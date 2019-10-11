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
import org.dicom4j.network.dimse.messages.support.AbstractDimseMessage;

/**
 * Listen {@link Association} events
 * 
 * @see DefaultAssociationListener
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface AssociationListener {

	/**
	 * Invoked when an associate release is received
	 * 
	 * @param association
	 * @param associateRelease
	 * @throws Exception
	 */
	public void associateRelease(Association association,
			AssociateRelease associateRelease) throws Exception;

	/**
	 * Invoked when the association is aborted
	 * 
	 * @param association
	 *          the association
	 * @throws Exception
	 */
	public void associationAborted(Association association,
			AssociateAbort associateAbort) throws Exception;

	/**
	 * Invoked when the {@link Association} was created
	 * 
	 * @param association
	 *          the association
	 * @throws Exception
	 */
	public void associationCreated(Association association) throws Exception;

	/**
	 * Invoked when an association was opened
	 * 
	 * @param association
	 *          the association
	 * @param aResponse
	 *          the Associate Response
	 * @throws Exception
	 */
	public void associationOpened(Association association,
			AssociateSession associateSession) throws Exception;

	/**
	 * Invoked when a AssociateReject is received
	 * 
	 * @param association
	 *          the association
	 * @throws Exception
	 */
	public void associationRejected(Association association,
			AssociateReject associateReject) throws Exception;

	/**
	 * Invoked when the association was released
	 * 
	 * @param association
	 *          the association
	 * @throws Exception
	 */
	public void associationReleased(Association association) throws Exception;

	/**
	 * Invoked when an exception occurs
	 * 
	 * @param association
	 *          the association
	 * @param cause
	 *          the cause of the error
	 * @throws Exception
	 */
	public void exceptionCaught(Association association, Throwable cause);

	/**
	 * Invoked when a {@link AbstractDimseMessage DimseMessage} was received
	 * 
	 * @param association
	 *          the association
	 * @param message
	 *          the message
	 * @throws Exception
	 */
	public void messageReceived(Association association,
			byte presentationContextID, DimseMessage message) throws Exception;

}
