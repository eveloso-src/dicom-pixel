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

import java.io.IOException;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.network.protocoldataunit.support.AbstractAReleasePDU;

/**
 * A-RELEASE-RQ PDU (see DICOM PS 3.8)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AReleaseRQPDU extends AbstractAReleasePDU {

	/**
	 * Creates a A-Release-RQ PDU
	 */
	public AReleaseRQPDU() {
		super();
	}

	/**
	 * Creates a A-RELEASE-RQ PDU
	 * 
	 * @param aStream
	 *          the stream
	 * @param aLength
	 *          the length to read
	 * @exception DicomException
	 * @exception IOException
	 */
	public AReleaseRQPDU(BinaryInputStream aStream, int aLength)
	throws DicomException, IOException {
		super(aStream, aLength);
	}

	@Override
	public ProtocolDataUnitType getType() {
		return ProtocolDataUnitType.A_RELEASE_RQ;
	}

	/**
	 * The PDU as a string
	 */
	@Override
	public String toString() {
		return this.getName();
	}

}
