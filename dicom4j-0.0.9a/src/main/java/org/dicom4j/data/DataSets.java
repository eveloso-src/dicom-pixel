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

package org.dicom4j.data;

import java.util.LinkedList;

/**
 * List of {@link DataSet DataSet}
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DataSets {

	protected LinkedList<DataSet> fList;

	public DataSets() {
		this.fList = new LinkedList<DataSet>();
	}

	/**
	 * Add an new {@link DataSet DataSet}
	 * 
	 * @param aDataSet
	 *          the {@link DataSet DataSet} do add
	 */
	public void addDataSet(DataSet aDataSet) {
		this.fList.add(aDataSet);
	}

	public void clear() {
		this.fList.clear();
	}

	/**
	 * Return the number of DataSet
	 * 
	 * @return number of DataSet
	 */
	public int count() {
		return this.fList.size();
	}

	public DataSet getDataSet(int aIndex) {
		return this.fList.get(aIndex);
	}

}
