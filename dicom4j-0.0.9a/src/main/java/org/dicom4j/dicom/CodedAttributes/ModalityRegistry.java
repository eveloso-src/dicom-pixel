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

import org.dicom4j.dicom.CodedAttributes.support.AbstractCodedAttributeRegistry;
import org.dicom4j.dicom.CodedAttributes.support.CodedAttributeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Modality's registry
 * 
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ModalityRegistry extends AbstractCodedAttributeRegistry {

	private static final Logger logger = LoggerFactory
	.getLogger(ModalityRegistry.class);

	private static final long serialVersionUID = 1L;

	public ModalityRegistry() {
		super();
		try {
			this.add(Modality.ComputedRadiography);
			this.add(Modality.ComputedTomography);
			this.add(Modality.IntraOralRadiography);
			this.add(Modality.MagneticResonance);
			this.add(Modality.Mammography);
			this.add(Modality.Other);
			this.add(Modality.Ultrasound);
		} catch (Exception ex) {
			logger.error(ex.getMessage());
		}
	}

	@Override
	public CodedAttributeType getType() {
		return CodedAttributeType.MODALITY;
	}

}
