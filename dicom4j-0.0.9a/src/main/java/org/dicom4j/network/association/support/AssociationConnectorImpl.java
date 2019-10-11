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

package org.dicom4j.network.association.support;

import java.util.ArrayList;
import java.util.List;

import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationConfiguration;
import org.dicom4j.network.association.AssociationConnector;
import org.dicom4j.network.association.AssociationConnectorConfiguration;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.listeners.AssociationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default {@link AssociationConnector AssociationConnector}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociationConnectorImpl extends AssociationServiceImpl implements
AssociationConnector {

	private class ConnectionRequest extends IoHandlerAdapter {

		private AssociateRequest request;

		// private AssociationListener listener;

		public ConnectionRequest(AssociateRequest request) {
			this.request = request;
			// this.listener = listener;
		}

		@Override
		public void sessionCreated(IoSession session) throws Exception {
			synchronized (this) {
				logger.debug("connection opened");
				Association lassoc = AssociationConnectorImpl.this
				.createAssociation(session);
				assert this.request != null;
				// fLogger.debug("trying to send Associate request");
				lassoc.sendAssociate(this.request);
				AssociationConnectorImpl.this.connectionRequests.remove(this);
			}
		}
	}

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(AssociationConnectorImpl.class);

	private AssociationConnectorConfiguration configuration;

	private List<ConnectionRequest> connectionRequests = new ArrayList<ConnectionRequest>();

	/**
	 * create the connector
	 * 
	 */
	public AssociationConnectorImpl() {
		super();
		this.setConfiguration(new AssociationConnectorConfigurationImpl());
	}

	public void connect(String hostName, int port, AssociateRequest request)
	throws Exception {
		logger.debug("connect (hostname: " + hostName + ", port: " + request + ")");
		if (this.getConfiguration().getTransportConnector() == null) {
			throw new NullPointerException(
			"No TransportConnector was set, unable to open a Transport connection");
		}
		if (request == null) {
			throw new NullPointerException(
			"Unable to open Association: no AssociateRequest supplied");
		}
		ConnectionRequest lConnectionRQ = new ConnectionRequest(request);
		this.connectionRequests.add(lConnectionRQ);
		this.getConfiguration().getTransportConnector().openConnection(hostName,
				port, lConnectionRQ);
	}

	public void connect(String hostName, int port, AssociateRequest request,
			AssociationListener listener) throws Exception {
		/*
		 * logger.debug("connect (hostname: " + hostName + ", port: " + request +
		 * ")"); if (this.getConfiguration().getTransportConnector() == null) {
		 * throw new NullPointerException(
		 * "No TransportConnector was set, unable to open a Transport connection");
		 * } if (request == null) { throw new NullPointerException(
		 * "Unable to open Association: no AssociateRequest supplied"); }
		 * ConnectionRequest lConnectionRQ = new ConnectionRequest(request,
		 * listener); this.connectionRequests.add(lConnectionRQ);
		 * this.getConfiguration().getTransportConnector().openConnection(hostName,
		 * port, lConnectionRQ);
		 */
	}

	@Override
	protected AssociationConfiguration createAssociationConfiguration() {
		AssociationConfigurationImpl config = new AssociationConfigurationImpl();
		config.setARTIMTimeOut(this.getConfiguration().getARTIMTimeOut());
		config.setAssociationListener(this.getConfiguration().getAssociationListener());
		config.setAssociateResponseHandler(this.getConfiguration()
				.getAssociateResponseHandler());
		config.setDimseMessageFactory(this.getConfiguration().getDimseMessageFactory());
		config.setTransferSyntaxRegistry(this.getConfiguration()
				.getTransferSyntaxRegistry());
		config.setSopClassRegistry(this.getConfiguration().getSopClassRegistry());
		return config;
	}

	@Override
	/*
	 * public void sessionCreated(IoSession session) throws Exception {
	 * fLogger.error("should not be called"); /*throw new Exception()
	 * synchronized(this) { fLogger.debug("connection opened"); Association
	 * lassoc=createAssociation(session); try { assert fRequest != null;
	 * //fLogger.debug("trying to send Associate request");
	 * lassoc.sendAssociate(fRequest); //fLogger.debug("Associate request
	 * sended"); } catch (Exception e) { //TODO getManager() remove(lassoc); throw
	 * new AssociationException(e.getMessage()); } }
	 */
	// }
	public AssociationConnectorConfiguration getConfiguration() {
		return this.configuration;
	}

	public void setConfiguration(AssociationConnectorConfiguration aConfiguration) {
		assert aConfiguration != null;
		logger.debug("setConfiguration: " + aConfiguration);
		this.configuration = aConfiguration;
	}

	// TODO change implement to allow 1 instance to manage many assoc
	// TODO done be must be well tested

}
