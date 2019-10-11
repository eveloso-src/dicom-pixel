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

package org.dicom4j.dicom.dictionary;

import java.util.Iterator;
import java.util.TreeMap;

import org.dicom4j.dicom.dictionary.item.DictionaryItem;

/**
 * List of {@link DictionaryItem}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DictionaryElements /* extends AbstractList */{

	private TreeMap<String, DictionaryItem> elements;

	public DictionaryElements() {
		super();
		this.elements = new TreeMap<String, DictionaryItem>();
	}

	/**
	 * Add a new element
	 * 
	 * @param aElement
	 * @return
	 */
	public DictionaryItem add(DictionaryItem aElement) {
		this.elements.put(aElement.getKey(), aElement);
		return aElement;
	}

	/**
	 * remove all elements
	 */
	public void clear() {
		this.elements.clear();
	}

	/**
	 * get number of elements
	 */
	public int count() {
		return this.elements.size();
	}

	public DictionaryItem get(String aKey) {
		return this.elements.get(aKey);
	}

	public Iterator<DictionaryItem> getIterator() {
		return this.elements.values().iterator();
	}

}
