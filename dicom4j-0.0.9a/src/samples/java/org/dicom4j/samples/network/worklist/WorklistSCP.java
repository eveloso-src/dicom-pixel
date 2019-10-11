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
package org.dicom4j.samples.network.worklist;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.dicom4j.core.Dicom4j;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.dicom.network.dimse.DimsePriority;
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
import org.dicom4j.network.dimse.messages.CFindRequestMessage;
import org.dicom4j.network.dimse.messages.CFindResponseMessage;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.dimse.messages.DimseMessageFactory;
import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;
import org.dicom4j.network.protocoldataunit.support.AbstractPresentationContextItem;
import org.dolmen.network.transport.acceptor.TransportAcceptor;
import org.dolmen.network.transport.acceptor.TransportAcceptorConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample Basic Worklist SCP (for testing purpose)
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class WorklistSCP {

	/**
	 * Class to handle the Associate requests.
	 */
	public static class WorklistSCPAssociateRequestHandler extends
	DefaultAssociateRequestHandler {

		@Override
		public AssociateResponse requestReceived(Association aAssociation,
				AssociateRequest aAssociateRequest) {
			logger.info("requestReceived");
			// we create the default response
			AssociateResponse lReponse = this
			.createDefaultResponse(aAssociateRequest);
			// we get an iterator to parse all Presentation
			Iterator<AbstractPresentationContextItem> lPres = aAssociateRequest
			.getPresentationIterator();
			while (lPres.hasNext()) {
				PresentationContexRequestItem lPresRQ = (PresentationContexRequestItem) lPres
				.next();
				String lSopClass = lPresRQ.getAbstractSyntax();
				logger.info("SopClass: " + lSopClass);

				// if the Request contains Verification, we add an Acceptance
				if (lSopClass.equals(SOPClass.Verification.getUID())) {
					lReponse.addPresentationContext(lPresRQ.getID(),
							NetworkStaticProperties.PresentationContextReasons.ACCEPTANCE,
							lPresRQ.getTransferSyntax(0));
					// ModalityWorklistInformationModelFIND we can send acceptance
				} else if (lSopClass
						.equals(SOPClass.ModalityWorklistInformationModelFIND.getUID())) {
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
	public static class WorklistSCPAssociationListener extends
	DefaultAssociationListener {

		@Override
		public void exceptionCaught(Association aAssociation, Throwable cause) {
			logger.error("exceptionCaught: " + cause.getMessage());
			try {
				aAssociation.sendAbort(AssociateAbort.ServiceUserAbort);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.dicom4j.network.association.listeners.defaults.DefaultAssociationListener
		 * #messageReceived(org.dicom4j.network.association.Association, byte,
		 * org.dicom4j.network.dimse.messages.DimseMessage)
		 */
		@Override
		public void messageReceived(Association aAssociation,
				byte aPresentationContextID, DimseMessage aMessage) throws Exception {
			super.messageReceived(aAssociation, aPresentationContextID, aMessage);
			logger.info("messageReceived: " + aMessage);
			if (aMessage.isCEchoRequest()) {
				CEchoRequestMessage lRequest = (CEchoRequestMessage) aMessage;
				int lMessageID = lRequest.getMessageID();
				String lSOPClassUID = lRequest.getAffectedSOPClassUID();
				CEchoResponseMessage lreponse = MessageFactory.newCEchoResponse(
						lMessageID, lSOPClassUID, DimsePriority.MEDIUM.value());
				aAssociation.sendMessage(aPresentationContextID, lreponse);
			}

			if (aMessage.isCFindRequest()) {
				logger.info("C-Find-Request");
				CFindRequestMessage lRequest = (CFindRequestMessage) aMessage;
				int messageID = lRequest.getMessageID();
				String sopClassUID = lRequest.getAffectedSOPClassUID();

				DataSet dataSet = lRequest.getDataSet();
				logger.info("Request:" + dataSet);

				/*
				 * we return 10 worklist items, so for the first 9, we return must
				 * return a pending status and success for the last one. each DataSet
				 * must be contain in one message
				 */
				for (int i = 0; i < 11; i++) {
					int status = DimseStatus.Pending.value();
					CFindResponseMessage response = MessageFactory.newCFindResponse(
							messageID, sopClassUID, true, status);
					if (i == 10) {
						// status = DimseStatus.Success.value();
						response.setStatus(DimseStatus.Success.value());
						response.setDataSet(null);

					} else {
						response.setStatus(DimseStatus.Pending.value());
						DataSet responseDataSet = new DataSet();

						SequenceOfItems scheduledProcedureStepSequence = DataElements
						.newScheduledProcedureStepSequence();

						DataSet procedureStepSequence = new DataSet();
						procedureStepSequence.addApplicationEntity(DataElements
								.newScheduledStationAET(), "ScheduledStationAET");
						procedureStepSequence.addCodeString(DataElements.newModality(),
						"MR");

						scheduledProcedureStepSequence.addItem(procedureStepSequence);

						responseDataSet.addElement(scheduledProcedureStepSequence);
						responseDataSet.addShortString(DataElements.newAccessionNumber(),
								"AccessionNumber" + i);
						responseDataSet.addPersonName(DataElements.newPatientName(),
						"JOHN^DOE");

						response.setDataSet(responseDataSet);
						logger.info("Response:" + response.getDataSet());
					}
					aAssociation.sendMessage(aPresentationContextID, response);

				}

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
	public static class WorklistSCPWorker extends Thread {

		public WorklistSCPWorker() {
			super();
		}

		@Override
		public void run() {

			// we create the TransportAcceptor (manage socket connections)
			TransportAcceptorConfiguration lConfig = new TransportAcceptorConfiguration();
			TransportAcceptor lAcceptor = new TransportAcceptor();
			lAcceptor.setConfiguration(lConfig);

			// we create the AssociationAcceptor configuration
			AssociationAcceptorConfiguration lAssocConfig = new AssociationAcceptorConfigurationImpl();
			// we set the class in charge to handle Associate Request
			lAssocConfig
			.setAssociateRequestHandler(new WorklistSCPAssociateRequestHandler());
			// we set the class in charge to handle Association's events
			lAssocConfig.setAssociationListener(new WorklistSCPAssociationListener());
			// we set the Transport Acceptor
			lAssocConfig.setTransportAcceptor(lAcceptor);

			// we create the AssociationAcceptor
			AssociationAcceptor assoc = new AssociationAcceptorImpl();
			assoc.setConfiguration(lAssocConfig);
			// assoc.setTransportAcceptor(lAcceptor);

			try {
				// we start listening on the port
				assoc.bind(Integer.parseInt(fProperties.getProperty("server.port")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static final Properties fProperties = new Properties(); // "./CEchoSCP.properties");

	/**
	 * the Logger
	 */
	private static final Logger logger = LoggerFactory
	.getLogger(WorklistSCP.class);

	private static final DimseMessageFactory MessageFactory = new DimseMessageFactory();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure("./log4j.properties");
		logger.info("start");
		try {
			fProperties.load(new FileInputStream("./WorklistSCP.properties"));
			Dicom4j.configure(); // we configure the framework
			new WorklistSCP();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * 
	 */
	public WorklistSCP() {
		WorklistSCPWorker lWorker = new WorklistSCPWorker();
		lWorker.start();
		// TODO Auto-generated constructor stub
	}

}
