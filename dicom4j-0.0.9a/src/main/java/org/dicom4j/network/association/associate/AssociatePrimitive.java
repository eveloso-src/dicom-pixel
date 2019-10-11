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

import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;

/**
 * Base class for all Associate-*
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AssociatePrimitive {

	private ProtocolDataUnit protocolDataUnit;

	protected AssociatePrimitive(AbstractProtocolDataUnit aProtocolDataUnit) {
		super();
		assert aProtocolDataUnit != null;
		this.protocolDataUnit = aProtocolDataUnit;
	}

	/**
	 * return the ProtocolDataUnit
	 * 
	 * @return the ProtocolDataUnit
	 */
	public ProtocolDataUnit getProtocolDataUnit() {
		return this.protocolDataUnit;
	}

	@Override
	public String toString() {
		return this.getProtocolDataUnit().toString();
	}

}
