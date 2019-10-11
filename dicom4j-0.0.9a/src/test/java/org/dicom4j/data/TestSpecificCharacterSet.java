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

package org.dicom4j.data;

import java.io.FileOutputStream;
import java.nio.ByteOrder;

import org.dicom4j.AbstractTestCase;
import org.dicom4j.TestDicom4J;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.io.BinaryOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestSpecificCharacterSet extends AbstractTestCase {

	private final static Logger logger = LoggerFactory
	.getLogger(TestSpecificCharacterSet.class);

	static private void createDicomFileWithPatientName(String fileName,
			byte[] example, String specificCharacterSet) {
		try {
			BinaryOutputStream o = new BinaryOutputStream(new FileOutputStream(
					fileName), ByteOrder.LITTLE_ENDIAN);
			{
				DicomTag tag = DicomTags.SpecificCharacterSet;
				o.writeUnsigned16(tag.getGroup());
				o.writeUnsigned16(tag.getElement());
			}
			o.write((byte) 'C');
			o.write((byte) 'S');
			byte[] scs = specificCharacterSet.getBytes("ASCII");
			int length = scs.length;
			boolean pad = false;
			if (length % 2 != 0) {
				++length;
				pad = true;
			}
			o.writeUnsigned16(length);
			o.write(scs);
			if (pad) {
				o.write((byte) ' ');
			}
			{
				DicomTag tag = DicomTags.PatientName;
				o.writeUnsigned16(tag.getGroup());
				o.writeUnsigned16(tag.getElement());
			}
			o.write((byte) 'P');
			o.write((byte) 'N');
			length = example.length;
			pad = false;
			if (length % 2 != 0) {
				++length;
				pad = true;
			}
			o.writeUnsigned16(length);
			o.write(example);
			if (pad) {
				o.write((byte) ' ');
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}

	public TestSpecificCharacterSet() {
		super("TestSpecificCharacterSet");
	}

	public void testCreateDicomWithDifferentCharset() throws Exception {
		logger.info("testCreateDicomWithDifferentCharset");
		String prefixPath = TestDicom4J.getOutputlocation();

		byte[] h31example = { (byte) 0x59, (byte) 0x61, (byte) 0x6d, (byte) 0x61,
				(byte) 0x64, (byte) 0x61, (byte) 0x5e, (byte) 0x54, (byte) 0x61,
				(byte) 0x72, (byte) 0x6f, (byte) 0x75, (byte) 0x3d, (byte) 0x1b,
				(byte) 0x24, (byte) 0x42, (byte) 0x3b, (byte) 0x33, (byte) 0x45,
				(byte) 0x44, (byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x5e,
				(byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x42, (byte) 0x40,
				(byte) 0x4f, (byte) 0x3a, (byte) 0x1b, (byte) 0x28, (byte) 0x42,
				(byte) 0x3d, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x24,
				(byte) 0x64, (byte) 0x24, (byte) 0x5e, (byte) 0x24, (byte) 0x40,
				(byte) 0x1b, (byte) 0x28, (byte) 0x42, (byte) 0x5e, (byte) 0x1b,
				(byte) 0x24, (byte) 0x42, (byte) 0x24, (byte) 0x3f, (byte) 0x24,
				(byte) 0x6d, (byte) 0x24, (byte) 0x26, (byte) 0x1b, (byte) 0x28,
				(byte) 0x42 };

		String h31exampleSpecificCharacterSet = "\\ISO 2022 IR 87";

		byte[] h32example = { (byte) 0xd4, (byte) 0xcf, (byte) 0xc0, (byte) 0xde,
				(byte) 0x5e, (byte) 0xc0, (byte) 0xdb, (byte) 0xb3, (byte) 0x3d,
				(byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x3b, (byte) 0x33,
				(byte) 0x45, (byte) 0x44, (byte) 0x1b, (byte) 0x28, (byte) 0x4a,
				(byte) 0x5e, (byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x42,
				(byte) 0x40, (byte) 0x4f, (byte) 0x3a, (byte) 0x1b, (byte) 0x28,
				(byte) 0x4a, (byte) 0x3d, (byte) 0x1b, (byte) 0x24, (byte) 0x42,
				(byte) 0x24, (byte) 0x64, (byte) 0x24, (byte) 0x5e, (byte) 0x24,
				(byte) 0x40, (byte) 0x1b, (byte) 0x28, (byte) 0x4a, (byte) 0x5e,
				(byte) 0x1b, (byte) 0x24, (byte) 0x42, (byte) 0x24, (byte) 0x3f,
				(byte) 0x24, (byte) 0x6d, (byte) 0x24, (byte) 0x26, (byte) 0x1b,
				(byte) 0x28, (byte) 0x4a };

		String h32exampleSpecificCharacterSet = "ISO 2022 IR 13\\ISO 2022 IR 87";

		byte[] i2example = { (byte) 0x48, (byte) 0x6f, (byte) 0x6e, (byte) 0x67,
				(byte) 0x5e, (byte) 0x47, (byte) 0x69, (byte) 0x6c, (byte) 0x64,
				(byte) 0x6f, (byte) 0x6e, (byte) 0x67, (byte) 0x3d, (byte) 0x1b,
				(byte) 0x24, (byte) 0x29, (byte) 0x43, (byte) 0xfb, (byte) 0xf3,
				(byte) 0x5e, (byte) 0x1b, (byte) 0x24, (byte) 0x29, (byte) 0x43,
				(byte) 0xd1, (byte) 0xce, (byte) 0xd4, (byte) 0xd7, (byte) 0x3d,
				(byte) 0x1b, (byte) 0x24, (byte) 0x29, (byte) 0x43, (byte) 0xc8,
				(byte) 0xab, (byte) 0x5e, (byte) 0x1b, (byte) 0x24, (byte) 0x29,
				(byte) 0x43, (byte) 0xb1, (byte) 0xe6, (byte) 0xb5, (byte) 0xbf };

		String i2exampleSpecificCharacterSet = "\\ISO 2022 IR 149";

		byte[] x1example = { (byte) 0x57, (byte) 0x61, (byte) 0x6e, (byte) 0x67,
				(byte) 0x5e, (byte) 0x58, (byte) 0x69, (byte) 0x61, (byte) 0x6f,
				(byte) 0x44, (byte) 0x6f, (byte) 0x6e, (byte) 0x67, (byte) 0x3d,
				(byte) 0xe7, (byte) 0x8e, (byte) 0x8b, (byte) 0x5e, (byte) 0xe5,
				(byte) 0xb0, (byte) 0x8f, (byte) 0xe6, (byte) 0x9d, (byte) 0xb1,
				(byte) 0x3d };

		String x1exampleSpecificCharacterSet = "ISO_IR 192";

		byte[] x2example = { (byte) 0x57, (byte) 0x61, (byte) 0x6e, (byte) 0x67,
				(byte) 0x5e, (byte) 0x58, (byte) 0x69, (byte) 0x61, (byte) 0x6f,
				(byte) 0x44, (byte) 0x6f, (byte) 0x6e, (byte) 0x67, (byte) 0x3d,
				(byte) 0xcd, (byte) 0xf5, (byte) 0x5e, (byte) 0xd0, (byte) 0xa1,
				(byte) 0xb6, (byte) 0xab, (byte) 0x3d };

		String x2exampleSpecificCharacterSet = "GB18030";

		createDicomFileWithPatientName(prefixPath + "h31example.dcm", h31example,
				h31exampleSpecificCharacterSet);
		createDicomFileWithPatientName(prefixPath + "h32example.dcm", h32example,
				h32exampleSpecificCharacterSet);
		createDicomFileWithPatientName(prefixPath + "i2example.dcm", i2example,
				i2exampleSpecificCharacterSet);
		createDicomFileWithPatientName(prefixPath + "x1example.dcm", x1example,
				x1exampleSpecificCharacterSet);
		createDicomFileWithPatientName(prefixPath + "x2example.dcm", x2example,
				x2exampleSpecificCharacterSet);

		try {
			String name = "\u0394\u03b9\u03bf\u03bd\u03c5\u03c3\u03b9\u03bf\u03c2";
			byte[] iso88597Bytes = name.getBytes("ISO8859_7");
			createDicomFileWithPatientName(prefixPath + "greek.dcm", iso88597Bytes,
			"ISO_IR 126");
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

		try {
			String name = "Buc^JŽr™me";
			byte[] iso88591Bytes = name.getBytes("ISO8859_1");
			createDicomFileWithPatientName(prefixPath + "french.dcm", iso88591Bytes,
			"ISO_IR 100");
		} catch (Exception e) {
			fail(e.getMessage());
		}

		try {
			String name = "€neas^RŸdiger";
			byte[] iso88591Bytes = name.getBytes("ISO8859_1");
			createDicomFileWithPatientName(prefixPath + "german.dcm", iso88591Bytes,
			"ISO_IR 100");
		} catch (Exception e) {
			fail(e.getMessage());
		}

		try {
			// from "http://faculty.washington.edu/heer/qabbani1.htm" Nizar Qabbani
			byte[] iso88596Bytes = { (byte) 0xe4, (byte) 0xe6, (byte) 0xd2,
					(byte) 0xc7, (byte) 0xd1, (byte) 0x20, (byte) 0xe2, (byte) 0xc8,
					(byte) 0xc7, (byte) 0xe6, (byte) 0xea };
			createDicomFileWithPatientName(prefixPath + "arabic.dcm", iso88596Bytes,
			"ISO_IR 127");
		} catch (Exception e) {
			fail(e.getMessage());
		}

		try {
			// from "http://www.p.lodz.pl/I35/personal/jw37/EUROPE/europe-L.html"
			// luxembourg in russian
			byte[] iso88595Bytes = { (byte) 0xbb, (byte) 0xee, (byte) 0xda,
					(byte) 0x63, (byte) 0x65, (byte) 0xdc, (byte) 0xd1, (byte) 0x79,
					(byte) 0x70, (byte) 0xd3 };
			createDicomFileWithPatientName(prefixPath + "russian.dcm", iso88595Bytes,
			"ISO_IR 144");
		} catch (Exception e) {
			fail(e.getMessage());
		}

	}

	public void testSpecificCharacterSet() throws Exception {
		SpecificCharacterSet charset = new SpecificCharacterSet(null);
		assertNotNull(charset);
	}

}
