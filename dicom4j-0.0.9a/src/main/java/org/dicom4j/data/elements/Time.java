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
import org.dicom4j.dicom.ValueRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Time (TM) {@link DataElement DataElement}
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class Time extends StringElement {

	/**
	 * the logger
	 */
	private static final Logger fLogger = LoggerFactory.getLogger(Time.class);

	/**
	 * <p>
	 * Creates an empty element
	 * </p>
	 * 
	 * @param aTag
	 *          the tag of the element
	 */
	public Time(DicomTag aTag) {
		super(aTag);
	}

	/**
	 * retrun a formated time ( hh:mm:ss )
	 * 
	 * @return the time
	 */
	public String format() {
		return this.getShowableValue(":");
	}

	/**
	 * return the value formated to be show in a UI
	 * 
	 * @param aSeparator
	 *          the time separator
	 * @return
	 */
	public String getShowableValue(String aSeparator) {
		String lValue = this.getSingleStringValue();
		if (lValue.length() > 6) {
			String lHours = lValue.substring(0, 2);
			String lminutes = lValue.substring(2, 4);
			String lseconds = lValue.substring(4, 6);
			return lHours + aSeparator + lminutes + aSeparator + lseconds;
		} else {
			return lValue;
		}
	}

	/**
	 * return the {@link ValueRepresentation} of this data element (TM)
	 * 
	 * @return the value representation
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.Time;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (TM).
	 * </p>
	 * 
	 * @deprecated
	 * @return 'T','M' in ASCII as a two byte array; see
	 */
	@Deprecated
	public byte[] getVR() {
		return ValueRepresentation.TM;
	}

	@Override
	public void setValue(String aValue) {
		fLogger.debug("setValue: " + aValue);
		super.setValue(aValue);
	}

}
