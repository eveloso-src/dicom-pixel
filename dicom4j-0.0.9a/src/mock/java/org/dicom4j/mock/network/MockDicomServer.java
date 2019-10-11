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

package org.dicom4j.mock.network;

import java.util.Iterator;

import junit.framework.TestCase;

import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationAcceptor;
import org.dicom4j.network.association.AssociationAcceptorConfiguration;
import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.associate.AssociateReject;
import org.dicom4j.network.association.associate.AssociateRelease;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateResponse;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.AssociateRequestHandler;
import org.dicom4j.network.association.listeners.AssociationListener;
import org.dicom4j.network.association.listeners.DefaultAssociateRequestHandler;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.dicom4j.network.association.support.AssociationAcceptorConfigurationImpl;
import org.dicom4j.network.association.support.AssociationAcceptorImpl;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;
import org.dicom4j.network.protocoldataunit.support.AbstractPresentationContextItem;
import org.dolmen.core.lang.ExceptionListener;
import org.dolmen.core.lang.thread.WorkerHandler;
import org.dolmen.network.transport.acceptor.TransportAcceptor;
import org.dolmen.network.transport.acceptor.TransportAcceptorConfiguration;

/**
 * Mock Dicom server which can be configured to to adapt his behavior for
 * specific {@link TestCase}
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class MockDicomServer {

	private class MockDicomServerAssociateRequestHandler extends
	DefaultAssociateRequestHandler implements AssociateRequestHandler {

		@Override
		public AssociateResponse requestReceived(Association aAssociation,
				AssociateRequest aAssociateRequest) {
			AssociateResponse response = this.createDefaultResponse(aAssociateRequest);
			Iterator<AbstractPresentationContextItem> it = aAssociateRequest
			.getPresentationIterator();
			while (it.hasNext()) {
				PresentationContexRequestItem reqItem = (PresentationContexRequestItem) it
				.next();
				String sopClass = reqItem.getAbstractSyntax();
				boolean accept = false;
				if ((MockDicomServer.this.acceptVerification == true)
						&& sopClass.equals(SOPClass.Verification.getUID())) {
					accept = true;
				}

				if (accept == true) {
					response.addAcceptancePresentationContext(reqItem.getID(), reqItem
							.getTransferSyntax(0));
				} else {
					response.addNotSupportedPresentationContext(reqItem.getID(), reqItem
							.getTransferSyntax(0));
				}
			}
			return response;
		}

	}

	private static class MockDicomServerAssociationListener implements
	AssociationListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.dicom4j.network.association.listeners.AssociationListener#
		 * associateRelease(org.dicom4j.network.association.Association,
		 * org.dicom4j.network.association.associate.AssociateRelease)
		 */
		public void associateRelease(Association association,
				AssociateRelease associateRelease) throws Exception {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.dicom4j.network.association.listeners.AssociationListener#
		 * associationAborted(org.dicom4j.network.association.Association,
		 * org.dicom4j.network.association.associate.AssociateAbort)
		 */
		public void associationAborted(Association association,
				AssociateAbort associateAbort) throws Exception {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.dicom4j.network.association.listeners.AssociationListener#
		 * associationCreated(org.dicom4j.network.association.Association)
		 */
		public void associationCreated(Association association) throws Exception {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.dicom4j.network.association.listeners.AssociationListener#
		 * associationOpened(org.dicom4j.network.association.Association,
		 * org.dicom4j.network.association.associate.AssociateSession)
		 */
		public void associationOpened(Association association,
				AssociateSession associateSession) throws Exception {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.dicom4j.network.association.listeners.AssociationListener#
		 * associationRejected(org.dicom4j.network.association.Association,
		 * org.dicom4j.network.association.associate.AssociateReject)
		 */
		public void associationRejected(Association association,
				AssociateReject associateReject) throws Exception {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @seeorg.dicom4j.network.association.listeners.AssociationListener#
		 * associationReleased(org.dicom4j.network.association.Association)
		 */
		public void associationReleased(Association association) throws Exception {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.dicom4j.network.association.listeners.AssociationListener#exceptionCaught
		 * (org.dicom4j.network.association.Association, java.lang.Throwable)
		 */
		public void exceptionCaught(Association association, Throwable cause) {
			// TODO Auto-generated method stub

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.dicom4j.network.association.listeners.AssociationListener#messageReceived
		 * (org.dicom4j.network.association.Association, byte,
		 * org.dicom4j.network.dimse.messages.DimseMessage)
		 */
		public void messageReceived(Association association,
				byte presentationContextID, DimseMessage message) throws Exception {
			// TODO Auto-generated method stub

		}

	}

	public class SCPWorker extends Thread implements
	org.dolmen.core.lang.thread.Worker {

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.dolmen.lang.thread.Worker#doWork(java.lang.Object)
		 */
		public Object doWork(Object aData) throws Exception {
			// we configure Transport
			TransportAcceptorConfiguration lConfig = new TransportAcceptorConfiguration();
			TransportAcceptor lAcceptor = new TransportAcceptor();
			lAcceptor.setConfiguration(lConfig);

			// we configure the AssociationAcceptor
			AssociationAcceptorConfiguration lAssocConfig = new AssociationAcceptorConfigurationImpl();
			lAssocConfig
			.setAssociateRequestHandler(MockDicomServer.this.AssociateRequestHandler);
			lAssocConfig
			.setAssociationListener(MockDicomServer.this.AssociationListener);
			lAssocConfig.setTransportAcceptor(lAcceptor);
			// we create the AssociationAcceptor
			// AssociationAcceptor lAssoc = new AssociationAcceptorImpl();
			// MockServer.this.fAcceptor.setConfiguration(lAssocConfig);
			// fAcceptor.setTransportAcceptor(lAcceptor);
			// MockServer.this.fAcceptor.bind(Data.defaultTestPort);
			return null;
		}
	}

	public boolean acceptVerification = false;

	public AssociateRequestHandler AssociateRequestHandler = new DefaultAssociateRequestHandler();

	public AssociationListener AssociationListener = new DefaultAssociationListener();

	private ExceptionListener exceptionListener;

	private AssociationAcceptor fAcceptor = new AssociationAcceptorImpl();

	private WorkerHandler fWorkerHandler;

	private int port;

	public MockDicomServer(ExceptionListener exceptionListener) {
		this.exceptionListener = exceptionListener;
		assert this.exceptionListener != null;
		this.fAcceptor.getConfiguration().setAssociateRequestHandler(
				new MockDicomServerAssociateRequestHandler());
		this.fAcceptor.getConfiguration().setAssociationListener(
				new MockDicomServerAssociationListener());

	}

	public MockDicomServer(WorkerHandler aWorkerHandler) {
		this.fWorkerHandler = aWorkerHandler;
		assert this.fWorkerHandler != null;
	}

	/**
	 * @return Returns the port.
	 */
	public int getPort() {
		return this.port;
	}

	/**
	 * @param port
	 *          The port to set.
	 */
	public void setPort(int port) {
		this.port = port;
	}

	public void start() {
		try {
			this.fAcceptor.bind(this.getPort());
		} catch (Exception ex) {
			this.exceptionListener.exceptionOccurs(ex);
		}
	}

	public void startWithException() throws Exception {
		this.fAcceptor.bind(this.getPort());
	}

	public void stopWithException() throws Exception {
		this.fAcceptor.unBind(this.getPort());
		/*
		 * if (this.fAcceptor != null) {
		 * this.fAcceptor.unBind(Data.defaultTestPort); }
		 */

	}

}
