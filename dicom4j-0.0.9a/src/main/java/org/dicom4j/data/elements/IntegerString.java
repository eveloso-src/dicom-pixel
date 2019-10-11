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

import java.text.NumberFormat;

import org.dicom4j.core.utils.ArrayCopyUtilities;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.data.elements.support.StringElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;

/**
 * <p>
 * Integer String (IS) {@link DataElement DataElement}
 * </p>
 * 
 * @since Alpha 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class IntegerString extends StringElement {

	public final static int MAXIMUM_LENGTH = 12;

	/**
	 * <p>
	 * Creates an empty element
	 * </p>
	 * 
	 * @param aTag
	 *          the tag of the element
	 */
	public IntegerString(DicomTag aTag) {
		super(aTag);
	}

	// TODO read al String a return 10 if "+10" and -10 if "-10"
	@Override
	public int[] getIntegerValues() throws DicomException {
		return ArrayCopyUtilities.copyStringToIntArray(this.getStringValues(null));
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
			long[] v = this.getLongValues();
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
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (IS)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.IntegerString;
	}

	/*
	 * public int[] getIntegerValues() throws DicomException { if
	 * (cachedIntegerCopy == null)
	 * cachedIntegerCopy=ArrayCopyUtilities.copyStringToIntArray
	 * (getStringValues()); // must be unpadded return cachedIntegerCopy; }
	 */

	/**
	 * <p>
	 * Get the value representation of this attribute (IS).
	 * </p>
	 * 
	 * @return 'I','S' in ASCII as a two byte array; see
	 */
	public byte[] getVR() {
		return ValueRepresentation.IS;
	}
}
