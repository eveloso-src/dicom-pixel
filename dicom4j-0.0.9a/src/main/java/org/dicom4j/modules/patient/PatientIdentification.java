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
package org.dicom4j.modules.patient;

import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.data.NoSuchElementException;
import org.dicom4j.data.WrongDataElementTypeException;
import org.dicom4j.data.elements.LongString;
import org.dicom4j.data.elements.PersonName;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.modules.AbstractModule;

/**
 * Patient Identification Module
 * 
 * <p>
 * (generated class, do not edit)
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class PatientIdentification extends AbstractModule {

	/**
	 * Creates a new module
	 * 
	 */
	public PatientIdentification() {
		super.addElement(DataElements.newPatientName());
		super.addElement(DataElements.newPatientID());
		super.addElement(DataElements.newIssuerOfPatientID());
		super.addElement(DataElements.newOtherPatientIDs());
		super.addElement(DataElements.newOtherPatientNames());
		super.addElement(DataElements.newPatientBirthName());
		super.addElement(DataElements.newPatientMotherBirthName());
		super.addElement(DataElements.newMedicalRecordLocator());
	}

	/**
	 * Creates a wrapper for data contains in the {@link DataSet DataSet}
	 * 
	 * Modify data with an instance of this class will modify also data of the
	 * DataSet, IT'S NOT A COPY
	 * 
	 * @param aDataSet
	 */
	public PatientIdentification(DataSet aDataSet) {
		super();
		this.addDataSet(aDataSet);
	}

	/**
	 * add all Module Elements if not present in the DataSet
	 */
	public void addElements() throws Exception {
		if (!this.hasPatientName()) {
			this.addElement(DataElements.newPatientName());
		}
		if (!this.hasPatientID()) {
			this.addElement(DataElements.newPatientID());
		}
		if (!this.hasIssuerOfPatientID()) {
			this.addElement(DataElements.newIssuerOfPatientID());
		}
		if (!this.hasOtherPatientIDs()) {
			this.addElement(DataElements.newOtherPatientIDs());
		}
		if (!this.hasOtherPatientNames()) {
			this.addElement(DataElements.newOtherPatientNames());
		}
		if (!this.hasPatientBirthName()) {
			this.addElement(DataElements.newPatientBirthName());
		}
		if (!this.hasPatientMotherBirthName()) {
			this.addElement(DataElements.newPatientMotherBirthName());
		}
		if (!this.hasMedicalRecordLocator()) {
			this.addElement(DataElements.newMedicalRecordLocator());
		}
	}

	/**
	 * Retrun the Issuer of Patient ID
	 * 
	 * @return the Issuer of Patient ID
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public LongString getIssuerOfPatientID() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getLongString(DicomTags.IssuerOfPatientID);
	}

	/**
	 * Retrun the Issuer of Patient ID or null if doesn't exits
	 * 
	 * @return the Issuer of Patient ID or null
	 */
	public LongString getIssuerOfPatientIDOrNull() {
		return this.getLongStringOrNull(DicomTags.IssuerOfPatientID);
	}

	/**
	 * Retrun the Medical Record Locator
	 * 
	 * @return the Medical Record Locator
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public LongString getMedicalRecordLocator() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getLongString(DicomTags.MedicalRecordLocator);
	}

	/**
	 * Retrun the Medical Record Locator or null if doesn't exits
	 * 
	 * @return the Medical Record Locator or null
	 */
	public LongString getMedicalRecordLocatorOrNull() {
		return this.getLongStringOrNull(DicomTags.MedicalRecordLocator);
	}

	@Override
	public String getName() {
		return "Patient Identification";
	}

	/**
	 * Retrun the Other Patient IDs
	 * 
	 * @return the Other Patient IDs
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public LongString getOtherPatientIDs() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getLongString(DicomTags.OtherPatientIDs);
	}

	/**
	 * Retrun the Other Patient IDs or null if doesn't exits
	 * 
	 * @return the Other Patient IDs or null
	 */
	public LongString getOtherPatientIDsOrNull() {
		return this.getLongStringOrNull(DicomTags.OtherPatientIDs);
	}

	/**
	 * Retrun the Other Patient Names
	 * 
	 * @return the Other Patient Names
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public PersonName getOtherPatientNames() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getPersonName(DicomTags.OtherPatientNames);
	}

	/**
	 * Retrun the Other Patient Names or null if doesn't exits
	 * 
	 * @return the Other Patient Names or null
	 */
	public PersonName getOtherPatientNamesOrNull() {
		return this.getPersonNameOrNull(DicomTags.OtherPatientNames);
	}

	/**
	 * Retrun the Patient's Birth Name
	 * 
	 * @return the Patient's Birth Name
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public PersonName getPatientBirthName() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getPersonName(DicomTags.PatientBirthName);
	}

	/**
	 * Retrun the Patient's Birth Name or null if doesn't exits
	 * 
	 * @return the Patient's Birth Name or null
	 */
	public PersonName getPatientBirthNameOrNull() {
		return this.getPersonNameOrNull(DicomTags.PatientBirthName);
	}

	/**
	 * Retrun the Patient ID
	 * 
	 * @return the Patient ID
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public LongString getPatientID() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getLongString(DicomTags.PatientID);
	}

	/**
	 * Retrun the Patient ID or null if doesn't exits
	 * 
	 * @return the Patient ID or null
	 */
	public LongString getPatientIDOrNull() {
		return this.getLongStringOrNull(DicomTags.PatientID);
	}

	/**
	 * Retrun the Patient's Mother's Birth Name
	 * 
	 * @return the Patient's Mother's Birth Name
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public PersonName getPatientMotherBirthName() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getPersonName(DicomTags.PatientMotherBirthName);
	}

	/**
	 * Retrun the Patient's Mother's Birth Name or null if doesn't exits
	 * 
	 * @return the Patient's Mother's Birth Name or null
	 */
	public PersonName getPatientMotherBirthNameOrNull() {
		return this.getPersonNameOrNull(DicomTags.PatientMotherBirthName);
	}

	/**
	 * Retrun the Patient's Name
	 * 
	 * @return the Patient's Name
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public PersonName getPatientName() throws NoSuchElementException,
	WrongDataElementTypeException {
		return this.getPersonName(DicomTags.PatientName);
	}

	/**
	 * Retrun the Patient's Name or null if doesn't exits
	 * 
	 * @return the Patient's Name or null
	 */
	public PersonName getPatientNameOrNull() {
		return this.getPersonNameOrNull(DicomTags.PatientName);
	}

	/**
	 * return true if the module has the Issuer of Patient ID element
	 * 
	 * @return true if present
	 */
	public boolean hasIssuerOfPatientID() {
		return this.hasElement(DicomTags.IssuerOfPatientID);
	}

	/**
	 * return true if the module has the Medical Record Locator element
	 * 
	 * @return true if present
	 */
	public boolean hasMedicalRecordLocator() {
		return this.hasElement(DicomTags.MedicalRecordLocator);
	}

	/**
	 * return true if the module has the Other Patient IDs element
	 * 
	 * @return true if present
	 */
	public boolean hasOtherPatientIDs() {
		return this.hasElement(DicomTags.OtherPatientIDs);
	}

	/**
	 * return true if the module has the Other Patient Names element
	 * 
	 * @return true if present
	 */
	public boolean hasOtherPatientNames() {
		return this.hasElement(DicomTags.OtherPatientNames);
	}

	/**
	 * return true if the module has the Patient's Birth Name element
	 * 
	 * @return true if present
	 */
	public boolean hasPatientBirthName() {
		return this.hasElement(DicomTags.PatientBirthName);
	}

	/**
	 * return true if the module has the Patient ID element
	 * 
	 * @return true if present
	 */
	public boolean hasPatientID() {
		return this.hasElement(DicomTags.PatientID);
	}

	/**
	 * return true if the module has the Patient's Mother's Birth Name element
	 * 
	 * @return true if present
	 */
	public boolean hasPatientMotherBirthName() {
		return this.hasElement(DicomTags.PatientMotherBirthName);
	}

	/**
	 * return true if the module has the Patient's Name element
	 * 
	 * @return true if present
	 */
	public boolean hasPatientName() {
		return this.hasElement(DicomTags.PatientName);
	}

}