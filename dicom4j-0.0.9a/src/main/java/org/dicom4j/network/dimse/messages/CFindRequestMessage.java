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
import org.dicom4j.dicom.network.dimse.DimsePriority;
import org.dicom4j.dicom.uniqueidentifiers.SOPClasses;
import org.dicom4j.network.dimse.DimseConst;
import org.dicom4j.network.dimse.messages.support.CompositeDimseRequestWithPriorityMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * C-FIND request
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CFindRequestMessage extends CompositeDimseRequestWithPriorityMessage {

	private static Logger logger = LoggerFactory.getLogger(CFindRequestMessage.class);

	/**
	 * Creates a new message from a {@link CommandSet CommandSet}
	 * 
	 * @param commandSet
	 *          the CommandSet
	 */
	public CFindRequestMessage(CommandSet commandSet) {
		super(commandSet);
	}

	/**
	 * Creates a new message
	 * 
	 * @param messageID
	 * @param affectedSOPClassUID
	 * @throws DicomException
	 */
	public CFindRequestMessage(int messageID, String affectedSOPClassUID) throws DicomException {
		super(messageID, affectedSOPClassUID);
		//this.setDataSetType(CommandSet.HAS_DATASET);
	}

	/**
	 * Creates a new message
	 * 
	 * @param aMessageID
	 * @param aAffectedSOPClassUID
	 * @param aPriority
	 * @throws DicomException
	 */
	public CFindRequestMessage(int aMessageID, String aAffectedSOPClassUID,
			int aPriority) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		this.setCommandField(CommandSetType.C_FIND_REQUEST.value());
		this.setDataSetType(CommandSet.HAS_DATASET);
		this.setPriority(aPriority);
	}

	/*@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = new CommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(new UnsignedShort(DicomTags.MessageID));
		lCommandSet.addElement(new UniqueIdentifier(DicomTags.AffectedSOPClassUID));
		lCommandSet.addElement(new UnsignedShort(DicomTags.Priority));
		return lCommandSet;
	}*/

	/*@Override
	public String getName() {
		return "C-FIND-REQUEST";
	}
*/
	/*public int getPriority() {
		return this.getCommandSet().getUnsignedShort(DicomTags.Priority)
		.getIntegerValue(0);
	}

	/**
	 * set the Priority
	 * 
	 * @param aPriority
	 * @throws DicomException
	 */
	/*public void setPriority(int aPriority) throws DicomException {
		this.getCommandSet().getUnsignedShort(DicomTags.Priority).setValue(
				aPriority);
	}*/

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		if (this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID)) {
			try {
				lBuffer.append("  SOPClass: "
						+ SOPClasses.toString(this.getAffectedSOPClassUID()) + "\n");
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		} else {
			logger.warn("No AffectedSOPClassUID in " + this.getName());
		}
		// lBuffer.append(" Command: " +
		// CommandSetTypes.typeToString(getCommandField())+"\n");
		// lBuffer.append(" Message: " + getMessageID() + "\n");
		lBuffer.append("  Priority: " + this.getPriorityAsString() + "\n");
		// lBuffer.append(" DataSet: " +
		// CommandSet.datasetTypeToString(getDataSetType())+"\n");
		if (this.getDataSet() != null) {
			lBuffer.append("DataSet: \n");
			lBuffer.append(this.getDataSet().toString());
		}
		return lBuffer.toString();
	}
	
	public CommandSetType getMessagetype() {
		return CommandSetType.C_FIND_REQUEST;
	}

}
