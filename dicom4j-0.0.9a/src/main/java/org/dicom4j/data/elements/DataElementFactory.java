/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.data.elements;

import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.ValueRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory to create {@link DataElement DataElement}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class DataElementFactory {

	/**
	 * the logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DataElementFactory.class);

	public DataElementFactory() {
		super();
	}

	/**
	 * creates the DataElement for pixel Data (the VR depends of the
	 * BytesPerSample)
	 * 
	 * @param aTag
	 * @param aBytesPerSample
	 * @return
	 * @throws DicomException
	 */
	protected DataElement createPixelDataElement(DicomTag aTag,	int aBytesPerSample) throws DicomException {
		if (aBytesPerSample > 1) {
			logger.debug("newOtherWordString");
			return new OtherWordString(aTag);
		} else {
			logger.debug("newOtherByteString");
			return new OtherByteString(aTag);
		}
	}

	/**
	 * Create a new {@link DataElement DataElement}
	 * 
	 * @param tag
	 *          the Tag
	 * @param valueRepresentation
	 *          the VR
	 * @param aisExplicito
	 * @param aBytesPerSample
	 * @return the ctreated {@link DataElement DataElement}
	 * @throws DicomException
	 */
	public DataElement newElement(DicomTag tag, ValueRepresentation valueRepresentation, boolean aisExplicit, int aBytesPerSample) throws DicomException {
		assert tag != null;
		logger.debug("ValueRepresentation: " + valueRepresentation);
		if (tag == DicomTags.PixelData) {
			return this.createPixelDataElement(tag, aBytesPerSample);
		}

		try {
			if (valueRepresentation.equals(ValueRepresentation.ApplicationEntity)) {
				return new ApplicationEntity(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.AgeString)) {
				return new AgeString(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.AttributeTag)) {
				return new AttributeTag(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.CodeString)) {
				return new CodeString(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.Date)) {
				return new DateElement(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.DateTime)) {
				return new DateTime(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.DecimalString)) {
				return new DecimalString(tag);
			} else if (valueRepresentation
					.equals(ValueRepresentation.FloatingPointDouble)) {
				return new FloatingPointDouble(tag);
			} else if (valueRepresentation
					.equals(ValueRepresentation.FloatingPointSingle)) {
				return new FloatingPointSingle(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.IntegerString)) {
				return new IntegerString(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.LongString)) {
				return new LongString(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.LongText)) {
				return new LongText(tag);
			} else if (valueRepresentation
					.equals(ValueRepresentation.OtherByteString)) {
				// just in case was incorrectly encoded as explicit OB VR but with
				// bytesPerSample > 1 (Bits Allocated > 8)
				if ((aBytesPerSample > 1) && tag.equals(DicomTags.PixelData)) {
					logger.debug("newOtherWordString");
					return new OtherWordString(tag);
				} else {
					logger.debug("newOtherByteString");
					return new OtherByteString(tag);
				}
			} else if (valueRepresentation
					.equals(ValueRepresentation.OtherFloatString)) {
				logger.debug("newOtherFloatString");
				return new OtherFloatString(tag);
			} else if (valueRepresentation
					.equals(ValueRepresentation.OtherWordString)) {
				// This is not quite right ... in implicit VR, pixel data is always OW
				// theoretically,
				// but this saves later unpacking ... and works as long is implicit VR
				// is little endian
				if ((aBytesPerSample > 1) && tag.equals(DicomTags.PixelData)) {
					logger.debug("newOtherWordString");
					return new OtherWordString(tag);
				} else {
					logger.debug("newOtherByteString");
					return new OtherByteString(tag);
				}
			} else if (ValueRepresentation.isOtherUnspecifiedVR(valueRepresentation)) {
				if ((aBytesPerSample > 1) && tag.equals(DicomTags.PixelData)) {
					logger.debug("newOtherWordString");
					return new OtherWordString(tag);
				} else {
					logger.debug("OtherByteString");
					return new OtherByteString(tag);
				}
			} else if (valueRepresentation.equals(ValueRepresentation.PersonName)) {
				return new PersonName(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.ShortString)) {
				return new ShortString(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.SignedLong)) {
				return new SignedLong(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.SignedShort)) {
				return new SignedShort(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.ShortText)) {
				return new ShortText(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.Time)) {
				return new Time(tag);
			} else if (valueRepresentation
					.equals(ValueRepresentation.UniqueIdentifier)) {
				return new UniqueIdentifier(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.UnsignedLong)) {
				return new UnsignedLong(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.Unknown)) {
				logger.debug("newUnknown");
				return new Unknown(tag);
			} else if (valueRepresentation.equals(ValueRepresentation.UnsignedShort)) {
				return new UnsignedShort(tag);
			} else if (ValueRepresentation.isUnspecifiedShortVR(valueRepresentation)) {
				return new UnsignedShort(tag); // treat as unsigned for now ... should
				// choose on PixelRepresentation
			} else if (ValueRepresentation
					.isUnspecifiedShortOrOtherWordVR(valueRepresentation)) {
				return new UnsignedShort(tag); // treat as unsigned for now ... should
				// choose on PixelRepresentation
			} else if (valueRepresentation.equals(ValueRepresentation.UnlimitedText)) {
				return new UnlimitedText(tag);
			} else {
				// unrecognized but fixed length VR ... treat as UN ...
				logger.debug("newUnknown (unrecognized)");
				return new Unknown(tag);
			}
		} catch (Exception e) {
			throw new DicomException("Could not instantiate an attribute for " + tag
					+ ": " + e.getCause());
		}
	}

	;

}