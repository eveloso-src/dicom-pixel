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
 * Availability
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class Availability extends CodedAttribute {

	/**
	 * NEARLINE
	 */
	public final static Availability NEARLINE = new Availability("NEARLINE",
	"NEARLINE");

	public final static Availability OFFLINE = new Availability("OFFLINE",
	"OFFLINE");

	public final static Availability Online = new Availability("ONLINE", "Online");

	public final static Availability UNAVAILABLE = new Availability(
			"UNAVAILABLE", "UNAVAILABLe");

	public Availability(String aCode, String aValue) {
		super(CodedAttributeType.Availability, aCode, aValue);
	}
}
