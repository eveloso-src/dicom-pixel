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

import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.data.elements.support.StringElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;

/**
 * <p>
 * Decimal String (DS) {@link DataElement element}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class DecimalString extends StringElement {

	/**
	 * <p>
	 * Construct an (empty) attribute.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 */
	public DecimalString(DicomTag t) {
		super(t);
	}

	/**
	 * <p>
	 * Read an attribute from an input stream.
	 * </p>
	 * 
	 * @param t
	 *          the tag of the attribute
	 * @param vl
	 *          the value length of the attribute
	 * @param i
	 *          the input stream
	 * @exception IOException
	 * @exception DicomException
	 */
	public DecimalString(DicomTag t, long vl, DicomInputStream i)
	throws IOException, DicomException {
		super(t, vl, i);
	}

	/**
	 * @param format
	 *          the format to use for each numerical or decimal value
	 * @exception DicomException
	 */
	@Override
	public String[] getStringValues(NumberFormat format) throws DicomException {
		String sv[] = null;
		if (format == null) {
			sv = super.getStringValues(null);
		} else {
			double[] v = this.getDoubleValues();
			if (v != null) {
				sv = new String[v.length];
				for (int j = 0; j < v.length; ++j) {
					sv[j] = format.format(v[j]);
				}
			}
		}
		return sv;
	}

	/**
	 * Return the value representation of this element
	 * 
	 * @return the value representation (DS)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.DecimalString;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (DS).
	 * </p>
	 * 
	 * @return 'D','S' in ASCII as a two byte array; see
	 */
	public byte[] getVR() {
		return ValueRepresentation.DS;
	}

}
