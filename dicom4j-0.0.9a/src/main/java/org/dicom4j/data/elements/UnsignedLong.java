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
import org.dicom4j.dicom.DicomViolationException;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;

/**
 * <p>
 * Unsigned Long (UL) {@link DataElement DataElement}
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class UnsignedLong extends DataElement {

	private static final int BYTES_PER_VALUES = 4;

	/**
	 * the values of this DataElement
	 */
	private long[] fValues;

	/**
	 * <p>
	 * Creates an (empty) DataElement
	 * </p>
	 * 
	 * @param aDataElementTag
	 *          the tag of the DataElement
	 */
	public UnsignedLong(DicomTag aDataElementTag) {
		super(aDataElementTag);
		this.clear();
	}

	public UnsignedLong(DicomTag t, long aValue) throws DicomException {
		this(t);
		this.addValue(aValue);
	}

	/**
	 * @param aValue
	 *          the value
	 * @exception DicomException
	 */
	@Override
	public void addValue(long aValue) throws DicomException {
		aValue = aValue & 0xffffffff; // make sure of no sign extension
		this.fValues = ArrayUtils.add(this.fValues, aValue);
	}

	@Override
	public void clear() {
		this.fValues = new long[0];
	}

	@Override
	public long getPaddedVL() {
		return this.getValueMultiplicity() * BYTES_PER_VALUES;
	}

	@Override
	public String[] getStringValues(NumberFormat format) throws DicomException {
		return org.dolmen.core.lang.util.ArrayUtils.longToString(this.getValues(),
				format);
	}

	public long getValue(int aIndex) {
		if (aIndex > this.fValues.length) {
			return 0;
		} else {
			return this.fValues[aIndex];
		}
	}

	@Override
	public int getValueMultiplicity() {
		return this.fValues.length;
	}

	// public void setValue(long aValue) throws DicomException {

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (UL)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.UnsignedLong;
	}

	public long[] getValues() {
		return this.fValues;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (UL).
	 * </p>
	 * 
	 * @deprecated
	 * @return 'U','L' in ASCII as a two byte array; see
	 */
	@Deprecated
	public byte[] getVR() {
		return ValueRepresentation.UL;
	}

	/**
	 * @param vl
	 * @param i
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException {
		if (aLength % BYTES_PER_VALUES != 0) {
			throw new DicomViolationException("incorrect value length for VR "
					+ this.getValueRepresentation().toString());
		}
		int vm = (int) (aLength / BYTES_PER_VALUES);
		this.fValues = new long[0];
		for (int j = 0; j < vm; ++j) {
			this.addValue(aStream.readUnsigned32());
		}
	}

	public void setValue(long aValue) throws DicomException {
		this.fValues = new long[0];
		this.addValue(aValue);
	}

	/***/
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" [");
		// try {
		// long[] v = getLongValues();
		// if (v != null) {
		for (int j = 0; j < this.fValues.length; ++j) {
			if (j > 0) {
				str.append(",");
			}
			str.append("0x");
			str.append(Long.toHexString(this.fValues[j]));
		}
		// }
		// }
		/*
		 * catch (DicomException e) { str.append("XXXX"); }
		 */
		str.append("]");
		return str.toString();

	}

	/**
	 * @param o
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void write(DicomOutputStream o) throws DicomException, IOException {
		this.writeBase(o);
		for (int i = 0; i < this.fValues.length; i++) {
			o.writeUnsigned32(this.fValues[i]);
		}
	}

}
