/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.images.transforms;

import java.util.ArrayList;
import java.util.Iterator;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.SequenceItems;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dolmen.core.lang.FloatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * A transformation constructed from a DICOM attribute list that extracts those
 * attributes which describe how stored pixel values are translated into real
 * world values (e.g., Hounsfield Units, cm/s).
 * </p>
 * 
 * <p>
 * Looks first for a per-frame functional group RealWorldValueMappingSequence
 * then looks in the shared functional groups, otherwise tries to find the
 * Rescale Slope and Intercept values in the top level of the dataset.
 * </p>
 * 
 * <p>
 * Note that multiple transformations (for each frame) may be present and are
 * supported.
 * </p>
 * 
 * <p>
 * Does not currently support a LUT in the Modality LUT Sequence, only linear
 * rescale values.
 * </p>
 * 
 * @author dclunie
 */
public class RealWorldValueTransform {

	/***/
	private class SingleRealWorldValueTransform {

		/***/
		double fIntercept;

		/***/
		double fSlope;

		/***/
		int[] rangeOfValues; // null if range not constrained

		/***/
		String units;

		/**
		 * @param rwvmlist
		 *          RealWorldValueMappingSequence item attributes
		 */
		SingleRealWorldValueTransform(DataSet rwvmlist) {
			if (rwvmlist != null) {
				this.rangeOfValues = new int[2];
				this.rangeOfValues[0] = DataElement.getSingleIntegerValueOrDefault(
						rwvmlist, DicomTags.RealWorldValueFirstValueMappedUS, 0);
				this.rangeOfValues[1] = DataElement.getSingleIntegerValueOrDefault(
						rwvmlist, DicomTags.RealWorldValueFirstValueMappedUS, 0);
				this.fSlope = DataElement.getSingleDoubleValueOrDefault(rwvmlist,
						DicomTags.RealWorldValueSlope, 0.0);
				this.fIntercept = DataElement.getSingleDoubleValueOrDefault(rwvmlist,
						DicomTags.RealWorldValueIntercept, 0.0);
				this.units = SequenceOfItems
				.getMeaningOfCodedSequenceAttributeOrDefault(rwvmlist,
						DicomTags.MeasurementUnitsCodeSeq, "");
				// System.err.println("SingleRealWorldValueTransform: adding "+rangeOfValues[0]+","+rangeOfValues[1]+","+slope+","+intercept+" "+units);
			}
		}

		/**
		 * @param aDataset
		 *          PixelValueTransformationSequence item attributes
		 * @param aSOPClassUID
		 *          to help choose default rescale units if not specified
		 */
		SingleRealWorldValueTransform(DataSet aDataset, String aSOPClassUID) {
			fLogger.debug("SingleRealWorldValueTransform");
			if (aDataset != null) {
				this.rangeOfValues = null;
				this.fSlope = DataElement.getSingleDoubleValueOrDefault(aDataset,
						DicomTags.RescaleSlope, 1.0);
				fLogger.debug("Slope:" + this.fSlope);
				this.fIntercept = DataElement.getSingleDoubleValueOrDefault(aDataset,
						DicomTags.RescaleIntercept, 0.0);
				fLogger.debug("Intercept:" + this.fIntercept);

				String useUnits = "??";
				String vRescaleType = DataElement.getSingleStringValueOrNull(aDataset,
						DicomTags.RescaleType);
				String vUnits = DataElement.getSingleStringValueOrNull(aDataset,
						DicomTags.Units);

				if ((vRescaleType != null) && (vRescaleType.length() > 0)) {
					useUnits = vRescaleType;
				} else if (aSOPClassUID
						.equals(SOPClass.PositronEmissionTomographyImageStorage.getUID())
						&& (vUnits != null) && (vUnits.length() > 0)) {
					useUnits = vUnits;
				} else if (aSOPClassUID.equals(SOPClass.CTImageStorage.getUID())) {
					useUnits = "HU";
				}
				this.units = useUnits;
				// System.err.println("SingleRealWorldValueTransform: adding "+rangeOfValues[0]+","+rangeOfValues[1]+","+slope+","+intercept+" "+units);
			}
			fLogger.debug("SingleRealWorldValueTransform completed");
		}

		boolean isIdentityAndUnitsUnspecified() {
			return (this.fSlope == 1)
			&& (this.fIntercept == 0)
			&& ((this.units == null) || this.units.equals("US") || this.units
					.equals("??"));
		}
	}

	/***/
	@SuppressWarnings("unchecked")
	private class SingleRealWorldValueTransforms extends ArrayList {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
	}

	private static Logger fLogger = LoggerFactory
	.getLogger(RealWorldValueTransform.class);

	/***/
	private static final String identString = "@(#) $Header: /userland/cvs/pixelmed/imgbook/com/pixelmed/dicom/RealWorldValueTransform.java,v 1.10 2004/07/10 12:44:26 dclunie Exp $";

	/***/
	private SingleRealWorldValueTransforms[] arrayOfTransforms; // null if not
	// varying
	// per-frame, if
	// not null will
	// have size ==
	// number of
	// frames

	/***/
	private SingleRealWorldValueTransforms commonTransforms; // in which case this
	// will be used

	private final int maximumIntegerDigits = 8;

	private final int maximumMaximumFractionDigits = 6;

	private final int precisionToDisplayDouble = 4;

	/**
	 * @param aDataSet
	 *          the dataset of an image object to be searched for transformations
	 */
	public RealWorldValueTransform(DataSet aDataSet) {
		fLogger.debug("RealWorldValueTransform");
		// System.err.println("RealWorldValueTransform:");
		this.arrayOfTransforms = null;
		this.commonTransforms = null;
		String lSOPClassUID = DataElement.getSingleStringValueOrEmptyString(
				aDataSet, DicomTags.SOPClassUID);
		if (aDataSet.hasElement(DicomTags.PerFrameFunctionalGroupsSequence)) {
			fLogger.debug("has PerFrameFunctionalGroupsSequence");
			SequenceOfItems aPerFrameFunctionalGroupsSequence = aDataSet
			.getSequenceOfItems(DicomTags.PerFrameFunctionalGroupsSequence);
			int nFrames = aPerFrameFunctionalGroupsSequence.count();
			int frameNumber = 0;
			Iterator pfitems = aPerFrameFunctionalGroupsSequence.iterator();
			while (pfitems.hasNext()) {
				SequenceItems fitem = (SequenceItems) pfitems.next();
				DataSet flist = fitem.getDataSet();
				if (flist != null) {
					SequenceOfItems aRealWorldValueMappingSequence = (SequenceOfItems) flist
					.getElement(DicomTags.RealWorldValueMappingSeq);
					if ((aRealWorldValueMappingSequence != null)
							&& (aRealWorldValueMappingSequence.count() >= 1)) {
						fLogger
						.debug("RealWorldValueTransform: found RealWorldValueMappingSequence");
						if (this.arrayOfTransforms == null) {
							this.arrayOfTransforms = new SingleRealWorldValueTransforms[nFrames];
						}
						if (this.arrayOfTransforms[frameNumber] == null) {
							this.arrayOfTransforms[frameNumber] = new SingleRealWorldValueTransforms();
						}
						Iterator rwvmitems = aRealWorldValueMappingSequence.iterator();
						while (rwvmitems.hasNext()) {
							SequenceItems rwvmitem = (SequenceItems) rwvmitems.next();
							DataSet rwvmlist = rwvmitem.getDataSet();
							this.arrayOfTransforms[frameNumber]
							                       .add(new SingleRealWorldValueTransform(rwvmlist));
						}
					}
					SequenceOfItems aPixelValueTransformationSequence = (SequenceOfItems) flist
					.getElement(DicomTags.PixelValueTransformationSeq);
					if ((aPixelValueTransformationSequence != null)
							&& (aPixelValueTransformationSequence.count() >= 1)) {
						fLogger
						.debug("RealWorldValueTransform: found PixelValueTransformationSequence");
						if (this.arrayOfTransforms == null) {
							this.arrayOfTransforms = new SingleRealWorldValueTransforms[nFrames];
						}
						if (this.arrayOfTransforms[frameNumber] == null) {
							this.arrayOfTransforms[frameNumber] = new SingleRealWorldValueTransforms();
						}
						Iterator ptfitems = aPixelValueTransformationSequence.iterator();
						while (ptfitems.hasNext()) {
							SequenceItems ptfitem = (SequenceItems) ptfitems.next();
							DataSet ptflist = ptfitem.getDataSet();
							this.arrayOfTransforms[frameNumber]
							                       .add(new SingleRealWorldValueTransform(ptflist, lSOPClassUID));
						}
					}
				}
				++frameNumber;
			}
		}

		if (this.arrayOfTransforms == null) {
			// System.err.println("RealWorldValueTransform: checking SharedFunctionalGroupsSequence");
			SequenceOfItems aSharedFunctionalGroupsSequence = (SequenceOfItems) aDataSet
			.getElement(DicomTags.SharedFunctionalGroupsSequence);
			if (aSharedFunctionalGroupsSequence != null) {
				// assert aSharedFunctionalGroupsSequence.getNumberOfItems() == 1
				Iterator sitems = aSharedFunctionalGroupsSequence.iterator();
				if (sitems.hasNext()) {
					SequenceItems sitem = (SequenceItems) sitems.next();
					DataSet slist = sitem.getDataSet();
					if (slist != null) {
						SequenceOfItems aRealWorldValueMappingSequence = (SequenceOfItems) slist
						.getElement(DicomTags.RealWorldValueMappingSeq);
						if ((aRealWorldValueMappingSequence != null)
								&& (aRealWorldValueMappingSequence.count() >= 1)) {
							// System.err.println("RealWorldValueTransform: found RealWorldValueMappingSequence");
							if (this.commonTransforms == null) {
								this.commonTransforms = new SingleRealWorldValueTransforms();
							}
							Iterator rwvmitems = aRealWorldValueMappingSequence.iterator();
							while (rwvmitems.hasNext()) {
								SequenceItems rwvmitem = (SequenceItems) rwvmitems.next();
								DataSet rwvmlist = rwvmitem.getDataSet();
								this.commonTransforms.add(new SingleRealWorldValueTransform(
										rwvmlist));
							}
						}
						SequenceOfItems aPixelValueTransformationSequence = (SequenceOfItems) slist
						.getElement(DicomTags.PixelValueTransformationSeq);
						if ((aPixelValueTransformationSequence != null)
								&& (aPixelValueTransformationSequence.count() >= 1)) {
							// System.err.println("RealWorldValueTransform: found PixelValueTransformationSequence");
							if (this.commonTransforms == null) {
								this.commonTransforms = new SingleRealWorldValueTransforms();
							}
							Iterator ptfitems = aPixelValueTransformationSequence.iterator();
							while (ptfitems.hasNext()) {
								SequenceItems ptfitem = (SequenceItems) ptfitems.next();
								DataSet ptflist = ptfitem.getDataSet();
								SingleRealWorldValueTransform transform = new SingleRealWorldValueTransform(
										ptflist, lSOPClassUID);
								if (!transform.isIdentityAndUnitsUnspecified()) {
									this.commonTransforms.add(transform);
								}
							}
						}
					}
				}
			}

			// check for "old-fashioned" Modality LUT style attributes

			{
				DataElement aRescaleSlope = aDataSet.getElement(DicomTags.RescaleSlope);
				DataElement aRescaleIntercept = aDataSet
				.getElement(DicomTags.RescaleIntercept);

				if ((aRescaleSlope != null) && (aRescaleIntercept != null)) {
					if (this.commonTransforms == null) {
						this.commonTransforms = new SingleRealWorldValueTransforms();
					}
					SingleRealWorldValueTransform transform = new SingleRealWorldValueTransform(
							aDataSet, lSOPClassUID);
					if (!transform.isIdentityAndUnitsUnspecified()) {
						this.commonTransforms.add(transform);
					}
				}
			}
		}

		fLogger.debug("RealWorldValueTransform completed");
		// catch (DicomException e) {
		// e.printStackTrace(System.err);
		// }
	}

	/**
	 * Given a stored pixel value, return a string containing a description of all
	 * known real world values that can be derived from it.
	 * 
	 * @param frame
	 *          numbered from zero; needed to select which transform if
	 *          frame-specific
	 * @param storedValue
	 *          the actual stored pixel value to look up
	 */
	public String toString(int frame, int storedValue) {
		StringBuffer sbuf = new StringBuffer();
		SingleRealWorldValueTransforms useTransform = (this.arrayOfTransforms == null) ? this.commonTransforms
				: this.arrayOfTransforms[frame];
		if (useTransform != null) {
			Iterator i = useTransform.iterator();
			while (i.hasNext()) {
				SingleRealWorldValueTransform t = (SingleRealWorldValueTransform) i
				.next();
				if ((t.rangeOfValues == null)
						|| ((t.rangeOfValues[0] <= storedValue) && (storedValue <= t.rangeOfValues[1]))) {
					if (sbuf.length() > 0) {
						sbuf.append(", ");
					}
					double value = (storedValue) * t.fSlope + t.fIntercept;
					sbuf.append(FloatUtils.toString(value));
					sbuf.append(" ");
					sbuf.append(t.units);
				}
			}
		}
		return sbuf.toString();
	}
}
