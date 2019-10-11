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
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateResponse;

/**
 * Notify a listener when a {@link AssociateRequest AssociateRequest} is
 * received from a remote peer
 * 
 * 
 * @see DefaultAssociateRequestHandler
 * @see DeviceAssociateRequestHandler
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface AssociateRequestHandler {

	/**
	 * Invoked when an {@link AssociateRequest AssociateRequest} is received
	 * 
	 * @param aAssociation
	 *          the Association
	 * @param aAssociateRequest
	 *          the request
	 * @return the {@link AssociateResponse AssociateResponse} of this request
	 *         (must be null if a Reject or Abort was sended)
	 */
	public AssociateResponse requestReceived(Association aAssociation,
			AssociateRequest aAssociateRequest) throws Exception;

}
