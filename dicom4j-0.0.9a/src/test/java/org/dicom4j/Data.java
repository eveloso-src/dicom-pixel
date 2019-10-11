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

package org.dicom4j;

import org.dicom4j.data.DataElements;
import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;
import org.dicom4j.network.protocoldataunit.items.UserInformationItem;

/**
 * Static class to provides Configuration and test data
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public final class Data {

	// private static final Logger fLogger =
	// LoggerFactory.getLogger(TestData.class);

	public static final String ClassUID = "ClassUID";

	public static int defaultTestPort = 42246;

	public static final int MaximumLength = 123456;

	public static final String resourcesPath = "./src/test/resources/";

	public static final byte[] USER_INFORMATION_ITEM = { 0x50, 0x00, 0x1, 0x1,
		0x1 };

	public static final String VersionName = "VersionName";

	/*
	 * public static LightLocalDevice getLocalDevice() { LightLocalDevice lDevice
	 * = new LightLocalDevice(); return lDevice; }
	 * 
	 * public static LightRemoteDevice getModalityWorklistSCP() {
	 * LightRemoteDevice lDevice = new LightRemoteDevice();
	 * lDevice.setPort(10044); return lDevice; }
	 * 
	 * public static LightRemoteDevice getVerificationSCP() { LightRemoteDevice
	 * lDevice = new LightRemoteDevice(); lDevice.setPort(10044); return lDevice;
	 * }
	 * 
	 * public static LightRemoteDevice geStorageSCP() { LightRemoteDevice lDevice
	 * = new LightRemoteDevice(); lDevice.setPort(10044); return lDevice; }
	 */
	public static DataSet newCTDataSet() throws Exception {
		String lSopClass = SOPClass.CTImageStorage.getUID();
		DataSet lData = new DataSet();
		lData.addElement(DataElements.newSOPClassUID());
		lData.getUniqueIdentifier(DicomTags.SOPClassUID).setValue(lSopClass);

		lData.addElement(DataElements.newSOPInstanceUID());

		lData.addElement(DataElements.newStudyInstanceUID());
		lData.getUniqueIdentifier(DicomTags.StudyInstanceUID).setValue("1.1.1.1");

		lData.addElement(DataElements.newStudyID());
		lData.getShortString(DicomTags.StudyID).setValue("1.1.1.1");

		lData.addElement(DataElements.newSeriesInstanceUID());
		lData.getUniqueIdentifier(DicomTags.SeriesInstanceUID).setValue("1.1.1.1");
		lData.addElement(DataElements.newSeriesNumber());
		lData.getIntegerString(DicomTags.SeriesNumber).setValue("4");

		lData.addElement(DataElements.newInstanceNumber());
		lData.getIntegerString(DicomTags.InstanceNumber).setValue("4");

		lData.getUniqueIdentifier(DicomTags.SOPInstanceUID).setValue("1.1.1.1");

		lData.addElement(DataElements.newPatientID());
		lData.getLongString(DicomTags.PatientID).setValue("D");
		lData.addElement(DataElements.newPatientName());
		lData.getPersonName(DicomTags.PatientName).setValue("DON^JOHNSON");
		return lData;
	}

	public static PresentationContexRequestItem newPresentationContextItemRQ(
			byte id) throws Exception {
		PresentationContexRequestItem item = new PresentationContexRequestItem(id);
		item.setAbstractSyntax(SOPClass.Verification);
		item.addTransferSyntax(TransferSyntax.Default);
		return item;
	}

	public static UserInformationItem newUserInformationItem() throws Exception {
		UserInformationItem item = new UserInformationItem();
		item.setImplementationClassUID(ClassUID);
		item.setImplementationVersionName(VersionName);
		item.setMaximumLength(MaximumLength);
		item.setMaximumNumberOperationsInvoked(4);
		item.setMaximumNumberOperationsPerformed(4);
		return item;
	}

}
