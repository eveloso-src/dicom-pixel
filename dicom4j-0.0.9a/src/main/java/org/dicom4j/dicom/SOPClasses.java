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
 */
// generated class, do not edit
package org.dicom4j.dicom;

import org.dicom4j.dicom.uniqueidentifiers.support.UniqueIdentifiers;

/**
 * DICOM SOPClasses
 * 
 * <p>
 * (generated class, do not edit)
 * 
 * @deprecated </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
@Deprecated
public class SOPClasses extends UniqueIdentifiers {

	/**
	 * the innter SOPClasses to store UID
	 */
	private static final SOPClasses fSOPClasses = new SOPClasses();

	/**
	 * get a SOP Class UID as a string
	 * 
	 * @param aUID
	 *          the SOP Class UID
	 * @return SOP Class as String
	 */
	//
	public static String toString(String aUID) {
		return fSOPClasses.getName(aUID);
	}

	/**
	 * creates new instance
	 */
	public SOPClasses() {
		super();
	}

	protected void addUIDs() {
		this.add(SOPClass.AmbulatoryECGWaveformStorage);
		this.add(SOPClass.BasicAnnotationBox);
		this.add(SOPClass.BasicColorImageBox);
		this.add(SOPClass.BasicFilmBoxSOP);
		this.add(SOPClass.BasicFilmSession);
		this.add(SOPClass.BasicGrayscaleImageBox);
		this.add(SOPClass.BasicPrintImageOverlayBox);
		this.add(SOPClass.BasicStudyContentNotification);
		this.add(SOPClass.BasicTextSR);
		this.add(SOPClass.BasicVoiceAudioWaveformStorage);
		this.add(SOPClass.BreastImagingRelevantPatientInformationQuery);
		this.add(SOPClass.CTImageStorage);
		this.add(SOPClass.CardiacElectrophysiologyWaveformStorage);
		this.add(SOPClass.CardiacRelevantPatientInformationQuery);
		this.add(SOPClass.ChestCADSR);
		this.add(SOPClass.ComprehensiveSR);
		this.add(SOPClass.ComputedRadiographyImageStorage);
		this.add(SOPClass.DetachedInterpretationManagement);
		this.add(SOPClass.DetachedPatientManagement);
		this.add(SOPClass.DetachedResultsManagement);
		this.add(SOPClass.DetachedStudyManagement);
		this.add(SOPClass.DetachedVisitManagement);
		this.add(SOPClass.DigitalIntraoralXRayImageStorageForPresentation);
		this.add(SOPClass.DigitalIntraoralXRayImageStorageForProcessing);
		this.add(SOPClass.DigitalMammographyXRayImageStorageForPresentation);
		this.add(SOPClass.DigitalMammographyXRayImageStorageForProcessing);
		this.add(SOPClass.DigitalXRayImageStorageForPresentation);
		this.add(SOPClass.DigitalXRayImageStorageForProcessing);
		this.add(SOPClass.EncapsulatedPDFStorage);
		this.add(SOPClass.EnhancedCTImageStorage);
		this.add(SOPClass.EnhancedMRImageStorage);
		this.add(SOPClass.EnhancedSR);
		this.add(SOPClass.GeneralECGWaveformStorage);
		this.add(SOPClass.GeneralPurposePerformedProcedureStepSOPClass);
		this.add(SOPClass.GeneralPurposeScheduledProcedureStepSOPClass);
		this.add(SOPClass.GeneralPurposeWorklistInformationModelFIND);
		this.add(SOPClass.GrayscaleSoftcopyPresentationStateStorage);
		this.add(SOPClass.HangingProtocolInformationModelFIND);
		this.add(SOPClass.HangingProtocolInformationModelMOVE);
		this.add(SOPClass.HangingProtocolStorage);
		this.add(SOPClass.HardcopyColorImageStorage);
		this.add(SOPClass.HardcopyGrayscaleImageStorage);
		this.add(SOPClass.HemodynamicWaveformStorage);
		this.add(SOPClass.ImageOverlayBox);
		this.add(SOPClass.InstanceAvailabilityNotificationSOPClass);
		this.add(SOPClass.KeyObjectSelectionDocument);
		this.add(SOPClass.MRImageStorage);
		this.add(SOPClass.MRSpectroscopyStorage);
		this.add(SOPClass.MammographyCADSR);
		this.add(SOPClass.MediaCreationManagementSOPClass);
		this.add(SOPClass.MediaStorageDirectoryStorage);
		this.add(SOPClass.ModalityPerformedProcedureStep);
		this.add(SOPClass.ModalityPerformedProcedureStepNotification);
		this.add(SOPClass.ModalityPerformedProcedureStepRetrieve);
		this.add(SOPClass.ModalityWorklistInformationModelFIND);
		this.add(SOPClass.MultiframeColorSecondaryCaptureImageStorage);
		this.add(SOPClass.MultiframeGrayscaleByteSecondaryCaptureImageStorage);
		this.add(SOPClass.MultiframeGrayscaleWordSecondaryCaptureImageStorage);
		this.add(SOPClass.MultiframeSingleBitSecondaryCaptureImageStorage);
		this.add(SOPClass.NuclearMedicineImageStorage);
		this.add(SOPClass.NuclearMedicineImageStorageRetired);
		this.add(SOPClass.OphthalmicPhotography16BitImageStorage);
		this.add(SOPClass.OphthalmicPhotography8BitImageStorage);
		this.add(SOPClass.PatientInformationQuery);
		this.add(SOPClass.PatientRootQueryRetrieveInformationModelFIND);
		this.add(SOPClass.PatientRootQueryRetrieveInformationModelGET);
		this.add(SOPClass.PatientRootQueryRetrieveInformationModelMOVE);
		this.add(SOPClass.PatientStudyOnlyQueryRetrieveInformationModelFIND);
		this.add(SOPClass.PatientStudyOnlyQueryRetrieveInformationModelGET);
		this.add(SOPClass.PatientStudyOnlyQueryRetrieveInformationModelMOVE);
		this.add(SOPClass.PositronEmissionTomographyImageStorage);
		this.add(SOPClass.PresentationLUT);
		this.add(SOPClass.PrintJob);
		this.add(SOPClass.PrintQueueManagement);
		this.add(SOPClass.Printer);
		this.add(SOPClass.PrinterConfigurationRetrieval);
		this.add(SOPClass.ProceduralEventLoggingSOPClass);
		this.add(SOPClass.ProcedureLogStorage);
		this.add(SOPClass.PullPrintRequest);
		this.add(SOPClass.RTBeamsTreatmentRecordStorage);
		this.add(SOPClass.RTBrachyTreatmentRecordStorage);
		this.add(SOPClass.RTDoseStorage);
		this.add(SOPClass.RTImageStorage);
		this.add(SOPClass.RTIonBeamsTreatmentRecordStorage);
		this.add(SOPClass.RTIonPlanStorage);
		this.add(SOPClass.RTPlanStorage);
		this.add(SOPClass.RTStructureSetStorage);
		this.add(SOPClass.RTTreatmentSummaryRecordStorage);
		this.add(SOPClass.RawDataStorage);
		this.add(SOPClass.ReferencedImageBoxRetired);
		this.add(SOPClass.SecondaryCaptureImageStorage);
		this.add(SOPClass.SpatialFiducialsStorage);
		this.add(SOPClass.SpatialRegistrationStorage);
		this.add(SOPClass.StandaloneCurveStorage);
		this.add(SOPClass.StandaloneModalityLUTStorage);
		this.add(SOPClass.StandaloneOverlayStorage);
		this.add(SOPClass.StandalonePETCurveStorage);
		this.add(SOPClass.StandaloneVOILUTStorage);
		this.add(SOPClass.StereometricRelationshipStorage);
		this.add(SOPClass.StorageCommitmentPullModel);
		this.add(SOPClass.StorageCommitmentPushModel);
		this.add(SOPClass.StorageServiceClass);
		this.add(SOPClass.StoredPrintStorage);
		this.add(SOPClass.StudyComponentManagement);
		this.add(SOPClass.StudyRootQueryRetrieveInformationModelFIND);
		this.add(SOPClass.StudyRootQueryRetrieveInformationModelGET);
		this.add(SOPClass.StudyRootQueryRetrieveInformationModelMOVE);
		this.add(SOPClass.TwelveLeadECGWaveformStorage);
		this.add(SOPClass.UltrasoundImageStorage);
		this.add(SOPClass.UltrasoundImageStorageRetired);
		this.add(SOPClass.UltrasoundMultiframeImageStorage);
		this.add(SOPClass.UltrasoundMultiframeImageStorageRetired);
		this.add(SOPClass.VLEndoscopicImageStorage);
		this.add(SOPClass.VLImageStorageRetired);
		this.add(SOPClass.VLMicroscopicImageStorage);
		this.add(SOPClass.VLMultiframeImageStorageRetired);
		this.add(SOPClass.VLPhotographicImageStorage);
		this.add(SOPClass.VLSlideCoordinatesMicroscopicImageStorage);
		this.add(SOPClass.VOILUTBox);
		this.add(SOPClass.Verification);
		this.add(SOPClass.VideoEndoscopicImageStorage);
		this.add(SOPClass.VideoMicroscopicImageStorage);
		this.add(SOPClass.VideoPhotographicImageStorage);
		this.add(SOPClass.XRayAngiographicBiPlaneImageStorageRetired);
		this.add(SOPClass.XRayAngiographicImageStorage);
		this.add(SOPClass.XRayRadiofluoroscopicImageStorage);
	}

}