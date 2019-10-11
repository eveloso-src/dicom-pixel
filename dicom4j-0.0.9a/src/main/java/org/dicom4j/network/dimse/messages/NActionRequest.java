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
import org.dicom4j.dicom.DicomException;
import org.dicom4j.network.dimse.messages.support.RequestedSOPClassUIDRequestMessage;

/**
 * N-ACTION request
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class NActionRequest extends RequestedSOPClassUIDRequestMessage {

	public NActionRequest(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public NActionRequest(int aMessageID, String aRequestedSOPClassUID)
	throws DicomException {
		this(aMessageID, aRequestedSOPClassUID, "");
	}

	public NActionRequest(int aMessageID, String aRequestedSOPClassUID,
			String aRequestedSOPInstanceUID) throws DicomException {
		super(aMessageID, aRequestedSOPClassUID, aRequestedSOPInstanceUID);
		this.setCommandField(CommandSetType.N_ACTION_REQUEST.value());
		this.setDataSetType(CommandSet.NO_DATASET);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dicom4j.network.dimse.messages.DimseMessage#createCommandSet()
	 */
	@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = super.createCommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(DataElements.newActionTypeID());
		return lCommandSet;
	}

	public CommandSetType getMessagetype() {
		return CommandSetType.N_ACTION_REQUEST;
	}
	
	// private static Logger fLogger =
	// LoggerFactory.getLogger(NActionRequest.class);

}
