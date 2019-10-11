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

import java.io.IOException;
import java.nio.ByteOrder;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.network.AssociateRejectResult;
import org.dicom4j.dicom.network.AssociateRejectSource;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.DicomNetworkException;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A-ASSOCIATE-RJ PDU (see DICOM PS 3.8)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateRJPDU extends AbstractProtocolDataUnit {

	private static Logger logger = LoggerFactory.getLogger(AssociateRJPDU.class);

	private byte reason;

	private byte result;

	private byte source;

	public AssociateRJPDU() {
		super();
	}

	/**
	 * 
	 * Create a new A-ASSOCIATE-RJ PDU from a stream
	 * 
	 * @param aReader
	 *          The stream
	 * @throws DicomNetworkException
	 */
	@Deprecated
	public AssociateRJPDU(BinaryInputStream aReader, int aLength)
	throws DicomException, IOException {
		super();
		this.read(aReader, aLength);
	}

	/**
	 * 
	 * @param result
	 * @param source
	 * @param reason
	 */
	public AssociateRJPDU(byte result, byte source, byte reason) {
		super();
		this.result = result;
		this.source = source;
		this.reason = reason;
	}

	@Override
	public int getLength() {
		return 10;
	}

	@Override
	public ProtocolDataUnitType getType() {
		return ProtocolDataUnitType.ASSOCIATE_RJ;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("read, length: " + length);
		this.skip(stream, 1); // reserved
		this.result = stream.readByte();
		if (this.result == -1) {
			throw new IOException(
			"end of stream reached while reading AssociateRJPDU.result");
		}
		this.source = stream.readByte();
		if (this.source == -1) {
			throw new IOException(
			"end of stream reached while reading AssociateRJPDU.source");
		}
		this.reason = stream.readByte();
		if (this.reason == -1) {
			throw new IOException(
			"end of stream reached while reading AssociateRJPDU.reason");
		}
	}

	/***/
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();

		if (this.result == AssociateRejectResult.REJECTED_PERMANENT.value()) {
			sb.append("A-ASSOCIATE-RJ: " + AssociateRejectResult.REJECTED_PERMANENT.getAsString());
		} else if (this.result == AssociateRejectResult.REJECTED_TRANSIENT.value()) {
			sb.append("A-ASSOCIATE-RJ: rejected-transient");
		}

		if (this.source == AssociateRejectSource.DICOM_UL_SERVICE_USER.value()) {
			sb.append(" by DICOM UL Service User");
		} else if (this.source == AssociateRejectSource.DICOM_UL_SERVICE_PROVIDER_ACSE.value()) {
			sb.append(" by DICOM UL Service Provider (ACSE related function)");
		} else if (this.source == AssociateRejectSource.DICOM_UL_SERVICE_PRESENTATION.value()) {
			sb
			.append(" by DICOM UL Service Provider (Presentation related function)");
		}

		/*
		 * if (fSource == Source.DICOM_UL_SERVICE_USER) { if (fResult ==
		 * Result.REJECTED_PERMANENT) { sb.append(", no reason given"); } else if
		 * (fResult == 2) { sb.append(", application context name not supported"); }
		 * else if (fResult == 3) { sb.append(", calling AE Title not recognized");
		 * } else if (fResult == 7) { sb.append(", called AE Title not recognized");
		 * } } else if (fSource == Source.DICOM_UL_SERVICE_PROVIDER_ACSE) { if
		 * (fResult == 1) { sb.append(", no reason given"); } else if (fResult == 2)
		 * { sb.append(", protocol version not supported"); } } else if (fSource ==
		 * Source.DICOM_UL_SERVICE_PRESENTATION) { if (fReason == 1) { sb.append(",
		 * temporary congestion"); } else if (fReason == 2) { sb.append(", local
		 * limit exceeded"); } }
		 */
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
		stream.write(this.result);
		stream.write(this.source);
		stream.write(this.reason);
	}

}
