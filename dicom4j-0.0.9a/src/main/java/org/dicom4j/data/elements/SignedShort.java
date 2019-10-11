/* Copyright (c) 2001-2004, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.data.elements;

import java.io.IOException;
import java.text.NumberFormat;

import org.dicom4j.core.utils.ArrayCopyUtilities;
import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;

/**
 * <p>
 * A concrete class specializing
 * {@link org.dicom4j.data.elements.support.DataElement Attribute} for Signed
 * Short (SS) attributes.
 * </p>
 * 
 * <p>
 * Though an instance of this class may be created using its constructors, there
 * is also a factory class, {@link org.dicom4j.data.elements.DataElementFactory
 * AttributeFactory}.
 * </p>
 * 
 * @see org.dicom4j.data.elements.support.DataElement
 * @see org.dicom4j.data.elements.DataElementFactory
 * 
 * @author dclunie
 */
public class SignedShort extends DataElement {

	static int bytesPerValue = 2;

	private static final String identString = "@(#) $Header: /userland/cvs/pixelmed/imgbook/com/pixelmed/dicom/SignedShortAttribute.java,v 1.12 2005/01/02 21:16:44 dclunie Exp $";

	int[] cachedIntegerCopy;

	long[] cachedLongCopy;

	short[] values;

	/**
	 * <p>
	 * Construct an (empty) attribute.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 */
	public SignedShort(DicomTag t) {
		super(t);
		this.flushCachedCopies();
		this.values = null;
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void addValue(int v) throws DicomException {
		this.flushCachedCopies();
		this.addValue((short) v);
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void addValue(long v) throws DicomException {
		this.flushCachedCopies();
		this.addValue((short) v);
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void addValue(short v) throws DicomException {
		this.flushCachedCopies();
		this.values = ArrayCopyUtilities.expandArray(this.values);
		this.values[this.fValueMultiplicity++] = v;
		this.fValueLength += 2;
	}

	private void flushCachedCopies() {
		this.cachedIntegerCopy = null;
		this.cachedLongCopy = null;
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public int[] getIntegerValues() throws DicomException {
		if (this.cachedIntegerCopy == null) {
			this.cachedIntegerCopy = ArrayCopyUtilities
			.copySignedShortToIntArray(this.values);
		}
		return this.cachedIntegerCopy;
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public long[] getLongValues() throws DicomException {
		if (this.cachedLongCopy == null) {
			this.cachedLongCopy = ArrayCopyUtilities
			.copySignedShortToLongArray(this.values);
		}
		return this.cachedLongCopy;
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public short[] getShortValues() throws DicomException {
		return this.values;
	}

	/**
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @exception DicomException
	 */
	@Override
	public String[] getStringValues(NumberFormat format) throws DicomException {
		String sv[] = null;
		int[] v = this.getIntegerValues();
		if (v != null) {
			sv = new String[v.length];
			for (int j = 0; j < v.length; ++j) {
				sv[j] = format == null ? Integer.toString(v[j]) : format.format(v[j]);
			}
		}
		return sv;
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (SS)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.SignedShort;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (SS).
	 * </p>
	 * 
	 * @return 'S','S' in ASCII as a two byte array; see
	 */
	public byte[] getVR() {
		return ValueRepresentation.SS;
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
		this.flushCachedCopies();
		if (aLength % bytesPerValue != 0) {
			throw new DicomException("incorrect value length for VR " + this.getVR());
		}
		int vm = (int) (aLength / bytesPerValue);
		this.values = null;
		for (int j = 0; j < vm; ++j) {
			this.addValue((short) aStream.readSigned16());
		}
	}

	/***/
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" [");
		try {
			// short[] v = getShortValues();
			int[] v = this.getIntegerValues();
			if (v != null) {
				for (int j = 0; j < v.length; ++j) {
					if (j > 0) {
						str.append(",");
					}
					str.append("0x");
					str.append(Integer.toHexString(v[j]));
				}
			}
		} catch (DicomException e) {
			str.append("XXXX");
		}
		str.append("]");
		return str.toString();
	}

	/**
	 * @param o
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void write(DicomOutputStream o) throws DicomException, IOException {
		this.writeBase(o);
		short[] v = this.getShortValues();
		if (v != null) {
			for (int j = 0; j < v.length; ++j) {
				o.writeSigned16(v[j]);
			}
		}
	}

}
