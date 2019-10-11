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

package org.dicom4j.dicom.network;

import org.dicom4j.core.utils.ByteValue;

/**
 * Associate Abort Reasons
 * 
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateAbortReason {

	/**
	 * INVALID_PDU_PARAMETER_VALUE
	 */
	public static final ByteValue INVALID_PDU_PARAMETER_VALUE = new ByteValue(
			(byte) 6, "INVALID_PDU_PARAMETER_VALUE");

	/**
	 * REASON_NOT_SPECIFIED
	 */
	public static final ByteValue REASON_NOT_SPECIFIED = new ByteValue((byte) 0,
	"REASON_NOT_SPECIFIED");

	/**
	 * RESERVED
	 */
	public static final ByteValue RESERVED = new ByteValue((byte) 3, "Reserved");

	/**
	 * Unexpected PDU
	 */
	public static final ByteValue UNEXPECTED_PDU = new ByteValue((byte) 2,
	"Unexpected PDU");

	/**
	 * UNEXPECTED_PDU_PARAMETER
	 */
	public static final ByteValue UNEXPECTED_PDU_PARAMETER = new ByteValue(
			(byte) 5, "UNEXPECTED_PDU_PARAMETER");

	/**
	 * UNRECOGNIZED_PDU
	 */
	public static final ByteValue UNRECOGNIZED_PDU = new ByteValue((byte) 1,
	"UNRECOGNIZED_PDU");

	/**
	 * UNRECOGNIZED_PDU_PARAMETER
	 */
	public static final ByteValue UNRECOGNIZED_PDU_PARAMETER = new ByteValue(
			(byte) 4, "UNRECOGNIZED_PDU_PARAMETER");
}
