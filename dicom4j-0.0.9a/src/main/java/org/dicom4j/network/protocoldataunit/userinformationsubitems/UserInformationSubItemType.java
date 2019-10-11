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

package org.dicom4j.network.protocoldataunit.userinformationsubitems;

import org.dicom4j.network.protocoldataunit.ProtocolDataUnitType;

/**
 * UserInformation Sub Item's type
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class UserInformationSubItemType extends ProtocolDataUnitType {

	/**
	 * ASYNCHRONOUS OPERATIONS WINDOW
	 */
	public static final UserInformationSubItemType ASYNCHRONOUS_OPERATIONS_WINDOW = new UserInformationSubItemType(
			(byte) 0x53, "Asynchronous operations window");

	/**
	 * ASYNCHRONOUS_OPERATIONS_WINDOW (byte)
	 */
	public static final byte ASYNCHRONOUS_OPERATIONS_WINDOW_BYTE = 0x53;

	/**
	 * IMPLEMENTATION VERSION NAME
	 */
	public static final UserInformationSubItemType IMPLEMENTATION_VERSION_NAME = new UserInformationSubItemType(
			(byte) 0x55, "Implementation version name");

	/**
	 * IMPLENTATIONCLASS UID
	 */
	public static final UserInformationSubItemType IMPLENTATIONCLASS_UID = new UserInformationSubItemType(
			(byte) 0x52, "Implementation class uid");

	/**
	 * IMPLENTATIONCLASS UID (byte)
	 */
	public static final byte IMPLENTATIONCLASS_UID_BYTE = 0x52;

	/**
	 * MAXIMUM LENGTH
	 */
	public static final UserInformationSubItemType MAXIMUM_LENGTH = new UserInformationSubItemType(
			(byte) 0x51, "Maximum Length");

	/***
	 * @deprecated
	 */
	@Deprecated
	public static final byte MAXIMUM_LENGTH_BYTE = 0x51;

	/**
	 * SCP SCU ROLE SELECTION item type
	 */
	public static final UserInformationSubItemType SCP_SCU_ROLE_SELECTION = new UserInformationSubItemType(
			(byte) 0x54, "SCP/SCU role selection");

	/**
	 * SOP CLASS COMMON EXTENDED NEGOTIATION
	 */
	public static final UserInformationSubItemType SOP_CLASS_COMMON_EXTENDED_NEGOTIATION = new UserInformationSubItemType(
			(byte) 0x57, "SOP_CLASS_COMMON_EXTENDED_NEGOTIATION");

	/**
	 * SOP CLASS EXTENDED NEGOCIATION
	 */
	public static final UserInformationSubItemType SOP_CLASS_EXTENDED_NEGOCIATION = new UserInformationSubItemType( (byte) 0x56, "SOP class extented negotiation");

	/**
	 * User Identity
	 */
	public static final UserInformationSubItemType USER_IDENTITY = new UserInformationSubItemType(
			(byte) 0x58, "User Identity");

	public static String toString(byte aType) {
		if (aType == MAXIMUM_LENGTH.value()) {
			return MAXIMUM_LENGTH.name();
		} else if (aType == IMPLENTATIONCLASS_UID.value()) {
			return "IMPLENTATIONCLASS UID";
		} else if (aType == ASYNCHRONOUS_OPERATIONS_WINDOW.value()) {
			return "Asynchronous Operations Window";
		} else if (aType == SCP_SCU_ROLE_SELECTION.value()) {
			return "SCP SCU ROLE SELECTION";
		} else if (aType == IMPLEMENTATION_VERSION_NAME.value()) {
			return "Implementation Version Name";
		} else if (aType == SOP_CLASS_EXTENDED_NEGOCIATION.value()) {
			return "SOP class extend negociation";
		} else if (aType == SOP_CLASS_COMMON_EXTENDED_NEGOTIATION.value()) {
			return "SOP CLASS COMMON EXTENDED NEGOTIATION";
		} else if (aType == USER_IDENTITY.value()) {
			return USER_IDENTITY.name();
		} else {
			return "UNKNOW INFORMATION SUB ITEM";
		}
	}

	public UserInformationSubItemType(byte aValue, String aValueAsString) {
		super(aValue, aValueAsString);
	}

}
