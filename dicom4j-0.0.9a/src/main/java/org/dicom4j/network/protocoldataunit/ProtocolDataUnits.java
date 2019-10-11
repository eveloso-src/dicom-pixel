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

package org.dicom4j.network.protocoldataunit;

import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.dolmen.core.util.AbstractList;

/**
 * <p>
 * a list of {@see ProtocolDataUnit}
 * </p>
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ProtocolDataUnits extends AbstractList {

	public ProtocolDataUnits() {
		super();
	}

	/**
	 * add a ProtocolDataUnit
	 * 
	 * @param aProtocolDataUnit
	 *          the PDU
	 * @return the added ProtocolDataUnit
	 */
	public AbstractProtocolDataUnit add(AbstractProtocolDataUnit aProtocolDataUnit) {
		return (AbstractProtocolDataUnit) super.addItem(aProtocolDataUnit);
	}

	public AbstractProtocolDataUnit get(int aIndex) {
		return (AbstractProtocolDataUnit) super.getItem(aIndex);
	}

}
