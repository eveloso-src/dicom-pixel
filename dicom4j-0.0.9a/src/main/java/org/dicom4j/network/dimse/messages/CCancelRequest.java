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

package org.dicom4j.network.dimse.messages;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.CommandSetType;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.network.dimse.messages.support.AbstractDimseMessage;

/**
 * C-CANCEL-RQ
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CCancelRequest extends AbstractDimseMessage {

	/**
	 * Creates a new message
	 * 
	 * @param aCommandSet
	 */
	public CCancelRequest(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	/**
	 * Creates a new message
	 * 
	 * @param aMessageID
	 * @throws DicomException
	 */
	public CCancelRequest(int aMessageID) throws DicomException {
		super(aMessageID);
		this.setCommandField(CommandSetType.C_CANCEL_REQUEST.value());
		this.setDataSetType(CommandSet.NO_DATASET);
	}

	@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = new CommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(DataElements.newMessageIDBeingRespondedTo());
		return lCommandSet;
	}

	@Override
	protected UnsignedShort getMessageIDElement() {
		return this.getCommandSet().getUnsignedShort(
				DicomTags.MessageIDBeingRespondedTo);
	}

	@Override
	public String getName() {
		return "C-CANCEL-REQUEST";
	}

	@Override
	public String toString() {
		return this.getName();
	}

	public CommandSetType getMessagetype() {
		return CommandSetType.C_CANCEL_REQUEST;
	}
	
}

