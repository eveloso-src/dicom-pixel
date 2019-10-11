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

import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Other Word String (OW) {@link DataElement DataElement}
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class OtherWordString extends DataElement {

	/**
	 * the logger
	 */
	private static Logger fLogger = LoggerFactory
	.getLogger(OtherWordString.class);

	/**
	 * the data
	 */
	private short[] values;

	/**
	 * <p>
	 * Construct an (empty) attribute.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 */
	public OtherWordString(DicomTag t) {
		super(t);
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public short[] getShortValues() throws DicomException {
		return this.values;
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (OW)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.OtherWordString;
	}

	/**
	 * <p>
	 * 
	 * @deprecated Get the value representation of this attribute (OW).
	 *             </p>
	 * 
	 * @return 'O','W' in ASCII as a two byte array; see
	 */
	@Deprecated
	public byte[] getVR() {
		return ValueRepresentation.OW;
	}

	@Override
	public boolean isAvailableAsString() {
		return false;
	}

	/**
	 * @param vl
	 * @param i
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException,
			DataElementException {
		fLogger.debug("read (length: " + aLength + " ) ");
		this.values = null;
		this.fValueLength = aLength;

		if (aLength > 0) {
			int len = (int) (aLength / 2);
			short buffer[] = new short[len];
			aStream.readUnsigned16(buffer, len);
			this.setValues(buffer);
			fLogger.debug("read completed");
		}
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void setValues(short[] v) throws DataElementException {
		this.values = v;
		this.fValueMultiplicity = 1; // different from normal value types where VM
		// is
		// size of array
		this.fValueLength = v.length * 2;
	}

	/***/
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" []"); // i.e. don't really dump values ... too many
		return str.toString();
	}

	/**
	 * @param o
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void write(DicomOutputStream o) throws IOException,
	DataElementException {
		this.writeBase(o);
		if ((this.values != null) && (this.values.length > 0)) {
			o.writeUnsigned16(this.values, this.values.length);
			if (this.getValueLength() != this.values.length * 2) {
				throw new DataElementException("Internal error - short array length ("
						+ this.values.length * 2 + ") not equal to expected VL("
						+ this.getValueLength() + ")");
			}
		}
	}

}
