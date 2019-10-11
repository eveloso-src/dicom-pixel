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

package org.dicom4j.data.elements.support;

import java.io.IOException;
import java.text.NumberFormat;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.DataElementFactory;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * abstract class that contains the core functionality for storing, accessing
 * and maintaining values of a DICOM Attribute.
 * </p>
 * 
 * <p>
 * Though instances of concrete sub-classes of this abstract class may be
 * created using their constructors, there is also a factory class,
 * {@link DataElementFactory}.
 * </p>
 * 
 * @see org.dicom4j.data.elements.DataElementFactory
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public abstract class DataElement {

	/**
	 * The Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DataElement.class);

	/**
	 * <p>
	 * Get all the string values for a named attribute in an attribute list,
	 * separated by the appropriate delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, the supplied default
	 * is returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param dflt
	 *          what to return if there are no (valid) string values
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public static String getDelimitedStringValuesOrDefault(DataSet list,
			DicomTag tag, String dflt) {
		String value = dflt;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				value = a.getDelimitedStringValues(dflt);
			}
		}
		return value;
	}

	/**
	 * <p>
	 * Get all the string values for a named attribute in an attribute list,
	 * separated by the appropriate delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, the supplied default
	 * is returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param dflt
	 *          what to return if there are no (valid) string values
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public static String getDelimitedStringValuesOrDefault(DataSet list,
			DicomTag tag, String dflt, NumberFormat format) {
		String value = dflt;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				value = a.getDelimitedStringValuesOrDefault(dflt, format);
			}
		}
		return value;
	}

	/**
	 * <p>
	 * Get all the string values for a named attribute in an attribute list,
	 * separated by the appropriate delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, an empty string is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public static String getDelimitedStringValuesOrEmptyString(DataSet list,
			DicomTag tag) {
		return getDelimitedStringValuesOrDefault(list, tag, "");
	}

	/**
	 * <p>
	 * Get all the string values for a named attribute in an attribute list,
	 * separated by the appropriate delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, an empty string is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public static String getDelimitedStringValuesOrEmptyString(DataSet list,
			DicomTag tag, NumberFormat format) {
		return getDelimitedStringValuesOrDefault(list, tag, "", format);
	}

	/**
	 * <p>
	 * Get all the string values for a named attribute in an attribute list,
	 * separated by the appropriate delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public static String getDelimitedStringValuesOrNull(DataSet list, DicomTag tag) {
		return getDelimitedStringValuesOrDefault(list, tag, null);
	}

	/**
	 * <p>
	 * Get all the string values for a named attribute in an attribute list,
	 * separated by the appropriate delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public static String getDelimitedStringValuesOrNull(DataSet list,
			DicomTag tag, NumberFormat format) {
		return getDelimitedStringValuesOrDefault(list, tag, null, format);
	}

	/**
	 * <p>
	 * Get the value representation of this attribute.
	 * </p>
	 * 
	 * @return the value representation as a {@link java.lang.String String}
	 */
	// public String getVRAsString() { return
	// ValueRepresentation.getAsString(getVR()); }
	/**
	 * <p>
	 * Get the values of a named attribute in an attribute list, as an array of
	 * double.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @return the values as an array of double
	 */
	public static double[] getDoubleValues(DataSet list, DicomTag tag) {
		double[] values = null;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				try {
					values = a.getDoubleValues();
				} catch (DicomException e) {
				}
			}
		}
		return values;
	}

	/**
	 * <p>
	 * Get the values of a named attribute in an attribute list, as an array of
	 * int.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @return the values as an array of int
	 */
	public static int[] getIntegerValues(DataSet list, DicomTag tag) {
		int[] values = null;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				try {
					values = a.getIntegerValues();
				} catch (DicomException e) {
					logger.warn(e.getMessage());
				}
			}
		}
		return values;
	}

	/**
	 * <p>
	 * Get the values of a named attribute in an attribute list, as an array of
	 * long.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @return the values as an array of long
	 */
	public static long[] getLongValues(DataSet list, DicomTag tag) {
		long[] values = null;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				try {
					values = a.getLongValues();
				} catch (DicomException e) {
				}
			}
		}
		return values;
	}

	/**
	 * <p>
	 * Get a single double value of a named attribute in an attribute list.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param dflt
	 *          what to return if there is no (valid) value
	 * @return a single double value
	 */
	public static double getSingleDoubleValueOrDefault(DataSet list,
			DicomTag tag, double dflt) {
		double value = dflt;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				value = a.getSingleDoubleValueOrDefault(dflt);
			}
		}
		return value;
	}

	public static final int getSingleIntegerValue(DataSet aDataSet,
			DicomTag aTag, int aDefault) {
		DataElement lElement = aDataSet.getElement(aTag);
		if (lElement != null) {
			return lElement.getSingleIntegerValue(aDefault);
		} else {
			return aDefault;
		}
	}

	/**
	 * <p>
	 * Get a single int value of a named attribute in an attribute list.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param dflt
	 *          what to return if there is no (valid) value
	 * @return a single int value
	 */
	public static int getSingleIntegerValueOrDefault(DataSet list, DicomTag tag,
			int dflt) {
		int value = dflt;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				value = a.getSingleIntegerValue(dflt);
			}
		}
		return value;
	}

	/**
	 * <p>
	 * Get a single long value of a named attribute in an attribute list.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param dflt
	 *          what to return if there is no (valid) value
	 * @return a single long value
	 */
	public static long getSingleLongValueOrDefault(DataSet list, DicomTag tag,
			long dflt) {
		long value = dflt;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				value = a.getSingleLongValueOrDefault(dflt);
			}
		}
		return value;
	}

	/**
	 * <p>
	 * Get a single string value for a named attribute in an attribute list.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param aDataset
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param aDefault
	 *          what to return if there is no (valid) string value
	 * @return a single {@link java.lang.String String} value
	 */
	public static String getSingleStringValueOrDefault(DataSet aDataset,
			DicomTag tag, String aDefault) {
		String value = aDefault;
		if (aDataset != null) {
			DataElement a = aDataset.getElement(tag);
			if (a != null) {
				value = a.getSingleStringValue(aDefault);
			}
		}
		if (value != null) {
			return value.trim();
		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Get a single string value for a named attribute in an attribute list.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param dflt
	 *          what to return if there is no (valid) string value
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return a single {@link java.lang.String String} value
	 */
	public static String getSingleStringValueOrDefault(DataSet list,
			DicomTag tag, String dflt, NumberFormat format) {
		String value = dflt;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				value = a.getSingleStringValueOrDefault(dflt, format);
			}
		}
		return value;
	}

	/**
	 * <p>
	 * Get a single string value for a named attribute in an attribute list.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, an empty string is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @return a single {@link java.lang.String String} value
	 */
	public static String getSingleStringValueOrEmptyString(DataSet list,
			DicomTag tag) {
		return getSingleStringValueOrDefault(list, tag, "");
	}

	/**
	 * <p>
	 * Get a single string value for a named attribute in an attribute list.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, an empty string is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return a single {@link java.lang.String String} value
	 */
	public static String getSingleStringValueOrEmptyString(DataSet list,
			DicomTag tag, NumberFormat format) {
		return getSingleStringValueOrDefault(list, tag, "", format);
	}

	/**
	 * <p>
	 * Get a single string value for a named attribute in an attribute list.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @return a single {@link java.lang.String String} value
	 */
	public static String getSingleStringValueOrNull(DataSet list, DicomTag tag) {
		return getSingleStringValueOrDefault(list, tag, null);
	}

	/**
	 * <p>
	 * Get a single string value for a named attribute in an attribute list.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return a single {@link java.lang.String String} value
	 */
	public static String getSingleStringValueOrNull(DataSet list, DicomTag tag,
			NumberFormat format) {
		return getSingleStringValueOrDefault(list, tag, null, format);
	}

	/**
	 * <p>
	 * Get the values of a named attribute in an attribute list, as an array of
	 * strings.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * The strings may have been cleaned up into a canonical form, such as to
	 * remove padding.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @return the values as an array of {@link java.lang.String String}
	 */
	public static String[] getStringValues(DataSet list, DicomTag tag) {
		String[] values = null;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				try {
					values = a.getStringValues();
				} catch (DicomException e) {
				}
			}
		}
		return values;
	}

	/**
	 * <p>
	 * Get the values of a named attribute in an attribute list, as an array of
	 * strings.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * The strings may have been cleaned up into a canonical form, such as to
	 * remove padding.
	 * </p>
	 * 
	 * @param list
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return the values as an array of {@link java.lang.String String}
	 */
	public static String[] getStringValues(DataSet list, DicomTag tag,
			NumberFormat format) {
		String[] values = null;
		if (list != null) {
			DataElement a = list.getElement(tag);
			if (a != null) {
				try {
					values = a.getStringValues(format);
				} catch (DicomException e) {
				}
			}
		}
		return values;
	}

	/**
	 * Return true if the DataElement represent a group length element (ie: the
	 * value of Element is equal to 0x0000)
	 * 
	 * @param aDataElement
	 * @return
	 */
	public static boolean isGroupLength(DataElement aDataElement) {
		return aDataElement.getTag().getElement() == 0;
	}

	/**
	 * the element's tag
	 */
	private DicomTag elementTag;

	/***/
	// TODO must be private
	// TODO must be replaced by a getValueLength
	protected long fValueLength;

	/***/

	// TODO must be replaced by a getValueMultiplicity
	protected int fValueMultiplicity = 0;

	/**
	 * <p>
	 * Creates an empty Element; called only by concrete sub-classes.
	 * </p>
	 * 
	 * @param aAttributeTag
	 *          the tag of the attribute
	 */
	protected DataElement(DicomTag aTag) {
		assert aTag != null;
		this.elementTag = aTag;
		// clear();
		this.fValueLength = 0;
		this.fValueMultiplicity = 0;
	}

	/**
	 * Add a(nother) byte value after any existing values of this attribute.
	 * 
	 * @param v
	 *          value to add
	 * @exception DicomException
	 *              thrown if value of this type is not valid for this concrete
	 *              attribute class
	 */
	public void addValue(byte v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * Add a(nother) double value after any existing values of this attribute.
	 * 
	 * @param v
	 *          value to add
	 * @exception DicomException
	 *              thrown if value of this type is not valid for this concrete
	 *              attribute class
	 */
	public void addValue(double v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * Add a(nother) float value after any existing values of this attribute.
	 * 
	 * @param v
	 *          value to add
	 * @exception DicomException
	 *              thrown if value of this type is not valid for this concrete
	 *              attribute class
	 */
	public void addValue(float v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * Add a(nother) int value after any existing values of this attribute.
	 * 
	 * @param v
	 *          value to add
	 * @exception DicomException
	 *              thrown if value of this type is not valid for this concrete
	 *              attribute class
	 */
	public void addValue(int v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * Add a(nother) long value after any existing values of this attribute.
	 * 
	 * @param v
	 *          value to add
	 * @exception DicomException
	 *              thrown if value of this type is not valid for this concrete
	 *              attribute class
	 */
	public void addValue(long v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * Add a(nother) short value after any existing values of this attribute.
	 * 
	 * @param v
	 *          value to add
	 * @exception DicomException
	 *              thrown if value of this type is not valid for this concrete
	 *              attribute class
	 */
	public void addValue(short v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * Add a(nother) {@link java.lang.String String} value after any existing
	 * values of this attribute.
	 * 
	 * @param v
	 *          value to add
	 * @exception DicomException
	 *              thrown if value of this type is not valid for this concrete
	 *              attribute class
	 */
	public void addValue(String v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * Clear Data contains in this Element
	 * 
	 */
	public void clear() {
		logger.warn("clear not yet implemented");
		// TODO make Abstract
	}

	// Some convenience methods ...

	protected void doCommonRead(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException {
		// TODO
		/*
		 * if (aLength > 1024000) { fLogger.warn(aLength + " is not a valid
		 * length"); throw new IOException(aLength + " is not a valid length"); }
		 */
		this.fValueLength = aLength;
	}

	/**
	 * <p>
	 * Get the values of this attribute as a byte array.
	 * </p>
	 * 
	 * @return the values as an array of bytes
	 * @exception DicomException
	 *              thrown if values are not available (such as not supported for
	 *              this concrete attribute class)
	 */
	public byte[] getByteValues() throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	public String getDelimitedStringValues() {
		return this.getDelimitedStringValues("");
	}

	/**
	 * <p>
	 * Get a single string value for the attribute.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, an empty string is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @return a single {@link java.lang.String String} value
	 */
	// public String getSingleStringValueOrEmptyString() { return
	// getSingleStringValue(""); }
	/**
	 * <p>
	 * Get all the string values for the attribute, separated by the appropriate
	 * delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, the supplied default
	 * is returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param dflt
	 *          what to return if there are no (valid) string values
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public String getDelimitedStringValues(String aDefault) {
		return this.getDelimitedStringValuesOrDefault(aDefault, null);
	}

	/**
	 * <p>
	 * Get all the string values for the attribute, separated by the appropriate
	 * delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, the supplied default
	 * is returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param dflt
	 *          what to return if there are no (valid) string values
	 * @param format
	 *          the format to use for each numerical or decimal value (null if
	 *          none)
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public String getDelimitedStringValuesOrDefault(String dflt,
			NumberFormat format) {
		String value = dflt;
		try {
			String[] sv = this.getStringValues(format);
			if (sv != null) {
				StringBuffer str = new StringBuffer();
				for (int i = 0; i < sv.length; ++i) {
					if (i > 0) {
						str.append("\\");
					}
					String v = sv[i];
					if (v != null) {
						str.append(v);
					}
				}
				value = str.toString().trim();
			}
		} catch (DicomException e) {
		}
		return value;
	}

	/**
	 * <p>
	 * Get all the string values for the attribute, separated by the appropriate
	 * delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, an empty string is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public String getDelimitedStringValuesOrEmptyString() {
		return this.getDelimitedStringValues("");
	}

	/**
	 * <p>
	 * Get all the string values for the attribute, separated by the appropriate
	 * delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, an empty string is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public String getDelimitedStringValuesOrEmptyString(NumberFormat format) {
		return this.getDelimitedStringValuesOrDefault("", format);
	}

	/**
	 * <p>
	 * Get all the string values for the attribute, separated by the appropriate
	 * delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public String getDelimitedStringValuesOrNull() {
		return this.getDelimitedStringValues(null);
	}

	/**
	 * <p>
	 * Get all the string values for the attribute, separated by the appropriate
	 * delimiter.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return the values as a delimited {@link java.lang.String String}
	 */
	public String getDelimitedStringValuesOrNull(NumberFormat format) {
		return this.getDelimitedStringValuesOrDefault(null, format);
	}

	/**
	 * <p>
	 * Get the values of this attribute as a double array.
	 * </p>
	 * 
	 * @return the values as an array of double
	 * @exception DicomException
	 *              thrown if values are not available (such as not supported for
	 *              this concrete attribute class)
	 */
	public double[] getDoubleValues() throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * <p>
	 * Get the values of this attribute as a float array.
	 * </p>
	 * 
	 * @return the values as an array of float
	 * @exception DicomException
	 *              thrown if values are not available (such as not supported for
	 *              this concrete attribute class)
	 */
	public float[] getFloatValues() throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * <p>
	 * Get the values of this attribute as an int array.
	 * </p>
	 * 
	 * @return the values as an array of int
	 * @exception DicomException
	 *              thrown if values are not available (such as not supported for
	 *              this concrete attribute class)
	 */
	public int[] getIntegerValues() throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * <p>
	 * Get the values of this attribute as a long array.
	 * </p>
	 * 
	 * @return the values as an array of long
	 * @exception DicomException
	 *              thrown if values are not available (such as not supported for
	 *              this concrete attribute class)
	 */
	public long[] getLongValues() throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * return the name of the element (ie: the tag's name
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.getTag().getName();
	}

	/**
	 * <p>
	 * Get the values of this attribute as strings, the way they were originally
	 * inserted or read.
	 * </p>
	 * 
	 * @return the values as an array of {@link java.lang.String String}
	 * @exception DicomException
	 *              thrown if values are not available (such as not supported for
	 *              this concrete attribute class)
	 */
	public String[] getOriginalStringValues() throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * <p>
	 * Get the value length of this attribute, accounting for the need for
	 * even-length padding.
	 * </p>
	 * 
	 * @return the value length (padded to an even length)
	 */
	public long getPaddedVL() {
		return this.fValueLength;
	} // Needs to be overridden esp. in String attributes

	/**
	 * <p>
	 * Get the values of this attribute as a short array.
	 * </p>
	 * 
	 * @return the values as an array of short
	 * @exception DicomException
	 *              thrown if values are not available (such as not supported for
	 *              this concrete attribute class)
	 */
	public short[] getShortValues() throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * <p>
	 * Get a single double value for the attribute.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * @param dflt
	 *          what to return if there is no (valid) value
	 * @return a single double value
	 */
	public double getSingleDoubleValueOrDefault(double dflt) {
		double value = dflt;
		try {
			double[] v = this.getDoubleValues();
			if ((v != null) && (v.length > 0)) {
				value = v[0];
			}
		} catch (DicomException e) {
		}
		return value;
	}

	public int getSingleIntegerValue() {
		return this.getSingleIntegerValue(-1);
	}

	/**
	 * <p>
	 * Get a single int value for the attribute.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * @param aDefault
	 *          what to return if there is no (valid) value
	 * @return a single int value
	 */
	public int getSingleIntegerValue(int aDefault) {
		int value = aDefault;
		try {
			int[] v = this.getIntegerValues();
			if ((v != null) && (v.length > 0)) {
				value = v[0];
			}
		} catch (DicomException e) {
			logger.warn(e.getMessage());
		}
		return value;
	}

	/**
	 * <p>
	 * Get a single long value for the attribute.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * @param dflt
	 *          what to return if there is no (valid) value
	 * @return a single long value
	 */
	public long getSingleLongValueOrDefault(long dflt) {
		long value = dflt;
		try {
			long[] v = this.getLongValues();
			if ((v != null) && (v.length > 0)) {
				value = v[0];
			}
		} catch (DicomException e) {
		}
		return value;
	}

	/**
	 * <p>
	 * Get a single string value
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, the supplied default is returned.
	 * </p>
	 */
	public String getSingleStringValue() {
		return this.getSingleStringValue("");
	}

	/**
	 * <p>
	 * Get a single string value for the attribute.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param dflt
	 *          what to return if there is no (valid) string value
	 * @return a single {@link java.lang.String String} value
	 */
	public String getSingleStringValue(String dflt) {
		return this.getSingleStringValueOrDefault(dflt, null);
	}

	/**
	 * <p>
	 * Get a single string value for the attribute.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, the supplied default is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, the supplied default is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param dflt
	 *          what to return if there is no (valid) string value
	 * @param format
	 *          the format to use for each numerical or decimal value (null if
	 *          none)
	 * @return a single {@link java.lang.String String} value
	 */
	public String getSingleStringValueOrDefault(String dflt, NumberFormat format) {
		String value = dflt;
		try {
			String[] sv = this.getStringValues(format);
			// String[] sv = getOriginalStringValues();
			if ((sv != null) && (sv.length > 0)) {
				String v = sv[0];
				if (v != null) {
					value = v;
				}
			}
		} catch (DicomException e) {
			logger.warn(e.getMessage());
		}
		if (value != null) {
			return value.trim();
		} else {
			return value;
		}
	}

	/**
	 * <p>
	 * Get a single string value for the attribute.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, an empty string is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, an empty string is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return a single {@link java.lang.String String} value
	 */
	public String getSingleStringValueOrEmptyString(NumberFormat format) {
		return this.getSingleStringValueOrDefault("", format);
	}

	/**
	 * <p>
	 * Get a single string value for the attribute.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @return a single {@link java.lang.String String} value
	 */
	public String getSingleStringValueOrNull() {
		return this.getSingleStringValue(null);
	}

	/**
	 * <p>
	 * Get a single string value for the attribute.
	 * </p>
	 * 
	 * <p>
	 * If there is more than one string value, only the first is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is no string value, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the value, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * <p>
	 * A canonicalized (unpadded) form is returned, not the original string.
	 * </p>
	 * 
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return a single {@link java.lang.String String} value
	 */
	public String getSingleStringValueOrNull(NumberFormat format) {
		return this.getSingleStringValueOrDefault(null, format);
	}

	/**
	 * <p>
	 * Get the values of this attribute as strings.
	 * </p>
	 * 
	 * <p>
	 * The strings may have been cleaned up into a canonical form, such as to
	 * remove padding.
	 * </p>
	 * 
	 * @return the values as an array of {@link java.lang.String String}
	 * @exception DicomException
	 *              thrown if values are not available (such as not supported for
	 *              this concrete attribute class)
	 */
	public String[] getStringValues() throws DicomException {
		return this.getStringValues(null);
	}

	/**
	 * <p>
	 * Get the values of this attribute as strings.
	 * </p>
	 * 
	 * <p>
	 * The strings may have been cleaned up into a canonical form, such as to
	 * remove padding as well as numbers formatted.
	 * </p>
	 * 
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @return the values as an array of {@link java.lang.String String}
	 * @exception DicomException
	 *              thrown if values are not available (such as not supported for
	 *              this concrete attribute class)
	 */
	public String[] getStringValues(NumberFormat format) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * <p>
	 * Return element's {@link DicomTag tag}
	 * </p>
	 * 
	 * @return the tag
	 */
	public DicomTag getTag() {
		return this.elementTag;
	}

	/**
	 * <p>
	 * Gets the value length
	 * </p>
	 * 
	 * @return the value length (does not include need for even-length padding,
	 *         hence may be odd length)
	 */
	public long getValueLength() {
		return this.fValueLength;
	}

	/*
	 * public static int getSingleUnsignedShortOrDefault(AttributeList
	 * list,AttributeTag tag,int dflt) { int value = dflt; if (list != null) {
	 * Attribute a = list.get(tag); if (a != null) { value =
	 * a.getSingleIntegerValueOrDefault(dflt); } } return value; }
	 */

	/**
	 * <p>
	 * Get the value multiplicity of this element
	 * </p>
	 * 
	 * @return the value multiplicity
	 */
	public int getValueMultiplicity() {
		return this.fValueMultiplicity;
	}

	/**
	 * return the element's {@link ValueRepresentation}
	 * 
	 * @return the value representation
	 */
	public abstract ValueRepresentation getValueRepresentation();

	/**
	 * used to check if the element's value can be available as a string. <br>
	 * must be check before getSrtingxxx methods
	 * 
	 * @return true if value is available as a string
	 * @since 0.0.6
	 */
	public boolean isAvailableAsString() {
		return true;
	}

	/***
	 * check is the tag is private
	 * 
	 * @return true if tag is private
	 * @since 0.0.9
	 */
	public boolean isPrivate() {
		return this.getTag().isPrivate();
	}

	/**
	 * <p>
	 * check is the data of this element is Dicom compliant
	 * </p>
	 * 
	 * @return true is dicom compliant
	 * 
	 * @todo make abstract
	 */
	public boolean isValid() {
		logger.warn("isValid() not yet implemented");
		return true;
	}

	/**
	 * Read data from a stream
	 * 
	 * @param aStream
	 *          the stream
	 * @param aLength
	 *          the length of data to read
	 * @throws IOException
	 * @throws DicomException
	 */
	public void read(DicomInputStream aStream, long aLength) throws IOException,
	DicomException {
		this.read(aStream, aLength, null);
	}

	public abstract void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException;

	/**
	 * <p>
	 * Remove any existing values, making the attribute empty (zero length).
	 * </p>
	 * 
	 * @exception DicomException
	 */
	public void removeValues() throws DicomException {
		throw new DicomException(
				"internal error - removeValues() not implemented for attribute "
				+ this.elementTag);
	}

	/**
	 * Replace any existing values with the supplied array of byte.
	 * 
	 * @param v
	 *          the array of new values
	 * @exception DicomException
	 *              thrown if values of this type are not valid for this concrete
	 *              attribute class
	 */
	public void setValues(byte[] v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * Replace any existing values with the supplied array of float.
	 * 
	 * @param v
	 *          the array of new values
	 * @exception DicomException
	 *              thrown if values of this type are not valid for this concrete
	 *              attribute class
	 */
	public void setValues(float[] v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * Replace any existing values with the supplied array of short.
	 * 
	 * @param v
	 *          the array of new values
	 * @exception DicomException
	 *              thrown if values of this type are not valid for this concrete
	 *              attribute class
	 */
	public void setValues(short[] v) throws DicomException {
		throw new DicomException("internal error - wrong value type for attribute "
				+ this.elementTag);
	}

	/**
	 * 
	 * <p>
	 * Dump the contents of the attribute as a human-readable string.
	 * </p>
	 * 
	 * <p>
	 * No new line is appended.
	 * </p>
	 * 
	 * <p>
	 * The result is of the form:
	 * </p>
	 * 
	 * <pre>
	 * (0xgggg,0xeeee) VR=&lt;XX&gt; VL=&lt;0xnnnn&gt; &lt;...&gt;
	 * </pre>
	 * 
	 * <p>
	 * For example:
	 * </p>
	 * 
	 * <pre>
	 * (0x0018,0x0020) VR=&lt;CS&gt; VL=&lt;0x2&gt; &lt;GR&gt;
	 * </pre>
	 * 
	 * @return a single {@link java.lang.String String} value
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(this.elementTag.toString());
		while (str.length() < 62) {
			str.append(" ");
		}

		str.append(" [");
		str.append(this.getValueRepresentation().getName());
		str.append("] <");
		str.append(this.getValueLength());
		str.append(">");
		// Logger.debug(str.toString());
		return str.toString();
	}

	/**
	 * <p>
	 * Write the entire attribute (including values) to the output stream.
	 * </p>
	 * 
	 * @param o
	 *          the output stream
	 * @exception IOException
	 * @exception DicomException
	 */
	abstract public void write(DicomOutputStream o) throws DicomException,
	IOException;

	/**
	 * <p>
	 * Write the common preamble of an attribute to the output stream.
	 * </p>
	 * 
	 * <p>
	 * Writes the tag, VR (if explicit in the output stream) and the value length
	 * in the appropriate form.
	 * </p>
	 * 
	 * <p>
	 * Called by a concrete base class prior to writing the values themselves.
	 * </p>
	 * 
	 * @param o
	 *          the output stream
	 * @exception IOException
	 */
	protected void writeBase(DicomOutputStream o) throws IOException {
		o.writeUnsigned16(this.getTag().getGroup());
		o.writeUnsigned16(this.getTag().getElement());
		if (o.isExplicitVR()) {
			byte[] vr = this.getValueRepresentation().toBytes();
			o.write(vr, 0, 2);
			if (ValueRepresentation.isShortValueLengthVR(vr)) {
				o.writeUnsigned16((int) this.getPaddedVL());
			} else {
				o.writeUnsigned16(0); // reserved bytes
				o.writeUnsigned32(this.getPaddedVL());
			}
		} else {
			o.writeUnsigned32(this.getPaddedVL());
		}
	}

}
