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

package org.dicom4j.network.dimse;

import org.dicom4j.core.AbstractFactory;
import org.dicom4j.data.CommandSet;
import org.dicom4j.data.CommandSetType;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.network.dimse.DimsePriority;
import org.dicom4j.dicom.network.dimse.DimseStatus;
import org.dicom4j.dicom.network.dimse.DimseStatusRegistry;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.network.dimse.messages.CCancelRequest;
import org.dicom4j.network.dimse.messages.CEchoRequestMessage;
import org.dicom4j.network.dimse.messages.CEchoResponseMessage;
import org.dicom4j.network.dimse.messages.CFindRequestMessage;
import org.dicom4j.network.dimse.messages.CFindResponseMessage;
import org.dicom4j.network.dimse.messages.CGetRequestMessage;
import org.dicom4j.network.dimse.messages.CGetResponseMessage;
import org.dicom4j.network.dimse.messages.CMoveRequestMessage;
import org.dicom4j.network.dimse.messages.CMoveResponseMessage;
import org.dicom4j.network.dimse.messages.CStoreRequestMessage;
import org.dicom4j.network.dimse.messages.CStoreResponseMessage;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.dimse.messages.NActionRequest;
import org.dicom4j.network.dimse.messages.NActionResponse;
import org.dicom4j.network.dimse.messages.NCreateRequest;
import org.dicom4j.network.dimse.messages.NCreateResponse;
import org.dicom4j.network.dimse.messages.NDeleteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory to create DIMSE messages
 * 
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DimseMessageFactory extends AbstractFactory {

	/**
	 * The current ID used to allocate new MessageID when requested
	 */
	private static int currentID = -1;

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory.getLogger(DimseMessageFactory.class);

	private DimseStatusRegistry statusRegistry;

	public DimseMessageFactory() {
		super();
	}

	protected DimseMessage configureMessage(DimseMessage message) {
		message.setSopClassRegistry(this.getSopClassRegistry());
		message.setStatusRegistry(this.getStatusRegistry());
		return message;
	}

	/**
	 * Return a Message ID
	 * 
	 * @return the message ID
	 */
	public synchronized byte createMessageID() {
		if (currentID > Byte.MAX_VALUE - 10) {
			currentID = -1;
		}
		currentID = currentID + 2;
		return (byte) currentID;
	}

	/**
	 * @return Returns the statusRegistry.
	 */
	public DimseStatusRegistry getStatusRegistry() {
		return this.statusRegistry;
	}

	protected int hasDatasetBoolToInt(boolean aHasDataset) {
		if (aHasDataset) {
			return CommandSet.HAS_DATASET;
		} else {
			return CommandSet.NO_DATASET;
		}
	}

	/**
	 * Create a new C-FIND-RSP MESSAGE
	 * 
	 * @return the message
	 */
	public CCancelRequest newCCancelFindRequest() throws DicomException {
		logger.debug("newCCancelFindRequest");
		return new CCancelRequest(this.createMessageID());
	}

	/**
	 * Create a new C-FIND-RSP MESSAGE
	 * 
	 * @param aCommandDataset
	 * @return the message
	 * @exception DicomException
	 */
	public CCancelRequest newCCancelFindRequest(CommandSet aCommandDataset)
	throws DicomException {
		logger.debug("newCCancelFindRequest");
		return new CCancelRequest(aCommandDataset);
	}

	/**
	 * Creates a new {@link CCancelRequest}
	 * 
	 * @param aMessageID
	 *          the MessageID
	 * @return the message
	 * @exception DicomException
	 */
	public CCancelRequest newCCancelRequest(int aMessageID) throws DicomException {
		logger.debug("newCCancelRequest (MessageID: " + aMessageID + ")");
		return new CCancelRequest(aMessageID);
	}

	public CEchoRequestMessage newCEchoRequest() throws DicomException {
		return this.newCEchoRequest(SOPClass.Verification);
	}

	/**
	 * create a new CEchoRequest message from a {@link CommandSet CommandSet}
	 * 
	 * @param aCommandSet
	 *          the CommandSet
	 * @return the message
	 * @throws DicomException
	 */
	public CEchoRequestMessage newCEchoRequest(CommandSet aCommandSet)
	throws DicomException {
		logger.debug("newCEchoRequest");
		return new CEchoRequestMessage(aCommandSet);
	}

	public CEchoRequestMessage newCEchoRequest(SOPClass sopClass)
	throws DicomException {
		assert sopClass != null;
		return this.newCEchoRequest(sopClass.getUID());
	}

	/**
	 * create a new CEchoRequest message
	 * 
	 * @param aAffectedSOPClassUID
	 *          the AffectedSOPClassUID
	 * @return the message
	 * @throws DicomException
	 */
	public CEchoRequestMessage newCEchoRequest(String aAffectedSOPClassUID)
	throws DicomException {
		logger.debug("newCEchoRequest - AffectedSOPClassUID: "
				+ aAffectedSOPClassUID);
		CEchoRequestMessage message = new CEchoRequestMessage(this
				.createMessageID(), aAffectedSOPClassUID);
		this.configureMessage(message);
		return message;
	}

	/**
	 * Create an new CEchoResponse message from a CommandSet
	 * 
	 * @param aCommandSet
	 *          the CommandSet
	 * @return the created message
	 * @throws DimseException
	 */
	public CEchoResponseMessage newCEchoResponse(CommandSet aCommandSet) {
		logger.debug("newCEchoResponse");
		CEchoResponseMessage message = new CEchoResponseMessage(aCommandSet);
		this.configureMessage(message);
		return message;
	}

	public CEchoResponseMessage newCEchoResponse(int messageIDBeingRespondedTo,
			String affectedSOPClassUID, DimseStatus aStatus) throws DicomException {
		assert aStatus != null;
		logger.debug("newCEchoResponse");
		return new CEchoResponseMessage(messageIDBeingRespondedTo,
				affectedSOPClassUID, aStatus.value());
	}

	public CEchoResponseMessage newCEchoResponse(int messageIDBeingRespondedTo,
			String affectedSOPClassUID, int status) throws DicomException {
		logger.debug("newCEchoResponse");
		return new CEchoResponseMessage(messageIDBeingRespondedTo,
				affectedSOPClassUID, status);
	}

	public CFindRequestMessage newCFindRequest(CommandSet aCommandDataset)
	throws DicomException {
		logger.debug("newCFindRequest");
		return new CFindRequestMessage(aCommandDataset);
	}

	public CFindRequestMessage newCFindRequest(SOPClass aSOPClass)
	throws DicomException {
		return this.newCFindRequest(aSOPClass.getUID());
	}

	public CFindRequestMessage newCFindRequest(String aAffectedSOPClassUID)
	throws DicomException {
		logger.debug("newCFindRequest - AffectedSOPClassUID: "
				+ aAffectedSOPClassUID);
		return new CFindRequestMessage(this.createMessageID(), aAffectedSOPClassUID);
	}

	public CFindRequestMessage newCFindRequest(String aAffectedSOPClassUID,
			int Priority) throws DicomException {
		logger.debug("newCFindRequest");
		return new CFindRequestMessage(this.createMessageID(),
				aAffectedSOPClassUID, Priority);
	}

	/**
	 * Create a new {@link CFindResponseMessage}
	 * 
	 * @param aCommandDataset the command set
	 * @return new message
	 */
	public CFindResponseMessage newCFindResponse(CommandSet commandSet) {
		logger.debug("newCFindResponse from CommandSet");
		CFindResponseMessage message = new CFindResponseMessage(commandSet);
		this.configureMessage(message);
		return message;
	}

	/**
	 * create new {@link CFindResponseMessage} with no DataSet and success Status
	 * 
	 * @param messageID the message ID of the request message
	 * @param affectedSOPClassUID the affected sopClass UID
	 * @return new message 
	 * @throws DicomException if errors occurs
	 */
	public CFindResponseMessage newCFindResponse(int messageID, String affectedSOPClassUID) throws DicomException {
		return (CFindResponseMessage) configureMessage( new CFindResponseMessage(messageID, affectedSOPClassUID) );
	}

	public CFindResponseMessage newCFindResponse(int messageID,
			String affectedSOPClassUID, boolean hasDataset, DimseStatus status)
	throws DicomException {
		logger.debug("newCFindResponse (affectedSOPClassUID: "
				+ affectedSOPClassUID, "Status: " + status.value() + ")");
		return this.newCFindResponse(messageID, affectedSOPClassUID, hasDataset,
				status.value());
	}

	public CFindResponseMessage newCFindResponse(int messageID, String affectedSOPClassUID, DimseStatus status) throws DicomException {
		CFindResponseMessage message = newCFindResponse(messageID, affectedSOPClassUID);
		message.setStatus( status.value() );
		return message;
	}
	
	@Deprecated
	public CFindResponseMessage newCFindResponse(int messageID,
			String affectedSOPClassUID, boolean aHasDataset, int status)
	throws DicomException {
		logger.debug("newCFindResponse (affectedSOPClassUID: "
				+ affectedSOPClassUID, "Status: " + status + ")");
		return new CFindResponseMessage(messageID, affectedSOPClassUID, this
				.hasDatasetBoolToInt(aHasDataset), status);
	}

	public CFindResponseMessage newCFindResponse(int aMessageID,
			String aAffectedSOPClassUID, int aHasDataset, int aStatus)
	throws DicomException {
		logger.debug("newCFindResponse - AffectedSOPClassUID: "
				+ aAffectedSOPClassUID);
		return new CFindResponseMessage(aMessageID, aAffectedSOPClassUID,
				aHasDataset, aStatus);
	}

	/**
	 * creates new C-Get-Request message from a CommandDataset
	 * 
	 * @param aCommandDataset
	 *          the CommandDataset
	 * @return the new message
	 * @throws DicomException
	 *           if errors ocurs
	 */
	public CGetRequestMessage newCGetRequest(CommandSet aCommandDataset)
	throws DicomException {
		logger.debug("newCGetRequest");
		return new CGetRequestMessage(aCommandDataset);
	}

	/**
	 * creates new C-Get-Request messag
	 * 
	 * @param aAffectedSOPClassUID
	 * @return the new message
	 * @throws DicomException
	 *           if errors ocurs
	 */
	public CGetRequestMessage newCGetRequest(String aAffectedSOPClassUID)
	throws DicomException {
		logger.debug("newCGetRequest (AffectedSOPClassUID:" + aAffectedSOPClassUID
				+ ")");
		return new CGetRequestMessage(this.createMessageID(), aAffectedSOPClassUID);
	}

	/**
	 * creates new C-Get-Request messag
	 * 
	 * @param aAffectedSOPClassUID
	 * @param Priority
	 * @return the new message
	 * @throws DicomException
	 *           if errors ocurs
	 */
	public CGetRequestMessage newCGetRequest(String aAffectedSOPClassUID,
			int Priority) throws DicomException {
		logger.debug("newCGetRequest");
		return new CGetRequestMessage(this.createMessageID(), aAffectedSOPClassUID,
				Priority);
	}

	public CGetResponseMessage newCGetResponse(SOPClass affectedSOPClass)
	throws DicomException {
		return this.newCGetResponse(affectedSOPClass.getUID(), DimseStatus.Success);
	}

	public CGetResponseMessage newCGetResponse(SOPClass affectedSOPClass,
			DimseStatus status) throws DicomException {
		return this.newCGetResponse(affectedSOPClass.getUID(), status.value());
	}

	public CGetResponseMessage newCGetResponse(String affectedSOPClass,
			DimseStatus status) throws DicomException {
		return this.newCGetResponse(affectedSOPClass, status.value());
	}

	public CGetResponseMessage newCGetResponse(String affectedSOPClass, int status)
	throws DicomException {
		logger.info("newCGetResponse (affectedSopClassUID: "
				+ this.getSopClassRegistry().getName(affectedSOPClass) + " status "
				+ DimseStatus.toString(status) + ")");
		CGetResponseMessage message = new CGetResponseMessage(this
				.createMessageID(), affectedSOPClass);
		this.configureMessage(message);
		message.setStatus(status);
		return message;

	}

	public CMoveRequestMessage newCMoveRequest(CommandSet aCommandDataset)
	throws DicomException {
		logger.debug("newCMoveRequest");
		return new CMoveRequestMessage(aCommandDataset);
	}

	public CMoveResponseMessage newCMoveResponse(CommandSet aCommandDataset)
	throws DicomException {
		logger.debug("newCMoveResponse");
		return new CMoveResponseMessage(aCommandDataset);
	}

	public CStoreRequestMessage newCStoreRequest() throws DicomException {
		logger.debug("newCStoreRequest()");
		return new CStoreRequestMessage(this.createMessageID());
	}

	/**
	 * create new CStoreRequestMessage
	 * 
	 * @param commandDataset
	 *          the commandSet
	 * @return new message
	 * @throws DicomException
	 */
	public CStoreRequestMessage newCStoreRequest(CommandSet commandDataset)
	throws DicomException {
		logger.debug("newCStoreRequestMessage");
		return new CStoreRequestMessage(commandDataset);
	}

	/**
	 * create new CStoreRequestMessage with the supplied affectedSopClass
	 * (priority: medium)
	 * 
	 * @param affectedSOPClassUID
	 *          the affectedSopClass
	 * @return new message
	 * @throws DicomException
	 */
	public CStoreRequestMessage newCStoreRequest(SOPClass affectedSOPClassUID)
	throws DicomException {
		return this.newCStoreRequest(affectedSOPClassUID.getUID(),
				DimsePriority.MEDIUM.value());
	}

	/**
	 * create new CStoreRequestMessage with the supplied affectedSopClass
	 * (priority: medium)
	 * 
	 * @param affectedSOPClassUID
	 *          the affectedSopClass
	 * @return new message
	 * @throws DicomException
	 */
	public CStoreRequestMessage newCStoreRequest(String affectedSOPClassUID)
	throws DicomException {
		return this.newCStoreRequest(affectedSOPClassUID, DimsePriority.MEDIUM
				.value());
	}

	/**
	 * create new CStoreRequestMessage
	 * 
	 * @param affectedSOPClassUID
	 * @param priority
	 * @return new message
	 * @throws DicomException
	 */
	public CStoreRequestMessage newCStoreRequest(String affectedSOPClassUID,
			int priority) throws DicomException {
		logger.debug("newCStoreRequest");
		CStoreRequestMessage message = new CStoreRequestMessage(this
				.createMessageID(), affectedSOPClassUID);
		message.setPriority(priority);
		this.configureMessage(message);
		return message;
	}

	/**
	 * create a new {@link CStoreResponseMessage}
	 * 
	 * @param aCommandSet
	 *          the CommandSet
	 * @return the message
	 * @throws DicomException
	 */
	public CStoreResponseMessage newCStoreResponseMessage(CommandSet aCommandSet)
	throws DicomException {
		logger.debug("newCStoreResponseMessage from CommandSet");
		return new CStoreResponseMessage(aCommandSet);
	}

	public CStoreResponseMessage newCStoreResponseMessage(int aMessageID,
			String aAffectedSOPClassUID, DimseStatus aStatus) throws DimseException,
			DicomException {
		logger.debug("CStoreResponseMessage");
		return new CStoreResponseMessage(aMessageID, aAffectedSOPClassUID, aStatus
				.value());
	}

	/**
	 * @deprecated use others methods
	 * @param aMessageID
	 * @param aAffectedSOPClassUID
	 * @param aHasDataset
	 * @param aStatus
	 * @return
	 * @throws DicomException
	 */
	@Deprecated
	public CStoreResponseMessage newCStoreResponseMessage(int aMessageID,
			String aAffectedSOPClassUID, int aHasDataset, int aStatus)
	throws DicomException {
		logger.debug("newCStoreResponseMessage");
		return new CStoreResponseMessage(aMessageID, aAffectedSOPClassUID,
				aHasDataset, aStatus);
	}

	/**
	 * <p>Creates a new message from a {@link CommandSet CommandSet}.
	 * 
	 * the appropriate message will be found depending of the commandSet' type
	 * 
	 * @param commandSet the CommandSet
	 * @return new message or null if not message can't be found
	 * @throws DicomException if error occurs
	 */
	public DimseMessage newMessage(CommandSet commandSet) throws DicomException {
		assert commandSet != null;
		logger.info("Trying to found a DimseMessage Class for " + CommandSetType.toString(commandSet.getCommandField()));
		if (commandSet.getCommandField() == CommandSetType.C_ECHO_RESPONSE.value()) {
			return this.newCEchoResponse(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.C_MOVE_REQUEST.value()) {
			return this.newCMoveRequest(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.C_MOVE_RESPONSE.value()) {
			return this.newCMoveResponse(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.C_STORE_REQUEST.value()) {
			return this.newCStoreRequest(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.C_STORE_RESPONSE.value()) {
			return this.newCStoreResponseMessage(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.C_FIND_REQUEST.value()) {
			return this.newCFindRequest(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.C_FIND_RESPONSE.value()) {
			return this.newCFindResponse(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.C_CANCEL_REQUEST.value()) {
			return this.newCCancelFindRequest(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.C_ECHO_REQUEST.value()) {
			return this.newCEchoRequest(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.N_CREATE_REQUEST.value()) {
			return this.newNCreateRequest(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.N_CREATE_RESPONSE.value()) {
			return this.newNCreateResponse(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.N_ACTION_REQUEST.value()) {
			return this.newNActionRequest(commandSet);
		} else if (commandSet.getCommandField() == CommandSetType.N_ACTION_RESPONSE.value()) {
			return this.newNActionResponse(commandSet);
		} else {
			return null;
		}
	}

	public NActionRequest newNActionRequest(CommandSet aCommandSet) throws DicomException {
		logger.debug("NActionRequest from CommandSet");
		return new NActionRequest(aCommandSet);
	}

	/**
	 * Create a new N-CREATE-RQ MESSAGE
	 * 
	 * @param aAffectedSOPClassUID
	 * @return
	 * @throws DicomException
	 */
	public NActionRequest newNActionRequest(String aRequestedSOPClassUID)
	throws DicomException {
		return this.newNActionRequest(aRequestedSOPClassUID, "");
	}

	public NActionRequest newNActionRequest(String aRequestedSOPClassUID,
			String aRequestedSOPInstanceUID) throws DicomException {
		logger.debug("newNActionRequest (RequestedSOPClassUID: "
				+ aRequestedSOPClassUID + ", RequestedSOPInstanceUID: "
				+ aRequestedSOPInstanceUID + ")");
		return new NActionRequest(this.createMessageID(), aRequestedSOPClassUID,
				aRequestedSOPInstanceUID);
	}

	public NActionResponse newNActionResponse(CommandSet aCommandDataSet)
	throws DimseException, DicomException {
		logger.debug("NActionResponse from CommandSet");
		return new NActionResponse(aCommandDataSet);
	}

	public NActionResponse newNActionResponse(int aMessageID,
			String aAffectedSOPClassUID) throws DicomException {
		logger.debug("NActionResponse");
		return new NActionResponse(aMessageID, aAffectedSOPClassUID);
	}

	/**
	 * Create a new N-CREATE-RQ MESSAGE from a CommandSet
	 * 
	 * @param aCommandDataset
	 * @return the message
	 * @exception DicomException
	 */
	public NCreateRequest newNCreateRequest(CommandSet aCommandDataSet)
	throws DicomException {
		logger.debug("newNCreateRequest");
		return new NCreateRequest(aCommandDataSet);
	}

	/**
	 * Create a new N-CREATE-RQ MESSAGE
	 * 
	 * @param affectedSOPClassUID
	 * @return
	 * @throws DicomException
	 */
	public NCreateRequest newNCreateRequest(String affectedSOPClassUID)
	throws DicomException {
		logger.debug("newNCreateRequest (AffectedSOPClassUID: "
				+ affectedSOPClassUID + ")");
		return new NCreateRequest(this.createMessageID(), affectedSOPClassUID);
	}

	public NCreateResponse newNCreateResponse(CommandSet aCommandDataSet)
	throws DimseException, DicomException {
		logger.debug("NCreateResponse from CommandSet");
		return new NCreateResponse(aCommandDataSet);
	}

	public NCreateResponse newNCreateResponse(int aMessageID,
			String aAffectedSOPClassUID, int aStatus) throws DimseException,
			DicomException {
		logger.debug("NCreateResponse (AffectedSOPClassUID: "
				+ aAffectedSOPClassUID + ", Status: "
				+ DimseConst.statusToString(aStatus) + ")");
		return new NCreateResponse(aMessageID, aAffectedSOPClassUID, aStatus);
	}

	public NCreateResponse newNCreateResponse(int aMessageID,
			String aAffectedSOPClassUID, int aHasDataset, int aStatus)
	throws DicomException {
		logger.debug("newNCreateResponse");
		return new NCreateResponse(aMessageID, aAffectedSOPClassUID, aHasDataset,
				aStatus);
	}

	public NCreateResponse newNCreateResponse(String aAffectedSOPClassUID,
			int aStatus) throws DimseException, DicomException {
		return this.newNCreateResponse(this.createMessageID(),
				aAffectedSOPClassUID, aStatus);
	}

	// public DimseMessage NActionResponse(int aMessageID) thorws

	public NDeleteRequest newNDeleteRequest(CommandSet aCommandSet)
	throws DicomException {
		logger.debug("newNDeleteRequest from CommandSet");
		return new NDeleteRequest(aCommandSet);
	}

	/*
	 * public DimseMessage newNActionResponse(String aRequestedSOPClassUID, String
	 * aRequestedSOPInstanceUID) throws DicomException {
	 * fLogger.debug("NActionResponse (RequestedSOPClassUID: " +
	 * aRequestedSOPClassUID + ", RequestedSOPInstanceUID: " +
	 * aRequestedSOPInstanceUID + ")"); return new
	 * NActionResponse(createMessageID(), aRequestedSOPClassUID,
	 * aRequestedSOPInstanceUID, DimseConst.Status.Success); }
	 */

	public NDeleteRequest newNDeleteRequest(String aRequestedSOPClassUID)
	throws DicomException {
		return this.newNDeleteRequest(aRequestedSOPClassUID, "");
	}

	public NDeleteRequest newNDeleteRequest(String aRequestedSOPClassUID,
			String aRequestedSOPInstanceUID) throws DicomException {
		logger.debug("newNCreateRequest (RequestedSOPClassUID: "
				+ aRequestedSOPClassUID + ", RequestedSOPInstanceUID: "
				+ aRequestedSOPInstanceUID + ")");
		return new NDeleteRequest(this.createMessageID(), aRequestedSOPClassUID,
				aRequestedSOPInstanceUID);
	}

	/**
	 * @param statusRegistry
	 *          The statusRegistry to set.
	 */
	public void setStatusRegistry(DimseStatusRegistry statusRegistry) {
		this.statusRegistry = statusRegistry;
	}

	@Override
	public String toString() {
		return "DimseMessageFactory";
	}

}
