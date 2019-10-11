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

public class DicomTags {

	public static final DicomTag _3DRenderingType = new DicomTag(0x0072, 0x0520,
			"3D Rendering Type", ValueRepresentation.CodeString);

	public static final DicomTag AbstractPriorCodeSeq = new DicomTag(0x0072,
			0x003e, "Abstract Prior Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AbstractValue = new DicomTag(0x0072, 0x003c,
			"Abstract Prior Value", ValueRepresentation.SignedShort);

	public static final DicomTag AccessionNumber = new DicomTag(0x0008, 0x0050,
			"Accession Number", ValueRepresentation.ShortString);

	public static final DicomTag AcquisitionContextDescription = new DicomTag(
			0x0040, 0x0556, "Acquisition Context Description",
			ValueRepresentation.ShortText);

	public static final DicomTag AcquisitionContextSeq = new DicomTag(0x0040,
			0x0555, "Acquisition Context Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AcquisitionContrast = new DicomTag(0x0008,
			0x9209, "Acquisition Contrast", ValueRepresentation.CodeString);

	public static final DicomTag AcquisitionDate = new DicomTag(0x0008, 0x0022,
			"Acquisition Date", ValueRepresentation.Date);

	public static final DicomTag AcquisitionDatetime = new DicomTag(0x0008,
			0x002a, "Acquisition Datetime", ValueRepresentation.DateTime);

	public static final DicomTag AcquisitionDeviceProcessingCode = new DicomTag(
			0x0018, 0x1401, "Acquisition Device Processing Code",
			ValueRepresentation.LongString);

	public static final DicomTag AcquisitionDeviceProcessingDescription = new DicomTag(
			0x0018, 0x1400, "Acquisition Device Processing Description",
			ValueRepresentation.LongString);

	public static final DicomTag AcquisitionDeviceTypeCodeSeq = new DicomTag(
			0x0022, 0x0015, "Acquisition Device Type Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AcquisitionDuration = new DicomTag(0x0018,
			0x9073, "Acquisition Duration", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag AcquisitionMatrix = new DicomTag(0x0018, 0x1310,
			"Acquisition Matrix", ValueRepresentation.UnsignedShort);

	public static final DicomTag AcquisitionNumber = new DicomTag(0x0020, 0x0012,
			"Acquisition Number", ValueRepresentation.IntegerString);

	public static final DicomTag AcquisitionsInSeriesRetired = new DicomTag(
			0x0020, 0x1001, "Acquisitions in Series (Retired)",
			ValueRepresentation.IntegerString);

	public static final DicomTag AcquisitionsInStudy = new DicomTag(0x0020,
			0x1004, "Acquisitions in Study", ValueRepresentation.IntegerString);

	public static final DicomTag AcquisitionStartCondition = new DicomTag(0x0018,
			0x0073, "Acquisition Start Condition", ValueRepresentation.CodeString);

	public static final DicomTag AcquisitionStartConditionData = new DicomTag(
			0x0018, 0x0074, "Acquisition Start Condition Data",
			ValueRepresentation.IntegerString);

	public static final DicomTag AcquisitionTerminationCondition = new DicomTag(
			0x0018, 0x0071, "Acquisition Termination Condition",
			ValueRepresentation.CodeString);

	public static final DicomTag AcquisitionTerminationConditionData = new DicomTag(
			0x0018, 0x0075, "Acquisition Termination Condition Data",
			ValueRepresentation.IntegerString);

	public static final DicomTag AcquisitionTime = new DicomTag(0x0008, 0x0032,
			"Acquisition Time", ValueRepresentation.Time);

	public static final DicomTag AcquisitionTimeSynchronized = new DicomTag(
			0x0018, 0x1800, "Acquisition Time Synchronized",
			ValueRepresentation.CodeString);

	public static final DicomTag AcquisitionType = new DicomTag(0x0018, 0x9302,
			"Acquisition Type", ValueRepresentation.CodeString);

	public static final DicomTag ActionTypeID = new DicomTag(0x0000, 0x1008,
			"Action type ID", ValueRepresentation.UnsignedShort);

	public static final DicomTag ActiveSourceDiameter = new DicomTag(0x300a,
			0x0218, "Active Source Diameter", ValueRepresentation.DecimalString);

	public static final DicomTag ActiveSourceLength = new DicomTag(0x300a,
			0x021a, "Active Source Length", ValueRepresentation.DecimalString);

	public static final DicomTag ActualFrameDuration = new DicomTag(0x0018,
			0x1242, "Actual Frame Duration", ValueRepresentation.IntegerString);

	public static final DicomTag ActualHumanPerformersSeq = new DicomTag(0x0040,
			0x4035, "Actual Human Performers Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AddGrayScaleRetired = new DicomTag(0x0000,
			0x5150, "Add Gray Scale (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag AdditionalDrugSeq = new DicomTag(0x0018, 0x002a,
			"Additional Drug Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag AdditionalPatientHistory = new DicomTag(0x0010,
			0x21b0, "Additional Patient History", ValueRepresentation.LongText);

	public static final DicomTag AdministrationRouteCodeSeq = new DicomTag(
			0x0054, 0x0302, "Administration Route Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AdmissionID = new DicomTag(0x0038, 0x0010,
			"Admission ID", ValueRepresentation.LongString);

	public static final DicomTag AdmittingDate = new DicomTag(0x0038, 0x0020,
			"Admitting Date", ValueRepresentation.Date);

	public static final DicomTag AdmittingDiagnosisCodeSeq = new DicomTag(0x0008,
			0x1084, "Admitting Diagnosis Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AdmittingDiagnosisDescription = new DicomTag(
			0x0008, 0x1080, "Admitting Diagnosis Description",
			ValueRepresentation.LongString);

	public static final DicomTag AdmittingTime = new DicomTag(0x0038, 0x0021,
			"Admitting Time", ValueRepresentation.Time);

	public static final DicomTag AffectedSOPClassUID = new DicomTag(0x0000,
			0x0002, "Affected SOP Class uid", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag AffectedSOPInstanceUID = new DicomTag(0x0000,
			0x1000, "Affected SOP Instance uid", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag AirKermaRateReferenceDate = new DicomTag(0x300a,
			0x022c, "Air Kerma Rate Reference Date", ValueRepresentation.Date);

	public static final DicomTag AirKermaRateReferenceTime = new DicomTag(0x300a,
			0x022e, "Air Kerma Rate Reference Time", ValueRepresentation.Time);

	public static final DicomTag AllowLossyCompression = new DicomTag(0x2200,
			0x000f, "Allow Lossy Compression", ValueRepresentation.CodeString);

	public static final DicomTag AllowMediaSplitting = new DicomTag(0x2200,
			0x0007, "Allow Media Splitting", ValueRepresentation.CodeString);

	public static final DicomTag AlternateRepresentationSeq = new DicomTag(
			0x0008, 0x3001, "Alternate Representation Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AnatomicRegionModifierSeq = new DicomTag(0x0008,
			0x2220, "Anatomic Region Modifier Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AnatomicRegionSeq = new DicomTag(0x0008, 0x2218,
			"Anatomic Region Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag AnatomicStructureRetired = new DicomTag(0x0008,
			0x2208, "Anatomic Structure (Retired)", ValueRepresentation.CodeString);

	public static final DicomTag AnatomicStructureSpaceRegionSeq = new DicomTag(
			0x0008, 0x2229, "Anatomic Structure, Space or Region Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AnchorPoint = new DicomTag(0x0070, 0x0014,
			"Anchor Point", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag AnchorPointAnnotationUnits = new DicomTag(
			0x0070, 0x0004, "Anchor Point Annotation Units",
			ValueRepresentation.CodeString);

	public static final DicomTag AnchorPointVisibility = new DicomTag(0x0070,
			0x0015, "Anchor Point Visibility", ValueRepresentation.CodeString);

	public static final DicomTag AngioFlag = new DicomTag(0x0018, 0x0025,
			"Angio Flag", ValueRepresentation.CodeString);

	public static final DicomTag AngleNumberRetired = new DicomTag(0x0020,
			0x0018, "Angle Number (Retired)", ValueRepresentation.IntegerString);

	public static final DicomTag AngularPosition = new DicomTag(0x0018, 0x1141,
			"Angular Position", ValueRepresentation.DecimalString);

	public static final DicomTag AngularStep = new DicomTag(0x0018, 0x1144,
			"Angular Step", ValueRepresentation.DecimalString);

	public static final DicomTag AngularViewVector = new DicomTag(0x0054, 0x0090,
			"Angular View Vector", ValueRepresentation.UnsignedShort);

	public static final DicomTag AnnotationContentSeq = new DicomTag(0x2130,
			0x0050, "Annotation Content Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag AnnotationDisplayFormatID = new DicomTag(0x2010,
			0x0030, "Annotation Display Format ID", ValueRepresentation.CodeString);

	public static final DicomTag AnnotationFlag = new DicomTag(0x2000, 0x0065,
			"Annotation Flag", ValueRepresentation.CodeString);

	public static final DicomTag AnnotationGroupNumber = new DicomTag(0x0040,
			0xa180, "Annotation Group Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag AnnotationPosition = new DicomTag(0x2030,
			0x0010, "Annotation Position", ValueRepresentation.UnsignedShort);

	public static final DicomTag AnnotationSeq = new DicomTag(0x0040, 0xb020,
			"Annotation Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag AnodeTargetMaterial = new DicomTag(0x0018,
			0x1191, "Anode Target Material", ValueRepresentation.CodeString);

	public static final DicomTag ApplicableFrameRange = new DicomTag(0x0028,
			0x6102, "Applicable Frame Range", ValueRepresentation.UnsignedShort);

	public static final DicomTag ApplicableSafetyStandardAgency = new DicomTag(
			0x0018, 0x9174, "Applicable Safety Standard Agency",
			ValueRepresentation.CodeString);

	public static final DicomTag ApplicableSafetyStandardDescription = new DicomTag(
			0x0018, 0x9175, "Applicable Safety Standard Description",
			ValueRepresentation.LongString);

	public static final DicomTag ApplicationMaximumRepaintTime = new DicomTag(
			0x0072, 0x010e, "Application Maximum Repaint Time",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag ApplicationSetupCheck = new DicomTag(0x3008,
			0x0116, "Application Setup Check", ValueRepresentation.CodeString);

	public static final DicomTag ApplicationSetupManufacturer = new DicomTag(
			0x300a, 0x0238, "Application Setup Manufacturer",
			ValueRepresentation.LongString);

	public static final DicomTag ApplicationSetupName = new DicomTag(0x300a,
			0x0236, "Application Setup Name", ValueRepresentation.LongString);

	public static final DicomTag ApplicationSetupNumber = new DicomTag(0x300a,
			0x0234, "Application Setup Number", ValueRepresentation.IntegerString);

	public static final DicomTag ApplicationSetupSeq = new DicomTag(0x300a,
			0x0230, "Application Setup Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ApplicationSetupType = new DicomTag(0x300a,
			0x0232, "Application Setup Type", ValueRepresentation.CodeString);

	public static final DicomTag ApplicatorDescription = new DicomTag(0x300a,
			0x010a, "Applicator Description", ValueRepresentation.LongString);

	public static final DicomTag ApplicatorID = new DicomTag(0x300a, 0x0108,
			"Applicator ID", ValueRepresentation.ShortString);

	public static final DicomTag ApplicatorSeq = new DicomTag(0x300a, 0x0107,
			"Applicator Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ApplicatorType = new DicomTag(0x300a, 0x0109,
			"Applicator Type", ValueRepresentation.CodeString);

	public static final DicomTag ApprovalStatus = new DicomTag(0x300e, 0x0002,
			"Approval Status", ValueRepresentation.CodeString);

	public static final DicomTag ArbitraryCommentsRetired = new DicomTag(0x4000,
			0x4000, "(Arbitrary) Comments (Retired)", ValueRepresentation.LongText);

	public static final DicomTag ArbitraryRetired = new DicomTag(0x4000, 0x0010,
			"Arbitrary (Retired)", ValueRepresentation.LongText);

	public static final DicomTag AttachedContours = new DicomTag(0x3006, 0x0049,
			"Attached Contours", ValueRepresentation.IntegerString);

	public static final DicomTag AttenuationCorrectionMethod = new DicomTag(
			0x0054, 0x1101, "Attenuation Correction Method",
			ValueRepresentation.LongString);

	public static final DicomTag AttributeIdentifierList = new DicomTag(0x0000,
			0x1005, "Attribute Identifier List", ValueRepresentation.AttributeTag);

	public static final DicomTag AuthorizationEquipmentCertificationNumber = new DicomTag(
			0x0100, 0x0426, "Authorization Equipment Certification Number",
			ValueRepresentation.LongString);

	public static final DicomTag AveragePulseWidth = new DicomTag(0x0018, 0x1154,
			"Average Pulse Width", ValueRepresentation.DecimalString);

	public static final DicomTag AxialAcceptance = new DicomTag(0x0054, 0x1200,
			"Axial Acceptance", ValueRepresentation.DecimalString);

	public static final DicomTag AxialMash = new DicomTag(0x0054, 0x1201,
			"Axial Mash", ValueRepresentation.IntegerString);

	public static final DicomTag BarcodeSymbology = new DicomTag(0x2200, 0x0006,
			"Barcode Symbology", ValueRepresentation.CodeString);

	public static final DicomTag BarcodeValue = new DicomTag(0x2200, 0x0005,
			"Barcode Value", ValueRepresentation.LongText);

	public static final DicomTag BaselineCorrection = new DicomTag(0x0018,
			0x9067, "Baseline Correction", ValueRepresentation.CodeString);

	public static final DicomTag BasicColorImageSeq = new DicomTag(0x2020,
			0x0111, "Basic Color Image Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag BasicGrayscaleImageSeq = new DicomTag(0x2020,
			0x0110, "Basic Grayscale Image Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BeamDescription = new DicomTag(0x300a, 0x00c3,
			"Beam Description", ValueRepresentation.ShortText);

	public static final DicomTag BeamDose = new DicomTag(0x300a, 0x0084,
			"Beam Dose", ValueRepresentation.DecimalString);

	public static final DicomTag BeamDoseSpecificationPoint = new DicomTag(
			0x300a, 0x0082, "Beam Dose Specification Point",
			ValueRepresentation.DecimalString);

	public static final DicomTag BeamLimitingDeviceAngle = new DicomTag(0x300a,
			0x0120, "Beam Limiting Device Angle", ValueRepresentation.DecimalString);

	public static final DicomTag BeamLimitingDeviceAngleTolerance = new DicomTag(
			0x300a, 0x0046, "Beam Limiting Device Angle Tolerance",
			ValueRepresentation.DecimalString);

	public static final DicomTag BeamLimitingDeviceLeafPairsSeq = new DicomTag(
			0x3008, 0x00a0, "Beam Limiting Device Leaf Pairs Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BeamLimitingDevicePositionSeq = new DicomTag(
			0x300a, 0x011a, "Beam Limiting Device Position Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BeamLimitingDevicePositionTolerance = new DicomTag(
			0x300a, 0x004a, "Beam Limiting Device Position Tolerance",
			ValueRepresentation.DecimalString);

	public static final DicomTag BeamLimitingDeviceRotationDirection = new DicomTag(
			0x300a, 0x0121, "Beam Limiting Device Rotation Direction",
			ValueRepresentation.CodeString);

	public static final DicomTag BeamLimitingDeviceSeq = new DicomTag(0x300a,
			0x00b6, "Beam Limiting Device Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BeamLimitingDeviceToleranceSeq = new DicomTag(
			0x300a, 0x0048, "Beam Limiting Device Tolerance Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BeamMeterset = new DicomTag(0x300a, 0x0086,
			"Beam Meterset", ValueRepresentation.DecimalString);

	public static final DicomTag BeamName = new DicomTag(0x300a, 0x00c2,
			"Beam Name", ValueRepresentation.LongString);

	public static final DicomTag BeamNumber = new DicomTag(0x300a, 0x00c0,
			"Beam Number", ValueRepresentation.IntegerString);

	public static final DicomTag BeamSeq = new DicomTag(0x300a, 0x00b0,
			"Beam Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag BeamStopperPosition = new DicomTag(0x3008,
			0x0230, "Beam Stopper Position", ValueRepresentation.CodeString);

	public static final DicomTag BeamType = new DicomTag(0x300a, 0x00c4,
			"Beam Type", ValueRepresentation.CodeString);

	public static final DicomTag BeatRejectionFlag = new DicomTag(0x0018, 0x1080,
			"Beat Rejection Flag", ValueRepresentation.CodeString);

	public static final DicomTag BillingItemSeq = new DicomTag(0x0040, 0x0296,
			"Billing Item Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag BillingProcedureStepSeq = new DicomTag(0x0040,
			0x0320, "Billing Procedure Step Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BillingSuppliesAndDevicesSeq = new DicomTag(
			0x0040, 0x0324, "Billing Supplies and Devices Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BiPlaneAcquisitionSeq = new DicomTag(0x0028,
			0x5000, "Bi-Plane Acquisition Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BitsAllocated = new DicomTag(0x0028, 0x0100,
			"Bits Allocated", ValueRepresentation.UnsignedShort);

	public static final DicomTag BitsStored = new DicomTag(0x0028, 0x0101,
			"Bits Stored", ValueRepresentation.UnsignedShort);

	public static final DicomTag BlendingOperationType = new DicomTag(0x0072,
			0x0500, "Blending Operation Type", ValueRepresentation.CodeString);

	public static final DicomTag BlockData = new DicomTag(0x300a, 0x0106,
			"Block Data", ValueRepresentation.DecimalString);

	public static final DicomTag BlockDivergence = new DicomTag(0x300a, 0x00fa,
			"Block Divergence", ValueRepresentation.CodeString);

	public static final DicomTag BlockName = new DicomTag(0x300a, 0x00fe,
			"Block Name", ValueRepresentation.LongString);

	public static final DicomTag BlockNumber = new DicomTag(0x300a, 0x00fc,
			"Block Number", ValueRepresentation.IntegerString);

	public static final DicomTag BlockNumberOfPoints = new DicomTag(0x300a,
			0x0104, "Block Number of Points", ValueRepresentation.IntegerString);

	public static final DicomTag BlockSeq = new DicomTag(0x300a, 0x00f4,
			"Block Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag BlockThickness = new DicomTag(0x300a, 0x0100,
			"Block Thickness", ValueRepresentation.DecimalString);

	public static final DicomTag BlockTransmission = new DicomTag(0x300a, 0x0102,
			"Block Transmission", ValueRepresentation.DecimalString);

	public static final DicomTag BlockTrayID = new DicomTag(0x300a, 0x00f5,
			"Block Tray ID", ValueRepresentation.ShortString);

	public static final DicomTag BlockType = new DicomTag(0x300a, 0x00f8,
			"Block Type", ValueRepresentation.CodeString);

	public static final DicomTag BloodSignalNulling = new DicomTag(0x0018,
			0x9022, "Blood Signal Nulling", ValueRepresentation.CodeString);

	public static final DicomTag BluePaletteColorLUTData = new DicomTag(0x0028,
			0x1203, "Blue Palette Color Lookup Table Data",
			ValueRepresentation.OtherWordString);

	public static final DicomTag BluePaletteColorLUTDescriptor = new DicomTag(
			0x0028, 0x1103, "Blue Palette Color Lookup Table Descriptor",
			ValueRepresentation.Unknown);

	public static final DicomTag BodyPartExamined = new DicomTag(0x0018, 0x0015,
			"Body Part Examined", ValueRepresentation.CodeString);

	public static final DicomTag BodyPartThickness = new DicomTag(0x0018, 0x11a0,
			"Body Part Thickness", ValueRepresentation.DecimalString);

	public static final DicomTag BoneThermalIndex = new DicomTag(0x0018, 0x5024,
			"Bone Thermal Index", ValueRepresentation.DecimalString);

	public static final DicomTag BorderDensity = new DicomTag(0x2010, 0x0100,
			"Border Density", ValueRepresentation.CodeString);

	public static final DicomTag BordersRetired = new DicomTag(0x0000, 0x5160,
			"Borders (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag BoundingBoxAnnotationUnits = new DicomTag(
			0x0070, 0x0003, "Bounding Box Annotation Units",
			ValueRepresentation.CodeString);

	public static final DicomTag BoundingBoxBottomRightHandCorner = new DicomTag(
			0x0070, 0x0011, "Bounding Box Bottom Right Hand Corner",
			ValueRepresentation.FloatingPointSingle);

	public static final DicomTag BoundingBoxTextHorizontalJustification = new DicomTag(
			0x0070, 0x0012, "Bounding Box Text Horizontal Justification",
			ValueRepresentation.CodeString);

	public static final DicomTag BoundingBoxTopLeftHandCorner = new DicomTag(
			0x0070, 0x0010, "Bounding Box Top Left Hand Corner",
			ValueRepresentation.FloatingPointSingle);

	public static final DicomTag BrachyAccessoryDeviceID = new DicomTag(0x300a,
			0x0263, "Brachy Accessory Device ID", ValueRepresentation.ShortString);

	public static final DicomTag BrachyAccessoryDeviceName = new DicomTag(0x300a,
			0x0266, "Brachy Accessory Device Name", ValueRepresentation.LongString);

	public static final DicomTag BrachyAccessoryDeviceNominalThickness = new DicomTag(
			0x300a, 0x026a, "Brachy Accessory Device Nominal Thickness",
			ValueRepresentation.DecimalString);

	public static final DicomTag BrachyAccessoryDeviceNominalTransmission = new DicomTag(
			0x300a, 0x026c, "Brachy Accessory Device Nominal Transmission",
			ValueRepresentation.DecimalString);

	public static final DicomTag BrachyAccessoryDeviceNumber = new DicomTag(
			0x300a, 0x0262, "Brachy Accessory Device Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag BrachyAccessoryDeviceSeq = new DicomTag(0x300a,
			0x0260, "Brachy Accessory Device Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BrachyAccessoryDeviceType = new DicomTag(0x300a,
			0x0264, "Brachy Accessory Device Type", ValueRepresentation.CodeString);

	public static final DicomTag BrachyApplicationSetupDose = new DicomTag(
			0x300a, 0x00a4, "Brachy Application Setup Dose",
			ValueRepresentation.DecimalString);

	public static final DicomTag BrachyApplicationSetupDoseSpecificationPoint = new DicomTag(
			0x300a, 0x00a2, "Brachy Application Setup Dose Specification Point",
			ValueRepresentation.DecimalString);

	public static final DicomTag BrachyControlPointDeliveredSeq = new DicomTag(
			0x3008, 0x0160, "Brachy Control Point Delivered Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BrachyControlPointSeq = new DicomTag(0x300a,
			0x02d0, "Brachy Control Point Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BrachyRefDoseReferenceSeq = new DicomTag(0x300c,
			0x0055, "Brachy Referenced Dose Reference Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag BrachyTreatmentTechnique = new DicomTag(0x300a,
			0x0200, "Brachy Treatment Technique", ValueRepresentation.CodeString);

	public static final DicomTag BrachyTreatmentType = new DicomTag(0x300a,
			0x0202, "Brachy Treatment Type", ValueRepresentation.CodeString);

	public static final DicomTag BranchOfService = new DicomTag(0x0010, 0x1081,
			"Branch of Service", ValueRepresentation.LongString);

	public static final DicomTag BulkMotionCompensationTechnique = new DicomTag(
			0x0018, 0x9172, "Bulk Motion Compensation Technique",
			ValueRepresentation.CodeString);

	public static final DicomTag BulkMotionSignalSource = new DicomTag(0x0018,
			0x9173, "Bulk Motion Signal Source", ValueRepresentation.CodeString);

	public static final DicomTag BulkMotionStatus = new DicomTag(0x0018, 0x9166,
			"Bulk Motion Status", ValueRepresentation.CodeString);

	public static final DicomTag BurnedInAnnotation = new DicomTag(0x0028,
			0x0301, "Burned In Annotation", ValueRepresentation.CodeString);

	public static final DicomTag CalculatedDoseReferenceDescription = new DicomTag(
			0x3008, 0x0074, "Calculated Dose Reference Description",
			ValueRepresentation.ShortText);

	public static final DicomTag CalculatedDoseReferenceDoseValue = new DicomTag(
			0x3008, 0x0076, "Calculated Dose Reference Dose Value",
			ValueRepresentation.DecimalString);

	public static final DicomTag CalculatedDoseReferenceNumber = new DicomTag(
			0x3008, 0x0072, "Calculated Dose Reference Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag CalculatedDoseReferenceSeq = new DicomTag(
			0x3008, 0x0070, "Calculated Dose Reference Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag CalibrationDataSeq = new DicomTag(0x0054,
			0x0306, "Calibration Data Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag CalibrationImage = new DicomTag(0x0050, 0x0004,
			"Calibration Image", ValueRepresentation.CodeString);

	public static final DicomTag CardiacBeatRejectionTechnique = new DicomTag(
			0x0018, 0x9169, "Cardiac Beat Rejection Technique",
			ValueRepresentation.CodeString);

	public static final DicomTag CardiacCyclePosition = new DicomTag(0x0018,
			0x9236, "Cardiac Cycle Position", ValueRepresentation.CodeString);

	public static final DicomTag CardiacNumberOfImages = new DicomTag(0x0018,
			0x1090, "Cardiac Number of Images", ValueRepresentation.IntegerString);

	public static final DicomTag CardiacRRIntervalSpecified = new DicomTag(
			0x0018, 0x9070, "Cardiac R-R Interval Specified",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag CardiacSignalSource = new DicomTag(0x0018,
			0x9085, "Cardiac Signal Source", ValueRepresentation.CodeString);

	public static final DicomTag CardiacSynchronizationTechnique = new DicomTag(
			0x0018, 0x9037, "Cardiac Synchronization Technique",
			ValueRepresentation.CodeString);

	public static final DicomTag CardiacTriggerSeq = new DicomTag(0x0018, 0x9118,
			"Cardiac Trigger Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag CassetteOrientation = new DicomTag(0x0018,
			0x1402, "Cassette Orientation", ValueRepresentation.CodeString);

	public static final DicomTag CassetteSize = new DicomTag(0x0018, 0x1403,
			"Cassette Size", ValueRepresentation.CodeString);

	public static final DicomTag CenterOfCircularCollimator = new DicomTag(
			0x0018, 0x1710, "Center of Circular Collimator",
			ValueRepresentation.IntegerString);

	public static final DicomTag CenterOfCircularShutter = new DicomTag(0x0018,
			0x1610, "Center of Circular Shutter", ValueRepresentation.IntegerString);

	public static final DicomTag CenterOfRotationOffset = new DicomTag(0x0018,
			0x1145, "Center of Rotation Offset", ValueRepresentation.DecimalString);

	public static final DicomTag ChannelBaseline = new DicomTag(0x003a, 0x0213,
			"Channel Baseline", ValueRepresentation.DecimalString);

	public static final DicomTag ChannelDefinitionSeq = new DicomTag(0x003a,
			0x0200, "Channel Definition Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ChannelDerivationDescription = new DicomTag(
			0x003a, 0x020c, "Channel Derivation Description",
			ValueRepresentation.LongString);

	public static final DicomTag ChannelDescriptionCodeSeq = new DicomTag(0x0022,
			0x001a, "Channel Description Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ChannelIdentificationCode = new DicomTag(0x003a,
			0x0301, "Channel Identification Code", ValueRepresentation.IntegerString);

	public static final DicomTag ChannelLabel = new DicomTag(0x003a, 0x0203,
			"Channel Label", ValueRepresentation.ShortString);

	public static final DicomTag ChannelLength = new DicomTag(0x300a, 0x0284,
			"Channel Length", ValueRepresentation.DecimalString);

	public static final DicomTag ChannelMaximumValue = new DicomTag(0x5400,
			0x0112, "Channel Maximum Value", ValueRepresentation.Unknown);

	public static final DicomTag ChannelMinimumValue = new DicomTag(0x5400,
			0x0110, "Channel Minimum Value", ValueRepresentation.Unknown);

	public static final DicomTag ChannelMode = new DicomTag(0x003a, 0x0302,
			"Channel Mode", ValueRepresentation.CodeString);

	public static final DicomTag ChannelNumber = new DicomTag(0x300a, 0x0282,
			"Channel Number", ValueRepresentation.IntegerString);

	public static final DicomTag ChannelOffset = new DicomTag(0x003a, 0x0218,
			"Channel Offset", ValueRepresentation.DecimalString);

	public static final DicomTag ChannelSampleSkew = new DicomTag(0x003a, 0x0215,
			"Channel Sample Skew", ValueRepresentation.DecimalString);

	public static final DicomTag ChannelSensitivity = new DicomTag(0x003a,
			0x0210, "Channel Sensitivity", ValueRepresentation.DecimalString);

	public static final DicomTag ChannelSensitivityCorrectionFactor = new DicomTag(
			0x003a, 0x0212, "Channel Sensitivity Correction Factor",
			ValueRepresentation.DecimalString);

	public static final DicomTag ChannelSensitivityUnitsSeq = new DicomTag(
			0x003a, 0x0211, "Channel Sensitivity Units Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ChannelSeq = new DicomTag(0x300a, 0x0280,
			"Channel Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ChannelShieldID = new DicomTag(0x300a, 0x02b3,
			"Channel Shield ID", ValueRepresentation.ShortString);

	public static final DicomTag ChannelShieldName = new DicomTag(0x300a, 0x02b4,
			"Channel Shield Name", ValueRepresentation.LongString);

	public static final DicomTag ChannelShieldNominalThickness = new DicomTag(
			0x300a, 0x02b8, "Channel Shield Nominal Thickness",
			ValueRepresentation.DecimalString);

	public static final DicomTag ChannelShieldNominalTransmission = new DicomTag(
			0x300a, 0x02ba, "Channel Shield Nominal Transmission",
			ValueRepresentation.DecimalString);

	public static final DicomTag ChannelShieldNumber = new DicomTag(0x300a,
			0x02b2, "Channel Shield Number", ValueRepresentation.IntegerString);

	public static final DicomTag ChannelShieldSeq = new DicomTag(0x300a, 0x02b0,
			"Channel Shield Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ChannelSourceModifiersSeq = new DicomTag(0x003a,
			0x0209, "Channel Source Modifiers Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ChannelSourceSeq = new DicomTag(0x003a, 0x0208,
			"Channel Source Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ChannelStatus = new DicomTag(0x003a, 0x0205,
			"Channel Status", ValueRepresentation.CodeString);

	public static final DicomTag ChannelTimeSkew = new DicomTag(0x003a, 0x0214,
			"Channel Time Skew", ValueRepresentation.DecimalString);

	public static final DicomTag ChannelTotalTime = new DicomTag(0x300a, 0x0286,
			"Channel Total Time", ValueRepresentation.DecimalString);

	public static final DicomTag ChemicalShiftReference = new DicomTag(0x0018,
			0x9053, "Chemical Shift Reference",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ChemicalShiftSeq = new DicomTag(0x0018, 0x9084,
			"Chemical Shift Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ChemicalShiftsMaximumIntegrationLimit = new DicomTag(
			0x0018, 0x9196, "Chemical Shifts Maximum Integration Limit",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ChemicalShiftsMinimumIntegrationLimit = new DicomTag(
			0x0018, 0x9195, "Chemical Shifts Minimum Integration Limit",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag CineRate = new DicomTag(0x0018, 0x0040,
			"Cine Rate", ValueRepresentation.IntegerString);

	public static final DicomTag CineRelativeToRealTime = new DicomTag(0x0072,
			0x0330, "Cine Relative to Real-Time",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ClinicalTrialProtocolID = new DicomTag(0x0012,
			0x0020, "Clinical Trial Protocol ID", ValueRepresentation.LongString);

	public static final DicomTag ClinicalTrialProtocolName = new DicomTag(0x0012,
			0x0021, "Clinical Trial Protocol Name", ValueRepresentation.LongString);

	public static final DicomTag ClinicalTrialSiteID = new DicomTag(0x0012,
			0x0030, "Clinical Trial Site ID", ValueRepresentation.LongString);

	public static final DicomTag ClinicalTrialSiteName = new DicomTag(0x0012,
			0x0031, "Clinical Trial Site Name", ValueRepresentation.LongString);

	public static final DicomTag ClinicalTrialSponsorName = new DicomTag(0x0012,
			0x0010, "Clinical Trial Sponsor Name", ValueRepresentation.LongString);

	public static final DicomTag ClinicalTrialSubjectID = new DicomTag(0x0012,
			0x0040, "Clinical Trial Subject ID", ValueRepresentation.LongString);

	public static final DicomTag ClinicalTrialSubjectReadingID = new DicomTag(
			0x0012, 0x0042, "Clinical Trial Subject Reading ID",
			ValueRepresentation.LongString);

	public static final DicomTag ClinicalTrialTimePointDescription = new DicomTag(
			0x0012, 0x0051, "Clinical Trial Time Point Description",
			ValueRepresentation.ShortText);

	public static final DicomTag ClinicalTrialTimePointID = new DicomTag(0x0012,
			0x0050, "Clinical Trial Time Point ID", ValueRepresentation.LongString);

	public static final DicomTag CodeMeaning = new DicomTag(0x0008, 0x0104,
			"Code Meaning", ValueRepresentation.LongString);

	public static final DicomTag CodeValue = new DicomTag(0x0008, 0x0100,
			"Code Value", ValueRepresentation.ShortString);

	public static final DicomTag CodingSchemeDesignator = new DicomTag(0x0008,
			0x0102, "Coding Scheme Designator", ValueRepresentation.ShortString);

	public static final DicomTag CodingSchemeExternal = new DicomTag(0x0008,
			0x0114, "Coding Scheme External ID", ValueRepresentation.ShortText);

	public static final DicomTag CodingSchemeIdentificationSeq = new DicomTag(
			0x0008, 0x0110, "Coding Scheme Identification Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag CodingSchemeName = new DicomTag(0x0008, 0x0115,
			"Coding Scheme Name", ValueRepresentation.ShortText);

	public static final DicomTag CodingSchemeRegistry = new DicomTag(0x0008,
			0x0112, "Coding Scheme Registry", ValueRepresentation.LongString);

	public static final DicomTag CodingSchemeUID = new DicomTag(0x0008, 0x010c,
			"Coding Scheme UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag CodingSchemeVersion = new DicomTag(0x0008,
			0x0103, "Coding Scheme Version", ValueRepresentation.ShortString);

	public static final DicomTag CoincidenceWindowWidth = new DicomTag(0x0054,
			0x1210, "Coincidence Window Width", ValueRepresentation.DecimalString);

	public static final DicomTag CollationFlag = new DicomTag(0x2000, 0x0063,
			"Collation Flag", ValueRepresentation.CodeString);

	public static final DicomTag CollimatorGridName = new DicomTag(0x0018,
			0x1180, "Collimator/grid Name", ValueRepresentation.ShortString);

	public static final DicomTag CollimatorLeftVerticalEdge = new DicomTag(
			0x0018, 0x1702, "Collimator Left Vertical Edge",
			ValueRepresentation.IntegerString);

	public static final DicomTag CollimatorLowerHorizontalEdge = new DicomTag(
			0x0018, 0x1708, "Collimator Lower Horizontal Edge",
			ValueRepresentation.IntegerString);

	public static final DicomTag CollimatorRightVerticalEdge = new DicomTag(
			0x0018, 0x1704, "Collimator Right Vertical Edge",
			ValueRepresentation.IntegerString);

	public static final DicomTag CollimatorShape = new DicomTag(0x0018, 0x1700,
			"Collimator Shape", ValueRepresentation.CodeString);

	public static final DicomTag CollimatorType = new DicomTag(0x0018, 0x1181,
			"Collimator Type", ValueRepresentation.CodeString);

	public static final DicomTag CollimatorUpperHorizontalEdge = new DicomTag(
			0x0018, 0x1706, "Collimator Upper Horizontal Edge",
			ValueRepresentation.IntegerString);

	public static final DicomTag ColorImagePrintingFlag = new DicomTag(0x2000,
			0x0062, "Color Image Printing Flag", ValueRepresentation.CodeString);

	public static final DicomTag ColumnAngulation = new DicomTag(0x0018, 0x1450,
			"Column Angulation", ValueRepresentation.CodeString);

	public static final DicomTag Columns = new DicomTag(0x0028, 0x0011,
			"Columns", ValueRepresentation.UnsignedShort);

	public static final DicomTag CommandField = new DicomTag(0x0000, 0x0100,
			"Command Field", ValueRepresentation.UnsignedShort);

	public static final DicomTag CommandGroupLength = new DicomTag(0x0000,
			0x0000, "Command Group Length", ValueRepresentation.UnsignedLong);

	public static final DicomTag CommandLengthToEndRetired = new DicomTag(0x0000,
			0x0001, "(Command) Length to End (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag CommandRecognitionCodeRetired = new DicomTag(
			0x0000, 0x0010, "(Command) Recognition Code (Retired)",
			ValueRepresentation.Unknown);

	public static final DicomTag CommentsOnRadiationDose = new DicomTag(0x0040,
			0x0310, "Comments on Radiation Dose", ValueRepresentation.ShortText);

	public static final DicomTag CompensatorColumns = new DicomTag(0x300a,
			0x00e8, "Compensator Columns", ValueRepresentation.IntegerString);

	public static final DicomTag CompensatorID = new DicomTag(0x300a, 0x00e5,
			"Compensator ID", ValueRepresentation.ShortString);

	public static final DicomTag CompensatorNumber = new DicomTag(0x300a, 0x00e4,
			"Compensator Number", ValueRepresentation.IntegerString);

	public static final DicomTag CompensatorPixelSpacing = new DicomTag(0x300a,
			0x00e9, "Compensator Pixel Spacing", ValueRepresentation.DecimalString);

	public static final DicomTag CompensatorPosition = new DicomTag(0x300a,
			0x00ea, "Compensator Position", ValueRepresentation.DecimalString);

	public static final DicomTag CompensatorRows = new DicomTag(0x300a, 0x00e7,
			"Compensator Rows", ValueRepresentation.IntegerString);

	public static final DicomTag CompensatorSeq = new DicomTag(0x300a, 0x00e3,
			"Compensator Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag CompensatorThicknessData = new DicomTag(0x300a,
			0x00ec, "Compensator Thickness Data", ValueRepresentation.DecimalString);

	public static final DicomTag CompensatorTransmissionData = new DicomTag(
			0x300a, 0x00eb, "Compensator Transmission Data",
			ValueRepresentation.DecimalString);

	public static final DicomTag CompensatorType = new DicomTag(0x300a, 0x00ee,
			"Compensator Type", ValueRepresentation.CodeString);

	public static final DicomTag CompletionFlag = new DicomTag(0x0040, 0xa491,
			"Completion Flag", ValueRepresentation.CodeString);

	public static final DicomTag CompletionFlagDescription = new DicomTag(0x0040,
			0xa492, "Completion Flag Description", ValueRepresentation.LongString);

	public static final DicomTag ComplexImageComponent = new DicomTag(0x0008,
			0x9208, "Complex Image Component", ValueRepresentation.CodeString);

	public static final DicomTag CompressionCodeRetired = new DicomTag(0x0028,
			0x0060, "Compression Code (Retired)", ValueRepresentation.CodeString);

	public static final DicomTag CompressionForce = new DicomTag(0x0018, 0x11a2,
			"Compression Force", ValueRepresentation.DecimalString);

	public static final DicomTag ConcatenationFrameOffsetNumber = new DicomTag(
			0x0020, 0x9228, "Concatenation Frame Offset Number",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag ConcatenationUID = new DicomTag(0x0020, 0x9161,
			"Concatenation UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag ConceptCodeSeq = new DicomTag(0x0040, 0xa168,
			"Concept Code Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ConceptNameCodeSeq = new DicomTag(0x0040,
			0xa043, "Concept-name Code Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ConfidentialityCode = new DicomTag(0x0040,
			0x1008, "Confidentiality Code", ValueRepresentation.LongString);

	public static final DicomTag ConfidentialityPatientData = new DicomTag(
			0x0040, 0x3001, "Confidentiality Constraint on Patient Data Description",
			ValueRepresentation.LongString);

	public static final DicomTag ConfigurationInformation = new DicomTag(0x2010,
			0x0150, "Configuration Information", ValueRepresentation.ShortText);

	public static final DicomTag ConfigurationInformationDescription = new DicomTag(
			0x2010, 0x0152, "Configuration Information Description",
			ValueRepresentation.LongText);

	public static final DicomTag ConstantVolumeFlag = new DicomTag(0x0018,
			0x9333, "Constant Volume Flag", ValueRepresentation.CodeString);

	public static final DicomTag ConstraintWeight = new DicomTag(0x300a, 0x0021,
			"Constraint Weight", ValueRepresentation.DecimalString);

	public static final DicomTag ContentDate = new DicomTag(0x0008, 0x0023,
			"Content Date", ValueRepresentation.Date);

	public static final DicomTag ContentDescription = new DicomTag(0x0070,
			0x0081, "Content Description", ValueRepresentation.LongString);

	public static final DicomTag ContentItemModifierSeq = new DicomTag(0x0040,
			0x0441, "Content Item Modifier Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContentLabel = new DicomTag(0x0070, 0x0080,
			"Content Label", ValueRepresentation.CodeString);

	public static final DicomTag ContentQualification = new DicomTag(0x0018,
			0x9004, "Content Qualification", ValueRepresentation.CodeString);

	public static final DicomTag ContentSeq = new DicomTag(0x0040, 0xa730,
			"Content Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContentTemplateSeq = new DicomTag(0x0040,
			0xa504, "Content Template Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContentTime = new DicomTag(0x0008, 0x0033,
			"Content Time", ValueRepresentation.Time);

	public static final DicomTag ContextGroupExtensionCreatorUID = new DicomTag(
			0x0008, 0x010d, "Context Group Extension Creator UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag ContextGroupExtensionFlag = new DicomTag(0x0008,
			0x010b, "Context Group Extension Flag", ValueRepresentation.CodeString);

	public static final DicomTag ContextGroupLocalVersion = new DicomTag(0x0008,
			0x0107, "Context Group Local Version", ValueRepresentation.DateTime);

	public static final DicomTag ContextGroupVersion = new DicomTag(0x0008,
			0x0106, "Context Group Version", ValueRepresentation.DateTime);

	public static final DicomTag ContextIdentifier = new DicomTag(0x0008, 0x010f,
			"Context Identifier", ValueRepresentation.CodeString);

	public static final DicomTag ContinuityOfContent = new DicomTag(0x0040,
			0xa050, "Continuity Of Content", ValueRepresentation.CodeString);

	public static final DicomTag ContourData = new DicomTag(0x3006, 0x0050,
			"Contour Data", ValueRepresentation.DecimalString);

	public static final DicomTag ContourGeometricType = new DicomTag(0x3006,
			0x0042, "Contour Geometric Type", ValueRepresentation.CodeString);

	public static final DicomTag ContourImageSeq = new DicomTag(0x3006, 0x0016,
			"Contour Image Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContourNumber = new DicomTag(0x3006, 0x0048,
			"Contour Number", ValueRepresentation.IntegerString);

	public static final DicomTag ContourOffsetVector = new DicomTag(0x3006,
			0x0045, "Contour Offset Vector", ValueRepresentation.DecimalString);

	public static final DicomTag ContourSeq = new DicomTag(0x3006, 0x0040,
			"Contour Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContourSlabThickness = new DicomTag(0x3006,
			0x0044, "Contour Slab Thickness", ValueRepresentation.DecimalString);

	public static final DicomTag ContourUncertaintyRadius = new DicomTag(0x0070,
			0x0312, "Contour Uncertainty Radius",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ContrastAdministrationProfileSeq = new DicomTag(
			0x0018, 0x9340, "Contrast Administration Profile Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContrastAllergies = new DicomTag(0x0010, 0x2110,
			"Contrast Allergies", ValueRepresentation.LongString);

	public static final DicomTag ContrastBolusAdministrationRouteSeq = new DicomTag(
			0x0018, 0x0014, "Contrast/Bolus Administration Route Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContrastBolusAgent = new DicomTag(0x0018,
			0x0010, "Contrast/Bolus Agent", ValueRepresentation.LongString);

	public static final DicomTag ContrastBolusAgentAdministered = new DicomTag(
			0x0018, 0x9342, "Contrast/Bolus Agent Administered",
			ValueRepresentation.CodeString);

	public static final DicomTag ContrastBolusAgentDetected = new DicomTag(
			0x0018, 0x9343, "Contrast/Bolus Agent Detected",
			ValueRepresentation.CodeString);

	public static final DicomTag ContrastBolusAgentNumber = new DicomTag(0x0018,
			0x9337, "Contrast/Bolus Agent Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag ContrastBolusAgentPhase = new DicomTag(0x0018,
			0x9344, "Contrast/Bolus Agent Phase", ValueRepresentation.CodeString);

	public static final DicomTag ContrastBolusAgentSeq = new DicomTag(0x0018,
			0x0012, "Contrast/Bolus Agent Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContrastBolusIngredient = new DicomTag(0x0018,
			0x1048, "Contrast/Bolus Ingredient", ValueRepresentation.CodeString);

	public static final DicomTag ContrastBolusIngredientCodeSeq = new DicomTag(
			0x0018, 0x9338, "Contrast/Bolus Ingredient Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContrastBolusIngredientConcentration = new DicomTag(
			0x0018, 0x1049, "Contrast/Bolus Ingredient Concentration",
			ValueRepresentation.DecimalString);

	public static final DicomTag ContrastBolusRoute = new DicomTag(0x0018,
			0x1040, "Contrast/Bolus Route", ValueRepresentation.LongString);

	public static final DicomTag ContrastBolusStartTime = new DicomTag(0x0018,
			0x1042, "Contrast/Bolus Start Time", ValueRepresentation.Time);

	public static final DicomTag ContrastBolusStopTime = new DicomTag(0x0018,
			0x1043, "Contrast/Bolus Stop Time", ValueRepresentation.Time);

	public static final DicomTag ContrastBolusTotalDose = new DicomTag(0x0018,
			0x1044, "Contrast/Bolus Total Dose", ValueRepresentation.DecimalString);

	public static final DicomTag ContrastBolusUsageSeq = new DicomTag(0x0018,
			0x9341, "Contrast/Bolus Usage Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContrastBolusVolume = new DicomTag(0x0018,
			0x1041, "Contrast/Bolus Volume", ValueRepresentation.DecimalString);

	public static final DicomTag ContrastFlowDuration = new DicomTag(0x0018,
			0x1047, "Contrast Flow Duration", ValueRepresentation.DecimalString);

	public static final DicomTag ContrastFlowRate = new DicomTag(0x0018, 0x1046,
			"Contrast Flow Rate", ValueRepresentation.DecimalString);

	public static final DicomTag ContrastFrameAveraging = new DicomTag(0x0028,
			0x6112, "Contrast Frame Averaging", ValueRepresentation.UnsignedShort);

	public static final DicomTag ContributingEquipmentSeq = new DicomTag(0x0018,
			0xa001, "Contributing Equipment Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ContributionDateTime = new DicomTag(0x0018,
			0xa002, "Contribution DateTime", ValueRepresentation.DateTime);

	public static final DicomTag ContributionDescription = new DicomTag(0x0018,
			0xa003, "Contribution Description", ValueRepresentation.ShortText);

	public static final DicomTag ControlPoint3DPosition = new DicomTag(0x300a,
			0x02d4, "Control Point 3D Position", ValueRepresentation.DecimalString);

	public static final DicomTag ControlPointDeliverySeq = new DicomTag(0x3008,
			0x0040, "Control Point Delivery Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ControlPointIndex = new DicomTag(0x300a, 0x0112,
			"Control Point Index", ValueRepresentation.IntegerString);

	public static final DicomTag ControlPointRelativePosition = new DicomTag(
			0x300a, 0x02d2, "Control Point Relative Position",
			ValueRepresentation.DecimalString);

	public static final DicomTag ControlPointSeq = new DicomTag(0x300a, 0x0111,
			"Control Point Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ConversionType = new DicomTag(0x0008, 0x0064,
			"Conversion Type", ValueRepresentation.CodeString);

	public static final DicomTag ConvolutionKernel = new DicomTag(0x0018, 0x1210,
			"Convolution Kernel", ValueRepresentation.ShortString);

	public static final DicomTag ConvolutionKernelGroup = new DicomTag(0x0018,
			0x9316, "Convolution Kernel Group", ValueRepresentation.CodeString);

	public static final DicomTag CoordinateSystemAxisCodeSeq = new DicomTag(
			0x0040, 0x08da, "Coordinate System Axis Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag CoordinatingCenterName = new DicomTag(0x0012,
			0x0060, "Clinical Trial Coordinating Center Name",
			ValueRepresentation.LongString);

	public static final DicomTag CopiesRetired = new DicomTag(0x0000, 0x5170,
			"Copies (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag CorrectedImage = new DicomTag(0x0028, 0x0051,
			"Corrected Image", ValueRepresentation.CodeString);

	public static final DicomTag CountRate = new DicomTag(0x0018, 0x1243,
			"Count Rate", ValueRepresentation.IntegerString);

	public static final DicomTag CountryOfResidence = new DicomTag(0x0010,
			0x2150, "Country of Residence", ValueRepresentation.LongString);

	public static final DicomTag CountsAccumulated = new DicomTag(0x0018, 0x0070,
			"Counts Accumulated", ValueRepresentation.IntegerString);

	public static final DicomTag CountsIncluded = new DicomTag(0x0054, 0x1400,
			"Counts Included", ValueRepresentation.CodeString);

	public static final DicomTag CountsSource = new DicomTag(0x0054, 0x1002,
			"Counts Source", ValueRepresentation.CodeString);

	public static final DicomTag CoverageOfKSpace = new DicomTag(0x0018, 0x9094,
			"Coverage of k-Space", ValueRepresentation.CodeString);

	public static final DicomTag CranialThermalIndex = new DicomTag(0x0018,
			0x5026, "Cranial Thermal Index", ValueRepresentation.DecimalString);

	public static final DicomTag CreationDate = new DicomTag(0x2100, 0x0040,
			"Creation Date", ValueRepresentation.Date);

	public static final DicomTag CreationTime = new DicomTag(0x2100, 0x0050,
			"Creation Time", ValueRepresentation.Time);

	public static final DicomTag CreatorVersionUID = new DicomTag(0x0008, 0x9123,
			"Creator-Version UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag CTAcquisitionDetailsSeq = new DicomTag(0x0018,
			0x9304, "CT Acquisition Details Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag CTAcquisitionTypeSeq = new DicomTag(0x0018,
			0x9301, "CT Acquisition Type Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag CTDIvol = new DicomTag(0x0018, 0x9345,
			"CTDIvol", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag CTExposureSeq = new DicomTag(0x0018, 0x9321,
			"CT Exposure Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag CTGeometrySeq = new DicomTag(0x0018, 0x9312,
			"CT Geometry Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag CTImageFrameTypeSeq = new DicomTag(0x0018,
			0x9329, "CT Image Frame Type Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag CTPositionSeq = new DicomTag(0x0018, 0x9326,
			"CT Position Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag CTReconstructionSeq = new DicomTag(0x0018,
			0x9314, "CT Reconstruction Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag CTTableDynamicsSeq = new DicomTag(0x0018,
			0x9308, "CT Table Dynamics Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag CTXRayDetailsSeq = new DicomTag(0x0018, 0x9325,
			"CT X-ray Details Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag CumulativeDoseReferenceCoefficient = new DicomTag(
			0x300a, 0x010c, "Cumulative Dose Reference Coefficient",
			ValueRepresentation.DecimalString);

	public static final DicomTag CumulativeDoseToDoseReference = new DicomTag(
			0x3008, 0x0052, "Cumulative Dose to Dose Reference",
			ValueRepresentation.DecimalString);

	public static final DicomTag CumulativeMetersetWeight = new DicomTag(0x300a,
			0x0134, "Cumulative Meterset Weight", ValueRepresentation.DecimalString);

	public static final DicomTag CumulativeTimeWeight = new DicomTag(0x300a,
			0x02d6, "Cumulative Time Weight", ValueRepresentation.DecimalString);

	public static final DicomTag CurrentFractionNumber = new DicomTag(0x3008,
			0x0022, "Current Fraction Number", ValueRepresentation.IntegerString);

	public static final DicomTag CurrentPatientLocation = new DicomTag(0x0038,
			0x0300, "Current Patient Location", ValueRepresentation.LongString);

	public static final DicomTag CurrentRequestedProcedureEvidenceSeq = new DicomTag(
			0x0040, 0xa375, "Current Requested Procedure Evidence Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag CurrentTreatmentStatus = new DicomTag(0x3008,
			0x0200, "Current Treatment Status", ValueRepresentation.CodeString);

	public static final DicomTag CurveDate = new DicomTag(0x0008, 0x0025,
			"Curve Date", ValueRepresentation.Date);

	public static final DicomTag CurveNumber = new DicomTag(0x0020, 0x0024,
			"Curve Number", ValueRepresentation.IntegerString);

	public static final DicomTag CurveTime = new DicomTag(0x0008, 0x0035,
			"Curve Time", ValueRepresentation.Time);

	public static final DicomTag CylinderAxis = new DicomTag(0x0022, 0x0009,
			"Cylinder Axis", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag CylinderLensPower = new DicomTag(0x0022, 0x0008,
			"Cylinder Lens Power", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag DataCollectionCenterPatient = new DicomTag(
			0x0018, 0x9313, "Data Collection Center (Patient)",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag DataCollectionDiameter = new DicomTag(0x0018,
			0x0090, "Data Collection Diameter", ValueRepresentation.DecimalString);

	public static final DicomTag DataInformationSeq = new DicomTag(0x0054,
			0x0063, "Data Information Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DataPointColumns = new DicomTag(0x0028, 0x9002,
			"Data Point Columns", ValueRepresentation.UnsignedLong);

	public static final DicomTag DataPointRows = new DicomTag(0x0028, 0x9001,
			"Data Point Rows", ValueRepresentation.UnsignedLong);

	public static final DicomTag DataRepresentation = new DicomTag(0x0028,
			0x9108, "Data Representation", ValueRepresentation.CodeString);

	public static final DicomTag DataSetSubtypeRetired = new DicomTag(0x0008,
			0x0041, "Data Set Subtype (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag DataSetTrailingPadding = new DicomTag(0xfffc,
			0xfffc, "Data Set Trailing Padding", ValueRepresentation.OtherByteString);

	public static final DicomTag DataSetType = new DicomTag(0x0000, 0x0800,
			"Data Set type", ValueRepresentation.UnsignedShort);

	public static final DicomTag DataSetTypeRetired = new DicomTag(0x0008,
			0x0040, "Data Set Type (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag Date = new DicomTag(0x0040, 0xa121, "Date",
			ValueRepresentation.Date);

	public static final DicomTag DateOfLastCalibration = new DicomTag(0x0018,
			0x1200, "Date of Last Calibration", ValueRepresentation.Date);

	public static final DicomTag DateOfLastDetectorCalibration = new DicomTag(
			0x0018, 0x700c, "Date of Last Detector Calibration",
			ValueRepresentation.Date);

	public static final DicomTag DateOfSecondaryCapture = new DicomTag(0x0018,
			0x1012, "Date of Secondary Capture", ValueRepresentation.Date);

	public static final DicomTag DateTime = new DicomTag(0x0040, 0xa120,
			"DateTime", ValueRepresentation.DateTime);

	public static final DicomTag dBDt = new DicomTag(0x0018, 0x1318, "dB/dt",
			ValueRepresentation.DecimalString);

	public static final DicomTag DeadTimeCorrectionFlag = new DicomTag(0x0054,
			0x1401, "Dead Time Correction Flag", ValueRepresentation.CodeString);

	public static final DicomTag DeadTimeFactor = new DicomTag(0x0054, 0x1324,
			"Dead Time Factor", ValueRepresentation.DecimalString);

	public static final DicomTag DecayCorrection = new DicomTag(0x0054, 0x1102,
			"Decay Correction", ValueRepresentation.CodeString);

	public static final DicomTag DecayFactor = new DicomTag(0x0054, 0x1321,
			"Decay Factor", ValueRepresentation.DecimalString);

	public static final DicomTag DecimateCropResult = new DicomTag(0x2020,
			0x00a2, "Decimate/Crop Result", ValueRepresentation.CodeString);

	public static final DicomTag DeCoupledNucleus = new DicomTag(0x0018, 0x9060,
			"De-coupled Nucleus", ValueRepresentation.CodeString);

	public static final DicomTag DeCoupling = new DicomTag(0x0018, 0x9059,
			"De-coupling", ValueRepresentation.CodeString);

	public static final DicomTag DeCouplingChemicalShiftReference = new DicomTag(
			0x0018, 0x9063, "De-coupling Chemical Shift Reference",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag DeCouplingFrequency = new DicomTag(0x0018,
			0x9061, "De-coupling Frequency", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag DeCouplingMethod = new DicomTag(0x0018, 0x9062,
			"De-coupling Method", ValueRepresentation.CodeString);

	public static final DicomTag DefaultMagnificationType = new DicomTag(0x2010,
			0x00a6, "Default Magnification Type", ValueRepresentation.CodeString);

	public static final DicomTag DefaultPrinterResolutionID = new DicomTag(
			0x2010, 0x0054, "Default Printer Resolution ID",
			ValueRepresentation.CodeString);

	public static final DicomTag DefaultSmoothingType = new DicomTag(0x2010,
			0x00a8, "Default Smoothing Type", ValueRepresentation.CodeString);

	public static final DicomTag DegreeOfDilation = new DicomTag(0x0022, 0x000e,
			"Degree of Dilation", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag DeIdentificationMethod = new DicomTag(0x0012,
			0x0063, "De-identification Method", ValueRepresentation.LongString);

	public static final DicomTag DeIdentificationMethodCodeSeq = new DicomTag(
			0x0012, 0x0064, "De-identification Method Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag DeliveredChannelTotalTime = new DicomTag(0x3008,
			0x0134, "Delivered Channel Total Time", ValueRepresentation.DecimalString);

	public static final DicomTag DeliveredMeterset = new DicomTag(0x3008, 0x0044,
			"Delivered Meterset", ValueRepresentation.DecimalString);

	public static final DicomTag DeliveredNumberOfPulses = new DicomTag(0x3008,
			0x0138, "Delivered Number of Pulses", ValueRepresentation.IntegerString);

	public static final DicomTag DeliveredPrimaryMeterset = new DicomTag(0x3008,
			0x0036, "Delivered Primary Meterset", ValueRepresentation.DecimalString);

	public static final DicomTag DeliveredPulseRepetitionInterval = new DicomTag(
			0x3008, 0x013c, "Delivered Pulse Repetition Interval",
			ValueRepresentation.DecimalString);

	public static final DicomTag DeliveredSecondaryMeterset = new DicomTag(
			0x3008, 0x0037, "Delivered Secondary Meterset",
			ValueRepresentation.DecimalString);

	public static final DicomTag DeliveredTreatmentTime = new DicomTag(0x3008,
			0x003b, "Delivered Treatment Time", ValueRepresentation.DecimalString);

	public static final DicomTag DeliveryMaximumDose = new DicomTag(0x300a,
			0x0023, "Delivery Maximum Dose", ValueRepresentation.DecimalString);

	public static final DicomTag DeliveryWarningDose = new DicomTag(0x300a,
			0x0022, "Delivery Warning Dose", ValueRepresentation.DecimalString);

	public static final DicomTag DepthOfScanField = new DicomTag(0x0018, 0x5050,
			"Depth of Scan Field", ValueRepresentation.IntegerString);

	public static final DicomTag DerivationCodeSeq = new DicomTag(0x0008, 0x9215,
			"Derivation Code Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DerivationDescription = new DicomTag(0x0008,
			0x2111, "Derivation Description", ValueRepresentation.ShortText);

	public static final DicomTag DerivationImageSeq = new DicomTag(0x0008,
			0x9124, "Derivation Image Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DestinationAE = new DicomTag(0x2100, 0x0140,
			"Destination AE", ValueRepresentation.ApplicationEntity);

	public static final DicomTag DetectorActivationOffsetFromExposure = new DicomTag(
			0x0018, 0x7016, "Detector Activation Offset From Exposure",
			ValueRepresentation.DecimalString);

	public static final DicomTag DetectorActiveDimension = new DicomTag(0x0018,
			0x7026, "Detector Active Dimension(s)", ValueRepresentation.DecimalString);

	public static final DicomTag DetectorActiveOrigin = new DicomTag(0x0018,
			0x7028, "Detector Active Origin", ValueRepresentation.DecimalString);

	public static final DicomTag DetectorActiveShape = new DicomTag(0x0018,
			0x7024, "Detector Active Shape", ValueRepresentation.CodeString);

	public static final DicomTag DetectorActiveTime = new DicomTag(0x0018,
			0x7014, "Detector Active Time", ValueRepresentation.DecimalString);

	public static final DicomTag DetectorBinning = new DicomTag(0x0018, 0x701a,
			"Detector Binning", ValueRepresentation.DecimalString);

	public static final DicomTag DetectorConditionsNominalFlag = new DicomTag(
			0x0018, 0x7000, "Detector Conditions Nominal Flag",
			ValueRepresentation.CodeString);

	public static final DicomTag DetectorConfiguration = new DicomTag(0x0018,
			0x7005, "Detector Configuration", ValueRepresentation.CodeString);

	public static final DicomTag DetectorDescription = new DicomTag(0x0018,
			0x7006, "Detector Description", ValueRepresentation.LongText);

	public static final DicomTag DetectorElementPhysicalSize = new DicomTag(
			0x0018, 0x7020, "Detector Element Physical Size",
			ValueRepresentation.DecimalString);

	public static final DicomTag DetectorElementSize = new DicomTag(0x0054,
			0x1203, "Detector Element Size", ValueRepresentation.DecimalString);

	public static final DicomTag DetectorElementSpacing = new DicomTag(0x0018,
			0x7022, "Detector Element Spacing", ValueRepresentation.DecimalString);

	public static final DicomTag DetectorID = new DicomTag(0x0018, 0x700a,
			"Detector ID", ValueRepresentation.ShortString);

	public static final DicomTag DetectorInformationSeq = new DicomTag(0x0054,
			0x0022, "Detector Information Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag DetectorLinesOfResponseUsed = new DicomTag(
			0x0054, 0x1104, "Detector Lines of Response Used",
			ValueRepresentation.LongString);

	public static final DicomTag DetectorMode = new DicomTag(0x0018, 0x7008,
			"Detector Mode", ValueRepresentation.LongText);

	public static final DicomTag DetectorPrimaryAngle = new DicomTag(0x0018,
			0x1530, "Detector Primary Angle", ValueRepresentation.DecimalString);

	public static final DicomTag DetectorSecondaryAngle = new DicomTag(0x0018,
			0x1531, "Detector Secondary Angle", ValueRepresentation.DecimalString);

	public static final DicomTag DetectorTemperature = new DicomTag(0x0018,
			0x7001, "Detector Temperature", ValueRepresentation.DecimalString);

	public static final DicomTag DetectorTimeSinceLastExposure = new DicomTag(
			0x0018, 0x7012, "Detector Time Since Last Exposure",
			ValueRepresentation.DecimalString);

	public static final DicomTag DetectorType = new DicomTag(0x0018, 0x7004,
			"Detector Type", ValueRepresentation.CodeString);

	public static final DicomTag DetectorVector = new DicomTag(0x0054, 0x0020,
			"Detector Vector", ValueRepresentation.UnsignedShort);

	public static final DicomTag DeviceDescription = new DicomTag(0x0050, 0x0020,
			"Device Description", ValueRepresentation.LongString);

	public static final DicomTag DeviceDiameter = new DicomTag(0x0050, 0x0016,
			"Device Diameter", ValueRepresentation.DecimalString);

	public static final DicomTag DeviceDiameterUnits = new DicomTag(0x0050,
			0x0017, "Device Diameter Units", ValueRepresentation.CodeString);

	public static final DicomTag DeviceLength = new DicomTag(0x0050, 0x0014,
			"Device Length", ValueRepresentation.DecimalString);

	public static final DicomTag DeviceSeq = new DicomTag(0x0050, 0x0010,
			"Device Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DeviceSerialNumber = new DicomTag(0x0018,
			0x1000, "Device Serial Number", ValueRepresentation.LongString);

	public static final DicomTag DeviceVolume = new DicomTag(0x0050, 0x0018,
			"Device Volume", ValueRepresentation.DecimalString);

	public static final DicomTag DialogReceiverRetired = new DicomTag(0x0000,
			0x4000, "Dialog Receiver (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag DiffusionAnisotropyType = new DicomTag(0x0018,
			0x9147, "Diffusion Anisotropy Type", ValueRepresentation.CodeString);

	public static final DicomTag DiffusionBValue = new DicomTag(0x0018, 0x9087,
			"Diffusion b-value", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag DiffusionDirectionality = new DicomTag(0x0018,
			0x9075, "Diffusion Directionality", ValueRepresentation.CodeString);

	public static final DicomTag DiffusionGradientDirectionSeq = new DicomTag(
			0x0018, 0x9076, "Diffusion Gradient Direction Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag DiffusionGradientOrientation = new DicomTag(
			0x0018, 0x9089, "Diffusion Gradient Orientation",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag DigitalImageFormatAcquired = new DicomTag(
			0x0018, 0x1023, "Digital Image Format Acquired",
			ValueRepresentation.LongString);

	public static final DicomTag DimensionIndexPointer = new DicomTag(0x0020,
			0x9165, "Dimension Index Pointer", ValueRepresentation.AttributeTag);

	public static final DicomTag DimensionIndexPrivateCreator = new DicomTag(
			0x0020, 0x9213, "Dimension Index Private Creator",
			ValueRepresentation.LongString);

	public static final DicomTag DimensionIndexSeq = new DicomTag(0x0020, 0x9222,
			"Dimension Index Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DimensionIndexValues = new DicomTag(0x0020,
			0x9157, "Dimension Index Values", ValueRepresentation.UnsignedLong);

	public static final DicomTag DimensionOrganizationSeq = new DicomTag(0x0020,
			0x9221, "Dimension Organization Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag DimensionOrganizationUID = new DicomTag(0x0020,
			0x9164, "Dimension Organization UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag DirectoryRecordSeq = new DicomTag(0x0004,
			0x1220, "Directory Record Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DirectoryRecordType = new DicomTag(0x0004,
			0x1430, "Directory Record Type", ValueRepresentation.CodeString);

	public static final DicomTag DischargeDate = new DicomTag(0x0038, 0x0030,
			"Discharge Date", ValueRepresentation.Date);

	public static final DicomTag DischargeDiagnosisCodeSeq = new DicomTag(0x0038,
			0x0044, "Discharge Diagnosis Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag DischargeDiagnosisDescription = new DicomTag(
			0x0038, 0x0040, "Discharge Diagnosis Description",
			ValueRepresentation.LongString);

	public static final DicomTag DischargeTime = new DicomTag(0x0038, 0x0032,
			"Discharge Time", ValueRepresentation.Time);

	public static final DicomTag DisplayedAreaBottomRightHandCorner = new DicomTag(
			0x0070, 0x0053, "Displayed Area Bottom Right Hand Corner",
			ValueRepresentation.SignedLong);

	public static final DicomTag DisplayedAreaSelectionSeq = new DicomTag(0x0070,
			0x005a, "Displayed Area Selection Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag DisplayedAreaTopLeftHandCorner = new DicomTag(
			0x0070, 0x0052, "Displayed Area Top Left Hand Corner",
			ValueRepresentation.SignedLong);

	public static final DicomTag DisplayEnvironmentSpatialPosition = new DicomTag(
			0x0072, 0x0108, "Display Environment Spatial Position",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag DisplayFormatRetired = new DicomTag(0x0000,
			0x5110, "Display Format (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag DisplaySetNumber = new DicomTag(0x0072, 0x0202,
			"Display Set Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag DisplaySetPatientOrientation = new DicomTag(
			0x0072, 0x0700, "Display Set Patient Orientation",
			ValueRepresentation.CodeString);

	public static final DicomTag DisplaySetPresentationGroup = new DicomTag(
			0x0072, 0x0204, "Display Set Presentation Group",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag DisplaySetPresentationGroupDescription = new DicomTag(
			0x0072, 0x0206, "Display Set Presentation Group Description",
			ValueRepresentation.LongString);

	public static final DicomTag DisplaySetScrollingGroup = new DicomTag(0x0072,
			0x0212, "Display Set Scrolling Group", ValueRepresentation.Unknown);

	public static final DicomTag DisplaySetsSeq = new DicomTag(0x0072, 0x0200,
			"Display Sets Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DistanceSourceToDataCollectionCenter = new DicomTag(
			0x0018, 0x9335, "Distance Source to Data Collection Center",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag DistanceSourceToDetector = new DicomTag(0x0018,
			0x1110, "Distance Source to Detector", ValueRepresentation.DecimalString);

	public static final DicomTag DistanceSourceToEntrance = new DicomTag(0x0040,
			0x0306, "Distance Source to Entrance", ValueRepresentation.DecimalString);

	public static final DicomTag DistanceSourceToPatient = new DicomTag(0x0018,
			0x1111, "Distance Source to Patient", ValueRepresentation.DecimalString);

	public static final DicomTag DistanceSourceToSupport = new DicomTag(0x0040,
			0x0307, "Distance Source to Support", ValueRepresentation.DecimalString);

	public static final DicomTag DistributionAddress = new DicomTag(0x4008,
			0x011a, "Distribution Address", ValueRepresentation.LongString);

	public static final DicomTag DistributionName = new DicomTag(0x4008, 0x0119,
			"Distribution Name", ValueRepresentation.PersonName);

	public static final DicomTag DocumentTitle = new DicomTag(0x0042, 0x0010,
			"Document Title", ValueRepresentation.ShortText);

	public static final DicomTag DopplerCorrectionAngle = new DicomTag(0x0018,
			0x6034, "Doppler Correction Angle",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag DopplerSampleVolumeXPosition = new DicomTag(
			0x0018, 0x6038, "Doppler Sample Volume X Position",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag DopplerSampleVolumeYPosition = new DicomTag(
			0x0018, 0x603a, "Doppler Sample Volume Y Position",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag DoseCalibrationFactor = new DicomTag(0x0054,
			0x1322, "Dose Calibration Factor", ValueRepresentation.DecimalString);

	public static final DicomTag DoseComment = new DicomTag(0x3004, 0x0006,
			"Dose Comment", ValueRepresentation.LongString);

	public static final DicomTag DoseGridScaling = new DicomTag(0x3004, 0x000e,
			"Dose Grid Scaling", ValueRepresentation.DecimalString);

	public static final DicomTag DoseRateDelivered = new DicomTag(0x3008, 0x0048,
			"Dose Rate Delivered", ValueRepresentation.DecimalString);

	public static final DicomTag DoseRateSet = new DicomTag(0x300a, 0x0115,
			"Dose Rate Set", ValueRepresentation.DecimalString);

	public static final DicomTag DoseReferenceDescription = new DicomTag(0x300a,
			0x0016, "Dose Reference Description", ValueRepresentation.LongString);

	public static final DicomTag DoseReferenceNumber = new DicomTag(0x300a,
			0x0012, "Dose Reference Number", ValueRepresentation.IntegerString);

	public static final DicomTag DoseReferencePointCoordinates = new DicomTag(
			0x300a, 0x0018, "Dose Reference Point Coordinates",
			ValueRepresentation.DecimalString);

	public static final DicomTag DoseReferenceSeq = new DicomTag(0x300a, 0x0010,
			"Dose Reference Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DoseReferenceStructureType = new DicomTag(
			0x300a, 0x0014, "Dose Reference Structure Type",
			ValueRepresentation.CodeString);

	public static final DicomTag DoseReferenceType = new DicomTag(0x300a, 0x0020,
			"Dose Reference Type", ValueRepresentation.CodeString);

	public static final DicomTag DoseSummationType = new DicomTag(0x3004, 0x000a,
			"Dose Summation Type", ValueRepresentation.CodeString);

	public static final DicomTag DoseType = new DicomTag(0x3004, 0x0004,
			"Dose Type", ValueRepresentation.CodeString);

	public static final DicomTag DoseUnits = new DicomTag(0x3004, 0x0002,
			"Dose Units", ValueRepresentation.CodeString);

	public static final DicomTag DoseValue = new DicomTag(0x3004, 0x0012,
			"Dose Value", ValueRepresentation.DecimalString);

	public static final DicomTag DVHData = new DicomTag(0x3004, 0x0058,
			"DVH Data", ValueRepresentation.DecimalString);

	public static final DicomTag DVHDoseScaling = new DicomTag(0x3004, 0x0052,
			"DVH Dose Scaling", ValueRepresentation.DecimalString);

	public static final DicomTag DVHMaximumDose = new DicomTag(0x3004, 0x0072,
			"DVH Maximum Dose", ValueRepresentation.DecimalString);

	public static final DicomTag DVHMeanDose = new DicomTag(0x3004, 0x0074,
			"DVH Mean Dose", ValueRepresentation.DecimalString);

	public static final DicomTag DVHMinimumDose = new DicomTag(0x3004, 0x0070,
			"DVH Minimum Dose", ValueRepresentation.DecimalString);

	public static final DicomTag DVHNormalizationDoseValue = new DicomTag(0x3004,
			0x0042, "DVH Normalization Dose Value", ValueRepresentation.DecimalString);

	public static final DicomTag DVHNormalizationPoint = new DicomTag(0x3004,
			0x0040, "DVH Normalization Point", ValueRepresentation.DecimalString);

	public static final DicomTag DVHNumberOfBins = new DicomTag(0x3004, 0x0056,
			"DVH Number of Bins", ValueRepresentation.IntegerString);

	public static final DicomTag DVHRefROISeq = new DicomTag(0x3004, 0x0060,
			"DVH Referenced ROI Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DVHROIContributionType = new DicomTag(0x3004,
			0x0062, "DVH ROI Contribution Type", ValueRepresentation.CodeString);

	public static final DicomTag DVHSeq = new DicomTag(0x3004, 0x0050,
			"DVH Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag DVHType = new DicomTag(0x3004, 0x0001,
			"DVH Type", ValueRepresentation.CodeString);

	public static final DicomTag DVHVolumeUnits = new DicomTag(0x3004, 0x0054,
			"DVH Volume Units", ValueRepresentation.CodeString);

	public static final DicomTag DynamicRangeRetired = new DicomTag(0x0018,
			0x5030, "Dynamic Range (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag EchoNumber = new DicomTag(0x0018, 0x0086,
			"Echo Number(s)", ValueRepresentation.IntegerString);

	public static final DicomTag EchoPlanarPulseSeq = new DicomTag(0x0018,
			0x9018, "Echo Planar Pulse Sequence", ValueRepresentation.CodeString);

	public static final DicomTag EchoPulseSeq = new DicomTag(0x0018, 0x9008,
			"Echo Pulse Sequence", ValueRepresentation.CodeString);

	public static final DicomTag EchoTime = new DicomTag(0x0018, 0x0081,
			"Echo Time", ValueRepresentation.DecimalString);

	public static final DicomTag EchoTrainLength = new DicomTag(0x0018, 0x0091,
			"Echo Train Length", ValueRepresentation.IntegerString);

	public static final DicomTag EcryptedAttributesSeq = new DicomTag(0x0400,
			0x0500, "Encrypted Attributes Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag EffectiveDuration = new DicomTag(0x0018, 0x0072,
			"Effective Duration", ValueRepresentation.DecimalString);

	public static final DicomTag EffectiveEchoTime = new DicomTag(0x0018, 0x9082,
			"Effective Echo Time", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag EmmetropicMagnification = new DicomTag(0x0022,
			0x000a, "Emmetropic Magnification",
			ValueRepresentation.FloatingPointSingle);

	public static final DicomTag EmptyImageDensity = new DicomTag(0x2010, 0x0110,
			"Empty Image Density", ValueRepresentation.CodeString);

	public static final DicomTag EncapsulatedDocument = new DicomTag(0x0042,
			0x0011, "Encapsulated Document", ValueRepresentation.OtherByteString);

	public static final DicomTag EncryptedContent = new DicomTag(0x0400, 0x0520,
			"Encrypted Content", ValueRepresentation.OtherByteString);

	public static final DicomTag EncryptedContentTransferSyntax = new DicomTag(
			0x0400, 0x0510, "Encrypted Content Transfer Syntax UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag EndCumulativeMetersetWeight = new DicomTag(
			0x300c, 0x0009, "End Cumulative Meterset Weight",
			ValueRepresentation.DecimalString);

	public static final DicomTag EndMessageIDRetired = new DicomTag(0x0000,
			0x5020, "End Message ID (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag EndMeterset = new DicomTag(0x3008, 0x007a,
			"End Meterset", ValueRepresentation.DecimalString);

	public static final DicomTag EnergyWindowCenterlineRetired = new DicomTag(
			0x0018, 0x0032, "Energy Window Centerline (Retired)",
			ValueRepresentation.DecimalString);

	public static final DicomTag EnergyWindowInformationSeq = new DicomTag(
			0x0054, 0x0012, "Energy Window Information Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag EnergyWindowLowerLimit = new DicomTag(0x0054,
			0x0014, "Energy Window Lower Limit", ValueRepresentation.DecimalString);

	public static final DicomTag EnergyWindowName = new DicomTag(0x0054, 0x0018,
			"Energy Window Name", ValueRepresentation.ShortString);

	public static final DicomTag EnergyWindowNumber = new DicomTag(0x0054,
			0x0308, "Energy Window Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag EnergyWindowRangeSeq = new DicomTag(0x0054,
			0x0013, "Energy Window Range Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag EnergyWindowTotalWidthRetired = new DicomTag(
			0x0018, 0x0033, "Energy Window Total Width (Retired)",
			ValueRepresentation.DecimalString);

	public static final DicomTag EnergyWindowUpperLimit = new DicomTag(0x0054,
			0x0015, "Energy Window Upper Limit", ValueRepresentation.DecimalString);

	public static final DicomTag EnergyWindowVector = new DicomTag(0x0054,
			0x0010, "Energy Window Vector", ValueRepresentation.UnsignedShort);

	public static final DicomTag EntranceDose = new DicomTag(0x0040, 0x0302,
			"Entrance Dose", ValueRepresentation.UnsignedShort);

	public static final DicomTag EntranceDoseInmGy = new DicomTag(0x0040, 0x8302,
			"Entrance Dose in mGy", ValueRepresentation.DecimalString);

	public static final DicomTag EraseRetired = new DicomTag(0x0000, 0x5190,
			"Erase (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag ErrorComment = new DicomTag(0x0000, 0x0902,
			"Error Comment", ValueRepresentation.LongString);

	public static final DicomTag ErrorID = new DicomTag(0x0000, 0x0903,
			"Error ID", ValueRepresentation.UnsignedShort);

	public static final DicomTag EstimatedDoseSaving = new DicomTag(0x0018,
			0x9324, "Estimated Dose Saving", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag EstimatedRadiographicMagnificationFactor = new DicomTag(
			0x0018, 0x1114, "Estimated Radiographic Magnification Factor",
			ValueRepresentation.DecimalString);

	public static final DicomTag EthnicGroup = new DicomTag(0x0010, 0x2160,
			"Ethnic Group", ValueRepresentation.ShortString);

	public static final DicomTag EventElapsedTime = new DicomTag(0x0008, 0x2130,
			"Event Elapsed Time(s)", ValueRepresentation.DecimalString);

	public static final DicomTag EventTimerName = new DicomTag(0x0008, 0x2132,
			"Event Timer Name(s)", ValueRepresentation.LongString);

	public static final DicomTag EventTypeID = new DicomTag(0x0000, 0x1002,
			"Event type ID", ValueRepresentation.UnsignedShort);

	public static final DicomTag ExecutionStatus = new DicomTag(0x2100, 0x0020,
			"Execution Status", ValueRepresentation.CodeString);

	public static final DicomTag ExecutionStatusInfo = new DicomTag(0x2100,
			0x0030, "Execution Status Info", ValueRepresentation.CodeString);

	public static final DicomTag ExpectedCompletionDateAndTime = new DicomTag(
			0x0040, 0x4011, "Expected Completion Date and Time",
			ValueRepresentation.DateTime);

	public static final DicomTag ExposedArea = new DicomTag(0x0040, 0x0303,
			"Exposed Area", ValueRepresentation.UnsignedShort);

	public static final DicomTag Exposure = new DicomTag(0x0018, 0x1152,
			"Exposure", ValueRepresentation.IntegerString);

	public static final DicomTag ExposureControlMode = new DicomTag(0x0018,
			0x7060, "Exposure Control Mode", ValueRepresentation.CodeString);

	public static final DicomTag ExposureControlModeDescription = new DicomTag(
			0x0018, 0x7062, "Exposure Control Mode Description",
			ValueRepresentation.LongText);

	public static final DicomTag ExposureDoseSeq = new DicomTag(0x0040, 0x030e,
			"Exposure Dose Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ExposureInMAs = new DicomTag(0x0018, 0x9332,
			"Exposure in mAs", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ExposureInuAs = new DicomTag(0x0018, 0x1153,
			"Exposure in uAs", ValueRepresentation.IntegerString);

	public static final DicomTag ExposureModulationType = new DicomTag(0x0018,
			0x9323, "Exposure Modulation Type", ValueRepresentation.CodeString);

	public static final DicomTag ExposureSeq = new DicomTag(0x3002, 0x0030,
			"Exposure Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ExposuresOnDetectorSinceLastCalibration = new DicomTag(
			0x0018, 0x7010, "Exposures on Detector Since Last Calibration",
			ValueRepresentation.IntegerString);

	public static final DicomTag ExposuresOnDetectorSinceManufactured = new DicomTag(
			0x0018, 0x7011, "Exposures on Detector Since Manufactured",
			ValueRepresentation.IntegerString);

	public static final DicomTag ExposuresOnPlate = new DicomTag(0x0018, 0x1404,
			"Exposures on Plate", ValueRepresentation.UnsignedShort);

	public static final DicomTag ExposureStatus = new DicomTag(0x0018, 0x7064,
			"Exposure Status", ValueRepresentation.CodeString);

	public static final DicomTag ExposureTime = new DicomTag(0x0018, 0x1150,
			"Exposure Time", ValueRepresentation.IntegerString);

	public static final DicomTag ExposureTimeInMs = new DicomTag(0x0018, 0x9328,
			"Exposure Time in ms", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ExposureTimeInuS = new DicomTag(0x0018, 0x8150,
			"Exposure Time in uS", ValueRepresentation.DecimalString);

	public static final DicomTag FailedSOPInstanceUIDList = new DicomTag(0x0008,
			0x0058, "Failed SOP Instance UID List",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag FailedSOPSeq = new DicomTag(0x0008, 0x1198,
			"Failed SOP Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FailureAttributes = new DicomTag(0x2200, 0x000e,
			"Failure Attributes", ValueRepresentation.AttributeTag);

	public static final DicomTag FailureReason = new DicomTag(0x0008, 0x1197,
			"Failure Reason", ValueRepresentation.UnsignedShort);

	public static final DicomTag FiducialDescription = new DicomTag(0x0070,
			0x030f, "Fiducial Description", ValueRepresentation.ShortText);

	public static final DicomTag FiducialIdentifier = new DicomTag(0x0070,
			0x0310, "Fiducial Identifier", ValueRepresentation.ShortString);

	public static final DicomTag FiducialIdentifierCodeSeq = new DicomTag(0x0070,
			0x0311, "Fiducial Identifier Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag FiducialSeq = new DicomTag(0x0070, 0x031e,
			"Fiducial Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FiducialSetSeq = new DicomTag(0x0070, 0x031c,
			"Fiducial Set Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FiducialUID = new DicomTag(0x0070, 0x031a,
			"Fiducial UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag FieldOfViewDimension = new DicomTag(0x0018,
			0x1149, "Field of View Dimension(s)", ValueRepresentation.IntegerString);

	public static final DicomTag FieldOfViewHorizontalFlip = new DicomTag(0x0018,
			0x7034, "Field of View Horizontal Flip", ValueRepresentation.CodeString);

	public static final DicomTag FieldOfViewOrigin = new DicomTag(0x0018, 0x7030,
			"Field of View Origin", ValueRepresentation.DecimalString);

	public static final DicomTag FieldOfViewRotation = new DicomTag(0x0018,
			0x7032, "Field of View Rotation", ValueRepresentation.DecimalString);

	public static final DicomTag FieldOfViewShape = new DicomTag(0x0018, 0x1147,
			"Field of View Shape", ValueRepresentation.CodeString);

	public static final DicomTag FileMetaInformationGroupLength = new DicomTag(
			0x0002, 0x0000, "File Meta Information Group Length",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag FileMetaInformationVersion = new DicomTag(
			0x0002, 0x0001, "File Meta Information Version",
			ValueRepresentation.OtherByteString);

	public static final DicomTag FileSetConsistencyFlag = new DicomTag(0x0004,
			0x1212, "File-set Consistency Flag", ValueRepresentation.UnsignedShort);

	public static final DicomTag FileSetDescriptorFileID = new DicomTag(0x0004,
			0x1141, "File-set Descriptor File ID", ValueRepresentation.CodeString);

	public static final DicomTag FileSetID = new DicomTag(0x0004, 0x1130,
			"File-set ID", ValueRepresentation.CodeString);

	public static final DicomTag FillerOrderNumber = new DicomTag(0x0040, 0x2017,
			"Filler Order Number / Imaging Service Request",
			ValueRepresentation.LongString);

	public static final DicomTag FillerOrderNumberImagingServiceRequestRetired = new DicomTag(
			0x0040, 0x2007, "Filler Order Number / Image Service Request (Retired)",
			ValueRepresentation.ShortString);

	public static final DicomTag FillerOrderNumberProcedureRetired = new DicomTag(
			0x0040, 0x1007, "Filler Order Number / Procedure (Retired)",
			ValueRepresentation.ShortString);

	public static final DicomTag FilmBoxContentSeq = new DicomTag(0x2130, 0x0030,
			"Film Box Content Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FilmConsumptionSeq = new DicomTag(0x0040,
			0x0321, "Film Consumption Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FilmDestination = new DicomTag(0x2000, 0x0040,
			"Film Destination", ValueRepresentation.CodeString);

	public static final DicomTag FilmOrientation = new DicomTag(0x2010, 0x0040,
			"Film Orientation", ValueRepresentation.CodeString);

	public static final DicomTag FilmSessionLabel = new DicomTag(0x2000, 0x0050,
			"Film Session Label", ValueRepresentation.LongString);

	public static final DicomTag FilmSizeID = new DicomTag(0x2010, 0x0050,
			"Film Size ID", ValueRepresentation.CodeString);

	public static final DicomTag FilterByAttributePresence = new DicomTag(0x0072,
			0x0404, "Filter-by Attribute Presence", ValueRepresentation.CodeString);

	public static final DicomTag FilterByCategory = new DicomTag(0x0072, 0x0402,
			"Filter-by Category", ValueRepresentation.CodeString);

	public static final DicomTag FilterByOperator = new DicomTag(0x0072, 0x0406,
			"Filter-by Operator", ValueRepresentation.CodeString);

	public static final DicomTag FilterHighFrequency = new DicomTag(0x003a,
			0x0221, "Filter High Frequency", ValueRepresentation.DecimalString);

	public static final DicomTag FilterLowFrequency = new DicomTag(0x003a,
			0x0220, "Filter Low Frequency", ValueRepresentation.DecimalString);

	public static final DicomTag FilterMaterial = new DicomTag(0x0018, 0x7050,
			"Filter Material", ValueRepresentation.CodeString);

	public static final DicomTag FilterOperationsSeq = new DicomTag(0x0072,
			0x0400, "Filter Operations Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FilterThicknessMaximum = new DicomTag(0x0018,
			0x7054, "Filter Thickness Maximum", ValueRepresentation.DecimalString);

	public static final DicomTag FilterThicknessMinimum = new DicomTag(0x0018,
			0x7052, "Filter Thickness Minimum", ValueRepresentation.DecimalString);

	public static final DicomTag FilterType = new DicomTag(0x0018, 0x1160,
			"Filter Type", ValueRepresentation.ShortString);

	public static final DicomTag FinalCumulativeMetersetWeight = new DicomTag(
			0x300a, 0x010e, "Final Cumulative Meterset Weight",
			ValueRepresentation.DecimalString);

	public static final DicomTag FinalCumulativeTimeWeight = new DicomTag(0x300a,
			0x02c8, "Final Cumulative Time Weight", ValueRepresentation.DecimalString);

	public static final DicomTag FindLocationRetired = new DicomTag(0x0000,
			0x0400, "Find Location (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag FirstOrderPhaseCorrection = new DicomTag(0x0018,
			0x9198, "First Order Phase Correction", ValueRepresentation.CodeString);

	public static final DicomTag FirstOrderPhaseCorrectionAngle = new DicomTag(
			0x5600, 0x0010, "First Order Phase Correction Angle",
			ValueRepresentation.OtherFloatString);

	public static final DicomTag FirstTreatmentDate = new DicomTag(0x3008,
			0x0054, "First Treatment Date", ValueRepresentation.Date);

	public static final DicomTag FixationDeviceDescription = new DicomTag(0x300a,
			0x0196, "Fixation Device Description", ValueRepresentation.ShortText);

	public static final DicomTag FixationDeviceLabel = new DicomTag(0x300a,
			0x0194, "Fixation Device Label", ValueRepresentation.ShortString);

	public static final DicomTag FixationDevicePosition = new DicomTag(0x300a,
			0x0198, "Fixation Device Position", ValueRepresentation.ShortString);

	public static final DicomTag FixationDeviceSeq = new DicomTag(0x300a, 0x0190,
			"Fixation Device Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FixationDeviceType = new DicomTag(0x300a,
			0x0192, "Fixation Device Type", ValueRepresentation.CodeString);

	public static final DicomTag FlipAngle = new DicomTag(0x0018, 0x1314,
			"Flip Angle", ValueRepresentation.DecimalString);

	public static final DicomTag FlowCompensation = new DicomTag(0x0018, 0x9010,
			"Flow Compensation", ValueRepresentation.CodeString);

	public static final DicomTag FlowCompensationDirection = new DicomTag(0x0018,
			0x9183, "Flow Compensation Direction", ValueRepresentation.CodeString);

	public static final DicomTag FluenceDataScale = new DicomTag(0x3002, 0x0042,
			"Fluence Data Scale", ValueRepresentation.DecimalString);

	public static final DicomTag FluenceDataSource = new DicomTag(0x3002, 0x0041,
			"Fluence Data Source", ValueRepresentation.CodeString);

	public static final DicomTag FluenceMapSeq = new DicomTag(0x3002, 0x0040,
			"Fluence Map Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FluoroscopyFlag = new DicomTag(0x0018, 0x9334,
			"Fluoroscopy Flag", ValueRepresentation.CodeString);

	public static final DicomTag FocalDistance = new DicomTag(0x0018, 0x1182,
			"Focal Distance", ValueRepresentation.IntegerString);

	public static final DicomTag FocalSpot = new DicomTag(0x0018, 0x1190,
			"Focal Spot(s)", ValueRepresentation.DecimalString);

	public static final DicomTag FocusDepth = new DicomTag(0x0018, 0x5012,
			"Focus Depth", ValueRepresentation.DecimalString);

	public static final DicomTag FractionGroupNumber = new DicomTag(0x300a,
			0x0071, "Fraction Group Number", ValueRepresentation.IntegerString);

	public static final DicomTag FractionGroupSeq = new DicomTag(0x300a, 0x0070,
			"Fraction Group Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FractionGroupSummarySeq = new DicomTag(0x3008,
			0x0220, "Fraction Group Summary Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag FractionGroupType = new DicomTag(0x3008, 0x0224,
			"Fraction Group Type", ValueRepresentation.CodeString);

	public static final DicomTag FractionNumber = new DicomTag(0x3002, 0x0029,
			"Fraction Number", ValueRepresentation.IntegerString);

	public static final DicomTag FractionPattern = new DicomTag(0x300a, 0x007b,
			"Fraction Pattern", ValueRepresentation.LongText);

	public static final DicomTag FractionStatusSummarySeq = new DicomTag(0x3008,
			0x0240, "Fraction Status Summary Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag FrameAcquisitionDatetime = new DicomTag(0x0018,
			0x9074, "Frame Acquisition Datetime", ValueRepresentation.DateTime);

	public static final DicomTag FrameAcquisitionDuration = new DicomTag(0x0018,
			0x9220, "Frame Acquisition Duration",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag FrameAcquisitionNumber = new DicomTag(0x0020,
			0x9156, "Frame Acquisition Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag FrameAnatomySeq = new DicomTag(0x0020, 0x9071,
			"Frame Anatomy Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FrameComments = new DicomTag(0x0020, 0x9158,
			"Frame Comments", ValueRepresentation.LongText);

	public static final DicomTag FrameContentSeq = new DicomTag(0x0020, 0x9111,
			"Frame Content Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FrameDelay = new DicomTag(0x0018, 0x1066,
			"Frame Delay", ValueRepresentation.DecimalString);

	public static final DicomTag FrameIncrementPointer = new DicomTag(0x0028,
			0x0009, "Frame Increment Pointer", ValueRepresentation.AttributeTag);

	public static final DicomTag FrameLaterality = new DicomTag(0x0020, 0x9072,
			"Frame Laterality", ValueRepresentation.CodeString);

	public static final DicomTag FrameNumbersOfInterest = new DicomTag(0x0028,
			0x6020, "Frame Numbers of Interest (FOI)",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag FrameOfInterestDescription = new DicomTag(
			0x0028, 0x6022, "Frame(s) of Interest Description",
			ValueRepresentation.LongString);

	public static final DicomTag FrameOfReferenceRelationshipSeq = new DicomTag(
			0x3006, 0x00c0, "Frame of Reference Relationship Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag FrameOfReferenceTransformationComment = new DicomTag(
			0x3006, 0x00c8, "Frame of Reference Transformation Comment",
			ValueRepresentation.LongString);

	public static final DicomTag FrameOfReferenceTransformationMatrix = new DicomTag(
			0x3006, 0x00c6, "Frame of Reference Transformation Matrix",
			ValueRepresentation.DecimalString);

	public static final DicomTag FrameOfReferenceTransformationMatrixType = new DicomTag(
			0x0070, 0x030c, "Frame of Reference Transformation Matrix Type",
			ValueRepresentation.CodeString);

	public static final DicomTag FrameOfReferenceTransformationType = new DicomTag(
			0x3006, 0x00c4, "Frame of Reference Transformation Type",
			ValueRepresentation.CodeString);

	public static final DicomTag FrameOfReferenceUID = new DicomTag(0x0020,
			0x0052, "Frame of Reference UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag FrameReferenceDatetime = new DicomTag(0x0018,
			0x9151, "Frame Reference Datetime", ValueRepresentation.DateTime);

	public static final DicomTag FrameReferenceTime = new DicomTag(0x0054,
			0x1300, "Frame Reference Time", ValueRepresentation.DecimalString);

	public static final DicomTag FrameTime = new DicomTag(0x0018, 0x1063,
			"Frame Time", ValueRepresentation.DecimalString);

	public static final DicomTag FrameTimeVector = new DicomTag(0x0018, 0x1065,
			"Frame Time Vector", ValueRepresentation.DecimalString);

	public static final DicomTag FrameType = new DicomTag(0x0008, 0x9007,
			"Frame Type", ValueRepresentation.CodeString);

	public static final DicomTag FrameVOILUTSeq = new DicomTag(0x0028, 0x9132,
			"Frame VOI LUT Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag FramingType = new DicomTag(0x0018, 0x1064,
			"Framing Type", ValueRepresentation.LongString);

	public static final DicomTag FrequencyCorrection = new DicomTag(0x0018,
			0x9101, "Frequency Correction", ValueRepresentation.CodeString);

	public static final DicomTag FunctionalGroupPointer = new DicomTag(0x0020,
			0x9167, "Functional Group Pointer", ValueRepresentation.AttributeTag);

	public static final DicomTag FunctionalGroupPrivateCreator = new DicomTag(
			0x0020, 0x9238, "Functional Group Private Creator",
			ValueRepresentation.LongString);

	public static final DicomTag GantryAngle = new DicomTag(0x300a, 0x011e,
			"Gantry Angle", ValueRepresentation.DecimalString);

	public static final DicomTag GantryAngleTolerance = new DicomTag(0x300a,
			0x0044, "Gantry Angle Tolerance", ValueRepresentation.DecimalString);

	public static final DicomTag GantryDetectorSlew = new DicomTag(0x0018,
			0x1121, "Gantry/Detector Slew", ValueRepresentation.DecimalString);

	public static final DicomTag GantryDetectorTilt = new DicomTag(0x0018,
			0x1120, "Gantry/Detector Tilt", ValueRepresentation.DecimalString);

	public static final DicomTag GantryRotationDirection = new DicomTag(0x300a,
			0x011f, "Gantry Rotation Direction", ValueRepresentation.CodeString);

	public static final DicomTag GatedInformationSeq = new DicomTag(0x0054,
			0x0062, "Gated Information Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag GeneratorPower = new DicomTag(0x0018, 0x1170,
			"Generator Power", ValueRepresentation.IntegerString);

	public static final DicomTag GeometryOfKSpaceTraversal = new DicomTag(0x0018,
			0x9032, "Geometry of k-Space Traversal", ValueRepresentation.CodeString);

	public static final DicomTag GPPPSStatus = new DicomTag(0x0040, 0x4002,
			"General Purpose Performed Procedure Step Status",
			ValueRepresentation.CodeString);

	public static final DicomTag GPSPSPriority = new DicomTag(0x0040, 0x4003,
			"General Purpose Scheduled Procedure Step Priority",
			ValueRepresentation.CodeString);

	public static final DicomTag GPSPSStatus = new DicomTag(0x0040, 0x4001,
			"General Purpose Scheduled Procedure Step Status",
			ValueRepresentation.CodeString);

	public static final DicomTag GradientEchoTrainLength = new DicomTag(0x0018,
			0x9241, "Gradient Echo Train Length", ValueRepresentation.UnsignedShort);

	public static final DicomTag GradientOutput = new DicomTag(0x0018, 0x9182,
			"Gradient Output", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag GradientOutputType = new DicomTag(0x0018,
			0x9180, "Gradient Output Type", ValueRepresentation.CodeString);

	public static final DicomTag GraphicAnnotationSeq = new DicomTag(0x0070,
			0x0001, "Graphic Annotation Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag GraphicAnnotationUnits = new DicomTag(0x0070,
			0x0005, "Graphic Annotation Units", ValueRepresentation.CodeString);

	public static final DicomTag GraphicCoordinatesDataSeq = new DicomTag(0x0070,
			0x0318, "Graphic Coordinates Data Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag GraphicData = new DicomTag(0x0070, 0x0022,
			"Graphic Data", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag GraphicDimensions = new DicomTag(0x0070, 0x0020,
			"Graphic Dimensions", ValueRepresentation.UnsignedShort);

	public static final DicomTag GraphicFilled = new DicomTag(0x0070, 0x0024,
			"Graphic Filled", ValueRepresentation.CodeString);

	public static final DicomTag GraphicLayer = new DicomTag(0x0070, 0x0002,
			"Graphic Layer", ValueRepresentation.CodeString);

	public static final DicomTag GraphicLayerDescription = new DicomTag(0x0070,
			0x0068, "Graphic Layer Description", ValueRepresentation.LongString);

	public static final DicomTag GraphicLayerOrder = new DicomTag(0x0070, 0x0062,
			"Graphic Layer Order", ValueRepresentation.IntegerString);

	public static final DicomTag GraphicLayerRecommendedDisplayGrayscaleValue = new DicomTag(
			0x0070, 0x0066, "Graphic Layer Recommended Display Grayscale Value",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag GraphicLayerRecommendedDisplayRGBValue = new DicomTag(
			0x0070, 0x0067, "Graphic Layer Recommended Display RGB Value",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag GraphicLayerSeq = new DicomTag(0x0070, 0x0060,
			"Graphic Layer Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag GraphicObjectSeq = new DicomTag(0x0070, 0x0009,
			"Graphic Object Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag GraphicType = new DicomTag(0x0070, 0x0023,
			"Graphic Type", ValueRepresentation.CodeString);

	public static final DicomTag GrayScaleRetired = new DicomTag(0x0028, 0x1080,
			"Gray Scale (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag GreenPaletteColorLUTData = new DicomTag(0x0028,
			0x1202, "Green Palette Color Lookup Table Data",
			ValueRepresentation.OtherWordString);

	public static final DicomTag GreenPaletteColorLUTDescriptor = new DicomTag(
			0x0028, 0x1102, "Green Palette Color Lookup Table Descriptor",
			ValueRepresentation.Unknown);

	public static final DicomTag GreyLUTDescriptorRetired = new DicomTag(0x0028,
			0x1100, "Gray Lookup Table Descriptor (Retired)",
			ValueRepresentation.Unknown);

	public static final DicomTag Grid = new DicomTag(0x0018, 0x1166, "Grid",
			ValueRepresentation.CodeString);

	public static final DicomTag GridAbsorbingMaterial = new DicomTag(0x0018,
			0x7040, "Grid Absorbing Material", ValueRepresentation.LongText);

	public static final DicomTag GridAspectRatio = new DicomTag(0x0018, 0x7046,
			"Grid Aspect Ratio", ValueRepresentation.IntegerString);

	public static final DicomTag GridFocalDistance = new DicomTag(0x0018, 0x704c,
			"Grid Focal Distance", ValueRepresentation.DecimalString);

	public static final DicomTag GridFrameOffsetVector = new DicomTag(0x3004,
			0x000c, "Grid Frame Offset Vector", ValueRepresentation.DecimalString);

	public static final DicomTag GridPeriod = new DicomTag(0x0018, 0x7048,
			"Grid Period", ValueRepresentation.DecimalString);

	public static final DicomTag GridPitch = new DicomTag(0x0018, 0x7044,
			"Grid Pitch", ValueRepresentation.DecimalString);

	public static final DicomTag GridSpacingMaterial = new DicomTag(0x0018,
			0x7041, "Grid Spacing Material", ValueRepresentation.LongText);

	public static final DicomTag GridThickness = new DicomTag(0x0018, 0x7042,
			"Grid Thickness", ValueRepresentation.DecimalString);

	public static final DicomTag HalfValueLayer = new DicomTag(0x0040, 0x0314,
			"Half Value Layer", ValueRepresentation.DecimalString);

	public static final DicomTag HangingProtocolCreationDatetime = new DicomTag(
			0x0072, 0x000a, "Hanging Protocol Creation Datetime",
			ValueRepresentation.DateTime);

	public static final DicomTag HangingProtocolCreator = new DicomTag(0x0072,
			0x0008, "Hanging Protocol Creator", ValueRepresentation.LongString);

	public static final DicomTag HangingProtocolDefinitionSeq = new DicomTag(
			0x0072, 0x000c, "Hanging Protocol Definition Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag HangingProtocolDescription = new DicomTag(
			0x0072, 0x0004, "Hanging Protocol Description",
			ValueRepresentation.LongString);

	public static final DicomTag HangingProtocolLevel = new DicomTag(0x0072,
			0x0006, "Hanging Protocol Level", ValueRepresentation.CodeString);

	public static final DicomTag HangingProtocolName = new DicomTag(0x0072,
			0x0002, "Hanging Protocol Name", ValueRepresentation.ShortString);

	public static final DicomTag HangingProtocolUserGroupName = new DicomTag(
			0x0072, 0x0010, "Hanging Protocol User Group Name",
			ValueRepresentation.LongString);

	public static final DicomTag HangingProtocolUserIdentificationCodeSeq = new DicomTag(
			0x0072, 0x000e, "Hanging Protocol User Identification Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag HardcopyCreationDeviceID = new DicomTag(0x0018,
			0x1011, "Hardcopy Creation Device ID", ValueRepresentation.LongString);

	public static final DicomTag HardcopyDeviceManfuacturerModelName = new DicomTag(
			0x0018, 0x101b, "Hardcopy Device Manfuacturer's Model Name",
			ValueRepresentation.LongString);

	public static final DicomTag HardcopyDeviceManufacturer = new DicomTag(
			0x0018, 0x1017, "Hardcopy Device Manufacturer",
			ValueRepresentation.LongString);

	public static final DicomTag HardcopyDeviceSoftwareVersion = new DicomTag(
			0x0018, 0x101a, "Hardcopy Device Software Version",
			ValueRepresentation.LongString);

	public static final DicomTag HeartRate = new DicomTag(0x0018, 0x1088,
			"Heart Rate", ValueRepresentation.IntegerString);

	public static final DicomTag HighBit = new DicomTag(0x0028, 0x0102,
			"High Bit", ValueRepresentation.UnsignedShort);

	public static final DicomTag HighRRValue = new DicomTag(0x0018, 0x1082,
			"High R-R Value", ValueRepresentation.IntegerString);

	public static final DicomTag HistogramBinWidth = new DicomTag(0x0060, 0x3008,
			"Histogram Bin Width", ValueRepresentation.UnsignedShort);

	public static final DicomTag HistogramData = new DicomTag(0x0060, 0x3020,
			"Histogram Data", ValueRepresentation.UnsignedLong);

	public static final DicomTag HistogramExplanation = new DicomTag(0x0060,
			0x3010, "Histogram Explanation", ValueRepresentation.LongString);

	public static final DicomTag HistogramFirstBinValue = new DicomTag(0x0060,
			0x3004, "Histogram First Bin Value", ValueRepresentation.Unknown);

	public static final DicomTag HistogramLastBinValue = new DicomTag(0x0060,
			0x3006, "Histogram Last Bin Value", ValueRepresentation.Unknown);

	public static final DicomTag HistogramNumberOfBins = new DicomTag(0x0060,
			0x3002, "Histogram Number of Bins", ValueRepresentation.UnsignedShort);

	public static final DicomTag HistogramSeq = new DicomTag(0x0060, 0x3000,
			"Histogram Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag HorizontalFieldOfView = new DicomTag(0x0022,
			0x000c, "Horizontal Field of View",
			ValueRepresentation.FloatingPointSingle);

	public static final DicomTag HumanPerformerCodeSeq = new DicomTag(0x0040,
			0x4009, "Human Performer Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag HumanPerformerName = new DicomTag(0x0040,
			0x4037, "Human Performer's Name", ValueRepresentation.PersonName);

	public static final DicomTag HumanPerformerOrganization = new DicomTag(
			0x0040, 0x4036, "Human Performer's Organization",
			ValueRepresentation.LongString);

	public static final DicomTag IconImageSeq = new DicomTag(0x0088, 0x0200,
			"Icon Image Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag IdenticalDocumentsSeq = new DicomTag(0x0040,
			0xa525, "Identical Documents Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag Illumination = new DicomTag(0x2010, 0x015e,
			"Illumination", ValueRepresentation.UnsignedShort);

	public static final DicomTag IlluminationTypeCodeSeq = new DicomTag(0x0022,
			0x0016, "Illumination Type Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ImageAreaDoseProduct = new DicomTag(0x0018,
			0x115e, "Image Area Dose Product", ValueRepresentation.DecimalString);

	public static final DicomTag ImageBoxContentSeq = new DicomTag(0x2130,
			0x0040, "Image Box Content Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ImageBoxesSeq = new DicomTag(0x0072, 0x0300,
			"Image Boxes Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ImageBoxLargeScrollAmount = new DicomTag(0x0072,
			0x0318, "Image Box Large Scroll Amount",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag ImageBoxLargeScrollType = new DicomTag(0x0072,
			0x0316, "Image Box Large Scroll Type", ValueRepresentation.CodeString);

	public static final DicomTag ImageBoxLayoutType = new DicomTag(0x0072,
			0x0304, "Image Box Layout Type", ValueRepresentation.CodeString);

	public static final DicomTag ImageBoxNumber = new DicomTag(0x0072, 0x0302,
			"Image Box Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag ImageBoxOverlapPriority = new DicomTag(0x0072,
			0x0320, "Image Box Overlap Priority", ValueRepresentation.UnsignedShort);

	public static final DicomTag ImageBoxPresentationLUTFlag = new DicomTag(
			0x2000, 0x006a, "Image Box Presentation LUT Flag",
			ValueRepresentation.CodeString);

	public static final DicomTag ImageBoxScrollDirection = new DicomTag(0x0072,
			0x0310, "Image Box Scroll Direction", ValueRepresentation.CodeString);

	public static final DicomTag ImageBoxSmallScrollAmount = new DicomTag(0x0072,
			0x0314, "Image Box Small Scroll Amount",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag ImageBoxSmallScrollType = new DicomTag(0x0072,
			0x0312, "Image Box Small Scroll Type", ValueRepresentation.CodeString);

	public static final DicomTag ImageBoxTileHorizontalDimension = new DicomTag(
			0x0072, 0x0306, "Image Box Tile Horizontal Dimension",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag ImageBoxTileVerticalDimension = new DicomTag(
			0x0072, 0x0308, "Image Box Tile Vertical Dimension",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag ImageCenterPointCoordinatesSeq = new DicomTag(
			0x0040, 0x071a, "Image Center Point Coordinates Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ImageComments = new DicomTag(0x0020, 0x4000,
			"Image Comments", ValueRepresentation.LongText);

	public static final DicomTag ImageDimensionsRetired = new DicomTag(0x0028,
			0x0005, "Image Dimensions (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag ImageDisplayFormat = new DicomTag(0x2010,
			0x0010, "Image Display Format", ValueRepresentation.ShortText);

	public static final DicomTag ImagedNucleus = new DicomTag(0x0018, 0x0085,
			"Imaged Nucleus", ValueRepresentation.ShortString);

	public static final DicomTag ImageFilter = new DicomTag(0x0018, 0x9320,
			"Image Filter", ValueRepresentation.ShortString);

	public static final DicomTag ImageFormatRetired = new DicomTag(0x0028,
			0x0040, "Image Format (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag ImageGeometryTypeRetired = new DicomTag(0x0020,
			0x0070, "Image Geometry Type (Retired)", ValueRepresentation.CodeString);

	public static final DicomTag ImageHorizontalFlip = new DicomTag(0x0070,
			0x0041, "Image Horizontal Flip", ValueRepresentation.CodeString);

	public static final DicomTag ImageID = new DicomTag(0x0054, 0x0400,
			"Image ID", ValueRepresentation.ShortString);

	public static final DicomTag ImageIndex = new DicomTag(0x0054, 0x1330,
			"Image Index", ValueRepresentation.UnsignedShort);

	public static final DicomTag ImageLaterality = new DicomTag(0x0020, 0x0062,
			"Image Laterality", ValueRepresentation.CodeString);

	public static final DicomTag ImageLocationRetired = new DicomTag(0x0028,
			0x0200, "Image Location (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag ImageOrientation = new DicomTag(0x0020, 0x0037,
			"Image Orientation (Patient)", ValueRepresentation.DecimalString);

	public static final DicomTag ImageOrientationRetired = new DicomTag(0x0020,
			0x0035, "Image Orientation (Retired)", ValueRepresentation.DecimalString);

	public static final DicomTag ImageOverlayBoxContentSeq = new DicomTag(0x2130,
			0x0060, "Image Overlay Box Content Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ImageOverlayFlag = new DicomTag(0x2000, 0x0067,
			"Image Overlay Flag", ValueRepresentation.CodeString);

	public static final DicomTag ImagePathFilterPassBand = new DicomTag(0x0022,
			0x0004, "Image Path Filter Pass Band", ValueRepresentation.UnsignedShort);

	public static final DicomTag ImagePathFilterPassThroughWavelength = new DicomTag(
			0x0022, 0x0003, "Image Path Filter Pass-Through Wavelength",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag ImagePathFilterTypeStackCodeSeq = new DicomTag(
			0x0022, 0x0018, "Image Path Filter Type Stack Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ImagePlanePixelSpacing = new DicomTag(0x3002,
			0x0011, "Image Plane Pixel Spacing", ValueRepresentation.DecimalString);

	public static final DicomTag ImagePosition = new DicomTag(0x0020, 0x0032,
			"Image Position (Patient)", ValueRepresentation.DecimalString);

	public static final DicomTag ImagePositionOnFilm = new DicomTag(0x2020,
			0x0010, "Image Position", ValueRepresentation.UnsignedShort);

	public static final DicomTag ImagePositionRetired = new DicomTag(0x0020,
			0x0030, "Image Position (Retired)", ValueRepresentation.DecimalString);

	public static final DicomTag ImageRotation = new DicomTag(0x0070, 0x0042,
			"Image Rotation", ValueRepresentation.UnsignedShort);

	public static final DicomTag ImagerPixelSpacing = new DicomTag(0x0018,
			0x1164, "Imager Pixel Spacing", ValueRepresentation.DecimalString);

	public static final DicomTag ImageSetLabel = new DicomTag(0x0072, 0x0040,
			"Image Set Label", ValueRepresentation.LongString);

	public static final DicomTag ImageSetNumber = new DicomTag(0x0072, 0x0032,
			"Image Set Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag ImageSetSelectorCategory = new DicomTag(0x0072,
			0x0034, "Image Set Selector Category", ValueRepresentation.CodeString);

	public static final DicomTag ImageSetSelectorSeq = new DicomTag(0x0072,
			0x0022, "Image Set Selector Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ImageSetSelectorUsageFlag = new DicomTag(0x0072,
			0x0024, "Image Set Selector Usage Flag", ValueRepresentation.CodeString);

	public static final DicomTag ImageSetsSeq = new DicomTag(0x0072, 0x0020,
			"Image Sets Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ImagesInAcquisition = new DicomTag(0x0020,
			0x1002, "Images in Acquisition", ValueRepresentation.IntegerString);

	public static final DicomTag ImageTransformationMatrix = new DicomTag(0x0018,
			0x5210, "Image Transformation Matrix", ValueRepresentation.DecimalString);

	public static final DicomTag ImageTranslationVector = new DicomTag(0x0018,
			0x5212, "Image Translation Vector", ValueRepresentation.DecimalString);

	public static final DicomTag ImageTriggerDelay = new DicomTag(0x0018, 0x1067,
			"Image Trigger Delay", ValueRepresentation.DecimalString);

	public static final DicomTag ImageType = new DicomTag(0x0008, 0x0008,
			"Image Type", ValueRepresentation.CodeString);

	public static final DicomTag ImagingDeviceSpecificAcquisitionParameters = new DicomTag(
			0x300a, 0x00cc, "Imaging Device-Specific Acquisition Parameters",
			ValueRepresentation.LongString);

	public static final DicomTag ImagingFrequency = new DicomTag(0x0018, 0x0084,
			"Imaging Frequency", ValueRepresentation.DecimalString);

	public static final DicomTag ImagingServiceRequestComments = new DicomTag(
			0x0040, 0x2400, "Imaging Service Request Comments",
			ValueRepresentation.LongText);

	public static final DicomTag ImplantPresent = new DicomTag(0x0028, 0x1300,
			"Implant Present", ValueRepresentation.CodeString);

	public static final DicomTag ImplementationClassUID = new DicomTag(0x0002,
			0x0012, "Implementation Class UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag ImplementationVersionName = new DicomTag(0x0002,
			0x0013, "Implementation Version Name", ValueRepresentation.ShortString);

	public static final DicomTag Impressions = new DicomTag(0x4008, 0x0300,
			"Impressions", ValueRepresentation.ShortText);

	public static final DicomTag IncludeDisplayApplication = new DicomTag(0x2200,
			0x0009, "Include Display Application", ValueRepresentation.CodeString);

	public static final DicomTag IncludeNonDICOMObjects = new DicomTag(0x2200,
			0x0008, "Include Non-DICOM Objects", ValueRepresentation.CodeString);

	public static final DicomTag InConcatenationNumber = new DicomTag(0x0020,
			0x9162, "In-concatenation Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag InConcatenationTotalNumber = new DicomTag(
			0x0020, 0x9163, "In-concatenation Total Number",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag InitiatorRetired = new DicomTag(0x0000, 0x0200,
			"Initiator (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag InPlanePhaseEncodingDirection = new DicomTag(
			0x0018, 0x1312, "In-plane Phase Encoding Direction",
			ValueRepresentation.CodeString);

	public static final DicomTag InputAvailabilityFlag = new DicomTag(0x0040,
			0x4020, "Input Availability Flag", ValueRepresentation.CodeString);

	public static final DicomTag InputInformationSeq = new DicomTag(0x0040,
			0x4021, "Input Information Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag InStackPositionNumber = new DicomTag(0x0020,
			0x9057, "In-Stack Position Number", ValueRepresentation.UnsignedLong);

	public static final DicomTag InstanceAvailability = new DicomTag(0x0008,
			0x0056, "Instance Availability", ValueRepresentation.CodeString);

	public static final DicomTag InstanceCreationDate = new DicomTag(0x0008,
			0x0012, "Instance Creation Date", ValueRepresentation.Date);

	public static final DicomTag InstanceCreationTime = new DicomTag(0x0008,
			0x0013, "Instance Creation Time", ValueRepresentation.Time);

	public static final DicomTag InstanceCreatorUID = new DicomTag(0x0008,
			0x0014, "Instance Creator UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag InstanceGroupLength = new DicomTag(0x0008,
			0x0000, "Instance Group Length", ValueRepresentation.UnsignedLong);

	public static final DicomTag InstanceNumber = new DicomTag(0x0020, 0x0013,
			"Instance Number", ValueRepresentation.IntegerString);

	public static final DicomTag InstitutionAddress = new DicomTag(0x0008,
			0x0081, "Institution Address", ValueRepresentation.ShortText);

	public static final DicomTag InstitutionalDepartmentName = new DicomTag(
			0x0008, 0x1040, "Institutional Department Name",
			ValueRepresentation.LongString);

	public static final DicomTag InstitutionCodeSeq = new DicomTag(0x0008,
			0x0082, "Institution Code Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag InstitutionName = new DicomTag(0x0008, 0x0080,
			"Institution Name", ValueRepresentation.LongString);

	public static final DicomTag InsurancePlanIdentificationRetired = new DicomTag(
			0x0010, 0x1050, "Insurance Plan Identification (Retired)",
			ValueRepresentation.LongString);

	public static final DicomTag IntendedRecipientsOfResultsIdentificationSeq = new DicomTag(
			0x0040, 0x1011, "Intended Recipients of Results Identification Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag IntensifierSize = new DicomTag(0x0018, 0x1162,
			"Intensifier Size", ValueRepresentation.DecimalString);

	public static final DicomTag InterMarkerDistance = new DicomTag(0x0050,
			0x0019, "Inter-marker Distance", ValueRepresentation.DecimalString);

	public static final DicomTag InterpretationApprovalDate = new DicomTag(
			0x4008, 0x0112, "Interpretation Approval Date", ValueRepresentation.Date);

	public static final DicomTag InterpretationApprovalTime = new DicomTag(
			0x4008, 0x0113, "Interpretation Approval Time", ValueRepresentation.Time);

	public static final DicomTag InterpretationApproverSeq = new DicomTag(0x4008,
			0x0111, "Interpretation Approver Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag InterpretationAuthor = new DicomTag(0x4008,
			0x010c, "Interpretation Author", ValueRepresentation.PersonName);

	public static final DicomTag InterpretationDiagnosisCodeSeq = new DicomTag(
			0x4008, 0x0117, "Interpretation Diagnosis Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag InterpretationDiagnosisDescription = new DicomTag(
			0x4008, 0x0115, "Interpretation Diagnosis Description",
			ValueRepresentation.LongText);

	public static final DicomTag InterpretationID = new DicomTag(0x4008, 0x0200,
			"Interpretation ID", ValueRepresentation.ShortString);

	public static final DicomTag InterpretationIDIssuer = new DicomTag(0x4008,
			0x0202, "Interpretation ID Issuer", ValueRepresentation.LongString);

	public static final DicomTag InterpretationRecordedDate = new DicomTag(
			0x4008, 0x0100, "Interpretation Recorded Date", ValueRepresentation.Date);

	public static final DicomTag InterpretationRecordedTime = new DicomTag(
			0x4008, 0x0101, "Interpretation Recorded Time", ValueRepresentation.Time);

	public static final DicomTag InterpretationRecorder = new DicomTag(0x4008,
			0x0102, "Interpretation Recorder", ValueRepresentation.PersonName);

	public static final DicomTag InterpretationStatusID = new DicomTag(0x4008,
			0x0212, "Interpretation Status ID", ValueRepresentation.CodeString);

	public static final DicomTag InterpretationText = new DicomTag(0x4008,
			0x010b, "Interpretation Text", ValueRepresentation.ShortText);

	public static final DicomTag InterpretationTranscriber = new DicomTag(0x4008,
			0x010a, "Interpretation Transcriber", ValueRepresentation.PersonName);

	public static final DicomTag InterpretationTranscriptionDate = new DicomTag(
			0x4008, 0x0108, "Interpretation Transcription Date",
			ValueRepresentation.Date);

	public static final DicomTag InterpretationTranscriptionTime = new DicomTag(
			0x4008, 0x0109, "Interpretation Transcription Time",
			ValueRepresentation.Time);

	public static final DicomTag InterpretationTypeID = new DicomTag(0x4008,
			0x0210, "Interpretation Type ID", ValueRepresentation.CodeString);

	public static final DicomTag IntervalNumberRetired = new DicomTag(0x0020,
			0x0016, "Interval Number (Retired)", ValueRepresentation.IntegerString);

	public static final DicomTag IntervalsAcquired = new DicomTag(0x0018, 0x1083,
			"Intervals Acquired", ValueRepresentation.IntegerString);

	public static final DicomTag IntervalsRejected = new DicomTag(0x0018, 0x1084,
			"Intervals Rejected", ValueRepresentation.IntegerString);

	public static final DicomTag InterventionalStatus = new DicomTag(0x0018,
			0x0038, "Interventional Status", ValueRepresentation.CodeString);

	public static final DicomTag InterventionalTherapySeq = new DicomTag(0x0018,
			0x0036, "Interventional Therapy Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag InterventionDrugCodeSeq = new DicomTag(0x0018,
			0x0029, "Intervention Drug Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag InterventionDrugDose = new DicomTag(0x0018,
			0x0028, "Intervention Drug Dose", ValueRepresentation.DecimalString);

	public static final DicomTag InterventionDrugInformationSeq = new DicomTag(
			0x0018, 0x0026, "Intervention Drug Information Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag InterventionDrugName = new DicomTag(0x0018,
			0x0034, "Intervention Drug Name", ValueRepresentation.LongString);

	public static final DicomTag InterventionDrugStartTime = new DicomTag(0x0018,
			0x0035, "Intervention Drug Start Time", ValueRepresentation.Time);

	public static final DicomTag InterventionDrugStopTime = new DicomTag(0x0018,
			0x0027, "Intervention Drug Stop Time", ValueRepresentation.Time);

	public static final DicomTag IntraOcularPressure = new DicomTag(0x0022,
			0x000b, "Intra Ocular Pressure", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag InversionRecovery = new DicomTag(0x0018, 0x9009,
			"Inversion Recovery", ValueRepresentation.CodeString);

	public static final DicomTag InversionTime = new DicomTag(0x0018, 0x0082,
			"Inversion Time", ValueRepresentation.DecimalString);

	public static final DicomTag InversionTimes = new DicomTag(0x0018, 0x9079,
			"Inversion Times", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag IsocenterPosition = new DicomTag(0x300a, 0x012c,
			"Isocenter Position", ValueRepresentation.DecimalString);

	public static final DicomTag IsotopeNumberRetired = new DicomTag(0x0020,
			0x0014, "Isotope Number (Retired)", ValueRepresentation.IntegerString);

	public static final DicomTag IssueDateOfImagingServiceRequest = new DicomTag(
			0x0040, 0x2004, "Issue Date of Imaging Service Request",
			ValueRepresentation.Date);

	public static final DicomTag IssuerOfAdmissionID = new DicomTag(0x0038,
			0x0011, "Issuer of Admission ID", ValueRepresentation.LongString);

	public static final DicomTag IssuerOfPatientID = new DicomTag(0x0010, 0x0021,
			"Issuer of Patient ID", ValueRepresentation.LongString);

	public static final DicomTag IssueTimeOfImagingServiceRequest = new DicomTag(
			0x0040, 0x2005, "Issue Time of Imaging Service Request",
			ValueRepresentation.Time);

	public static final DicomTag Item = new DicomTag(0xfffe, 0xe000, "Item",
			ValueRepresentation.Unknown);

	public static final DicomTag ItemDelimitationItem = new DicomTag(0xfffe,
			0xe00d, "Item Delimitation Item", ValueRepresentation.Unknown);

	public static final DicomTag ItemNumber = new DicomTag(0x0020, 0x0019,
			"Item Number", ValueRepresentation.IntegerString);

	public static final DicomTag IVUSGatedRate = new DicomTag(0x0018, 0x3102,
			"IVUS Gated Rate", ValueRepresentation.DecimalString);

	public static final DicomTag IVUSPullbackStopFrameNumber = new DicomTag(
			0x0018, 0x3104, "IVUS Pullback Stop Frame Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag KSpaceFiltering = new DicomTag(0x0018, 0x9064,
			"k-space Filtering", ValueRepresentation.CodeString);

	public static final DicomTag KVP = new DicomTag(0x0018, 0x0060, "KVP",
			ValueRepresentation.DecimalString);

	public static final DicomTag LabelStyleSelection = new DicomTag(0x2200,
			0x0003, "Label Style Selection", ValueRepresentation.CodeString);

	public static final DicomTag LabelText = new DicomTag(0x2200, 0x0002,
			"Label Text", ValueRepresentation.UnlimitedText);

	public static final DicomTag LabelUsingInformationExtractedFromInstances = new DicomTag(
			0x2200, 0x0001, "Label Using Information Extracted From Instances",
			ValueRepresentation.CodeString);

	public static final DicomTag LargestImagePixelValue = new DicomTag(0x0028,
			0x0107, "Largest Image Pixel Value", ValueRepresentation.Unknown);

	public static final DicomTag LargestImagePixelValueInPlane = new DicomTag(
			0x0028, 0x0111, "Largest Image Pixel Value in Plane",
			ValueRepresentation.Unknown);

	public static final DicomTag LargestMonochromePixelValue = new DicomTag(
			0x0028, 0x9099, "Largest Monochrome Pixel Value",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag LargestPixelValueInSeries = new DicomTag(0x0028,
			0x0109, "Largest Pixel Value in Series", ValueRepresentation.Unknown);

	public static final DicomTag LargestValidPixelValueRetired = new DicomTag(
			0x0028, 0x0105, "Largest Valid Pixel Value (Retired)",
			ValueRepresentation.Unknown);

	public static final DicomTag LastMenstrualDate = new DicomTag(0x0010, 0x21d0,
			"Last Menstrual Date", ValueRepresentation.Date);

	public static final DicomTag Laterality = new DicomTag(0x0020, 0x0060,
			"Laterality", ValueRepresentation.CodeString);

	public static final DicomTag LeafJawPositions = new DicomTag(0x300a, 0x011c,
			"Leaf/Jaw Positions", ValueRepresentation.DecimalString);

	public static final DicomTag LeafPositionBoundaries = new DicomTag(0x300a,
			0x00be, "Leaf Position Boundaries", ValueRepresentation.DecimalString);

	public static final DicomTag LeftImageSeq = new DicomTag(0x0022, 0x0021,
			"Left Image Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag LengthToEndRetired = new DicomTag(0x0008,
			0x0001, "Length to End (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag LensesCodeSeq = new DicomTag(0x0022, 0x0019,
			"Lenses Code Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag LesionNumber = new DicomTag(0x0018, 0x3105,
			"Lesion Number", ValueRepresentation.IntegerString);

	public static final DicomTag LightPathFilterPassBand = new DicomTag(0x0022,
			0x0002, "Light Path Filter Pass Band", ValueRepresentation.UnsignedShort);

	public static final DicomTag LightPathFilterPassThroughWavelength = new DicomTag(
			0x0022, 0x0001, "Light Path Filter Pass-Through Wavelength",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag LightPathFilterTypeStackCodeSeq = new DicomTag(
			0x0022, 0x0017, "Light Path Filter Type Stack Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag LocationRetired = new DicomTag(0x0020, 0x0050,
			"Location (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag LossyImageCompression = new DicomTag(0x0028,
			0x2110, "Lossy Image Compression", ValueRepresentation.CodeString);

	public static final DicomTag LossyImageCompressionMethod = new DicomTag(
			0x0028, 0x2114, "Lossy Image Compression Method",
			ValueRepresentation.CodeString);

	public static final DicomTag LossyImageCompressionRatio = new DicomTag(
			0x0028, 0x2112, "Lossy Image Compression Ratio",
			ValueRepresentation.DecimalString);

	public static final DicomTag LossyImageCompressionRetired = new DicomTag(
			0x0008, 0x2110, "Lossy Image Compression (Retired)",
			ValueRepresentation.CodeString);

	public static final DicomTag LowRRValue = new DicomTag(0x0018, 0x1081,
			"Low R-R Value", ValueRepresentation.IntegerString);

	public static final DicomTag LUTData = new DicomTag(0x0028, 0x3006,
			"LUT Data", ValueRepresentation.Unknown);

	public static final DicomTag LUTDescriptor = new DicomTag(0x0028, 0x3002,
			"LUT Descriptor", ValueRepresentation.Unknown);

	public static final DicomTag LUTExplanation = new DicomTag(0x0028, 0x3003,
			"LUT Explanation", ValueRepresentation.LongString);

	public static final DicomTag LUTLabel = new DicomTag(0x0040, 0x9210,
			"LUT Label", ValueRepresentation.ShortString);

	public static final DicomTag LUTNumber = new DicomTag(0x0020, 0x0026,
			"Lookup Table Number", ValueRepresentation.IntegerString);

	public static final DicomTag MagneticFieldStrength = new DicomTag(0x0018,
			0x0087, "Magnetic Field Strength", ValueRepresentation.DecimalString);

	public static final DicomTag MagnetizationTransfer = new DicomTag(0x0018,
			0x9020, "Magnetization Transfer", ValueRepresentation.CodeString);

	public static final DicomTag MagnificationType = new DicomTag(0x2010, 0x0060,
			"Magnification Type", ValueRepresentation.CodeString);

	public static final DicomTag MagnificationTypeRetired = new DicomTag(0x0000,
			0x5180, "Magnification Type (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag MagnifyToNumberOfColumns = new DicomTag(0x2040,
			0x0074, "Magnify to Number of Columns", ValueRepresentation.UnsignedShort);

	public static final DicomTag ManipulatedImageRetired = new DicomTag(0x0028,
			0x0050, "Manipulated Image (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag Manufacturer = new DicomTag(0x0008, 0x0070,
			"Manufacturer", ValueRepresentation.LongString);

	public static final DicomTag ManufacturerModelName = new DicomTag(0x0008,
			0x1090, "Manufacturer's Model Name", ValueRepresentation.LongString);

	public static final DicomTag MappingResource = new DicomTag(0x0008, 0x0105,
			"Mapping Resource", ValueRepresentation.CodeString);

	public static final DicomTag MaskFrameNumbers = new DicomTag(0x0028, 0x6110,
			"Mask Frame Numbers", ValueRepresentation.UnsignedShort);

	public static final DicomTag MaskingImageRetired = new DicomTag(0x0020,
			0x0080, "Masking Image (Retired)", ValueRepresentation.CodeString);

	public static final DicomTag MaskOperation = new DicomTag(0x0028, 0x6101,
			"Mask Operation", ValueRepresentation.CodeString);

	public static final DicomTag MaskOperationExplanation = new DicomTag(0x0028,
			0x6190, "Mask Operation Explanation", ValueRepresentation.ShortText);

	public static final DicomTag MaskPointer = new DicomTag(0x0028, 0x6030,
			"Mask Pointer(s)", ValueRepresentation.UnsignedShort);

	public static final DicomTag MaskSubPixelShift = new DicomTag(0x0028, 0x6114,
			"Mask Sub-pixel Shift", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag MaskSubtractionSeq = new DicomTag(0x0028,
			0x6100, "Mask Subtraction Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MaterialID = new DicomTag(0x300a, 0x00e1,
			"Material ID", ValueRepresentation.ShortString);

	public static final DicomTag MatrixRegistrationSeq = new DicomTag(0x0070,
			0x0309, "Matrix Registration Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MatrixSeq = new DicomTag(0x0070, 0x030a,
			"Matrix Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MaxDensity = new DicomTag(0x2010, 0x0130,
			"Max Density", ValueRepresentation.UnsignedShort);

	public static final DicomTag MaximumCollatedFilms = new DicomTag(0x2010,
			0x0154, "Maximum Collated Films", ValueRepresentation.IntegerString);

	public static final DicomTag MaximumMemoryAllocation = new DicomTag(0x2000,
			0x0061, "Maximum Memory Allocation", ValueRepresentation.IntegerString);

	public static final DicomTag MeasuredDoseDescription = new DicomTag(0x3008,
			0x0012, "Measured Dose Description", ValueRepresentation.ShortText);

	public static final DicomTag MeasuredDoseReferenceNumber = new DicomTag(
			0x3008, 0x0064, "Measured Dose Reference Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag MeasuredDoseReferenceSeq = new DicomTag(0x3008,
			0x0010, "Measured Dose Reference Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MeasuredDoseType = new DicomTag(0x3008, 0x0014,
			"Measured Dose Type", ValueRepresentation.CodeString);

	public static final DicomTag MeasuredDoseValue = new DicomTag(0x3008, 0x0016,
			"Measured Dose Value", ValueRepresentation.DecimalString);

	public static final DicomTag MeasuredValueSeq = new DicomTag(0x0040, 0xa300,
			"Measured Value Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MeasurementUnitsCodeSeq = new DicomTag(0x0040,
			0x08ea, "Measurement Units Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MeasuringUnitsSeq = new DicomTag(0x0040, 0x0295,
			"Measuring Units Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MechanicalIndex = new DicomTag(0x0018, 0x5022,
			"Mechanical Index", ValueRepresentation.DecimalString);

	public static final DicomTag MediaDisposition = new DicomTag(0x2200, 0x0004,
			"Media Disposition", ValueRepresentation.LongText);

	public static final DicomTag MediaInstalledSeq = new DicomTag(0x2000, 0x00a2,
			"Media Installed Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MediaStorageSOPClassUID = new DicomTag(0x0002,
			0x0002, "Media Storage SOP Class UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag MediaStorageSOPInstanceUID = new DicomTag(
			0x0002, 0x0003, "Media Storage SOP Instance UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag MedicalAlerts = new DicomTag(0x0010, 0x2000,
			"Medical Alerts", ValueRepresentation.LongString);

	public static final DicomTag MedicalRecordLocator = new DicomTag(0x0010,
			0x1090, "Medical Record Locator", ValueRepresentation.LongString);

	public static final DicomTag MediumType = new DicomTag(0x2000, 0x0030,
			"Medium Type", ValueRepresentation.CodeString);

	public static final DicomTag MemoryAllocation = new DicomTag(0x2000, 0x0060,
			"Memory Allocation", ValueRepresentation.IntegerString);

	public static final DicomTag MemoryBitDepth = new DicomTag(0x2000, 0x00a0,
			"Memory Bit Depth", ValueRepresentation.UnsignedShort);

	public static final DicomTag MessageID = new DicomTag(0x0000, 0x0110,
			"Message ID", ValueRepresentation.UnsignedShort);

	public static final DicomTag MessageIDBeingRespondedTo = new DicomTag(0x0000,
			0x0120, "Message ID Being Responded To",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag MessageSetIDRetired = new DicomTag(0x0000,
			0x5010, "Message Set ID (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag MetaboliteMapDescription = new DicomTag(0x0018,
			0x9080, "Metabolite Map Description", ValueRepresentation.ShortText);

	public static final DicomTag MetersetExposure = new DicomTag(0x3002, 0x0032,
			"Meterset Exposure", ValueRepresentation.DecimalString);

	public static final DicomTag MidSlabPosition = new DicomTag(0x0018, 0x9106,
			"Mid Slab Position", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag MilitaryRank = new DicomTag(0x0010, 0x1080,
			"Military Rank", ValueRepresentation.LongString);

	public static final DicomTag MIMETypeOfEncapsulatedDocument = new DicomTag(
			0x0042, 0x0012, "MIME Type of Encapsulated Document",
			ValueRepresentation.LongString);

	public static final DicomTag MinDensity = new DicomTag(0x2010, 0x0120,
			"Min Density", ValueRepresentation.UnsignedShort);

	public static final DicomTag ModalitiesInStudy = new DicomTag(0x0008, 0x0061,
			"Modalities in Study", ValueRepresentation.CodeString);

	public static final DicomTag Modality = new DicomTag(0x0008, 0x0060,
			"Modality", ValueRepresentation.CodeString);

	public static final DicomTag ModalityLUTSeq = new DicomTag(0x0028, 0x3000,
			"Modality LUT Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ModalityLUTType = new DicomTag(0x0028, 0x3004,
			"Modality LUT Type", ValueRepresentation.LongString);

	public static final DicomTag ModifiedAttributesSeq = new DicomTag(0x0400,
			0x0550, "Modified Attributes Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ModifiedImageDateRetired = new DicomTag(0x0020,
			0x3403, "Modified Image Date (Retired)", ValueRepresentation.Date);

	public static final DicomTag ModifiedImageDescriptionRetired = new DicomTag(
			0x0020, 0x3406, "Modified Image Description (Retired)",
			ValueRepresentation.LongString);

	public static final DicomTag ModifiedImageIDRetired = new DicomTag(0x0020,
			0x3402, "Modified Image ID (Retired)", ValueRepresentation.ShortString);

	public static final DicomTag ModifiedImageTimeRetired = new DicomTag(0x0020,
			0x3405, "Modified Image Time (Retired)", ValueRepresentation.Time);

	public static final DicomTag ModifierCodeSeq = new DicomTag(0x0040, 0xa195,
			"Modifier Code Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ModifyingDeviceIDRetired = new DicomTag(0x0020,
			0x3401, "Modifying Device ID (Retired)", ValueRepresentation.ShortString);

	public static final DicomTag ModifyingDeviceManufacturerRetired = new DicomTag(
			0x0020, 0x3404, "Modifying Device Manufacturer (Retired)",
			ValueRepresentation.LongString);

	public static final DicomTag MostRecentTreatmentDate = new DicomTag(0x3008,
			0x0056, "Most Recent Treatment Date", ValueRepresentation.Date);

	public static final DicomTag MoveDestination = new DicomTag(0x0000, 0x0600,
			"Move Destination", ValueRepresentation.ApplicationEntity);

	public static final DicomTag MoveOriginatorAET = new DicomTag(0x0000, 0x1030,
			"Move Originator Application Entity Title",
			ValueRepresentation.ApplicationEntity);

	public static final DicomTag MoveOriginatorMessageID = new DicomTag(0x0000,
			0x1031, "Move Originator Message ID", ValueRepresentation.UnsignedShort);

	public static final DicomTag MRAcquisitionFrequencyEncodingSteps = new DicomTag(
			0x0018, 0x9058, "MR Acquisition Frequency Encoding Steps",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag MRAcquisitionPhaseEncodingStepsInPlane = new DicomTag(
			0x0018, 0x9231, "MR Acquisition Phase Encoding Steps in-plane",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag MRAcquisitionPhaseEncodingStepsOutOfPlane = new DicomTag(
			0x0018, 0x9232, "MR Acquisition Phase Encoding Steps out-of-plane",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag MRAcquisitionType = new DicomTag(0x0018, 0x0023,
			"MR Acquisition Type", ValueRepresentation.CodeString);

	public static final DicomTag MRAveragesSeq = new DicomTag(0x0018, 0x9119,
			"MR Averages Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRDiffusionSeq = new DicomTag(0x0018, 0x9117,
			"MR Diffusion Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRDRDirectoryRecordOffset = new DicomTag(0x0004,
			0x1504, "MRDR Directory Record Offset", ValueRepresentation.UnsignedLong);

	public static final DicomTag MREchoSeq = new DicomTag(0x0018, 0x9114,
			"MR Echo Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRFOVGeometrySeq = new DicomTag(0x0018, 0x9125,
			"MR FOV/Geometry Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRImageFrameTypeSeq = new DicomTag(0x0018,
			0x9226, "MR Image Frame Type Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRImagingModifierSeq = new DicomTag(0x0018,
			0x9006, "MR Imaging Modifier Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRMetaboliteMapSeq = new DicomTag(0x0018,
			0x9152, "MR Metabolite Map Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRModifierSeq = new DicomTag(0x0018, 0x9115,
			"MR Modifier Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRReceiveCoilSeq = new DicomTag(0x0018, 0x9042,
			"MR Receive Coil Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRSpatialSaturationSeq = new DicomTag(0x0018,
			0x9107, "MR Spatial Saturation Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRSpectroscopyAcquisitionType = new DicomTag(
			0x0018, 0x9200, "MR Spectroscopy Acquisition Type",
			ValueRepresentation.CodeString);

	public static final DicomTag MRSpectroscopyFOVGeometrySeq = new DicomTag(
			0x0018, 0x9103, "MR Spectroscopy FOV/Geometry Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRSpectroscopyFrameTypeSeq = new DicomTag(
			0x0018, 0x9227, "MR Spectroscopy Frame Type Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRTimingAndRelatedParametersSeq = new DicomTag(
			0x0018, 0x9112, "MR Timing and Related Parameters Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRTransmitCoilSeq = new DicomTag(0x0018, 0x9049,
			"MR Transmit Coil Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag MRVelocityEncodingSeq = new DicomTag(0x0018,
			0x9197, "MR Velocity Encoding Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MultiCoilConfiguration = new DicomTag(0x0018,
			0x9046, "Multi-Coil Configuration", ValueRepresentation.LongString);

	public static final DicomTag MultiCoilDefinitionSeq = new DicomTag(0x0018,
			0x9045, "Multi-Coil Definition Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MultiCoilElementName = new DicomTag(0x0018,
			0x9047, "Multi-Coil Element Name", ValueRepresentation.ShortString);

	public static final DicomTag MultiCoilElementUsed = new DicomTag(0x0018,
			0x9048, "Multi-Coil Element Used", ValueRepresentation.CodeString);

	public static final DicomTag MultiPlanarExcitation = new DicomTag(0x0018,
			0x9012, "Multi-planar Excitation", ValueRepresentation.CodeString);

	public static final DicomTag MultipleCopiesFlag = new DicomTag(0x0040,
			0x4006, "Multiple Copies Flag", ValueRepresentation.CodeString);

	public static final DicomTag MultipleSpinEcho = new DicomTag(0x0018, 0x9011,
			"Multiple Spin Echo", ValueRepresentation.CodeString);

	public static final DicomTag MultiplexedAudioChannelsDescriptionCodeSeq = new DicomTag(
			0x003a, 0x0300, "Multiplexed Audio Channels Description Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag MultiplexGroupLabel = new DicomTag(0x003a,
			0x0020, "Multiplex Group Label", ValueRepresentation.ShortString);

	public static final DicomTag MultiplexGroupTimeOffset = new DicomTag(0x0018,
			0x1068, "Multiplex Group Time Offset", ValueRepresentation.DecimalString);

	public static final DicomTag MydriaticAgentCodeSeq = new DicomTag(0x0022,
			0x001c, "Mydriatic Agent Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag NameOfPhysicianReadingStudy = new DicomTag(
			0x0008, 0x1060, "Name of Physician(s) Reading Study",
			ValueRepresentation.PersonName);

	public static final DicomTag NamesOfIntendedRecipientsOfResults = new DicomTag(
			0x0040, 0x1010, "Names of Intended Recipients of Results",
			ValueRepresentation.PersonName);

	public static final DicomTag NavigationDisplaySet = new DicomTag(0x0072,
			0x0216, "Navigation Display Set", ValueRepresentation.UnsignedShort);

	public static final DicomTag NavigationIndicatorSeq = new DicomTag(0x0072,
			0x0214, "Navigation Indicator Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag NetworkIDRetired = new DicomTag(0x0008, 0x1000,
			"Network ID (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag NominalBeamEnergy = new DicomTag(0x300a, 0x0114,
			"Nominal Beam Energy", ValueRepresentation.DecimalString);

	public static final DicomTag NominalBeamEnergyUnit = new DicomTag(0x300a,
			0x0015, "Nominal Beam Energy Unit", ValueRepresentation.CodeString);

	public static final DicomTag NominalInterval = new DicomTag(0x0018, 0x1062,
			"Nominal Interval", ValueRepresentation.IntegerString);

	public static final DicomTag NominalPriorDose = new DicomTag(0x300a, 0x001a,
			"Nominal Prior Dose", ValueRepresentation.DecimalString);

	public static final DicomTag NominalScreenDefinitionSeq = new DicomTag(
			0x0072, 0x0102, "Nominal Screen Definition Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag NonDICOMOutputCodeSeq = new DicomTag(0x0040,
			0x4032, "Non-DICOM Output Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag NormalizationPoint = new DicomTag(0x3004,
			0x0008, "Normalization Point", ValueRepresentation.DecimalString);

	public static final DicomTag NorRevRetired = new DicomTag(0x0000, 0x5140,
			"Nor/Rev (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag NotchFilterBandwidth = new DicomTag(0x003a,
			0x0223, "Notch Filter Bandwidth", ValueRepresentation.DecimalString);

	public static final DicomTag NotchFilterFrequency = new DicomTag(0x003a,
			0x0222, "Notch Filter Frequency", ValueRepresentation.DecimalString);

	public static final DicomTag NuclearMedicineSeriesTypeRetired = new DicomTag(
			0x0008, 0x0042, "Nuclear Medicine Series Type (Retired)",
			ValueRepresentation.CodeString);

	public static final DicomTag NumberOfAverages = new DicomTag(0x0018, 0x0083,
			"Number of Averages", ValueRepresentation.DecimalString);

	public static final DicomTag NumberOfBeams = new DicomTag(0x300a, 0x0080,
			"Number of Beams", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfBlocks = new DicomTag(0x300a, 0x00f0,
			"Number of Blocks", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfBoli = new DicomTag(0x300a, 0x00ed,
			"Number of Boli", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfBrachyApplicationSetups = new DicomTag(
			0x300a, 0x00a0, "Number of Brachy Application Setups",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfCompensators = new DicomTag(0x300a,
			0x00e0, "Number of Compensators", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfCompletedSubOperations = new DicomTag(
			0x0000, 0x1021, "Number of Completed Sub-operations",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfContourPoints = new DicomTag(0x3006,
			0x0046, "Number of Contour Points", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfControlPoints = new DicomTag(0x300a,
			0x0110, "Number of Control Points", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfCopies = new DicomTag(0x2000, 0x0010,
			"Number of Copies", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfDetectors = new DicomTag(0x0054, 0x0021,
			"Number of Detectors", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfEnergyWindows = new DicomTag(0x0054,
			0x0011, "Number of Energy Windows", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfEventTimers = new DicomTag(0x0008,
			0x2129, "Number of Event Timers", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfFailedSubOperations = new DicomTag(
			0x0000, 0x1022, "Number of Failed Sub-operations",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfFilms = new DicomTag(0x2100, 0x0170,
			"Number of Films", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfFractionsDelivered = new DicomTag(
			0x3008, 0x005a, "Number of Fractions Delivered",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfFractionsPerDay = new DicomTag(0x300a,
			0x0079, "Number of Fractions Per Day", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfFractionsPlanned = new DicomTag(0x300a,
			0x0078, "Number of Fractions Planned", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfFrames = new DicomTag(0x0028, 0x0008,
			"Number of Frames", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfFramesInPhase = new DicomTag(0x0054,
			0x0033, "Number of Frames in Phase", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfFramesInRotation = new DicomTag(0x0054,
			0x0053, "Number of Frames in Rotation", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfGraphicPoints = new DicomTag(0x0070,
			0x0021, "Number of Graphic Points", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfHorizontalPixels = new DicomTag(0x0072,
			0x0106, "Number of Horizontal Pixels", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfKSpaceTrajectories = new DicomTag(
			0x0018, 0x9093, "Number of k-Space Trajectories",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfLeafJawPairs = new DicomTag(0x300a,
			0x00bc, "Number of Leaf/Jaw Pairs", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfMatchesRetired = new DicomTag(0x0000,
			0x0850, "Number of Matches (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag NumberOfPatientRelatedInstances = new DicomTag(
			0x0020, 0x1204, "Number of Patient Related Instances",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfPatientRelatedSeries = new DicomTag(
			0x0020, 0x1202, "Number of Patient Related Series",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfPatientRelatedStudies = new DicomTag(
			0x0020, 0x1200, "Number of Patient Related Studies",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfPhaseEncodingSteps = new DicomTag(
			0x0018, 0x0089, "Number of Phase Encoding Steps",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfPhases = new DicomTag(0x0054, 0x0031,
			"Number of Phases", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfPriorsReferenced = new DicomTag(0x0072,
			0x0014, "Number of Priors Referenced", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfPulses = new DicomTag(0x300a, 0x028a,
			"Number of Pulses", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfReferences = new DicomTag(0x0004,
			0x1600, "Number of References", ValueRepresentation.UnsignedLong);

	public static final DicomTag NumberOfRemainingSubOperations = new DicomTag(
			0x0000, 0x1020, "Number of Remaining Sub-operations",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfRotations = new DicomTag(0x0054, 0x0051,
			"Number of Rotations", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfRRIntervals = new DicomTag(0x0054,
			0x0061, "Number of R-R Intervals", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfScreens = new DicomTag(0x0072, 0x0100,
			"Number of Screens", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfSeriesRelatedInstances = new DicomTag(
			0x0020, 0x1209, "Number of Series Related Instances",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfSlices = new DicomTag(0x0054, 0x0081,
			"Number of Slices", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfStages = new DicomTag(0x0008, 0x2124,
			"Number of Stages", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfStudyRelatedInstances = new DicomTag(
			0x0020, 0x1208, "Number of Study Related Instances",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfStudyRelatedSeries = new DicomTag(
			0x0020, 0x1206, "Number of Study Related Series",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfTableBreakPoints = new DicomTag(0x0018,
			0x6050, "Number of Table Break Points", ValueRepresentation.UnsignedLong);

	public static final DicomTag NumberOfTableEntries = new DicomTag(0x0018,
			0x6056, "Number of Table Entries", ValueRepresentation.UnsignedLong);

	public static final DicomTag NumberOfTemporalPositions = new DicomTag(0x0020,
			0x0105, "Number of Temporal Positions", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfTimeSlices = new DicomTag(0x0054,
			0x0101, "Number of Time Slices", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfTimeSlots = new DicomTag(0x0054, 0x0071,
			"Number of Time Slots", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberofTomosynthesisSourceImages = new DicomTag(
			0x0018, 0x1495, "Number of Tomosynthesis Source Images",
			ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfTriggersInPhase = new DicomTag(0x0054,
			0x0211, "Number of Triggers in Phase", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfVerticalPixels = new DicomTag(0x0072,
			0x0104, "Number of Vertical Pixels", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfViewsInStage = new DicomTag(0x0008,
			0x212a, "Number of Views in Stage", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfWarningSubOperations = new DicomTag(
			0x0000, 0x1023, "Number of Warning Sub-operations",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfWaveformChannels = new DicomTag(0x003a,
			0x0005, "Number of Waveform Channels", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumberOfWaveformSamples = new DicomTag(0x003a,
			0x0010, "Number of Waveform Samples", ValueRepresentation.UnsignedLong);

	public static final DicomTag NumberOfWedges = new DicomTag(0x300a, 0x00d0,
			"Number of Wedges", ValueRepresentation.IntegerString);

	public static final DicomTag NumberOfZeroFills = new DicomTag(0x0018, 0x9066,
			"Number of Zero fills", ValueRepresentation.UnsignedShort);

	public static final DicomTag NumericValue = new DicomTag(0x0040, 0xa30a,
			"Numeric Value", ValueRepresentation.DecimalString);

	public static final DicomTag NumericValueQualifierCodeSeq = new DicomTag(
			0x0040, 0xa301, "Numeric Value Qualifier Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ObservationDateTime = new DicomTag(0x0040,
			0xa032, "Observation DateTime", ValueRepresentation.DateTime);

	public static final DicomTag ObservationNumber = new DicomTag(0x3006, 0x0082,
			"Observation Number", ValueRepresentation.IntegerString);

	public static final DicomTag Occupation = new DicomTag(0x0010, 0x2180,
			"Occupation", ValueRepresentation.ShortString);

	public static final DicomTag OffendingElement = new DicomTag(0x0000, 0x0901,
			"Offending element", ValueRepresentation.AttributeTag);

	public static final DicomTag OffsetOfFirstRootDirectoryRecord = new DicomTag(
			0x0004, 0x1200,
			"Offset of the First Directory Record of the Root Directory Entity",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag OffsetOfLastRootDirectoryRecord = new DicomTag(
			0x0004, 0x1202,
			"Offset of the Last Directory Record of the Root Directory Entity",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag OffsetOfLowerLevelDirectoryEntity = new DicomTag(
			0x0004, 0x1420, "Offset of Referenced Lower-Level Directory Entity",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag OffsetOfNextDirectoryRecord = new DicomTag(
			0x0004, 0x1400, "Offset of the Next Directory Record",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag OperatingMode = new DicomTag(0x0018, 0x9178,
			"Operating Mode", ValueRepresentation.CodeString);

	public static final DicomTag OperatingModeSeq = new DicomTag(0x0018, 0x9176,
			"Operating Mode Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag OperatingModeType = new DicomTag(0x0018, 0x9177,
			"Operating Mode Type", ValueRepresentation.CodeString);

	public static final DicomTag OperatorIdentificationSeq = new DicomTag(0x0008,
			0x1072, "Operator Identification Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag OperatorName = new DicomTag(0x0008, 0x1070,
			"Operator's Name", ValueRepresentation.PersonName);

	public static final DicomTag OrderCallbackPhoneNumber = new DicomTag(0x0040,
			0x2010, "Order Callback Phone Number", ValueRepresentation.ShortString);

	public static final DicomTag OrderEnteredBy = new DicomTag(0x0040, 0x2008,
			"Order Entered By", ValueRepresentation.PersonName);

	public static final DicomTag OrderEntererLocation = new DicomTag(0x0040,
			0x2009, "Order Enterer s Location", ValueRepresentation.ShortString);

	public static final DicomTag OrganAtRiskFullVolumeDose = new DicomTag(0x300a,
			0x002a, "Organ at Risk Full-volume Dose",
			ValueRepresentation.DecimalString);

	public static final DicomTag OrganAtRiskLimitDose = new DicomTag(0x300a,
			0x002b, "Organ at Risk Limit Dose", ValueRepresentation.DecimalString);

	public static final DicomTag OrganAtRiskMaximumDose = new DicomTag(0x300a,
			0x002c, "Organ at Risk Maximum Dose", ValueRepresentation.DecimalString);

	public static final DicomTag OrganAtRiskOverdoseVolumeFraction = new DicomTag(
			0x300a, 0x002d, "Organ at Risk Overdose Volume Fraction",
			ValueRepresentation.DecimalString);

	public static final DicomTag OrganDose = new DicomTag(0x0040, 0x0316,
			"Organ Dose", ValueRepresentation.DecimalString);

	public static final DicomTag OrganExposed = new DicomTag(0x0040, 0x0318,
			"Organ Exposed", ValueRepresentation.CodeString);

	public static final DicomTag OriginalImageIdentificationNomenclatureRetired = new DicomTag(
			0x0020, 0x5002, "Original Image Identification Nomenclature (Retired)",
			ValueRepresentation.LongString);

	public static final DicomTag OriginalImageIdentificationRetired = new DicomTag(
			0x0020, 0x5000, "Original Image Identification (Retired)",
			ValueRepresentation.LongString);

	public static final DicomTag OriginalImageSeq = new DicomTag(0x2130, 0x00c0,
			"Original Image Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag Originator = new DicomTag(0x2100, 0x0070,
			"Originator", ValueRepresentation.ApplicationEntity);

	public static final DicomTag OtherMagnificationTypesAvailable = new DicomTag(
			0x2010, 0x00a7, "Other Magnification Types Available",
			ValueRepresentation.CodeString);

	public static final DicomTag OtherMediaAvailableSeq = new DicomTag(0x2000,
			0x00a4, "Other Media Available Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag OtherPatientIDs = new DicomTag(0x0010, 0x1000,
			"Other Patient IDs", ValueRepresentation.LongString);

	public static final DicomTag OtherPatientNames = new DicomTag(0x0010, 0x1001,
			"Other Patient Names", ValueRepresentation.PersonName);

	public static final DicomTag OtherSmoothingTypesAvailable = new DicomTag(
			0x2010, 0x00a9, "Other Smoothing Types Available",
			ValueRepresentation.CodeString);

	public static final DicomTag OtherStudyNumbers = new DicomTag(0x0020, 0x1070,
			"Other Study Numbers", ValueRepresentation.IntegerString);

	public static final DicomTag OutputInformationSeq = new DicomTag(0x0040,
			0x4033, "Output Information Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag OutputPower = new DicomTag(0x0018, 0x5000,
			"Output Power", ValueRepresentation.ShortString);

	public static final DicomTag OverlayBackgroundDensity = new DicomTag(0x2040,
			0x0082, "Overlay Background Density", ValueRepresentation.CodeString);

	public static final DicomTag OverlayDate = new DicomTag(0x0008, 0x0024,
			"Overlay Date", ValueRepresentation.Date);

	public static final DicomTag OverlayForegroundDensity = new DicomTag(0x2040,
			0x0080, "Overlay Foreground Density", ValueRepresentation.CodeString);

	public static final DicomTag OverlayMagnificationType = new DicomTag(0x2040,
			0x0060, "Overlay Magnification Type", ValueRepresentation.CodeString);

	public static final DicomTag OverlayModeRetired = new DicomTag(0x2040,
			0x0090, "Overlay Mode (Retired)", ValueRepresentation.CodeString);

	public static final DicomTag OverlayNumber = new DicomTag(0x0020, 0x0022,
			"Overlay Number", ValueRepresentation.IntegerString);

	public static final DicomTag OverlayOrImageMagnification = new DicomTag(
			0x2040, 0x0072, "Overlay or Image Magnification",
			ValueRepresentation.CodeString);

	public static final DicomTag OverlayPixelDataSeq = new DicomTag(0x2040,
			0x0020, "Overlay Pixel Data Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag OverlaySmoothingType = new DicomTag(0x2040,
			0x0070, "Overlay Smoothing Type", ValueRepresentation.CodeString);

	public static final DicomTag OverlayTime = new DicomTag(0x0008, 0x0034,
			"Overlay Time", ValueRepresentation.Time);

	public static final DicomTag OverrideParameterPointer = new DicomTag(0x3008,
			0x0062, "Override Parameter Pointer", ValueRepresentation.AttributeTag);

	public static final DicomTag OverrideReason = new DicomTag(0x3008, 0x0066,
			"Override Reason", ValueRepresentation.ShortText);

	public static final DicomTag OverrideSeq = new DicomTag(0x3008, 0x0060,
			"Override Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag OversamplingPhase = new DicomTag(0x0018, 0x9029,
			"Oversampling Phase", ValueRepresentation.CodeString);

	public static final DicomTag OwnerID = new DicomTag(0x2100, 0x0160,
			"Owner ID", ValueRepresentation.ShortString);

	public static final DicomTag PagePositionIDRetired = new DicomTag(0x0000,
			0x5120, "Page Position ID (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag PaletteColorLUTUID = new DicomTag(0x0028,
			0x1199, "Palette Color Lookup Table UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag ParallelAcquisition = new DicomTag(0x0018,
			0x9077, "Parallel Acquisition", ValueRepresentation.CodeString);

	public static final DicomTag ParallelAcquisitionTechnique = new DicomTag(
			0x0018, 0x9078, "Parallel Acquisition Technique",
			ValueRepresentation.CodeString);

	public static final DicomTag ParallelReductionFactorInPlane = new DicomTag(
			0x0018, 0x9069, "Parallel Reduction Factor In-plane",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ParallelReductionFactorOutOfPlane = new DicomTag(
			0x0018, 0x9155, "Parallel Reduction Factor out-of-plane",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ParallelReductionFactorSecondInPlane = new DicomTag(
			0x0018, 0x9168, "Parallel Reduction Factor Second In-plane",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag PartialDataDisplayHandling = new DicomTag(
			0x0072, 0x0208, "Partial Data Display Handling",
			ValueRepresentation.CodeString);

	public static final DicomTag PartialFourier = new DicomTag(0x0018, 0x9081,
			"Partial Fourier", ValueRepresentation.CodeString);

	public static final DicomTag PartialFourierDirection = new DicomTag(0x0018,
			0x9036, "Partial Fourier Direction", ValueRepresentation.CodeString);

	public static final DicomTag PartialView = new DicomTag(0x0028, 0x1350,
			"Partial View", ValueRepresentation.CodeString);

	public static final DicomTag PartialViewDescription = new DicomTag(0x0028,
			0x1351, "Partial View Description", ValueRepresentation.ShortText);

	public static final DicomTag PatientAdditionalPosition = new DicomTag(0x300a,
			0x0184, "Patient Additional Position", ValueRepresentation.LongString);

	public static final DicomTag PatientAddress = new DicomTag(0x0010, 0x1040,
			"Patient's Address", ValueRepresentation.LongString);

	public static final DicomTag PatientAge = new DicomTag(0x0010, 0x1010,
			"Patient's Age", ValueRepresentation.AgeString);

	public static final DicomTag PatientBirthDate = new DicomTag(0x0010, 0x0030,
			"Patient's Birth Date", ValueRepresentation.Date);

	public static final DicomTag PatientBirthName = new DicomTag(0x0010, 0x1005,
			"Patient's Birth Name", ValueRepresentation.PersonName);

	public static final DicomTag PatientBirthTime = new DicomTag(0x0010, 0x0032,
			"Patient's Birth Time", ValueRepresentation.Time);

	public static final DicomTag PatientComments = new DicomTag(0x0010, 0x4000,
			"Patient Comments", ValueRepresentation.LongText);

	public static final DicomTag PatientEyeMovementCommandCodeSeq = new DicomTag(
			0x0022, 0x0006, "Patient Eye Movement Command Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PatientEyeMovementCommanded = new DicomTag(
			0x0022, 0x0005, "Patient Eye Movement Commanded",
			ValueRepresentation.CodeString);

	public static final DicomTag PatientGantryRelationshipCodeSeq = new DicomTag(
			0x0054, 0x0414, "Patient Gantry Relationship Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PatientGroupLength = new DicomTag(0x0010,
			0x0000, "Patient Group Length", ValueRepresentation.UnsignedLong);

	public static final DicomTag PatientID = new DicomTag(0x0010, 0x0020,
			"Patient ID", ValueRepresentation.LongString);

	public static final DicomTag PatientIdentityRemoved = new DicomTag(0x0012,
			0x0062, "Patient Identity Removed", ValueRepresentation.CodeString);

	public static final DicomTag PatientInstitutionResidence = new DicomTag(
			0x0038, 0x0400, "Patient's Institution Residence",
			ValueRepresentation.LongString);

	public static final DicomTag PatientInsurancePlanCodeSeq = new DicomTag(
			0x0010, 0x0050, "Patient's Insurance Plan Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PatientMotherBirthName = new DicomTag(0x0010,
			0x1060, "Patient's Mother's Birth Name", ValueRepresentation.PersonName);

	public static final DicomTag PatientName = new DicomTag(0x0010, 0x0010,
			"Patient's Name", ValueRepresentation.PersonName);

	public static final DicomTag PatientOrientation = new DicomTag(0x0020,
			0x0020, "Patient Orientation", ValueRepresentation.CodeString);

	public static final DicomTag PatientOrientationCodeSeq = new DicomTag(0x0054,
			0x0410, "Patient Orientation Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PatientOrientationModifierCodeSeq = new DicomTag(
			0x0054, 0x0412, "Patient Orientation Modifier Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PatientPhoneNumbers = new DicomTag(0x0010,
			0x2154, "Patient's Telephone Numbers", ValueRepresentation.ShortString);

	public static final DicomTag PatientPosition = new DicomTag(0x0018, 0x5100,
			"Patient Position", ValueRepresentation.CodeString);

	public static final DicomTag PatientReligiousPreference = new DicomTag(
			0x0010, 0x21f0, "Patient's Religious Preference",
			ValueRepresentation.LongString);

	public static final DicomTag PatientSetupNumber = new DicomTag(0x300a,
			0x0182, "Patient Setup Number", ValueRepresentation.IntegerString);

	public static final DicomTag PatientSetupSeq = new DicomTag(0x300a, 0x0180,
			"Patient Setup Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag PatientSex = new DicomTag(0x0010, 0x0040,
			"Patient's Sex", ValueRepresentation.CodeString);

	public static final DicomTag PatientSize = new DicomTag(0x0010, 0x1020,
			"Patient's Size", ValueRepresentation.DecimalString);

	public static final DicomTag PatientState = new DicomTag(0x0038, 0x0500,
			"Patient State", ValueRepresentation.LongString);

	public static final DicomTag PatientSupportAngle = new DicomTag(0x300a,
			0x0122, "Patient Support Angle", ValueRepresentation.DecimalString);

	public static final DicomTag PatientSupportAngleTolerance = new DicomTag(
			0x300a, 0x004c, "Patient Support Angle Tolerance",
			ValueRepresentation.DecimalString);

	public static final DicomTag PatientSupportRotationDirection = new DicomTag(
			0x300a, 0x0123, "Patient Support Rotation Direction",
			ValueRepresentation.CodeString);

	public static final DicomTag PatientTransportArrangements = new DicomTag(
			0x0040, 0x1004, "Patient Transport Arrangements",
			ValueRepresentation.LongString);

	public static final DicomTag PatientWeight = new DicomTag(0x0010, 0x1030,
			"Patient's Weight", ValueRepresentation.DecimalString);

	public static final DicomTag PauseBetweenFrames = new DicomTag(0x0054,
			0x0038, "Pause Between Frames", ValueRepresentation.IntegerString);

	public static final DicomTag PercentPhaseFieldOfView = new DicomTag(0x0018,
			0x0094, "Percent Phase Field of View", ValueRepresentation.DecimalString);

	public static final DicomTag PercentSampling = new DicomTag(0x0018, 0x0093,
			"Percent Sampling", ValueRepresentation.DecimalString);

	public static final DicomTag PerformedLocation = new DicomTag(0x0040, 0x0243,
			"Performed Location", ValueRepresentation.ShortString);

	public static final DicomTag PerformedProcedureCodeSeq = new DicomTag(0x0040,
			0xa372, "Performed Procedure Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformedProcedureStepComments = new DicomTag(
			0x0040, 0x0280, "Comments on the Performed Procedure Steps",
			ValueRepresentation.ShortText);

	public static final DicomTag PerformedProcedureStepDescription = new DicomTag(
			0x0040, 0x0254, "Performed Procedure Step Description",
			ValueRepresentation.LongString);

	public static final DicomTag PerformedProcedureStepDiscontinuationReasonCodeSeq = new DicomTag(
			0x0040, 0x0281,
			"Performed Procedure Step Discontinuation Reason Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformedProcedureStepEndDate = new DicomTag(
			0x0040, 0x0250, "Performed Procedure Step End Date",
			ValueRepresentation.Date);

	public static final DicomTag PerformedProcedureStepEndTime = new DicomTag(
			0x0040, 0x0251, "Performed Procedure Step End Time",
			ValueRepresentation.Time);

	public static final DicomTag PerformedProcedureStepID = new DicomTag(0x0040,
			0x0253, "Performed Procedure Step ID", ValueRepresentation.ShortString);

	public static final DicomTag PerformedProcedureStepStartDate = new DicomTag(
			0x0040, 0x0244, "Performed Procedure Step Start Date",
			ValueRepresentation.Date);

	public static final DicomTag PerformedProcedureStepStartTime = new DicomTag(
			0x0040, 0x0245, "Performed Procedure Step Start Time",
			ValueRepresentation.Time);

	public static final DicomTag PerformedProcedureStepStatus = new DicomTag(
			0x0040, 0x0252, "Performed Procedure Step Status",
			ValueRepresentation.CodeString);

	public static final DicomTag PerformedProcedureTypeDescription = new DicomTag(
			0x0040, 0x0255, "Performed Procedure Type Description",
			ValueRepresentation.LongString);

	public static final DicomTag PerformedProcessingApplicationsCodeSeq = new DicomTag(
			0x0040, 0x4007, "Performed Processing Applications Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformedProtocolCodeSeq = new DicomTag(0x0040,
			0x0260, "Performed Protocol Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformedSeriesSeq = new DicomTag(0x0040,
			0x0340, "Performed Series Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformedStationAET = new DicomTag(0x0040,
			0x0241, "Performed Station AE Title",
			ValueRepresentation.ApplicationEntity);

	public static final DicomTag PerformedStationClassCodeSeq = new DicomTag(
			0x0040, 0x4029, "Performed Station Class Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformedStationGeographicLocationCodeSeq = new DicomTag(
			0x0040, 0x4030, "Performed Station Geographic Location Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformedStationName = new DicomTag(0x0040,
			0x0242, "Performed Station Name", ValueRepresentation.ShortString);

	public static final DicomTag PerformedStationNameCodeSeq = new DicomTag(
			0x0040, 0x4028, "Performed Station Name Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformedWorkitemCodeSeq = new DicomTag(0x0040,
			0x4019, "Performed Workitem Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformingPhysicianIdentificationSeq = new DicomTag(
			0x0008, 0x1052, "Performing Physician Identification Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PerformingPhysicianName = new DicomTag(0x0008,
			0x1050, "Performing Physician's Name", ValueRepresentation.PersonName);

	public static final DicomTag PerFrameFunctionalGroupsSequence = new DicomTag(
			0x5200, 0x9230, "Per-frame Functional Groups Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PersonAddress = new DicomTag(0x0040, 0x1102,
			"Person's Address", ValueRepresentation.ShortText);

	public static final DicomTag PersonIdentificationCodeSeq = new DicomTag(
			0x0040, 0x1101, "Person Identification Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PersonName = new DicomTag(0x0040, 0xa123,
			"Person Name", ValueRepresentation.PersonName);

	public static final DicomTag PersonTelephoneNumbers = new DicomTag(0x0040,
			0x1103, "Person's Telephone Numbers", ValueRepresentation.LongString);

	public static final DicomTag PertinentOtherEvidenceSeq = new DicomTag(0x0040,
			0xa385, "Pertinent Other Evidence Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PhaseContrast = new DicomTag(0x0018, 0x9014,
			"Phase Contrast", ValueRepresentation.CodeString);

	public static final DicomTag PhaseDelay = new DicomTag(0x0054, 0x0036,
			"Phase Delay", ValueRepresentation.IntegerString);

	public static final DicomTag PhaseDescription = new DicomTag(0x0054, 0x0039,
			"Phase Description", ValueRepresentation.CodeString);

	public static final DicomTag PhaseInformationSeq = new DicomTag(0x0054,
			0x0032, "Phase Information Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag PhaseNumberRetired = new DicomTag(0x0020,
			0x0015, "Phase Number (Retired)", ValueRepresentation.IntegerString);

	public static final DicomTag PhaseVector = new DicomTag(0x0054, 0x0030,
			"Phase Vector", ValueRepresentation.UnsignedShort);

	public static final DicomTag PhosphorType = new DicomTag(0x0018, 0x1261,
			"Phosphor Type", ValueRepresentation.LongString);

	public static final DicomTag PhotometricInterpretation = new DicomTag(0x0028,
			0x0004, "Photometric Interpretation", ValueRepresentation.CodeString);

	public static final DicomTag PhototimerSetting = new DicomTag(0x0018, 0x7065,
			"Phototimer Setting", ValueRepresentation.DecimalString);

	public static final DicomTag PhysicalDeltaX = new DicomTag(0x0018, 0x602c,
			"Physical Delta X", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag PhysicalDeltaY = new DicomTag(0x0018, 0x602e,
			"Physical Delta Y", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag PhysicalUnitsXDirection = new DicomTag(0x0018,
			0x6024, "Physical Units X Direction", ValueRepresentation.UnsignedShort);

	public static final DicomTag PhysicalUnitsYDirection = new DicomTag(0x0018,
			0x6026, "Physical Units Y Direction", ValueRepresentation.UnsignedShort);

	public static final DicomTag PhysicianApprovingInterpretation = new DicomTag(
			0x4008, 0x0114, "Physician Approving Interpretation",
			ValueRepresentation.PersonName);

	public static final DicomTag PhysicianOfRecord = new DicomTag(0x0008, 0x1048,
			"Physician(s) of Record", ValueRepresentation.PersonName);

	public static final DicomTag PhysicianOfRecordIdentificationSeq = new DicomTag(
			0x0008, 0x1049, "Physician(s) of Record Identification Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PhysicianReadingStudyIdentificationSeq = new DicomTag(
			0x0008, 0x1062, "Physician(s) Reading Study Identification Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PixelAspectRatio = new DicomTag(0x0028, 0x0034,
			"Pixel Aspect Ratio", ValueRepresentation.IntegerString);

	public static final DicomTag PixelBandwidth = new DicomTag(0x0018, 0x0095,
			"Pixel Bandwidth", ValueRepresentation.DecimalString);

	public static final DicomTag PixelCommentsRetired = new DicomTag(0x0028,
			0x4000, "(Pixel) Comments (Retired)", ValueRepresentation.LongText);

	public static final DicomTag PixelComponentDataType = new DicomTag(0x0018,
			0x604e, "Pixel Component Data Type", ValueRepresentation.UnsignedShort);

	public static final DicomTag PixelComponentMask = new DicomTag(0x0018,
			0x6046, "Pixel Component Mask", ValueRepresentation.UnsignedLong);

	public static final DicomTag PixelComponentOrganization = new DicomTag(
			0x0018, 0x6044, "Pixel Component Organization",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag PixelComponentPhysicalUnits = new DicomTag(
			0x0018, 0x604c, "Pixel Component Physical Units",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag PixelComponentRangeStart = new DicomTag(0x0018,
			0x6048, "Pixel Component Range Start", ValueRepresentation.UnsignedLong);

	public static final DicomTag PixelComponentRangeStop = new DicomTag(0x0018,
			0x604a, "Pixel Component Range Stop", ValueRepresentation.UnsignedLong);

	public static final DicomTag PixelData = new DicomTag(0x7fe0, 0x0010,
			"Pixel Data", ValueRepresentation.Unknown);

	public static final DicomTag PixelIntensityRelationship = new DicomTag(
			0x0028, 0x1040, "Pixel Intensity Relationship",
			ValueRepresentation.CodeString);

	public static final DicomTag PixelIntensityRelationshipSign = new DicomTag(
			0x0028, 0x1041, "Pixel Intensity Relationship Sign",
			ValueRepresentation.SignedShort);

	public static final DicomTag PixelMeasuresSeq = new DicomTag(0x0028, 0x9110,
			"Pixel Measures Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag PixelPaddingValue = new DicomTag(0x0028, 0x0120,
			"Pixel Padding Value", ValueRepresentation.Unknown);

	public static final DicomTag PixelPresentation = new DicomTag(0x0008, 0x9205,
			"Pixel Presentation", ValueRepresentation.CodeString);

	public static final DicomTag PixelRepresentation = new DicomTag(0x0028,
			0x0103, "Pixel Representation", ValueRepresentation.UnsignedShort);

	public static final DicomTag PixelSpacing = new DicomTag(0x0028, 0x0030,
			"Pixel Spacing", ValueRepresentation.DecimalString);

	public static final DicomTag PixelSpacingSeq = new DicomTag(0x0040, 0x08d8,
			"Pixel Spacing Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag PixelValueTransformationSeq = new DicomTag(
			0x0028, 0x9145, "Pixel Value Transformation Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PlacerOrderNumber = new DicomTag(0x0040, 0x2016,
			"Placer Order Number / Imaging Service Request",
			ValueRepresentation.LongString);

	public static final DicomTag PlacerOrderNumberImagingServiceRequestRetired = new DicomTag(
			0x0040, 0x2006, "Placer Order Number / Image Service Request (Retired)",
			ValueRepresentation.ShortString);

	public static final DicomTag PlacerOrderNumberProcedureRetired = new DicomTag(
			0x0040, 0x1006, "Placer Order Number / Procedure (Retired)",
			ValueRepresentation.ShortString);

	public static final DicomTag PlanarConfiguration = new DicomTag(0x0028,
			0x0006, "Planar Configuration", ValueRepresentation.UnsignedShort);

	public static final DicomTag PlaneOrientationSeq = new DicomTag(0x0020,
			0x9116, "Plane Orientation Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag PlanePositionSeq = new DicomTag(0x0020, 0x9113,
			"Plane Position Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag Planes = new DicomTag(0x0028, 0x0012, "Planes",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag PlannedVerificationImageSeq = new DicomTag(
			0x300a, 0x00ca, "Planned Verification Image Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PlateID = new DicomTag(0x0018, 0x1004,
			"Plate ID", ValueRepresentation.LongString);

	public static final DicomTag PlateType = new DicomTag(0x0018, 0x1260,
			"Plate Type", ValueRepresentation.ShortString);

	public static final DicomTag Polarity = new DicomTag(0x2020, 0x0020,
			"Polarity", ValueRepresentation.CodeString);

	public static final DicomTag PositionerMotion = new DicomTag(0x0018, 0x1500,
			"Positioner Motion", ValueRepresentation.CodeString);

	public static final DicomTag PositionerPrimaryAngle = new DicomTag(0x0018,
			0x1510, "Positioner Primary Angle", ValueRepresentation.DecimalString);

	public static final DicomTag PositionerPrimaryAngleIncrement = new DicomTag(
			0x0018, 0x1520, "Positioner Primary Angle Increment",
			ValueRepresentation.DecimalString);

	public static final DicomTag PositionerSecondaryAngle = new DicomTag(0x0018,
			0x1511, "Positioner Secondary Angle", ValueRepresentation.DecimalString);

	public static final DicomTag PositionerSecondaryAngleIncrement = new DicomTag(
			0x0018, 0x1521, "Positioner Secondary Angle Increment",
			ValueRepresentation.DecimalString);

	public static final DicomTag PositionerType = new DicomTag(0x0018, 0x1508,
			"Positioner Type", ValueRepresentation.CodeString);

	public static final DicomTag PositionReferenceIndicator = new DicomTag(
			0x0020, 0x1040, "Position Reference Indicator",
			ValueRepresentation.LongString);

	public static final DicomTag PostprocessingFunction = new DicomTag(0x0018,
			0x5021, "Postprocessing Function", ValueRepresentation.LongString);

	public static final DicomTag PredecessorDocumentsSeq = new DicomTag(0x0040,
			0xa360, "Predecessor Documents Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PreferredPlaybackSequencing = new DicomTag(
			0x0018, 0x1244, "Preferred Playback Sequencing",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag PregnancyStatus = new DicomTag(0x0010, 0x21c0,
			"Pregnancy Status", ValueRepresentation.UnsignedShort);

	public static final DicomTag PreMedication = new DicomTag(0x0040, 0x0012,
			"Pre-Medication", ValueRepresentation.LongString);

	public static final DicomTag PrescriptionDescription = new DicomTag(0x300a,
			0x000e, "Prescription Description", ValueRepresentation.ShortText);

	public static final DicomTag PresentationCreationDate = new DicomTag(0x0070,
			0x0082, "Presentation Creation Date", ValueRepresentation.Date);

	public static final DicomTag PresentationCreationTime = new DicomTag(0x0070,
			0x0083, "Presentation Creation Time", ValueRepresentation.Time);

	public static final DicomTag PresentationCreatorName = new DicomTag(0x0070,
			0x0084, "Presentation Creator's Name", ValueRepresentation.PersonName);

	public static final DicomTag PresentationIntentType = new DicomTag(0x0008,
			0x0068, "Presentation Intent Type", ValueRepresentation.CodeString);

	public static final DicomTag PresentationLUTContentSeq = new DicomTag(0x2130,
			0x0080, "Presentation LUT Content Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PresentationLUTFlag = new DicomTag(0x2000,
			0x0069, "Presentation LUT Flag", ValueRepresentation.CodeString);

	public static final DicomTag PresentationLUTSeq = new DicomTag(0x2050,
			0x0010, "Presentation LUT Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag PresentationLUTShape = new DicomTag(0x2050,
			0x0020, "Presentation LUT Shape", ValueRepresentation.CodeString);

	public static final DicomTag PresentationPixelAspectRatio = new DicomTag(
			0x0070, 0x0102, "Presentation Pixel Aspect Ratio",
			ValueRepresentation.IntegerString);

	public static final DicomTag PresentationPixelMagnificationRatio = new DicomTag(
			0x0070, 0x0103, "Presentation Pixel Magnification Ratio",
			ValueRepresentation.FloatingPointSingle);

	public static final DicomTag PresentationPixelSpacing = new DicomTag(0x0070,
			0x0101, "Presentation Pixel Spacing", ValueRepresentation.DecimalString);

	public static final DicomTag PresentationSizeMode = new DicomTag(0x0070,
			0x0100, "Presentation Size Mode", ValueRepresentation.CodeString);

	public static final DicomTag PreserveCompositeInstancesAfterMediaCreation = new DicomTag(
			0x2200, 0x000a, "Preserve Composite Instances After Media Creation",
			ValueRepresentation.CodeString);

	public static final DicomTag PrimaryAnatomicStructureModifierSeq = new DicomTag(
			0x0008, 0x2230, "Primary Anatomic Structure Modifier Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PrimaryAnatomicStructureSeq = new DicomTag(
			0x0008, 0x2228, "Primary Anatomic Structure Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PrimaryCountsAccumulated = new DicomTag(0x0054,
			0x1310, "Primary (Prompts) Counts Accumulated",
			ValueRepresentation.IntegerString);

	public static final DicomTag PrimaryDosimeterUnit = new DicomTag(0x300a,
			0x00b3, "Primary Dosimeter Unit", ValueRepresentation.CodeString);

	public static final DicomTag PrinterCharacteristicsSeq = new DicomTag(0x2130,
			0x0015, "Printer Characteristics Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PrinterConfigurationSeq = new DicomTag(0x2000,
			0x001e, "Printer Configuration Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PrinterName = new DicomTag(0x2110, 0x0030,
			"Printer Name", ValueRepresentation.LongString);

	public static final DicomTag PrinterPixelSpacing = new DicomTag(0x2010,
			0x0376, "Printer Pixel Spacing", ValueRepresentation.DecimalString);

	public static final DicomTag PrinterResolutionID = new DicomTag(0x2010,
			0x0052, "Printer Resolution ID", ValueRepresentation.CodeString);

	public static final DicomTag PrinterStatus = new DicomTag(0x2110, 0x0010,
			"Printer Status", ValueRepresentation.CodeString);

	public static final DicomTag PrinterStatusInfo = new DicomTag(0x2110, 0x0020,
			"Printer Status Info", ValueRepresentation.CodeString);

	public static final DicomTag PrintingBitDepth = new DicomTag(0x2000, 0x00a1,
			"Printing Bit Depth", ValueRepresentation.UnsignedShort);

	public static final DicomTag PrintJobDescriptionSeq = new DicomTag(0x2120,
			0x0050, "Print Job Description Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PrintJobID = new DicomTag(0x2100, 0x0010,
			"Print Job ID", ValueRepresentation.ShortString);

	public static final DicomTag PrintManagementCapabilitiesSeq = new DicomTag(
			0x2130, 0x0010, "Print Management Capabilities Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PrintPriority = new DicomTag(0x2000, 0x0020,
			"Print Priority", ValueRepresentation.CodeString);

	public static final DicomTag PrintQueueID = new DicomTag(0x2110, 0x0099,
			"Print Queue ID", ValueRepresentation.ShortString);

	public static final DicomTag PrintRetired = new DicomTag(0x0000, 0x51a0,
			"Print (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag Priority = new DicomTag(0x0000, 0x0700,
			"Priority", ValueRepresentation.UnsignedShort);

	public static final DicomTag PrivateInformation = new DicomTag(0x0002,
			0x0102, "Private Information", ValueRepresentation.OtherByteString);

	public static final DicomTag PrivateInformationCreatorUID = new DicomTag(
			0x0002, 0x0100, "Private Information Creator UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag PrivateRecordUID = new DicomTag(0x0004, 0x1432,
			"Private Record UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag ProcedureCodeSeq = new DicomTag(0x0008, 0x1032,
			"Procedure Code Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ProcessingFunction = new DicomTag(0x0018,
			0x5020, "Processing Function", ValueRepresentation.LongString);

	public static final DicomTag ProjectionEponymousNameCodeSeq = new DicomTag(
			0x0018, 0x5104, "Projection Eponymous Name Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ProposedStudySeq = new DicomTag(0x2130, 0x00a0,
			"Proposed Study Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ProtocolContextSeq = new DicomTag(0x0040,
			0x0440, "Protocol Context Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ProtocolName = new DicomTag(0x0018, 0x1030,
			"Protocol Name", ValueRepresentation.LongString);

	public static final DicomTag PseudoColorType = new DicomTag(0x0072, 0x0704,
			"Pseudo-color Type", ValueRepresentation.CodeString);

	public static final DicomTag PulseRepetitionFrequency = new DicomTag(0x0018,
			0x6032, "Pulse Repetition Frequency", ValueRepresentation.UnsignedLong);

	public static final DicomTag PulseRepetitionInterval = new DicomTag(0x300a,
			0x028c, "Pulse Repetition Interval", ValueRepresentation.DecimalString);

	public static final DicomTag PulseSequenceName = new DicomTag(0x0018, 0x9005,
			"Pulse Sequence Name", ValueRepresentation.ShortString);

	public static final DicomTag PupilDilated = new DicomTag(0x0022, 0x000d,
			"Pupil Dilated", ValueRepresentation.CodeString);

	public static final DicomTag PurposeOfReferenceCodeSeq = new DicomTag(0x0040,
			0xa170, "Purpose of Reference Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag PVCRejection = new DicomTag(0x0018, 0x1085,
			"PVC Rejection", ValueRepresentation.LongString);

	public static final DicomTag QuadratureReceiveCoil = new DicomTag(0x0018,
			0x9044, "Quadrature Receive Coil", ValueRepresentation.CodeString);

	public static final DicomTag QualityControlImage = new DicomTag(0x0028,
			0x0300, "Quality Control Image", ValueRepresentation.CodeString);

	public static final DicomTag Quantity = new DicomTag(0x0040, 0x0294,
			"Quantity", ValueRepresentation.DecimalString);

	public static final DicomTag QuantitySeq = new DicomTag(0x0040, 0x0293,
			"Quantity Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag QueryRetrieveLevel = new DicomTag(0x0008,
			0x0052, "Query/Retrieve Level", ValueRepresentation.CodeString);

	public static final DicomTag QueueStatus = new DicomTag(0x2120, 0x0010,
			"Queue Status", ValueRepresentation.CodeString);

	public static final DicomTag RadialPosition = new DicomTag(0x0018, 0x1142,
			"Radial Position", ValueRepresentation.DecimalString);

	public static final DicomTag RadiationMachineName = new DicomTag(0x3002,
			0x0020, "Radiation Machine Name", ValueRepresentation.ShortString);

	public static final DicomTag RadiationMachineSAD = new DicomTag(0x3002,
			0x0022, "Radiation Machine SAD", ValueRepresentation.DecimalString);

	public static final DicomTag RadiationMachineSSD = new DicomTag(0x3002,
			0x0024, "Radiation Machine SSD", ValueRepresentation.DecimalString);

	public static final DicomTag RadiationMode = new DicomTag(0x0018, 0x115a,
			"Radiation Mode", ValueRepresentation.CodeString);

	public static final DicomTag RadiationSetting = new DicomTag(0x0018, 0x1155,
			"Radiation Setting", ValueRepresentation.CodeString);

	public static final DicomTag RadiationType = new DicomTag(0x300a, 0x00c6,
			"Radiation Type", ValueRepresentation.CodeString);

	public static final DicomTag RadionuclideCodeSeq = new DicomTag(0x0054,
			0x0300, "Radionuclide Code Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RadionuclideHalfLife = new DicomTag(0x0018,
			0x1075, "Radionuclide Half Life", ValueRepresentation.DecimalString);

	public static final DicomTag RadionuclidePositronFraction = new DicomTag(
			0x0018, 0x1076, "Radionuclide Positron Fraction",
			ValueRepresentation.DecimalString);

	public static final DicomTag RadionuclideRetired = new DicomTag(0x0018,
			0x0030, "Radionuclide (Retired)", ValueRepresentation.LongString);

	public static final DicomTag RadionuclideTotalDose = new DicomTag(0x0018,
			0x1074, "Radionuclide Total Dose", ValueRepresentation.DecimalString);

	public static final DicomTag Radiopharmaceutical = new DicomTag(0x0018,
			0x0031, "Radiopharmaceutical", ValueRepresentation.LongString);

	public static final DicomTag RadiopharmaceuticalCodeSeq = new DicomTag(
			0x0054, 0x0304, "Radiopharmaceutical Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RadiopharmaceuticalInformationSeq = new DicomTag(
			0x0054, 0x0016, "Radiopharmaceutical Information Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RadiopharmaceuticalRoute = new DicomTag(0x0018,
			0x1070, "Radiopharmaceutical Route", ValueRepresentation.LongString);

	public static final DicomTag RadiopharmaceuticalSpecificActivity = new DicomTag(
			0x0018, 0x1077, "Radiopharmaceutical Specific Activity",
			ValueRepresentation.DecimalString);

	public static final DicomTag RadiopharmaceuticalStartTime = new DicomTag(
			0x0018, 0x1072, "Radiopharmaceutical Start Time",
			ValueRepresentation.Time);

	public static final DicomTag RadiopharmaceuticalStopTime = new DicomTag(
			0x0018, 0x1073, "Radiopharmaceutical Stop Time", ValueRepresentation.Time);

	public static final DicomTag RadiopharmaceuticalVolume = new DicomTag(0x0018,
			0x1071, "Radiopharmaceutical Volume", ValueRepresentation.DecimalString);

	public static final DicomTag RadiusOfCircularCollimator = new DicomTag(
			0x0018, 0x1712, "Radius of Circular Collimator",
			ValueRepresentation.IntegerString);

	public static final DicomTag RadiusOfCircularShutter = new DicomTag(0x0018,
			0x1612, "Radius of Circular Shutter", ValueRepresentation.IntegerString);

	public static final DicomTag RandomsCorrectionMethod = new DicomTag(0x0054,
			0x1100, "Randoms Correction Method", ValueRepresentation.CodeString);

	public static final DicomTag RealWorldValueFirstValueMappedUS = new DicomTag(
			0x0040, 0x9216, "Real World Value First Value Mapped",
			ValueRepresentation.Unknown);

	public static final DicomTag RealWorldValueIntercept = new DicomTag(0x0040,
			0x9224, "Real World Value Intercept",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag RealWorldValueLastValueMappedUS = new DicomTag(
			0x0040, 0x9211, "Real World Value Last Value Mapped",
			ValueRepresentation.Unknown);

	public static final DicomTag RealWorldValueLUTData = new DicomTag(0x0040,
			0x9212, "Real World Value LUT Data",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag RealWorldValueMappingSeq = new DicomTag(0x0040,
			0x9096, "Real World Value Mapping Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RealWorldValueSlope = new DicomTag(0x0040,
			0x9225, "Real World Value Slope", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ReasonforRequestedProcedureCodeSeq = new DicomTag(
			0x0040, 0x100a, "Reason for Requested Procedure Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ReasonforStudy = new DicomTag(0x0032, 0x1030,
			"Reason for Study", ValueRepresentation.LongString);

	public static final DicomTag ReasonForTheImagingServiceRequest = new DicomTag(
			0x0040, 0x2001, "Reason for the Imaging Service Request",
			ValueRepresentation.LongString);

	public static final DicomTag ReasonForTheRequestedProcedure = new DicomTag(
			0x0040, 0x1002, "Reason for the Requested Procedure",
			ValueRepresentation.LongString);

	public static final DicomTag ReceiveCoilManufacturerName = new DicomTag(
			0x0018, 0x9041, "Receive Coil Manufacturer Name",
			ValueRepresentation.LongString);

	public static final DicomTag ReceiveCoilName = new DicomTag(0x0018, 0x1250,
			"Receive Coil Name", ValueRepresentation.ShortString);

	public static final DicomTag ReceiveCoilType = new DicomTag(0x0018, 0x9043,
			"Receive Coil Type", ValueRepresentation.CodeString);

	public static final DicomTag ReceiverRetired = new DicomTag(0x0000, 0x0300,
			"Receiver (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag RecognitionCodeRetired = new DicomTag(0x0008,
			0x0010, "Recognition Code (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag RecommendedDisplayFrameRate = new DicomTag(
			0x0008, 0x2144, "Recommended Display Frame Rate",
			ValueRepresentation.IntegerString);

	public static final DicomTag RecommendedViewingMode = new DicomTag(0x0028,
			0x1090, "Recommended Viewing Mode", ValueRepresentation.CodeString);

	public static final DicomTag ReconstructionAlgorithm = new DicomTag(0x0018,
			0x9315, "Reconstruction Algorithm", ValueRepresentation.CodeString);

	public static final DicomTag ReconstructionAngle = new DicomTag(0x0018,
			0x9319, "Reconstruction Angle", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ReconstructionDiameter = new DicomTag(0x0018,
			0x1100, "Reconstruction Diameter", ValueRepresentation.DecimalString);

	public static final DicomTag ReconstructionFieldOfView = new DicomTag(0x0018,
			0x9317, "Reconstruction Field of View",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ReconstructionMethod = new DicomTag(0x0054,
			0x1103, "Reconstruction Method", ValueRepresentation.LongString);

	public static final DicomTag ReconstructionPixelSpacing = new DicomTag(
			0x0018, 0x9322, "Reconstruction Pixel Spacing",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ReconstructionTargetCenterPatient = new DicomTag(
			0x0018, 0x9318, "Reconstruction Target Center (Patient)",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag RecordedBlockSeq = new DicomTag(0x3008, 0x00d0,
			"Recorded Block Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RecordedBrachyAccessoryDeviceSeq = new DicomTag(
			0x3008, 0x0120, "Recorded Brachy Accessory Device Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RecordedChannelSeq = new DicomTag(0x3008,
			0x0130, "Recorded Channel Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RecordedChannelShieldSeq = new DicomTag(0x3008,
			0x0150, "Recorded Channel Shield Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RecordedCompensatorSeq = new DicomTag(0x3008,
			0x00c0, "Recorded Compensator Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RecordedSourceApplicatorSeq = new DicomTag(
			0x3008, 0x0140, "Recorded Source Applicator Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RecordedSourceSeq = new DicomTag(0x3008, 0x0100,
			"Recorded Source Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RecordedWedgeSeq = new DicomTag(0x3008, 0x00b0,
			"Recorded Wedge Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RecordInUseFlag = new DicomTag(0x0004, 0x1410,
			"Record In-use Flag", ValueRepresentation.UnsignedShort);

	public static final DicomTag RectificationType = new DicomTag(0x0018, 0x1156,
			"Rectification Type", ValueRepresentation.CodeString);

	public static final DicomTag RectilinearPhaseEncodeReordering = new DicomTag(
			0x0018, 0x9034, "Rectilinear Phase Encode Reordering",
			ValueRepresentation.CodeString);

	public static final DicomTag RedPaletteColorLUTData = new DicomTag(0x0028,
			0x1201, "Red Palette Color Lookup Table Data",
			ValueRepresentation.OtherWordString);

	public static final DicomTag RedPaletteColorLUTDescriptor = new DicomTag(
			0x0028, 0x1101, "Red Palette Color Lookup Table Descriptor",
			ValueRepresentation.Unknown);

	public static final DicomTag RefBasicAnnotationBoxSeq = new DicomTag(0x2010,
			0x0520, "Referenced Basic Annotation Box Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefBeamNumber = new DicomTag(0x300c, 0x0006,
			"Referenced Beam Number", ValueRepresentation.IntegerString);

	public static final DicomTag RefBeamSeq = new DicomTag(0x300c, 0x0004,
			"Referenced Beam Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefBlockNumber = new DicomTag(0x300c, 0x00e0,
			"Referenced Block Number", ValueRepresentation.IntegerString);

	public static final DicomTag RefBolusSeq = new DicomTag(0x300c, 0x00b0,
			"Referenced Bolus Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefBrachyAccessoryDeviceNumber = new DicomTag(
			0x3008, 0x0122, "Referenced Brachy Accessory Device Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefBrachyApplicationSetupNumber = new DicomTag(
			0x300c, 0x000c, "Referenced Brachy Application Setup Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefBrachyApplicationSetupSeq = new DicomTag(
			0x300c, 0x000a, "Referenced Brachy Application Setup Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefCalculatedDoseReferenceNumber = new DicomTag(
			0x3008, 0x0092, "Referenced Calculated Dose Reference Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefCalculatedDoseReferenceSeq = new DicomTag(
			0x3008, 0x0090, "Referenced Calculated Dose Reference Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefChannelShieldNumber = new DicomTag(0x3008,
			0x0152, "Referenced Channel Shield Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefCompensatorNumber = new DicomTag(0x300c,
			0x00d0, "Referenced Compensator Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefContentItemIdentifier = new DicomTag(0x0040,
			0xdb73, "Referenced Content Item Identifier",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag RefControlPointIndex = new DicomTag(0x300c,
			0x00f0, "Referenced Control Point Index",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefCurveSeq = new DicomTag(0x0008, 0x1145,
			"Referenced Curve Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefDatetime = new DicomTag(0x0040, 0xa13a,
			"Referenced Datetime", ValueRepresentation.DateTime);

	public static final DicomTag RefDoseReferenceNumber = new DicomTag(0x300c,
			0x0051, "Referenced Dose Reference Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefDoseReferenceSeq = new DicomTag(0x300c,
			0x0050, "Referenced Dose Reference Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefDoseSeq = new DicomTag(0x300c, 0x0080,
			"Referenced Dose Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ReferenceAirKermaRate = new DicomTag(0x300a,
			0x022a, "Reference Air Kerma Rate", ValueRepresentation.DecimalString);

	public static final DicomTag ReferenceDisplaySets = new DicomTag(0x0072,
			0x0218, "Reference Display Sets", ValueRepresentation.UnsignedShort);

	public static final DicomTag ReferencedRelatedGeneralSOPClassUIDInFile = new DicomTag(
			0x0004, 0x151a, "Referenced Related General SOP Class UID in File",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag ReferencedWaveformSeq = new DicomTag(0x0008,
			0x113a, "Referenced Waveform Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ReferenceImageNumber = new DicomTag(0x300a,
			0x00c8, "Reference Image Number", ValueRepresentation.IntegerString);

	public static final DicomTag ReferencePixelPhysicalValueX = new DicomTag(
			0x0018, 0x6028, "Reference Pixel Physical Value X",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ReferencePixelPhysicalValueY = new DicomTag(
			0x0018, 0x602a, "Reference Pixel Physical Value Y",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ReferencePixelX0 = new DicomTag(0x0018, 0x6020,
			"Reference Pixel X0", ValueRepresentation.SignedLong);

	public static final DicomTag ReferencePixelY0 = new DicomTag(0x0018, 0x6022,
			"Reference Pixel Y0", ValueRepresentation.SignedLong);

	public static final DicomTag ReferenceRetired = new DicomTag(0x0020, 0x1020,
			"Reference (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag ReferenceToRecordedSound = new DicomTag(0x4008,
			0x0103, "Reference to Recorded Sound", ValueRepresentation.LongString);

	public static final DicomTag ReferringPhysicianAddress = new DicomTag(0x0008,
			0x0092, "Referring Physician's Address", ValueRepresentation.ShortText);

	public static final DicomTag ReferringPhysicianIdentificationSeq = new DicomTag(
			0x0008, 0x0096, "Referring Physician Identification Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ReferringPhysicianName = new DicomTag(0x0008,
			0x0090, "Referring Physician's Name", ValueRepresentation.PersonName);

	public static final DicomTag ReferringPhysicianPhoneNumbers = new DicomTag(
			0x0008, 0x0094, "Referring Physician's Telephone Numbers",
			ValueRepresentation.ShortString);

	public static final DicomTag RefFileID = new DicomTag(0x0004, 0x1500,
			"Referenced File ID", ValueRepresentation.CodeString);

	public static final DicomTag RefFilmBoxSeq = new DicomTag(0x2000, 0x0500,
			"Referenced Film Box Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefFilmSessionSeq = new DicomTag(0x2010, 0x0500,
			"Referenced Film Session Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefFractionGroupNumber = new DicomTag(0x300c,
			0x0022, "Referenced Fraction Group Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefFractionGroupSeq = new DicomTag(0x300c,
			0x0020, "Referenced Fraction Group Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefFractionNumber = new DicomTag(0x3008, 0x0223,
			"Referenced Fraction Number", ValueRepresentation.IntegerString);

	public static final DicomTag RefFrameNumber = new DicomTag(0x0008, 0x1160,
			"Referenced Frame Number", ValueRepresentation.IntegerString);

	public static final DicomTag RefFrameNumbers = new DicomTag(0x0040, 0xa136,
			"Referenced Frame Numbers", ValueRepresentation.UnsignedShort);

	public static final DicomTag RefFrameOfReferenceSeq = new DicomTag(0x3006,
			0x0010, "Referenced Frame of Reference Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefFrameOfReferenceUID = new DicomTag(0x3006,
			0x0024, "Referenced Frame of Reference UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RefGPSPSSeq = new DicomTag(0x0040, 0x4016,
			"Referenced General Purpose Scheduled Procedure Step Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefGPSPSTransactionUID = new DicomTag(0x0040,
			0x4023,
			"Referenced General Purpose Scheduled Procedure Step Transaction UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RefGrayscalePresentationStateSeq = new DicomTag(
			0x0008, 0x9237, "Referenced Grayscale Presentation State Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefImageBoxSeq = new DicomTag(0x2010, 0x0510,
			"Referenced Image Box Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefImageBoxSeqRetired = new DicomTag(0x2040,
			0x0500, "Referenced Image Box Sequence (Retired)",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefImageEvidenceSeq = new DicomTag(0x0008,
			0x9092, "Referenced Image Evidence Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefImageOverlayBoxSeqRetired = new DicomTag(
			0x2020, 0x0130, "Referenced Image Overlay Box Sequence (Retired)",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefImageSeq = new DicomTag(0x0008, 0x1140,
			"Referenced Image Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefInstanceSeq = new DicomTag(0x0008, 0x114a,
			"Referenced Instance Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefInterpretationSeq = new DicomTag(0x4008,
			0x0050, "Referenced Interpretation Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ReflectedAmbientLight = new DicomTag(0x2010,
			0x0160, "Reflected Ambient Light", ValueRepresentation.UnsignedShort);

	public static final DicomTag RefMeasuredDoseReferenceNumber = new DicomTag(
			0x3008, 0x0082, "Referenced Measured Dose Reference Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefMeasuredDoseReferenceSeq = new DicomTag(
			0x3008, 0x0080, "Referenced Measured Dose Reference Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefNonImageCompositeSOPInstanceSeq = new DicomTag(
			0x0040, 0x0220, "Referenced Non-Image Composite SOP Instance Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ReformattingInterval = new DicomTag(0x0072,
			0x0514, "Reformatting Interval", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag ReformattingOperationInitialViewDirection = new DicomTag(
			0x0072, 0x0516, "Reformatting Operation Initial View Direction",
			ValueRepresentation.CodeString);

	public static final DicomTag ReformattingOperationType = new DicomTag(0x0072,
			0x0510, "Reformatting Operation Type", ValueRepresentation.CodeString);

	public static final DicomTag ReformattingThickness = new DicomTag(0x0072,
			0x0512, "Reformatting Thickness", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag RefOverlayPlaneGroups = new DicomTag(0x2040,
			0x0011, "Referenced Overlay Plane Groups",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag RefOverlayPlaneSeq = new DicomTag(0x2040,
			0x0010, "Referenced Overlay Plane Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefOverlaySeq = new DicomTag(0x0008, 0x1130,
			"Referenced Overlay Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefPatientAliasSeq = new DicomTag(0x0038,
			0x0004, "Referenced Patient Alias Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefPatientSeq = new DicomTag(0x0008, 0x1120,
			"Referenced Patient Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefPatientSetupNumber = new DicomTag(0x300c,
			0x006a, "Referenced Patient Setup Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefPPSSeq = new DicomTag(0x0008, 0x1111,
			"Referenced Performed Procedure Step Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefPresentationLUTSeq = new DicomTag(0x2050,
			0x0500, "Referenced Presentation LUT Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefPrintJobSeq = new DicomTag(0x2100, 0x0500,
			"Referenced Print Job Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefPrintJobSeqInQueue = new DicomTag(0x2120,
			0x0070, "Referenced Print Job Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefProcedureStepSeq = new DicomTag(0x0040,
			0x0330, "Referenced Procedure Step Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefractiveStateSeq = new DicomTag(0x0022,
			0x001b, "Refractive State Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefRawDataSeq = new DicomTag(0x0008, 0x9121,
			"Referenced Raw Data Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefReferenceImageNumber = new DicomTag(0x300c,
			0x0007, "Referenced Reference Image Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefReferenceImageSeq = new DicomTag(0x300c,
			0x0042, "Referenced Reference Image Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefRequestSeq = new DicomTag(0x0040, 0xa370,
			"Referenced Request Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefResultsSeq = new DicomTag(0x0008, 0x1100,
			"Referenced Results Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefROINumber = new DicomTag(0x3006, 0x0084,
			"Referenced ROI Number", ValueRepresentation.IntegerString);

	public static final DicomTag RefRTPlanSeq = new DicomTag(0x300c, 0x0002,
			"Referenced RT Plan Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefSamplePositions = new DicomTag(0x0040,
			0xa132, "Referenced Sample Positions", ValueRepresentation.UnsignedLong);

	public static final DicomTag RefSeriesSeq = new DicomTag(0x0008, 0x1115,
			"Referenced Series Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefSOPClassUID = new DicomTag(0x0008, 0x1150,
			"Referenced SOP Class UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RefSOPClassUIDInFile = new DicomTag(0x0004,
			0x1510, "Referenced SOP Class UID in File",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RefSOPInstanceUID = new DicomTag(0x0008, 0x1155,
			"Referenced SOP Instance UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RefSOPInstanceUIDInFile = new DicomTag(0x0004,
			0x1511, "Referenced SOP Instance UID in File",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RefSOPSeq = new DicomTag(0x0008, 0x1199,
			"Referenced SOP Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefSOPTransferSyntaxUIDInFile = new DicomTag(
			0x0004, 0x1512, "Referenced SOP Transfer Syntax UID in File",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RefSourceApplicatorNumber = new DicomTag(0x3008,
			0x0142, "Referenced Source Applicator Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefSourceNumber = new DicomTag(0x300c, 0x000e,
			"Referenced Source Number", ValueRepresentation.IntegerString);

	public static final DicomTag RefStorageMediaSeq = new DicomTag(0x2200,
			0x000d, "Referenced Storage Media Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefStoredPrintSeq = new DicomTag(0x2000, 0x0510,
			"Referenced Stored Print Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefStructureSetSeq = new DicomTag(0x300c,
			0x0060, "Referenced Structure Set Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefStudySeq = new DicomTag(0x0008, 0x1110,
			"Referenced Study Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefTimeOffsets = new DicomTag(0x0040, 0xa138,
			"Referenced Time Offsets", ValueRepresentation.DecimalString);

	public static final DicomTag RefToleranceTableNumber = new DicomTag(0x300c,
			0x00a0, "Referenced Tolerance Table Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag RefTreatmentRecordSeq = new DicomTag(0x3008,
			0x0030, "Referenced Treatment Record Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefVerificationImageSeq = new DicomTag(0x300c,
			0x0040, "Referenced Verification Image Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefVisitSeq = new DicomTag(0x0008, 0x1125,
			"Referenced Visit Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefVOILUTBoxSeqRetired = new DicomTag(0x2020,
			0x0140, "Referenced VOI LUT Box Sequence (Retired)",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RefWaveformChannels = new DicomTag(0x0040,
			0xa0b0, "Referenced Waveform Channels", ValueRepresentation.UnsignedShort);

	public static final DicomTag RefWedgeNumber = new DicomTag(0x300c, 0x00c0,
			"Referenced Wedge Number", ValueRepresentation.IntegerString);

	public static final DicomTag RegionDataType = new DicomTag(0x0018, 0x6014,
			"Region Data Type", ValueRepresentation.UnsignedShort);

	public static final DicomTag RegionFlags = new DicomTag(0x0018, 0x6016,
			"Region Flags", ValueRepresentation.UnsignedLong);

	public static final DicomTag RegionLocationMaxX1 = new DicomTag(0x0018,
			0x601c, "Region Location Max X1", ValueRepresentation.UnsignedLong);

	public static final DicomTag RegionLocationMaxY1 = new DicomTag(0x0018,
			0x601e, "Region Location Max Y1", ValueRepresentation.UnsignedLong);

	public static final DicomTag RegionLocationMinX0 = new DicomTag(0x0018,
			0x6018, "Region Location Min X0", ValueRepresentation.UnsignedLong);

	public static final DicomTag RegionLocationMinY0 = new DicomTag(0x0018,
			0x601a, "Region Location Min Y0", ValueRepresentation.UnsignedLong);

	public static final DicomTag RegionOfResidence = new DicomTag(0x0010, 0x2152,
			"Region of Residence", ValueRepresentation.LongString);

	public static final DicomTag RegionSpatialFormat = new DicomTag(0x0018,
			0x6012, "Region Spatial Format", ValueRepresentation.UnsignedShort);

	public static final DicomTag RegistrationSeq = new DicomTag(0x0070, 0x0308,
			"Registration Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RegistrationTypeCodeSeq = new DicomTag(0x0070,
			0x030d, "Registration Type Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RelatedFrameOfReferenceUID = new DicomTag(
			0x3006, 0x00c2, "Related Frame of Reference UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RelatedRTROIObservationsSeq = new DicomTag(
			0x3006, 0x00a0, "Related RT ROI Observations Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RelationshipType = new DicomTag(0x0040, 0xa010,
			"Relationship Type", ValueRepresentation.CodeString);

	public static final DicomTag RelativeImagePositionCodeSeq = new DicomTag(
			0x0022, 0x001d, "Relative Image Position Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RelativeTime = new DicomTag(0x0072, 0x0038,
			"Relative Time", ValueRepresentation.UnsignedShort);

	public static final DicomTag RelativeTimeUnits = new DicomTag(0x0072, 0x003a,
			"Relative Time Units", ValueRepresentation.CodeString);

	public static final DicomTag RelativeXRayExposure = new DicomTag(0x0018,
			0x1405, "Relative X-ray Exposure", ValueRepresentation.IntegerString);

	public static final DicomTag RelevantInformationSeq = new DicomTag(0x0040,
			0x4022, "Relevant Information Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RepeatFractionCycleLength = new DicomTag(0x300a,
			0x007a, "Repeat Fraction Cycle Length", ValueRepresentation.IntegerString);

	public static final DicomTag RepetitionTime = new DicomTag(0x0018, 0x0080,
			"Repetition Time", ValueRepresentation.DecimalString);

	public static final DicomTag ReportedValuesOrigin = new DicomTag(0x3002,
			0x000a, "Reported Values Origin", ValueRepresentation.CodeString);

	public static final DicomTag ReportingPriority = new DicomTag(0x0040, 0x1009,
			"Reporting Priority", ValueRepresentation.ShortString);

	public static final DicomTag RepresentativeFrameNumber = new DicomTag(0x0028,
			0x6010, "Representative Frame Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag ReprojectionMethod = new DicomTag(0x0054,
			0x1004, "Reprojection Method", ValueRepresentation.CodeString);

	public static final DicomTag RequestAttributesSeq = new DicomTag(0x0040,
			0x0275, "Request Attributes Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RequestedContrastAgent = new DicomTag(0x0032,
			0x1070, "Requested Contrast Agent", ValueRepresentation.LongString);

	public static final DicomTag RequestedDecimateCropBehavior = new DicomTag(
			0x2020, 0x0040, "Requested Decimate/Crop Behavior",
			ValueRepresentation.CodeString);

	public static final DicomTag RequestedImageSize = new DicomTag(0x2020,
			0x0030, "Requested Image Size", ValueRepresentation.DecimalString);

	public static final DicomTag RequestedImageSizeFlag = new DicomTag(0x2020,
			0x00a0, "Requested Image Size Flag", ValueRepresentation.CodeString);

	public static final DicomTag RequestedMediaApplicationProfile = new DicomTag(
			0x2200, 0x000c, "Requested Media Application Profile",
			ValueRepresentation.LongString);

	public static final DicomTag RequestedProcedureCodeSeq = new DicomTag(0x0032,
			0x1064, "Requested Procedure Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RequestedProcedureComments = new DicomTag(
			0x0040, 0x1400, "Requested Procedure Comments",
			ValueRepresentation.LongText);

	public static final DicomTag RequestedProcedureDescription = new DicomTag(
			0x0032, 0x1060, "Requested Procedure Description",
			ValueRepresentation.LongString);

	public static final DicomTag RequestedProcedureID = new DicomTag(0x0040,
			0x1001, "Requested Procedure ID", ValueRepresentation.ShortString);

	public static final DicomTag RequestedProcedureLocation = new DicomTag(
			0x0040, 0x1005, "Requested Procedure Location",
			ValueRepresentation.LongString);

	public static final DicomTag RequestedProcedurePriority = new DicomTag(
			0x0040, 0x1003, "Requested Procedure Priority",
			ValueRepresentation.ShortString);

	public static final DicomTag RequestedResolutionID = new DicomTag(0x2020,
			0x0050, "Requested Resolution ID", ValueRepresentation.CodeString);

	public static final DicomTag RequestedSOPClassUID = new DicomTag(0x0000,
			0x0003, "Requested SOP Class uid", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RequestedSOPInstanceUID = new DicomTag(0x0000,
			0x1001, "Requested SOP Instance uid",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag RequestedSubsequentWorkitemCodeSeq = new DicomTag(
			0x0040, 0x4031, "Requested Subsequent Workitem Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RequestingPhysician = new DicomTag(0x0032,
			0x1032, "Requesting Physician", ValueRepresentation.PersonName);

	public static final DicomTag RequestingPhysicianIdentificationSeq = new DicomTag(
			0x0032, 0x1031, "Requesting Physician Identification Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RequestingService = new DicomTag(0x0032, 0x1033,
			"Requesting Service", ValueRepresentation.LongString);

	public static final DicomTag RequestPriority = new DicomTag(0x2200, 0x0020,
			"Request Priority", ValueRepresentation.CodeString);

	public static final DicomTag RescaleIntercept = new DicomTag(0x0028, 0x1052,
			"Rescale Intercept", ValueRepresentation.DecimalString);

	public static final DicomTag RescaleSlope = new DicomTag(0x0028, 0x1053,
			"Rescale Slope", ValueRepresentation.DecimalString);

	public static final DicomTag RescaleType = new DicomTag(0x0028, 0x1054,
			"Rescale Type", ValueRepresentation.LongString);

	public static final DicomTag ResidualSyringeCounts = new DicomTag(0x0054,
			0x0017, "Residual Syringe Counts", ValueRepresentation.IntegerString);

	public static final DicomTag ResonantNucleus = new DicomTag(0x0018, 0x9100,
			"Resonant Nucleus", ValueRepresentation.CodeString);

	public static final DicomTag RespiratoryCyclePosition = new DicomTag(0x0018,
			0x9214, "Respiratory Cycle Position", ValueRepresentation.CodeString);

	public static final DicomTag RespiratoryMotionCompensationTechnique = new DicomTag(
			0x0018, 0x9170, "Respiratory Motion Compensation Technique",
			ValueRepresentation.CodeString);

	public static final DicomTag RespiratorySignalSource = new DicomTag(0x0018,
			0x9171, "Respiratory Signal Source", ValueRepresentation.CodeString);

	public static final DicomTag ResponseSequenceNumberRetired = new DicomTag(
			0x0000, 0x0860, "Response Sequence Number (Retired)",
			ValueRepresentation.Unknown);

	public static final DicomTag ResponsibleOrganization = new DicomTag(0x0008,
			0x0116, "Responsible Organization", ValueRepresentation.ShortText);

	public static final DicomTag ResultingGPPPSSeq = new DicomTag(0x0040, 0x4015,
			"Resulting General Purpose Performed Procedure Steps Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ResultsComments = new DicomTag(0x4008, 0x4000,
			"Results Comments", ValueRepresentation.ShortText);

	public static final DicomTag ResultsDistributionListSeq = new DicomTag(
			0x4008, 0x0118, "Results Distribution List Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ResultsID = new DicomTag(0x4008, 0x0040,
			"Results ID", ValueRepresentation.ShortString);

	public static final DicomTag ResultsIDIssuer = new DicomTag(0x4008, 0x0042,
			"Results ID Issuer", ValueRepresentation.LongString);

	public static final DicomTag RetrieveAET = new DicomTag(0x0008, 0x0054,
			"Retrieve AE Title", ValueRepresentation.ApplicationEntity);

	public static final DicomTag ReviewDate = new DicomTag(0x300e, 0x0004,
			"Review Date", ValueRepresentation.Date);

	public static final DicomTag ReviewerName = new DicomTag(0x300e, 0x0008,
			"Reviewer Name", ValueRepresentation.PersonName);

	public static final DicomTag ReviewTime = new DicomTag(0x300e, 0x0005,
			"Review Time", ValueRepresentation.Time);

	public static final DicomTag RevolutionTime = new DicomTag(0x0018, 0x9305,
			"Revolution Time", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag RFEchoTrainLength = new DicomTag(0x0018, 0x9240,
			"RF Echo Train Length", ValueRepresentation.UnsignedShort);

	public static final DicomTag RightImageSeq = new DicomTag(0x0022, 0x0022,
			"Right Image Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ROIContourSeq = new DicomTag(0x3006, 0x0039,
			"ROI Contour Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ROIDescription = new DicomTag(0x3006, 0x0028,
			"ROI Description", ValueRepresentation.ShortText);

	public static final DicomTag ROIDisplayColor = new DicomTag(0x3006, 0x002a,
			"ROI Display Color", ValueRepresentation.IntegerString);

	public static final DicomTag ROIGenerationAlgorithm = new DicomTag(0x3006,
			0x0036, "ROI Generation Algorithm", ValueRepresentation.CodeString);

	public static final DicomTag ROIGenerationDescription = new DicomTag(0x3006,
			0x0038, "ROI Generation Description", ValueRepresentation.LongString);

	public static final DicomTag ROIInterpreter = new DicomTag(0x3006, 0x00a6,
			"ROI Interpreter", ValueRepresentation.PersonName);

	public static final DicomTag ROIName = new DicomTag(0x3006, 0x0026,
			"ROI Name", ValueRepresentation.LongString);

	public static final DicomTag ROINumber = new DicomTag(0x3006, 0x0022,
			"ROI Number", ValueRepresentation.IntegerString);

	public static final DicomTag ROIObservationDescription = new DicomTag(0x3006,
			0x0088, "ROI Observation Description", ValueRepresentation.ShortText);

	public static final DicomTag ROIObservationLabel = new DicomTag(0x3006,
			0x0085, "ROI Observation Label", ValueRepresentation.ShortString);

	public static final DicomTag ROIPhysicalPropertiesSeq = new DicomTag(0x3006,
			0x00b0, "ROI Physical Properties Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ROIPhysicalProperty = new DicomTag(0x3006,
			0x00b2, "ROI Physical Property", ValueRepresentation.CodeString);

	public static final DicomTag ROIPhysicalPropertyValue = new DicomTag(0x3006,
			0x00b4, "ROI Physical Property Value", ValueRepresentation.DecimalString);

	public static final DicomTag ROIVolume = new DicomTag(0x3006, 0x002c,
			"ROI Volume", ValueRepresentation.DecimalString);

	public static final DicomTag RotationDirection = new DicomTag(0x0018, 0x1140,
			"Rotation Direction", ValueRepresentation.CodeString);

	public static final DicomTag RotationInformationSeq = new DicomTag(0x0054,
			0x0052, "Rotation Information Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RotationOffsetRetired = new DicomTag(0x0018,
			0x1146, "Rotation Offset (Retired)", ValueRepresentation.DecimalString);

	public static final DicomTag RotationVector = new DicomTag(0x0054, 0x0050,
			"Rotation Vector", ValueRepresentation.UnsignedShort);

	public static final DicomTag RouteOfAdmissions = new DicomTag(0x0038, 0x0016,
			"Route of Admissions", ValueRepresentation.LongString);

	public static final DicomTag Rows = new DicomTag(0x0028, 0x0010, "Rows",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag RRIntervalVector = new DicomTag(0x0054, 0x0060,
			"R-R Interval Vector", ValueRepresentation.UnsignedShort);

	public static final DicomTag RTBeamLimitingDeviceType = new DicomTag(0x300a,
			0x00b8, "RT Beam Limiting Device Type", ValueRepresentation.CodeString);

	public static final DicomTag RTDoseROISeq = new DicomTag(0x3004, 0x0010,
			"RT Dose ROI Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RTImageDescription = new DicomTag(0x3002,
			0x0004, "RT Image Description", ValueRepresentation.ShortText);

	public static final DicomTag RTImageLabel = new DicomTag(0x3002, 0x0002,
			"RT Image Label", ValueRepresentation.ShortString);

	public static final DicomTag RTImageName = new DicomTag(0x3002, 0x0003,
			"RT Image Name", ValueRepresentation.LongString);

	public static final DicomTag RTImageOrientation = new DicomTag(0x3002,
			0x0010, "RT Image Orientation", ValueRepresentation.DecimalString);

	public static final DicomTag RTImagePlane = new DicomTag(0x3002, 0x000c,
			"RT Image Plane", ValueRepresentation.CodeString);

	public static final DicomTag RTImagePosition = new DicomTag(0x3002, 0x0012,
			"RT Image Position", ValueRepresentation.DecimalString);

	public static final DicomTag RTImageSID = new DicomTag(0x3002, 0x0026,
			"RT Image SID", ValueRepresentation.DecimalString);

	public static final DicomTag RTPlanDate = new DicomTag(0x300a, 0x0006,
			"RT Plan Date", ValueRepresentation.Date);

	public static final DicomTag RTPlanDescription = new DicomTag(0x300a, 0x0004,
			"RT Plan Description", ValueRepresentation.ShortText);

	public static final DicomTag RTPlanGeometry = new DicomTag(0x300a, 0x000c,
			"RT Plan Geometry", ValueRepresentation.CodeString);

	public static final DicomTag RTPlanLabel = new DicomTag(0x300a, 0x0002,
			"RT Plan Label", ValueRepresentation.ShortString);

	public static final DicomTag RTPlanName = new DicomTag(0x300a, 0x0003,
			"RT Plan Name", ValueRepresentation.LongString);

	public static final DicomTag RTPlanRelationship = new DicomTag(0x300a,
			0x0055, "RT Plan Relationship", ValueRepresentation.CodeString);

	public static final DicomTag RTPlanTime = new DicomTag(0x300a, 0x0007,
			"RT Plan Time", ValueRepresentation.Time);

	public static final DicomTag RTRefSeriesSeq = new DicomTag(0x3006, 0x0014,
			"RT Referenced Series Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RTRefStudySeq = new DicomTag(0x3006, 0x0012,
			"RT Referenced Study Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RTRelatedROISeq = new DicomTag(0x3006, 0x0030,
			"RT Related ROI Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag RTROIIdentificationCodeSeq = new DicomTag(
			0x3006, 0x0086, "RT ROI Identification Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RTROIInterpretedType = new DicomTag(0x3006,
			0x00a4, "RT ROI Interpreted Type", ValueRepresentation.CodeString);

	public static final DicomTag RTROIObservationsSeq = new DicomTag(0x3006,
			0x0080, "RT ROI Observations Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag RTROIRelationship = new DicomTag(0x3006, 0x0033,
			"RT ROI Relationship", ValueRepresentation.CodeString);

	public static final DicomTag RWavePointer = new DicomTag(0x0028, 0x6040,
			"R Wave Pointer", ValueRepresentation.UnsignedShort);

	public static final DicomTag RWaveTimeVector = new DicomTag(0x0018, 0x6060,
			"R Wave Time Vector", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag SafePositionExitDate = new DicomTag(0x3008,
			0x0162, "Safe Position Exit Date", ValueRepresentation.Date);

	public static final DicomTag SafePositionExitTime = new DicomTag(0x3008,
			0x0164, "Safe Position Exit Time", ValueRepresentation.Time);

	public static final DicomTag SafePositionReturnDate = new DicomTag(0x3008,
			0x0166, "Safe Position Return Date", ValueRepresentation.Date);

	public static final DicomTag SafePositionReturnTime = new DicomTag(0x3008,
			0x0168, "Safe Position Return Time", ValueRepresentation.Time);

	public static final DicomTag SamplesPerPixel = new DicomTag(0x0028, 0x0002,
			"Samples per Pixel", ValueRepresentation.UnsignedShort);

	public static final DicomTag SamplesPerPixelUsed = new DicomTag(0x0028,
			0x0003, "Samples per Pixel Used", ValueRepresentation.UnsignedShort);

	public static final DicomTag SamplingFrequency = new DicomTag(0x003a, 0x001a,
			"Sampling Frequency", ValueRepresentation.DecimalString);

	public static final DicomTag SAR = new DicomTag(0x0018, 0x1316, "SAR",
			ValueRepresentation.DecimalString);

	public static final DicomTag SaturationRecovery = new DicomTag(0x0018,
			0x9024, "Saturation Recovery", ValueRepresentation.CodeString);

	public static final DicomTag ScanArc = new DicomTag(0x0018, 0x1143,
			"Scan Arc", ValueRepresentation.DecimalString);

	public static final DicomTag ScanLength = new DicomTag(0x0018, 0x1302,
			"Scan Length", ValueRepresentation.IntegerString);

	public static final DicomTag ScanningSeq = new DicomTag(0x0018, 0x0020,
			"Scanning Sequence", ValueRepresentation.CodeString);

	public static final DicomTag ScanOptions = new DicomTag(0x0018, 0x0022,
			"Scan Options", ValueRepresentation.CodeString);

	public static final DicomTag ScanVelocity = new DicomTag(0x0018, 0x1300,
			"Scan Velocity", ValueRepresentation.DecimalString);

	public static final DicomTag ScatterCorrectionMethod = new DicomTag(0x0054,
			0x1105, "Scatter Correction Method", ValueRepresentation.LongString);

	public static final DicomTag ScatterFractionFactor = new DicomTag(0x0054,
			0x1323, "Scatter Fraction Factor", ValueRepresentation.DecimalString);

	public static final DicomTag ScheduledAdmissionDate = new DicomTag(0x0038,
			0x001a, "Scheduled Admission Date", ValueRepresentation.Date);

	public static final DicomTag ScheduledAdmissionTime = new DicomTag(0x0038,
			0x001b, "Scheduled Admission Time", ValueRepresentation.Time);

	public static final DicomTag ScheduledDischargeDate = new DicomTag(0x0038,
			0x001c, "Scheduled Discharge Date", ValueRepresentation.Date);

	public static final DicomTag ScheduledDischargeTime = new DicomTag(0x0038,
			0x001d, "Scheduled Discharge Time", ValueRepresentation.Time);

	public static final DicomTag ScheduledHumanPerformersSeq = new DicomTag(
			0x0040, 0x4034, "Scheduled Human Performers Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScheduledPatientInstitutionResidence = new DicomTag(
			0x0038, 0x001e, "Scheduled Patient Institution Residence",
			ValueRepresentation.LongString);

	public static final DicomTag ScheduledPerformingPhysicianIdentificationSeq = new DicomTag(
			0x0040, 0x000b, "Scheduled Performing Physician Identification Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScheduledPerformingPhysicianName = new DicomTag(
			0x0040, 0x0006, "Scheduled Performing Physician's Name",
			ValueRepresentation.PersonName);

	public static final DicomTag ScheduledProcedureStepDescription = new DicomTag(
			0x0040, 0x0007, "Scheduled Procedure Step Description",
			ValueRepresentation.LongString);

	public static final DicomTag ScheduledProcedureStepEndDate = new DicomTag(
			0x0040, 0x0004, "Scheduled Procedure Step End Date",
			ValueRepresentation.Date);

	public static final DicomTag ScheduledProcedureStepEndTime = new DicomTag(
			0x0040, 0x0005, "Scheduled Procedure Step End Time",
			ValueRepresentation.Time);

	public static final DicomTag ScheduledProcedureStepID = new DicomTag(0x0040,
			0x0009, "Scheduled Procedure Step ID", ValueRepresentation.ShortString);

	public static final DicomTag ScheduledProcedureStepLocation = new DicomTag(
			0x0040, 0x0011, "Scheduled Procedure Step Location",
			ValueRepresentation.ShortString);

	public static final DicomTag ScheduledProcedureStepSequence = new DicomTag(
			0x0040, 0x0100, "Scheduled Procedure Step Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScheduledProcedureStepStartDate = new DicomTag(
			0x0040, 0x0002, "Scheduled Procedure Step Start Date",
			ValueRepresentation.Date);

	public static final DicomTag ScheduledProcedureStepStartTime = new DicomTag(
			0x0040, 0x0003, "Scheduled Procedure Step Start Time",
			ValueRepresentation.Time);

	public static final DicomTag ScheduledProcedureStepStatus = new DicomTag(
			0x0040, 0x0020, "Scheduled Procedure Step Status",
			ValueRepresentation.CodeString);

	public static final DicomTag ScheduledProcessingApplicationsCodeSeq = new DicomTag(
			0x0040, 0x4004, "Scheduled Processing Applications Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScheduledProtocolCodeSeq = new DicomTag(0x0040,
			0x0008, "Scheduled Protocol Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScheduledStationAET = new DicomTag(0x0040,
			0x0001, "Scheduled Station AE Title",
			ValueRepresentation.ApplicationEntity);

	public static final DicomTag ScheduledStationClassCodeSeq = new DicomTag(
			0x0040, 0x4026, "Scheduled Station Class Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScheduledStationGeographicLocationCodeSeq = new DicomTag(
			0x0040, 0x4027, "Scheduled Station Geographic Location Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScheduledStationName = new DicomTag(0x0040,
			0x0010, "Scheduled Station Name", ValueRepresentation.ShortString);

	public static final DicomTag ScheduledStationNameCodeSeq = new DicomTag(
			0x0040, 0x4025, "Scheduled Station Name Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScheduledStepAttributesSeq = new DicomTag(
			0x0040, 0x0270, "Scheduled Step Attributes Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScheduledStudyLocation = new DicomTag(0x0032,
			0x1020, "Scheduled Study Location", ValueRepresentation.LongString);

	public static final DicomTag ScheduledStudyLocationAET = new DicomTag(0x0032,
			0x1021, "Scheduled Study Location AE Title(s)",
			ValueRepresentation.ApplicationEntity);

	public static final DicomTag ScheduledStudyStartDate = new DicomTag(0x0032,
			0x1000, "Scheduled Study Start Date", ValueRepresentation.Date);

	public static final DicomTag ScheduledStudyStartTime = new DicomTag(0x0032,
			0x1001, "Scheduled Study Start Time", ValueRepresentation.Time);

	public static final DicomTag ScheduledStudyStopDate = new DicomTag(0x0032,
			0x1010, "Scheduled Study Stop Date", ValueRepresentation.Date);

	public static final DicomTag ScheduledStudyStopTime = new DicomTag(0x0032,
			0x1011, "Scheduled Study Stop Time", ValueRepresentation.Time);

	public static final DicomTag ScheduledWorkitemCodeSeq = new DicomTag(0x0040,
			0x4018, "Scheduled Workitem Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ScreenMinimumColorBitDepth = new DicomTag(
			0x0072, 0x010c, "Screen Minimum Color Bit Depth",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag ScreenMinimumGrayscaleBitDepth = new DicomTag(
			0x0072, 0x010a, "Screen Minimum Grayscale Bit Depth",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag SecondaryCaptureDeviceID = new DicomTag(0x0018,
			0x1010, "Secondary Capture Device ID", ValueRepresentation.LongString);

	public static final DicomTag SecondaryCaptureDeviceManufacturer = new DicomTag(
			0x0018, 0x1016, "Secondary Capture Device Manufacturer",
			ValueRepresentation.LongString);

	public static final DicomTag SecondaryCaptureDeviceManufacturerModelName = new DicomTag(
			0x0018, 0x1018, "Secondary Capture Device Manufacturer's Model Name",
			ValueRepresentation.LongString);

	public static final DicomTag SecondaryCaptureDeviceSoftwareVersion = new DicomTag(
			0x0018, 0x1019, "Secondary Capture Device Software Version(s)",
			ValueRepresentation.LongString);

	public static final DicomTag SecondaryCountsAccumulated = new DicomTag(
			0x0054, 0x1311, "Secondary Counts Accumulated",
			ValueRepresentation.IntegerString);

	public static final DicomTag SecondaryCountsType = new DicomTag(0x0054,
			0x1220, "Secondary Counts Type", ValueRepresentation.CodeString);

	public static final DicomTag SegmentedBluePaletteColorLUTData = new DicomTag(
			0x0028, 0x1223, "Segmented Blue Palette Color Lookup Table Data",
			ValueRepresentation.OtherWordString);

	public static final DicomTag SegmentedGreenPaletteColorLUTData = new DicomTag(
			0x0028, 0x1222, "Segmented Green Palette Color Lookup Table Data",
			ValueRepresentation.OtherWordString);

	public static final DicomTag SegmentedKSpaceTraversal = new DicomTag(0x0018,
			0x9033, "Segmented k-Space Traversal", ValueRepresentation.CodeString);

	public static final DicomTag SegmentedRedPaletteColorLUTData = new DicomTag(
			0x0028, 0x1221, "Segmented Red Palette Color Lookup Table Data",
			ValueRepresentation.OtherWordString);

	public static final DicomTag SelectorAttribute = new DicomTag(0x0072, 0x0026,
			"Selector Attribute", ValueRepresentation.AttributeTag);

	public static final DicomTag SelectorAttributePrivateCreator = new DicomTag(
			0x0072, 0x0056, "Selector Attribute Private Creator",
			ValueRepresentation.LongString);

	public static final DicomTag SelectorAttributeVR = new DicomTag(0x0072,
			0x0050, "Selector Attribute VR", ValueRepresentation.CodeString);

	public static final DicomTag SelectorATValue = new DicomTag(0x0072, 0x0060,
			"Selector AT Value", ValueRepresentation.AttributeTag);

	public static final DicomTag SelectorCodeSequenceValue = new DicomTag(0x0072,
			0x0080, "Selector Code Sequence Value",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag SelectorCSValue = new DicomTag(0x0072, 0x0062,
			"Selector CS Value", ValueRepresentation.CodeString);

	public static final DicomTag SelectorDSValue = new DicomTag(0x0072, 0x0072,
			"Selector DS Value", ValueRepresentation.DecimalString);

	public static final DicomTag SelectorFDValue = new DicomTag(0x0072, 0x0074,
			"Selector FD Value", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag SelectorFLValue = new DicomTag(0x0072, 0x0076,
			"Selector FL Value", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag SelectorISValue = new DicomTag(0x0072, 0x0064,
			"Selector IS Value", ValueRepresentation.IntegerString);

	public static final DicomTag SelectorLOValue = new DicomTag(0x0072, 0x0066,
			"Selector LO Value", ValueRepresentation.LongString);

	public static final DicomTag SelectorLTValue = new DicomTag(0x0072, 0x0068,
			"Selector LT Value", ValueRepresentation.LongText);

	public static final DicomTag SelectorPNValue = new DicomTag(0x0072, 0x006a,
			"Selector PN Value", ValueRepresentation.PersonName);

	public static final DicomTag SelectorSequencePointer = new DicomTag(0x0072,
			0x0052, "Selector Sequence Pointer", ValueRepresentation.AttributeTag);

	public static final DicomTag SelectorSequencePointerPrivateCreator = new DicomTag(
			0x0072, 0x0054, "Selector Sequence Pointer Private Creator",
			ValueRepresentation.LongString);

	public static final DicomTag SelectorSHValue = new DicomTag(0x0072, 0x006c,
			"Selector SH Value", ValueRepresentation.ShortString);

	public static final DicomTag SelectorSLValue = new DicomTag(0x0072, 0x007c,
			"Selector SL Value", ValueRepresentation.SignedLong);

	public static final DicomTag SelectorSSValue = new DicomTag(0x0072, 0x007e,
			"Selector SS Value", ValueRepresentation.SignedShort);

	public static final DicomTag SelectorSTValue = new DicomTag(0x0072, 0x006e,
			"Selector ST Value", ValueRepresentation.ShortText);

	public static final DicomTag SelectorULValue = new DicomTag(0x0072, 0x0078,
			"Selector UL Value", ValueRepresentation.UnsignedLong);

	public static final DicomTag SelectorUSValue = new DicomTag(0x0072, 0x007a,
			"Selector US Value", ValueRepresentation.UnsignedShort);

	public static final DicomTag SelectorUTValue = new DicomTag(0x0072, 0x0070,
			"Selector UT Value", ValueRepresentation.UnlimitedText);

	public static final DicomTag SelectorValueNumber = new DicomTag(0x0072,
			0x0028, "Selector Value Number", ValueRepresentation.UnsignedShort);

	public static final DicomTag Sensitivity = new DicomTag(0x0018, 0x6000,
			"Sensitivity", ValueRepresentation.DecimalString);

	public static final DicomTag SeqDelimitationItem = new DicomTag(0xfffe,
			0xe0dd, "Seq Delimitation Item", ValueRepresentation.Unknown);

	public static final DicomTag SeqOfUltrasoundRegions = new DicomTag(0x0018,
			0x6011, "Seq of Ultrasound Regions", ValueRepresentation.SequenceOfItems);

	public static final DicomTag SequenceName = new DicomTag(0x0018, 0x0024,
			"Sequence Name", ValueRepresentation.ShortString);

	public static final DicomTag SeqVariant = new DicomTag(0x0018, 0x0021,
			"Seq Variant", ValueRepresentation.CodeString);

	public static final DicomTag SeriesCommentsRetired = new DicomTag(0x0018,
			0x4000, "(Series) Comments (Retired)", ValueRepresentation.LongText);

	public static final DicomTag SeriesDate = new DicomTag(0x0008, 0x0021,
			"Series Date", ValueRepresentation.Date);

	public static final DicomTag SeriesDescription = new DicomTag(0x0008, 0x103e,
			"Series Description", ValueRepresentation.LongString);

	public static final DicomTag SeriesInstanceUID = new DicomTag(0x0020, 0x000e,
			"Series Instance UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag SeriesInStudy = new DicomTag(0x0020, 0x1000,
			"Series in Study", ValueRepresentation.IntegerString);

	public static final DicomTag SeriesNumber = new DicomTag(0x0020, 0x0011,
			"Series Number", ValueRepresentation.IntegerString);

	public static final DicomTag SeriesTime = new DicomTag(0x0008, 0x0031,
			"Series Time", ValueRepresentation.Time);

	public static final DicomTag SeriesType = new DicomTag(0x0054, 0x1000,
			"Series Type", ValueRepresentation.CodeString);

	public static final DicomTag SetupDeviceDescription = new DicomTag(0x300a,
			0x01ba, "Setup Device Description", ValueRepresentation.ShortText);

	public static final DicomTag SetupDeviceLabel = new DicomTag(0x300a, 0x01b8,
			"Setup Device Label", ValueRepresentation.ShortString);

	public static final DicomTag SetupDeviceParameter = new DicomTag(0x300a,
			0x01bc, "Setup Device Parameter", ValueRepresentation.DecimalString);

	public static final DicomTag SetupDeviceSeq = new DicomTag(0x300a, 0x01b4,
			"Setup Device Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag SetupDeviceType = new DicomTag(0x300a, 0x01b6,
			"Setup Device Type", ValueRepresentation.CodeString);

	public static final DicomTag SetupReferenceDescription = new DicomTag(0x300a,
			0x01d0, "Setup Reference Description", ValueRepresentation.ShortText);

	public static final DicomTag SetupTechnique = new DicomTag(0x300a, 0x01b0,
			"Setup Technique", ValueRepresentation.CodeString);

	public static final DicomTag SetupTechniqueDescription = new DicomTag(0x300a,
			0x01b2, "Setup Technique Description", ValueRepresentation.ShortText);

	public static final DicomTag ShapeType = new DicomTag(0x0070, 0x0306,
			"Shape Type", ValueRepresentation.CodeString);

	public static final DicomTag SharedFunctionalGroupsSequence = new DicomTag(
			0x5200, 0x9229, "Shared Functional Groups Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ShieldingDeviceDescription = new DicomTag(
			0x300a, 0x01a6, "Shielding Device Description",
			ValueRepresentation.ShortText);

	public static final DicomTag ShieldingDeviceLabel = new DicomTag(0x300a,
			0x01a4, "Shielding Device Label", ValueRepresentation.ShortString);

	public static final DicomTag ShieldingDevicePosition = new DicomTag(0x300a,
			0x01a8, "Shielding Device Position", ValueRepresentation.ShortString);

	public static final DicomTag ShieldingDeviceSeq = new DicomTag(0x300a,
			0x01a0, "Shielding Device Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ShieldingDeviceType = new DicomTag(0x300a,
			0x01a2, "Shielding Device Type", ValueRepresentation.CodeString);

	public static final DicomTag ShowAcquisitionTechniquesFlag = new DicomTag(
			0x0072, 0x0716, "Show Acquisition Techniques Flag",
			ValueRepresentation.CodeString);

	public static final DicomTag ShowGraphicAnnotationFlag = new DicomTag(0x0072,
			0x0712, "Show Graphic Annotation Flag", ValueRepresentation.CodeString);

	public static final DicomTag ShowGrayscaleInverted = new DicomTag(0x0072,
			0x0706, "Show Grayscale Inverted", ValueRepresentation.CodeString);

	public static final DicomTag ShowImageTrueSizeFlag = new DicomTag(0x0072,
			0x0710, "Show Image True Size Flag", ValueRepresentation.CodeString);

	public static final DicomTag ShowPatientDemographicsFlag = new DicomTag(
			0x0072, 0x0714, "Show Patient Demographics Flag",
			ValueRepresentation.CodeString);

	public static final DicomTag ShutterLeftVerticalEdge = new DicomTag(0x0018,
			0x1602, "Shutter Left Vertical Edge", ValueRepresentation.IntegerString);

	public static final DicomTag ShutterLowerHorizontalEdge = new DicomTag(
			0x0018, 0x1608, "Shutter Lower Horizontal Edge",
			ValueRepresentation.IntegerString);

	public static final DicomTag ShutterOverlayGroup = new DicomTag(0x0018,
			0x1623, "Shutter Overlay Group", ValueRepresentation.UnsignedShort);

	public static final DicomTag ShutterPresentationValue = new DicomTag(0x0018,
			0x1622, "Shutter Presentation Value", ValueRepresentation.UnsignedShort);

	public static final DicomTag ShutterRightVerticalEdge = new DicomTag(0x0018,
			0x1604, "Shutter Right Vertical Edge", ValueRepresentation.IntegerString);

	public static final DicomTag ShutterShape = new DicomTag(0x0018, 0x1600,
			"Shutter Shape", ValueRepresentation.CodeString);

	public static final DicomTag ShutterUpperHorizontalEdge = new DicomTag(
			0x0018, 0x1606, "Shutter Upper Horizontal Edge",
			ValueRepresentation.IntegerString);

	public static final DicomTag SignalDomain = new DicomTag(0x0028, 0x9003,
			"Signal Domain Columns", ValueRepresentation.CodeString);

	public static final DicomTag SignalDomainRows = new DicomTag(0x0028, 0x9235,
			"Signal Domain Rows", ValueRepresentation.CodeString);

	public static final DicomTag SingleCollimationWidth = new DicomTag(0x0018,
			0x9306, "Single Collimation Width",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag SkipBeats = new DicomTag(0x0018, 0x1086,
			"Skip Beats", ValueRepresentation.IntegerString);

	public static final DicomTag SlabOrientation = new DicomTag(0x0018, 0x9105,
			"Slab Orientation", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag SlabThickness = new DicomTag(0x0018, 0x9104,
			"Slab Thickness", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag SliceLocation = new DicomTag(0x0020, 0x1041,
			"Slice Location", ValueRepresentation.DecimalString);

	public static final DicomTag SliceProgressionDirection = new DicomTag(0x0054,
			0x0500, "Slice Progression Direction", ValueRepresentation.CodeString);

	public static final DicomTag SliceSensitivityFactor = new DicomTag(0x0054,
			0x1320, "Slice Sensitivity Factor", ValueRepresentation.DecimalString);

	public static final DicomTag SliceThickness = new DicomTag(0x0018, 0x0050,
			"Slice Thickness", ValueRepresentation.DecimalString);

	public static final DicomTag SliceVector = new DicomTag(0x0054, 0x0080,
			"Slice Vector", ValueRepresentation.UnsignedShort);

	public static final DicomTag SlideIdentifier = new DicomTag(0x0040, 0x06fa,
			"Slide Identifier", ValueRepresentation.LongString);

	public static final DicomTag SmallestImagePixelValue = new DicomTag(0x0028,
			0x0106, "Smallest Image Pixel Value", ValueRepresentation.Unknown);

	public static final DicomTag SmallestImagePixelValueInPlane = new DicomTag(
			0x0028, 0x0110, "Smallest Image Pixel Value in Plane",
			ValueRepresentation.Unknown);

	public static final DicomTag SmallestPixelValueInSeries = new DicomTag(
			0x0028, 0x0108, "Smallest Pixel Value in Series",
			ValueRepresentation.Unknown);

	public static final DicomTag SmallestValidPixelValueRetired = new DicomTag(
			0x0028, 0x0104, "Smallest Valid Pixel Value (Retired)",
			ValueRepresentation.Unknown);

	public static final DicomTag SmokingStatus = new DicomTag(0x0010, 0x21a0,
			"Smoking Status", ValueRepresentation.CodeString);

	public static final DicomTag SmoothingType = new DicomTag(0x2010, 0x0080,
			"Smoothing Type", ValueRepresentation.CodeString);

	public static final DicomTag SoftcopyVOILUTSeq = new DicomTag(0x0028, 0x3110,
			"Softcopy VOI LUT Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag SoftTissueFocusThermalIndex = new DicomTag(
			0x0018, 0x5028, "Soft Tissue-focus Thermal Index",
			ValueRepresentation.DecimalString);

	public static final DicomTag SoftTissueSurfaceThermalIndex = new DicomTag(
			0x0018, 0x5029, "Soft Tissue-surface Thermal Index",
			ValueRepresentation.DecimalString);

	public static final DicomTag SoftTissueThermalIndex = new DicomTag(0x0018,
			0x5027, "Soft Tissue Thermal Index", ValueRepresentation.DecimalString);

	public static final DicomTag SoftwareVersion = new DicomTag(0x0018, 0x1020,
			"Software Version(s)", ValueRepresentation.LongString);

	public static final DicomTag SOPAuthorizationComment = new DicomTag(0x0100,
			0x0424, "SOP Authorization Comment", ValueRepresentation.LongText);

	public static final DicomTag SOPAuthorizationDateAndTime = new DicomTag(
			0x0100, 0x0420, "SOP Authorization Date and Time",
			ValueRepresentation.DateTime);

	public static final DicomTag SOPClassesSupported = new DicomTag(0x0008,
			0x115a, "SOP Classes Supported", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag SOPClassUID = new DicomTag(0x0008, 0x0016,
			"SOP Class UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag SOPInstanceStatus = new DicomTag(0x0100, 0x0410,
			"SOP Instance Status", ValueRepresentation.CodeString);

	public static final DicomTag SOPInstanceUID = new DicomTag(0x0008, 0x0018,
			"SOP Instance UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag SortByCategory = new DicomTag(0x0072, 0x0602,
			"Sort-by Category", ValueRepresentation.CodeString);

	public static final DicomTag SortingDirection = new DicomTag(0x0072, 0x0604,
			"Sorting Direction", ValueRepresentation.CodeString);

	public static final DicomTag SortingOperationsSeq = new DicomTag(0x0072,
			0x0600, "Sorting Operations Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag SourceApplicationEntityTitle = new DicomTag(
			0x0002, 0x0016, "Source Application Entity Title",
			ValueRepresentation.ApplicationEntity);

	public static final DicomTag SourceApplicatorID = new DicomTag(0x300a,
			0x0291, "Source Applicator ID", ValueRepresentation.ShortString);

	public static final DicomTag SourceApplicatorLength = new DicomTag(0x300a,
			0x0296, "Source Applicator Length", ValueRepresentation.DecimalString);

	public static final DicomTag SourceApplicatorManufacturer = new DicomTag(
			0x300a, 0x0298, "Source Applicator Manufacturer",
			ValueRepresentation.LongString);

	public static final DicomTag SourceApplicatorName = new DicomTag(0x300a,
			0x0294, "Source Applicator Name", ValueRepresentation.LongString);

	public static final DicomTag SourceApplicatorNumber = new DicomTag(0x300a,
			0x0290, "Source Applicator Number", ValueRepresentation.IntegerString);

	public static final DicomTag SourceApplicatorStepSize = new DicomTag(0x300a,
			0x02a0, "Source Applicator Step Size", ValueRepresentation.DecimalString);

	public static final DicomTag SourceApplicatorType = new DicomTag(0x300a,
			0x0292, "Source Applicator Type", ValueRepresentation.CodeString);

	public static final DicomTag SourceApplicatorWallNominalThickness = new DicomTag(
			0x300a, 0x029c, "Source Applicator Wall Nominal Thickness",
			ValueRepresentation.DecimalString);

	public static final DicomTag SourceApplicatorWallNominalTransmission = new DicomTag(
			0x300a, 0x029e, "Source Applicator Wall Nominal Transmission",
			ValueRepresentation.DecimalString);

	public static final DicomTag SourceAxisDistance = new DicomTag(0x300a,
			0x00b4, "Source-Axis Distance", ValueRepresentation.DecimalString);

	public static final DicomTag SourceEncapsulationNominalThickness = new DicomTag(
			0x300a, 0x0222, "Source Encapsulation Nominal Thickness",
			ValueRepresentation.DecimalString);

	public static final DicomTag SourceEncapsulationNominalTransmission = new DicomTag(
			0x300a, 0x0224, "Source Encapsulation Nominal Transmission",
			ValueRepresentation.DecimalString);

	public static final DicomTag SourceHangingProtocolSeq = new DicomTag(0x0072,
			0x0012, "Source Hanging Protocol Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag SourceImageEvidenceSeq = new DicomTag(0x0008,
			0x9154, "Source Image Evidence Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag SourceImageSeq = new DicomTag(0x0008, 0x2112,
			"Source Image Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag SourceInstanceSeq = new DicomTag(0x0042, 0x0013,
			"Source Instance Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag SourceIsotopeHalfLife = new DicomTag(0x300a,
			0x0228, "Source Isotope Half Life", ValueRepresentation.DecimalString);

	public static final DicomTag SourceIsotopeName = new DicomTag(0x300a, 0x0226,
			"Source Isotope Name", ValueRepresentation.LongString);

	public static final DicomTag SourceManufacturer = new DicomTag(0x300a,
			0x0216, "Source Manufacturer", ValueRepresentation.LongString);

	public static final DicomTag SourceMovementType = new DicomTag(0x300a,
			0x0288, "Source Movement Type", ValueRepresentation.CodeString);

	public static final DicomTag SourceNumber = new DicomTag(0x300a, 0x0212,
			"Source Number", ValueRepresentation.IntegerString);

	public static final DicomTag SourceSeq = new DicomTag(0x300a, 0x0210,
			"Source Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag SourceSerialNumber = new DicomTag(0x3008,
			0x0105, "Source Serial Number", ValueRepresentation.LongString);

	public static final DicomTag SourceToBeamLimitingDeviceDistance = new DicomTag(
			0x300a, 0x00ba, "Source to Beam Limiting Device Distance",
			ValueRepresentation.DecimalString);

	public static final DicomTag SourceToBlockTrayDistance = new DicomTag(0x300a,
			0x00f6, "Source to Block Tray Distance",
			ValueRepresentation.DecimalString);

	public static final DicomTag SourceToCompensatorTrayDistance = new DicomTag(
			0x300a, 0x00e6, "Source to Compensator Tray Distance",
			ValueRepresentation.DecimalString);

	public static final DicomTag SourceToReferenceObjectDistance = new DicomTag(
			0x3002, 0x0028, "Source to Reference Object Distance",
			ValueRepresentation.DecimalString);

	public static final DicomTag SourceToSurfaceDistance = new DicomTag(0x300a,
			0x0130, "Source to Surface Distance", ValueRepresentation.DecimalString);

	public static final DicomTag SourceToWedgeTrayDistance = new DicomTag(0x300a,
			0x00da, "Source to Wedge Tray Distance",
			ValueRepresentation.DecimalString);

	public static final DicomTag SourceType = new DicomTag(0x300a, 0x0214,
			"Source Type", ValueRepresentation.CodeString);

	public static final DicomTag SourceWaveformSeq = new DicomTag(0x003a, 0x020a,
			"Source Waveform Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag SpacingBetweenSlices = new DicomTag(0x0018,
			0x0088, "Spacing Between Slices", ValueRepresentation.DecimalString);

	public static final DicomTag SpatialPreSaturation = new DicomTag(0x0018,
			0x9027, "Spatial Pre-saturation", ValueRepresentation.CodeString);

	public static final DicomTag SpatialResolution = new DicomTag(0x0018, 0x1050,
			"Spatial Resolution", ValueRepresentation.DecimalString);

	public static final DicomTag SpecialNeeds = new DicomTag(0x0038, 0x0050,
			"Special Needs", ValueRepresentation.LongString);

	public static final DicomTag SpecificAbsorptionRateDefinition = new DicomTag(
			0x0018, 0x9179, "Specific Absorption Rate Definition",
			ValueRepresentation.CodeString);

	public static final DicomTag SpecificAbsorptionRateSeq = new DicomTag(0x0018,
			0x9239, "Specific Absorption Rate Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag SpecificAbsorptionRateValue = new DicomTag(
			0x0018, 0x9181, "Specific Absorption Rate Value",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag SpecificCharacterSet = new DicomTag(0x0008,
			0x0005, "Specific Character Set", ValueRepresentation.CodeString);

	public static final DicomTag SpecificCharacterSetOfFileSetDescriptorFile = new DicomTag(
			0x0004, 0x1142, "Specific Character Set of File-set Descriptor File",
			ValueRepresentation.CodeString);

	public static final DicomTag SpecifiedChannelTotalTime = new DicomTag(0x3008,
			0x0132, "Specified Channel Total Time", ValueRepresentation.DecimalString);

	public static final DicomTag SpecifiedMeterset = new DicomTag(0x3008, 0x0042,
			"Specified Meterset", ValueRepresentation.DecimalString);

	public static final DicomTag SpecifiedNumberOfPulses = new DicomTag(0x3008,
			0x0136, "Specified Number of Pulses", ValueRepresentation.IntegerString);

	public static final DicomTag SpecifiedPrimaryMeterset = new DicomTag(0x3008,
			0x0032, "Specified Primary Meterset", ValueRepresentation.DecimalString);

	public static final DicomTag SpecifiedPulseRepetitionInterval = new DicomTag(
			0x3008, 0x013a, "Specified Pulse Repetition Interval",
			ValueRepresentation.DecimalString);

	public static final DicomTag SpecifiedSecondaryMeterset = new DicomTag(
			0x3008, 0x0033, "Specified Secondary Meterset",
			ValueRepresentation.DecimalString);

	public static final DicomTag SpecifiedTreatmentTime = new DicomTag(0x3008,
			0x003a, "Specified Treatment Time", ValueRepresentation.DecimalString);

	public static final DicomTag SpecimenAccessionNumber = new DicomTag(0x0040,
			0x050a, "Specimen Accession Number", ValueRepresentation.LongString);

	public static final DicomTag SpecimenIdentifier = new DicomTag(0x0040,
			0x0551, "Specimen Identifier", ValueRepresentation.LongString);

	public static final DicomTag SpecimenSeq = new DicomTag(0x0040, 0x0550,
			"Specimen Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag SpecimenTypeCodeSeq = new DicomTag(0x0040,
			0x059a, "Specimen Type Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag SpectrallySelectedExcitation = new DicomTag(
			0x0018, 0x9026, "Spectrally Selected Excitation",
			ValueRepresentation.CodeString);

	public static final DicomTag SpectrallySelectedSuppression = new DicomTag(
			0x0018, 0x9025, "Spectrally Selected Suppression",
			ValueRepresentation.CodeString);

	public static final DicomTag SpectralWidth = new DicomTag(0x0018, 0x9052,
			"Spectral Width", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag SpectroscopyAcquisitionDataColumns = new DicomTag(
			0x0018, 0x9127, "Spectroscopy Acquisition Data Columns",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag SpectroscopyAcquisitionOutOfPlanePhaseSteps = new DicomTag(
			0x0018, 0x9159, "Spectroscopy Acquisition Out-of-plane Phase Steps",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag SpectroscopyAcquisitionPhaseColumns = new DicomTag(
			0x0018, 0x9234, "Spectroscopy Acquisition Phase Columns",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag SpectroscopyAcquisitionPhaseRows = new DicomTag(
			0x0018, 0x9095, "Spectroscopy Acquisition Phase Rows",
			ValueRepresentation.UnsignedLong);

	public static final DicomTag SpectroscopyData = new DicomTag(0x5600, 0x0020,
			"Spectroscopy Data", ValueRepresentation.OtherFloatString);

	public static final DicomTag SphericalLensPower = new DicomTag(0x0022,
			0x0007, "Spherical Lens Power", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag SpiralPitchFactor = new DicomTag(0x0018, 0x9311,
			"Spiral Pitch Factor", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag Spoiling = new DicomTag(0x0018, 0x9016,
			"Spoiling", ValueRepresentation.CodeString);

	public static final DicomTag SPSComments = new DicomTag(0x0040, 0x0400,
			"Comments on the Scheduled Procedure Step", ValueRepresentation.LongText);

	public static final DicomTag SPSStartDateAndTime = new DicomTag(0x0040,
			0x4005, "Scheduled Procedure Step Start Date and Time",
			ValueRepresentation.DateTime);

	public static final DicomTag StackID = new DicomTag(0x0020, 0x9056,
			"Stack ID", ValueRepresentation.ShortString);

	public static final DicomTag StageName = new DicomTag(0x0008, 0x2120,
			"Stage Name", ValueRepresentation.ShortString);

	public static final DicomTag StageNumber = new DicomTag(0x0008, 0x2122,
			"Stage Number", ValueRepresentation.IntegerString);

	public static final DicomTag StartAngle = new DicomTag(0x0054, 0x0200,
			"Start Angle", ValueRepresentation.DecimalString);

	public static final DicomTag StartCumulativeMetersetWeight = new DicomTag(
			0x300c, 0x0008, "Start Cumulative Meterset Weight",
			ValueRepresentation.DecimalString);

	public static final DicomTag StartMeterset = new DicomTag(0x3008, 0x0078,
			"Start Meterset", ValueRepresentation.DecimalString);

	public static final DicomTag StartTrim = new DicomTag(0x0008, 0x2142,
			"Start Trim", ValueRepresentation.IntegerString);

	public static final DicomTag StationName = new DicomTag(0x0008, 0x1010,
			"Station Name", ValueRepresentation.ShortString);

	public static final DicomTag Status = new DicomTag(0x0000, 0x0900, "Status",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag SteadyStatePulseSeq = new DicomTag(0x0018,
			0x9017, "Steady State Pulse Sequence", ValueRepresentation.CodeString);

	public static final DicomTag SteeringAngle = new DicomTag(0x0018, 0x6036,
			"Steering Angle", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag StereoBaselineAngle = new DicomTag(0x0022,
			0x0010, "Stereo Baseline Angle", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag StereoBaselineDisplacement = new DicomTag(
			0x0022, 0x0011, "Stereo Baseline Displacement",
			ValueRepresentation.FloatingPointSingle);

	public static final DicomTag StereoHorizontalPixelOffset = new DicomTag(
			0x0022, 0x0012, "Stereo Horizontal Pixel Offset",
			ValueRepresentation.FloatingPointSingle);

	public static final DicomTag StereoPairsSeq = new DicomTag(0x0022, 0x0020,
			"Stereo Pairs Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag StereoRotation = new DicomTag(0x0022, 0x0014,
			"Stereo Rotation", ValueRepresentation.FloatingPointSingle);

	public static final DicomTag StereoVerticalPixelOffset = new DicomTag(0x0022,
			0x0013, "Stereo Vertical Pixel Offset",
			ValueRepresentation.FloatingPointSingle);

	public static final DicomTag StopTrim = new DicomTag(0x0008, 0x2143,
			"Stop Trim", ValueRepresentation.IntegerString);

	public static final DicomTag StorageMediaFileSetID = new DicomTag(0x0088,
			0x0130, "Storage Media File-set ID", ValueRepresentation.ShortString);

	public static final DicomTag StorageMediaFileSetUID = new DicomTag(0x0088,
			0x0140, "Storage Media File-set UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag StructureSetDate = new DicomTag(0x3006, 0x0008,
			"Structure Set Date", ValueRepresentation.Date);

	public static final DicomTag StructureSetDescription = new DicomTag(0x3006,
			0x0006, "Structure Set Description", ValueRepresentation.ShortText);

	public static final DicomTag StructureSetLabel = new DicomTag(0x3006, 0x0002,
			"Structure Set Label", ValueRepresentation.ShortString);

	public static final DicomTag StructureSetName = new DicomTag(0x3006, 0x0004,
			"Structure Set Name", ValueRepresentation.LongString);

	public static final DicomTag StructureSetROISeq = new DicomTag(0x3006,
			0x0020, "Structure Set ROI Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag StructureSetTime = new DicomTag(0x3006, 0x0009,
			"Structure Set Time", ValueRepresentation.Time);

	public static final DicomTag StudiesContainingOtherReferencedInstancesSeq = new DicomTag(
			0x0008, 0x1200, "Studies Containing Other Referenced Instances Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag StudyArrivalDate = new DicomTag(0x0032, 0x1040,
			"Study Arrival Date", ValueRepresentation.Date);

	public static final DicomTag StudyArrivalTime = new DicomTag(0x0032, 0x1041,
			"Study Arrival Time", ValueRepresentation.Time);

	public static final DicomTag StudyComments = new DicomTag(0x0032, 0x4000,
			"Study Comments", ValueRepresentation.LongText);

	public static final DicomTag StudyCommentsRetired = new DicomTag(0x0008,
			0x4000, "(Study) Comments (Retired)", ValueRepresentation.LongText);

	public static final DicomTag StudyCompletionDate = new DicomTag(0x0032,
			0x1050, "Study Completion Date", ValueRepresentation.Date);

	public static final DicomTag StudyCompletionTime = new DicomTag(0x0032,
			0x1051, "Study Completion Time", ValueRepresentation.Time);

	public static final DicomTag StudyComponentStatusID = new DicomTag(0x0032,
			0x1055, "Study Component Status ID", ValueRepresentation.CodeString);

	public static final DicomTag StudyDate = new DicomTag(0x0008, 0x0020,
			"Study Date", ValueRepresentation.Date);

	public static final DicomTag StudyDescription = new DicomTag(0x0008, 0x1030,
			"Study Description", ValueRepresentation.LongString);

	public static final DicomTag StudyID = new DicomTag(0x0020, 0x0010,
			"Study ID", ValueRepresentation.ShortString);

	public static final DicomTag StudyIDIssuer = new DicomTag(0x0032, 0x0012,
			"Study ID Issuer", ValueRepresentation.LongString);

	public static final DicomTag StudyInstanceUID = new DicomTag(0x0020, 0x000d,
			"Study Instance UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag StudyPriorityID = new DicomTag(0x0032, 0x000c,
			"Study Priority ID", ValueRepresentation.CodeString);

	public static final DicomTag StudyReadDate = new DicomTag(0x0032, 0x0034,
			"Study Read Date", ValueRepresentation.Date);

	public static final DicomTag StudyReadTime = new DicomTag(0x0032, 0x0035,
			"Study Read Time", ValueRepresentation.Time);

	public static final DicomTag StudyStatusID = new DicomTag(0x0032, 0x000a,
			"Study Status ID", ValueRepresentation.CodeString);

	public static final DicomTag StudyTime = new DicomTag(0x0008, 0x0030,
			"Study Time", ValueRepresentation.Time);

	public static final DicomTag StudyVerifiedDate = new DicomTag(0x0032, 0x0032,
			"Study Verified Date", ValueRepresentation.Date);

	public static final DicomTag StudyVerifiedTime = new DicomTag(0x0032, 0x0033,
			"Study Verified Time", ValueRepresentation.Time);

	public static final DicomTag SupportedImageDisplayFormatsSeq = new DicomTag(
			0x2000, 0x00a8, "Supported Image Display Formats Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag SurfaceEntryPoint = new DicomTag(0x300a, 0x012e,
			"Surface Entry Point", ValueRepresentation.DecimalString);

	public static final DicomTag SynchronizationChannel = new DicomTag(0x0018,
			0x106c, "Synchronization Channel", ValueRepresentation.UnsignedShort);

	public static final DicomTag SynchronizationFrameOfReferenceUID = new DicomTag(
			0x0020, 0x0200, "Synchronization Frame of Reference UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag SynchronizationTrigger = new DicomTag(0x0018,
			0x106a, "Synchronization Trigger", ValueRepresentation.CodeString);

	public static final DicomTag SynchronizedScrollingSeq = new DicomTag(0x0072,
			0x0210, "Synchronized Scrolling Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag SyringeCounts = new DicomTag(0x0018, 0x1045,
			"Syringe Counts", ValueRepresentation.IntegerString);

	public static final DicomTag T2Preparation = new DicomTag(0x0018, 0x9021,
			"T2 Preparation", ValueRepresentation.CodeString);

	public static final DicomTag TableAngle = new DicomTag(0x0018, 0x1138,
			"Table Angle", ValueRepresentation.DecimalString);

	public static final DicomTag TableFeedPerRotation = new DicomTag(0x0018,
			0x9310, "Table Feed per Rotation",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TableHeight = new DicomTag(0x0018, 0x1130,
			"Table Height", ValueRepresentation.DecimalString);

	public static final DicomTag TableLateralIncrement = new DicomTag(0x0018,
			0x1136, "Table Lateral Increment", ValueRepresentation.DecimalString);

	public static final DicomTag TableLongitudinalIncrement = new DicomTag(
			0x0018, 0x1137, "Table Longitudinal Increment",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableMotion = new DicomTag(0x0018, 0x1134,
			"Table Motion", ValueRepresentation.CodeString);

	public static final DicomTag TableOfParameterValues = new DicomTag(0x0018,
			0x605a, "Table of Parameter Values",
			ValueRepresentation.FloatingPointSingle);

	public static final DicomTag TableOfPixelValues = new DicomTag(0x0018,
			0x6058, "Table of Pixel Values", ValueRepresentation.UnsignedLong);

	public static final DicomTag TableOfXBreakPoints = new DicomTag(0x0018,
			0x6052, "Table of X Break Points", ValueRepresentation.UnsignedLong);

	public static final DicomTag TableOfYBreakPoints = new DicomTag(0x0018,
			0x6054, "Table of Y Break Points",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TablePosition = new DicomTag(0x0018, 0x9327,
			"Table Position", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TableSpeed = new DicomTag(0x0018, 0x9309,
			"Table Speed", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TableTopEccentricAngle = new DicomTag(0x300a,
			0x0125, "Table Top Eccentric Angle", ValueRepresentation.DecimalString);

	public static final DicomTag TableTopEccentricAngleTolerance = new DicomTag(
			0x300a, 0x004e, "Table Top Eccentric Angle Tolerance",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableTopEccentricAxisDistance = new DicomTag(
			0x300a, 0x0124, "Table Top Eccentric Axis Distance",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableTopEccentricRotationDirection = new DicomTag(
			0x300a, 0x0126, "Table Top Eccentric Rotation Direction",
			ValueRepresentation.CodeString);

	public static final DicomTag TableTopLateralPosition = new DicomTag(0x300a,
			0x012a, "Table Top Lateral Position", ValueRepresentation.DecimalString);

	public static final DicomTag TableTopLateralPositionTolerance = new DicomTag(
			0x300a, 0x0053, "Table Top Lateral Position Tolerance",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableTopLateralSetupDisplacement = new DicomTag(
			0x300a, 0x01d6, "Table Top Lateral Setup Displacement",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableTopLongitudinalPosition = new DicomTag(
			0x300a, 0x0129, "Table Top Longitudinal Position",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableTopLongitudinalPositionTolerance = new DicomTag(
			0x300a, 0x0052, "Table Top Longitudinal Position Tolerance",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableTopLongitudinalSetupDisplacement = new DicomTag(
			0x300a, 0x01d4, "Table Top Longitudinal Setup Displacement",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableTopVerticalPosition = new DicomTag(0x300a,
			0x0128, "Table Top Vertical Position", ValueRepresentation.DecimalString);

	public static final DicomTag TableTopVerticalPositionTolerance = new DicomTag(
			0x300a, 0x0051, "Table Top Vertical Position Tolerance",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableTopVerticalSetupDisplacement = new DicomTag(
			0x300a, 0x01d2, "Table Top Vertical Setup Displacement",
			ValueRepresentation.DecimalString);

	public static final DicomTag TableTraverse = new DicomTag(0x0018, 0x1131,
			"Table Traverse", ValueRepresentation.DecimalString);

	public static final DicomTag TableType = new DicomTag(0x0018, 0x113a,
			"Table Type", ValueRepresentation.CodeString);

	public static final DicomTag TableVerticalIncrement = new DicomTag(0x0018,
			0x1135, "Table Vertical Increment", ValueRepresentation.DecimalString);

	public static final DicomTag TagAngleFirstAxis = new DicomTag(0x0018, 0x9019,
			"Tag Angle First Axis", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TagAngleSecondAxis = new DicomTag(0x0018,
			0x9219, "Tag Angle Second Axis", ValueRepresentation.SignedShort);

	public static final DicomTag Tagging = new DicomTag(0x0018, 0x9028,
			"Tagging", ValueRepresentation.CodeString);

	public static final DicomTag TaggingDelay = new DicomTag(0x0018, 0x9184,
			"Tagging Delay", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TagSpacingFirstDimension = new DicomTag(0x0018,
			0x9030, "Tag Spacing First Dimension",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TagSpacingSecondDimension = new DicomTag(0x0018,
			0x9218, "Tag Spacing Second Dimension",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TagThickness = new DicomTag(0x0018, 0x9035,
			"Tag Thickness", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TargetMaximumDose = new DicomTag(0x300a, 0x0027,
			"Target Maximum Dose", ValueRepresentation.DecimalString);

	public static final DicomTag TargetMinimumDose = new DicomTag(0x300a, 0x0025,
			"Target Minimum Dose", ValueRepresentation.DecimalString);

	public static final DicomTag TargetPrescriptionDose = new DicomTag(0x300a,
			0x0026, "Target Prescription Dose", ValueRepresentation.DecimalString);

	public static final DicomTag TargetUnderdoseVolumeFraction = new DicomTag(
			0x300a, 0x0028, "Target Underdose Volume Fraction",
			ValueRepresentation.DecimalString);

	public static final DicomTag TemplateExtensionCreatorUID = new DicomTag(
			0x0040, 0xdb0d, "Template Extension Creator UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag TemplateExtensionFlag = new DicomTag(0x0040,
			0xdb0b, "Template Extension Flag", ValueRepresentation.CodeString);

	public static final DicomTag TemplateExtensionOrganizationUID = new DicomTag(
			0x0040, 0xdb0c, "Template Extension Organization UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag TemplateIdentifier = new DicomTag(0x0040,
			0xdb00, "Template Identifier", ValueRepresentation.CodeString);

	public static final DicomTag TemplateLocalVersion = new DicomTag(0x0040,
			0xdb07, "Template Local Version", ValueRepresentation.DateTime);

	public static final DicomTag TemplateName = new DicomTag(0x300a, 0x0244,
			"Template Name", ValueRepresentation.LongString);

	public static final DicomTag TemplateNumber = new DicomTag(0x300a, 0x0240,
			"Template Number", ValueRepresentation.IntegerString);

	public static final DicomTag TemplateType = new DicomTag(0x300a, 0x0242,
			"Template Type", ValueRepresentation.ShortString);

	public static final DicomTag TemplateVersion = new DicomTag(0x0040, 0xdb06,
			"Template Version", ValueRepresentation.DateTime);

	public static final DicomTag TemporalPositionIdentifier = new DicomTag(
			0x0020, 0x0100, "Temporal Position Identifier",
			ValueRepresentation.IntegerString);

	public static final DicomTag TemporalPositionIndex = new DicomTag(0x0020,
			0x9128, "Temporal Position Index", ValueRepresentation.UnsignedLong);

	public static final DicomTag TemporalRangeType = new DicomTag(0x0040, 0xa130,
			"Temporal Range Type", ValueRepresentation.CodeString);

	public static final DicomTag TemporalResolution = new DicomTag(0x0020,
			0x0110, "Temporal Resolution", ValueRepresentation.DecimalString);

	public static final DicomTag TerminalTypeRetired = new DicomTag(0x0000,
			0x4010, "Terminal Type (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag TextFormatIDRetired = new DicomTag(0x0000,
			0x5130, "Text Format ID (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag TextObjectSeq = new DicomTag(0x0070, 0x0008,
			"Text Object Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag TextString = new DicomTag(0x2030, 0x0020,
			"Text String", ValueRepresentation.LongString);

	public static final DicomTag TextValue = new DicomTag(0x0040, 0xa160,
			"Text Value", ValueRepresentation.UnlimitedText);

	public static final DicomTag TherapyDescription = new DicomTag(0x0018,
			0x0039, "Therapy Description", ValueRepresentation.CodeString);

	public static final DicomTag TherapyType = new DicomTag(0x0018, 0x0037,
			"Therapy Type", ValueRepresentation.CodeString);

	public static final DicomTag ThresholdDensityRetired = new DicomTag(0x2040,
			0x0100, "Threshold Density (Retired)", ValueRepresentation.CodeString);

	public static final DicomTag TIDOffset = new DicomTag(0x0028, 0x6120,
			"TID Offset", ValueRepresentation.SignedShort);

	public static final DicomTag Time = new DicomTag(0x0040, 0xa122, "Time",
			ValueRepresentation.Time);

	public static final DicomTag TimeBasedImageSetsSeq = new DicomTag(0x0072,
			0x0030, "Time Based Image Sets Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TimeDistributionProtocol = new DicomTag(0x0018,
			0x1802, "Time Distribution Protocol", ValueRepresentation.CodeString);

	public static final DicomTag TimeDomainFiltering = new DicomTag(0x0018,
			0x9065, "Time Domain Filtering", ValueRepresentation.CodeString);

	public static final DicomTag TimeOfFlightContrast = new DicomTag(0x0018,
			0x9015, "Time of Flight Contrast", ValueRepresentation.CodeString);

	public static final DicomTag TimeOfLastCalibration = new DicomTag(0x0018,
			0x1201, "Time of Last Calibration", ValueRepresentation.Time);

	public static final DicomTag TimeOfLastDetectorCalibration = new DicomTag(
			0x0018, 0x700e, "Time of Last Detector Calibration",
			ValueRepresentation.Time);

	public static final DicomTag TimeOfSecondaryCapture = new DicomTag(0x0018,
			0x1014, "Time of Secondary Capture", ValueRepresentation.Time);

	public static final DicomTag TimeSliceVector = new DicomTag(0x0054, 0x0100,
			"Time Slice Vector", ValueRepresentation.UnsignedShort);

	public static final DicomTag TimeSlotInformationSeq = new DicomTag(0x0054,
			0x0072, "Time Slot Information Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TimeSlotNumberRetired = new DicomTag(0x0020,
			0x0017, "Time Slot Number (Retired)", ValueRepresentation.IntegerString);

	public static final DicomTag TimeSlotTime = new DicomTag(0x0054, 0x0073,
			"Time Slot Time", ValueRepresentation.DecimalString);

	public static final DicomTag TimeSlotVector = new DicomTag(0x0054, 0x0070,
			"Time Slot Vector", ValueRepresentation.UnsignedShort);

	public static final DicomTag TimeSource = new DicomTag(0x0018, 0x1801,
			"Time Source", ValueRepresentation.ShortString);

	public static final DicomTag TimezoneOffsetFromUTC = new DicomTag(0x0008,
			0x0201, "Timezone Offset From UTC", ValueRepresentation.ShortString);

	public static final DicomTag TMLinePositionX0 = new DicomTag(0x0018, 0x603c,
			"TM-Line Position X0", ValueRepresentation.UnsignedLong);

	public static final DicomTag TMLinePositionX1 = new DicomTag(0x0018, 0x6040,
			"TM-Line Position X1", ValueRepresentation.UnsignedLong);

	public static final DicomTag TMLinePositionY0 = new DicomTag(0x0018, 0x603e,
			"TM-Line Position Y0", ValueRepresentation.UnsignedLong);

	public static final DicomTag TMLinePositionY1 = new DicomTag(0x0018, 0x6042,
			"TM-Line Position Y1", ValueRepresentation.UnsignedLong);

	public static final DicomTag ToleranceTableLabel = new DicomTag(0x300a,
			0x0043, "Tolerance Table Label", ValueRepresentation.ShortString);

	public static final DicomTag ToleranceTableNumber = new DicomTag(0x300a,
			0x0042, "Tolerance Table Number", ValueRepresentation.IntegerString);

	public static final DicomTag ToleranceTableSeq = new DicomTag(0x300a, 0x0040,
			"Tolerance Table Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag TomoAngle = new DicomTag(0x0018, 0x1470,
			"Tomo Angle", ValueRepresentation.DecimalString);

	public static final DicomTag TomoClass = new DicomTag(0x0018, 0x1491,
			"Tomo Class", ValueRepresentation.CodeString);

	public static final DicomTag TomoLayerHeight = new DicomTag(0x0018, 0x1460,
			"Tomo Layer Height", ValueRepresentation.DecimalString);

	public static final DicomTag TomoTime = new DicomTag(0x0018, 0x1480,
			"Tomo Time", ValueRepresentation.DecimalString);

	public static final DicomTag TomoType = new DicomTag(0x0018, 0x1490,
			"Tomo Type", ValueRepresentation.CodeString);

	public static final DicomTag TopicAuthor = new DicomTag(0x0088, 0x0910,
			"Topic Author", ValueRepresentation.LongString);

	public static final DicomTag TopicKeyWords = new DicomTag(0x0088, 0x0912,
			"Topic Key Words", ValueRepresentation.LongString);

	public static final DicomTag TopicSubject = new DicomTag(0x0088, 0x0906,
			"Topic Subject", ValueRepresentation.ShortText);

	public static final DicomTag TopicTitle = new DicomTag(0x0088, 0x0904,
			"Topic Title", ValueRepresentation.LongString);

	public static final DicomTag TotalBlockTrayFactor = new DicomTag(0x300a,
			0x00f2, "Total Block Tray Factor", ValueRepresentation.DecimalString);

	public static final DicomTag TotalCollimationWidth = new DicomTag(0x0018,
			0x9307, "Total Collimation Width",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TotalCompensatorTrayFactor = new DicomTag(
			0x300a, 0x00e2, "Total Compensator Tray Factor",
			ValueRepresentation.DecimalString);

	public static final DicomTag TotalGainRetired = new DicomTag(0x0018, 0x5040,
			"Total Gain (Retired)", ValueRepresentation.Unknown);

	public static final DicomTag TotalNumberOfExposures = new DicomTag(0x0040,
			0x0301, "Total Number of Exposures", ValueRepresentation.UnsignedShort);

	public static final DicomTag TotalNumberOfPiecesOfMediaCreated = new DicomTag(
			0x2200, 0x000b, "Total Number of Pieces of Media Created",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag TotalReferenceAirKerma = new DicomTag(0x300a,
			0x0250, "Total Reference Air Kerma", ValueRepresentation.DecimalString);

	public static final DicomTag TotalTimeOfFluoroscopy = new DicomTag(0x0040,
			0x0300, "Total Time of Fluoroscopy", ValueRepresentation.UnsignedShort);

	public static final DicomTag TransactionUID = new DicomTag(0x0008, 0x1195,
			"Transaction UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag TransducerData = new DicomTag(0x0018, 0x5010,
			"Transducer Data", ValueRepresentation.LongString);

	public static final DicomTag TransducerFrequency = new DicomTag(0x0018,
			0x6030, "Transducer Frequency", ValueRepresentation.UnsignedLong);

	public static final DicomTag TransducerOrientationModifierSeq = new DicomTag(
			0x0008, 0x2246, "Transducer Orientation Modifier Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TransducerOrientationRetired = new DicomTag(
			0x0008, 0x2204, "Transducer Orientation (Retired)",
			ValueRepresentation.CodeString);

	public static final DicomTag TransducerOrientationSeq = new DicomTag(0x0008,
			0x2244, "Transducer Orientation Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TransducerPositionModifierSeq = new DicomTag(
			0x0008, 0x2242, "Transducer Position Modifier Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TransducerPositionRetired = new DicomTag(0x0008,
			0x2200, "Transducer Position (Retired)", ValueRepresentation.CodeString);

	public static final DicomTag TransducerPositionSeq = new DicomTag(0x0008,
			0x2240, "Transducer Position Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TransducerType = new DicomTag(0x0018, 0x6031,
			"Transducer Type", ValueRepresentation.CodeString);

	public static final DicomTag TransferSyntaxUID = new DicomTag(0x0002, 0x0010,
			"Transfer Syntax UID", ValueRepresentation.UniqueIdentifier);

	public static final DicomTag TransferTubeLength = new DicomTag(0x300a,
			0x02a4, "Transfer Tube Length", ValueRepresentation.DecimalString);

	public static final DicomTag TransferTubeNumber = new DicomTag(0x300a,
			0x02a2, "Transfer Tube Number", ValueRepresentation.IntegerString);

	public static final DicomTag TransmitCoilManufacturerName = new DicomTag(
			0x0018, 0x9050, "Transmit Coil Manufacturer Name",
			ValueRepresentation.LongString);

	public static final DicomTag TransmitCoilName = new DicomTag(0x0018, 0x1251,
			"Transmit Coil Name", ValueRepresentation.ShortString);

	public static final DicomTag TransmitCoilType = new DicomTag(0x0018, 0x9051,
			"Transmit Coil Type", ValueRepresentation.CodeString);

	public static final DicomTag TransmitterFrequency = new DicomTag(0x0018,
			0x9098, "Transmitter Frequency", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TransverseMash = new DicomTag(0x0054, 0x1202,
			"Transverse Mash", ValueRepresentation.IntegerString);

	public static final DicomTag TreatmentControlPointDate = new DicomTag(0x3008,
			0x0024, "Treatment Control Point Date", ValueRepresentation.Date);

	public static final DicomTag TreatmentControlPointTime = new DicomTag(0x3008,
			0x0025, "Treatment Control Point Time", ValueRepresentation.Time);

	public static final DicomTag TreatmentDate = new DicomTag(0x3008, 0x0250,
			"Treatment Date", ValueRepresentation.Date);

	public static final DicomTag TreatmentDeliveryType = new DicomTag(0x300a,
			0x00ce, "Treatment Delivery Type", ValueRepresentation.CodeString);

	public static final DicomTag TreatmentIntent = new DicomTag(0x300a, 0x000a,
			"Treatment Intent", ValueRepresentation.CodeString);

	public static final DicomTag TreatmentMachineName = new DicomTag(0x300a,
			0x00b2, "Treatment Machine Name", ValueRepresentation.ShortString);

	public static final DicomTag TreatmentMachineSeq = new DicomTag(0x300a,
			0x0206, "Treatment Machine Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag TreatmentProtocols = new DicomTag(0x300a,
			0x0009, "Treatment Protocols", ValueRepresentation.LongString);

	public static final DicomTag TreatmentSessionApplicationSetupSeq = new DicomTag(
			0x3008, 0x0110, "Treatment Session Application Setup Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TreatmentSessionBeamSeq = new DicomTag(0x3008,
			0x0020, "Treatment Session Beam Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TreatmentSites = new DicomTag(0x300a, 0x000b,
			"Treatment Sites", ValueRepresentation.LongString);

	public static final DicomTag TreatmentStatusComment = new DicomTag(0x3008,
			0x0202, "Treatment Status Comment", ValueRepresentation.ShortText);

	public static final DicomTag TreatmentSummaryCalculatedDoseReferenceSeq = new DicomTag(
			0x3008, 0x0050, "Treatment Summary Calculated Dose Reference Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TreatmentSummaryMeasuredDoseReferenceSeq = new DicomTag(
			0x3008, 0x00e0, "Treatment Summary Measured Dose Reference Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag TreatmentTerminationCode = new DicomTag(0x3008,
			0x002b, "Treatment Termination Code", ValueRepresentation.ShortString);

	public static final DicomTag TreatmentTerminationStatus = new DicomTag(
			0x3008, 0x002a, "Treatment Termination Status",
			ValueRepresentation.CodeString);

	public static final DicomTag TreatmentTime = new DicomTag(0x3008, 0x0251,
			"Treatment Time", ValueRepresentation.Time);

	public static final DicomTag TreatmentVerificationStatus = new DicomTag(
			0x3008, 0x002c, "Treatment Verification Status",
			ValueRepresentation.CodeString);

	public static final DicomTag TriggerDelayTime = new DicomTag(0x0020, 0x9153,
			"Trigger Delay Time", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TriggerSamplePosition = new DicomTag(0x0018,
			0x106e, "Trigger Sample Position", ValueRepresentation.UnsignedLong);

	public static final DicomTag TriggerSourceOrType = new DicomTag(0x0018,
			0x1061, "Trigger Source or Type", ValueRepresentation.LongString);

	public static final DicomTag TriggerTime = new DicomTag(0x0018, 0x1060,
			"Trigger Time", ValueRepresentation.DecimalString);

	public static final DicomTag TriggerTimeOffset = new DicomTag(0x0018, 0x1069,
			"Trigger Time Offset", ValueRepresentation.DecimalString);

	public static final DicomTag TriggerVector = new DicomTag(0x0054, 0x0210,
			"Trigger Vector", ValueRepresentation.IntegerString);

	public static final DicomTag TriggerWindow = new DicomTag(0x0018, 0x1094,
			"Trigger Window", ValueRepresentation.IntegerString);

	public static final DicomTag Trim = new DicomTag(0x2010, 0x0140, "Trim",
			ValueRepresentation.CodeString);

	public static final DicomTag TubeAngle = new DicomTag(0x0018, 0x9303,
			"Tube Angle", ValueRepresentation.FloatingPointDouble);

	public static final DicomTag TypeOfDetectorMotion = new DicomTag(0x0054,
			0x0202, "Type of Detector Motion", ValueRepresentation.CodeString);

	public static final DicomTag TypeOfFilters = new DicomTag(0x0018, 0x1161,
			"Type of Filters", ValueRepresentation.LongString);

	public static final DicomTag UID = new DicomTag(0x0040, 0xa124, "UID",
			ValueRepresentation.UniqueIdentifier);

	public static final DicomTag UltrasoundColorDataPresent = new DicomTag(
			0x0028, 0x0014, "Ultrasound Color Data Present",
			ValueRepresentation.UnsignedShort);

	public static final DicomTag UnformattedTextValue = new DicomTag(0x0070,
			0x0006, "Unformatted Text Value", ValueRepresentation.ShortText);

	public static final DicomTag Units = new DicomTag(0x0054, 0x1001, "Units",
			ValueRepresentation.CodeString);

	public static final DicomTag UpperLowerPixelValuesRetired = new DicomTag(
			0x0018, 0x1240, "Upper/Lower Pixel Values (Retired)",
			ValueRepresentation.Unknown);

	public static final DicomTag UsedFiducialsSeq = new DicomTag(0x0070, 0x0314,
			"Used Fiducials Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ValueType = new DicomTag(0x0040, 0xa040,
			"Value Type", ValueRepresentation.CodeString);

	public static final DicomTag VariableFlipAngleFlag = new DicomTag(0x0018,
			0x1315, "Variable Flip Angle Flag", ValueRepresentation.CodeString);

	public static final DicomTag VelocityEncodingDirection = new DicomTag(0x0018,
			0x9090, "Velocity Encoding Direction",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag VelocityEncodingMaximumValue = new DicomTag(
			0x0018, 0x9217, "Velocity Encoding Maximum Value",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag VelocityEncodingMinimumValue = new DicomTag(
			0x0018, 0x9091, "Velocity Encoding Minimum Value",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag VerificationDateTime = new DicomTag(0x0040,
			0xa030, "Verification DateTime", ValueRepresentation.DateTime);

	public static final DicomTag VerificationFlag = new DicomTag(0x0040, 0xa493,
			"Verification Flag", ValueRepresentation.CodeString);

	public static final DicomTag VerifyingObserverIdentificationCodeSeq = new DicomTag(
			0x0040, 0xa088, "Verifying Observer Identification Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag VerifyingObserverName = new DicomTag(0x0040,
			0xa075, "Verifying Observer Name", ValueRepresentation.PersonName);

	public static final DicomTag VerifyingObserverSeq = new DicomTag(0x0040,
			0xa073, "Verifying Observer Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag VerifyingOrganization = new DicomTag(0x0040,
			0xa027, "Verifying Organization", ValueRepresentation.LongString);

	public static final DicomTag VerticesOfPolygonalCollimator = new DicomTag(
			0x0018, 0x1720, "Vertices of the Polygonal Collimator",
			ValueRepresentation.IntegerString);

	public static final DicomTag VerticesOfPolygonalShutter = new DicomTag(
			0x0018, 0x1620, "Vertices of the Polygonal Shutter",
			ValueRepresentation.IntegerString);

	public static final DicomTag VideoImageFormatAcquired = new DicomTag(0x0018,
			0x1022, "Video Image Format Acquired", ValueRepresentation.ShortString);

	public static final DicomTag ViewCodeSeq = new DicomTag(0x0054, 0x0220,
			"View Code Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag ViewModifierCodeSeq = new DicomTag(0x0054,
			0x0222, "View Modifier Code Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag ViewNumber = new DicomTag(0x0008, 0x2128,
			"View Number", ValueRepresentation.IntegerString);

	public static final DicomTag ViewPosition = new DicomTag(0x0018, 0x5101,
			"View Position", ValueRepresentation.CodeString);

	public static final DicomTag VisitComments = new DicomTag(0x0038, 0x4000,
			"Visit Comments", ValueRepresentation.LongText);

	public static final DicomTag VisitStatusID = new DicomTag(0x0038, 0x0008,
			"Visit Status ID", ValueRepresentation.CodeString);

	public static final DicomTag VOILUTSeq = new DicomTag(0x0028, 0x3010,
			"VOI LUT Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag VOIType = new DicomTag(0x0072, 0x0702,
			"VOI Type", ValueRepresentation.CodeString);

	public static final DicomTag VolumeBasedCalculationTechnique = new DicomTag(
			0x0008, 0x9207, "Volume Based Calculation Technique",
			ValueRepresentation.CodeString);

	public static final DicomTag VolumeLocalizationSeq = new DicomTag(0x0018,
			0x9126, "Volume Localization Sequence",
			ValueRepresentation.SequenceOfItems);

	public static final DicomTag VolumeLocalizationTechnique = new DicomTag(
			0x0018, 0x9054, "Volume Localization Technique",
			ValueRepresentation.CodeString);

	public static final DicomTag VolumetricProperties = new DicomTag(0x0008,
			0x9206, "Volumetric Properties", ValueRepresentation.CodeString);

	public static final DicomTag VUSAcquisition = new DicomTag(0x0018, 0x3100,
			"IVUS Acquisition", ValueRepresentation.CodeString);

	public static final DicomTag VUSPullbackRate = new DicomTag(0x0018, 0x3101,
			"IVUS Pullback Rate", ValueRepresentation.DecimalString);

	public static final DicomTag VUSPullbackStartFrameNumber = new DicomTag(
			0x0018, 0x3103, "IVUS Pullback Start Frame Number",
			ValueRepresentation.IntegerString);

	public static final DicomTag WaterReferencedPhaseCorrection = new DicomTag(
			0x0018, 0x9199, "Water Referenced Phase Correction",
			ValueRepresentation.CodeString);

	public static final DicomTag WaveformBitsAllocated = new DicomTag(0x5400,
			0x1004, "Waveform Bits Allocated", ValueRepresentation.UnsignedShort);

	public static final DicomTag WaveformBitsStored = new DicomTag(0x003a,
			0x021a, "Waveform Bits Stored", ValueRepresentation.UnsignedShort);

	public static final DicomTag WaveformChannelNumber = new DicomTag(0x003a,
			0x0202, "Waveform Channel Number", ValueRepresentation.IntegerString);

	public static final DicomTag WaveformData = new DicomTag(0x5400, 0x1010,
			"Waveform Data", ValueRepresentation.Unknown);

	public static final DicomTag WaveformOriginality = new DicomTag(0x003a,
			0x0004, "Waveform Originality", ValueRepresentation.CodeString);

	public static final DicomTag WaveformPaddingValue = new DicomTag(0x5400,
			0x100a, "Waveform Padding Value", ValueRepresentation.Unknown);

	public static final DicomTag WaveformSampleInterpretation = new DicomTag(
			0x5400, 0x1006, "Waveform Sample Interpretation",
			ValueRepresentation.CodeString);

	public static final DicomTag WaveformSeq = new DicomTag(0x5400, 0x0100,
			"Waveform Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag WedgeAngle = new DicomTag(0x300a, 0x00d5,
			"Wedge Angle", ValueRepresentation.IntegerString);

	public static final DicomTag WedgeFactor = new DicomTag(0x300a, 0x00d6,
			"Wedge Factor", ValueRepresentation.DecimalString);

	public static final DicomTag WedgeID = new DicomTag(0x300a, 0x00d4,
			"Wedge ID", ValueRepresentation.ShortString);

	public static final DicomTag WedgeNumber = new DicomTag(0x300a, 0x00d2,
			"Wedge Number", ValueRepresentation.IntegerString);

	public static final DicomTag WedgeOrientation = new DicomTag(0x300a, 0x00d8,
			"Wedge Orientation", ValueRepresentation.DecimalString);

	public static final DicomTag WedgePosition = new DicomTag(0x300a, 0x0118,
			"Wedge Position", ValueRepresentation.CodeString);

	public static final DicomTag WedgePositionSeq = new DicomTag(0x300a, 0x0116,
			"Wedge Position Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag WedgeSeq = new DicomTag(0x300a, 0x00d1,
			"Wedge Sequence", ValueRepresentation.SequenceOfItems);

	public static final DicomTag WedgeType = new DicomTag(0x300a, 0x00d3,
			"Wedge Type", ValueRepresentation.CodeString);

	public static final DicomTag WholeBodyTechnique = new DicomTag(0x0018,
			0x1301, "Whole Body Technique", ValueRepresentation.CodeString);

	public static final DicomTag WindowCenter = new DicomTag(0x0028, 0x1050,
			"Window Center", ValueRepresentation.DecimalString);

	public static final DicomTag WindowCenterWidthExplanation = new DicomTag(
			0x0028, 0x1055, "Window Center & Width Explanation",
			ValueRepresentation.LongString);

	public static final DicomTag WindowWidth = new DicomTag(0x0028, 0x1051,
			"Window Width", ValueRepresentation.DecimalString);

	public static final DicomTag XFocusCenter = new DicomTag(0x0018, 0x1183,
			"X Focus Center", ValueRepresentation.DecimalString);

	public static final DicomTag XOffsetInSlideCoordinateSystem = new DicomTag(
			0x0040, 0x072a, "X offset in Slide Coordinate System",
			ValueRepresentation.DecimalString);

	public static final DicomTag XRayImageReceptorAngle = new DicomTag(0x3002,
			0x000e, "X-Ray Image Receptor Angle", ValueRepresentation.DecimalString);

	public static final DicomTag XRayImageReceptorTranslation = new DicomTag(
			0x3002, 0x000d, "X-Ray Image Receptor Translation",
			ValueRepresentation.DecimalString);

	public static final DicomTag XRayOutput = new DicomTag(0x0040, 0x0312,
			"X-Ray Output", ValueRepresentation.DecimalString);

	public static final DicomTag XRayTubeCurrent = new DicomTag(0x0018, 0x1151,
			"X-ray Tube Current", ValueRepresentation.IntegerString);

	public static final DicomTag XRayTubeCurrentInMA = new DicomTag(0x0018,
			0x9330, "X-Ray Tube Current in mA",
			ValueRepresentation.FloatingPointDouble);

	public static final DicomTag XRayTubeCurrentInuA = new DicomTag(0x0018,
			0x8151, "X-Ray Tube Current in uA", ValueRepresentation.DecimalString);

	public static final DicomTag YFocusCenter = new DicomTag(0x0018, 0x1184,
			"Y Focus Center", ValueRepresentation.DecimalString);

	public static final DicomTag YOffsetInSlideCoordinateSystem = new DicomTag(
			0x0040, 0x073a, "Y offset in Slide Coordinate System",
			ValueRepresentation.DecimalString);

	public static final DicomTag ZOffsetInSlideCoordinateSystem = new DicomTag(
			0x0040, 0x074a, "Z offset in Slide Coordinate System",
			ValueRepresentation.DecimalString);

	public static final DicomTag ZoomCenter = new DicomTag(0x0028, 0x0032,
			"Zoom Center", ValueRepresentation.DecimalString);

	public static final DicomTag ZoomFactor = new DicomTag(0x0028, 0x0031,
			"Zoom Factor", ValueRepresentation.DecimalString);

}