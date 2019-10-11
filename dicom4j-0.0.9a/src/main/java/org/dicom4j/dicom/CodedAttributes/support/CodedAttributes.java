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

package org.dicom4j.dicom.CodedAttributes.support;

import java.util.Iterator;
import java.util.TreeMap;

/**
 * List of {@link CodedAttribute}
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CodedAttributes {

	private TreeMap<String, CodedAttribute> items;

	public CodedAttributes() {
		this.items = new TreeMap<String, CodedAttribute>();
	}

	protected CodedAttribute add(CodedAttribute item) {
		this.items.put(item.getCode(), item);
		return item;
	}

	public int count() {
		return this.items.size();
	}

	/**
	 * Return a {@link CodedAttribute CodedAttribute }
	 * 
	 * @param aIndex
	 *          the index
	 * @return the CodedAttribute
	 */
	public CodedAttribute getByCode(String code) {
		return this.items.get(code);
	}

	/**
	 * get an {@link Iterator} to the coded attributes
	 * 
	 * @return the iterator
	 */
	public Iterator<CodedAttribute> getIterator() {
		return this.items.values().iterator();
	}

	public String getValue(String code) {
		CodedAttribute attribut = this.getByCode(code.trim());
		if (attribut != null) {
			return attribut.getValue();
		} else {
			return code;
		}
	}

}
