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

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnitType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p> Abstract {@link AbstractProtocolDataUnit} implements.
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractProtocolDataUnit implements ProtocolDataUnit {

	/**
	 * Types of {@link AbstractProtocolDataUnit ProtocolDataUnit}
	 * 
	 * @deprecated see ProtocolDataUnitType
	 * @since 0.0.0
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 */
	@Deprecated
	public class Types {

		/**
		 * A-ABORT
		 */
		public final static byte A_ABORT = 0x07;

		/**
		 * A-ASSOCIATE-AC
		 */
		public final static byte A_ASSOCIATE_AC = 0x02;

		/**
		 * A-ASSOCIATE-RQ
		 */
		public final static byte A_ASSOCIATE_RQ = 0x01;

		/**
		 * A-RELEASE-RP
		 */
		public final static byte A_RELEASE_RP = 0x06;

		/**
		 * A-RELEASE-RQ
		 */
		public final static byte A_RELEASE_RQ = 0x05;

		/**
		 * ASSOCIATE-RJ
		 */
		public final static byte ASSOCIATE_RJ = 0x03;

		/**
		 * P-DATA-TF
		 */
		public final static byte P_DATA_TF = 0x04;
	}

	private static Logger logger = LoggerFactory.getLogger(AbstractProtocolDataUnit.class);

	//must be in Reader/writer
	@Deprecated
	public static void checkStream(BinaryInputStream stream) throws DicomException {
		if (stream == null) {
			throw new DicomException("the stream can't be null");
		}
		if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
	}

	@Deprecated
	protected static void checkStream(BinaryOutputStream aStream)
	throws DicomException {
		if (aStream == null) {
			throw new DicomException("the stream can't be null");
		}
		if (aStream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
	}

	/**
	 * return a type of PDU as String
	 * 
	 * @param aType
	 *          type of PDU
	 * @return PDU as string
	 */
	public static String typetoString(byte aType) {
		if (aType == Types.A_ASSOCIATE_RQ) {
			return "A-ASSOCIATE-RQ";
		} else if (aType == Types.A_ASSOCIATE_AC) {
			return "A-ASSOCIATE-AC";
		} else if (aType == Types.ASSOCIATE_RJ) {
			return "ASSOCIATE-RJ";
		} else if (aType == Types.P_DATA_TF) {
			return "P-DATA-TF";
		} else if (aType == Types.A_RELEASE_RQ) {
			return "A-RELEASE-RQ";
		} else if (aType == Types.A_RELEASE_RP) {
			return "A-RELEASE-RP";
		} else if (aType == Types.A_ABORT) {
			return "A-ABORT";
		} else {
			return "Unkonw Protocol Data Unit item";
		}
	}

	private SOPClassRegistry sopClassRegistry;

	private TransferSyntaxRegistry transferSyntaxRegistry;

	/**
	 * Creates a new PDU
	 */
	protected AbstractProtocolDataUnit() {
		super();
		this.sopClassRegistry = new SOPClassRegistry();
		this.transferSyntaxRegistry = new TransferSyntaxRegistry();
	}

	/**
	 * Creates a new Protocol Data Unit from a stream
	 * 
	 * @deprecated (it's cleaner to creates a new instance and then call
	 *             read/write
	 * @param aStream
	 *          the stream
	 * @param aLength
	 *          length to read
	 * @exception DicomException
	 * @exception IOException
	 */
	@Deprecated
	protected AbstractProtocolDataUnit(BinaryInputStream aStream, int aLength)
	throws DicomException, IOException {
		super();
		this.read(aStream, aLength);
	}

	/**
	 * Return the length of the Protocol Data Unit
	 * 
	 * @return the length
	 */
	public abstract int getLength();

	/**
	 * Return the name of the Protocol Data Unit
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.getType().name();
	}

	public SOPClassRegistry getSopClassRegistry() {
		return this.sopClassRegistry;
	}

	public TransferSyntaxRegistry getTransferSyntaxRegistry() {
		return this.transferSyntaxRegistry;
	}

	public abstract ProtocolDataUnitType getType();

	/**
	 * Read the Protocol Data Unit from a stream
	 * 
	 * @param stream
	 * @param length
	 * @throws DicomException
	 * @throws IOException
	 */
	public abstract void read(BinaryInputStream stream, int length)
	throws DicomException, IOException;

	public void setSopClassRegistry(SOPClassRegistry sopClassRegistry) {
		this.sopClassRegistry = sopClassRegistry;
	}

	public void setTransferSyntaxRegistry(
			TransferSyntaxRegistry transferSyntaxRegistry) {
		this.transferSyntaxRegistry = transferSyntaxRegistry;
	}

	protected void skip(BinaryInputStream stream, long skip) throws IOException {
		long skipped = stream.skip(skip);
		if (skipped != skip) {
			logger.error("must skipped " + skip + " but only skipped " + skipped);
			throw new IOException("must skipped " + skip + " but only skipped "
					+ skipped);
		}
	}

	/**
	 * Return the Protocol Data Unit as bytes
	 * 
	 * @return PDU as bytes
	 * @throws DicomException
	 * @throws IOException
	 */
	public byte[] toBytes() throws DicomException, IOException {
		ByteArrayOutputStream Result = new ByteArrayOutputStream();
		this.write(new BinaryOutputStream(Result, ByteOrder.BIG_ENDIAN));
		return Result.toByteArray();
	}

	@Override
	public String toString() {
		return this.getName();
	}

	/**
	 * Write the Protocol Data Unit to a stream
	 * 
	 * @param stream
	 * @throws DicomException
	 * @throws IOException
	 */
	public abstract void write(BinaryOutputStream stream) throws DicomException,
	IOException;
}
