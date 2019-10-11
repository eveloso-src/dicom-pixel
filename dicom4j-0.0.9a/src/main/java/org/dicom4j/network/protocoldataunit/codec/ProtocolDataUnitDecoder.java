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

import java.io.InputStream;
import java.nio.ByteOrder;

import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnitFactory;
import org.dicom4j.network.protocoldataunit.UnrecognizedPDUException;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Decode {@link AbstractProtocolDataUnit} from stream.
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ProtocolDataUnitDecoder {

	private static Logger logger = LoggerFactory
	.getLogger(ProtocolDataUnitDecoder.class);

	private ProtocolDataUnitFactory pduFactory = new ProtocolDataUnitFactory();

	/**
	 * Creates new Decoder
	 * 
	 */
	public ProtocolDataUnitDecoder() {
		super();
	}

	/**
	 * Read a stream to decode the
	 * {@link org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit
	 * ProtocolDataUnit} contains in
	 * 
	 * @param pduType
	 *          the type of PDU
	 * @param pduLength
	 *          the length of the PDU
	 * @param stream
	 *          the stream to read from
	 * @return the readed PDU
	 * @throws Exception
	 *           if errors occurs
	 */
	public ProtocolDataUnit decode(byte pduType, int pduLength, InputStream stream)
	throws ProtocolDataUnitDecoderException {
		try {
			logger.debug("trying to decoding " + this.getTypeAsString(pduType)
					+ " PDU");
			BinaryInputStream lInput = new BinaryInputStream(stream,
					ByteOrder.BIG_ENDIAN);

			ProtocolDataUnit lPDU = this.pduFactory.newProtocolDataUnit(pduType);
			lPDU.read(lInput, pduLength);
			if (lPDU == null) {
				throw new UnrecognizedPDUException();
			}
			assert lPDU != null;
			return lPDU;
		} catch (Throwable e) {
			throw new ProtocolDataUnitDecoderException(e.getMessage(), e);
		}
	}

	public String getTypeAsString(byte pduType) {
		return AbstractProtocolDataUnit.typetoString(pduType);
	}

	public void setSopClassRegistry(SOPClassRegistry sopClassRegistry) {
		logger.debug("setSopClassRegistry: " + sopClassRegistry);
		this.pduFactory.setSopClassRegistry(sopClassRegistry);
	}

	public void setTransferSyntaxRegistry(
			TransferSyntaxRegistry transferSyntaxRegistry) {
		logger.debug("setTransferSyntaxRegistry: " + transferSyntaxRegistry);
		this.pduFactory.setTransferSyntaxRegistry(transferSyntaxRegistry);
	}

}
