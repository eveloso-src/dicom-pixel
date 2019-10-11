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
package org.dicom4j.modules.study;

import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.data.NoSuchElementException;
import org.dicom4j.data.WrongDataElementTypeException;
import org.dicom4j.data.elements.LongText;
import org.dicom4j.data.elements.PersonName;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.modules.AbstractModule;

/**
 * Imaging Service Request Module
 * 
 * <p>
 * (generated class, do not edit)
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ImagingServiceRequest extends AbstractModule {

	/**
	 * Creates a new module
	 * 
	 */
	public ImagingServiceRequest() {
		super.addElement(DataElements.newImagingServiceRequestComments());
		super.addElement(DataElements.newRequestingPhysician());
		super.addElement(DataElements.newRequestingPhysicianIdentificationSeq());
		super.addElement(DataElements.newReferringPhysicianName());
		super.addElement(DataElements.newReferringPhysicianIdentificationSeq());
	}

	/**
	 * Creates a wrapper for data contains in the {@link DataSet DataSet}
	 * 
	 * Modify data with an instance of this class will modify also data of the
	 * DataSet, IT'S NOT A COPY
	 * 
	 * @param aDataSet
	 */
	public ImagingServiceRequest(DataSet aDataSet) {
		super();
		this.addDataSet(aDataSet);
	}

	/**
	 * add all Module Elements if not present in the DataSet
	 */
	public void addElements() throws Exception {
		if (!this.hasImagingServiceRequestComments()) {
			this.addElement(DataElements.newImagingServiceRequestComments());
		}
		if (!this.hasRequestingPhysician()) {
			this.addElement(DataElements.newRequestingPhysician());
		}
		if (!this.hasRequestingPhysicianIdentificationSeq()) {
			this.addElement(DataElements.newRequestingPhysicianIdentificationSeq());
		}
		if (!this.hasReferringPhysicianName()) {
			this.addElement(DataElements.newReferringPhysicianName());
		}
		if (!this.hasReferringPhysicianIdentificationSeq()) {
			this.addElement(DataElements.newReferringPhysicianIdentificationSeq());
		}
	}

	/**
	 * Retrun the Imaging Service Request Comments
	 * 
	 * @return the Imaging Service Request Comments
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public LongText getImagingServiceRequestComments()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this.getLongText(DicomTags.ImagingServiceRequestComments);
	}

	/**
	 * Retrun the Imaging Service Request Comments or null if doesn't exits
	 * 
	 * @return the Imaging Service Request Comments or null
	 */
	public LongText getImagingServiceRequestCommentsOrNull() {
		return this.getLongTextOrNull(DicomTags.ImagingServiceRequestComments);
	}

	@Override
	public String getName() {
		return "Imaging Service Request";
	}

	/**
	 * Retrun the Referring Physician Identification Sequence
	 * 
	 * @return the Referring Physician Identification Sequence
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public SequenceOfItems getReferringPhysicianIdentificationSeq()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this
		.getSequenceOfItems(DicomTags.ReferringPhysicianIdentificationSeq);
	}

	/**
	 * Retrun the Referring Physician Identification Sequence or null if doesn't
	 * exits
	 * 
	 * @return the Referring Physician Identification Sequence or null
	 */
	public SequenceOfItems getReferringPhysicianIdentificationSeqOrNull() {
		return this
		.getSequenceOfItemsOrNull(DicomTags.ReferringPhysicianIdentificationSeq);
	}

	/**
	 * Retrun the Referring Physician's Name
	 * 
	 * @return the Referring Physician's Name
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public PersonName getReferringPhysicianName() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getPersonName(DicomTags.ReferringPhysicianName);
	}

	/**
	 * Retrun the Referring Physician's Name or null if doesn't exits
	 * 
	 * @return the Referring Physician's Name or null
	 */
	public PersonName getReferringPhysicianNameOrNull() {
		return this.getPersonNameOrNull(DicomTags.ReferringPhysicianName);
	}

	/**
	 * Retrun the Requesting Physician
	 * 
	 * @return the Requesting Physician
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public PersonName getRequestingPhysician() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getPersonName(DicomTags.RequestingPhysician);
	}

	/**
	 * Retrun the Requesting Physician Identification Sequence
	 * 
	 * @return the Requesting Physician Identification Sequence
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public SequenceOfItems getRequestingPhysicianIdentificationSeq()
	throws NoSuchElementException, WrongDataElementTypeException {
		return this
		.getSequenceOfItems(DicomTags.RequestingPhysicianIdentificationSeq);
	}

	/**
	 * Retrun the Requesting Physician Identification Sequence or null if doesn't
	 * exits
	 * 
	 * @return the Requesting Physician Identification Sequence or null
	 */
	public SequenceOfItems getRequestingPhysicianIdentificationSeqOrNull() {
		return this
		.getSequenceOfItemsOrNull(DicomTags.RequestingPhysicianIdentificationSeq);
	}

	/**
	 * Retrun the Requesting Physician or null if doesn't exits
	 * 
	 * @return the Requesting Physician or null
	 */
	public PersonName getRequestingPhysicianOrNull() {
		return this.getPersonNameOrNull(DicomTags.RequestingPhysician);
	}

	/**
	 * return true if the module has the Imaging Service Request Comments element
	 * 
	 * @return true if present
	 */
	public boolean hasImagingServiceRequestComments() {
		return this.hasElement(DicomTags.ImagingServiceRequestComments);
	}

	/**
	 * return true if the module has the Referring Physician Identification
	 * Sequence element
	 * 
	 * @return true if present
	 */
	public boolean hasReferringPhysicianIdentificationSeq() {
		return this.hasElement(DicomTags.ReferringPhysicianIdentificationSeq);
	}

	/**
	 * return true if the module has the Referring Physician's Name element
	 * 
	 * @return true if present
	 */
	public boolean hasReferringPhysicianName() {
		return this.hasElement(DicomTags.ReferringPhysicianName);
	}

	/**
	 * return true if the module has the Requesting Physician element
	 * 
	 * @return true if present
	 */
	public boolean hasRequestingPhysician() {
		return this.hasElement(DicomTags.RequestingPhysician);
	}

	/**
	 * return true if the module has the Requesting Physician Identification
	 * Sequence element
	 * 
	 * @return true if present
	 */
	public boolean hasRequestingPhysicianIdentificationSeq() {
		return this.hasElement(DicomTags.RequestingPhysicianIdentificationSeq);
	}

}