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
 * <p>
 * Associate Reject Service User Reasons
 * <p>
 * <ul>
 * <li>no-reason-given</li>
 * <li>2 - application-context-name-not-supported</li>
 * <li>3 - calling-AE-title-not-recognized</li>
 *<li>4-6 - reserved</li>
 * <li>7 - called-AE-title-not-recognized</li>
 * <li>8-10 - reserved</li>
 * </li>
 * </ul>
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociateRejectServiceUserReasons {

	public static final ByteValue APPLICATION_CONTEXT_NAME_NOT_SUPPORTED = new ByteValue(
			(byte) 2, "application-context-name-not-supported");

	public static final ByteValue CALLED_AE_TITLE_NOT_RECOGNIZE = new ByteValue(
			(byte) 7, "calling-AE-title-not-recognize");

	public static final ByteValue CALLING_AE_TITLE_NOT_RECOGNIZE = new ByteValue(
			(byte) 3, "calling-AE-title-not-recognize");

	public static final ByteValue NO_REASON_GIVEN = new ByteValue((byte) 1,
	"no-reason-given");

}
