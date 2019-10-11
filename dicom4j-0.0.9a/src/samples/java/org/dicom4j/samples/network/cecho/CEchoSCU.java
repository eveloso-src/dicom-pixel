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
package org.dicom4j.samples.network.cecho;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationConnector;
import org.dicom4j.network.association.AssociationConnectorConfiguration;
import org.dicom4j.network.association.associate.AssociatePrimitiveFactory;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.dicom4j.network.association.support.AssociationConnectorConfigurationImpl;
import org.dicom4j.network.association.support.AssociationConnectorImpl;
import org.dicom4j.network.dimse.messages.CEchoRequestMessage;
import org.dicom4j.network.dimse.messages.CEchoResponseMessage;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.dimse.messages.support.AbstractDimseMessage;

/**
 * a sample class showing how to create e C-EchoSCU
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CEchoSCU {

	/**
	 * class to handle Association's events
	 * 
	 * @since 0.0.3
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 * 
	 */
	public class InnerAssociationListener extends DefaultAssociationListener {

		@Override
		public void associationOpened(Association aAssociation,
				AssociateSession aAssociateSession) throws Exception {
			CEchoRequestMessage lMessage = aAssociation.getMessageFactory()
			.newCEchoRequest(SOPClass.Verification.getUID());
			byte lPres = aAssociateSession
			.getSuitablePresentationContextID(SOPClass.Verification.getUID());

			for (int i = 0; i < 1; i++) {
				SendThread lT = new SendThread(aAssociation, lPres, lMessage);
				lT.start();
			}

		}

		@Override
		public void messageReceived(Association aAssociation,
				byte aPresentationContextID, DimseMessage message) throws Exception {
			logger.debug("messageReceived: " + message.getName());
			if (message.isCEchoResponse()) {
				logger.debug("isCEchoResponse");
				logger.info("Response: "
						+ ((CEchoResponseMessage) message).statusToString());
				aAssociation.sendReleaseRequest();
			}
		}

	}

	/**
	 * Thread to send the messages
	 * 
	 * @since 0.1
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 * 
	 */
	private class SendThread extends Thread {

		private Association fAssoc;

		private AbstractDimseMessage fMessage;

		private byte fPres;

		public SendThread(Association aAssoc, byte aPres,
				AbstractDimseMessage aMessage) {
			this.fAssoc = aAssoc;
			this.fPres = aPres;
			this.fMessage = aMessage;
		}

		@Override
		public void run() {
			super.run();
			try {
				this.fAssoc.sendMessage(this.fPres, this.fMessage);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}

		}

	}

	/**
	 * the logger
	 */
	private static final Logger logger = Logger.getLogger(CEchoSCU.class);

	/**
	 * the main class to run the sample
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PropertyConfigurator.configure(".//log4j.properties");
			CEchoSCU scu = new CEchoSCU();
			scu.performVerification();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AssociatePrimitiveFactory associateFactroy = new AssociatePrimitiveFactory();

	/**
	 * Connector to initiate associations
	 */
	private AssociationConnector connector = new AssociationConnectorImpl();

	/**
	 * The factory to create Dimse messages
	 */
	// private DimseMessageFactory messageFactory = new DimseMessageFactory();

	/**
	 * 
	 */
	public CEchoSCU() {
		// we create the Connector's configuration
		AssociationConnectorConfiguration lConfig = new AssociationConnectorConfigurationImpl();
		// we set the Association listener, used to receive data from the remote
		lConfig.setAssociationListener(new InnerAssociationListener());
		this.connector.setConfiguration(lConfig);
	}

	protected AssociateRequest createRequest() throws Exception {
		AssociateRequest lRequest = this.associateFactroy.newAssociateRequest();
		lRequest.setMaximumPDUSize(60000);
		lRequest.setMaximumNumberOperationsInvoked(4);
		lRequest.setMaximumNumberOperationsPerformed(4);
		lRequest.addPresentationContext(SOPClass.Verification,
				TransferSyntax.Default);
		return lRequest;
	}

	public void performVerification() throws Exception {
		try {
			// we open the connection
			this.connector.connect("localhost", 10044, this.createRequest());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
