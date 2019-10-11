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
 * Maximum Length (SUB-ITEM)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class MaximumLength extends AbstractUserInformationSubItem {

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory.getLogger(MaximumLength.class);

	/**
	 * the value
	 */
	private long value;

	public MaximumLength() {
		this(0);
	}

	public MaximumLength(long aValue) {
		super();
		this.setValue(aValue);
	}

	@Override
	public int getLength() {
		return 8;
	}

	@Override
	public UserInformationSubItemType getType() {
		return UserInformationSubItemType.MAXIMUM_LENGTH;
	}

	public long getValue() {
		return this.value;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		checkStream(stream);
		// logger.debug("Start reading (length: " + length + ")");
		if (length != 4) {
			logger.warn(length + " is not a valid length for a " + this.getName()
					+ " sub item");
		}
		this.setValue(stream.readUnsigned32());
	}

	public void setValue(long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return this.getName() + ": " + this.getValue();
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		checkStream(stream);
		stream.write(this.getType().value());
		stream.write(0x00); // reserverd
		stream.writeUnsigned16(4); // 4: value is Unsigned32
		stream.writeUnsigned32(this.getValue());
	}

}
