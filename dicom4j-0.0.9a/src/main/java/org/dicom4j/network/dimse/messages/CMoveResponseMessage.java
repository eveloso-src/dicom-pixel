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

package org.dicom4j.network.dimse.messages;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.CommandSetType;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.network.dimse.DimsePriority;
import org.dicom4j.dicom.uniqueidentifiers.SOPClasses;
import org.dicom4j.network.dimse.DimseException;
import org.dicom4j.network.dimse.messages.support.DimseResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * C-MOVE-RSP
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CMoveResponseMessage extends DimseResponseMessage {

	private static final Logger fLogger = LoggerFactory
	.getLogger(CMoveResponseMessage.class);

	/**
	 * Creates a new message from a {@link CommandSet CommandSet}
	 * 
	 * @param aCommandSet
	 *          the CommandSet
	 */
	public CMoveResponseMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	/**
	 * Creates a new message
	 * 
	 * @param aMessageID
	 * @param aAffectedSOPClassUID
	 * @throws DicomException
	 */
	public CMoveResponseMessage(int aMessageID, String aAffectedSOPClassUID)
	throws DicomException {
		this(aMessageID, aAffectedSOPClassUID, DimsePriority.MEDIUM.value());
	}

	/**
	 * Creates a new message
	 * 
	 * @param aMessageID
	 * @param aAffectedSOPClassUID
	 * @param aPriority
	 * @throws DicomException
	 */
	public CMoveResponseMessage(int aMessageID, String aAffectedSOPClassUID,
			int aPriority) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		this.setCommandField(CommandSetType.C_MOVE_RESPONSE.value());
		this.setDataSetType(CommandSet.HAS_DATASET);
		// setPriority(aPriority);
	}

	public CMoveResponseMessage(int aMessageID, String aAffectedSOPClassUID,
			int aHasDataset, int aStatus) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID, aHasDataset, aStatus);
		this.setCommandField(CommandSetType.C_MOVE_RESPONSE.value());
	}

	@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = super.createCommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(DataElements.newNumberOfRemainingSubOperations());
		lCommandSet.addElement(DataElements.newNumberOfCompletedSubOperations());
		lCommandSet.addElement(DataElements.newNumberOfFailedSubOperations());
		lCommandSet.addElement(DataElements.newNumberOfWarningSubOperations());
		return lCommandSet;
	}

	public UnsignedShort getNumberOfRemainingSubOperationsElement()
	throws DicomException {
		return this.getCommandSet().getUnsignedShort(
				DicomTags.NumberOfRemainingSubOperations);
	}

	public boolean hasNumberOfCompletedSubOperations() {
		return this.getCommandSet().hasElement(
				DicomTags.NumberOfCompletedSubOperations);
	}

	public boolean hasNumberOfFailedSubOperations() {
		return this.getCommandSet().hasElement(
				DicomTags.NumberOfFailedSubOperations);
	}

	public boolean hasNumberOfRemainingSubOperations() {
		return this.getCommandSet().hasElement(
				DicomTags.NumberOfRemainingSubOperations);
	}

	public boolean hasNumberOfWarningSubOperations() {
		return this.getCommandSet().hasElement(
				DicomTags.NumberOfWarningSubOperations);
	}

	@Override
	public void setMessagetype() throws DicomException {
		this.setCommandField(CommandSetType.C_MOVE_RESPONSE.value());
	}

	public void setNumberOfCompletedSubOperations(int aNumber)
	throws DicomException, DimseException {
		fLogger.debug("setNumberOfCompletedSubOperations: " + aNumber);
		if (this.hasNumberOfFailedSubOperations()) {
			this.getCommandSet().getUnsignedShort(
					DicomTags.NumberOfCompletedSubOperations).setValue(aNumber);
		} else {
			fLogger.warn("NO NumberOfCompletedSubOperations");
		}
	}

	public void setNumberOfFailedSubOperations(int aNumber)
	throws DicomException, DimseException {
		fLogger.debug("setNumberOfFailedSubOperations: " + aNumber);
		if (this.hasNumberOfCompletedSubOperations()) {
			this.getCommandSet().getUnsignedShort(
					DicomTags.NumberOfFailedSubOperations).setValue(aNumber);
		} else {
			fLogger.warn("NO NumberOfFailedSubOperations");
		}
	}

	/**
	 * set the NumberOfRemainingSubOperations (add the element if not present in
	 * the CommandSet)
	 * 
	 * @param aNumber
	 *          the number
	 * @throws DicomException
	 * @throws DimseException
	 */
	public void setNumberOfRemainingSubOperations(int aNumber)
	throws DicomException, DimseException {
		fLogger.debug("setNumberOfRemainingSubOperations: " + aNumber);
		if (!this.hasNumberOfRemainingSubOperations()) {
			fLogger
			.debug("No NumberOfRemainingSubOperations in CommandSet, we add it");
			this.getCommandSet().addElement(
					DataElements.newNumberOfRemainingSubOperations());
		}
		this.getNumberOfRemainingSubOperationsElement().setValue(aNumber);
	}

	public void setNumberOfWarningSubOperations(int aNumber)
	throws DicomException, DimseException {
		fLogger.debug("setNumberOfWarningSubOperations: " + aNumber);
		if (this.hasNumberOfCompletedSubOperations()) {
			this.getCommandSet().getUnsignedShort(
					DicomTags.NumberOfWarningSubOperations).setValue(aNumber);
		} else {
			fLogger.warn("NO NumberOfWarningSubOperations");
		}
	}

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		if (this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID)) {
			lBuffer.append("  SOPClass: "
					+ SOPClasses.toString(this.getAffectedSOPClassUID()) + "\n");
		} else {
			fLogger.warn("No AffectedSOPClassUID");
		}
		lBuffer.append("  Status: " + this.statusToString() + "\n");
		if (this.getDataSet() != null) {
			lBuffer.append("DataSet: \n");
			lBuffer.append(this.getDataSet().toString());
		}
		return lBuffer.toString();
	}
	
	public CommandSetType getMessagetype() {
		return CommandSetType.C_MOVE_RESPONSE;
	}

}
