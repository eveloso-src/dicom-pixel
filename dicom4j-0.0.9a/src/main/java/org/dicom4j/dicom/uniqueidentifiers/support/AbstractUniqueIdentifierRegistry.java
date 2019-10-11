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
package org.dicom4j.dicom.uniqueidentifiers.support;

import java.util.TreeMap;

import org.dicom4j.core.registry.NotFoundRegistryException;
import org.dicom4j.dicom.uniqueidentifiers.UniqueIdentifierType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Registry of {@link UniqueIdentifier}
 * </p>
 * 
 * @since 0.0.8
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractUniqueIdentifierRegistry {

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(AbstractUniqueIdentifierRegistry.class);

	private static final long serialVersionUID = 1L;

	// private static final Logger logger =
	// LoggerFactory.getLogger(AbstractUniqueIdentifierRegistry.class);

	/**
	 * the innter map to store UID
	 */
	private TreeMap<String, UniqueIdentifier> list = new TreeMap<String, UniqueIdentifier>();

	// private UniqueIdentifiers list = new UniqueIdentifiers();

	protected UniqueIdentifier add(UniqueIdentifier item) {
		this.getList().put(item.getUID(), item);
		return item;
	}

	/**
	 * Check if the registry contains an Unique Identifier with the supplied uid
	 * 
	 * @param uid
	 *          the unique identifier's uid
	 * @return true uid unique identifier found
	 */
	public boolean containsByUID(String uid) {
		return this.getList().containsKey(uid);
	}

	/**
	 * Returns the number of elements
	 * 
	 * @return the number of elements
	 */
	public int count() {
		return this.getList().size();
	}

	/**
	 * Return a UniqueIdentifier with the uid
	 * 
	 * @param uid
	 *          the unique identifier's uid
	 * @return the UniqueIdentifier or null is not uid doesn't match
	 */
	protected UniqueIdentifier getByUID(String uid)
	throws NotFoundRegistryException {
		UniqueIdentifier identifier = this.getList().get(uid);
		if (identifier == null) {
			throw new NotFoundRegistryException("Unique Identifier", uid);
		} else {
			return identifier;
		}
	}

	protected TreeMap<String, UniqueIdentifier> getList() {
		return this.list;
	}

	/**
	 * Return an UniqueIdentifier's name or the uid if no UniqueIdentifier can ben
	 * found
	 * 
	 * @param uid
	 *          the unique identifier's uid
	 * @return UniqueIdentifier's name or uid
	 */
	public String getName(String uid) {
		try {
			return this.getByUID(uid).getName();
		} catch (Exception ex) {
			logger.warn(ex.getMessage());
			return uid;
		}
	}

	/**
	 * return the type of {@link UniqueIdentifier} this registry manage
	 * 
	 * @return the type
	 */
	public abstract UniqueIdentifierType getType();

}
