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

import org.dicom4j.classcreator.support.BaseClassGenerator;
import org.dicom4j.dicom.dictionary.item.SopClassDictionaryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SopClassRegistryGenerator extends BaseClassGenerator {

	private static final Logger logger = LoggerFactory
	.getLogger(SopClassRegistryGenerator.class);

	private static final long serialVersionUID = 1L;

	public SopClassRegistryGenerator() throws Exception {
		super();
	}

	@Override
	protected Writer createWriter() throws Exception {
		return new BufferedWriter(
				new FileWriter(
						"./src/main/java/org/dicom4j/dicom/uniqueidentifiers/SOPClassRegistry.java"));
	}

	@Override
	public void generate() throws Exception {
		logger.info("generate");
		super.generate();
		this.append("import org.dicom4j.core.RegistryException;");
		this
		.append("import org.dicom4j.dicom.uniqueidentifiers.support.AbstractUniqueIdentifierRegistry;");
		this.append("import org.slf4j.Logger;");
		this.append("import org.slf4j.LoggerFactory;");
		this.appendBlankLine();
		this.append("/** ");
		this.append(" * <p>Registry of SOPClass");
		this.append(" * ");
		this.append(" * <p>(generated class, do not edit)");
		this.append(" */");
		this
		.append("public class SOPClassRegistry extends AbstractUniqueIdentifierRegistry {");
		this.appendBlankLine();
		this.append("  private static final long serialVersionUID = 1L;");
		this.appendBlankLine();
		this
		.append("  private static final Logger logger = LoggerFactory.getLogger(SOPClassRegistry.class);");
		this.appendBlankLine();
		this.append("  public SOPClassRegistry() {");
		this.append("	  super();");
		this.append("  }");
		this.appendBlankLine();
		this.append("  @Override");
		this.append("  public UniqueIdentifierType getType() {");
		this.append("	  return UniqueIdentifierType.SOPCLASS;");
		this.append("  }");
		this.appendBlankLine();
		this.append("  @Override");
		this.append("  public String toString() {");
		this.append("	  return \"dicom4j SOPClassRegistry\";");
		this.append("  }");
		this.appendBlankLine();
		this
		.append("  public SOPClass getSopClass(String uid) throws RegistryException {");
		this.append("	  if ( uid.equals(\"\")) ");
		this
		.append("		  throw new RegistryException(\"Registry can provide a SopClas: no UID was supplied\"); ");
		this.append("	  logger.debug(\"getSopClass, UID: \" + uid ); ");
		this.append("	  SOPClass result=null;");
		Iterator<SopClassDictionaryItem> items = this.getDicomDictionary()
		.getSOPClassesIterator();
		while (items.hasNext()) {
			SopClassDictionaryItem item = items.next();
			this.append("    if ( uid.equals( SOPClass." + item.getKey()
					+ ".getUID() ) )");
			this.append("      result = SOPClass." + item.getKey() + "; ");
		}
		this.append("	  if ( result == null) {");
		this
		.append("	  	logger.warn(\"Unable to get a SOPClass for \" + uid + \" UID\"); ");
		this
		.append("	    throw new RegistryException(\"Unable to provide a SOPClass for \" + uid + \" UID\"); ");
		this.append("	  } else { ");
		this
		.append("	    logger.debug(\"SOPClass \" + result.getName() + \" returned\"); ");
		this.append("	    return result; ");
		this.append("	  } ");
		this.append("	} ");
		this.appendBlankLine();
		this.append("  /**");
		this.append("   * return the SopClass's name from a SOPClass UID ");
		this.append("   * @param uid the uid");
		this
		.append("   * @return the name or uid if the sopclass is non contains in the registry");
		this.append("   */");
		this.append("  public String getSopClassAsString(String uid) {");
		this.append("    try {");
		this.append("      SOPClass sopClass = getSopClass(uid); ");
		this.append("      return sopClass.getName();");
		this.append("    } catch (Exception ex) { ");
		this.append("	    return uid; ");
		this.append("    }");
		this.append("  }");

		this.fWriter.write("}");
		this.fWriter.flush();
		logger.info("End");
	}

	@Override
	public String getClassName() {
		return "SOPClassRegistry extends AbstractUniqueIdentifierRegistry";
	}

	@Override
	public String getPackage() {
		return "org.dicom4j.dicom.uniqueidentifiers";
	}

}
