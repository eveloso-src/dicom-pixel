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

package org.dicom4j.dicom.uniqueidentifiers.support;

import org.dicom4j.dicom.uniqueidentifiers.UniqueIdentifierType;

/**
 * DICOM Unique Identifiers (UID)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public abstract class UniqueIdentifier {

	/**
	 * the name
	 */
	protected String name;

	/**
	 * the type
	 */
	private UniqueIdentifierType type;

	/**
	 * the UID
	 */
	protected String uid;

	public UniqueIdentifier(int aType, String aUID, String aName) {
		super();
		this.type = new UniqueIdentifierType(aType);
		this.uid = aUID.trim();
		this.name = aName;
	}

	protected UniqueIdentifier(UniqueIdentifierType aType, String uid,
			String aName) {
		super();
		assert aType != null;
		this.type = aType;
		this.uid = uid.trim();
		this.name = aName;
	}

	/**
	 * Return the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the type of the UniqueIdentifier
	 * 
	 * @return The type of UID
	 */
	public int getType() {
		return this.type.value();
	}

	/**
	 * Return the UID
	 * 
	 * @return the UID
	 */
	public String getUID() {
		return this.uid;
	}

	@Override
	public String toString() {
		return "[" + this.getUID() + "] " + this.getName();
	}

}
