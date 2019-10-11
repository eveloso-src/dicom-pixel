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
 * Associate Reject Sources
 * 
 * @since 0.0.8
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateRejectSource {

	public static final ByteValue DICOM_UL_SERVICE_PRESENTATION = new ByteValue(
			(byte) 3, "DICOM_UL_SERVICE_PRESENTATION");

	public static final ByteValue DICOM_UL_SERVICE_PROVIDER_ACSE = new ByteValue(
			(byte) 2, "DICOM_UL_SERVICE_PROVIDER_ACSE");

	public static final ByteValue DICOM_UL_SERVICE_USER = new ByteValue((byte) 1,
	"REASON_NOT_SPECIFIED");

}
