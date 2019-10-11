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
import java.io.Writer;
import java.util.Iterator;

import org.dicom4j.dicom.dictionary.DicomDictionary;
import org.dicom4j.dicom.dictionary.DictionarySopClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * To generate SOPClass.java file
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class SOPClassGenerator extends BaseGenerator {

	static Logger fLogger = LoggerFactory.getLogger(SOPClassGenerator.class);

	public static void generateJavaFile(DicomDictionary aDico) throws Exception {
		SOPClassGenerator lGene = new SOPClassGenerator(aDico);
		lGene.generate();
	}

	private DicomDictionary fDico;

	public SOPClassGenerator(DicomDictionary aDico) throws Exception {
		super();
		this.fDico = aDico;
	}

	@Override
	protected Writer createWriter() throws Exception {
		return new BufferedWriter(new FileWriter(ClassCreator.gConfig
				.getSopClassFileName()));
	}

	public void generate() throws Exception {
		fLogger.info("Start");
		Utils.writeLicence(this.fWriter);
		this.appendBlankLine();
		this.append("package org.dicom4j.dicom.UniqueIdentifiers;\n");
		this.appendBlankLine();

		// append("import org.dicom4j.core.implementation.Dicom4jImplementation;");
		this
		.append("import org.dicom4j.dicom.UniqueIdentifiers.support.UniqueIdentifier;");

		this.fWriter.write("\n");
		Utils.writeClassName("SOPClass extends UniqueIdentifier",
				"a DICOM SOPClass", this.fWriter);
		// appendBlankLine();

		this.append("  /** ");
		this.append("  * creates new instance");
		this.append("  */ ");
		this.append("  public SOPClass(String aUID, String aName) {");
		this.append("  	super(UniqueIdentifierType.SOPCLASS, aUID, aName);");
		this.append("  } ");

		/*
		 * append(" public String toString() {"); append(" return \"SOPClass
		 * (dicom4j embedded)\"; "); append(" }");
		 */
		this.appendBlankLine();

		/*
		 * append(" /** "); append(" * get a SOP Class UID as a string "); append("
		 * *
		 * 
		 * @param aUID the SOP Class UID"); append(" * @return SOP Class as
		 * String"); append("
		 */// ");
		/*
		 * append(" public static String toString(String aUID) {"); append("
		 * SOPClasses lSOPs = Dicom4jImplementation.Instance().getSOPClasses();");
		 * append(" return lSOPs.getName(aUID);"); append(" } "); appendBlankLine();
		 */

		Iterator lIT = this.fDico.getSOPClassesIterator();
		// Writer lTest = new BufferedWriter(new FileWriter("c:\\test.xml"));
		while (lIT.hasNext()) {
			// create this kind of line for all SopClasses
			// public static final SOPClass EnhancedCTImageStorage = new
			// SOPClass("1.2.840.10008.5.1.4.1.1.2.1", "Enhanced CT Image Storage");
			DictionarySopClass lSOP = (DictionarySopClass) lIT.next();
			this.append("  /** ");
			this.append("  * " + lSOP.getName());
			this.append("  */ ");
			this.append("	public static final SOPClass " + lSOP.getKey()
					+ "=new SOPClass(\"" + lSOP.getUID() + "\", \"" + lSOP.getName()
					+ "\" ); ");
			this.appendBlankLine();

			// TEMP
			/*
			 * lTest.write("<bean
			 * class=\"org.dicom4jserver.server.DicomTransferCapability\">\n");
			 * lTest.write(" <property name=\"commonName\"
			 * value=\""+lSOP.getKey()+"\"></property><property name=\"acceptIT\"
			 * value=\"true\"></property>\n"); lTest.write(" <property
			 * name=\"sopClass\" value=\""+lSOP.getUID()+"\"></property><property
			 * name=\"role\" value=\"SCP\"></property><property
			 * name=\"serviceBeanID\" value=\"ImageCStoreSCP\"></property>\n");
			 * lTest.write("</bean>"); lTest.write("\n");
			 */

		}
		// lTest.flush();

		/*
		 * append(" protected void addUIDs() {"); Iterator lIT2 =
		 * fDico.getSOPClassesIterator();
		 * 
		 * while ( lIT2.hasNext() ) { DictionarySopClass
		 * lSOP2=(DictionarySopClass)lIT2.next(); append("
		 * addUID("+lSOP2.getKey()+"); "); } append(" }");
		 */
		this.appendBlankLine();

		this.fWriter.write("}");
		this.fWriter.flush();
		fLogger.info("End");
	}
}
