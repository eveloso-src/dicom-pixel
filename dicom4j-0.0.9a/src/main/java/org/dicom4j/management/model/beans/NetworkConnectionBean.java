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

import org.dicom4j.management.Device;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link NetworkConnectionBean NetworkConnection} bean
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class NetworkConnectionBean {

	/**
	 * the logger
	 */
	private static Logger flogger = LoggerFactory
	.getLogger(NetworkConnectionBean.class);

	/**
	 * the related device
	 */
	private Device fDevice;

	/**
	 * the port
	 */
	private int fPort = 104; // default DICOM value

	public String getCommonName() {
		return "";
	}

	public Device getDevice() {
		return this.fDevice;
	}

	public String getHostname() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getInstalled() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getPort() {
		return this.fPort;
	}

	public String[] getTLSCipherSuite() {
		// TODO Auto-generated method stub
		return null;
	}

	public void SetCommonName(String aCommonName) {
		// TODO Auto-generated method stub

	}

	public void setDevice(Device aDevice) {
		this.fDevice = aDevice;
	}

	public void setHostname(String aHostname) {
		// TODO Auto-generated method stub

	}

	public void setInstalled(boolean aInstalled) {
		// TODO Auto-generated method stub

	}

	public void setPort(int aPort) {
		this.fPort = aPort;
		flogger.debug("setPort:" + this.fPort);
	}

	public void setTLSCipherSuite(String[] aTLSCipherSuite) {
		// TODO Auto-generated method stub

	}

}
