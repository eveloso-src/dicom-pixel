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

package org.dicom4j.io;

import java.io.File;

import junit.framework.TestCase;

import org.dicom4j.TestDicom4J;
import org.dicom4j.data.DataSet;
import org.dicom4j.data.FileMetaInformation;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.io.file.DicomFileReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestDicomFileReader extends TestCase {

	private final static Logger logger = LoggerFactory.getLogger(TestDicomFileReader.class);

	private static File locateFile(String name) {
		return new File("./src/test/resources/" + name);
	}

	public TestDicomFileReader(String name) {
		super(name);
		TestDicom4J.start();
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	/*
	 * public final void testChest01_Prefix_but_no_FMI() throws IOException,
	 * DicomException { DicomFileReader lReader = new DicomFileReader(new
	 * File("E:\\Chest01 (Prefix but no FMI).dcm")); DataSet lData = new
	 * DataSet(); FileMetaInformation lFMI = new FileMetaInformation();
	 * lReader.readFile(lFMI, lData); assertEquals(33, lData.count()); }
	 */

	/*
	 * public final void testGeneric() {
	 * //PropertyConfigurator.configure("dicom4j-log4j.properties"); File lFile =
	 * new File(".\\src\\test\\resources\\"); File[] lFileList =
	 * lFile.listFiles();
	 * 
	 * for (int i=0; i < lFileList.length; i++ ) { try {
	 * fLogger.info(lFileList[i].toString()); DicomFileReader lReader = new
	 * DicomFileReader(lFileList[i]); DataSet lData = new DataSet();
	 * FileMetaInformation lFMI = new FileMetaInformation();
	 * lReader.readFile(lFMI, lData); fLogger.info(""); } catch (Exception e) {
	 * fLogger.error(e.getMessage()); } } }
	 */

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testReadExplicitVRLE() throws Exception {
		DicomFileReader lReader = new DicomFileReader(locateFile("dicomdir1"));
		DataSet lData = new DataSet();
		FileMetaInformation lFMI = new FileMetaInformation();
		lReader.readFile(lFMI, lData);
		SequenceOfItems lSEQ = (SequenceOfItems) lData
		.getElement(DicomTags.DirectoryRecordSeq);
		assertNotNull(lSEQ);
		assertEquals(1203, lSEQ.count());
	}

	public final void testReadImplicitVRLE() throws Exception {
		DicomFileReader lReader = new DicomFileReader(locateFile("view400.dcm"));
		DataSet lData = new DataSet();
		FileMetaInformation lFMI = new FileMetaInformation();
		lReader.readFile(lFMI, lData);
		assertEquals(5, lFMI.count());
		assertEquals(37, lData.count());
		// DicomElement attr = attrs.get(0x00041220);
		// assertEquals(1203, attr.countItems());
	}

	public final void testReadRawImplicitVRLE() throws Exception {
		DicomFileReader lReader = new DicomFileReader(locateFile("OT-PAL-8-face"));
		DataSet lData = new DataSet();
		FileMetaInformation lFMI = new FileMetaInformation();
		lReader.readFile(lFMI, lData);
		assertEquals(33, lData.count());
	}

}
