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

import org.dicom4j.core.utils.ArrayCopyUtilities;
import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;

/**
 * <p>
 * Signed Long (SL) {@link DataElement element}
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class SignedLong extends DataElement {

	static int bytesPerValue = 4;

	long[] cachedLongCopy;

	short[] cachedShortCopy;

	int[] values;

	/**
	 * <p>
	 * Construct an (empty) attribute.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 */
	public SignedLong(DicomTag t) {
		super(t);
		this.flushCachedCopies();
		this.values = null;
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void addValue(int v) throws DicomException {
		this.flushCachedCopies();
		this.values = ArrayCopyUtilities.expandArray(this.values);
		this.values[this.fValueMultiplicity++] = v;
		this.fValueLength += 4;
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void addValue(long v) throws DicomException {
		this.flushCachedCopies();
		this.addValue((short) v);
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void addValue(short v) throws DicomException {
		this.flushCachedCopies();
		this.addValue((int) v); // should we sign extend or not ? :(
	}

	private void flushCachedCopies() {
		this.cachedShortCopy = null;
		this.cachedLongCopy = null;
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public int[] getIntegerValues() throws DicomException {
		return this.values;
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public long[] getLongValues() throws DicomException {
		if (this.cachedLongCopy == null) {
			this.cachedLongCopy = ArrayCopyUtilities
			.copySignedIntToLongArray(this.values);
		}
		return this.cachedLongCopy;
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public short[] getShortValues() throws DicomException {
		if (this.cachedShortCopy == null) {
			this.cachedShortCopy = ArrayCopyUtilities
			.copySignedIntToShortArray(this.values);
		}
		return this.cachedShortCopy;
	}

	/**
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @exception DicomException
	 */
	@Override
	public String[] getStringValues(NumberFormat format) throws DicomException {
		String sv[] = null;
		int[] v = this.getIntegerValues();
		if (v != null) {
			sv = new String[v.length];
			for (int j = 0; j < v.length; ++j) {
				sv[j] = format == null ? Long.toString(v[j]) : format.format(v[j]);
			}
		}
		return sv;
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (SL)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.SignedLong;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (SL).
	 * </p>
	 * 
	 * @return 'S','L' in ASCII as a two byte array; see
	 */
	public byte[] getVR() {
		return ValueRepresentation.SL;
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
		this.flushCachedCopies();
		if (aLength % bytesPerValue != 0) {
			throw new DicomException("incorrect value length for VR " + this.getVR());
		}
		int vm = (int) (aLength / bytesPerValue);
		this.values = null;
		for (int j = 0; j < vm; ++j) {
			this.addValue(aStream.readSigned32());
		}
	}

	/***/
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append(" [");
		try {
			long[] v = this.getLongValues();
			if (v != null) {
				for (int j = 0; j < v.length; ++j) {
					if (j > 0) {
						str.append(",");
					}
					str.append("0x");
					str.append(Long.toHexString(v[j]));
				}
			}
		} catch (DicomException e) {
			str.append("XXXX");
		}
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
		int[] v = this.getIntegerValues();
		if (v != null) {
			for (int j = 0; j < v.length; ++j) {
				o.writeSigned32(v[j]);
			}
		}
	}

}
