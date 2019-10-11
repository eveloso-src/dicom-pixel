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

import java.net.SocketAddress;

import org.apache.mina.common.IoSession;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Associate Session (ie: parameters of an Association opened between 2 dicom
 * nodes)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateSession {

	/**
	 * The logger
	 */
	protected static final Logger logger = LoggerFactory
	.getLogger(AssociateSession.class);

	/**
	 * The MINA IoSession
	 */
	private IoSession ioSession;

	private AssociateRequest request;

	/**
	 * The Association Response
	 */
	private AssociateResponse response;

	// private boolean isSCP;

	/**
	 * create a new session
	 * 
	 * @param ioSession
	 *          the I/O session
	 * @param request
	 *          the request
	 * @param response
	 *          the response
	 */
	public AssociateSession(IoSession ioSession, AssociateRequest request,
			AssociateResponse response) {
		super();
		assert request != null;
		assert response != null;
		this.ioSession = ioSession;
		this.request = request;
		this.response = response;
		// isSCP = aIsSCP;
	}

	/**
	 * Return the called Application Entity Title
	 * 
	 * @return The called AET
	 */
	public String getCalledAET() {
		return this.response.getCalledAET();
	}

	/**
	 * Return the calling Application Entity Title
	 * 
	 * @return The calling AET
	 */
	public String getCallingAET() {
		return this.response.getCallingAET();
	}

	public long getMaximumLength() {
		return this.response.getMaximumPDUSize();
	}

	public int getMaximumNumberOperationsInvoked() {
		return this.response.getMaximumNumberOperationsInvoked();
	}

	/**
	 * Return the response's called Application Entity Title
	 * 
	 * @since 0.0.9
	 * @return The called AET
	 */
	public String getResponseCalledAET() {
		return this.response.getCalledAET();
	}

	/**
	 * Return the response's calling Application Entity Title
	 * 
	 * @since 0.0.9
	 * @return The calling AET
	 */
	public String getResponseCallingAET() {
		return this.response.getCallingAET();
	}

	public SocketAddress getSocketAddress() {
		return this.ioSession.getRemoteAddress();
	}

	/**
	 * 
	 * @since 0.0.4
	 * 
	 * @param sopClass
	 * @return
	 */
	public byte getSuitablePresentationContextID(SOPClass sopClass) {
		assert sopClass != null;
		return this.getSuitablePresentationContextID(sopClass.getUID());
	}

	/**
	 * return a Accepted PresentationContextID depending of an AbstractSyntax
	 * 
	 * @param abstractSyntaxUID
	 *          the AbstractSyntax
	 * @return the PresentationContextID (-1 if no accepted PresentationContext)
	 */
	public byte getSuitablePresentationContextID(String abstractSyntaxUID) {
		logger.debug("getSuitablePresentationContextID for " + abstractSyntaxUID
				+ " abstractSyntaxUID ");
		byte lPres = this.request.getPresentationContextId(abstractSyntaxUID);
		if (this.isAccepted(lPres)) {
			return lPres;
		} else {
			return -1;
		}
	}

	/**
	 * get a TransferSyntax from a presentationContextId
	 * 
	 * @param presentationContextId
	 * @return the TransferSyntax
	 * @throws DicomException
	 *           if no TransferSyntax could be found
	 */
	public TransferSyntax getTransferSyntax(byte presentationContextId)
	throws DicomException {
		return this.response.getTransferSyntax(presentationContextId);
	}

	public boolean isAccepted(byte aPresentationID) {
		if (aPresentationID == -1) {
			return false; // -1 not present in Response, so it was not accepted
		} else {
			return this.response.isAccepted(aPresentationID);
		}
	}

	/**
	 * check if the remote peer accepted the supplied SOPClass
	 * 
	 * @param sopClass
	 *          the SOPClass
	 * @return true if accepted
	 */
	public boolean isAccepted(SOPClass sopClass) {
		return this.isAccepted(sopClass.getUID());
	}

	/**
	 * check if the remote peer accepted the supplied AbstractSyntaxUID
	 * 
	 * @param abstractSyntaxUID
	 *          the AbstractSyntaxUID
	 * @return true if accepted
	 */
	public boolean isAccepted(String abstractSyntaxUID) {
		return this.isAccepted(this
				.getSuitablePresentationContextID(abstractSyntaxUID));
	}

	@Override
	public String toString() {
		return this.getSocketAddress() + " (Calling: " + this.getCallingAET()
		+ ", Called:" + this.getCalledAET() + ")";
	}

}
