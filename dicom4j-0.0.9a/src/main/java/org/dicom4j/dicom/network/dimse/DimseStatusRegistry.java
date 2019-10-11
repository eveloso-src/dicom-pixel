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

package org.dicom4j.dicom.network.dimse;

import java.util.TreeMap;

import org.dicom4j.core.registry.AbstractRegistry;
import org.dicom4j.core.registry.RegistryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DimseStatusRegistry extends AbstractRegistry {

	private static final Logger logger = LoggerFactory
	.getLogger(DimseStatusRegistry.class);

	private static final long serialVersionUID = 1L;

	private TreeMap<Integer, DimseStatus> list = new TreeMap<Integer, DimseStatus>();

	public DimseStatusRegistry() {
		super();
		this.add(DimseStatus.Success);
		this.add(DimseStatus.Cancel);
	}

	public DimseStatus add(DimseStatus item) {
		logger.debug("add: " + item);
		this.list.put(Integer.valueOf(item.value()), item);
		return item;
	}

	public boolean contains(int value) {
		return this.list.containsKey(Integer.valueOf(value));
	}

	@Override
	public int count() {
		return this.list.size();
	}

	public DimseStatus get(int value) throws RegistryException {
		DimseStatus status = this.list.get(Integer.valueOf(value));
		if (status == null) {
			throw new RegistryException("Dimse Status with " + value
					+ "value can't be found");
		} else {
			return status;
		}
	}

	public String getName(int value) {
		try {
			return this.get(value).valueAsString();
		} catch (Exception ex) {
			logger.warn(ex.getMessage());
			return Integer.toString(value);
		}
	}

}
