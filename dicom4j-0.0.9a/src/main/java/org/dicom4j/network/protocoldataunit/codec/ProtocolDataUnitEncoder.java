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

package org.dicom4j.network.protocoldataunit.codec;

import java.nio.ByteOrder;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnits;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.dolmen.core.lang.HexaDecimalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Encode {@link ProtocolDataUnit} into bytes
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ProtocolDataUnitEncoder {

	private static Logger logger = LoggerFactory
	.getLogger(ProtocolDataUnitEncoder.class);

	/**
	 * Creates new Encoder
	 * 
	 */
	public ProtocolDataUnitEncoder() {
		super();
	}

	/**
	 * Encode a ProtocolDataUnit
	 * 
	 * @param pdu
	 *          the PDU to encode
	 * @return encoded PDU
	 * @throws
	 */
	public byte[] encode(ProtocolDataUnit pdu)
	throws ProtocolDataUnitEncoderException {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		this.encode(pdu, result);
		return result.toByteArray();
	}

	/**
	 * Encode a
	 * {@link org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit
	 * ProtocolDataUnit} into a stream
	 * 
	 * @param pdu
	 *          the PDU to encode
	 * @param stream
	 *          the stream to write into
	 * @throws Exception
	 */
	public void encode(ProtocolDataUnit pdu, ByteArrayOutputStream stream)
	throws ProtocolDataUnitEncoderException {
		try {
			if (pdu == null) {
				throw new ProtocolDataUnitEncoderException("can't encode a null PDU");
			}
			logger.debug("trying to encode " + pdu.getName() + " PDU");
			pdu.write(new BinaryOutputStream(stream, ByteOrder.BIG_ENDIAN));
			logger.debug("encoded " + pdu.getName() + "\n"
					+ HexaDecimalUtils.dump(stream.toByteArray()));
			logger.info(pdu.getName() + "PDU(s) correctly encoded");
		} catch (Exception e) {
			throw new ProtocolDataUnitEncoderException(
					"errors occurs while encoding a ProtocolDataUnit", e);
		}
	}

	/**
	 * Encode a list of
	 * {@link org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit
	 * ProtocolDataUnit}
	 * 
	 * @param aPDU
	 *          the PDU to encode
	 * @return encoded PDU
	 * @throws Exception
	 */
	public byte[] encode(ProtocolDataUnits aPDUs)
	throws ProtocolDataUnitEncoderException {
		ByteArrayOutputStream Result = new ByteArrayOutputStream();
		this.encode(aPDUs, Result);
		return Result.toByteArray();
	}

	/**
	 * Encode a list of
	 * {@link org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit
	 * ProtocolDataUnit} into a stream
	 * 
	 * @param aPDUs
	 * @param aStream
	 *          the stream to write into
	 * @throws Exception
	 */
	public void encode(ProtocolDataUnits aPDUs, ByteArrayOutputStream aStream)
	throws ProtocolDataUnitEncoderException {
		try {
			if (aPDUs == null) {
				throw new ProtocolDataUnitEncoderException(
				"can't encode a null list of PDUs");
			}
			BinaryOutputStream lStream = new BinaryOutputStream(aStream,
					ByteOrder.BIG_ENDIAN);
			for (int i = 0; i < aPDUs.count(); i++) {
				AbstractProtocolDataUnit lPDU = aPDUs.get(i);
				lPDU.write(lStream);
			}
			logger.info(aPDUs.count() + " correctly encoded");
		} catch (Exception e) {
			throw new ProtocolDataUnitEncoderException(
					"errors occurs while encoding a ProtocolDataUnit", e);
		}
	}

}
