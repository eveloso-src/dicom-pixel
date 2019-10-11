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

package org.dicom4j.core.utils;

/**
 * <p>
 * class to associate an byte value and string (example: 3 - value4)
 * </p>
 * 
 * <p>
 * this class is used to help the implements DICOM defined values
 * </p>
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ByteValue extends Value {

	/**
	 * the value
	 */
	private byte value;

	public ByteValue(byte value, String valueAsString) {
		super();
		this.value = value;
		this.setAsString(valueAsString);
	}

	public byte value() {
		return this.value;
	}

}
