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
 * {@link org.dicom4j.data.elements.support.DataElement Attribute} for Attribute
 * Tag (AT) attributes.
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
public class AttributeTag extends DataElement {

	static int bytesPerValue = 4;

	int[] elements;

	int[] groups;

	/**
	 * <p>
	 * Construct an (empty) attribute.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 */
	public AttributeTag(DicomTag t) {
		super(t);
		this.groups = null;
		this.elements = null;
	}

	/**
	 * @param g
	 * @param e
	 * @exception DicomException
	 */
	public void addValue(int g, int e) throws DicomException {
		this.groups = ArrayCopyUtilities.expandArray(this.groups);
		this.groups[this.fValueMultiplicity] = g;
		this.elements = ArrayCopyUtilities.expandArray(this.elements);
		this.elements[this.fValueMultiplicity++] = e;
	}

	/**
	 * @exception DicomException
	 */
	public DicomTag[] getAttributeTagValues() throws DicomException {
		DicomTag atv[] = null;
		if ((this.groups != null) && (this.elements != null)) {
			atv = new DicomTag[this.groups.length];
			for (int j = 0; j < this.groups.length; ++j) {
				atv[j] = new DicomTag(this.groups[j], this.elements[j]);
			}
		}
		return atv;
	}

	/**
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @exception DicomException
	 */
	@Override
	public String[] getStringValues(NumberFormat format) throws DicomException {
		// ignore number format
		String sv[] = null;
		if ((this.groups != null) && (this.elements != null)) {
			sv = new String[this.groups.length];
			for (int j = 0; j < this.groups.length; ++j) {
				StringBuffer str = new StringBuffer();
				str.append("(0x");
				String groupString = Integer.toHexString(this.groups[j]);
				for (int i = groupString.length(); i < 4; ++i) {
					str.append("0");
				}
				str.append(groupString);
				str.append(",0x");
				String elementString = Integer.toHexString(this.elements[j]);
				for (int i = elementString.length(); i < 4; ++i) {
					str.append("0");
				}
				str.append(elementString);
				str.append(")");
				sv[j] = str.toString();
			}
		}
		return sv;
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (AT)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.AttributeTag;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (AT).
	 * </p>
	 * 
	 * @return 'A','T' in ASCII as a two byte array; see
	 */
	public byte[] getVR() {
		return ValueRepresentation.AT;
	}

	/**
	 * <p>
	 * Read an attribute from an input stream.
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
	/*
	 * public AttributeTagAttribute(DataElementTag t,long vl,DicomInputStream i)
	 * throws IOException, DicomException { super(t);
	 * doCommonConstructorStuff(vl,i); }
	 * 
	 * /** <p>Read an attribute from an input stream.</p>
	 * 
	 * @param t the tag of the attribute @param vl the value length of the
	 * attribute @param i the input stream @exception IOException @exception
	 * DicomException
	 */
	/*
	 * public AttributeTagAttribute(DataElementTag t,Long vl,DicomInputStream i)
	 * throws IOException, DicomException { super(t);
	 * doCommonConstructorStuff(vl.longValue(),i); }
	 * 
	 * /** @param vl @param i @exception IOException @exception DicomException
	 */
	@Override
	public void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException {
		this.fValueLength = aLength;
		if (this.fValueLength % bytesPerValue != 0) {
			throw new DicomException("incorrect value length for VR " + this.getVR());
		}
		int vm = (int) (this.fValueLength / bytesPerValue);

		// valueMultiplicity=vm;
		// values=new short[valueMultiplicity];
		// for (int j=0; j<valueMultiplicity; ++j)
		// values[j]=(short)(i.readUnsigned16());

		this.groups = null;
		this.elements = null;
		for (int j = 0; j < vm; ++j) {
			int g = aStream.readUnsigned16() & 0xffff;
			int e = aStream.readUnsigned16() & 0xffff;
			this.addValue(g, e);
		}
	}

	/***/
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" [");
		if ((this.groups != null) && (this.elements != null)) {
			for (int j = 0; j < this.groups.length; ++j) {
				if (j > 0) {
					str.append(",");
				}
				str.append("(0x");
				String groupString = Integer.toHexString(this.groups[j]);
				for (int i = groupString.length(); i < 4; ++i) {
					str.append("0");
				}
				str.append(groupString);
				str.append(",0x");
				String elementString = Integer.toHexString(this.elements[j]);
				for (int i = elementString.length(); i < 4; ++i) {
					str.append("0");
				}
				str.append(elementString);
				str.append(")");
			}
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
		for (int j = 0; j < this.fValueMultiplicity; ++j) {
			o.writeUnsigned16(this.groups[j]);
			o.writeUnsigned16(this.elements[j]);
		}
	}

}
