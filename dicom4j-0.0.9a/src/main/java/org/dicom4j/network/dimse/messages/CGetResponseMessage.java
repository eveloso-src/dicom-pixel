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

/**
 * 
 */
package org.dicom4j.network.dimse.messages;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.CommandSetType;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.network.dimse.DimseException;
import org.dicom4j.network.dimse.ElementNotFoundException;
import org.dicom4j.network.dimse.messages.support.DimseResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * C-Get Response message
 * 
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CGetResponseMessage extends DimseResponseMessage {

	private static final Logger logger = LoggerFactory.getLogger(CGetResponseMessage.class);

	private static final long serialVersionUID = 1L;

	/**
	 * @param commandSet
	 */
	public CGetResponseMessage(CommandSet commandSet) {
		super(commandSet);
	}

	/**
	 * @param messageID
	 * @param affectedSOPClassUID
	 * @throws DicomException
	 */
	public CGetResponseMessage(int messageID, String affectedSOPClassUID)
	throws DicomException {
		super(messageID, affectedSOPClassUID);
		this.setMessagetype();
	}

	public CGetResponseMessage(int messageID, String affectedSOPClassUID,	int status) throws DicomException {
		super(messageID, affectedSOPClassUID, CommandSet.NO_DATASET, status);
		this.setMessagetype();
	}

	/**
	 * @param messageID
	 * @param affectedSOPClassUID
	 * @param aHasDataset
	 * @param status
	 * @throws DicomException
	 */
	public CGetResponseMessage(int messageID, String affectedSOPClassUID,	int aHasDataset, int status) throws DicomException {
		super(messageID, affectedSOPClassUID, aHasDataset, status);
	}

	@Override
	protected void fillCommandSet(CommandSet commandSet) {
		commandSet.addElement(DataElements.newMessageIDBeingRespondedTo());
		commandSet.addElement(DataElements.newStatus());
		commandSet.addElement(DataElements.newAffectedSOPClassUID());
		commandSet.addElement(DataElements.newErrorComment());
		commandSet.addElement(DataElements.newNumberOfRemainingSubOperations());
		commandSet.addElement(DataElements.newNumberOfCompletedSubOperations());
		commandSet.addElement(DataElements.newNumberOfFailedSubOperations());
		commandSet.addElement(DataElements.newNumberOfWarningSubOperations());
	}

	/**
	 * return the Number Of Completed Sub Operations
	 * 
	 * @return the value
	 * @throws DicomException
	 * @throws ElementNotFoundException
	 *           occurs when the element can't be found in the message
	 */
	public int getNumberOfCompletedSubOperations() throws DicomException,
	ElementNotFoundException {
		if (this.hasNumberOfCompletedSubOperationsElement()) {
			return this.getNumberOfCompletedSubOperationsElement().getSingleIntegerValue();
		} else {
			throw new ElementNotFoundException(this,
					DicomTags.NumberOfCompletedSubOperations);
		}
	}

	public UnsignedShort getNumberOfCompletedSubOperationsElement()
	throws DicomException {
		return this.getCommandSet().getUnsignedShort(
				DicomTags.NumberOfCompletedSubOperations);
	}

	/**
	 * return the Number Of Failed Sub Operations
	 * 
	 * @return the value
	 * @throws DicomException
	 * @throws ElementNotFoundException
	 *           occurs when the element can't be found in the message
	 */
	public int getNumberOfFailedSubOperations() throws DicomException, ElementNotFoundException {
		if (this.hasNumberOfFailedSubOperationsElement()) {
			return this.getNumberOfFailedSubOperationsElement().getSingleIntegerValue();
		} else {
			throw new ElementNotFoundException(this,
					DicomTags.NumberOfFailedSubOperations);
		}
	}

	public UnsignedShort getNumberOfFailedSubOperationsElement()
	throws DicomException {
		return this.getCommandSet().getUnsignedShort(
				DicomTags.NumberOfFailedSubOperations);
	}

	/**
	 * return the Number Of Remaining Sub Operations
	 * 
	 * @return the value
	 * @throws DicomException
	 * @throws ElementNotFoundException
	 *           occurs when the element can't be found in the message
	 */
	public int getNumberOfRemainingSubOperations() throws DicomException, ElementNotFoundException {
		if (this.hasNumberOfRemainingSubOperationsElement()) {
			return this.getNumberOfRemainingSubOperationsElement().getSingleIntegerValue();
		} else {
			throw new ElementNotFoundException(this,
					DicomTags.NumberOfRemainingSubOperations);
		}
	}

	public UnsignedShort getNumberOfRemainingSubOperationsElement()	throws DicomException {
		return this.getCommandSet().getUnsignedShort(
				DicomTags.NumberOfRemainingSubOperations);
	}

	/**
	 * return the Number Of Warning Sub Operations
	 * 
	 * @return the value
	 * @throws DicomException
	 * @throws ElementNotFoundException
	 *           occurs when the element can't be found in the message
	 */
	public int getNumberOfWarningSubOperations() throws DicomException,	ElementNotFoundException {
		if (this.hasNumberOfWarningSubOperationsElement()) {
			return this.getNumberOfWarningSubOperationsElement().getSingleIntegerValue();
		} else {
			throw new ElementNotFoundException(this, DicomTags.NumberOfWarningSubOperations);
		}
	}

	public UnsignedShort getNumberOfWarningSubOperationsElement() throws DicomException {
		return this.getCommandSet().getUnsignedShort(DicomTags.NumberOfWarningSubOperations);
	}

	/**
	 * return true if the NumberOfCompletedSubOperations element isin the message
	 * 
	 * @return true if present
	 */
	public boolean hasNumberOfCompletedSubOperationsElement() {
		return this.getCommandSet().hasElement(DicomTags.NumberOfCompletedSubOperations);
	}

	/**
	 * return true if the NumberOfFailedSubOperations element isin the message
	 * 
	 * @return true if present
	 */
	public boolean hasNumberOfFailedSubOperationsElement() {
		return this.getCommandSet().hasElement(DicomTags.NumberOfFailedSubOperations);
	}

	/**
	 * return true if the NumberOfRemainingSubOperations element isin the message
	 * 
	 * @return true if present
	 */
	public boolean hasNumberOfRemainingSubOperationsElement() {
		return this.getCommandSet().hasElement(
				DicomTags.NumberOfRemainingSubOperations);
	}

	/**
	 * return true if the NumberOfWarningSubOperations element isin the message
	 * 
	 * @return true if present
	 */
	public boolean hasNumberOfWarningSubOperationsElement() {
		return this.getCommandSet().hasElement(
				DicomTags.NumberOfWarningSubOperations);
	}

	@Override
	protected void setMessagetype() throws DicomException {
		this.setCommandField(CommandSetType.C_GET_RESPONSE.value());
	}

	/**
	 * set the NumberOfCompletedSubOperations (add the element if not in the
	 * CommandSet)
	 * 
	 * @param number
	 *          the number
	 * @throws DicomException
	 * @throws DimseException
	 */
	public void setNumberOfCompletedSubOperations(int number)
	throws DicomException, DimseException {
		logger.info("setNumberOfCompletedSubOperations: " + number);
		this.setorAddUnsignedShort(DicomTags.NumberOfCompletedSubOperations, number);
	}

	/**
	 * set the NumberOfFailedSubOperations (add the element if not in the
	 * CommandSet)
	 * 
	 * @param number
	 *          the number
	 * @throws DicomException
	 * @throws DimseException
	 */
	public void setNumberOfFailedSubOperations(int number) throws DicomException,
	DimseException {
		logger.info("setNumberOfFailedSubOperations: " + number);
		this.setorAddUnsignedShort(DicomTags.NumberOfFailedSubOperations, number);
	}

	/**
	 * set the NumberOfRemainingSubOperations (add the element if not in the
	 * CommandSet)
	 * 
	 * @param number
	 *          the number
	 * @throws DicomException
	 * @throws DimseException
	 */
	public void setNumberOfRemainingSubOperations(int number)
	throws DicomException, DimseException {
		logger.info("setNumberOfRemainingSubOperations: " + number);
		this.setorAddUnsignedShort(DicomTags.NumberOfRemainingSubOperations, number);
	}

	/**
	 * set the NumberOfWarningSubOperations (add the element if not in the
	 * CommandSet)
	 * 
	 * @param number
	 * @throws DicomException
	 * @throws DimseException
	 */
	public void setNumberOfWarningSubOperations(int number)
	throws DicomException, DimseException {
		logger.info("setNumberOfWarningSubOperations: " + number);
		this.setorAddUnsignedShort(DicomTags.NumberOfWarningSubOperations, number);
	}
	
	public CommandSetType getMessagetype() {
		return CommandSetType.C_GET_RESPONSE;
	}

}
