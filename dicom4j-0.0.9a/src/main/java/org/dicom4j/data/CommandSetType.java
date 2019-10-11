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

import org.dicom4j.core.utils.IntValue;
import org.dicom4j.data.elements.ElementNotFoundException;

/**
 * Types of CommandSet
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CommandSetType extends IntValue {

	/**
	 * C-Cancel-Request
	 */
	public final static CommandSetType C_CANCEL_REQUEST = new CommandSetType(0x0FFF, "C-Cancel-Request");

	/**
	 * C-ECHO-REQUEST
	 */
	public final static CommandSetType C_ECHO_REQUEST = new CommandSetType(0x0030, "C-Echo-Request");

	/**
	 * C-ECHO-RESPONSE
	 */
	public final static CommandSetType C_ECHO_RESPONSE = new CommandSetType(
			0x8030, "C-Echo-Response");

	/**
	 * C-FIND-REQUEST
	 */
	public final static CommandSetType C_FIND_REQUEST = new CommandSetType(
			0x0020, "C-Find-Request");

	/**
	 * C-FIND-RESPONSE
	 */
	public final static CommandSetType C_FIND_RESPONSE = new CommandSetType(
			0x8020, "C-Find-Response");

	/**
	 * C-GET-RQ
	 */
	public final static CommandSetType C_GET_REQUEST = new CommandSetType(0x0010,
	"C-Get-Request");

	/**
	 * C-GET-RSP
	 */
	public final static CommandSetType C_GET_RESPONSE = new CommandSetType(
			0x8010, "c-Get-Response");

	/**
	 * C-MOVE-REQUEST
	 */
	public final static CommandSetType C_MOVE_REQUEST = new CommandSetType(
			0x0021, "C-Move-Request");

	/**
	 * C-MOVE-RESPONSE
	 */
	public final static CommandSetType C_MOVE_RESPONSE = new CommandSetType(
			0x8021, "C-Move-Response");

	/**
	 * C-STORE-RQ
	 */
	public final static CommandSetType C_STORE_REQUEST = new CommandSetType(
			0x0001, "C-Store-Request");

	/**
	 * C-STORE-RSP
	 */
	public final static CommandSetType C_STORE_RESPONSE = new CommandSetType(
			0x8001, "C-Strore-Response");

	/**
	 * N-CREATE-RQ
	 */
	public final static CommandSetType N_ACTION_REQUEST = new CommandSetType(
			0x0130, "N-Action-Request");

	/**
	 * N-CREATE-RSP
	 */
	public final static CommandSetType N_ACTION_RESPONSE = new CommandSetType(
			0x8130, "N-Action-Response");

	/**
	 * N-CREATE-RQ
	 */
	public final static CommandSetType N_CREATE_REQUEST = new CommandSetType(
			0x0140, "N_CREATE_RQ");

	/**
	 * N-CREATE-RSP
	 */
	public final static CommandSetType N_CREATE_RESPONSE = new CommandSetType(
			0x8140, "N-Create-Response");

	/**
	 * N-DELETE-RQ
	 */
	public final static CommandSetType N_DELETE_REQUEST = new CommandSetType(
			0x0150, "N_DELETE_RQ");

	/**
	 * N-DELETE-RSP
	 */
	public final static CommandSetType N_DELETE_RESPONSE = new CommandSetType(0x8150,
	"N_DELETE_RSP");

	/**
	 * N-EVENT-REPORT-RQ
	 */
	public final static CommandSetType N_EVENT_REPORT_REQUEST = new CommandSetType(
			0x0100, "N_EVENT_REPORT_REQUEST");

	/**
	 * N-EVENT-REPORT-RSP
	 */
	public final static CommandSetType N_EVENT_REPORT_RESPONSE = new CommandSetType(
			0x8100, "N-EVENT-REPORT-RESPONSE");

	/**
	 * N-GET-RQ
	 */
	public final static CommandSetType N_GET_REQUEST = new CommandSetType(0x0110,	"N-GET request");

	/**
	 * N-GET-RSP
	 */
	public final static CommandSetType N_GET_RSP = new CommandSetType(0x8110,
	"N_GET_RSP");

	/**
	 * N-SET-RQ
	 */
	public final static CommandSetType N_SET_REQUEST = new CommandSetType(0x0120,
	"N_SET_RQ");

	/**
	 * N-SET-RSP
	 */
	public final static CommandSetType N_SET_RSP = new CommandSetType(0x8120,
	"N_SET_RSP");

	public static final CommandSetType getCommandSetType(int aType)
	throws Exception {
		if (aType == C_STORE_REQUEST.value()) {
			return C_STORE_REQUEST;
		} else if (aType == C_STORE_RESPONSE.value()) {
			return C_STORE_RESPONSE;
		} else if (aType == C_GET_REQUEST.value()) {
			return C_GET_REQUEST;
		} else if (aType == C_GET_RESPONSE.value()) {
			return C_GET_RESPONSE;
		} else if (aType == C_FIND_REQUEST.value()) {
			return C_FIND_REQUEST;
		} else if (aType == C_FIND_RESPONSE.value()) {
			return C_FIND_RESPONSE;
		} else if (aType == C_MOVE_REQUEST.value()) {
			return C_MOVE_REQUEST;
		} else if (aType == C_MOVE_RESPONSE.value()) {
			return C_MOVE_RESPONSE;
		} else if (aType == C_ECHO_REQUEST.value()) {
			return C_ECHO_REQUEST;
		} else if (aType == C_ECHO_RESPONSE.value()) {
			return C_ECHO_RESPONSE;
		} else if (aType == N_EVENT_REPORT_REQUEST.value()) {
			return N_EVENT_REPORT_REQUEST;
		} else if (aType == N_EVENT_REPORT_REQUEST.value()) {
			return N_EVENT_REPORT_REQUEST;
		} else if (aType == N_GET_REQUEST.value()) {
			return N_GET_REQUEST;
		} else if (aType == N_GET_RSP.value()) {
			return N_GET_RSP;
		} else if (aType == N_SET_REQUEST.value()) {
			return N_SET_REQUEST;
		} else if (aType == N_SET_RSP.value()) {
			return N_SET_RSP;
		} else if (aType == N_ACTION_REQUEST.value()) {
			return N_ACTION_REQUEST;
		} else if (aType == N_ACTION_RESPONSE.value()) {
			return N_ACTION_RESPONSE;
		} else if (aType == N_CREATE_REQUEST.value()) {
			return N_CREATE_REQUEST;
		} else if (aType == N_CREATE_RESPONSE.value()) {
			return N_CREATE_RESPONSE;
		} else if (aType == N_DELETE_REQUEST.value()) {
			return N_DELETE_REQUEST;
		} else if (aType == N_DELETE_RESPONSE.value()) {
			return N_DELETE_RESPONSE;
		} else if (aType == C_CANCEL_REQUEST.value()) {
			return C_CANCEL_REQUEST;
		} else {
			throw new Exception(+aType + "is to a valid CommandType");
		}
	}

	/**
	 * Check if the Command is a CEcho (Request or Response)
	 * 
	 * @param aDimseCommand
	 *          the command
	 * @return true if C-ECho
	 */
	public static boolean isCEcho(CommandSet aDimseCommand) throws ElementNotFoundException {
		assert aDimseCommand != null;
		return (aDimseCommand.getCommandField() == C_ECHO_REQUEST.value())
		|| (aDimseCommand.getCommandField() == C_ECHO_RESPONSE.value());
	}

	public static final String toString(int aType) {
		try {
			return getCommandSetType(aType).valueAsString();
		} catch (Exception e) {
			return "Unknown CommandSet";
		}
	}

	public CommandSetType(int aValue, String aValueAsString) {
		super(aValue, aValueAsString);
	}

}
