package laucher;

import java.io.IOException;
import java.util.Iterator;

import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.media.DicomFile;

public class DicomTest {

	public static void main(String[] args) throws IOException, DicomException, Exception {

		DicomFile ldcm = new DicomFile("C:\\Users\\Emiliano\\datos\\clases\\Cardiologico Angioplasti ITOIZ\\DICOMDIR"); // we create the File
		ldcm.open(); // we open it (read the data)

		// we get an iterator to the elements
		Iterator iterator = ldcm.getDataset().getIterator();
		int i = 1;

		// We dump the File Meta Information
//		logger.info("\n" + ldcm.getFileMetaInformation());

		// we parse all elements
		while (iterator.hasNext()) {
			// we get the current Element (DataElement is the base class for all elements)
			DataElement lElement = (DataElement) iterator.next();
//			logger.info("Item " + i);
			// we Dump the tag's content
			String tag = "Tag (Group: " + lElement.getTag().getGroupAsString() + ", Element: "
					+ lElement.getTag().getElementAsString() + ", Name: " + lElement.getTag().getName() + ")";
//			logger.info(tag);
			// We Dump the Element's content
//			logger.info("Element (Class: " + lElement.getClass().getSimpleName() + ", VR: " + lElement.getValueRepresentation().getName() + ", VM: " +
//			 lElement.getValueMultiplicity() + ")");
			if (lElement.isAvailableAsString()) {
				// we get the values as String[]
				String[] ldata = lElement.getStringValues();
				for (int j = 0; j < ldata.length; j++) {
//					logger.info(" Value " + new Integer(j + 1) + " = " + ldata[j]);
				}
			} else {
//				logger.info(" Value can't be get a string");
			}
			i++;
		}
	}
}