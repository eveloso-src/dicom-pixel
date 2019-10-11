/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.images.transforms;

import java.util.Iterator;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.SequenceItems;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomTags;

/**
 * <p>
 * A transformation constructed from a DICOM attribute list that extracts those
 * attributes that define the Modality LUT transformation, specifically the
 * window center and width attributes.
 * </p>
 * 
 * <p>
 * Looks first for a per-frame functional group PixelValueTransformationSequence
 * then looks in the shared functional groups, otherwise tries to find the
 * Rescale Slope and Intercept values in the top level of the dataset.
 * </p>
 * <p>
 * Note that multiple transformations (for the same frames) are not permitted by
 * the standard.
 * </p>
 * 
 * <p>
 * Does not currently support a LUT in the Modality LUT Sequence, only linear
 * rescale values.
 * </p>
 * 
 * @author dclunie
 */
public class ModalityTransform {

	/***/
	private class SingleModalityTransform {

		/***/
		String explanation;

		/***/
		double intercept;

		/***/
		double slope;

		/**
		 * @param ptflist
		 */
		SingleModalityTransform(DataSet ptflist) {
			if (ptflist != null) {
				this.slope = DataElement.getSingleDoubleValueOrDefault(ptflist,
						DicomTags.RescaleSlope, 1.0);
				this.intercept = DataElement.getSingleDoubleValueOrDefault(ptflist,
						DicomTags.RescaleIntercept, 0.0);
				this.explanation = DataElement.getSingleStringValueOrEmptyString(
						ptflist, DicomTags.RescaleType);
				// System.err.println("SingleModalityTransform: adding "+slope+","+intercept+" "+explanation);
			}
		}
	}

	/***/
	private static final String identString = "@(#) $Header: /userland/cvs/pixelmed/imgbook/com/pixelmed/dicom/ModalityTransform.java,v 1.4 2003/10/12 14:29:01 dclunie Exp $";

	/***/
	private SingleModalityTransform[] arrayOfTransforms; // null if not varying
	// per-frame, if not
	// null will have size
	// == number of frames

	/***/
	private SingleModalityTransform commonTransforms; // in which case this will
	// be used

	/**
	 * @param aDataSet
	 *          the dataset of an image object to be searched for transformations
	 */
	public ModalityTransform(DataSet aDataSet) {
		// System.err.println("ModalityTransform:");
		this.arrayOfTransforms = null;
		this.commonTransforms = null;
		/* try */{
			SequenceOfItems aPerFrameFunctionalGroupsSequence = aDataSet
			.getSequenceOfItems(DicomTags.PerFrameFunctionalGroupsSequence);
			// (Sequence)aDataSet.getElement(TagFromName.PerFrameFunctionalGroupsSequence);
			if (aPerFrameFunctionalGroupsSequence != null) {
				// System.err.println("ModalityTransform: checking PerFrameFunctionalGroupsSequence");
				int nFrames = aPerFrameFunctionalGroupsSequence.count();
				int frameNumber = 0;
				Iterator pfitems = aPerFrameFunctionalGroupsSequence.iterator();
				while (pfitems.hasNext()) {
					SequenceItems fitem = (SequenceItems) pfitems.next();
					DataSet flist = fitem.getDataSet();
					if (flist != null) {
						SequenceOfItems aPixelValueTransformationSequence = (SequenceOfItems) flist
						.getElement(DicomTags.PixelValueTransformationSeq);
						if ((aPixelValueTransformationSequence != null)
								&& (aPixelValueTransformationSequence.count() >= 1)) {
							// System.err.println("ModalityTransform: found PixelValueTransformationSequence");
							if (this.arrayOfTransforms == null) {
								this.arrayOfTransforms = new SingleModalityTransform[nFrames];
							}
							if (this.arrayOfTransforms[frameNumber] == null) {
								this.arrayOfTransforms[frameNumber] = null;
							}
							Iterator ptfitems = aPixelValueTransformationSequence.iterator();
							while (ptfitems.hasNext()) {
								SequenceItems ptfitem = (SequenceItems) ptfitems.next();
								DataSet ptflist = ptfitem.getDataSet();
								this.arrayOfTransforms[frameNumber] = new SingleModalityTransform(
										ptflist);
							}
						}
					}
					++frameNumber;
				}
			}

			if (this.arrayOfTransforms == null) {
				// System.err.println("ModalityTransform: checking SharedFunctionalGroupsSequence");
				SequenceOfItems aSharedFunctionalGroupsSequence = (SequenceOfItems) aDataSet
				.getElement(DicomTags.SharedFunctionalGroupsSequence);
				if (aSharedFunctionalGroupsSequence != null) {
					// assert aSharedFunctionalGroupsSequence.getNumberOfItems() == 1
					Iterator sitems = aSharedFunctionalGroupsSequence.iterator();
					if (sitems.hasNext()) {
						SequenceItems sitem = (SequenceItems) sitems.next();
						DataSet slist = sitem.getDataSet();
						if (slist != null) {
							SequenceOfItems aPixelValueTransformationSequence = (SequenceOfItems) slist
							.getElement(DicomTags.PixelValueTransformationSeq);
							if ((aPixelValueTransformationSequence != null)
									&& (aPixelValueTransformationSequence.count() >= 1)) {
								// System.err.println("ModalityTransform: found PixelValueTransformationSequence");
								this.commonTransforms = null;
								Iterator ptfitems = aPixelValueTransformationSequence
								.iterator();
								while (ptfitems.hasNext()) {
									SequenceItems ptfitem = (SequenceItems) ptfitems.next();
									DataSet ptflist = ptfitem.getDataSet();
									this.commonTransforms = new SingleModalityTransform(ptflist);
								}
							}
						}
					}
				}

				// check for "old-fashioned" Modality LUT style attributes (only if
				// nothing per-frame was detected)

				if ((this.arrayOfTransforms == null) && (this.commonTransforms == null)) {
					this.commonTransforms = new SingleModalityTransform(aDataSet);
				}
			}

		}
	}

	/**
	 * Get the rescale intercept of the particular transform available for a
	 * particular frame.
	 * 
	 * @param frame
	 *          numbered from zero; needed to select which transform if
	 *          frame-specific
	 * @return the rescale intercept (0.0 if none available)
	 */
	public double getRescaleIntercept(int frame) {
		SingleModalityTransform useTransform = (this.arrayOfTransforms == null) ? this.commonTransforms
				: this.arrayOfTransforms[frame];
		return useTransform == null ? 0.0 : useTransform.intercept;
	}

	/**
	 * Get the rescale slope of the particular transform available for a
	 * particular frame.
	 * 
	 * @param frame
	 *          numbered from zero; needed to select which transform if
	 *          frame-specific
	 * @return the rescale slope (1.0 if none available)
	 */
	public double getRescaleSlope(int frame) {
		SingleModalityTransform useTransform = (this.arrayOfTransforms == null) ? this.commonTransforms
				: this.arrayOfTransforms[frame];
		return useTransform == null ? 1.0 : useTransform.slope;
	}

}
