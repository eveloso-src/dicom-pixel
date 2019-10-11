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

import org.dicom4j.network.association.associate.AssociateRequest;

/**
 * To initiate a assocations to a remote peers
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface AssociationConnector extends AssociationService {

	/**
	 * Initiate an {@link Association Association} to a remote peer
	 * 
	 * @param hostName
	 *          the remote hostname or IP adress
	 * @param port
	 *          the remote port
	 * @param aRequest
	 *          the {@link AssociateRequest AssociateRequest}
	 * @throws Exception
	 *           if errors occurs
	 */
	public void connect(String hostName, int port, AssociateRequest aRequest)
	throws Exception;

	// public void connect(String hostName, int port, AssociateRequest request,
	// AssociationListener listener) throws Exception;

	/**
	 * return the current configuration
	 * 
	 * @return
	 */
	public AssociationConnectorConfiguration getConfiguration();

	/**
	 * set the configuration to use
	 * 
	 * @param configuration
	 */
	public void setConfiguration(AssociationConnectorConfiguration configuration);

}
