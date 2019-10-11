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
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.network.dimse.DimsePriority;
import org.dicom4j.dicom.uniqueidentifiers.SOPClasses;
import org.dicom4j.network.dimse.DimseException;
import org.dicom4j.network.dimse.messages.support.DimseResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * N-ACTION-RESPONSE
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class NActionResponse extends DimseResponseMessage {

	private static Logger fLogger = LoggerFactory
	.getLogger(NActionResponse.class);

	/**
	 * Creates a new message
	 * 
	 * @param aCommandSet
	 */
	public NActionResponse(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public NActionResponse(int aMessageID, String aAffectedSOPClassUID)
	throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		this.setCommandField(CommandSetType.N_ACTION_RESPONSE.value());
		this.setDataSetType(CommandSet.NO_DATASET);
		this.setDataSetType(DimsePriority.MEDIUM.value());
	}

	public NActionResponse(int aMessageID, String aAffectedSOPClassUID,
			int aStatus) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID, CommandSet.NO_DATASET, aStatus);
		this.setCommandField(CommandSetType.N_ACTION_RESPONSE.value());
	}

	/**
	 * Creates a new message
	 * 
	 * @param aMessageID
	 * @param aAffectedSOPClassUID
	 * @param aHasDataset
	 * @param aStatus
	 * @throws DicomException
	 */
	public NActionResponse(int aMessageID, String aAffectedSOPClassUID,
			int aHasDataset, int aStatus) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID, aHasDataset, aStatus);
		this.setCommandField(CommandSetType.N_ACTION_RESPONSE.value());
	}

	public NActionResponse(int aMessageID, String aRequestedSOPClassUID,
			String aAffectedSOPClassUID, int aStatus) throws DicomException {
		this(aMessageID, aRequestedSOPClassUID, aStatus);
		this.setAffectedSOPInstanceUID(aAffectedSOPClassUID);
	}

	@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = super.createCommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(DataElements.newAffectedSOPInstanceUID());
		return lCommandSet;
	}

	@Override
	public String getAffectedSOPInstanceUID() {
		try {
			if (this.getCommandSet().hasElement(DicomTags.AffectedSOPInstanceUID)) {
				return this.getCommandSet().getUniqueIdentifier(
						DicomTags.AffectedSOPInstanceUID).getSingleStringValue().trim();
			} else {
				return "";
			}
		} catch (Exception e) {
			fLogger.warn(e.getMessage());
			return "";
		}
	}

	@Override
	public UniqueIdentifier getAffectedSOPInstanceUIDElement()
	throws DicomException {
		return this.getCommandSet().getUniqueIdentifier(
				DicomTags.AffectedSOPInstanceUID);
	}

	public boolean hasAffectedSOPInstanceUID() {
		return this.getCommandSet().hasElement(DicomTags.AffectedSOPInstanceUID);
	}

	public void setAffectedSOPInstanceUID(String AffectedSOPInstanceUID)
	throws DicomException, DimseException {
		if (this.hasAffectedSOPInstanceUID()) {
			this.getAffectedSOPInstanceUIDElement().setValue(AffectedSOPInstanceUID);
		} else {
			throw new DimseException("No AffectedSOPInstanceUID in CommandSet");
		}
	}

	@Override
	public void setMessagetype() throws DicomException {
		this.setCommandField(CommandSetType.N_ACTION_RESPONSE.value());
	}

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		if (this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID)) {
			lBuffer.append("  SOPClass: "
					+ SOPClasses.toString(this.getAffectedSOPClassUID()) + "\n");
		} else {
			fLogger.warn("No AffectedSOPClassUID");
		}
		lBuffer.append("  Status: " + this.statusToString() + "\n");
		if (this.getDataSet() != null) {
			lBuffer.append("DataSet: \n");
			lBuffer.append(this.getDataSet().toString());
		}
		return lBuffer.toString();
	}

	public CommandSetType getMessagetype() {
		return CommandSetType.N_ACTION_RESPONSE;
	}
	
}
