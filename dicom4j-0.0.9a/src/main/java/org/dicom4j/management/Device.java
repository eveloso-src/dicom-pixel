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
 * Device (see DICOM PS 3.15, table H.1-2)
 * 
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface Device {

	public NetworkConnection addNetworkConnection(
			NetworkConnection networkConnection);

	public String getDescription();

	public String getDeviceName();

	public List<NetworkApplicationEntity> getNetworkApplicationEntity();

	public NetworkApplicationEntity getNetworkApplicationEntity(String aAET);

	public List<NetworkConnection> getNetworkConnection();

	public boolean isInstalled();

	public void setDescription(String description);

	public void setDeviceName(String deviceName);

	public void setInstalled(boolean aInstalled);

	public void setNetworkApplicationEntity(
			List<NetworkApplicationEntity> networkApplicationEntity);

	public void setNetworkConnection(List<NetworkConnection> networkConnection);

}
