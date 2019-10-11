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

package org.dicom4j.network.protocoldataunit.pdu;

import java.io.IOException;
import java.nio.ByteOrder;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.NetworkStaticProperties;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnitType;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * A-ABORT PDU
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AAbortPDU extends AbstractProtocolDataUnit {

	private static Logger logger = LoggerFactory.getLogger(AAbortPDU.class);

	private byte reason;

	private byte source;

	/**
	 * Creates a A-ABORT
	 */
	public AAbortPDU() {
		this((byte) 0, (byte) 0);
	}

	/**
	 * Creates a A-ABORT PDU
	 * 
	 * @deprecated
	 * @param aStream
	 *          the stream
	 * @param aLength
	 *          length to read
	 * @exception DicomException
	 * @exception IOException
	 */
	@Deprecated
	public AAbortPDU(BinaryInputStream aStream, int aLength)
	throws DicomException, IOException {
		super();
		this.read(aStream, aLength);
	}

	/**
	 * Creates a A-ABORT
	 * 
	 * @param aSource
	 *          the source
	 * @param aReason
	 *          the reason
	 */
	public AAbortPDU(byte aSource, byte aReason) {
		super();
		this.source = aSource;
		this.reason = aReason;
	}

	@Override
	public int getLength() {
		return 10;
	}

	@Override
	public String getName() {
		return "A-ABORT";
	}

	/**
	 * Return the reason of the A-Abort
	 * 
	 * @return Reason of A-Abort
	 */
	public byte getReason() {
		return this.reason;
	}

	/**
	 * Return the source of the A-Abort
	 * 
	 * @return Source of A-Abort
	 */
	public byte getSource() {
		return this.source;
	}

	@Override
	public ProtocolDataUnitType getType() {
		return ProtocolDataUnitType.A_ABORT;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("read, length: " + length);
		AbstractProtocolDataUnit.checkStream(stream);
		this.source = stream.readByte();
		if (this.source == -1) {
			throw new IOException(
			"end of stream reached while reading AAbortPDU.source");
		}
		this.reason = stream.readByte();
		if (this.reason == -1) {
			throw new IOException(
			"end of stream reached while reading AAbortPDU.reason");
		}
	}

	/**
	 * Return the PDU as a string
	 * 
	 * @return PDU as a string
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getName() + " (");

		if (this.source == NetworkStaticProperties.AssociateAbortSource.SERVICE_USER) {
			sb.append(" Source: DICOM UL Service User");
		} else if (this.source == NetworkStaticProperties.AssociateAbortSource.SERVICE_PROVIDER) {
			sb.append("Source: DICOM UL Service Provider");
		}

		if (this.source == NetworkStaticProperties.AssociateAbortSource.SERVICE_PROVIDER) {
			if (this.reason == NetworkStaticProperties.AssociateAbortReasons.REASON_NOT_SPECIFIED) {
				sb.append(", reason not specified");
			} else if (this.reason == NetworkStaticProperties.AssociateAbortReasons.UNRECOGNIZED_PDU) {
				sb.append(", unrecognized PDU");
			} else if (this.reason == NetworkStaticProperties.AssociateAbortReasons.UNEXPECTED_PDU) {
				sb.append(", unexpected PDU");
			} else if (this.reason == NetworkStaticProperties.AssociateAbortReasons.UNRECOGNIZED_PDU_PARAMETER) {
				sb.append(", unrecognized PDU parameter");
			} else if (this.reason == NetworkStaticProperties.AssociateAbortReasons.UNEXPECTED_PDU_PARAMETER) {
				sb.append(", unexpected PDU parameter");
			} else if (this.reason == NetworkStaticProperties.AssociateAbortReasons.INVALID_PDU_PARAMETER_VALUE) {
				sb.append(", invalid PDU parameter value");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
		stream.write(this.getType().value());
		stream.write(0x00); // reserved
		stream.writeUnsigned32(4);
		stream.write(0x00);// reserved
		stream.write(0x00);// reserved
		stream.write(this.getSource());// source
		stream.write(this.getReason());// reasons
	}

}
