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
package org.dicom4j.core;

/**
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public final class Dicom4j {

	/**
	 * the Class UID
	 */
	public static final String CLASS_UID = "1.2.826.0.1.3680043.2.1641";

	/**
	 * the default Maximum PDU Size for network communications
	 */
	// public static final int MAXIMUM_PDU_SIZE = 65000;

	/**
	 * the Project's name
	 */
	public final static String PROJECT_NAME = "dicom4j";

	/**
	 * the Version
	 */
	public final static String VERSION = "0.0.9";

	/**
	 * the Version Name
	 */
	public static final String VERSION_NAME = "dicom4j";

	/**
	 * project web site URL
	 */
	public final static String WEBSITE_ADRESS = "http://dicom4j.sourceforge.net";

	/**
	 * check that the framework is well configured and ready to work
	 * 
	 * @throws Exception
	 *           if check fail
	 * 
	 * @since 0.0.4
	 */
	@Deprecated
	public static synchronized void check() throws Exception {
		// TODO
	}

	/**
	 * configure the framework with default values
	 * 
	 * @throws Exception
	 *           if erros occurs
	 * 
	 * @since 0.0.4
	 */
	@Deprecated
	public static synchronized void configure() throws Exception {
	}

}
