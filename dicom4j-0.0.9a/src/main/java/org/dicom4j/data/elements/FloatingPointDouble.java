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
import org.dolmen.core.lang.FloatUtils;

/**
 * <p>
 * A concrete class specializing
 * {@link org.dicom4j.data.elements.support.DataElement Attribute} for Float
 * Double (FD) attributes.
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
public class FloatingPointDouble extends DataElement {

	static int bytesPerValue = 8;

	double[] values;

	/**
	 * <p>
	 * Construct an (empty) attribute.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 */
	public FloatingPointDouble(DicomTag t) {
		super(t);
		this.flushCachedCopies();
		this.values = null;
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void addValue(double v) throws DicomException {
		this.flushCachedCopies();
		this.values = ArrayCopyUtilities.expandArray(this.values);
		this.values[this.fValueMultiplicity++] = v;
		this.fValueLength += 8;
	}

	private void flushCachedCopies() {
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public double[] getDoubleValues() throws DicomException {
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
		double[] v = this.getDoubleValues();
		if (v != null) {
			sv = new String[v.length];
			for (int j = 0; j < v.length; ++j) {
				sv[j] = format == null ? FloatUtils.toString(v[j]) : format
						.format(v[j]);
			}
		}
		return sv;
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (FD)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.FloatingPointDouble;
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
			throw new DicomException("incorrect value length for VR "
					+ this.getValueRepresentation().getName());
		}
		int vm = (int) (aLength / bytesPerValue);
		this.values = null;
		for (int j = 0; j < vm; ++j) {
			this.addValue(aStream.readDouble());
		}
	}

	/***/
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" [");
		try {
			double[] v = this.getDoubleValues();
			if (v != null) {
				for (int j = 0; j < v.length; ++j) {
					if (j > 0) {
						str.append(",");
					}
					str.append(v[j]);
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
		double[] v = this.getDoubleValues();
		if (v != null) {
			for (int j = 0; j < v.length; ++j) {
				o.writeDouble(v[j]);
			}
		}
	}

}
