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
 * Asynchronous Operations Window (SUB-ITEM)
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AsynchronousOperationsWindow extends
AbstractUserInformationSubItem {

	private static Logger logger = LoggerFactory
	.getLogger(AsynchronousOperationsWindow.class);

	private int maximumNumberOperationsInvoked;

	private int maximumNumberOperationsPerformed;

	@Override
	protected int getInnerLength() {
		return 4; // 2 Signed16
	}

	@Override
	public int getLength() {
		return 8; // see PS 3.7 (annexe D)
	}

	/**
	 * get the Maximum Number Operations Invoked value
	 * 
	 * @return Returns the maximumNumberOperationsInvoked.
	 */
	public int getMaximumNumberOperationsInvoked() {
		return this.maximumNumberOperationsInvoked;
	}

	/**
	 * get the Maximum Number Operations Performed value
	 * 
	 * @return Returns the maximumNumberOperationsPerformed.
	 */
	public int getMaximumNumberOperationsPerformed() {
		return this.maximumNumberOperationsPerformed;
	}

	@Override
	public UserInformationSubItemType getType() {
		return UserInformationSubItemType.ASYNCHRONOUS_OPERATIONS_WINDOW;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("Start reading (length: " + length + ")");
		this.maximumNumberOperationsInvoked = stream.readSigned16();
		this.maximumNumberOperationsPerformed = stream.readSigned16();
		logger.debug("reading completed");
	}

	/**
	 * set the Maximum Number Operations Invoked value
	 * 
	 * @param maximumNumberOperationsInvoked
	 *          The maximumNumberOperationsInvoked to set.
	 */
	public void setMaximumNumberOperationsInvoked(
			int maximumNumberOperationsInvoked) {
		logger.debug("setMaximumNumberOperationsPerformed: "
				+ maximumNumberOperationsInvoked);
		this.maximumNumberOperationsInvoked = maximumNumberOperationsInvoked;
	}

	/**
	 * set the Maximum Number Operations Performed value
	 * 
	 * @param maximumNumberOperationsPerformed
	 *          The maximumNumberOperationsPerformed to set.
	 */
	public void setMaximumNumberOperationsPerformed(
			int maximumNumberOperationsPerformed) {
		logger.debug("setMaximumNumberOperationsPerformed: "
				+ maximumNumberOperationsPerformed);
		this.maximumNumberOperationsPerformed = maximumNumberOperationsPerformed;
	}

	/**
	 * the Item as String
	 */
	@Override
	public String toString() {
		return this.getName() + "(MaximumNumberOperationsInvoked: "
		+ this.maximumNumberOperationsInvoked
		+ ", MaximumNumberOperationsPerformed: "
		+ this.maximumNumberOperationsPerformed + ")";
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		logger.debug("Start writing");
		this.writeBase(stream);
		stream.writeUnsigned16(this.maximumNumberOperationsInvoked);
		stream.writeUnsigned16(this.maximumNumberOperationsPerformed);
		logger.debug("writing completed");
	}

}
