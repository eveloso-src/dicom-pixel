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

package org.dicom4j.data;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * A class to encapsulate the functionality defined by the DICOM Specific
 * Character Set attribute, including the ability to parse the string values of
 * the attribute and then apply the appropriate character conversions from byte
 * array values into Java's internal Unicode representation contained in
 * {@link String}.
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class SpecificCharacterSet {

	/**
	 * the logger
	 */
	protected static Logger logger = LoggerFactory
	.getLogger(SpecificCharacterSet.class);

	/***/
	private String useEncoding;

	/***/
	private boolean useISO2022 = false;

	/***/
	// static private boolean useOwnJIS;
	/***/
	// static private boolean useOwnJISCheckPerformed;
	/***/
	// static private HashMap ownJIS0208Mapping;
	/***/
	// static private HashMap ownJIS0212Mapping;

	/**
	 * @param bytes
	 */
	// static private void dumpBytes(byte[] bytes) {
	// for (int i=0; i<bytes.length; ++i)
	// System.err.print(Integer.toHexString(((int)bytes[i])&0xff)+" ");
	// System.err.println();
	// }

	/**
	 * @return true if JIS encodings are working properly
	 */
	/*
	 * private boolean testIfNativeJISWorking() { boolean success=false; byte[]
	 * jis0208bytes = { (byte)0x3b,(byte)0x33,(byte)0x45,(byte)0x44 }; try {
	 * String string = new String(jis0208bytes,"JIS0208"); byte[] utf8Bytes =
	 * string.getBytes("UTF8");
	 * //System.err.println("testIfNativeJISWorking():src = ");
	 * dumpBytes(jis0208bytes);
	 * //System.err.println("testIfNativeJISWorking():dst = ");
	 * dumpBytes(utf8Bytes); // if not working will come back unchanged (3b 33 45
	 * 44) // if working will come back e5 b1 b1 e7 94 b0 success =
	 * utf8Bytes.length == 6 && (utf8Bytes[0]&0xff) == 0xe5 && (utf8Bytes[1]&0xff)
	 * == 0xb1 && (utf8Bytes[2]&0xff) == 0xb1 && (utf8Bytes[3]&0xff) == 0xe7 &&
	 * (utf8Bytes[4]&0xff) == 0x94 && (utf8Bytes[5]&0xff) == 0xb0 ; } catch
	 * (java.io.UnsupportedEncodingException e) { } return success; }
	 * 
	 * /**
	 */
	/*
	 * static private HashMap<Short, Character> initializeOwnMapping(String name)
	 * {
	 * //System.err.println("SpecificCharacterSet.initializeOwnMapping(): start "
	 * +name); HashMap<Short, Character> map=new HashMap<Short, Character>();
	 * InputStream ownMappingSourceStream =
	 * SpecificCharacterSet.class.getResourceAsStream
	 * ("/com/pixelmed/dicom/"+name); if (ownMappingSourceStream != null) {
	 * //System.err.println("Opening "+name); BufferedReader reader = new
	 * BufferedReader(new InputStreamReader(ownMappingSourceStream)); String line;
	 * try { while ((line=reader.readLine()) != null) {
	 * //System.err.println("Read "+line); StringTokenizer tokens = new
	 * StringTokenizer(line); if (tokens.countTokens() == 2) { // the decode
	 * method handles the 0x // can't use Short.decode() because some values
	 * "too large" Short jisvalue = new
	 * Short(Integer.decode(tokens.nextToken()).shortValue()); Character univalue
	 * = new Character((char)(Integer.decode(tokens.nextToken()).shortValue()));
	 * //System.err.println("Decoded 0x"+Integer.toHexString(jisvalue.intValue())+
	 * " to 0x"+Integer.toHexString(univalue.charValue()));
	 * map.put(jisvalue,univalue); } } } catch (IOException e) {
	 * e.printStackTrace(System.err); } }
	 * //System.err.println("SpecificCharacterSet.initializeOwnMapping(): done "
	 * +name); return map; }
	 * 
	 * /**
	 */
	/*
	 * static private void initializeOwnJIS0208Mapping() {
	 * ownJIS0208Mapping=initializeOwnMapping("JIS0208Mapping.dat"); }
	 */

	/**
	 */
	// static private void initializeOwnJIS0212Mapping() {
	// ownJIS0212Mapping=initializeOwnMapping("JIS0212Mapping.dat");
	// }

	/**
	 * <p>
	 * Construct a character set handler from the values of the Specific Character
	 * Set attribute.
	 * </p>
	 * 
	 * @param specificCharacterSetAttributeValues
	 *          the values of Specific Character Set
	 */
	public SpecificCharacterSet(String[] specificCharacterSetAttributeValues) {
		// System.err.println("SpecificCharacterSet(): specificCharacterSetAttributeValues="+specificCharacterSetAttributeValues);
		// this.specificCharacterSetAttributeValues=specificCharacterSetAttributeValues;
		this.useEncoding = null;
		this.useISO2022 = false;
		/*
		 * if (!useOwnJISCheckPerformed) { useOwnJIS=!testIfNativeJISWorking();
		 * //System.err.println("SpecificCharacterSet(): useOwnJIS="+useOwnJIS);
		 * useOwnJISCheckPerformed=true; }
		 */
		if ((specificCharacterSetAttributeValues != null)
				&& (specificCharacterSetAttributeValues.length >= 1)) {
			String firstValue = specificCharacterSetAttributeValues[0];
			logger.debug("SpecificCharacterSet,firstValue: " + firstValue);
			// System.err.println("SpecificCharacterSet(): firstValue="+firstValue);
			if ((firstValue == null) || firstValue.equals("")) {
				this.useEncoding = "ASCII";
			} else if (firstValue.equals("ISO_IR 100")) {
				this.useEncoding = "ISO8859_1";
			} else if (firstValue.equals("ISO_IR 101")) {
				this.useEncoding = "ISO8859_2";
			} else if (firstValue.equals("ISO_IR 109")) {
				this.useEncoding = "ISO8859_3";
			} else if (firstValue.equals("ISO_IR 110")) {
				this.useEncoding = "ISO8859_4";
			} else if (firstValue.equals("ISO_IR 144")) {
				this.useEncoding = "ISO8859_5";
			} else if (firstValue.equals("ISO_IR 127")) {
				this.useEncoding = "ISO8859_6";
			} else if (firstValue.equals("ISO_IR 126")) {
				this.useEncoding = "ISO8859_7";
			} else if (firstValue.equals("ISO_IR 138")) {
				this.useEncoding = "ISO8859_8";
			} else if (firstValue.equals("ISO_IR 148")) {
				this.useEncoding = "ISO8859_9";
			} else if (firstValue.equals("ISO_IR 166")) {
				this.useEncoding = "TIS620";
			} else if (firstValue.equals("ISO_IR 192")) {
				this.useEncoding = "UTF8";
			} else if (firstValue.equals("GB18030")) {
				this.useEncoding = "GB18030";
			} else if (firstValue.equals("ISO_IR 13")) {
				this.useEncoding = "JIS0201";
			} else if (firstValue.equals("ISO 2022 IR 13")) {
				this.useISO2022 = true;
				this.useEncoding = "JIS0201"; // i.e. start with this before any escape
				// sequences seen
			} else {
				this.useEncoding = "ASCII";
			}
			// Now look at any remaining values, solely to determine whether or not
			// ISO2022 code extension techniques will be used
			for (int i = 1; i < specificCharacterSetAttributeValues.length; ++i) {
				String nextValue = specificCharacterSetAttributeValues[i];
				if ((nextValue != null) && nextValue.startsWith("ISO 2022")) {
					this.useISO2022 = true;
					// the actual character set is irrelevant, since it is activated later
					// by a specific escape sequence anyway
				}
			}
		} else {
			this.useEncoding = "ASCII";
		}
		// System.err.println("SpecificCharacterSet(): useEncoding="+useEncoding);
	}

	/**
	 * <p>
	 * Translate a byte array (such as a value from a DICOM attribute), using the
	 * specified Specific Character Set, into a {@link java.lang.String String}.
	 * 
	 * @param bytes
	 *          the bytes to translate
	 * @param offset
	 *          the offset into the byte array to start translation
	 * @param length
	 *          how many bytes to translate
	 * @param useMapping
	 */
	/*
	 * private String translateByteArrayToString(byte[] bytes,int offset,int
	 * length,HashMap<?, ?> useMapping) { String s = null; if (useMapping != null)
	 * { StringBuffer buf = new StringBuffer(length/2); for (int i=offset;
	 * i<offset+length;) { short hibyte = (short)(((bytes[i++])) & 0xff); short
	 * lobyte = (short)(((bytes[i++])) & 0xff); short lookup = (short)((hibyte<<8)
	 * | lobyte); Character c = (Character)useMapping.get(new Short(lookup));
	 * //System
	 * .err.println("Mapped from 0x"+Integer.toHexString(lookup)+" to "+c); if (c
	 * != null) buf.append(c.charValue()); } s=buf.toString(); } return s; }
	 */

	public String translateByteArrayToString(byte[] bytes) {
		return this.translateByteArrayToString(bytes, 0, bytes.length);
	}

	/**
	 * <p>
	 * Translate a byte array (such as a value from a DICOM attribute), using the
	 * specified Specific Character Set, into a {@link java.lang.String String}.
	 * 
	 * @param bytes
	 *          the bytes to translate
	 * @param offset
	 *          the offset into the byte array to start translation
	 * @param length
	 *          how many bytes to translate
	 * @return the string decoded according to the specific character set
	 */
	public String translateByteArrayToString(byte[] bytes, int offset, int length) {
		String s = null;
		if (this.useEncoding == null) {
			s = new String(bytes, 0, length);
		} else {
			if (this.useISO2022) {
				// start at beginning with useEncoding (from 1st value of Specific
				// Character Set)
				// and use that until we see an escape sequence
				// note that this is all a bit hokey since we are assuming a lot about
				// what is in GL vs. GR
				// and are using the scape sequence to switch both which is a bit
				// naughty
				StringBuffer sbuf = new StringBuffer();
				int done = 0;
				int startlast = 0;
				int bytesperchar = 1;
				String lastEncoding = this.useEncoding;
				while (done < length) {
					// System.err.println("SpecificCharacterSet.translateByteArrayToString() looping startlast="+startlast+" done="+done);
					if (bytes[done] == 0x1b) { // escape character
						if (done > startlast) {
							sbuf.append(this.translateByteArrayToString(bytes, startlast,
									done - startlast, lastEncoding));
						}
						if ((bytes[done + 1] == 0x28) && (bytes[done + 2] == 0x42)) {
							lastEncoding = "ASCII"; // IR 6 ISO 646
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x41)) {
							lastEncoding = "ISO8859_1"; // IR 100
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x42)) {
							lastEncoding = "ISO8859_2"; // IR 101
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x43)) {
							lastEncoding = "ISO8859_3"; // IR 109
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x44)) {
							lastEncoding = "ISO8859_4"; // IR 110
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x4c)) {
							lastEncoding = "ISO8859_5"; // IR 144
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x47)) {
							lastEncoding = "ISO8859_6"; // IR 127
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x46)) {
							lastEncoding = "ISO8859_7"; // IR 126
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x48)) {
							lastEncoding = "ISO8859_8"; // IR 138
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x4d)) {
							lastEncoding = "ISO8859_9"; // IR 148
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x2d) && (bytes[done + 2] == 0x54)) {
							lastEncoding = "TIS620"; // IR 166
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x29) && (bytes[done + 2] == 0x49)) {
							lastEncoding = "JIS0201"; // IR 13
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x28) && (bytes[done + 2] == 0x4a)) {
							lastEncoding = "JIS0201"; // IR 13
							bytesperchar = 1;
							done += 3;
						} else if ((bytes[done + 1] == 0x24) && (bytes[done + 2] == 0x42)) {
							lastEncoding = "JIS0208"; // IR 87
							bytesperchar = 2;
							done += 3;
						} else if ((bytes[done + 1] == 0x24) && (bytes[done + 2] == 0x28)
								&& (bytes[done + 3] == 0x44)) {
							lastEncoding = "JIS0212"; // IR 159
							bytesperchar = 2;
							done += 4;
						} else if ((bytes[done + 1] == 0x24) && (bytes[done + 2] == 0x29)
								&& (bytes[done + 3] == 0x43)) {
							lastEncoding = "Cp949"; // IR 149 KS X 1001
							bytesperchar = -1; // flag to trigger high bit based selection of
							// 1 or 2 bytes
							done += 4;
						} else {
							done += 3;
						}
						startlast = done;
					} else {
						done += (bytesperchar == -1 ? ((bytes[done] & 0x80) == 1 ? 2 : 1)
								: bytesperchar);
					}
				}
				if (done > startlast) {
					sbuf.append(this.translateByteArrayToString(bytes, startlast, done
							- startlast, lastEncoding));
				}
				s = sbuf.toString();
			} else {
				s = this.translateByteArrayToString(bytes, 0, length, this.useEncoding);
			}
		}
		return s;
	}

	/**
	 * <p>
	 * Translate a byte array (such as a value from a DICOM attribute), using the
	 * specified encoding, into a {@link java.lang.String String}.
	 * 
	 * @param bytes
	 *          the bytes to translate
	 * @param offset
	 *          the offset into the byte array to start translation
	 * @param length
	 *          how many bytes to translate
	 * @param useEncoding
	 *          the encoding to use
	 */
	private String translateByteArrayToString(byte[] bytes, int offset,
			int length, String useEncoding) {
		// System.err.println("SpecificCharacterSet.translateByteArrayToString() useEncoding="+useEncoding+" offset="+offset+" length="+length);
		String s = null;
		/*
		 * if (length > 0 && useOwnJIS && useEncoding.equals("JIS0208")) {
		 * //System.err.println(
		 * "SpecificCharacterSet.translateByteArrayToString() using own JIS0208");
		 * if (ownJIS0208Mapping == null) { initializeOwnJIS0208Mapping(); }
		 * s=translateByteArrayToString(bytes,offset,length,ownJIS0208Mapping); }
		 */
		// else if (length > 0 && useOwnJIS && useEncoding.equals("JIS0212")) {
		// if (ownJIS0212Mapping == null) {
		// initializeOwnJIS0212Mapping();
		// }
		// s=translateByteArrayToString(bytes,offset,length,ownJIS0212Mapping);
		// }
		// else {
		try {
			s = new String(bytes, offset, length, useEncoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(System.err);
			// s=new String(bytes,offset,length);
		}
		// }
		return s;
	}

	/**
	 * <p>
	 * Encode a string into a byte array.
	 * </p>
	 * 
	 * <p>
	 * Does not currently support ISO 2022 (or JIS 0208 or 0212 if 1.4.1 bug
	 * present).
	 * </p>
	 * 
	 * @param string
	 *          the string to be encoded
	 * @return the byte array encoded according to the specific character set
	 * @exception UnsupportedEncodingException
	 */
	public byte[] translateStringToByteArray(String string) throws UnsupportedEncodingException {
		return this.useEncoding == null ? string.getBytes() : string
				.getBytes(this.useEncoding);
	}

}
