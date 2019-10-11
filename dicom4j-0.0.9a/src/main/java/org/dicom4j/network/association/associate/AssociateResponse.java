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

import java.util.ListIterator;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.network.PresentationContextReason;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.network.association.associate.support.AssociateRQRSP;
import org.dicom4j.network.protocoldataunit.AssociateACPDU;
import org.dicom4j.network.protocoldataunit.items.PresentationContextItemAC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A-ASSOCIATE response
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateResponse extends AssociateRQRSP {

	protected Logger logger = LoggerFactory.getLogger(AssociateResponse.class);

	public AssociateResponse() {
		this("", "");
	}

	public AssociateResponse(AssociateACPDU aAssociateACPDU) {
		super(aAssociateACPDU);
	}

	/**
	 * creates an new Response from an AssociateRequest
	 * 
	 * @param aAssociateRequest
	 * @since 0.0.6
	 */

	public AssociateResponse(AssociateRequest aAssociateRequest) {
		this();
		this.setCalledAET(aAssociateRequest.getCalledAET());
		this.setCallingAET(aAssociateRequest.getCallingAET());
	}

	public AssociateResponse(String aCalledAET, String aCallingAET) {
		super(new AssociateACPDU(aCalledAET, aCallingAET));
		this.getAssociateRQACPDU().setDefautValues();
	}

	public void addAcceptancePresentationContext(byte presentationID,
			String transfertSyntax) {
		this.addPresentationContext(presentationID,
				PresentationContextReason.ACCEPTANCE.value(), transfertSyntax);
	}

	public void addNotSupportedPresentationContext(byte aPresentationID,
			String aTransfertSyntax) {
		this.addPresentationContext(aPresentationID,
				PresentationContextReason.ABSTRACT_SYNTAX_NOT_SUPPORTED.value(),
				aTransfertSyntax);
	}

	public void addPresentationContext(byte aPresentationID, byte aReason,
			String aTransfertSyntax) {
		this.getAssociateACPDU().addPresentationContext(aPresentationID, aReason,
				aTransfertSyntax);
	}

	public PresentationContextItemAC addPresentationContextItemAC(
			PresentationContextItemAC item) {
		return this.getAssociateACPDU().addPresentationContextItem(item);
	}

	private AssociateACPDU getAssociateACPDU() {
		return (AssociateACPDU) this.getProtocolDataUnit();
	}

	@Override
	public String getImplementationClassUID() {
		return this.getUserInformationItem().getImplementationClassUID();
	}

	@Override
	public String getImplementationVersionName() {
		return this.getUserInformationItem().getImplementationVersionName();
	}

	public long getMaximumLengthPDULength() {
		return this.getUserInformationItem().getMaximumLength();
	}

	public PresentationContextItemAC getPresentationContext(byte aPresentationID) {
		AssociateACPDU lPDU = (AssociateACPDU) this.getProtocolDataUnit();
		ListIterator i = lPDU.getPresentationContextItemAC().listIterator();
		while (i.hasNext()) {
			PresentationContextItemAC lItem = (PresentationContextItemAC) i.next();
			if (lItem.getID() == aPresentationID) {
				return lItem;
			}
		}
		throw new IllegalArgumentException(
				"Unabled to find a PresentationContextItemAC for " + aPresentationID
				+ " PresentationID");
	}

	public TransferSyntax getTransferSyntax(byte presentationID)
	throws DicomException {
		TransferSyntax ts = this.getPresentationContext(presentationID)
		.getTransfertSyntax();
		if (ts == null) {
			throw new DicomException("Unabled to find a TransferSyntax for "
					+ presentationID + " PresentationID");
		}
		return ts;
	}

	public String getTransferSyntaxUID(byte aPresentationID) {
		if (this.getPresentationContext(aPresentationID).isAccepted()) {
			return this.getPresentationContext(aPresentationID)
			.getTransfertSyntaxUID();
		} else {
			return "";
		}
	}

	/*
	 * private UserInformationItem getUserInformationItem() { return
	 * ((AssociateACPDU) getProtocolDataUnit()).getUserInformationItem(); }
	 */

	/*
	 * public String toString() { StringBuffer sb = new StringBuffer();
	 * sb.append("AssociateResponse: \n"); sb.append(fAssociateACPDU);
	 * //sb.append("ImplementationVersionName: " + getImplementationVersionName()
	 * + "\n"); return sb.toString(); }
	 */

	public boolean isAccepted(byte aPresentationID) {
		return this.getPresentationContext(aPresentationID).isAccepted();
	}
}
