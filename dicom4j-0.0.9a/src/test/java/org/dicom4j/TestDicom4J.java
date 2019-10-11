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

package org.dicom4j;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.dicom4j.core.Dicom4j;

/**
 * provides static methods for Unit testing
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestDicom4J {

	private static boolean isStarted = false;

	public static final String outputLocation = "./testOut/";

	public static String getOutputlocation() {
		return outputLocation;
	}

	public static String getResourcesLocation() {
		return "./src/test/resources/";
	}

	public static void start() {
		if (isStarted == false) {
			PropertyConfigurator.configure("./src/test/resources/log4j.properties");
			try {
				FileUtils.forceMkdir(new File(outputLocation));
			} catch (Exception e) {
				e.printStackTrace();
			}
			isStarted = true;
		}
	}

}
