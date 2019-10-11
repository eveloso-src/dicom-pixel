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

package org.dicom4j.dicom.uniqueidentifiers;

import org.dicom4j.core.utils.IntValue;

/**
 * Types of Unique Identifier
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class UniqueIdentifierType extends IntValue {

	/**
	 * Meta SOP Class
	 */
	public static final UniqueIdentifierType META_SOPCLASS = new UniqueIdentifierType(
			3, "Meta SOP Class");

	/**
	 * Modality
	 */
	public static final UniqueIdentifierType MODALITY = new UniqueIdentifierType(
			5, "Modality");

	/**
	 * SOP Class
	 */
	public static final UniqueIdentifierType SOPCLASS = new UniqueIdentifierType(
			2, "SOP Class");

	/**
	 * Transfer Syntax
	 */
	public static final UniqueIdentifierType TRANSFER_SYNTAX = new UniqueIdentifierType(
			1, "Transfer Syntax");

	/**
	 * Well-known frame of reference
	 */
	public static final UniqueIdentifierType WELL_KNOWN_FRAME_OF_REFERENCE = new UniqueIdentifierType(
			4, "Well-known frame of reference");

	/**
	 * creates new instance
	 * 
	 * @param atype
	 */
	public UniqueIdentifierType(int atype) {
		super(atype);
	}

	public UniqueIdentifierType(int aValue, String aValueAsString) {
		super(aValue, aValueAsString);
	}

}
