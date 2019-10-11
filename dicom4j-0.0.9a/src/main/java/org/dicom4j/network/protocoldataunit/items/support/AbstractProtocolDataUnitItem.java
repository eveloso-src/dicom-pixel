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

package org.dicom4j.network.protocoldataunit.items.support;

import java.io.IOException;
import java.nio.ByteOrder;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.SOPClasses;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.items.ProtocolDataUnitItem;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for PDU items
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractProtocolDataUnitItem extends AbstractProtocolDataUnit implements ProtocolDataUnitItem {

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory.getLogger(AbstractProtocolDataUnitItem.class);

	/**
	 * the value (for String User Items)
	 */
	private String value;

	protected AbstractProtocolDataUnitItem() {
		this("");
	}

	/**
	 * @deprecated
	 * @since 0.0.6
	 * @param aReader
	 * @throws DicomException
	 * @throws IOException
	 */
	@Deprecated
	protected AbstractProtocolDataUnitItem(BinaryInputStream aReader)
	throws DicomException, IOException {
		this();
		this.read(aReader, 0);
	}

	protected AbstractProtocolDataUnitItem(String aValue) {
		super();
		this.setValue(aValue);
	}

	/**
	 * Return the number of bytes of the item
	 * 
	 * @return Number of bytes
	 */
	@Override
	public int getLength() {
		// 4 : type(1) + reserved(1) + length (2)
		return 4 + this.getValue().length();
	}

	protected String getValue() {
		return this.value;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("Start reading (length: " + length + ")");
		stream.skip(1); // We must skip the first reserved byte
		int llength = stream.readUnsigned16();
		logger.debug("llength: " + llength);
		this.value = stream.readASCII(llength);
	}

	protected void setValue(String aValue) {
		assert aValue != null;
		this.value = aValue;
	}

	@Override
	public String toString() {
		return this.getName() + ": " + getSopClassRegistry().getName(this.getValue());
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		// fLogger.debug("Start writing");
		if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
		stream.write(this.getType().value());
		stream.write(0x00); // reserverd
		byte[] lValue = this.getValue().getBytes("ASCII");
		stream.writeUnsigned16(lValue.length);
		logger.debug("value writed: " + this.getValue());
		stream.write(lValue);
		// fLogger.debug("End writing");
	}

}
