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

package org.dicom4j.network.association.support;

import org.dicom4j.dicom.network.dimse.DimseStatusRegistry;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.network.association.AssociationConfiguration;
import org.dicom4j.network.association.listeners.AssociateRequestHandler;
import org.dicom4j.network.association.listeners.AssociateResponseHandler;
import org.dicom4j.network.association.listeners.AssociationListener;
import org.dicom4j.network.association.listeners.AssociationMonitor;
import org.dicom4j.network.association.listeners.DefaultAssociateRequestHandler;
import org.dicom4j.network.association.listeners.DefaultAssociateResponseListener;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.dicom4j.network.association.listeners.DefaultAssociationMonitor;
import org.dicom4j.network.dimse.DimseMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract {@link AssociationConfiguration} implements
 * 
 * @since 0.0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociationConfigurationImpl implements AssociationConfiguration {

	/**
	 * The logger
	 */
	protected static final Logger logger = LoggerFactory
	.getLogger(AssociationConfigurationImpl.class);

	private DimseMessageFactory dimseMessageFactory;

	private DimseStatusRegistry dimseStatusRegistry;

	/**
	 * the ARTIMTimeOut (set to 4000 by default)
	 */
	private int fARTIMTimeOut = 4000;

	private AssociateRequestHandler fAssociateRequestHandler;

	private AssociateResponseHandler fAssociateResponseHandler;

	private AssociationListener fAssociationListener;

	/**
	 * To monitor Assocation Activities
	 */
	private AssociationMonitor fAssociationMonitor;

	private String fClassUID;

	private long fMaximumPDUSize;

	private String fVersionName;

	private SOPClassRegistry sopClassRegistry;

	private TransferSyntaxRegistry transferSyntaxRegistry;

	public AssociationConfigurationImpl() {
		super();
		this.dimseMessageFactory = new DimseMessageFactory();

		this.setSopClassRegistry(new SOPClassRegistry());
		this.setTransferSyntaxRegistry(new TransferSyntaxRegistry());
		this.setAssociateRequestHandler(new DefaultAssociateRequestHandler());
		this.setAssociateResponseHandler(new DefaultAssociateResponseListener());
		this.setAssociationListener(new DefaultAssociationListener());
		this.setMonitor(new DefaultAssociationMonitor());
	}

	public int getARTIMTimeOut() {
		return this.fARTIMTimeOut;
	}

	public AssociateRequestHandler getAssociateRequestHandler() {
		return this.fAssociateRequestHandler;
	}

	public AssociateResponseHandler getAssociateResponseHandler() {
		return this.fAssociateResponseHandler;
	}

	public AssociationListener getAssociationListener() {
		return this.fAssociationListener;
	}

	public AssociationMonitor getAssociationMonitor() {
		return this.fAssociationMonitor;
	}

	public String getClassUID() {
		return this.fClassUID;
	}

	/**
	 * @return Returns the dimseMessageFactory.
	 */
	public DimseMessageFactory getDimseMessageFactory() {
		return this.dimseMessageFactory;
	}

	/**
	 * @return Returns the dimseStatusRegistry.
	 */
	public DimseStatusRegistry getDimseStatusRegistry() {
		return this.dimseStatusRegistry;
	}

	public long getMaximumPDUSize() {
		return this.fMaximumPDUSize;
	}

	public SOPClassRegistry getSopClassRegistry() {
		return this.getDimseMessageFactory().getSopClassRegistry();
	}

	public TransferSyntaxRegistry getTransferSyntaxRegistry() {
		return this.getDimseMessageFactory().getTransferSyntaxRegistry();
	}

	public String getVersionName() {
		return this.fVersionName;
	}

	/**
	 * @param timeOut
	 *          The aTimeOut to set. (in ms)
	 */
	public void setARTIMTimeOut(int atimeOut) {
		this.fARTIMTimeOut = atimeOut;
	}

	public void setAssociateRequestHandler(
			AssociateRequestHandler aAssociateRequestHandler) {
		logger.debug("setAssociateRequestHandler: " + aAssociateRequestHandler);
		this.fAssociateRequestHandler = aAssociateRequestHandler;
	}

	public void setAssociateResponseHandler(
			AssociateResponseHandler aAssociateResponseHandler) {
		logger.debug("setAssociateResponseHandler: " + aAssociateResponseHandler);
		this.fAssociateResponseHandler = aAssociateResponseHandler;
	}

	public void setAssociationListener(AssociationListener aListener) {
		logger.debug("setAssociationListener: " + aListener);
		this.fAssociationListener = aListener;
		assert this.fAssociationListener != null;
	}

	public void setClassUID(String classUID) {
		this.fClassUID = classUID;
	}

	/**
	 * Set the {@link DimseMessageFactory} to use. if overrideConfiguration is
	 * true the Factory configuration will be override with the current
	 * configuration of this instance
	 * 
	 * @param dimseMessageFactory
	 *          The dimseMessageFactory to set.
	 * 
	 */
	public void setDimseMessageFactory(DimseMessageFactory dimseMessageFactory) {
		this.dimseMessageFactory = dimseMessageFactory;
	}

	/**
	 * @param dimseStatusRegistry
	 *          The dimseStatusRegistry to set.
	 */
	public void setDimseStatusRegistry(DimseStatusRegistry dimseStatusRegistry) {
		this.dimseStatusRegistry = dimseStatusRegistry;
		this.dimseMessageFactory.setStatusRegistry(this.getDimseStatusRegistry());
	}

	public void setMaximumPDUSize(long maximumPDUSize) {
		this.fMaximumPDUSize = maximumPDUSize;
	}

	public void setMonitor(AssociationMonitor aAssociationMonitor) {
		logger.debug("setMonitor: " + aAssociationMonitor);
		this.fAssociationMonitor = aAssociationMonitor;
	}

	public void setSopClassRegistry(SOPClassRegistry registry) {
		logger.debug("setSopClassRegistry: " + registry);
		this.sopClassRegistry = registry;
		this.dimseMessageFactory.setSopClassRegistry(this.getSopClassRegistry());
	}

	public void setTransferSyntaxRegistry(TransferSyntaxRegistry registry) {
		logger.debug("setTransferSyntaxRegistry: " + registry);
		this.transferSyntaxRegistry = registry;
		this.dimseMessageFactory
		.setTransferSyntaxRegistry(this.getTransferSyntaxRegistry());
	}

	public void setVersionName(String versionName) {
		this.fVersionName = versionName;
	}

}
