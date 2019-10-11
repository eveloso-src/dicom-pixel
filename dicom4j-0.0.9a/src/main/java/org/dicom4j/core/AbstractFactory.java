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
package org.dicom4j.core;

import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract factory
 * 
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractFactory {

	private static final Logger logger = LoggerFactory
	.getLogger(AbstractFactory.class);

	private static final long serialVersionUID = 1L;

	private SOPClassRegistry sopClassRegistry;

	private TransferSyntaxRegistry transferSyntaxRegistry;

	public AbstractFactory() {
		super();
		this.sopClassRegistry = new SOPClassRegistry();
		this.transferSyntaxRegistry = new TransferSyntaxRegistry();
	}

	public SOPClassRegistry getSopClassRegistry() {
		return this.sopClassRegistry;
	}

	public TransferSyntaxRegistry getTransferSyntaxRegistry() {
		return this.transferSyntaxRegistry;
	}

	public void setSopClassRegistry(SOPClassRegistry sopClassRegistry) {
		logger.debug("setSopClassRegistry: " + sopClassRegistry);
		this.sopClassRegistry = sopClassRegistry;
	}

	public void setTransferSyntaxRegistry(
			TransferSyntaxRegistry transferSyntaxRegistry) {
		logger.debug("setTransferSyntaxRegistry: " + transferSyntaxRegistry);
		this.transferSyntaxRegistry = transferSyntaxRegistry;
	}

}
