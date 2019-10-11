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

package org.dicom4j.network.association;

import java.util.Set;

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
 * <p>
 * Dicom Association (see DICOM PS 3.8)
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface Association {

	public void closeTransportConnection(boolean aWaitARTIM)
	throws AssociationException;

	/**
	 * Returns <tt>true</tt> if this Association contains the attribute with the
	 * specified <tt>key</tt>.
	 */
	boolean containsAttribute(String key);

	/**
	 * @deprecated get the {@link AssociateResponseHandler
	 *             AssociateResponseHandler}
	 * @retrun the AssociateResponseHandler
	 */
	@Deprecated
	public AssociateResponseHandler getAssociateResponseListener();

	/**
	 * <p>
	 * return the current {@link AssociateSession} of this association.
	 * 
	 * <p>
	 * If on association are established calling getAssociateSession will return a
	 * <i>null<i> session
	 * 
	 * @return the AssociateSession or null
	 */
	public AssociateSession getAssociateSession();

	/**
	 * @deprecated get the {@link AssociationListener AssociationListener}
	 * @retrun the AssociationListener
	 */
	// @Deprecated
	// public AssociationListener getAssociationListener();

	/**
	 * the {@link AsynOperationsWindow AsynOperationsWindow}
	 * 
	 * @return the AsynOperationsWindow
	 */
	public AsynOperationsWindow getAsynOperationsWindow();

	/**
	 * Returns an attachment of this Association. This method is identical with
	 * <tt>getAttribute( "" )</tt>.
	 */
	public Object getAttachment();

	/**
	 * Returns the value of user-defined attribute of this Association.
	 * 
	 * @param key
	 *          the key of the attribute
	 * @return <tt>null</tt> if there is no attribute with the specified key
	 */
	public Object getAttribute(String key);

	/**
	 * Returns the set of keys of all user-defined attributes.
	 */
	public Set<String> getAttributeKeys();

	/**
	 * get the {@link AssociationConfiguration}
	 * 
	 * @since 0.0.3
	 * @return the configuration
	 * 
	 */
	@Deprecated
	public AssociationConfiguration getConfiguration();

	/**
	 * return the {@link DimseMessageFactory} to use to creates
	 * {@link DimseMessage}
	 * 
	 * @return the factory
	 * @since 0.0.9
	 */
	public DimseMessageFactory getMessageFactory();

	/**
	 * return the {@link AssociationMonitor}
	 * 
	 * @return the AssociationMonitor
	 */
	public AssociationMonitor getMonitor();

	/**
	 * @deprecated
	 */
	@Deprecated
	public String getTransferSyntaxFromPresentationID(byte aPresentationID);

	/**
	 * Indicates if an association was established
	 * 
	 * @return true if established
	 */
	public boolean isEstablished();

	/**
	 * Indicates that the association is in release State and can be disposed
	 * 
	 * @return thue is released
	 */
	public boolean isReleased();

	/**
	 * Removes a user-defined attribute with the specified key.
	 * 
	 * @return The old value of the attribute. <tt>null</tt> if not found.
	 */
	public Object removeAttribute(String key);

	/**
	 * Send an {@link AssociateAbort AssociateAbort} request to a remote peer
	 * 
	 * @param aAbort
	 *          the Abort request
	 * @throws Exception
	 *           if error occurs
	 */
	public void sendAbort(AssociateAbort aAbort) throws Exception;

	/**
	 * Send an A-ASSOCIATE request to a remote peer
	 * 
	 * @param aRequest
	 *          the {@link AssociateRequest AssociateRequest}
	 * @throws Exception
	 *           if error occurs
	 */
	public void sendAssociate(AssociateRequest aRequest) throws Exception;

	/**
	 * Send a {@link DimseMessage} to a remote peer
	 * 
	 * @param presentationContextID
	 *          the Presentation Context ID to use
	 * @param message
	 *          the {@linkDimseMessage DimseMessage} to send
	 * @throws Exception
	 *           if error occurs
	 */
	public void sendMessage(byte presentationContextID, DimseMessage message)
	throws Exception;

	/**
	 * send a A-ASSOCIATE REJECT
	 * 
	 * @param AssociateReject
	 *          the A-ASSOCIATE REJECT
	 * @throws Exception
	 *           if error occurs
	 */
	public void sendReject(AssociateReject associateReject) throws Exception;

	/**
	 * send a A-ASSOCIATE REJECT
	 * 
	 * @param aResult
	 * @param aSource
	 * @param aReason
	 * @throws Exception
	 *           if error occurs
	 */
	public void sendReject(byte aResult, byte aSource, byte aReason)
	throws Exception;

	/**
	 * Send an A-RELEASE request to a remote peer
	 * 
	 * @throws Exception
	 *           if error occurs
	 */
	public void sendReleaseRequest() throws Exception;

	/**
	 * Send an A-RELEASE response to a remote peer
	 * 
	 * @throws Exception
	 */
	public void sendReleaseResponse() throws Exception;

	/**
	 * @deprecated set the {@link AssociateRequestHandler AssociateRequestHandler}
	 * @param aAssociateRequestHandler
	 */
	@Deprecated
	public void setAssociateRequestListener(
			AssociateRequestHandler aAssociateRequestHandler);

	/**
	 * @deprecated set the {@link AssociateResponseListener
	 *             AssociateResponseHandler}
	 * @param aAssociateResponseHandler
	 *          the listener
	 */
	@Deprecated
	public void setAssociateResponseListener(
			AssociateResponseHandler aAssociateResponseHandler);

	/**
	 * @deprecated Set the {@link AssociationListener AssociationListener} to by
	 *             notify of Associations events
	 * @param aListener
	 *          the listener
	 */
	@Deprecated
	public void setAssociationListener(AssociationListener aListener);

	/**
	 * Sets an attachment of this session. This method is identical with
	 * <tt>setAttribute( "", attachment )</tt>.
	 * 
	 * @return Old attachment. <tt>null</tt> if it is new.
	 */
	Object setAttachment(Object attachment);

	/**
	 * Sets a user defined attribute without a value. This is useful when you just
	 * want to put a 'mark' attribute. Its value is set to {@link Boolean#TRUE}.
	 * 
	 * @param key
	 *          the key of the attribute
	 * @return The old value of the attribute. <tt>null</tt> if it is new.
	 */
	Object setAttribute(String key);

	/**
	 * Sets a user-defined attribute.
	 * 
	 * @param key
	 *          the key of the attribute
	 * @param value
	 *          the value of the attribute
	 * @return The old value of the attribute. <tt>null</tt> if it is new.
	 */
	Object setAttribute(String key, Object value);

	/**
	 * set the {@link AssociationConfiguration}
	 * 
	 * @since 0.0.3
	 * @param aConfiguration
	 *          the configuration
	 * 
	 */
	public void setConfiguration(AssociationConfiguration aConfiguration);

	/**
	 * @deprecated Set the {@link AssociationMonitor AssociationMonitor} for this
	 *             Association
	 * @param aAssociationMonitor
	 *          the monitor
	 */
	@Deprecated
	public void setMonitor(AssociationMonitor aAssociationMonitor);

	/**
	 * Wait an {@link AssociateRequest AssociateRequest} from a remote peer
	 * 
	 * @throws Exception
	 *           if error occurs
	 */
	public void waitAssociate() throws Exception;

}
