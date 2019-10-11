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

package org.dicom4j.core;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Manage loggers
 * 
 * @since 0.0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class Logging {

	/**
	 * the root logger's name
	 */
	public static final String ROOT_LOGGER = "org.dicom4j";
	
	/**
	 * the network logger's name
	 */
	public static final String NETWORK_LOGGER = ROOT_LOGGER + ".network";



	Logging() {
		super();
	}

	public Logger getRootLogger() {
		return LogManager.getLogger("org.dicom4j");
	}

	@Override
	public String toString() {
		return "Logging";
	}

}
