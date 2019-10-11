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

package org.dicom4j.samples.network;

import org.dicom4j.network.association.AssociationAcceptor;
import org.dicom4j.network.association.AssociationAcceptorConfiguration;
import org.dicom4j.network.association.support.AssociationAcceptorConfigurationImpl;
import org.dicom4j.network.association.support.AssociationAcceptorImpl;
import org.dicom4j.samples.AbstractSample;

/**
 * Abstract class for SCP samples
 * 
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractSampleSCP extends AbstractSample {

	/**
	 * Connector to initiate associations
	 */
	protected AssociationAcceptor acceptor = new AssociationAcceptorImpl();

	/**
	 * Configure AssociationConnector
	 */
	protected AssociationAcceptorConfiguration configuration = new AssociationAcceptorConfigurationImpl();

	public AbstractSampleSCP() throws Exception {
		super();
	}

}
