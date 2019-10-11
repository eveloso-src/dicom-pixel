/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.data.elements;

import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;

/**
 * <p>
 * Unknow (UN) {@link DataElement DataElement}
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class Unknown extends OtherByteString {

	/**
	 * <p>
	 * Creates an empty element
	 * </p>
	 * 
	 * @param aTag
	 *          the tag of the element
	 */
	public Unknown(DicomTag aTag) {
		super(aTag);
	}

	/**
	 * Return the value representation of this element
	 * 
	 * @return the value representation (UN)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.Unknown;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (UN).
	 * </p>
	 * 
	 * @return 'U','U' in ASCII as a two byte array; see
	 */
	@Override
	public byte[] getVR() {
		return ValueRepresentation.UN;
	}

}
