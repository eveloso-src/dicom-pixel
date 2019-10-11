/* Copyright (c) 2001-2003, David A. Clunie DBA Pixelmed Publishing. All rights reserved. */

package org.dicom4j.dicom;

/**
 * <p>
 * Utilities to support the concept of the DICOM Value Representation (VR),
 * including two byte arrays for each VR, and tester methods that determine
 * whether or not a particular two byte array is a particular type of VR.
 * </p>
 * 
 * @author dclunie
 */
// TODO FINISH
public class ValueRepresentation implements Comparable<ValueRepresentation> {

	/***/
	public static byte[] AE = { 'A', 'E' };

	/**
	 * AGE STRING Value Representation
	 * 
	 */
	public final static ValueRepresentation AgeString = new ValueRepresentation("AS", "Age String");

	/**
	 * APPLICATION ENTITY Value Representation
	 */
	public final static ValueRepresentation ApplicationEntity = new ValueRepresentation("AE", "Application Entity");

	/***/
	public static byte[] AS = { 'A', 'S' };

	/***/
	public static byte[] AT = { 'A', 'T' };

	/**
	 * ATTRIBUTE TAG Value Representation
	 */
	public final static ValueRepresentation AttributeTag = new ValueRepresentation("AT", "Attribute Tag");

	/**
	 * CODE STRING Value Representation
	 */
	public final static ValueRepresentation CodeString = new ValueRepresentation("CS", "Code String");

	/***/
	public static byte[] CS = { 'C', 'S' };

	/***/
	public static byte[] DA = { 'D', 'A' };

	/**
	 * DATE Value Representation
	 */
	public final static ValueRepresentation Date = new ValueRepresentation("DA", "Date");

	/**
	 * DATE TIME Value Representation
	 */
	public final static ValueRepresentation DateTime = new ValueRepresentation("DT", "Date Time");

	/**
	 * DECIMAL STRING Value Representation
	 */
	public final static ValueRepresentation DecimalString = new ValueRepresentation("DS", "Decimal String");

	public static byte[] DS = { 'D', 'S' };

	public static byte[] DT = { 'D', 'T' };

	public static byte[] FD = { 'F', 'D' };

	public static byte[] FL = { 'F', 'L' };

	/**
	 * FLOATING POINT DOUBLE Value Representation
	 */
	public final static ValueRepresentation FloatingPointDouble = new ValueRepresentation(
			"FD", "FloatingPointDouble");

	/**
	 * FLOATING POINT SINGLE Value Representation
	 */
	public final static ValueRepresentation FloatingPointSingle = new ValueRepresentation(
			"FL", "FloatingPointSingle");

	/**
	 * INTGER STRING Value Representation
	 */
	public final static ValueRepresentation IntegerString = new ValueRepresentation(
			"IS", "IntegerString");

	/***/
	public static byte[] IS = { 'I', 'S' };

	/***/
	public static byte[] LO = { 'L', 'O' };

	/**
	 * LONG STRING Value Representation
	 */
	public final static ValueRepresentation LongString = new ValueRepresentation(
			"LO", "LongString");

	/**
	 * LONG TEXT Value Representation
	 */
	public final static ValueRepresentation LongText = new ValueRepresentation(
			"LT", "LongText");

	/***/
	public static byte[] LT = { 'L', 'T' };

	/***/
	public static byte[] OB = { 'O', 'B' };

	/***/
	public static byte[] OF = { 'O', 'F' };

	/**
	 * OTHER BYTE STRING Value Representation
	 */
	public final static ValueRepresentation OtherByteString = new ValueRepresentation(
			"OB", "OtherByteString");

	/**
	 * OTHER FLOAT STRING Value Representation
	 */
	public final static ValueRepresentation OtherFloatString = new ValueRepresentation(
			"OF", "OtherFloatString");

	/**
	 * OTHER WORD STRING Value Representation
	 */
	public final static ValueRepresentation OtherWordString = new ValueRepresentation(
			"OW", "OtherWordString");

	/***/
	public static byte[] OW = { 'O', 'W' };

	/***/
	public static byte[] OX = { 'O', 'X' }; // OB or OW

	/**
	 * PERSON NAME Value Representation
	 */
	public final static ValueRepresentation PersonName = new ValueRepresentation(
			"PN", "Person Name");

	/***/
	public static byte[] PN = { 'P', 'N' };

	/**
	 * SEQUENCE OF ITEMS Value Representation
	 */
	public final static ValueRepresentation SequenceOfItems = new ValueRepresentation(
			"SQ", "SequenceOfItems");

	/***/
	public static byte[] SH = { 'S', 'H' };

	/**
	 * SHORT STRING Value Representation
	 */
	public final static ValueRepresentation ShortString = new ValueRepresentation(
			"SH", "ShortString");

	/**
	 * SHORT TEXT Value Representation
	 */
	public final static ValueRepresentation ShortText = new ValueRepresentation(
			"ST", "ShortText");

	/**
	 * SIGNED LONG Value Representation
	 */
	public final static ValueRepresentation SignedLong = new ValueRepresentation(
			"SL", "SignedLong");

	/**
	 * SIGNED SHORT Value Representation
	 */
	public final static ValueRepresentation SignedShort = new ValueRepresentation(
			"SS", "SignedShort");

	/***/
	public static byte[] SL = { 'S', 'L' };

	/***/
	public static byte[] SQ = { 'S', 'Q' };

	/***/
	public static byte[] SS = { 'S', 'S' };

	/***/
	public static byte[] ST = { 'S', 'T' };

	/**
	 * TIME Value Representation
	 */
	public final static ValueRepresentation Time = new ValueRepresentation("TM",
	"Time");

	/***/
	public static byte[] TM = { 'T', 'M' };

	/***/
	public static byte[] UI = { 'U', 'I' };

	/***/
	public static byte[] UL = { 'U', 'L' };

	/***/
	public static byte[] UN = { 'U', 'N' };

	/**
	 * UNIQUE IDENTIFIER Value Representation
	 */
	public final static ValueRepresentation UniqueIdentifier = new ValueRepresentation("UI", "Unique Identifier");

	/**
	 * UNKNOW Value Representation
	 */
	public final static ValueRepresentation Unknown = new ValueRepresentation("UN", "Unknown");

	/**
	 * UNLIMITED TEXT Value Representation
	 */
	public final static ValueRepresentation UnlimitedText = new ValueRepresentation("UT", "Unlimited Text");

	/**
	 * UNSIGNED LONG Value Representation
	 */
	public final static ValueRepresentation UnsignedLong = new ValueRepresentation("UL", "Unsigned Long");

	/**
	 * UNSIGNED SHORT Value Representation
	 */
	public final static ValueRepresentation UnsignedShort = new ValueRepresentation("US", "Unsigned Short");

	/***/
	public static byte[] US = { 'U', 'S' };

	/***/
	public static byte[] UT = { 'U', 'T' };

	/***/
	public static byte[] XO = { 'X', 'O' }; // US or SS or OW

	/***/
	public static byte[] XS = { 'X', 'S' }; // US or SS

	/**
	 * @param vr
	 */
	public static final String getAsString(byte[] vr) {
		return new String(vr);
	}

	/**
	 * TODO
	 */
	public static ValueRepresentation getValueRepresentation(byte[] aVr)
	throws Exception {
		assert aVr != null;
		if (aVr.length != 2) {
			throw new Exception(
			"getValueRepresentation must be call with an array of 2 bytes");
		}

		if ((aVr[0] == 'A') && (aVr[1] == 'E')) {
			return ValueRepresentation.ApplicationEntity;
		} else if ((aVr[0] == 'A') && (aVr[1] == 'S')) {
			return ValueRepresentation.AgeString;
		} else if ((aVr[0] == 'A') && (aVr[1] == 'T')) {
			return ValueRepresentation.AttributeTag;
		} else if ((aVr[0] == 'C') && (aVr[1] == 'S')) {
			return ValueRepresentation.CodeString;

		} else {
			return null;
		}
	}

	/**
	 * <p>
	 * Get the length of the "word" corresponding to an individual value for this
	 * VR, such as may be needed when swapping the endianness of values.
	 * </p>
	 * 
	 * @param vr
	 */
	public static final int getWordLengthOfValueAffectedByEndianness(byte[] vr) {
		int length = 1;
		if (isSignedShortVR(vr) || isUnsignedShortVR(vr)
				|| isUnspecifiedShortVR(vr) || isOtherWordVR(vr)
				|| isUnspecifiedShortOrOtherWordVR(vr)) {
			length = 2;
		}

		if (isSignedLongVR(vr) || isUnsignedLongVR(vr) || isFloatSingleVR(vr)
				|| isOtherFloatVR(vr)) {
			length = 4;
		}

		if (isFloatDoubleVR(vr)) {
			length = 8;
		}

		return length;
	}

	/**
	 * @param vr
	 */
	public static final boolean isAffectedBySpecificCharacterSet(byte[] vr) {
		return isLongStringVR(vr) || isLongTextVR(vr) || isPersonNameVR(vr)
		|| isShortStringVR(vr) || isShortTextVR(vr) || isUnlimitedTextVR(vr);
	}

	/**
	 * @param vr
	 */
	public static final boolean isCodeStringVR(byte[] vr) {
		return (vr[0] == 'C') && (vr[1] == 'S');
	}

	/**
	 * @param vr
	 */
	public static final boolean isDateTimeVR(byte[] vr) {
		return (vr[0] == 'D') && (vr[1] == 'T');
	}

	/**
	 * @param vr
	 */
	public static final boolean isDateVR(byte[] vr) {
		return (vr[0] == 'D') && (vr[1] == 'A');
	}

	/**
	 * @deprecated
	 * @param vr
	 */
	public static final boolean isDecimalStringVR(byte[] vr) {
		return (vr[0] == 'D') && (vr[1] == 'S');
	}

	/**
	 * @param vr
	 */
	public static final boolean isFloatDoubleVR(byte[] vr) {
		return (vr[0] == 'F') && (vr[1] == 'D');
	}

	/**
	 * @param vr
	 */
	public static final boolean isFloatSingleVR(byte[] vr) {
		return (vr[0] == 'F') && (vr[1] == 'L');
	}

	/**
	 * @param vr
	 */
	public static final boolean isIntegerStringVR(byte[] vr) {
		return (vr[0] == 'I') && (vr[1] == 'S');
	}

	/**
	 * @param vr
	 */
	public static final boolean isLongStringVR(byte[] vr) {
		return (vr[0] == 'L') && (vr[1] == 'O');
	}

	/**
	 * @param vr
	 */
	public static final boolean isLongTextVR(byte[] vr) {
		return (vr[0] == 'L') && (vr[1] == 'T');
	}

	/**
	 * @param vr
	 */
	public static final boolean isOtherByteOrWordVR(byte[] vr) {
		return (vr[0] == 'O')
		&& ((vr[1] == 'B') || (vr[1] == 'W') || (vr[1] == 'X'));
	}

	/**
	 * @param vr
	 */
	public static final boolean isOtherByteVR(byte[] vr) {
		return (vr[0] == 'O') && (vr[1] == 'B');
	}

	/**
	 * @param vr
	 */
	public static final boolean isOtherFloatVR(byte[] vr) {
		return (vr[0] == 'O') && (vr[1] == 'F');
	}

	/**
	 * @param vr
	 */
	public static final boolean isOtherUnspecifiedVR(byte[] vr) { // Not a real VR
		// ... but
		// returned by
		// dictionary
		return (vr[0] == 'O') && (vr[1] == 'X');
	}

	/**
	 * @param aVR
	 */
	public static final boolean isOtherUnspecifiedVR(ValueRepresentation aVR) { // Not
		// a
		// real
		// VR
		// ...
		// but
		// returned
		// by
		// dictionary
		return aVR.equals("OX");
	}

	/**
	 * @param vr
	 */
	public static final boolean isOtherWordVR(byte[] vr) {
		return (vr[0] == 'O') && (vr[1] == 'W');
	}

	/**
	 * @param vr
	 */
	public static final boolean isPersonNameVR(byte[] vr) {
		return (vr[0] == 'P') && (vr[1] == 'N');
	}

	/**
	 * @param vr
	 */
	/*
	 * public static final boolean isApplicationEntityVR(byte[] vr) { return
	 * vr[0]=='A' && vr[1]=='E'; }
	 */

	/**
	 * @param vr
	 */
	/*
	 * public static final boolean isAgeStringVR(byte[] vr) { return vr[0]=='A' &&
	 * vr[1]=='S'; }
	 */

	/**
	 * @param vr
	 */
	/*
	 * public static final boolean isAttributeTagVR(byte[] vr) { return vr[0]=='A'
	 * && vr[1]=='T'; }
	 */

	/**
	 * @param vr
	 */
	public static final boolean isSequenceVR(byte[] vr) {
		return (vr[0] == 'S') && (vr[1] == 'Q');
	}

	/**
	 * @param vr
	 */
	public static final boolean isShortStringVR(byte[] vr) {
		return (vr[0] == 'S') && (vr[1] == 'H');
	}

	/**
	 * @param vr
	 */
	public static final boolean isShortTextVR(byte[] vr) {
		return (vr[0] == 'S') && (vr[1] == 'T');
	}

	/**
	 * @param vr
	 */
	public static final boolean isShortValueLengthVR(byte[] vr) {
		return ((vr[0] == 'A') && ((vr[1] == 'E') || (vr[1] == 'S') || (vr[1] == 'T')))
		|| ((vr[0] == 'C') && (vr[1] == 'S'))
		|| ((vr[0] == 'D') && ((vr[1] == 'A') || (vr[1] == 'S') || (vr[1] == 'T')))
		|| ((vr[0] == 'F') && ((vr[1] == 'D') || (vr[1] == 'L')))
		|| ((vr[0] == 'I') && (vr[1] == 'S'))
		|| ((vr[0] == 'L') && ((vr[1] == 'O') || (vr[1] == 'T')))
		|| ((vr[0] == 'P') && (vr[1] == 'N'))
		|| ((vr[0] == 'S') && ((vr[1] == 'H') || (vr[1] == 'L')
				|| (vr[1] == 'S') || (vr[1] == 'T')))
				|| ((vr[0] == 'T') && (vr[1] == 'M'))
				|| ((vr[0] == 'U') && ((vr[1] == 'I') || (vr[1] == 'L') || (vr[1] == 'S')));
	}

	/**
	 * @param vr
	 */
	public static final boolean isSignedLongVR(byte[] vr) {
		return (vr[0] == 'S') && (vr[1] == 'L');
	}

	/**
	 * @param vr
	 */
	public static final boolean isSignedShortVR(byte[] vr) {
		return (vr[0] == 'S') && (vr[1] == 'S');
	}

	/**
	 * @param vr
	 */
	public static final boolean isTimeVR(byte[] vr) {
		return (vr[0] == 'T') && (vr[1] == 'M');
	}

	/**
	 * @param vr
	 */
	public static final boolean isUniqueIdentifierVR(byte[] vr) {
		return (vr[0] == 'U') && (vr[1] == 'I');
	}

	/**
	 * @param vr
	 */
	public static final boolean isUnknownVR(byte[] vr) {
		return (vr[0] == 'U') && (vr[1] == 'N');
	}

	/**
	 * @param vr
	 */
	public static final boolean isUnlimitedTextVR(byte[] vr) {
		return (vr[0] == 'U') && (vr[1] == 'T');
	}

	/**
	 * @param vr
	 */
	public static final boolean isUnsignedLongVR(byte[] vr) {
		return (vr[0] == 'U') && (vr[1] == 'L');
	}

	/**
	 * @param vr
	 */
	public static final boolean isUnsignedShortVR(byte[] vr) {
		return (vr[0] == 'U') && (vr[1] == 'S');
	}

	/**
	 * @param vr
	 */
	public static final boolean isUnspecifiedShortOrOtherWordVR(byte[] vr) { // Not
		// a
		// real
		// VR
		// ...
		// but
		// returned
		// by
		// dictionary
		return (vr[0] == 'X') && (vr[1] == 'O');
	}

	public static final boolean isUnspecifiedShortOrOtherWordVR(
			ValueRepresentation aVR) { // Not a real VR ... but returned by
		// dictionary
		return aVR.equals("XO");
	}

	/**
	 * @param vr
	 */
	public static final boolean isUnspecifiedShortVR(byte[] vr) { // Not a real VR
		// ... but
		// returned by
		// dictionary
		return (vr[0] == 'X') && (vr[1] == 'S');
	}

	public static final boolean isUnspecifiedShortVR(ValueRepresentation aVR) { // Not
		// a
		// real
		// VR
		// ...
		// but
		// returned
		// by
		// dictionary
		return aVR.equals("XS");
	}

	/**
	 * the VR as a string
	 */
	private String code;

	/**
	 * the name
	 */
	private String name;

	/**
	 * create a new VR from bytes
	 * 
	 * @param aVR
	 */
	public ValueRepresentation(byte[] aVR) {
		this(new String(aVR), "");
	}

	/**
	 * creates a new VR from a VR's code and name
	 * 
	 * @param vrCode
	 * @param vrName
	 */
	public ValueRepresentation(String vrCode, String vrName) {
		assert vrCode != null;
		assert !vrCode.equals("");
		this.code = vrCode;
		this.name = vrName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(ValueRepresentation aValueRepresentation) {
		return this.toString().compareTo(aValueRepresentation.toString());
	}

	@Override
	public boolean equals(Object o) {
		/*if (o instanceof String) {
			return falsethis.toString().equals(o);
		}*/
		if (o instanceof ValueRepresentation) {
			return this.getCode().equals(((ValueRepresentation) o).getCode());
		}
		return false;
	}

	public String getCode() {
		return this.code;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int hashCode() {
		return this.code.hashCode();
	}

	public byte[] toBytes() {
		return this.code.getBytes();
	}

	@Override
	public String toString() {
		return "[" + this.code + "] " + this.getName();
	}

}
