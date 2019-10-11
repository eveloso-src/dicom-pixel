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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.data.elements.support.StringElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;

/**
 * <p>
 * Date (DA) {@link DataElement element}
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class DateElement extends StringElement {

	/**
	 * <p>
	 * Creates an empty element
	 * </p>
	 * 
	 * @param aDicomTag
	 *          the tag of the element
	 */
	public DateElement(DicomTag aDicomTag) {
		super(aDicomTag);
	}

	/**
	 * <p>
	 * Read an attribute from an input stream.
	 * </p>
	 * 
	 * @param aDicomTag
	 *          the tag of the element
	 * @param aLength
	 *          the value length of the attribute
	 * @param aStream
	 *          the input stream
	 * @exception IOException
	 * @exception DicomException
	 */
	public DateElement(DicomTag aDicomTag, long aLength, DicomInputStream aStream)
	throws IOException, DicomException {
		super(aDicomTag, aLength, aStream);
	}

	/**
	 * retrun a format Date depending on the current {@link Locale}
	 * 
	 * @return
	 */
	public String format() {
		String lValue = this.getSingleStringValue();
		if (lValue.length() == 8) {
			try {
				java.util.Date lDate = new SimpleDateFormat("yyyyMMdd", Locale
						.getDefault()).parse(lValue);
				return DateFormat
				.getDateInstance(DateFormat.SHORT, Locale.getDefault()).format(
						lDate);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return lValue;
		} else {
			return lValue;
		}
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (PN)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.Date;
	}

}
