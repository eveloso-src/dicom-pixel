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

package org.dicom4j.network.association.transport.codec;

import org.apache.mina.common.ByteBuffer;
import org.apache.mina.common.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnits;
import org.dicom4j.network.protocoldataunit.codec.ProtocolDataUnitEncoder;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Encode {@link ProtocolDataUnit} and send it to the network
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomProtocolEncoder implements ProtocolEncoder {

	private static ProtocolDataUnitEncoder fEncoder = new ProtocolDataUnitEncoder();

	private static Logger logger = LoggerFactory
	.getLogger(DicomProtocolEncoder.class);

	public DicomProtocolEncoder() {
		super();
	}

	/**
	 * Release all resources
	 */
	public void dispose(IoSession session) throws Exception {
	}

	/**
	 * Encode a
	 * {@link org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit
	 * ProtocolDataUnit}
	 * 
	 * @param session
	 * @param message
	 *          the ProtocolDataUnit
	 * @param out
	 * @throws Exception
	 */
	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput out) throws Exception {
		if (message instanceof AbstractProtocolDataUnit) {
			logger.debug("encode: " + ((AbstractProtocolDataUnit) message).getName());
			out.write(ByteBuffer.wrap(fEncoder
					.encode(((AbstractProtocolDataUnit) message))));
			out.flush();
			// fLogger.info( ((ProtocolDataUnit)message).getName() + " PDU flushed");
		} else if (message instanceof ProtocolDataUnits) {
			ProtocolDataUnits lPDUs = (ProtocolDataUnits) message;
			logger.debug("encode " + lPDUs.count() + " PDU(s)");
			byte[] lEncodePDUs = fEncoder.encode(lPDUs);
			out.write(ByteBuffer.wrap(lEncodePDUs));
			out.flush();
			// fLogger.info(((ProtocolDataUnits)message).count() + " PDU(s) flushed");
		} else {
			logger
			.warn("call of encode with an object != ProtocolDataUnit or ProtocolDataUnits (class: "
					+ message.getClass() + ")");
		}
	}

}
