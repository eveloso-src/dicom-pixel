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
import java.nio.ByteOrder;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.UserInformationSubItemType;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.support.AbstractUserInformationSubItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementation Class UID (SUB-ITEM)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ImplementationClassUID extends AbstractUserInformationSubItem {

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(ImplementationClassUID.class);

	/**
	 * the value
	 */
	private String fValue;

	public ImplementationClassUID() {
		this("");
	}

	public ImplementationClassUID(String aValue) {
		super();
		this.setValue(aValue);
	}

	/**
	 * return the number of bytes of the item
	 * 
	 * @return number of bytes
	 */
	@Override
	public int getLength() {
		// 4 : type(1) + reserved(1) + length (2)
		return 4 + this.getValue().length();
	}

	// @Override
	/*
	 * public String getName() { return "Implementation Class UID"; }
	 */

	@Override
	public UserInformationSubItemType getType() {
		return UserInformationSubItemType.IMPLENTATIONCLASS_UID;
	}

	public String getValue() {
		assert this.fValue != null;
		return this.fValue;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		checkStream(stream);
		// logger.debug("Start reading (length: " + length + ")");
		this.fValue = stream.readASCII(length);
	}

	public void setValue(String aValue) {
		assert aValue != null;
		this.fValue = aValue;
	}

	@Override
	public String toString() {
		return this.getName() + ": " + this.getValue();
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
		stream.write(this.getType().value());
		stream.write(0x00); // reserverd
		stream.writeUnsigned16(this.getValue().length());
		stream.writeASCII(this.getValue());
	}

}
