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

package org.dicom4j.network;

import junit.framework.TestCase;

import org.dicom4j.TestDicom4J;
import org.dicom4j.network.association.AssociationAcceptor;
import org.dicom4j.network.association.support.AssociationAcceptorImpl;
import org.dolmen.network.transport.acceptor.TransportAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSCU extends TestCase {

	private static Logger fLogger = LoggerFactory.getLogger(TestSCU.class);

	private AssociationAcceptor fAssocAccept;

	private TransportAcceptor fTCPAccept;

	/*
	 * private class CEchoResultHandler implements DicomResultHandler {
	 * 
	 * public CEchoResultHandler(boolean aMustBeSucces) {
	 * fMustBeSucces=aMustBeSucces; }
	 * 
	 * public Object handleResult(DicomQueryRunner aQueryRunner, Association
	 * aAssociation, byte aPresentationContextID, DimseResponseMessage aMessage) {
	 * if (aMessage instanceof CEchoResponseMessage) { if (
	 * ((CEchoResponseMessage)aMessage).isSuccess()) { assertEquals(fMustBeSucces,
	 * ((CEchoResponseMessage)aMessage).isSuccess()); } } else {
	 * assertEquals(fMustBeSucces, ((CEchoResponseMessage)aMessage).isSuccess());
	 * } return null; }
	 * 
	 * 
	 * 
	 * public void handleException(Association aAssociation, Throwable cause) {
	 * fail( cause.getMessage()); //fStatus.append("\n [ERROR] " +
	 * cause.getMessage() + "\n"); }
	 * 
	 * private boolean fMustBeSucces; }
	 * 
	 * 
	 * /*public void sendEcho() { try { }catch (Exception ex) { fLogger.error(
	 * ex.getMessage() ); fStatus.append("\n [ERROR] " + ex.getMessage() + "\n");
	 * } }
	 */

	// private class
	public TestSCU(String name) {
		super(name);
		TestDicom4J.start();
	}

	@Override
	protected void setUp() throws Exception {
		this.fAssocAccept = new AssociationAcceptorImpl();
		this.fTCPAccept = new TransportAcceptor();
		// fAssocAccept.setTransportAcceptor(fTCPAccept);
	}

	public void testCEcho() throws Exception {
		fLogger.info("testCEcho");

		fLogger.error("No testCEcho");
		// start the server
		/*
		 * fAssocAccept.bind(Properties.getPort()); DicomQueryRunner lRunner = new
		 * DicomQueryRunner(); DicomQuery lQuery = new VerificationQuery();
		 * lRunner.sendQuery(Properties.getHostname(), Properties.getPort(),
		 * Properties.getRemoteAET(), Properties.getLocalAET(), lQuery, new
		 * CEchoResultHandler(true) ); //lRunner.sendQuery(Properties.getHostname(),
		 * Properties.getPort(), Properties.getRemoteAET(),
		 * Properties.getLocalAET(), // lQuery, new CEchoResultHandler(false) );
		 */
	}

}
