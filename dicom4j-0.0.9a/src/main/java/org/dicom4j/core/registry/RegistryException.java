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

package org.dicom4j.core.registry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Registry Exception
 * 
 * @since 0.0.8
 * @since 30 sept. 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class RegistryException extends Exception {

	private static final Logger logger = LoggerFactory
	.getLogger(RegistryException.class);

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public RegistryException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public RegistryException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RegistryException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public RegistryException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
