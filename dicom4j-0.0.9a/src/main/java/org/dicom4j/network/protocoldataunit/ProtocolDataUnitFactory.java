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

package org.dicom4j.network.protocoldataunit;

import org.dicom4j.core.AbstractFactory;
import org.dicom4j.network.protocoldataunit.pdu.AAbortPDU;
import org.dicom4j.network.protocoldataunit.pdu.AssociateRQPDU;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Factory to create {@link ProtocolDataUnit}.
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ProtocolDataUnitFactory extends AbstractFactory {

	private static final Logger logger = LoggerFactory
	.getLogger(ProtocolDataUnitFactory.class);

	private static final long serialVersionUID = 1L;

	public ProtocolDataUnitFactory() {
		super();
	}

	/**
	 * configure a created pdu
	 * 
	 * @param pdu
	 *          the pdu to configure
	 */
	protected void configureProtocolDataUnit(ProtocolDataUnit pdu) {
		pdu.setSopClassRegistry(this.getSopClassRegistry());
		pdu.setTransferSyntaxRegistry(this.getTransferSyntaxRegistry());
	}

	/**
	 * Creates a new {@link ProtocolDataUnit} depending of the supplied type (as
	 * byte)
	 * 
	 * @param type
	 *          the type of PDU
	 * @return the new PDU
	 * @throws UnrecognizedPDUException
	 *           if type doesn't match to a valid PDU
	 */
	public ProtocolDataUnit newProtocolDataUnit(byte type)
	throws UnrecognizedPDUException {
		AbstractProtocolDataUnit pdu = null;
		if (type == ProtocolDataUnitType.A_ASSOCIATE_RQ_BYTE) {
			pdu = new AssociateRQPDU();
		} else if (type == ProtocolDataUnitType.A_ASSOCIATE_AC_BYTE) {
			pdu = new AssociateACPDU();
		} else if (type == ProtocolDataUnitType.ASSOCIATE_RJ_BYTE) {
			pdu = new AssociateRJPDU();
		} else if (type == ProtocolDataUnitType.P_DATA_TF_BYTE) {
			pdu = new PDataTFPDU();
		} else if (type == ProtocolDataUnitType.A_ABORT_BYTE) {
			pdu = new AAbortPDU();
		} else if (type == ProtocolDataUnitType.A_RELEASE_RP_BYTE) {
			pdu = new AReleaseRPPDU();
		} else if (type == ProtocolDataUnitType.A_RELEASE_RQ_BYTE) {
			pdu = new AReleaseRQPDU();
		}
		if (pdu != null) {
			this.configureProtocolDataUnit(pdu);
			logger.info("newProtocolDataUnit: " + pdu.getName() + " created");
			return pdu;
		} else {
			throw new UnrecognizedPDUException(type);
		}
	}

}
