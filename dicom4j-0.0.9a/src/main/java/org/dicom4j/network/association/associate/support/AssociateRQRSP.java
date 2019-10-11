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

package org.dicom4j.network.association.associate.support;

import org.dicom4j.network.association.associate.AssociatePrimitive;
import org.dicom4j.network.protocoldataunit.items.UserInformationItem;
import org.dicom4j.network.protocoldataunit.support.AssociateRQACPDU;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.AsynchronousOperationsWindow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AssociateRQRSP extends AssociatePrimitive {

	/**
	 * the logger
	 */
	private static final Logger logger = LoggerFactory
	.getLogger(AssociateRQRSP.class);

	protected AssociateRQRSP(AssociateRQACPDU aPDU) {
		super(aPDU);
	}

	/*
	 * protected AssociateRQRSP(String aCalledAET, String aCallingAET) { super(new
	 * AssociateRQPDU()); getAssociateRQACPDU().setCalledAET(aCalledAET);
	 * getAssociateRQACPDU().setCallingAET(aCallingAET);
	 * setApplicationContext("1.2.840.10008.3.1.1.1"); //Default
	 * ApplicationContext getAssociateRQACPDU().setUserInformations(
	 * Configuration.MaximumPDUSize(), Implementation.Instance().ClassUID(),
	 * Implementation.Instance().VersionName()); // fCurrentID = 1; }
	 */

	public void addScpScuRoleSelection(String aSOPClassUID, boolean aIsSCU,
			boolean aIsSCP) {
		this.getAssociateRQACPDU().getUserInformationItem().addScpScuRoleSelection(
				aSOPClassUID, aIsSCU, aIsSCP);
	}

	/**
	 * Return the ApplicationContext
	 * 
	 * @return the ApplicationContext
	 */
	public String getApplicationContext() {
		return this.getAssociateRQACPDU().getApplicationContextItem().getName();
	}

	protected AssociateRQACPDU getAssociateRQACPDU() {
		return (AssociateRQACPDU) this.getProtocolDataUnit();
	}

	public AsynchronousOperationsWindow getAsynchronousOperationsWindow() {
		return this.getAssociateRQACPDU().getUserInformationItem()
		.getAsynchronousOperationsWindow();
	}

	/**
	 * Return the CalledAET
	 * 
	 * @return the CalledAET
	 */
	public String getCalledAET() {
		return this.getAssociateRQACPDU().getCalledAETitle().trim();
	}

	/**
	 * Return the CallingAET
	 * 
	 * @return the CallingAET
	 */
	public String getCallingAET() {
		return this.getAssociateRQACPDU().getCallingAETitle().trim();
	}

	public String getImplementationClassUID() {
		return this.getUserInformationItem().getImplementationClassUID();
	}

	public String getImplementationVersionName() {
		return this.getUserInformationItem().getImplementationVersionName();
	}

	public int getMaximumNumberOperationsInvoked() {
		return this.getAssociateRQACPDU().getUserInformationItem()
		.getMaximumNumberOperationsInvoked();
	}

	public int getMaximumNumberOperationsPerformed() {
		return this.getAssociateRQACPDU().getUserInformationItem()
		.getMaximumNumberOperationsPerformed();
	}

	public long getMaximumPDUSize() {
		return this.getAssociateRQACPDU().getUserInformationItem()
		.getMaximumLength();
	}

	protected UserInformationItem getUserInformationItem() {
		return this.getAssociateRQACPDU().getUserInformationItem();
	}

	/**
	 * Set the Application Context to use
	 * 
	 * @param aApplicationContext
	 *          the ApplicationContext
	 */
	public void setApplicationContext(String aApplicationContext) {
		this.getAssociateRQACPDU().setApplicationContext(aApplicationContext);
	}

	/**
	 * Set the called AET
	 * 
	 * @param aCalledAET
	 */
	public void setCalledAET(String aCalledAET) {
		this.getAssociateRQACPDU().setCalledAET(aCalledAET);
	}

	public void setCallingAET(String aCallingAET) {
		this.getAssociateRQACPDU().setCallingAET(aCallingAET);
	}

	public void setClassUID(String classUID) {
		logger.debug("setClassUID: " + classUID);
		// getAssociateRQACPDU().getUserInformationItem().setc

	}

	public String setImplementationClassUID(String implementationClassUID) {
		return this.getUserInformationItem().setImplementationClassUID(
				implementationClassUID);
	}

	public String setImplementationVersionName(String implementationVersionName) {
		return this.getUserInformationItem().setImplementationVersionName(
				implementationVersionName);
	}

	public void setMaximumNumberOperationsInvoked(
			int aMaximumNumberOperationsInvoked) {
		this.getAssociateRQACPDU().getUserInformationItem()
		.setMaximumNumberOperationsInvoked(aMaximumNumberOperationsInvoked);
	}

	public void setMaximumNumberOperationsPerformed(
			int aMaximumNumberOperationsPerformed) {
		this.getAssociateRQACPDU().getUserInformationItem()
		.setMaximumNumberOperationsPerformed(aMaximumNumberOperationsPerformed);
	}

	public void setMaximumPDUSize(long aMaximumPDUSize) {
		this.getAssociateRQACPDU().getUserInformationItem().setMaximumLength(
				aMaximumPDUSize);
	}

}
