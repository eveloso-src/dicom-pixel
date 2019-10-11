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

import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.associate.AssociateRelease;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.AssociationMonitor;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingAssociationMonitor implements AssociationMonitor {

	private static Logger logger = LoggerFactory
	.getLogger(LoggingAssociationMonitor.class);

	public LoggingAssociationMonitor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void abortSent(Association aAssociation, AssociateAbort aAssociateAbort) {
		logger.info("[ASSOCIATION] ABORT");
	}

	public void associateRequestReceived(Association aAssociation,
			AssociateRequest aAssociateRequest) {
		logger.info("[ASSOCIATION] request from "
				+ aAssociateRequest.getCallingAET());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.AssociationMonitor#onSendAssociate(org.
	 * dicom4j.network.association.Association,
	 * org.dicom4j.network.association.associate.AssociateRequest)
	 */
	public void associateSent(Association aAssociation,
			AssociateRequest aAssociateRequest) {
		// TODO Auto-generated method stub

	}

	public void associationOpened(Association aAssociation,
			AssociateSession aAssociateSession) {
		// fLogger.info("ESTABLISHED");
		// System.out.println("[ASSOCIATION] ESTABLISHED");
	}

	public void messageReceived(Association association, DimseMessage message) {
		logger.info("[INBOUND] " + message.getName());
	}

	public void messageSent(Association association, DimseMessage message) {
		logger.info("[OUTBOUND] " + message.getName());
	}

	public void onAssociationReleased(Association aAssociation,
			AssociateRelease aAssociateRelease) {
		logger.info("RELEASED");
	}

	public void protocolDataUnitReceived(Association association,
			ProtocolDataUnit protocolDataUnit) {
		logger.info("[INBOUND] " + protocolDataUnit.getName());
	}

	public void protocolDataUnitSent(Association association,
			ProtocolDataUnit protocolDataUnit) {
		logger.info("[OUTBOUND] " + protocolDataUnit.getName());
	}

	public void stateChanged(int aOldState, int aNewState) {
		logger.info(AssociationState.toString(aNewState));
		// System.out.println("[ASSOCIATION] ChangeState (old:" +
		// AssociationState.getStateToString(aOldState) + ", new: " +
		// AssociationState.getStateToString(aNewState)+")" );
	}

}
