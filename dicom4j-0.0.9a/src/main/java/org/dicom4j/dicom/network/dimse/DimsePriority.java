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

package org.dicom4j.dicom.network.dimse;

import org.dicom4j.core.utils.IntValue;

/**
 * Dimse Priority
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DimsePriority extends IntValue {

	/**
	 * HIGH priority
	 */
	public final static DimsePriority HIGH = new DimsePriority(0x0001, "High");

	/**
	 * LOW priority
	 */
	public final static DimsePriority LOW = new DimsePriority(0x0002, "Low");

	/**
	 * MEDIUM priority
	 */
	public final static DimsePriority MEDIUM = new DimsePriority(0x0000, "Medium");

	public static String toString(int priority) {
		if (priority == HIGH.value()) {
			return HIGH.valueAsString();
		} else if (priority == MEDIUM.value()) {
			return MEDIUM.valueAsString();
		} else if (priority == LOW.value()) {
			return LOW.valueAsString();
		} else {
			return "Unknown priority";
		}

	}

	public DimsePriority(int aValue) {
		super(aValue);
	}

	public DimsePriority(int aValue, String aValueAsString) {
		super(aValue, aValueAsString);
	}

	/**
	 * Priority as string
	 * 
	 * @return Priority
	 */
	@Override
	public String toString() {
		if (this.value() == 0x0002) {
			return "Low";
		} else if (this.value() == 0x0000) {
			return "Medium";
		} else if (this.value() == 0x0001) {
			return "High";
		} else {
			return "Unknown priority";
		}
	}

}
