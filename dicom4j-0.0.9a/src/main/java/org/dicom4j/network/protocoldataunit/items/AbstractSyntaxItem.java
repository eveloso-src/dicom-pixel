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
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.items.support.AbstractProtocolDataUnitItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Abstract Syntax Item.
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AbstractSyntaxItem extends AbstractProtocolDataUnitItem {

	private static Logger logger = LoggerFactory
	.getLogger(AbstractSyntaxItem.class);

	public AbstractSyntaxItem() {
		this("");
	}

	/**
	 * @deprecated
	 * @param aReader
	 * @throws DicomException
	 * @throws IOException
	 */
	@Deprecated
	public AbstractSyntaxItem(BinaryInputStream aReader) throws DicomException,
	IOException {
		super(aReader);
	}

	public AbstractSyntaxItem(String aValue) {
		super(aValue);
	}

	@Override
	public ProtocolDataUnitItemType getType() {
		return ProtocolDataUnitItemType.ABSTRACT_SYNTAX;
	}

	@Override
	public String getValue() {
		return super.getValue();
	}

	public void setValue(SOPClass sopClass) {
		this.setValue(sopClass.getUID());
	}

	@Override
	public void setValue(String aValue) {
		super.setValue(aValue);
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		logger.debug("Start writing...");
		super.write(stream);
	}
}
