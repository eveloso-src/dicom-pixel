/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.DicomTags;

/**
 * <p>
 * A class that extends {@link java.io.InputStream InputStream} by adding a
 * mechanism for unecapsulating an undefined length DICOM attribute, such as is
 * used for compressed Pixel Data.
 * </p>
 * 
 * <p>
 * The read methods hide the fact that the data is encapsulated by removing the
 * Items and Item and Sequence delimiter tags, as well as skipping any Basic
 * Offset Table that may be present in the first Item.
 * </p>
 * 
 * <p>
 * A {@link #nextFrame nextFrame()} method is provided to skip any padding at
 * the end of a fragment, if any, and position the stream at the begin of the
 * next fragment, since frame data is not permitted to span fragments, but an
 * individual frame may be fragmented.
 * </p>
 * 
 * @author dclunie
 */
public class EncapsulatedInputStream extends InputStream {

	/***/
	private static final String identString = "@(#) $Header: /userland/cvs/pixelmed/imgbook/com/pixelmed/dicom/EncapsulatedInputStream.java,v 1.5 2004/08/09 11:46:07 dclunie Exp $";

	/***/
	boolean bigEndian;

	/***/
	byte buffer[]; // just for read() one byte method

	/***/
	boolean firstTime;

	/***/
	byte fragment[];

	/***/
	int fragmentOffset;

	/***/
	int fragmentRemaining;

	/***/
	int fragmentSize;

	/***/
	BinaryInputStream i;

	/***/
	boolean sequenceDelimiterEncountered;

	/**
	 * <p>
	 * Construct a byte ordered stream from the supplied stream.
	 * </p>
	 * 
	 * <p>
	 * The byte order may be changed later.
	 * </p>
	 * 
	 * @param i
	 *          the input stream to read from
	 */
	public EncapsulatedInputStream(BinaryInputStream i) {
		this.i = i;
		this.bigEndian = i.getByteOrder() == ByteOrder.BIG_ENDIAN;
		this.buffer = new byte[8];
		this.fragment = null;
		this.firstTime = true;
		this.sequenceDelimiterEncountered = false;
	}

	/**
	 * <p>
	 * Skip to the start of a fragment, if not already there.
	 * </p>
	 */
	public void nextFrame() {
		System.err.println("EncapsulatedInputStream.nextFrame()");
		// flush to start of next fragment unless already positioned at start of
		// next fragment
		if ((this.fragment != null) && (this.fragmentOffset != 0)) {
			System.err
			.println("EncapsulatedInputStream.nextFrame(): fragment was not already null");
			this.fragment = null;
		}
	}

	// private void readItemDelimiter() throws IOException {
	// AttributeTag tag = readAttributeTag();
	// System.err.println("EncapsulatedInputStream.readItemDelimiter: tag="+tag);
	// i.readUnsigned32(); // always implicit VR form for items and delimiters
	// if (!tag.equals(TagFromName.ItemDelimitationItem)) {
	// throw new
	// IOException("Expected DICOM Item Delimitation Item tag in encapsulated data");
	// }
	// }

	// private void readSequenceDelimiter() throws IOException {
	// AttributeTag tag = readAttributeTag();
	// System.err.println("EncapsulatedInputStream.readSequenceDelimiter: tag="+tag);
	// i.readUnsigned32(); // always implicit VR form for items and delimiters
	// if (!tag.equals(TagFromName.SequenceDelimitationItem)) {
	// throw new
	// IOException("Expected DICOM Sequence Delimitation Item tag in encapsulated data");
	// }
	// }

	/**
	 * <p>
	 * Extracts the next byte of data from the current or subsequent fragments.
	 * </p>
	 * 
	 * @return the next byte of data, or -1 if there is no more data because the
	 *         end of the stream has been reached.
	 * @exception IOException
	 *              if an I/O error occurs.
	 */
	@Override
	public final int read() throws IOException {
		int count = this.read(this.buffer, 0, 1);
		return count == -1 ? -1 : (this.buffer[0] & 0xff); // do not sign extend
	}

	/**
	 * <p>
	 * Extracts <code>byte.length</code> bytes of data from the current or
	 * subsequent fragments.
	 * </p>
	 * <p>
	 * This method simply performs the call <code>read(b, 0, b.length)</code> and
	 * returns the result.
	 * </p>
	 * 
	 * @param b
	 *          the buffer into which the data is read.
	 * @return the total number of bytes read into the buffer (always whatever was
	 *         asked for), or -1 if there is no more data because the end of the
	 *         stream has been reached.
	 * @exception IOException
	 *              if an I/O error occurs.
	 * @see #read(byte[], int, int)
	 */
	@Override
	public final int read(byte b[]) throws IOException {
		return this.read(b, 0, b.length);
	}

	// Our own specific methods a la BinaryInputStream ...

	/**
	 * <p>
	 * Extracts <code>len</code> bytes of data from the current or subsequent
	 * fragments.
	 * </p>
	 * 
	 * @param b
	 *          the buffer into which the data is read.
	 * @param off
	 *          the start offset of the data.
	 * @param len
	 *          the number of bytes read.
	 * @return the total number of bytes read into the buffer (always whatever was
	 *         asked for), or -1 if there is no more data because the end of the
	 *         stream has been reached.
	 * @exception IOException
	 *              if an I/O error occurs.
	 */
	@Override
	public final int read(byte b[], int off, int len) throws IOException {
		// System.err.println("EncapsulatedInputStream.read(byte [],"+off+","+len+")");
		int count = 0;
		int remainingToDo = len;
		while ((remainingToDo > 0) && !this.sequenceDelimiterEncountered) {
			// System.err.println("EncapsulatedInputStream.read() remainingToDo="+remainingToDo);
			if (this.fragment == null) {
				if (this.firstTime) {
					// System.err.println("EncapsulatedInputStream.read() firstTime");
					// first time ... skip offset table ...
					long offsetTableLength = this.readItemTag();
					if (this.sequenceDelimiterEncountered) {
						throw new IOException(
						"Expected offset table item tag; got sequence delimiter");
					}
					this.i.skip(offsetTableLength);
					this.firstTime = false;
				}
				// load a new fragment ...
				long vl = this.readItemTag(); // if sequenceDelimiterEncountered, vl
				// will be zero and no more will be done
				if (vl != 0) {
					this.fragmentRemaining = this.fragmentSize = (int) vl;
					this.fragment = new byte[this.fragmentSize];
					this.i.readInsistently(this.fragment, 0, this.fragmentSize);
					this.fragmentOffset = 0;
				}
			}
			int amountToCopyFromThisFragment = remainingToDo < this.fragmentRemaining ? remainingToDo
					: this.fragmentRemaining;
			// System.err.println("EncapsulatedInputStream.read() amountToCopyFromThisFragment="+amountToCopyFromThisFragment);
			if (amountToCopyFromThisFragment > 0) {
				System.arraycopy(this.fragment, this.fragmentOffset, b, off,
						amountToCopyFromThisFragment);
				off += amountToCopyFromThisFragment;
				this.fragmentOffset += amountToCopyFromThisFragment;
				this.fragmentRemaining -= amountToCopyFromThisFragment;
				remainingToDo -= amountToCopyFromThisFragment;
				count += amountToCopyFromThisFragment;
			}
			if (this.fragmentRemaining <= 0) {
				this.fragment = null;
			}
		}
		return count == 0 ? -1 : count; // always returns more than 0 unless end,
		// which is signalled by -1
	}

	// Override the necessary methods from InputStream ...

	/**
	 * @param i
	 * @exception IOException
	 */
	private DicomTag readAttributeTag() throws IOException {
		int group = this.i.readUnsigned16();
		int element = this.i.readUnsigned16();
		return new DicomTag(group, element);
	}

	private long readItemTag() throws IOException {
		DicomTag tag = this.readAttributeTag();
		System.err.println("EncapsulatedInputStream.readItemTag: tag=" + tag);
		long vl = this.i.readUnsigned32(); // always implicit VR form for items and
		// delimiters
		if (tag.equals(DicomTags.SeqDelimitationItem)) {
			System.err
			.println("EncapsulatedInputStream.readItemTag: SequenceDelimitationItem");
			vl = 0; // regardless of what was read
			this.sequenceDelimiterEncountered = true;
		} else if (!tag.equals(DicomTags.Item)) {
			throw new IOException("Expected DICOM Item tag in encapsulated data");
		}
		return vl;
	}

	/**
	 * <p>
	 * Read an array of unsigned integer 16 bit values.
	 * </p>
	 * 
	 * @param w
	 *          an array of sufficient size in which to return the values read
	 * @param offset
	 *          the offset in the array at which to begin storing values
	 * @param len
	 *          the number of 16 bit values to read
	 * @exception IOException
	 */
	public final void readUnsigned16(short[] w, int offset, int len)
	throws IOException {
		int blen = len * 2;
		byte b[] = new byte[blen];
		this.read(b, 0, blen); // read the bytes from the fragment(s)
		int bcount = 0;
		int wcount = 0;
		if (this.bigEndian) {
			for (; wcount < len; ++wcount) {
				w[offset + wcount] = (short) ((b[bcount++] << 8) + (b[bcount++] & 0xff)); // assumes
				// left
				// to
				// right
				// evaluation
			}
		} else {
			for (; wcount < len; ++wcount) {
				w[offset + wcount] = (short) ((b[bcount++] & 0xff) + (b[bcount++] << 8)); // assumes
				// left
				// to
				// right
				// evaluation
			}
		}
	}
}
