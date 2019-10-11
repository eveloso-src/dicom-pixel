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

package org.dicom4j.network.dimse.messages.support;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.uniqueidentifiers.SOPClasses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * base class for request with RequestedSOPClassUID
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class RequestedSOPClassUIDRequestMessage extends NormalizedMessage {

	/*
	 * public RequestedSOPClassUIDRequestMessage(int aMessageID, String
	 * aRequestedSOPClassUID) throws DicomException { this(aMessageID,
	 * aRequestedSOPClassUID, ""); }
	 */

	private static final Logger fLogger = LoggerFactory
	.getLogger(RequestedSOPClassUIDRequestMessage.class);

	public RequestedSOPClassUIDRequestMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public RequestedSOPClassUIDRequestMessage(int aMessageID,
			String aRequestedSOPClassUID, String aRequestedSOPInstanceUID)
	throws DicomException {
		super(aMessageID);
		this.setRequestedSOPClassUID(aRequestedSOPClassUID);
		this.setRequestedSOPInstanceUID(aRequestedSOPInstanceUID);
	}

	@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = new CommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(DataElements.newMessageID());
		lCommandSet.addElement(DataElements.newRequestedSOPClassUID());
		lCommandSet.addElement(DataElements.newRequestedSOPInstanceUID());
		return lCommandSet;
	}

	@Override
	protected UnsignedShort getMessageIDElement() {
		return this.getCommandSet().getUnsignedShort(DicomTags.MessageID);
	}

	public String getRequestedSOPClassUID() {
		return this.getCommandSet().getElement(DicomTags.RequestedSOPClassUID)
		.getSingleStringValue("");
	}

	public String getRequestedSOPInstanceUID() {
		return this.getCommandSet().getElement(DicomTags.RequestedSOPInstanceUID)
		.getSingleStringValue("");
	}

	public boolean hasRequestedSOPClassUID() {
		return this.getCommandSet().hasElement(DicomTags.RequestedSOPClassUID);
	}

	public boolean hasRequestedSOPInstanceUID() {
		return this.getCommandSet().hasElement(DicomTags.RequestedSOPInstanceUID);
	}

	public void setRequestedSOPClassUID(String aRequestedSOPClassUID)
	throws DicomException {
		fLogger.debug("setRequestedSOPClassUID: " + aRequestedSOPClassUID);
		this.getCommandSet().getUniqueIdentifier(DicomTags.RequestedSOPClassUID)
		.setValue(aRequestedSOPClassUID);
	}

	public void setRequestedSOPInstanceUID(String aRequestedSOPInstanceUID)
	throws DicomException {
		fLogger.debug("setRequestedSOPInstanceUID: " + aRequestedSOPInstanceUID);
		this.getCommandSet().getUniqueIdentifier(DicomTags.RequestedSOPInstanceUID)
		.setValue(aRequestedSOPInstanceUID);
	}

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		if (this.hasRequestedSOPClassUID()) {
			lBuffer.append("  Requested SOP ClassUID: "
					+ SOPClasses.toString(this.getRequestedSOPClassUID()) + "\n");
		} else {
			fLogger.warn("No RequestedSOPClassUID in " + this.getName());
		}
		if (this.hasRequestedSOPInstanceUID()) {
			lBuffer.append("  Requested SOP Instance UID: "
					+ this.getRequestedSOPInstanceUID() + "\n");
		} else {
			fLogger.warn("No Requested SOP Instance UID in " + this.getName());
		}
		if (this.getDataSet() != null) {
			lBuffer.append("DataSet: \n");
			lBuffer.append(this.getDataSet().toString());
		}
		return lBuffer.toString();
	}
}
