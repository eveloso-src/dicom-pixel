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

package org.dicom4j.network.protocoldataunit.support;

import java.io.IOException;
import java.nio.ByteOrder;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for {@link org.dicom4j.network.protocoldataunit.AReleaseRQPDU
 * AReleaseRQPDU} and {@link org.dicom4j.network.protocoldataunit.AReleaseRPPDU
 * AReleaseRPPDU} PDUs
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractAReleasePDU extends AbstractProtocolDataUnit {

	private static Logger logger = LoggerFactory
	.getLogger(AbstractAReleasePDU.class);

	protected AbstractAReleasePDU() {
		super();
	}

	protected AbstractAReleasePDU(BinaryInputStream aStream, int aLength)
	throws DicomException, IOException {
		this.read(aStream, aLength);
	}

	@Override
	public int getLength() {
		return 10;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("we must read " + length + " bytes ");
		this.skip(stream, length); // nothing to read, reserved
		// long skipped = aStream.skip(aLength); // nothing to read, reserved
		// if ( skipped != aLength ) throw new IOException("must skipped " + aLength
		// + " but only skipped " + skipped);
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG ENDIAN");
		}
		stream.write(this.getType().value());
		stream.write(0x00); // reserved
		stream.writeUnsigned32(4);
		stream.write(0x00);// reserved
		stream.write(0x00);// reserved
		stream.write(0x00);// reserved
		stream.write(0x00);// reserved
		logger.debug("Writted 10 bytes");
	}
}
