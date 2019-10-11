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

/**
 * Network Connection (see DICOM PS 3.15, table H.1-6)
 * 
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface NetworkConnection {

	/**
	 * get the CommonName
	 * 
	 * @return the CommonName
	 */
	public String getCommonName();

	/**
	 * get the related Device
	 * 
	 * @return
	 */
	public Device getDevice();

	/**
	 * 
	 * @return
	 */
	public String getHostname();

	/**
	 * True if the Network Connection is installed on the network. If not present,
	 * information about the installed status of the Network Connection is
	 * inherited from the device.
	 * 
	 * @return true if installed
	 */
	public boolean getInstalled();

	/**
	 * return the TCP port that the AE is listening on. (This may be missing for a
	 * network connection that only initiates associations.)
	 * 
	 * @return
	 */
	public int getPort();

	public String[] getTLSCipherSuite();

	/**
	 * set the CommonName
	 * 
	 * @param commonName
	 *          the CommonName
	 */
	public void SetCommonName(String commonName);

	/**
	 * set the related Device
	 * 
	 */
	public void setDevice(Device device);

	public void setHostname(String aHostname);

	public void setInstalled(boolean aInstalled);

	/**
	 * set the port
	 * 
	 * @param port
	 */
	public void setPort(int port);

	public void setTLSCipherSuite(String[] aTLSCipherSuite);

}
