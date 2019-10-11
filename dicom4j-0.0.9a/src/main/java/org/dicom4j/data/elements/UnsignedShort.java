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
import java.text.NumberFormat;

import org.apache.commons.lang.ArrayUtils;
import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;

/**
 * Unsigned Short (US) {@link DataElement Attribute}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class UnsignedShort extends DataElement {

	static private int BYTES_PER_VALUES = 2;

	private int[] fValues;

	/**
	 * creates new Element
	 * 
	 * @param aDataElementTag
	 *          the tag
	 */
	public UnsignedShort(DicomTag aDataElementTag) {
		super(aDataElementTag);
		this.fValues = new int[0];
	}

	public UnsignedShort(DicomTag t, int aUnsigned16) throws DicomException {
		this(t);
		this.addValue(aUnsigned16);
	}

	/**
	 * add a new Value to this element
	 * 
	 * @param aUnsigned16
	 *          the value
	 * @exception DicomException
	 */
	@Override
	public void addValue(int aUnsigned16) throws DicomException {
		if (aUnsigned16 < 0) {
			throw new DicomException(aUnsigned16 + " is not a valid value for "
					+ this.getValueRepresentation().toString());
		}
		if (aUnsigned16 > 65536) {
			throw new DicomException(aUnsigned16 + " is not a valid for "
					+ this.getValueRepresentation().toString());
		}
		this.fValues = ArrayUtils.add(this.fValues, aUnsigned16);
		this.fValueLength += 2;
	}

	public int getIntegerValue(int aIndex) {
		return this.getValues()[aIndex];
	}

	@Override
	public int[] getIntegerValues() throws DicomException {
		return this.fValues;
	}

	@Override
	public long getPaddedVL() {
		return this.getValueMultiplicity() * BYTES_PER_VALUES;
	}

	@Override
	public String[] getStringValues(NumberFormat format) throws DicomException {
		return org.dolmen.core.lang.util.ArrayUtils.intToString(this.getValues(),
				format);
	}

	@Override
	public int getValueMultiplicity() {
		return this.fValues.length;
	}

	/**
	 * get the value representation of this data element
	 * 
	 * @return the value representation (UL)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.UnsignedShort;
	}

	public int[] getValues() {
		return this.fValues;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (US).
	 * </p>
	 * 
	 * @return 'U','S' in ASCII as a two byte array; see
	 */
	public byte[] getVR() {
		return ValueRepresentation.US;
	}

	@Override
	public void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException {
		if (aLength % BYTES_PER_VALUES != 0) {
			throw new DicomException("incorrect value length for VR " + this.getVR());
		}
		int vm = (int) (aLength / BYTES_PER_VALUES);
		this.fValues = null;
		for (int j = 0; j < vm; ++j) {
			this.addValue(aStream.readUnsigned16());
		}
	}

	public void setValue(int aUnsigned16) throws DicomException {
		this.fValues = new int[0];
		this.addValue(aUnsigned16); // we add the value
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" [");
		if (this.fValues != null) {
			for (int j = 0; j < this.fValues.length; ++j) {
				if (j > 0) {
					str.append(",");
				}
				str.append("0x");
				str.append(Integer.toHexString(this.fValues[j]));
			}
		}
		str.append("]");
		return str.toString();
	}

	@Override
	public void write(DicomOutputStream o) throws DicomException, IOException {
		this.writeBase(o);
		for (int j = 0; j < this.fValues.length; ++j) {
			o.writeUnsigned16(this.fValues[j]);
		}
	}

}
