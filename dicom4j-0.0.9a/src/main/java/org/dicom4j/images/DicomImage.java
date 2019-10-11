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

package org.dicom4j.images;

import java.util.ArrayList;
import java.util.List;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.images.transforms.ModalityTransform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Constains {@link DicomFrame DicomImage(s)} from a {@link DataSet DataSet}.
 * <p>
 * Frames (ie: Dicom Images) are read from ONLY ONE DataSet
 * 
 * @since Alpha 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomImage {

	private static Logger fLogger = LoggerFactory.getLogger(DicomImage.class);

	private int fBitsAllocated;

	private int fBitsStored;

	private DataSet fDataSet;

	private List<DicomFrame> fFrames;

	private int fHeight;

	/***/
	private int fImgMax;

	private int fImgMin;

	private boolean fIsByPlane;

	private boolean fisGrayscale;

	private boolean fIsInverted;

	private boolean fisPaletteColor;

	private boolean fIsSigned;

	private ModalityTransform fModalityTransform;

	private int fSamplesPerPixel;

	private int fWidth;

	public DicomImage(DataSet aDataSet) {
		this.fDataSet = aDataSet;
		this.readDataSet(aDataSet);
	}

	public DicomFrame addFrame(DicomFrame aImage) {
		this.fFrames.add(aImage);
		return aImage;
	}

	public int count() {
		return this.fFrames.size();
	}

	public int getBitsAllocated() {
		return this.fBitsAllocated;
	}

	public int getBitsStored() {
		return this.fBitsStored;
	}

	public DataSet getDataSet() {
		return this.fDataSet;
	}

	public DicomFrame getFrame(int aIndex) {
		return this.fFrames.get(aIndex);
	}

	public int getHeight() {
		return this.fHeight;
	}

	/***/
	public int getMaximum() {
		return this.fImgMax;
	}

	public int getMinimum() {
		return this.fImgMin;
	}

	public ModalityTransform getModalityTransform() {
		return this.fModalityTransform;
	}

	public int getSamplesPerPixel() {
		return this.fSamplesPerPixel;
	}

	public int getWidth() {
		return this.fWidth;
	}

	public boolean isByPlane() {
		return this.fIsByPlane;
	}

	public boolean isInverted() {
		return this.fIsInverted;
	}

	public boolean isSigned() {
		return this.fIsSigned;
	}

	protected void readDataSet(DataSet aDataSet) {
		this.setWidth(DataElement.getSingleIntegerValue(aDataSet,
				DicomTags.Columns, 0));
		this.setHeight(DataElement.getSingleIntegerValue(aDataSet, DicomTags.Rows,
				0));
		this.setBitsAllocated(DataElement.getSingleIntegerValue(aDataSet,
				DicomTags.BitsAllocated, 0));
		this.setBitsStored(DataElement.getSingleIntegerValue(aDataSet,
				DicomTags.BitsStored, this.fBitsAllocated));
		this.setSamples(DataElement.getSingleIntegerValue(aDataSet,
				DicomTags.SamplesPerPixel, 1));
		this
		.setisByPlane(((this.fSamplesPerPixel > 1) && (DataElement
				.getSingleIntegerValue(aDataSet, DicomTags.PlanarConfiguration, 0) == 1)));
		this.setisSigned(DataElement.getSingleIntegerValue(aDataSet,
				DicomTags.PixelRepresentation, 0) == 1);

		int lNumberOfFrames = DataElement.getSingleIntegerValue(aDataSet,
				DicomTags.NumberOfFrames, 1);
		fLogger.debug("NumberOfFrames: " + lNumberOfFrames);
		this.fFrames = new ArrayList<DicomFrame>(lNumberOfFrames);

		this.fModalityTransform = new ModalityTransform(aDataSet);
		// fLogger.debug("NumberOfFrames: " + fNumberOfFrames);
	}

	protected void readPhotometricInterpretation(DataSet aDataSet) {
		String vPhotometricInterpretation = DataElement
		.getSingleStringValueOrDefault(aDataSet,
				DicomTags.PhotometricInterpretation, "MONOCHROME2").trim();
		fLogger.info("PhotometricInterpretation: " + vPhotometricInterpretation);
		this.setIsInverted(vPhotometricInterpretation.equals("MONOCHROME1"));

		this.fisGrayscale = vPhotometricInterpretation.equals("MONOCHROME1")
		|| vPhotometricInterpretation.equals("MONOCHROME2");
		fLogger.debug("isGrayscale: " + this.fisGrayscale);
		this.fisPaletteColor = vPhotometricInterpretation
		.equals(DicomFrame.PHOTOMETRIC_INTERPRETATION_PALETTE_COLOR);
		fLogger.debug("isPaletteColor: " + this.fisPaletteColor);
	}

	public DicomFrame removeFrame(DicomFrame aImage) {
		if (this.fFrames.remove(aImage)) {
			return aImage;
		} else {
			return null;
		}
	}

	protected void setBitsAllocated(int aBitsAllocated) {
		this.fBitsAllocated = aBitsAllocated;
		fLogger.debug("setDepth: " + this.fBitsAllocated);
	}

	protected void setBitsStored(int aBitsStored) {
		this.fBitsStored = aBitsStored;
		fLogger.debug("setBitsStored: " + this.fBitsStored);
	}

	protected void setHeight(int aHeight) {
		this.fHeight = aHeight;
		fLogger.debug("setHeight: " + this.fHeight);
	}

	protected void setisByPlane(boolean aIsByPlane) {
		this.fIsByPlane = aIsByPlane;
		fLogger.debug("setisByPlane: " + Boolean.toString(this.fIsByPlane));
	}

	protected void setIsInverted(boolean aIsInverted) {
		this.fIsInverted = aIsInverted;
		fLogger.debug("setIsInverted: " + Boolean.toString(this.fIsInverted));
	}

	protected void setisSigned(boolean aIsSigned) {
		this.fIsSigned = aIsSigned;
		fLogger.debug("setisSigned: " + Boolean.toString(this.fIsSigned));
	}

	public void setMaximum(int aMaximum) {
		this.fImgMax = aMaximum;
		fLogger.debug("setMaximum: " + this.fImgMax);
	}

	public void setMinimum(int aMinimum) {
		this.fImgMin = aMinimum;
		fLogger.debug("setMinimum: " + this.fImgMin);
	}

	protected void setSamples(int aSamples) {
		this.fSamplesPerPixel = aSamples;
		fLogger.debug("setSamples: " + this.fSamplesPerPixel);
	}

	protected void setWidth(int aWidth) {
		this.fWidth = aWidth;
		fLogger.debug("setWidth: " + this.fWidth);
	}

}
