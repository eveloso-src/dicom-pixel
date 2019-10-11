/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.data.elements;

import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.data.elements.support.StringElement;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;

/**
 * Long String (LO) {@link DataElement DataElement}
 * 
 * 
 * @see org.dicom4j.data.elements.support.DataElement
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class LongString extends StringElement {

	/**
	 * <p>
	 * Construct an (empty) attribute.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 */
	public LongString(DicomTag t) {
		super(t);
	}

	/**
	 * <p>
	 * Construct an (empty) attribute.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 * @param specificCharacterSet
	 *          the character set to be used for the text
	 */
	public LongString(DicomTag t, SpecificCharacterSet specificCharacterSet) {
		super(t, specificCharacterSet);
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (LO)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.LongString;
	}

	/**
	 * @deprecated <p>
	 *             Get the value representation of this attribute (LO).
	 *             </p>
	 * 
	 * @return 'L','O' in ASCII as a two byte array; see
	 */
	@Deprecated
	public byte[] getVR() {
		return ValueRepresentation.LO;
	}

	@Override
	public boolean isValid() {
		return this.getValueLength() <= 64;
	}

}
