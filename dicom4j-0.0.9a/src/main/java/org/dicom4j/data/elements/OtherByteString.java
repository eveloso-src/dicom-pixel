/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.data.elements;

import java.io.IOException;

import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Other Byte (OB) {@link DataElement DataElement}
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class OtherByteString extends DataElement {

	private static Logger fLogger = LoggerFactory
	.getLogger(OtherByteString.class);

	private byte[] fValue;

	/**
	 * <p>
	 * Creates an empty element
	 * </p>
	 * 
	 * @param aTag
	 *          the tag of the element
	 */
	public OtherByteString(DicomTag aTag) {
		super(aTag);
	}

	@Override
	public void clear() {
		this.fValue = new byte[0];
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public byte[] getByteValues() throws DicomException {
		return this.fValue;
	}

	/***/
	@Override
	public long getPaddedVL() {
		long vl = this.getValueLength();
		if (vl % 2 != 0) {
			++vl;
		}
		return vl;
	}

	@Override
	public int getValueMultiplicity() {
		return 1; // always 1 for this VR
	}

	/**
	 * Return the value representation of this element
	 * 
	 * @return the value representation (OB)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.OtherByteString;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (OB).
	 * </p>
	 * 
	 * @return 'O','B' in ASCII as a two byte array; see
	 */
	public byte[] getVR() {
		return ValueRepresentation.OB;
	}

	@Override
	public boolean isAvailableAsString() {
		return false;
	}

	/**
	 * @param vl
	 * @param i
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException {
		fLogger.debug("read (length: " + aLength + " ) ");
		this.doCommonRead(aStream, aLength, aCharacterSet);
		this.fValue = null;
		if (this.fValueLength > 0) {
			// TODO the cast is source of BUGS
			// read data into a stream not a array
			try {
				// TreeMap lmp;

				/*
				 * fLogger.info("1"); ByteArrayOutputStream lOutStream = new
				 * ByteArrayOutputStream( (int)aLength ); CopyUtils.copy(aStream,
				 * lOutStream); fLogger.info("2");
				 */
				byte[] buffer = new byte[(int) aLength];
				aStream.readInsistently(buffer, 0, (int) aLength);
				this.setValues(buffer);
			} catch (Throwable e) {
				fLogger.warn(e.getMessage());
				throw new DicomException("Failed to read value (length " + aLength
						+ ") in " + ValueRepresentation.getAsString(this.getVR())
						+ " attribute " + this.getTag());
			}
		}
		fLogger.debug("read completed");
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void setValues(byte[] v) throws DicomException {
		this.fValue = v;
		this.fValueMultiplicity = 1; // different from normal value types where VM
		// is
		// size of array
		this.fValueLength = v.length;
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" []"); // i.e. don't really dump values ... too many
		return str.toString();
	}

	/**
	 * @param o
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void write(DicomOutputStream o) throws DicomException, IOException {
		// try {

		this.writeBase(o);
		if ((this.fValue != null) && (this.fValue.length > 0)) {
			o.write(this.fValue);
			if (this.getValueLength() != this.fValue.length) {
				throw new DicomException("Internal error - byte array length ("
						+ this.fValue.length + ") not equal to expected VL("
						+ this.getValueLength() + ")");
			}
			long npad = this.getPaddedVL() - this.fValue.length;
			while (npad-- > 0) {
				o.write(0x00);
			}
		}

		/*
		 * } catch (DicomException e) { fLogger.error("DicomException: " +
		 * e.getMessage()); throw e; } catch (IOException e2) {
		 * fLogger.error("IOException: " + e2.getMessage()); throw e2; }
		 */

	}

}
