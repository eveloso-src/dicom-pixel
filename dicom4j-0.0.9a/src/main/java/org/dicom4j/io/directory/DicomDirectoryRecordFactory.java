/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.io.directory;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.CodeString;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dclunie
 */
public class DicomDirectoryRecordFactory {

	/***/
	class RawDataDirectoryRecord extends DicomDirectoryItem {
		/**
		 * @param parent
		 * @param list
		 */
		RawDataDirectoryRecord(DicomDirectoryItem parent, DataSet list) {
			super(parent, list);
			this.fUID = DataElement.getSingleStringValueOrEmptyString(this
					.getDataSet(), DicomTags.ReferencedRelatedGeneralSOPClassUIDInFile);
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
			return "Raw Data " + this.getStringValue();
		}
	}

	/***/
	class SpectroscopyDirectoryRecord extends DicomDirectoryItem {
		/**
		 * @param parent
		 * @param list
		 */
		SpectroscopyDirectoryRecord(DicomDirectoryItem parent, DataSet list) {
			super(parent, list);
			this.fUID = DataElement.getSingleStringValueOrEmptyString(this
					.getDataSet(), DicomTags.ReferencedRelatedGeneralSOPClassUIDInFile);
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
			StringBuffer buffer = new StringBuffer();
			String useNumber = DataElement.getSingleStringValueOrNull(this
					.getDataSet(), DicomTags.InConcatenationNumber);
			if (useNumber == null) {
				useNumber = DataElement.getSingleStringValueOrEmptyString(this
						.getDataSet(), DicomTags.InstanceNumber);
			}
			buffer.append(useNumber);
			buffer.append(" ");
			buffer.append(DataElement.getSingleStringValueOrEmptyString(this
					.getDataSet(), DicomTags.ImageComments));
			this.stringValue = buffer.toString();
		}

		/***/
		@Override
		public String toString() {
			return "Spectra " + this.getStringValue();
		}
	}

	/***/
	class SRDocumentDirectoryRecord extends DicomDirectoryItem {
		/**
		 * @param parent
		 * @param list
		 */
		SRDocumentDirectoryRecord(DicomDirectoryItem parent, DataSet list) {
			super(parent, list);
			this.fUID = DataElement.getSingleStringValueOrEmptyString(this
					.getDataSet(), DicomTags.ReferencedRelatedGeneralSOPClassUIDInFile);
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
			return "SR Document " + this.getStringValue();
		}
	}

	/***/
	class UnrecognizedDirectoryRecord extends DicomDirectoryItem {
		/***/
		private String directoryRecordType;

		/***/
		UnrecognizedDirectoryRecord() {
			super(null, null);
			this.directoryRecordType = "Unrecognized";
		}

		/**
		 * @param parent
		 */
		UnrecognizedDirectoryRecord(DicomDirectoryItem parent) {
			super(parent, null);
			this.directoryRecordType = "Unrecognized";
		}

		/**
		 * @param parent
		 * @param list
		 */
		UnrecognizedDirectoryRecord(DicomDirectoryItem parent, DataSet list) {
			super(parent, list);
			this.directoryRecordType = "Unrecognized";
		}

		/**
		 * @param parent
		 * @param list
		 * @param name
		 */
		UnrecognizedDirectoryRecord(DicomDirectoryItem parent, DataSet list,
				String name) {
			super(parent, list);
			this.fUID = "";
			this.directoryRecordType = name;
		}

		/***/
		@Override
		protected void makeIntegerValue() {
			this.integerValue = -1;
		}

		/***/
		@Override
		protected void makeStringValue() {
			this.stringValue = "BAD";
		}

		/***/
		@Override
		public String toString() {
			return this.directoryRecordType;
		}
	}

	/***/
	class WaveformDirectoryRecord extends DicomDirectoryItem {
		/**
		 * @param parent
		 * @param list
		 */
		WaveformDirectoryRecord(DicomDirectoryItem parent, DataSet list) {
			super(parent, list);
			this.fUID = DataElement.getSingleStringValueOrEmptyString(this
					.getDataSet(), DicomTags.ReferencedRelatedGeneralSOPClassUIDInFile);
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
			return "Waveform " + this.getStringValue();
		}
	}

	/**
	 * the Logger
	 */
	private static final Logger flogger = LoggerFactory
	.getLogger(DicomDirectoryRecordFactory.class);

	/***/
	private static final String identString = "@(#) $Header: /userland/cvs/pixelmed/imgbook/com/pixelmed/dicom/DicomDirectoryRecordFactory.java,v 1.18 2004/09/08 20:46:45 dclunie Exp $";

	/**
	 * creates a new {@link DicomDirectoryItem}
	 * 
	 * @param aParent
	 * @param aDataSet
	 * @assert always return not null
	 */
	public DicomDirectoryItem newDicomDirectoryItem(DicomDirectoryItem aParent,
			DataSet aDataSet) {
		DicomDirectoryItem record = null;

		// try {
		if (aDataSet == null) {
			flogger.warn("newDicomDirectoryItem: DataSet is null");
			record = new UnrecognizedDirectoryRecord(aParent);
		} else {
			String directoryRecordType = null;
			DirectoryRecordType lDirectoryRecordType = null;
			if (aDataSet.hasElement(DicomTags.DirectoryRecordType)) {
				CodeString lDirRecType = aDataSet
				.getCodeString(DicomTags.DirectoryRecordType);
				directoryRecordType = lDirRecType.getSingleStringValue();
				lDirectoryRecordType = new DirectoryRecordType(lDirRecType
						.getSingleStringValue());
			}
			flogger.debug("DirectoryRecordType: " + lDirectoryRecordType);
			if (directoryRecordType == null) {
				flogger.warn("newDicomDirectoryItem: DirectoryRecordType is null");
				record = new UnrecognizedDirectoryRecord(aParent, aDataSet);
			} else if (lDirectoryRecordType.equals(DirectoryRecordType.PATIENT)) {
				record = new PatientDirectoryItem(aParent, aDataSet);
				flogger.debug("PatientDirectoryItem created");
			} else if (lDirectoryRecordType.equals(DirectoryRecordType.STUDY)) {
				record = new StudyDirectoryItem(aParent, aDataSet);
				flogger.debug("StudyDirectoryItem created");
			} else if (lDirectoryRecordType.equals(DirectoryRecordType.SERIES)) {
				record = new SeriesDirectoryItem(aParent, aDataSet);
				flogger.debug("SeriesDirectoryItem created");
			} else if (lDirectoryRecordType.equals(DirectoryRecordType.CONCATENATION)) {
				record = new ConcatenationDirectoryItem(aParent, aDataSet);
			} else if (lDirectoryRecordType.equals(DirectoryRecordType.IMAGE)) {
				record = new ImageDirectoryItem(aParent, aDataSet);
			} else if (directoryRecordType.equals("SR DOCUMENT")) {
				record = new SRDocumentDirectoryRecord(aParent, aDataSet);
			} else if (directoryRecordType.equals("WAVEFORM")) {
				record = new WaveformDirectoryRecord(aParent, aDataSet);
			} else if (directoryRecordType.equals("SPECTROSCOPY")) {
				record = new SpectroscopyDirectoryRecord(aParent, aDataSet);
			} else if (directoryRecordType.equals("RAW DATA")) {
				record = new RawDataDirectoryRecord(aParent, aDataSet);
			} else {
				record = new UnrecognizedDirectoryRecord(aParent, aDataSet,
						directoryRecordType);
			}
		}
		// }
		// catch (DicomException e) {
		// flogger.warn(e.getMessage());
		// record = new UnrecognizedDirectoryRecord(aParent,aDataSet);
		// }

		return record;
	}

	/***/
	public TopDirectoryItem newTopDirectoryRecord() {
		return new TopDirectoryItem();
	}

}
