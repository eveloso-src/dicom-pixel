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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.DataElementException;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class specializing {@link DataElement } for string element.
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public abstract class StringElement extends DataElement {

	/**
	 * the logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(StringElement.class);

	/**
	 * to manage specifics charsets
	 */
	private SpecificCharacterSet specificCharacterSet;

	/**
	 * the stored values
	 */
	private List<String> values;

	/**
	 * <p>
	 * Construct an (empty) attribute; called only by concrete sub-classes.
	 * </p>
	 * 
	 * @param tag
	 *          the tag of the attribute
	 */
	protected StringElement(DicomTag tag) {
		super(tag);
		this.values = new ArrayList<String>();
		this.doCommonConstructorStuff(null);
	}

	/**
	 * <p>
	 * Read an attribute from an input stream; called only by concrete
	 * sub-classes.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 * @param vl
	 *          the value length of the attribute
	 * @param i
	 *          the input stream
	 * @exception IOException
	 * @exception DicomException
	 */
	protected StringElement(DicomTag t, long vl, DicomInputStream i) throws IOException, DicomException {
		super(t);
		this.read(i, vl, null);
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
	protected StringElement(DicomTag t, SpecificCharacterSet specificCharacterSet) {
		super(t);
		this.doCommonConstructorStuff(null);
	}

	/**
	 * add a value
	 * @param value
	 * @exception DicomException
	 */
	@Override
	public void addValue(String value) {
		if ( value == null ){
			logger.warn("null value provided, we set blank a string");
			this.values.add("");
		} else {
			this.values.add(value);
		}
		/*
		 * flushCachedCopies();
		 * originalValues=ArrayCopyUtilities.expandArray(originalValues);
		 * fValueLength+=v.length(); if (fValueMultiplicity > 0) ++fValueLength; //
		 * for the delimiter originalValues[fValueMultiplicity++]=v;
		 */

		// = ArrayCopyUtilities.expandArray(fValues);
		// fValues[getValueMultiplicity() - 1] = v;
		// ArrayUtils.add(fValues, v);
	}

	@Override
	public void clear() {
		this.values.clear();
	}

	private void doCommonConstructorStuff( SpecificCharacterSet specificCharacterSet) {
		this.specificCharacterSet = specificCharacterSet;
		this.clear();
	}

	@Override
	public String getDelimitedStringValues() {
		StringBuffer buffer = new StringBuffer();
		// we add value separator (ie: "\" )
		for (int j = 0; j < this.values.size(); ++j) {
			if (j > 0) {
				buffer.append("\\");
			}
			buffer.append( this.values.get(j) );
		}
		return buffer.toString();//  this.getDelimitedStringValues("");
	}

	/**
	 * <p>
	 * Get the appropriate byte for padding a string to an even length.
	 * </p>
	 * <p>
	 * by default return 0x20 (space, the common padding byte)
	 * 
	 * @return the byte pad value appropriate to the VR
	 */
	protected byte getPadByte() {
		return 0x20;
	}

	/**
	 * @exception DicomException
	 */
	private byte[] getPaddedByteValues() throws DicomException, DataElementException {
		StringBuffer buffer = new StringBuffer();
		// we add value separator (ie: "\" )
		for (int j = 0; j < this.values.size(); ++j) {
			if (j > 0) {
				buffer.append("\\");
			}
			buffer.append( this.values.get(j) );
		}
		byte[] b = null;
		try {
			b = this.translateStringToByteArray(buffer.toString());
		} catch (UnsupportedEncodingException e) {
			throw new DataElementException("Unsupported encoding:" + e);
		}
		// should padding take into account character set, i.e. could the pad
		// character be different ? :(
		ByteArrayOutputStream resultValue = new ByteArrayOutputStream( b.length );
		resultValue.write( b , 0 , b.length );
		if ( resultValue.toByteArray().length % 2 != 0) {
			// we must pad the value
			//byte[] b2 = new byte[bl + 1];
			//System.arraycopy(b, 0, b2, 0, bl);
			//b2[bl] = this.getPadByte();
			//b = b2;
			resultValue.write( this.getPadByte() );
		}

		/*if (b != null) {
			int bl = b.length;
			if (bl % 2 != 0) {
				byte[] b2 = new byte[bl + 1];
				System.arraycopy(b, 0, b2, 0, bl);
				b2[bl] = this.getPadByte();
				b = b2;
			}
			if (this.getPaddedVL() != b.length) {
				logger.error("getPaddedByteValues (tag=" + this.getTag() + "): " + this.getStringValues());
				throw new DataElementException("Internal error - " + this + " - byte array length (" + b.length + ") not equal to expected padded VL(" + this.getPaddedVL() + ")");
			}
		}*/
		if (this.getPaddedVL() != resultValue.toByteArray().length ) {
			String errorMsg =  this + " - byte array length (" + resultValue.toByteArray().length + ") not equal to expected padded VL(" + this.getPaddedVL() +")";
			logger.error("getPaddedByteValues : " + errorMsg ); // (tag=" + this.getTag() + "): " + this.getStringValues() );
			throw new DataElementException("Internal error - " + this + " - byte array length (" + resultValue.toByteArray().length + ") not equal to expected padded VL(" + this.getPaddedVL() + ")");
		}
		return resultValue.toByteArray(); // b;
	}

	/**
	 * @exception DicomException
	 */
	/*private byte[] getPaddedByteValues() throws DicomException, DataElementException {
		StringBuffer sb = new StringBuffer();
		String[] v = this.getStringValues();
		if (v != null) {
			for (int j = 0; j < v.length; ++j) {
				if (j > 0) {
					sb.append("\\");
				}
				sb.append(v[j]);
			}
		}
		byte[] b = null;
		try {
			b = this.translateStringToByteArray(sb.toString());
		} catch (UnsupportedEncodingException e) {
			throw new DataElementException("Unsupported encoding:" + e);
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
				logger.error("getPaddedByteValues (tag=" + this.getTag() + "): " + this.getStringValues());
				throw new DataElementException("Internal error - " + this + " - byte array length (" + b.length + ") not equal to expected padded VL(" + this.getPaddedVL() + ")");
			}
		}
		return b;
	}*/

	@Override
	public long getPaddedVL() {
		long vl = this.getValueLength();
		if (vl % 2 != 0) {
			++vl;
		}
		return vl;
	}

	/**
	 * <p>
	 * Get the values of this attribute as strings.
	 * </p>
	 * 
	 * <p>
	 * The strings are first cleaned up into a canonical form, to remove leading
	 * and trailing padding.
	 * </p>
	 * 
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return the values as an array of {@link java.lang.String String}
	 * @exception DicomException
	 *              not thrown
	 */
	@Override
	public String[] getStringValues(NumberFormat format) throws DicomException {
		String[] larray = new String[this.values.size()];
		for (int i = 0; i < larray.length; i++) {
			larray[i] = this.values.get(i);
		}
		return larray; // fValues.toArray();
	}

	@Override
	public long getValueLength() {
		return this.getDelimitedStringValues().length();
	}

	@Override
	public int getValueMultiplicity() {
		return this.values.size();
	}

	/**
	 * <p>
	 * Read a constructed attribute from an input stream; called only by concrete
	 * sub-classes.
	 * </p>
	 * 
	 * @param length
	 *          the value length of the attribute
	 * @param i
	 *          the input stream
	 * @param characterSet
	 *          the character set to be used for the text
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void read(DicomInputStream stream, long length, SpecificCharacterSet characterSet) throws IOException, DicomException {
		this.doCommonConstructorStuff(this.specificCharacterSet);
		if (characterSet == null) {
			logger.debug("read (length: " + length + ", no SpecificCharacterSet" + ")");
		} else {
			logger.debug("read (length: " + length + ", SpecificCharacterSet: " + characterSet.toString() + ")");
		}
		// originalValues=null;
		if (length > 0) {
			byte[] buffer = new byte[(int) length];
			try {
				stream.readInsistently(buffer, 0, (int) length);
			} catch (IOException e) {
				throw new DicomException("Failed to read value (length " + length + " dec) in " + this.getValueRepresentation().toString() + " attribute " + this.getTag());
			}
			String sbuf = this.translateByteArrayToString(buffer, 0, (int) length);
			length = sbuf.length(); // NB. this only makes a difference for multi-byte character sets
			int start = 0;
			int delim = 0;
			while (true) {
				if ((delim >= length) || (sbuf.charAt(delim) == '\\')) {
					this.addValue(sbuf.substring(start, delim));
					++delim;
					start = delim;
					if (delim >= length) {
						break;
					}
				} else {
					++delim;
				}
			}
		}
	}

	/**
	 * set the element's value (all previous added value will be erased)
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.clear();
		this.addValue(value);
	}

	/***/
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" <");
		try {
			String[] v = this.getStringValues();
			if (v != null) {
				for (int j = 0; j < v.length; ++j) {
					if (j > 0) {
						str.append("\\");
					}
					str.append(v[j]);
				}
			}
		} catch (DicomException e) {
			str.append("XXXX");
		}
		str.append(">");
		return str.toString();
	}

	/**
	 * Decode a byte array into a string.
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
	protected String translateByteArrayToString(byte[] bytes, int offset, int length) {
		if (this.specificCharacterSet == null) {
			return new String(bytes, 0, length);
		} else {
			return this.specificCharacterSet.translateByteArrayToString(bytes, 0, length);
		}
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
	protected byte[] translateStringToByteArray(String string) throws UnsupportedEncodingException {
		if ( this.specificCharacterSet == null ) {
			return string.getBytes();
		} else {
			return this.specificCharacterSet.translateStringToByteArray(string );
		}
		//return this.specificCharacterSet == null ? string.getBytes()
		//	: this.specificCharacterSet.translateStringToByteArray(string);
	}

	/**
	 * <p>
	 * Get the values of this attribute as strings, the way they were originally
	 * inserted or read.
	 * </p>
	 * 
	 * @return the values as an array of {@link java.lang.String String}
	 * @exception DicomException
	 *              not thrown
	 */
	/*
	 * public String[] getOriginalStringValues() throws DicomException { return
	 * originalValues; }
	 */

	/**
	 * @exception DicomException
	 */
	/*
	 * public int[] getIntegerValues() throws DicomException { if
	 * (cachedIntegerCopy == null)
	 * cachedIntegerCopy=ArrayCopyUtilities.copyStringToIntArray
	 * (getStringValues()); // must be unpadded return cachedIntegerCopy; }
	 */

	/**
	 * @exception DicomException
	 */
	/*
	 * public long[] getLongValues() throws DicomException { if (cachedLongCopy ==
	 * null)
	 * cachedLongCopy=ArrayCopyUtilities.copyStringToLongArray(getStringValues());
	 * // must be unpadded return cachedLongCopy; }
	 */

	/**
	 * @exception DicomException
	 */
	/*
	 * public float[] getFloatValues() throws DicomException { if (cachedFloatCopy
	 * == null)
	 * cachedFloatCopy=ArrayCopyUtilities.copyStringToFloatArray(getStringValues
	 * ()); // must be unpadded return cachedFloatCopy; }
	 */

	/**
	 * @exception DicomException
	 */
	/*
	 * public double[] getDoubleValues() throws DicomException { if
	 * (cachedDoubleCopy == null)
	 * cachedDoubleCopy=ArrayCopyUtilities.copyStringToDoubleArray
	 * (getStringValues()); // must be unpadded return cachedDoubleCopy; }
	 */

	/**
	 * @param outputStream
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void write(DicomOutputStream outputStream) throws DicomException, IOException {
		this.writeBase(outputStream);
		byte b[] = this.getPaddedByteValues();
		// fLogger.debug("bytes:\n" + HexDump.dump(b) );
		outputStream.write(b);
	}

}
