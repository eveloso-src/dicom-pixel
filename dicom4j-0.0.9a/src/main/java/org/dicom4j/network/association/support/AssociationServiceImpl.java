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

import java.util.List;

import org.apache.mina.common.IoSession;
import org.apache.mina.common.TransportType;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.SocketSessionConfig;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationConfiguration;
import org.dicom4j.network.association.AssociationService;
import org.dicom4j.network.association.AssociationServiceConfiguration;
import org.dicom4j.network.association.associate.AssociatePrimitiveFactory;
import org.dicom4j.network.association.listeners.AssociationListener;
import org.dicom4j.network.association.listeners.AssociationMonitor;
import org.dicom4j.network.association.transport.codec.DicomProtocolCodecFactory;
import org.dicom4j.network.dimse.DimseMessageFactory;
import org.dolmen.network.transport.TransportLoggerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link AssociationService} implements
 * 
 * @since 0.0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AssociationServiceImpl implements AssociationService {

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(AssociationServiceImpl.class);

	/**
	 * to manage associations
	 */
	private AssociationManager associationManager;

	public AssociationServiceImpl() {
		super();
		this.associationManager = new AssociationManager();
	}

	public void abortAssociations() {
		this.associationManager.abortAssociations();
	}

	protected void configureAssociation(Association aAssociation) {
		this.associationManager.addAssocation(aAssociation);
		if (this.getAssociationListener() != null) {
			aAssociation.setAssociationListener(this.getAssociationListener());
		}
		if (this.getAssociationMonitor() != null) {
			aAssociation.setMonitor(this.getAssociationMonitor());
		}
	}

	protected void configureIOSession(IoSession session, Association association)
	throws Exception {
		logger.debug("Trying to configure IOSession");
		if (session == null) {
			throw new NullPointerException(
			"configureIOSession: a session must be provided");
		}
		session.getFilterChain().addFirst("Logging",
				new TransportLoggerFilter("TransportLoggerFilter"));
		DicomProtocolCodecFactory codecFactory = new DicomProtocolCodecFactory();
		codecFactory.setSopClassRegistry(this.getConfiguration()
				.getSopClassRegistry());
		codecFactory.setTransferSyntaxRegistry(this.getConfiguration()
				.getTransferSyntaxRegistry());
		session.getFilterChain().addLast("Protocol Data Unit Codec",
				new ProtocolCodecFilter(codecFactory));
		session.getFilterChain().addLast("Association",
				(AssociationImpl) association);
		if (session.getTransportType() == TransportType.SOCKET) {
			((SocketSessionConfig) session.getConfig()).setReceiveBufferSize(65000);
			((SocketSessionConfig) session.getConfig()).setSendBufferSize(65000);
		}
		logger.debug("IOSession configured");
	}

	public int count() {
		return this.getAssociations().size();
	}

	protected Association createAssociation(IoSession session) throws Exception {
		logger.debug("Trying to create an Association");
		AssociationConfiguration config = this.createAssociationConfiguration(); // new
		// AssociationConfigurationImpl();
		/*
		 * config.setARTIMTimeOut( getConfiguration().getARTIMTimeOut() );
		 * config.setAssociationListener(
		 * getConfiguration().getAssociationListener() );
		 * config.setAssociateRequestHandler(
		 * getConfiguration().getAssociateRequestHandler() );
		 * config.setAssociateResponseHandler(
		 * getConfiguration().getAssociateResponseHandler() );
		 * config.setDimseMessageFactory(
		 * getConfiguration().getDimseMessageFactory());
		 * config.setTransferSyntaxRegistry(
		 * getConfiguration().getTransferSyntaxRegistry() );
		 * config.setSopClassRegistry( getConfiguration().getSopClassRegistry() );
		 */

		Association association = new AssociationImpl(config);
		this.configureIOSession(session, association);
		this.associationManager.addAssocation(association);
		logger.debug("Association created");
		return association;
	}

	/*
	 * protected Association createAssociation(IoSession session,
	 * AssociationListener listener) throws Exception {
	 * logger.debug("Trying to create an Association");
	 * AssociationConfigurationImpl config = new AssociationConfigurationImpl();
	 * config.setARTIMTimeOut( getConfiguration().getARTIMTimeOut() );
	 * config.setAssociationListener( listener ); config.setMonitor(
	 * getConfiguration().getAssociationMonitor() );
	 * 
	 * //config.setAssociateRequestHandler(
	 * getConfiguration().getAssociateRequestHandler() );
	 * config.setAssociateResponseHandler(
	 * getConfiguration().getAssociateResponseHandler() );
	 * config.setDimseMessageFactory(
	 * getConfiguration().getDimseMessageFactory());
	 * config.setTransferSyntaxRegistry(
	 * getConfiguration().getTransferSyntaxRegistry() );
	 * config.setSopClassRegistry( getConfiguration().getSopClassRegistry() );
	 * 
	 * Association association = new AssociationImpl( config );
	 * this.configureIOSession(session, association);
	 * this.associationManager.addAssocation(association);
	 * logger.info("Association created"); logger.debug("Association created: " +
	 * association.toString() ); return association; }
	 */

	protected abstract AssociationConfiguration createAssociationConfiguration();

	/*
	 * { AssociationConfigurationImpl config = new AssociationConfigurationImpl();
	 * config.setARTIMTimeOut( getConfiguration().getARTIMTimeOut() );
	 * config.setAssociationListener( getConfiguration().getAssociationListener()
	 * ); //config.setAssociateRequestHandler(
	 * getConfiguration().getAssociateRequestHandler() );
	 * config.setAssociateResponseHandler(
	 * getConfiguration().getAssociateResponseHandler() );
	 * config.setDimseMessageFactory(
	 * getConfiguration().getDimseMessageFactory());
	 * config.setTransferSyntaxRegistry(
	 * getConfiguration().getTransferSyntaxRegistry() );
	 * config.setSopClassRegistry( getConfiguration().getSopClassRegistry() );
	 * return config; }
	 */

	public AssociatePrimitiveFactory getAssociatePrimitiveFactory() {
		return this.getConfiguration().getAssociatePrimitiveFactory();
	}

	public AssociationListener getAssociationListener() {
		return this.getConfiguration().getAssociationListener();
	}

	public AssociationMonitor getAssociationMonitor() {
		return this.getConfiguration().getAssociationMonitor();
	}

	public List<Association> getAssociations() {
		return this.getManager().getAssociations();
	}

	protected abstract AssociationServiceConfiguration getConfiguration();

	protected AssociationManager getManager() {
		assert this.associationManager != null;
		return this.associationManager;
	}

	public DimseMessageFactory getMessageFactory() {
		return this.getConfiguration().getDimseMessageFactory();
	}

}
