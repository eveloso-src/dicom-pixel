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
 * List of Associate Reject Results
 * 
 * @since 0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateRejectResult {

	public static final ByteValue REJECTED_PERMANENT = new ByteValue((byte) 1,
	"REJECTED_PERMANENT");

	public static final ByteValue REJECTED_TRANSIENT = new ByteValue((byte) 2,
	"REJECTED_TRANSIENT");
}
