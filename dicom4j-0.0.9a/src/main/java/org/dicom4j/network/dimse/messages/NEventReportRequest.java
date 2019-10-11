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
import org.dicom4j.network.dimse.messages.support.RequestedSOPClassUIDRequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * N-Event-Report-Request
 * 
 * @since 0.0.8
 * @since 12 févr. 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class NEventReportRequest extends RequestedSOPClassUIDRequestMessage {

	private static final Logger logger = LoggerFactory
	.getLogger(NEventReportRequest.class);

	private static final long serialVersionUID = 1L;

	public NEventReportRequest(int aMessageID, String aRequestedSOPClassUID,
			String aRequestedSOPInstanceUID) throws DicomException {
		super(aMessageID, aRequestedSOPClassUID, aRequestedSOPInstanceUID);
		this.setCommandField(CommandSetType.N_EVENT_REPORT_REQUEST.value());
		this.setDataSetType(CommandSet.NO_DATASET);
	}

	public CommandSetType getMessagetype() {
		return CommandSetType.N_DELETE_RESPONSE;
	}
	
}
