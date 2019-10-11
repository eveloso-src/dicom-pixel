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

package org.dicom4j.network.protocoldataunit.userinformationsubitems.support;

import java.io.IOException;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;

/**
 * Abstract class of all UserInformationSubItem
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractUserInformationSubItem extends AbstractProtocolDataUnit {

	protected AbstractUserInformationSubItem() {
		super();
	}

	/**
	 * @deprecated
	 * @param aReader
	 * @param aLength
	 * @throws DicomException
	 * @throws IOException
	 */
	@Deprecated
	protected AbstractUserInformationSubItem(BinaryInputStream aReader,
			int aLength) throws DicomException, IOException {
		super();
		this.read(aReader, aLength);
	}

	/**
	 * Return the length contains in the PDU, this length depends of the PDU's
	 * type
	 */
	protected int getInnerLength() {
		return 0;
	}

	// muse use Reader/Writer
	@Deprecated 
	protected void writeBase(BinaryOutputStream aStream) throws DicomException, IOException {
		AbstractProtocolDataUnit.checkStream(aStream);
		aStream.write(this.getType().value());
		aStream.write(0x00); // reserved
		aStream.writeUnsigned16(this.getInnerLength());
	}
}
