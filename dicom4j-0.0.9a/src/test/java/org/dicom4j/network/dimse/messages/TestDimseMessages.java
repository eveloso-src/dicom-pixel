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

import org.dicom4j.AbstractTestCase;
import org.dicom4j.data.CommandSet;
import org.dicom4j.data.CommandSetType;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.UnsignedLong;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.network.dimse.DimsePriority;
import org.dicom4j.dicom.network.dimse.DimseStatus;
import org.dicom4j.dicom.network.dimse.DimseStatusRegistry;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.network.Properties;
import org.dicom4j.network.dimse.DimseMessageFactory;
import org.dicom4j.network.dimse.messages.support.CompositeDimseRequestMessage;
import org.dicom4j.network.dimse.messages.support.CompositeDimseRequestWithPriorityMessage;
import org.dicom4j.network.dimse.messages.support.CompositeDimseResponseMessage;
import org.dicom4j.network.dimse.messages.support.DimseRequestMessage;
import org.dicom4j.network.dimse.messages.support.DimseResponseMessage;
import org.dicom4j.network.dimse.messages.support.NormalizedDimseResponseMessage;
import org.dicom4j.network.dimse.messages.support.RequestedSOPClassUIDRequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Tests for DimseMessages
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestDimseMessages extends AbstractTestCase {

	private static Logger logger = LoggerFactory.getLogger(TestDimseMessages.class);

	private DimseMessageFactory factory = Properties.newMessageFac();

	private String sopClassUID = "SOPClassUID";

	private String sopInstanceUID = "SOPInstanceUID";
	
	private SOPClassRegistry sopClassRegistry = new SOPClassRegistry();
	
	private TransferSyntaxRegistry transferSyntaxRegistry = new TransferSyntaxRegistry();
	
	private DimseStatusRegistry statusRegistry = new DimseStatusRegistry();

	public TestDimseMessages() {
		super(TestDimseMessages.class.getName());
		assertNotNull(this.factory);
	}

	/*
	 * private void checkCEchoResponseMessage(CEchoResponseMessage message) throws
	 * Exception { assertEquals(CommandSetType.C_ECHO_RESPONSE.value(),
	 * message.getCommandField()); assertEquals(SOPClass.Verification.getUID(),
	 * message.getAffectedSOPClassUID()); assertTrue( message.hasSucces() );
	 * this.dimseResponseMessageTest( message ); fLogger.info(message.toString()
	 * ); }
	 */

	private void checkMessageType(DimseMessage message,
			CommandSetType commandSetType) throws Exception {
		assertNotNull(message);
		assertEquals(commandSetType.value(), message.getCommandField());
		logger.debug(message.toString());
	}

	private void checkNewMessage(int aMessageType) throws Exception {
		DimseMessage lMessage = this.factory
		.newMessage(this.newCommandSet(aMessageType));
		assertEquals(aMessageType, lMessage.getCommandSet().getCommandField());
	}

	/**
	 * common test for response messages
	 * 
	 * @param message
	 *          the message
	 * @throws Exception
	 */
	private void checkResponseMessage(DimseResponseMessage message,
			String expectedSopClassUID) throws Exception {
		assertTrue(message.hasSucces());

		assertEquals(expectedSopClassUID, message.getAffectedSOPClassUID());
		message.setStatus(DimseStatus.Pending.value());
		assertEquals(DimseStatus.Pending.value(), message.getStatus());
		message.setErrorComment("comments");
		assertEquals("comments", message.getErrorComment());

	}

	private CommandSet newCommandSet(int aCommandType) throws Exception {
		CommandSet lCommand = new CommandSet();
		lCommand.addElement(new UnsignedLong(DicomTags.CommandGroupLength));
		lCommand.addElement(DataElements.newCommandField());
		lCommand.addElement(DataElements.newDataSetType());
		lCommand.setCommandField(aCommandType);
		return lCommand;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.factory = Properties.newMessageFac();
		assertNotNull(this.factory);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCCancelRequestMessage() throws Exception {
		CCancelRequest lMessage = this.factory.newCCancelRequest(4);
		assertNotNull(lMessage);
		logger.debug(lMessage.toString());
		logger.debug("\n" + lMessage.getCommandSet().toString());
		// assertEquals( lClassUID, lMessage.getRequestedSOPClassUID() );

	}

	/*
	 * private void dump(DimseMessage aMessage) throws Exception {
	 * 
	 * 
	 * }
	 */

	public void testCEchoRequest() throws Exception {
		CEchoRequestMessage message = new CEchoRequestMessage( 1 , getSOPClassUID() );
		innerTestCompositeRequest( message, 1, CommandSetType.C_ECHO_REQUEST);
	}
	
	public void testCEchoResponse() throws Exception {
		CEchoResponseMessage message = new CEchoResponseMessage( 1, getSOPClassUID() );
		innerTestResponseMessage( message, 1, CommandSetType.C_ECHO_RESPONSE);
	}

	public void testCFindRequest() throws Exception {
		CFindRequestMessage message = new CFindRequestMessage( 1 , getSOPClassUID() );
		innerTestCompositeDimseRequestWithPriorityMessage( message, 1, CommandSetType.C_FIND_REQUEST);
	}
	
	public void testCFindResponse() throws Exception {
		CFindResponseMessage message = new CFindResponseMessage(1, getSOPClassUID() );
		innerTestResponseMessage( message, 1, CommandSetType.C_FIND_RESPONSE);
	}
	
	public void testCStoreRequest() throws Exception {
		logger.info("testCStoreRequest");
		String moveOriginatorAET = "moveOriginatorAET";
		int moveOriginatorMessageID = 40;
		CStoreRequestMessage message = new CStoreRequestMessage( 1, getSOPClassUID() );
		innerTestCompositeDimseRequestWithPriorityMessage( message, 1,  CommandSetType.C_STORE_REQUEST);
		message.setAffectedSOPInstanceUID( getSOPInstanceUID() );
		assertEquals( getSOPInstanceUID()  , message.getAffectedSOPInstanceUID() );
		message.setMoveOriginatorAET( moveOriginatorAET );
		assertEquals( moveOriginatorAET , message.getMoveOriginatorAET() );
		message.setMoveOriginatorMessageID( moveOriginatorMessageID );
		assertEquals( moveOriginatorMessageID , message.getMoveOriginatorMessageID() );
		/*this.checkMessageType(lMessage, CommandSetType.C_STORE_REQUEST);
		lMessage.setAffectedSOPClassUID(this.sopClassUID);
		lMessage.setAffectedSOPInstanceUID(this.sopInstanceUID);
		assertEquals(this.sopClassUID, lMessage.getAffectedSOPClassUID());
		assertEquals(this.sopInstanceUID, lMessage.getAffectedSOPInstanceUID());
		logger.debug(lMessage.toString());
*/
		logger.info("testCStoreRequest: success");
	}
	
	protected void innerTestCompositeDimseRequestWithPriorityMessage( CompositeDimseRequestWithPriorityMessage message, int messageID, CommandSetType type) throws Exception {
		innerTestCompositeRequest( message, messageID, type);
	  message.setPriority( DimsePriority.HIGH.value() );
		assertEquals( DimsePriority.HIGH.value(), message.getPriority() );
	}
	
	protected void innerTestCompositeRequest( CompositeDimseRequestMessage message, int messageID, CommandSetType type) throws Exception {
		innerTestRequestMessage( message, messageID, type);
		assertEquals( getSOPClassUID(), message.getAffectedSOPClassUID());
	}

	protected void innerTestRequestMessage( DimseRequestMessage message, int messageID, CommandSetType type) throws Exception {
		innerTestMessage( message, messageID, type );
	}

	protected void innerTestCompositeResponse( CompositeDimseResponseMessage message, int messageID, CommandSetType type) throws Exception {
		innerTestResponseMessage( message, messageID, type);
		assertEquals( getSOPClassUID(), message.getAffectedSOPClassUID());
	}
	
	protected void innerTestNormalizedResponseMessage( NormalizedDimseResponseMessage message, int messageID, CommandSetType type) throws Exception {
		innerTestResponseMessage( message, messageID, type );
		assertTrue( message.hasAffectedSOPClassUIDElement() );
		assertTrue( message.hasAffectedSOPInstanceUIDDElement() );
		message.setAffectedSOPClassUID( getSOPClassUID() );
		assertEquals( getSOPClassUID() , message.getAffectedSOPClassUID() );
		message.setAffectedSOPInstanceUID( getSOPInstanceUID() );
		assertEquals( getSOPInstanceUID() , message.getAffectedSOPInstanceUID() );
	}
	
	protected void innerTestResponseMessage( DimseResponseMessage message, int messageID, CommandSetType type) throws Exception {
		innerTestMessage( message, messageID, type );
	}
	
	protected void innerTestMessage( DimseMessage message, int messageID, CommandSetType type) throws Exception {
		assertNotNull(message);	
		assertEquals( messageID, message.getMessageID() );
		assertEquals( type.value(), message.getCommandField() );
		assertFalse( message.hasDataSet() );
		message.setDataSet( new DataSet() );
		assertTrue( message.hasDataSet() );		
		logger.info("Message: \n" + message.toString() );
	}
	
	public void testCEchoResponseMessage() throws Exception {
		CEchoResponseMessage message = this.factory.newCEchoResponse(1,
				SOPClass.Verification.getUID(), DimseStatus.Success);
		this.checkMessageType(message, CommandSetType.C_ECHO_RESPONSE);
		this.checkResponseMessage(message, SOPClass.Verification.getUID());
		// this.checkCEchoResponseMessage(message);
	}

	public void testCGetResponseMessage() throws Exception {
		SOPClass sopClass = SOPClass.CTImageStorage;
		CGetResponseMessage message = this.factory.newCGetResponse(sopClass);
		this.checkMessageType(message, CommandSetType.C_GET_RESPONSE);
		assertEquals(sopClass.getUID(), message.getAffectedSOPClassUID());
		assertEquals(DimseStatus.Success.value(), message.getStatus());
		message.setNumberOfCompletedSubOperations(1);
		assertEquals(1, message.getNumberOfCompletedSubOperations());
		message.setNumberOfFailedSubOperations(2);
		assertEquals(2, message.getNumberOfFailedSubOperations());
		message.setNumberOfRemainingSubOperations(3);
		assertEquals(3, message.getNumberOfRemainingSubOperations());
		message.setNumberOfWarningSubOperations(4);
		assertEquals(4, message.getNumberOfWarningSubOperations());
	}

	public void testCStoreResponseMessage() throws Exception {
		logger.info("testCStoreResponseMessage");
		CStoreResponseMessage message =  new CStoreResponseMessage(1, getSOPClassUID() );
		innerTestCompositeResponse(message, 1, CommandSetType.C_STORE_RESPONSE);
		logger.info("testCStoreResponseMessage: success");
	}

	public void testErrorComments() throws Exception {
		DimseResponseMessage msg;
		// msg = factory.newCEchoResponse(1, "", DimseStatus.Pending );
		// assertTrue( msg.hasErrorComment() );
		// msg = null;
		msg = this.factory.newCFindResponse(1, "");
		assertFalse(msg.hasErrorCommentElement());
		msg.setErrorComment("error");
		assertTrue(msg.hasErrorCommentElement());
	}

	public void testNActionRequest() throws Exception {
		NActionRequest message = this.factory.newNActionRequest(getSOPClassUID(), getSOPInstanceUID() );
		innerTestRequestedSOPClassUIDRequestMessage( message, CommandSetType.N_ACTION_REQUEST);
	}

	/*public void testNCreateRequest() throws Exception {
		NCreateRequest lMessage = this.factory.newNCreateRequest(getSOPClassUID());
		assertNotNull(lMessage);
		assertEquals(SOPClass.Verification.getUID(), lMessage
				.getAffectedSOPClassUID());
		lMessage.setAffectedSOPInstanceUID("aAffectedSOPInstanceUID");
		assertEquals("aAffectedSOPInstanceUID", lMessage
				.getAffectedSOPInstanceUID());
		lMessage.setAffectedSOPInstanceUID("aAffectedSOPInstanceUID2");
		assertEquals("aAffectedSOPInstanceUID2", lMessage
				.getAffectedSOPInstanceUID());
	}*/

	/*public void testNGetRequestMessage() throws Exception {
		NGetRequestMessage message = new NGetRequestMessage(0, getSOPClassUID(), getSOPInstanceUID() );
		innerTestRequestedSOPClassUIDRequestMessage( message, CommandSetType.N_GET_REQUEST);
		
	}*/
	
	protected void innerTestRequestedSOPClassUIDRequestMessage(RequestedSOPClassUIDRequestMessage message, CommandSetType type) {
		assertNotNull(message);		
		assertEquals(getSOPClassUID(), message.getRequestedSOPClassUID());
		assertEquals(getSOPInstanceUID(), message.getRequestedSOPInstanceUID());
		logger.debug(message.toString());
	}
	
	public void testNDeleteRequest() throws Exception {
		NDeleteRequest lMessage = this.factory.newNDeleteRequest(getSOPClassUID(), getSOPInstanceUID());
		innerTestRequestedSOPClassUIDRequestMessage( lMessage, CommandSetType.N_DELETE_REQUEST );
	}

	public void testNEventReportResponse() throws Exception {
		NEventReportResponseMessage message = new NEventReportResponseMessage(1);
		innerTestNormalizedResponseMessage( message, 1, CommandSetType.N_EVENT_REPORT_RESPONSE);
		message.setEventTypeID( 48 );
		assertEquals( 48, message.getEventTypeID());
	}
	
	protected String getSOPClassUID() {
		return  SOPClass.CTImageStorage.getUID();
	}
	
	protected String getSOPInstanceUID() {
		return  "1.1.1.4.8.5.78.45.6.8676.4984";
	}
	
	protected void configureMessage(DimseMessage message) {
		message.setSopClassRegistry( sopClassRegistry );
		message.setStatusRegistry( statusRegistry );
	}
}
