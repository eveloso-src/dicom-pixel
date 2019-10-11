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

package org.dicom4j.network.dimse.messages.support;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.LongString;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.network.dimse.DimseStatus;
import org.dicom4j.network.dimse.DimseConst;
import org.dicom4j.network.dimse.DimseException;
import org.dicom4j.network.dimse.ElementNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract dimse response message
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class DimseResponseMessage extends DimseMessageWithAffectedSOPClass {

	private static final Logger logger = LoggerFactory.getLogger(DimseResponseMessage.class);

	/**
	 * create a new message from a {@link CommandSet}
	 * 
	 * @param commandSet
	 */
	public DimseResponseMessage(CommandSet commandSet) {
		super(commandSet);
	}

	public DimseResponseMessage(int messageID) throws DicomException {
		super();
		setMessageID( messageID );
		setStatus( DimseStatus.Success.value() );
	}
	
	public DimseResponseMessage(int messageID, String aAffectedSOPClassUID) throws DicomException {
		this(messageID, aAffectedSOPClassUID, DimseStatus.Success.value());
	}

	public DimseResponseMessage(int messageID, String affectedSOPClassUID,
			int status) throws DicomException {
		this(messageID, affectedSOPClassUID, CommandSet.NO_DATASET, status);
	}

	public DimseResponseMessage(int messageID, String aAffectedSOPClassUID,
			int aHasDataset, int status) throws DicomException {
		super(messageID, aAffectedSOPClassUID);
		this.setDataSetType(aHasDataset);
		this.setStatus(status);
	}

	protected void addErrorCommentElement() {
		this.getCommandSet().addElement(DataElements.newErrorComment());
	}

	/*@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = new CommandSet();
		assert lCommandSet != null;
		//this.fillCommandSet(lCommandSet);
		return lCommandSet;
	}*/

	@Override
	protected void fillCommandSet(CommandSet commandSet) throws DicomException {
		super.fillCommandSet( commandSet );
		commandSet.addElement(DataElements.newMessageIDBeingRespondedTo());
		commandSet.addElement(DataElements.newStatus());
		//commandSet.addElement(DataElements.newAffectedSOPClassUID());
		commandSet.addElement(DataElements.newErrorComment());
	}

	public String getAffectedSOPInstanceUID() throws DicomException,
	ElementNotFoundException {
		if (this.hasAffectedSOPClassUIDElement()) {
			return this.getAffectedSOPInstanceUIDElement().getSingleStringValue();
		} else {
			throw new ElementNotFoundException(this, DicomTags.AffectedSOPClassUID);
		}
	}

	public UniqueIdentifier getAffectedSOPInstanceUIDElement()
	throws DicomException {
		return this.getCommandSet().getUniqueIdentifier(
				DicomTags.AffectedSOPClassUID);
	}

	public String getErrorComment() {
		if (this.hasErrorCommentElement()) {
			return this.getErrorCommentElement().getSingleStringValue().trim();
		} else {
			return "";
		}
	}

	public LongString getErrorCommentElement() {
		if (this.hasErrorCommentElement()) {
			return this.getCommandSet().getLongString(DicomTags.ErrorComment);
		} else {
			return null;
		}
	}
	
	public int setMessageID( int messageID ) throws DicomException {
		setorAddUnsignedShort(DicomTags.MessageIDBeingRespondedTo, messageID);
		return messageID;
	}
	
	@Override
	protected UnsignedShort getMessageIDElement() {
		return this.getCommandSet().getUnsignedShort(
				DicomTags.MessageIDBeingRespondedTo);
	}

	/**
	 * Return the status's value as an integer
	 * 
	 * @return the status(s value
	 */
	public int getStatus() {
		return this.getStatusElement().getSingleIntegerValue();
	}

	public UnsignedShort getStatusElement() {
		assert this.getCommandSet().getUnsignedShort(DicomTags.Status) != null;
		return this.getCommandSet().getUnsignedShort(DicomTags.Status);
	}

	/**
	 * Return true if the message contains ErrorComment tag
	 * 
	 * @return true if element is present
	 */
	public boolean hasErrorCommentElement() {
		return this.getCommandSet().hasElement(DicomTags.ErrorComment);
	}

	/**
	 * Return true if the message contains Status tag
	 * 
	 * @return true if element is present
	 */
	public boolean hasStatusElement() {
		return this.getCommandSet().hasElement(DicomTags.Status);
	}

	public boolean hasSucces() {
		return this.getCommandSet().hasElement(DicomTags.Status);
	}

	/**
	 * Return true if the message indicates a cancel status
	 * 
	 * @return true if success
	 */
	public boolean isCanceled() {
		// fLogger.debug("isCanceled: " + Boolean.toString(getStatus() ==
		// DimseConst.Status.Cancel) );
		return this.getStatus() == DimseConst.Status.Cancel;
	}

	/**
	 * Return true if the message indicates a failure
	 * 
	 * @return true if success
	 */
	public boolean isFailure() {
		return DimseConst.isFailure(this.getStatus());
	}

	/**
	 * Return true if the message indicates a pending status
	 * 
	 * @return true if success
	 */
	public boolean isPending() {
		// fLogger.debug("isPending: " +
		// Boolean.toString(DimseConst.isPendingStatus(getStatus())) );
		return DimseConst.isPendingStatus(this.getStatus());
	}

	/**
	 * Return true if the message indicates a pending with warning status
	 * 
	 * @return true if success
	 */
	public boolean isPendingWithWarning() {
		// fLogger.debug("isPendingWithWarning: " + Boolean.toString(getStatus() ==
		// DimseConst.Status.PendingWithWarning) );
		return this.getStatus() == DimseConst.Status.PendingWithWarning;
	}

	/**
	 * Return true if the message indicates a success status
	 * 
	 * @return true if success
	 */
	public boolean isSuccess() {
		return this.getStatus() == DimseConst.Status.Success;
	}

	public void setAffectedSOPClassUID(String affectedSOPClassUID)
	throws DicomException, DimseException {
		if (this.hasAffectedSOPClassUIDElement()) {
			this.getAffectedSOPInstanceUIDElement().setValue(affectedSOPClassUID);
		} else {
			throw new DimseException("No AffectedSOPClassUID in CommandSet");
		}
	}

	public void setErrorComment(String errorComment) throws DimseException {
		try {
			if (!this.hasErrorCommentElement()) {
				this.addErrorCommentElement();
			}
			LongString lError = this.getErrorCommentElement();
			if (lError != null) {
				lError.setValue(errorComment);
			}
		} catch (Throwable e) {
			logger.warn(e.getMessage());
			throw new DimseException(e.getMessage());
		}
	}

	protected void setMessagetype() throws DicomException {
		
	}

	/**
	 * set value for the status element. if success status is provided, the
	 * ErrorComments value will be removed
	 * 
	 * @param the
	 *          value to set
	 * @throws DicomException
	 */
	public void setStatus(int status) throws DicomException {
		logger.debug("setStatus: " + DimseConst.statusToString(status));
		if (!this.hasStatusElement()) {
			this.getCommandSet().addElement(DataElements.newStatus());
		}
		assert this.getCommandSet().getUnsignedShort(DicomTags.Status) != null;
		this.getStatusElement().setValue(status);
		if (this.isSuccess()) {
			this.getCommandSet().removeElement(DicomTags.ErrorComment);
			logger.info("Status is succes, we remove ErrorComment Element");
		}
	}

	/**
	 * return the status as a string
	 * 
	 * @return the status as string
	 */
	public String statusToString() {
		try {
			return this.getStatusRegistry().getName(this.getStatus());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return DimseStatus.toString(this.getStatus());
		}
		// return DimseStatus.toString( this.getStatus() );
	}

}
