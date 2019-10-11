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

package org.dicom4j.network.association;

import junit.framework.TestCase;

import org.dicom4j.AbstractTestCase;
import org.dicom4j.mock.network.MockAssociation;
import org.dicom4j.mock.network.MockDicomServer;
import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.dicom4j.network.association.support.ARTIMTimer;
import org.dicom4j.network.association.support.AssociationConnectorImpl;
import org.dolmen.core.lang.thread.WorkerHandler;
import org.dolmen.network.transport.connector.TransportConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAssociation extends AbstractTestCase {

	private class InnerWorkerHandler extends TestCase implements WorkerHandler {

		public void onException(Throwable aException) {
			fail(aException.getMessage());
		}

		public void onWorkCompleted(Object aResult) {
		}
	}

	private class testAssociationListener extends DefaultAssociationListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.dicom4j.network.association.listeners.defaults.DefaultAssociationListener
		 * #associationOpened(org.dicom4j.network.association.Association,
		 * org.dicom4j.network.association.associate.AssociateSession)
		 */
		@Override
		public void associationOpened(Association aAssociation,
				AssociateSession aAssociateSession) throws Exception {
			// TODO Auto-generated method stub
			super.associationOpened(aAssociation, aAssociateSession);
			aAssociation.sendAbort(AssociateAbort.ServiceUserAbort);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.dicom4j.network.association.listeners.defaults.DefaultAssociationListener
		 * #exceptionCaught(org.dicom4j.network.association.Association,
		 * java.lang.Throwable)
		 */
		@Override
		public void exceptionCaught(Association aAssociation, Throwable cause) {
			assertFalse(cause.getMessage(), true); // error so assert error
		}

	}

	private static Logger logger = LoggerFactory.getLogger(TestAssociation.class);

	private AssociationConnector fAssocConnector;

	private MockDicomServer fServer;

	/*
	 * public void testEcho() { try { AssociateRequest lRequest = new
	 * AssociateRequest("WL", "WL"); byte lPres =
	 * lRequest.addPresentationContext(SOPClass.Verification,
	 * TransferSyntax.ImplicitVRLittleEndian.getValue()); CEchoResponseHandler
	 * lEchoHandler = new CEchoResponseHandler();
	 * fAssoc.addDimseMessageHandler(lEchoHandler);
	 * fAssoc.sendAssociate(lRequest); DimseMessage lMessage =
	 * DimseMessageFactory.Instance().newCEchoRequest(1, SOPClass.Verification);
	 * fAssoc.sendMessage(lPres, lMessage); assertTrue(lEchoHandler.isSuccess());
	 * fAssoc.sendRelease(); } catch (Exception e) {
	 * System.err.println(e.getMessage()); fail(e.getMessage()); } }
	 */

	private TransportConnector fTCPConnector;

	public TestAssociation() {
		super(TestAssociation.class.getName());
		this.fServer = new MockDicomServer(new InnerWorkerHandler());
	}

	/*
	 * public void testCFind() { try { AssociateRequest lRequest = new
	 * AssociateRequest("WL", "WL"); byte lPres =
	 * lRequest.addPresentationContext(SOPClass
	 * .FindModalityWorklistInformationModel,
	 * TransferSyntax.ImplicitVRLittleEndian.getValue()); CFindResponseHandler
	 * lHandler = new CFindResponseHandler();
	 * fAssoc.addDimseMessageHandler(lHandler); fAssoc.sendAssociate(lRequest);
	 * DimseMessage lMessage = DimseMessageFactory.Instance().newCFindRequest(1,
	 * SOPClass.FindModalityWorklistInformationModel); PersonNameAttribute lAttrib
	 * = new PersonNameAttribute(TagFromName.PatientName); lAttrib.addValue("*");
	 * lMessage.getDataSet().addAttribute(lAttrib);
	 * lMessage.getDataSet().addAttribute(new
	 * LongStringAttribute(TagFromName.PatientID));
	 * lMessage.getDataSet().addAttribute(new
	 * PersonNameAttribute(TagFromName.RequestingPhysician));
	 * lMessage.getDataSet().addAttribute(new
	 * ShortStringAttribute(TagFromName.AccessionNumber));
	 * lMessage.getDataSet().addAttribute(new
	 * DateAttribute(TagFromName.PatientBirthDate));
	 * 
	 * fAssoc.sendMessage(lPres, lMessage); fAssoc.sendRelease();
	 * assertTrue(lHandler.isSuccess()); // for (int i=0; i<
	 * lHandler.getDataSets().count(); i++) { //
	 * System.out.println(lHandler.getDataSets().getDataSet(i).toString()); }
	 * catch (Exception e) { System.err.println(e.getMessage());
	 * fail(e.getMessage()); } }
	 */

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.fTCPConnector = new TransportConnector();
		this.fAssocConnector = new AssociationConnectorImpl();
		// fAssocConnector.setTransportConnector(fTCPConnector);
		// fAssoc = new MinaAssociation(); //
		// Implementation.Instance().UpperLayer().newAssociation("localhost", 104);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAssociation() {
		/*
		 * AssociateRequest lReq = new AssociateRequest("ANY","ANY"); try {
		 * fAssocConnector.setAssociationListener(new testAssociationListener());
		 * fAssocConnector.connect("localhost", 104, lReq); } catch (Exception e) {
		 * assertFalse(e.getMessage(),true); // error so assert error
		 * //fLogger.error(e.getMessage()); }
		 */

	}

	public void testWaitTimer() throws Exception {
		logger.info("testWaitTimer");
		Association lAssoc = new MockAssociation();
		assertFalse(lAssoc.isEstablished());
		lAssoc.waitAssociate();
		int timeout = 1000;
		ARTIMTimer lTimer = new ARTIMTimer(lAssoc, timeout);
		assertFalse(lTimer.isStarted());
		lTimer.start();
		assertTrue(lTimer.isStarted());
		Thread.sleep(timeout + 1000);
		assertFalse(lAssoc.isEstablished());
		logger.info("testWaitTimer: success");
	}

}
