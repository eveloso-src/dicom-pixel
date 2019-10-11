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

package org.dicom4j.data.elements.support;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;

import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * An abstract class specializing
 * {@link org.dicom4j.data.elements.support.DataElement Attribute} for the
 * family of text attributes.
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public abstract class TextElement extends DataElement {

	/**
	 * the logger
	 */
	private static Logger fLogger = LoggerFactory.getLogger(TextElement.class);

	/**
	 * the element's value
	 */
	private String fValue = "";

	/**
	 * the values
	 */
	private String fValues[];

	/**
	 * the {@link SpecificCharacterSet}
	 */
	protected SpecificCharacterSet specificCharacterSet;

	/**
	 * <p>
	 * Construct an (empty) attribute; called only by concrete sub-classes.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 */
	protected TextElement(DicomTag t) {
		super(t);
		this.doCommonConstructorStuff(null);
	}

	/**
	 * <p>
	 * Construct an (empty) attribute; called only by concrete sub-classes.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 * @param specificCharacterSet
	 *          the character set to be used for the text
	 */
	protected TextElement(DicomTag t, SpecificCharacterSet specificCharacterSet) {
		super(t);
		this.doCommonConstructorStuff(specificCharacterSet);
	}

	/**
	 * @deprecated
	 * @param v
	 * @exception DicomException
	 */
	@Deprecated
	@Override
	public void addValue(String v) throws DicomException {
		if ((this.fValues != null) || (this.fValueMultiplicity > 0)) {
			throw new DicomException(
			"No more than one value allowed for text attributes");
		}
		this.fValues = new String[1];
		this.fValues[0] = v;
		this.fValueLength = v.length();
		++this.fValueMultiplicity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.data.elements.DataElement#clear()
	 */
	@Override
	public void clear() {
		this.fValue = "";
	}

	/**
	 * @param specificCharacterSet
	 */
	private void doCommonConstructorStuff(
			SpecificCharacterSet specificCharacterSet) {
		this.fValues = null;
		this.fValue = "";
		this.specificCharacterSet = specificCharacterSet;
	}

	/**
	 * <p>
	 * Get the appropriate byte for padding a string to an even length.
	 * </p>
	 * 
	 * @return the byte pad value appropriate to the VR
	 */
	private byte getPadByte() {
		return 0x20;
	}

	/**
	 * @exception DicomException
	 */
	private byte[] getPaddedByteValues() throws DicomException {
		String[] v = this.getStringValues();
		// byte[] b = v == null ? null : v[0].getBytes();
		byte[] b = null;
		try {
			if (v != null) {
				b = this.translateStringToByteArray(v[0]);
			}
		} catch (UnsupportedEncodingException e) {
			throw new DicomException("Unsupported encoding:" + e);
		}
		// should padding take into account character set, i.e. could the pad
		// character be different ? :(
		if (b != null) {
			int bl = b.length;
			if (bl % 2 != 0) {
				byte[] b2 = new byte[bl + 1];
				System.arraycopy(b, 0, b2, 0, bl);
				b2[bl] = this.getPadByte();
				b = b2;
			}
			if (this.getPaddedVL() != b.length) {
				throw new DicomException(
				"Internal error - byte array length not equal to expected padded VL");
			}
		}
		return b;
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

	/**
	 * @deprecated
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @exception DicomException
	 * 
	 */
	@Deprecated
	@Override
	public String[] getStringValues(NumberFormat format) throws DicomException {
		// ignore number format for generic text attributes
		return this.fValues;
	}

	public String getValue() {
		return this.fValue;
	}

	@Override
	public long getValueLength() {
		return this.fValue.length();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.data.elements.DataElement#getValueMultiplicity()
	 */
	@Override
	public int getValueMultiplicity() {
		if (this.fValue.length() == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.data.elements.DataElement#getValueRepresentation()
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param vl
	 * @param i
	 * @param specificCharacterSet
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException {
		this.doCommonConstructorStuff(this.specificCharacterSet);
		if (aLength > 0) {
			byte[] buffer = new byte[(int) aLength];
			try {
				aStream.readInsistently(buffer, 0, (int) aLength);
			} catch (IOException e) {
				throw new DicomException("Failed to read value (length " + aLength
						+ " dec) in " + this.getValueRepresentation().toString()
						+ " attribute " + this.getTag());
			}
			String sbuf = this.translateByteArrayToString(buffer, 0, (int) aLength);
			aLength = sbuf.length(); // NB. this only makes a difference for
			// multi-byte
			// character sets
			this.setValue(sbuf);
		}
		this.setValue("");
	}

	/**
	 * @deprecated use clear()
	 * @exception DicomException
	 */
	@Deprecated
	@Override
	public void removeValues() throws DicomException {
		this.fValueLength = 0;
		this.fValueMultiplicity = 0;
		this.fValues = null;
	}

	public void setValue(String aValue) {
		if (fLogger.isDebugEnabled()) {
			fLogger
			.debug("[" + this.getClass().getName() + "] - setValue: " + aValue);
		}
		this.fValue = aValue;
	}

	/***/
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" <");
		str.append(this.getValue());
		/*
		 * try { String[] v = getStringValues(); if (v != null) str.append(v[0]); }
		 * catch (DicomException e) { str.append("XXXX"); }
		 */
		str.append(">");
		return str.toString();
	}

	/**
	 * <p>
	 * Decode a byte array into a string.
	 * </p>
	 * 
	 * @param bytes
	 *          the byte buffer in which the encoded string is located
	 * @param offset
	 *          the offset into the buffer
	 * @param length
	 *          the number of bytes to be decoded
	 * @return the string decoded according to the specified or default specific
	 *         character set
	 */
	protected String translateByteArrayToString(byte[] bytes, int offset,
			int length) { // NOT
		// static
		return this.specificCharacterSet == null ? new String(bytes, 0, length)
		: this.specificCharacterSet
		.translateByteArrayToString(bytes, 0, length);
	}

	/**
	 * <p>
	 * Encode a string into a byte array.
	 * </p>
	 * 
	 * @param string
	 *          the string to be encoded
	 * @return the byte array encoded according to the specified or default
	 *         specific character set
	 * @exception UnsupportedEncodingException
	 */
	protected byte[] translateStringToByteArray(String string)
	throws UnsupportedEncodingException { // NOT
		// static
		return this.specificCharacterSet == null ? string.getBytes()
				: this.specificCharacterSet.translateStringToByteArray(string);
	}

	/**
	 * @param o
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void write(DicomOutputStream o) throws DicomException, IOException {
		try {
			this.writeBase(o);
			byte b[] = this.getPaddedByteValues();
			if ((b != null) && (b.length > 0)) {
				o.write(b);
			}
		} catch (DicomException e) {
			fLogger.error("DicomException: " + e.getMessage());
			throw e;
		} catch (IOException e2) {
			fLogger.error("IOException: " + e2.getMessage());
			throw e2;
		}
	}

}
