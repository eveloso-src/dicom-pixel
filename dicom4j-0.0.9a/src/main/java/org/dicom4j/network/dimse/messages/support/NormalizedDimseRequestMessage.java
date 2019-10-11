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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 *
 * @since 0.0.9 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte 
 *
 */
public abstract class NormalizedDimseRequestMessage extends DimseRequestMessage {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory.getLogger(NormalizedDimseRequestMessage.class);

	public NormalizedDimseRequestMessage(CommandSet aCommandSet) {
		super(aCommandSet);
	}

	public NormalizedDimseRequestMessage(int aMessageID) throws DicomException {
		super(aMessageID);
	}

}
