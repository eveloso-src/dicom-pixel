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

package org.dicom4j.io.media.handlers;

import org.dicom4j.io.media.MediaStorage;
import org.dicom4j.network.dimse.messages.CStoreResponseMessage;

/**
 * a Media Storage handler
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface MediaStoreHandler {

	/**
	 * handler to notify of a Store request
	 * 
	 * @param aMediaStorage
	 *          the {@link MediaStorage}
	 * @param aStoreResponse
	 *          the store response as a DimseMessage
	 */
	public void onStored(MediaStorage aMediaStorage,
			CStoreResponseMessage aStoreResponse);

}
