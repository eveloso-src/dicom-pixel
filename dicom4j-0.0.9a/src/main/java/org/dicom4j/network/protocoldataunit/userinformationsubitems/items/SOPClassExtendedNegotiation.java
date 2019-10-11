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

package org.dicom4j.network.protocoldataunit.userinformationsubitems.items;

import java.io.IOException;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.UserInformationSubItemType;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.support.AbstractUserInformationSubItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SOP Class Extended Negotiation (SUB-ITEM)
 * 
 * @since 0.0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class SOPClassExtendedNegotiation extends AbstractUserInformationSubItem {

	private static Logger fLogger = LoggerFactory.getLogger(SOPClassExtendedNegotiation.class);

	private String sopClassUID;

	private int sopClassUIDLength;

	public SOPClassExtendedNegotiation() {
		super();
	}

	@Override
	public int getLength() {
		return 0;
	}

	@Override
	public UserInformationSubItemType getType() {
		return UserInformationSubItemType.SOP_CLASS_EXTENDED_NEGOCIATION;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		fLogger.debug("Start reading, length: " + length);
		this.sopClassUIDLength = stream.readUnsigned16();
		this.sopClassUID = stream.readASCII(this.sopClassUIDLength);
		// TODO read the Service-class-applicationinformation
		stream.skip(length - 2 - this.sopClassUID.length());
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		// TODO Auto-generated method stub
		throw new DicomException("NOT SUPPORTED");
	}

}
