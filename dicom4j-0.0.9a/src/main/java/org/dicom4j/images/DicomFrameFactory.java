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

import java.awt.Point;
import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.ComponentColorModel;
import java.awt.image.ComponentSampleModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferUShort;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory to create {@link DicomFrame DicomImage}
 * 
 * @since Alpha 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomFrameFactory {

	private static Logger fLogger = LoggerFactory
	.getLogger(DicomFrameFactory.class);

	public DicomFrameFactory() {
		super();
	}

	public DicomFrame createBandInterleavedByteRGBImage(int w, int h,
			byte data[], int offset) {
		fLogger.info("createBandInterleavedByteRGBImage");
		ComponentColorModel cm = new ComponentColorModel(ColorSpace
				.getInstance(ColorSpace.CS_sRGB), new int[] { 8, 8, 8 }, false, // has
				// alpha
				false, // alpha premultipled
				Transparency.OPAQUE, DataBuffer.TYPE_BYTE);

		ComponentSampleModel sm = new ComponentSampleModel(DataBuffer.TYPE_BYTE, w,
				h, 1, w, new int[] { 0, w * h, w * h * 2 });

		DataBuffer buf = new DataBufferByte(data, w, offset);

		WritableRaster wr = Raster.createWritableRaster(sm, buf, new Point(0, 0));

		return new DicomFrame(cm, wr, true, null); // no properties hash table
	}

	public DicomFrame createByteGrayscaleImage(int w, int h, byte data[],
			int offset) {
		fLogger.info("createByteGrayscaleImage");
		ComponentColorModel cm = new ComponentColorModel(ColorSpace
				.getInstance(ColorSpace.CS_GRAY), new int[] { 8 }, false, // has alpha
				false, // alpha premultipled
				Transparency.OPAQUE, DataBuffer.TYPE_BYTE);

		ComponentSampleModel sm = new ComponentSampleModel(DataBuffer.TYPE_BYTE, w,
				h, 1, w, new int[] { 0 });

		DataBuffer buf = new DataBufferByte(data, w, offset);

		WritableRaster wr = Raster.createWritableRaster(sm, buf, new Point(0, 0));

		return new DicomFrame(cm, wr, true, null); // no properties hash table
	}

	public DicomFrame createPixelInterleavedByteRGBImage(int w, int h,
			byte data[], int offset) {
		fLogger.info("createPixelInterleavedByteRGBImage");
		ComponentColorModel cm = new ComponentColorModel(ColorSpace
				.getInstance(ColorSpace.CS_sRGB), new int[] { 8, 8, 8 }, false, // has
				// alpha
				false, // alpha premultipled
				Transparency.OPAQUE, DataBuffer.TYPE_BYTE);

		ComponentSampleModel sm = new ComponentSampleModel(DataBuffer.TYPE_BYTE, w,
				h, 3, w * 3, new int[] { 0, 1, 2 });

		DataBuffer buf = new DataBufferByte(data, w, offset);

		WritableRaster wr = Raster.createWritableRaster(sm, buf, new Point(0, 0));

		return new DicomFrame(cm, wr, true, null); // no properties hash table
	}

	public DicomFrame createSignedShortGrayscaleImage(int w, int h, short data[],
			int offset) {
		fLogger.info("createSignedShortGrayscaleImage");
		// System.err.println("createSignedShortGrayscaleImage");
		// DataBufferUShort and DataBuffer.TYPE_USHORT are used here,
		// otherwise lookup table operations for windowing fail;
		// concept of signedness is conveyed separately;
		// causes issues with JAI operations expecting signed shorts
		ComponentColorModel cm = new ComponentColorModel(ColorSpace
				.getInstance(ColorSpace.CS_GRAY), new int[] { 16 }, false, // has alpha
				false, // alpha premultipled
				Transparency.OPAQUE,
				/* DataBuffer.TYPE_SHORT */DataBuffer.TYPE_USHORT);

		ComponentSampleModel sm = new ComponentSampleModel(
				/* DataBuffer.TYPE_SHORT */DataBuffer.TYPE_USHORT, w, h, 1, w,
				new int[] { 0 });

		DataBuffer buf = new /* DataBufferShort */DataBufferUShort(data, w, offset);

		WritableRaster wr = Raster.createWritableRaster(sm, buf, new Point(0, 0));

		return new DicomFrame(cm, wr, true, null); // no properties hash table
	}

	public DicomFrame createUnsignedShortGrayscaleImage(int aWidth, int aHeight,
			short data[], int offset) {
		fLogger.info("createUnsignedShortGrayscaleImage (Width:" + aWidth
				+ ", Heigth:" + aHeight + ")");
		ComponentColorModel cm = new ComponentColorModel(ColorSpace
				.getInstance(ColorSpace.CS_GRAY), new int[] { 16 }, false, // has alpha
				false, // alpha premultipled
				Transparency.OPAQUE, DataBuffer.TYPE_USHORT);
		fLogger.debug("ComponentColorModel created");

		ComponentSampleModel sm = new ComponentSampleModel(DataBuffer.TYPE_USHORT,
				aWidth, aHeight, 1, aWidth, new int[] { 0 });
		fLogger.debug("ComponentSampleModel created");

		DataBuffer buf = new DataBufferUShort(data, aWidth, offset);
		fLogger.debug("DataBuffer created");

		WritableRaster wr = Raster.createWritableRaster(sm, buf, new Point(0, 0));
		fLogger.debug("WritableRaster created");

		DicomFrame lFrame = new DicomFrame(cm, wr, true, null);
		fLogger.debug("DicomFrame created");

		fLogger.info("createUnsignedShortGrayscaleImage completed");
		return lFrame;
	}
}
