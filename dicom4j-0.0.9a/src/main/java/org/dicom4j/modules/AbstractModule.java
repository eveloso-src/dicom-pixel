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

package org.dicom4j.modules;

import org.dicom4j.data.DataSet;

/**
 * Abstract module
 * 
 * @since 0.0.3
 * @since 5 march 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractModule extends DataSet implements Module {

	/**
	 * Creates a new module
	 * 
	 */
	public AbstractModule() {
	}

	/**
	 * add all module's element. Added elements depend of the module
	 */
	public void addModuleElements() {

	}

	/**
	 * Return the name of the module
	 * 
	 * @return the name
	 */
	public abstract String getName();
}
