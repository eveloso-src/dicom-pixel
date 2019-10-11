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

package org.dicom4j.network.protocoldataunit.items;

import java.io.IOException;
import java.nio.ByteOrder;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dolmen.core.lang.HexaDecimalUtils;
import org.slf4j.Logger;

/**
 * Presentation Data Value Item
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class PresentationDataValueItem {

	private byte[] fValue;

	protected Logger logger = org.slf4j.LoggerFactory
	.getLogger(PresentationDataValueItem.class);

	private byte messageControlHeader;

	private byte presentationContextID;

	public PresentationDataValueItem() {
		super();
		this.presentationContextID = -1;
		this.messageControlHeader = -1;
	}

	public PresentationDataValueItem(BinaryInputStream aReader)
	throws DicomException, IOException {
		// try {
		long lLength = aReader.readUnsigned32();
		this.presentationContextID = aReader.readByte();
		this.messageControlHeader = aReader.readByte();
		long lValueLength = lLength - 2; // we don't count ContextID, Header
		// TODO see how handle a PresentationDataValue with length > as an int
		this.fValue = new byte[(int) lValueLength];
		aReader.read(this.fValue);
		// int lreaded = aReader.read(fValue);
		// We must read the stream until all PDV is readed
		// while (lreaded != lValueLength) {
		// lreaded = lreaded + aReader.read(fValue, lreaded, (int)lValueLength-
		// lreaded);
		// }
		// fLogger.debug("PresentationDataValue. value:\n " + HexDump.dump(fValue));
		// // } catch (Exception e) {
		// throw new DicomNetworkException(e.getMessage());
		// }
	}

	/**
	 * @param aPresentationContextID
	 * @param value
	 * @param isCommand
	 * @param isLastFragment
	 */
	public PresentationDataValueItem(byte aPresentationContextID,
			boolean isCommand, boolean isLastFragment, byte[] value) {
		this.presentationContextID = aPresentationContextID;
		this.messageControlHeader = (byte) ((isLastFragment ? 1 : 0) << 1 | (isCommand ? 1
				: 0));
		this.fValue = value;

		/*
		 * fLogger.debug("PresentationContextID: " + aPresentationContextID);
		 * fLogger.debug("isLastFragment: " + isLastFragment);
		 * fLogger.debug("isCommand: " + isCommand);
		 */
		// b = new byte[6+value.length];
		/*
		 * itemLength = value.length+2; b[0]=(byte)(itemLength>>24); // big endian
		 * b[1]=(byte)(itemLength>>16); b[2]=(byte)(itemLength>>8);
		 * b[3]=(byte)itemLength;
		 * 
		 * b[4]=presentationContextID; b[5]=fMessageControlHeader;
		 * System.arraycopy(value,0,b,6,value.length);
		 */
	}

	private long getInternalLength() {
		return 2 + this.fValue.length;
	}

	/**
	 * get the total length of this PresentationDataValue
	 * 
	 * @return the length
	 */
	public long getLength() {
		// 4 : length(4))
		return 4 + this.getInternalLength();
	}

	/**
	 * Return the Presentation Context ID
	 * 
	 * @return The Presentation Context ID
	 */
	public byte getPresentationContextID() {
		return this.presentationContextID;
	}

	public byte[] getValue() {
		return this.fValue;
	}

	/**
	 * Return true if it's contain a command
	 * 
	 * @return True if contain Command
	 */
	public boolean isCommand() {
		return (this.messageControlHeader & 0x01) != 0;
	}

	/***/
	/**
	 * Return true if it's a last fragment
	 * 
	 * @return True if last fragment
	 */
	public boolean isLastFragment() {
		return (this.messageControlHeader & 0x02) != 0;
	}

	public void read(BinaryInputStream aStream, int aLength)
	throws DicomException, IOException {
		if (aStream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
		long lLength = aStream.readUnsigned32();
		this.presentationContextID = aStream.readByte();
		this.messageControlHeader = aStream.readByte();
		long lValueLength = lLength - 2; // we don't count ContextID, Header
		// TODO see how handle a PresentationDataValue with length > as an int
		this.fValue = new byte[(int) lValueLength];
		aStream.read(this.fValue);
		/*
		 * aReader.read(fValue); long llength = aLength; //aReader.readUnsigned32();
		 * long offset = 6; // we already readed 6 bytes while (offset < llength) {
		 * PresentationDataValueItem lItem = new PresentationDataValueItem(aStream);
		 * fPresentationDataValues.add(lItem); offset += lItem.getLength(); }
		 */
	}

	/***/
	@Override
	public String toString() {
		return HexaDecimalUtils.dump(this.fValue);
	}

	public void write(BinaryOutputStream aStream) throws DicomException,
	IOException {
		if (aStream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
		aStream.writeUnsigned32(this.getInternalLength());
		aStream.write(this.presentationContextID);
		aStream.write(this.messageControlHeader);
		aStream.write(this.getValue());
	}
}
