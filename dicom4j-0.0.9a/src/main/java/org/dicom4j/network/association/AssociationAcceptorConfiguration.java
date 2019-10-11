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
import org.dolmen.network.transport.acceptor.TransportAcceptor;

/**
 * Configuration of an {@link AssociationAcceptor}
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface AssociationAcceptorConfiguration extends
AssociationServiceConfiguration {

	/**
	 * return the {@link AssociateRequestHandler}
	 * 
	 * @retrun the handler
	 */
	public AssociateRequestHandler getAssociateRequestHandler();

	/**
	 * return the {@link TransportAcceptor TransportAcceptor} used
	 * 
	 * @return the TransportAcceptor used
	 */
	public TransportAcceptor getTransportAcceptor();

	/**
	 * set the {@link AssociateRequestHandler AssociateRequestHandler}
	 * 
	 * @param associateRequestHandler
	 */
	public void setAssociateRequestHandler(
			AssociateRequestHandler associateRequestHandler);

	/**
	 * Set the {@link TransportAcceptor TransportAcceptor} to use
	 * 
	 * @param aTransport
	 *          the {@link TransportAcceptor TransportAcceptor} to use
	 */
	public void setTransportAcceptor(TransportAcceptor aTransport);
}
