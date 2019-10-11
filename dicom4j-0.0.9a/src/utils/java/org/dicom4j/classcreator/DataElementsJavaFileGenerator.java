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

package org.dicom4j.classcreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;

import org.dicom4j.dicom.dictionary.DicomDictionary;
import org.dicom4j.dicom.dictionary.DictionaryTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataElementsJavaFileGenerator {

	static Logger fLogger = LoggerFactory
	.getLogger(DataElementsJavaFileGenerator.class);

	/**
	 * Generate the source which contain all types DataElement
	 * 
	 * @param aTags
	 * @throws IOException
	 */
	public static void generateDataElementsJavaFile(DicomDictionary aDico)
	throws IOException {
		fLogger.info("Start");
		Writer lWriter = new BufferedWriter(new FileWriter(ClassCreator.gConfig
				.getDataElementsFileName()));
		Utils.writeLicence(lWriter);
		lWriter.write("\n");
		lWriter.write("package org.dicom4j.data;\n");
		lWriter.write("\n");
		lWriter.write("import org.dicom4j.dicom.DicomTags;\n");
		lWriter.write("import org.dicom4j.data.elements.*;\n");
		lWriter.write("\n");
		Utils.writeClassName("DataElements", "List of all DataElements", lWriter);
		// lWriter.write("public class DataElements {\n");
		lWriter.write("\n");
		Iterator lIterator = aDico.getTagIterator();
		while (lIterator.hasNext()) {
			DictionaryTag lTag = (DictionaryTag) lIterator.next();
			assert lTag != null;
			String lDataClassName = ClassCreator.gConfig.getDataElementClassName(lTag
					.getVR());
			if (lDataClassName != "") {
				lWriter.write("    public static " + lDataClassName + " new"
						+ lTag.getKey() + "() { ");
				lWriter.write(" return new " + lDataClassName + "(DicomTags."
						+ lTag.getKey() + "); }");
				lWriter.write("\n");
			}
		}
		lWriter.write("\n");
		lWriter.write("}");
		lWriter.flush();
		fLogger.info("End");
	}
}
