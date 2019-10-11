package org.dicom4j.core.utils;

import java.util.StringTokenizer;

/**
 * <p>
 * Various static methods helpful for comparing and manipulating strings.
 * </p>
 * 
 * @author dclunie
 */
public class StringUtilities {
	private static final String identString = "@(#) $Header: /userland/cvs/pixelmed/imgbook/com/pixelmed/utils/StringUtilities.java,v 1.5 2003/09/25 22:19:26 dclunie Exp $";

	/**
	 * <p>
	 * Compare strings based on their integer value of they are both integers,
	 * otherwise their lexicographic order.
	 * </p>
	 * 
	 * <p>
	 * For example, <code>"001"</code> and<code>"1"</code> would be treated as
	 * equal, whilst <code>"1"</code> would be considered as occuring before
	 * <code>"10"</code>, which would not be the case with a simple lexicographic
	 * ordering.
	 * </p>
	 * 
	 * @param s1
	 *          the first of two strings to be compared
	 * @param s2
	 *          the first of two strings to be compared
	 * @return the value 0 if the first string is equal to the second string; a
	 *         value less than 0 if the first string is less than the second
	 *         string; and a value greater than 0 if the first string is greater
	 *         than the second string
	 */
	static public final int compareStringsThatMayBeIntegers(String s1, String s2) {
		try {
			return Integer.parseInt(s1) - Integer.parseInt(s2);
		} catch (NumberFormatException e) {
			// System.err.println("compareStringsThatMayBeIntegers: falling back to
			// string");
			return s1.compareTo(s2);
		}
	}

	/**
	 * <p>
	 * Compare strings based on the lexicographic order of their values, but
	 * accounting for non-zero padded integers.
	 * </p>
	 * 
	 * <p>
	 * Note that the comparison is more complex than a simple lexicographic
	 * comparison of strings (as described in the definition of
	 * {@link java.lang.String#compareTo(String)
	 * java.lang.String.compareTo(String)} but rather accounts for embedded
	 * non-zero padded integers by treating occurrences of space delimited
	 * integers as integer values rather than strings. For example,
	 * <code>"a 001 b"</code> and<code>"a 1 b"</code> would be treated as equal,
	 * whilst <code>"a 1 b"</code> would be considered as occuring before
	 * <code>"a 10 b"</code>, which would not be the case with a simple
	 * lexicographic ordering.
	 * </p>
	 * 
	 * @param s1
	 *          the first of two strings to be compared
	 * @param s2
	 *          the first of two strings to be compared
	 * @return the value 0 if the first string is equal to the second string; a
	 *         value less than 0 if the first string is lexicographically less
	 *         than the second string; and a value greater than 0 if the first
	 *         string is lexicographically greater than the second string
	 */
	static public final int compareStringsWithEmbeddedNonZeroPaddedIntegers(
			String s1, String s2) {
		StringTokenizer st1 = new StringTokenizer(s1);
		StringTokenizer st2 = new StringTokenizer(s2);
		int c = 0;
		while (st1.hasMoreElements() && st2.hasMoreElements()) {
			String t1 = st1.nextToken();
			String t2 = st2.nextToken();
			c = compareStringsThatMayBeIntegers(t1, t2);
			// System.err.println("compareStringsWithEmbeddedNonZeroPaddedIntegers:
			// looping with <"+t1+"> and <"+t2+"> c="+c);
			if (c != 0) {
				return c;
			}
		}
		c = st1.hasMoreElements() ? 1 : st1.hasMoreElements() ? -1 : 0;
		return c;
	}

	/**
	 * <p>
	 * Unit testing.
	 * </p>
	 * 
	 * @param arg
	 *          ignored
	 */
	public static void main(String arg[]) {
		String s;
		s = "1234";
		System.err.println("src <" + s + "> dst <" + removeTrailingSpaces(s) + ">");
		s = "1234  ";
		System.err.println("src <" + s + "> dst <" + removeTrailingSpaces(s) + ">");
		s = "12  34  ";
		System.err.println("src <" + s + "> dst <" + removeTrailingSpaces(s) + ">");
		s = "  1234";
		System.err.println("src <" + s + "> dst <" + removeTrailingSpaces(s) + ">");
		s = "  1234  ";
		System.err.println("src <" + s + "> dst <" + removeTrailingSpaces(s) + ">");
		s = "1";
		System.err.println("src <" + s + "> dst <" + removeTrailingSpaces(s) + ">");
		s = " ";
		System.err.println("src <" + s + "> dst <" + removeTrailingSpaces(s) + ">");
		s = "    ";
		System.err.println("src <" + s + "> dst <" + removeTrailingSpaces(s) + ">");
		s = "";
		System.err.println("src <" + s + "> dst <" + removeTrailingSpaces(s) + ">");

		String s1;
		String s2;

		s1 = "this is 2 way";
		s2 = "this is 2 way";
		System.err.println("s1 <" + s1 + "> s2 <" + s2 + "> : compare ="
				+ compareStringsWithEmbeddedNonZeroPaddedIntegers(s1, s2));

		s1 = "this is 2 way";
		s2 = "this is 10 way";
		System.err.println("s1 <" + s1 + "> s2 <" + s2 + "> : compare ="
				+ compareStringsWithEmbeddedNonZeroPaddedIntegers(s1, s2));

		s1 = "this is 10 way";
		s2 = "this is 2 way";
		System.err.println("s1 <" + s1 + "> s2 <" + s2 + "> : compare ="
				+ compareStringsWithEmbeddedNonZeroPaddedIntegers(s1, s2));

		s1 = "this is 2 way";
		s2 = "this is 2 way plus";
		System.err.println("s1 <" + s1 + "> s2 <" + s2 + "> : compare ="
				+ compareStringsWithEmbeddedNonZeroPaddedIntegers(s1, s2));

		s1 = "this is 2 way";
		s2 = "this is 10 way plus";
		System.err.println("s1 <" + s1 + "> s2 <" + s2 + "> : compare ="
				+ compareStringsWithEmbeddedNonZeroPaddedIntegers(s1, s2));

		s1 = "this is 10 way";
		s2 = "this is 2 way plus";
		System.err.println("s1 <" + s1 + "> s2 <" + s2 + "> : compare ="
				+ compareStringsWithEmbeddedNonZeroPaddedIntegers(s1, s2));

	}

	/**
	 * <p>
	 * Remove any trailing instances of a particular character from a string.
	 * </p>
	 * 
	 * @param src
	 *          the string that may have trailing spaces
	 * @param rmchar
	 *          the character, all trailing instances of which are to be removed
	 * @return the value of the string argument with any instances of the trailing
	 *         character removed
	 */
	static public final String removeTrailingCharacter(String src, char rmchar) {
		char[] c = src.toCharArray();
		int l = c.length;
		int n = l;
		while ((n > 0) && (c[n - 1] == rmchar)) {
			--n;
		}
		return n == l ? src : n > 0 ? new String(c, 0, n) : "";
	}

	/**
	 * <p>
	 * Remove any trailing spaces from a string.
	 * </p>
	 * 
	 * @param src
	 *          the string that may have trailing spaces
	 * @return the value of the string argument with any trailing spaces removed
	 */
	static public final String removeTrailingSpaces(String src) {
		return removeTrailingCharacter(src, ' ');
	}

	private StringUtilities() {
	}
}