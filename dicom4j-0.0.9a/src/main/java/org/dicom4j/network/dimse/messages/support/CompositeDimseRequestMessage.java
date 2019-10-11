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
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Composite Dimse Request Message
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte 
 *
 */
public abstract class CompositeDimseRequestMessage extends DimseRequestMessage {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(CompositeDimseRequestMessage.class);

	public CompositeDimseRequestMessage(CommandSet commandSet) {
		super(commandSet);
	}

	public CompositeDimseRequestMessage(int messageID) throws DicomException {
		this(messageID, "");
	}
	
	public CompositeDimseRequestMessage(int messageID, String affectedSOPClassUID) throws DicomException {
		super(messageID);
		setAffectedSOPClassUID( affectedSOPClassUID );
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
	
	/**
	 * check if the message include the AffectedSOPClassUID parameter
	 * 
	 * @return true if AffectedSOPClassUID is include
	 */
	public boolean hasAffectedSOPClassUIDElement() {
		return this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID);
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
	
	@Override
	protected void fillCommandSet(CommandSet commandSet) throws DicomException {
		super.fillCommandSet( commandSet );
		commandSet.addElement( DataElements.newAffectedSOPClassUID() ); 
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
	
	/*public boolean hasAffectedSOPClassUIDElement() {
		return this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID);
	}*/
	
	/*public String getAffectedSOPClassUID() throws DicomException, DimseException {
		if (this.hasAffectedSOPClassUIDElement()) {
			return this.getCommandSet().getUniqueIdentifier( DicomTags.AffectedSOPClassUID).getSingleStringValue();
		} else {
			throw new DimseException("no AffectedSOPClassUID in message");
	}*/


}
