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
package org.dicom4j.io;

import org.dicom4j.AbstractTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestDicomDirectoryReader extends AbstractTestCase {

	/**
	 * the Logger
	 */
	private static final Logger flogger = LoggerFactory
	.getLogger(TestDicomDirectoryReader.class);

	public TestDicomDirectoryReader() {
		super("TestDicomDir");
	}

	public void testDumpDicomDir() throws Exception {
		/*
		 * DicomDirectoryReader lDir = new DicomDirectoryReader( Data.resourcesPath
		 * + "/dicomdir1"); lDir.open();
		 * flogger.info(lDir.getDicomDirectory().getRoot().getClass().getName());
		 * flogger.info(lDir.getDicomDirectory().getRoot().toString());
		 * DicomDirectory lDicomdir = lDir.getDicomDirectory(); DicomDirectoryItem
		 * lItem = lDicomdir.getRoot(); while (lItem.getChildCount() != 0) { lItem =
		 * lDicomdir.getChild(lItem, 0); flogger.info(lItem.getClass().getName());
		 * flogger.info(lItem.toString()); }
		 */
	}
}
