package laucher;

import java.io.IOException;
import java.util.Iterator;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.SequenceItems;
import org.dicom4j.data.elements.SequenceOfItems;
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

		DataSet data = ldcm.getDataset();
		Object[] array = data.toArray();
		SequenceOfItems soi = (SequenceOfItems ) array[6];
		Iterator<SequenceItems> items = soi.iterator();
		SequenceItems seq;
		while (items.hasNext()) {
			seq = items.next();
			DataSet ds = seq.getDataSet();
			Iterator<DataElement> it = ds.getIterator();
			while (it.hasNext()) {
				DataElement dElem = it.next();
				if (dElem.getTag().getName().equals("Patient's Name")) {
					System.out.println("nombre ");
					String valor = dElem.getTag().getName().toString();
					System.out.println("nombre: " + dElem.getDelimitedStringValues());
				}
				System.out.println(dElem.getTag().toString() + " // " + dElem.toString());
				
			}
		}
		// We dump the File Meta Information
//		System.out.println("\n" + ldcm.getFileMetaInformation());


	}
}