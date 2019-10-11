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

import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * List of {@link UniqueIdentifier UniqueIdentifier}
 * 
 * @deprecated
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
@Deprecated
public class UniqueIdentifiers {

	/**
	 * the logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(UniqueIdentifiers.class);

	/**
	 * the innter map to store UID
	 */
	private TreeMap<String, UniqueIdentifier> list;

	public UniqueIdentifiers() {
		super();
		this.list = new TreeMap<String, UniqueIdentifier>();
		// addUIDs();
	}

	/**
	 * add one {@link UniqueIdentifier}
	 * 
	 * @param aUniqueIdentifier
	 *          the UniqueIdentifier
	 * @return the added UniqueIdentifier
	 * 
	 * @since 0.0.2
	 */
	public UniqueIdentifier add(UniqueIdentifier aUniqueIdentifier) {
		this.list.put(aUniqueIdentifier.getUID(), aUniqueIdentifier);
		return aUniqueIdentifier;
	}

	// protected abstract void addUIDs();

	/**
	 * return true if an Object is associated to the request UID
	 * 
	 * @param aUID
	 *          the UID to check for an object
	 * @return true if exist
	 * 
	 * @since 0.0.4
	 */
	public boolean containsUID(String aUID) {
		if (this.getByUID(aUID.trim()) != null) {
			return true;
		} else {
			return false;
		}
	}

	public int count() {
		return this.list.size();
	}

	public UniqueIdentifier getByUID(String aUID) {
		logger.debug(this.getClass().getName() + ".getByUID: " + aUID);
		UniqueIdentifier lUniqueIdentifier = this.list.get(aUID.trim());
		if (lUniqueIdentifier == null) {
			logger.warn("getByUID: UniqueIdentifier with " + aUID
					+ "UID can't be found");
		}
		return lUniqueIdentifier;
	}

	/**
	 * return the Name associated to the UID
	 * 
	 * @param aUID
	 * @return
	 */
	public String getName(String aUID) {
		UniqueIdentifier lUID = this.getByUID(aUID);
		if (lUID != null) {
			return lUID.getName();
		} else {
			return aUID;
		}
	}

	/**
	 * @deprecated use containsUID return true if an Object is associated to the
	 *             request UID
	 * @param aUID
	 *          the UID to check for an object
	 * @return true if exist
	 */
	@Deprecated
	public boolean isSupported(String aUID) {
		if (this.getByUID(aUID) != null) {
			return true;
		} else {
			return false;
		}
	}

}
