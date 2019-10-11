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
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.network.dimse.DimseException;
import org.dicom4j.network.dimse.messages.support.NormalizedDimseResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * N-EVENT-REPORT response
 * 
 * @since 0.0.8
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class NEventReportResponseMessage extends NormalizedDimseResponseMessage {

	private static final Logger logger = LoggerFactory.getLogger(NEventReportResponseMessage.class);

	private static final long serialVersionUID = 1L;

	public NEventReportResponseMessage(int messageID) throws Exception {
		super( messageID );
	}
	
	/*public NEventReportResponseMessage(int aMessageID, String aRequestedSOPClassUID,
			String aRequestedSOPInstanceUID) throws DicomException {
		//super(aMessageID, aRequestedSOPClassUID, aRequestedSOPInstanceUID);
		//this.setCommandField(CommandSetType.N_EVENT_REPORT_RESPONSE.value());
		//this.setDataSetType(CommandSet.NO_DATASET);
	}*/
	
	@Override
	protected void fillCommandSet(CommandSet commandSet) throws DicomException {
		super.fillCommandSet( commandSet );
		commandSet.addElement(DataElements.newEventTypeID());
	}
	
	public void setEventTypeID(int value) throws DicomException, DimseException {
		logger.info("setEventTypeID: " + value);
		this.setorAddUnsignedShort( DicomTags.EventTypeID, value);
	}
	
	/**
	 * check if the message include the EventTypeID parameter
	 * 
	 * @return true if parameter is include
	 */
	public boolean hasEventTypeIDElement() {
		return this.getCommandSet().hasElement(DicomTags.EventTypeID);
	}
	
	/**
	 * return the EventTypeID element
	 * 
	 * @return the element
	 * @exception DicomException if errors occurs
	 */
	public UnsignedShort getEventTypeIDElement() throws DicomException {
		return this.getCommandSet().getUnsignedShort(DicomTags.EventTypeID);
	}
	
	public int getEventTypeID() throws Exception {
		return getEventTypeIDElement().getIntegerValue(0);
	}
	
	@Override
	public CommandSetType getMessagetype() {
		return CommandSetType.N_EVENT_REPORT_RESPONSE;
	}
}
