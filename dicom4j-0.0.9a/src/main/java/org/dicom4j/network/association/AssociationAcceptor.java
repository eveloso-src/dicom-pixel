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

import org.dicom4j.network.association.listeners.AssociateRequestHandler;
import org.dicom4j.network.association.listeners.AssociationListener;

/**
 * <p>
 * To accept Associations from remote peers.
 * 
 * <p>
 * before start an acceptor with the <i>bind</i> methods, you need to configure
 * it and set an {@link AssociateRequestHandler} and an
 * {@link AssociationListener}
 * </p>
 * <p>
 * the AssociateRequestHandler is used to handle associate request from remote
 * peer, construct an appropriate response (depending of supported sop classes).
 * </p>
 * <p>
 * the AssociationListener is used to handle all events coming from an open
 * association.
 * </p>
 * 
 * @since 0.0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface AssociationAcceptor extends AssociationService {

	/**
	 * Accept {@link Association}s from remote peers
	 * 
	 * @param port
	 *          the port to listen on
	 * @throws Exception
	 *           if errors occurs
	 */
	public void bind(int port) throws Exception;

	/**
	 * return the current configuration
	 * 
	 * @return the current configuration
	 */
	public AssociationAcceptorConfiguration getConfiguration();

	/**
	 * set the configuration to use
	 * 
	 * @param aConfiguration
	 */
	public void setConfiguration(AssociationAcceptorConfiguration aConfiguration);

	public void unBind(int aPort) throws Exception;

}
