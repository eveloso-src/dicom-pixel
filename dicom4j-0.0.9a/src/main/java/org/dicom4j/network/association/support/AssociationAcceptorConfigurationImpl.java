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

/**
 * 
 */
package org.dicom4j.network.association.support;

import org.dicom4j.network.association.AssociationAcceptorConfiguration;
import org.dolmen.network.transport.acceptor.TransportAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Default {@link AssociationAcceptorConfiguration}
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociationAcceptorConfigurationImpl extends
AssociationServiceConfigurationImpl implements
AssociationAcceptorConfiguration {

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(AssociationAcceptorConfigurationImpl.class);

	private TransportAcceptor transportAcceptor;

	/**
	 * creates new acceptor with default configuration
	 */
	public AssociationAcceptorConfigurationImpl() {
		super();
		this.setTransportAcceptor(new TransportAcceptor());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.dicom4j.network.association.AssociationAcceptorConfiguration#
	 * getTransportAcceptor()
	 */
	public TransportAcceptor getTransportAcceptor() {
		return this.transportAcceptor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.dicom4j.network.association.AssociationAcceptorConfiguration#
	 * setTransportAcceptor
	 * (org.dicom4j.network.association.transport.TransportAcceptor)
	 */
	public void setTransportAcceptor(TransportAcceptor aTransport) {
		assert aTransport != null;
		logger.debug("setTransportAcceptor: " + aTransport);
		this.transportAcceptor = aTransport;
	}

}
