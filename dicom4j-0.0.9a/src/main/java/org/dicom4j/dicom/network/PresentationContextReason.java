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

package org.dicom4j.dicom.network;

import org.dicom4j.core.utils.ByteValue;

/**
 * Presentation Context Reasons
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class PresentationContextReason extends ByteValue {

	public PresentationContextReason(byte value, String valueAsString) {
		super(value, valueAsString);
	}
	
	public final static PresentationContextReason ABSTRACT_SYNTAX_NOT_SUPPORTED = new PresentationContextReason( (byte) 3, "ABSTRACT_SYNTAX_NOT_SUPPORTED");

	public final static PresentationContextReason ACCEPTANCE = new PresentationContextReason((byte) 0, "Acceptance");

	/**
	 * No reason
	 */
	public final static PresentationContextReason NO_REASON = new PresentationContextReason((byte) 2, "No reason");

	public final static PresentationContextReason TRANSFER_SYNTAXES_NOT_SUPPORTED = new PresentationContextReason( (byte) 4, "TRANSFER_SYNTAXES_NOT_SUPPORTED");

	/**
	 * User rejection
	 */
	public final static PresentationContextReason USER_REJECTION = new PresentationContextReason((byte) 1, "User rejection");

}
