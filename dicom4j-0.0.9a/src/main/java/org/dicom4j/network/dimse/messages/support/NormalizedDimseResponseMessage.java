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

/**
 * 
 */
package org.dicom4j.network.dimse.messages.support;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.CommandSetType;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.network.dimse.DimseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @since 0.0.9 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte 
 *
 */
public abstract class NormalizedDimseResponseMessage extends DimseResponseMessage {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(NormalizedDimseResponseMessage.class);

	/**
	 * @param commandSet
	 */
	public NormalizedDimseResponseMessage(CommandSet commandSet) {
		super(commandSet);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param messageID
	 * @throws DicomException
	 */
	public NormalizedDimseResponseMessage(int messageID) throws DicomException {
		super(messageID);
	}

	/**
	 * @param messageID
	 * @param aAffectedSOPClassUID
	 * @throws DicomException
	 */
	public NormalizedDimseResponseMessage(int messageID,
			String aAffectedSOPClassUID) throws DicomException {
		super(messageID, aAffectedSOPClassUID);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param messageID
	 * @param affectedSOPClassUID
	 * @param status
	 * @throws DicomException
	 */
	public NormalizedDimseResponseMessage(int messageID,
			String affectedSOPClassUID, int status) throws DicomException {
		super(messageID, affectedSOPClassUID, status);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param messageID
	 * @param aAffectedSOPClassUID
	 * @param aHasDataset
	 * @param status
	 * @throws DicomException
	 */
	public NormalizedDimseResponseMessage(int messageID,
			String aAffectedSOPClassUID, int aHasDataset, int status)
			throws DicomException {
		super(messageID, aAffectedSOPClassUID, aHasDataset, status);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * set the AffectedSOPClassUID
	 * 
	 * @param affectedSOPClassUID value to set
	 * @exception DicomException if errors occurs when setting the value
	 */
	public void setAffectedSOPClassUID(String affectedSOPClassUID) throws DicomException {
		logger.info("setAffectedSOPClassUID: " + affectedSOPClassUID);
		this.setorAddUniqueIdentifier( DicomTags.AffectedSOPClassUID, affectedSOPClassUID);
	}
	
	public void setAffectedSOPInstanceUID(String affectedSOPInstanceUID) throws DicomException, DimseException {
		logger.info("setAffectedSOPInstanceUID: " + affectedSOPInstanceUID);
		this.setorAddUniqueIdentifier( DicomTags.AffectedSOPInstanceUID, affectedSOPInstanceUID);
	}
	
	/**
	 * check if the message include the AffectedSOPClassUID parameter
	 * 
	 * @return true if AffectedSOPClassUID is include
	 */
	public boolean hasAffectedSOPClassUIDElement() {
		return this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID);
	}
	/**
	 * check if the message include the AffectedSOPInstanceUID parameter
	 * 
	 * @return true if parameter is include
	 */
	public boolean hasAffectedSOPInstanceUIDDElement() {
		return this.getCommandSet().hasElement(DicomTags.AffectedSOPInstanceUID);
	}
	
	/**
	 * return the AffectedSOPClassUID element
	 * 
	 * @return the element
	 * @exception DicomException if errors occurs
	 */
	public UniqueIdentifier getAffectedSOPClassUIDElement() throws DicomException {
		return this.getCommandSet().getUniqueIdentifier(DicomTags.AffectedSOPClassUID);
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
	
	public String getAffectedSOPClassName() {
		if (this.getSopClassRegistry() == null) {
			logger.warn("SopClassRegistry was no set, return the AffectedSOPClassUID");
			return this.getAffectedSOPClassUID();
		} else {
			try {
				return this.getSopClassRegistry().getName(this.getAffectedSOPClassUID());
			} catch (Exception lE) {
				return this.getAffectedSOPClassUID();
			}
		}
	}
	
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
	
	@Override
	protected void fillCommandSet(CommandSet commandSet) throws DicomException {
		super.fillCommandSet( commandSet );
		commandSet.addElement(DataElements.newAffectedSOPClassUID());
		commandSet.addElement(DataElements.newAffectedSOPInstanceUID());
	}

}
