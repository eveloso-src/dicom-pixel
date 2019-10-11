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
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.network.dimse.messages.support.CompositeDimseResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * C-Find response
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CFindResponseMessage extends CompositeDimseResponseMessage {

	private static Logger logger = LoggerFactory.getLogger(CFindResponseMessage.class);

	/**
	 * Creates a new message
	 * 
	 * @param aCommandSet
	 */
	public CFindResponseMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public CFindResponseMessage(int messageID, String affectedSOPClassUID) throws DicomException {
		super(messageID, affectedSOPClassUID);
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
	public CFindResponseMessage(int aMessageID, String aAffectedSOPClassUID,
			int aHasDataset, int aStatus) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		setStatus( aStatus );
		this.setCommandField(CommandSetType.C_FIND_RESPONSE.value());
	}

	@Override
	public void setMessagetype() throws DicomException {
		this.setCommandField(CommandSetType.C_FIND_RESPONSE.value());
	}

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		if (this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID)) {
			lBuffer.append("  SOPClass: " + this.getAffectedSOPClassName() + "\n");
		} else {
			logger.warn("No AffectedSOPClassUID");
		}
		lBuffer.append("  Status: " + this.statusToString() + "\n");
		if (this.getDataSet() != null) {
			lBuffer.append("DataSet: \n");
			lBuffer.append(this.getDataSet().toString());
		}
		return lBuffer.toString();
	}
	
	public CommandSetType getMessagetype() {
		return CommandSetType.C_FIND_RESPONSE;
	}

}
