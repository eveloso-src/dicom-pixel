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

package org.dicom4j.network.protocoldataunit;

import org.dicom4j.core.utils.ByteValue;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit.Types;

/**
 * Type of {@link AbstractProtocolDataUnit}
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ProtocolDataUnitType extends ByteValue {

	/**
	 * A-ABORT
	 */
	public final static ProtocolDataUnitType A_ABORT = new ProtocolDataUnitType(
			(byte) 0x07, "A-Abort");

	/**
	 * A-ABORT
	 */
	public final static byte A_ABORT_BYTE = 0x07;

	/**
	 * A-ASSOCIATE-AC
	 */
	public final static ProtocolDataUnitType A_ASSOCIATE_AC = new ProtocolDataUnitType(
			(byte) 0x02, "A-ASSOCIATE-AC");

	/**
	 * A-ASSOCIATE-AC
	 */
	public final static byte A_ASSOCIATE_AC_BYTE = 0x02;

	/**
	 * A-ASSOCIATE-RQ type
	 */
	public final static ProtocolDataUnitType A_ASSOCIATE_RQ = new ProtocolDataUnitType(
			(byte) 0x01, "A-ASSOCIATE-RQ");

	/**
	 * A-ASSOCIATE-RQ byte value
	 */
	public final static byte A_ASSOCIATE_RQ_BYTE = 0x01;

	/**
	 * A-RELEASE-RP as ProtocolDataUnitType
	 */
	public final static ProtocolDataUnitType A_RELEASE_RP = new ProtocolDataUnitType(
			(byte) 0x06, "A-RELEASE-RP");

	/**
	 * A-RELEASE-RP as byte
	 */
	public final static byte A_RELEASE_RP_BYTE = 0x06;

	/**
	 * A-RELEASE-RQ
	 */
	public final static ProtocolDataUnitType A_RELEASE_RQ = new ProtocolDataUnitType(
			(byte) 0x05, "A-RELEASE-RQ");

	/**
	 * A-RELEASE-RQ
	 */
	public final static byte A_RELEASE_RQ_BYTE = 0x05;

	/**
	 * ASSOCIATE-RJ as ProtocolDataUnitType
	 */
	public final static ProtocolDataUnitType ASSOCIATE_RJ = new ProtocolDataUnitType(
			(byte) 0x03, "ASSOCIATE-RJ");

	/**
	 * ASSOCIATE-RJ as byte
	 */
	public final static byte ASSOCIATE_RJ_BYTE = 0x03;

	/**
	 * P-DATA-TF
	 */
	public final static ProtocolDataUnitType P_DATA_TF = new ProtocolDataUnitType(
			(byte) 0x04, "P-DATA-TF");

	/**
	 * P-DATA-TF
	 */
	public final static byte P_DATA_TF_BYTE = 0x04;

	/**
	 * Return a type of PDU as String
	 * 
	 * @param type
	 *          type of PDU
	 * @return PDU as string
	 */
	public static String typetoString(byte type) {
		if (type == ProtocolDataUnitType.A_ASSOCIATE_RQ.value()) {
			return ProtocolDataUnitType.A_ASSOCIATE_RQ.name();
		} else if (type == Types.A_ASSOCIATE_AC) {
			return "A-ASSOCIATE-AC";
		} else if (type == Types.ASSOCIATE_RJ) {
			return "ASSOCIATE-RJ";
		} else if (type == Types.P_DATA_TF) {
			return "P-DATA-TF";
		} else if (type == Types.A_RELEASE_RQ) {
			return "A-RELEASE-RQ";
		} else if (type == Types.A_RELEASE_RP) {
			return "A-RELEASE-RP";
		} else if (type == Types.A_ABORT) {
			return "A-ABORT";
		} else {
			return "Unkonw Protocol Data Unit item (byte:" + type + ")";
		}
	}

	public ProtocolDataUnitType(byte type, String name) {
		super(type, name);
	}

	public String name() {
		return this.getAsString();
	}

	/**
	 * get the type as String
	 * 
	 * @return the type
	 */
	@Override
	public String toString() {
		return this.name();
	}

}
