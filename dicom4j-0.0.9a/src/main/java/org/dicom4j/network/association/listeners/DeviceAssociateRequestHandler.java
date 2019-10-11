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

package org.dicom4j.network.association.listeners;

import java.util.Iterator;

import org.apache.commons.lang.NullArgumentException;
import org.dicom4j.management.Device;
import org.dicom4j.network.NetworkStaticProperties;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.dicom4j.network.association.associate.AssociateResponse;
import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;
import org.dicom4j.network.protocoldataunit.support.AbstractPresentationContextItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * implementation of {@link AssociateRequestHandler AssociateRequestHandler}
 * using a {@link Device Device} to know supported SOPClass and
 * TransferSyntaxes.
 * 
 * If not Device is set, a warning is write in the log, and all requests will be
 * refused
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class DeviceAssociateRequestHandler implements AssociateRequestHandler {

	private static Logger flogger = LoggerFactory
	.getLogger(DeviceAssociateRequestHandler.class);

	/**
	 * The device
	 */
	private Device fDevice;

	public DeviceAssociateRequestHandler(Device aDevice) {
		super();
		this.setDevice(aDevice);
	}

	/**
	 * Internal perfom of request
	 * 
	 * @param aDevice
	 *          the device (always != null)
	 * @param aAssociation
	 *          the assocation
	 * @param aAssociateRequest
	 * @param aResponse
	 *          the reponse already created
	 * @return
	 * @throws Exception
	 */
	protected AssociateResponse dorequestReceived(Device aDevice,
			Association aAssociation, AssociateRequest aAssociateRequest,
			AssociateResponse aResponse) throws Exception {
		Iterator<AbstractPresentationContextItem> lIt = aAssociateRequest
		.getPresentationIterator();
		while (lIt.hasNext()) {
			PresentationContexRequestItem lPres = (PresentationContexRequestItem) lIt
			.next();
			if (this.getDevice() == null) {
				aResponse.addPresentationContext(lPres.getID(),
						NetworkStaticProperties.PresentationContextReasons.USER_REJECTION,
						lPres.getTransferSyntax(0));
			}
		}
		return aResponse;
	}

	public Device getDevice() {
		return this.fDevice;
	}

	public AssociateResponse requestReceived(Association aAssociation,
			AssociateRequest aAssociateRequest) throws Exception {
		AssociateResponse lResponse = new AssociateResponse(aAssociateRequest
				.getCalledAET(), aAssociateRequest.getCallingAET());
		if (this.getDevice() == null) {
			flogger.warn("No Device was set, we send Reject");
			return null; // null will cause send a reject
		} else {
			return this.dorequestReceived(this.getDevice(), aAssociation,
					aAssociateRequest, lResponse);
		}
	}

	public void setDevice(Device aDevice) {
		if (aDevice != null) {
			flogger.debug("setDevice: " + aDevice.getDeviceName());
			this.fDevice = aDevice;
		} else {
			throw new NullArgumentException("DeviceAssociateRequestHandler.setDevice");
		}
	}

	@Override
	public String toString() {
		String lRes = "DeviceAssociateRequestHandler";
		if (this.getDevice() != null) {
			return lRes + " (Device: " + this.getDevice().getDeviceName() + ")";
		} else {
			return lRes + " (No Device)";
		}
	}

}
