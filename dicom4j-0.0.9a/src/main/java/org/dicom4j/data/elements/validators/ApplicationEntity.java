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

/**
 * 
 */
package org.dicom4j.data.elements.validators;

/**
 * to valid a {@link ApplicationEntity} element
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ApplicationEntity extends DataElementValidator {

	/**
	 * retrun true is the supplied AET is valid
	 * 
	 * @param aAET
	 *          the ATE
	 * @return true if valid
	 */
	public boolean isValid(String aAET) {
		if (aAET.length() > 16) {
			return false;
		}
		return true;
		// TODO check other AET rules

	}

}
