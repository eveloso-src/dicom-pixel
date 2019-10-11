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

import org.apache.log4j.BasicConfigurator;
import org.dicom4j.dicom.dictionary.DicomDictionary;
import org.dicom4j.dicom.dictionary.DictionaryTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Create Java source code from the XML Dicom Dictionary
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ClassCreator {

	public static Configuration gConfig;

	public static Logger lLogger = LoggerFactory.getLogger(ClassCreator.class);

	public static void main(String[] args) {
		try {
			BasicConfigurator.configure();
			gConfig = new Configuration();
			ClassCreator lCreator = new ClassCreator(gConfig);

			// DicomDictionary dicomDictionary = new
			// XMLDictionary("./dictionary.xml");

			/*
			 * SopClassRegistryGenerator sopClassRegistryGenerator = new
			 * SopClassRegistryGenerator();
			 * sopClassRegistryGenerator.setDicomDictionary( dicomDictionary );
			 * sopClassRegistryGenerator.generate();
			 */
			/*
			 * System.out.println("OK"); DicomTag lTag = new DicomTag(0x0012, 0x0042);
			 * System.out.println(lTag); String lTagName = lDico.getTagName(lTag);
			 * System.out.println(lTagName);
			 */

			// ModulesJavaFileGenerator lModules = new ModulesJavaFileGenerator();
			// lModules.generateModulesJavaFile(fTags, lReader.getModules());
		} catch (Exception e) {
			lLogger.error("ERROR : " + e.getMessage());
		}

	}

	private Configuration fConfiguration;

	private EmbbededDicomDictionayGenerator fEmbbededDicomDictionayGenerator;

	private ModulesJavaFileGenerator fModuleGenerator;

	public ClassCreator(Configuration aConfiguration) {
		super();
		this.fConfiguration = aConfiguration;
		this.fModuleGenerator = new ModulesJavaFileGenerator();
		this.fEmbbededDicomDictionayGenerator = new EmbbededDicomDictionayGenerator();
	}

	/**
	 * Generate the source which contain all types DataElement
	 * 
	 * @param aTags
	 * @throws IOException
	 */
	public void generateDataElementsJavaFile(DicomDictionary aDico)
	throws IOException {
		DataElementsJavaFileGenerator.generateDataElementsJavaFile(aDico);
		/*
		 * lLogger.info("generateDataElementsJavaFile"); Writer lWriter = new
		 * BufferedWriter(new FileWriter(fConfiguration.getDataElementsFileName()));
		 * Utils.writeLicence(lWriter); lWriter.write("\n"); lWriter.write("package
		 * org.dicom4j.data;\n"); lWriter.write("\n"); lWriter.write("import
		 * org.dicom4j.dicom.DicomTags;\n"); lWriter.write("import
		 * org.dicom4j.data.elements.*;\n"); lWriter.write("\n");
		 * Utils.writeClassName("DataElements", "List of all DataElements",
		 * lWriter); //lWriter.write("public class DataElements {\n");
		 * lWriter.write("\n"); Iterator lIterator = aDico.getTagIterator(); while
		 * (lIterator.hasNext() ) { DictionaryTag lTag =
		 * (DictionaryTag)lIterator.next(); assert lTag != null; String
		 * lDataClassName = fConfiguration.getVRToClassName(lTag.getVR()); if
		 * (lDataClassName != "") { lWriter.write(" public static " + lDataClassName
		 * + " new" + lTag.getKey() + "() { "); lWriter.write(" return new " +
		 * lDataClassName+"(DicomTags."+lTag.getKey()+"); }"); lWriter.write("\n");
		 * } } lWriter.write("\n"); lWriter.write("}"); lWriter.flush();
		 */
	}

	public void generateEmbbededDicomDictionayJavaFile(DicomDictionary lDico)
	throws IOException {
		this.fEmbbededDicomDictionayGenerator.generate(lDico);
	}

	public void generateModulesJavaFile(DicomDictionary lDico) throws Exception {
		this.fModuleGenerator.generateModulesJavaFile(lDico);
	}

	/**
	 * Generate the source which contain all TAGs
	 * 
	 * @param aTags
	 *          the list of Tags
	 */
	public void generateTagsJavaFile(DicomDictionary aDico) throws IOException {
		lLogger.info("generateTagsJavaFile");
		Writer lWriter = new BufferedWriter(new FileWriter(this.fConfiguration
				.getTagsJavaFileName()));
		Utils.writeLicence(lWriter);
		lWriter.write("\n");
		lWriter.write("package org.dicom4j.dicom;\n");
		lWriter.write("\n");
		lWriter.write("import org.dicom4j.dicom.ValueRepresentation;\n");
		lWriter.write("\n");
		lWriter.write("public class DicomTags {\n");
		lWriter.write("\n");
		Iterator<DictionaryTag> lIterator = aDico.getTagIterator();
		while (lIterator.hasNext()) {
			DictionaryTag lTag = lIterator.next();
			assert lTag != null;
			String lVR = this.fConfiguration.getVRClassName(lTag.getVR());

			lWriter.write("    public static final "
					+ this.fConfiguration.getDataElementTagClassName() + " "
					+ lTag.getKey() + " = new "
					+ this.fConfiguration.getDataElementTagClassName() + "("
					+ lTag.getGroupAsString() + "," + lTag.getElementAsString() + ", \""
					+ lTag.getName() + "\", ValueRepresentation." + lVR + ");\n");
		}
		lWriter.write("\n");
		lWriter.write("}");
		lWriter.flush();
	}
}
