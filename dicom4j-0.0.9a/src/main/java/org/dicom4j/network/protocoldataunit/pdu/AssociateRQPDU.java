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
import java.util.ListIterator;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnitType;
import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;
import org.dicom4j.network.protocoldataunit.support.AbstractPresentationContextItem;
import org.dicom4j.network.protocoldataunit.support.AssociateRQACPDU;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ASSOCIATE-RQ PDU (see DICOM PS 3.8)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateRQPDU extends AssociateRQACPDU {

	private static Logger logger = LoggerFactory.getLogger(AssociateRQPDU.class);

	/**
	 * Create a new ASSOCIATE-RQ PDU
	 */
	public AssociateRQPDU() {
		super();
	}

	/**
	 * Create a new Associate-RQ PDU
	 * 
	 * @param aCalledAETitle
	 *          the called AET
	 * @param aCallingAETitle
	 *          the calling AET
	 */
	public AssociateRQPDU(String aCalledAETitle, String aCallingAETitle) {
		super(aCalledAETitle, aCallingAETitle);
	}

	/**
	 * Add a new PresentationContext Item
	 * 
	 * @param aItem
	 *          the item
	 */
	public void addPresentationContextItem(PresentationContexRequestItem aItem) {
		assert aItem != null;
		this.items.add(aItem);
	}

	@Override
	public String getName() {
		return "ASSOCIATE-RQ";
	}

	public PresentationContexRequestItem getPresentationContextItem(byte aId) {
		ListIterator<AbstractPresentationContextItem> i = this.items.listIterator();
		while (i.hasNext()) {
			PresentationContexRequestItem lPres = (PresentationContexRequestItem) i
			.next();
			if (lPres.getID() == aId) {
				return lPres;
			}
		}
		return null;
	}

	/**
	 * return a PresentationContextItemRQ depending of an abstractSyntax
	 * 
	 * @param abstractSyntax
	 *          the abstractSyntax
	 * @return the PresentationContextItemRQ of null if not present
	 */
	public PresentationContexRequestItem getPresentationContextItem(
			String abstractSyntax) {
		ListIterator i = this.items.listIterator();
		while (i.hasNext()) {
			PresentationContexRequestItem lPres = (PresentationContexRequestItem) i
			.next();
			if (lPres.getAbstractSyntax().equals(abstractSyntax.trim())) {
				return lPres;
			}
		}
		return null;
	}

	public PresentationContexRequestItem[] getPresentationContextItemRQ() {
		PresentationContexRequestItem[] Result = new PresentationContexRequestItem[this.items
		                                                                           .size()];
		int lIndex = 0;
		ListIterator i = this.items.listIterator();
		while (i.hasNext()) {
			Result[lIndex] = (PresentationContexRequestItem) i.next();
		}
		return Result;
	}

	@Override
	public ProtocolDataUnitType getType() {
		return ProtocolDataUnitType.A_ASSOCIATE_RQ;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("we must read " + length + " bytes ");
		super.read(stream, length);
		logger.debug("reading completed");
	}

	public void setPresentationContexts(byte aID, String aAbstractSyntax,
			String[] aTransfertSyntaxes) {
		PresentationContexRequestItem lItem = new PresentationContexRequestItem(aID);
		lItem.setAbstractSyntax(aAbstractSyntax);
		lItem.addTransferSyntaxes(aTransfertSyntaxes);
		this.addPresentationContextItem(lItem);
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		logger.debug("Start writing");
		super.write(stream);
		logger.debug("Stop writing");
	}
}
