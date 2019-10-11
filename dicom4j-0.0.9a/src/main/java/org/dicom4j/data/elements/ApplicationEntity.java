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

import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.data.elements.support.StringElement;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.DicomViolationException;
import org.dicom4j.dicom.ValueRepresentation;

/**
 * <p>
 * Application Entity (AE) {@link DataElement element}
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ApplicationEntity extends StringElement {

	/**
	 * creates new element
	 * 
	 * @param aDataElementTag
	 *          the tag element's
	 */
	public ApplicationEntity(DicomTag aDataElementTag) {
		super(aDataElementTag);
	}

	/**
	 * <p>
	 * Creates an new DataElement
	 * </p>
	 * 
	 * @param aDataElementTag
	 *          the tag of the element
	 * @param aAET
	 *          the value for this element
	 * @throws DicomViolationException
	 *           if the value doesn't respect the DICOM standard
	 */
	public ApplicationEntity(DicomTag aDataElementTag, String aAET)
	throws DicomViolationException {
		this(aDataElementTag);
		// checkIfValid(aAET);
		this.addValue(aAET);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.data.elements.DataElement#getValueRepresentation()
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.ApplicationEntity;
	}

	@Override
	public boolean isValid() {
		if (this.getSingleStringValue().length() > 16) {
			return false;
		}
		return true;
	}

}
