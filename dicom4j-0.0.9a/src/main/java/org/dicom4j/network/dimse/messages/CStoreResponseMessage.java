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
import org.dicom4j.network.dimse.DimseConst;
import org.dicom4j.network.dimse.DimseException;
import org.dicom4j.network.dimse.messages.support.CompositeDimseResponseMessage;
import org.dicom4j.network.dimse.messages.support.DimseResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * C-STORE-RSP
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CStoreResponseMessage extends CompositeDimseResponseMessage {

	private static Logger logger = LoggerFactory.getLogger(CStoreResponseMessage.class);

	public CStoreResponseMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public CStoreResponseMessage(int aMessageID, String aAffectedSOPClassUID,
			int aStatus) throws DimseException, DicomException {
		this(aMessageID, aAffectedSOPClassUID, CommandSet.NO_DATASET, aStatus);
	}

	public CStoreResponseMessage(int messageID, String affectedSOPClassUID) throws DicomException {
		super(messageID, affectedSOPClassUID);
	}
	
	public CStoreResponseMessage(int messageID, String affectedSOPClassUID,int aHasDataset, int aStatus) throws DicomException {
		super(messageID, affectedSOPClassUID);
		setStatus( aStatus );
		this.setCommandField(CommandSetType.C_STORE_RESPONSE.value());
	}

	public CStoreResponseMessage(int aMessageID, String aAffectedSOPClassUID,
			String AffectedSOPInstanceUID) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		this.setCommandField(CommandSetType.C_STORE_RESPONSE.value());
		this.setStatus(DimseConst.Status.Success);
		this.setAffectedSOPInstanceUID(AffectedSOPInstanceUID);
	}

	/*@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = super.createCommandSet();
		lCommandSet.addElement(new UniqueIdentifier(
				DicomTags.AffectedSOPInstanceUID));
		return lCommandSet;
	}*/

	@Override
	public String getAffectedSOPInstanceUID() throws DicomException {
		return this.getCommandSet().getUniqueIdentifier(
				DicomTags.AffectedSOPInstanceUID).getSingleStringValue();
	}

	public String getAffectedSOPInstanceUIDorBlank() {
		try {
			return this.getCommandSet().getUniqueIdentifier(
					DicomTags.AffectedSOPInstanceUID).getSingleStringValue();
		} catch (Exception e) {
			logger.warn("getAffectedSOPInstanceUIDorBlank: " + e.getMessage());
			return "";
		}
	}

	public boolean hasAffectedSOPInstanceUID() {
		return this.getCommandSet().hasElement(DicomTags.AffectedSOPInstanceUID);
	}

	public void setAffectedSOPInstanceUID(String aValue) throws DicomException {
		logger.debug("setAffectedSOPInstanceUID: " + aValue);
		this.getCommandSet().getUniqueIdentifier(DicomTags.AffectedSOPInstanceUID)
		.setValue(aValue);
	}

	@Override
	public void setMessagetype() throws DicomException {
		this.setCommandField(CommandSetType.C_STORE_RESPONSE.value());
	}

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		if (this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID)) {
			lBuffer.append("  SOPClass: " + this.getAffectedSOPClassName() + "\n");
		} else {
			logger.error("No AffectedSOPClassUID");
		}
		lBuffer.append("  Status: " + this.statusToString() + "\n");
		if (this.hasAffectedSOPInstanceUID()) {
			try {
				lBuffer.append("  Affected SOP Instance UID: "
						+ this.getAffectedSOPInstanceUID() + "\n");
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} else {
			lBuffer.append("  No Affected SOP Instance UID");
		}
		if (this.hasErrorCommentElement()) {
			lBuffer.append("  Error comments: " + this.getErrorComment());
		}

		if (this.getDataSet() != null) {
			lBuffer.append("DataSet: \n");
			lBuffer.append(this.getDataSet().toString());
		}
		return lBuffer.toString();
	}

	public CommandSetType getMessagetype() {
		return CommandSetType.C_STORE_RESPONSE;
	}
	
}
