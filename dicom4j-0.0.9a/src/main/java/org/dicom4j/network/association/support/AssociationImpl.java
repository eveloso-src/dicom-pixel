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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.mina.common.IoFilterAdapter;
import org.apache.mina.common.IoSession;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.network.NetworkStaticProperties;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationClosedException;
import org.dicom4j.network.association.AssociationConfiguration;
import org.dicom4j.network.association.AssociationException;
import org.dicom4j.network.association.AssociationState;
import org.dicom4j.network.association.AsynOperationsWindow;
import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.associate.AssociateReject;
import org.dicom4j.network.association.associate.AssociateRelease;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateResponse;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.AssociateRequestHandler;
import org.dicom4j.network.association.listeners.AssociateResponseHandler;
import org.dicom4j.network.association.listeners.AssociationListener;
import org.dicom4j.network.association.listeners.AssociationMonitor;
import org.dicom4j.network.dimse.DimseMessageFactory;
import org.dicom4j.network.dimse.codec.DimseMessageCodecFactory;
import org.dicom4j.network.dimse.codec.DimseMessageEncoder;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.dimse.messages.support.AbstractDimseMessage;
import org.dicom4j.network.protocoldataunit.AReleaseRPPDU;
import org.dicom4j.network.protocoldataunit.AReleaseRQPDU;
import org.dicom4j.network.protocoldataunit.AssociateACPDU;
import org.dicom4j.network.protocoldataunit.AssociateRJPDU;
import org.dicom4j.network.protocoldataunit.PDataTFPDU;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnits;
import org.dicom4j.network.protocoldataunit.pdu.AAbortPDU;
import org.dicom4j.network.protocoldataunit.pdu.AssociateRQPDU;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default {@link Association Association} implementation
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociationImpl extends IoFilterAdapter implements Association {
	/*
	 * private class AssociationListenerDispatcher extends Thread {
	 * 
	 * protected Association fAssociation;
	 * 
	 * protected AssociationListener fListener;
	 * 
	 * public AssociationListenerDispatcher(Association aAssociation,
	 * AssociationListener aListener) { fAssociation = aAssociation; fListener =
	 * aListener; setName("AssociationListenerDispatcher"); }
	 * 
	 * @Override public void run() { super.run(); try {
	 * fListener.associationOpened(fAssociation, null); } catch (Throwable e) {
	 * fListener.exceptionCaught(fAssociation, e); } } }
	 * 
	 * /* private class AssociationOpenedDispatcher extends
	 * AssociationListenerDispatcher {
	 * 
	 * private AssociateSession aSession;
	 * 
	 * public AssociationOpenedDispatcher(Association aAssociation,
	 * AssociationListener aListener, AssociateSession aSession) {
	 * super(aAssociation, aListener); setName("AssociationOpenedDispatcher"); }
	 * 
	 * @Override public void run() { super.run(); try {
	 * fListener.associationOpened(fAssociation, null); } catch (Throwable e) {
	 * fListener.exceptionCaught(fAssociation, e); } } }
	 */

	// private static final AssociateEventDispatcher Associate_Event_Dispatcher =
	// new AssociateEventDispatcher();

	/**
	 * The logger
	 */
	protected static final Logger logger = LoggerFactory
	.getLogger(Association.class);

	// protected static final DimseMessageCodecFactory Message_Codec_Factory = new
	// DimseMessageCodecFactory();

	/**
	 * the ARTIM Timer
	 */
	private ARTIMTimer artimTimer;

	/**
	 * parameters of the Association (if established)
	 */
	private AssociateSession associateSession;

	private AsynOperationsWindowImpl asynOperationsWindow;

	/**
	 * Attibutes attached to an Assocation
	 */
	private final Map<String, Object> attributes = new HashMap<String, Object>();

	/**
	 * The Configuration
	 */
	private AssociationConfiguration configuration;

	private DimseMessageCodecFactory dimseMessageCodecFactory;

	/**
	 * The TCP/IP session
	 */
	private IoSession ioSession;

	/**
	 * To notify when this association is in release state
	 */
	private boolean isReleased;

	/**
	 * To known if the Association is in SCP or SCU
	 */
	private boolean isSCP;

	protected AssociateRequest request;

	protected AssociateResponse response;

	/**
	 * Internal Association State
	 */
	private int state;

	public AssociationImpl() throws Exception {
		this(new AssociationConfigurationImpl());
	}

	public AssociationImpl(AssociationConfiguration configuration)
	throws Exception {
		super();
		this.setConfiguration(configuration);
		this.isReleased = false;
		this.isSCP = false;
		this.associateSession = null;
		this.asynOperationsWindow = new AsynOperationsWindowImpl();
		this.request = null;
		this.response = null;
		this.dimseMessageCodecFactory = new DimseMessageCodecFactory(this);
		this.artimTimer = new ARTIMTimer(this, configuration.getARTIMTimeOut());
		this.setState(AssociationState.IDLE);
		this.getAssociationListener().associationCreated(this);
	}

	public void closeTransportConnection(boolean aWaitARTIM)
	throws AssociationException {
		this.setState(AssociationState.AWAITING_TRANSPORT_CONNECTION_CLOSE);
		if (aWaitARTIM == true) {
			// TODO should wait ARTIM
		}
		try {
			if (this.ioSession != null) {
				this.ioSession.close();
			} else {
				logger.warn("closeIoSession: ioSession is null");
			}
		} catch (Throwable e) {
			logger.error("closeIoSession: " + e.getMessage());
		}
	}

	public boolean containsAttribute(String key) {
		return this.getAttribute(key) != null;
	}

	// TODO add a AssociateRequestHandler

	public void exceptionCaught(Throwable cause) throws Exception {
		logger.error("Event: exception occurs (message: " + cause.getMessage()
				+ ")");
		this.getAssociationListener().exceptionCaught(this, cause);
	}

	public AssociateRequest getAssociateRequest() {
		return this.request;
	}

	public AssociateResponseHandler getAssociateResponseListener() {
		return this.getConfiguration().getAssociateResponseHandler();
	}

	public AssociateSession getAssociateSession() {
		return this.associateSession;
	}

	public AssociationListener getAssociationListener() {
		return this.getConfiguration().getAssociationListener();
	}

	public AsynOperationsWindow getAsynOperationsWindow() {
		return this.asynOperationsWindow;
	}

	public Object getAttachment() {
		synchronized (this.attributes) {
			return this.attributes.get("");
		}
	}

	public Object getAttribute(String key) {
		synchronized (this.attributes) {
			return this.attributes.get(key);
		}
	}

	public Set<String> getAttributeKeys() {
		synchronized (this.attributes) {
			return new HashSet<String>(this.attributes.keySet());
		}
	}

	public AssociationConfiguration getConfiguration() {
		return this.configuration;
	}

	/*
	 * public byte getSuitablePresentationContextID(String abstractSyntaxUID) {
	 * assert fAssociateRequest != null; assert fAssociateResponse != null; byte
	 * lPres = fAssociateRequest.getPresentationContextId(abstractSyntaxUID); if
	 * (fAssociateResponse.isAccepted(lPres) ) return lPres; else return 0; }
	 */

	protected IoSession getIoSession() {
		assert this.ioSession != null;
		return this.ioSession;
	}

	/**
	 * @return Returns the messageFactory.
	 */
	public DimseMessageFactory getMessageFactory() {
		return this.getConfiguration().getDimseMessageFactory();
	}

	public AssociationMonitor getMonitor() {
		return this.getConfiguration().getAssociationMonitor();
	}

	/**
	 * Return the current state of the Association
	 * 
	 * @return the State
	 */
	protected int getState() {
		return this.state;
	}

	public String getTransferSyntaxFromPresentationID(byte aPresentationID) {
		return this.response.getTransferSyntaxUID(aPresentationID);
	}

	protected void handleAssociateAAbortPDU(AAbortPDU aPDU) throws Exception {
		assert aPDU != null;
		logger.info("Associate Abort received");
		if (this.getState() == AssociationState.ASSOCIATION_ESTABLISHED_READY_FOR_DATA_TRANSFERT) {
			this.closeTransportConnection(false);
			this.getAssociationListener().associationAborted(this,
					new AssociateAbort(aPDU));
		}

		if (this.getState() == AssociationState.AWAITING_A_RELEASE_RP) {
			AssociateAbort lAbort = new AssociateAbort(aPDU);
			if (lAbort.getSource() == NetworkStaticProperties.AssociateAbortSource.SERVICE_USER) {
				this.sendAbort(lAbort);
			} else {
				// TODO don't work
				// getAssociationListener().exceptionCaught(this, new
				// NotSpecifiedException() );
			}
			this.closeTransportConnection(false);
			this.getAssociationListener().associationAborted(this, lAbort);
		}
	}

	protected void handleAssociateACPDU(AssociateACPDU aPDU) throws Exception {
		logger.info("Event: Associate Response received");
		if (logger.isDebugEnabled()) {
			logger.debug(aPDU.toString());
		}
		if (this.getState() == AssociationState.AWAITING_ASSOCIATE_AC_RJ) {
			this.response = this.getAssociateResponseListener().responseReceived(
					this, new AssociateResponse(aPDU));
			this.openAssociation(this.getAssociateRequest(), this.response);
		} else {
			logger.warn(this.stateToString()
					+ " is not valid State for handleAssociateACPDU");
			// TODO manage what to do
		}
	}

	/**
	 * Handle an {@link AReleaseRPPDU AReleaseRPPDU} PDU
	 * 
	 * @param aPDU
	 *          the the PDU
	 */
	protected void handleAssociateAReleaseRPPDU(AReleaseRPPDU aPDU)
	throws Exception {
		assert aPDU != null;
		logger.info("Event: Associate Release Response received");
		// fLogger.debug("A-Release-RP: " + aPDU.toString());
		if (this.getState() == AssociationState.AWAITING_A_RELEASE_RP) {
			// getAssociationListener().associationReleased(this);
			this.closeTransportConnection(false);
		} else {
			logger.warn("handleAssociateAReleaseRPPDU: TODO");
		}
	}

	protected void handleAssociateAReleaseRQPDU(AReleaseRQPDU aPDU)
	throws Exception {
		assert aPDU != null;
		try {
			logger.info("Event: Associate Release Request received");
			// fLogger.debug("A-Release-RP: " + aPDU.toString());
			if (this.getState() == AssociationState.ASSOCIATION_ESTABLISHED_READY_FOR_DATA_TRANSFERT) {
				this.getAssociationListener().associateRelease(this,
						new AssociateRelease(aPDU));
			}
		} catch (Exception e) {
			this.throwException(e);
		}
		// sendReleaseRequest();
		// TODO start timer instead
		// closeConnection(false);
	}

	protected void handleAssociateRequest(AssociateRQPDU aPDU) throws Exception {
		try {
			AssociateRequest lRequest = new AssociateRequest(aPDU);
			logger.info("Event: Associate Request received");
			logger.debug(aPDU.toString());
			this.getMonitor().associateRequestReceived(this, lRequest);
			if (this.getState() == AssociationState.AWAITING_A_ASSOCIATE) {
				logger.debug("transmiting request to "
						+ this.getConfiguration().getAssociateRequestHandler().toString());
				this.response = this.getConfiguration().getAssociateRequestHandler()
				.requestReceived(this, new AssociateRequest(aPDU));
				if (this.response != null) {
					// fLogger.debug("Associate Response: " +
					// fAssociateResponse.toString() );
					logger.info("Event: send Associate Response");
					if (logger.isDebugEnabled()) {
						logger.debug("Response:\n" + this.response.toString());
					}
					this.sendProtocolDataUnit(this.response.getProtocolDataUnit());
					this.openAssociation(lRequest, this.response);
				} else {
					this
					.sendReject(
							NetworkStaticProperties.AssociateRejectResult.REJECTED_PERMANENT,
							NetworkStaticProperties.AssociateRejectSource.DICOM_UL_SERVICE_PROVIDER_ACSE,
							(byte) 1); // no reason
					this.closeTransportConnection(false);
				}
			}
		} catch (Exception e) {
			this.throwException(e);
			logger
			.warn("Exception in handleAssociateRequestPDU, we send back a Reject");
			this
			.sendReject(
					NetworkStaticProperties.AssociateRejectResult.REJECTED_PERMANENT,
					NetworkStaticProperties.AssociateRejectSource.DICOM_UL_SERVICE_PROVIDER_ACSE,
					(byte) 1); // no reason
			this.closeTransportConnection(false);
		}
	}

	/**
	 * Handle an AssociateRJPDU PDU
	 * 
	 * @param aPDU
	 * @throws Exception
	 */
	protected void handleAssociateRJPDU(AssociateRJPDU aPDU) throws Exception {
		assert aPDU != null;
		logger.info("Associate Reject received");
		if (this.getState() == AssociationState.AWAITING_ASSOCIATE_AC_RJ) {
			// fLogger.info("We received: " + aPDU.getName());
			this.closeTransportConnection(false); // don't wait ARTIM
			this.getAssociationListener().associationRejected(this,
					new AssociateReject(aPDU));
			// getAssociationHandler().exceptionCaught(this, new
			// AssociationException(aPDU.toString()) );
		}
	}

	protected void handleMessageReceived(byte aPresentationID,
			AbstractDimseMessage aMessage) throws Exception {
		// try {
		logger.info("Event: " + aMessage.getName() + " received");
		this.manageAsynOperationsWindow(aMessage.getMessageID());
		if (logger.isDebugEnabled()) {
			logger.debug("DimseMessage: \n" + aMessage.getCommandSet().toString());
		}
		this.getAssociationListener().messageReceived(this, aPresentationID,
				aMessage);
		// Associate_Event_Dispatcher.messageReceived(this,
		// getAssociationListener(), aPresentationID, aMessage);
		// getAssociationListener().messageReceived(this, aPresentationID,
		// aMessage);
		this.getMonitor().messageReceived(this, aMessage);
		// } catch (Exception ex) {
		// exceptionCaught(ex);
		// throwException(e);
		// }
	}

	/**
	 * handle a {@link PDataTFPDU} received from the remote peer
	 * 
	 * @param pDataTF
	 *          the PDU
	 * @throws Exception
	 */
	protected void handlePDataPDU(PDataTFPDU pDataTF) throws Exception {
		assert pDataTF != null;
		try {
			logger.debug("handlePDataPDU (" + this.stateToString() + ")");
			if (this.getState() == AssociationState.ASSOCIATION_ESTABLISHED_READY_FOR_DATA_TRANSFERT) {
				this.dimseMessageCodecFactory.getDecoder().decode(pDataTF);
				if (this.dimseMessageCodecFactory.getDecoder().isDone()) {
					logger.debug("Dimse message completely received");
					AbstractDimseMessage lMessage = this.dimseMessageCodecFactory
					.getDecoder().getDecodedMessage();
					byte lPres = this.dimseMessageCodecFactory.getDecoder()
					.getPresentationContextID();
					this.dimseMessageCodecFactory.getDecoder().clear();
					this.handleMessageReceived(lPres, lMessage);
				}
			} else {
				// TODO
			}
		} catch (Exception e) {
			this.throwException(e);
		}
	}

	/**
	 * Determine if an association is established
	 * 
	 * @return True if open
	 */
	public boolean isEstablished() {
		return this.getState() == AssociationState.ASSOCIATION_ESTABLISHED_READY_FOR_DATA_TRANSFERT;
	}

	public boolean isReleased() {
		return this.isReleased;
	}

	private synchronized void manageAsynOperationsWindow(int aMessageID) {
		AsynOperation lOp = this.asynOperationsWindow.getAsynOperation(aMessageID);
		if (lOp == null) {
			this.asynOperationsWindow.addAsynOperation(aMessageID);
		} else {
			this.asynOperationsWindow.removeAsynOperation(aMessageID);
		}
		logger.debug("AsynOperation remaining : "
				+ this.asynOperationsWindow.count());
	}

	@Override
	public void messageReceived(NextFilter nextFilter, IoSession session,
			Object message) {
		try {
			this.artimTimer.stop();
			AbstractProtocolDataUnit lPDU = (AbstractProtocolDataUnit) message;
			// fLogger.debug("messageReceived: " + lPDU.getName());
			if (this.getMonitor() != null) {
				this.getMonitor().protocolDataUnitReceived(this, lPDU);
			}
			if (lPDU instanceof AssociateRQPDU) {
				this.handleAssociateRequest((AssociateRQPDU) lPDU);
			} else if (lPDU instanceof AssociateACPDU) {
				this.handleAssociateACPDU((AssociateACPDU) lPDU);
			} else if (lPDU instanceof AssociateRJPDU) {
				this.handleAssociateRJPDU((AssociateRJPDU) lPDU);
			} else if (lPDU instanceof PDataTFPDU) {
				this.handlePDataPDU((PDataTFPDU) lPDU);
			} else if (lPDU instanceof AReleaseRPPDU) {
				this.handleAssociateAReleaseRPPDU((AReleaseRPPDU) lPDU);
			} else if (lPDU instanceof AReleaseRQPDU) {
				this.handleAssociateAReleaseRQPDU((AReleaseRQPDU) lPDU);
			} else if (lPDU instanceof AAbortPDU) {
				this.handleAssociateAAbortPDU((AAbortPDU) lPDU);
			} else {
				throw new AssociationException(this, "Unexpected PDU");
			}
			nextFilter.messageReceived(session, message);
		} catch (Throwable e) {
			this.throwException(e);
			logger.error("messageReceived: " + e.getMessage());
			try {
				if (this.getAssociationListener() != null) {
					this.getAssociationListener().exceptionCaught(this, e.getCause());
				}
			} catch (Exception ex) {
				logger.error("messageReceived: " + e.getMessage());
			}
		}

	}

	@Override
	public void messageSent(NextFilter nextFilter, IoSession session,
			Object message) {
		logger.info("Event: data sent");
		nextFilter.messageSent(session, message);
	}

	/**
	 * called when a Association can be opened
	 * 
	 * @param aAssociateResponse
	 *          the Associate Response
	 * @throws Exception
	 */
	protected void openAssociation(AssociateRequest aRequest,
			AssociateResponse aResponse) throws Exception {
		logger.debug("openAssociation");
		this.associateSession = new AssociateSession(this.getIoSession(), aRequest,
				aResponse); // when create an AssociateSession
		this
		.setState(AssociationState.ASSOCIATION_ESTABLISHED_READY_FOR_DATA_TRANSFERT); // State
		// 6
		this.getMonitor().associationOpened(this, this.associateSession);

		// 3
		this.getAssociationListener()
		.associationOpened(this, this.associateSession);
		// AssociateEventDispatcher lTest = new AssociateEventDispatcher(this,
		// getAssociationListener());
		// lTest.associationOpened(this, getAssociationListener(),
		// fAssociateSession);

		// 2
		// AssociationListenerDispatcher la =new AssociationListenerDispatcher(this,
		// getAssociationListener());
		// la.start();

		// 1
		// getAssociationListener().associationOpened(this, fAssociateSession);
	}

	public Object removeAttribute(String key) {
		synchronized (this.attributes) {
			return this.attributes.remove(key);
		}
	}

	public void sendAbort(AssociateAbort aAbort) throws Exception {
		logger.info("Event: send Associate Abort");
		if (this.getIoSession() == null) {
			throw new AssociationException(this,
			"No IoSession, unable to send Associate Abort");
		}
		this.getAssociationListener().associationAborted(this, aAbort);
		if (this.getMonitor() != null) {
			this.getMonitor().abortSent(this, aAbort);
		}
		logger.debug(aAbort.toString());
		// We send Abort, and close connection even if exception occurs
		try {
			this.sendProtocolDataUnit(aAbort.getProtocolDataUnit());
		} catch (Throwable e) {
			this.exceptionCaught(e);
		}
		if (this.getState() != AssociationState.IDLE) {
			this.closeTransportConnection(false);
		}
	}

	public void sendAssociate(AssociateRequest aRequest) throws Exception {
		logger.info("Event: send Associate Request");
		this.getMonitor().associateSent(this, aRequest);
		if (logger.isDebugEnabled()) {
			logger.debug(aRequest.getProtocolDataUnit().toString());
		}
		this.setAssociateRequest(aRequest);
		this.response = null;
		this.isSCP = false;
		this.setState(AssociationState.AWAITING_TRANSPORT_CONNECTION_OPENING); // State
		// 4
	}

	public void sendMessage(byte aPresentationContextID, DimseMessage aMessage)
	throws Exception {
		if (!this.isEstablished()) {
			throw new AssociationClosedException(this,
			"unable to send a DimseMessage, no Association was established");
		}
		logger.info("Event: must send " + aMessage.getName());
		if (logger.isDebugEnabled()) {
			logger.debug("DimseMessage: \n" + aMessage.getCommandSet().toString());
		}
		this.manageAsynOperationsWindow(aMessage.getMessageID());
		try {
			TransferSyntax lTransferSyntaxforDataSet = this.getAssociateSession()
			.getTransferSyntax(aPresentationContextID);
			DimseMessageEncoder lEncoder = this.dimseMessageCodecFactory.getEncoder();
			ProtocolDataUnits lPDUs = lEncoder.encode(aPresentationContextID,
					lTransferSyntaxforDataSet, aMessage, (int) this.getAssociateSession()
					.getMaximumLength());
			if (this.getMonitor() != null) {
				this.getMonitor().messageSent(this, aMessage);
			}
			logger.info("Event: message " + aMessage.getName() + " sended");
			this.sendProtocolDataUnit(lPDUs); // when can send all PData-TF
		} catch (Exception e) {
			this.manageAsynOperationsWindow(aMessage.getMessageID()); // it will
			// remove the
			// message from
			// the list of
			// operations
			throw new AssociationException(this, e);
		}
	}

	/**
	 * Send a PDU
	 * 
	 * @param aPDU
	 * @throws Exception
	 */
	protected void sendProtocolDataUnit(ProtocolDataUnit aPDU) throws Exception {
		try {
			logger.debug("We send " + aPDU.toString());
			this.getIoSession().write(aPDU);
			if (this.getMonitor() != null) {
				this.getMonitor().protocolDataUnitSent(this, aPDU);
			}
		} catch (Exception e) {
			logger.error("sendProtocolDataUnit: " + e.getMessage());
			if ((this.getState() == AssociationState.TRANSPORT_CONNECTION_OPEN)
					|| (this.getState() == AssociationState.AWAITING_TRANSPORT_CONNECTION_CLOSE)) {
				this.closeTransportConnection(false);
			}
			throw e;
		}
	}

	/**
	 * Send a list of PDUs. this way is more efficient to send many PData
	 * 
	 * @param aPDUs
	 * @throws Exception
	 */
	protected void sendProtocolDataUnit(ProtocolDataUnits aPDUs) throws Exception {
		if (this.getIoSession() == null) {
			throw new AssociationException(this,
			"No IoSession, unable to send Protocol Data Unit(s) ");
		}
		try {
			logger.debug("We send a list a ProtocolDataUnit (number: "
					+ aPDUs.count() + ")");
			this.getIoSession().write(aPDUs);
			if (this.getMonitor() != null) {
				for (int i = 0; i < aPDUs.count(); i++) {
					this.getMonitor().protocolDataUnitSent(this, aPDUs.get(i));
				}
			}
		} catch (Exception e) {
			logger.error("sendProtocolDataUnit: " + e.getMessage());
			if ((this.getState() == AssociationState.TRANSPORT_CONNECTION_OPEN)
					|| (this.getState() == AssociationState.AWAITING_TRANSPORT_CONNECTION_CLOSE)) {
				this.closeTransportConnection(false);
			}
			throw e;
		}
	}

	public void sendReject(AssociateReject associateReject) throws Exception {
		logger.info("Event: send Associate Reject"); // (" +
		// aAssociateReject.toString()+")");
		if (this.getIoSession() == null) {
			throw new AssociationException(this,
			"No IoSession Transport, unable to send Associate Reject");
		}
		this.sendProtocolDataUnit(associateReject.getProtocolDataUnit());
		this.getAssociationListener().associationRejected(this, associateReject);
	}

	public void sendReject(byte aResult, byte aSource, byte aReason)
	throws Exception {
		this.sendReject(new AssociateReject(aResult, aSource, aReason));
	}

	public void sendReleaseRequest() throws Exception {
		logger.info("Event: send Associate Release Request");
		this.sendProtocolDataUnit(new AReleaseRQPDU());
		this.setState(AssociationState.AWAITING_A_RELEASE_RP);
		// TODO manage timeout
		/*
		 * byte lPDUType = getTransportLayer().readByte();
		 * fLogger.debug("sendRelease, PDU type readed: " + lPDUType); if (lPDUType
		 * == ProtocolDataUnit.Types.A_RELEASE_RP) { AReleaseRPPDU lPDU = new
		 * AReleaseRPPDU(getTransportLayer().getInputStream()); fLogger.debug("We
		 * received: " + lPDU); CloseConnection(false); // Don't wait ARTIM } else {
		 * fLogger.debug("sendRelease: TODO: " + lPDUType); }
		 */
	}

	public void sendReleaseResponse() throws Exception {
		logger.info("Event: send Associate Release reponse");
		this.sendProtocolDataUnit(new AReleaseRPPDU());
		// ARTIMTimer lTimer = new ARTIMTimer(5000);
		// lTimer.run();
		// TODO should wait ARTIM
		this.closeTransportConnection(false);
		// SetState(AssociationState.AWAITING_A_RELEASE_RP);
	}

	@Override
	public void sessionClosed(NextFilter nextFilter, IoSession session) {
		try {
			// must be before then listener can check if released but Session(s) will
			// stay not null
			this.isReleased = true;
			this.getAssociationListener().associationReleased(this);
			this.getMonitor().onAssociationReleased(this, null);
			this.ioSession = null;
			this.associateSession = null;
			this.request = null;
			this.response = null;
			this.setState(AssociationState.IDLE);
			session = null;
		} catch (Exception ex) {
			this.throwException(ex);
		}
	}

	@Override
	public void sessionCreated(NextFilter nextFilter, IoSession session) {
		nextFilter.sessionCreated(session);
	}

	@Override
	public void sessionOpened(NextFilter nextFilter, IoSession session) {
		try {
			// Thread.sleep(40000);
			logger.debug("sessionOpened");
			this.setIoSession(session);
			this.setState(AssociationState.TRANSPORT_CONNECTION_OPEN); // State 2
			this.artimTimer.start();
			if (this.isSCP) {
				this.setState(AssociationState.AWAITING_A_ASSOCIATE);
			} else {
				// the association is in client mode (SCU), we send the Associate
				// Request
				this.sendProtocolDataUnit(this.getAssociateRequest()
						.getProtocolDataUnit());
				this.setState(AssociationState.AWAITING_ASSOCIATE_AC_RJ); // State 5
			}
		} catch (Exception e) {
			logger.error("sessionOpened: " + e.getMessage());
		}
		nextFilter.sessionOpened(session);
	}

	public void setAssociateRequest(AssociateRequest aRequest) {
		logger.debug("setAssociateRequest");
		this.request = aRequest;
	}

	public void setAssociateRequestListener(AssociateRequestHandler aListener) {
		assert aListener != null;
		logger.debug("setAssociateRequestListener: " + aListener);
		// fAssociateRequestListener = aListener;
	}

	public void setAssociateResponseListener(AssociateResponseHandler aHandler) {
		assert aHandler != null;
		logger.debug("setAssociateResponseListener: " + aHandler);
		// fAssociateResponseHandler = aHandler;
	}

	public void setAssociationListener(AssociationListener aHandler) {
		assert aHandler != null;
		logger.debug("setAssociationListener:" + aHandler);
		// fAssociationHandler = aHandler;
	}

	public Object setAttachment(Object attachment) {
		synchronized (this.attributes) {
			return this.attributes.put("", attachment);
		}
	}

	public Object setAttribute(String key) {
		return this.setAttribute(key, Boolean.TRUE);
	}

	public Object setAttribute(String key, Object value) {
		synchronized (this.attributes) {
			return this.attributes.put(key, value);
		}
	}

	public void setConfiguration(AssociationConfiguration aConfiguration) {
		if (logger.isDebugEnabled()) {
			logger.debug("Configuration.AssociateRequestHandler: "
					+ aConfiguration.getAssociateRequestHandler());
			logger.debug("Configuration.AssociateResponseHandler: "
					+ aConfiguration.getAssociateResponseHandler());
			logger.debug("Configuration.AssociationListener: "
					+ aConfiguration.getAssociationListener());
			logger.debug("Configuration.AssociationMonitor: "
					+ aConfiguration.getAssociationMonitor());
		}
		this.configuration = aConfiguration;
	}

	protected void setIoSession(IoSession aSession) {
		if (aSession == null) {
			throw new NullPointerException("IoSession");
		}
		// IoFilterChain ioFilterChain = aSession.getFilterChain();
		// List<IoFilterChain.Entry> filterChainList = ioFilterChain.getAll();
		// logger.error("setIoSession; filterChainList : " +
		// filterChainList.size());

		this.ioSession = aSession;
		/*
		 * IoFilterChain ioFilterChain = aSession.getFilterChain();
		 * List<IoFilterChain.Entry> filterChainList = ioFilterChain.getAll(); for
		 * (int i=0; i < filterChainList.size(); i++ ) { logger.warn(
		 * filterChainList.get(i).getName() ); logger.warn(
		 * filterChainList.get(i).getFilter().toString() ); //logger.warn(
		 * filterChainList.get(i).getClass().getName() ); IoFilter filter =
		 * filterChainList.get(i).getFilter(); if ( filter instanceof
		 * ExecutorFilter) { logger.warn("Exec"); logger.warn( " " + (
		 * (ExecutorFilter) filter).getExecutor().getClass().getName() );
		 * 
		 * }
		 * 
		 * }
		 */
		// filterChainList.s
		// aSession.getFilterChain();
	}

	public void setMonitor(AssociationMonitor aAssociationMonitor) {
		logger.debug("setMonitor: " + aAssociationMonitor);
		// fAssociationMonitor = aAssociationMonitor;
	}

	/**
	 * Set the new state on the Association
	 * 
	 * @param aState
	 */
	protected void setState(int aState) {
		this.state = aState;
		logger.info("State: " + AssociationState.toString(this.state));
		if (this.getMonitor() != null) {
			this.getMonitor().stateChanged(this.state, aState);
		}
	}

	protected String stateToString() {
		return AssociationState.toString(this.getState());
	}

	/**
	 * Throw an Exception, send it to the AssociationListener if exist
	 * 
	 * @param aException
	 *          the Exception
	 */
	private void throwException(Throwable aException) {
		try {
			logger.warn("throwException: " + aException.getMessage());
			if (logger.isDebugEnabled()) {
				logger.error("throwException: ", aException);
			}
			if (this.getAssociationListener() != null) {
				this.getAssociationListener().exceptionCaught(this, aException);
			}
		} catch (Exception ex) {
			logger.error("throwException: " + aException.getMessage());
		}
	}

	@Override
	public String toString() {
		if (this.getAssociateSession() != null) {
			return this.getAssociateSession().toString();
		} else {
			return super.toString();
		}
	}

	public void waitAssociate() throws Exception {
		this.isSCP = true;
		logger.info("Event: wait Associate Request");
	}

}
