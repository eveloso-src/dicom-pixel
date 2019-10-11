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

package org.dicom4j.network.protocoldataunit.support;

import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;

/**
 * Abstract {@link PresentationContexRequestItem}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractPresentationContextItem extends AbstractProtocolDataUnit {

	private byte id;

	protected AbstractPresentationContextItem() {
		super();
	}

	/**
	 * Creates new PresentationContextItem
	 * 
	 * @param id
	 */
	public AbstractPresentationContextItem(byte id) {
		super();
		this.setID(id);
	}

	/**
	 * Return the ID
	 * 
	 * @return the ID
	 */
	public byte getID() {
		return this.id;
	}

	/**
	 * Set the ID
	 * 
	 * @param id
	 */
	public void setID(byte id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "[" + this.getID() + "] Presentation Context";
	}

}
