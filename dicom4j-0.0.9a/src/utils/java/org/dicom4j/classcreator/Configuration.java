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

package org.dicom4j.classcreator;

import org.dicom4j.data.elements.support.DataElement;

/**
 * Way to configure the ClassCreator
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class Configuration {

	public Configuration() {
		super();
	}

	/**
	 * retrun a class's name which extends {@link DataElement}
	 * 
	 * @param aVR
	 * @return
	 */
	public String getDataElementClassName(String aVR) {
		if (aVR != "") {
			if (aVR.toUpperCase().equals("AS")) {
				return "AgeString";
			} else if (aVR.toUpperCase().equals("AE")) {
				return "ApplicationEntity";
			} else if (aVR.toUpperCase().equals("AT")) {
				return "AttributeTag";
			} else if (aVR.toUpperCase().equals("CS")) {
				return "CodeString";
			} else if (aVR.toUpperCase().equals("DA")) {
				return "DateElement";
			} else if (aVR.toUpperCase().equals("DS")) {
				return "DecimalString";
			} else if (aVR.toUpperCase().equals("DT")) {
				return "DateTime";
			} else if (aVR.toUpperCase().equals("FL")) {
				return "FloatingPointSingle";
			} else if (aVR.toUpperCase().equals("FD")) {
				return "FloatingPointDouble";
			} else if (aVR.toUpperCase().equals("IS")) {
				return "IntegerString";
			} else if (aVR.toUpperCase().equals("LO")) {
				return "LongString";
			} else if (aVR.toUpperCase().equals("LT")) {
				return "LongText";
			} else if (aVR.toUpperCase().equals("OB")) {
				return "OtherByteString";
			} else if (aVR.toUpperCase().equals("OF")) {
				return "OtherFloatString";
			} else if (aVR.toUpperCase().equals("OW")) {
				return "OtherWordString";
			} else if (aVR.toUpperCase().equals("PN")) {
				return "PersonName";
			} else if (aVR.toUpperCase().equals("SH")) {
				return "ShortString";
			} else if (aVR.toUpperCase().equals("SL")) {
				return "SignedLong";
			} else if (aVR.toUpperCase().equals("SQ")) {
				return "SequenceOfItems";
			} else if (aVR.toUpperCase().equals("SS")) {
				return "SignedShort";
			} else if (aVR.toUpperCase().equals("ST")) {
				return "ShortText";
			} else if (aVR.toUpperCase().equals("TM")) {
				return "Time";
			} else if (aVR.toUpperCase().equals("UI")) {
				return "UniqueIdentifier";
			} else if (aVR.toUpperCase().equals("UL")) {
				return "UnsignedLong";
			} else if (aVR.toUpperCase().equals("UN")) {
				return "Unknown";
			} else if (aVR.toUpperCase().equals("US")) {
				return "UnsignedShort";
			} else if (aVR.toUpperCase().equals("UT")) {
				return "UnlimitedText";
			} else {
				return "Unknown";
			}
		}
		return "Unknown";
	}

	public String getDataElementsFileName() {
		// return ".\\testData.java";
		return ".\\src\\main\\java\\org\\dicom4j\\data\\DataElements.java";
	}

	public String getDataElementTagClassName() {
		return "DicomTag";
	}

	public String getEmebbedDicomDictionaryLocation() {
		return ".\\src\\main\\java\\org\\dicom4j\\dicom\\dictionary\\EmbbedDicomDictionary.java";
	}

	public String getModulesLocation() {
		return ".\\src\\main\\java\\org\\dicom4j\\modules";
	}

	public String getSopClassesFileName() {
		return ".\\src\\main\\java\\org\\dicom4j\\dicom\\SOPClasses.java";
	}

	public String getSopClassFileName() {
		return ".\\src\\main\\java\\org\\dicom4j\\dicom\\UniqueIdentifiers\\SOPClass.java";
	}

	public String getTagsJavaFileName() {
		// return ".\\testTag.java";
		return ".\\src\\main\\java\\org\\dicom4j\\dicom\\DicomTags.java";
	}

	/**
	 * an Embbeded DicomDictionary.
	 * 
	 * It's the défault DicomDictionary used if not other was set.
	 * 
	 * @since Alpha 0.0.0
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 * @see org.dicom4j.core.implementation.Dicom4jImplementation
	 * 
	 */

	public String getVRClassName(String aVR) {
		if (aVR != "") {
			if (aVR.toUpperCase().equals("AS")) {
				return "AgeString";
			} else if (aVR.toUpperCase().equals("AE")) {
				return "ApplicationEntity";
			} else if (aVR.toUpperCase().equals("AT")) {
				return "AttributeTag";
			} else if (aVR.toUpperCase().equals("CS")) {
				return "CodeString";
			} else if (aVR.toUpperCase().equals("DA")) {
				return "Date";
			} else if (aVR.toUpperCase().equals("DS")) {
				return "DecimalString";
			} else if (aVR.toUpperCase().equals("DT")) {
				return "DateTime";
			} else if (aVR.toUpperCase().equals("FL")) {
				return "FloatingPointSingle";
			} else if (aVR.toUpperCase().equals("FD")) {
				return "FloatingPointDouble";
			} else if (aVR.toUpperCase().equals("IS")) {
				return "IntegerString";
			} else if (aVR.toUpperCase().equals("LO")) {
				return "LongString";
			} else if (aVR.toUpperCase().equals("LT")) {
				return "LongText";
			} else if (aVR.toUpperCase().equals("OB")) {
				return "OtherByteString";
			} else if (aVR.toUpperCase().equals("OF")) {
				return "OtherFloatString";
			} else if (aVR.toUpperCase().equals("OW")) {
				return "OtherWordString";
			} else if (aVR.toUpperCase().equals("PN")) {
				return "PersonName";
			} else if (aVR.toUpperCase().equals("SH")) {
				return "ShortString";
			} else if (aVR.toUpperCase().equals("SL")) {
				return "SignedLong";
			} else if (aVR.toUpperCase().equals("SQ")) {
				return "SequenceOfItems";
			} else if (aVR.toUpperCase().equals("SS")) {
				return "SignedShort";
			} else if (aVR.toUpperCase().equals("ST")) {
				return "ShortText";
			} else if (aVR.toUpperCase().equals("TM")) {
				return "Time";
			} else if (aVR.toUpperCase().equals("UI")) {
				return "UniqueIdentifier";
			} else if (aVR.toUpperCase().equals("UL")) {
				return "UnsignedLong";
			} else if (aVR.toUpperCase().equals("UN")) {
				return "Unknown";
			} else if (aVR.toUpperCase().equals("US")) {
				return "UnsignedShort";
			} else if (aVR.toUpperCase().equals("UT")) {
				return "UnlimitedText";
			} else {
				return "Unknown";
			}
		}
		return "Unknown";
	}
}
