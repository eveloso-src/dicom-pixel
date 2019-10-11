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

package org.dicom4j.network.protocoldataunit.items;

import java.io.IOException;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnitType;
import org.dicom4j.network.protocoldataunit.items.support.AbstractProtocolDataUnitItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Transfer Syntax Item (see DICOM PS 3.8)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TransferSyntaxItem extends AbstractProtocolDataUnitItem {

	protected static Logger logger = LoggerFactory.getLogger(TransferSyntaxItem.class);

	public TransferSyntaxItem() {
		this("");
	}

	/**
	 * Creates new Item from stream
	 * 
	 * @deprecated
	 * @param aReader
	 * @throws DicomException
	 * @throws IOException
	 */
	@Deprecated
	public TransferSyntaxItem(BinaryInputStream aReader) throws DicomException,
	IOException {
		super(aReader);
	}

	/**
	 * Creates new Item
	 * 
	 * @param aValue
	 *          a valid {@link org.dicom4j.dicom.uniqueidentifiers.TransferSyntax
	 *          TransferSyntax} UID
	 */
	public TransferSyntaxItem(String aValue) {
		super(aValue);
	}

	/**
	 * return the TransferSyntax's name (or the UID' value if no
	 * TransferSyntaxRegistry was set)
	 * 
	 * @return name or UID
	 */
	public String getTransferSyntaxName() {
		if (this.getTransferSyntaxRegistry() == null) {
			logger.warn("no TransferSyntaxRegistry was set, we return the UID");
			return this.getValue();
		} else {
			try {
				return this.getTransferSyntaxRegistry().getName(this.getValue());
			} catch (Exception ex) {
				logger.warn(ex.getMessage());
				return this.getValue();
			}
		}
	}

	@Override
	public ProtocolDataUnitType getType() {
		return ProtocolDataUnitItemType.TRANSFERT_SYNTAX;
	}

	@Override
	public String getValue() {
		return super.getValue();
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("Start reading (length: " + length + ")");
		stream.skip(1); // We must skip the first reserved byte
		int valueLength = stream.readUnsigned16();
		this.setValue(stream.readASCII(valueLength));
		logger.info("read: (value:" + this.getTransferSyntaxName() + ", length: "
				+ valueLength + ")");
	}

	public void setTransferSyntax(TransferSyntax transferSyntax) {
		this.setValue(transferSyntax.getUID());
	}

	@Override
	public void setValue(String aValue) {
		super.setValue(aValue);
	}

	@Override
	public String toString() {
		return this.getName() + "(UID: " + this.getValue() + ",name: "
		+ this.getTransferSyntaxName() + ")";
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		logger.debug("Start writing...");
		super.write(stream);
	}

}
