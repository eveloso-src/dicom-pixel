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

import org.dicom4j.network.association.AssociationConnectorConfiguration;
import org.dolmen.network.transport.connector.TransportConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implement AssociationConnectorConfiguration
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociationConnectorConfigurationImpl extends
AssociationServiceConfigurationImpl implements
AssociationConnectorConfiguration {

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(AssociationConnectorConfigurationImpl.class);

	private TransportConnector transportConnector;

	/**
	 * creates a new configuration and set default settings
	 */
	public AssociationConnectorConfigurationImpl() {
		super();
		this.setTransportConnector(new TransportConnector());
	}

	public TransportConnector getTransportConnector() {
		return this.transportConnector;
	}

	public void setTransportConnector(TransportConnector aTransportConnector) {
		assert aTransportConnector != null;
		logger.debug("setTransportConnector: " + aTransportConnector);
		this.transportConnector = aTransportConnector;
	}

}
