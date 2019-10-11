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
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for Dimse message which have an AffectedSOPClass field
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class DimseMessageWithAffectedSOPClass extends AbstractDimseMessage {

	private static final Logger logger = LoggerFactory
	.getLogger(DimseResponseMessage.class);

	public DimseMessageWithAffectedSOPClass(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public DimseMessageWithAffectedSOPClass() throws DicomException {
		super();
	}
	
	public DimseMessageWithAffectedSOPClass(int aMessageID) throws DicomException {
		super(aMessageID);
	}

	public DimseMessageWithAffectedSOPClass(int aMessageID,
			String aAffectedSOPClassUID) throws DicomException {
		super(aMessageID);
		this.getCommandSet().getUniqueIdentifier(DicomTags.AffectedSOPClassUID)
		.addValue(aAffectedSOPClassUID);
	}

	public String getAffectedSOPClassName() {
		if (this.getSopClassRegistry() == null) {
			logger
			.warn("SopClassRegistry was no set, return the AffectedSOPClassUID");
			return this.getAffectedSOPClassUID();
		} else {
			try {
				return this.getSopClassRegistry().getName(this.getAffectedSOPClassUID());
			} catch (Exception lE) {
				return this.getAffectedSOPClassUID();
			}
		}
	}

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

	public boolean hasAffectedSOPClassUIDElement() {
		return this.getCommandSet().hasElement(DicomTags.AffectedSOPClassUID);
	}
}
