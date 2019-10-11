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
import org.dicom4j.data.CommandSetType;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.dicom.network.dimse.DimseStatusRegistry;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.network.dimse.DimseException;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class for DIMSE messages.
 * 
 * <p>
 * A message contains
 * <ul>
 * <li>a DimseCommandSet</li>
 * <li>a DataSet</li>
 * </ul>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractDimseMessage implements DimseMessage {

	private static final Logger logger = LoggerFactory.getLogger(AbstractDimseMessage.class);

	protected CommandSet commandSet;

	protected DataSet dataSet;

	private SOPClassRegistry sopClassRegistry;

	private DimseStatusRegistry statusRegistry;

	public AbstractDimseMessage(CommandSet commandSet) {
		super();
		this.commonConstructor();
		assert commandSet != null;

		// TODO check the CommandSet depending if of the message class
		this.commandSet = commandSet;

	}

	public AbstractDimseMessage() throws DicomException {
		super();
		this.commonConstructor();
		this.commandSet = this.createCommandSet();
		assert this.commandSet != null;
		//this.commandSet.addElement(DataElements.newCommandGroupLength());
		//this.commandSet.addElement(DataElements.newCommandField());
		//this.commandSet.addElement(DataElements.newDataSetType());

		this.setCommandField( getMessagetype().value() );
		fillCommandSet( commandSet );
//		this.setMessageID(messageID);
		this.setDataSet( null );
	}
	
	public AbstractDimseMessage(int messageID) throws DicomException {
		super();
		this.commonConstructor();
		this.commandSet = this.createCommandSet();
		assert this.commandSet != null;
		this.commandSet.addElement(DataElements.newCommandGroupLength());
		this.commandSet.addElement(DataElements.newCommandField());
		this.commandSet.addElement(DataElements.newDataSetType());

		this.setCommandField( getMessagetype().value() );
		fillCommandSet( commandSet );
//		this.setMessageID(messageID);
		this.setDataSet( null );
	}

	protected void commonConstructor() {
		this.sopClassRegistry = new SOPClassRegistry();
		this.statusRegistry = new DimseStatusRegistry();
		this.dataSet = null;
	}

	protected CommandSet createCommandSet() {
		commandSet = new CommandSet();// this.createCommandSet();
		commandSet.addElement(DataElements.newCommandGroupLength());
		commandSet.addElement(DataElements.newCommandField());
		commandSet.addElement(DataElements.newDataSetType());
		return commandSet;
	}

	/*
	 * { return new CommandSet(); }
	 */
//TODO make abstract 
	protected void fillCommandSet(CommandSet commandSet) throws DicomException {
		assert commandSet != null;
	}

	/**
	 * Return the value of the Command Field
	 * 
	 * @return the CommandField
	 */
	public int getCommandField() {
		return this.commandSet.getUnsignedShort(DicomTags.CommandField).getIntegerValue(0);
	}

	/**
	 * Return the CommandSet
	 * 
	 * @return the CommandSet
	 */
	public CommandSet getCommandSet() {
		assert this.commandSet != null;
		return this.commandSet;
	}

	/**
	 * Return the DataSet
	 * 
	 * @return the DataSet
	 */
	public DataSet getDataSet() {
		return this.dataSet;
	}

	protected int getDataSetType() {
		return this.commandSet.getDataSetType();
	}

	public boolean hasDataSet() {
		return getDataSetType() == CommandSet.HAS_DATASET;
	}
	/*
	 * public String CommandSetToString() { return getCommandSet().toString(); }
	 */

	/*
	 * public String toString() { StringBuffer lBuffer = new StringBuffer();
	 * 
	 * lBuffer.append(getCommandSet().toString()); // read data from Command
	 * 
	 * //for (int i=0; i <)
	 * 
	 * // read data from DataSet
	 * 
	 * 
	 * return lBuffer.toString(); }
	 */

	/**
	 * Return the Message ID
	 * 
	 * @return the Message ID
	 */
	public int getMessageID() {
		return this.getMessageIDElement().getIntegerValue(0);
	}

	protected abstract UnsignedShort getMessageIDElement();

	/**
	 * Return the name of the message
	 * 
	 * @return the name
	 */
	public String getName() {
		try {
			return CommandSetType.toString(this.getCommandSet().getCommandField());
		} catch (Exception ex) {
			logger.error( ex.getMessage() );
			return "";
		}
	}

	public SOPClassRegistry getSopClassRegistry() {
		return this.sopClassRegistry;
	}

	/**
	 * @return Returns the statusRegistry.
	 */
	public DimseStatusRegistry getStatusRegistry() {
		return this.statusRegistry;
	}

	public boolean isCEchoRequest() {
		try {
			return this.getCommandSet().isCEchoRequest();
		} catch (Exception ex) {
			logger.error( ex.getMessage() );
			return false;
		}
	}

	public boolean isCEchoResponse() {
		return this.getCommandField() == CommandSetType.C_ECHO_RESPONSE.value();
	}

	public boolean isCFindRequest() {
		return this.getCommandField() == CommandSetType.C_FIND_REQUEST.value();
	}

	public boolean isCStoreResponse() {
		return this.getCommandField() == CommandSetType.C_STORE_RESPONSE.value();
	}

	public void removeDataSet() throws DicomException {
		this.setDataSet(null);
	}

	/**
	 * Set the Command Field value
	 * 
	 * @param commandField
	 *          the value to set
	 */
	public void setCommandField(int commandField) throws DicomException {
		logger.debug("setCommandField: " + commandField);
		this.commandSet.setCommandField(commandField);
	}

	/**
	 * set the DataSet. The DataSetType will be set to "no dataset" is the
	 * supplied object is null.
	 * 
	 * @param dataSet
	 *          the DataSet to set
	 */
	public void setDataSet(DataSet dataSet) throws DicomException {
		if (dataSet != null) {
			this.dataSet = dataSet;
			this.setDataSetType(CommandSet.HAS_DATASET);
		} else {
			this.setDataSetType(CommandSet.NO_DATASET);
		}
		// fLogger.debug("we set the DataSet: \n" + aDataSet.toString() );
	}

	protected void setDataSetType(int aDataSetType) throws DicomException {
		this.commandSet.setDataSetType(aDataSetType);
	}

	private void setMessageID(int aMessageID) throws DicomException {
		this.getMessageIDElement().setValue(aMessageID);
	}

	protected void setorAddUniqueIdentifier(DicomTag tag, String value) throws DicomException, DimseException {
		logger.debug("setorAddUniqueIdentifier (tag: " + tag.getName() + ", value: "	+ value);
		if ( ! tag.getValueRepresentation().equals(ValueRepresentation.UniqueIdentifier) )
			throw new DicomException("tag" + tag.getName() + " is not a Unique Identifier"); 
		if (!this.getCommandSet().hasElement(tag)) {
			this.getCommandSet().addUniqueIdentifier(tag);
		}
		UniqueIdentifier element = this.getCommandSet().getUniqueIdentifier(tag);
		element.setValue(value);
	}
	
	/**
	 * set the NumberOfRemainingSubOperations (add the element if not present in
	 * the CommandSet)
	 * 
	 * @param aNumber
	 *          the number
	 * @throws DicomException
	 * @throws DimseException
	 */
	protected void setorAddUnsignedShort(DicomTag tag, int value) throws DicomException, DimseException {
		logger.debug("setorAddUnsignedShort (tag: " + tag.getName() + ", value: "	+ value);
		if (!this.getCommandSet().hasElement(tag)) {
			this.getCommandSet().addUnsignedShort(tag);
		}
		UnsignedShort element = this.getCommandSet().getUnsignedShort(tag);
		element.setValue(value);
	}

	public void setSopClassRegistry(SOPClassRegistry sopClassRegistry) {
		this.sopClassRegistry = sopClassRegistry;
	}

	/**
	 * @param statusRegistry
	 *          The statusRegistry to set.
	 */
	public void setStatusRegistry(DimseStatusRegistry statusRegistry) {
		this.statusRegistry = statusRegistry;
	}
	
	public abstract CommandSetType getMessagetype();
	
	// Make Abstract
	protected void setMessagetype() throws DicomException {
	}

}
