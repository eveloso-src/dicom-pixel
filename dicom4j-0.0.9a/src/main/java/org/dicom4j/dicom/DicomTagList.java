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
package org.dicom4j.dicom;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * List of {@link DicomTag}
 * 
 * @since 0.0.7
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomTagList {

	private ArrayList<DicomTag> tags;

	public DicomTagList() {
		super();
		this.tags = new ArrayList<DicomTag>();
	}

	public boolean add(DicomTag o) {
		return this.tags.add(o);
	}

	public void add(int index, DicomTag element) {
		this.tags.add(index, element);
	}

	public boolean addAll(Collection<? extends DicomTag> c) {
		return this.tags.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends DicomTag> c) {
		return this.tags.addAll(index, c);
	}

	public void clear() {
		this.tags.clear();
	}

	public int count() {
		return this.tags.size();
	}

	public DicomTag get(int index) {
		return this.tags.get(index);
	}

	public int indexOf(Object elem) {
		return this.tags.indexOf(elem);
	}

	public boolean isEmpty() {
		return this.tags.isEmpty();
	}

	public Iterator<DicomTag> iterator() {
		return this.tags.iterator();
	}

	public DicomTag remove(int index) {
		return this.tags.remove(index);
	}

	public boolean remove(Object o) {
		return this.tags.remove(o);
	}

	public DicomTag set(int index, DicomTag element) {
		return this.tags.set(index, element);
	}

	public Object[] toArray() {
		return this.tags.toArray();
	}

}
