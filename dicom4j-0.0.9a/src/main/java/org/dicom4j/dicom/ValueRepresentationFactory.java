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

package org.dicom4j.dicom;

/**
 * Factory to create {@link ValueRepresentation}
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ValueRepresentationFactory {

	// TODO make the implements

	public ValueRepresentation newValueRepresentation(byte[] vr) throws Exception {
		if (vr.length != 2) {
			throw new Exception("newValueRepresentation must be call with an array of 2 bytes");
		}
		// String lVR = (String)aVR[0] + (String)aVR[1];
		if ((vr[0] == 'A') && (vr[1] == 'E')) {
			return ValueRepresentation.ApplicationEntity;
		} else if ((vr[0] == 'A') && (vr[1] == 'S')) {
			return ValueRepresentation.AgeString;
		} else if ((vr[0] == 'A') && (vr[1] == 'T')) {
			return ValueRepresentation.AttributeTag;
		} else if ((vr[0] == 'C') && (vr[1] == 'S')) {
			return ValueRepresentation.CodeString;
		} else if ( ValueRepresentation.isDateVR(vr) ) {
			return ValueRepresentation.Date;
		} else {
			return new ValueRepresentation(vr);
		}

	}
}
