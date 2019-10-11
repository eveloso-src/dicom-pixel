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

package org.dicom4j.network.association.associate;

import org.dicom4j.network.protocoldataunit.AssociateRJPDU;

/**
 * Associate Reject primitive
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * @since 0.0.0
 */
public class AssociateReject extends AssociatePrimitive {

	public AssociateReject(AssociateRJPDU aAssociateRJPDU) {
		super(aAssociateRJPDU);
	}

	public AssociateReject(byte aResult, byte aSource, byte aReason) {
		this(new AssociateRJPDU(aResult, aSource, aReason));
	}
}
