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

import java.io.IOException;

import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.data.elements.support.TextElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Long Text (LT) {@link DataElement DataElement}.
 * </p>
 * <p>
 * a Long Text is not multi-valued
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class LongText extends TextElement {

	/**
	 * the logger
	 */
	private static Logger fLogger = LoggerFactory.getLogger(LongText.class);

	/**
	 * <p>
	 * creates a new DataElement
	 * </p>
	 * 
	 * @param tag
	 *          the tag of the element
	 */
	public LongText(DicomTag tag) {
		super(tag);
	}

	/**
	 * <p>
	 * Creates an new DataElement
	 * </p>
	 * 
	 * @param aDataElementTag
	 *          the tag of the element
	 * @param aCharacterSet
	 *          the CharacterSet
	 */
	public LongText(DicomTag t, SpecificCharacterSet aCharacterSet) {
		super(t, aCharacterSet);
	}

	@Override
	public String[] getStringValues() {
		String[] result = new String[1];
		result[0] = this.getValue();
		return result;
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (LT)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.LongText;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (LT).
	 * </p>
	 * 
	 * @deprecated
	 * @return 'L','T' in ASCII as a two byte array; see
	 */
	@Deprecated
	public byte[] getVR() {
		return ValueRepresentation.LT;
	}

	@Override
	public void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException {
		fLogger.debug("read (length: " + aLength + " ) ");
		super.read(aStream, aLength, aCharacterSet);
		fLogger.debug("read completed");
	}

}
