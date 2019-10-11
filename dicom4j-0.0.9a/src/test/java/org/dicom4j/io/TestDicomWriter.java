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

import java.io.ByteArrayOutputStream;

import org.dicom4j.AbstractTestCase;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.LongString;

/**
 * {@linkplain DicomWriter test case}
 * 
 * @since 0.0.5
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestDicomWriter extends AbstractTestCase {

	/**
	 * 
	 */
	public TestDicomWriter() {
		super("TestDicomWriter");
	}

	private DicomWriter newWriter() {
		ByteArrayOutputStream lStream = new ByteArrayOutputStream();
		DicomWriter lWriter = new DicomWriter(lStream);
		return lWriter;
	}

	/**
	 * test writing LO into streams
	 * 
	 * @throws Exception
	 */
	public void testWriteLO() throws Exception {
		DicomWriter lWriter = this.newWriter();

		DataSet lData = new DataSet();
		LongString lLO1 = DataElements.newInstitutionName();
		// TODO SHLOUD work
		lLO1
		.addValue("FFFFFFFFFFFFFFFGDSFGGDGGEZGEBDFSGMLKJHGFDSQPOIUYTREZADFGHJKLMLKJHGFDSZERMLKJHGFD//FGDFGEGGGSRGERGERGERGEGGDGDFGDFGGFGDSDFGERGERGEGGEGEGERGERGEGERGRGERGERGMLKJHGFDSMLKJHGFDSMKJHGFDSPOIUYTREZMLKJHGFDSPOIUYTREENDEND");
		// lLO1.addValue("d/t");

		// LongString lLO2 = DataElements.newInstitutionName();
		// lLO2.addValue("d1234\r");
		lData.addElement(lLO1);
		// lData.addElement( lLO2 );
		lWriter.write(lData);

	}
}
