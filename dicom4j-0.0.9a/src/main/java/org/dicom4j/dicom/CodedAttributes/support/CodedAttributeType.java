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

import org.dicom4j.core.utils.IntValue;

/**
 * CodedAttribute's type
 * 
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CodedAttributeType extends IntValue {

	public static final CodedAttributeType Availability = new CodedAttributeType(
			3, "Availability");

	public static final CodedAttributeType DirectoryRecordType = new CodedAttributeType(
			4, "Directory Record Type");

	public static final CodedAttributeType MODALITY = new CodedAttributeType(1,
	"Modality");

	public static final CodedAttributeType PERSON_SEX = new CodedAttributeType(2,
	"Person Sex");

	public CodedAttributeType(int value, String name) {
		super(value, name);
	}

}
