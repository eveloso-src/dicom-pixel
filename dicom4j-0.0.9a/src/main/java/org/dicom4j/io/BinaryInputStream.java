/*
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 *
 */

package org.dicom4j.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Extends {@link java.io.FilterInputStream FilterInputStream} by adding the
 * concept of little and big endian binary value encoding.
 * 
 * 
 * @see org.dicom4j.io.BinaryOutputStream
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class BinaryInputStream extends FilterInputStream {

	/**
	 * logger
	 */
	private static Logger logger = LoggerFactory.getLogger(BinaryInputStream.class);

	/**
	 * inner buffer
	 */
	private byte buffer[];

	/**
	 * The {@link ByteOrder ByteOrder} of the stream
	 */
	private ByteOrder byteOrder;

	/**
	 * <p>
	 * Construct a new stream from the supplied stream (byte order:
	 * LITTLE_ENDIAN).
	 * </p>
	 * 
	 * @param aInput
	 *          the input stream to read from
	 */
	public BinaryInputStream(InputStream aInput) {
		this(aInput, ByteOrder.LITTLE_ENDIAN);
	}

	/**
	 * <p>
	 * Construct a new stream from the supplied stream.
	 * </p>
	 * 
	 * @param aInput
	 *          the input stream to read from
	 * @param aByteOrder
	 *          the byte order
	 */
	public BinaryInputStream(InputStream i, ByteOrder aByteOrder) {
		super(i);
		this.setByteOrder(aByteOrder);
		this.buffer = new byte[8];
	}

	/***/
	final short extractSigned16() {
		short v1 = (short) (this.buffer[0] & 0xff);
		short v2 = (short) (this.buffer[1] & 0xff);
		return (short) (this.getByteOrder() == ByteOrder.BIG_ENDIAN ? v1 << 8 | v2
				: v2 << 8 | v1);
	}

	/***/
	final int extractSigned32() {
		int v1 = this.buffer[0] & 0xff;
		int v2 = this.buffer[1] & 0xff;
		int v3 = this.buffer[2] & 0xff;
		int v4 = this.buffer[3] & 0xff;
		return this.getByteOrder() == ByteOrder.BIG_ENDIAN ? ((v1 << 8 | v2) << 8 | v3) << 8
				| v4
				: ((v4 << 8 | v3) << 8 | v2) << 8 | v1;
	}

	/***/
	final int extractUnsigned16() {
		int v1 = this.buffer[0] & 0xff;
		int v2 = this.buffer[1] & 0xff;
		return this.getByteOrder() == ByteOrder.BIG_ENDIAN ? v1 << 8 | v2 : v2 << 8
				| v1;
	}

	/***/
	final long extractUnsigned32() {
		long v1 = (long) this.buffer[0] & 0xff;
		long v2 = (long) this.buffer[1] & 0xff;
		long v3 = (long) this.buffer[2] & 0xff;
		long v4 = (long) this.buffer[3] & 0xff;
		return this.getByteOrder() == ByteOrder.BIG_ENDIAN ? ((v1 << 8 | v2) << 8 | v3) << 8
				| v4
				: ((v4 << 8 | v3) << 8 | v2) << 8 | v1;
	}

	/***/
	final long extractUnsigned64() {
		long v1 = (long) this.buffer[0] & 0xff;
		long v2 = (long) this.buffer[1] & 0xff;
		long v3 = (long) this.buffer[2] & 0xff;
		long v4 = (long) this.buffer[3] & 0xff;
		long v5 = (long) this.buffer[4] & 0xff;
		long v6 = (long) this.buffer[5] & 0xff;
		long v7 = (long) this.buffer[6] & 0xff;
		long v8 = (long) this.buffer[7] & 0xff;
		return this.getByteOrder() == ByteOrder.BIG_ENDIAN ? ((((((v1 << 8 | v2) << 8 | v3) << 8 | v4) << 8 | v5) << 8 | v6) << 8 | v7) << 8
				| v8
				: ((((((v8 << 8 | v7) << 8 | v6) << 8 | v5) << 8 | v4) << 8 | v3) << 8 | v2) << 8
				| v1;
	}

	/***/
	final int extractUnsigned8() {
		return this.buffer[0] & 0xff;
	}

	public ByteOrder getByteOrder() {
		return this.byteOrder;
	}

	@Override
	public int read(byte[] aBytes) throws IOException {
		int lLength = aBytes.length;
		int lreaded = this.in.read(aBytes);
		while (lreaded != lLength) {
			logger.warn("the read method need a loop to read all data");
			lreaded = lreaded + this.in.read(aBytes, lreaded, lLength - lreaded);
		}
		return lreaded;
	}

	/**
	 * Read string coded in ACSII
	 * 
	 * @param aLength
	 *          length to read
	 * @return the string readed
	 * @throws IOException
	 *           if error occurs
	 */
	public String readASCII(int aLength) throws IOException {
		return this.readString(aLength, "ASCII");
	}

	/**
	 * Reads one byte and returns true if that byte is nonzero, false if that byte
	 * is zero.
	 * 
	 * @return the boolean value readed.
	 * @throws IOException
	 */
	public boolean readBoolean() throws IOException {
		return this.read() != 0;
	}

	/**
	 * Read one byte
	 * 
	 * @return the readed byte
	 */
	public byte readByte() throws IOException {
		return (byte) this.in.read();
	}

	/**
	 * <p>
	 * Read interleaved complex floating point 64 bit value pairs into real and
	 * imaginary arrays.
	 * </p>
	 * 
	 * @param freal
	 *          an array of sufficient size in which to return the real values
	 *          read, may be null if don't want real values
	 * @param fimaginary
	 *          an array of sufficient size in which to return the real values
	 *          read, may be null if don't want imaginary values
	 * @param len
	 *          the number of 64 bit values to read
	 * @exception IOException
	 */
	public final void readComplexDouble(double[] freal, double[] fimaginary,
			int len) throws IOException {
		for (int i = 0; i < len; ++i) {
			double vreal = this.readDouble();
			double vimaginary = this.readDouble();
			if (freal != null) {
				freal[i] = vreal;
			}
			if (fimaginary != null) {
				fimaginary[i] = vimaginary;
			}
		}
	}

	/**
	 * <p>
	 * Read interleaved complex floating point 32 bit value pairs into real and
	 * imaginary arrays.
	 * </p>
	 * 
	 * @param freal
	 *          an array of sufficient size in which to return the real values
	 *          read, may be null if don't want real values
	 * @param fimaginary
	 *          an array of sufficient size in which to return the real values
	 *          read, may be null if don't want imaginary values
	 * @param len
	 *          the number of 32 bit values to read
	 * @exception IOException
	 */
	public final void readComplexFloat(float[] freal, float[] fimaginary, int len)
	throws IOException {
		for (int i = 0; i < len; ++i) {
			float vreal = this.readFloat();
			float vimaginary = this.readFloat();
			if (freal != null) {
				freal[i] = vreal;
			}
			if (fimaginary != null) {
				fimaginary[i] = vimaginary;
			}
		}
	}

	/**
	 * <p>
	 * Read one floating point 64 bit value.
	 * </p>
	 * 
	 * @return a double value
	 * @exception IOException
	 */
	public final double readDouble() throws IOException {
		this.readInsistently(this.buffer, 0, 8);
		long binary = this.extractUnsigned64();
		return Double.longBitsToDouble(binary);
	}

	/**
	 * <p>
	 * Read an array of floating point 64 bit values.
	 * </p>
	 * 
	 * @param f
	 *          an array of sufficient size in which to return the values read
	 * @param len
	 *          the number of 64 bit values to read
	 * @exception IOException
	 */
	public final void readDouble(double[] f, int len) throws IOException {
		for (int i = 0; i < len; ++i) {
			f[i] = this.readDouble();
		}
	}

	/**
	 * <p>
	 * Read one floating point 32 bit value.
	 * </p>
	 * 
	 * @return a float value
	 * @exception IOException
	 */
	public final float readFloat() throws IOException {
		this.readInsistently(this.buffer, 0, 4);
		int binary = (int) this.extractUnsigned32();
		return Float.intBitsToFloat(binary);
	}

	/**
	 * <p>
	 * Read an array of floating point 32 bit values.
	 * </p>
	 * 
	 * @param f
	 *          an array of sufficient size in which to return the values read
	 * @param len
	 *          the number of 32 bit values to read
	 * @exception IOException
	 */
	public final void readFloat(float[] f, int len) throws IOException {
		for (int i = 0; i < len; ++i) {
			f[i] = this.readFloat();
		}
	}

	public int readFully(byte[] arg0) throws IOException {
		return this.in.read(arg0);
	}

	public int readFully(byte[] arg0, int arg1, int arg2) throws IOException {
		return this.in.read(arg0, arg1, arg2);
	}

	/**
	 * <p>
	 * Read as many bytes as requested, unless an exception occurs.
	 * </p>
	 * 
	 * @param b
	 *          buffer to read into
	 * @param offset
	 *          offset (from 0) in buffer to read into
	 * @param length
	 *          number of bytes to read (no more and no less)
	 * @exception IOException
	 */
	public void readInsistently(byte[] b, int offset, int length)
	throws IOException {
		int remaining = length;
		while (remaining > 0) {
			int bytesReceived = this.in.read(b, offset, remaining);
			if (bytesReceived == -1) {
				throw new IOException("read failed with " + remaining
						+ " bytes remaining to be read, wanted " + length);
			}
			remaining -= bytesReceived;
			offset += bytesReceived;
		}
	}

	/**
	 * <p>
	 * Read one signed integer 16 bit value.
	 * </p>
	 * 
	 * @return an int containing an unsigned value
	 * @exception IOException
	 */
	public final int readSigned16() throws IOException {
		this.readInsistently(this.buffer, 0, 2);
		return this.extractSigned16();

	}

	/**
	 * <p>
	 * Read one signed integer 32 bit value.
	 * </p>
	 * 
	 * @return an int containing an signed value
	 * @exception IOException
	 */
	public final int readSigned32() throws IOException {
		this.readInsistently(this.buffer, 0, 4);
		return this.extractSigned32();
	}

	/**
	 * read string coded in a specific charset
	 * 
	 * @param length
	 *          length to read
	 * @param charsetName
	 *          the charset to use
	 * @return the string readed
	 * @throws IOException
	 *           if error occurs
	 */
	public String readString(int length, String charsetName) throws IOException {
		byte[] lbytes = new byte[length];
		int readedlength = this.read(lbytes);
		if ( readedlength != length )
			throw new IOException("readString: must read " +length + "but only " + readedlength + " read");
		return new String(lbytes, charsetName);
	}

	/**
	 * <p>
	 * Read one unsigned integer 16 bit value.
	 * </p>
	 * 
	 * @return an int containing an unsigned value
	 * @exception IOException
	 */
	public final int readUnsigned16() throws IOException {
		this.readInsistently(this.buffer, 0, 2);
		return this.extractUnsigned16();

	}

	/**
	 * <p>
	 * Read an array of unsigned integer 16 bit values.
	 * </p>
	 * 
	 * @param w
	 *          an array of sufficient size in which to return the values read
	 * @param len
	 *          the number of 16 bit values to read
	 * @exception IOException
	 */
	public final void readUnsigned16(short[] w, int len) throws IOException {
		this.readUnsigned16(w, 0, len);
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
		this.readInsistently(b, 0, blen);
		int bcount = 0;
		int wcount = 0;
		if (this.getByteOrder() == ByteOrder.BIG_ENDIAN) {
			while (wcount < len) {
				int highByte = b[bcount++] & 0xff;
				int lowByte = b[bcount++] & 0xff;
				short value = (short) ((highByte << 8) + lowByte);
				w[offset + wcount++] = value;
			}
		} else {
			// while (wcount<len) {
			for (; wcount < len; ++wcount) {
				// int lowByte=((int)b[bcount++])&0xff;
				// int highByte=((int)b[bcount++])&0xff;
				// short value=(short)((highByte<<8) + lowByte);
				// w[wcount++]=(short)value;
				// w[wcount++]=(short)((b[bcount+1]<<8) + (b[bcount]&0xff));
				// w[wcount++]=(short)((b[bcount++]&0xff) + (b[bcount++]<<8)); //
				// assumes left to right evaluation
				w[offset + wcount] = (short) ((b[bcount++] & 0xff) + (b[bcount++] << 8)); // assumes
				// left
				// to
				// right
				// evaluation
				// bcount++; bcount++;
				// bcount+=2;
			}
		}
	}

	/**
	 * <p>
	 * Read one unsigned integer 32 bit value.
	 * </p>
	 * 
	 * @return a long containing an unsigned value
	 * @exception IOException
	 */
	public final long readUnsigned32() throws IOException {
		this.readInsistently(this.buffer, 0, 4);
		return this.extractUnsigned32();
	}

	/**
	 * <p>
	 * Read one unsigned integer 8 bit value.
	 * </p>
	 * 
	 * @return an int containing an unsigned value
	 * @exception IOException
	 */
	public final int readUnsigned8() throws IOException {
		this.readInsistently(this.buffer, 0, 1);
		return this.extractUnsigned8();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataInput#readUnsignedByte()
	 */
	public int readUnsignedByte() throws IOException {
		this.readInsistently(this.buffer, 0, 1);
		return this.extractUnsigned8();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.DataInput#readUnsignedShort()
	 */
	public int readUnsignedShort() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setByteOrder(ByteOrder aByteOrder) {
		this.byteOrder = aByteOrder;
	}

	/**
	 * Skips over and discards n bytes of data from the input stream. The skip
	 * method may, for a variety of reasons, end up skipping over some smaller
	 * number of bytes, possibly 0. The actual number of bytes skipped is
	 * returned.
	 * 
	 * @param aNumberToSkip
	 *          number of bytes to skip
	 * @return the actual number of bytes skipped.
	 */
	@Override
	public long skip(long aNumberToSkip) throws IOException {
		long lSkiped = super.skip(aNumberToSkip);
		if (lSkiped != aNumberToSkip) {
			logger.error("try to skip " + aNumberToSkip + " byte(s), " + lSkiped
					+ " realy skipped");
			throw new IOException("try to skip " + aNumberToSkip + " byte(s), "
					+ lSkiped + " realy skipped");
		}
		return lSkiped;
	}

}
