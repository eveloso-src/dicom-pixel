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

package org.dicom4j.dicom.CodedAttributes;

import org.dicom4j.dicom.CodedAttributes.support.CodedAttribute;
import org.dicom4j.dicom.CodedAttributes.support.CodedAttributeType;

/**
 * PersonSex
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class PersonSex extends CodedAttribute {

	public final static PersonSex Female = new PersonSex("F", "Female");

	public static final String FEMALE_SEX = "F";

	public final static PersonSex Male = new PersonSex("M", "Male");

	public static final String MALE_SEX = "M";

	public final static PersonSex Other = new PersonSex("O", "Other");

	public static final String OTHER_SEX = "O";

	public PersonSex(String aCode, String aValue) {
		super(CodedAttributeType.PERSON_SEX, aCode, aValue);
	}

}