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
 * 
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ConcatenationDirectoryItem extends DicomDirectoryItem {

	/**
	 * The Logger
	 */
	// private static Logger flogger =
	// LoggerFactory.getLogger(ConcatenationDirectoryItem.class);
	/**
	 * @param parent
	 * @param list
	 */
	public ConcatenationDirectoryItem(DicomDirectoryItem aParent, DataSet aDataSet) {
		super(DirectoryRecordType.CONCATENATION, aParent, aDataSet);
		this.fUID = DataElement.getSingleStringValueOrEmptyString(
				this.getDataSet(), DicomTags.ConcatenationUID);
	}

	/**
	 * @param o
	 */
	@Override
	public int compareTo(Object o) {
		return this.compareToByIntegerValue((DicomDirectoryItem) o);
	}

	/***/
	@Override
	protected void makeIntegerValue() {
		this.integerValue = DataElement.getSingleIntegerValueOrDefault(this
				.getDataSet(), DicomTags.InstanceNumber, -1);
	}

	/***/
	@Override
	protected void makeStringValue() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(DataElement.getSingleStringValueOrEmptyString(this
				.getDataSet(), DicomTags.InstanceNumber));
		this.stringValue = buffer.toString();
	}

	/***/
	@Override
	public String toString() {
		return "Concatenation " + this.getStringValue();
	}
}