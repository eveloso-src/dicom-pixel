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

package org.dicom4j.dicom.CodedAttributes.support;

/**
 * Abstract coded attribute
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class CodedAttribute {

	// private CodedAttributeType type;

	protected String code;

	// private int fType;

	private CodedAttributeType type;

	protected String value;

	protected CodedAttribute(CodedAttributeType type, String code, String value) {
		super();
		this.type = type;
		// this.type = type;
		this.code = code;
		this.value = value;
	}

	/**
	 * Create new CodedAttribute
	 * 
	 * @param aType
	 * @param aUID
	 * @param aName
	 */
	protected CodedAttribute(int aType, String aCode, String aValue) {
		super();
		// fType = aType;
		this.code = aCode;
		this.value = aValue;
	}

	/**
	 * Return the UID
	 * 
	 * @return the UID
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * return the type of this coded attribute
	 * 
	 * @return The type of UID
	 */
	public CodedAttributeType getType() {
		return this.type;
	}

	/**
	 * return the value of the coded attribute
	 * 
	 * @return the value
	 */
	public String getValue() {
		return this.value;
	}

	@Override
	public String toString() {
		return "[" + this.getCode() + "] " + this.getValue();
	}

}
