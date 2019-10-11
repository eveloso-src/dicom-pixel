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

package org.dicom4j.samples.io.media;

import java.util.Iterator;

import org.apache.log4j.PropertyConfigurator;
import org.dicom4j.core.Dicom4j;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.io.media.DicomFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Sample to read a DICOM File
 * 
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DcmFileDump {

	/**
	 * the Logger
	 */
	private static final Logger logger = LoggerFactory
	.getLogger(DcmFileDump.class);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure(".//log4j.properties");
		logger.info("start");
		Dicom4j.configure(); // we configure the framework
		if (args.length != 1) {
			System.out
			.println("usage: \"dcmFileDump {path} \" , where {path} is the complete filepath of a dicom file");
		} else {
			try {
				DicomFile ldcm = new DicomFile(args[0]); // we create the File
				ldcm.open(); // we open it (read the data)

				// we get an iterator to the elements
				Iterator<DataElement> iterator = ldcm.getDataset().getIterator();
				int i = 1;

				// We dump the File Meta Information
				logger.info("\n" + ldcm.getFileMetaInformation());

				// we parse all elements
				while (iterator.hasNext()) {
					// we get the current Element (DataElement is the base class for all
					// elements)
					DataElement lElement = iterator.next();
					logger.info("Item " + i);
					// we Dump the tag's content
					String tag = "Tag (Group: " + lElement.getTag().getGroupAsString()
					+ ", Element: " + lElement.getTag().getElementAsString()
					+ ", Name: " + lElement.getTag().getName() + ")";
					logger.info(tag);
					// We Dump the Element's content
					logger.info("Element (Class: " + lElement.getClass().getSimpleName()
							+ ", VR: " + lElement.getValueRepresentation().getName()
							+ ", VM: " + lElement.getValueMultiplicity() + ")");
					if (lElement.isAvailableAsString()) {
						// we get the values as String[]
						String[] ldata = lElement.getStringValues();
						for (int j = 0; j < ldata.length; j++) {
							logger.info(" Value " + new Integer(j + 1) + " = " + ldata[j]);
						}
					} else {
						logger.info(" Value can't be get a string");
					}
					i++;
					logger.info("");
				}
				ldcm.close(); // we close the File
				logger.info("stop");
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

}
