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

package org.dicom4j.network.association.associate;

import java.util.Iterator;

import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.network.association.associate.support.AssociateRQRSP;
import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;
import org.dicom4j.network.protocoldataunit.pdu.AssociateRQPDU;
import org.dicom4j.network.protocoldataunit.support.AbstractPresentationContextItem;

/**
 * A-ASSOCIATE request
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateRequest extends AssociateRQRSP {

	/**
	 * Used to return a incremented Presentation ID after addPresentationContext
	 * call
	 */
	private int currentID;

	public AssociateRequest() {
		this("", "");
	}

	public AssociateRequest(AssociateRQPDU aAssociateRQPDU) {
		super(aAssociateRQPDU);
	}

	public AssociateRequest(String aCalledAET, String aCallingAET) {
		super(new AssociateRQPDU(aCalledAET, aCallingAET));
		this.getAssociateRequestPDU().setDefautValues();
		this.currentID = 1;
	}

	/**
	 * add a PresentationContext
	 * 
	 * @param aSOPClass
	 *          the SOPClass
	 * @param transferSyntax
	 *          the TransferSyntax
	 * @return the PresentationContext ID
	 */
	public byte addPresentationContext(SOPClass abstractSyntax,
			TransferSyntax transferSyntax) {
		assert abstractSyntax != null;
		assert transferSyntax != null;
		return this.addPresentationContext(abstractSyntax.getUID(), transferSyntax);
	}

	/**
	 * Add a PresentationContext
	 * 
	 * @param abstractSyntaxUID
	 *          an AbstractSyntax
	 * @param transferSyntax
	 *          a TransfertSyntax
	 * @return the PresentationContext ID
	 */
	public byte addPresentationContext(String abstractSyntaxUID,
			TransferSyntax transferSyntax) {
		TransferSyntax[] lTSs = new TransferSyntax[1];
		lTSs[0] = transferSyntax;
		return this.addPresentationContext(abstractSyntaxUID, lTSs);
	}

	// TODO not sure for the fact -1 if nice

	/**
	 * Add a PresentationContext
	 * 
	 * @param aAbstractSyntax
	 *          an AbstractSyntax
	 * @param aTransferSyntaxes
	 *          the TransfertSyntaxes
	 * @return the PresentationContext ID
	 */
	public byte addPresentationContext(String aAbstractSyntax,
			TransferSyntax[] aTransferSyntaxes) {
		PresentationContexRequestItem lPDU = new PresentationContexRequestItem(
				(byte) this.currentID);
		this.currentID = this.currentID + 2;
		lPDU.setAbstractSyntax(aAbstractSyntax);
		lPDU.addTransferSyntaxes(aTransferSyntaxes);
		this.getAssociateRequestPDU().addPresentationContextItem(lPDU);
		return lPDU.getID();
	}

	/**
	 * Return the Associate RQ PDU
	 * 
	 * @return the PDU
	 */
	private AssociateRQPDU getAssociateRequestPDU() {
		return (AssociateRQPDU) this.getProtocolDataUnit();
	}

	/**
	 * retrun a PresentationContextId depending of an AbstractSyntax
	 * 
	 * @param the
	 *          AbstractSyntax
	 * @return the PresentationContextId (-1 if no PresentationContext was found)
	 */
	public byte getPresentationContextId(String aAbstractSyntax) {
		PresentationContexRequestItem lPres = this.getAssociateRequestPDU()
		.getPresentationContextItem(aAbstractSyntax);
		if (lPres == null) {
			return -1;
		} else {
			return lPres.getID();
		}
	}

	public Iterator<AbstractPresentationContextItem> getPresentationIterator() {
		return this.getAssociateRequestPDU().getPresentationIterator();
	}

}
