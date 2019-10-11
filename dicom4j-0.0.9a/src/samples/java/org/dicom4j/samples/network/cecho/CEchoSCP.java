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

package org.dicom4j.samples.network.cecho;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.dicom4j.core.Dicom4j;
import org.dicom4j.dicom.network.dimse.DimseStatus;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
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
import org.dicom4j.network.association.support.AssociationAcceptorImpl;
import org.dicom4j.network.dimse.messages.CEchoRequestMessage;
import org.dicom4j.network.dimse.messages.CEchoResponseMessage;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.dimse.messages.DimseMessageFactory;
import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;
import org.dicom4j.network.protocoldataunit.support.AbstractPresentationContextItem;
import org.dicom4j.samples.network.NetworkUtils;
import org.dolmen.network.transport.acceptor.TransportAcceptor;
import org.dolmen.network.transport.acceptor.TransportAcceptorConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sample class showing how to implement a basic C-Echo server
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CEchoSCP {

	/**
	 * Class to handle the Associate requests. Send Acceptance for Verification
	 * UID
	 */
	public static class CEchoSCPAssociateRequestHandler extends
	DefaultAssociateRequestHandler {

		@Override
		public AssociateResponse requestReceived(Association aAssociation,
				AssociateRequest aAssociateRequest) {
			// we create the default response
			AssociateResponse lReponse = this
			.createDefaultResponse(aAssociateRequest);
			// we get an iterator to parse all Presentation
			Iterator<AbstractPresentationContextItem> lPres = aAssociateRequest
			.getPresentationIterator();
			while (lPres.hasNext()) {
				PresentationContexRequestItem lPresRQ = (PresentationContexRequestItem) lPres
				.next();
				// if the Request contains Verification, we add an Acceptance
				// PresentationContext
				if (lPresRQ.getAbstractSyntax().equals(SOPClass.Verification.getUID())) {
					lReponse.addPresentationContext(lPresRQ.getID(),
							NetworkStaticProperties.PresentationContextReasons.ACCEPTANCE,
							lPresRQ.getTransferSyntax(0));
				} else {
					lReponse
					.addPresentationContext(
							lPresRQ.getID(),
							NetworkStaticProperties.PresentationContextReasons.USER_REJECTION,
							lPresRQ.getTransferSyntax(0));
				}
			}
			return lReponse; // we return the created Response
		}

	}

	/**
	 * class to handle Association events
	 * 
	 * @since 0.1
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 * 
	 */
	public static class CEchoSCPAssociationListener extends
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
			if (aMessage instanceof CEchoRequestMessage) {
				logger.info("C-Echo-Request");
				CEchoRequestMessage lRequest = (CEchoRequestMessage) aMessage;
				int lMessageID = lRequest.getMessageID();
				String lSOPClassUID = lRequest.getAffectedSOPClassUID();
				CEchoResponseMessage lreponse = MessageFactory.newCEchoResponse(
						lMessageID, lSOPClassUID, DimseStatus.Success);
				aAssociation.sendMessage(aPresentationContextID, lreponse);
			}
		}

	}

	/**
	 * the Thread which launch the socket bind
	 * 
	 * @since 0.1
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 * 
	 */
	public static class SCPWorker extends Thread {

		public SCPWorker() {
			super();
		}

		@Override
		public void run() {

			// we create the TransportAcceptor (manage socket connections)
			TransportAcceptorConfiguration lTransportAcceptorConfiguration = new TransportAcceptorConfiguration();
			TransportAcceptor lAcceptor = new TransportAcceptor();
			lAcceptor.setConfiguration(lTransportAcceptorConfiguration);

			// we create the AssociationAcceptor configuration
			AssociationAcceptorConfiguration lAssocConfig = new AssociationAcceptorConfigurationImpl();
			// we set the class in charge to handle Associate Request
			lAssocConfig
			.setAssociateRequestHandler(new CEchoSCPAssociateRequestHandler());
			// we set the class in charge to handle Association's events
			lAssocConfig.setAssociationListener(new CEchoSCPAssociationListener());

			lAssocConfig.setTransportAcceptor(lAcceptor);

			// we create the AssociationAcceptor
			AssociationAcceptor lAssoc = new AssociationAcceptorImpl();
			lAssoc.setConfiguration(lAssocConfig);

			try {
				int lport = Integer.parseInt(fProperties
						.getProperty(NetworkUtils.PROPERTY_SERVER_PORT));
				lAssoc.bind(lport); // we start listening on the port
				logger.info("waiting associations on port : " + lport);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static final Properties fProperties = new Properties();

	/**
	 * the Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(CEchoSCP.class);

	private static final DimseMessageFactory MessageFactory = new DimseMessageFactory();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("./log4j.properties");
		logger.info("CEchoSCP.start");
		try {
			fProperties.load(new FileInputStream("./CEchoSCP.properties"));
			Dicom4j.configure(); // we configure the framework
			SCPWorker lSCPWorker = new SCPWorker();
			lSCPWorker.start();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

}
