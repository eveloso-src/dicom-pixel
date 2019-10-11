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

package org.dicom4j.dicom.CodedAttributes;

import org.dicom4j.dicom.CodedAttributes.support.CodedAttribute;
import org.dicom4j.dicom.CodedAttributes.support.CodedAttributeType;

/**
 * Modality
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class Modality extends CodedAttribute {

	/**
	 * Computed Radiography (CR)
	 */
	public final static Modality ComputedRadiography = new Modality("CR",
	"Computed Radiography");

	/**
	 * Computed Tomography (CT)
	 */
	public final static Modality ComputedTomography = new Modality("CT",
	"Computed Tomography");

	/**
	 * Intra-oral Radiography (IO)
	 */
	public final static Modality IntraOralRadiography = new Modality("IO",
	"Intra-oral Radiography");

	public final static Modality MagneticResonance = new Modality("MR",
	"Magnetic Resonance");

	public final static Modality Mammography = new Modality("MG", "Mammography");

	public final static Modality Other = new Modality("OT", "Other");

	/**
	 * Ultrasound (US)
	 */
	public final static Modality Ultrasound = new Modality("US", "Ultrasound");

	public Modality(String aCode, String aValue) {
		super(CodedAttributeType.MODALITY, aCode, aValue);
	}

}
