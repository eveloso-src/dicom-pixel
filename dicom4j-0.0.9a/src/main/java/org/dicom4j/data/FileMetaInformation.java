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

package org.dicom4j.data;

import org.dicom4j.data.elements.ApplicationEntity;
import org.dicom4j.data.elements.OtherByteString;
import org.dicom4j.data.elements.ShortString;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.UnsignedLong;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.DicomViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO finish this class

/**
 * <p>
 * File Meta Information (see DICOM PS 3.10)
 * </p>
 * <br>
 * extends a DataSet by adding specific methods related to FMI
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */

public class FileMetaInformation extends DataSet {

	/**
	 * the Dicom Prefix
	 */
	public final static String DicomPrefix = "DICM";

	/**
	 * the logger
	 */
	protected static Logger logger = LoggerFactory.getLogger(FileMetaInformation.class);

	public final static int PREAMBLE_LENGTH = 128;

	private byte[] preamble;

	public FileMetaInformation() {
		try {
			this.setPreambule(new byte[PREAMBLE_LENGTH]);
			this.addElement(DataElements.newFileMetaInformationGroupLength());
			this.addElement(DataElements.newFileMetaInformationVersion());
			this.addElement(DataElements.newMediaStorageSOPClassUID());
			this.addElement(DataElements.newMediaStorageSOPInstanceUID());
			this.addElement(DataElements.newTransferSyntaxUID());
			this.addElement(DataElements.newImplementationClassUID());
			this.addElement(DataElements.newImplementationVersionName());
			this.addElement(DataElements.newSourceApplicationEntityTitle());
			// addElement(DataElements.newPrivateInformationCreatorUID());
			// addElement(DataElements.newPrivateInformation());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * creates a new FileMetaInformation. If true is supplied dicom norms elements
	 * will be added, otherwise the FileMetaInformation will be empty
	 * 
	 * @param mustAddElements true to add dicom norms's element
	 */
	public FileMetaInformation(boolean mustAddElements) {
		super();
		if (mustAddElements) {
			try {
				this.setPreambule(new byte[PREAMBLE_LENGTH]);
				this.addElement(DataElements.newFileMetaInformationGroupLength());
				this.addElement(DataElements.newFileMetaInformationVersion());
				this.addElement(DataElements.newMediaStorageSOPClassUID());
				this.addElement(DataElements.newMediaStorageSOPInstanceUID());
				this.addElement(DataElements.newTransferSyntaxUID());
				this.addElement(DataElements.newImplementationClassUID());
				this.addElement(DataElements.newImplementationVersionName());
				this.addElement(DataElements.newSourceApplicationEntityTitle());
				// addElement(DataElements.newPrivateInformationCreatorUID());
				// addElement(DataElements.newPrivateInformation());
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * create a FMI from a DataSet
	 * 
	 * @param aPreambule
	 * @param aDataSet
	 * @throws DicomViolationException
	 */
	public FileMetaInformation(byte[] aPreambule, DataSet aDataSet)
	throws DicomViolationException {
		this.setPreambule(aPreambule);
	}

	/**
	 * add all elements and the preamble (see PS 3.10 for more details)
	 * 
	 * @throws Exception
	 */
	public void addElementsAndPreambule() throws Exception {
		this.setPreambule(new byte[PREAMBLE_LENGTH]);
		this.addElement(DataElements.newFileMetaInformationGroupLength());
		this.addElement(DataElements.newFileMetaInformationVersion());
		this.addElement(DataElements.newMediaStorageSOPClassUID());
		this.addElement(DataElements.newMediaStorageSOPInstanceUID());
		this.addElement(DataElements.newTransferSyntaxUID());
		this.addElement(DataElements.newImplementationClassUID());
		this.addElement(DataElements.newImplementationVersionName());
		this.addElement(DataElements.newSourceApplicationEntityTitle());
	}

	/*
	 * public Attribute FileMetaInformationVersion() { return
	 * FAttributes.get(TagFromName.FileMetaInformationVersion); }
	 * 
	 * public Attribute SourceApplicationEntityTitle() { return
	 * FAttributes.get(TagFromName.SourceApplicationEntityTitle); }
	 */

	/**
	 * Retrun the File Meta Information Group Length
	 * 
	 * @return the File Meta Information Group Length
	 */
	public UnsignedLong getFileMetaInformationGroupLengthElement() {
		return this.getUnsignedLong(DicomTags.FileMetaInformationGroupLength);
	}

	/**
	 * Retrun the File Meta Information Version
	 * 
	 * @return the File Meta Information Version
	 */
	public OtherByteString getFileMetaInformationVersionElement() {
		return this.getOtherByteString(DicomTags.FileMetaInformationVersion);
	}

	public String getImplementationClassUID() {
		if (this.hasImplementationClassUIDElement()) {
			try {
				return this.getImplementationClassUIDElement().getSingleStringValue();
			} catch (Exception e) {
				logger.warn(e.getMessage());
				return "";
			}
		} else {
			return "";
		}
	}

	/**
	 * return the Implementation Class UID Element
	 * 
	 * @since 0.0.3
	 * @return the Implementation Class UID
	 */
	public UniqueIdentifier getImplementationClassUIDElement()
	throws DicomException {
		return this.getUniqueIdentifier(DicomTags.ImplementationClassUID);
	}

	/**
	 * @since 0.0.3
	 * @return
	 */
	public String getImplementationVersionName() {
		if (this.hasImplementationVersionNameElement()) {
			try {
				return this.getImplementationVersionNameElement()
				.getSingleStringValue();
			} catch (Exception e) {
				logger.warn(e.getMessage());
				return "";
			}
		} else {
			return "";
		}
	}

	/**
	 * Retrun the Implementation Version Name Element
	 * 
	 * @since 0.0.3
	 * @return the Element
	 */
	public ShortString getImplementationVersionNameElement() {
		return this.getShortString(DicomTags.ImplementationVersionName);
	}

	/**
	 * Retrun the Media Storage SOP Class UID
	 * 
	 * @return the Media Storage SOP Class UID
	 */
	public UniqueIdentifier getMediaStorageSOPClassUIDElement()
	throws DicomException {
		return this.getUniqueIdentifier(DicomTags.MediaStorageSOPClassUID);
	}

	public UniqueIdentifier getMediaStorageSOPInstanceUIDElement()
	throws DicomException {
		return this.getUniqueIdentifier(DicomTags.MediaStorageSOPInstanceUID);
	}

	/**
	 * Return the Preambule
	 * 
	 * @return the Preambule
	 */
	public byte[] getPreambule() {
		return this.preamble;
	}

	/**
	 * Retrun the Private Information Creator UID
	 * 
	 * @return the Private Information Creator UID
	 */
	public UniqueIdentifier getPrivateInformationCreatorUID()
	throws DicomException {
		return this.getUniqueIdentifier(DicomTags.PrivateInformationCreatorUID);
	}

	/**
	 * Retrun the Private Information
	 * 
	 * @return the Private Information
	 */
	/*
	 * public OtherByteString getPrivateInformation() { return
	 * getOtherByteString(DicomTags.PrivateInformation); }
	 */

	/**
	 * @since 0.0.3
	 * @return
	 */
	public String getSourceApplicationEntityTitle() {
		if (this.hasSourceApplicationEntityTitleElement()) {
			try {
				return this.getSourceApplicationEntityTitleElement()
				.getSingleStringValue();
			} catch (Exception e) {
				logger.warn(e.getMessage());
				return "";
			}
		} else {
			return "";
		}
	}

	/**
	 * Retrun the Implementation Version Name Element
	 * 
	 * @since 0.0.3
	 * @return the Element
	 */
	public ApplicationEntity getSourceApplicationEntityTitleElement()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this.getApplicationEntity(DicomTags.SourceApplicationEntityTitle);
	}

	// ------------ ImplementationClassUID -----------

	public String getTransferSyntaxUID() {
		if (this.hasTransferSyntaxUIDElement()) {
			try {
				return this.getTransferSyntaxUIDElement().getSingleStringValue();
			} catch (Exception e) {
				logger.warn(e.getMessage());
				return "";
			}
		} else {
			return "";
		}
	}

	/**
	 * Retrun the Transfer Syntax UID
	 * 
	 * @return the Transfer Syntax UID
	 */
	public UniqueIdentifier getTransferSyntaxUIDElement() throws DicomException {
		return this.getUniqueIdentifier(DicomTags.TransferSyntaxUID);
	}

	public boolean hasImplementationClassUIDElement() {
		return this.hasElement(DicomTags.ImplementationClassUID);
	}

	/**
	 * @since 0.0.3
	 * @return
	 */
	public boolean hasImplementationVersionNameElement() {
		return this.hasElement(DicomTags.ImplementationVersionName);
	}

	// ------------ ImplementationVersionName -----------

	public boolean hasMediaStorageSOPClassUIDElement() {
		return this.hasElement(DicomTags.MediaStorageSOPClassUID);
	}

	public boolean hasMediaStorageSOPInstanceUIDElement() {
		return this.hasElement(DicomTags.MediaStorageSOPInstanceUID);
	}

	/**
	 * Return true is the DataSet have the PrivateInformationCreatorUID tag
	 * 
	 * @return true if tag present
	 */
	public boolean hasPrivateInformationCreatorUID() {
		return this.hasElement(DicomTags.PrivateInformationCreatorUID);
	}

	/**
	 * @since 0.0.3
	 * @return
	 */
	public boolean hasSourceApplicationEntityTitleElement() {
		return this.hasElement(DicomTags.SourceApplicationEntityTitle);
	}

	// ---------- SourceApplicationEntityTitle ----------

	/**
	 * Return true is the DataSet have the TransferSyntaxUID tag
	 * 
	 * @return true if the tag is present
	 */
	public boolean hasTransferSyntaxUIDElement() {
		return this.hasElement(DicomTags.TransferSyntaxUID);
	}

	public void setImplementationClassUID(String aImplementationClassUID) {
		logger.debug("setImplementationClassUID: " + aImplementationClassUID);
		try {
			if (!this.hasImplementationClassUIDElement()) {
				this.addElement(DataElements.newImplementationClassUID());
			}
			this.getImplementationClassUIDElement().setValue(aImplementationClassUID);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * @since 0.0.3
	 * @param aImplementationVersionName
	 */
	public void setImplementationVersionName(String aImplementationVersionName) {
		logger
		.debug("setImplementationVersionName: " + aImplementationVersionName);
		try {
			if (!this.hasImplementationVersionNameElement()) {
				this.addElement(DataElements.newImplementationVersionName());
			}
			this.getImplementationVersionNameElement().setValue(
					aImplementationVersionName);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void setMediaStorageSOPClassUID(String aMediaStorageSOPClass) {
		logger.debug("setMediaStorageSOPInstanceUID: " + aMediaStorageSOPClass);
		try {
			if (!this.hasMediaStorageSOPClassUIDElement()) {
				this.addElement(DataElements.newMediaStorageSOPClassUID());
			}
			this.getMediaStorageSOPClassUIDElement().setValue(aMediaStorageSOPClass);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public void setMediaStorageSOPInstanceUID(String aMediaStorageSOPInstanceUID) {
		logger.debug("setMediaStorageSOPInstanceUID: "
				+ aMediaStorageSOPInstanceUID);
		try {
			if (!this.hasMediaStorageSOPInstanceUIDElement()) {
				this.addElement(DataElements.newMediaStorageSOPInstanceUID());
			}
			this.getMediaStorageSOPInstanceUIDElement().setValue(
					aMediaStorageSOPInstanceUID);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * Set the value for the Dicom Premabule
	 * 
	 * @param aPreambule
	 * @throws DicomViolationException
	 */
	public void setPreambule(byte[] aPreambule) throws DicomViolationException {
		if (aPreambule.length != PREAMBLE_LENGTH) {
			throw new DicomViolationException("the premabule must have a length of "
					+ PREAMBLE_LENGTH + " bytes");
		}
		this.preamble = aPreambule;
	}

	/**
	 * @since 0.0.3
	 * @param aImplementationVersionName
	 */
	public void setSourceApplicationEntityTitle(
			String aSourceApplicationEntityTitle) {
		logger.debug("setSourceApplicationEntityTitle: "
				+ aSourceApplicationEntityTitle);
		try {
			if (!this.hasSourceApplicationEntityTitleElement()) {
				this.addElement(DataElements.newSourceApplicationEntityTitle());
			}
			this.getSourceApplicationEntityTitleElement().setValue(
					aSourceApplicationEntityTitle);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/*
	 * public String enhancedToString() { StringBuffer str = new StringBuffer();
	 * 
	 * Iterator i = fDataElements.values().iterator(); while (i.hasNext()) {
	 * DataElement lElement=(DataElement)i.next(); if (
	 * lElement.getTag().equals(DicomTags.TransferSyntaxUID) ) { TransferSyntax
	 * lTS=Dicom4jImplementation.Instance().getTransferSyntax(
	 * getTransferSyntaxUID() ); if ( lTS!= null ) { str.append(lTS.toString()); }
	 * else { str.append(lElement.toString()); } } else {
	 * str.append(lElement.toString()); } str.append("\n"); } return
	 * str.toString(); }
	 */

	public void setTransferSyntaxUID(String aTransferSyntaxUID) {
		logger.debug("setTransferSyntaxUID: " + aTransferSyntaxUID);
		try {
			if (!this.hasTransferSyntaxUIDElement()) {
				this.addElement(DataElements.newTransferSyntaxUID());
			}
			this.getTransferSyntaxUIDElement().setValue(aTransferSyntaxUID);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
