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

import org.dicom4j.network.DicomNetworkException;

/**
 * Common Exception related to PDU
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ProtocolDataUnitException extends DicomNetworkException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2800395185242419752L;

	private byte fReason;

	/**
	 * Construct a new ProtocolDataUnitException
	 * 
	 * @param aReason
	 *          The reason of exception
	 * @param aMessage
	 * @see org.dicom4j.network.protocoldataunit.pdu.AAbortPDU.Reasons
	 */
	public ProtocolDataUnitException(byte aReason, String aMessage) {
		super(aMessage);
		this.fReason = aReason;
	}

	public ProtocolDataUnitException(String aMessage) {
		super(aMessage);
	}

	public ProtocolDataUnitException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public byte getReason() {
		return this.fReason;
	}

}
