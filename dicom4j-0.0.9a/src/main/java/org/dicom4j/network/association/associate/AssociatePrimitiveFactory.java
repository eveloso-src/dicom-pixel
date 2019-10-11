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

/**
 * 
 */
package org.dicom4j.network.association.associate;

import org.dicom4j.core.AbstractFactory;
import org.dicom4j.dicom.implementation.Dicom4jImplementation;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Factory to creates {@link AssociatePrimitive}
 * 
 * 
 * @since 0.0.8
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociatePrimitiveFactory extends AbstractFactory {

	/**
	 * the logger
	 */
	private static final Logger logger = LoggerFactory
	.getLogger(AssociatePrimitiveFactory.class);

	private static final long serialVersionUID = 1L;

	private String classUID;

	private String defaultCalledAET = "ANY-AET";

	private String defaultcallingAET = "ANY-AET";

	private long maximumPduSize;

	private String versionName;

	/**
	 * create new factory
	 */
	public AssociatePrimitiveFactory() {
		super();
		Dicom4jImplementation dicomImplementation = new Dicom4jImplementation();
		this.setMaximumPduSize(65000);
		this.setClassUID(dicomImplementation.getImplementationClassUID()
				.getSingleStringValue());
		this.setVersionName(dicomImplementation.getImplementationVersionName()
				.getSingleStringValue());
	}

	public String getClassUID() {
		return this.classUID;
	}

	/**
	 * @return Returns the defaultCalledAET.
	 */
	public String getDefaultCalledAET() {
		return this.defaultCalledAET;
	}

	/**
	 * @return Returns the defaultcallingAET.
	 */
	public String getDefaultcallingAET() {
		return this.defaultcallingAET;
	}

	public long getMaximumPduSize() {
		return this.maximumPduSize;
	}

	public String getVersionName() {
		return this.versionName;
	}

	public AssociateRequest newAssociateRequest() {
		return this.newAssociateRequest(this.getDefaultCalledAET(),
				this.getDefaultcallingAET());
	}

	public AssociateRequest newAssociateRequest(String calledAET,
			String callingAET) {
		logger.debug("newAssociateRequest");
		AssociateRequest request = new AssociateRequest();
		request.setCalledAET(calledAET);
		request.setCallingAET(callingAET);
		request.setImplementationClassUID(this.getClassUID());
		request.setImplementationVersionName(this.getVersionName());
		request.setMaximumPDUSize(this.getMaximumPduSize());
		return request;
	}

	public AssociateResponse newAssociateResponse() {
		return this.newAssociateResponse(this.getDefaultCalledAET(),
				this.getDefaultcallingAET());
	}

	public AssociateResponse newAssociateResponse(String calledAET,
			String callingAET) {
		logger.debug("newAssociateRequest");
		AssociateResponse primitive = new AssociateResponse();
		primitive.setCalledAET(calledAET);
		primitive.setCallingAET(callingAET);
		primitive.setImplementationClassUID(this.getClassUID());
		primitive.setImplementationVersionName(this.getVersionName());
		primitive.setMaximumPDUSize(this.maximumPduSize);
		return primitive;
	}

	/**
	 * create a new {@link AssociateRequest} with default called and calling AET
	 * 
	 * @return a new AssociateRequest
	 * @since 0.0.9
	 * @see setDefaultCalledAET
	 * @see setDefaultcallingAET
	 */
	public AssociateRequest newStoreAssociateRequest() {
		return this.newStoreAssociateRequest(this.getDefaultCalledAET(),
				this.getDefaultcallingAET());
	}

	/**
	 * create a new {@link AssociateRequest} to perform C-Store primitive
	 * 
	 * @return a new AssociateRequest
	 * @since 0.0.9
	 */
	public AssociateRequest newStoreAssociateRequest(String calledAET,
			String callingAET) {
		AssociateRequest query = this.newAssociateRequest(calledAET, callingAET);
		query.addPresentationContext(SOPClass.Verification, TransferSyntax.Default);
		query.addPresentationContext(SOPClass.CTImageStorage,
				TransferSyntax.Default);
		query.addPresentationContext(SOPClass.ComputedRadiographyImageStorage,
				TransferSyntax.Default);
		query.addPresentationContext(
				SOPClass.DigitalIntraoralXRayImageStorageForPresentation,
				TransferSyntax.Default);
		query.addPresentationContext(
				SOPClass.DigitalIntraoralXRayImageStorageForProcessing,
				TransferSyntax.Default);
		query.addPresentationContext(
				SOPClass.DigitalMammographyXRayImageStorageForPresentation,
				TransferSyntax.Default);
		query
		.addPresentationContext(
				SOPClass.DigitalXRayImageStorageForPresentation,
				TransferSyntax.Default);
		query.addPresentationContext(SOPClass.DigitalXRayImageStorageForProcessing,
				TransferSyntax.Default);
		query.addPresentationContext(SOPClass.EnhancedCTImageStorage,
				TransferSyntax.Default);
		query.addPresentationContext(SOPClass.MRImageStorage,
				TransferSyntax.Default);
		query.addPresentationContext(SOPClass.UltrasoundImageStorage,
				TransferSyntax.Default);
		query.addPresentationContext(SOPClass.UltrasoundImageStorageRetired,
				TransferSyntax.Default);
		query.addPresentationContext(SOPClass.UltrasoundMultiframeImageStorage,
				TransferSyntax.Default);
		query.addPresentationContext(
				SOPClass.UltrasoundMultiframeImageStorageRetired,
				TransferSyntax.Default);
		query.addPresentationContext(SOPClass.SecondaryCaptureImageStorage,
				TransferSyntax.Default);
		return query;
	}

	public AssociateRequest newVerificationQuery() {
		return this.newVerificationQuery("ANY-AET", "ANY-AET");
	}

	/**
	 * return a new {@link AssociateRequest} to perform C-Echo primitive
	 * 
	 * @return the Associate Query
	 * @since 0.0.9
	 */
	public AssociateRequest newVerificationQuery(String calledAET,
			String callingAET) {
		AssociateRequest query = this.newAssociateRequest(calledAET, callingAET);
		query.addPresentationContext(SOPClass.Verification, TransferSyntax.Default);
		return query;
	}

	public void setClassUID(String classUID) {
		this.classUID = classUID;
	}

	/**
	 * @param defaultCalledAET
	 *          The defaultCalledAET to set.
	 */
	public void setDefaultCalledAET(String defaultCalledAET) {
		this.defaultCalledAET = defaultCalledAET;
	}

	/**
	 * @param defaultcallingAET
	 *          The defaultcallingAET to set.
	 */
	public void setDefaultcallingAET(String defaultcallingAET) {
		this.defaultcallingAET = defaultcallingAET;
	}

	public void setMaximumPduSize(long maximumPduSize) {
		logger.debug("setMaximumPduSize: " + maximumPduSize);
		this.maximumPduSize = maximumPduSize;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
}
