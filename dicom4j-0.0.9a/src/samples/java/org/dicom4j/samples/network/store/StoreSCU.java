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
package org.dicom4j.samples.network.store;

import org.apache.log4j.PropertyConfigurator;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.dicom4j.network.dimse.messages.CEchoResponseMessage;
import org.dicom4j.network.dimse.messages.CStoreRequestMessage;
import org.dicom4j.network.dimse.messages.CStoreResponseMessage;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.samples.network.AbstractSampleSCU;
import org.dolmen.network.transport.connector.TransportConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample Store SCU
 * 
 * @since 0.1
 * @since 28 oct. 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class StoreSCU extends AbstractSampleSCU {

	/**
	 * class to handle Association's events
	 * 
	 * @since 0.0.3
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 * 
	 */
	public class StoreSCUAssociationListener extends DefaultAssociationListener {

		@Override
		public void associationOpened(Association aAssociation,
				AssociateSession aAssociateSession) throws Exception {
			logger.info("associationOpened");
			String SopClass = SOPClass.CTImageStorage.getUID();
			String SopInstance = "1.1.1.1.1.1.1.1.1";
			CStoreRequestMessage message = aAssociation.getMessageFactory()
			.newCStoreRequest(SOPClass.CTImageStorage);
			DataSet data = new DataSet();
			data.addUniqueIdentifier(DataElements.newSOPClassUID(),
					SOPClass.CTImageStorage.getUID());
			data.addUniqueIdentifier(DataElements.newSOPInstanceUID(), SopInstance);
			data.addPersonName(DataElements.newPatientName(), "JOHN^DOE");
			data.addLongString(DataElements.newPatientID(), "PatientID");

			data.addUniqueIdentifier(DataElements.newStudyInstanceUID(), "1.1.1.1");
			data.addShortString(DataElements.newStudyID(), "1");

			data.addUniqueIdentifier(DataElements.newSeriesInstanceUID(), "1.1.1.1");
			data.addIntegerString(DataElements.newSeriesNumber(), "1");

			data.addIntegerString(DataElements.newInstanceNumber(), "1");

			message.setAffectedSOPInstanceUID(SopInstance);
			message.setDataSet(data);

			if (aAssociateSession.isAccepted(SopClass)) {
				byte presContext = aAssociateSession
				.getSuitablePresentationContextID(SopClass);
				aAssociation.sendMessage(presContext, message);
			} else {
				logger.error("SopClass: " + SopClass + "not accepted");
			}
			/*
			 * CEchoRequestMessage lMessage =
			 * messageFactory.newCEchoRequest(SOPClass.Verification.getUID()); byte
			 * lPres =
			 * aAssociateSession.getSuitablePresentationContextID(SOPClass.Verification
			 * .getUID());
			 * 
			 * for (int i = 0; i < 1; i++) { SendThread lT = new
			 * SendThread(aAssociation, lPres, lMessage); lT.start(); }
			 */

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
			if (message.isCStoreResponse()) {
				logger.debug("isCStoreResponse");
				logger.info("Response: "
						+ ((CStoreResponseMessage) message).statusToString());
				aAssociation.sendReleaseRequest();
			}
		}

	}

	private static final Logger logger = LoggerFactory.getLogger(StoreSCU.class);

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			PropertyConfigurator.configure(".//log4j.properties");
			StoreSCU scu = new StoreSCU();
			scu.performStore();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// we create the Connector's configuration

	public StoreSCU() throws Exception {
		super();
		this.configuration
		.setAssociationListener(new StoreSCUAssociationListener());
		this.configuration.setTransportConnector(new TransportConnector());
		this.connector.setConfiguration(this.configuration);
	}

	public void performStore() throws Exception {
		AssociateRequest request = this.connector.getAssociatePrimitiveFactory()
		.newStoreAssociateRequest("ANY-AET", "STORE");
		this.connector.connect("localhost", 10044, request);
	}

}
