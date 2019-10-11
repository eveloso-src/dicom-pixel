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

package org.dicom4j.network.dimse.messages;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.CommandSetType;
import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.network.dimse.DimseStatusRegistry;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;

/**
 * Dimse Message
 * 
 * <p>
 * a message is composed by
 * <ul>
 * <li>a CommandSet</li>
 * <li>a DataSet (depend of message's type)</li>
 * </ul>
 * 
 * @since 0.0.8
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface DimseMessage {

	/**
	 * Return the value of the Command Field
	 * 
	 * @return the CommandField
	 */
	public int getCommandField();

	/**
	 * return the message's {@link CommandSet}
	 * 
	 * @return the CommandSet
	 */
	public CommandSet getCommandSet();
	
	public CommandSetType getMessagetype();

	/**
	 * return the message's {@link DataSet} (must be null if the message doesn't
	 * contain a DataSet)
	 * 
	 * @return the DataSet
	 */
	public DataSet getDataSet();

	/**
	 * return the Message ID
	 * 
	 * @return the Message ID
	 */
	public int getMessageID();

	/**
	 * return the name of the message
	 * 
	 * @return the name
	 */
	public String getName();

	public SOPClassRegistry getSopClassRegistry();

	/**
	 * @return Returns the statusRegistry.
	 */
	public DimseStatusRegistry getStatusRegistry();

	/**
	 * check if the message is a C-Echo-Request
	 * 
	 * @return true is C-Echo-Request
	 * 
	 * @since 0.0.9
	 */
	public boolean isCEchoRequest();

	public boolean isCEchoResponse();

	/**
	 * check if the message is a C-Find-Request
	 * 
	 * @return true if C-Find-Request
	 * 
	 * @since 0.0.9
	 */
	public boolean isCFindRequest();

	/**
	 * check if this message is a C-STORE-RESPONSE
	 * 
	 * @return true if the message is a store response
	 * @since 0.0.9
	 */
	public boolean isCStoreResponse();

	public void setDataSet(DataSet dataSet) throws DicomException;

	/**
	 * set the {@link SOPClassRegistry}
	 * 
	 * @param sopClassRegistry
	 *          the SOPClassRegistry
	 */
	public void setSopClassRegistry(SOPClassRegistry sopClassRegistry);

	/**
	 * @param statusRegistry
	 *          The statusRegistry to set.
	 */
	public void setStatusRegistry(DimseStatusRegistry statusRegistry);
	
	/**
	 * Remove the DataSet from the message.
	 * <p>
	 * DataSetType is changed to reflect there no DataSet
	 * </p>
	 * 
	 * @throws DicomException
	 */
	public void removeDataSet() throws DicomException;

	public boolean hasDataSet();
}
