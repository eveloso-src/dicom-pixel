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

import org.apache.mina.common.IoSession;
import org.apache.mina.common.TransportType;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.transport.socket.nio.SocketSessionConfig;
import org.apache.mina.util.SessionUtil;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationConfiguration;
import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.transport.codec.DicomProtocolCodecFactory;
import org.dolmen.network.transport.TransportLoggerFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * to manage {@link org.dicom4j.network.association.Association Associations}
 * created by
 * {@link org.dicom4j.network.association.AssociationAcceptor AssociationAcceptor}
 * or
 * {@link org.dicom4j.network.association.AssociationConnector AssociationConnector}.
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */

/**
 * Implementation of AssociationManager
 */
public class AssociationManager {

	private class AssociationConfigurator extends Thread {

		// private AssociateRequestHandler fAssociateRequestHandler;
		// private AssociationListener fListener;
		private Logger AssociationConfigurator_LOGGER = LoggerFactory
		.getLogger(AssociationConfigurator.class);

		private AssociationConfiguration fConfig;

		private IoSession fSession;

		public AssociationConfigurator(IoSession session,
				AssociationConfiguration aConfiguration) {
			if (session == null) {
				throw new NullPointerException("session");
			}
			this.setName("AssociationConfigurator-" + session.getCreationTime());
			this.fSession = session;
			this.fConfig = aConfiguration;
		}

		@Override
		public void run() {
			this.AssociationConfigurator_LOGGER.debug("start");
			try {
				logger.debug("sessionCreated (" + this.fSession + " )");
				SessionUtil.initialize(this.fSession);
				this.fSession.getFilterChain().addFirst("Logging",
						new TransportLoggerFilter("TransportLoggerFilter"));
				this.fSession.getFilterChain().addLast("Protocol Data Unit Codec",
						new ProtocolCodecFilter(new DicomProtocolCodecFactory()));

				if (this.fSession.getTransportType() == TransportType.SOCKET) {
					((SocketSessionConfig) this.fSession.getConfig())
					.setReceiveBufferSize(65000);
					((SocketSessionConfig) this.fSession.getConfig())
					.setSendBufferSize(65000);
				}
				Association lAssoc = null;
				// new AssociationImpl();
				if (this.fConfig == null) {
					lAssoc = new AssociationImpl();
				} else {
					lAssoc = new AssociationImpl(this.fConfig);
					// lAssoc.setConfiguration(fConfig);
				}
				this.fSession.getFilterChain().addLast("Association",
						(AssociationImpl) lAssoc);
				lAssoc.waitAssociate();
				AssociationManager.this.addAssocation(lAssoc);
			} catch (Exception e) {
				this.AssociationConfigurator_LOGGER.error(e.getMessage());
				// TODO remove assoc if (lAssoc)
			}
			this.AssociationConfigurator_LOGGER.debug("work completed");
		}
	}

	private class AssociationReaper extends Thread {

		public AssociationReaper() {
			super("AssociationReaper");
		}

		@Override
		public void run() {
			try {
				while (true) {
					Thread.sleep(5000);
					for (int i = 0; i < AssociationManager.this.fAssociations.size(); i++) {
						Association lAssoc = AssociationManager.this.getAssociation(i);
						if (lAssoc.isReleased()) {
							logger.debug("[AssociationReaper] " + lAssoc.toString()
									+ " removed");
							AssociationManager.this.fAssociations.remove(lAssoc);
						}
					}
				}
			} catch (Exception e) {
				logger.error("[AssociationReaper] " + e.getMessage());
			}

		}
	}

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(AssociationManager.class);

	/**
	 * the reaper to remove released associations
	 */
	private AssociationReaper fAssociationReaper;

	/**
	 * list of associations
	 */
	private List<Association> fAssociations;

	public AssociationManager() {
		super();
		this.fAssociations = new ArrayList<Association>();
		this.fAssociationReaper = new AssociationReaper();
		this.fAssociationReaper.setDaemon(true);
		this.fAssociationReaper.start();
	}

	public synchronized void abortAssocation(Association aAssociation) {
		try {
			aAssociation.sendAbort(AssociateAbort.ServiceUserAbort);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public synchronized void abortAssociations() {
		for (int i = 0; i < this.fAssociations.size(); i++) {
			Association lAssoc = this.getAssociation(i);
			// if not Released, when send a Abort to close the association
			if (!lAssoc.isReleased()) {
				this.abortAssocation(lAssoc);
			}
		}
	}

	public synchronized void addAssocation(Association aAssociation) {
		this.fAssociations.add(aAssociation);
	}

	public void addWaitAssociation(IoSession session,
			AssociationConfiguration aConfiguration) {
		AssociationConfigurator lWorker = new AssociationConfigurator(session,
				aConfiguration);
		lWorker.start();
	}

	public synchronized Association getAssociation(int aItem) {
		return this.fAssociations.get(aItem);
	}

	/*
	 * public void addWaitAssociation(IoSession session, AssociationListener
	 * aListener, AssociateRequestHandler aAssociateRequestHandler) {
	 * AssociationConfigurator lWorker=new AssociationConfigurator(session,
	 * aListener, aAssociateRequestHandler); lWorker.start(); }
	 */

	public List<Association> getAssociations() {
		return this.fAssociations;
	}

	public synchronized void realeaseAssocation(Association aAssociation) {
	}

}
