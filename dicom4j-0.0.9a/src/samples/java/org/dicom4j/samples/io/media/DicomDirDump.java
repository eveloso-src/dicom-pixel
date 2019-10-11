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
package org.dicom4j.samples.io.media;

import org.apache.log4j.PropertyConfigurator;
import org.dicom4j.core.Dicom4j;
import org.dicom4j.io.directory.DicomDirectory;
import org.dicom4j.io.directory.DicomDirectoryItem;
import org.dicom4j.io.media.DicomDir;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * sample class to Dump a DicomDir into a log file
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomDirDump {

	/**
	 * the Logger
	 */
	private static final Logger flogger = LoggerFactory
	.getLogger(DicomDirDump.class);

	/**
	 * dump One Item
	 * 
	 * @param aItem
	 * @throws Exception
	 */
	public static void DumpItem(DicomDirectoryItem aItem) throws Exception {
		// flogger.info(aItem.toString());
		for (int i = 0; i < aItem.getChildCount(); i++) {
			DicomDirectoryItem lChild = (DicomDirectoryItem) aItem.getChildAt(i);
			flogger.info(lChild.toString());
			DumpItem(lChild);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PropertyConfigurator.configure(".//samples-log4j.properties");
		flogger.info("DicomDirDump.start");
		try {
			Dicom4j.configure(); // we configure the framework
			DicomDir lDir = new DicomDir(".//DICOMDIR"); // we create the
			// DicomDir instance
			// to read the file
			// (work as the same
			// as a File)
			lDir.open(); // we open the DicomDir
			DicomDirectory lDicomdir = lDir.getDicomDirectory(); // we get the
			// DicomDirectory
			// Object (which
			// contains data)
			DicomDirectoryItem lItem = lDicomdir.getRoot();
			DumpItem(lItem);
			flogger.info("DicomDirDump.stop");
		} catch (Exception e) {
			flogger.error(e.getMessage());
		}
	}

}
