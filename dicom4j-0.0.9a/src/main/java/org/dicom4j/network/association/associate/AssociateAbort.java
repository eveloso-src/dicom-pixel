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

package org.dicom4j.network.association.associate;

import org.dicom4j.network.NetworkStaticProperties;
import org.dicom4j.network.protocoldataunit.pdu.AAbortPDU;

/**
 * A-ASSOCIATE ABORT
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateAbort extends AssociatePrimitive {

	/**
	 * A DICOM UL Service User (initiated Abort)
	 */
	public static AssociateAbort ServiceUserAbort = new AssociateAbort(
			NetworkStaticProperties.AssociateAbortSource.SERVICE_USER,
			NetworkStaticProperties.AssociateAbortReasons.REASON_NOT_SPECIFIED);

	public AssociateAbort(AAbortPDU aPDU) {
		super(aPDU);
	}

	public AssociateAbort(byte aSource, byte aReason) {
		this(new AAbortPDU(aSource, aReason));
	}

	public byte getRource() {
		return ((AAbortPDU) this.getProtocolDataUnit()).getReason();
	}

	public byte getSource() {
		return ((AAbortPDU) this.getProtocolDataUnit()).getSource();
	}

	// public static AssociateAbort ServiceProvided = new
	// AssociateAbort(StaticProperties.AssociateAbortSource.SERVICE_PROVIDER,
	// StaticProperties.AssociateAbortReasons.REASON_NOT_SPECIFIED);

}
