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
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.uniqueidentifiers.SOPClasses;
import org.dicom4j.network.dimse.messages.support.DimseResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * N-CREATE-RSP
 * 
 * @since Alpha 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class NCreateResponse extends DimseResponseMessage {

	private static Logger fLogger = LoggerFactory
	.getLogger(NCreateResponse.class);

	public NCreateResponse(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public NCreateResponse(int aMessageID, String aAffectedSOPClassUID)
	throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
	}

	public NCreateResponse(int aMessageID, String aAffectedSOPClassUID,
			int aStatus) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		this.setStatus(aStatus);
	}

	public NCreateResponse(int aMessageID, String aAffectedSOPClassUID,
			int aHasDataset, int aStatus) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		this.setDataSetType(aHasDataset);
		this.setStatus(aStatus);
	}

	@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = super.createCommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(new UniqueIdentifier(
				DicomTags.AffectedSOPInstanceUID));
		return lCommandSet;
	}

	@Override
	public String getAffectedSOPInstanceUID() throws DicomException {
		return this.getCommandSet().getUniqueIdentifier(
				DicomTags.AffectedSOPInstanceUID).getSingleStringValue();
	}

	public void setAffectedSOPInstanceUID(String aAffectedSOPInstanceUID)
	throws DicomException {
		this.getCommandSet().getUniqueIdentifier(DicomTags.AffectedSOPInstanceUID)
		.setValue(aAffectedSOPInstanceUID);
	}

	@Override
	protected void setMessagetype() throws DicomException {
		this.setCommandField(CommandSetType.N_CREATE_RESPONSE.value());
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
		return CommandSetType.N_CREATE_RESPONSE;
	}

}
