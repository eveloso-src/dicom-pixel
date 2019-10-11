/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.data.elements;

import java.io.IOException;

import org.dicom4j.data.elements.support.StringElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * A concrete class specializing
 * {@link org.dicom4j.data.elements.support.DataElement Attribute} for Unique
 * Identifier (UI) attributes.
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
public class UniqueIdentifier extends StringElement {

	private static final Logger fLogger = LoggerFactory.getLogger(UniqueIdentifier.class);

	/**
	 * <p>
	 * Construct an (empty) attribute.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 */
	public UniqueIdentifier(DicomTag t) {
		super(t);
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
	public UniqueIdentifier(DicomTag t, long vl, DicomInputStream i)
	throws IOException, DicomException {
		super(t, vl, i);
	}

	public UniqueIdentifier(DicomTag t, String aValue) {
		this(t);
		this.addValue(aValue);
	}

	/**
	 * <p>
	 * Get the appropriate (0X00) byte for padding UIDS to an even length.
	 * </p>
	 * 
	 * @return the byte pad value appropriate to the VR
	 */
	@Override
	protected byte getPadByte() {
		return 0x00;
	}

	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.UniqueIdentifier;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (UI).
	 * </p>
	 * 
	 * @return 'U','I' in ASCII as a two byte array; see
	 */
	public byte[] getVR() {
		return ValueRepresentation.UI;
	}

	@Override
	public void setValue(String aValue) {
		fLogger.debug("setValue: " + aValue);
		super.setValue(aValue);
	}
}
