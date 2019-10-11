/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.images;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.images.transforms.ModalityTransform;
import org.dicom4j.images.transforms.RealWorldValueTransform;
import org.dicom4j.images.transforms.VOITransform;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * A class that encapsulates the pixel data and features and values from an
 * image source (such as a DICOM image), usually for the purpose of displaying
 * it.
 * </p>
 * 
 * l
 * 
 * @since Alpha 0.0.0
 * @author dclunie
 */
public class DicomImageReader {

	private static DicomFrameFactory fFactory = new DicomFrameFactory();

	private static Logger fLogger = LoggerFactory
	.getLogger(DicomImageReader.class);

	public static DicomImage createDicomFrames(DataSet aDataSet)
	throws DicomImageReaderException, DicomException {
		fLogger.debug("createDicomFrames");
		DicomImageReader lReader = new DicomImageReader();
		DicomImage lImage = lReader.read(aDataSet);
		fLogger.debug("createDicomFrames completed");
		return lImage;
	}

	/***/
	private int bitsPerEntry;

	/***/
	private short blueTable[];

	/***/
	private int firstValueMapped;

	/***/
	private short greenTable[];

	/***/
	int imgMax;

	/***/
	double imgMean;

	/***/
	int imgMin;

	/***/
	double imgStandardDeviation;

	/***/
	boolean inverted;

	/***/
	boolean isGrayscale;

	/***/
	boolean isPaletteColor;

	// stuff for (supplemental) palette color LUT
	/***/
	private int largestGray;

	/***/
	boolean lIsSigned;

	/***/
	private ModalityTransform modalityTransform;

	/***/
	private int numberOfEntries;

	/***/
	private RealWorldValueTransform realWorldValueTransform;

	/***/
	private short redTable[];

	/***/

	/**
	 * Retrun the first Image
	 */
	/*****************************************************************************
	 * public BufferedImage getBufferedImage() { return fImages[0]; } /
	 ****************************************************************************/
	/*
	 * public BufferedImage[] getBufferedImages() { return fImages; }
	 */
	/***/
	// public int getWidth() { return fColumns; }
	/***/
	// public int getHeight() { return height; }
	/***/
	private VOITransform voiTransform;

	/**
	 * Creates a new reader
	 * 
	 */
	public DicomImageReader() {

	}

	/***/
	public int getMaximum() {
		return this.imgMax;
	}

	// public double getMean() { return imgMean; }

	// public double getStandardDeviation() { return imgStandardDeviation; }

	/***/
	public int getMinimum() {
		return this.imgMin;
	}

	/***/
	public ModalityTransform getModalityTransform() {
		return this.modalityTransform;
	}

	/***/
	public int getPaletteColorBitsPerEntry() {
		return this.bitsPerEntry;
	}

	/***/
	// public int getNumberOfFrames() { return lNumberOfFrames; }
	/***/
	public short[] getPaletteColorBlueTable() {
		return this.blueTable;
	}

	/***/
	public int getPaletteColorFirstValueMapped() {
		return this.firstValueMapped;
	}

	/***/
	public short[] getPaletteColorGreenTable() {
		return this.greenTable;
	}

	/***/
	public int getPaletteColorLargestGray() {
		return this.largestGray;
	}

	/***/
	public int getPaletteColorNumberOfEntries() {
		return this.numberOfEntries;
	}

	/***/
	public short[] getPaletteColorRedTable() {
		return this.redTable;
	}

	/***/
	public RealWorldValueTransform getRealWorldValueTransform() {
		return this.realWorldValueTransform;
	}

	/***/
	public VOITransform getVOITransform() {
		return this.voiTransform;
	}

	/***/
	public boolean isGrayscale() {
		return this.isGrayscale;
	}

	/***/
	public boolean isInverted() {
		return this.inverted;
	}

	// private int fColumns;

	// private DicomImage[] fImages;

	/***/
	public boolean isSigned() {
		return this.lIsSigned;
	}

	/**
	 * Creates images from a DataSet
	 * 
	 * @param aDataSet
	 * @return
	 * @throws DicomImageReaderException
	 */
	public DicomImage read(DataSet aDataSet) throws DicomImageReaderException,
	DicomException {
		fLogger.info("read: " + aDataSet.count() + " element(s) to read");
		if (aDataSet == null) {
			throw new DicomImageReaderException("read (aDataSet==null)");
		}
		if (aDataSet.getElement(DicomTags.PixelData) == null) {
			throw new DicomImageReaderException(
			"the DataSet doesn't contains Pixel Data");
		}
		DicomImage lFrames = new DicomImage(aDataSet);

		/*
		 * lImages.setWidth( DataElement.getSingleIntegerValue(aDataSet,
		 * DicomTags.Columns, 0) ); fLogger.debug("Columns: " + lImages.getWidth()
		 * ); lImages.setHeight(
		 * aDataSet.getElement(DicomTags.Rows).getSingleIntegerValue(0) );
		 * fLogger.debug("Rows: " + height); int depth =
		 * aDataSet.getElement(DicomTags.BitsAllocated).getSingleIntegerValue(0);
		 * fLogger.debug("BitsAllocated: " + depth); int samples =
		 * DataElement.getSingleIntegerValueOrDefault
		 * (aDataSet,TagFromName.SamplesPerPixel,1);
		 * fLogger.debug("SamplesPerPixel: " + samples); boolean lIsByPlane =
		 * (samples > 1 &&
		 * DataElement.getSingleIntegerValueOrDefault(aDataSet,TagFromName
		 * .PlanarConfiguration,0) == 1); fLogger.debug("IsByPlane: " + lIsByPlane);
		 */
		int lNumberOfFrames = DataElement.getSingleIntegerValueOrDefault(aDataSet,
				DicomTags.NumberOfFrames, 1);
		fLogger.debug("NumberOfFrames: " + lNumberOfFrames);

		// fImages=new DicomImage[fNumberOfFrames];

		int mask = 0;
		int extend = 0;
		int signbit = 1;
		{
			int stored = lFrames.getBitsStored(); // DataElement.getSingleIntegerValueOrDefault(aDataSet,TagFromName.BitsStored,
			// depth);
			while (stored-- > 0) {
				mask = mask << 1 | 1;
				signbit = signbit << 1;
			}
			signbit = signbit >> 1;
				extend = ~mask;
		}
		// System.err.println("mask=0x"+Integer.toHexString(mask));
		// System.err.println("extend=0x"+Integer.toHexString(extend));
		// System.err.println("signbit=0x"+Integer.toHexString(signbit));

		boolean lIsSigned = lFrames.isSigned(); // DataElement.getSingleIntegerValueOrDefault(aDataSet,TagFromName.PixelRepresentation,0)
		// == 1;

		this.imgMin = lIsSigned ? 0x00007fff : 0x0000ffff; // i.e. start with the
		// largest
		// possible 16 bit +ve value,
		// sign extended to the full
		// Java int 32 bits
		this.imgMax = lIsSigned ? 0xffff8000 : 0x00000000; // i.e. start with the
		// smallest possible 16 bit
		// -ve value, sign extended to
		// the full Java int 32 bits

		// System.err.println("signed="+signed);

		int pad = 0;
		boolean hasPad = false;
		DataElement aPixelPaddingValue = aDataSet
		.getElement(DicomTags.PixelPaddingValue);
		if (aPixelPaddingValue != null) {
			hasPad = true;
			pad = aPixelPaddingValue.getSingleIntegerValue(0);
		}
		// System.err.println("hasPad="+hasPad);
		// System.err.println("pad="+pad);

		String vPhotometricInterpretation = DataElement
		.getSingleStringValueOrDefault(aDataSet,
				DicomTags.PhotometricInterpretation, "MONOCHROME2").trim();
		fLogger.info("PhotometricInterpretation: " + vPhotometricInterpretation);
		this.inverted = vPhotometricInterpretation.equals("MONOCHROME1");
		fLogger.debug("inverted: " + this.inverted);

		this.isGrayscale = vPhotometricInterpretation.equals("MONOCHROME1")
		|| vPhotometricInterpretation.equals("MONOCHROME2");
		fLogger.debug("isGrayscale: " + this.isGrayscale);
		this.isPaletteColor = vPhotometricInterpretation.equals("PALETTE COLOR");
		fLogger.debug("isPaletteColor: " + this.isPaletteColor);

		// Get palette color LUT stuff, if present ...

		DataElement aLargestMonochromePixelValue = aDataSet
		.getElement(DicomTags.LargestMonochromePixelValue);
		DataElement aRedPaletteColorLookupTableDescriptor = aDataSet
		.getElement(DicomTags.RedPaletteColorLUTDescriptor);
		DataElement aGreenPaletteColorLookupTableDescriptor = aDataSet
		.getElement(DicomTags.GreenPaletteColorLUTDescriptor);
		DataElement aBluePaletteColorLookupTableDescriptor = aDataSet
		.getElement(DicomTags.BluePaletteColorLUTDescriptor);

		this.largestGray = lIsSigned ? 0x00007fff : 0x0000ffff; // default to
		// largest
		// possible in case
		// nothing found
		boolean usedLargestMonochromePixelValue = false;
		if ((aLargestMonochromePixelValue != null)
				&& (aLargestMonochromePixelValue.getValueMultiplicity() == 1)) {
			usedLargestMonochromePixelValue = true;
			this.largestGray = aLargestMonochromePixelValue.getIntegerValues()[0];
		}
		boolean usedLargestImagePixelValue = false;
		if (usedLargestMonochromePixelValue == false) { // encountered this in an
			// old MR SOP Class Siemens
			// MR image
			DataElement aLargestImagePixelValue = aDataSet
			.getElement(DicomTags.LargestImagePixelValue);
			if ((aLargestImagePixelValue != null)
					&& (aLargestImagePixelValue.getValueMultiplicity() == 1)) {
				usedLargestImagePixelValue = true;
				this.largestGray = aLargestImagePixelValue.getIntegerValues()[0];
			}
		}

		// boolean usedFirstValueMapped=false;
		if ((aRedPaletteColorLookupTableDescriptor != null)
				&& (aGreenPaletteColorLookupTableDescriptor != null)
				&& (aBluePaletteColorLookupTableDescriptor != null)) {
			// the descriptors should all be the same; should check but let's be lazy
			// and just use one ...
			if ((aRedPaletteColorLookupTableDescriptor != null)
					&& (aRedPaletteColorLookupTableDescriptor.getValueMultiplicity() == 3)) {
				this.numberOfEntries = aRedPaletteColorLookupTableDescriptor
				.getIntegerValues()[0];
				if (this.numberOfEntries == 0) {
					this.numberOfEntries = 65536;
				}
				this.firstValueMapped = aRedPaletteColorLookupTableDescriptor
				.getIntegerValues()[1];
				if (((usedLargestMonochromePixelValue == false) && (usedLargestImagePixelValue == false))
						|| aDataSet.getElement(DicomTags.PhotometricInterpretation)
						.getStringValues()[0].equals("PALETTE COLOR")) { // [bugs.mrmf]
					// (000102)
					// Palette
					// Color image
					// displays as
					// gray when
					// Largest
					// Pixel Value
					// present
					// boolean usedFirstValueMapped=true;
					this.largestGray = this.firstValueMapped - 1; // if a pure color image
					// then
					// firstValueMapped will be 0, and
					// largestGray will be -1
				}
				this.bitsPerEntry = aRedPaletteColorLookupTableDescriptor
				.getIntegerValues()[2];
				DataElement aRedPaletteColorLookupTableData = aDataSet
				.getElement(DicomTags.RedPaletteColorLUTData);
				DataElement aGreenPaletteColorLookupTableData = aDataSet
				.getElement(DicomTags.GreenPaletteColorLUTData);
				DataElement aBluePaletteColorLookupTableData = aDataSet
				.getElement(DicomTags.BluePaletteColorLUTData);
				if ((aRedPaletteColorLookupTableData != null)
						&& (aGreenPaletteColorLookupTableData != null)
						&& (aBluePaletteColorLookupTableData != null)) {
					this.redTable = aRedPaletteColorLookupTableData.getShortValues();
					this.greenTable = aGreenPaletteColorLookupTableData.getShortValues();
					this.blueTable = aBluePaletteColorLookupTableData.getShortValues();
				}
			}
		}
		fLogger.debug("largestGray=" + this.largestGray);

		int nframepixels = lFrames.getWidth() * lFrames.getHeight();
		fLogger.debug("nframepixels: " + nframepixels);
		int nframesamples = nframepixels * lFrames.getSamplesPerPixel();
		int nsamples = nframesamples * lNumberOfFrames;

		if ((this.isGrayscale || this.isPaletteColor)
				&& (lFrames.getSamplesPerPixel() == 1)
				&& (lFrames.getBitsAllocated() > 8)) {
			fLogger
			.debug("SourceImage.constructSourceImage(): grayscale or palette color > 8 bits");
			DataElement a = aDataSet.getElement(DicomTags.PixelData);
			short data[] = a.getShortValues();
			if (lIsSigned) {
				// boolean dopad = hasPad && pad != 0; // ignore pad if it is zero and
				// image is signed, e.g. GE MR image pretending to be signed
				for (int count = 0; count < nsamples; ++count) {
					int value = data[count] & mask;
					if ((value & signbit) != 0) {
						value = value | extend;
					}
					// if (dopad && (value == pad || value == -32767)) { // include old GE
					// CT bug (0x8001 pad)
					// value=0x8000; // otherwise surround not less than -ve pixel values
					// }
					data[count] = (short) value;
					// if (value > imgMax) imgMax=value;
					if ((value > this.imgMax) && (value <= this.largestGray/*
					 * && (!hasPad
					 * || value !=
					 * pad)
					 */)) {
						this.imgMax = value;
					}
					if (value < this.imgMin/* && (!hasPad || value != pad) */) {
						this.imgMin = value;
						// imgSum+=value;
						// imgSumOfSquares+=value*value;
					}
				}
				int offset = 0;
				for (int frame = 0; frame < lNumberOfFrames; ++frame) {
					lFrames.addFrame(fFactory.createSignedShortGrayscaleImage(lFrames
							.getWidth(), lFrames.getHeight(), data, offset));
					offset += nframesamples;
				}
			} else {
				for (int count = 0; count < nsamples; ++count) {
					int value = data[count] & mask;
					if (hasPad && (value == pad)) {
						value = 0;
					}
					data[count] = (short) value;
					// if (value > imgMax) imgMax=value;
					if ((value > this.imgMax) && (value <= this.largestGray/*
					 * && (!hasPad
					 * || value !=
					 * pad)
					 */)) {
						this.imgMax = value;
					}
					if (value < this.imgMin/* && (!hasPad || value != pad) */) {
						this.imgMin = value;
						// imgSum+=value;
						// imgSumOfSquares+=value*value;
					}
				}
				int offset = 0;
				for (int frame = 0; frame < lNumberOfFrames; ++frame) {
					lFrames.addFrame(fFactory.createUnsignedShortGrayscaleImage(lFrames
							.getWidth(), lFrames.getHeight(), data, offset));
					offset += nframesamples;
				}
			}
		} else if ((this.isGrayscale || this.isPaletteColor)
				&& (lFrames.getSamplesPerPixel() == 1)
				&& (lFrames.getBitsAllocated() <= 8)) {
			fLogger
			.debug("SourceImage.constructSourceImage(): grayscale or palette color <= 8 bits");
			byte data[] = null;
			DataElement a = aDataSet.getElement(DicomTags.PixelData);
			if (ValueRepresentation.isOtherByteVR(a.getValueRepresentation()
					.toBytes())) {
				byte[] sdata = a.getByteValues();
				// GUIUtils.showWarning(null, "" + nsamples); //442368
				data = new byte[nsamples];
				for (int count = 0; count < nsamples; ++count) {
					int value = sdata[count] & mask;
					// fLogger.debug("value masked = "+Integer.toHexString(value));
					if (lIsSigned && ((value & signbit) != 0)) {
						value = value | extend;
					}
					// fLogger.debug(" extended = "+Integer.toHexString(value));
					if (hasPad && (value == pad)) {
						value = 0;
					}
					data[count] = (byte) value;
					// if (value > imgMax) imgMax=value;
					if ((value > this.imgMax) && (value <= this.largestGray)) {
						this.imgMax = value;
					}
					if (value < this.imgMin) {
						this.imgMin = value;
						// imgSum+=value;
						// imgSumOfSquares+=value*value;
					}
				}
			} else {
				short sdata[] = a.getShortValues();
				data = new byte[nsamples];
				int slen = nsamples / 2;
				int scount = 0;
				int count = 0;
				while (scount < slen) {
					int value = sdata[scount++] & 0xffff; // the endianness of the TS has
					// already been accounted for
					int value1 = value & mask; // now just unpack from low part of word
					// first
					if (lIsSigned && ((value1 & signbit) != 0)) {
						value1 = value1 | extend;
					}
					if (hasPad && (value1 == pad)) {
						value1 = 0;
					}
					data[count++] = (byte) value1;
					// if (value1 > imgMax) imgMax=value1;
					if ((value1 > this.imgMax) && (value1 <= this.largestGray)) {
						this.imgMax = value1;
					}
					if (value1 < this.imgMin) {
						this.imgMin = value1;
						// imgSum+=value1;
						// imgSumOfSquares+=value1*value1;
					}

					int value2 = value >> 8 & mask;
					if (lIsSigned && ((value2 & signbit) != 0)) {
						value2 = value2 | extend;
					}
					if (hasPad && (value2 == pad)) {
						value2 = 0;
					}
					data[count++] = (byte) value2;
					// if (value2 > imgMax) imgMax=value2;
					if ((value2 > this.imgMax) && (value2 <= this.largestGray)) {
						this.imgMax = value2;
					}
					if (value2 < this.imgMin) {
						this.imgMin = value2;
						// imgSum+=value2;
						// imgSumOfSquares+=value2*value2;
					}
				}
			}
			int offset = 0;
			for (int frame = 0; frame < lNumberOfFrames; ++frame) {
				lFrames.addFrame(fFactory.createByteGrayscaleImage(lFrames.getWidth(),
						lFrames.getHeight(), data, offset));
				offset += nframesamples;
			}
		} else if (!this.isGrayscale && (lFrames.getSamplesPerPixel() == 3)
				&& (lFrames.getBitsAllocated() <= 8)) {
			fLogger
			.debug("SourceImage.constructSourceImage(): not grayscale, is 3 channel and <= 8 bits");
			byte data[] = null;
			DataElement a = aDataSet.getElement(DicomTags.PixelData);
			if (ValueRepresentation.isOtherByteVR(a.getValueRepresentation()
					.toBytes())) {
				data = a.getByteValues();
			} else {
				short sdata[] = a.getShortValues();
				data = new byte[nsamples];
				int slen = nsamples / 2;
				int scount = 0;
				int count = 0;
				while (scount < slen) {
					int value = sdata[scount++] & 0xffff; // the endianness of the TS has
					// already been accounted for
					int value1 = value & 0xff; // now just unpack from low part of word
					// first
					data[count++] = (byte) value1;
					int value2 = value >> 8 & 0xff;
				data[count++] = (byte) value2;
				}
			}
			int offset = 0;
			for (int frame = 0; frame < lNumberOfFrames; ++frame) {
				if (lFrames.isByPlane()) {
					lFrames.addFrame(fFactory.createBandInterleavedByteRGBImage(lFrames
							.getWidth(), lFrames.getHeight(), data, offset));
				} else {
					lFrames.addFrame(fFactory.createPixelInterleavedByteRGBImage(lFrames
							.getWidth(), lFrames.getHeight(), data, offset));
				}
				offset += nframesamples;
			}
		} else {
			throw new DicomImageReaderException(
					"Unsupported image photometric interpretation \""
					+ vPhotometricInterpretation + "\" or bit depth "
					+ lFrames.getBitsAllocated());
		}

		fLogger.debug("try to create RealWorldValueTransform");
		this.realWorldValueTransform = new RealWorldValueTransform(aDataSet);
		fLogger.debug("try to create ModalityTransform");
		this.modalityTransform = new ModalityTransform(aDataSet);
		fLogger.debug("try to create VOITransform");
		this.voiTransform = new VOITransform(aDataSet);

		// System.out.println(imgMin + " - " + imgMax);
		lFrames.setMinimum(this.imgMin);
		lFrames.setMaximum(this.imgMax);
		return lFrames;
		// System.err.println("constructSourceImage - end");
	}

}
