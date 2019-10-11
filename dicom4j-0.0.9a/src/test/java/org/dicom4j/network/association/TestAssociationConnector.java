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

import org.dicom4j.AbstractTestCase;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.mock.network.MockDicomServer;
import org.dicom4j.network.association.associate.AssociateReject;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.dicom4j.network.association.support.AssociationConnectorImpl;
import org.dolmen.core.lang.ExceptionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAssociationConnector extends AbstractTestCase {

	private class TestAssociationConnectorAssociationListener extends
	DefaultAssociationListener {

		public boolean rejectexpected = false;

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.dicom4j.network.association.listeners.DefaultAssociationListener#
		 * associationOpened(org.dicom4j.network.association.Association,
		 * org.dicom4j.network.association.associate.AssociateSession)
		 */
		@Override
		public void associationOpened(Association association,
				AssociateSession associateSession) throws Exception {
			super.associationOpened(association, associateSession);
			if (!associateSession.isAccepted(SOPClass.Verification)) {
				TestAssociationConnector.this.failMessage = SOPClass.Verification.getName() + " not accepted";
			}

		}

		@Override
		public void associationRejected(Association association,
				AssociateReject associateReject) throws Exception {
			if (this.rejectexpected == false) {
				TestAssociationConnector.this.failMessage = "association Rejected not expected";
			}
		}

	}

	private class TestAssociationConnectorExceptionListener implements
	ExceptionListener {

		public void exceptionOccurs(Throwable exception) {
			TestAssociationConnector.this.failMessage = exception.getMessage();
		}

	}

	// private MockServer server = new MockServer();

	private static final Logger logger = LoggerFactory
	.getLogger(TestAssociationConnector.class);

	private static final long serialVersionUID = 1L;

	private String failMessage = "";

	public void testConnector() throws Exception {
		logger.info("testConnector");
		int port = 10044;
		MockDicomServer server = new MockDicomServer(
				new TestAssociationConnectorExceptionListener());
		server.setPort(port);
		server.acceptVerification = true;
		server.start();
		// Thread.sleep(2000);

		AssociationConnector connector = new AssociationConnectorImpl();
		TestAssociationConnectorAssociationListener listerner = new TestAssociationConnectorAssociationListener();
		connector.getConfiguration().setAssociationListener(listerner);
		AssociateRequest request = connector.getConfiguration()
		.getAssociatePrimitiveFactory().newVerificationQuery();
		connector.connect("localhost", 10044, request);
		Thread.sleep(2000);
		if (this.failMessage.length() != 0) {
			fail(this.failMessage);
			logger.info("testConnector: " + this.failMessage);
		} else {
			logger.info("testConnector: success");
		}
	}

}
