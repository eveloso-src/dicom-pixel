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

import java.io.IOException;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.CommandSetType;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.network.dimse.messages.support.CompositeDimseRequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>C-Echo Request.
 * 
 * <p>
 * <table border="1">
 * <tr>
 * <th>Message Field</th>
 * <th>Tag</th>
 * <th>VR</th>
 * <th>VM</th>
 * <th>Description of Field </th>
 * </tr>
 * <tr>
 * 	<td>Command Group Length</td>
 * 	<td>(0000,0100)</td>
 * 	<td>US</td>
 * 	<td>1</td>
 * 	<td>The even number of bytes from the end of the value field to the beginning of the next group. </td>
 * </tr>
 * <tr>
 * 	<td>Affected SOP Class UID</td>
 * 	<td>(0000,0002)</td>
 * 	<td>UI</td>
 * 	<td>1</td>
 * 	<td>SOP Class UID associated with this operation.</td>
 * </tr>
 * <tr>
 * 	<td>Command Field</td>
 * 	<td>(0000,0100)</td>
 * 	<td>US</td>
 * 	<td>1</td>
 * 	<td>This field distinguishes the DIMSE-C operation conveyed by this Message. The value of this field shall be set to 0030H for the C-ECHO-RQ Message.</td>
 * </tr>
 * <tr>
 * 	<td>Message ID</td>
 * 	<td>(0000,0110)</td>
 * 	<td>US</td>
 * 	<td>1</td>
 * 	<td>Implementation-specific value which distinguishes this Message from other Messages.</td>
 * </tr>
 * <tr>
 * 	<td>Data Set Type</td>
 * 	<td>(0000,0800)</td>
 * 	<td>US</td>
 * 	<td>1</td>
 * 	<td>This field indicates that no Data Set is present in the Message and shall be set to a value of 0101H.</td>
 * </tr>
 * </table>
 * <p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CEchoRequestMessage extends CompositeDimseRequestMessage {

	private static Logger logger = LoggerFactory.getLogger(CEchoRequestMessage.class);

	public CEchoRequestMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	/**
	 * Create a new message
	 * 
	 * @param messageID
	 *          the MessageID
	 * @param affectedSOPClassUID
	 *          the affected SOPClass
	 * @exception IOException
	 * @exception DicomException
	 */
	public CEchoRequestMessage(int messageID, String affectedSOPClassUID) throws DicomException {
		super(messageID, affectedSOPClassUID);
	}
	
	/*@Override
	protected void fillCommandSet(CommandSet commandSet) throws DicomException {
		assert commandSet != null;
//		commandSet.addElement(new UniqueIdentifier(DicomTags.AffectedSOPClassUID));
	//	commandSet.addElement(new UnsignedShort(DicomTags.MessageID));
		//this.setDataSetType(CommandSet.NO_DATASET);
	}*/


	/*@Override
	protected UnsignedShort getMessageIDAttributeTag() {
		return this.getCommandSet().getUnsignedShort(DicomTags.MessageID);
	}*/

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		if (this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID)) {
			lBuffer.append("  SOP Class: "
					+ this.getSopClassRegistry().getSopClassAsString(	this.getAffectedSOPClassUID()) + "\n");
		} else {
			logger.warn("No AffectedSOPClassUID");
		}
		return lBuffer.toString();
	}
	
	@Override
	public CommandSetType getMessagetype() {
		return CommandSetType.C_ECHO_REQUEST;
	}
	
}
