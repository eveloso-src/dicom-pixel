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

package org.dicom4j.samples.network.store;

import java.io.File;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.network.dimse.DimseStatus;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.file.DicomFileWriter;
import org.dicom4j.network.NetworkStaticProperties;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationAcceptor;
import org.dicom4j.network.association.AssociationAcceptorConfiguration;
import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateResponse;
import org.dicom4j.network.association.listeners.DefaultAssociateRequestHandler;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.dicom4j.network.association.support.AssociationAcceptorConfigurationImpl;
import org.dicom4j.network.dimse.messages.CStoreRequestMessage;
import org.dicom4j.network.dimse.messages.CStoreResponseMessage;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;
import org.dicom4j.network.protocoldataunit.support.AbstractPresentationContextItem;
import org.dicom4j.samples.network.AbstractSampleSCP;
import org.dolmen.network.transport.acceptor.TransportAcceptor;
import org.dolmen.network.transport.acceptor.TransportAcceptorConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Basic store SCP
 * 
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class StoreSCP extends AbstractSampleSCP {

	/**
	 * Class to handle the Associate requests (Send Acceptance for any UID)
	 */
	public static class StoreSCPAssociateRequestHandler extends
	DefaultAssociateRequestHandler {

		@Override
		public AssociateResponse requestReceived(Association aAssociation,
				AssociateRequest request) {
			// we create the default response
			AssociateResponse reponse = this.createDefaultResponse(request);
			reponse.setCalledAET(request.getCalledAET());
			// we get an iterator to parse all Presentation
			Iterator<AbstractPresentationContextItem> lPres = request
			.getPresentationIterator();
			while (lPres.hasNext()) {
				PresentationContexRequestItem lPresRQ = (PresentationContexRequestItem) lPres
				.next();
				// we accept all SopClass
				reponse.addPresentationContext(lPresRQ.getID(),
						NetworkStaticProperties.PresentationContextReasons.ACCEPTANCE,
						lPresRQ.getTransferSyntax(0));
			}
			return reponse; // we return the created Response
		}

	}

	public static class StoreSCPAssociationListener extends
	DefaultAssociationListener {

		@Override
		public void exceptionCaught(Association association, Throwable cause) {
			System.err.println(cause.getMessage());
			try {
				association.sendAbort(AssociateAbort.ServiceUserAbort);
			} catch (Exception e) {
				System.err.println(cause.getMessage());
			}
		}

		@Override
		public void messageReceived(Association aAssociation,
				byte aPresentationContextID, DimseMessage aMessage) throws Exception {
			super.messageReceived(aAssociation, aPresentationContextID, aMessage);
			logger.debug("messageReceived: " + aMessage);
			if (aMessage instanceof CStoreRequestMessage) {
				logger.info("CStoreRequestMessage");
				CStoreRequestMessage lRequest = (CStoreRequestMessage) aMessage;
				String lSOPClassUID = lRequest.getAffectedSOPClassUID();
				try {
					String lInstanceUID = lRequest.getAffectedSOPInstanceUID();
					DataSet lData = lRequest.getDataSet();
					FileUtils.forceMkdir(new File("./store"));
					DicomFileWriter lWriter = new DicomFileWriter("./store/"
							+ lInstanceUID + ".dcm");
					lWriter.write(lData, TransferSyntax.Default);
					CStoreResponseMessage lRsp = aAssociation.getMessageFactory()
					.newCStoreResponseMessage(aMessage.getMessageID(), lSOPClassUID,
							DimseStatus.Success);
					aAssociation.sendMessage(aPresentationContextID, lRsp);

				} catch (Exception e) {
					logger.error(e.getMessage());
					CStoreResponseMessage lRsp = aAssociation.getMessageFactory()
					.newCStoreResponseMessage(aMessage.getMessageID(), lSOPClassUID,
							DimseStatus.RefusedOutOfResources);
					aAssociation.sendMessage(aPresentationContextID, lRsp);
				}
			}
		}

	}

	/**
	 * the Store Server (extends Thread to not block the default thread)
	 * 
	 */
	public static class StoreSCPWorker extends Thread {

		protected AssociationAcceptor acceptor;

		private int port;

		public StoreSCPWorker(AssociationAcceptor acceptor, int port) {
			super();
			this.acceptor = acceptor;
			this.port = port;
		}

		@Override
		public void run() {

			// we create the TransportAcceptor (manage socket connections)
			TransportAcceptorConfiguration transportConfiguration = new TransportAcceptorConfiguration();
			TransportAcceptor lAcceptor = new TransportAcceptor();
			lAcceptor.setConfiguration(transportConfiguration);

			// we create the AssociationAcceptor configuration
			AssociationAcceptorConfiguration lAssocConfig = new AssociationAcceptorConfigurationImpl();
			// we set the class in charge to handle Associate Request
			lAssocConfig
			.setAssociateRequestHandler(new StoreSCPAssociateRequestHandler());
			// we set the class in charge to handle Association's events
			this.acceptor.getConfiguration().setAssociationListener(
					new StoreSCPAssociationListener());
			// we set the transport acceptor
			this.acceptor.getConfiguration().setTransportAcceptor(lAcceptor);

			// we create the AssociationAcceptor
			// AssociationAcceptor lAssoc = new AssociationAcceptorImpl();
			// we configure it
			// lAssoc.setConfiguration(lAssocConfig);

			try {
				this.acceptor.bind(this.port); // we start listening on the port
				logger.info("waiting associations on port : " + this.port);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * the Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(StoreSCP.class);

	/**
	 * main method to start the server
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			StoreSCP scp = new StoreSCP();
			scp.waitAssociation();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public StoreSCP() throws Exception {
		super();
	}

	@Override
	public String getProperiesFilePath() {
		return "StoreSCP.properties";
	}

	public void waitAssociation() throws Exception {
		this.acceptor.setConfiguration(this.configuration);
		StoreSCPWorker lSCPWorker = new StoreSCPWorker(this.acceptor, this.getServerPort());
		lSCPWorker.start();
	}

}
