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

/**
 * <p>
 * Other Float String (OF) {@link DataElement DataElement}
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class OtherFloatString extends DataElement {

	private float[] values;

	/**
	 * <p>
	 * Creates an empty element
	 * </p>
	 * 
	 * @param aTag
	 *          the tag of the element
	 */
	public OtherFloatString(DicomTag aTag) {
		super(aTag);
	}

	/**
	 * @exception DicomException
	 */
	@Override
	public float[] getFloatValues() throws DicomException {
		return this.values;
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (OF)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.OtherFloatString;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (OF).
	 * </p>
	 * 
	 * @return 'O','F' in ASCII as a two byte array; see
	 */
	public byte[] getVR() {
		return ValueRepresentation.OF;
	}

	@Override
	public void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException {
		this.values = null;
		this.fValueLength = aLength;

		if (aLength > 0) {
			int len = (int) (aLength / 4);
			float buffer[] = new float[len];
			aStream.readFloat(buffer, len);
			this.setValues(buffer);
		}
	}

	/**
	 * @param v
	 * @exception DicomException
	 */
	@Override
	public void setValues(float[] v) throws DicomException {
		this.values = v;
		this.fValueMultiplicity = 1; // different from normal value types where VM
		// is
		// size of array
		this.fValueLength = v.length * 4;
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
	public void write(DicomOutputStream o) throws DicomException, IOException {
		this.writeBase(o);
		if ((this.values != null) && (this.values.length > 0)) {
			o.writeFloat(this.values, this.values.length);
			if (this.getValueLength() != this.values.length * 4) {
				throw new DicomException("Internal error - float array length ("
						+ this.values.length * 2 + ") not equal to expected VL("
						+ this.getValueLength() + ")");
			}
		}
	}

}
