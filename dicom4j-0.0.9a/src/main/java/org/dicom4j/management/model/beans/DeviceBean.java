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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dicom4j.management.Device;
import org.dicom4j.management.NetworkApplicationEntity;
import org.dicom4j.management.NetworkConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link Device Device} bean
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DeviceBean implements Device {

	private static Logger flogger = LoggerFactory.getLogger(DeviceBean.class);

	private String deviceName = "";

	private String fDescription = "";

	private boolean fisInstalled = false;

	private List<NetworkApplicationEntity> networkAE;

	private List<NetworkConnection> networkConnection;

	public DeviceBean() {
		this.networkAE = new ArrayList<NetworkApplicationEntity>();
		this.networkConnection = new ArrayList<NetworkConnection>();
	}

	public NetworkConnection addNetworkConnection(
			NetworkConnection networkConnection) {
		flogger.debug("addNetworkConnection:" + networkConnection);
		networkConnection.setDevice(this);
		this.networkConnection.add(networkConnection);
		return networkConnection;
	}

	public String getDescription() {
		return this.fDescription;
	}

	public String getDeviceName() {
		return this.deviceName;
	}

	public List<NetworkApplicationEntity> getNetworkApplicationEntity() {
		return this.networkAE;
	}

	public NetworkApplicationEntity getNetworkApplicationEntity(String aAET) {
		for (int i = 0; i < this.networkAE.size(); i++) {
			if (this.networkAE.get(i).getAETitle().equals(aAET.trim())) {
				return this.networkAE.get(i);
			}
		}
		return null;
	}

	public List<NetworkConnection> getNetworkConnection() {
		return this.networkConnection;
	}

	public boolean isInstalled() {
		return this.fisInstalled;
	}

	public void setDescription(String aDescription) {
		this.fDescription = aDescription;
	}

	public void setDeviceName(String aDeviceName) {
		this.deviceName = aDeviceName;
	}

	public void setInstalled(boolean aInstalled) {
		this.fisInstalled = aInstalled;
	}

	public void setNetworkApplicationEntity(
			List<NetworkApplicationEntity> aNetworkApplicationEntity) {
		assert aNetworkApplicationEntity != null;
		this.networkAE = aNetworkApplicationEntity;
	}

	public void setNetworkConnection(List<NetworkConnection> aNetworkConnection) {
		flogger.debug("setNetworkConnection");
		Iterator<NetworkConnection> it;

		it = this.networkConnection.iterator();
		while (it.hasNext()) {
			NetworkConnection connection = it.next();
			connection.setDevice(null);
		}

		it = aNetworkConnection.iterator();
		while (it.hasNext()) {
			NetworkConnection connection = it.next();
			connection.setDevice(this);
		}

		this.networkConnection = aNetworkConnection;
	}

}
