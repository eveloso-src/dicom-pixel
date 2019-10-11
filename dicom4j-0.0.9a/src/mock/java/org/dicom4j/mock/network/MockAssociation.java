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

package org.dicom4j.mock.network;

import java.util.Set;

import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.AssociationConfiguration;
import org.dicom4j.network.association.AssociationException;
import org.dicom4j.network.association.AssociationState;
import org.dicom4j.network.association.AsynOperationsWindow;
import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.associate.AssociateReject;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.AssociateRequestHandler;
import org.dicom4j.network.association.listeners.AssociateResponseHandler;
import org.dicom4j.network.association.listeners.AssociationListener;
import org.dicom4j.network.association.listeners.AssociationMonitor;
import org.dicom4j.network.dimse.DimseMessageFactory;
import org.dicom4j.network.dimse.messages.DimseMessage;

/**
 * a Mock Assocication
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class MockAssociation implements Association {

	public int fState = AssociationState.IDLE;

	public boolean isEstablished = false;

	public MockAssociation() {
		this.isEstablished = false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#closeTransportConnection(boolean
	 * )
	 */
	public void closeTransportConnection(boolean waitARTIM)
	throws AssociationException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#containsAttribute(java.lang
	 * .String)
	 */
	public boolean containsAttribute(String key) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#getAssociateResponseListener()
	 */
	public AssociateResponseHandler getAssociateResponseListener() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#getAssociateSession()
	 */
	public AssociateSession getAssociateSession() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#getAssociationListener()
	 */
	public AssociationListener getAssociationListener() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#getAsynOperationsWindow()
	 */
	public AsynOperationsWindow getAsynOperationsWindow() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#getAttachment()
	 */
	public Object getAttachment() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#getAttribute(java.lang.String)
	 */
	public Object getAttribute(String key) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#getAttributeKeys()
	 */
	public Set<String> getAttributeKeys() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#getConfiguration()
	 */
	public AssociationConfiguration getConfiguration() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#getMessageFactory()
	 */
	public DimseMessageFactory getMessageFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#getMonitor()
	 */
	public AssociationMonitor getMonitor() {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#getTransferSyntaxFromPresentationID
	 * (byte)
	 */
	public String getTransferSyntaxFromPresentationID(byte presentationID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isEstablished() {
		return this.isEstablished;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#isReleased()
	 */
	public boolean isReleased() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#removeAttribute(java.lang.String
	 * )
	 */
	public Object removeAttribute(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#sendAbort(org.dicom4j.network
	 * .association.associate.AssociateAbort)
	 */
	public void sendAbort(AssociateAbort abort) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#sendAssociate(org.dicom4j.network
	 * .association.associate.AssociateRequest)
	 */
	public void sendAssociate(AssociateRequest request) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#sendMessage(byte,
	 * org.dicom4j.network.dimse.messages.DimseMessage)
	 */
	public void sendMessage(byte presentationContextID, DimseMessage message)
	throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#sendReject(org.dicom4j.network
	 * .association.associate.AssociateReject)
	 */
	public void sendReject(AssociateReject associateReject) throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#sendReject(byte, byte,
	 * byte)
	 */
	public void sendReject(byte result, byte source, byte reason)
	throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#sendReleaseRequest()
	 */
	public void sendReleaseRequest() throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#sendReleaseResponse()
	 */
	public void sendReleaseResponse() throws Exception {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#setAssociateRequestListener
	 * (org.dicom4j.network.association.listeners.AssociateRequestHandler)
	 */
	public void setAssociateRequestListener(
			AssociateRequestHandler associateRequestHandler) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#setAssociateResponseListener
	 * (org.dicom4j.network.association.listeners.AssociateResponseHandler)
	 */
	public void setAssociateResponseListener(
			AssociateResponseHandler associateResponseHandler) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#setAssociationListener(org.
	 * dicom4j.network.association.listeners.AssociationListener)
	 */
	public void setAssociationListener(AssociationListener listener) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#setAttachment(java.lang.Object)
	 */
	public Object setAttachment(Object attachment) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#setAttribute(java.lang.String)
	 */
	public Object setAttribute(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#setAttribute(java.lang.String,
	 * java.lang.Object)
	 */
	public Object setAttribute(String key, Object value) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#setConfiguration(org.dicom4j
	 * .network.association.AssociationConfiguration)
	 */
	public void setConfiguration(AssociationConfiguration configuration) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dicom4j.network.association.Association#setMonitor(org.dicom4j.network
	 * .association.AssociationMonitor)
	 */
	public void setMonitor(AssociationMonitor associationMonitor) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.association.Association#waitAssociate()
	 */
	public void waitAssociate() throws Exception {
		// TODO Auto-generated method stub

	}

}
