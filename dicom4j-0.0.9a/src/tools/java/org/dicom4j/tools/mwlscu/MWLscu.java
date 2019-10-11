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

package org.dicom4j.tools.mwlscu;

import org.apache.log4j.BasicConfigurator;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationConnector;
import org.dicom4j.network.association.AssociationConnectorConfiguration;
import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.dicom4j.network.association.support.AssociationConnectorConfigurationImpl;
import org.dicom4j.network.association.support.AssociationConnectorImpl;
import org.dicom4j.network.dimse.messages.CEchoResponseMessage;
import org.dicom4j.network.dimse.messages.CFindRequestMessage;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.dimse.messages.DimseMessageFactory;
import org.dicom4j.network.dimse.messages.support.AbstractDimseMessage;
import org.dicom4j.tools.commons.Tool;
import org.dolmen.network.transport.connector.TransportConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MWLscu extends Tool {

	private class InnerAssociationListener extends DefaultAssociationListener {

		@Override
		public void associationOpened(Association aAssociation,
				AssociateSession aAssociateSession) throws Exception {
			CFindRequestMessage lMessage = MWLscu.this.factory
			.newCFindRequest(SOPClass.ModalityWorklistInformationModelFIND
					.getUID());
			DataSet data = new DataSet();
			data.addElement(DataElements.newAccessionNumber());
			lMessage.setDataSet(data);
			byte lPres = aAssociateSession
			.getSuitablePresentationContextID(SOPClass.ModalityWorklistInformationModelFIND
					.getUID());

			for (int i = 0; i < 1; i++) {
				SendThread lT = new SendThread(aAssociation, lPres, lMessage);
				lT.start();
			}
		}

		@Override
		public void messageReceived(Association aAssociation,
				byte aPresentationContextID, DimseMessage aMessage) throws Exception {
			logger.info("messageReceived");
			if (aMessage.isCEchoResponse()) {
				logger.debug("isCEchoResponse");
				logger.info("Response: "
						+ ((CEchoResponseMessage) aMessage).statusToString());
				aAssociation.sendReleaseRequest();
			}
			aAssociation.sendAbort(AssociateAbort.ServiceUserAbort);
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
	private static final Logger logger = LoggerFactory.getLogger(MWLscu.class);

	public static void main(String[] args) {
		try {
			BasicConfigurator.configure();
			MWLscu scu = new MWLscu();
			scu.performRequest();
		} catch (Exception lE) {
			lE.printStackTrace();
		}
	}

	/**
	 * Connector to initiate associations
	 */
	private AssociationConnector connector = new AssociationConnectorImpl();

	/**
	 * The factory used to create Dimse messages
	 */
	private final DimseMessageFactory factory = new DimseMessageFactory();

	public MWLscu() throws Exception {
		// we create the Connector's configuration
		AssociationConnectorConfiguration lConfig = new AssociationConnectorConfigurationImpl();
		// we set the Association listener, used to receive data from the remote
		lConfig.setAssociationListener(new InnerAssociationListener());
		// we set the TransportConnector used to open the transport connection
		lConfig.setTransportConnector(new TransportConnector());
		// we configure the connector
		this.connector.setConfiguration(lConfig);
	}

	protected AssociateRequest createRequest() throws Exception {
		AssociateRequest lRequest = new AssociateRequest();
		lRequest.setMaximumPDUSize(60000);
		lRequest.setMaximumNumberOperationsInvoked(4);
		lRequest.setMaximumNumberOperationsPerformed(4);
		lRequest.addPresentationContext(
				SOPClass.ModalityWorklistInformationModelFIND, TransferSyntax.Default);
		return lRequest;
	}

	public void performRequest() throws Exception {
		this.connector.connect("localhost", 10044, this.createRequest());

	}

}
