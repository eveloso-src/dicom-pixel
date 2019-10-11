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
import org.dicom4j.network.association.associate.AssociateReject;
import org.dicom4j.network.association.associate.AssociateRelease;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.dimse.messages.DimseMessage;

/**
 * Default {@link AssociationListener AssociationListener} implements
 * 
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * @since 0.0.0
 */
public class DefaultAssociationListener implements AssociationListener {

	public DefaultAssociationListener() {
		super();
	}

	public void associateRelease(Association association,
			AssociateRelease associateRelease) throws Exception {
	}

	public void associationAborted(Association association,
			AssociateAbort associateAbort) throws Exception {
	}

	public void associationCreated(Association association) throws Exception {
	}

	public void associationOpened(Association association,
			AssociateSession associateSession) throws Exception {
	}

	public void associationRejected(Association association,
			AssociateReject associateReject) throws Exception {
	}

	public void associationReleased(Association association) throws Exception {
	}

	public void exceptionCaught(Association association, Throwable cause) {
	}

	public void messageReceived(Association association,
			byte presentationContextID, DimseMessage message) throws Exception {
	}

	@Override
	public String toString() {
		return "DefaultAssociationListener";
	}
}
