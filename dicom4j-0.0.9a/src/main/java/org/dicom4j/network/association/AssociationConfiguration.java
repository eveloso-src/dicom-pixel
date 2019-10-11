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

import org.dicom4j.dicom.network.dimse.DimseStatusRegistry;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.network.association.listeners.AssociateRequestHandler;
import org.dicom4j.network.association.listeners.AssociateResponseHandler;
import org.dicom4j.network.association.listeners.AssociationListener;
import org.dicom4j.network.association.listeners.AssociationMonitor;
import org.dicom4j.network.dimse.DimseMessageFactory;

/**
 * Association's Configuration items
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface AssociationConfiguration {

	public int getARTIMTimeOut();

	/**
	 * get the {@link AssociateRequestHandler }
	 * 
	 * @retrun the handler
	 */
	public AssociateRequestHandler getAssociateRequestHandler();

	/**
	 * get the {@link AssociateResponseHandler AssociateResponseHandler}
	 * 
	 * @retrun the AssociateResponseHandler
	 */
	public AssociateResponseHandler getAssociateResponseHandler();

	/**
	 * get the {@link AssociationListener AssociationListener}
	 * 
	 * @retrun the AssociationListener
	 */
	public AssociationListener getAssociationListener();

	/**
	 * get the {@link AssociationMonitor AssociationMonitor}
	 * 
	 * @return the AssociationMonitor
	 */
	public AssociationMonitor getAssociationMonitor();

	// public String getClassUID();

	// public long getMaximumPDUSize();

	/**
	 * return the current {@link DimseMessageFactory}
	 * 
	 * @return the dimseMessageFactory.
	 * @since 0.0.9
	 */
	public DimseMessageFactory getDimseMessageFactory();

	/**
	 * @return Returns the dimseStatusRegistry.
	 */
	public DimseStatusRegistry getDimseStatusRegistry();

	// public String getVersionName();

	/**
	 * @param timeOut
	 *          The aTimeOut to set.
	 */
	// public void setARTIMTimeOut(int atimeOut);

	/**
	 * set the {@link AssociateRequestHandler AssociateRequestHandler}
	 * 
	 * @param aAssociateRequestHandler
	 */
	// public void setAssociateRequestHandler(AssociateRequestHandler
	// aAssociateRequestHandler);

	/**
	 * set the {@link AssociateResponseListener AssociateResponseHandler}
	 * 
	 * @param aAssociateResponseHandler
	 *          the listener
	 */
	// public void setAssociateResponseHandler(AssociateResponseHandler
	// aAssociateResponseHandler);

	/**
	 * set the {@link AssociationListener AssociationListener} to by notify of
	 * Associations events
	 * 
	 * @param aListener
	 *          the listener
	 */
	// public void setAssociationListener(AssociationListener aListener);

	// public void setClassUID(String classUID);

	// public void setMaximumPDUSize(long maximumPDUSize);

	// public void setVersionName(String versionName);

	/**
	 * return the current {@link SOPClassRegistry}
	 * 
	 * @return the SOPClassRegistry
	 * @since 0.0.9
	 */
	public SOPClassRegistry getSopClassRegistry();

	public TransferSyntaxRegistry getTransferSyntaxRegistry();

}
