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
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.network.dimse.DimsePriority;
import org.dicom4j.dicom.uniqueidentifiers.SOPClasses;
import org.dicom4j.network.dimse.DimseConst;
import org.dicom4j.network.dimse.messages.support.DimseRequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * C-MOVE-REQUEST
 * 
 * @since Alpha 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CMoveRequestMessage extends DimseRequestMessage {

	private static Logger fLogger = LoggerFactory
	.getLogger(CMoveRequestMessage.class);

	/**
	 * Creates a new message from a {@link CommandSet CommandSet}
	 * 
	 * @param aCommandSet
	 *          the CommandSet
	 */
	public CMoveRequestMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	/**
	 * Creates a new message
	 * 
	 * @param aMessageID
	 * @param aAffectedSOPClassUID
	 * @throws DicomException
	 */
	public CMoveRequestMessage(int aMessageID, String aAffectedSOPClassUID)
	throws DicomException {
		this(aMessageID, aAffectedSOPClassUID, DimsePriority.MEDIUM.value());
	}

	/**
	 * Creates a new message
	 * 
	 * @param aMessageID
	 * @param aAffectedSOPClassUID
	 * @param aPriority
	 * @throws DicomException
	 */
	public CMoveRequestMessage(int aMessageID, String aAffectedSOPClassUID,
			int aPriority) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		this.setCommandField(CommandSetType.C_MOVE_REQUEST.value());
		this.setDataSetType(CommandSet.HAS_DATASET);
		this.setPriority(aPriority);
	}

	@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = new CommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(new UnsignedShort(DicomTags.MessageID));
		lCommandSet.addElement(new UniqueIdentifier(DicomTags.AffectedSOPClassUID));
		lCommandSet.addElement(new UnsignedShort(DicomTags.Priority));
		lCommandSet.addElement(DataElements.newMoveDestination());
		return lCommandSet;
	}

	public String getMoveDestination() {
		try {
			return this.getCommandSet().getApplicationEntity(
					DicomTags.MoveDestination).getSingleStringValue().trim();
		} catch (Exception e) {
			fLogger.warn(e.getMessage());
			return "";
		}
	}

	@Override
	public String getName() {
		return "C-MOVE-REQUEST";
	}

	public int getPriority() {
		return this.getCommandSet().getUnsignedShort(DicomTags.Priority)
		.getIntegerValue(0);
	}

	/**
	 * set the Priority
	 * 
	 * @param aPriority
	 * @throws DicomException
	 */
	public void setPriority(int aPriority) throws DicomException {
		this.getCommandSet().getUnsignedShort(DicomTags.Priority).setValue(
				aPriority);
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
		// lBuffer.append(" Command: " +
		// CommandSetTypes.typeToString(getCommandField())+"\n");
		// lBuffer.append(" Message: " + getMessageID() + "\n");
		lBuffer.append("  Priority: "
				+ DimseConst.priorityToString(this.getPriority()) + "\n");
		lBuffer.append("  MoveDestination: " + this.getMoveDestination() + "\n");
		if (this.getDataSet() != null) {
			lBuffer.append("DataSet: \n");
			lBuffer.append(this.getDataSet().toString());
		}
		return lBuffer.toString();
	}

	public CommandSetType getMessagetype() {
		return CommandSetType.C_MOVE_REQUEST;
	}
	
}
