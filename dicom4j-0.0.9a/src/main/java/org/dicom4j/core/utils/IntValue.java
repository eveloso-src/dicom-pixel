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
 * Associate an int value to a string (ex: 4 - value4)
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class IntValue implements Comparable<IntValue> {

	/**
	 * the value
	 */
	private int value;

	private String valueAsString;

	public IntValue(int aValue) {
		this(aValue, "");
	}

	public IntValue(int aValue, String aValueAsString) {
		super();
		this.value = aValue;
		this.valueAsString = aValueAsString;
	}

	public int compareTo(IntValue obj) {
		return this.value - obj.value();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else {
			return this.value == ((IntValue) obj).value;
		}
	}

	/**
	 * Priority as string
	 * 
	 * @return Priority
	 */
	@Override
	public String toString() {
		return this.valueAsString + " (value: " + this.value + ")";
	}

	public int value() {
		return this.value;
	}

	public String valueAsString() {
		return this.valueAsString;
	}
}
