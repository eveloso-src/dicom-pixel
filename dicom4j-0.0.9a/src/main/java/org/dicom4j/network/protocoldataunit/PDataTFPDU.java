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

package org.dicom4j.network.protocoldataunit;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.LinkedList;
import java.util.ListIterator;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.items.PresentationDataValueItem;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * P-DATA-TF PDU as defined in DICOM PS 3.8
 * 
 * @internal
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class PDataTFPDU extends AbstractProtocolDataUnit {

	private static Logger logger = LoggerFactory.getLogger(PDataTFPDU.class);

	private LinkedList<PresentationDataValueItem> fPresentationDataValues;

	public PDataTFPDU() {
		super();
		this.fPresentationDataValues = new LinkedList<PresentationDataValueItem>();
	}

	/**
	 * @deprecated
	 * @param aStream
	 * @param aLength
	 * @throws DicomException
	 * @throws IOException
	 */
	@Deprecated
	public PDataTFPDU(BinaryInputStream aStream, int aLength)
	throws DicomException, IOException {
		this();
		this.read(aStream, aLength);
	}

	public void addPresentationDataValueItem(PresentationDataValueItem aPDV) {
		this.getPresentationDataValues().add(aPDV);
	}

	/***/
	public boolean containsLastCommandFragment() {
		boolean found = false;
		if ((this.fPresentationDataValues != null)
				&& (this.fPresentationDataValues.size() > 0)) {
			// need to iterate through fragments, since data may follow last fragment
			// of command
			ListIterator i = this.getPresentationDataValues().listIterator();
			while (i.hasNext()) {
				PresentationDataValueItem pdv = (PresentationDataValueItem) i.next();
				if (pdv.isLastFragment() && pdv.isCommand()) {
					found = true;
					break;
				}
			}
		}
		logger.debug("containsLastCommandFragment: " + Boolean.toString(found));
		return found;
	}

	/***/
	public boolean containsLastDataFragment() {
		boolean found = false;
		if ((this.fPresentationDataValues != null)
				&& (this.fPresentationDataValues.size() > 0)) {
			// only need to look at last fragment, since nothing can come after data
			PresentationDataValueItem pdv = this.fPresentationDataValues.getLast();
			if (pdv.isLastFragment() && !pdv.isCommand()) {
				found = true;
			}
		}
		logger.debug("containsLastDataFragment: " + Boolean.toString(found));
		return found;
	}

	private int getInternalLength() {
		int res = 0;
		ListIterator i = this.fPresentationDataValues.listIterator();
		while (i.hasNext()) {
			PresentationDataValueItem pdv = (PresentationDataValueItem) i.next();
			res = res + (int) pdv.getLength();
		}
		return res;
	}

	@Override
	public int getLength() {
		return this.getInternalLength() + 6;
	}

	@Override
	public String getName() {
		return "P-Data-TF";
	}

	/***/
	public LinkedList<PresentationDataValueItem> getPresentationDataValues() {
		return this.fPresentationDataValues;
	}

	@Override
	public ProtocolDataUnitType getType() {
		return ProtocolDataUnitType.P_DATA_TF;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		long llength = length; // aReader.readUnsigned32();
		long offset = 6; // we already readed 6 bytes
		while (offset < llength) {
			PresentationDataValueItem lItem = new PresentationDataValueItem(stream);
			this.fPresentationDataValues.add(lItem);
			offset += lItem.getLength();
		}
	}

	@Override
	public String toString() {
		StringBuffer lBuff = new StringBuffer();
		lBuff.append(this.getName() + " (");
		lBuff.append("contain(s) " + this.fPresentationDataValues.size() + " PDV");
		lBuff.append(")");
		return lBuff.toString();
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
		stream.write(this.getType().value());
		stream.write(0x00); // reserved
		stream.writeUnsigned32(this.getInternalLength());
		// one or more Presentation Data Values ...
		ListIterator i = this.fPresentationDataValues.listIterator();
		while (i.hasNext()) {
			PresentationDataValueItem pdv = (PresentationDataValueItem) i.next();
			pdv.write(stream);
			// aStream.write(pdv.getBytes());
		}

	}
}
