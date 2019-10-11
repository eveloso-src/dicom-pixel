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
import java.util.ArrayList;
import java.util.ListIterator;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.support.AbstractPresentationContextItem;

/**
 * Presentation Context Item in Request (DICOM PS 3.8)
 * 
 * @since 0.0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class PresentationContexRequestItem extends
AbstractPresentationContextItem {

	/**
	 * the AbstractSyntaxItem
	 */
	private AbstractSyntaxItem abstractSyntaxItem;

	/**
	 * the list of TransferSyntaxItem
	 */
	private ArrayList<TransferSyntaxItem> transfertSyntaxes;

	/**
	 * Creates new PRESENTATION CONTEXT ITEM
	 * 
	 * @param aStream
	 * @throws DicomException
	 * @throws IOException
	 */
	public PresentationContexRequestItem(BinaryInputStream aStream)
	throws DicomException, IOException {
		super();
		this.read(aStream, 0);
	}

	/**
	 * Creates a new PRESENTATION CONTEXT ITEM
	 * 
	 * @param aID
	 *          the ID
	 */
	public PresentationContexRequestItem(byte aID) {
		super(aID);
		this.transfertSyntaxes = new ArrayList<TransferSyntaxItem>();
		this.abstractSyntaxItem = null;
	}

	/**
	 * Add one Transfer Syntax
	 * 
	 * @param transferSyntaxUID
	 */
	public void addTransferSyntax(String transferSyntaxUID) {
		assert transferSyntaxUID != null;
		this.addTransfertSyntaxItem(new TransferSyntaxItem(transferSyntaxUID));
	}

	/**
	 * Add one Transfer Syntax
	 * 
	 * @param aTransferSyntax
	 *          the {@link TransferSyntax TransferSyntax}
	 */
	public void addTransferSyntax(TransferSyntax aTransferSyntax) {
		assert aTransferSyntax != null;
		this
		.addTransfertSyntaxItem(new TransferSyntaxItem(aTransferSyntax.getUID()));
	}

	/**
	 * Add many Transfer Syntaxes
	 * 
	 * @param aTransfertSyntaxes
	 */
	/*
	 * public void addTransferSyntaxes(TransferSyntaxes aTransfertSyntaxes) {
	 * Object[] lTS = aTransfertSyntaxes.toArray(); for (int i=0; i < lTS.length;
	 * i++) { addTransferSyntax((TransferSyntax)lTS[i]); } }
	 * 
	 * /** Add many Transferts Syntaxes @param aTransfertSyntaxes
	 */
	public void addTransferSyntaxes(String[] aTransfertSyntaxes) {
		for (int i = 0; i < aTransfertSyntaxes.length; i++) {
			this.addTransferSyntax(aTransfertSyntaxes[i]);
		}
	}

	/**
	 * Add many Transferts Syntaxes
	 * 
	 * @param aTransfertSyntaxes
	 */
	public void addTransferSyntaxes(TransferSyntax[] aTransfertSyntaxes) {
		for (int i = 0; i < aTransfertSyntaxes.length; i++) {
			this.addTransferSyntax(aTransfertSyntaxes[i]);
		}
	}

	protected void addTransfertSyntaxItem(TransferSyntaxItem aItem) {
		assert aItem != null;
		this.transfertSyntaxes.add(aItem);
	}

	/**
	 * Return the AbstractSyntax
	 * 
	 * @return the AbstractSyntax
	 */
	public String getAbstractSyntax() {
		return this.getAbstractSyntaxItem().getValue();
	}

	protected AbstractSyntaxItem getAbstractSyntaxItem() {
		return this.abstractSyntaxItem;
	}

	@Override
	public int getLength() {
		// 8 : type(1) + reserved(1) + length (2) + ID(1) + reserved(3)
		int Result = 8;
		if (this.abstractSyntaxItem != null) {
			Result += this.abstractSyntaxItem.getLength();
		}
		ListIterator<TransferSyntaxItem> i = this.transfertSyntaxes.listIterator();
		while (i.hasNext()) {
			Result += (i.next()).getLength();
		}
		return Result;
	}

	// @Override
	/*
	 * public String getName() { return "PRESENTATION CONTEXT ITEM (for RQ)"; }
	 */

	public String getTransferSyntax(int aIndex) {
		return this.getTransferSyntaxItem(aIndex).getValue();
	}

	public int getTransferSyntaxesCount() {
		return this.transfertSyntaxes.size();
	}

	protected TransferSyntaxItem getTransferSyntaxItem(int aIndex) {
		return this.transfertSyntaxes.get(aIndex);
	}

	@Override
	public ProtocolDataUnitItemType getType() {
		return ProtocolDataUnitItemType.PRESENTATION_CONTEXT_RQ;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		this.transfertSyntaxes = new ArrayList<TransferSyntaxItem>();
		stream.skip(1);
		int llength = stream.readUnsigned16();
		this.setID((byte) stream.read());
		stream.skip(3); // reserved
		long lOffset = 8;
		while (lOffset < llength) {
			byte lType = (byte) stream.read();
			if (lType == ProtocolDataUnitItemType.ABSTRACT_SYNTAX.value()) {
				AbstractSyntaxItem lItem = new AbstractSyntaxItem(stream);
				lOffset += lItem.getLength();
				this.setAbstractSyntaxItem(lItem);
			} else if (lType == ProtocolDataUnitItemType.TRANSFERT_SYNTAX.value()) {
				TransferSyntaxItem lItem = new TransferSyntaxItem(stream);
				lOffset += lItem.getLength();
				this.addTransfertSyntaxItem(lItem);
			} else {
				throw new DicomException(
				"Transfert syntax not found while reading PresentationContextItemRQ");
			}
		}
	}

	public void setAbstractSyntax(SOPClass sopClass) {
		this.setAbstractSyntax(sopClass.getUID());
	}

	/**
	 * Set the AbstractSyntax
	 * 
	 * @param aAbstractSyntax
	 */
	public void setAbstractSyntax(String aAbstractSyntax) {
		this.setAbstractSyntaxItem(new AbstractSyntaxItem(aAbstractSyntax));
	}

	protected void setAbstractSyntaxItem(AbstractSyntaxItem aItem) {
		assert aItem != null;
		this.abstractSyntaxItem = aItem;
	}

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(super.toString() + ": \n");
		lBuffer.append("  " + this.getAbstractSyntaxItem().toString() + "\n");
		ListIterator<TransferSyntaxItem> i = this.transfertSyntaxes.listIterator();
		while (i.hasNext()) {
			lBuffer.append("  " + (i.next()).toString() + "\n");
		}
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
		stream.write(this.getID());
		stream.write(0x00); // reserved
		stream.write(0x00); // reserved
		stream.write(0x00); // reserved
		if (this.abstractSyntaxItem != null) {
			this.abstractSyntaxItem.write(stream);
		}
		ListIterator i = this.transfertSyntaxes.listIterator();
		while (i.hasNext()) {
			((TransferSyntaxItem) i.next()).write(stream);
		}
	}

}
