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

package org.dicom4j.network.association.listeners;

import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.associate.AssociateRelease;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;

/**
 * Adapter for {@link AssociationMonitor} interface
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * @since 0.0.2
 * 
 */
public class AssociationMonitorAdapter implements AssociationMonitor {

	public AssociationMonitorAdapter() {
		super();
	}

	public void abortSent(Association aAssociation, AssociateAbort aAssociateAbort) {

	}

	public void associateRequestReceived(Association aAssociation,
			AssociateRequest aAssociateRequest) {

	}

	public void associateSent(Association aAssociation,
			AssociateRequest aAssociateRequest) {
	}

	public void associationOpened(Association aAssociation,
			AssociateSession aAssociateSession) {

	}

	public void messageReceived(Association association, DimseMessage message) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.AssociationMonitor#onSendMessage(org.dicom4j
	 * .network.association.Association,
	 * org.dicom4j.network.dimse.messages.DimseMessage)
	 */
	public void messageSent(Association association, DimseMessage message) {
		// TODO Auto-generated method stub

	}

	public void onAssociationReleased(Association aAssociation,
			AssociateRelease aAssociateRelease) {

	}

	public void protocolDataUnitReceived(Association association,
			ProtocolDataUnit protocolDataUnit) {
	}

	public void protocolDataUnitSent(Association association,
			ProtocolDataUnit protocolDataUnit) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.AssociationMonitor#onChangeState(int,
	 * int)
	 */
	public void stateChanged(int aOldState, int aNewState) {
		// TODO Auto-generated method stub

	}

}
