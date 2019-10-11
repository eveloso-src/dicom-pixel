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
package org.dicom4j.dicom.CodedAttributes.support;

import java.util.Iterator;

import org.dicom4j.core.registry.AbstractRegistry;
import org.dicom4j.core.registry.RegistryException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract registry for coded attributes
 * 
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractCodedAttributeRegistry extends AbstractRegistry {

	private static final Logger logger = LoggerFactory.getLogger(AbstractCodedAttributeRegistry.class);

	private static final long serialVersionUID = 1L;

	protected CodedAttributes attributes = new CodedAttributes();

	public AbstractCodedAttributeRegistry() {
		super();
	}

	/**
	 * add a new item
	 * <p>
	 * When adding, the item's type is check, if the registry's type doesn't math
	 * with the item's type a RegistryException will be thrown
	 * 
	 * @param item
	 *          the item to add
	 * @return the added item
	 * @throws RegistryException
	 */
	public CodedAttribute add(CodedAttribute item) throws RegistryException {
		if (item.getType().equals(this.getType())) {
			logger.debug("add: " + item);
			this.attributes.add(item);
			return item;

		} else {
			throw new RegistryException(item.getType() + " type is not valid for this " + this.getType() + " registry");
		}
	}

	@Override
	public int count() {
		return this.attributes.count();
	}

	/**
	 * get an {@link Iterator} to the coded attributes
	 * 
	 * @return the iterator
	 */
	public Iterator<CodedAttribute> getIterator() {
		return this.attributes.getIterator();
	}

	/**
	 * return the type of {@link CodedAttribute} this registry manage
	 * 
	 * @return the type
	 */
	public abstract CodedAttributeType getType();

	public String getValue(String code) {
		return this.attributes.getValue(code);
	}

}
