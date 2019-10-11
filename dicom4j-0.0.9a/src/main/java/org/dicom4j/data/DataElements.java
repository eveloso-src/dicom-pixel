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
package org.dicom4j.data;

import org.dicom4j.data.elements.AgeString;
import org.dicom4j.data.elements.ApplicationEntity;
import org.dicom4j.data.elements.AttributeTag;
import org.dicom4j.data.elements.CodeString;
import org.dicom4j.data.elements.DateElement;
import org.dicom4j.data.elements.DateTime;
import org.dicom4j.data.elements.DecimalString;
import org.dicom4j.data.elements.FloatingPointDouble;
import org.dicom4j.data.elements.FloatingPointSingle;
import org.dicom4j.data.elements.IntegerString;
import org.dicom4j.data.elements.LongString;
import org.dicom4j.data.elements.LongText;
import org.dicom4j.data.elements.OtherByteString;
import org.dicom4j.data.elements.OtherFloatString;
import org.dicom4j.data.elements.OtherWordString;
import org.dicom4j.data.elements.PersonName;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.data.elements.ShortString;
import org.dicom4j.data.elements.ShortText;
import org.dicom4j.data.elements.SignedLong;
import org.dicom4j.data.elements.SignedShort;
import org.dicom4j.data.elements.Time;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.Unknown;
import org.dicom4j.data.elements.UnlimitedText;
import org.dicom4j.data.elements.UnsignedLong;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomTags;

/**
 * List of all DataElements
 * 
 * <p>
 * (generated class, do not edit)
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DataElements {

	public static CodeString new_3DRenderingType() {
		return new CodeString(DicomTags._3DRenderingType);
	}

	public static SequenceOfItems newAbstractPriorCodeSeq() {
		return new SequenceOfItems(DicomTags.AbstractPriorCodeSeq);
	}

	public static SignedShort newAbstractValue() {
		return new SignedShort(DicomTags.AbstractValue);
	}

	public static ShortString newAccessionNumber() {
		return new ShortString(DicomTags.AccessionNumber);
	}

	public static ShortText newAcquisitionContextDescription() {
		return new ShortText(DicomTags.AcquisitionContextDescription);
	}

	public static SequenceOfItems newAcquisitionContextSeq() {
		return new SequenceOfItems(DicomTags.AcquisitionContextSeq);
	}

	public static CodeString newAcquisitionContrast() {
		return new CodeString(DicomTags.AcquisitionContrast);
	}

	public static DateElement newAcquisitionDate() {
		return new DateElement(DicomTags.AcquisitionDate);
	}

	public static DateTime newAcquisitionDatetime() {
		return new DateTime(DicomTags.AcquisitionDatetime);
	}

	public static LongString newAcquisitionDeviceProcessingCode() {
		return new LongString(DicomTags.AcquisitionDeviceProcessingCode);
	}

	public static LongString newAcquisitionDeviceProcessingDescription() {
		return new LongString(DicomTags.AcquisitionDeviceProcessingDescription);
	}

	public static SequenceOfItems newAcquisitionDeviceTypeCodeSeq() {
		return new SequenceOfItems(DicomTags.AcquisitionDeviceTypeCodeSeq);
	}

	public static FloatingPointDouble newAcquisitionDuration() {
		return new FloatingPointDouble(DicomTags.AcquisitionDuration);
	}

	public static UnsignedShort newAcquisitionMatrix() {
		return new UnsignedShort(DicomTags.AcquisitionMatrix);
	}

	public static IntegerString newAcquisitionNumber() {
		return new IntegerString(DicomTags.AcquisitionNumber);
	}

	public static IntegerString newAcquisitionsInSeriesRetired() {
		return new IntegerString(DicomTags.AcquisitionsInSeriesRetired);
	}

	public static IntegerString newAcquisitionsInStudy() {
		return new IntegerString(DicomTags.AcquisitionsInStudy);
	}

	public static CodeString newAcquisitionStartCondition() {
		return new CodeString(DicomTags.AcquisitionStartCondition);
	}

	public static IntegerString newAcquisitionStartConditionData() {
		return new IntegerString(DicomTags.AcquisitionStartConditionData);
	}

	public static CodeString newAcquisitionTerminationCondition() {
		return new CodeString(DicomTags.AcquisitionTerminationCondition);
	}

	public static IntegerString newAcquisitionTerminationConditionData() {
		return new IntegerString(DicomTags.AcquisitionTerminationConditionData);
	}

	public static Time newAcquisitionTime() {
		return new Time(DicomTags.AcquisitionTime);
	}

	public static CodeString newAcquisitionTimeSynchronized() {
		return new CodeString(DicomTags.AcquisitionTimeSynchronized);
	}

	public static CodeString newAcquisitionType() {
		return new CodeString(DicomTags.AcquisitionType);
	}

	public static UnsignedShort newActionTypeID() {
		return new UnsignedShort(DicomTags.ActionTypeID);
	}

	public static DecimalString newActiveSourceDiameter() {
		return new DecimalString(DicomTags.ActiveSourceDiameter);
	}

	public static DecimalString newActiveSourceLength() {
		return new DecimalString(DicomTags.ActiveSourceLength);
	}

	public static IntegerString newActualFrameDuration() {
		return new IntegerString(DicomTags.ActualFrameDuration);
	}

	public static SequenceOfItems newActualHumanPerformersSeq() {
		return new SequenceOfItems(DicomTags.ActualHumanPerformersSeq);
	}

	public static Unknown newAddGrayScaleRetired() {
		return new Unknown(DicomTags.AddGrayScaleRetired);
	}

	public static SequenceOfItems newAdditionalDrugSeq() {
		return new SequenceOfItems(DicomTags.AdditionalDrugSeq);
	}

	public static LongText newAdditionalPatientHistory() {
		return new LongText(DicomTags.AdditionalPatientHistory);
	}

	public static SequenceOfItems newAdministrationRouteCodeSeq() {
		return new SequenceOfItems(DicomTags.AdministrationRouteCodeSeq);
	}

	public static LongString newAdmissionID() {
		return new LongString(DicomTags.AdmissionID);
	}

	public static DateElement newAdmittingDate() {
		return new DateElement(DicomTags.AdmittingDate);
	}

	public static SequenceOfItems newAdmittingDiagnosisCodeSeq() {
		return new SequenceOfItems(DicomTags.AdmittingDiagnosisCodeSeq);
	}

	public static LongString newAdmittingDiagnosisDescription() {
		return new LongString(DicomTags.AdmittingDiagnosisDescription);
	}

	public static Time newAdmittingTime() {
		return new Time(DicomTags.AdmittingTime);
	}

	public static UniqueIdentifier newAffectedSOPClassUID() {
		return new UniqueIdentifier(DicomTags.AffectedSOPClassUID);
	}

	public static UniqueIdentifier newAffectedSOPInstanceUID() {
		return new UniqueIdentifier(DicomTags.AffectedSOPInstanceUID);
	}

	public static DateElement newAirKermaRateReferenceDate() {
		return new DateElement(DicomTags.AirKermaRateReferenceDate);
	}

	public static Time newAirKermaRateReferenceTime() {
		return new Time(DicomTags.AirKermaRateReferenceTime);
	}

	public static CodeString newAllowLossyCompression() {
		return new CodeString(DicomTags.AllowLossyCompression);
	}

	public static CodeString newAllowMediaSplitting() {
		return new CodeString(DicomTags.AllowMediaSplitting);
	}

	public static SequenceOfItems newAlternateRepresentationSeq() {
		return new SequenceOfItems(DicomTags.AlternateRepresentationSeq);
	}

	public static SequenceOfItems newAnatomicRegionModifierSeq() {
		return new SequenceOfItems(DicomTags.AnatomicRegionModifierSeq);
	}

	public static SequenceOfItems newAnatomicRegionSeq() {
		return new SequenceOfItems(DicomTags.AnatomicRegionSeq);
	}

	public static CodeString newAnatomicStructureRetired() {
		return new CodeString(DicomTags.AnatomicStructureRetired);
	}

	public static SequenceOfItems newAnatomicStructureSpaceRegionSeq() {
		return new SequenceOfItems(DicomTags.AnatomicStructureSpaceRegionSeq);
	}

	public static FloatingPointSingle newAnchorPoint() {
		return new FloatingPointSingle(DicomTags.AnchorPoint);
	}

	public static CodeString newAnchorPointAnnotationUnits() {
		return new CodeString(DicomTags.AnchorPointAnnotationUnits);
	}

	public static CodeString newAnchorPointVisibility() {
		return new CodeString(DicomTags.AnchorPointVisibility);
	}

	public static CodeString newAngioFlag() {
		return new CodeString(DicomTags.AngioFlag);
	}

	public static IntegerString newAngleNumberRetired() {
		return new IntegerString(DicomTags.AngleNumberRetired);
	}

	public static DecimalString newAngularPosition() {
		return new DecimalString(DicomTags.AngularPosition);
	}

	public static DecimalString newAngularStep() {
		return new DecimalString(DicomTags.AngularStep);
	}

	public static UnsignedShort newAngularViewVector() {
		return new UnsignedShort(DicomTags.AngularViewVector);
	}

	public static SequenceOfItems newAnnotationContentSeq() {
		return new SequenceOfItems(DicomTags.AnnotationContentSeq);
	}

	public static CodeString newAnnotationDisplayFormatID() {
		return new CodeString(DicomTags.AnnotationDisplayFormatID);
	}

	public static CodeString newAnnotationFlag() {
		return new CodeString(DicomTags.AnnotationFlag);
	}

	public static UnsignedShort newAnnotationGroupNumber() {
		return new UnsignedShort(DicomTags.AnnotationGroupNumber);
	}

	public static UnsignedShort newAnnotationPosition() {
		return new UnsignedShort(DicomTags.AnnotationPosition);
	}

	public static SequenceOfItems newAnnotationSeq() {
		return new SequenceOfItems(DicomTags.AnnotationSeq);
	}

	public static CodeString newAnodeTargetMaterial() {
		return new CodeString(DicomTags.AnodeTargetMaterial);
	}

	public static UnsignedShort newApplicableFrameRange() {
		return new UnsignedShort(DicomTags.ApplicableFrameRange);
	}

	public static CodeString newApplicableSafetyStandardAgency() {
		return new CodeString(DicomTags.ApplicableSafetyStandardAgency);
	}

	public static LongString newApplicableSafetyStandardDescription() {
		return new LongString(DicomTags.ApplicableSafetyStandardDescription);
	}

	public static UnsignedShort newApplicationMaximumRepaintTime() {
		return new UnsignedShort(DicomTags.ApplicationMaximumRepaintTime);
	}

	public static CodeString newApplicationSetupCheck() {
		return new CodeString(DicomTags.ApplicationSetupCheck);
	}

	public static LongString newApplicationSetupManufacturer() {
		return new LongString(DicomTags.ApplicationSetupManufacturer);
	}

	public static LongString newApplicationSetupName() {
		return new LongString(DicomTags.ApplicationSetupName);
	}

	public static IntegerString newApplicationSetupNumber() {
		return new IntegerString(DicomTags.ApplicationSetupNumber);
	}

	public static SequenceOfItems newApplicationSetupSeq() {
		return new SequenceOfItems(DicomTags.ApplicationSetupSeq);
	}

	public static CodeString newApplicationSetupType() {
		return new CodeString(DicomTags.ApplicationSetupType);
	}

	public static LongString newApplicatorDescription() {
		return new LongString(DicomTags.ApplicatorDescription);
	}

	public static ShortString newApplicatorID() {
		return new ShortString(DicomTags.ApplicatorID);
	}

	public static SequenceOfItems newApplicatorSeq() {
		return new SequenceOfItems(DicomTags.ApplicatorSeq);
	}

	public static CodeString newApplicatorType() {
		return new CodeString(DicomTags.ApplicatorType);
	}

	public static CodeString newApprovalStatus() {
		return new CodeString(DicomTags.ApprovalStatus);
	}

	public static LongText newArbitraryCommentsRetired() {
		return new LongText(DicomTags.ArbitraryCommentsRetired);
	}

	public static LongText newArbitraryRetired() {
		return new LongText(DicomTags.ArbitraryRetired);
	}

	public static IntegerString newAttachedContours() {
		return new IntegerString(DicomTags.AttachedContours);
	}

	public static LongString newAttenuationCorrectionMethod() {
		return new LongString(DicomTags.AttenuationCorrectionMethod);
	}

	public static AttributeTag newAttributeIdentifierList() {
		return new AttributeTag(DicomTags.AttributeIdentifierList);
	}

	public static LongString newAuthorizationEquipmentCertificationNumber() {
		return new LongString(DicomTags.AuthorizationEquipmentCertificationNumber);
	}

	public static DecimalString newAveragePulseWidth() {
		return new DecimalString(DicomTags.AveragePulseWidth);
	}

	public static DecimalString newAxialAcceptance() {
		return new DecimalString(DicomTags.AxialAcceptance);
	}

	public static IntegerString newAxialMash() {
		return new IntegerString(DicomTags.AxialMash);
	}

	public static CodeString newBarcodeSymbology() {
		return new CodeString(DicomTags.BarcodeSymbology);
	}

	public static LongText newBarcodeValue() {
		return new LongText(DicomTags.BarcodeValue);
	}

	public static CodeString newBaselineCorrection() {
		return new CodeString(DicomTags.BaselineCorrection);
	}

	public static SequenceOfItems newBasicColorImageSeq() {
		return new SequenceOfItems(DicomTags.BasicColorImageSeq);
	}

	public static SequenceOfItems newBasicGrayscaleImageSeq() {
		return new SequenceOfItems(DicomTags.BasicGrayscaleImageSeq);
	}

	public static ShortText newBeamDescription() {
		return new ShortText(DicomTags.BeamDescription);
	}

	public static DecimalString newBeamDose() {
		return new DecimalString(DicomTags.BeamDose);
	}

	public static DecimalString newBeamDoseSpecificationPoint() {
		return new DecimalString(DicomTags.BeamDoseSpecificationPoint);
	}

	public static DecimalString newBeamLimitingDeviceAngle() {
		return new DecimalString(DicomTags.BeamLimitingDeviceAngle);
	}

	public static DecimalString newBeamLimitingDeviceAngleTolerance() {
		return new DecimalString(DicomTags.BeamLimitingDeviceAngleTolerance);
	}

	public static SequenceOfItems newBeamLimitingDeviceLeafPairsSeq() {
		return new SequenceOfItems(DicomTags.BeamLimitingDeviceLeafPairsSeq);
	}

	public static SequenceOfItems newBeamLimitingDevicePositionSeq() {
		return new SequenceOfItems(DicomTags.BeamLimitingDevicePositionSeq);
	}

	public static DecimalString newBeamLimitingDevicePositionTolerance() {
		return new DecimalString(DicomTags.BeamLimitingDevicePositionTolerance);
	}

	public static CodeString newBeamLimitingDeviceRotationDirection() {
		return new CodeString(DicomTags.BeamLimitingDeviceRotationDirection);
	}

	public static SequenceOfItems newBeamLimitingDeviceSeq() {
		return new SequenceOfItems(DicomTags.BeamLimitingDeviceSeq);
	}

	public static SequenceOfItems newBeamLimitingDeviceToleranceSeq() {
		return new SequenceOfItems(DicomTags.BeamLimitingDeviceToleranceSeq);
	}

	public static DecimalString newBeamMeterset() {
		return new DecimalString(DicomTags.BeamMeterset);
	}

	public static LongString newBeamName() {
		return new LongString(DicomTags.BeamName);
	}

	public static IntegerString newBeamNumber() {
		return new IntegerString(DicomTags.BeamNumber);
	}

	public static SequenceOfItems newBeamSeq() {
		return new SequenceOfItems(DicomTags.BeamSeq);
	}

	public static CodeString newBeamStopperPosition() {
		return new CodeString(DicomTags.BeamStopperPosition);
	}

	public static CodeString newBeamType() {
		return new CodeString(DicomTags.BeamType);
	}

	public static CodeString newBeatRejectionFlag() {
		return new CodeString(DicomTags.BeatRejectionFlag);
	}

	public static SequenceOfItems newBillingItemSeq() {
		return new SequenceOfItems(DicomTags.BillingItemSeq);
	}

	public static SequenceOfItems newBillingProcedureStepSeq() {
		return new SequenceOfItems(DicomTags.BillingProcedureStepSeq);
	}

	public static SequenceOfItems newBillingSuppliesAndDevicesSeq() {
		return new SequenceOfItems(DicomTags.BillingSuppliesAndDevicesSeq);
	}

	public static SequenceOfItems newBiPlaneAcquisitionSeq() {
		return new SequenceOfItems(DicomTags.BiPlaneAcquisitionSeq);
	}

	public static UnsignedShort newBitsAllocated() {
		return new UnsignedShort(DicomTags.BitsAllocated);
	}

	public static UnsignedShort newBitsStored() {
		return new UnsignedShort(DicomTags.BitsStored);
	}

	public static CodeString newBlendingOperationType() {
		return new CodeString(DicomTags.BlendingOperationType);
	}

	public static DecimalString newBlockData() {
		return new DecimalString(DicomTags.BlockData);
	}

	public static CodeString newBlockDivergence() {
		return new CodeString(DicomTags.BlockDivergence);
	}

	public static LongString newBlockName() {
		return new LongString(DicomTags.BlockName);
	}

	public static IntegerString newBlockNumber() {
		return new IntegerString(DicomTags.BlockNumber);
	}

	public static IntegerString newBlockNumberOfPoints() {
		return new IntegerString(DicomTags.BlockNumberOfPoints);
	}

	public static SequenceOfItems newBlockSeq() {
		return new SequenceOfItems(DicomTags.BlockSeq);
	}

	public static DecimalString newBlockThickness() {
		return new DecimalString(DicomTags.BlockThickness);
	}

	public static DecimalString newBlockTransmission() {
		return new DecimalString(DicomTags.BlockTransmission);
	}

	public static ShortString newBlockTrayID() {
		return new ShortString(DicomTags.BlockTrayID);
	}

	public static CodeString newBlockType() {
		return new CodeString(DicomTags.BlockType);
	}

	public static CodeString newBloodSignalNulling() {
		return new CodeString(DicomTags.BloodSignalNulling);
	}

	public static OtherWordString newBluePaletteColorLUTData() {
		return new OtherWordString(DicomTags.BluePaletteColorLUTData);
	}

	public static Unknown newBluePaletteColorLUTDescriptor() {
		return new Unknown(DicomTags.BluePaletteColorLUTDescriptor);
	}

	public static CodeString newBodyPartExamined() {
		return new CodeString(DicomTags.BodyPartExamined);
	}

	public static DecimalString newBodyPartThickness() {
		return new DecimalString(DicomTags.BodyPartThickness);
	}

	public static DecimalString newBoneThermalIndex() {
		return new DecimalString(DicomTags.BoneThermalIndex);
	}

	public static CodeString newBorderDensity() {
		return new CodeString(DicomTags.BorderDensity);
	}

	public static Unknown newBordersRetired() {
		return new Unknown(DicomTags.BordersRetired);
	}

	public static CodeString newBoundingBoxAnnotationUnits() {
		return new CodeString(DicomTags.BoundingBoxAnnotationUnits);
	}

	public static FloatingPointSingle newBoundingBoxBottomRightHandCorner() {
		return new FloatingPointSingle(DicomTags.BoundingBoxBottomRightHandCorner);
	}

	public static CodeString newBoundingBoxTextHorizontalJustification() {
		return new CodeString(DicomTags.BoundingBoxTextHorizontalJustification);
	}

	public static FloatingPointSingle newBoundingBoxTopLeftHandCorner() {
		return new FloatingPointSingle(DicomTags.BoundingBoxTopLeftHandCorner);
	}

	public static ShortString newBrachyAccessoryDeviceID() {
		return new ShortString(DicomTags.BrachyAccessoryDeviceID);
	}

	public static LongString newBrachyAccessoryDeviceName() {
		return new LongString(DicomTags.BrachyAccessoryDeviceName);
	}

	public static DecimalString newBrachyAccessoryDeviceNominalThickness() {
		return new DecimalString(DicomTags.BrachyAccessoryDeviceNominalThickness);
	}

	public static DecimalString newBrachyAccessoryDeviceNominalTransmission() {
		return new DecimalString(DicomTags.BrachyAccessoryDeviceNominalTransmission);
	}

	public static IntegerString newBrachyAccessoryDeviceNumber() {
		return new IntegerString(DicomTags.BrachyAccessoryDeviceNumber);
	}

	public static SequenceOfItems newBrachyAccessoryDeviceSeq() {
		return new SequenceOfItems(DicomTags.BrachyAccessoryDeviceSeq);
	}

	public static CodeString newBrachyAccessoryDeviceType() {
		return new CodeString(DicomTags.BrachyAccessoryDeviceType);
	}

	public static DecimalString newBrachyApplicationSetupDose() {
		return new DecimalString(DicomTags.BrachyApplicationSetupDose);
	}

	public static DecimalString newBrachyApplicationSetupDoseSpecificationPoint() {
		return new DecimalString(
				DicomTags.BrachyApplicationSetupDoseSpecificationPoint);
	}

	public static SequenceOfItems newBrachyControlPointDeliveredSeq() {
		return new SequenceOfItems(DicomTags.BrachyControlPointDeliveredSeq);
	}

	public static SequenceOfItems newBrachyControlPointSeq() {
		return new SequenceOfItems(DicomTags.BrachyControlPointSeq);
	}

	public static SequenceOfItems newBrachyRefDoseReferenceSeq() {
		return new SequenceOfItems(DicomTags.BrachyRefDoseReferenceSeq);
	}

	public static CodeString newBrachyTreatmentTechnique() {
		return new CodeString(DicomTags.BrachyTreatmentTechnique);
	}

	public static CodeString newBrachyTreatmentType() {
		return new CodeString(DicomTags.BrachyTreatmentType);
	}

	public static LongString newBranchOfService() {
		return new LongString(DicomTags.BranchOfService);
	}

	public static CodeString newBulkMotionCompensationTechnique() {
		return new CodeString(DicomTags.BulkMotionCompensationTechnique);
	}

	public static CodeString newBulkMotionSignalSource() {
		return new CodeString(DicomTags.BulkMotionSignalSource);
	}

	public static CodeString newBulkMotionStatus() {
		return new CodeString(DicomTags.BulkMotionStatus);
	}

	public static CodeString newBurnedInAnnotation() {
		return new CodeString(DicomTags.BurnedInAnnotation);
	}

	public static ShortText newCalculatedDoseReferenceDescription() {
		return new ShortText(DicomTags.CalculatedDoseReferenceDescription);
	}

	public static DecimalString newCalculatedDoseReferenceDoseValue() {
		return new DecimalString(DicomTags.CalculatedDoseReferenceDoseValue);
	}

	public static IntegerString newCalculatedDoseReferenceNumber() {
		return new IntegerString(DicomTags.CalculatedDoseReferenceNumber);
	}

	public static SequenceOfItems newCalculatedDoseReferenceSeq() {
		return new SequenceOfItems(DicomTags.CalculatedDoseReferenceSeq);
	}

	public static SequenceOfItems newCalibrationDataSeq() {
		return new SequenceOfItems(DicomTags.CalibrationDataSeq);
	}

	public static CodeString newCalibrationImage() {
		return new CodeString(DicomTags.CalibrationImage);
	}

	public static CodeString newCardiacBeatRejectionTechnique() {
		return new CodeString(DicomTags.CardiacBeatRejectionTechnique);
	}

	public static CodeString newCardiacCyclePosition() {
		return new CodeString(DicomTags.CardiacCyclePosition);
	}

	public static IntegerString newCardiacNumberOfImages() {
		return new IntegerString(DicomTags.CardiacNumberOfImages);
	}

	public static FloatingPointDouble newCardiacRRIntervalSpecified() {
		return new FloatingPointDouble(DicomTags.CardiacRRIntervalSpecified);
	}

	public static CodeString newCardiacSignalSource() {
		return new CodeString(DicomTags.CardiacSignalSource);
	}

	public static CodeString newCardiacSynchronizationTechnique() {
		return new CodeString(DicomTags.CardiacSynchronizationTechnique);
	}

	public static SequenceOfItems newCardiacTriggerSeq() {
		return new SequenceOfItems(DicomTags.CardiacTriggerSeq);
	}

	public static CodeString newCassetteOrientation() {
		return new CodeString(DicomTags.CassetteOrientation);
	}

	public static CodeString newCassetteSize() {
		return new CodeString(DicomTags.CassetteSize);
	}

	public static IntegerString newCenterOfCircularCollimator() {
		return new IntegerString(DicomTags.CenterOfCircularCollimator);
	}

	public static IntegerString newCenterOfCircularShutter() {
		return new IntegerString(DicomTags.CenterOfCircularShutter);
	}

	public static DecimalString newCenterOfRotationOffset() {
		return new DecimalString(DicomTags.CenterOfRotationOffset);
	}

	public static DecimalString newChannelBaseline() {
		return new DecimalString(DicomTags.ChannelBaseline);
	}

	public static SequenceOfItems newChannelDefinitionSeq() {
		return new SequenceOfItems(DicomTags.ChannelDefinitionSeq);
	}

	public static LongString newChannelDerivationDescription() {
		return new LongString(DicomTags.ChannelDerivationDescription);
	}

	public static SequenceOfItems newChannelDescriptionCodeSeq() {
		return new SequenceOfItems(DicomTags.ChannelDescriptionCodeSeq);
	}

	public static IntegerString newChannelIdentificationCode() {
		return new IntegerString(DicomTags.ChannelIdentificationCode);
	}

	public static ShortString newChannelLabel() {
		return new ShortString(DicomTags.ChannelLabel);
	}

	public static DecimalString newChannelLength() {
		return new DecimalString(DicomTags.ChannelLength);
	}

	public static Unknown newChannelMaximumValue() {
		return new Unknown(DicomTags.ChannelMaximumValue);
	}

	public static Unknown newChannelMinimumValue() {
		return new Unknown(DicomTags.ChannelMinimumValue);
	}

	public static CodeString newChannelMode() {
		return new CodeString(DicomTags.ChannelMode);
	}

	public static IntegerString newChannelNumber() {
		return new IntegerString(DicomTags.ChannelNumber);
	}

	public static DecimalString newChannelOffset() {
		return new DecimalString(DicomTags.ChannelOffset);
	}

	public static DecimalString newChannelSampleSkew() {
		return new DecimalString(DicomTags.ChannelSampleSkew);
	}

	public static DecimalString newChannelSensitivity() {
		return new DecimalString(DicomTags.ChannelSensitivity);
	}

	public static DecimalString newChannelSensitivityCorrectionFactor() {
		return new DecimalString(DicomTags.ChannelSensitivityCorrectionFactor);
	}

	public static SequenceOfItems newChannelSensitivityUnitsSeq() {
		return new SequenceOfItems(DicomTags.ChannelSensitivityUnitsSeq);
	}

	public static SequenceOfItems newChannelSeq() {
		return new SequenceOfItems(DicomTags.ChannelSeq);
	}

	public static ShortString newChannelShieldID() {
		return new ShortString(DicomTags.ChannelShieldID);
	}

	public static LongString newChannelShieldName() {
		return new LongString(DicomTags.ChannelShieldName);
	}

	public static DecimalString newChannelShieldNominalThickness() {
		return new DecimalString(DicomTags.ChannelShieldNominalThickness);
	}

	public static DecimalString newChannelShieldNominalTransmission() {
		return new DecimalString(DicomTags.ChannelShieldNominalTransmission);
	}

	public static IntegerString newChannelShieldNumber() {
		return new IntegerString(DicomTags.ChannelShieldNumber);
	}

	public static SequenceOfItems newChannelShieldSeq() {
		return new SequenceOfItems(DicomTags.ChannelShieldSeq);
	}

	public static SequenceOfItems newChannelSourceModifiersSeq() {
		return new SequenceOfItems(DicomTags.ChannelSourceModifiersSeq);
	}

	public static SequenceOfItems newChannelSourceSeq() {
		return new SequenceOfItems(DicomTags.ChannelSourceSeq);
	}

	public static CodeString newChannelStatus() {
		return new CodeString(DicomTags.ChannelStatus);
	}

	public static DecimalString newChannelTimeSkew() {
		return new DecimalString(DicomTags.ChannelTimeSkew);
	}

	public static DecimalString newChannelTotalTime() {
		return new DecimalString(DicomTags.ChannelTotalTime);
	}

	public static FloatingPointDouble newChemicalShiftReference() {
		return new FloatingPointDouble(DicomTags.ChemicalShiftReference);
	}

	public static SequenceOfItems newChemicalShiftSeq() {
		return new SequenceOfItems(DicomTags.ChemicalShiftSeq);
	}

	public static FloatingPointDouble newChemicalShiftsMaximumIntegrationLimit() {
		return new FloatingPointDouble(
				DicomTags.ChemicalShiftsMaximumIntegrationLimit);
	}

	public static FloatingPointDouble newChemicalShiftsMinimumIntegrationLimit() {
		return new FloatingPointDouble(
				DicomTags.ChemicalShiftsMinimumIntegrationLimit);
	}

	public static IntegerString newCineRate() {
		return new IntegerString(DicomTags.CineRate);
	}

	public static FloatingPointDouble newCineRelativeToRealTime() {
		return new FloatingPointDouble(DicomTags.CineRelativeToRealTime);
	}

	public static LongString newClinicalTrialProtocolID() {
		return new LongString(DicomTags.ClinicalTrialProtocolID);
	}

	public static LongString newClinicalTrialProtocolName() {
		return new LongString(DicomTags.ClinicalTrialProtocolName);
	}

	public static LongString newClinicalTrialSiteID() {
		return new LongString(DicomTags.ClinicalTrialSiteID);
	}

	public static LongString newClinicalTrialSiteName() {
		return new LongString(DicomTags.ClinicalTrialSiteName);
	}

	public static LongString newClinicalTrialSponsorName() {
		return new LongString(DicomTags.ClinicalTrialSponsorName);
	}

	public static LongString newClinicalTrialSubjectID() {
		return new LongString(DicomTags.ClinicalTrialSubjectID);
	}

	public static LongString newClinicalTrialSubjectReadingID() {
		return new LongString(DicomTags.ClinicalTrialSubjectReadingID);
	}

	public static ShortText newClinicalTrialTimePointDescription() {
		return new ShortText(DicomTags.ClinicalTrialTimePointDescription);
	}

	public static LongString newClinicalTrialTimePointID() {
		return new LongString(DicomTags.ClinicalTrialTimePointID);
	}

	public static LongString newCodeMeaning() {
		return new LongString(DicomTags.CodeMeaning);
	}

	public static ShortString newCodeValue() {
		return new ShortString(DicomTags.CodeValue);
	}

	public static ShortString newCodingSchemeDesignator() {
		return new ShortString(DicomTags.CodingSchemeDesignator);
	}

	public static ShortText newCodingSchemeExternal() {
		return new ShortText(DicomTags.CodingSchemeExternal);
	}

	public static SequenceOfItems newCodingSchemeIdentificationSeq() {
		return new SequenceOfItems(DicomTags.CodingSchemeIdentificationSeq);
	}

	public static ShortText newCodingSchemeName() {
		return new ShortText(DicomTags.CodingSchemeName);
	}

	public static LongString newCodingSchemeRegistry() {
		return new LongString(DicomTags.CodingSchemeRegistry);
	}

	public static UniqueIdentifier newCodingSchemeUID() {
		return new UniqueIdentifier(DicomTags.CodingSchemeUID);
	}

	public static ShortString newCodingSchemeVersion() {
		return new ShortString(DicomTags.CodingSchemeVersion);
	}

	public static DecimalString newCoincidenceWindowWidth() {
		return new DecimalString(DicomTags.CoincidenceWindowWidth);
	}

	public static CodeString newCollationFlag() {
		return new CodeString(DicomTags.CollationFlag);
	}

	public static ShortString newCollimatorGridName() {
		return new ShortString(DicomTags.CollimatorGridName);
	}

	public static IntegerString newCollimatorLeftVerticalEdge() {
		return new IntegerString(DicomTags.CollimatorLeftVerticalEdge);
	}

	public static IntegerString newCollimatorLowerHorizontalEdge() {
		return new IntegerString(DicomTags.CollimatorLowerHorizontalEdge);
	}

	public static IntegerString newCollimatorRightVerticalEdge() {
		return new IntegerString(DicomTags.CollimatorRightVerticalEdge);
	}

	public static CodeString newCollimatorShape() {
		return new CodeString(DicomTags.CollimatorShape);
	}

	public static CodeString newCollimatorType() {
		return new CodeString(DicomTags.CollimatorType);
	}

	public static IntegerString newCollimatorUpperHorizontalEdge() {
		return new IntegerString(DicomTags.CollimatorUpperHorizontalEdge);
	}

	public static CodeString newColorImagePrintingFlag() {
		return new CodeString(DicomTags.ColorImagePrintingFlag);
	}

	public static CodeString newColumnAngulation() {
		return new CodeString(DicomTags.ColumnAngulation);
	}

	public static UnsignedShort newColumns() {
		return new UnsignedShort(DicomTags.Columns);
	}

	public static UnsignedShort newCommandField() {
		return new UnsignedShort(DicomTags.CommandField);
	}

	public static UnsignedLong newCommandGroupLength() {
		return new UnsignedLong(DicomTags.CommandGroupLength);
	}

	public static Unknown newCommandLengthToEndRetired() {
		return new Unknown(DicomTags.CommandLengthToEndRetired);
	}

	public static Unknown newCommandRecognitionCodeRetired() {
		return new Unknown(DicomTags.CommandRecognitionCodeRetired);
	}

	public static ShortText newCommentsOnRadiationDose() {
		return new ShortText(DicomTags.CommentsOnRadiationDose);
	}

	public static IntegerString newCompensatorColumns() {
		return new IntegerString(DicomTags.CompensatorColumns);
	}

	public static ShortString newCompensatorID() {
		return new ShortString(DicomTags.CompensatorID);
	}

	public static IntegerString newCompensatorNumber() {
		return new IntegerString(DicomTags.CompensatorNumber);
	}

	public static DecimalString newCompensatorPixelSpacing() {
		return new DecimalString(DicomTags.CompensatorPixelSpacing);
	}

	public static DecimalString newCompensatorPosition() {
		return new DecimalString(DicomTags.CompensatorPosition);
	}

	public static IntegerString newCompensatorRows() {
		return new IntegerString(DicomTags.CompensatorRows);
	}

	public static SequenceOfItems newCompensatorSeq() {
		return new SequenceOfItems(DicomTags.CompensatorSeq);
	}

	public static DecimalString newCompensatorThicknessData() {
		return new DecimalString(DicomTags.CompensatorThicknessData);
	}

	public static DecimalString newCompensatorTransmissionData() {
		return new DecimalString(DicomTags.CompensatorTransmissionData);
	}

	public static CodeString newCompensatorType() {
		return new CodeString(DicomTags.CompensatorType);
	}

	public static CodeString newCompletionFlag() {
		return new CodeString(DicomTags.CompletionFlag);
	}

	public static LongString newCompletionFlagDescription() {
		return new LongString(DicomTags.CompletionFlagDescription);
	}

	public static CodeString newComplexImageComponent() {
		return new CodeString(DicomTags.ComplexImageComponent);
	}

	public static CodeString newCompressionCodeRetired() {
		return new CodeString(DicomTags.CompressionCodeRetired);
	}

	public static DecimalString newCompressionForce() {
		return new DecimalString(DicomTags.CompressionForce);
	}

	public static UnsignedLong newConcatenationFrameOffsetNumber() {
		return new UnsignedLong(DicomTags.ConcatenationFrameOffsetNumber);
	}

	public static UniqueIdentifier newConcatenationUID() {
		return new UniqueIdentifier(DicomTags.ConcatenationUID);
	}

	public static SequenceOfItems newConceptCodeSeq() {
		return new SequenceOfItems(DicomTags.ConceptCodeSeq);
	}

	public static SequenceOfItems newConceptNameCodeSeq() {
		return new SequenceOfItems(DicomTags.ConceptNameCodeSeq);
	}

	public static LongString newConfidentialityCode() {
		return new LongString(DicomTags.ConfidentialityCode);
	}

	public static LongString newConfidentialityPatientData() {
		return new LongString(DicomTags.ConfidentialityPatientData);
	}

	public static ShortText newConfigurationInformation() {
		return new ShortText(DicomTags.ConfigurationInformation);
	}

	public static LongText newConfigurationInformationDescription() {
		return new LongText(DicomTags.ConfigurationInformationDescription);
	}

	public static CodeString newConstantVolumeFlag() {
		return new CodeString(DicomTags.ConstantVolumeFlag);
	}

	public static DecimalString newConstraintWeight() {
		return new DecimalString(DicomTags.ConstraintWeight);
	}

	public static DateElement newContentDate() {
		return new DateElement(DicomTags.ContentDate);
	}

	public static LongString newContentDescription() {
		return new LongString(DicomTags.ContentDescription);
	}

	public static SequenceOfItems newContentItemModifierSeq() {
		return new SequenceOfItems(DicomTags.ContentItemModifierSeq);
	}

	public static CodeString newContentLabel() {
		return new CodeString(DicomTags.ContentLabel);
	}

	public static CodeString newContentQualification() {
		return new CodeString(DicomTags.ContentQualification);
	}

	public static SequenceOfItems newContentSeq() {
		return new SequenceOfItems(DicomTags.ContentSeq);
	}

	public static SequenceOfItems newContentTemplateSeq() {
		return new SequenceOfItems(DicomTags.ContentTemplateSeq);
	}

	public static Time newContentTime() {
		return new Time(DicomTags.ContentTime);
	}

	public static UniqueIdentifier newContextGroupExtensionCreatorUID() {
		return new UniqueIdentifier(DicomTags.ContextGroupExtensionCreatorUID);
	}

	public static CodeString newContextGroupExtensionFlag() {
		return new CodeString(DicomTags.ContextGroupExtensionFlag);
	}

	public static DateTime newContextGroupLocalVersion() {
		return new DateTime(DicomTags.ContextGroupLocalVersion);
	}

	public static DateTime newContextGroupVersion() {
		return new DateTime(DicomTags.ContextGroupVersion);
	}

	public static CodeString newContextIdentifier() {
		return new CodeString(DicomTags.ContextIdentifier);
	}

	public static CodeString newContinuityOfContent() {
		return new CodeString(DicomTags.ContinuityOfContent);
	}

	public static DecimalString newContourData() {
		return new DecimalString(DicomTags.ContourData);
	}

	public static CodeString newContourGeometricType() {
		return new CodeString(DicomTags.ContourGeometricType);
	}

	public static SequenceOfItems newContourImageSeq() {
		return new SequenceOfItems(DicomTags.ContourImageSeq);
	}

	public static IntegerString newContourNumber() {
		return new IntegerString(DicomTags.ContourNumber);
	}

	public static DecimalString newContourOffsetVector() {
		return new DecimalString(DicomTags.ContourOffsetVector);
	}

	public static SequenceOfItems newContourSeq() {
		return new SequenceOfItems(DicomTags.ContourSeq);
	}

	public static DecimalString newContourSlabThickness() {
		return new DecimalString(DicomTags.ContourSlabThickness);
	}

	public static FloatingPointDouble newContourUncertaintyRadius() {
		return new FloatingPointDouble(DicomTags.ContourUncertaintyRadius);
	}

	public static SequenceOfItems newContrastAdministrationProfileSeq() {
		return new SequenceOfItems(DicomTags.ContrastAdministrationProfileSeq);
	}

	public static LongString newContrastAllergies() {
		return new LongString(DicomTags.ContrastAllergies);
	}

	public static SequenceOfItems newContrastBolusAdministrationRouteSeq() {
		return new SequenceOfItems(DicomTags.ContrastBolusAdministrationRouteSeq);
	}

	public static LongString newContrastBolusAgent() {
		return new LongString(DicomTags.ContrastBolusAgent);
	}

	public static CodeString newContrastBolusAgentAdministered() {
		return new CodeString(DicomTags.ContrastBolusAgentAdministered);
	}

	public static CodeString newContrastBolusAgentDetected() {
		return new CodeString(DicomTags.ContrastBolusAgentDetected);
	}

	public static UnsignedShort newContrastBolusAgentNumber() {
		return new UnsignedShort(DicomTags.ContrastBolusAgentNumber);
	}

	public static CodeString newContrastBolusAgentPhase() {
		return new CodeString(DicomTags.ContrastBolusAgentPhase);
	}

	public static SequenceOfItems newContrastBolusAgentSeq() {
		return new SequenceOfItems(DicomTags.ContrastBolusAgentSeq);
	}

	public static CodeString newContrastBolusIngredient() {
		return new CodeString(DicomTags.ContrastBolusIngredient);
	}

	public static SequenceOfItems newContrastBolusIngredientCodeSeq() {
		return new SequenceOfItems(DicomTags.ContrastBolusIngredientCodeSeq);
	}

	public static DecimalString newContrastBolusIngredientConcentration() {
		return new DecimalString(DicomTags.ContrastBolusIngredientConcentration);
	}

	public static LongString newContrastBolusRoute() {
		return new LongString(DicomTags.ContrastBolusRoute);
	}

	public static Time newContrastBolusStartTime() {
		return new Time(DicomTags.ContrastBolusStartTime);
	}

	public static Time newContrastBolusStopTime() {
		return new Time(DicomTags.ContrastBolusStopTime);
	}

	public static DecimalString newContrastBolusTotalDose() {
		return new DecimalString(DicomTags.ContrastBolusTotalDose);
	}

	public static SequenceOfItems newContrastBolusUsageSeq() {
		return new SequenceOfItems(DicomTags.ContrastBolusUsageSeq);
	}

	public static DecimalString newContrastBolusVolume() {
		return new DecimalString(DicomTags.ContrastBolusVolume);
	}

	public static DecimalString newContrastFlowDuration() {
		return new DecimalString(DicomTags.ContrastFlowDuration);
	}

	public static DecimalString newContrastFlowRate() {
		return new DecimalString(DicomTags.ContrastFlowRate);
	}

	public static UnsignedShort newContrastFrameAveraging() {
		return new UnsignedShort(DicomTags.ContrastFrameAveraging);
	}

	public static SequenceOfItems newContributingEquipmentSeq() {
		return new SequenceOfItems(DicomTags.ContributingEquipmentSeq);
	}

	public static DateTime newContributionDateTime() {
		return new DateTime(DicomTags.ContributionDateTime);
	}

	public static ShortText newContributionDescription() {
		return new ShortText(DicomTags.ContributionDescription);
	}

	public static DecimalString newControlPoint3DPosition() {
		return new DecimalString(DicomTags.ControlPoint3DPosition);
	}

	public static SequenceOfItems newControlPointDeliverySeq() {
		return new SequenceOfItems(DicomTags.ControlPointDeliverySeq);
	}

	public static IntegerString newControlPointIndex() {
		return new IntegerString(DicomTags.ControlPointIndex);
	}

	public static DecimalString newControlPointRelativePosition() {
		return new DecimalString(DicomTags.ControlPointRelativePosition);
	}

	public static SequenceOfItems newControlPointSeq() {
		return new SequenceOfItems(DicomTags.ControlPointSeq);
	}

	public static CodeString newConversionType() {
		return new CodeString(DicomTags.ConversionType);
	}

	public static ShortString newConvolutionKernel() {
		return new ShortString(DicomTags.ConvolutionKernel);
	}

	public static CodeString newConvolutionKernelGroup() {
		return new CodeString(DicomTags.ConvolutionKernelGroup);
	}

	public static SequenceOfItems newCoordinateSystemAxisCodeSeq() {
		return new SequenceOfItems(DicomTags.CoordinateSystemAxisCodeSeq);
	}

	public static LongString newCoordinatingCenterName() {
		return new LongString(DicomTags.CoordinatingCenterName);
	}

	public static Unknown newCopiesRetired() {
		return new Unknown(DicomTags.CopiesRetired);
	}

	public static CodeString newCorrectedImage() {
		return new CodeString(DicomTags.CorrectedImage);
	}

	public static IntegerString newCountRate() {
		return new IntegerString(DicomTags.CountRate);
	}

	public static LongString newCountryOfResidence() {
		return new LongString(DicomTags.CountryOfResidence);
	}

	public static IntegerString newCountsAccumulated() {
		return new IntegerString(DicomTags.CountsAccumulated);
	}

	public static CodeString newCountsIncluded() {
		return new CodeString(DicomTags.CountsIncluded);
	}

	public static CodeString newCountsSource() {
		return new CodeString(DicomTags.CountsSource);
	}

	public static CodeString newCoverageOfKSpace() {
		return new CodeString(DicomTags.CoverageOfKSpace);
	}

	public static DecimalString newCranialThermalIndex() {
		return new DecimalString(DicomTags.CranialThermalIndex);
	}

	public static DateElement newCreationDate() {
		return new DateElement(DicomTags.CreationDate);
	}

	public static Time newCreationTime() {
		return new Time(DicomTags.CreationTime);
	}

	public static UniqueIdentifier newCreatorVersionUID() {
		return new UniqueIdentifier(DicomTags.CreatorVersionUID);
	}

	public static SequenceOfItems newCTAcquisitionDetailsSeq() {
		return new SequenceOfItems(DicomTags.CTAcquisitionDetailsSeq);
	}

	public static SequenceOfItems newCTAcquisitionTypeSeq() {
		return new SequenceOfItems(DicomTags.CTAcquisitionTypeSeq);
	}

	public static FloatingPointDouble newCTDIvol() {
		return new FloatingPointDouble(DicomTags.CTDIvol);
	}

	public static SequenceOfItems newCTExposureSeq() {
		return new SequenceOfItems(DicomTags.CTExposureSeq);
	}

	public static SequenceOfItems newCTGeometrySeq() {
		return new SequenceOfItems(DicomTags.CTGeometrySeq);
	}

	public static SequenceOfItems newCTImageFrameTypeSeq() {
		return new SequenceOfItems(DicomTags.CTImageFrameTypeSeq);
	}

	public static SequenceOfItems newCTPositionSeq() {
		return new SequenceOfItems(DicomTags.CTPositionSeq);
	}

	public static SequenceOfItems newCTReconstructionSeq() {
		return new SequenceOfItems(DicomTags.CTReconstructionSeq);
	}

	public static SequenceOfItems newCTTableDynamicsSeq() {
		return new SequenceOfItems(DicomTags.CTTableDynamicsSeq);
	}

	public static SequenceOfItems newCTXRayDetailsSeq() {
		return new SequenceOfItems(DicomTags.CTXRayDetailsSeq);
	}

	public static DecimalString newCumulativeDoseReferenceCoefficient() {
		return new DecimalString(DicomTags.CumulativeDoseReferenceCoefficient);
	}

	public static DecimalString newCumulativeDoseToDoseReference() {
		return new DecimalString(DicomTags.CumulativeDoseToDoseReference);
	}

	public static DecimalString newCumulativeMetersetWeight() {
		return new DecimalString(DicomTags.CumulativeMetersetWeight);
	}

	public static DecimalString newCumulativeTimeWeight() {
		return new DecimalString(DicomTags.CumulativeTimeWeight);
	}

	public static IntegerString newCurrentFractionNumber() {
		return new IntegerString(DicomTags.CurrentFractionNumber);
	}

	public static LongString newCurrentPatientLocation() {
		return new LongString(DicomTags.CurrentPatientLocation);
	}

	public static SequenceOfItems newCurrentRequestedProcedureEvidenceSeq() {
		return new SequenceOfItems(DicomTags.CurrentRequestedProcedureEvidenceSeq);
	}

	public static CodeString newCurrentTreatmentStatus() {
		return new CodeString(DicomTags.CurrentTreatmentStatus);
	}

	public static DateElement newCurveDate() {
		return new DateElement(DicomTags.CurveDate);
	}

	public static IntegerString newCurveNumber() {
		return new IntegerString(DicomTags.CurveNumber);
	}

	public static Time newCurveTime() {
		return new Time(DicomTags.CurveTime);
	}

	public static FloatingPointSingle newCylinderAxis() {
		return new FloatingPointSingle(DicomTags.CylinderAxis);
	}

	public static FloatingPointSingle newCylinderLensPower() {
		return new FloatingPointSingle(DicomTags.CylinderLensPower);
	}

	public static FloatingPointDouble newDataCollectionCenterPatient() {
		return new FloatingPointDouble(DicomTags.DataCollectionCenterPatient);
	}

	public static DecimalString newDataCollectionDiameter() {
		return new DecimalString(DicomTags.DataCollectionDiameter);
	}

	public static SequenceOfItems newDataInformationSeq() {
		return new SequenceOfItems(DicomTags.DataInformationSeq);
	}

	public static UnsignedLong newDataPointColumns() {
		return new UnsignedLong(DicomTags.DataPointColumns);
	}

	public static UnsignedLong newDataPointRows() {
		return new UnsignedLong(DicomTags.DataPointRows);
	}

	public static CodeString newDataRepresentation() {
		return new CodeString(DicomTags.DataRepresentation);
	}

	public static Unknown newDataSetSubtypeRetired() {
		return new Unknown(DicomTags.DataSetSubtypeRetired);
	}

	public static OtherByteString newDataSetTrailingPadding() {
		return new OtherByteString(DicomTags.DataSetTrailingPadding);
	}

	public static UnsignedShort newDataSetType() {
		return new UnsignedShort(DicomTags.DataSetType);
	}

	public static Unknown newDataSetTypeRetired() {
		return new Unknown(DicomTags.DataSetTypeRetired);
	}

	public static DateElement newDate() {
		return new DateElement(DicomTags.Date);
	}

	public static DateElement newDateOfLastCalibration() {
		return new DateElement(DicomTags.DateOfLastCalibration);
	}

	public static DateElement newDateOfLastDetectorCalibration() {
		return new DateElement(DicomTags.DateOfLastDetectorCalibration);
	}

	public static DateElement newDateOfSecondaryCapture() {
		return new DateElement(DicomTags.DateOfSecondaryCapture);
	}

	public static DateTime newDateTime() {
		return new DateTime(DicomTags.DateTime);
	}

	public static DecimalString newdBDt() {
		return new DecimalString(DicomTags.dBDt);
	}

	public static CodeString newDeadTimeCorrectionFlag() {
		return new CodeString(DicomTags.DeadTimeCorrectionFlag);
	}

	public static DecimalString newDeadTimeFactor() {
		return new DecimalString(DicomTags.DeadTimeFactor);
	}

	public static CodeString newDecayCorrection() {
		return new CodeString(DicomTags.DecayCorrection);
	}

	public static DecimalString newDecayFactor() {
		return new DecimalString(DicomTags.DecayFactor);
	}

	public static CodeString newDecimateCropResult() {
		return new CodeString(DicomTags.DecimateCropResult);
	}

	public static CodeString newDeCoupledNucleus() {
		return new CodeString(DicomTags.DeCoupledNucleus);
	}

	public static CodeString newDeCoupling() {
		return new CodeString(DicomTags.DeCoupling);
	}

	public static FloatingPointDouble newDeCouplingChemicalShiftReference() {
		return new FloatingPointDouble(DicomTags.DeCouplingChemicalShiftReference);
	}

	public static FloatingPointDouble newDeCouplingFrequency() {
		return new FloatingPointDouble(DicomTags.DeCouplingFrequency);
	}

	public static CodeString newDeCouplingMethod() {
		return new CodeString(DicomTags.DeCouplingMethod);
	}

	public static CodeString newDefaultMagnificationType() {
		return new CodeString(DicomTags.DefaultMagnificationType);
	}

	public static CodeString newDefaultPrinterResolutionID() {
		return new CodeString(DicomTags.DefaultPrinterResolutionID);
	}

	public static CodeString newDefaultSmoothingType() {
		return new CodeString(DicomTags.DefaultSmoothingType);
	}

	public static FloatingPointSingle newDegreeOfDilation() {
		return new FloatingPointSingle(DicomTags.DegreeOfDilation);
	}

	public static LongString newDeIdentificationMethod() {
		return new LongString(DicomTags.DeIdentificationMethod);
	}

	public static SequenceOfItems newDeIdentificationMethodCodeSeq() {
		return new SequenceOfItems(DicomTags.DeIdentificationMethodCodeSeq);
	}

	public static DecimalString newDeliveredChannelTotalTime() {
		return new DecimalString(DicomTags.DeliveredChannelTotalTime);
	}

	public static DecimalString newDeliveredMeterset() {
		return new DecimalString(DicomTags.DeliveredMeterset);
	}

	public static IntegerString newDeliveredNumberOfPulses() {
		return new IntegerString(DicomTags.DeliveredNumberOfPulses);
	}

	public static DecimalString newDeliveredPrimaryMeterset() {
		return new DecimalString(DicomTags.DeliveredPrimaryMeterset);
	}

	public static DecimalString newDeliveredPulseRepetitionInterval() {
		return new DecimalString(DicomTags.DeliveredPulseRepetitionInterval);
	}

	public static DecimalString newDeliveredSecondaryMeterset() {
		return new DecimalString(DicomTags.DeliveredSecondaryMeterset);
	}

	public static DecimalString newDeliveredTreatmentTime() {
		return new DecimalString(DicomTags.DeliveredTreatmentTime);
	}

	public static DecimalString newDeliveryMaximumDose() {
		return new DecimalString(DicomTags.DeliveryMaximumDose);
	}

	public static DecimalString newDeliveryWarningDose() {
		return new DecimalString(DicomTags.DeliveryWarningDose);
	}

	public static IntegerString newDepthOfScanField() {
		return new IntegerString(DicomTags.DepthOfScanField);
	}

	public static SequenceOfItems newDerivationCodeSeq() {
		return new SequenceOfItems(DicomTags.DerivationCodeSeq);
	}

	public static ShortText newDerivationDescription() {
		return new ShortText(DicomTags.DerivationDescription);
	}

	public static SequenceOfItems newDerivationImageSeq() {
		return new SequenceOfItems(DicomTags.DerivationImageSeq);
	}

	public static ApplicationEntity newDestinationAE() {
		return new ApplicationEntity(DicomTags.DestinationAE);
	}

	public static DecimalString newDetectorActivationOffsetFromExposure() {
		return new DecimalString(DicomTags.DetectorActivationOffsetFromExposure);
	}

	public static DecimalString newDetectorActiveDimension() {
		return new DecimalString(DicomTags.DetectorActiveDimension);
	}

	public static DecimalString newDetectorActiveOrigin() {
		return new DecimalString(DicomTags.DetectorActiveOrigin);
	}

	public static CodeString newDetectorActiveShape() {
		return new CodeString(DicomTags.DetectorActiveShape);
	}

	public static DecimalString newDetectorActiveTime() {
		return new DecimalString(DicomTags.DetectorActiveTime);
	}

	public static DecimalString newDetectorBinning() {
		return new DecimalString(DicomTags.DetectorBinning);
	}

	public static CodeString newDetectorConditionsNominalFlag() {
		return new CodeString(DicomTags.DetectorConditionsNominalFlag);
	}

	public static CodeString newDetectorConfiguration() {
		return new CodeString(DicomTags.DetectorConfiguration);
	}

	public static LongText newDetectorDescription() {
		return new LongText(DicomTags.DetectorDescription);
	}

	public static DecimalString newDetectorElementPhysicalSize() {
		return new DecimalString(DicomTags.DetectorElementPhysicalSize);
	}

	public static DecimalString newDetectorElementSize() {
		return new DecimalString(DicomTags.DetectorElementSize);
	}

	public static DecimalString newDetectorElementSpacing() {
		return new DecimalString(DicomTags.DetectorElementSpacing);
	}

	public static ShortString newDetectorID() {
		return new ShortString(DicomTags.DetectorID);
	}

	public static SequenceOfItems newDetectorInformationSeq() {
		return new SequenceOfItems(DicomTags.DetectorInformationSeq);
	}

	public static LongString newDetectorLinesOfResponseUsed() {
		return new LongString(DicomTags.DetectorLinesOfResponseUsed);
	}

	public static LongText newDetectorMode() {
		return new LongText(DicomTags.DetectorMode);
	}

	public static DecimalString newDetectorPrimaryAngle() {
		return new DecimalString(DicomTags.DetectorPrimaryAngle);
	}

	public static DecimalString newDetectorSecondaryAngle() {
		return new DecimalString(DicomTags.DetectorSecondaryAngle);
	}

	public static DecimalString newDetectorTemperature() {
		return new DecimalString(DicomTags.DetectorTemperature);
	}

	public static DecimalString newDetectorTimeSinceLastExposure() {
		return new DecimalString(DicomTags.DetectorTimeSinceLastExposure);
	}

	public static CodeString newDetectorType() {
		return new CodeString(DicomTags.DetectorType);
	}

	public static UnsignedShort newDetectorVector() {
		return new UnsignedShort(DicomTags.DetectorVector);
	}

	public static LongString newDeviceDescription() {
		return new LongString(DicomTags.DeviceDescription);
	}

	public static DecimalString newDeviceDiameter() {
		return new DecimalString(DicomTags.DeviceDiameter);
	}

	public static CodeString newDeviceDiameterUnits() {
		return new CodeString(DicomTags.DeviceDiameterUnits);
	}

	public static DecimalString newDeviceLength() {
		return new DecimalString(DicomTags.DeviceLength);
	}

	public static SequenceOfItems newDeviceSeq() {
		return new SequenceOfItems(DicomTags.DeviceSeq);
	}

	public static LongString newDeviceSerialNumber() {
		return new LongString(DicomTags.DeviceSerialNumber);
	}

	public static DecimalString newDeviceVolume() {
		return new DecimalString(DicomTags.DeviceVolume);
	}

	public static Unknown newDialogReceiverRetired() {
		return new Unknown(DicomTags.DialogReceiverRetired);
	}

	public static CodeString newDiffusionAnisotropyType() {
		return new CodeString(DicomTags.DiffusionAnisotropyType);
	}

	public static FloatingPointDouble newDiffusionBValue() {
		return new FloatingPointDouble(DicomTags.DiffusionBValue);
	}

	public static CodeString newDiffusionDirectionality() {
		return new CodeString(DicomTags.DiffusionDirectionality);
	}

	public static SequenceOfItems newDiffusionGradientDirectionSeq() {
		return new SequenceOfItems(DicomTags.DiffusionGradientDirectionSeq);
	}

	public static FloatingPointDouble newDiffusionGradientOrientation() {
		return new FloatingPointDouble(DicomTags.DiffusionGradientOrientation);
	}

	public static LongString newDigitalImageFormatAcquired() {
		return new LongString(DicomTags.DigitalImageFormatAcquired);
	}

	public static AttributeTag newDimensionIndexPointer() {
		return new AttributeTag(DicomTags.DimensionIndexPointer);
	}

	public static LongString newDimensionIndexPrivateCreator() {
		return new LongString(DicomTags.DimensionIndexPrivateCreator);
	}

	public static SequenceOfItems newDimensionIndexSeq() {
		return new SequenceOfItems(DicomTags.DimensionIndexSeq);
	}

	public static UnsignedLong newDimensionIndexValues() {
		return new UnsignedLong(DicomTags.DimensionIndexValues);
	}

	public static SequenceOfItems newDimensionOrganizationSeq() {
		return new SequenceOfItems(DicomTags.DimensionOrganizationSeq);
	}

	public static UniqueIdentifier newDimensionOrganizationUID() {
		return new UniqueIdentifier(DicomTags.DimensionOrganizationUID);
	}

	public static SequenceOfItems newDirectoryRecordSeq() {
		return new SequenceOfItems(DicomTags.DirectoryRecordSeq);
	}

	public static CodeString newDirectoryRecordType() {
		return new CodeString(DicomTags.DirectoryRecordType);
	}

	public static DateElement newDischargeDate() {
		return new DateElement(DicomTags.DischargeDate);
	}

	public static SequenceOfItems newDischargeDiagnosisCodeSeq() {
		return new SequenceOfItems(DicomTags.DischargeDiagnosisCodeSeq);
	}

	public static LongString newDischargeDiagnosisDescription() {
		return new LongString(DicomTags.DischargeDiagnosisDescription);
	}

	public static Time newDischargeTime() {
		return new Time(DicomTags.DischargeTime);
	}

	public static SignedLong newDisplayedAreaBottomRightHandCorner() {
		return new SignedLong(DicomTags.DisplayedAreaBottomRightHandCorner);
	}

	public static SequenceOfItems newDisplayedAreaSelectionSeq() {
		return new SequenceOfItems(DicomTags.DisplayedAreaSelectionSeq);
	}

	public static SignedLong newDisplayedAreaTopLeftHandCorner() {
		return new SignedLong(DicomTags.DisplayedAreaTopLeftHandCorner);
	}

	public static FloatingPointDouble newDisplayEnvironmentSpatialPosition() {
		return new FloatingPointDouble(DicomTags.DisplayEnvironmentSpatialPosition);
	}

	public static Unknown newDisplayFormatRetired() {
		return new Unknown(DicomTags.DisplayFormatRetired);
	}

	public static UnsignedShort newDisplaySetNumber() {
		return new UnsignedShort(DicomTags.DisplaySetNumber);
	}

	public static CodeString newDisplaySetPatientOrientation() {
		return new CodeString(DicomTags.DisplaySetPatientOrientation);
	}

	public static UnsignedShort newDisplaySetPresentationGroup() {
		return new UnsignedShort(DicomTags.DisplaySetPresentationGroup);
	}

	public static LongString newDisplaySetPresentationGroupDescription() {
		return new LongString(DicomTags.DisplaySetPresentationGroupDescription);
	}

	public static Unknown newDisplaySetScrollingGroup() {
		return new Unknown(DicomTags.DisplaySetScrollingGroup);
	}

	public static SequenceOfItems newDisplaySetsSeq() {
		return new SequenceOfItems(DicomTags.DisplaySetsSeq);
	}

	public static FloatingPointDouble newDistanceSourceToDataCollectionCenter() {
		return new FloatingPointDouble(
				DicomTags.DistanceSourceToDataCollectionCenter);
	}

	public static DecimalString newDistanceSourceToDetector() {
		return new DecimalString(DicomTags.DistanceSourceToDetector);
	}

	public static DecimalString newDistanceSourceToEntrance() {
		return new DecimalString(DicomTags.DistanceSourceToEntrance);
	}

	public static DecimalString newDistanceSourceToPatient() {
		return new DecimalString(DicomTags.DistanceSourceToPatient);
	}

	public static DecimalString newDistanceSourceToSupport() {
		return new DecimalString(DicomTags.DistanceSourceToSupport);
	}

	public static LongString newDistributionAddress() {
		return new LongString(DicomTags.DistributionAddress);
	}

	public static PersonName newDistributionName() {
		return new PersonName(DicomTags.DistributionName);
	}

	public static ShortText newDocumentTitle() {
		return new ShortText(DicomTags.DocumentTitle);
	}

	public static FloatingPointDouble newDopplerCorrectionAngle() {
		return new FloatingPointDouble(DicomTags.DopplerCorrectionAngle);
	}

	public static UnsignedLong newDopplerSampleVolumeXPosition() {
		return new UnsignedLong(DicomTags.DopplerSampleVolumeXPosition);
	}

	public static UnsignedLong newDopplerSampleVolumeYPosition() {
		return new UnsignedLong(DicomTags.DopplerSampleVolumeYPosition);
	}

	public static DecimalString newDoseCalibrationFactor() {
		return new DecimalString(DicomTags.DoseCalibrationFactor);
	}

	public static LongString newDoseComment() {
		return new LongString(DicomTags.DoseComment);
	}

	public static DecimalString newDoseGridScaling() {
		return new DecimalString(DicomTags.DoseGridScaling);
	}

	public static DecimalString newDoseRateDelivered() {
		return new DecimalString(DicomTags.DoseRateDelivered);
	}

	public static DecimalString newDoseRateSet() {
		return new DecimalString(DicomTags.DoseRateSet);
	}

	public static LongString newDoseReferenceDescription() {
		return new LongString(DicomTags.DoseReferenceDescription);
	}

	public static IntegerString newDoseReferenceNumber() {
		return new IntegerString(DicomTags.DoseReferenceNumber);
	}

	public static DecimalString newDoseReferencePointCoordinates() {
		return new DecimalString(DicomTags.DoseReferencePointCoordinates);
	}

	public static SequenceOfItems newDoseReferenceSeq() {
		return new SequenceOfItems(DicomTags.DoseReferenceSeq);
	}

	public static CodeString newDoseReferenceStructureType() {
		return new CodeString(DicomTags.DoseReferenceStructureType);
	}

	public static CodeString newDoseReferenceType() {
		return new CodeString(DicomTags.DoseReferenceType);
	}

	public static CodeString newDoseSummationType() {
		return new CodeString(DicomTags.DoseSummationType);
	}

	public static CodeString newDoseType() {
		return new CodeString(DicomTags.DoseType);
	}

	public static CodeString newDoseUnits() {
		return new CodeString(DicomTags.DoseUnits);
	}

	public static DecimalString newDoseValue() {
		return new DecimalString(DicomTags.DoseValue);
	}

	public static DecimalString newDVHData() {
		return new DecimalString(DicomTags.DVHData);
	}

	public static DecimalString newDVHDoseScaling() {
		return new DecimalString(DicomTags.DVHDoseScaling);
	}

	public static DecimalString newDVHMaximumDose() {
		return new DecimalString(DicomTags.DVHMaximumDose);
	}

	public static DecimalString newDVHMeanDose() {
		return new DecimalString(DicomTags.DVHMeanDose);
	}

	public static DecimalString newDVHMinimumDose() {
		return new DecimalString(DicomTags.DVHMinimumDose);
	}

	public static DecimalString newDVHNormalizationDoseValue() {
		return new DecimalString(DicomTags.DVHNormalizationDoseValue);
	}

	public static DecimalString newDVHNormalizationPoint() {
		return new DecimalString(DicomTags.DVHNormalizationPoint);
	}

	public static IntegerString newDVHNumberOfBins() {
		return new IntegerString(DicomTags.DVHNumberOfBins);
	}

	public static SequenceOfItems newDVHRefROISeq() {
		return new SequenceOfItems(DicomTags.DVHRefROISeq);
	}

	public static CodeString newDVHROIContributionType() {
		return new CodeString(DicomTags.DVHROIContributionType);
	}

	public static SequenceOfItems newDVHSeq() {
		return new SequenceOfItems(DicomTags.DVHSeq);
	}

	public static CodeString newDVHType() {
		return new CodeString(DicomTags.DVHType);
	}

	public static CodeString newDVHVolumeUnits() {
		return new CodeString(DicomTags.DVHVolumeUnits);
	}

	public static Unknown newDynamicRangeRetired() {
		return new Unknown(DicomTags.DynamicRangeRetired);
	}

	public static IntegerString newEchoNumber() {
		return new IntegerString(DicomTags.EchoNumber);
	}

	public static CodeString newEchoPlanarPulseSeq() {
		return new CodeString(DicomTags.EchoPlanarPulseSeq);
	}

	public static CodeString newEchoPulseSeq() {
		return new CodeString(DicomTags.EchoPulseSeq);
	}

	public static DecimalString newEchoTime() {
		return new DecimalString(DicomTags.EchoTime);
	}

	public static IntegerString newEchoTrainLength() {
		return new IntegerString(DicomTags.EchoTrainLength);
	}

	public static SequenceOfItems newEcryptedAttributesSeq() {
		return new SequenceOfItems(DicomTags.EcryptedAttributesSeq);
	}

	public static DecimalString newEffectiveDuration() {
		return new DecimalString(DicomTags.EffectiveDuration);
	}

	public static FloatingPointDouble newEffectiveEchoTime() {
		return new FloatingPointDouble(DicomTags.EffectiveEchoTime);
	}

	public static FloatingPointSingle newEmmetropicMagnification() {
		return new FloatingPointSingle(DicomTags.EmmetropicMagnification);
	}

	public static CodeString newEmptyImageDensity() {
		return new CodeString(DicomTags.EmptyImageDensity);
	}

	public static OtherByteString newEncapsulatedDocument() {
		return new OtherByteString(DicomTags.EncapsulatedDocument);
	}

	public static OtherByteString newEncryptedContent() {
		return new OtherByteString(DicomTags.EncryptedContent);
	}

	public static UniqueIdentifier newEncryptedContentTransferSyntax() {
		return new UniqueIdentifier(DicomTags.EncryptedContentTransferSyntax);
	}

	public static DecimalString newEndCumulativeMetersetWeight() {
		return new DecimalString(DicomTags.EndCumulativeMetersetWeight);
	}

	public static Unknown newEndMessageIDRetired() {
		return new Unknown(DicomTags.EndMessageIDRetired);
	}

	public static DecimalString newEndMeterset() {
		return new DecimalString(DicomTags.EndMeterset);
	}

	public static DecimalString newEnergyWindowCenterlineRetired() {
		return new DecimalString(DicomTags.EnergyWindowCenterlineRetired);
	}

	public static SequenceOfItems newEnergyWindowInformationSeq() {
		return new SequenceOfItems(DicomTags.EnergyWindowInformationSeq);
	}

	public static DecimalString newEnergyWindowLowerLimit() {
		return new DecimalString(DicomTags.EnergyWindowLowerLimit);
	}

	public static ShortString newEnergyWindowName() {
		return new ShortString(DicomTags.EnergyWindowName);
	}

	public static UnsignedShort newEnergyWindowNumber() {
		return new UnsignedShort(DicomTags.EnergyWindowNumber);
	}

	public static SequenceOfItems newEnergyWindowRangeSeq() {
		return new SequenceOfItems(DicomTags.EnergyWindowRangeSeq);
	}

	public static DecimalString newEnergyWindowTotalWidthRetired() {
		return new DecimalString(DicomTags.EnergyWindowTotalWidthRetired);
	}

	public static DecimalString newEnergyWindowUpperLimit() {
		return new DecimalString(DicomTags.EnergyWindowUpperLimit);
	}

	public static UnsignedShort newEnergyWindowVector() {
		return new UnsignedShort(DicomTags.EnergyWindowVector);
	}

	public static UnsignedShort newEntranceDose() {
		return new UnsignedShort(DicomTags.EntranceDose);
	}

	public static DecimalString newEntranceDoseInmGy() {
		return new DecimalString(DicomTags.EntranceDoseInmGy);
	}

	public static Unknown newEraseRetired() {
		return new Unknown(DicomTags.EraseRetired);
	}

	public static LongString newErrorComment() {
		return new LongString(DicomTags.ErrorComment);
	}

	public static UnsignedShort newErrorID() {
		return new UnsignedShort(DicomTags.ErrorID);
	}

	public static FloatingPointDouble newEstimatedDoseSaving() {
		return new FloatingPointDouble(DicomTags.EstimatedDoseSaving);
	}

	public static DecimalString newEstimatedRadiographicMagnificationFactor() {
		return new DecimalString(DicomTags.EstimatedRadiographicMagnificationFactor);
	}

	public static ShortString newEthnicGroup() {
		return new ShortString(DicomTags.EthnicGroup);
	}

	public static DecimalString newEventElapsedTime() {
		return new DecimalString(DicomTags.EventElapsedTime);
	}

	public static LongString newEventTimerName() {
		return new LongString(DicomTags.EventTimerName);
	}

	public static UnsignedShort newEventTypeID() {
		return new UnsignedShort(DicomTags.EventTypeID);
	}

	public static CodeString newExecutionStatus() {
		return new CodeString(DicomTags.ExecutionStatus);
	}

	public static CodeString newExecutionStatusInfo() {
		return new CodeString(DicomTags.ExecutionStatusInfo);
	}

	public static DateTime newExpectedCompletionDateAndTime() {
		return new DateTime(DicomTags.ExpectedCompletionDateAndTime);
	}

	public static UnsignedShort newExposedArea() {
		return new UnsignedShort(DicomTags.ExposedArea);
	}

	public static IntegerString newExposure() {
		return new IntegerString(DicomTags.Exposure);
	}

	public static CodeString newExposureControlMode() {
		return new CodeString(DicomTags.ExposureControlMode);
	}

	public static LongText newExposureControlModeDescription() {
		return new LongText(DicomTags.ExposureControlModeDescription);
	}

	public static SequenceOfItems newExposureDoseSeq() {
		return new SequenceOfItems(DicomTags.ExposureDoseSeq);
	}

	public static FloatingPointDouble newExposureInMAs() {
		return new FloatingPointDouble(DicomTags.ExposureInMAs);
	}

	public static IntegerString newExposureInuAs() {
		return new IntegerString(DicomTags.ExposureInuAs);
	}

	public static CodeString newExposureModulationType() {
		return new CodeString(DicomTags.ExposureModulationType);
	}

	public static SequenceOfItems newExposureSeq() {
		return new SequenceOfItems(DicomTags.ExposureSeq);
	}

	public static IntegerString newExposuresOnDetectorSinceLastCalibration() {
		return new IntegerString(DicomTags.ExposuresOnDetectorSinceLastCalibration);
	}

	public static IntegerString newExposuresOnDetectorSinceManufactured() {
		return new IntegerString(DicomTags.ExposuresOnDetectorSinceManufactured);
	}

	public static UnsignedShort newExposuresOnPlate() {
		return new UnsignedShort(DicomTags.ExposuresOnPlate);
	}

	public static CodeString newExposureStatus() {
		return new CodeString(DicomTags.ExposureStatus);
	}

	public static IntegerString newExposureTime() {
		return new IntegerString(DicomTags.ExposureTime);
	}

	public static FloatingPointDouble newExposureTimeInMs() {
		return new FloatingPointDouble(DicomTags.ExposureTimeInMs);
	}

	public static DecimalString newExposureTimeInuS() {
		return new DecimalString(DicomTags.ExposureTimeInuS);
	}

	public static UniqueIdentifier newFailedSOPInstanceUIDList() {
		return new UniqueIdentifier(DicomTags.FailedSOPInstanceUIDList);
	}

	public static SequenceOfItems newFailedSOPSeq() {
		return new SequenceOfItems(DicomTags.FailedSOPSeq);
	}

	public static AttributeTag newFailureAttributes() {
		return new AttributeTag(DicomTags.FailureAttributes);
	}

	public static UnsignedShort newFailureReason() {
		return new UnsignedShort(DicomTags.FailureReason);
	}

	public static ShortText newFiducialDescription() {
		return new ShortText(DicomTags.FiducialDescription);
	}

	public static ShortString newFiducialIdentifier() {
		return new ShortString(DicomTags.FiducialIdentifier);
	}

	public static SequenceOfItems newFiducialIdentifierCodeSeq() {
		return new SequenceOfItems(DicomTags.FiducialIdentifierCodeSeq);
	}

	public static SequenceOfItems newFiducialSeq() {
		return new SequenceOfItems(DicomTags.FiducialSeq);
	}

	public static SequenceOfItems newFiducialSetSeq() {
		return new SequenceOfItems(DicomTags.FiducialSetSeq);
	}

	public static UniqueIdentifier newFiducialUID() {
		return new UniqueIdentifier(DicomTags.FiducialUID);
	}

	public static IntegerString newFieldOfViewDimension() {
		return new IntegerString(DicomTags.FieldOfViewDimension);
	}

	public static CodeString newFieldOfViewHorizontalFlip() {
		return new CodeString(DicomTags.FieldOfViewHorizontalFlip);
	}

	public static DecimalString newFieldOfViewOrigin() {
		return new DecimalString(DicomTags.FieldOfViewOrigin);
	}

	public static DecimalString newFieldOfViewRotation() {
		return new DecimalString(DicomTags.FieldOfViewRotation);
	}

	public static CodeString newFieldOfViewShape() {
		return new CodeString(DicomTags.FieldOfViewShape);
	}

	public static UnsignedLong newFileMetaInformationGroupLength() {
		return new UnsignedLong(DicomTags.FileMetaInformationGroupLength);
	}

	public static OtherByteString newFileMetaInformationVersion() {
		return new OtherByteString(DicomTags.FileMetaInformationVersion);
	}

	public static UnsignedShort newFileSetConsistencyFlag() {
		return new UnsignedShort(DicomTags.FileSetConsistencyFlag);
	}

	public static CodeString newFileSetDescriptorFileID() {
		return new CodeString(DicomTags.FileSetDescriptorFileID);
	}

	public static CodeString newFileSetID() {
		return new CodeString(DicomTags.FileSetID);
	}

	public static LongString newFillerOrderNumber() {
		return new LongString(DicomTags.FillerOrderNumber);
	}

	public static ShortString newFillerOrderNumberImagingServiceRequestRetired() {
		return new ShortString(
				DicomTags.FillerOrderNumberImagingServiceRequestRetired);
	}

	public static ShortString newFillerOrderNumberProcedureRetired() {
		return new ShortString(DicomTags.FillerOrderNumberProcedureRetired);
	}

	public static SequenceOfItems newFilmBoxContentSeq() {
		return new SequenceOfItems(DicomTags.FilmBoxContentSeq);
	}

	public static SequenceOfItems newFilmConsumptionSeq() {
		return new SequenceOfItems(DicomTags.FilmConsumptionSeq);
	}

	public static CodeString newFilmDestination() {
		return new CodeString(DicomTags.FilmDestination);
	}

	public static CodeString newFilmOrientation() {
		return new CodeString(DicomTags.FilmOrientation);
	}

	public static LongString newFilmSessionLabel() {
		return new LongString(DicomTags.FilmSessionLabel);
	}

	public static CodeString newFilmSizeID() {
		return new CodeString(DicomTags.FilmSizeID);
	}

	public static CodeString newFilterByAttributePresence() {
		return new CodeString(DicomTags.FilterByAttributePresence);
	}

	public static CodeString newFilterByCategory() {
		return new CodeString(DicomTags.FilterByCategory);
	}

	public static CodeString newFilterByOperator() {
		return new CodeString(DicomTags.FilterByOperator);
	}

	public static DecimalString newFilterHighFrequency() {
		return new DecimalString(DicomTags.FilterHighFrequency);
	}

	public static DecimalString newFilterLowFrequency() {
		return new DecimalString(DicomTags.FilterLowFrequency);
	}

	public static CodeString newFilterMaterial() {
		return new CodeString(DicomTags.FilterMaterial);
	}

	public static SequenceOfItems newFilterOperationsSeq() {
		return new SequenceOfItems(DicomTags.FilterOperationsSeq);
	}

	public static DecimalString newFilterThicknessMaximum() {
		return new DecimalString(DicomTags.FilterThicknessMaximum);
	}

	public static DecimalString newFilterThicknessMinimum() {
		return new DecimalString(DicomTags.FilterThicknessMinimum);
	}

	public static ShortString newFilterType() {
		return new ShortString(DicomTags.FilterType);
	}

	public static DecimalString newFinalCumulativeMetersetWeight() {
		return new DecimalString(DicomTags.FinalCumulativeMetersetWeight);
	}

	public static DecimalString newFinalCumulativeTimeWeight() {
		return new DecimalString(DicomTags.FinalCumulativeTimeWeight);
	}

	public static Unknown newFindLocationRetired() {
		return new Unknown(DicomTags.FindLocationRetired);
	}

	public static CodeString newFirstOrderPhaseCorrection() {
		return new CodeString(DicomTags.FirstOrderPhaseCorrection);
	}

	public static OtherFloatString newFirstOrderPhaseCorrectionAngle() {
		return new OtherFloatString(DicomTags.FirstOrderPhaseCorrectionAngle);
	}

	public static DateElement newFirstTreatmentDate() {
		return new DateElement(DicomTags.FirstTreatmentDate);
	}

	public static ShortText newFixationDeviceDescription() {
		return new ShortText(DicomTags.FixationDeviceDescription);
	}

	public static ShortString newFixationDeviceLabel() {
		return new ShortString(DicomTags.FixationDeviceLabel);
	}

	public static ShortString newFixationDevicePosition() {
		return new ShortString(DicomTags.FixationDevicePosition);
	}

	public static SequenceOfItems newFixationDeviceSeq() {
		return new SequenceOfItems(DicomTags.FixationDeviceSeq);
	}

	public static CodeString newFixationDeviceType() {
		return new CodeString(DicomTags.FixationDeviceType);
	}

	public static DecimalString newFlipAngle() {
		return new DecimalString(DicomTags.FlipAngle);
	}

	public static CodeString newFlowCompensation() {
		return new CodeString(DicomTags.FlowCompensation);
	}

	public static CodeString newFlowCompensationDirection() {
		return new CodeString(DicomTags.FlowCompensationDirection);
	}

	public static DecimalString newFluenceDataScale() {
		return new DecimalString(DicomTags.FluenceDataScale);
	}

	public static CodeString newFluenceDataSource() {
		return new CodeString(DicomTags.FluenceDataSource);
	}

	public static SequenceOfItems newFluenceMapSeq() {
		return new SequenceOfItems(DicomTags.FluenceMapSeq);
	}

	public static CodeString newFluoroscopyFlag() {
		return new CodeString(DicomTags.FluoroscopyFlag);
	}

	public static IntegerString newFocalDistance() {
		return new IntegerString(DicomTags.FocalDistance);
	}

	public static DecimalString newFocalSpot() {
		return new DecimalString(DicomTags.FocalSpot);
	}

	public static DecimalString newFocusDepth() {
		return new DecimalString(DicomTags.FocusDepth);
	}

	public static IntegerString newFractionGroupNumber() {
		return new IntegerString(DicomTags.FractionGroupNumber);
	}

	public static SequenceOfItems newFractionGroupSeq() {
		return new SequenceOfItems(DicomTags.FractionGroupSeq);
	}

	public static SequenceOfItems newFractionGroupSummarySeq() {
		return new SequenceOfItems(DicomTags.FractionGroupSummarySeq);
	}

	public static CodeString newFractionGroupType() {
		return new CodeString(DicomTags.FractionGroupType);
	}

	public static IntegerString newFractionNumber() {
		return new IntegerString(DicomTags.FractionNumber);
	}

	public static LongText newFractionPattern() {
		return new LongText(DicomTags.FractionPattern);
	}

	public static SequenceOfItems newFractionStatusSummarySeq() {
		return new SequenceOfItems(DicomTags.FractionStatusSummarySeq);
	}

	public static DateTime newFrameAcquisitionDatetime() {
		return new DateTime(DicomTags.FrameAcquisitionDatetime);
	}

	public static FloatingPointDouble newFrameAcquisitionDuration() {
		return new FloatingPointDouble(DicomTags.FrameAcquisitionDuration);
	}

	public static UnsignedShort newFrameAcquisitionNumber() {
		return new UnsignedShort(DicomTags.FrameAcquisitionNumber);
	}

	public static SequenceOfItems newFrameAnatomySeq() {
		return new SequenceOfItems(DicomTags.FrameAnatomySeq);
	}

	public static LongText newFrameComments() {
		return new LongText(DicomTags.FrameComments);
	}

	public static SequenceOfItems newFrameContentSeq() {
		return new SequenceOfItems(DicomTags.FrameContentSeq);
	}

	public static DecimalString newFrameDelay() {
		return new DecimalString(DicomTags.FrameDelay);
	}

	public static AttributeTag newFrameIncrementPointer() {
		return new AttributeTag(DicomTags.FrameIncrementPointer);
	}

	public static CodeString newFrameLaterality() {
		return new CodeString(DicomTags.FrameLaterality);
	}

	public static UnsignedShort newFrameNumbersOfInterest() {
		return new UnsignedShort(DicomTags.FrameNumbersOfInterest);
	}

	public static LongString newFrameOfInterestDescription() {
		return new LongString(DicomTags.FrameOfInterestDescription);
	}

	public static SequenceOfItems newFrameOfReferenceRelationshipSeq() {
		return new SequenceOfItems(DicomTags.FrameOfReferenceRelationshipSeq);
	}

	public static LongString newFrameOfReferenceTransformationComment() {
		return new LongString(DicomTags.FrameOfReferenceTransformationComment);
	}

	public static DecimalString newFrameOfReferenceTransformationMatrix() {
		return new DecimalString(DicomTags.FrameOfReferenceTransformationMatrix);
	}

	public static CodeString newFrameOfReferenceTransformationMatrixType() {
		return new CodeString(DicomTags.FrameOfReferenceTransformationMatrixType);
	}

	public static CodeString newFrameOfReferenceTransformationType() {
		return new CodeString(DicomTags.FrameOfReferenceTransformationType);
	}

	public static UniqueIdentifier newFrameOfReferenceUID() {
		return new UniqueIdentifier(DicomTags.FrameOfReferenceUID);
	}

	public static DateTime newFrameReferenceDatetime() {
		return new DateTime(DicomTags.FrameReferenceDatetime);
	}

	public static DecimalString newFrameReferenceTime() {
		return new DecimalString(DicomTags.FrameReferenceTime);
	}

	public static DecimalString newFrameTime() {
		return new DecimalString(DicomTags.FrameTime);
	}

	public static DecimalString newFrameTimeVector() {
		return new DecimalString(DicomTags.FrameTimeVector);
	}

	public static CodeString newFrameType() {
		return new CodeString(DicomTags.FrameType);
	}

	public static SequenceOfItems newFrameVOILUTSeq() {
		return new SequenceOfItems(DicomTags.FrameVOILUTSeq);
	}

	public static LongString newFramingType() {
		return new LongString(DicomTags.FramingType);
	}

	public static CodeString newFrequencyCorrection() {
		return new CodeString(DicomTags.FrequencyCorrection);
	}

	public static AttributeTag newFunctionalGroupPointer() {
		return new AttributeTag(DicomTags.FunctionalGroupPointer);
	}

	public static LongString newFunctionalGroupPrivateCreator() {
		return new LongString(DicomTags.FunctionalGroupPrivateCreator);
	}

	public static DecimalString newGantryAngle() {
		return new DecimalString(DicomTags.GantryAngle);
	}

	public static DecimalString newGantryAngleTolerance() {
		return new DecimalString(DicomTags.GantryAngleTolerance);
	}

	public static DecimalString newGantryDetectorSlew() {
		return new DecimalString(DicomTags.GantryDetectorSlew);
	}

	public static DecimalString newGantryDetectorTilt() {
		return new DecimalString(DicomTags.GantryDetectorTilt);
	}

	public static CodeString newGantryRotationDirection() {
		return new CodeString(DicomTags.GantryRotationDirection);
	}

	public static SequenceOfItems newGatedInformationSeq() {
		return new SequenceOfItems(DicomTags.GatedInformationSeq);
	}

	public static IntegerString newGeneratorPower() {
		return new IntegerString(DicomTags.GeneratorPower);
	}

	public static CodeString newGeometryOfKSpaceTraversal() {
		return new CodeString(DicomTags.GeometryOfKSpaceTraversal);
	}

	public static CodeString newGPPPSStatus() {
		return new CodeString(DicomTags.GPPPSStatus);
	}

	public static CodeString newGPSPSPriority() {
		return new CodeString(DicomTags.GPSPSPriority);
	}

	public static CodeString newGPSPSStatus() {
		return new CodeString(DicomTags.GPSPSStatus);
	}

	public static UnsignedShort newGradientEchoTrainLength() {
		return new UnsignedShort(DicomTags.GradientEchoTrainLength);
	}

	public static FloatingPointDouble newGradientOutput() {
		return new FloatingPointDouble(DicomTags.GradientOutput);
	}

	public static CodeString newGradientOutputType() {
		return new CodeString(DicomTags.GradientOutputType);
	}

	public static SequenceOfItems newGraphicAnnotationSeq() {
		return new SequenceOfItems(DicomTags.GraphicAnnotationSeq);
	}

	public static CodeString newGraphicAnnotationUnits() {
		return new CodeString(DicomTags.GraphicAnnotationUnits);
	}

	public static SequenceOfItems newGraphicCoordinatesDataSeq() {
		return new SequenceOfItems(DicomTags.GraphicCoordinatesDataSeq);
	}

	public static FloatingPointSingle newGraphicData() {
		return new FloatingPointSingle(DicomTags.GraphicData);
	}

	public static UnsignedShort newGraphicDimensions() {
		return new UnsignedShort(DicomTags.GraphicDimensions);
	}

	public static CodeString newGraphicFilled() {
		return new CodeString(DicomTags.GraphicFilled);
	}

	public static CodeString newGraphicLayer() {
		return new CodeString(DicomTags.GraphicLayer);
	}

	public static LongString newGraphicLayerDescription() {
		return new LongString(DicomTags.GraphicLayerDescription);
	}

	public static IntegerString newGraphicLayerOrder() {
		return new IntegerString(DicomTags.GraphicLayerOrder);
	}

	public static UnsignedShort newGraphicLayerRecommendedDisplayGrayscaleValue() {
		return new UnsignedShort(
				DicomTags.GraphicLayerRecommendedDisplayGrayscaleValue);
	}

	public static UnsignedShort newGraphicLayerRecommendedDisplayRGBValue() {
		return new UnsignedShort(DicomTags.GraphicLayerRecommendedDisplayRGBValue);
	}

	public static SequenceOfItems newGraphicLayerSeq() {
		return new SequenceOfItems(DicomTags.GraphicLayerSeq);
	}

	public static SequenceOfItems newGraphicObjectSeq() {
		return new SequenceOfItems(DicomTags.GraphicObjectSeq);
	}

	public static CodeString newGraphicType() {
		return new CodeString(DicomTags.GraphicType);
	}

	public static Unknown newGrayScaleRetired() {
		return new Unknown(DicomTags.GrayScaleRetired);
	}

	public static OtherWordString newGreenPaletteColorLUTData() {
		return new OtherWordString(DicomTags.GreenPaletteColorLUTData);
	}

	public static Unknown newGreenPaletteColorLUTDescriptor() {
		return new Unknown(DicomTags.GreenPaletteColorLUTDescriptor);
	}

	public static Unknown newGreyLUTDescriptorRetired() {
		return new Unknown(DicomTags.GreyLUTDescriptorRetired);
	}

	public static CodeString newGrid() {
		return new CodeString(DicomTags.Grid);
	}

	public static LongText newGridAbsorbingMaterial() {
		return new LongText(DicomTags.GridAbsorbingMaterial);
	}

	public static IntegerString newGridAspectRatio() {
		return new IntegerString(DicomTags.GridAspectRatio);
	}

	public static DecimalString newGridFocalDistance() {
		return new DecimalString(DicomTags.GridFocalDistance);
	}

	public static DecimalString newGridFrameOffsetVector() {
		return new DecimalString(DicomTags.GridFrameOffsetVector);
	}

	public static DecimalString newGridPeriod() {
		return new DecimalString(DicomTags.GridPeriod);
	}

	public static DecimalString newGridPitch() {
		return new DecimalString(DicomTags.GridPitch);
	}

	public static LongText newGridSpacingMaterial() {
		return new LongText(DicomTags.GridSpacingMaterial);
	}

	public static DecimalString newGridThickness() {
		return new DecimalString(DicomTags.GridThickness);
	}

	public static DecimalString newHalfValueLayer() {
		return new DecimalString(DicomTags.HalfValueLayer);
	}

	public static DateTime newHangingProtocolCreationDatetime() {
		return new DateTime(DicomTags.HangingProtocolCreationDatetime);
	}

	public static LongString newHangingProtocolCreator() {
		return new LongString(DicomTags.HangingProtocolCreator);
	}

	public static SequenceOfItems newHangingProtocolDefinitionSeq() {
		return new SequenceOfItems(DicomTags.HangingProtocolDefinitionSeq);
	}

	public static LongString newHangingProtocolDescription() {
		return new LongString(DicomTags.HangingProtocolDescription);
	}

	public static CodeString newHangingProtocolLevel() {
		return new CodeString(DicomTags.HangingProtocolLevel);
	}

	public static ShortString newHangingProtocolName() {
		return new ShortString(DicomTags.HangingProtocolName);
	}

	public static LongString newHangingProtocolUserGroupName() {
		return new LongString(DicomTags.HangingProtocolUserGroupName);
	}

	public static SequenceOfItems newHangingProtocolUserIdentificationCodeSeq() {
		return new SequenceOfItems(
				DicomTags.HangingProtocolUserIdentificationCodeSeq);
	}

	public static LongString newHardcopyCreationDeviceID() {
		return new LongString(DicomTags.HardcopyCreationDeviceID);
	}

	public static LongString newHardcopyDeviceManfuacturerModelName() {
		return new LongString(DicomTags.HardcopyDeviceManfuacturerModelName);
	}

	public static LongString newHardcopyDeviceManufacturer() {
		return new LongString(DicomTags.HardcopyDeviceManufacturer);
	}

	public static LongString newHardcopyDeviceSoftwareVersion() {
		return new LongString(DicomTags.HardcopyDeviceSoftwareVersion);
	}

	public static IntegerString newHeartRate() {
		return new IntegerString(DicomTags.HeartRate);
	}

	public static UnsignedShort newHighBit() {
		return new UnsignedShort(DicomTags.HighBit);
	}

	public static IntegerString newHighRRValue() {
		return new IntegerString(DicomTags.HighRRValue);
	}

	public static UnsignedShort newHistogramBinWidth() {
		return new UnsignedShort(DicomTags.HistogramBinWidth);
	}

	public static UnsignedLong newHistogramData() {
		return new UnsignedLong(DicomTags.HistogramData);
	}

	public static LongString newHistogramExplanation() {
		return new LongString(DicomTags.HistogramExplanation);
	}

	public static Unknown newHistogramFirstBinValue() {
		return new Unknown(DicomTags.HistogramFirstBinValue);
	}

	public static Unknown newHistogramLastBinValue() {
		return new Unknown(DicomTags.HistogramLastBinValue);
	}

	public static UnsignedShort newHistogramNumberOfBins() {
		return new UnsignedShort(DicomTags.HistogramNumberOfBins);
	}

	public static SequenceOfItems newHistogramSeq() {
		return new SequenceOfItems(DicomTags.HistogramSeq);
	}

	public static FloatingPointSingle newHorizontalFieldOfView() {
		return new FloatingPointSingle(DicomTags.HorizontalFieldOfView);
	}

	public static SequenceOfItems newHumanPerformerCodeSeq() {
		return new SequenceOfItems(DicomTags.HumanPerformerCodeSeq);
	}

	public static PersonName newHumanPerformerName() {
		return new PersonName(DicomTags.HumanPerformerName);
	}

	public static LongString newHumanPerformerOrganization() {
		return new LongString(DicomTags.HumanPerformerOrganization);
	}

	public static SequenceOfItems newIconImageSeq() {
		return new SequenceOfItems(DicomTags.IconImageSeq);
	}

	public static SequenceOfItems newIdenticalDocumentsSeq() {
		return new SequenceOfItems(DicomTags.IdenticalDocumentsSeq);
	}

	public static UnsignedShort newIllumination() {
		return new UnsignedShort(DicomTags.Illumination);
	}

	public static SequenceOfItems newIlluminationTypeCodeSeq() {
		return new SequenceOfItems(DicomTags.IlluminationTypeCodeSeq);
	}

	public static DecimalString newImageAreaDoseProduct() {
		return new DecimalString(DicomTags.ImageAreaDoseProduct);
	}

	public static SequenceOfItems newImageBoxContentSeq() {
		return new SequenceOfItems(DicomTags.ImageBoxContentSeq);
	}

	public static SequenceOfItems newImageBoxesSeq() {
		return new SequenceOfItems(DicomTags.ImageBoxesSeq);
	}

	public static UnsignedShort newImageBoxLargeScrollAmount() {
		return new UnsignedShort(DicomTags.ImageBoxLargeScrollAmount);
	}

	public static CodeString newImageBoxLargeScrollType() {
		return new CodeString(DicomTags.ImageBoxLargeScrollType);
	}

	public static CodeString newImageBoxLayoutType() {
		return new CodeString(DicomTags.ImageBoxLayoutType);
	}

	public static UnsignedShort newImageBoxNumber() {
		return new UnsignedShort(DicomTags.ImageBoxNumber);
	}

	public static UnsignedShort newImageBoxOverlapPriority() {
		return new UnsignedShort(DicomTags.ImageBoxOverlapPriority);
	}

	public static CodeString newImageBoxPresentationLUTFlag() {
		return new CodeString(DicomTags.ImageBoxPresentationLUTFlag);
	}

	public static CodeString newImageBoxScrollDirection() {
		return new CodeString(DicomTags.ImageBoxScrollDirection);
	}

	public static UnsignedShort newImageBoxSmallScrollAmount() {
		return new UnsignedShort(DicomTags.ImageBoxSmallScrollAmount);
	}

	public static CodeString newImageBoxSmallScrollType() {
		return new CodeString(DicomTags.ImageBoxSmallScrollType);
	}

	public static UnsignedShort newImageBoxTileHorizontalDimension() {
		return new UnsignedShort(DicomTags.ImageBoxTileHorizontalDimension);
	}

	public static UnsignedShort newImageBoxTileVerticalDimension() {
		return new UnsignedShort(DicomTags.ImageBoxTileVerticalDimension);
	}

	public static SequenceOfItems newImageCenterPointCoordinatesSeq() {
		return new SequenceOfItems(DicomTags.ImageCenterPointCoordinatesSeq);
	}

	public static LongText newImageComments() {
		return new LongText(DicomTags.ImageComments);
	}

	public static Unknown newImageDimensionsRetired() {
		return new Unknown(DicomTags.ImageDimensionsRetired);
	}

	public static ShortText newImageDisplayFormat() {
		return new ShortText(DicomTags.ImageDisplayFormat);
	}

	public static ShortString newImagedNucleus() {
		return new ShortString(DicomTags.ImagedNucleus);
	}

	public static ShortString newImageFilter() {
		return new ShortString(DicomTags.ImageFilter);
	}

	public static Unknown newImageFormatRetired() {
		return new Unknown(DicomTags.ImageFormatRetired);
	}

	public static CodeString newImageGeometryTypeRetired() {
		return new CodeString(DicomTags.ImageGeometryTypeRetired);
	}

	public static CodeString newImageHorizontalFlip() {
		return new CodeString(DicomTags.ImageHorizontalFlip);
	}

	public static ShortString newImageID() {
		return new ShortString(DicomTags.ImageID);
	}

	public static UnsignedShort newImageIndex() {
		return new UnsignedShort(DicomTags.ImageIndex);
	}

	public static CodeString newImageLaterality() {
		return new CodeString(DicomTags.ImageLaterality);
	}

	public static Unknown newImageLocationRetired() {
		return new Unknown(DicomTags.ImageLocationRetired);
	}

	public static DecimalString newImageOrientation() {
		return new DecimalString(DicomTags.ImageOrientation);
	}

	public static DecimalString newImageOrientationRetired() {
		return new DecimalString(DicomTags.ImageOrientationRetired);
	}

	public static SequenceOfItems newImageOverlayBoxContentSeq() {
		return new SequenceOfItems(DicomTags.ImageOverlayBoxContentSeq);
	}

	public static CodeString newImageOverlayFlag() {
		return new CodeString(DicomTags.ImageOverlayFlag);
	}

	public static UnsignedShort newImagePathFilterPassBand() {
		return new UnsignedShort(DicomTags.ImagePathFilterPassBand);
	}

	public static UnsignedShort newImagePathFilterPassThroughWavelength() {
		return new UnsignedShort(DicomTags.ImagePathFilterPassThroughWavelength);
	}

	public static SequenceOfItems newImagePathFilterTypeStackCodeSeq() {
		return new SequenceOfItems(DicomTags.ImagePathFilterTypeStackCodeSeq);
	}

	public static DecimalString newImagePlanePixelSpacing() {
		return new DecimalString(DicomTags.ImagePlanePixelSpacing);
	}

	public static DecimalString newImagePosition() {
		return new DecimalString(DicomTags.ImagePosition);
	}

	public static UnsignedShort newImagePositionOnFilm() {
		return new UnsignedShort(DicomTags.ImagePositionOnFilm);
	}

	public static DecimalString newImagePositionRetired() {
		return new DecimalString(DicomTags.ImagePositionRetired);
	}

	public static UnsignedShort newImageRotation() {
		return new UnsignedShort(DicomTags.ImageRotation);
	}

	public static DecimalString newImagerPixelSpacing() {
		return new DecimalString(DicomTags.ImagerPixelSpacing);
	}

	public static LongString newImageSetLabel() {
		return new LongString(DicomTags.ImageSetLabel);
	}

	public static UnsignedShort newImageSetNumber() {
		return new UnsignedShort(DicomTags.ImageSetNumber);
	}

	public static CodeString newImageSetSelectorCategory() {
		return new CodeString(DicomTags.ImageSetSelectorCategory);
	}

	public static SequenceOfItems newImageSetSelectorSeq() {
		return new SequenceOfItems(DicomTags.ImageSetSelectorSeq);
	}

	public static CodeString newImageSetSelectorUsageFlag() {
		return new CodeString(DicomTags.ImageSetSelectorUsageFlag);
	}

	public static SequenceOfItems newImageSetsSeq() {
		return new SequenceOfItems(DicomTags.ImageSetsSeq);
	}

	public static IntegerString newImagesInAcquisition() {
		return new IntegerString(DicomTags.ImagesInAcquisition);
	}

	public static DecimalString newImageTransformationMatrix() {
		return new DecimalString(DicomTags.ImageTransformationMatrix);
	}

	public static DecimalString newImageTranslationVector() {
		return new DecimalString(DicomTags.ImageTranslationVector);
	}

	public static DecimalString newImageTriggerDelay() {
		return new DecimalString(DicomTags.ImageTriggerDelay);
	}

	public static CodeString newImageType() {
		return new CodeString(DicomTags.ImageType);
	}

	public static LongString newImagingDeviceSpecificAcquisitionParameters() {
		return new LongString(DicomTags.ImagingDeviceSpecificAcquisitionParameters);
	}

	public static DecimalString newImagingFrequency() {
		return new DecimalString(DicomTags.ImagingFrequency);
	}

	public static LongText newImagingServiceRequestComments() {
		return new LongText(DicomTags.ImagingServiceRequestComments);
	}

	public static CodeString newImplantPresent() {
		return new CodeString(DicomTags.ImplantPresent);
	}

	public static UniqueIdentifier newImplementationClassUID() {
		return new UniqueIdentifier(DicomTags.ImplementationClassUID);
	}

	public static ShortString newImplementationVersionName() {
		return new ShortString(DicomTags.ImplementationVersionName);
	}

	public static ShortText newImpressions() {
		return new ShortText(DicomTags.Impressions);
	}

	public static CodeString newIncludeDisplayApplication() {
		return new CodeString(DicomTags.IncludeDisplayApplication);
	}

	public static CodeString newIncludeNonDICOMObjects() {
		return new CodeString(DicomTags.IncludeNonDICOMObjects);
	}

	public static UnsignedShort newInConcatenationNumber() {
		return new UnsignedShort(DicomTags.InConcatenationNumber);
	}

	public static UnsignedShort newInConcatenationTotalNumber() {
		return new UnsignedShort(DicomTags.InConcatenationTotalNumber);
	}

	public static Unknown newInitiatorRetired() {
		return new Unknown(DicomTags.InitiatorRetired);
	}

	public static CodeString newInPlanePhaseEncodingDirection() {
		return new CodeString(DicomTags.InPlanePhaseEncodingDirection);
	}

	public static CodeString newInputAvailabilityFlag() {
		return new CodeString(DicomTags.InputAvailabilityFlag);
	}

	public static SequenceOfItems newInputInformationSeq() {
		return new SequenceOfItems(DicomTags.InputInformationSeq);
	}

	public static UnsignedLong newInStackPositionNumber() {
		return new UnsignedLong(DicomTags.InStackPositionNumber);
	}

	public static CodeString newInstanceAvailability() {
		return new CodeString(DicomTags.InstanceAvailability);
	}

	public static DateElement newInstanceCreationDate() {
		return new DateElement(DicomTags.InstanceCreationDate);
	}

	public static Time newInstanceCreationTime() {
		return new Time(DicomTags.InstanceCreationTime);
	}

	public static UniqueIdentifier newInstanceCreatorUID() {
		return new UniqueIdentifier(DicomTags.InstanceCreatorUID);
	}

	public static UnsignedLong newInstanceGroupLength() {
		return new UnsignedLong(DicomTags.InstanceGroupLength);
	}

	public static IntegerString newInstanceNumber() {
		return new IntegerString(DicomTags.InstanceNumber);
	}

	public static ShortText newInstitutionAddress() {
		return new ShortText(DicomTags.InstitutionAddress);
	}

	public static LongString newInstitutionalDepartmentName() {
		return new LongString(DicomTags.InstitutionalDepartmentName);
	}

	public static SequenceOfItems newInstitutionCodeSeq() {
		return new SequenceOfItems(DicomTags.InstitutionCodeSeq);
	}

	public static LongString newInstitutionName() {
		return new LongString(DicomTags.InstitutionName);
	}

	public static LongString newInsurancePlanIdentificationRetired() {
		return new LongString(DicomTags.InsurancePlanIdentificationRetired);
	}

	public static SequenceOfItems newIntendedRecipientsOfResultsIdentificationSeq() {
		return new SequenceOfItems(
				DicomTags.IntendedRecipientsOfResultsIdentificationSeq);
	}

	public static DecimalString newIntensifierSize() {
		return new DecimalString(DicomTags.IntensifierSize);
	}

	public static DecimalString newInterMarkerDistance() {
		return new DecimalString(DicomTags.InterMarkerDistance);
	}

	public static DateElement newInterpretationApprovalDate() {
		return new DateElement(DicomTags.InterpretationApprovalDate);
	}

	public static Time newInterpretationApprovalTime() {
		return new Time(DicomTags.InterpretationApprovalTime);
	}

	public static SequenceOfItems newInterpretationApproverSeq() {
		return new SequenceOfItems(DicomTags.InterpretationApproverSeq);
	}

	public static PersonName newInterpretationAuthor() {
		return new PersonName(DicomTags.InterpretationAuthor);
	}

	public static SequenceOfItems newInterpretationDiagnosisCodeSeq() {
		return new SequenceOfItems(DicomTags.InterpretationDiagnosisCodeSeq);
	}

	public static LongText newInterpretationDiagnosisDescription() {
		return new LongText(DicomTags.InterpretationDiagnosisDescription);
	}

	public static ShortString newInterpretationID() {
		return new ShortString(DicomTags.InterpretationID);
	}

	public static LongString newInterpretationIDIssuer() {
		return new LongString(DicomTags.InterpretationIDIssuer);
	}

	public static DateElement newInterpretationRecordedDate() {
		return new DateElement(DicomTags.InterpretationRecordedDate);
	}

	public static Time newInterpretationRecordedTime() {
		return new Time(DicomTags.InterpretationRecordedTime);
	}

	public static PersonName newInterpretationRecorder() {
		return new PersonName(DicomTags.InterpretationRecorder);
	}

	public static CodeString newInterpretationStatusID() {
		return new CodeString(DicomTags.InterpretationStatusID);
	}

	public static ShortText newInterpretationText() {
		return new ShortText(DicomTags.InterpretationText);
	}

	public static PersonName newInterpretationTranscriber() {
		return new PersonName(DicomTags.InterpretationTranscriber);
	}

	public static DateElement newInterpretationTranscriptionDate() {
		return new DateElement(DicomTags.InterpretationTranscriptionDate);
	}

	public static Time newInterpretationTranscriptionTime() {
		return new Time(DicomTags.InterpretationTranscriptionTime);
	}

	public static CodeString newInterpretationTypeID() {
		return new CodeString(DicomTags.InterpretationTypeID);
	}

	public static IntegerString newIntervalNumberRetired() {
		return new IntegerString(DicomTags.IntervalNumberRetired);
	}

	public static IntegerString newIntervalsAcquired() {
		return new IntegerString(DicomTags.IntervalsAcquired);
	}

	public static IntegerString newIntervalsRejected() {
		return new IntegerString(DicomTags.IntervalsRejected);
	}

	public static CodeString newInterventionalStatus() {
		return new CodeString(DicomTags.InterventionalStatus);
	}

	public static SequenceOfItems newInterventionalTherapySeq() {
		return new SequenceOfItems(DicomTags.InterventionalTherapySeq);
	}

	public static SequenceOfItems newInterventionDrugCodeSeq() {
		return new SequenceOfItems(DicomTags.InterventionDrugCodeSeq);
	}

	public static DecimalString newInterventionDrugDose() {
		return new DecimalString(DicomTags.InterventionDrugDose);
	}

	public static SequenceOfItems newInterventionDrugInformationSeq() {
		return new SequenceOfItems(DicomTags.InterventionDrugInformationSeq);
	}

	public static LongString newInterventionDrugName() {
		return new LongString(DicomTags.InterventionDrugName);
	}

	public static Time newInterventionDrugStartTime() {
		return new Time(DicomTags.InterventionDrugStartTime);
	}

	public static Time newInterventionDrugStopTime() {
		return new Time(DicomTags.InterventionDrugStopTime);
	}

	public static FloatingPointSingle newIntraOcularPressure() {
		return new FloatingPointSingle(DicomTags.IntraOcularPressure);
	}

	public static CodeString newInversionRecovery() {
		return new CodeString(DicomTags.InversionRecovery);
	}

	public static DecimalString newInversionTime() {
		return new DecimalString(DicomTags.InversionTime);
	}

	public static FloatingPointDouble newInversionTimes() {
		return new FloatingPointDouble(DicomTags.InversionTimes);
	}

	public static DecimalString newIsocenterPosition() {
		return new DecimalString(DicomTags.IsocenterPosition);
	}

	public static IntegerString newIsotopeNumberRetired() {
		return new IntegerString(DicomTags.IsotopeNumberRetired);
	}

	public static DateElement newIssueDateOfImagingServiceRequest() {
		return new DateElement(DicomTags.IssueDateOfImagingServiceRequest);
	}

	public static LongString newIssuerOfAdmissionID() {
		return new LongString(DicomTags.IssuerOfAdmissionID);
	}

	public static LongString newIssuerOfPatientID() {
		return new LongString(DicomTags.IssuerOfPatientID);
	}

	public static Time newIssueTimeOfImagingServiceRequest() {
		return new Time(DicomTags.IssueTimeOfImagingServiceRequest);
	}

	public static Unknown newItem() {
		return new Unknown(DicomTags.Item);
	}

	public static Unknown newItemDelimitationItem() {
		return new Unknown(DicomTags.ItemDelimitationItem);
	}

	public static IntegerString newItemNumber() {
		return new IntegerString(DicomTags.ItemNumber);
	}

	public static DecimalString newIVUSGatedRate() {
		return new DecimalString(DicomTags.IVUSGatedRate);
	}

	public static IntegerString newIVUSPullbackStopFrameNumber() {
		return new IntegerString(DicomTags.IVUSPullbackStopFrameNumber);
	}

	public static CodeString newKSpaceFiltering() {
		return new CodeString(DicomTags.KSpaceFiltering);
	}

	public static DecimalString newKVP() {
		return new DecimalString(DicomTags.KVP);
	}

	public static CodeString newLabelStyleSelection() {
		return new CodeString(DicomTags.LabelStyleSelection);
	}

	public static UnlimitedText newLabelText() {
		return new UnlimitedText(DicomTags.LabelText);
	}

	public static CodeString newLabelUsingInformationExtractedFromInstances() {
		return new CodeString(DicomTags.LabelUsingInformationExtractedFromInstances);
	}

	public static Unknown newLargestImagePixelValue() {
		return new Unknown(DicomTags.LargestImagePixelValue);
	}

	public static Unknown newLargestImagePixelValueInPlane() {
		return new Unknown(DicomTags.LargestImagePixelValueInPlane);
	}

	public static UnsignedShort newLargestMonochromePixelValue() {
		return new UnsignedShort(DicomTags.LargestMonochromePixelValue);
	}

	public static Unknown newLargestPixelValueInSeries() {
		return new Unknown(DicomTags.LargestPixelValueInSeries);
	}

	public static Unknown newLargestValidPixelValueRetired() {
		return new Unknown(DicomTags.LargestValidPixelValueRetired);
	}

	public static DateElement newLastMenstrualDate() {
		return new DateElement(DicomTags.LastMenstrualDate);
	}

	public static CodeString newLaterality() {
		return new CodeString(DicomTags.Laterality);
	}

	public static DecimalString newLeafJawPositions() {
		return new DecimalString(DicomTags.LeafJawPositions);
	}

	public static DecimalString newLeafPositionBoundaries() {
		return new DecimalString(DicomTags.LeafPositionBoundaries);
	}

	public static SequenceOfItems newLeftImageSeq() {
		return new SequenceOfItems(DicomTags.LeftImageSeq);
	}

	public static Unknown newLengthToEndRetired() {
		return new Unknown(DicomTags.LengthToEndRetired);
	}

	public static SequenceOfItems newLensesCodeSeq() {
		return new SequenceOfItems(DicomTags.LensesCodeSeq);
	}

	public static IntegerString newLesionNumber() {
		return new IntegerString(DicomTags.LesionNumber);
	}

	public static UnsignedShort newLightPathFilterPassBand() {
		return new UnsignedShort(DicomTags.LightPathFilterPassBand);
	}

	public static UnsignedShort newLightPathFilterPassThroughWavelength() {
		return new UnsignedShort(DicomTags.LightPathFilterPassThroughWavelength);
	}

	public static SequenceOfItems newLightPathFilterTypeStackCodeSeq() {
		return new SequenceOfItems(DicomTags.LightPathFilterTypeStackCodeSeq);
	}

	public static Unknown newLocationRetired() {
		return new Unknown(DicomTags.LocationRetired);
	}

	public static CodeString newLossyImageCompression() {
		return new CodeString(DicomTags.LossyImageCompression);
	}

	public static CodeString newLossyImageCompressionMethod() {
		return new CodeString(DicomTags.LossyImageCompressionMethod);
	}

	public static DecimalString newLossyImageCompressionRatio() {
		return new DecimalString(DicomTags.LossyImageCompressionRatio);
	}

	public static CodeString newLossyImageCompressionRetired() {
		return new CodeString(DicomTags.LossyImageCompressionRetired);
	}

	public static IntegerString newLowRRValue() {
		return new IntegerString(DicomTags.LowRRValue);
	}

	public static Unknown newLUTData() {
		return new Unknown(DicomTags.LUTData);
	}

	public static Unknown newLUTDescriptor() {
		return new Unknown(DicomTags.LUTDescriptor);
	}

	public static LongString newLUTExplanation() {
		return new LongString(DicomTags.LUTExplanation);
	}

	public static ShortString newLUTLabel() {
		return new ShortString(DicomTags.LUTLabel);
	}

	public static IntegerString newLUTNumber() {
		return new IntegerString(DicomTags.LUTNumber);
	}

	public static DecimalString newMagneticFieldStrength() {
		return new DecimalString(DicomTags.MagneticFieldStrength);
	}

	public static CodeString newMagnetizationTransfer() {
		return new CodeString(DicomTags.MagnetizationTransfer);
	}

	public static CodeString newMagnificationType() {
		return new CodeString(DicomTags.MagnificationType);
	}

	public static Unknown newMagnificationTypeRetired() {
		return new Unknown(DicomTags.MagnificationTypeRetired);
	}

	public static UnsignedShort newMagnifyToNumberOfColumns() {
		return new UnsignedShort(DicomTags.MagnifyToNumberOfColumns);
	}

	public static Unknown newManipulatedImageRetired() {
		return new Unknown(DicomTags.ManipulatedImageRetired);
	}

	public static LongString newManufacturer() {
		return new LongString(DicomTags.Manufacturer);
	}

	public static LongString newManufacturerModelName() {
		return new LongString(DicomTags.ManufacturerModelName);
	}

	public static CodeString newMappingResource() {
		return new CodeString(DicomTags.MappingResource);
	}

	public static UnsignedShort newMaskFrameNumbers() {
		return new UnsignedShort(DicomTags.MaskFrameNumbers);
	}

	public static CodeString newMaskingImageRetired() {
		return new CodeString(DicomTags.MaskingImageRetired);
	}

	public static CodeString newMaskOperation() {
		return new CodeString(DicomTags.MaskOperation);
	}

	public static ShortText newMaskOperationExplanation() {
		return new ShortText(DicomTags.MaskOperationExplanation);
	}

	public static UnsignedShort newMaskPointer() {
		return new UnsignedShort(DicomTags.MaskPointer);
	}

	public static FloatingPointSingle newMaskSubPixelShift() {
		return new FloatingPointSingle(DicomTags.MaskSubPixelShift);
	}

	public static SequenceOfItems newMaskSubtractionSeq() {
		return new SequenceOfItems(DicomTags.MaskSubtractionSeq);
	}

	public static ShortString newMaterialID() {
		return new ShortString(DicomTags.MaterialID);
	}

	public static SequenceOfItems newMatrixRegistrationSeq() {
		return new SequenceOfItems(DicomTags.MatrixRegistrationSeq);
	}

	public static SequenceOfItems newMatrixSeq() {
		return new SequenceOfItems(DicomTags.MatrixSeq);
	}

	public static UnsignedShort newMaxDensity() {
		return new UnsignedShort(DicomTags.MaxDensity);
	}

	public static IntegerString newMaximumCollatedFilms() {
		return new IntegerString(DicomTags.MaximumCollatedFilms);
	}

	public static IntegerString newMaximumMemoryAllocation() {
		return new IntegerString(DicomTags.MaximumMemoryAllocation);
	}

	public static ShortText newMeasuredDoseDescription() {
		return new ShortText(DicomTags.MeasuredDoseDescription);
	}

	public static IntegerString newMeasuredDoseReferenceNumber() {
		return new IntegerString(DicomTags.MeasuredDoseReferenceNumber);
	}

	public static SequenceOfItems newMeasuredDoseReferenceSeq() {
		return new SequenceOfItems(DicomTags.MeasuredDoseReferenceSeq);
	}

	public static CodeString newMeasuredDoseType() {
		return new CodeString(DicomTags.MeasuredDoseType);
	}

	public static DecimalString newMeasuredDoseValue() {
		return new DecimalString(DicomTags.MeasuredDoseValue);
	}

	public static SequenceOfItems newMeasuredValueSeq() {
		return new SequenceOfItems(DicomTags.MeasuredValueSeq);
	}

	public static SequenceOfItems newMeasurementUnitsCodeSeq() {
		return new SequenceOfItems(DicomTags.MeasurementUnitsCodeSeq);
	}

	public static SequenceOfItems newMeasuringUnitsSeq() {
		return new SequenceOfItems(DicomTags.MeasuringUnitsSeq);
	}

	public static DecimalString newMechanicalIndex() {
		return new DecimalString(DicomTags.MechanicalIndex);
	}

	public static LongText newMediaDisposition() {
		return new LongText(DicomTags.MediaDisposition);
	}

	public static SequenceOfItems newMediaInstalledSeq() {
		return new SequenceOfItems(DicomTags.MediaInstalledSeq);
	}

	public static UniqueIdentifier newMediaStorageSOPClassUID() {
		return new UniqueIdentifier(DicomTags.MediaStorageSOPClassUID);
	}

	public static UniqueIdentifier newMediaStorageSOPInstanceUID() {
		return new UniqueIdentifier(DicomTags.MediaStorageSOPInstanceUID);
	}

	public static LongString newMedicalAlerts() {
		return new LongString(DicomTags.MedicalAlerts);
	}

	public static LongString newMedicalRecordLocator() {
		return new LongString(DicomTags.MedicalRecordLocator);
	}

	public static CodeString newMediumType() {
		return new CodeString(DicomTags.MediumType);
	}

	public static IntegerString newMemoryAllocation() {
		return new IntegerString(DicomTags.MemoryAllocation);
	}

	public static UnsignedShort newMemoryBitDepth() {
		return new UnsignedShort(DicomTags.MemoryBitDepth);
	}

	public static UnsignedShort newMessageID() {
		return new UnsignedShort(DicomTags.MessageID);
	}

	public static UnsignedShort newMessageIDBeingRespondedTo() {
		return new UnsignedShort(DicomTags.MessageIDBeingRespondedTo);
	}

	public static Unknown newMessageSetIDRetired() {
		return new Unknown(DicomTags.MessageSetIDRetired);
	}

	public static ShortText newMetaboliteMapDescription() {
		return new ShortText(DicomTags.MetaboliteMapDescription);
	}

	public static DecimalString newMetersetExposure() {
		return new DecimalString(DicomTags.MetersetExposure);
	}

	public static FloatingPointDouble newMidSlabPosition() {
		return new FloatingPointDouble(DicomTags.MidSlabPosition);
	}

	public static LongString newMilitaryRank() {
		return new LongString(DicomTags.MilitaryRank);
	}

	public static LongString newMIMETypeOfEncapsulatedDocument() {
		return new LongString(DicomTags.MIMETypeOfEncapsulatedDocument);
	}

	public static UnsignedShort newMinDensity() {
		return new UnsignedShort(DicomTags.MinDensity);
	}

	public static CodeString newModalitiesInStudy() {
		return new CodeString(DicomTags.ModalitiesInStudy);
	}

	public static CodeString newModality() {
		return new CodeString(DicomTags.Modality);
	}

	public static SequenceOfItems newModalityLUTSeq() {
		return new SequenceOfItems(DicomTags.ModalityLUTSeq);
	}

	public static LongString newModalityLUTType() {
		return new LongString(DicomTags.ModalityLUTType);
	}

	public static SequenceOfItems newModifiedAttributesSeq() {
		return new SequenceOfItems(DicomTags.ModifiedAttributesSeq);
	}

	public static DateElement newModifiedImageDateRetired() {
		return new DateElement(DicomTags.ModifiedImageDateRetired);
	}

	public static LongString newModifiedImageDescriptionRetired() {
		return new LongString(DicomTags.ModifiedImageDescriptionRetired);
	}

	public static ShortString newModifiedImageIDRetired() {
		return new ShortString(DicomTags.ModifiedImageIDRetired);
	}

	public static Time newModifiedImageTimeRetired() {
		return new Time(DicomTags.ModifiedImageTimeRetired);
	}

	public static SequenceOfItems newModifierCodeSeq() {
		return new SequenceOfItems(DicomTags.ModifierCodeSeq);
	}

	public static ShortString newModifyingDeviceIDRetired() {
		return new ShortString(DicomTags.ModifyingDeviceIDRetired);
	}

	public static LongString newModifyingDeviceManufacturerRetired() {
		return new LongString(DicomTags.ModifyingDeviceManufacturerRetired);
	}

	public static DateElement newMostRecentTreatmentDate() {
		return new DateElement(DicomTags.MostRecentTreatmentDate);
	}

	public static ApplicationEntity newMoveDestination() {
		return new ApplicationEntity(DicomTags.MoveDestination);
	}

	public static ApplicationEntity newMoveOriginatorAET() {
		return new ApplicationEntity(DicomTags.MoveOriginatorAET);
	}

	public static UnsignedShort newMoveOriginatorMessageID() {
		return new UnsignedShort(DicomTags.MoveOriginatorMessageID);
	}

	public static UnsignedShort newMRAcquisitionFrequencyEncodingSteps() {
		return new UnsignedShort(DicomTags.MRAcquisitionFrequencyEncodingSteps);
	}

	public static UnsignedShort newMRAcquisitionPhaseEncodingStepsInPlane() {
		return new UnsignedShort(DicomTags.MRAcquisitionPhaseEncodingStepsInPlane);
	}

	public static UnsignedShort newMRAcquisitionPhaseEncodingStepsOutOfPlane() {
		return new UnsignedShort(
				DicomTags.MRAcquisitionPhaseEncodingStepsOutOfPlane);
	}

	public static CodeString newMRAcquisitionType() {
		return new CodeString(DicomTags.MRAcquisitionType);
	}

	public static SequenceOfItems newMRAveragesSeq() {
		return new SequenceOfItems(DicomTags.MRAveragesSeq);
	}

	public static SequenceOfItems newMRDiffusionSeq() {
		return new SequenceOfItems(DicomTags.MRDiffusionSeq);
	}

	public static UnsignedLong newMRDRDirectoryRecordOffset() {
		return new UnsignedLong(DicomTags.MRDRDirectoryRecordOffset);
	}

	public static SequenceOfItems newMREchoSeq() {
		return new SequenceOfItems(DicomTags.MREchoSeq);
	}

	public static SequenceOfItems newMRFOVGeometrySeq() {
		return new SequenceOfItems(DicomTags.MRFOVGeometrySeq);
	}

	public static SequenceOfItems newMRImageFrameTypeSeq() {
		return new SequenceOfItems(DicomTags.MRImageFrameTypeSeq);
	}

	public static SequenceOfItems newMRImagingModifierSeq() {
		return new SequenceOfItems(DicomTags.MRImagingModifierSeq);
	}

	public static SequenceOfItems newMRMetaboliteMapSeq() {
		return new SequenceOfItems(DicomTags.MRMetaboliteMapSeq);
	}

	public static SequenceOfItems newMRModifierSeq() {
		return new SequenceOfItems(DicomTags.MRModifierSeq);
	}

	public static SequenceOfItems newMRReceiveCoilSeq() {
		return new SequenceOfItems(DicomTags.MRReceiveCoilSeq);
	}

	public static SequenceOfItems newMRSpatialSaturationSeq() {
		return new SequenceOfItems(DicomTags.MRSpatialSaturationSeq);
	}

	public static CodeString newMRSpectroscopyAcquisitionType() {
		return new CodeString(DicomTags.MRSpectroscopyAcquisitionType);
	}

	public static SequenceOfItems newMRSpectroscopyFOVGeometrySeq() {
		return new SequenceOfItems(DicomTags.MRSpectroscopyFOVGeometrySeq);
	}

	public static SequenceOfItems newMRSpectroscopyFrameTypeSeq() {
		return new SequenceOfItems(DicomTags.MRSpectroscopyFrameTypeSeq);
	}

	public static SequenceOfItems newMRTimingAndRelatedParametersSeq() {
		return new SequenceOfItems(DicomTags.MRTimingAndRelatedParametersSeq);
	}

	public static SequenceOfItems newMRTransmitCoilSeq() {
		return new SequenceOfItems(DicomTags.MRTransmitCoilSeq);
	}

	public static SequenceOfItems newMRVelocityEncodingSeq() {
		return new SequenceOfItems(DicomTags.MRVelocityEncodingSeq);
	}

	public static LongString newMultiCoilConfiguration() {
		return new LongString(DicomTags.MultiCoilConfiguration);
	}

	public static SequenceOfItems newMultiCoilDefinitionSeq() {
		return new SequenceOfItems(DicomTags.MultiCoilDefinitionSeq);
	}

	public static ShortString newMultiCoilElementName() {
		return new ShortString(DicomTags.MultiCoilElementName);
	}

	public static CodeString newMultiCoilElementUsed() {
		return new CodeString(DicomTags.MultiCoilElementUsed);
	}

	public static CodeString newMultiPlanarExcitation() {
		return new CodeString(DicomTags.MultiPlanarExcitation);
	}

	public static CodeString newMultipleCopiesFlag() {
		return new CodeString(DicomTags.MultipleCopiesFlag);
	}

	public static CodeString newMultipleSpinEcho() {
		return new CodeString(DicomTags.MultipleSpinEcho);
	}

	public static SequenceOfItems newMultiplexedAudioChannelsDescriptionCodeSeq() {
		return new SequenceOfItems(
				DicomTags.MultiplexedAudioChannelsDescriptionCodeSeq);
	}

	public static ShortString newMultiplexGroupLabel() {
		return new ShortString(DicomTags.MultiplexGroupLabel);
	}

	public static DecimalString newMultiplexGroupTimeOffset() {
		return new DecimalString(DicomTags.MultiplexGroupTimeOffset);
	}

	public static SequenceOfItems newMydriaticAgentCodeSeq() {
		return new SequenceOfItems(DicomTags.MydriaticAgentCodeSeq);
	}

	public static PersonName newNameOfPhysicianReadingStudy() {
		return new PersonName(DicomTags.NameOfPhysicianReadingStudy);
	}

	public static PersonName newNamesOfIntendedRecipientsOfResults() {
		return new PersonName(DicomTags.NamesOfIntendedRecipientsOfResults);
	}

	public static UnsignedShort newNavigationDisplaySet() {
		return new UnsignedShort(DicomTags.NavigationDisplaySet);
	}

	public static SequenceOfItems newNavigationIndicatorSeq() {
		return new SequenceOfItems(DicomTags.NavigationIndicatorSeq);
	}

	public static Unknown newNetworkIDRetired() {
		return new Unknown(DicomTags.NetworkIDRetired);
	}

	public static DecimalString newNominalBeamEnergy() {
		return new DecimalString(DicomTags.NominalBeamEnergy);
	}

	public static CodeString newNominalBeamEnergyUnit() {
		return new CodeString(DicomTags.NominalBeamEnergyUnit);
	}

	public static IntegerString newNominalInterval() {
		return new IntegerString(DicomTags.NominalInterval);
	}

	public static DecimalString newNominalPriorDose() {
		return new DecimalString(DicomTags.NominalPriorDose);
	}

	public static SequenceOfItems newNominalScreenDefinitionSeq() {
		return new SequenceOfItems(DicomTags.NominalScreenDefinitionSeq);
	}

	public static SequenceOfItems newNonDICOMOutputCodeSeq() {
		return new SequenceOfItems(DicomTags.NonDICOMOutputCodeSeq);
	}

	public static DecimalString newNormalizationPoint() {
		return new DecimalString(DicomTags.NormalizationPoint);
	}

	public static Unknown newNorRevRetired() {
		return new Unknown(DicomTags.NorRevRetired);
	}

	public static DecimalString newNotchFilterBandwidth() {
		return new DecimalString(DicomTags.NotchFilterBandwidth);
	}

	public static DecimalString newNotchFilterFrequency() {
		return new DecimalString(DicomTags.NotchFilterFrequency);
	}

	public static CodeString newNuclearMedicineSeriesTypeRetired() {
		return new CodeString(DicomTags.NuclearMedicineSeriesTypeRetired);
	}

	public static DecimalString newNumberOfAverages() {
		return new DecimalString(DicomTags.NumberOfAverages);
	}

	public static IntegerString newNumberOfBeams() {
		return new IntegerString(DicomTags.NumberOfBeams);
	}

	public static IntegerString newNumberOfBlocks() {
		return new IntegerString(DicomTags.NumberOfBlocks);
	}

	public static IntegerString newNumberOfBoli() {
		return new IntegerString(DicomTags.NumberOfBoli);
	}

	public static IntegerString newNumberOfBrachyApplicationSetups() {
		return new IntegerString(DicomTags.NumberOfBrachyApplicationSetups);
	}

	public static IntegerString newNumberOfCompensators() {
		return new IntegerString(DicomTags.NumberOfCompensators);
	}

	public static UnsignedShort newNumberOfCompletedSubOperations() {
		return new UnsignedShort(DicomTags.NumberOfCompletedSubOperations);
	}

	public static IntegerString newNumberOfContourPoints() {
		return new IntegerString(DicomTags.NumberOfContourPoints);
	}

	public static IntegerString newNumberOfControlPoints() {
		return new IntegerString(DicomTags.NumberOfControlPoints);
	}

	public static IntegerString newNumberOfCopies() {
		return new IntegerString(DicomTags.NumberOfCopies);
	}

	public static UnsignedShort newNumberOfDetectors() {
		return new UnsignedShort(DicomTags.NumberOfDetectors);
	}

	public static UnsignedShort newNumberOfEnergyWindows() {
		return new UnsignedShort(DicomTags.NumberOfEnergyWindows);
	}

	public static IntegerString newNumberOfEventTimers() {
		return new IntegerString(DicomTags.NumberOfEventTimers);
	}

	public static UnsignedShort newNumberOfFailedSubOperations() {
		return new UnsignedShort(DicomTags.NumberOfFailedSubOperations);
	}

	public static IntegerString newNumberOfFilms() {
		return new IntegerString(DicomTags.NumberOfFilms);
	}

	public static IntegerString newNumberOfFractionsDelivered() {
		return new IntegerString(DicomTags.NumberOfFractionsDelivered);
	}

	public static IntegerString newNumberOfFractionsPerDay() {
		return new IntegerString(DicomTags.NumberOfFractionsPerDay);
	}

	public static IntegerString newNumberOfFractionsPlanned() {
		return new IntegerString(DicomTags.NumberOfFractionsPlanned);
	}

	public static IntegerString newNumberOfFrames() {
		return new IntegerString(DicomTags.NumberOfFrames);
	}

	public static UnsignedShort newNumberOfFramesInPhase() {
		return new UnsignedShort(DicomTags.NumberOfFramesInPhase);
	}

	public static UnsignedShort newNumberOfFramesInRotation() {
		return new UnsignedShort(DicomTags.NumberOfFramesInRotation);
	}

	public static UnsignedShort newNumberOfGraphicPoints() {
		return new UnsignedShort(DicomTags.NumberOfGraphicPoints);
	}

	public static UnsignedShort newNumberOfHorizontalPixels() {
		return new UnsignedShort(DicomTags.NumberOfHorizontalPixels);
	}

	public static UnsignedShort newNumberOfKSpaceTrajectories() {
		return new UnsignedShort(DicomTags.NumberOfKSpaceTrajectories);
	}

	public static IntegerString newNumberOfLeafJawPairs() {
		return new IntegerString(DicomTags.NumberOfLeafJawPairs);
	}

	public static Unknown newNumberOfMatchesRetired() {
		return new Unknown(DicomTags.NumberOfMatchesRetired);
	}

	public static IntegerString newNumberOfPatientRelatedInstances() {
		return new IntegerString(DicomTags.NumberOfPatientRelatedInstances);
	}

	public static IntegerString newNumberOfPatientRelatedSeries() {
		return new IntegerString(DicomTags.NumberOfPatientRelatedSeries);
	}

	public static IntegerString newNumberOfPatientRelatedStudies() {
		return new IntegerString(DicomTags.NumberOfPatientRelatedStudies);
	}

	public static IntegerString newNumberOfPhaseEncodingSteps() {
		return new IntegerString(DicomTags.NumberOfPhaseEncodingSteps);
	}

	public static UnsignedShort newNumberOfPhases() {
		return new UnsignedShort(DicomTags.NumberOfPhases);
	}

	public static UnsignedShort newNumberOfPriorsReferenced() {
		return new UnsignedShort(DicomTags.NumberOfPriorsReferenced);
	}

	public static IntegerString newNumberOfPulses() {
		return new IntegerString(DicomTags.NumberOfPulses);
	}

	public static UnsignedLong newNumberOfReferences() {
		return new UnsignedLong(DicomTags.NumberOfReferences);
	}

	public static UnsignedShort newNumberOfRemainingSubOperations() {
		return new UnsignedShort(DicomTags.NumberOfRemainingSubOperations);
	}

	public static UnsignedShort newNumberOfRotations() {
		return new UnsignedShort(DicomTags.NumberOfRotations);
	}

	public static UnsignedShort newNumberOfRRIntervals() {
		return new UnsignedShort(DicomTags.NumberOfRRIntervals);
	}

	public static UnsignedShort newNumberOfScreens() {
		return new UnsignedShort(DicomTags.NumberOfScreens);
	}

	public static IntegerString newNumberOfSeriesRelatedInstances() {
		return new IntegerString(DicomTags.NumberOfSeriesRelatedInstances);
	}

	public static UnsignedShort newNumberOfSlices() {
		return new UnsignedShort(DicomTags.NumberOfSlices);
	}

	public static IntegerString newNumberOfStages() {
		return new IntegerString(DicomTags.NumberOfStages);
	}

	public static IntegerString newNumberOfStudyRelatedInstances() {
		return new IntegerString(DicomTags.NumberOfStudyRelatedInstances);
	}

	public static IntegerString newNumberOfStudyRelatedSeries() {
		return new IntegerString(DicomTags.NumberOfStudyRelatedSeries);
	}

	public static UnsignedLong newNumberOfTableBreakPoints() {
		return new UnsignedLong(DicomTags.NumberOfTableBreakPoints);
	}

	public static UnsignedLong newNumberOfTableEntries() {
		return new UnsignedLong(DicomTags.NumberOfTableEntries);
	}

	public static IntegerString newNumberOfTemporalPositions() {
		return new IntegerString(DicomTags.NumberOfTemporalPositions);
	}

	public static UnsignedShort newNumberOfTimeSlices() {
		return new UnsignedShort(DicomTags.NumberOfTimeSlices);
	}

	public static UnsignedShort newNumberOfTimeSlots() {
		return new UnsignedShort(DicomTags.NumberOfTimeSlots);
	}

	public static IntegerString newNumberofTomosynthesisSourceImages() {
		return new IntegerString(DicomTags.NumberofTomosynthesisSourceImages);
	}

	public static UnsignedShort newNumberOfTriggersInPhase() {
		return new UnsignedShort(DicomTags.NumberOfTriggersInPhase);
	}

	public static UnsignedShort newNumberOfVerticalPixels() {
		return new UnsignedShort(DicomTags.NumberOfVerticalPixels);
	}

	public static IntegerString newNumberOfViewsInStage() {
		return new IntegerString(DicomTags.NumberOfViewsInStage);
	}

	public static UnsignedShort newNumberOfWarningSubOperations() {
		return new UnsignedShort(DicomTags.NumberOfWarningSubOperations);
	}

	public static UnsignedShort newNumberOfWaveformChannels() {
		return new UnsignedShort(DicomTags.NumberOfWaveformChannels);
	}

	public static UnsignedLong newNumberOfWaveformSamples() {
		return new UnsignedLong(DicomTags.NumberOfWaveformSamples);
	}

	public static IntegerString newNumberOfWedges() {
		return new IntegerString(DicomTags.NumberOfWedges);
	}

	public static UnsignedShort newNumberOfZeroFills() {
		return new UnsignedShort(DicomTags.NumberOfZeroFills);
	}

	public static DecimalString newNumericValue() {
		return new DecimalString(DicomTags.NumericValue);
	}

	public static SequenceOfItems newNumericValueQualifierCodeSeq() {
		return new SequenceOfItems(DicomTags.NumericValueQualifierCodeSeq);
	}

	public static DateTime newObservationDateTime() {
		return new DateTime(DicomTags.ObservationDateTime);
	}

	public static IntegerString newObservationNumber() {
		return new IntegerString(DicomTags.ObservationNumber);
	}

	public static ShortString newOccupation() {
		return new ShortString(DicomTags.Occupation);
	}

	public static AttributeTag newOffendingElement() {
		return new AttributeTag(DicomTags.OffendingElement);
	}

	public static UnsignedLong newOffsetOfFirstRootDirectoryRecord() {
		return new UnsignedLong(DicomTags.OffsetOfFirstRootDirectoryRecord);
	}

	public static UnsignedLong newOffsetOfLastRootDirectoryRecord() {
		return new UnsignedLong(DicomTags.OffsetOfLastRootDirectoryRecord);
	}

	public static UnsignedLong newOffsetOfLowerLevelDirectoryEntity() {
		return new UnsignedLong(DicomTags.OffsetOfLowerLevelDirectoryEntity);
	}

	public static UnsignedLong newOffsetOfNextDirectoryRecord() {
		return new UnsignedLong(DicomTags.OffsetOfNextDirectoryRecord);
	}

	public static CodeString newOperatingMode() {
		return new CodeString(DicomTags.OperatingMode);
	}

	public static SequenceOfItems newOperatingModeSeq() {
		return new SequenceOfItems(DicomTags.OperatingModeSeq);
	}

	public static CodeString newOperatingModeType() {
		return new CodeString(DicomTags.OperatingModeType);
	}

	public static SequenceOfItems newOperatorIdentificationSeq() {
		return new SequenceOfItems(DicomTags.OperatorIdentificationSeq);
	}

	public static PersonName newOperatorName() {
		return new PersonName(DicomTags.OperatorName);
	}

	public static ShortString newOrderCallbackPhoneNumber() {
		return new ShortString(DicomTags.OrderCallbackPhoneNumber);
	}

	public static PersonName newOrderEnteredBy() {
		return new PersonName(DicomTags.OrderEnteredBy);
	}

	public static ShortString newOrderEntererLocation() {
		return new ShortString(DicomTags.OrderEntererLocation);
	}

	public static DecimalString newOrganAtRiskFullVolumeDose() {
		return new DecimalString(DicomTags.OrganAtRiskFullVolumeDose);
	}

	public static DecimalString newOrganAtRiskLimitDose() {
		return new DecimalString(DicomTags.OrganAtRiskLimitDose);
	}

	public static DecimalString newOrganAtRiskMaximumDose() {
		return new DecimalString(DicomTags.OrganAtRiskMaximumDose);
	}

	public static DecimalString newOrganAtRiskOverdoseVolumeFraction() {
		return new DecimalString(DicomTags.OrganAtRiskOverdoseVolumeFraction);
	}

	public static DecimalString newOrganDose() {
		return new DecimalString(DicomTags.OrganDose);
	}

	public static CodeString newOrganExposed() {
		return new CodeString(DicomTags.OrganExposed);
	}

	public static LongString newOriginalImageIdentificationNomenclatureRetired() {
		return new LongString(
				DicomTags.OriginalImageIdentificationNomenclatureRetired);
	}

	public static LongString newOriginalImageIdentificationRetired() {
		return new LongString(DicomTags.OriginalImageIdentificationRetired);
	}

	public static SequenceOfItems newOriginalImageSeq() {
		return new SequenceOfItems(DicomTags.OriginalImageSeq);
	}

	public static ApplicationEntity newOriginator() {
		return new ApplicationEntity(DicomTags.Originator);
	}

	public static CodeString newOtherMagnificationTypesAvailable() {
		return new CodeString(DicomTags.OtherMagnificationTypesAvailable);
	}

	public static SequenceOfItems newOtherMediaAvailableSeq() {
		return new SequenceOfItems(DicomTags.OtherMediaAvailableSeq);
	}

	public static LongString newOtherPatientIDs() {
		return new LongString(DicomTags.OtherPatientIDs);
	}

	public static PersonName newOtherPatientNames() {
		return new PersonName(DicomTags.OtherPatientNames);
	}

	public static CodeString newOtherSmoothingTypesAvailable() {
		return new CodeString(DicomTags.OtherSmoothingTypesAvailable);
	}

	public static IntegerString newOtherStudyNumbers() {
		return new IntegerString(DicomTags.OtherStudyNumbers);
	}

	public static SequenceOfItems newOutputInformationSeq() {
		return new SequenceOfItems(DicomTags.OutputInformationSeq);
	}

	public static ShortString newOutputPower() {
		return new ShortString(DicomTags.OutputPower);
	}

	public static CodeString newOverlayBackgroundDensity() {
		return new CodeString(DicomTags.OverlayBackgroundDensity);
	}

	public static DateElement newOverlayDate() {
		return new DateElement(DicomTags.OverlayDate);
	}

	public static CodeString newOverlayForegroundDensity() {
		return new CodeString(DicomTags.OverlayForegroundDensity);
	}

	public static CodeString newOverlayMagnificationType() {
		return new CodeString(DicomTags.OverlayMagnificationType);
	}

	public static CodeString newOverlayModeRetired() {
		return new CodeString(DicomTags.OverlayModeRetired);
	}

	public static IntegerString newOverlayNumber() {
		return new IntegerString(DicomTags.OverlayNumber);
	}

	public static CodeString newOverlayOrImageMagnification() {
		return new CodeString(DicomTags.OverlayOrImageMagnification);
	}

	public static SequenceOfItems newOverlayPixelDataSeq() {
		return new SequenceOfItems(DicomTags.OverlayPixelDataSeq);
	}

	public static CodeString newOverlaySmoothingType() {
		return new CodeString(DicomTags.OverlaySmoothingType);
	}

	public static Time newOverlayTime() {
		return new Time(DicomTags.OverlayTime);
	}

	public static AttributeTag newOverrideParameterPointer() {
		return new AttributeTag(DicomTags.OverrideParameterPointer);
	}

	public static ShortText newOverrideReason() {
		return new ShortText(DicomTags.OverrideReason);
	}

	public static SequenceOfItems newOverrideSeq() {
		return new SequenceOfItems(DicomTags.OverrideSeq);
	}

	public static CodeString newOversamplingPhase() {
		return new CodeString(DicomTags.OversamplingPhase);
	}

	public static ShortString newOwnerID() {
		return new ShortString(DicomTags.OwnerID);
	}

	public static Unknown newPagePositionIDRetired() {
		return new Unknown(DicomTags.PagePositionIDRetired);
	}

	public static UniqueIdentifier newPaletteColorLUTUID() {
		return new UniqueIdentifier(DicomTags.PaletteColorLUTUID);
	}

	public static CodeString newParallelAcquisition() {
		return new CodeString(DicomTags.ParallelAcquisition);
	}

	public static CodeString newParallelAcquisitionTechnique() {
		return new CodeString(DicomTags.ParallelAcquisitionTechnique);
	}

	public static FloatingPointDouble newParallelReductionFactorInPlane() {
		return new FloatingPointDouble(DicomTags.ParallelReductionFactorInPlane);
	}

	public static FloatingPointDouble newParallelReductionFactorOutOfPlane() {
		return new FloatingPointDouble(DicomTags.ParallelReductionFactorOutOfPlane);
	}

	public static FloatingPointDouble newParallelReductionFactorSecondInPlane() {
		return new FloatingPointDouble(
				DicomTags.ParallelReductionFactorSecondInPlane);
	}

	public static CodeString newPartialDataDisplayHandling() {
		return new CodeString(DicomTags.PartialDataDisplayHandling);
	}

	public static CodeString newPartialFourier() {
		return new CodeString(DicomTags.PartialFourier);
	}

	public static CodeString newPartialFourierDirection() {
		return new CodeString(DicomTags.PartialFourierDirection);
	}

	public static CodeString newPartialView() {
		return new CodeString(DicomTags.PartialView);
	}

	public static ShortText newPartialViewDescription() {
		return new ShortText(DicomTags.PartialViewDescription);
	}

	public static LongString newPatientAdditionalPosition() {
		return new LongString(DicomTags.PatientAdditionalPosition);
	}

	public static LongString newPatientAddress() {
		return new LongString(DicomTags.PatientAddress);
	}

	public static AgeString newPatientAge() {
		return new AgeString(DicomTags.PatientAge);
	}

	public static DateElement newPatientBirthDate() {
		return new DateElement(DicomTags.PatientBirthDate);
	}

	public static PersonName newPatientBirthName() {
		return new PersonName(DicomTags.PatientBirthName);
	}

	public static Time newPatientBirthTime() {
		return new Time(DicomTags.PatientBirthTime);
	}

	public static LongText newPatientComments() {
		return new LongText(DicomTags.PatientComments);
	}

	public static SequenceOfItems newPatientEyeMovementCommandCodeSeq() {
		return new SequenceOfItems(DicomTags.PatientEyeMovementCommandCodeSeq);
	}

	public static CodeString newPatientEyeMovementCommanded() {
		return new CodeString(DicomTags.PatientEyeMovementCommanded);
	}

	public static SequenceOfItems newPatientGantryRelationshipCodeSeq() {
		return new SequenceOfItems(DicomTags.PatientGantryRelationshipCodeSeq);
	}

	public static UnsignedLong newPatientGroupLength() {
		return new UnsignedLong(DicomTags.PatientGroupLength);
	}

	public static LongString newPatientID() {
		return new LongString(DicomTags.PatientID);
	}

	public static CodeString newPatientIdentityRemoved() {
		return new CodeString(DicomTags.PatientIdentityRemoved);
	}

	public static LongString newPatientInstitutionResidence() {
		return new LongString(DicomTags.PatientInstitutionResidence);
	}

	public static SequenceOfItems newPatientInsurancePlanCodeSeq() {
		return new SequenceOfItems(DicomTags.PatientInsurancePlanCodeSeq);
	}

	public static PersonName newPatientMotherBirthName() {
		return new PersonName(DicomTags.PatientMotherBirthName);
	}

	public static PersonName newPatientName() {
		return new PersonName(DicomTags.PatientName);
	}

	public static CodeString newPatientOrientation() {
		return new CodeString(DicomTags.PatientOrientation);
	}

	public static SequenceOfItems newPatientOrientationCodeSeq() {
		return new SequenceOfItems(DicomTags.PatientOrientationCodeSeq);
	}

	public static SequenceOfItems newPatientOrientationModifierCodeSeq() {
		return new SequenceOfItems(DicomTags.PatientOrientationModifierCodeSeq);
	}

	public static ShortString newPatientPhoneNumbers() {
		return new ShortString(DicomTags.PatientPhoneNumbers);
	}

	public static CodeString newPatientPosition() {
		return new CodeString(DicomTags.PatientPosition);
	}

	public static LongString newPatientReligiousPreference() {
		return new LongString(DicomTags.PatientReligiousPreference);
	}

	public static IntegerString newPatientSetupNumber() {
		return new IntegerString(DicomTags.PatientSetupNumber);
	}

	public static SequenceOfItems newPatientSetupSeq() {
		return new SequenceOfItems(DicomTags.PatientSetupSeq);
	}

	public static CodeString newPatientSex() {
		return new CodeString(DicomTags.PatientSex);
	}

	public static DecimalString newPatientSize() {
		return new DecimalString(DicomTags.PatientSize);
	}

	public static LongString newPatientState() {
		return new LongString(DicomTags.PatientState);
	}

	public static DecimalString newPatientSupportAngle() {
		return new DecimalString(DicomTags.PatientSupportAngle);
	}

	public static DecimalString newPatientSupportAngleTolerance() {
		return new DecimalString(DicomTags.PatientSupportAngleTolerance);
	}

	public static CodeString newPatientSupportRotationDirection() {
		return new CodeString(DicomTags.PatientSupportRotationDirection);
	}

	public static LongString newPatientTransportArrangements() {
		return new LongString(DicomTags.PatientTransportArrangements);
	}

	public static DecimalString newPatientWeight() {
		return new DecimalString(DicomTags.PatientWeight);
	}

	public static IntegerString newPauseBetweenFrames() {
		return new IntegerString(DicomTags.PauseBetweenFrames);
	}

	public static DecimalString newPercentPhaseFieldOfView() {
		return new DecimalString(DicomTags.PercentPhaseFieldOfView);
	}

	public static DecimalString newPercentSampling() {
		return new DecimalString(DicomTags.PercentSampling);
	}

	public static ShortString newPerformedLocation() {
		return new ShortString(DicomTags.PerformedLocation);
	}

	public static SequenceOfItems newPerformedProcedureCodeSeq() {
		return new SequenceOfItems(DicomTags.PerformedProcedureCodeSeq);
	}

	public static ShortText newPerformedProcedureStepComments() {
		return new ShortText(DicomTags.PerformedProcedureStepComments);
	}

	public static LongString newPerformedProcedureStepDescription() {
		return new LongString(DicomTags.PerformedProcedureStepDescription);
	}

	public static SequenceOfItems newPerformedProcedureStepDiscontinuationReasonCodeSeq() {
		return new SequenceOfItems(
				DicomTags.PerformedProcedureStepDiscontinuationReasonCodeSeq);
	}

	public static DateElement newPerformedProcedureStepEndDate() {
		return new DateElement(DicomTags.PerformedProcedureStepEndDate);
	}

	public static Time newPerformedProcedureStepEndTime() {
		return new Time(DicomTags.PerformedProcedureStepEndTime);
	}

	public static ShortString newPerformedProcedureStepID() {
		return new ShortString(DicomTags.PerformedProcedureStepID);
	}

	public static DateElement newPerformedProcedureStepStartDate() {
		return new DateElement(DicomTags.PerformedProcedureStepStartDate);
	}

	public static Time newPerformedProcedureStepStartTime() {
		return new Time(DicomTags.PerformedProcedureStepStartTime);
	}

	public static CodeString newPerformedProcedureStepStatus() {
		return new CodeString(DicomTags.PerformedProcedureStepStatus);
	}

	public static LongString newPerformedProcedureTypeDescription() {
		return new LongString(DicomTags.PerformedProcedureTypeDescription);
	}

	public static SequenceOfItems newPerformedProcessingApplicationsCodeSeq() {
		return new SequenceOfItems(DicomTags.PerformedProcessingApplicationsCodeSeq);
	}

	public static SequenceOfItems newPerformedProtocolCodeSeq() {
		return new SequenceOfItems(DicomTags.PerformedProtocolCodeSeq);
	}

	public static SequenceOfItems newPerformedSeriesSeq() {
		return new SequenceOfItems(DicomTags.PerformedSeriesSeq);
	}

	public static ApplicationEntity newPerformedStationAET() {
		return new ApplicationEntity(DicomTags.PerformedStationAET);
	}

	public static SequenceOfItems newPerformedStationClassCodeSeq() {
		return new SequenceOfItems(DicomTags.PerformedStationClassCodeSeq);
	}

	public static SequenceOfItems newPerformedStationGeographicLocationCodeSeq() {
		return new SequenceOfItems(
				DicomTags.PerformedStationGeographicLocationCodeSeq);
	}

	public static ShortString newPerformedStationName() {
		return new ShortString(DicomTags.PerformedStationName);
	}

	public static SequenceOfItems newPerformedStationNameCodeSeq() {
		return new SequenceOfItems(DicomTags.PerformedStationNameCodeSeq);
	}

	public static SequenceOfItems newPerformedWorkitemCodeSeq() {
		return new SequenceOfItems(DicomTags.PerformedWorkitemCodeSeq);
	}

	public static SequenceOfItems newPerformingPhysicianIdentificationSeq() {
		return new SequenceOfItems(DicomTags.PerformingPhysicianIdentificationSeq);
	}

	public static PersonName newPerformingPhysicianName() {
		return new PersonName(DicomTags.PerformingPhysicianName);
	}

	public static SequenceOfItems newPerFrameFunctionalGroupsSequence() {
		return new SequenceOfItems(DicomTags.PerFrameFunctionalGroupsSequence);
	}

	public static ShortText newPersonAddress() {
		return new ShortText(DicomTags.PersonAddress);
	}

	public static SequenceOfItems newPersonIdentificationCodeSeq() {
		return new SequenceOfItems(DicomTags.PersonIdentificationCodeSeq);
	}

	public static PersonName newPersonName() {
		return new PersonName(DicomTags.PersonName);
	}

	public static LongString newPersonTelephoneNumbers() {
		return new LongString(DicomTags.PersonTelephoneNumbers);
	}

	public static SequenceOfItems newPertinentOtherEvidenceSeq() {
		return new SequenceOfItems(DicomTags.PertinentOtherEvidenceSeq);
	}

	public static CodeString newPhaseContrast() {
		return new CodeString(DicomTags.PhaseContrast);
	}

	public static IntegerString newPhaseDelay() {
		return new IntegerString(DicomTags.PhaseDelay);
	}

	public static CodeString newPhaseDescription() {
		return new CodeString(DicomTags.PhaseDescription);
	}

	public static SequenceOfItems newPhaseInformationSeq() {
		return new SequenceOfItems(DicomTags.PhaseInformationSeq);
	}

	public static IntegerString newPhaseNumberRetired() {
		return new IntegerString(DicomTags.PhaseNumberRetired);
	}

	public static UnsignedShort newPhaseVector() {
		return new UnsignedShort(DicomTags.PhaseVector);
	}

	public static LongString newPhosphorType() {
		return new LongString(DicomTags.PhosphorType);
	}

	public static CodeString newPhotometricInterpretation() {
		return new CodeString(DicomTags.PhotometricInterpretation);
	}

	public static DecimalString newPhototimerSetting() {
		return new DecimalString(DicomTags.PhototimerSetting);
	}

	public static FloatingPointDouble newPhysicalDeltaX() {
		return new FloatingPointDouble(DicomTags.PhysicalDeltaX);
	}

	public static FloatingPointDouble newPhysicalDeltaY() {
		return new FloatingPointDouble(DicomTags.PhysicalDeltaY);
	}

	public static UnsignedShort newPhysicalUnitsXDirection() {
		return new UnsignedShort(DicomTags.PhysicalUnitsXDirection);
	}

	public static UnsignedShort newPhysicalUnitsYDirection() {
		return new UnsignedShort(DicomTags.PhysicalUnitsYDirection);
	}

	public static PersonName newPhysicianApprovingInterpretation() {
		return new PersonName(DicomTags.PhysicianApprovingInterpretation);
	}

	public static PersonName newPhysicianOfRecord() {
		return new PersonName(DicomTags.PhysicianOfRecord);
	}

	public static SequenceOfItems newPhysicianOfRecordIdentificationSeq() {
		return new SequenceOfItems(DicomTags.PhysicianOfRecordIdentificationSeq);
	}

	public static SequenceOfItems newPhysicianReadingStudyIdentificationSeq() {
		return new SequenceOfItems(DicomTags.PhysicianReadingStudyIdentificationSeq);
	}

	public static IntegerString newPixelAspectRatio() {
		return new IntegerString(DicomTags.PixelAspectRatio);
	}

	public static DecimalString newPixelBandwidth() {
		return new DecimalString(DicomTags.PixelBandwidth);
	}

	public static LongText newPixelCommentsRetired() {
		return new LongText(DicomTags.PixelCommentsRetired);
	}

	public static UnsignedShort newPixelComponentDataType() {
		return new UnsignedShort(DicomTags.PixelComponentDataType);
	}

	public static UnsignedLong newPixelComponentMask() {
		return new UnsignedLong(DicomTags.PixelComponentMask);
	}

	public static UnsignedShort newPixelComponentOrganization() {
		return new UnsignedShort(DicomTags.PixelComponentOrganization);
	}

	public static UnsignedShort newPixelComponentPhysicalUnits() {
		return new UnsignedShort(DicomTags.PixelComponentPhysicalUnits);
	}

	public static UnsignedLong newPixelComponentRangeStart() {
		return new UnsignedLong(DicomTags.PixelComponentRangeStart);
	}

	public static UnsignedLong newPixelComponentRangeStop() {
		return new UnsignedLong(DicomTags.PixelComponentRangeStop);
	}

	public static Unknown newPixelData() {
		return new Unknown(DicomTags.PixelData);
	}

	public static CodeString newPixelIntensityRelationship() {
		return new CodeString(DicomTags.PixelIntensityRelationship);
	}

	public static SignedShort newPixelIntensityRelationshipSign() {
		return new SignedShort(DicomTags.PixelIntensityRelationshipSign);
	}

	public static SequenceOfItems newPixelMeasuresSeq() {
		return new SequenceOfItems(DicomTags.PixelMeasuresSeq);
	}

	public static Unknown newPixelPaddingValue() {
		return new Unknown(DicomTags.PixelPaddingValue);
	}

	public static CodeString newPixelPresentation() {
		return new CodeString(DicomTags.PixelPresentation);
	}

	public static UnsignedShort newPixelRepresentation() {
		return new UnsignedShort(DicomTags.PixelRepresentation);
	}

	public static DecimalString newPixelSpacing() {
		return new DecimalString(DicomTags.PixelSpacing);
	}

	public static SequenceOfItems newPixelSpacingSeq() {
		return new SequenceOfItems(DicomTags.PixelSpacingSeq);
	}

	public static SequenceOfItems newPixelValueTransformationSeq() {
		return new SequenceOfItems(DicomTags.PixelValueTransformationSeq);
	}

	public static LongString newPlacerOrderNumber() {
		return new LongString(DicomTags.PlacerOrderNumber);
	}

	public static ShortString newPlacerOrderNumberImagingServiceRequestRetired() {
		return new ShortString(
				DicomTags.PlacerOrderNumberImagingServiceRequestRetired);
	}

	public static ShortString newPlacerOrderNumberProcedureRetired() {
		return new ShortString(DicomTags.PlacerOrderNumberProcedureRetired);
	}

	public static UnsignedShort newPlanarConfiguration() {
		return new UnsignedShort(DicomTags.PlanarConfiguration);
	}

	public static SequenceOfItems newPlaneOrientationSeq() {
		return new SequenceOfItems(DicomTags.PlaneOrientationSeq);
	}

	public static SequenceOfItems newPlanePositionSeq() {
		return new SequenceOfItems(DicomTags.PlanePositionSeq);
	}

	public static UnsignedShort newPlanes() {
		return new UnsignedShort(DicomTags.Planes);
	}

	public static SequenceOfItems newPlannedVerificationImageSeq() {
		return new SequenceOfItems(DicomTags.PlannedVerificationImageSeq);
	}

	public static LongString newPlateID() {
		return new LongString(DicomTags.PlateID);
	}

	public static ShortString newPlateType() {
		return new ShortString(DicomTags.PlateType);
	}

	public static CodeString newPolarity() {
		return new CodeString(DicomTags.Polarity);
	}

	public static CodeString newPositionerMotion() {
		return new CodeString(DicomTags.PositionerMotion);
	}

	public static DecimalString newPositionerPrimaryAngle() {
		return new DecimalString(DicomTags.PositionerPrimaryAngle);
	}

	public static DecimalString newPositionerPrimaryAngleIncrement() {
		return new DecimalString(DicomTags.PositionerPrimaryAngleIncrement);
	}

	public static DecimalString newPositionerSecondaryAngle() {
		return new DecimalString(DicomTags.PositionerSecondaryAngle);
	}

	public static DecimalString newPositionerSecondaryAngleIncrement() {
		return new DecimalString(DicomTags.PositionerSecondaryAngleIncrement);
	}

	public static CodeString newPositionerType() {
		return new CodeString(DicomTags.PositionerType);
	}

	public static LongString newPositionReferenceIndicator() {
		return new LongString(DicomTags.PositionReferenceIndicator);
	}

	public static LongString newPostprocessingFunction() {
		return new LongString(DicomTags.PostprocessingFunction);
	}

	public static SequenceOfItems newPredecessorDocumentsSeq() {
		return new SequenceOfItems(DicomTags.PredecessorDocumentsSeq);
	}

	public static UnsignedShort newPreferredPlaybackSequencing() {
		return new UnsignedShort(DicomTags.PreferredPlaybackSequencing);
	}

	public static UnsignedShort newPregnancyStatus() {
		return new UnsignedShort(DicomTags.PregnancyStatus);
	}

	public static LongString newPreMedication() {
		return new LongString(DicomTags.PreMedication);
	}

	public static ShortText newPrescriptionDescription() {
		return new ShortText(DicomTags.PrescriptionDescription);
	}

	public static DateElement newPresentationCreationDate() {
		return new DateElement(DicomTags.PresentationCreationDate);
	}

	public static Time newPresentationCreationTime() {
		return new Time(DicomTags.PresentationCreationTime);
	}

	public static PersonName newPresentationCreatorName() {
		return new PersonName(DicomTags.PresentationCreatorName);
	}

	public static CodeString newPresentationIntentType() {
		return new CodeString(DicomTags.PresentationIntentType);
	}

	public static SequenceOfItems newPresentationLUTContentSeq() {
		return new SequenceOfItems(DicomTags.PresentationLUTContentSeq);
	}

	public static CodeString newPresentationLUTFlag() {
		return new CodeString(DicomTags.PresentationLUTFlag);
	}

	public static SequenceOfItems newPresentationLUTSeq() {
		return new SequenceOfItems(DicomTags.PresentationLUTSeq);
	}

	public static CodeString newPresentationLUTShape() {
		return new CodeString(DicomTags.PresentationLUTShape);
	}

	public static IntegerString newPresentationPixelAspectRatio() {
		return new IntegerString(DicomTags.PresentationPixelAspectRatio);
	}

	public static FloatingPointSingle newPresentationPixelMagnificationRatio() {
		return new FloatingPointSingle(
				DicomTags.PresentationPixelMagnificationRatio);
	}

	public static DecimalString newPresentationPixelSpacing() {
		return new DecimalString(DicomTags.PresentationPixelSpacing);
	}

	public static CodeString newPresentationSizeMode() {
		return new CodeString(DicomTags.PresentationSizeMode);
	}

	public static CodeString newPreserveCompositeInstancesAfterMediaCreation() {
		return new CodeString(
				DicomTags.PreserveCompositeInstancesAfterMediaCreation);
	}

	public static SequenceOfItems newPrimaryAnatomicStructureModifierSeq() {
		return new SequenceOfItems(DicomTags.PrimaryAnatomicStructureModifierSeq);
	}

	public static SequenceOfItems newPrimaryAnatomicStructureSeq() {
		return new SequenceOfItems(DicomTags.PrimaryAnatomicStructureSeq);
	}

	public static IntegerString newPrimaryCountsAccumulated() {
		return new IntegerString(DicomTags.PrimaryCountsAccumulated);
	}

	public static CodeString newPrimaryDosimeterUnit() {
		return new CodeString(DicomTags.PrimaryDosimeterUnit);
	}

	public static SequenceOfItems newPrinterCharacteristicsSeq() {
		return new SequenceOfItems(DicomTags.PrinterCharacteristicsSeq);
	}

	public static SequenceOfItems newPrinterConfigurationSeq() {
		return new SequenceOfItems(DicomTags.PrinterConfigurationSeq);
	}

	public static LongString newPrinterName() {
		return new LongString(DicomTags.PrinterName);
	}

	public static DecimalString newPrinterPixelSpacing() {
		return new DecimalString(DicomTags.PrinterPixelSpacing);
	}

	public static CodeString newPrinterResolutionID() {
		return new CodeString(DicomTags.PrinterResolutionID);
	}

	public static CodeString newPrinterStatus() {
		return new CodeString(DicomTags.PrinterStatus);
	}

	public static CodeString newPrinterStatusInfo() {
		return new CodeString(DicomTags.PrinterStatusInfo);
	}

	public static UnsignedShort newPrintingBitDepth() {
		return new UnsignedShort(DicomTags.PrintingBitDepth);
	}

	public static SequenceOfItems newPrintJobDescriptionSeq() {
		return new SequenceOfItems(DicomTags.PrintJobDescriptionSeq);
	}

	public static ShortString newPrintJobID() {
		return new ShortString(DicomTags.PrintJobID);
	}

	public static SequenceOfItems newPrintManagementCapabilitiesSeq() {
		return new SequenceOfItems(DicomTags.PrintManagementCapabilitiesSeq);
	}

	public static CodeString newPrintPriority() {
		return new CodeString(DicomTags.PrintPriority);
	}

	public static ShortString newPrintQueueID() {
		return new ShortString(DicomTags.PrintQueueID);
	}

	public static Unknown newPrintRetired() {
		return new Unknown(DicomTags.PrintRetired);
	}

	public static UnsignedShort newPriority() {
		return new UnsignedShort(DicomTags.Priority);
	}

	public static OtherByteString newPrivateInformation() {
		return new OtherByteString(DicomTags.PrivateInformation);
	}

	public static UniqueIdentifier newPrivateInformationCreatorUID() {
		return new UniqueIdentifier(DicomTags.PrivateInformationCreatorUID);
	}

	public static UniqueIdentifier newPrivateRecordUID() {
		return new UniqueIdentifier(DicomTags.PrivateRecordUID);
	}

	public static SequenceOfItems newProcedureCodeSeq() {
		return new SequenceOfItems(DicomTags.ProcedureCodeSeq);
	}

	public static LongString newProcessingFunction() {
		return new LongString(DicomTags.ProcessingFunction);
	}

	public static SequenceOfItems newProjectionEponymousNameCodeSeq() {
		return new SequenceOfItems(DicomTags.ProjectionEponymousNameCodeSeq);
	}

	public static SequenceOfItems newProposedStudySeq() {
		return new SequenceOfItems(DicomTags.ProposedStudySeq);
	}

	public static SequenceOfItems newProtocolContextSeq() {
		return new SequenceOfItems(DicomTags.ProtocolContextSeq);
	}

	public static LongString newProtocolName() {
		return new LongString(DicomTags.ProtocolName);
	}

	public static CodeString newPseudoColorType() {
		return new CodeString(DicomTags.PseudoColorType);
	}

	public static UnsignedLong newPulseRepetitionFrequency() {
		return new UnsignedLong(DicomTags.PulseRepetitionFrequency);
	}

	public static DecimalString newPulseRepetitionInterval() {
		return new DecimalString(DicomTags.PulseRepetitionInterval);
	}

	public static ShortString newPulseSequenceName() {
		return new ShortString(DicomTags.PulseSequenceName);
	}

	public static CodeString newPupilDilated() {
		return new CodeString(DicomTags.PupilDilated);
	}

	public static SequenceOfItems newPurposeOfReferenceCodeSeq() {
		return new SequenceOfItems(DicomTags.PurposeOfReferenceCodeSeq);
	}

	public static LongString newPVCRejection() {
		return new LongString(DicomTags.PVCRejection);
	}

	public static CodeString newQuadratureReceiveCoil() {
		return new CodeString(DicomTags.QuadratureReceiveCoil);
	}

	public static CodeString newQualityControlImage() {
		return new CodeString(DicomTags.QualityControlImage);
	}

	public static DecimalString newQuantity() {
		return new DecimalString(DicomTags.Quantity);
	}

	public static SequenceOfItems newQuantitySeq() {
		return new SequenceOfItems(DicomTags.QuantitySeq);
	}

	public static CodeString newQueryRetrieveLevel() {
		return new CodeString(DicomTags.QueryRetrieveLevel);
	}

	public static CodeString newQueueStatus() {
		return new CodeString(DicomTags.QueueStatus);
	}

	public static DecimalString newRadialPosition() {
		return new DecimalString(DicomTags.RadialPosition);
	}

	public static ShortString newRadiationMachineName() {
		return new ShortString(DicomTags.RadiationMachineName);
	}

	public static DecimalString newRadiationMachineSAD() {
		return new DecimalString(DicomTags.RadiationMachineSAD);
	}

	public static DecimalString newRadiationMachineSSD() {
		return new DecimalString(DicomTags.RadiationMachineSSD);
	}

	public static CodeString newRadiationMode() {
		return new CodeString(DicomTags.RadiationMode);
	}

	public static CodeString newRadiationSetting() {
		return new CodeString(DicomTags.RadiationSetting);
	}

	public static CodeString newRadiationType() {
		return new CodeString(DicomTags.RadiationType);
	}

	public static SequenceOfItems newRadionuclideCodeSeq() {
		return new SequenceOfItems(DicomTags.RadionuclideCodeSeq);
	}

	public static DecimalString newRadionuclideHalfLife() {
		return new DecimalString(DicomTags.RadionuclideHalfLife);
	}

	public static DecimalString newRadionuclidePositronFraction() {
		return new DecimalString(DicomTags.RadionuclidePositronFraction);
	}

	public static LongString newRadionuclideRetired() {
		return new LongString(DicomTags.RadionuclideRetired);
	}

	public static DecimalString newRadionuclideTotalDose() {
		return new DecimalString(DicomTags.RadionuclideTotalDose);
	}

	public static LongString newRadiopharmaceutical() {
		return new LongString(DicomTags.Radiopharmaceutical);
	}

	public static SequenceOfItems newRadiopharmaceuticalCodeSeq() {
		return new SequenceOfItems(DicomTags.RadiopharmaceuticalCodeSeq);
	}

	public static SequenceOfItems newRadiopharmaceuticalInformationSeq() {
		return new SequenceOfItems(DicomTags.RadiopharmaceuticalInformationSeq);
	}

	public static LongString newRadiopharmaceuticalRoute() {
		return new LongString(DicomTags.RadiopharmaceuticalRoute);
	}

	public static DecimalString newRadiopharmaceuticalSpecificActivity() {
		return new DecimalString(DicomTags.RadiopharmaceuticalSpecificActivity);
	}

	public static Time newRadiopharmaceuticalStartTime() {
		return new Time(DicomTags.RadiopharmaceuticalStartTime);
	}

	public static Time newRadiopharmaceuticalStopTime() {
		return new Time(DicomTags.RadiopharmaceuticalStopTime);
	}

	public static DecimalString newRadiopharmaceuticalVolume() {
		return new DecimalString(DicomTags.RadiopharmaceuticalVolume);
	}

	public static IntegerString newRadiusOfCircularCollimator() {
		return new IntegerString(DicomTags.RadiusOfCircularCollimator);
	}

	public static IntegerString newRadiusOfCircularShutter() {
		return new IntegerString(DicomTags.RadiusOfCircularShutter);
	}

	public static CodeString newRandomsCorrectionMethod() {
		return new CodeString(DicomTags.RandomsCorrectionMethod);
	}

	public static Unknown newRealWorldValueFirstValueMappedUS() {
		return new Unknown(DicomTags.RealWorldValueFirstValueMappedUS);
	}

	public static FloatingPointDouble newRealWorldValueIntercept() {
		return new FloatingPointDouble(DicomTags.RealWorldValueIntercept);
	}

	public static Unknown newRealWorldValueLastValueMappedUS() {
		return new Unknown(DicomTags.RealWorldValueLastValueMappedUS);
	}

	public static FloatingPointDouble newRealWorldValueLUTData() {
		return new FloatingPointDouble(DicomTags.RealWorldValueLUTData);
	}

	public static SequenceOfItems newRealWorldValueMappingSeq() {
		return new SequenceOfItems(DicomTags.RealWorldValueMappingSeq);
	}

	public static FloatingPointDouble newRealWorldValueSlope() {
		return new FloatingPointDouble(DicomTags.RealWorldValueSlope);
	}

	public static SequenceOfItems newReasonforRequestedProcedureCodeSeq() {
		return new SequenceOfItems(DicomTags.ReasonforRequestedProcedureCodeSeq);
	}

	public static LongString newReasonforStudy() {
		return new LongString(DicomTags.ReasonforStudy);
	}

	public static LongString newReasonForTheImagingServiceRequest() {
		return new LongString(DicomTags.ReasonForTheImagingServiceRequest);
	}

	public static LongString newReasonForTheRequestedProcedure() {
		return new LongString(DicomTags.ReasonForTheRequestedProcedure);
	}

	public static LongString newReceiveCoilManufacturerName() {
		return new LongString(DicomTags.ReceiveCoilManufacturerName);
	}

	public static ShortString newReceiveCoilName() {
		return new ShortString(DicomTags.ReceiveCoilName);
	}

	public static CodeString newReceiveCoilType() {
		return new CodeString(DicomTags.ReceiveCoilType);
	}

	public static Unknown newReceiverRetired() {
		return new Unknown(DicomTags.ReceiverRetired);
	}

	public static Unknown newRecognitionCodeRetired() {
		return new Unknown(DicomTags.RecognitionCodeRetired);
	}

	public static IntegerString newRecommendedDisplayFrameRate() {
		return new IntegerString(DicomTags.RecommendedDisplayFrameRate);
	}

	public static CodeString newRecommendedViewingMode() {
		return new CodeString(DicomTags.RecommendedViewingMode);
	}

	public static CodeString newReconstructionAlgorithm() {
		return new CodeString(DicomTags.ReconstructionAlgorithm);
	}

	public static FloatingPointDouble newReconstructionAngle() {
		return new FloatingPointDouble(DicomTags.ReconstructionAngle);
	}

	public static DecimalString newReconstructionDiameter() {
		return new DecimalString(DicomTags.ReconstructionDiameter);
	}

	public static FloatingPointDouble newReconstructionFieldOfView() {
		return new FloatingPointDouble(DicomTags.ReconstructionFieldOfView);
	}

	public static LongString newReconstructionMethod() {
		return new LongString(DicomTags.ReconstructionMethod);
	}

	public static FloatingPointDouble newReconstructionPixelSpacing() {
		return new FloatingPointDouble(DicomTags.ReconstructionPixelSpacing);
	}

	public static FloatingPointDouble newReconstructionTargetCenterPatient() {
		return new FloatingPointDouble(DicomTags.ReconstructionTargetCenterPatient);
	}

	public static SequenceOfItems newRecordedBlockSeq() {
		return new SequenceOfItems(DicomTags.RecordedBlockSeq);
	}

	public static SequenceOfItems newRecordedBrachyAccessoryDeviceSeq() {
		return new SequenceOfItems(DicomTags.RecordedBrachyAccessoryDeviceSeq);
	}

	public static SequenceOfItems newRecordedChannelSeq() {
		return new SequenceOfItems(DicomTags.RecordedChannelSeq);
	}

	public static SequenceOfItems newRecordedChannelShieldSeq() {
		return new SequenceOfItems(DicomTags.RecordedChannelShieldSeq);
	}

	public static SequenceOfItems newRecordedCompensatorSeq() {
		return new SequenceOfItems(DicomTags.RecordedCompensatorSeq);
	}

	public static SequenceOfItems newRecordedSourceApplicatorSeq() {
		return new SequenceOfItems(DicomTags.RecordedSourceApplicatorSeq);
	}

	public static SequenceOfItems newRecordedSourceSeq() {
		return new SequenceOfItems(DicomTags.RecordedSourceSeq);
	}

	public static SequenceOfItems newRecordedWedgeSeq() {
		return new SequenceOfItems(DicomTags.RecordedWedgeSeq);
	}

	public static UnsignedShort newRecordInUseFlag() {
		return new UnsignedShort(DicomTags.RecordInUseFlag);
	}

	public static CodeString newRectificationType() {
		return new CodeString(DicomTags.RectificationType);
	}

	public static CodeString newRectilinearPhaseEncodeReordering() {
		return new CodeString(DicomTags.RectilinearPhaseEncodeReordering);
	}

	public static OtherWordString newRedPaletteColorLUTData() {
		return new OtherWordString(DicomTags.RedPaletteColorLUTData);
	}

	public static Unknown newRedPaletteColorLUTDescriptor() {
		return new Unknown(DicomTags.RedPaletteColorLUTDescriptor);
	}

	public static SequenceOfItems newRefBasicAnnotationBoxSeq() {
		return new SequenceOfItems(DicomTags.RefBasicAnnotationBoxSeq);
	}

	public static IntegerString newRefBeamNumber() {
		return new IntegerString(DicomTags.RefBeamNumber);
	}

	public static SequenceOfItems newRefBeamSeq() {
		return new SequenceOfItems(DicomTags.RefBeamSeq);
	}

	public static IntegerString newRefBlockNumber() {
		return new IntegerString(DicomTags.RefBlockNumber);
	}

	public static SequenceOfItems newRefBolusSeq() {
		return new SequenceOfItems(DicomTags.RefBolusSeq);
	}

	public static IntegerString newRefBrachyAccessoryDeviceNumber() {
		return new IntegerString(DicomTags.RefBrachyAccessoryDeviceNumber);
	}

	public static IntegerString newRefBrachyApplicationSetupNumber() {
		return new IntegerString(DicomTags.RefBrachyApplicationSetupNumber);
	}

	public static SequenceOfItems newRefBrachyApplicationSetupSeq() {
		return new SequenceOfItems(DicomTags.RefBrachyApplicationSetupSeq);
	}

	public static IntegerString newRefCalculatedDoseReferenceNumber() {
		return new IntegerString(DicomTags.RefCalculatedDoseReferenceNumber);
	}

	public static SequenceOfItems newRefCalculatedDoseReferenceSeq() {
		return new SequenceOfItems(DicomTags.RefCalculatedDoseReferenceSeq);
	}

	public static IntegerString newRefChannelShieldNumber() {
		return new IntegerString(DicomTags.RefChannelShieldNumber);
	}

	public static IntegerString newRefCompensatorNumber() {
		return new IntegerString(DicomTags.RefCompensatorNumber);
	}

	public static UnsignedLong newRefContentItemIdentifier() {
		return new UnsignedLong(DicomTags.RefContentItemIdentifier);
	}

	public static IntegerString newRefControlPointIndex() {
		return new IntegerString(DicomTags.RefControlPointIndex);
	}

	public static SequenceOfItems newRefCurveSeq() {
		return new SequenceOfItems(DicomTags.RefCurveSeq);
	}

	public static DateTime newRefDatetime() {
		return new DateTime(DicomTags.RefDatetime);
	}

	public static IntegerString newRefDoseReferenceNumber() {
		return new IntegerString(DicomTags.RefDoseReferenceNumber);
	}

	public static SequenceOfItems newRefDoseReferenceSeq() {
		return new SequenceOfItems(DicomTags.RefDoseReferenceSeq);
	}

	public static SequenceOfItems newRefDoseSeq() {
		return new SequenceOfItems(DicomTags.RefDoseSeq);
	}

	public static DecimalString newReferenceAirKermaRate() {
		return new DecimalString(DicomTags.ReferenceAirKermaRate);
	}

	public static UnsignedShort newReferenceDisplaySets() {
		return new UnsignedShort(DicomTags.ReferenceDisplaySets);
	}

	public static UniqueIdentifier newReferencedRelatedGeneralSOPClassUIDInFile() {
		return new UniqueIdentifier(
				DicomTags.ReferencedRelatedGeneralSOPClassUIDInFile);
	}

	public static SequenceOfItems newReferencedWaveformSeq() {
		return new SequenceOfItems(DicomTags.ReferencedWaveformSeq);
	}

	public static IntegerString newReferenceImageNumber() {
		return new IntegerString(DicomTags.ReferenceImageNumber);
	}

	public static FloatingPointDouble newReferencePixelPhysicalValueX() {
		return new FloatingPointDouble(DicomTags.ReferencePixelPhysicalValueX);
	}

	public static FloatingPointDouble newReferencePixelPhysicalValueY() {
		return new FloatingPointDouble(DicomTags.ReferencePixelPhysicalValueY);
	}

	public static SignedLong newReferencePixelX0() {
		return new SignedLong(DicomTags.ReferencePixelX0);
	}

	public static SignedLong newReferencePixelY0() {
		return new SignedLong(DicomTags.ReferencePixelY0);
	}

	public static Unknown newReferenceRetired() {
		return new Unknown(DicomTags.ReferenceRetired);
	}

	public static LongString newReferenceToRecordedSound() {
		return new LongString(DicomTags.ReferenceToRecordedSound);
	}

	public static ShortText newReferringPhysicianAddress() {
		return new ShortText(DicomTags.ReferringPhysicianAddress);
	}

	public static SequenceOfItems newReferringPhysicianIdentificationSeq() {
		return new SequenceOfItems(DicomTags.ReferringPhysicianIdentificationSeq);
	}

	public static PersonName newReferringPhysicianName() {
		return new PersonName(DicomTags.ReferringPhysicianName);
	}

	public static ShortString newReferringPhysicianPhoneNumbers() {
		return new ShortString(DicomTags.ReferringPhysicianPhoneNumbers);
	}

	public static CodeString newRefFileID() {
		return new CodeString(DicomTags.RefFileID);
	}

	public static SequenceOfItems newRefFilmBoxSeq() {
		return new SequenceOfItems(DicomTags.RefFilmBoxSeq);
	}

	public static SequenceOfItems newRefFilmSessionSeq() {
		return new SequenceOfItems(DicomTags.RefFilmSessionSeq);
	}

	public static IntegerString newRefFractionGroupNumber() {
		return new IntegerString(DicomTags.RefFractionGroupNumber);
	}

	public static SequenceOfItems newRefFractionGroupSeq() {
		return new SequenceOfItems(DicomTags.RefFractionGroupSeq);
	}

	public static IntegerString newRefFractionNumber() {
		return new IntegerString(DicomTags.RefFractionNumber);
	}

	public static IntegerString newRefFrameNumber() {
		return new IntegerString(DicomTags.RefFrameNumber);
	}

	public static UnsignedShort newRefFrameNumbers() {
		return new UnsignedShort(DicomTags.RefFrameNumbers);
	}

	public static SequenceOfItems newRefFrameOfReferenceSeq() {
		return new SequenceOfItems(DicomTags.RefFrameOfReferenceSeq);
	}

	public static UniqueIdentifier newRefFrameOfReferenceUID() {
		return new UniqueIdentifier(DicomTags.RefFrameOfReferenceUID);
	}

	public static SequenceOfItems newRefGPSPSSeq() {
		return new SequenceOfItems(DicomTags.RefGPSPSSeq);
	}

	public static UniqueIdentifier newRefGPSPSTransactionUID() {
		return new UniqueIdentifier(DicomTags.RefGPSPSTransactionUID);
	}

	public static SequenceOfItems newRefGrayscalePresentationStateSeq() {
		return new SequenceOfItems(DicomTags.RefGrayscalePresentationStateSeq);
	}

	public static SequenceOfItems newRefImageBoxSeq() {
		return new SequenceOfItems(DicomTags.RefImageBoxSeq);
	}

	public static SequenceOfItems newRefImageBoxSeqRetired() {
		return new SequenceOfItems(DicomTags.RefImageBoxSeqRetired);
	}

	public static SequenceOfItems newRefImageEvidenceSeq() {
		return new SequenceOfItems(DicomTags.RefImageEvidenceSeq);
	}

	public static SequenceOfItems newRefImageOverlayBoxSeqRetired() {
		return new SequenceOfItems(DicomTags.RefImageOverlayBoxSeqRetired);
	}

	public static SequenceOfItems newRefImageSeq() {
		return new SequenceOfItems(DicomTags.RefImageSeq);
	}

	public static SequenceOfItems newRefInstanceSeq() {
		return new SequenceOfItems(DicomTags.RefInstanceSeq);
	}

	public static SequenceOfItems newRefInterpretationSeq() {
		return new SequenceOfItems(DicomTags.RefInterpretationSeq);
	}

	public static UnsignedShort newReflectedAmbientLight() {
		return new UnsignedShort(DicomTags.ReflectedAmbientLight);
	}

	public static IntegerString newRefMeasuredDoseReferenceNumber() {
		return new IntegerString(DicomTags.RefMeasuredDoseReferenceNumber);
	}

	public static SequenceOfItems newRefMeasuredDoseReferenceSeq() {
		return new SequenceOfItems(DicomTags.RefMeasuredDoseReferenceSeq);
	}

	public static SequenceOfItems newRefNonImageCompositeSOPInstanceSeq() {
		return new SequenceOfItems(DicomTags.RefNonImageCompositeSOPInstanceSeq);
	}

	public static FloatingPointDouble newReformattingInterval() {
		return new FloatingPointDouble(DicomTags.ReformattingInterval);
	}

	public static CodeString newReformattingOperationInitialViewDirection() {
		return new CodeString(DicomTags.ReformattingOperationInitialViewDirection);
	}

	public static CodeString newReformattingOperationType() {
		return new CodeString(DicomTags.ReformattingOperationType);
	}

	public static FloatingPointDouble newReformattingThickness() {
		return new FloatingPointDouble(DicomTags.ReformattingThickness);
	}

	public static UnsignedShort newRefOverlayPlaneGroups() {
		return new UnsignedShort(DicomTags.RefOverlayPlaneGroups);
	}

	public static SequenceOfItems newRefOverlayPlaneSeq() {
		return new SequenceOfItems(DicomTags.RefOverlayPlaneSeq);
	}

	public static SequenceOfItems newRefOverlaySeq() {
		return new SequenceOfItems(DicomTags.RefOverlaySeq);
	}

	public static SequenceOfItems newRefPatientAliasSeq() {
		return new SequenceOfItems(DicomTags.RefPatientAliasSeq);
	}

	public static SequenceOfItems newRefPatientSeq() {
		return new SequenceOfItems(DicomTags.RefPatientSeq);
	}

	public static IntegerString newRefPatientSetupNumber() {
		return new IntegerString(DicomTags.RefPatientSetupNumber);
	}

	public static SequenceOfItems newRefPPSSeq() {
		return new SequenceOfItems(DicomTags.RefPPSSeq);
	}

	public static SequenceOfItems newRefPresentationLUTSeq() {
		return new SequenceOfItems(DicomTags.RefPresentationLUTSeq);
	}

	public static SequenceOfItems newRefPrintJobSeq() {
		return new SequenceOfItems(DicomTags.RefPrintJobSeq);
	}

	public static SequenceOfItems newRefPrintJobSeqInQueue() {
		return new SequenceOfItems(DicomTags.RefPrintJobSeqInQueue);
	}

	public static SequenceOfItems newRefProcedureStepSeq() {
		return new SequenceOfItems(DicomTags.RefProcedureStepSeq);
	}

	public static SequenceOfItems newRefractiveStateSeq() {
		return new SequenceOfItems(DicomTags.RefractiveStateSeq);
	}

	public static SequenceOfItems newRefRawDataSeq() {
		return new SequenceOfItems(DicomTags.RefRawDataSeq);
	}

	public static IntegerString newRefReferenceImageNumber() {
		return new IntegerString(DicomTags.RefReferenceImageNumber);
	}

	public static SequenceOfItems newRefReferenceImageSeq() {
		return new SequenceOfItems(DicomTags.RefReferenceImageSeq);
	}

	public static SequenceOfItems newRefRequestSeq() {
		return new SequenceOfItems(DicomTags.RefRequestSeq);
	}

	public static SequenceOfItems newRefResultsSeq() {
		return new SequenceOfItems(DicomTags.RefResultsSeq);
	}

	public static IntegerString newRefROINumber() {
		return new IntegerString(DicomTags.RefROINumber);
	}

	public static SequenceOfItems newRefRTPlanSeq() {
		return new SequenceOfItems(DicomTags.RefRTPlanSeq);
	}

	public static UnsignedLong newRefSamplePositions() {
		return new UnsignedLong(DicomTags.RefSamplePositions);
	}

	public static SequenceOfItems newRefSeriesSeq() {
		return new SequenceOfItems(DicomTags.RefSeriesSeq);
	}

	public static UniqueIdentifier newRefSOPClassUID() {
		return new UniqueIdentifier(DicomTags.RefSOPClassUID);
	}

	public static UniqueIdentifier newRefSOPClassUIDInFile() {
		return new UniqueIdentifier(DicomTags.RefSOPClassUIDInFile);
	}

	public static UniqueIdentifier newRefSOPInstanceUID() {
		return new UniqueIdentifier(DicomTags.RefSOPInstanceUID);
	}

	public static UniqueIdentifier newRefSOPInstanceUIDInFile() {
		return new UniqueIdentifier(DicomTags.RefSOPInstanceUIDInFile);
	}

	public static SequenceOfItems newRefSOPSeq() {
		return new SequenceOfItems(DicomTags.RefSOPSeq);
	}

	public static UniqueIdentifier newRefSOPTransferSyntaxUIDInFile() {
		return new UniqueIdentifier(DicomTags.RefSOPTransferSyntaxUIDInFile);
	}

	public static IntegerString newRefSourceApplicatorNumber() {
		return new IntegerString(DicomTags.RefSourceApplicatorNumber);
	}

	public static IntegerString newRefSourceNumber() {
		return new IntegerString(DicomTags.RefSourceNumber);
	}

	public static SequenceOfItems newRefStorageMediaSeq() {
		return new SequenceOfItems(DicomTags.RefStorageMediaSeq);
	}

	public static SequenceOfItems newRefStoredPrintSeq() {
		return new SequenceOfItems(DicomTags.RefStoredPrintSeq);
	}

	public static SequenceOfItems newRefStructureSetSeq() {
		return new SequenceOfItems(DicomTags.RefStructureSetSeq);
	}

	public static SequenceOfItems newRefStudySeq() {
		return new SequenceOfItems(DicomTags.RefStudySeq);
	}

	public static DecimalString newRefTimeOffsets() {
		return new DecimalString(DicomTags.RefTimeOffsets);
	}

	public static IntegerString newRefToleranceTableNumber() {
		return new IntegerString(DicomTags.RefToleranceTableNumber);
	}

	public static SequenceOfItems newRefTreatmentRecordSeq() {
		return new SequenceOfItems(DicomTags.RefTreatmentRecordSeq);
	}

	public static SequenceOfItems newRefVerificationImageSeq() {
		return new SequenceOfItems(DicomTags.RefVerificationImageSeq);
	}

	public static SequenceOfItems newRefVisitSeq() {
		return new SequenceOfItems(DicomTags.RefVisitSeq);
	}

	public static SequenceOfItems newRefVOILUTBoxSeqRetired() {
		return new SequenceOfItems(DicomTags.RefVOILUTBoxSeqRetired);
	}

	public static UnsignedShort newRefWaveformChannels() {
		return new UnsignedShort(DicomTags.RefWaveformChannels);
	}

	public static IntegerString newRefWedgeNumber() {
		return new IntegerString(DicomTags.RefWedgeNumber);
	}

	public static UnsignedShort newRegionDataType() {
		return new UnsignedShort(DicomTags.RegionDataType);
	}

	public static UnsignedLong newRegionFlags() {
		return new UnsignedLong(DicomTags.RegionFlags);
	}

	public static UnsignedLong newRegionLocationMaxX1() {
		return new UnsignedLong(DicomTags.RegionLocationMaxX1);
	}

	public static UnsignedLong newRegionLocationMaxY1() {
		return new UnsignedLong(DicomTags.RegionLocationMaxY1);
	}

	public static UnsignedLong newRegionLocationMinX0() {
		return new UnsignedLong(DicomTags.RegionLocationMinX0);
	}

	public static UnsignedLong newRegionLocationMinY0() {
		return new UnsignedLong(DicomTags.RegionLocationMinY0);
	}

	public static LongString newRegionOfResidence() {
		return new LongString(DicomTags.RegionOfResidence);
	}

	public static UnsignedShort newRegionSpatialFormat() {
		return new UnsignedShort(DicomTags.RegionSpatialFormat);
	}

	public static SequenceOfItems newRegistrationSeq() {
		return new SequenceOfItems(DicomTags.RegistrationSeq);
	}

	public static SequenceOfItems newRegistrationTypeCodeSeq() {
		return new SequenceOfItems(DicomTags.RegistrationTypeCodeSeq);
	}

	public static UniqueIdentifier newRelatedFrameOfReferenceUID() {
		return new UniqueIdentifier(DicomTags.RelatedFrameOfReferenceUID);
	}

	public static SequenceOfItems newRelatedRTROIObservationsSeq() {
		return new SequenceOfItems(DicomTags.RelatedRTROIObservationsSeq);
	}

	public static CodeString newRelationshipType() {
		return new CodeString(DicomTags.RelationshipType);
	}

	public static SequenceOfItems newRelativeImagePositionCodeSeq() {
		return new SequenceOfItems(DicomTags.RelativeImagePositionCodeSeq);
	}

	public static UnsignedShort newRelativeTime() {
		return new UnsignedShort(DicomTags.RelativeTime);
	}

	public static CodeString newRelativeTimeUnits() {
		return new CodeString(DicomTags.RelativeTimeUnits);
	}

	public static IntegerString newRelativeXRayExposure() {
		return new IntegerString(DicomTags.RelativeXRayExposure);
	}

	public static SequenceOfItems newRelevantInformationSeq() {
		return new SequenceOfItems(DicomTags.RelevantInformationSeq);
	}

	public static IntegerString newRepeatFractionCycleLength() {
		return new IntegerString(DicomTags.RepeatFractionCycleLength);
	}

	public static DecimalString newRepetitionTime() {
		return new DecimalString(DicomTags.RepetitionTime);
	}

	public static CodeString newReportedValuesOrigin() {
		return new CodeString(DicomTags.ReportedValuesOrigin);
	}

	public static ShortString newReportingPriority() {
		return new ShortString(DicomTags.ReportingPriority);
	}

	public static UnsignedShort newRepresentativeFrameNumber() {
		return new UnsignedShort(DicomTags.RepresentativeFrameNumber);
	}

	public static CodeString newReprojectionMethod() {
		return new CodeString(DicomTags.ReprojectionMethod);
	}

	public static SequenceOfItems newRequestAttributesSeq() {
		return new SequenceOfItems(DicomTags.RequestAttributesSeq);
	}

	public static LongString newRequestedContrastAgent() {
		return new LongString(DicomTags.RequestedContrastAgent);
	}

	public static CodeString newRequestedDecimateCropBehavior() {
		return new CodeString(DicomTags.RequestedDecimateCropBehavior);
	}

	public static DecimalString newRequestedImageSize() {
		return new DecimalString(DicomTags.RequestedImageSize);
	}

	public static CodeString newRequestedImageSizeFlag() {
		return new CodeString(DicomTags.RequestedImageSizeFlag);
	}

	public static LongString newRequestedMediaApplicationProfile() {
		return new LongString(DicomTags.RequestedMediaApplicationProfile);
	}

	public static SequenceOfItems newRequestedProcedureCodeSeq() {
		return new SequenceOfItems(DicomTags.RequestedProcedureCodeSeq);
	}

	public static LongText newRequestedProcedureComments() {
		return new LongText(DicomTags.RequestedProcedureComments);
	}

	public static LongString newRequestedProcedureDescription() {
		return new LongString(DicomTags.RequestedProcedureDescription);
	}

	public static ShortString newRequestedProcedureID() {
		return new ShortString(DicomTags.RequestedProcedureID);
	}

	public static LongString newRequestedProcedureLocation() {
		return new LongString(DicomTags.RequestedProcedureLocation);
	}

	public static ShortString newRequestedProcedurePriority() {
		return new ShortString(DicomTags.RequestedProcedurePriority);
	}

	public static CodeString newRequestedResolutionID() {
		return new CodeString(DicomTags.RequestedResolutionID);
	}

	public static UniqueIdentifier newRequestedSOPClassUID() {
		return new UniqueIdentifier(DicomTags.RequestedSOPClassUID);
	}

	public static UniqueIdentifier newRequestedSOPInstanceUID() {
		return new UniqueIdentifier(DicomTags.RequestedSOPInstanceUID);
	}

	public static SequenceOfItems newRequestedSubsequentWorkitemCodeSeq() {
		return new SequenceOfItems(DicomTags.RequestedSubsequentWorkitemCodeSeq);
	}

	public static PersonName newRequestingPhysician() {
		return new PersonName(DicomTags.RequestingPhysician);
	}

	public static SequenceOfItems newRequestingPhysicianIdentificationSeq() {
		return new SequenceOfItems(DicomTags.RequestingPhysicianIdentificationSeq);
	}

	public static LongString newRequestingService() {
		return new LongString(DicomTags.RequestingService);
	}

	public static CodeString newRequestPriority() {
		return new CodeString(DicomTags.RequestPriority);
	}

	public static DecimalString newRescaleIntercept() {
		return new DecimalString(DicomTags.RescaleIntercept);
	}

	public static DecimalString newRescaleSlope() {
		return new DecimalString(DicomTags.RescaleSlope);
	}

	public static LongString newRescaleType() {
		return new LongString(DicomTags.RescaleType);
	}

	public static IntegerString newResidualSyringeCounts() {
		return new IntegerString(DicomTags.ResidualSyringeCounts);
	}

	public static CodeString newResonantNucleus() {
		return new CodeString(DicomTags.ResonantNucleus);
	}

	public static CodeString newRespiratoryCyclePosition() {
		return new CodeString(DicomTags.RespiratoryCyclePosition);
	}

	public static CodeString newRespiratoryMotionCompensationTechnique() {
		return new CodeString(DicomTags.RespiratoryMotionCompensationTechnique);
	}

	public static CodeString newRespiratorySignalSource() {
		return new CodeString(DicomTags.RespiratorySignalSource);
	}

	public static Unknown newResponseSequenceNumberRetired() {
		return new Unknown(DicomTags.ResponseSequenceNumberRetired);
	}

	public static ShortText newResponsibleOrganization() {
		return new ShortText(DicomTags.ResponsibleOrganization);
	}

	public static SequenceOfItems newResultingGPPPSSeq() {
		return new SequenceOfItems(DicomTags.ResultingGPPPSSeq);
	}

	public static ShortText newResultsComments() {
		return new ShortText(DicomTags.ResultsComments);
	}

	public static SequenceOfItems newResultsDistributionListSeq() {
		return new SequenceOfItems(DicomTags.ResultsDistributionListSeq);
	}

	public static ShortString newResultsID() {
		return new ShortString(DicomTags.ResultsID);
	}

	public static LongString newResultsIDIssuer() {
		return new LongString(DicomTags.ResultsIDIssuer);
	}

	public static ApplicationEntity newRetrieveAET() {
		return new ApplicationEntity(DicomTags.RetrieveAET);
	}

	public static DateElement newReviewDate() {
		return new DateElement(DicomTags.ReviewDate);
	}

	public static PersonName newReviewerName() {
		return new PersonName(DicomTags.ReviewerName);
	}

	public static Time newReviewTime() {
		return new Time(DicomTags.ReviewTime);
	}

	public static FloatingPointDouble newRevolutionTime() {
		return new FloatingPointDouble(DicomTags.RevolutionTime);
	}

	public static UnsignedShort newRFEchoTrainLength() {
		return new UnsignedShort(DicomTags.RFEchoTrainLength);
	}

	public static SequenceOfItems newRightImageSeq() {
		return new SequenceOfItems(DicomTags.RightImageSeq);
	}

	public static SequenceOfItems newROIContourSeq() {
		return new SequenceOfItems(DicomTags.ROIContourSeq);
	}

	public static ShortText newROIDescription() {
		return new ShortText(DicomTags.ROIDescription);
	}

	public static IntegerString newROIDisplayColor() {
		return new IntegerString(DicomTags.ROIDisplayColor);
	}

	public static CodeString newROIGenerationAlgorithm() {
		return new CodeString(DicomTags.ROIGenerationAlgorithm);
	}

	public static LongString newROIGenerationDescription() {
		return new LongString(DicomTags.ROIGenerationDescription);
	}

	public static PersonName newROIInterpreter() {
		return new PersonName(DicomTags.ROIInterpreter);
	}

	public static LongString newROIName() {
		return new LongString(DicomTags.ROIName);
	}

	public static IntegerString newROINumber() {
		return new IntegerString(DicomTags.ROINumber);
	}

	public static ShortText newROIObservationDescription() {
		return new ShortText(DicomTags.ROIObservationDescription);
	}

	public static ShortString newROIObservationLabel() {
		return new ShortString(DicomTags.ROIObservationLabel);
	}

	public static SequenceOfItems newROIPhysicalPropertiesSeq() {
		return new SequenceOfItems(DicomTags.ROIPhysicalPropertiesSeq);
	}

	public static CodeString newROIPhysicalProperty() {
		return new CodeString(DicomTags.ROIPhysicalProperty);
	}

	public static DecimalString newROIPhysicalPropertyValue() {
		return new DecimalString(DicomTags.ROIPhysicalPropertyValue);
	}

	public static DecimalString newROIVolume() {
		return new DecimalString(DicomTags.ROIVolume);
	}

	public static CodeString newRotationDirection() {
		return new CodeString(DicomTags.RotationDirection);
	}

	public static SequenceOfItems newRotationInformationSeq() {
		return new SequenceOfItems(DicomTags.RotationInformationSeq);
	}

	public static DecimalString newRotationOffsetRetired() {
		return new DecimalString(DicomTags.RotationOffsetRetired);
	}

	public static UnsignedShort newRotationVector() {
		return new UnsignedShort(DicomTags.RotationVector);
	}

	public static LongString newRouteOfAdmissions() {
		return new LongString(DicomTags.RouteOfAdmissions);
	}

	public static UnsignedShort newRows() {
		return new UnsignedShort(DicomTags.Rows);
	}

	public static UnsignedShort newRRIntervalVector() {
		return new UnsignedShort(DicomTags.RRIntervalVector);
	}

	public static CodeString newRTBeamLimitingDeviceType() {
		return new CodeString(DicomTags.RTBeamLimitingDeviceType);
	}

	public static SequenceOfItems newRTDoseROISeq() {
		return new SequenceOfItems(DicomTags.RTDoseROISeq);
	}

	public static ShortText newRTImageDescription() {
		return new ShortText(DicomTags.RTImageDescription);
	}

	public static ShortString newRTImageLabel() {
		return new ShortString(DicomTags.RTImageLabel);
	}

	public static LongString newRTImageName() {
		return new LongString(DicomTags.RTImageName);
	}

	public static DecimalString newRTImageOrientation() {
		return new DecimalString(DicomTags.RTImageOrientation);
	}

	public static CodeString newRTImagePlane() {
		return new CodeString(DicomTags.RTImagePlane);
	}

	public static DecimalString newRTImagePosition() {
		return new DecimalString(DicomTags.RTImagePosition);
	}

	public static DecimalString newRTImageSID() {
		return new DecimalString(DicomTags.RTImageSID);
	}

	public static DateElement newRTPlanDate() {
		return new DateElement(DicomTags.RTPlanDate);
	}

	public static ShortText newRTPlanDescription() {
		return new ShortText(DicomTags.RTPlanDescription);
	}

	public static CodeString newRTPlanGeometry() {
		return new CodeString(DicomTags.RTPlanGeometry);
	}

	public static ShortString newRTPlanLabel() {
		return new ShortString(DicomTags.RTPlanLabel);
	}

	public static LongString newRTPlanName() {
		return new LongString(DicomTags.RTPlanName);
	}

	public static CodeString newRTPlanRelationship() {
		return new CodeString(DicomTags.RTPlanRelationship);
	}

	public static Time newRTPlanTime() {
		return new Time(DicomTags.RTPlanTime);
	}

	public static SequenceOfItems newRTRefSeriesSeq() {
		return new SequenceOfItems(DicomTags.RTRefSeriesSeq);
	}

	public static SequenceOfItems newRTRefStudySeq() {
		return new SequenceOfItems(DicomTags.RTRefStudySeq);
	}

	public static SequenceOfItems newRTRelatedROISeq() {
		return new SequenceOfItems(DicomTags.RTRelatedROISeq);
	}

	public static SequenceOfItems newRTROIIdentificationCodeSeq() {
		return new SequenceOfItems(DicomTags.RTROIIdentificationCodeSeq);
	}

	public static CodeString newRTROIInterpretedType() {
		return new CodeString(DicomTags.RTROIInterpretedType);
	}

	public static SequenceOfItems newRTROIObservationsSeq() {
		return new SequenceOfItems(DicomTags.RTROIObservationsSeq);
	}

	public static CodeString newRTROIRelationship() {
		return new CodeString(DicomTags.RTROIRelationship);
	}

	public static UnsignedShort newRWavePointer() {
		return new UnsignedShort(DicomTags.RWavePointer);
	}

	public static FloatingPointSingle newRWaveTimeVector() {
		return new FloatingPointSingle(DicomTags.RWaveTimeVector);
	}

	public static DateElement newSafePositionExitDate() {
		return new DateElement(DicomTags.SafePositionExitDate);
	}

	public static Time newSafePositionExitTime() {
		return new Time(DicomTags.SafePositionExitTime);
	}

	public static DateElement newSafePositionReturnDate() {
		return new DateElement(DicomTags.SafePositionReturnDate);
	}

	public static Time newSafePositionReturnTime() {
		return new Time(DicomTags.SafePositionReturnTime);
	}

	public static UnsignedShort newSamplesPerPixel() {
		return new UnsignedShort(DicomTags.SamplesPerPixel);
	}

	public static UnsignedShort newSamplesPerPixelUsed() {
		return new UnsignedShort(DicomTags.SamplesPerPixelUsed);
	}

	public static DecimalString newSamplingFrequency() {
		return new DecimalString(DicomTags.SamplingFrequency);
	}

	public static DecimalString newSAR() {
		return new DecimalString(DicomTags.SAR);
	}

	public static CodeString newSaturationRecovery() {
		return new CodeString(DicomTags.SaturationRecovery);
	}

	public static DecimalString newScanArc() {
		return new DecimalString(DicomTags.ScanArc);
	}

	public static IntegerString newScanLength() {
		return new IntegerString(DicomTags.ScanLength);
	}

	public static CodeString newScanningSeq() {
		return new CodeString(DicomTags.ScanningSeq);
	}

	public static CodeString newScanOptions() {
		return new CodeString(DicomTags.ScanOptions);
	}

	public static DecimalString newScanVelocity() {
		return new DecimalString(DicomTags.ScanVelocity);
	}

	public static LongString newScatterCorrectionMethod() {
		return new LongString(DicomTags.ScatterCorrectionMethod);
	}

	public static DecimalString newScatterFractionFactor() {
		return new DecimalString(DicomTags.ScatterFractionFactor);
	}

	public static DateElement newScheduledAdmissionDate() {
		return new DateElement(DicomTags.ScheduledAdmissionDate);
	}

	public static Time newScheduledAdmissionTime() {
		return new Time(DicomTags.ScheduledAdmissionTime);
	}

	public static DateElement newScheduledDischargeDate() {
		return new DateElement(DicomTags.ScheduledDischargeDate);
	}

	public static Time newScheduledDischargeTime() {
		return new Time(DicomTags.ScheduledDischargeTime);
	}

	public static SequenceOfItems newScheduledHumanPerformersSeq() {
		return new SequenceOfItems(DicomTags.ScheduledHumanPerformersSeq);
	}

	public static LongString newScheduledPatientInstitutionResidence() {
		return new LongString(DicomTags.ScheduledPatientInstitutionResidence);
	}

	public static SequenceOfItems newScheduledPerformingPhysicianIdentificationSeq() {
		return new SequenceOfItems(
				DicomTags.ScheduledPerformingPhysicianIdentificationSeq);
	}

	public static PersonName newScheduledPerformingPhysicianName() {
		return new PersonName(DicomTags.ScheduledPerformingPhysicianName);
	}

	public static LongString newScheduledProcedureStepDescription() {
		return new LongString(DicomTags.ScheduledProcedureStepDescription);
	}

	public static DateElement newScheduledProcedureStepEndDate() {
		return new DateElement(DicomTags.ScheduledProcedureStepEndDate);
	}

	public static Time newScheduledProcedureStepEndTime() {
		return new Time(DicomTags.ScheduledProcedureStepEndTime);
	}

	public static ShortString newScheduledProcedureStepID() {
		return new ShortString(DicomTags.ScheduledProcedureStepID);
	}

	public static ShortString newScheduledProcedureStepLocation() {
		return new ShortString(DicomTags.ScheduledProcedureStepLocation);
	}

	public static SequenceOfItems newScheduledProcedureStepSequence() {
		return new SequenceOfItems(DicomTags.ScheduledProcedureStepSequence);
	}

	public static DateElement newScheduledProcedureStepStartDate() {
		return new DateElement(DicomTags.ScheduledProcedureStepStartDate);
	}

	public static Time newScheduledProcedureStepStartTime() {
		return new Time(DicomTags.ScheduledProcedureStepStartTime);
	}

	public static CodeString newScheduledProcedureStepStatus() {
		return new CodeString(DicomTags.ScheduledProcedureStepStatus);
	}

	public static SequenceOfItems newScheduledProcessingApplicationsCodeSeq() {
		return new SequenceOfItems(DicomTags.ScheduledProcessingApplicationsCodeSeq);
	}

	public static SequenceOfItems newScheduledProtocolCodeSeq() {
		return new SequenceOfItems(DicomTags.ScheduledProtocolCodeSeq);
	}

	public static ApplicationEntity newScheduledStationAET() {
		return new ApplicationEntity(DicomTags.ScheduledStationAET);
	}

	public static SequenceOfItems newScheduledStationClassCodeSeq() {
		return new SequenceOfItems(DicomTags.ScheduledStationClassCodeSeq);
	}

	public static SequenceOfItems newScheduledStationGeographicLocationCodeSeq() {
		return new SequenceOfItems(
				DicomTags.ScheduledStationGeographicLocationCodeSeq);
	}

	public static ShortString newScheduledStationName() {
		return new ShortString(DicomTags.ScheduledStationName);
	}

	public static SequenceOfItems newScheduledStationNameCodeSeq() {
		return new SequenceOfItems(DicomTags.ScheduledStationNameCodeSeq);
	}

	public static SequenceOfItems newScheduledStepAttributesSeq() {
		return new SequenceOfItems(DicomTags.ScheduledStepAttributesSeq);
	}

	public static LongString newScheduledStudyLocation() {
		return new LongString(DicomTags.ScheduledStudyLocation);
	}

	public static ApplicationEntity newScheduledStudyLocationAET() {
		return new ApplicationEntity(DicomTags.ScheduledStudyLocationAET);
	}

	public static DateElement newScheduledStudyStartDate() {
		return new DateElement(DicomTags.ScheduledStudyStartDate);
	}

	public static Time newScheduledStudyStartTime() {
		return new Time(DicomTags.ScheduledStudyStartTime);
	}

	public static DateElement newScheduledStudyStopDate() {
		return new DateElement(DicomTags.ScheduledStudyStopDate);
	}

	public static Time newScheduledStudyStopTime() {
		return new Time(DicomTags.ScheduledStudyStopTime);
	}

	public static SequenceOfItems newScheduledWorkitemCodeSeq() {
		return new SequenceOfItems(DicomTags.ScheduledWorkitemCodeSeq);
	}

	public static UnsignedShort newScreenMinimumColorBitDepth() {
		return new UnsignedShort(DicomTags.ScreenMinimumColorBitDepth);
	}

	public static UnsignedShort newScreenMinimumGrayscaleBitDepth() {
		return new UnsignedShort(DicomTags.ScreenMinimumGrayscaleBitDepth);
	}

	public static LongString newSecondaryCaptureDeviceID() {
		return new LongString(DicomTags.SecondaryCaptureDeviceID);
	}

	public static LongString newSecondaryCaptureDeviceManufacturer() {
		return new LongString(DicomTags.SecondaryCaptureDeviceManufacturer);
	}

	public static LongString newSecondaryCaptureDeviceManufacturerModelName() {
		return new LongString(DicomTags.SecondaryCaptureDeviceManufacturerModelName);
	}

	public static LongString newSecondaryCaptureDeviceSoftwareVersion() {
		return new LongString(DicomTags.SecondaryCaptureDeviceSoftwareVersion);
	}

	public static IntegerString newSecondaryCountsAccumulated() {
		return new IntegerString(DicomTags.SecondaryCountsAccumulated);
	}

	public static CodeString newSecondaryCountsType() {
		return new CodeString(DicomTags.SecondaryCountsType);
	}

	public static OtherWordString newSegmentedBluePaletteColorLUTData() {
		return new OtherWordString(DicomTags.SegmentedBluePaletteColorLUTData);
	}

	public static OtherWordString newSegmentedGreenPaletteColorLUTData() {
		return new OtherWordString(DicomTags.SegmentedGreenPaletteColorLUTData);
	}

	public static CodeString newSegmentedKSpaceTraversal() {
		return new CodeString(DicomTags.SegmentedKSpaceTraversal);
	}

	public static OtherWordString newSegmentedRedPaletteColorLUTData() {
		return new OtherWordString(DicomTags.SegmentedRedPaletteColorLUTData);
	}

	public static AttributeTag newSelectorAttribute() {
		return new AttributeTag(DicomTags.SelectorAttribute);
	}

	public static LongString newSelectorAttributePrivateCreator() {
		return new LongString(DicomTags.SelectorAttributePrivateCreator);
	}

	public static CodeString newSelectorAttributeVR() {
		return new CodeString(DicomTags.SelectorAttributeVR);
	}

	public static AttributeTag newSelectorATValue() {
		return new AttributeTag(DicomTags.SelectorATValue);
	}

	public static SequenceOfItems newSelectorCodeSequenceValue() {
		return new SequenceOfItems(DicomTags.SelectorCodeSequenceValue);
	}

	public static CodeString newSelectorCSValue() {
		return new CodeString(DicomTags.SelectorCSValue);
	}

	public static DecimalString newSelectorDSValue() {
		return new DecimalString(DicomTags.SelectorDSValue);
	}

	public static FloatingPointDouble newSelectorFDValue() {
		return new FloatingPointDouble(DicomTags.SelectorFDValue);
	}

	public static FloatingPointSingle newSelectorFLValue() {
		return new FloatingPointSingle(DicomTags.SelectorFLValue);
	}

	public static IntegerString newSelectorISValue() {
		return new IntegerString(DicomTags.SelectorISValue);
	}

	public static LongString newSelectorLOValue() {
		return new LongString(DicomTags.SelectorLOValue);
	}

	public static LongText newSelectorLTValue() {
		return new LongText(DicomTags.SelectorLTValue);
	}

	public static PersonName newSelectorPNValue() {
		return new PersonName(DicomTags.SelectorPNValue);
	}

	public static AttributeTag newSelectorSequencePointer() {
		return new AttributeTag(DicomTags.SelectorSequencePointer);
	}

	public static LongString newSelectorSequencePointerPrivateCreator() {
		return new LongString(DicomTags.SelectorSequencePointerPrivateCreator);
	}

	public static ShortString newSelectorSHValue() {
		return new ShortString(DicomTags.SelectorSHValue);
	}

	public static SignedLong newSelectorSLValue() {
		return new SignedLong(DicomTags.SelectorSLValue);
	}

	public static SignedShort newSelectorSSValue() {
		return new SignedShort(DicomTags.SelectorSSValue);
	}

	public static ShortText newSelectorSTValue() {
		return new ShortText(DicomTags.SelectorSTValue);
	}

	public static UnsignedLong newSelectorULValue() {
		return new UnsignedLong(DicomTags.SelectorULValue);
	}

	public static UnsignedShort newSelectorUSValue() {
		return new UnsignedShort(DicomTags.SelectorUSValue);
	}

	public static UnlimitedText newSelectorUTValue() {
		return new UnlimitedText(DicomTags.SelectorUTValue);
	}

	public static UnsignedShort newSelectorValueNumber() {
		return new UnsignedShort(DicomTags.SelectorValueNumber);
	}

	public static DecimalString newSensitivity() {
		return new DecimalString(DicomTags.Sensitivity);
	}

	public static Unknown newSeqDelimitationItem() {
		return new Unknown(DicomTags.SeqDelimitationItem);
	}

	public static SequenceOfItems newSeqOfUltrasoundRegions() {
		return new SequenceOfItems(DicomTags.SeqOfUltrasoundRegions);
	}

	public static ShortString newSequenceName() {
		return new ShortString(DicomTags.SequenceName);
	}

	public static CodeString newSeqVariant() {
		return new CodeString(DicomTags.SeqVariant);
	}

	public static LongText newSeriesCommentsRetired() {
		return new LongText(DicomTags.SeriesCommentsRetired);
	}

	public static DateElement newSeriesDate() {
		return new DateElement(DicomTags.SeriesDate);
	}

	public static LongString newSeriesDescription() {
		return new LongString(DicomTags.SeriesDescription);
	}

	public static UniqueIdentifier newSeriesInstanceUID() {
		return new UniqueIdentifier(DicomTags.SeriesInstanceUID);
	}

	public static IntegerString newSeriesInStudy() {
		return new IntegerString(DicomTags.SeriesInStudy);
	}

	public static IntegerString newSeriesNumber() {
		return new IntegerString(DicomTags.SeriesNumber);
	}

	public static Time newSeriesTime() {
		return new Time(DicomTags.SeriesTime);
	}

	public static CodeString newSeriesType() {
		return new CodeString(DicomTags.SeriesType);
	}

	public static ShortText newSetupDeviceDescription() {
		return new ShortText(DicomTags.SetupDeviceDescription);
	}

	public static ShortString newSetupDeviceLabel() {
		return new ShortString(DicomTags.SetupDeviceLabel);
	}

	public static DecimalString newSetupDeviceParameter() {
		return new DecimalString(DicomTags.SetupDeviceParameter);
	}

	public static SequenceOfItems newSetupDeviceSeq() {
		return new SequenceOfItems(DicomTags.SetupDeviceSeq);
	}

	public static CodeString newSetupDeviceType() {
		return new CodeString(DicomTags.SetupDeviceType);
	}

	public static ShortText newSetupReferenceDescription() {
		return new ShortText(DicomTags.SetupReferenceDescription);
	}

	public static CodeString newSetupTechnique() {
		return new CodeString(DicomTags.SetupTechnique);
	}

	public static ShortText newSetupTechniqueDescription() {
		return new ShortText(DicomTags.SetupTechniqueDescription);
	}

	public static CodeString newShapeType() {
		return new CodeString(DicomTags.ShapeType);
	}

	public static SequenceOfItems newSharedFunctionalGroupsSequence() {
		return new SequenceOfItems(DicomTags.SharedFunctionalGroupsSequence);
	}

	public static ShortText newShieldingDeviceDescription() {
		return new ShortText(DicomTags.ShieldingDeviceDescription);
	}

	public static ShortString newShieldingDeviceLabel() {
		return new ShortString(DicomTags.ShieldingDeviceLabel);
	}

	public static ShortString newShieldingDevicePosition() {
		return new ShortString(DicomTags.ShieldingDevicePosition);
	}

	public static SequenceOfItems newShieldingDeviceSeq() {
		return new SequenceOfItems(DicomTags.ShieldingDeviceSeq);
	}

	public static CodeString newShieldingDeviceType() {
		return new CodeString(DicomTags.ShieldingDeviceType);
	}

	public static CodeString newShowAcquisitionTechniquesFlag() {
		return new CodeString(DicomTags.ShowAcquisitionTechniquesFlag);
	}

	public static CodeString newShowGraphicAnnotationFlag() {
		return new CodeString(DicomTags.ShowGraphicAnnotationFlag);
	}

	public static CodeString newShowGrayscaleInverted() {
		return new CodeString(DicomTags.ShowGrayscaleInverted);
	}

	public static CodeString newShowImageTrueSizeFlag() {
		return new CodeString(DicomTags.ShowImageTrueSizeFlag);
	}

	public static CodeString newShowPatientDemographicsFlag() {
		return new CodeString(DicomTags.ShowPatientDemographicsFlag);
	}

	public static IntegerString newShutterLeftVerticalEdge() {
		return new IntegerString(DicomTags.ShutterLeftVerticalEdge);
	}

	public static IntegerString newShutterLowerHorizontalEdge() {
		return new IntegerString(DicomTags.ShutterLowerHorizontalEdge);
	}

	public static UnsignedShort newShutterOverlayGroup() {
		return new UnsignedShort(DicomTags.ShutterOverlayGroup);
	}

	public static UnsignedShort newShutterPresentationValue() {
		return new UnsignedShort(DicomTags.ShutterPresentationValue);
	}

	public static IntegerString newShutterRightVerticalEdge() {
		return new IntegerString(DicomTags.ShutterRightVerticalEdge);
	}

	public static CodeString newShutterShape() {
		return new CodeString(DicomTags.ShutterShape);
	}

	public static IntegerString newShutterUpperHorizontalEdge() {
		return new IntegerString(DicomTags.ShutterUpperHorizontalEdge);
	}

	public static CodeString newSignalDomain() {
		return new CodeString(DicomTags.SignalDomain);
	}

	public static CodeString newSignalDomainRows() {
		return new CodeString(DicomTags.SignalDomainRows);
	}

	public static FloatingPointDouble newSingleCollimationWidth() {
		return new FloatingPointDouble(DicomTags.SingleCollimationWidth);
	}

	public static IntegerString newSkipBeats() {
		return new IntegerString(DicomTags.SkipBeats);
	}

	public static FloatingPointDouble newSlabOrientation() {
		return new FloatingPointDouble(DicomTags.SlabOrientation);
	}

	public static FloatingPointDouble newSlabThickness() {
		return new FloatingPointDouble(DicomTags.SlabThickness);
	}

	public static DecimalString newSliceLocation() {
		return new DecimalString(DicomTags.SliceLocation);
	}

	public static CodeString newSliceProgressionDirection() {
		return new CodeString(DicomTags.SliceProgressionDirection);
	}

	public static DecimalString newSliceSensitivityFactor() {
		return new DecimalString(DicomTags.SliceSensitivityFactor);
	}

	public static DecimalString newSliceThickness() {
		return new DecimalString(DicomTags.SliceThickness);
	}

	public static UnsignedShort newSliceVector() {
		return new UnsignedShort(DicomTags.SliceVector);
	}

	public static LongString newSlideIdentifier() {
		return new LongString(DicomTags.SlideIdentifier);
	}

	public static Unknown newSmallestImagePixelValue() {
		return new Unknown(DicomTags.SmallestImagePixelValue);
	}

	public static Unknown newSmallestImagePixelValueInPlane() {
		return new Unknown(DicomTags.SmallestImagePixelValueInPlane);
	}

	public static Unknown newSmallestPixelValueInSeries() {
		return new Unknown(DicomTags.SmallestPixelValueInSeries);
	}

	public static Unknown newSmallestValidPixelValueRetired() {
		return new Unknown(DicomTags.SmallestValidPixelValueRetired);
	}

	public static CodeString newSmokingStatus() {
		return new CodeString(DicomTags.SmokingStatus);
	}

	public static CodeString newSmoothingType() {
		return new CodeString(DicomTags.SmoothingType);
	}

	public static SequenceOfItems newSoftcopyVOILUTSeq() {
		return new SequenceOfItems(DicomTags.SoftcopyVOILUTSeq);
	}

	public static DecimalString newSoftTissueFocusThermalIndex() {
		return new DecimalString(DicomTags.SoftTissueFocusThermalIndex);
	}

	public static DecimalString newSoftTissueSurfaceThermalIndex() {
		return new DecimalString(DicomTags.SoftTissueSurfaceThermalIndex);
	}

	public static DecimalString newSoftTissueThermalIndex() {
		return new DecimalString(DicomTags.SoftTissueThermalIndex);
	}

	public static LongString newSoftwareVersion() {
		return new LongString(DicomTags.SoftwareVersion);
	}

	public static LongText newSOPAuthorizationComment() {
		return new LongText(DicomTags.SOPAuthorizationComment);
	}

	public static DateTime newSOPAuthorizationDateAndTime() {
		return new DateTime(DicomTags.SOPAuthorizationDateAndTime);
	}

	public static UniqueIdentifier newSOPClassesSupported() {
		return new UniqueIdentifier(DicomTags.SOPClassesSupported);
	}

	public static UniqueIdentifier newSOPClassUID() {
		return new UniqueIdentifier(DicomTags.SOPClassUID);
	}

	public static CodeString newSOPInstanceStatus() {
		return new CodeString(DicomTags.SOPInstanceStatus);
	}

	public static UniqueIdentifier newSOPInstanceUID() {
		return new UniqueIdentifier(DicomTags.SOPInstanceUID);
	}

	public static CodeString newSortByCategory() {
		return new CodeString(DicomTags.SortByCategory);
	}

	public static CodeString newSortingDirection() {
		return new CodeString(DicomTags.SortingDirection);
	}

	public static SequenceOfItems newSortingOperationsSeq() {
		return new SequenceOfItems(DicomTags.SortingOperationsSeq);
	}

	public static ApplicationEntity newSourceApplicationEntityTitle() {
		return new ApplicationEntity(DicomTags.SourceApplicationEntityTitle);
	}

	public static ShortString newSourceApplicatorID() {
		return new ShortString(DicomTags.SourceApplicatorID);
	}

	public static DecimalString newSourceApplicatorLength() {
		return new DecimalString(DicomTags.SourceApplicatorLength);
	}

	public static LongString newSourceApplicatorManufacturer() {
		return new LongString(DicomTags.SourceApplicatorManufacturer);
	}

	public static LongString newSourceApplicatorName() {
		return new LongString(DicomTags.SourceApplicatorName);
	}

	public static IntegerString newSourceApplicatorNumber() {
		return new IntegerString(DicomTags.SourceApplicatorNumber);
	}

	public static DecimalString newSourceApplicatorStepSize() {
		return new DecimalString(DicomTags.SourceApplicatorStepSize);
	}

	public static CodeString newSourceApplicatorType() {
		return new CodeString(DicomTags.SourceApplicatorType);
	}

	public static DecimalString newSourceApplicatorWallNominalThickness() {
		return new DecimalString(DicomTags.SourceApplicatorWallNominalThickness);
	}

	public static DecimalString newSourceApplicatorWallNominalTransmission() {
		return new DecimalString(DicomTags.SourceApplicatorWallNominalTransmission);
	}

	public static DecimalString newSourceAxisDistance() {
		return new DecimalString(DicomTags.SourceAxisDistance);
	}

	public static DecimalString newSourceEncapsulationNominalThickness() {
		return new DecimalString(DicomTags.SourceEncapsulationNominalThickness);
	}

	public static DecimalString newSourceEncapsulationNominalTransmission() {
		return new DecimalString(DicomTags.SourceEncapsulationNominalTransmission);
	}

	public static SequenceOfItems newSourceHangingProtocolSeq() {
		return new SequenceOfItems(DicomTags.SourceHangingProtocolSeq);
	}

	public static SequenceOfItems newSourceImageEvidenceSeq() {
		return new SequenceOfItems(DicomTags.SourceImageEvidenceSeq);
	}

	public static SequenceOfItems newSourceImageSeq() {
		return new SequenceOfItems(DicomTags.SourceImageSeq);
	}

	public static SequenceOfItems newSourceInstanceSeq() {
		return new SequenceOfItems(DicomTags.SourceInstanceSeq);
	}

	public static DecimalString newSourceIsotopeHalfLife() {
		return new DecimalString(DicomTags.SourceIsotopeHalfLife);
	}

	public static LongString newSourceIsotopeName() {
		return new LongString(DicomTags.SourceIsotopeName);
	}

	public static LongString newSourceManufacturer() {
		return new LongString(DicomTags.SourceManufacturer);
	}

	public static CodeString newSourceMovementType() {
		return new CodeString(DicomTags.SourceMovementType);
	}

	public static IntegerString newSourceNumber() {
		return new IntegerString(DicomTags.SourceNumber);
	}

	public static SequenceOfItems newSourceSeq() {
		return new SequenceOfItems(DicomTags.SourceSeq);
	}

	public static LongString newSourceSerialNumber() {
		return new LongString(DicomTags.SourceSerialNumber);
	}

	public static DecimalString newSourceToBeamLimitingDeviceDistance() {
		return new DecimalString(DicomTags.SourceToBeamLimitingDeviceDistance);
	}

	public static DecimalString newSourceToBlockTrayDistance() {
		return new DecimalString(DicomTags.SourceToBlockTrayDistance);
	}

	public static DecimalString newSourceToCompensatorTrayDistance() {
		return new DecimalString(DicomTags.SourceToCompensatorTrayDistance);
	}

	public static DecimalString newSourceToReferenceObjectDistance() {
		return new DecimalString(DicomTags.SourceToReferenceObjectDistance);
	}

	public static DecimalString newSourceToSurfaceDistance() {
		return new DecimalString(DicomTags.SourceToSurfaceDistance);
	}

	public static DecimalString newSourceToWedgeTrayDistance() {
		return new DecimalString(DicomTags.SourceToWedgeTrayDistance);
	}

	public static CodeString newSourceType() {
		return new CodeString(DicomTags.SourceType);
	}

	public static SequenceOfItems newSourceWaveformSeq() {
		return new SequenceOfItems(DicomTags.SourceWaveformSeq);
	}

	public static DecimalString newSpacingBetweenSlices() {
		return new DecimalString(DicomTags.SpacingBetweenSlices);
	}

	public static CodeString newSpatialPreSaturation() {
		return new CodeString(DicomTags.SpatialPreSaturation);
	}

	public static DecimalString newSpatialResolution() {
		return new DecimalString(DicomTags.SpatialResolution);
	}

	public static LongString newSpecialNeeds() {
		return new LongString(DicomTags.SpecialNeeds);
	}

	public static CodeString newSpecificAbsorptionRateDefinition() {
		return new CodeString(DicomTags.SpecificAbsorptionRateDefinition);
	}

	public static SequenceOfItems newSpecificAbsorptionRateSeq() {
		return new SequenceOfItems(DicomTags.SpecificAbsorptionRateSeq);
	}

	public static FloatingPointDouble newSpecificAbsorptionRateValue() {
		return new FloatingPointDouble(DicomTags.SpecificAbsorptionRateValue);
	}

	public static CodeString newSpecificCharacterSet() {
		return new CodeString(DicomTags.SpecificCharacterSet);
	}

	public static CodeString newSpecificCharacterSetOfFileSetDescriptorFile() {
		return new CodeString(DicomTags.SpecificCharacterSetOfFileSetDescriptorFile);
	}

	public static DecimalString newSpecifiedChannelTotalTime() {
		return new DecimalString(DicomTags.SpecifiedChannelTotalTime);
	}

	public static DecimalString newSpecifiedMeterset() {
		return new DecimalString(DicomTags.SpecifiedMeterset);
	}

	public static IntegerString newSpecifiedNumberOfPulses() {
		return new IntegerString(DicomTags.SpecifiedNumberOfPulses);
	}

	public static DecimalString newSpecifiedPrimaryMeterset() {
		return new DecimalString(DicomTags.SpecifiedPrimaryMeterset);
	}

	public static DecimalString newSpecifiedPulseRepetitionInterval() {
		return new DecimalString(DicomTags.SpecifiedPulseRepetitionInterval);
	}

	public static DecimalString newSpecifiedSecondaryMeterset() {
		return new DecimalString(DicomTags.SpecifiedSecondaryMeterset);
	}

	public static DecimalString newSpecifiedTreatmentTime() {
		return new DecimalString(DicomTags.SpecifiedTreatmentTime);
	}

	public static LongString newSpecimenAccessionNumber() {
		return new LongString(DicomTags.SpecimenAccessionNumber);
	}

	public static LongString newSpecimenIdentifier() {
		return new LongString(DicomTags.SpecimenIdentifier);
	}

	public static SequenceOfItems newSpecimenSeq() {
		return new SequenceOfItems(DicomTags.SpecimenSeq);
	}

	public static SequenceOfItems newSpecimenTypeCodeSeq() {
		return new SequenceOfItems(DicomTags.SpecimenTypeCodeSeq);
	}

	public static CodeString newSpectrallySelectedExcitation() {
		return new CodeString(DicomTags.SpectrallySelectedExcitation);
	}

	public static CodeString newSpectrallySelectedSuppression() {
		return new CodeString(DicomTags.SpectrallySelectedSuppression);
	}

	public static FloatingPointDouble newSpectralWidth() {
		return new FloatingPointDouble(DicomTags.SpectralWidth);
	}

	public static UnsignedLong newSpectroscopyAcquisitionDataColumns() {
		return new UnsignedLong(DicomTags.SpectroscopyAcquisitionDataColumns);
	}

	public static UnsignedLong newSpectroscopyAcquisitionOutOfPlanePhaseSteps() {
		return new UnsignedLong(
				DicomTags.SpectroscopyAcquisitionOutOfPlanePhaseSteps);
	}

	public static UnsignedLong newSpectroscopyAcquisitionPhaseColumns() {
		return new UnsignedLong(DicomTags.SpectroscopyAcquisitionPhaseColumns);
	}

	public static UnsignedLong newSpectroscopyAcquisitionPhaseRows() {
		return new UnsignedLong(DicomTags.SpectroscopyAcquisitionPhaseRows);
	}

	public static OtherFloatString newSpectroscopyData() {
		return new OtherFloatString(DicomTags.SpectroscopyData);
	}

	public static FloatingPointSingle newSphericalLensPower() {
		return new FloatingPointSingle(DicomTags.SphericalLensPower);
	}

	public static FloatingPointDouble newSpiralPitchFactor() {
		return new FloatingPointDouble(DicomTags.SpiralPitchFactor);
	}

	public static CodeString newSpoiling() {
		return new CodeString(DicomTags.Spoiling);
	}

	public static LongText newSPSComments() {
		return new LongText(DicomTags.SPSComments);
	}

	public static DateTime newSPSStartDateAndTime() {
		return new DateTime(DicomTags.SPSStartDateAndTime);
	}

	public static ShortString newStackID() {
		return new ShortString(DicomTags.StackID);
	}

	public static ShortString newStageName() {
		return new ShortString(DicomTags.StageName);
	}

	public static IntegerString newStageNumber() {
		return new IntegerString(DicomTags.StageNumber);
	}

	public static DecimalString newStartAngle() {
		return new DecimalString(DicomTags.StartAngle);
	}

	public static DecimalString newStartCumulativeMetersetWeight() {
		return new DecimalString(DicomTags.StartCumulativeMetersetWeight);
	}

	public static DecimalString newStartMeterset() {
		return new DecimalString(DicomTags.StartMeterset);
	}

	public static IntegerString newStartTrim() {
		return new IntegerString(DicomTags.StartTrim);
	}

	public static ShortString newStationName() {
		return new ShortString(DicomTags.StationName);
	}

	public static UnsignedShort newStatus() {
		return new UnsignedShort(DicomTags.Status);
	}

	public static CodeString newSteadyStatePulseSeq() {
		return new CodeString(DicomTags.SteadyStatePulseSeq);
	}

	public static FloatingPointDouble newSteeringAngle() {
		return new FloatingPointDouble(DicomTags.SteeringAngle);
	}

	public static FloatingPointSingle newStereoBaselineAngle() {
		return new FloatingPointSingle(DicomTags.StereoBaselineAngle);
	}

	public static FloatingPointSingle newStereoBaselineDisplacement() {
		return new FloatingPointSingle(DicomTags.StereoBaselineDisplacement);
	}

	public static FloatingPointSingle newStereoHorizontalPixelOffset() {
		return new FloatingPointSingle(DicomTags.StereoHorizontalPixelOffset);
	}

	public static SequenceOfItems newStereoPairsSeq() {
		return new SequenceOfItems(DicomTags.StereoPairsSeq);
	}

	public static FloatingPointSingle newStereoRotation() {
		return new FloatingPointSingle(DicomTags.StereoRotation);
	}

	public static FloatingPointSingle newStereoVerticalPixelOffset() {
		return new FloatingPointSingle(DicomTags.StereoVerticalPixelOffset);
	}

	public static IntegerString newStopTrim() {
		return new IntegerString(DicomTags.StopTrim);
	}

	public static ShortString newStorageMediaFileSetID() {
		return new ShortString(DicomTags.StorageMediaFileSetID);
	}

	public static UniqueIdentifier newStorageMediaFileSetUID() {
		return new UniqueIdentifier(DicomTags.StorageMediaFileSetUID);
	}

	public static DateElement newStructureSetDate() {
		return new DateElement(DicomTags.StructureSetDate);
	}

	public static ShortText newStructureSetDescription() {
		return new ShortText(DicomTags.StructureSetDescription);
	}

	public static ShortString newStructureSetLabel() {
		return new ShortString(DicomTags.StructureSetLabel);
	}

	public static LongString newStructureSetName() {
		return new LongString(DicomTags.StructureSetName);
	}

	public static SequenceOfItems newStructureSetROISeq() {
		return new SequenceOfItems(DicomTags.StructureSetROISeq);
	}

	public static Time newStructureSetTime() {
		return new Time(DicomTags.StructureSetTime);
	}

	public static SequenceOfItems newStudiesContainingOtherReferencedInstancesSeq() {
		return new SequenceOfItems(
				DicomTags.StudiesContainingOtherReferencedInstancesSeq);
	}

	public static DateElement newStudyArrivalDate() {
		return new DateElement(DicomTags.StudyArrivalDate);
	}

	public static Time newStudyArrivalTime() {
		return new Time(DicomTags.StudyArrivalTime);
	}

	public static LongText newStudyComments() {
		return new LongText(DicomTags.StudyComments);
	}

	public static LongText newStudyCommentsRetired() {
		return new LongText(DicomTags.StudyCommentsRetired);
	}

	public static DateElement newStudyCompletionDate() {
		return new DateElement(DicomTags.StudyCompletionDate);
	}

	public static Time newStudyCompletionTime() {
		return new Time(DicomTags.StudyCompletionTime);
	}

	public static CodeString newStudyComponentStatusID() {
		return new CodeString(DicomTags.StudyComponentStatusID);
	}

	public static DateElement newStudyDate() {
		return new DateElement(DicomTags.StudyDate);
	}

	public static LongString newStudyDescription() {
		return new LongString(DicomTags.StudyDescription);
	}

	public static ShortString newStudyID() {
		return new ShortString(DicomTags.StudyID);
	}

	public static LongString newStudyIDIssuer() {
		return new LongString(DicomTags.StudyIDIssuer);
	}

	public static UniqueIdentifier newStudyInstanceUID() {
		return new UniqueIdentifier(DicomTags.StudyInstanceUID);
	}

	public static CodeString newStudyPriorityID() {
		return new CodeString(DicomTags.StudyPriorityID);
	}

	public static DateElement newStudyReadDate() {
		return new DateElement(DicomTags.StudyReadDate);
	}

	public static Time newStudyReadTime() {
		return new Time(DicomTags.StudyReadTime);
	}

	public static CodeString newStudyStatusID() {
		return new CodeString(DicomTags.StudyStatusID);
	}

	public static Time newStudyTime() {
		return new Time(DicomTags.StudyTime);
	}

	public static DateElement newStudyVerifiedDate() {
		return new DateElement(DicomTags.StudyVerifiedDate);
	}

	public static Time newStudyVerifiedTime() {
		return new Time(DicomTags.StudyVerifiedTime);
	}

	public static SequenceOfItems newSupportedImageDisplayFormatsSeq() {
		return new SequenceOfItems(DicomTags.SupportedImageDisplayFormatsSeq);
	}

	public static DecimalString newSurfaceEntryPoint() {
		return new DecimalString(DicomTags.SurfaceEntryPoint);
	}

	public static UnsignedShort newSynchronizationChannel() {
		return new UnsignedShort(DicomTags.SynchronizationChannel);
	}

	public static UniqueIdentifier newSynchronizationFrameOfReferenceUID() {
		return new UniqueIdentifier(DicomTags.SynchronizationFrameOfReferenceUID);
	}

	public static CodeString newSynchronizationTrigger() {
		return new CodeString(DicomTags.SynchronizationTrigger);
	}

	public static SequenceOfItems newSynchronizedScrollingSeq() {
		return new SequenceOfItems(DicomTags.SynchronizedScrollingSeq);
	}

	public static IntegerString newSyringeCounts() {
		return new IntegerString(DicomTags.SyringeCounts);
	}

	public static CodeString newT2Preparation() {
		return new CodeString(DicomTags.T2Preparation);
	}

	public static DecimalString newTableAngle() {
		return new DecimalString(DicomTags.TableAngle);
	}

	public static FloatingPointDouble newTableFeedPerRotation() {
		return new FloatingPointDouble(DicomTags.TableFeedPerRotation);
	}

	public static DecimalString newTableHeight() {
		return new DecimalString(DicomTags.TableHeight);
	}

	public static DecimalString newTableLateralIncrement() {
		return new DecimalString(DicomTags.TableLateralIncrement);
	}

	public static DecimalString newTableLongitudinalIncrement() {
		return new DecimalString(DicomTags.TableLongitudinalIncrement);
	}

	public static CodeString newTableMotion() {
		return new CodeString(DicomTags.TableMotion);
	}

	public static FloatingPointSingle newTableOfParameterValues() {
		return new FloatingPointSingle(DicomTags.TableOfParameterValues);
	}

	public static UnsignedLong newTableOfPixelValues() {
		return new UnsignedLong(DicomTags.TableOfPixelValues);
	}

	public static UnsignedLong newTableOfXBreakPoints() {
		return new UnsignedLong(DicomTags.TableOfXBreakPoints);
	}

	public static FloatingPointDouble newTableOfYBreakPoints() {
		return new FloatingPointDouble(DicomTags.TableOfYBreakPoints);
	}

	public static FloatingPointDouble newTablePosition() {
		return new FloatingPointDouble(DicomTags.TablePosition);
	}

	public static FloatingPointDouble newTableSpeed() {
		return new FloatingPointDouble(DicomTags.TableSpeed);
	}

	public static DecimalString newTableTopEccentricAngle() {
		return new DecimalString(DicomTags.TableTopEccentricAngle);
	}

	public static DecimalString newTableTopEccentricAngleTolerance() {
		return new DecimalString(DicomTags.TableTopEccentricAngleTolerance);
	}

	public static DecimalString newTableTopEccentricAxisDistance() {
		return new DecimalString(DicomTags.TableTopEccentricAxisDistance);
	}

	public static CodeString newTableTopEccentricRotationDirection() {
		return new CodeString(DicomTags.TableTopEccentricRotationDirection);
	}

	public static DecimalString newTableTopLateralPosition() {
		return new DecimalString(DicomTags.TableTopLateralPosition);
	}

	public static DecimalString newTableTopLateralPositionTolerance() {
		return new DecimalString(DicomTags.TableTopLateralPositionTolerance);
	}

	public static DecimalString newTableTopLateralSetupDisplacement() {
		return new DecimalString(DicomTags.TableTopLateralSetupDisplacement);
	}

	public static DecimalString newTableTopLongitudinalPosition() {
		return new DecimalString(DicomTags.TableTopLongitudinalPosition);
	}

	public static DecimalString newTableTopLongitudinalPositionTolerance() {
		return new DecimalString(DicomTags.TableTopLongitudinalPositionTolerance);
	}

	public static DecimalString newTableTopLongitudinalSetupDisplacement() {
		return new DecimalString(DicomTags.TableTopLongitudinalSetupDisplacement);
	}

	public static DecimalString newTableTopVerticalPosition() {
		return new DecimalString(DicomTags.TableTopVerticalPosition);
	}

	public static DecimalString newTableTopVerticalPositionTolerance() {
		return new DecimalString(DicomTags.TableTopVerticalPositionTolerance);
	}

	public static DecimalString newTableTopVerticalSetupDisplacement() {
		return new DecimalString(DicomTags.TableTopVerticalSetupDisplacement);
	}

	public static DecimalString newTableTraverse() {
		return new DecimalString(DicomTags.TableTraverse);
	}

	public static CodeString newTableType() {
		return new CodeString(DicomTags.TableType);
	}

	public static DecimalString newTableVerticalIncrement() {
		return new DecimalString(DicomTags.TableVerticalIncrement);
	}

	public static FloatingPointDouble newTagAngleFirstAxis() {
		return new FloatingPointDouble(DicomTags.TagAngleFirstAxis);
	}

	public static SignedShort newTagAngleSecondAxis() {
		return new SignedShort(DicomTags.TagAngleSecondAxis);
	}

	public static CodeString newTagging() {
		return new CodeString(DicomTags.Tagging);
	}

	public static FloatingPointDouble newTaggingDelay() {
		return new FloatingPointDouble(DicomTags.TaggingDelay);
	}

	public static FloatingPointDouble newTagSpacingFirstDimension() {
		return new FloatingPointDouble(DicomTags.TagSpacingFirstDimension);
	}

	public static FloatingPointDouble newTagSpacingSecondDimension() {
		return new FloatingPointDouble(DicomTags.TagSpacingSecondDimension);
	}

	public static FloatingPointDouble newTagThickness() {
		return new FloatingPointDouble(DicomTags.TagThickness);
	}

	public static DecimalString newTargetMaximumDose() {
		return new DecimalString(DicomTags.TargetMaximumDose);
	}

	public static DecimalString newTargetMinimumDose() {
		return new DecimalString(DicomTags.TargetMinimumDose);
	}

	public static DecimalString newTargetPrescriptionDose() {
		return new DecimalString(DicomTags.TargetPrescriptionDose);
	}

	public static DecimalString newTargetUnderdoseVolumeFraction() {
		return new DecimalString(DicomTags.TargetUnderdoseVolumeFraction);
	}

	public static UniqueIdentifier newTemplateExtensionCreatorUID() {
		return new UniqueIdentifier(DicomTags.TemplateExtensionCreatorUID);
	}

	public static CodeString newTemplateExtensionFlag() {
		return new CodeString(DicomTags.TemplateExtensionFlag);
	}

	public static UniqueIdentifier newTemplateExtensionOrganizationUID() {
		return new UniqueIdentifier(DicomTags.TemplateExtensionOrganizationUID);
	}

	public static CodeString newTemplateIdentifier() {
		return new CodeString(DicomTags.TemplateIdentifier);
	}

	public static DateTime newTemplateLocalVersion() {
		return new DateTime(DicomTags.TemplateLocalVersion);
	}

	public static LongString newTemplateName() {
		return new LongString(DicomTags.TemplateName);
	}

	public static IntegerString newTemplateNumber() {
		return new IntegerString(DicomTags.TemplateNumber);
	}

	public static ShortString newTemplateType() {
		return new ShortString(DicomTags.TemplateType);
	}

	public static DateTime newTemplateVersion() {
		return new DateTime(DicomTags.TemplateVersion);
	}

	public static IntegerString newTemporalPositionIdentifier() {
		return new IntegerString(DicomTags.TemporalPositionIdentifier);
	}

	public static UnsignedLong newTemporalPositionIndex() {
		return new UnsignedLong(DicomTags.TemporalPositionIndex);
	}

	public static CodeString newTemporalRangeType() {
		return new CodeString(DicomTags.TemporalRangeType);
	}

	public static DecimalString newTemporalResolution() {
		return new DecimalString(DicomTags.TemporalResolution);
	}

	public static Unknown newTerminalTypeRetired() {
		return new Unknown(DicomTags.TerminalTypeRetired);
	}

	public static Unknown newTextFormatIDRetired() {
		return new Unknown(DicomTags.TextFormatIDRetired);
	}

	public static SequenceOfItems newTextObjectSeq() {
		return new SequenceOfItems(DicomTags.TextObjectSeq);
	}

	public static LongString newTextString() {
		return new LongString(DicomTags.TextString);
	}

	public static UnlimitedText newTextValue() {
		return new UnlimitedText(DicomTags.TextValue);
	}

	public static CodeString newTherapyDescription() {
		return new CodeString(DicomTags.TherapyDescription);
	}

	public static CodeString newTherapyType() {
		return new CodeString(DicomTags.TherapyType);
	}

	public static CodeString newThresholdDensityRetired() {
		return new CodeString(DicomTags.ThresholdDensityRetired);
	}

	public static SignedShort newTIDOffset() {
		return new SignedShort(DicomTags.TIDOffset);
	}

	public static Time newTime() {
		return new Time(DicomTags.Time);
	}

	public static SequenceOfItems newTimeBasedImageSetsSeq() {
		return new SequenceOfItems(DicomTags.TimeBasedImageSetsSeq);
	}

	public static CodeString newTimeDistributionProtocol() {
		return new CodeString(DicomTags.TimeDistributionProtocol);
	}

	public static CodeString newTimeDomainFiltering() {
		return new CodeString(DicomTags.TimeDomainFiltering);
	}

	public static CodeString newTimeOfFlightContrast() {
		return new CodeString(DicomTags.TimeOfFlightContrast);
	}

	public static Time newTimeOfLastCalibration() {
		return new Time(DicomTags.TimeOfLastCalibration);
	}

	public static Time newTimeOfLastDetectorCalibration() {
		return new Time(DicomTags.TimeOfLastDetectorCalibration);
	}

	public static Time newTimeOfSecondaryCapture() {
		return new Time(DicomTags.TimeOfSecondaryCapture);
	}

	public static UnsignedShort newTimeSliceVector() {
		return new UnsignedShort(DicomTags.TimeSliceVector);
	}

	public static SequenceOfItems newTimeSlotInformationSeq() {
		return new SequenceOfItems(DicomTags.TimeSlotInformationSeq);
	}

	public static IntegerString newTimeSlotNumberRetired() {
		return new IntegerString(DicomTags.TimeSlotNumberRetired);
	}

	public static DecimalString newTimeSlotTime() {
		return new DecimalString(DicomTags.TimeSlotTime);
	}

	public static UnsignedShort newTimeSlotVector() {
		return new UnsignedShort(DicomTags.TimeSlotVector);
	}

	public static ShortString newTimeSource() {
		return new ShortString(DicomTags.TimeSource);
	}

	public static ShortString newTimezoneOffsetFromUTC() {
		return new ShortString(DicomTags.TimezoneOffsetFromUTC);
	}

	public static UnsignedLong newTMLinePositionX0() {
		return new UnsignedLong(DicomTags.TMLinePositionX0);
	}

	public static UnsignedLong newTMLinePositionX1() {
		return new UnsignedLong(DicomTags.TMLinePositionX1);
	}

	public static UnsignedLong newTMLinePositionY0() {
		return new UnsignedLong(DicomTags.TMLinePositionY0);
	}

	public static UnsignedLong newTMLinePositionY1() {
		return new UnsignedLong(DicomTags.TMLinePositionY1);
	}

	public static ShortString newToleranceTableLabel() {
		return new ShortString(DicomTags.ToleranceTableLabel);
	}

	public static IntegerString newToleranceTableNumber() {
		return new IntegerString(DicomTags.ToleranceTableNumber);
	}

	public static SequenceOfItems newToleranceTableSeq() {
		return new SequenceOfItems(DicomTags.ToleranceTableSeq);
	}

	public static DecimalString newTomoAngle() {
		return new DecimalString(DicomTags.TomoAngle);
	}

	public static CodeString newTomoClass() {
		return new CodeString(DicomTags.TomoClass);
	}

	public static DecimalString newTomoLayerHeight() {
		return new DecimalString(DicomTags.TomoLayerHeight);
	}

	public static DecimalString newTomoTime() {
		return new DecimalString(DicomTags.TomoTime);
	}

	public static CodeString newTomoType() {
		return new CodeString(DicomTags.TomoType);
	}

	public static LongString newTopicAuthor() {
		return new LongString(DicomTags.TopicAuthor);
	}

	public static LongString newTopicKeyWords() {
		return new LongString(DicomTags.TopicKeyWords);
	}

	public static ShortText newTopicSubject() {
		return new ShortText(DicomTags.TopicSubject);
	}

	public static LongString newTopicTitle() {
		return new LongString(DicomTags.TopicTitle);
	}

	public static DecimalString newTotalBlockTrayFactor() {
		return new DecimalString(DicomTags.TotalBlockTrayFactor);
	}

	public static FloatingPointDouble newTotalCollimationWidth() {
		return new FloatingPointDouble(DicomTags.TotalCollimationWidth);
	}

	public static DecimalString newTotalCompensatorTrayFactor() {
		return new DecimalString(DicomTags.TotalCompensatorTrayFactor);
	}

	public static Unknown newTotalGainRetired() {
		return new Unknown(DicomTags.TotalGainRetired);
	}

	public static UnsignedShort newTotalNumberOfExposures() {
		return new UnsignedShort(DicomTags.TotalNumberOfExposures);
	}

	public static UnsignedShort newTotalNumberOfPiecesOfMediaCreated() {
		return new UnsignedShort(DicomTags.TotalNumberOfPiecesOfMediaCreated);
	}

	public static DecimalString newTotalReferenceAirKerma() {
		return new DecimalString(DicomTags.TotalReferenceAirKerma);
	}

	public static UnsignedShort newTotalTimeOfFluoroscopy() {
		return new UnsignedShort(DicomTags.TotalTimeOfFluoroscopy);
	}

	public static UniqueIdentifier newTransactionUID() {
		return new UniqueIdentifier(DicomTags.TransactionUID);
	}

	public static LongString newTransducerData() {
		return new LongString(DicomTags.TransducerData);
	}

	public static UnsignedLong newTransducerFrequency() {
		return new UnsignedLong(DicomTags.TransducerFrequency);
	}

	public static SequenceOfItems newTransducerOrientationModifierSeq() {
		return new SequenceOfItems(DicomTags.TransducerOrientationModifierSeq);
	}

	public static CodeString newTransducerOrientationRetired() {
		return new CodeString(DicomTags.TransducerOrientationRetired);
	}

	public static SequenceOfItems newTransducerOrientationSeq() {
		return new SequenceOfItems(DicomTags.TransducerOrientationSeq);
	}

	public static SequenceOfItems newTransducerPositionModifierSeq() {
		return new SequenceOfItems(DicomTags.TransducerPositionModifierSeq);
	}

	public static CodeString newTransducerPositionRetired() {
		return new CodeString(DicomTags.TransducerPositionRetired);
	}

	public static SequenceOfItems newTransducerPositionSeq() {
		return new SequenceOfItems(DicomTags.TransducerPositionSeq);
	}

	public static CodeString newTransducerType() {
		return new CodeString(DicomTags.TransducerType);
	}

	public static UniqueIdentifier newTransferSyntaxUID() {
		return new UniqueIdentifier(DicomTags.TransferSyntaxUID);
	}

	public static DecimalString newTransferTubeLength() {
		return new DecimalString(DicomTags.TransferTubeLength);
	}

	public static IntegerString newTransferTubeNumber() {
		return new IntegerString(DicomTags.TransferTubeNumber);
	}

	public static LongString newTransmitCoilManufacturerName() {
		return new LongString(DicomTags.TransmitCoilManufacturerName);
	}

	public static ShortString newTransmitCoilName() {
		return new ShortString(DicomTags.TransmitCoilName);
	}

	public static CodeString newTransmitCoilType() {
		return new CodeString(DicomTags.TransmitCoilType);
	}

	public static FloatingPointDouble newTransmitterFrequency() {
		return new FloatingPointDouble(DicomTags.TransmitterFrequency);
	}

	public static IntegerString newTransverseMash() {
		return new IntegerString(DicomTags.TransverseMash);
	}

	public static DateElement newTreatmentControlPointDate() {
		return new DateElement(DicomTags.TreatmentControlPointDate);
	}

	public static Time newTreatmentControlPointTime() {
		return new Time(DicomTags.TreatmentControlPointTime);
	}

	public static DateElement newTreatmentDate() {
		return new DateElement(DicomTags.TreatmentDate);
	}

	public static CodeString newTreatmentDeliveryType() {
		return new CodeString(DicomTags.TreatmentDeliveryType);
	}

	public static CodeString newTreatmentIntent() {
		return new CodeString(DicomTags.TreatmentIntent);
	}

	public static ShortString newTreatmentMachineName() {
		return new ShortString(DicomTags.TreatmentMachineName);
	}

	public static SequenceOfItems newTreatmentMachineSeq() {
		return new SequenceOfItems(DicomTags.TreatmentMachineSeq);
	}

	public static LongString newTreatmentProtocols() {
		return new LongString(DicomTags.TreatmentProtocols);
	}

	public static SequenceOfItems newTreatmentSessionApplicationSetupSeq() {
		return new SequenceOfItems(DicomTags.TreatmentSessionApplicationSetupSeq);
	}

	public static SequenceOfItems newTreatmentSessionBeamSeq() {
		return new SequenceOfItems(DicomTags.TreatmentSessionBeamSeq);
	}

	public static LongString newTreatmentSites() {
		return new LongString(DicomTags.TreatmentSites);
	}

	public static ShortText newTreatmentStatusComment() {
		return new ShortText(DicomTags.TreatmentStatusComment);
	}

	public static SequenceOfItems newTreatmentSummaryCalculatedDoseReferenceSeq() {
		return new SequenceOfItems(
				DicomTags.TreatmentSummaryCalculatedDoseReferenceSeq);
	}

	public static SequenceOfItems newTreatmentSummaryMeasuredDoseReferenceSeq() {
		return new SequenceOfItems(
				DicomTags.TreatmentSummaryMeasuredDoseReferenceSeq);
	}

	public static ShortString newTreatmentTerminationCode() {
		return new ShortString(DicomTags.TreatmentTerminationCode);
	}

	public static CodeString newTreatmentTerminationStatus() {
		return new CodeString(DicomTags.TreatmentTerminationStatus);
	}

	public static Time newTreatmentTime() {
		return new Time(DicomTags.TreatmentTime);
	}

	public static CodeString newTreatmentVerificationStatus() {
		return new CodeString(DicomTags.TreatmentVerificationStatus);
	}

	public static FloatingPointDouble newTriggerDelayTime() {
		return new FloatingPointDouble(DicomTags.TriggerDelayTime);
	}

	public static UnsignedLong newTriggerSamplePosition() {
		return new UnsignedLong(DicomTags.TriggerSamplePosition);
	}

	public static LongString newTriggerSourceOrType() {
		return new LongString(DicomTags.TriggerSourceOrType);
	}

	public static DecimalString newTriggerTime() {
		return new DecimalString(DicomTags.TriggerTime);
	}

	public static DecimalString newTriggerTimeOffset() {
		return new DecimalString(DicomTags.TriggerTimeOffset);
	}

	public static IntegerString newTriggerVector() {
		return new IntegerString(DicomTags.TriggerVector);
	}

	public static IntegerString newTriggerWindow() {
		return new IntegerString(DicomTags.TriggerWindow);
	}

	public static CodeString newTrim() {
		return new CodeString(DicomTags.Trim);
	}

	public static FloatingPointDouble newTubeAngle() {
		return new FloatingPointDouble(DicomTags.TubeAngle);
	}

	public static CodeString newTypeOfDetectorMotion() {
		return new CodeString(DicomTags.TypeOfDetectorMotion);
	}

	public static LongString newTypeOfFilters() {
		return new LongString(DicomTags.TypeOfFilters);
	}

	public static UniqueIdentifier newUID() {
		return new UniqueIdentifier(DicomTags.UID);
	}

	public static UnsignedShort newUltrasoundColorDataPresent() {
		return new UnsignedShort(DicomTags.UltrasoundColorDataPresent);
	}

	public static ShortText newUnformattedTextValue() {
		return new ShortText(DicomTags.UnformattedTextValue);
	}

	public static CodeString newUnits() {
		return new CodeString(DicomTags.Units);
	}

	public static Unknown newUpperLowerPixelValuesRetired() {
		return new Unknown(DicomTags.UpperLowerPixelValuesRetired);
	}

	public static SequenceOfItems newUsedFiducialsSeq() {
		return new SequenceOfItems(DicomTags.UsedFiducialsSeq);
	}

	public static CodeString newValueType() {
		return new CodeString(DicomTags.ValueType);
	}

	public static CodeString newVariableFlipAngleFlag() {
		return new CodeString(DicomTags.VariableFlipAngleFlag);
	}

	public static FloatingPointDouble newVelocityEncodingDirection() {
		return new FloatingPointDouble(DicomTags.VelocityEncodingDirection);
	}

	public static FloatingPointDouble newVelocityEncodingMaximumValue() {
		return new FloatingPointDouble(DicomTags.VelocityEncodingMaximumValue);
	}

	public static FloatingPointDouble newVelocityEncodingMinimumValue() {
		return new FloatingPointDouble(DicomTags.VelocityEncodingMinimumValue);
	}

	public static DateTime newVerificationDateTime() {
		return new DateTime(DicomTags.VerificationDateTime);
	}

	public static CodeString newVerificationFlag() {
		return new CodeString(DicomTags.VerificationFlag);
	}

	public static SequenceOfItems newVerifyingObserverIdentificationCodeSeq() {
		return new SequenceOfItems(DicomTags.VerifyingObserverIdentificationCodeSeq);
	}

	public static PersonName newVerifyingObserverName() {
		return new PersonName(DicomTags.VerifyingObserverName);
	}

	public static SequenceOfItems newVerifyingObserverSeq() {
		return new SequenceOfItems(DicomTags.VerifyingObserverSeq);
	}

	public static LongString newVerifyingOrganization() {
		return new LongString(DicomTags.VerifyingOrganization);
	}

	public static IntegerString newVerticesOfPolygonalCollimator() {
		return new IntegerString(DicomTags.VerticesOfPolygonalCollimator);
	}

	public static IntegerString newVerticesOfPolygonalShutter() {
		return new IntegerString(DicomTags.VerticesOfPolygonalShutter);
	}

	public static ShortString newVideoImageFormatAcquired() {
		return new ShortString(DicomTags.VideoImageFormatAcquired);
	}

	public static SequenceOfItems newViewCodeSeq() {
		return new SequenceOfItems(DicomTags.ViewCodeSeq);
	}

	public static SequenceOfItems newViewModifierCodeSeq() {
		return new SequenceOfItems(DicomTags.ViewModifierCodeSeq);
	}

	public static IntegerString newViewNumber() {
		return new IntegerString(DicomTags.ViewNumber);
	}

	public static CodeString newViewPosition() {
		return new CodeString(DicomTags.ViewPosition);
	}

	public static LongText newVisitComments() {
		return new LongText(DicomTags.VisitComments);
	}

	public static CodeString newVisitStatusID() {
		return new CodeString(DicomTags.VisitStatusID);
	}

	public static SequenceOfItems newVOILUTSeq() {
		return new SequenceOfItems(DicomTags.VOILUTSeq);
	}

	public static CodeString newVOIType() {
		return new CodeString(DicomTags.VOIType);
	}

	public static CodeString newVolumeBasedCalculationTechnique() {
		return new CodeString(DicomTags.VolumeBasedCalculationTechnique);
	}

	public static SequenceOfItems newVolumeLocalizationSeq() {
		return new SequenceOfItems(DicomTags.VolumeLocalizationSeq);
	}

	public static CodeString newVolumeLocalizationTechnique() {
		return new CodeString(DicomTags.VolumeLocalizationTechnique);
	}

	public static CodeString newVolumetricProperties() {
		return new CodeString(DicomTags.VolumetricProperties);
	}

	public static CodeString newVUSAcquisition() {
		return new CodeString(DicomTags.VUSAcquisition);
	}

	public static DecimalString newVUSPullbackRate() {
		return new DecimalString(DicomTags.VUSPullbackRate);
	}

	public static IntegerString newVUSPullbackStartFrameNumber() {
		return new IntegerString(DicomTags.VUSPullbackStartFrameNumber);
	}

	public static CodeString newWaterReferencedPhaseCorrection() {
		return new CodeString(DicomTags.WaterReferencedPhaseCorrection);
	}

	public static UnsignedShort newWaveformBitsAllocated() {
		return new UnsignedShort(DicomTags.WaveformBitsAllocated);
	}

	public static UnsignedShort newWaveformBitsStored() {
		return new UnsignedShort(DicomTags.WaveformBitsStored);
	}

	public static IntegerString newWaveformChannelNumber() {
		return new IntegerString(DicomTags.WaveformChannelNumber);
	}

	public static Unknown newWaveformData() {
		return new Unknown(DicomTags.WaveformData);
	}

	public static CodeString newWaveformOriginality() {
		return new CodeString(DicomTags.WaveformOriginality);
	}

	public static Unknown newWaveformPaddingValue() {
		return new Unknown(DicomTags.WaveformPaddingValue);
	}

	public static CodeString newWaveformSampleInterpretation() {
		return new CodeString(DicomTags.WaveformSampleInterpretation);
	}

	public static SequenceOfItems newWaveformSeq() {
		return new SequenceOfItems(DicomTags.WaveformSeq);
	}

	public static IntegerString newWedgeAngle() {
		return new IntegerString(DicomTags.WedgeAngle);
	}

	public static DecimalString newWedgeFactor() {
		return new DecimalString(DicomTags.WedgeFactor);
	}

	public static ShortString newWedgeID() {
		return new ShortString(DicomTags.WedgeID);
	}

	public static IntegerString newWedgeNumber() {
		return new IntegerString(DicomTags.WedgeNumber);
	}

	public static DecimalString newWedgeOrientation() {
		return new DecimalString(DicomTags.WedgeOrientation);
	}

	public static CodeString newWedgePosition() {
		return new CodeString(DicomTags.WedgePosition);
	}

	public static SequenceOfItems newWedgePositionSeq() {
		return new SequenceOfItems(DicomTags.WedgePositionSeq);
	}

	public static SequenceOfItems newWedgeSeq() {
		return new SequenceOfItems(DicomTags.WedgeSeq);
	}

	public static CodeString newWedgeType() {
		return new CodeString(DicomTags.WedgeType);
	}

	public static CodeString newWholeBodyTechnique() {
		return new CodeString(DicomTags.WholeBodyTechnique);
	}

	public static DecimalString newWindowCenter() {
		return new DecimalString(DicomTags.WindowCenter);
	}

	public static LongString newWindowCenterWidthExplanation() {
		return new LongString(DicomTags.WindowCenterWidthExplanation);
	}

	public static DecimalString newWindowWidth() {
		return new DecimalString(DicomTags.WindowWidth);
	}

	public static DecimalString newXFocusCenter() {
		return new DecimalString(DicomTags.XFocusCenter);
	}

	public static DecimalString newXOffsetInSlideCoordinateSystem() {
		return new DecimalString(DicomTags.XOffsetInSlideCoordinateSystem);
	}

	public static DecimalString newXRayImageReceptorAngle() {
		return new DecimalString(DicomTags.XRayImageReceptorAngle);
	}

	public static DecimalString newXRayImageReceptorTranslation() {
		return new DecimalString(DicomTags.XRayImageReceptorTranslation);
	}

	public static DecimalString newXRayOutput() {
		return new DecimalString(DicomTags.XRayOutput);
	}

	public static IntegerString newXRayTubeCurrent() {
		return new IntegerString(DicomTags.XRayTubeCurrent);
	}

	public static FloatingPointDouble newXRayTubeCurrentInMA() {
		return new FloatingPointDouble(DicomTags.XRayTubeCurrentInMA);
	}

	public static DecimalString newXRayTubeCurrentInuA() {
		return new DecimalString(DicomTags.XRayTubeCurrentInuA);
	}

	public static DecimalString newYFocusCenter() {
		return new DecimalString(DicomTags.YFocusCenter);
	}

	public static DecimalString newYOffsetInSlideCoordinateSystem() {
		return new DecimalString(DicomTags.YOffsetInSlideCoordinateSystem);
	}

	public static DecimalString newZOffsetInSlideCoordinateSystem() {
		return new DecimalString(DicomTags.ZOffsetInSlideCoordinateSystem);
	}

	public static DecimalString newZoomCenter() {
		return new DecimalString(DicomTags.ZoomCenter);
	}

	public static DecimalString newZoomFactor() {
		return new DecimalString(DicomTags.ZoomFactor);
	}

}