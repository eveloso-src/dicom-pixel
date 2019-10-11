/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.images.transforms;

import java.util.ArrayList;
import java.util.Iterator;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.SequenceItems;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomTags;

/**
 * <p>
 * A transformation constructed from a DICOM attribute list that extracts those
 * attributes that define the VOI LUT transformation, specifically the window
 * center and width attributes.
 * </p>
 * 
 * <p>
 * Looks first for a per-frame functional group FrameVOILUTSequence then looks
 * in the shared functional groups, otherwise tries to find the Window Center
 * and Width values in the top level of the dataset.
 * </p>
 * 
 * <p>
 * Note that multiple transformations (for each frame) may be present and are
 * supported (specifically, Window Center and Width are multi-valued
 * attributes).
 * </p>
 * 
 * <p>
 * Does not currently support a LUT in the VOI LUT Sequence, only linear window
 * values.
 * </p>
 * 
 * @author dclunie
 */
public class VOITransform {

	/***/
	private class SingleVOITransform {

		/***/
		double center;

		/***/
		String explanation;

		/***/
		double width;

		/**
		 * @param center
		 * @param width
		 * @param explanation
		 */
		SingleVOITransform(double center, double width, String explanation) {
			this.center = center;
			this.width = width;
			this.explanation = explanation;
			// System.err.println("SingleVOITransform: adding "+center+","+width+" "+explanation);
		}

		/***/
		@Override
		public final String toString() {
			return this.center + "," + this.width + " " + this.explanation;
		}
	}

	/***/
	@SuppressWarnings("unchecked")
	private class SingleVOITransforms extends ArrayList {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		void add(DataSet list) {
			double centers[] = DataElement.getDoubleValues(list,
					DicomTags.WindowCenter);
			double widths[] = DataElement
			.getDoubleValues(list, DicomTags.WindowWidth);
			String explanations[] = DataElement.getStringValues(list,
					DicomTags.WindowCenterWidthExplanation);

			if ((centers != null) && (widths != null)) {
				int n = centers.length;
				if (widths.length < n) {
					n = widths.length; // should probably warn users :(
				}
				for (int i = 0; i < n; ++i) {
					this
					.add(new SingleVOITransform(
							centers[i],
							widths[i],
							(explanations != null) && (i < explanations.length) ? explanations[i]
							                                                                   : ""));
				}
			}
		}
	}

	/***/
	private static final String identString = "@(#) $Header: /userland/cvs/pixelmed/imgbook/com/pixelmed/dicom/VOITransform.java,v 1.8 2005/01/26 17:46:01 dclunie Exp $";

	/***/
	private SingleVOITransforms[] arrayOfTransforms; // null if not varying
	// per-frame, if not null
	// will have size == number
	// of frames

	/***/
	private SingleVOITransforms commonTransforms; // in which case this will be
	// used

	/**
	 * @param list
	 */
	public VOITransform(DataSet list) {
		// System.err.println("VOITransform:");
		this.arrayOfTransforms = null;
		this.commonTransforms = null;
		/* try */{
			SequenceOfItems aPerFrameFunctionalGroupsSequence = (SequenceOfItems) list
			.getElement(DicomTags.PerFrameFunctionalGroupsSequence);
			if (aPerFrameFunctionalGroupsSequence != null) {
				// System.err.println("VOITransform: checking PerFrameFunctionalGroupsSequence");
				int nFrames = aPerFrameFunctionalGroupsSequence.count();
				int frameNumber = 0;
				Iterator<?> pfitems = aPerFrameFunctionalGroupsSequence.iterator();
				while (pfitems.hasNext()) {
					SequenceItems fitem = (SequenceItems) pfitems.next();
					DataSet flist = fitem.getDataSet();
					if (flist != null) {
						SequenceOfItems aFrameVOILUTSequence = (SequenceOfItems) flist
						.getElement(DicomTags.FrameVOILUTSeq);
						if ((aFrameVOILUTSequence != null)
								&& (aFrameVOILUTSequence.count() >= 1)) {
							// System.err.println("VOITransform: found FrameVOILUTSequence");
							if (this.arrayOfTransforms == null) {
								this.arrayOfTransforms = new SingleVOITransforms[nFrames];
							}
							if (this.arrayOfTransforms[frameNumber] == null) {
								this.arrayOfTransforms[frameNumber] = new SingleVOITransforms();
							}
							Iterator<?> fvlitems = aFrameVOILUTSequence.iterator();
							while (fvlitems.hasNext()) {
								SequenceItems fvlitem = (SequenceItems) fvlitems.next();
								DataSet fvllist = fvlitem.getDataSet();
								// arrayOfTransforms[frameNumber].add(new
								// SingleVOITransform(fvllist));
								this.arrayOfTransforms[frameNumber].add(fvllist);
							}
						}
					}
					++frameNumber;
				}
			}

			if (this.arrayOfTransforms == null) {
				// System.err.println("VOITransform: checking SharedFunctionalGroupsSequence");
				SequenceOfItems aSharedFunctionalGroupsSequence = (SequenceOfItems) list
				.getElement(DicomTags.SharedFunctionalGroupsSequence);
				if (aSharedFunctionalGroupsSequence != null) {
					// assert aSharedFunctionalGroupsSequence.getNumberOfItems() == 1
					Iterator sitems = aSharedFunctionalGroupsSequence.iterator();
					if (sitems.hasNext()) {
						SequenceItems sitem = (SequenceItems) sitems.next();
						DataSet slist = sitem.getDataSet();
						if (slist != null) {
							SequenceOfItems aFrameVOILUTSequence = (SequenceOfItems) slist
							.getElement(DicomTags.FrameVOILUTSeq);
							if ((aFrameVOILUTSequence != null)
									&& (aFrameVOILUTSequence.count() >= 1)) {
								// System.err.println("VOITransform: found FrameVOILUTSequence");
								this.commonTransforms = new SingleVOITransforms();
								Iterator fvlitems = aFrameVOILUTSequence.iterator();
								while (fvlitems.hasNext()) {
									SequenceItems fvlitem = (SequenceItems) fvlitems.next();
									DataSet fvllist = fvlitem.getDataSet();
									// commonTransforms.add(new SingleVOITransform(fvllist));
									this.commonTransforms.add(fvllist);
								}
							}
						}
					}
				}

				// check for "old-fashioned" VOI LUT style attributes

				if ((list.getElement(DicomTags.WindowCenter) != null)
						&& (list.getElement(DicomTags.WindowWidth) != null)) {
					if (this.commonTransforms == null) {
						this.commonTransforms = new SingleVOITransforms();
					}
					this.commonTransforms.add(list);
				}
			}

		}
		// catch (DicomException e) {
		// e.printStackTrace(System.err);
		// }
		// System.err.println("VOITransform: is "+toString());
	}

	/**
	 * Get the window center of the particular transform available for a
	 * particular frame.
	 * 
	 * @param frame
	 *          numbered from zero; needed to select which transform if
	 *          frame-specific
	 * @param transform
	 *          numbered from zero; needed to select which transform if more than
	 *          one for that frame
	 * @return the window center, or 0 if none
	 */
	public double getCenter(int frame, int transform) {
		SingleVOITransforms useTransform = ((this.arrayOfTransforms == null) || (frame >= this.arrayOfTransforms.length)) ? this.commonTransforms
				: this.arrayOfTransforms[frame];
		SingleVOITransform singleTransform = (SingleVOITransform) (useTransform
				.get(transform));
		// System.err.println("VOITransform.getCenter(): from frame "+frame+" has singleTransform="+singleTransform);
		return singleTransform == null ? 0 : singleTransform.center;
	}

	/**
	 * Get the number of transforms available for a particular frame.
	 * 
	 * @param frame
	 *          numbered from zero; needed to select which transform if
	 *          frame-specific
	 * @return the number of transforms available for the frame, 0 if none
	 */
	public int getNumberOfTransforms(int frame) {
		SingleVOITransforms useTransform = ((this.arrayOfTransforms == null) || (frame >= this.arrayOfTransforms.length)) ? this.commonTransforms
				: this.arrayOfTransforms[frame];
		// System.err.println("VOITransform.getNumberOfTransforms(): from frame "+frame+" has useTransform="+useTransform);
		return useTransform == null ? 0 : useTransform.size();
	}

	/**
	 * Get the window width of the particular transform available for a particular
	 * frame.
	 * 
	 * @param frame
	 *          numbered from zero; needed to select which transform if
	 *          frame-specific
	 * @param transform
	 *          numbered from zero; needed to select which transform if more than
	 *          one for that frame
	 * @return the window width, or 0 if none
	 */
	public double getWidth(int frame, int transform) {
		SingleVOITransforms useTransform = ((this.arrayOfTransforms == null) || (frame >= this.arrayOfTransforms.length)) ? this.commonTransforms
				: this.arrayOfTransforms[frame];
		SingleVOITransform singleTransform = (SingleVOITransform) (useTransform
				.get(transform));
		return singleTransform == null ? 0 : singleTransform.width;
	}

	/***/
	@Override
	public final String toString() {
		StringBuffer strbuf = new StringBuffer();
		strbuf.append("Common = ");
		strbuf.append(this.commonTransforms == null ? "None"
				: this.commonTransforms.toString());
		strbuf.append("\n");
		if ((this.arrayOfTransforms == null)
				|| (this.arrayOfTransforms.length == 0)) {
			strbuf.append("Frames: None\n");
		} else {
			for (int i = 0; i < this.arrayOfTransforms.length; ++i) {
				strbuf.append("[");
				strbuf.append(Integer.toString(i));
				strbuf.append("] = ");
				strbuf.append(this.arrayOfTransforms[i] == null ? "None"
						: this.arrayOfTransforms[i].toString());
				strbuf.append("\n");
			}
		}
		return strbuf.toString();
	}
}
