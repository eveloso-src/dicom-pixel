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
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.uniqueidentifiers.SOPClasses;
import org.dicom4j.network.dimse.messages.support.DimseRequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * N-CREATE request
 * 
 * @since Alpha 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class NCreateRequest extends DimseRequestMessage {

	private static Logger fLogger = LoggerFactory.getLogger(NCreateRequest.class);

	/**
	 * Creates a new message from a {@link CommandSet CommandSet}
	 * 
	 * @param aCommandSet
	 *          the CommandSet
	 */
	public NCreateRequest(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public NCreateRequest(int aMessageID, String aAffectedSOPClassUID)
	throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		this.setCommandField(CommandSetType.N_CREATE_REQUEST.value());
		this.setDataSetType(CommandSet.NO_DATASET);
	}

	@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = new CommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(new UnsignedShort(DicomTags.MessageID));
		lCommandSet.addElement(new UniqueIdentifier(DicomTags.AffectedSOPClassUID));
		lCommandSet.addElement(new UniqueIdentifier(
				DicomTags.AffectedSOPInstanceUID));
		return lCommandSet;
	}

	public String getAffectedSOPInstanceUID() throws DicomException {
		return this.getCommandSet().getUniqueIdentifier(
				DicomTags.AffectedSOPInstanceUID).getSingleStringValue();
	}

	@Override
	protected UnsignedShort getMessageIDElement() {
		return this.getCommandSet().getUnsignedShort(DicomTags.MessageID);
	}

	public void setAffectedSOPInstanceUID(String aAffectedSOPInstanceUID)
	throws DicomException {
		this.getCommandSet().getUniqueIdentifier(DicomTags.AffectedSOPInstanceUID)
		.setValue(aAffectedSOPInstanceUID);
	}

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		if (this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID)) {
			lBuffer.append("  SOPClass: "
					+ SOPClasses.toString(this.getAffectedSOPClassUID()) + "\n");
		} else {
			fLogger.warn("No AffectedSOPClassUID in " + this.getName());
		}
		if (this.getDataSet() != null) {
			lBuffer.append("DataSet: \n");
			lBuffer.append(this.getDataSet().toString());
		}
		return lBuffer.toString();
	}
	
	public CommandSetType getMessagetype() {
		return CommandSetType.N_CREATE_REQUEST;
	}
}
