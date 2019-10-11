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

import java.io.IOException;
import java.io.Writer;

/**
 * TOTO
 * 
 * <p>
 * GENERATED CLASS
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class Utils {

	public static void writeAuthor(Writer aWriter) throws IOException {
		aWriter
		.write(" * @author <a href=\"mailto:straahd@users.sourceforge.net\">Laurent Lecomte \n");
	}

	public static void writeClassName(String aClassName, String aClassComments,
			Writer aWriter) throws IOException {
		aWriter.write("/**\n");
		aWriter.write(" * " + aClassComments + "\n");
		aWriter.write(" * \n");
		aWriter.write(" * <p>(generated class, do not edit)</p>\n");
		aWriter.write(" * \n");
		writeAuthor(aWriter);
		aWriter.write(" * \n");
		aWriter.write(" */ \n");
		aWriter.write("public class " + aClassName + " { \n");
		aWriter.write("\n");
		// aWriter.write(" * @author <a
		// href=\"mailto:straahd@users.sourceforge.net\">Laurent Lecomte \n");
	}

	public static void writeLicence(Writer aWriter) throws IOException {
		aWriter.write("/*\n");
		aWriter
		.write("* This library is free software; you can redistribute it and/or modify it\n");
		aWriter
		.write("* under the terms of the GNU Lesser General Public License as published\n");
		aWriter
		.write("* by the Free Software Foundation; either version 2 of the License, or\n");
		aWriter.write("* (at your option) any later version.  \n");
		aWriter.write("*\n");
		aWriter
		.write("* This library is distributed in the hope that it will be useful, but\n");
		aWriter
		.write("* WITHOUT ANY WARRANTY; without even the implied warranty of\n");
		aWriter
		.write("* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU\n");
		aWriter.write("* Lesser General Public License for more details.\n");
		aWriter.write("*\n");
		aWriter
		.write("* You should have received a copy of the GNU Lesser General Public\n");
		aWriter
		.write("* License along with this library; if not, write to the Free Software\n");
		aWriter
		.write("* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA\n");
		aWriter.write("*/\n");
		aWriter.write("// generated class, do not edit \n");
	}
}
