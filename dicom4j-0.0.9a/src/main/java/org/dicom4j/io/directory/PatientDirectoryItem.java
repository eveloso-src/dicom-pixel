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

package org.dicom4j.io.directory;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomTags;

/**
 * Patient Directory Item (contains in a DicomDir)
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class PatientDirectoryItem extends DicomDirectoryItem {

	/**
	 * The Logger
	 */
	// private static Logger flogger =
	// LoggerFactory.getLogger(PatientDirectoryItem.class);
	/**
	 * @param parent
	 * @param list
	 */
	public PatientDirectoryItem(DicomDirectoryItem aParent, DataSet aDataSet) {
		super(DirectoryRecordType.PATIENT, aParent, aDataSet);
		this.setUID("");
	}

	/**
	 * @param o
	 */
	@Override
	public int compareTo(Object o) {
		// do NOT use compareToByStringValue() else absence of UIDs will cause
		// erroneous equality
		return this.toString().compareTo(((DicomDirectoryItem) o).toString()); // includes
		// name
		// of
		// record
		// type
	}

	/***/
	@Override
	protected void makeIntegerValue() {
		this.integerValue = -1;
	}

	/***/
	@Override
	protected void makeStringValue() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(DataElement.getSingleStringValueOrEmptyString(this
				.getDataSet(), DicomTags.PatientName));
		buffer.append(" ");
		buffer.append(DataElement.getSingleStringValueOrEmptyString(this
				.getDataSet(), DicomTags.PatientID));
		this.stringValue = buffer.toString();
	}

	/***/
	@Override
	public String toString() {
		return "Patient " + this.getStringValue();
	}
}
