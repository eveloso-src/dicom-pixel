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

public class EmbbededDicomDictionayGenerator {

	static Logger lLogger = LoggerFactory
	.getLogger(EmbbededDicomDictionayGenerator.class);

	public EmbbededDicomDictionayGenerator() {
		super();
	}

	public void generate(DicomDictionary lDico) throws IOException {
		lLogger.info("generate");

		// lLogger.info(" generate module " + lElement.getKey());
		Writer fWriter = new BufferedWriter(new FileWriter(ClassCreator.gConfig
				.getEmebbedDicomDictionaryLocation()));
		Utils.writeLicence(fWriter);
		fWriter.write("\n");
		fWriter.write("package org.dicom4j.dicom.dictionary;\n");
		fWriter.write("\n");
		fWriter.write("import org.dicom4j.dicom.DicomTags;\n");
		fWriter.write("\n");
		fWriter.write("/**\n");
		fWriter.write(" * EmbbedDicomDictionary \n");
		fWriter.write(" * \n");
		Utils.writeAuthor(fWriter);
		fWriter.write(" * \n");
		fWriter.write(" */\n");
		fWriter
		.write("public class EmbbedDicomDictionary extends AbstractDictionary implements DicomDictionary {\n");
		fWriter.write("\n");
		fWriter.write("     /**\n");
		fWriter.write("     * Creates a new EmbbedDicomDictionary\n");
		fWriter.write("     *\n");
		fWriter.write("     */\n");
		fWriter.write("    public EmbbedDicomDictionary() {\n");
		fWriter.write("        super();\n");
		Iterator lIterator = lDico.getTagIterator();
		while (lIterator.hasNext()) {
			DictionaryTag lTag = (DictionaryTag) lIterator.next();
			fWriter.write("        addTag( DicomTags." + lTag.getKey() + " );\n");

			// fWriter.write(" addTag( new
			// DicomTag("+lTag.getGroupAsString()+","+lTag.getElementAsString() +",
			// \"" + lTag.getName()+"\") );\n");
		}

		fWriter.write("    }\n");

		fWriter.write("}\n");
		fWriter.flush();

	}
}
