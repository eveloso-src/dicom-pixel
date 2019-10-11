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

package org.dicom4j.network.protocoldataunit.items;

import org.dicom4j.network.protocoldataunit.ProtocolDataUnitType;

/**
 * Types of {@link ProtocolDataUnitItem}
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ProtocolDataUnitItemType extends ProtocolDataUnitType {

	/**
	 * ABSTRACT_SYNTAX
	 */
	public static final ProtocolDataUnitItemType ABSTRACT_SYNTAX = new ProtocolDataUnitItemType(
			(byte) 0x30, "Abstract Syntax");

	/**
	 * APPLICATION_CONTEXT
	 */
	public static final ProtocolDataUnitItemType APPLICATION_CONTEXT = new ProtocolDataUnitItemType(
			(byte) 0x10, "Application Context");

	/**
	 * PRESENTATION_CONTEXT_AC
	 */
	public static final ProtocolDataUnitItemType PRESENTATION_CONTEXT_AC = new ProtocolDataUnitItemType(
			(byte) 0x21, "PRESENTATION_CONTEXT_AC");

	/**
	 * PRESENTATION_CONTEXT_RQ
	 */
	public static final ProtocolDataUnitItemType PRESENTATION_CONTEXT_RQ = new ProtocolDataUnitItemType(
			(byte) 0x20, "PRESENTATION_CONTEXT_RQ");

	/**
	 * TRANSFERT_SYNTAX
	 */
	public static final ProtocolDataUnitItemType TRANSFERT_SYNTAX = new ProtocolDataUnitItemType(
			(byte) 0x40, "TRANSFERT_SYNTAX");

	/**
	 * USER_INFORMATION
	 */
	public static final ProtocolDataUnitItemType USER_INFORMATION = new ProtocolDataUnitItemType(
			(byte) 0x50, "User Information");

	public static String toString(byte type) {
		if (type == ABSTRACT_SYNTAX.value()) {
			return ABSTRACT_SYNTAX.name();
		} else if (type == APPLICATION_CONTEXT.value()) {
			return APPLICATION_CONTEXT.name();
		} else if (type == PRESENTATION_CONTEXT_RQ.value()) {
			return PRESENTATION_CONTEXT_RQ.name();
		} else if (type == PRESENTATION_CONTEXT_AC.value()) {
			return "PRESENTATION_CONTEXT_AC";
		} else if (type == TRANSFERT_SYNTAX.value()) {
			return "TRANSFERT_SYNTAX";
		} else if (type == USER_INFORMATION.value()) {
			return USER_INFORMATION.name();
		} else {
			return "Unkown Protocol Data Unit Item's type (byte: " + type + ")";
		}
	}

	/**
	 * creates new instance
	 * 
	 * @param type
	 * @param type
	 *          as string
	 */
	public ProtocolDataUnitItemType(byte type, String asString) {
		super(type, asString);
	}

}
