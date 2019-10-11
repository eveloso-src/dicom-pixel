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

package org.dicom4j.data.elements;

import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.support.StringElement;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;

/**
 * Short String (SH) element.
 * 
 * @see org.dicom4j.data.elements.support.DataElement
 * @see org.dicom4j.data.elements.DataElementFactory
 * 
 * @since 0.0.0
 * @version test version
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class ShortString extends StringElement {

	/**
	 *  new empty element
	 * 
	 *  @param tag the dicom tag
	 */
	public ShortString(DicomTag tag) {
		super(tag);
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
	public ShortString(DicomTag t, SpecificCharacterSet specificCharacterSet) {
		super(t, specificCharacterSet);
	}

	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.ShortString;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (SH).
	 * </p>
	 * @deprecated
	 * @return 'S','H' in ASCII as a two byte array; see
	 */
	@Deprecated
	public byte[] getVR() {
		return ValueRepresentation.SH;
	}

}
