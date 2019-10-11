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
 */
// generated class, do not edit
package org.dicom4j.modules.media;

import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.data.NoSuchElementException;
import org.dicom4j.data.WrongDataElementTypeException;
import org.dicom4j.data.elements.ApplicationEntity;
import org.dicom4j.data.elements.OtherByteString;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.UnsignedLong;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.modules.AbstractModule;

/**
 * <p>
 * File Meta Information Module
 * </p>
 * 
 * @since 0.0.8
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class FileMetaInformation extends AbstractModule {

	/**
	 * Creates a new module
	 * 
	 */
	public FileMetaInformation() {
		this.addModuleElements();
		/*
		 * super.addElement(DataElements.newFileMetaInformationGroupLength());
		 * super.addElement(DataElements.newFileMetaInformationVersion());
		 * super.addElement(DataElements.newMediaStorageSOPClassUID());
		 * super.addElement(DataElements.newMediaStorageSOPInstanceUID());
		 * super.addElement(DataElements.newTransferSyntaxUID());
		 * super.addElement(DataElements.newImplementationClassUID());
		 * super.addElement(DataElements.newSourceApplicationEntityTitle());
		 * super.addElement(DataElements.newPrivateInformationCreatorUID());
		 * super.addElement(DataElements.newPrivateInformation());
		 */
	}

	/**
	 * Creates a wrapper for data contains in the {@link DataSet DataSet}
	 * 
	 * Modify data with an instance of this class will modify also data of the
	 * DataSet, IT'S NOT A COPY
	 * 
	 * @param aDataSet
	 */
	public FileMetaInformation(DataSet aDataSet) {
		super();
		this.addDataSet(aDataSet);
	}

	/**
	 * add all Module Elements if not present in the DataSet
	 */
	public void addElements() throws Exception {
		if (!this.hasFileMetaInformationGroupLength()) {
			this.addElement(DataElements.newFileMetaInformationGroupLength());
		}
		if (!this.hasFileMetaInformationVersion()) {
			this.addElement(DataElements.newFileMetaInformationVersion());
		}
		if (!this.hasMediaStorageSOPClassUID()) {
			this.addElement(DataElements.newMediaStorageSOPClassUID());
		}
		if (!this.hasMediaStorageSOPInstanceUID()) {
			this.addElement(DataElements.newMediaStorageSOPInstanceUID());
		}
		if (!this.hasTransferSyntaxUID()) {
			this.addElement(DataElements.newTransferSyntaxUID());
		}
		if (!this.hasImplementationClassUID()) {
			this.addElement(DataElements.newImplementationClassUID());
		}
		if (!this.hasSourceApplicationEntityTitle()) {
			this.addElement(DataElements.newSourceApplicationEntityTitle());
		}
		if (!this.hasPrivateInformationCreatorUID()) {
			this.addElement(DataElements.newPrivateInformationCreatorUID());
		}
		if (!this.hasPrivateInformation()) {
			this.addElement(DataElements.newPrivateInformation());
		}
	}

	@Override
	public void addModuleElements() {
		super.addElement(DataElements.newFileMetaInformationGroupLength());
		super.addElement(DataElements.newFileMetaInformationVersion());
		super.addElement(DataElements.newMediaStorageSOPClassUID());
		super.addElement(DataElements.newMediaStorageSOPInstanceUID());
		super.addElement(DataElements.newTransferSyntaxUID());
		super.addElement(DataElements.newImplementationClassUID());
		super.addElement(DataElements.newSourceApplicationEntityTitle());
		super.addElement(DataElements.newPrivateInformationCreatorUID());
		super.addElement(DataElements.newPrivateInformation());
	}

	/**
	 * Retrun the File Meta Information Group Length
	 * 
	 * @return the File Meta Information Group Length
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public UnsignedLong getFileMetaInformationGroupLength()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this.getUnsignedLong(DicomTags.FileMetaInformationGroupLength);
	}

	/**
	 * Retrun the File Meta Information Group Length or null if doesn't exits
	 * 
	 * @return the File Meta Information Group Length or null
	 */
	public UnsignedLong getFileMetaInformationGroupLengthOrNull() {
		return this.getUnsignedLongOrNull(DicomTags.FileMetaInformationGroupLength);
	}

	/**
	 * Retrun the File Meta Information Version
	 * 
	 * @return the File Meta Information Version
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public OtherByteString getFileMetaInformationVersion()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this.getOtherByteString(DicomTags.FileMetaInformationVersion);
	}

	/**
	 * Retrun the File Meta Information Version or null if doesn't exits
	 * 
	 * @return the File Meta Information Version or null
	 */
	public OtherByteString getFileMetaInformationVersionOrNull() {
		return this.getOtherByteStringOrNull(DicomTags.FileMetaInformationVersion);
	}

	/**
	 * Retrun the Implementation Class UID
	 * 
	 * @return the Implementation Class UID
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public UniqueIdentifier getImplementationClassUID()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this.getUniqueIdentifier(DicomTags.ImplementationClassUID);
	}

	/**
	 * Retrun the Implementation Class UID or null if doesn't exits
	 * 
	 * @return the Implementation Class UID or null
	 */
	public UniqueIdentifier getImplementationClassUIDOrNull() {
		return this.getUniqueIdentifierOrNull(DicomTags.ImplementationClassUID);
	}

	/**
	 * Retrun the Media Storage SOP Class UID
	 * 
	 * @return the Media Storage SOP Class UID
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public UniqueIdentifier getMediaStorageSOPClassUID()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this.getUniqueIdentifier(DicomTags.MediaStorageSOPClassUID);
	}

	/**
	 * Retrun the Media Storage SOP Class UID or null if doesn't exits
	 * 
	 * @return the Media Storage SOP Class UID or null
	 */
	public UniqueIdentifier getMediaStorageSOPClassUIDOrNull() {
		return this.getUniqueIdentifierOrNull(DicomTags.MediaStorageSOPClassUID);
	}

	/**
	 * Retrun the Media Storage SOP Instance UID
	 * 
	 * @return the Media Storage SOP Instance UID
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public UniqueIdentifier getMediaStorageSOPInstanceUID()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this.getUniqueIdentifier(DicomTags.MediaStorageSOPInstanceUID);
	}

	/**
	 * Retrun the Media Storage SOP Instance UID or null if doesn't exits
	 * 
	 * @return the Media Storage SOP Instance UID or null
	 */
	public UniqueIdentifier getMediaStorageSOPInstanceUIDOrNull() {
		return this.getUniqueIdentifierOrNull(DicomTags.MediaStorageSOPInstanceUID);
	}

	@Override
	public String getName() {
		return "File Meta Information";
	}

	/**
	 * Retrun the Private Information
	 * 
	 * @return the Private Information
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public OtherByteString getPrivateInformation() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getOtherByteString(DicomTags.PrivateInformation);
	}

	/**
	 * Retrun the Private Information Creator UID
	 * 
	 * @return the Private Information Creator UID
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public UniqueIdentifier getPrivateInformationCreatorUID()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this.getUniqueIdentifier(DicomTags.PrivateInformationCreatorUID);
	}

	/**
	 * Retrun the Private Information Creator UID or null if doesn't exits
	 * 
	 * @return the Private Information Creator UID or null
	 */
	public UniqueIdentifier getPrivateInformationCreatorUIDOrNull() {
		return this
		.getUniqueIdentifierOrNull(DicomTags.PrivateInformationCreatorUID);
	}

	/**
	 * Retrun the Private Information or null if doesn't exits
	 * 
	 * @return the Private Information or null
	 */
	public OtherByteString getPrivateInformationOrNull() {
		return this.getOtherByteStringOrNull(DicomTags.PrivateInformation);
	}

	/**
	 * Retrun the Source Application Entity Title
	 * 
	 * @return the Source Application Entity Title
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public ApplicationEntity getSourceApplicationEntityTitle()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this.getApplicationEntity(DicomTags.SourceApplicationEntityTitle);
	}

	/**
	 * Retrun the Source Application Entity Title or null if doesn't exits
	 * 
	 * @return the Source Application Entity Title or null
	 */
	public ApplicationEntity getSourceApplicationEntityTitleOrNull() {
		return this
		.getApplicationEntityOrNull(DicomTags.SourceApplicationEntityTitle);
	}

	/**
	 * Retrun the Transfer Syntax UID
	 * 
	 * @return the Transfer Syntax UID
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public UniqueIdentifier getTransferSyntaxUID() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getUniqueIdentifier(DicomTags.TransferSyntaxUID);
	}

	/**
	 * Retrun the Transfer Syntax UID or null if doesn't exits
	 * 
	 * @return the Transfer Syntax UID or null
	 */
	public UniqueIdentifier getTransferSyntaxUIDOrNull() {
		return this.getUniqueIdentifierOrNull(DicomTags.TransferSyntaxUID);
	}

	/**
	 * return true if the module has the File Meta Information Group Length
	 * element
	 * 
	 * @return true if present
	 */
	public boolean hasFileMetaInformationGroupLength() {
		return this.hasElement(DicomTags.FileMetaInformationGroupLength);
	}

	/**
	 * return true if the module has the File Meta Information Version element
	 * 
	 * @return true if present
	 */
	public boolean hasFileMetaInformationVersion() {
		return this.hasElement(DicomTags.FileMetaInformationVersion);
	}

	/**
	 * return true if the module has the Implementation Class UID element
	 * 
	 * @return true if present
	 */
	public boolean hasImplementationClassUID() {
		return this.hasElement(DicomTags.ImplementationClassUID);
	}

	/**
	 * return true if the module has the Media Storage SOP Class UID element
	 * 
	 * @return true if present
	 */
	public boolean hasMediaStorageSOPClassUID() {
		return this.hasElement(DicomTags.MediaStorageSOPClassUID);
	}

	/**
	 * return true if the module has the Media Storage SOP Instance UID element
	 * 
	 * @return true if present
	 */
	public boolean hasMediaStorageSOPInstanceUID() {
		return this.hasElement(DicomTags.MediaStorageSOPInstanceUID);
	}

	/**
	 * return true if the module has the Private Information element
	 * 
	 * @return true if present
	 */
	public boolean hasPrivateInformation() {
		return this.hasElement(DicomTags.PrivateInformation);
	}

	/**
	 * return true if the module has the Private Information Creator UID element
	 * 
	 * @return true if present
	 */
	public boolean hasPrivateInformationCreatorUID() {
		return this.hasElement(DicomTags.PrivateInformationCreatorUID);
	}

	/**
	 * return true if the module has the Source Application Entity Title element
	 * 
	 * @return true if present
	 */
	public boolean hasSourceApplicationEntityTitle() {
		return this.hasElement(DicomTags.SourceApplicationEntityTitle);
	}

	/**
	 * return true if the module has the Transfer Syntax UID element
	 * 
	 * @return true if present
	 */
	public boolean hasTransferSyntaxUID() {
		return this.hasElement(DicomTags.TransferSyntaxUID);
	}

}