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

package org.dicom4j.dicom;

/**
 * <p>
 * a DICOM Tag (a Group and a Element)
 * </p>
 * 
 * <B>An instance is immutable</B>
 * 
 * <p>
 * Safe to use in hashed collections such as {@link java.util.Hashtable
 * Hashtable} and {@link java.util.HashMap HashMap} (i.e. it takes care to
 * implement {@link java.lang.Object#hashCode() hashCode()} and
 * {@link java.lang.Object#equals(Object) equals()} consistently).
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 * @version 0.0.4: adding isGroupLength
 * 
 */
public class DicomTag implements Comparable<DicomTag> {

	/**
	 * The Element
	 */
	private int fElement;

	/**
	 * the Group
	 */
	private int fGroup;

	/**
	 * the Name
	 */
	private String fName;

	/**
	 * the ValueRepresentation
	 */
	private ValueRepresentation fValueRepresentation;

	/**
	 * <p>
	 * Construct a DICOM data element (attribute) tag.
	 * </p>
	 * 
	 * @param group
	 *          the 16 bit unsigned binary group
	 * @param element
	 *          the 16 bit unsigned binary element
	 */
	public DicomTag(int group, int element) {
		this(group, element, "");
	}

	/**
	 * <p>
	 * Creates a new DICOM Tag
	 * </p>
	 * 
	 * @param aGroup
	 *          the 16 bit unsigned binary group
	 * @param aElement
	 *          the 16 bit unsigned binary element
	 * @param aName
	 *          the name of this tag
	 */
	public DicomTag(int aGroup, int aElement, String aName) {
		this(aGroup, aElement, aName, ValueRepresentation.Unknown);
	}

	/**
	 * <p>
	 * Creates a new DICOM Tag
	 * </p>
	 * 
	 * @param aGroup
	 *          the 16 bit unsigned binary group
	 * @param aElement
	 *          the 16 bit unsigned binary element
	 * @param aName
	 *          the name of this tag
	 * @param aVR
	 *          the {@link ValueRepresentation ValueRepresentation}
	 */
	public DicomTag(int aGroup, int aElement, String aName,
			ValueRepresentation aVR) {
		this.fGroup = aGroup;
		this.fElement = aElement;
		this.fName = aName;
		this.fValueRepresentation = aVR;
	}

	/**
	 * <p>
	 * Compare tags based on the numeric order of their group and then element
	 * values.
	 * </p>
	 * 
	 * @param o
	 *          the {@link org.dicom4j.dicom.DicomTag AttributeTag} to compare
	 *          this {@link org.dicom4j.dicom.DicomTag AttributeTag} against
	 * @return the value 0 if the argument tag is equal to this object; a value
	 *         less than 0 if this tag is less than the argument tag; and a value
	 *         greater than 0 if this tag is greater than the argument tag
	 */
	public int compareTo(DicomTag o) {
		return this.getLong().compareTo(o.getLong());
	}

	/**
	 * @Override <p>
	 *           Compare tags based on their group and element values.
	 *           </p>
	 * 
	 * @param aObject
	 *          the {@link org.dicom4j.dicom.DicomTag AttributeTag} to compare
	 *          this {@link org.dicom4j.dicom.DicomTag AttributeTag} against
	 * @return true if the same group and element number
	 */
	@Override
	public boolean equals(Object aObject) {
		if (aObject instanceof DicomTag) {
			return (this.fGroup == ((DicomTag) aObject).getGroup())
			&& (this.fElement == ((DicomTag) aObject).getElement());
		} else {
			return false;
		}
	}

	/**
	 * <p>
	 * Return the element value.
	 * </p>
	 * 
	 * @return the 16 bit unsigned binary element
	 */
	public int getElement() {
		return this.fElement;
	}

	public String getElementAsString() {
		StringBuffer str = new StringBuffer();
		str.append("0x");
		String groupString = Integer.toHexString(this.getElement());
		for (int i = groupString.length(); i < 4; ++i) {
			str.append("0");
		}
		str.append(groupString);
		// str.append(",0x");
		return str.toString();
	}

	/**
	 * <p>
	 * Get the group value.
	 * </p>
	 * 
	 * @return the 16 bit unsigned binary group
	 */
	public int getGroup() {
		return this.fGroup;
	}

	public String getGroupAsString() {
		StringBuffer str = new StringBuffer();
		str.append("0x");
		String groupString = Integer.toHexString(this.getGroup());
		for (int i = groupString.length(); i < 4; ++i) {
			str.append("0");
		}
		str.append(groupString);
		// str.append(",0x");
		return str.toString();
	}

	/**
	 * Set the name of this tag
	 * 
	 * @param aName
	 *          the name
	 */
	/*
	 * public void setName(String aName) { fName = aName; }
	 */

	/**
	 * <p>
	 * Get a single long integer which represents the tag.
	 * </p>
	 * 
	 * <p>
	 * The low 16 bits are filled with the element number and the next higher 16
	 * bits with the group number.
	 * </p>
	 * 
	 * @return the long integer representation of the tag
	 */
	private Long getLong() {
		return new Long(((long) this.fGroup << 16)
				+ ((long) this.fElement & 0xffff));
	}

	/**
	 * Return the name of this Tag
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.fName;
	}

	public ValueRepresentation getValueRepresentation() {
		return this.fValueRepresentation;
	}

	/**
	 * <p>
	 * Get a hash value which represents the tag.
	 * </p>
	 * 
	 * <p>
	 * This method is implemented to override {@link java.lang.Object#hashCode()
	 * java.lang.Object.hashCode()} so as to comply with the contract that two
	 * tags that return true for equals() will return the same value for
	 * hashCode(), which would not be the case unless overridden (i.e. two
	 * allocations of a tag with the same group and element would be equal but the
	 * default implementation would return different hash values).
	 * </p>
	 * 
	 * @return a hash value representing the tag
	 */
	@Override
	public int hashCode() {
		return (this.fGroup << 16) + (this.fElement & 0xffff);
	}

	/**
	 * <p>
	 * Is the tag a group length tag ?
	 * </p>
	 * 
	 * <p>
	 * Group Length tags are those with Element equals to 0.
	 * </p>
	 * 
	 * @return
	 */
	public boolean isGroupLength() {
		return this.fElement == 0;
	}

	/**
	 * <p>
	 * Is the tag a private tag ?
	 * </p>
	 * 
	 * <p>
	 * Private tags are those with odd-numbered groups.
	 * </p>
	 * 
	 * @return true if private
	 */
	public boolean isPrivate() {
		return this.fGroup % 2 != 0;
	}

	/**
	 * <p>
	 * Get a human-readable rendering of the tag.
	 * </p>
	 * 
	 * <p>
	 * This takes the form "(0xgggg,0xeeee)" where gggg and eeee are the
	 * zero-padded hexadecimal representations of the group and element
	 * respectively.
	 * </p>
	 * 
	 * @return the string rendering of the tag
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("(0x");
		String groupString = Integer.toHexString(this.fGroup);
		for (int i = groupString.length(); i < 4; ++i) {
			str.append("0");
		}
		str.append(groupString);
		str.append(",0x");
		String elementString = Integer.toHexString(this.fElement);
		for (int i = elementString.length(); i < 4; ++i) {
			str.append("0");
		}
		str.append(elementString);
		str.append(")");
		if (this.getName() != "") {
			str.append(" " + this.getName());
		} else {
			if (this.isPrivate()) {
				str.append(" Private");
			} else {
				str.append(" Unknow");
			}
		}
		return str.toString();
	}

}
