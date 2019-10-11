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
import org.dicom4j.data.elements.ApplicationEntity;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.network.dimse.DimsePriority;
import org.dicom4j.dicom.uniqueidentifiers.SOPClasses;
import org.dicom4j.network.dimse.DimseException;
import org.dicom4j.network.dimse.messages.support.CompositeDimseRequestWithPriorityMessage;
import org.dicom4j.network.dimse.messages.support.DimseRequestMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.org.apache.xerces.internal.util.DefaultErrorHandler;

/**
 * C-STORE request
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CStoreRequestMessage extends CompositeDimseRequestWithPriorityMessage {

	private static Logger logger = LoggerFactory.getLogger(CStoreRequestMessage.class);

	public CStoreRequestMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public CStoreRequestMessage(int messageID) throws DicomException {
		this(messageID, "");
		/*this.setCommandField(CommandSetType.C_STORE_REQUEST.value());
		this.setDataSetType(CommandSet.NO_DATASET);
		this.setPriority(DimsePriority.MEDIUM.value());*/
	}

	public CStoreRequestMessage(int messageID, String affectedSOPClassUID) throws DicomException {
		super(messageID, affectedSOPClassUID);
		/*this.setCommandField(CommandSetType.C_STORE_REQUEST.value());
		this.setDataSetType(CommandSet.NO_DATASET);
		this.setPriority(DimsePriority.MEDIUM.value());*/
	}

	public CStoreRequestMessage(int aMessageID, String aAffectedSOPClassUID, int aPriority) throws DicomException {
		super(aMessageID, aAffectedSOPClassUID);
		//this.setCommandField(CommandSetType.C_STORE_REQUEST.value());
		//this.setDataSetType(CommandSet.NO_DATASET);
		//this.setPriority(aPriority);
	}
	
	@Override
	protected void fillCommandSet(CommandSet commandSet) throws DicomException {
		super.fillCommandSet( commandSet );
		commandSet.addElement( DataElements.newAffectedSOPInstanceUID() ); 
		commandSet.addElement( DataElements.newMoveOriginatorAET() ); 
		commandSet.addElement( DataElements.newMoveOriginatorMessageID() ); 
	}

/*	@Override
	protected CommandSet createCommandSet() {
		CommandSet lCommandSet = new CommandSet();
		assert lCommandSet != null;
		lCommandSet.addElement(new UnsignedShort(DicomTags.MessageID));
		lCommandSet.addElement(new UniqueIdentifier(DicomTags.AffectedSOPClassUID));
		lCommandSet.addElement(new UnsignedShort(DicomTags.Priority));
		lCommandSet.addElement(new UniqueIdentifier(
				DicomTags.AffectedSOPInstanceUID));
		lCommandSet.addElement(new ApplicationEntity(DicomTags.MoveOriginatorAET));
		lCommandSet
		.addElement(new UnsignedShort(DicomTags.MoveOriginatorMessageID));
		return lCommandSet;
	}
*/
	public String getAffectedSOPInstanceUID() {
		try {
			if (this.getCommandSet().hasElement(DicomTags.AffectedSOPInstanceUID)) {
				return this.getCommandSet().getUniqueIdentifier(
						DicomTags.AffectedSOPInstanceUID).getSingleStringValue().trim();
			} else {
				return "";
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return "";
		}
	}

	@Override
	public UniqueIdentifier getAffectedSOPInstanceUIDElement()
	throws DicomException {
		return this.getCommandSet().getUniqueIdentifier(
				DicomTags.AffectedSOPInstanceUID);
	}

	public String getMoveOriginatorAET() {
		try {
			if (this.getCommandSet().hasElement(DicomTags.MoveOriginatorAET)) {
				return this.getCommandSet().getApplicationEntity(
						DicomTags.MoveOriginatorAET).getSingleStringValue().trim();
			} else {
				return "";
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return "";
		}
	}
	
	@Deprecated
	public String getMoveOriginatorAETasString() {
		try {
			if (this.getCommandSet().hasElement(DicomTags.MoveOriginatorAET)) {
				return this.getCommandSet().getApplicationEntity(
						DicomTags.MoveOriginatorAET).getSingleStringValue().trim();
			} else {
				return "";
			}
		} catch (Exception e) {
			logger.warn(e.getMessage());
			return "";
		}
	}
	
	public int getMoveOriginatorMessageID() throws DicomException {
		return this.getMoveOriginatorMessageIDElement().getSingleIntegerValue();
	}

	public UnsignedShort getMoveOriginatorMessageIDElement() throws DicomException {
		return this.getCommandSet().getUnsignedShort(DicomTags.MoveOriginatorMessageID);
	}

	/*public int getPriority() {
		return this.getCommandSet().getUnsignedShort(DicomTags.Priority)
		.getIntegerValue(0);
	}*/

	public boolean hasAffectedSOPInstanceUID() {
		return this.getCommandSet().hasElement(DicomTags.AffectedSOPInstanceUID);
	}

	public boolean hasMoveOriginatorAET() {
		return this.getCommandSet().hasElement(DicomTags.MoveOriginatorAET);
	}

	public boolean hasMoveOriginatorMessageID() {
		return this.getCommandSet().hasElement(DicomTags.MoveOriginatorMessageID);
	}

	public void setAffectedSOPInstanceUID(String AffectedSOPInstanceUID)
	throws DicomException, DimseException {
		if (this.hasAffectedSOPInstanceUID()) {
			this.getAffectedSOPInstanceUIDElement().setValue(AffectedSOPInstanceUID);
		} else {
			throw new DimseException("No AffectedSOPInstanceUID in CommandSet");
		}
	}

	public void setMoveOriginatorAET(String aMoveOriginatorAET)
	throws DicomException, DimseException {
		if (this.getCommandSet().hasElement(DicomTags.MoveOriginatorAET)) {
			this.getCommandSet().getApplicationEntity(DicomTags.MoveOriginatorAET)
			.setValue(aMoveOriginatorAET);
		} else {
			throw new DimseException("No MoveOriginatorAET in CommandSet");
		}
	}

	public void setMoveOriginatorMessageID(int aMoveOriginatorMessageID)
	throws DicomException, DimseException {
		if (this.getCommandSet().hasElement(DicomTags.MoveOriginatorMessageID)) {
			this.getCommandSet().getUnsignedShort(DicomTags.MoveOriginatorMessageID)
			.setValue(aMoveOriginatorMessageID);
		} else {
			throw new DimseException("No MoveOriginatorMessageID in CommandSet");
		}
	}

	/**
	 * set the Priority
	 * 
	 * @param aPriority
	 * @throws DicomException
	 */
/*	public void setPriority(int aPriority) throws DicomException {
		this.getCommandSet().getUnsignedShort(DicomTags.Priority).setValue(
				aPriority);
	}
*/
	// TODO ADD NOTEXISTEXCEPTION
	/*
	 * public UniqueIdentifier getUniqueIdentifier() throws DicomException {
	 * return
	 * getCommandSet().getUniqueIdentifier(DicomTags.AffectedSOPInstanceUID); }
	 */

	@Override
	public String toString() {
		StringBuffer lBuffer = new StringBuffer();
		lBuffer.append(this.getName() + ": \n");
		lBuffer.append("  SOPClass: " + getAffectedSOPClassName() + "\n");
		lBuffer.append("  Affected SOP Instance UID: " + this.getAffectedSOPInstanceUID() + "\n");
		lBuffer.append("  Move Originator AET: " + this.getMoveOriginatorAETasString() + "\n");
		try {
			lBuffer.append("  MoveOriginatorMessageID: " + this.getMoveOriginatorMessageID() + "\n");
		} catch (Exception ex) {
			logger.warn( ex.getMessage() );
			lBuffer.append("  MoveOriginatorMessageID: unable to get the value" );
		}

		if (this.getDataSet() != null) {
			lBuffer.append("DataSet: \n");
			lBuffer.append(this.getDataSet().toString());
		}
		return lBuffer.toString();
	}
	
	public CommandSetType getMessagetype() {
		return CommandSetType.C_STORE_REQUEST;
	}

}
