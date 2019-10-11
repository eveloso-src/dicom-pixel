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

package org.dicom4j.data.elements;

import java.io.IOException;
import java.util.Iterator;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.DicomOutputStream;

/**
 * <p>
 * a Sequence of items contained in a SequenceOfItems (SQ)
 * </p>
 * 
 * @since Alpha 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class SequenceItems {

	/**
	 * the byte offset of this Item when readed (need for display a Dicom Dir)
	 */
	private long fByteOffset; // value of 0 is flag that it is not set

	/**
	 * the Data
	 */
	private DataSet fDataSet;

	/**
	 * 
	 * Creates an Sequence from a DataSet
	 * 
	 * @param aDataSet
	 *          the dataset
	 */
	public SequenceItems(DataSet aDataSet) {
		this(aDataSet, 0);
	}

	/**
	 * Creates an Sequence from a DataSet
	 * 
	 * @param aDataSet
	 *          the dataset
	 * @param offset
	 *          the offset
	 */
	public SequenceItems(DataSet aDataSet, long offset) {
		super();
		this.fDataSet = aDataSet;
		this.fByteOffset = offset;
	}

	/**
	 * clear the DataSet
	 * 
	 */
	public void clear() {
		if (this.fDataSet != null) {
			this.fDataSet.clear();
		}
	}

	/**
	 * <p>
	 * Get the byte offset of the start of this item recorded when the item was
	 * read.
	 * </p>
	 * 
	 * @return the byte offset
	 */
	public long getByteOffset() {
		return this.fByteOffset;
	}

	/**
	 * get the Dataset of this sequence of items
	 * 
	 * @return the DataSet
	 */
	public DataSet getDataSet() {
		assert this.fDataSet != null;
		return this.fDataSet;
	}

	/**
	 * <p>
	 * Dump the item in a human readable form, list the contained attributes.
	 * </p>
	 * 
	 * @return the string representing the content of the item
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("%item");
		if (this.fByteOffset != 0) {
			str.append(" [starts at 0x");
			str.append(Long.toHexString(this.fByteOffset));
			str.append("]");
		}
		str.append("\n");
		str.append(this.getDataSet().toString());
		str.append("%enditem");
		return str.toString();
	}

	/**
	 * <p>
	 * Write the item (with appropriate delimiter tags) to the output stream.
	 * </p>
	 * 
	 * <p>
	 * Always written in undefined length form.
	 * </p>
	 * 
	 * @param aOutputStream
	 *          the output stream
	 * @exception IOException
	 * @exception DicomException
	 */
	public void write(DicomOutputStream aOutputStream) throws DicomException,
	IOException {
		// fLogger.debug("Start write");
		aOutputStream.writeUnsigned16(0xfffe); // Item
		aOutputStream.writeUnsigned16(0xe000);
		aOutputStream.writeUnsigned32(0xffffffffl); // undefined length
		// null, the TransferSyntax was already set
		Iterator lIT = this.getDataSet().getIterator();
		while (lIT.hasNext()) {
			DataElement lElement = (DataElement) lIT.next();
			lElement.write(aOutputStream);
		}
		// for (int i=0 ; i < getDataSet().count(); i++) {
		// DataElement lElemetn=getDataSet().get
		// }
		// getDataSet().write(aOutputStream, null);
		aOutputStream.writeUnsigned16(0xfffe); // Item Delimiter
		aOutputStream.writeUnsigned16(0xe00d);
		aOutputStream.writeUnsigned32(0); // dummy length
		// fLogger.debug("End write");
	}

	// private static final Logger fLogger =
	// LoggerFactory.getLogger(SequenceItems.class);

}
