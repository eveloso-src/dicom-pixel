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
import org.dicom4j.network.association.AssociationServiceConfiguration;
import org.dicom4j.network.association.associate.AssociatePrimitiveFactory;
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

public class AssociationServiceConfigurationImpl implements
AssociationServiceConfiguration {

	private static final Logger logger = LoggerFactory
	.getLogger(AssociationServiceConfigurationImpl.class);

	private static final long serialVersionUID = 1L;

	private AssociatePrimitiveFactory associatePrimitiveFactory;

	/**
	 * To monitor Assocation Activities
	 */
	private AssociationMonitor associationMonitor;

	private DimseMessageFactory dimseMessageFactory;

	private DimseStatusRegistry dimseStatusRegistry;

	/**
	 * the ARTIMTimeOut (set to 4000 by default)
	 */
	private int fARTIMTimeOut = 4000;

	private AssociateRequestHandler fAssociateRequestHandler;

	private AssociateResponseHandler fAssociateResponseHandler;

	private AssociationListener fAssociationListener;

	private String fClassUID;

	private long maximumPduSize;

	private SOPClassRegistry sopClassRegistry;

	private TransferSyntaxRegistry transferSyntaxRegistry;

	private String versionName;

	public AssociationServiceConfigurationImpl() {
		super();
		this.dimseMessageFactory = new DimseMessageFactory();
		this.associatePrimitiveFactory = new AssociatePrimitiveFactory();

		this.setSopClassRegistry(new SOPClassRegistry());
		this.setTransferSyntaxRegistry(new TransferSyntaxRegistry());
		this.setDimseStatusRegistry(new DimseStatusRegistry());

		this.setAssociateRequestHandler(new DefaultAssociateRequestHandler());
		this.setAssociateResponseHandler(new DefaultAssociateResponseListener());
		this.setAssociationListener(new DefaultAssociationListener());
		this.setMonitor(new DefaultAssociationMonitor());
	}

	public int getARTIMTimeOut() {
		return this.fARTIMTimeOut;
	}

	public AssociatePrimitiveFactory getAssociatePrimitiveFactory() {
		return this.associatePrimitiveFactory;
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
		return this.associationMonitor;
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

	public long getMaximumPduSize() {
		return this.maximumPduSize;
	}

	public SOPClassRegistry getSopClassRegistry() {
		return this.sopClassRegistry;
	}

	public TransferSyntaxRegistry getTransferSyntaxRegistry() {
		return this.transferSyntaxRegistry;
	}

	public String getVersionName() {
		return this.versionName;
	}

	/**
	 * @param timeOut
	 *          The aTimeOut to set. (in ms)
	 */
	public void setARTIMTimeOut(int atimeOut) {
		this.fARTIMTimeOut = atimeOut;
	}

	public void setAssociatePrimitiveFactory(
			AssociatePrimitiveFactory associatePrimitiveFactory,
			boolean overrideConfiguration) {
		this.associatePrimitiveFactory = associatePrimitiveFactory;
		if (overrideConfiguration) {
			this.associatePrimitiveFactory.setClassUID(this.getClassUID());
			this.associatePrimitiveFactory.setVersionName(this.getVersionName());
			this.associatePrimitiveFactory.setMaximumPduSize(this.getMaximumPduSize());
			// this.associatePrimitiveFactory
		}
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
	public void setDimseMessageFactory(DimseMessageFactory dimseMessageFactory,
			boolean overrideConfiguration) {
		this.dimseMessageFactory = dimseMessageFactory;
		if (overrideConfiguration) {
			this.dimseMessageFactory.setSopClassRegistry(this.getSopClassRegistry());
			this.dimseMessageFactory
			.setTransferSyntaxRegistry(this.getTransferSyntaxRegistry());
			this.dimseMessageFactory.setStatusRegistry(this.getDimseStatusRegistry());
		}
	}

	/**
	 * @param registry
	 *          The dimseStatusRegistry to set.
	 */
	public void setDimseStatusRegistry(DimseStatusRegistry registry) {
		this.dimseStatusRegistry = registry;
		this.dimseMessageFactory.setStatusRegistry(registry);
	}

	public void setMaximumPduSize(long maximumPDUSize) {
		this.maximumPduSize = maximumPDUSize;
	}

	public void setMonitor(AssociationMonitor associationMonitor) {
		logger.info("setMonitor: " + associationMonitor);
		this.associationMonitor = associationMonitor;
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
		this.versionName = versionName;
	}

}
