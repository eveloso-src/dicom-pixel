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

package org.dicom4j.io.media;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.dicom4j.AbstractTestCase;
import org.dicom4j.core.registry.NotFoundRegistryException;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.PersonName;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.implementation.Dicom4jImplementation;
import org.dicom4j.dicom.implementation.DicomImplementation;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * test case for {@link DicomFile}
 * 
 * @since 0.0.7
 * @since 17 January 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestDicomFile extends AbstractTestCase {

	private static final String FilePath = "./test.dcm";

	private static final Logger logger = LoggerFactory
	.getLogger(TestDicomFile.class);

	private static final long serialVersionUID = 1L;

	private String patientName = "JOHN^DOE";

	protected DicomFile getFile() {
		return new DicomFile(FilePath);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		if (new File(FilePath).exists()) {
			new File(FilePath).delete();
		}
		assertFalse(new File(FilePath).exists());
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		new File(FilePath).delete();
		assertFalse(new File(FilePath).exists());
	}

	public void testCanFoundTansferSyntax() throws Exception {
		DicomFile file = this.getFile();
		file.getFileMetaInformation().setTransferSyntaxUID("fakeTransferSyntaxUID");
		try {
			file.save();
			fail("Exception should have been raised");
		} catch (NotFoundRegistryException lE) {
			assertEquals(NotFoundRegistryException.class.getName(), lE.getClass()
					.getName());
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}

	public void testSaveAs() throws Exception {

	}

	public void testSaveWithFMI() throws Exception {
		logger.info("testSaveWithFMI");
		DicomFile file = this.getFile();
		file.getFileMetaInformation().addElementsAndPreambule();
		DicomImplementation implementation = new Dicom4jImplementation();
		file.getFileMetaInformation().setTransferSyntaxUID(
				TransferSyntax.Default.getUID());
		file.getFileMetaInformation().setImplementationClassUID(
				implementation.getImplementationClassUID().getSingleStringValue());
		file.getFileMetaInformation().setImplementationVersionName(
				implementation.getImplementationVersionName().getSingleStringValue());
		file.getDataset().addPersonName(DataElements.newPatientName(), this.patientName);
		file.save();
		file.close();

		DicomFile fileForCheck = this.getFile();
		fileForCheck.open();
		assertEquals(8, fileForCheck.getFileMetaInformation().count());
		assertEquals(TransferSyntax.Default.getUID(), fileForCheck
				.getFileMetaInformation().getTransferSyntaxUID());
		assertEquals(implementation.getImplementationClassUID()
				.getSingleStringValue(), fileForCheck.getFileMetaInformation()
				.getImplementationClassUID());
		assertEquals(this.patientName, fileForCheck.getDataset().getPersonName(
				DicomTags.PatientName).getSingleStringValue());
	}

	public void testSaveWithNewFilePath() throws Exception {
		String newpath = "./copy.dcm";
		try {
			DicomFile file = this.getFile();
			file.getDataset().addPersonName(DataElements.newPatientName(),
					this.patientName);
			file.save();
			file.getDataset().addPersonName(
					DataElements.newPhysicianApprovingInterpretation(), "PERSON");
			file.save(newpath, TransferSyntax.Default, false);

			file = this.getFile();
			DicomFile newFile = new DicomFile(newpath);
			assertTrue(file.exists());
			assertTrue(newFile.exists());
			file.open();
			newFile.open();
			assertEquals(1, file.getDataset().count());
			assertEquals(2, newFile.getDataset().count());

			file.delete();
			newFile.delete();
			assertFalse(file.exists());
			assertFalse(newFile.exists());

		} catch (Exception ex) {
			assertTrue(FileUtils.deleteQuietly(new File(newpath)));
			throw ex;
		}
	}

	public void testSaveWithNoFMI() throws Exception {
		logger.info("testSaveWithNoFMI");
		DicomFile file = this.getFile();
		PersonName patientName = DataElements.newPatientName();
		patientName.setValue("JOHN^DOE");
		file.getDataset().addElement(patientName);
		file.save();
		file.close();
		assertTrue(file.exists());
		DicomFile file2 = this.getFile();
		file2.open();
		assertTrue(file2.getDataset().hasElement(DicomTags.PatientName));
	}

}
