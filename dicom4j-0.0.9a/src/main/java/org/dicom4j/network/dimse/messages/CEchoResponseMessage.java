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
 * C-Echo response
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CEchoResponseMessage extends CompositeDimseResponseMessage {

	private static Logger logger = LoggerFactory.getLogger(CEchoResponseMessage.class);

	public CEchoResponseMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public CEchoResponseMessage(int messageIDBeingRespondedTo, String affectedSOPClassUID) throws DicomException {
		super(messageIDBeingRespondedTo, affectedSOPClassUID);
	}
	
	public CEchoResponseMessage(int messageIDBeingRespondedTo, String affectedSOPClassUID, int status) throws DicomException {
		super(messageIDBeingRespondedTo, affectedSOPClassUID); 
		setStatus( status );
	}

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		if (this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID)) {
			lBuffer.append("  SOP Class: " + this.getAffectedSOPClassName() + "\n");
		} else {
			logger.warn("No AffectedSOPClassUID");
		}
		lBuffer.append("  Status: " + this.statusToString() + "\n");
		return lBuffer.toString();
	}
	
	@Override
	public CommandSetType getMessagetype() {
		return CommandSetType.C_ECHO_RESPONSE;
	}

}
