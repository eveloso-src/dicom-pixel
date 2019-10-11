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

package org.dicom4j.management;

import java.util.List;

/**
 * Network Application Entity (see DICOM PS 3.15, table H.1-4)
 * 
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface NetworkApplicationEntity {

	/**
	 * return the AE Title of the entity
	 * 
	 * @return the AE Title
	 */
	public String getAETitle();

	public List<String> getApplicationCluster();

	/**
	 * return true is the entity is an association acceptor
	 * 
	 * @return true if acceptor
	 */
	public boolean getAssociationAcceptor();

	/**
	 * return true is the entity is an association initiator
	 * 
	 * @return true if initiator
	 */
	public boolean getAssociationInitiator();

	public String getDescription();

	public boolean getInstalled();

	public List<NetworkConnection> getNetworkConnection();

	public List<String> getPreferredCalledAETitle();

	public List<String> getPreferredCallingETitle();

	public String getSupportedCharacterSet();

	public List<TransferCapability> getTransferCapability();

	/**
	 * Get a TransferCapability depending of a SOPClass
	 * 
	 * @param sopClass
	 *          the SOPClass
	 * @return the TransferCapability (null if not found)
	 */
	public TransferCapability getTransferCapability(String sopClass);

	/**
	 * Get a TransferCapability depending of a SOPClass and his Role
	 * 
	 * @param aSOPClass
	 *          the SOPClass
	 * @param aRole
	 *          the role
	 * @return the TransferCapability (null if not found)
	 */
	public TransferCapability getTransferCapability(String aSOPClass, String aRole);

	/**
	 * Get a TransferCapability depending of a SOPClass, his Role, and a
	 * TransferSyntax
	 * 
	 * @param aSOPClass
	 *          the SOPClass
	 * @param aRole
	 *          the role
	 * @param aTransferSyntax
	 *          the TransferSyntax
	 * @return the TransferCapability (null if not found)
	 */
	public TransferCapability getTransferCapability(String aSOPClass,
			String aRole, String aTransferSyntax);

	public List<Object> getVendorData();

	public void setAETitle(String aeTitle);

	// public String getNetworkConnection();

	// public void setDescription(String aDescription);

	public void setApplicationCluster(List<String> aApplicationCluster);

	public void setAssociationAcceptor(boolean aAssociationAcceptor);

	public void setAssociationInitiator(boolean aAssociationInitiator);

	public void setDescription(String aDescription);

	public void setInstalled(boolean installed);

	public void setNetworkConnection(List<NetworkConnection> networkConnection);

	public void setPreferredCalledAETitle(List<String> aPreferredCalledAETitle);

	public void setPreferredCallingAETitle(List<String> aPreferredCallingAETitle);

	public void setSupportedCharacterSet(String aSupportedCharacterSet);

	public void setTransferCapability(List<TransferCapability> transferCapability);

	public void setVendorData(List<Object> vendorData);

}
