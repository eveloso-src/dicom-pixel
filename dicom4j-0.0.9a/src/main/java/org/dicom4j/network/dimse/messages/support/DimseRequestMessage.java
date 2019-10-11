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

package org.dicom4j.network.dimse.messages.support;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.network.dimse.DimseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for Request DIMSE messages
 * 
 * @see CompositeDimseRequestMessage
 * @see NormalizedDimseRequestMessage
 * 
 * @since 0.0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class DimseRequestMessage extends DimseMessageWithAffectedSOPClass {

	private static final Logger logger = LoggerFactory.getLogger(DimseRequestMessage.class);

	public DimseRequestMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public DimseRequestMessage(int messageID) throws DicomException {
		super();
		setMessageID( messageID );
	}

	@Deprecated
	public DimseRequestMessage(int aMessageID, String aAffectedSOPClassUID) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
	}

	@Override
	public String getAffectedSOPClassUID() {
		try {
			if (this.hasAffectedSOPClassUIDElement()) {
				return this.getCommandSet().getUniqueIdentifier(
						DicomTags.AffectedSOPClassUID).getSingleStringValue();
			} else {
				return "";
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return "";
		}
	}

	public UniqueIdentifier getAffectedSOPClassUIDElement() throws DicomException {
		return this.getCommandSet().getUniqueIdentifier(
				DicomTags.AffectedSOPClassUID);
	}

	public UniqueIdentifier getAffectedSOPInstanceUIDElement()
	throws DicomException {
		return this.getCommandSet().getUniqueIdentifier(
				DicomTags.AffectedSOPClassUID);
	}
	
	@Override
	protected void fillCommandSet(CommandSet commandSet) throws DicomException {
		assert commandSet != null;
		commandSet.addElement( DataElements.newMessageID() ); // new UnsignedShort(DicomTags.MessageID));
		//this.setDataSetType(CommandSet.NO_DATASET);
	}
	
	public int setMessageID( int messageID ) throws DicomException {
		setorAddUnsignedShort(DicomTags.MessageID, messageID);
		//if ( has)
		return messageID;
	}
	
	@Override
	protected UnsignedShort getMessageIDElement() {
		return this.getCommandSet().getUnsignedShort(DicomTags.MessageID);
	}

	public boolean hasMessageIDElement() {
		return this.getCommandSet().hasElement(DicomTags.MessageID);
	}
	
	@Override
	public boolean hasAffectedSOPClassUIDElement() {
		return this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID);
	}

	public void setAffectedSOPClassUID(String AffectedSOPClassUID)
	throws DicomException, DimseException {
		if (this.hasAffectedSOPClassUIDElement()) {
			this.getAffectedSOPClassUIDElement().setValue(AffectedSOPClassUID);
		} else {
			throw new DimseException("No AffectedSOPClassUID in CommandSet");
		}
	}

}
