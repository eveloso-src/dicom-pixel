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

public class ImageDirectoryItem extends DicomDirectoryItem {
	/***/
	String recordNameFromSOPClass;

	/**
	 * @param parent
	 * @param list
	 */
	public ImageDirectoryItem(DicomDirectoryItem aParent, DataSet aDataSet) {
		super(DirectoryRecordType.IMAGE, aParent, aDataSet);
		/*
		 * fUID = DataElement.getSingleStringValueOrEmptyString(getDataSet(),
		 * DicomTags.refer ReferencedSOPInstanceUIDInFile); String sopClassUID =
		 * DataElement.getSingleStringValueOrNull(aDataSet,
		 * DicomTags.ReferencedSOPClassUIDInFile); recordNameFromSOPClass = "Image";
		 * if (sopClassUID != null) { if (SOPClass.isSpectroscopy(sopClassUID)) {
		 * recordNameFromSOPClass = "Spectra"; } else if
		 * (SOPClass.isRawData(sopClassUID)) { recordNameFromSOPClass = "Raw Data";
		 * } }
		 */
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
				.getDataSet(), DicomTags.InConcatenationNumber, -1);
		if (this.integerValue == -1) {
			this.integerValue = DataElement.getSingleIntegerValueOrDefault(this
					.getDataSet(), DicomTags.InstanceNumber, -1);
		}
	}

	/***/
	@Override
	protected void makeStringValue() {
		this.stringValue = DescriptionFactory.makeImageDescription(this
				.getDataSet());
	}

	/***/
	@Override
	public String toString() {
		return this.recordNameFromSOPClass + " " + this.getStringValue();
	}
}
