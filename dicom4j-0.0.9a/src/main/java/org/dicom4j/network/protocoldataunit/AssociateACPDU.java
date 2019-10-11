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
import java.util.LinkedList;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.items.PresentationContextItemAC;
import org.dicom4j.network.protocoldataunit.support.AssociateRQACPDU;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ASSOCIATE-AC
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateACPDU extends AssociateRQACPDU {

	private static Logger logger = LoggerFactory.getLogger(AssociateACPDU.class);

	/**
	 * Creates a new ASSOCIATE-AC PDU
	 * 
	 */
	public AssociateACPDU() {
		this("", "");
	}

	/**
	 * Create a new Associate-AC PDU
	 * 
	 * @param calledAETitle
	 *          The called AET
	 * @param callingAETitle
	 *          The Calling AET
	 */
	public AssociateACPDU(String calledAETitle, String callingAETitle) {
		super(calledAETitle, callingAETitle);
	}

	/**
	 * Add a new Presentation Context
	 * 
	 * @param id
	 *          the ID
	 * @param reason
	 *          the Reason
	 * @param transferSyntaxUID
	 *          the TransferSyntax UID
	 * @return the added Presentation Context
	 */
	public PresentationContextItemAC addPresentationContext(byte id, byte reason,
			String transferSyntaxUID) {
		PresentationContextItemAC lItem = new PresentationContextItemAC(id, reason);
		lItem.setTransfertSyntax(transferSyntaxUID);
		this.addPresentationContextItem(lItem);
		return lItem;
	}

	/**
	 * Add a new Presentation Context
	 * 
	 * @param id
	 *          the ID
	 * @param reason
	 *          the Reason
	 * @param transferSyntax
	 *          the {@link TransferSyntax}
	 * @return the added Presentation Context
	 */
	public PresentationContextItemAC addPresentationContext(byte aID,
			byte aReason, TransferSyntax transferSyntax) {
		return this.addPresentationContext(aID, aReason, transferSyntax.getUID());
	}

	/**
	 * Add a new Presentation Context AC Item
	 * 
	 * @param aItem
	 *          the item
	 * @return the added item
	 */
	public PresentationContextItemAC addPresentationContextItem(
			PresentationContextItemAC item) {
		assert item != null;
		this.getItems().add(item);
		return item;
	}

	// @Override
	/*
	 * public String getName() { return "ASSOCIATE-AC"; }
	 */

	/**
	 * return the Presentation Context Items
	 * 
	 * @return the Presentation Context Items
	 */
	@SuppressWarnings("unchecked")
	public LinkedList getPresentationContextItemAC() {
		// PresentationContextItemAC[] Result = new
		// PresentationContextItemAC[fPresentationContextItems.size()];
		// int lIndex = 0;
		return this.items;
		/*
		 * ListIterator i = fPresentationContextItems.listIterator(); while
		 * (i.hasNext()) { Result[lIndex] = (PresentationContextItemAC)i.next(); }
		 * return Result;
		 */
	}

	@Override
	public ProtocolDataUnitType getType() {
		return ProtocolDataUnitType.A_ASSOCIATE_AC;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("Start reading");
		super.read(stream, length);
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		logger.debug("Start writing");
		super.write(stream);
	}

}
