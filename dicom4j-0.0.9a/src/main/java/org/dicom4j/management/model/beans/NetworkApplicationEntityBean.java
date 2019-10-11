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

package org.dicom4j.management.model.beans;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.NullArgumentException;
import org.dicom4j.management.Device;
import org.dicom4j.management.NetworkApplicationEntity;
import org.dicom4j.management.NetworkConnection;
import org.dicom4j.management.TransferCapability;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetworkApplicationEntityBean implements NetworkApplicationEntity {

	private static Logger logger = LoggerFactory
	.getLogger(NetworkApplicationEntityBean.class);

	private String aeTitle = "";

	/**
	 * The associated device
	 */
	private Device fDevice = null;

	private List<NetworkConnection> fNetworkConnection;

	private List<TransferCapability> fTransferCapability;

	// private
	public NetworkApplicationEntityBean() {
		super();
		this.fNetworkConnection = new LinkedList<NetworkConnection>();
		this.fTransferCapability = new LinkedList<TransferCapability>();
	}

	public String getAETitle() {
		return this.aeTitle;
	}

	public List<String> getApplicationCluster() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getAssociationAcceptor() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean getAssociationInitiator() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	public Device getDevice() {
		return this.fDevice;
	}

	public boolean getInstalled() {
		// TODO Auto-generated method stub
		return false;
	}

	public List<NetworkConnection> getNetworkConnection() {
		return this.fNetworkConnection;
	}

	public List<String> getPreferredCalledAETitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getPreferredCallingETitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSupportedCharacterSet() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TransferCapability> getTransferCapability() {
		return this.fTransferCapability;
	}

	public TransferCapability getTransferCapability(String aSOpClass) {
		return this.getTransferCapability(aSOpClass, "");
	}

	public TransferCapability getTransferCapability(String aSOpClass, String aRole) {
		return this.getTransferCapability(aSOpClass, aRole, "");
	}

	public TransferCapability getTransferCapability(String aSOpClass,
			String role, String transferSyntaxUID) {
		if (aSOpClass == null) {
			throw new NullArgumentException(
			"NetworkApplicationEntityBean.getTransferCapability");
		}
		Iterator<TransferCapability> it = this.getTransferCapability().iterator();
		// TransferCapability[] lTCs = getTransferCapability();
		while (it.hasNext()) {
			TransferCapability lTC = it.next();

			if (lTC.getSOPClass().equals(aSOpClass.trim())) {
				// sop class if ok

				// if we must check role
				if (!role.equals("")) {
					if (!role.equals(role.trim())) {
						return null; // role request and not equal
					}
				}

				// if we must check TransferSyntax
				if (!transferSyntaxUID.equals("")) {
					Iterator<String> it2 = lTC.getTransferSyntax().iterator();
					// ring[] lTSs = lTC.getTransferSyntax();
					while (it2.hasNext()) {
						if (it2.next().equals(transferSyntaxUID.trim())) {
							return lTC;
						}
					}
				} else { // we found the SOPClass and don't care the TS requested
					return lTC;
				}
			}
		}

		return null;
	}

	public List<Object> getVendorData() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setAETitle(String aAETitle) {
		logger.debug("setAETitle:" + aAETitle);
		this.aeTitle = aAETitle;
	}

	public void setApplicationCluster(List<String> applicationCluster) {
		// TODO Auto-generated method stub

	}

	public void setApplicationCluster(String[] aApplicationCluster) {
		// TODO Auto-generated method stub

	}

	public void setAssociationAcceptor(boolean aAssociationAcceptor) {
		// TODO Auto-generated method stub

	}

	public void setAssociationInitiator(boolean aAssociationInitiator) {
		// TODO Auto-generated method stub

	}

	public void setDescription(String aDescription) {
		// TODO Auto-generated method stub

	}

	public void setDevice(Device aDevice) {
		this.fDevice = aDevice;
	}

	/*
	 * public void setNetworkConnection(NetworkConnection[] aNetworkConnection) {
	 * for (int i = 0; i < aNetworkConnection.length; i++) {
	 * aNetworkConnection[i].setDevice(getDevice()); }
	 * 
	 * fNetworkConnection = aNetworkConnection; }
	 */

	public void setInstalled(boolean aInstalled) {
		// TODO Auto-generated method stub

	}

	public void setNetworkConnection(List<NetworkConnection> networkConnection) {
		// TODO Auto-generated method stub

	}

	public void setPreferredCalledAETitle(List<String> preferredCalledAETitle) {
		// TODO Auto-generated method stub

	}

	/*
	 * public void setTransferCapability(TransferCapability[] aTransferCapability)
	 * { // for (int i = 0; i < aTransferCapability.length; i++) //
	 * aTransferCapability[i].setDevice(getDevice());
	 * 
	 * fTransferCapability = aTransferCapability; }
	 */

	public void setPreferredCalledAETitle(String[] aPreferredCalledAETitle) {
		// TODO Auto-generated method stub

	}

	public void setPreferredCallingAETitle(List<String> preferredCallingAETitle) {
		// TODO Auto-generated method stub

	}

	public void setPreferredCallingAETitle(String[] aPreferredCallingAETitle) {
		// TODO Auto-generated method stub

	}

	public void setSupportedCharacterSet(String aSupportedCharacterSet) {
		// TODO Auto-generated method stub

	}

	public void setTransferCapability(List<TransferCapability> transferCapability) {
		// TODO Auto-generated method stub

	}

	public void setVendorData(List<Object> vendorData) {
		// TODO Auto-generated method stub

	}

	public void setVendorData(Object[] aVendorData) {
		// TODO Auto-generated method stub

	}

}
