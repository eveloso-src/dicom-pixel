/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
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
import org.dicom4j.dicom.dictionary.DictionaryModule;
import org.dicom4j.dicom.dictionary.DictionaryTag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ModulesJavaFileGenerator {

	static Logger LOGGER = LoggerFactory
	.getLogger(ModulesJavaFileGenerator.class);

	private Writer fWriter;

	/**
	 * Creates a new module
	 * 
	 */
	public ModulesJavaFileGenerator() {
		super();
	}

	protected void append(String aString) throws Exception {
		this.fWriter.write(aString + "\n");
	}

	protected void appendBlankLine() throws Exception {
		this.append("");
	}

	/**
	 * Generate all Dicom Modules
	 * 
	 * @param aTags
	 * @param aModules
	 * @throws IOException
	 */
	public void generateModulesJavaFile(DicomDictionary lDico) throws Exception {
		LOGGER.info("Start");
		assert lDico != null;
		Iterator lModules = lDico.getModulesIterator();
		while (lModules.hasNext()) {

			DictionaryModule lElement = (DictionaryModule) lModules.next(); // (DictionaryModule)aModules.get(i);

			LOGGER.info(" generate module " + lElement.getKey());
			this.fWriter = new BufferedWriter(new FileWriter(ClassCreator.gConfig
					.getModulesLocation()
					+ "\\" + lElement.getType() + "\\" + lElement.getKey() + ".java"));
			Utils.writeLicence(this.fWriter);
			this.appendBlankLine();
			this.fWriter.write("package org.dicom4j.modules." + lElement.getType()
					+ ";\n");
			this.appendBlankLine();
			this.fWriter.write("import org.dicom4j.data.DataSet;\n");
			this.fWriter.write("import org.dicom4j.dicom.DicomTags;\n");
			this.fWriter.write("import org.dicom4j.data.DataElements;\n");
			this.fWriter.write("import org.dicom4j.data.elements.*;\n");
			this.fWriter.write("import org.dicom4j.data.NoSuchElementException;\n");
			this.fWriter
			.write("import org.dicom4j.data.WrongDataElementTypeException;\n");
			this.fWriter.write("import org.dicom4j.modules.Module;\n");
			this.appendBlankLine();
			Utils.writeClassName(lElement.getKey() + " extends Module ", lElement
					.getName()
					+ " Module ", this.fWriter);
			// appendBlankLine();

			// fWriter.write("public class "+lElement.getKey()+" extends Module {\n");
			// fWriter.write("\n");
			this.fWriter.write("     /**\n");
			this.fWriter.write("     * Creates a new module\n");
			this.fWriter.write("     *\n");
			this.fWriter.write("     */\n");
			this.fWriter.write("    public " + lElement.getKey() + "() {\n");
			// We add all DataElement of this module in the constructor
			Iterator<DictionaryTag> lIterator = lElement.getTags().iterator();
			while (lIterator.hasNext()) {
				DictionaryTag lTag = lIterator.next();
				assert lTag != null;
				DictionaryTag lRealTag = (DictionaryTag) lDico.getTag(lTag);
				if (lRealTag != null) {
					this.fWriter.write("        super.addElement( DataElements.new"
							+ lRealTag.getKey() + "() );\n");
				}
			}
			this.fWriter.write("    }\n");
			this.fWriter.write("\n");

			this.fWriter.write("     /**\n");
			this.fWriter
			.write("     * Creates a wrapper for data contains in the {@link DataSet DataSet} \n");
			this.fWriter.write("     *\n");
			this.fWriter
			.write("     * Modify data with an instance of this class will modify also data of the DataSet, IT'S NOT A COPY\n");
			this.fWriter.write("     *\n");
			this.fWriter.write("     * @param aDataSet\n");
			this.fWriter.write("     */\n");
			this.fWriter.write("    public " + lElement.getKey()
					+ "(DataSet aDataSet) {\n");
			this.fWriter.write("        super();\n");
			this.fWriter.write("        addDataSet(aDataSet);\n");
			this.fWriter.write("    }\n");

			this.fWriter.write("\n");

			this.appendBlankLine();
			// we add all addElements
			this.append("  /**");
			this.append("   * add all Module Elements if not present in the DataSet");
			this.append("   */");
			this.append("  public void addElements() throws Exception {");
			Iterator<DictionaryTag> lIterator2 = lElement.getTags().iterator();
			while (lIterator2.hasNext()) {
				DictionaryTag lTag = lIterator2.next();
				assert lTag != null;
				DictionaryTag lRealTag = (DictionaryTag) lDico.getTag(lTag);
				this.append("    if( !has" + lRealTag.getKey() + "() ) ");
				this.append("      addElement( DataElements.new" + lRealTag.getKey()
						+ "() );");
				if (lRealTag != null) {
				}
			}
			this.append("  }");

			// we add all hasXX
			this.appendBlankLine();
			Iterator<DictionaryTag> lIterator3 = lElement.getTags().iterator();
			while (lIterator3.hasNext()) {
				DictionaryTag lTag = lIterator3.next();
				assert lTag != null;
				DictionaryTag lRealTag = (DictionaryTag) lDico.getTag(lTag);
				if (lRealTag != null) {
					// String lDataClass =
					// ClassCreator.gConfig.getVRToClassName(lRealTag.getVR());
					this.append("  /**");
					this.append("   * return true if the module has the "
							+ lRealTag.getName() + " element ");
					this.append("   * @return true if present");
					this.append("   */");
					this.append("  public boolean has" + lRealTag.getKey() + "() {");
					this.append("    return hasElement(DicomTags." + lRealTag.getKey()
							+ ");");
					this.append("  }");
					this.appendBlankLine();
				} else {
					LOGGER.error(lTag + "not found");
				}
			}

			// we add all accessor
			this.appendBlankLine();
			Iterator<DictionaryTag> lIterator4 = lElement.getTags().iterator();
			while (lIterator4.hasNext()) {
				DictionaryTag lTag = lIterator4.next();
				assert lTag != null;
				DictionaryTag lRealTag = (DictionaryTag) lDico.getTag(lTag);
				if (lRealTag != null) {
					String lDataClass = ClassCreator.gConfig
					.getDataElementClassName(lRealTag.getVR());
					this.append("  /**");
					this.append("    * Retrun the " + lRealTag.getName());
					this.append("    * @return the " + lRealTag.getName());
					this.append("    * @throws NoSuchElementException");
					this.append("    * @throws WrongDataElementTypeException");
					this.append("    */");
					this
					.append("  public "
							+ lDataClass
							+ " get"
							+ lRealTag.getKey()
							+ "() throws NoSuchElementException, WrongDataElementTypeException {");
					this.append("    return get" + lDataClass + "(DicomTags."
							+ lRealTag.getKey() + ");");
					this.append("  }");
					this.appendBlankLine();

					this.append("  /**");
					this.append("    * Retrun the " + lRealTag.getName()
							+ " or null if doesn't exits");
					this.append("    * @return the " + lRealTag.getName() + " or null");
					this.append("    */");
					this.fWriter.write("    public " + lDataClass + " get"
							+ lRealTag.getKey() + "OrNull() {\n");
					this.fWriter.write("        return get" + lDataClass
							+ "OrNull(DicomTags." + lRealTag.getKey() + ");\n");
					this.fWriter.write("    }\n");
					this.appendBlankLine();
				} else {
					LOGGER.error(lTag + "not found");
				}
			}

			// we add getName method

			this.appendBlankLine();
			this.fWriter.write("  public String getName() {\n");
			this.fWriter.write("    return \"" + lElement.getName() + "\";\n");
			this.fWriter.write("  }\n");

			this.appendBlankLine();
			this.fWriter.write("}");
			this.fWriter.flush();
			LOGGER.info("End");
		}

	}
}
