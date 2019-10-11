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
import org.dicom4j.network.dimse.messages.support.DimseRequestMessage;

/**
 * C-GET-RQ
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CGetRequestMessage extends DimseRequestMessage {

	public CGetRequestMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public CGetRequestMessage(int aMessageID, String aAffectedSOPClassUID)
	throws DicomException {
		this(aMessageID, aAffectedSOPClassUID, DimsePriority.MEDIUM.value());
	}

	public CGetRequestMessage(int aMessageID, String aAffectedSOPClassUID,
			int aPriority) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		this.setCommandField(CommandSetType.C_GET_REQUEST.value());
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
		return lCommandSet;
	}

	/**
	 * get the priority
	 * 
	 * @return the priority
	 */
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
	
	public CommandSetType getMessagetype() {
		return CommandSetType.C_GET_REQUEST;
	}

	// private static Logger fLogger =
	// LoggerFactory.getLogger(CGetRequestMessage.class);
}
