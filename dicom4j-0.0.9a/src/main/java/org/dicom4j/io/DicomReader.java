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

package org.dicom4j.io;

import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.Raster;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Locale;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.event.IIOReadProgressListener;
import javax.imageio.spi.ImageReaderSpi;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.DataElementFactory;
import org.dicom4j.data.elements.OtherByteString;
import org.dicom4j.data.elements.OtherWordString;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.data.elements.UnsignedLong;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.dicom.ValueRepresentationFactory;
import org.dicom4j.dicom.dictionary.DicomDictionary;
import org.dicom4j.dicom.dictionary.EmbbedDicomDictionary;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to read a {@link DataSet} from a stream or bytes
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomReader {

	private class OurIIOReadProgressListener implements IIOReadProgressListener {
		public void imageComplete(ImageReader source) {
			System.out.println("OurIIOReadProgressListener:imageComplete()");
		}

		public void imageProgress(ImageReader source, float percentageDone) {
			System.out
			.println("OurIIOReadProgressListener:imageProgress(): percentageDone="
					+ percentageDone);
		}

		public void imageStarted(ImageReader source, int imageIndex) {
			System.out
			.println("OurIIOReadProgressListener:imageStarted(): imageIndex="
					+ imageIndex);
		}

		public void readAborted(ImageReader source) {
			System.out.println("OurIIOReadProgressListener:readAborted()");
		}

		public void sequenceComplete(ImageReader source) {
			System.out.println("OurIIOReadProgressListener:sequenceComplete()");
		}

		public void sequenceStarted(ImageReader source, int minIndex) {
			System.out
			.println("OurIIOReadProgressListener:sequenceStarted(): minIndex="
					+ minIndex);
		}

		public void thumbnailComplete(ImageReader source) {
			System.out.println("OurIIOReadProgressListener:thumbnailComplete()");
		}

		public void thumbnailProgress(ImageReader source, float percentageDone) {
			System.out
			.println("OurIIOReadProgressListener:thumbnailProgress(): percentageDone="
					+ percentageDone);
		}

		public void thumbnailStarted(ImageReader source, int imageIndex,
				int thumbnailIndex) {
			System.out
			.println("OurIIOReadProgressListener:thumbnailStarted(): imageIndex="
					+ imageIndex + " thumbnailIndex=" + thumbnailIndex);
		}
	}

	/**
	 * The Logger
	 */
	private static Logger logger = LoggerFactory.getLogger(DicomReader.class);

	/**
	 * The Dictionary
	 */
	private DicomDictionary dictionary = new EmbbedDicomDictionary();// Dicom4jImplementation.Instance().getDicomDictionary();;

	/**
	 * The avaibles TS
	 */
	// private final TransferSyntaxes fTransferSyntaxes =
	// Dicom4jImplementation.Instance().getTransferSyntaxes();
	private DataElementFactory elementFactory = new DataElementFactory();

	protected long fByteOffset = 0;

	/**
	 * The stream to read
	 */
	protected DicomInputStream fInputStream;

	private ValueRepresentationFactory vrFactory = new ValueRepresentationFactory();

	/**
	 * Creates a new DicomReader
	 * 
	 * @param aBytes
	 *          the bytes to read from
	 */
	public DicomReader(byte[] aBytes) {
		this(new ByteArrayInputStream(aBytes));
	}


	/**
	 * Creates a new DicomReader
	 * 
	 * @param aInputStream
	 *          the stream to read from
	 */
	public DicomReader(InputStream aInputStream) {
		super();
		logger.info("DicomReader");
		this.fInputStream = new DicomInputStream(new BufferedInputStream(
				aInputStream));
		assert this.fInputStream != null;
		assert this.elementFactory != null;
	}

	public void close() {
		logger.info("close");
		try {
			this.fInputStream.close();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
	}

	/**
	 * @since 0.0.6
	 * @return
	 */
	public DicomDictionary getDictionary() {
		return this.dictionary;
	}

	/**
	 * return the factory to create {@link DataElement}
	 * 
	 * @return the factory
	 */
	public DataElementFactory getElementFactory() {
		return this.elementFactory;
	}

	/**
	 * @return Returns the inputStream.
	 */
	protected DicomInputStream getStream() {
		return this.fInputStream;
	}

	/**
	 * return the factory to create {@link ValueRepresentation}
	 * 
	 * @return the factory
	 */
	public ValueRepresentationFactory getVrFactory() {
		return this.vrFactory;
	}

	/**
	 * @param i
	 * @param byteOffset
	 * @param lengthToRead
	 * @param stopAfterMetaInformationHeader
	 * @param specificCharacterSet
	 * @param aStopTag
	 *          the tag (in the top level data set) at which to stop
	 * @exception IOException
	 * @exception DicomException
	 */
	protected long read(DataSet aDataSet, long lengthToRead,
			boolean stopAfterMetaInformationHeader,
			SpecificCharacterSet specificCharacterSet, DicomTag aStopTag)
	throws IOException, DicomException, Exception {
		boolean undefinedLength = lengthToRead == 0xffffffffl;
		long endByteOffset = undefinedLength ? 0xffffffffl : this.fByteOffset
				+ lengthToRead - 1;
		logger.debug("read: stopAfterMetaInformationHeader("
				+ Boolean.toString(stopAfterMetaInformationHeader) + "), start Offset("
				+ this.fByteOffset + "), lengthToRead(" + lengthToRead + ")");
		logger.debug("undefinedLength: " + undefinedLength);
		logger.debug("endByteOffset: " + endByteOffset);
		logger.debug("fByteOffset: " + this.fByteOffset);
		// fLogger.info("read:
		// stopAfterMetaInformationHeader("+Boolean.toString(stopAfterMetaInformationHeader)+"),
		// TransferSyntax: " + fInputStream.getTransferSyntax().toString());

		byte vrBuffer[] = new byte[2];
		boolean lIsExplicit = this.fInputStream.getTransferSyntax().isExplicitVR();
		logger.debug("is explicit: " + Boolean.toString(lIsExplicit));

		// keep track of pixel data size in case need VL for encapsulated data ...
		int rows = 0;
		int columns = 0;
		int frames = 1;
		int samplesPerPixel = 1;
		int bytesPerSample = 0;

		DicomTag tag = null;
		try {
			// fLogger.info("byteOffset:" + byteOffset);
			// fLogger.info("endByteOffset:" + endByteOffset);
			while (undefinedLength || (this.fByteOffset < endByteOffset)) {
				// fLogger.info("byteOffset:" + byteOffset);
				// fLogger.info("endByteOffset:" + endByteOffset);
				tag = this.readDataElementTag();
				logger.debug("tag readed: " + tag.toString());
				// fLogger.info("byteOffset:" + byteOffset);
				if ((aStopTag != null) && tag.equals(aStopTag)) {
					logger.debug("stopped at tag" + tag.toString());
					return this.fByteOffset; // stop now, since we have reached the tag at
					// which we were told to stop
				}

				if (tag.equals(DicomTags.ItemDelimitationItem)) {
					logger.debug("read: ItemDelimitationItem");
					this.fInputStream.readUnsigned32(); // Read and discard value length
					this.fByteOffset += 4;
					return this.fByteOffset; // stop now, since we must have been called
					// to
					// read an item's dataset
				}

				if (tag.equals(DicomTags.Item)) {
					logger.warn("read: Item");
					// this is bad ... there shouldn't be Items here since they should
					// only be found during readNewSequenceAttribute()
					// however, try to work around Philips bug ...
					long vl = this.fInputStream.readUnsigned32(); // always implicit VR
					// form
					// for items and delimiters
					this.fByteOffset += 4;
					logger.warn("Ignoring bad Item at " + this.fByteOffset + " " + tag
							+ " VL=<0x" + Long.toHexString(vl) + ">");
					continue; // let's just ignore it for now
				}

				byte vr[];
				ValueRepresentation lVR = null;
				if (lIsExplicit) {
					// explicit, we read VR from the stream
					vr = this.fInputStream.readValueRepresentationAsBytes();
					/*if (this.fInputStream.read(vr, 0, 2) != 2) {
						throw new DicomException("VR read failed");
					}*/
					this.fByteOffset += 2;
				} else {
					// not explicit we must get the VR from the current Dictionary
					vr = null;
					DicomTag lTag = null;
					if (this.getDictionary() != null) {
						lTag = this.getDictionary().getTag(tag);
					}
					if (lTag != null) {
						logger.debug(lTag.getName());
						vr = lTag.getValueRepresentation().toBytes();
						lVR = lTag.getValueRepresentation();
						logger.debug(lVR.getName());
					}
					if (vr == null) {
						vr = vrBuffer;
						if (tag.isGroupLength()) {
							vr[0] = 'U';
							vr[1] = 'L';
						} else {
							vr[0] = 'U';
							vr[1] = 'N';
						}

					}
				}
				// fLogger.info("byteOffset:" + byteOffset);

				long vl;
				if (lIsExplicit) {
					if (ValueRepresentation.isShortValueLengthVR(vr)) {
						vl = this.fInputStream.readUnsigned16();
						this.fByteOffset += 2;
						// fLogger.info("vl:" + 2);
					} else {
						this.fInputStream.skip(2); // reserved bytes
						vl = this.fInputStream.readUnsigned32();
						this.fByteOffset += 6;
						// fLogger.info("vl:" + 6);
					}
				} else {
					vl = this.fInputStream.readUnsigned32();
					this.fByteOffset += 4;
					// fLogger.info("vl:" + 4);
				}
				// fLogger.info("byteOffset:" + byteOffset);

				// System.err.println(byteOffset+" "+tag+"
				// VR=<"+ValueRepresentation.getAsString(vr)+">
				// VL=<0x"+Long.toHexString(vl)+">");

				DataElement a = null;

				if (ValueRepresentation.isSequenceVR(vr)
						|| (ValueRepresentation.isUnknownVR(vr) && (vl == 0xffffffffl))) {
					a = new SequenceOfItems(tag);
					this.fByteOffset = this.readNewSequenceAttribute(a, vl,
							specificCharacterSet);
				} else if (vl != 0xffffffffl) {
					// if (vl > maximumSaneFixedValueLength) throw new
					// DicomException("unlikely fixed VL ("+vl+" dec,
					// 0x"+Long.toHexString(vl)+") - probably correct dataset");
					// logger.debug("get attribute for " + new ValueRepresentation(vr) + "
					// Value Representation" );
					ValueRepresentation valueRep = null;
					if (this.getVrFactory() != null) {
						valueRep = this.getVrFactory().newValueRepresentation(vr);
					} else {
						valueRep = new ValueRepresentation(vr);
					}
					a = this.getElementFactory().newElement(tag, valueRep, lIsExplicit, bytesPerSample);
					logger.debug("Element " + a.getName() + " to read (length: " + vl + ")");
					a.read(this.fInputStream, vl, specificCharacterSet);
					logger.debug("Element " + a.getName() + " readed (length:"
							+ a.getValueLength() + ")");
					this.fByteOffset += vl;
					// fLogger.info("byteOffset:" + byteOffset);
				}
				// assume encapsulated in case TS is not recognized
				else if ((vl == 0xffffffffl) && tag.equals(DicomTags.PixelData)) {
					// int wordsPerFrame = rows*columns*samplesPerPixel;
					String tsuid = this.fInputStream.getTransferSyntax().getUID();
					logger
					.error("Undefined length encapsulated Pixel Data: TransferSyntax UID "
							+ tsuid);
					String readerWanted = null;
					if (tsuid.equals(TransferSyntax.JPEGBaseline)
							|| tsuid.equals(TransferSyntax.JPEGExtended)) {
						readerWanted = "JPEG";
						logger
						.error("Undefined length encapsulated Pixel Data in JPEG Baseline");
					} else if (tsuid.equals(TransferSyntax.JPEG2000)
							|| tsuid.equals(TransferSyntax.JPEG2000Lossless)) {
						readerWanted = "JPEG2000";
						logger
						.error("Undefined length encapsulated Pixel Data in JPEG 2000");
					} else if (tsuid.equals(TransferSyntax.JPEGLossless)
							|| tsuid.equals(TransferSyntax.JPEGLosslessSV1)) {
						readerWanted = "jpeg-lossless";
						logger
						.error("Undefined length encapsulated Pixel Data in JPEG Lossless");
					} else if (tsuid.equals(TransferSyntax.JPEGLS)
							|| tsuid.equals(TransferSyntax.JPEGNLS)) {
						readerWanted = "jpeg-ls";
						logger
						.error("Undefined length encapsulated Pixel Data in JPEG-LS");
					}
					boolean doneReadingEncapsulatedData = false;
					EncapsulatedInputStream ei = new EncapsulatedInputStream(
							this.fInputStream);
					if (readerWanted != null) {
						Iterator<?> readers = ImageIO
						.getImageReadersByFormatName(readerWanted);
						if (readers.hasNext()) {
							ImageReader reader = (ImageReader) readers.next();
							ImageReaderSpi spi = reader.getOriginatingProvider();
							logger.error("Using reader from "
									+ spi.getDescription(Locale.US) + " " + spi.getVendorName()
									+ " " + spi.getVersion());
							reader.setInput(ImageIO.createImageInputStream(ei),
									true/* seekForwardOnly */, true/* ignoreMetadata */);
							OurIIOReadProgressListener progressListener = new OurIIOReadProgressListener();
							reader.addIIOReadProgressListener(progressListener);
							BufferedImage image = null;
							try {
								image = reader.read(0);
								doneReadingEncapsulatedData = true;
							} catch (Exception e) {
								logger.error(e.getMessage());
							}
							if (image == null) {
								logger.warn("Reader returned null image");
							} else {
								Raster raster = image.getData();
								int numDataElements = raster.getNumDataElements();
								if (numDataElements == samplesPerPixel) {
									int transferType = raster.getTransferType();
									if (transferType == DataBuffer.TYPE_BYTE) {
										System.out.println("Getting "
												+ (samplesPerPixel > 1 ? "interleaved " : "")
												+ samplesPerPixel + " channel byte data");
										byte[] vPixelData = (byte[]) raster.getDataElements(0, 0,
												columns, rows, null);
										System.out.println("Decompressed byte array length "
												+ vPixelData.length + " expected " + frames * rows
												* columns * samplesPerPixel);
										a = new OtherByteString(tag);
										a.setValues(vPixelData);
									} else if ((transferType == DataBuffer.TYPE_SHORT)
											|| (transferType == DataBuffer.TYPE_USHORT)) {
										System.out.println("Getting "
												+ (samplesPerPixel > 1 ? "interleaved " : "")
												+ samplesPerPixel + " channel byte data");
										short[] vPixelData = (short[]) raster.getDataElements(0, 0,
												columns, rows, null);
										System.out.println("Decompressed short array length "
												+ vPixelData.length + " expected " + frames * rows
												* columns * samplesPerPixel);
										a = new OtherWordString(tag);
										a.setValues(vPixelData);
									}
								}
							}
						} else {
							logger.warn("No reader for " + readerWanted + " available");
						}
					} else {
						logger.error("Unrecognized Transfer Syntax");
					}
					if (!doneReadingEncapsulatedData) {
						logger.warn("Skipping encapsulated pixel data");
						while (ei.skip(1024) > 0) {
							;
						}
					}

				}

				if (a != null) {
					// we add the attribute readed
					aDataSet.addElement(a);
					logger.info(a.getTag().toString());
					logger.info(a.toString());

					if (tag.equals(DicomTags.FileMetaInformationGroupLength)) {
						logger.info("Found meta-header");
						long metaLength = ((UnsignedLong) a).getValue(0);
						// fLogger.info("metaLength: " + metaLength);
						this.fByteOffset = this.read(aDataSet, metaLength,
								stopAfterMetaInformationHeader, null, aStopTag); // detects and
						// sets
						// transfer
						// syntax for
						// reading
						// dataset
						if (stopAfterMetaInformationHeader) {
							logger.info("Stopping after meta-header");
							break;
						} else {
							// System.err.println("Calling read");
							this.fByteOffset = this.read(aDataSet, 0xffffffffl, false, null,
									aStopTag); // read
							// to
							// end
							// (will
							// detect
							// and
							// set
							// own
							// SpecificCharacterSet)
							// System.err.println("Back from read after metaheader: now
							// undefinedLength="+undefinedLength+" byteOffset="+byteOffset+"
							// endByteOffset="+endByteOffset);
							break; // ... no plausible reason to continue past this point
						}
					}
					/*
					 * if (tag.equals(TagFromName.TransferSyntaxUID)) { // we change the
					 * transfert syntax i.setTransferSyntax(new
					 * TransferSyntax(a.getSingleStringValue
					 * (TransferSyntax.ExplicitVRLittleEndian.getUID()))); }
					 */
					else if (tag.equals(DicomTags.SpecificCharacterSet)) {
						specificCharacterSet = new SpecificCharacterSet(a.getStringValues());
					} else if (tag.equals(DicomTags.Columns)) {
						columns = a.getSingleIntegerValue(0);
					} else if (tag.equals(DicomTags.Rows)) {
						rows = a.getSingleIntegerValue(0);
					} else if (tag.equals(DicomTags.NumberOfFrames)) {
						frames = a.getSingleIntegerValue(1);
					} else if (tag.equals(DicomTags.SamplesPerPixel)) {
						samplesPerPixel = a.getSingleIntegerValue(1);
					} else if (tag.equals(DicomTags.BitsAllocated)) {
						bytesPerSample = (a.getSingleIntegerValue(16) - 1) / 8 + 1;
					}
				}
			}
		} catch (EOFException e) {
			if (!undefinedLength) {
				throw new EOFException(e.getMessage());
			}
		} catch (IOException e) {
			if (!undefinedLength) {
				throw new IOException(e.getMessage());
			}
		}
		return this.fByteOffset;
	}

	/**
	 * <p>
	 * Read all data from the stream
	 * </p>
	 * 
	 * @return the {@link DataSet} which contains read data
	 * @throws IOException
	 * @throws DicomException
	 */
	public void read(DataSet dataSet, TransferSyntax transferSyntax)
	throws IOException, DicomException, Exception {
		this.read(dataSet, transferSyntax, null);
	}

	/**
	 * <p>
	 * Read all data from the stream until the specified tag is encountered.
	 * </p>
	 * 
	 * @param i
	 *          the stream to read from
	 * @param aDataElementTag
	 *          the DataElementTag at which to stop
	 * @exception IOException
	 * @exception DicomException
	 */
	public void read(DataSet dataSet, TransferSyntax aTransferSyntax,
			DicomTag aDataElementTag) throws IOException, DicomException, Exception {
		if (aDataElementTag != null) {
			logger.info("Start reading (TransferSyntax: "
					+ aTransferSyntax.getName() + ", Stop Tag: "
					+ aDataElementTag.toString() + ")");
		} else {
			logger.info("Start reading (TransferSyntax: "
					+ aTransferSyntax.getName() + ", non stop tag)");
		}
		this.fInputStream.setTransferSyntax(aTransferSyntax);
		this.read(dataSet, 0xffffffffl, false, null, aDataElementTag);
		logger.info("Stop reading ( " + dataSet.count() + " element(s) readed )");
	}

	/**
	 * Read a DicomTag from a stream. If a {@link DicomDictionary} is available,
	 * the created Tag will be taken from the dictionary
	 * 
	 * @param aStream
	 *          the stream to read
	 * @return the DataElementTag read
	 * @throws IOException
	 */
	protected DicomTag readDataElementTag() throws IOException {
		assert this.fInputStream != null;
		int group = this.fInputStream.readUnsigned16();
		int element = this.fInputStream.readUnsigned16();
		this.fByteOffset += 4;
		DicomTag lAttribute = null;
		if (this.getDictionary() != null) {
			lAttribute = this.getDictionary().getTag(group, element);
		}
		if (lAttribute == null) {
			String lName = "Unknow";
			ValueRepresentation lVR = ValueRepresentation.Unknown;
			if (group % 2 != 0) {
				lName = "Private";
			}
			if (element == 0) {
				lName = "GroupLength";
				lVR = ValueRepresentation.UnsignedLong;
			}
			return new DicomTag(group, element, lName, lVR);
		} else {
			return lAttribute;
		}
	}

	/**
	 * @param element
	 * @param i
	 * @param byteOffset
	 * @param lengthToRead
	 * @param specificCharacterSet
	 * @exception IOException
	 * @exception DicomException
	 */
	protected long readNewSequenceAttribute(DataElement element,
			long lengthToRead, SpecificCharacterSet specificCharacterSet)
	throws IOException, DicomException, Exception {
		if (element == null) {
			throw new DicomException("readNewSequenceAttribute with null DataElement");
		}
		logger.info("readNewSequenceAttribute (Element: "
				+ element.getTag().getName() + ")");
		boolean undefinedLength = lengthToRead == 0xffffffffl;
		long endByteOffset = undefinedLength ? 0xffffffffl : this.fByteOffset
				+ lengthToRead - 1;
		try {
			// CBZip2InputStream.available() always returns zero, and since we
			// terminate
			// on exceptions anyway, just forget about it
			while (undefinedLength || (this.fByteOffset < endByteOffset)) {
				long itemStartOffset = this.fByteOffset;
				DicomTag tag = this.readDataElementTag();
				// fByteOffset+=4;
				long vl = this.fInputStream.readUnsigned32(); // always implicit VR form
				// for
				// items and delimiters
				this.fByteOffset += 4;
				if (tag.equals(DicomTags.SeqDelimitationItem)) {
					break;
				} else if (tag.equals(DicomTags.Item)) {
					DataSet list = new DataSet();
					this.fByteOffset = this.read(list, vl, false, specificCharacterSet,
							null);
					((SequenceOfItems) element).addItem(list, itemStartOffset);
				} else {
					throw new DicomException("Bad tag " + tag
							+ " (not Item or Sequence Delimiter) in Sequence at byte offset "
							+ this.fByteOffset);
				}
			}
		} catch (EOFException e) {
			if (!undefinedLength) {
				throw new EOFException();
			}
		} catch (IOException e) {
			if (!undefinedLength) {
				throw new IOException();
			}
		}
		if (element instanceof SequenceOfItems) {
			logger.debug("end of readNewSequenceAttribute ("
					+ ((SequenceOfItems) element).count() + " item(s) readed)");
		}
		return this.fByteOffset;
	}

	protected ValueRepresentation readValueRepresentation(DicomTag aTag)
	throws Exception {
		if (this.fInputStream.isExplicitVR()) {
			byte[] lvr = new byte[2];
			if (this.fInputStream.read(lvr, 0, 2) != 2) {
				throw new DicomException("VR read failed");
			}
			this.fByteOffset += 2;
			return ValueRepresentation.getValueRepresentation(lvr);
		} else {
			return aTag.getValueRepresentation();
		}
	}

	/**
	 * to set the {@link DicomDictionary} to used when reading a file. Null can be
	 * provided is no dictionary should be used
	 * 
	 * @since 0.0.6
	 * @param dictionary
	 */
	public void setDictionary(DicomDictionary dictionary) {
		this.dictionary = dictionary;
	}

	public InputStream setInputStream(InputStream stream) {
		this.fInputStream = new DicomInputStream(new BufferedInputStream(stream));
		return this.fInputStream;
	}

	public void setVrFactory(ValueRepresentationFactory vrFactory) {
		this.vrFactory = vrFactory;
	}

}
