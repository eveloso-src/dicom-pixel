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

package org.dicom4j.io.media;

import java.io.FileNotFoundException;

import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.media.handlers.MediaStoreHandler;
import org.dicom4j.network.dimse.messages.CStoreRequestMessage;

/**
 * Media Storage interface (ie: physicial storage)
 * 
 * @since Alpha 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface MediaStorage {

	/**
	 * @since Alpha 0.0.3
	 * @return
	 */
	// public String getMediaID();
	/**
	 * Check if a DataSet is stored on the media
	 * 
	 * @since Alpha 0.0.3
	 * @param aSOPClassUID
	 * @return
	 * @throws DicomException
	 */
	public boolean isStored(String aSOPClassUID) throws Exception;

	public DataSet retrieveDataSet(String aSOPClassUID) throws Exception,
	DicomException, FileNotFoundException;

	// public boolean isAvia

	/**
	 * Store a DataSet on the media
	 * 
	 * @param aStoreRequest
	 *          the request
	 * @param aTransferSyntax
	 *          the {@link TransferSyntax TransferSyntax} to use to write the
	 *          DataSet
	 * @param aStoreHandler
	 *          the StoreHander
	 */
	public void storeDataSet(CStoreRequestMessage aStoreRequest,
			TransferSyntax aTransferSyntax, MediaStoreHandler aStoreHandler)
	throws DicomException;

	// public boolean isAvaible(String aSOPClassUID, DataSet aDataSet) throws
	// DicomException;
}
