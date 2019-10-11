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
import org.dicom4j.dicom.network.PresentationContextReason;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.NetworkStaticProperties;
import org.dicom4j.network.protocoldataunit.support.AbstractPresentationContextItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Presentation Context Item in AC
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class PresentationContextItemAC extends AbstractPresentationContextItem {

	/**
	 * the logger
	 */
	private static final Logger logger = LoggerFactory
	.getLogger(PresentationContextItemAC.class);

	public static PresentationContextItemAC newAbstractSyntaxNotSupportedPresentationContext(
			byte presentationID, String transfertSyntax) {
		PresentationContextItemAC lItem = new PresentationContextItemAC(
				presentationID,
				PresentationContextReason.ABSTRACT_SYNTAX_NOT_SUPPORTED.value());
		lItem.setTransfertSyntax(transfertSyntax);
		return lItem;
	}

	public static PresentationContextItemAC newAcceptancePresentationContext(
			byte presentationID, String transfertSyntax) {
		PresentationContextItemAC lItem = new PresentationContextItemAC(
				presentationID, PresentationContextReason.ACCEPTANCE.value());
		lItem.setTransfertSyntax(transfertSyntax);
		return lItem;
	}

	private TransferSyntaxItem fTransfertSyntax;

	private byte reason;

	public PresentationContextItemAC() {
		super();
	}

	public PresentationContextItemAC(BinaryInputStream aStream)
	throws DicomException, IOException {
		super();
		this.read(aStream, 0);
	}

	public PresentationContextItemAC(byte aID, byte aReason) {
		super(aID);
		this.reason = aReason;
	}

	@Override
	public int getLength() {
		// 8 : type(1) + reserved(1) + length (2) + ID(1) + reserved(1) + Reason(1)
		// + reserved(1)
		int Result = 8;
		if (this.fTransfertSyntax != null) {
			Result += this.fTransfertSyntax.getLength();
		}
		return Result;
	}

	@Override
	public String getName() {
		return "PRESENTATION CONTEXT ITEM (for AC)";
	}

	public byte getReason() {
		return this.reason;
	}

	public String getReasonAsString() {
		if (this.getReason() == NetworkStaticProperties.PresentationContextReasons.ACCEPTANCE) {
			return "acceptance";
		} else if (this.getReason() == NetworkStaticProperties.PresentationContextReasons.USER_REJECTION) {
			return "user rejection";
		} else if (this.getReason() == NetworkStaticProperties.PresentationContextReasons.NO_REASON) {
			return "no reason (provider rejection)";
		} else if (this.getReason() == NetworkStaticProperties.PresentationContextReasons.ABSTRACT_SYNTAX_NOT_SUPPORTED) {
			return "abstract syntax not supported (provider rejection)";
		} else if (this.getReason() == NetworkStaticProperties.PresentationContextReasons.TRANSFER_SYNTAXES_NOT_SUPPORTED) {
			return "transfer syntaxes not supported (provider rejection)";
		} else {
			return "unrecognized";
		}
	}

	public TransferSyntax getTransfertSyntax() {
		String uid = this.getTransfertSyntaxItem().getValue();
		try {
			return this.getTransferSyntaxRegistry().getByUID(uid);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			return null;
		}
	}

	protected TransferSyntaxItem getTransfertSyntaxItem() {
		return this.fTransfertSyntax;
	}

	public String getTransfertSyntaxUID() {
		return this.getTransfertSyntaxItem().getValue();
	}

	@Override
	public ProtocolDataUnitItemType getType() {
		return ProtocolDataUnitItemType.PRESENTATION_CONTEXT_AC;
	}

	public boolean isAccepted() {
		return this.getReason() == NetworkStaticProperties.PresentationContextReasons.ACCEPTANCE;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		stream.skip(1);
		stream.readUnsigned16();
		this.setID(stream.readByte());
		stream.skip(1);
		this.reason = (byte) stream.read();
		stream.skip(1);
		if (stream.readByte() == ProtocolDataUnitItemType.TRANSFERT_SYNTAX.value()) {
			TransferSyntaxItem item = new TransferSyntaxItem();
			item.setTransferSyntaxRegistry(this.getTransferSyntaxRegistry());
			item.read(stream, length);
			this.setTransfertSyntaxItem(item); // new TransferSyntaxItem(stream));
		} else {
			throw new DicomException(
			"Transfert syntax not found while reading PresentationContextItemAC");
		}
	}

	public void setTransfertSyntax(String aTransfertSyntax) {
		this.setTransfertSyntaxItem(new TransferSyntaxItem(aTransfertSyntax));
	}

	public void setTransfertSyntax(TransferSyntax aTransfertSyntax) {
		this.setTransfertSyntax(aTransfertSyntax.getUID());
	}

	protected void setTransfertSyntaxItem(TransferSyntaxItem aItem) {
		assert aItem != null;
		this.fTransfertSyntax = aItem;
	}

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(super.toString() + ": \n");
		lBuffer.append("  " + this.getTransfertSyntaxItem().toString() + "\n");
		lBuffer.append("  Result: " + this.getReasonAsString() + "\n");
		return lBuffer.toString();
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
		stream.write(this.getType().value());
		stream.write(0x00); // reserved
		stream.writeUnsigned16(this.getLength() - 4); // Length shouldn't containt
		// type(1), reserved(1), length(2)
		stream.write(this.getID()); // reserved
		stream.write(0x00); // reserved
		stream.write(this.getReason());
		stream.write(0x00); // reserved
		if (this.fTransfertSyntax != null) {
			this.fTransfertSyntax.write(stream);
		}
	}

}
