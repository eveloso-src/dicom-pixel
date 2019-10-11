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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class StudyDirectoryItem extends DicomDirectoryItem {

	/**
	 * The Logger
	 */
	private static Logger flogger = LoggerFactory
	.getLogger(StudyDirectoryItem.class);

	/**
	 * @param aParent
	 * @param aDataSet
	 */
	public StudyDirectoryItem(DicomDirectoryItem aParent, DataSet aDataSet) {
		super(DirectoryRecordType.STUDY, aParent, aDataSet);
		if (aDataSet.hasElement(DicomTags.StudyInstanceUID)) {
			this.fUID = DataElement.getSingleStringValueOrEmptyString(this
					.getDataSet(), DicomTags.StudyInstanceUID);
			flogger.debug("StudyInstanceUID: " + this.fUID);
		} else {
			flogger.warn("No StudyInstanceUID in DataSet");
		}
	}

	/**
	 * @param o
	 */
	@Override
	public int compareTo(Object o) {
		return this.compareToByStringValue((DicomDirectoryItem) o);
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
				.getDataSet(), DicomTags.StudyDate)); // [bugs.mrmf]
		// (000111)
		// Studies
		// in
		// browser
		// not
		// sorted
		// by
		// date
		// but
		// ID,
		// and
		// don't
		// display
		// date
		buffer.append(" ");
		buffer.append(DataElement.getSingleStringValueOrEmptyString(this
				.getDataSet(), DicomTags.StudyID));
		buffer.append(" ");
		buffer.append(DataElement.getSingleStringValueOrEmptyString(this
				.getDataSet(), DicomTags.StudyDescription));
		this.stringValue = buffer.toString();
	}

}
