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
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.codec.ProtocolDataUnitDecoder;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Decode {@link ProtocolDataUnit} from network streams
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomProtocolDecoder extends CumulativeProtocolDecoder implements
ProtocolDecoder {

	private static Logger logger = LoggerFactory
	.getLogger(DicomProtocolDecoder.class);

	private int length;

	private ProtocolDataUnitDecoder pduDecoder = new ProtocolDataUnitDecoder();

	private byte pdutype;

	public DicomProtocolDecoder() {
		super();
		this.clear();
	}

	private void clear() {
		this.length = -1;
		this.pdutype = 0x00;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.mina.filter.codec.CumulativeProtocolDecoder#doDecode(org.apache
	 * .mina.common.IoSession, org.apache.mina.common.ByteBuffer,
	 * org.apache.mina.filter.codec.ProtocolDecoderOutput)
	 */
	@Override
	protected boolean doDecode(IoSession session, ByteBuffer in,
			ProtocolDecoderOutput out) throws Exception {
		// fLogger.info( Long.toString(in.remaining()));
		if ((this.pdutype == 0x00) && (this.length == -1)) {
			if (in.remaining() >= 6) {
				this.pdutype = in.get();
				in.skip(1); // skip reserved
				this.length = in.getInt();
				logger.debug("PDU to read : "
						+ AbstractProtocolDataUnit.typetoString(this.pdutype)
						+ " (length: " + this.length + ")");
			}
		}

		// the PDU type and length is known, and buffer contains all data so we can
		// decode the complete PDU
		if ((this.length != -1) && (this.pdutype != 0x00)
				&& (in.remaining() >= this.length)) {
			out.write(this.pduDecoder.decode(this.pdutype, this.length, in
					.asInputStream()));
			this.clear();
			logger.debug("doDecode finished");
			return true; // we say: we finish to read one PDU
		} else {
			return false;
		}
	}

	public void setSopClassRegistry(SOPClassRegistry sopClassRegistry) {
		logger.debug("setSopClassRegistry: " + sopClassRegistry);
		this.pduDecoder.setSopClassRegistry(sopClassRegistry);
	}

	public void setTransferSyntaxRegistry(
			TransferSyntaxRegistry transferSyntaxRegistry) {
		logger.debug("setTransferSyntaxRegistry: " + transferSyntaxRegistry);
		this.pduDecoder.setTransferSyntaxRegistry(transferSyntaxRegistry);
	}

}
