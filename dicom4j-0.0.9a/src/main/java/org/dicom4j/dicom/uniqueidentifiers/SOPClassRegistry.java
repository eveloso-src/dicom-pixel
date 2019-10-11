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

package org.dicom4j.dicom.uniqueidentifiers;

import org.dicom4j.core.registry.NotFoundRegistryException;
import org.dicom4j.dicom.uniqueidentifiers.support.AbstractUniqueIdentifierRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Registry of {@link SOPClass}
 * </p>
 * 
 * @since 0.0.8
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class SOPClassRegistry extends AbstractUniqueIdentifierRegistry {

	private static final Logger logger = LoggerFactory
	.getLogger(SOPClassRegistry.class);

	private static final long serialVersionUID = 1L;

	public SOPClassRegistry() {
		super();
	}

	@Override
	public SOPClass getByUID(String uid) throws NotFoundRegistryException {
		if (uid.length() == 0) {
			throw new NotFoundRegistryException("SOPClass", "no UID");
		}
		logger.debug("getSopClass, UID: " + uid);
		SOPClass result = null;
		if (uid.equals(SOPClass.AmbulatoryECGWaveformStorage.getUID())) {
			result = SOPClass.AmbulatoryECGWaveformStorage;
		}
		if (uid.equals(SOPClass.BasicAnnotationBox.getUID())) {
			result = SOPClass.BasicAnnotationBox;
		}
		if (uid.equals(SOPClass.BasicColorImageBox.getUID())) {
			result = SOPClass.BasicColorImageBox;
		}
		if (uid.equals(SOPClass.BasicFilmBoxSOP.getUID())) {
			result = SOPClass.BasicFilmBoxSOP;
		}
		if (uid.equals(SOPClass.BasicFilmSession.getUID())) {
			result = SOPClass.BasicFilmSession;
		}
		if (uid.equals(SOPClass.BasicGrayscaleImageBox.getUID())) {
			result = SOPClass.BasicGrayscaleImageBox;
		}
		if (uid.equals(SOPClass.BasicPrintImageOverlayBox.getUID())) {
			result = SOPClass.BasicPrintImageOverlayBox;
		}
		if (uid.equals(SOPClass.BasicStudyContentNotification.getUID())) {
			result = SOPClass.BasicStudyContentNotification;
		}
		if (uid.equals(SOPClass.BasicTextSR.getUID())) {
			result = SOPClass.BasicTextSR;
		}
		if (uid.equals(SOPClass.BasicVoiceAudioWaveformStorage.getUID())) {
			result = SOPClass.BasicVoiceAudioWaveformStorage;
		}
		if (uid.equals(SOPClass.BreastImagingRelevantPatientInformationQuery
				.getUID())) {
			result = SOPClass.BreastImagingRelevantPatientInformationQuery;
		}
		if (uid.equals(SOPClass.CTImageStorage.getUID())) {
			result = SOPClass.CTImageStorage;
		}
		if (uid.equals(SOPClass.CardiacElectrophysiologyWaveformStorage.getUID())) {
			result = SOPClass.CardiacElectrophysiologyWaveformStorage;
		}
		if (uid.equals(SOPClass.CardiacRelevantPatientInformationQuery.getUID())) {
			result = SOPClass.CardiacRelevantPatientInformationQuery;
		}
		if (uid.equals(SOPClass.ChestCADSR.getUID())) {
			result = SOPClass.ChestCADSR;
		}
		if (uid.equals(SOPClass.ComprehensiveSR.getUID())) {
			result = SOPClass.ComprehensiveSR;
		}
		if (uid.equals(SOPClass.ComputedRadiographyImageStorage.getUID())) {
			result = SOPClass.ComputedRadiographyImageStorage;
		}
		if (uid.equals(SOPClass.DetachedInterpretationManagement.getUID())) {
			result = SOPClass.DetachedInterpretationManagement;
		}
		if (uid.equals(SOPClass.DetachedPatientManagement.getUID())) {
			result = SOPClass.DetachedPatientManagement;
		}
		if (uid.equals(SOPClass.DetachedResultsManagement.getUID())) {
			result = SOPClass.DetachedResultsManagement;
		}
		if (uid.equals(SOPClass.DetachedStudyManagement.getUID())) {
			result = SOPClass.DetachedStudyManagement;
		}
		if (uid.equals(SOPClass.DetachedVisitManagement.getUID())) {
			result = SOPClass.DetachedVisitManagement;
		}
		if (uid.equals(SOPClass.DigitalIntraoralXRayImageStorageForPresentation
				.getUID())) {
			result = SOPClass.DigitalIntraoralXRayImageStorageForPresentation;
		}
		if (uid.equals(SOPClass.DigitalIntraoralXRayImageStorageForProcessing
				.getUID())) {
			result = SOPClass.DigitalIntraoralXRayImageStorageForProcessing;
		}
		if (uid.equals(SOPClass.DigitalMammographyXRayImageStorageForPresentation
				.getUID())) {
			result = SOPClass.DigitalMammographyXRayImageStorageForPresentation;
		}
		if (uid.equals(SOPClass.DigitalMammographyXRayImageStorageForProcessing
				.getUID())) {
			result = SOPClass.DigitalMammographyXRayImageStorageForProcessing;
		}
		if (uid.equals(SOPClass.DigitalXRayImageStorageForPresentation.getUID())) {
			result = SOPClass.DigitalXRayImageStorageForPresentation;
		}
		if (uid.equals(SOPClass.DigitalXRayImageStorageForProcessing.getUID())) {
			result = SOPClass.DigitalXRayImageStorageForProcessing;
		}
		if (uid.equals(SOPClass.EncapsulatedPDFStorage.getUID())) {
			result = SOPClass.EncapsulatedPDFStorage;
		}
		if (uid.equals(SOPClass.EnhancedCTImageStorage.getUID())) {
			result = SOPClass.EnhancedCTImageStorage;
		}
		if (uid.equals(SOPClass.EnhancedMRImageStorage.getUID())) {
			result = SOPClass.EnhancedMRImageStorage;
		}
		if (uid.equals(SOPClass.EnhancedSR.getUID())) {
			result = SOPClass.EnhancedSR;
		}
		if (uid.equals(SOPClass.GeneralECGWaveformStorage.getUID())) {
			result = SOPClass.GeneralECGWaveformStorage;
		}
		if (uid.equals(SOPClass.GeneralPurposePerformedProcedureStepSOPClass
				.getUID())) {
			result = SOPClass.GeneralPurposePerformedProcedureStepSOPClass;
		}
		if (uid.equals(SOPClass.GeneralPurposeScheduledProcedureStepSOPClass
				.getUID())) {
			result = SOPClass.GeneralPurposeScheduledProcedureStepSOPClass;
		}
		if (uid
				.equals(SOPClass.GeneralPurposeWorklistInformationModelFIND.getUID())) {
			result = SOPClass.GeneralPurposeWorklistInformationModelFIND;
		}
		if (uid.equals(SOPClass.GrayscaleSoftcopyPresentationStateStorage.getUID())) {
			result = SOPClass.GrayscaleSoftcopyPresentationStateStorage;
		}
		if (uid.equals(SOPClass.HangingProtocolInformationModelFIND.getUID())) {
			result = SOPClass.HangingProtocolInformationModelFIND;
		}
		if (uid.equals(SOPClass.HangingProtocolInformationModelMOVE.getUID())) {
			result = SOPClass.HangingProtocolInformationModelMOVE;
		}
		if (uid.equals(SOPClass.HangingProtocolStorage.getUID())) {
			result = SOPClass.HangingProtocolStorage;
		}
		if (uid.equals(SOPClass.HardcopyColorImageStorage.getUID())) {
			result = SOPClass.HardcopyColorImageStorage;
		}
		if (uid.equals(SOPClass.HardcopyGrayscaleImageStorage.getUID())) {
			result = SOPClass.HardcopyGrayscaleImageStorage;
		}
		if (uid.equals(SOPClass.HemodynamicWaveformStorage.getUID())) {
			result = SOPClass.HemodynamicWaveformStorage;
		}
		if (uid.equals(SOPClass.ImageOverlayBox.getUID())) {
			result = SOPClass.ImageOverlayBox;
		}
		if (uid.equals(SOPClass.InstanceAvailabilityNotificationSOPClass.getUID())) {
			result = SOPClass.InstanceAvailabilityNotificationSOPClass;
		}
		if (uid.equals(SOPClass.KeyObjectSelectionDocument.getUID())) {
			result = SOPClass.KeyObjectSelectionDocument;
		}
		if (uid.equals(SOPClass.MRImageStorage.getUID())) {
			result = SOPClass.MRImageStorage;
		}
		if (uid.equals(SOPClass.MRSpectroscopyStorage.getUID())) {
			result = SOPClass.MRSpectroscopyStorage;
		}
		if (uid.equals(SOPClass.MammographyCADSR.getUID())) {
			result = SOPClass.MammographyCADSR;
		}
		if (uid.equals(SOPClass.MediaCreationManagementSOPClass.getUID())) {
			result = SOPClass.MediaCreationManagementSOPClass;
		}
		if (uid.equals(SOPClass.MediaStorageDirectoryStorage.getUID())) {
			result = SOPClass.MediaStorageDirectoryStorage;
		}
		if (uid.equals(SOPClass.ModalityPerformedProcedureStep.getUID())) {
			result = SOPClass.ModalityPerformedProcedureStep;
		}
		if (uid
				.equals(SOPClass.ModalityPerformedProcedureStepNotification.getUID())) {
			result = SOPClass.ModalityPerformedProcedureStepNotification;
		}
		if (uid.equals(SOPClass.ModalityPerformedProcedureStepRetrieve.getUID())) {
			result = SOPClass.ModalityPerformedProcedureStepRetrieve;
		}
		if (uid.equals(SOPClass.ModalityWorklistInformationModelFIND.getUID())) {
			result = SOPClass.ModalityWorklistInformationModelFIND;
		}
		if (uid.equals(SOPClass.MultiframeColorSecondaryCaptureImageStorage
				.getUID())) {
			result = SOPClass.MultiframeColorSecondaryCaptureImageStorage;
		}
		if (uid.equals(SOPClass.MultiframeGrayscaleByteSecondaryCaptureImageStorage
				.getUID())) {
			result = SOPClass.MultiframeGrayscaleByteSecondaryCaptureImageStorage;
		}
		if (uid.equals(SOPClass.MultiframeGrayscaleWordSecondaryCaptureImageStorage
				.getUID())) {
			result = SOPClass.MultiframeGrayscaleWordSecondaryCaptureImageStorage;
		}
		if (uid.equals(SOPClass.MultiframeSingleBitSecondaryCaptureImageStorage
				.getUID())) {
			result = SOPClass.MultiframeSingleBitSecondaryCaptureImageStorage;
		}
		if (uid.equals(SOPClass.NuclearMedicineImageStorage.getUID())) {
			result = SOPClass.NuclearMedicineImageStorage;
		}
		if (uid.equals(SOPClass.NuclearMedicineImageStorageRetired.getUID())) {
			result = SOPClass.NuclearMedicineImageStorageRetired;
		}
		if (uid.equals(SOPClass.OphthalmicPhotography16BitImageStorage.getUID())) {
			result = SOPClass.OphthalmicPhotography16BitImageStorage;
		}
		if (uid.equals(SOPClass.OphthalmicPhotography8BitImageStorage.getUID())) {
			result = SOPClass.OphthalmicPhotography8BitImageStorage;
		}
		if (uid.equals(SOPClass.PatientInformationQuery.getUID())) {
			result = SOPClass.PatientInformationQuery;
		}
		if (uid.equals(SOPClass.PatientRootQueryRetrieveInformationModelFIND
				.getUID())) {
			result = SOPClass.PatientRootQueryRetrieveInformationModelFIND;
		}
		if (uid.equals(SOPClass.PatientRootQueryRetrieveInformationModelGET
				.getUID())) {
			result = SOPClass.PatientRootQueryRetrieveInformationModelGET;
		}
		if (uid.equals(SOPClass.PatientRootQueryRetrieveInformationModelMOVE
				.getUID())) {
			result = SOPClass.PatientRootQueryRetrieveInformationModelMOVE;
		}
		if (uid.equals(SOPClass.PatientStudyOnlyQueryRetrieveInformationModelFIND
				.getUID())) {
			result = SOPClass.PatientStudyOnlyQueryRetrieveInformationModelFIND;
		}
		if (uid.equals(SOPClass.PatientStudyOnlyQueryRetrieveInformationModelGET
				.getUID())) {
			result = SOPClass.PatientStudyOnlyQueryRetrieveInformationModelGET;
		}
		if (uid.equals(SOPClass.PatientStudyOnlyQueryRetrieveInformationModelMOVE
				.getUID())) {
			result = SOPClass.PatientStudyOnlyQueryRetrieveInformationModelMOVE;
		}
		if (uid.equals(SOPClass.PositronEmissionTomographyImageStorage.getUID())) {
			result = SOPClass.PositronEmissionTomographyImageStorage;
		}
		if (uid.equals(SOPClass.PresentationLUT.getUID())) {
			result = SOPClass.PresentationLUT;
		}
		if (uid.equals(SOPClass.PrintJob.getUID())) {
			result = SOPClass.PrintJob;
		}
		if (uid.equals(SOPClass.PrintQueueManagement.getUID())) {
			result = SOPClass.PrintQueueManagement;
		}
		if (uid.equals(SOPClass.Printer.getUID())) {
			result = SOPClass.Printer;
		}
		if (uid.equals(SOPClass.PrinterConfigurationRetrieval.getUID())) {
			result = SOPClass.PrinterConfigurationRetrieval;
		}
		if (uid.equals(SOPClass.ProceduralEventLoggingSOPClass.getUID())) {
			result = SOPClass.ProceduralEventLoggingSOPClass;
		}
		if (uid.equals(SOPClass.ProcedureLogStorage.getUID())) {
			result = SOPClass.ProcedureLogStorage;
		}
		if (uid.equals(SOPClass.PullPrintRequest.getUID())) {
			result = SOPClass.PullPrintRequest;
		}
		if (uid.equals(SOPClass.RTBeamsTreatmentRecordStorage.getUID())) {
			result = SOPClass.RTBeamsTreatmentRecordStorage;
		}
		if (uid.equals(SOPClass.RTBrachyTreatmentRecordStorage.getUID())) {
			result = SOPClass.RTBrachyTreatmentRecordStorage;
		}
		if (uid.equals(SOPClass.RTDoseStorage.getUID())) {
			result = SOPClass.RTDoseStorage;
		}
		if (uid.equals(SOPClass.RTImageStorage.getUID())) {
			result = SOPClass.RTImageStorage;
		}
		if (uid.equals(SOPClass.RTIonBeamsTreatmentRecordStorage.getUID())) {
			result = SOPClass.RTIonBeamsTreatmentRecordStorage;
		}
		if (uid.equals(SOPClass.RTIonPlanStorage.getUID())) {
			result = SOPClass.RTIonPlanStorage;
		}
		if (uid.equals(SOPClass.RTPlanStorage.getUID())) {
			result = SOPClass.RTPlanStorage;
		}
		if (uid.equals(SOPClass.RTStructureSetStorage.getUID())) {
			result = SOPClass.RTStructureSetStorage;
		}
		if (uid.equals(SOPClass.RTTreatmentSummaryRecordStorage.getUID())) {
			result = SOPClass.RTTreatmentSummaryRecordStorage;
		}
		if (uid.equals(SOPClass.RawDataStorage.getUID())) {
			result = SOPClass.RawDataStorage;
		}
		if (uid.equals(SOPClass.ReferencedImageBoxRetired.getUID())) {
			result = SOPClass.ReferencedImageBoxRetired;
		}
		if (uid.equals(SOPClass.SecondaryCaptureImageStorage.getUID())) {
			result = SOPClass.SecondaryCaptureImageStorage;
		}
		if (uid.equals(SOPClass.SpatialFiducialsStorage.getUID())) {
			result = SOPClass.SpatialFiducialsStorage;
		}
		if (uid.equals(SOPClass.SpatialRegistrationStorage.getUID())) {
			result = SOPClass.SpatialRegistrationStorage;
		}
		if (uid.equals(SOPClass.StandaloneCurveStorage.getUID())) {
			result = SOPClass.StandaloneCurveStorage;
		}
		if (uid.equals(SOPClass.StandaloneModalityLUTStorage.getUID())) {
			result = SOPClass.StandaloneModalityLUTStorage;
		}
		if (uid.equals(SOPClass.StandaloneOverlayStorage.getUID())) {
			result = SOPClass.StandaloneOverlayStorage;
		}
		if (uid.equals(SOPClass.StandalonePETCurveStorage.getUID())) {
			result = SOPClass.StandalonePETCurveStorage;
		}
		if (uid.equals(SOPClass.StandaloneVOILUTStorage.getUID())) {
			result = SOPClass.StandaloneVOILUTStorage;
		}
		if (uid.equals(SOPClass.StereometricRelationshipStorage.getUID())) {
			result = SOPClass.StereometricRelationshipStorage;
		}
		if (uid.equals(SOPClass.StorageCommitmentPullModel.getUID())) {
			result = SOPClass.StorageCommitmentPullModel;
		}
		if (uid.equals(SOPClass.StorageCommitmentPushModel.getUID())) {
			result = SOPClass.StorageCommitmentPushModel;
		}
		if (uid.equals(SOPClass.StorageServiceClass.getUID())) {
			result = SOPClass.StorageServiceClass;
		}
		if (uid.equals(SOPClass.StoredPrintStorage.getUID())) {
			result = SOPClass.StoredPrintStorage;
		}
		if (uid.equals(SOPClass.StudyComponentManagement.getUID())) {
			result = SOPClass.StudyComponentManagement;
		}
		if (uid
				.equals(SOPClass.StudyRootQueryRetrieveInformationModelFIND.getUID())) {
			result = SOPClass.StudyRootQueryRetrieveInformationModelFIND;
		}
		if (uid.equals(SOPClass.StudyRootQueryRetrieveInformationModelGET.getUID())) {
			result = SOPClass.StudyRootQueryRetrieveInformationModelGET;
		}
		if (uid
				.equals(SOPClass.StudyRootQueryRetrieveInformationModelMOVE.getUID())) {
			result = SOPClass.StudyRootQueryRetrieveInformationModelMOVE;
		}
		if (uid.equals(SOPClass.TwelveLeadECGWaveformStorage.getUID())) {
			result = SOPClass.TwelveLeadECGWaveformStorage;
		}
		if (uid.equals(SOPClass.UltrasoundImageStorage.getUID())) {
			result = SOPClass.UltrasoundImageStorage;
		}
		if (uid.equals(SOPClass.UltrasoundImageStorageRetired.getUID())) {
			result = SOPClass.UltrasoundImageStorageRetired;
		}
		if (uid.equals(SOPClass.UltrasoundMultiframeImageStorage.getUID())) {
			result = SOPClass.UltrasoundMultiframeImageStorage;
		}
		if (uid.equals(SOPClass.UltrasoundMultiframeImageStorageRetired.getUID())) {
			result = SOPClass.UltrasoundMultiframeImageStorageRetired;
		}
		if (uid.equals(SOPClass.VLEndoscopicImageStorage.getUID())) {
			result = SOPClass.VLEndoscopicImageStorage;
		}
		if (uid.equals(SOPClass.VLImageStorageRetired.getUID())) {
			result = SOPClass.VLImageStorageRetired;
		}
		if (uid.equals(SOPClass.VLMicroscopicImageStorage.getUID())) {
			result = SOPClass.VLMicroscopicImageStorage;
		}
		if (uid.equals(SOPClass.VLMultiframeImageStorageRetired.getUID())) {
			result = SOPClass.VLMultiframeImageStorageRetired;
		}
		if (uid.equals(SOPClass.VLPhotographicImageStorage.getUID())) {
			result = SOPClass.VLPhotographicImageStorage;
		}
		if (uid.equals(SOPClass.VLSlideCoordinatesMicroscopicImageStorage.getUID())) {
			result = SOPClass.VLSlideCoordinatesMicroscopicImageStorage;
		}
		if (uid.equals(SOPClass.VOILUTBox.getUID())) {
			result = SOPClass.VOILUTBox;
		}
		if (uid.equals(SOPClass.Verification.getUID())) {
			result = SOPClass.Verification;
		}
		if (uid.equals(SOPClass.VideoEndoscopicImageStorage.getUID())) {
			result = SOPClass.VideoEndoscopicImageStorage;
		}
		if (uid.equals(SOPClass.VideoMicroscopicImageStorage.getUID())) {
			result = SOPClass.VideoMicroscopicImageStorage;
		}
		if (uid.equals(SOPClass.VideoPhotographicImageStorage.getUID())) {
			result = SOPClass.VideoPhotographicImageStorage;
		}
		if (uid
				.equals(SOPClass.XRayAngiographicBiPlaneImageStorageRetired.getUID())) {
			result = SOPClass.XRayAngiographicBiPlaneImageStorageRetired;
		}
		if (uid.equals(SOPClass.XRayAngiographicImageStorage.getUID())) {
			result = SOPClass.XRayAngiographicImageStorage;
		}
		if (uid.equals(SOPClass.XRayRadiofluoroscopicImageStorage.getUID())) {
			result = SOPClass.XRayRadiofluoroscopicImageStorage;
		}
		if (result == null) {
			logger.warn("Unable to get a SOPClass for " + uid + " UID");
			throw new NotFoundRegistryException("SOPClass", uid);
		} else {
			logger.debug("SOPClass " + result.getName() + " returned");
			return result;
		}
	}

	/**
	 * return the SopClass's name from a SOPClass UI or the UID if the SopClass's
	 * can't be found
	 * 
	 * @param uid
	 *          the uid
	 * @return the name or uid
	 */
	public String getSopClassAsString(String uid) {
		try {
			SOPClass sopClass = this.getByUID(uid);
			return sopClass.getName();
		} catch (Exception ex) {
			return uid;
		}
	}

	@Override
	public UniqueIdentifierType getType() {
		return UniqueIdentifierType.SOPCLASS;
	}

	@Override
	public String toString() {
		return "dicom4j SOPClassRegistry";
	}
}