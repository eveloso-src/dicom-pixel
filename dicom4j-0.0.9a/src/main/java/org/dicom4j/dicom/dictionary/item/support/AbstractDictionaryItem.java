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

package org.dicom4j.dicom.dictionary.item.support;

import org.dicom4j.dicom.dictionary.item.DictionaryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract {@link DictionaryItem} implements
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AbstractDictionaryItem implements DictionaryItem {

	private static final Logger logger = LoggerFactory.getLogger(AbstractDictionaryItem.class);

	private String fType;

	private String key;

	private String name;

	public AbstractDictionaryItem() {
		this("", "");
	}

	public AbstractDictionaryItem(String key) {
		this(key, "");
	}

	public AbstractDictionaryItem(String key, String name) {
		super();
		this.setKey(key);
		this.setName(name);
		this.setType("");
	}

	public String getKey() {
		return this.key;
	}

	public String getName() {
		return this.name;
	}

	public String getType() {
		return this.fType;
	}

	public void setKey(String aKey) {
		logger.warn("setKey: " + aKey);
		if (aKey != null) {
			this.key = aKey;
		}
	}

	public void setName(String aName) {
		if (aName != null) {
			this.name = aName;
		}
	}

	public void setType(String aType) {
		if (aType != null) {
			this.fType = aType;
		}
	}

}
