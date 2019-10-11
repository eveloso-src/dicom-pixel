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

import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.dicom4j.network.dimse.messages.CFindRequestMessage;
import org.dicom4j.network.dimse.messages.CFindResponseMessage;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.samples.network.AbstractSampleSCU;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WorklistSCU sample
 * 
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class WorklistSCU extends AbstractSampleSCU {

	/**
	 * Handle Association's events
	 * 
	 */
	public class WorklistSCUAssociationListener extends
	DefaultAssociationListener {

		@Override
		public void associationOpened(Association association,
				AssociateSession associateSession) throws Exception {
			super.associationOpened(association, associateSession);
			logger.info("AssociateSession: " + associateSession);
			if (associateSession
					.isAccepted(SOPClass.ModalityWorklistInformationModelFIND)) {
				byte presentationID = associateSession
				.getSuitablePresentationContextID(SOPClass.ModalityWorklistInformationModelFIND);
				CFindRequestMessage requestMessage = association.getMessageFactory()
				.newCFindRequest(SOPClass.ModalityWorklistInformationModelFIND);
				DataSet data = new DataSet();
				data.addPersonName(DataElements.newPatientName(), "");
				requestMessage.setDataSet(data);
				logger.info("Message: \n" + requestMessage);
				association.sendMessage(presentationID, requestMessage);
			} else {
				logger.warn(SOPClass.ModalityWorklistInformationModelFIND.getName()
						+ " was not accepted ");
			}
		}

		@Override
		public void associationReleased(Association association) throws Exception {
			logger.info("associationReleased");
		}

		@Override
		public void messageReceived(Association association,
				byte presentationContextID, DimseMessage message) throws Exception {
			logger.info("messageReceived: " + message);
			if (message instanceof CFindResponseMessage) {
				CFindResponseMessage response = (CFindResponseMessage) message;
				logger.info("Response Status: " + response.statusToString());
				DataSet data = response.getDataSet();
				if (data != null) {
					logger.info("Data: \n " + data);
				}
				if (response.isFailure() || response.isSuccess()) {
					association.sendReleaseRequest();
				}
			}
		}

	}

	private static final Logger logger = LoggerFactory
	.getLogger(WorklistSCU.class);

	private static final long serialVersionUID = 1L;

	/**
	 * Run the sample
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WorklistSCU scu = new WorklistSCU();
			scu.performQuery();
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public WorklistSCU() throws Exception {
		super();
		this.configuration
		.setAssociationListener(new WorklistSCUAssociationListener());
		this.connector.setConfiguration(this.configuration);
	}

	protected AssociateRequest createRequest() throws Exception {
		AssociateRequest request = this.connector.getAssociatePrimitiveFactory()
		.newAssociateRequest();
		request.setCallingAET("WorklistSCU");
		request.setMaximumPDUSize(60000);
		request.setMaximumNumberOperationsInvoked(4);
		request.setMaximumNumberOperationsPerformed(4);
		request.addPresentationContext(SOPClass.Verification,
				TransferSyntax.Default);
		request.addPresentationContext(
				SOPClass.ModalityWorklistInformationModelFIND, TransferSyntax.Default);
		return request;
	}

	@Override
	public String getProperiesFilePath() {
		return "./WorklistSCU.properties";
	}

	public void performQuery() throws Exception {
		try {
			// we create the request
			AssociateRequest request = this.createRequest();
			logger.info("Request: " + request);
			// we open the connection
			this.connector.connect(this.getServerHostName(), this.getServerPort(), request);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
