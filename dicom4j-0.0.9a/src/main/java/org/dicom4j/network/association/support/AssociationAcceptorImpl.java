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

import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationAcceptor;
import org.dicom4j.network.association.AssociationAcceptorConfiguration;
import org.dicom4j.network.association.AssociationConfiguration;
import org.dolmen.network.transport.TransportException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default {@link AssociationAcceptor} implements
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociationAcceptorImpl extends AssociationServiceImpl implements
AssociationAcceptor {

	private class SessionAcceptor extends IoHandlerAdapter {

		@Override
		public void sessionCreated(IoSession session) throws Exception {
			synchronized (this) {
				logger.debug("Connection asked");
				Association lAssoc = AssociationAcceptorImpl.this
				.createAssociation(session);
				lAssoc.waitAssociate();
				/*
				 * super.sessionCreated(session); Association lAssoc = null; if (
				 * getConfiguration() == null) { lAssoc =new AssociationImpl(); } else {
				 * lAssoc =new AssociationImpl(getConfiguration()); }
				 * session.getFilterChain().addLast("Association",
				 * (AssociationImpl)lAssoc );
				 */

			}
		}
	}

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(AssociationAcceptor.class);

	private AssociationAcceptorConfiguration configuration;

	private SessionAcceptor sessionAcceptor = new SessionAcceptor();

	public AssociationAcceptorImpl() {
		super();
		this.setConfiguration(new AssociationAcceptorConfigurationImpl());
	}

	public synchronized void bind(int aPort) throws Exception {
		logger.debug("bind (port: " + aPort + ")");
		if (this.getConfiguration() == null) {
			throw new Exception(
			"No Configuration was set, unable to accept connection");
		}
		if (this.getConfiguration().getTransportAcceptor() == null) {
			throw new TransportException(
			"No TransportAcceptor was set, unable to accept connection");
		}
		this.getConfiguration().getTransportAcceptor().bind(aPort,
				this.sessionAcceptor);
		logger.info("Accepting Associations on port " + aPort);
	}

	@Override
	protected AssociationConfiguration createAssociationConfiguration() {
		AssociationConfigurationImpl config = new AssociationConfigurationImpl();
		config.setARTIMTimeOut(this.getConfiguration().getARTIMTimeOut());
		config.setAssociationListener(this.getConfiguration().getAssociationListener());
		config.setAssociateRequestHandler(this.getConfiguration()
				.getAssociateRequestHandler());
		config.setAssociateResponseHandler(this.getConfiguration()
				.getAssociateResponseHandler());
		config.setDimseMessageFactory(this.getConfiguration().getDimseMessageFactory());
		config.setTransferSyntaxRegistry(this.getConfiguration()
				.getTransferSyntaxRegistry());
		config.setSopClassRegistry(this.getConfiguration().getSopClassRegistry());
		return config;
	}

	/*
	 * public void setAssociateRequestListener(AssociateRequestHandler aListener)
	 * { fAssociateRequestListener = aListener; }
	 * 
	 * public AssociateRequestHandler getAssociateRequestListener() { return
	 * fAssociateRequestListener; }
	 */

	/**
	 * return the current configuration
	 * 
	 * @return
	 */
	@Override
	public AssociationAcceptorConfiguration getConfiguration() {
		return this.configuration;
	}

	/**
	 * set the configuration to use
	 * 
	 * @param aConfiguration
	 */
	public void setConfiguration(AssociationAcceptorConfiguration aConfiguration) {
		this.configuration = aConfiguration;
	}

	public void unBind(int aPort) throws Exception {
		logger.debug("unBind (port: " + aPort + ")");
		this.abortAssociations();
		this.getConfiguration().getTransportAcceptor().unBind(aPort);
	}

}
