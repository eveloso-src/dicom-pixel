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

/**
 * Exception to notify when a PDU's type doesn't match to a dicom's type
 * 
 * @since 0.0.8
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class UnrecognizedPDUException extends ProtocolDataUnitException {

	private static final long serialVersionUID = 1L;

	public UnrecognizedPDUException() {
		super("Unrecognized pdu");
	}

	/**
	 * <p>
	 * create a new exception when a byte value doesn't match to a valid PDU's
	 * type
	 * <p>
	 * 
	 * @since 0.0.4
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 * @param type
	 *          the invalid byte value
	 */
	public UnrecognizedPDUException(byte type) {
		super(type + " is not a valid ProtocolDataUnit's type");
	}

}
