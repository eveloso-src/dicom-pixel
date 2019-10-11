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

package org.dicom4j.data.elements;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import org.dicom4j.AbstractTestCase;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.data.elements.support.StringElement;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;
import org.dolmen.core.lang.HexaDecimalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestDataElement extends AbstractTestCase {

	/**
	 * the Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TestDataElement.class);

	public TestDataElement() {
		super("DataElementTest");
	}

	private void checkElement( DataElement element , DicomTag tag, ValueRepresentation vr ) {
		assertEquals( tag.getElement(), element.getTag().getElement() );
		assertEquals( vr.getCode(), element.getValueRepresentation().getCode() );
	}

	protected void clearAndChek(DataElement aDataElement) throws Exception {
		assertTrue(aDataElement.getValueMultiplicity() != 0);
		aDataElement.clear();
		assertTrue(aDataElement.getValueMultiplicity() == 0);
	}

	private void innerTestClear( DataElement element) {
		element.clear();
		assertEquals(0, element.getValueLength() );
	}

	private void innerTestStringElement( StringElement element , DicomTag tag, ValueRepresentation vr ) {
		this.checkElement( element, tag, vr);

		this.innerTestClear( element );
		element.setValue("TEXT");
		assertEquals(1, element.getValueMultiplicity());
		assertEquals("TEXT", element.getSingleStringValue());

		this.innerTestClear( element );
		element.addValue("ONE");
		element.addValue("TWO");
		assertEquals(2, element.getValueMultiplicity());
		assertEquals(7, element.getValueLength());
		element.setValue("ONE");
		assertEquals(1, element.getValueMultiplicity());
	}

	public void innerTestWriteImplictVR(StringElement element) throws Exception {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DicomOutputStream stream = new DicomOutputStream(bytes);
		stream.setTransferSyntax( TransferSyntax.ImplicitVRLittleEndian );
		element.write( stream );
		logger.debug("innerTestWriteImplictVR: bytes (length: " + bytes.toByteArray().length + "): " + HexaDecimalUtils.dump( bytes.toByteArray() ) );
		ByteArrayInputStream inBytes = new ByteArrayInputStream( bytes.toByteArray() );
		DicomInputStream inStream = new DicomInputStream( inBytes );
		int groupValue = inStream.readUnsigned16();
		int elementValue = inStream.readUnsigned16();
		DicomTag tag = new DicomTag( groupValue, elementValue);
		ShortString readedElement = null;
		if ( element.getValueRepresentation().equals( ValueRepresentation.ShortString) ) {
			readedElement = new ShortString( tag );
		}
		assertNotNull( readedElement );
		long vl = inStream.readUnsigned32();
		readedElement.read(inStream,  vl );

		assertEquals( element.getTag().getGroup() , readedElement.getTag().getGroup() );
		assertEquals( element.getTag().getElement() , readedElement.getTag().getElement() );
		assertEquals( element.getValueRepresentation() , readedElement.getValueRepresentation() );
		assertEquals( element.getDelimitedStringValues().trim(),  readedElement.getDelimitedStringValues().trim());
	}

	public void innerTestWriteStringElement(StringElement element) throws Exception {
		// explicit VR
		element.setValue("A");
		this.writeAndCheckLength( element, 10 );
		element.setValue("A ");
		this.writeAndCheckLength( element, 10 );
		element.setValue("A  ");
		this.writeAndCheckLength( element, 12 );
		element.setValue("       ");
		this.writeAndCheckLength( element, 16 );
		// implici VR
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testApplicationEntity() throws Exception {
		ApplicationEntity element = new ApplicationEntity(
				DicomTags.ScheduledStationAET);
		assertTrue(element.isValid());
		element.setValue("Test");
		assertTrue(element.isValid());
		element.setValue("NOT A VALID AET BECAUSE TOO TOO TOO TOO LONGER");
		assertFalse(element.isValid());
	}

	public void testClear() throws Exception {
		ApplicationEntity lAE = new ApplicationEntity(DicomTags.ScheduledStationAET);
		lAE.setValue("Test");
		this.clearAndChek(lAE);
		Time ltime = DataElements.newTime();
		ltime.setValue("TEST");
		this.clearAndChek(ltime);
		LongText lLongText = DataElements.newAdditionalPatientHistory();
		lLongText.setValue("TEST");
		this.clearAndChek(lLongText);

		UnsignedLong lUnsignedLong = DataElements.newCommandGroupLength();
		lUnsignedLong.setValue(10);
		this.clearAndChek(lUnsignedLong);
	}

	public void testDecimalString() throws Exception {
		DecimalString lDec = DataElements.newPatientWeight();
		lDec.addValue("90");
		DicomOutputStream lstream = new DicomOutputStream(
				new ByteArrayOutputStream());
		lDec.write(lstream);
	}

	public void testLongString() {
		logger.debug("testLongString");
		this.innerTestStringElement( DataElements.newInstitutionName(), DicomTags.InstitutionName, ValueRepresentation.LongString );
		logger.debug("testLongString: success");
	}

	public void testLongText() throws Exception {
		LongText longText = DataElements.newBarcodeValue();
		longText.setValue("Test");
		assertEquals(1, longText.getValueMultiplicity());
		String[] ldata = longText.getStringValues();
		assertEquals("Test", ldata[0]);
	}

	public void testOtherWordString() throws Exception {
		OtherWordString ows = DataElements.newBluePaletteColorLUTData();
		ows.setValues(new short[15]);
		assertEquals(1, ows.getValueMultiplicity());
		assertFalse(ows.isAvailableAsString());
		// String[] ldata = ows.getStringValues();
		// assertEquals("Test", ldata[0]);
		// ows.set

	}

	public void testShortString() throws Exception {
		logger.debug("testShortString");
		this.innerTestStringElement( DataElements.newStudyID(), DicomTags.StudyID, ValueRepresentation.ShortString );
		ShortString element = DataElements.newStudyID();
		//checkElement( element , DicomTags.StudyID, ValueRepresentation.ShortString );
		logger.info("Element: " + element );
		this.innerTestWriteStringElement( element );
		element.setValue("ABCD");
		this.innerTestWriteImplictVR( element);
		element.addValue("EFGH");
		this.innerTestWriteImplictVR( element);
		logger.debug("testShortString: success");
	}

	// test StringDataElements and subclasses
	public void testStringDataElements() {
		ApplicationEntity lAE = new ApplicationEntity(DicomTags.ScheduledStationAET);
		lAE.setValue("TEST1");
		lAE.addValue("TEST2");

		assertEquals("TEST1", lAE.getSingleStringValue(""));
		assertEquals("TEST1\\TEST2", lAE.getDelimitedStringValues(""));
	}

	public void testUniqueIdentifierWrite() throws Exception {
		UniqueIdentifier lUID = DataElements.newAffectedSOPClassUID();
		lUID.setValue("1");
		ByteArrayOutputStream lbytes = new ByteArrayOutputStream();
		DicomOutputStream lstream = new DicomOutputStream(lbytes);
		lUID.write(lstream);
		assertEquals(10, lbytes.toByteArray().length);
		lUID.setValue("20");
		lUID.write(lstream);
		assertEquals(20, lbytes.toByteArray().length);
		lUID.setValue("20.34");
		lUID.write(lstream);
		assertEquals(34, lbytes.toByteArray().length);
	}

	public void writeAndCheckLength(DataElement element, int expectedLength) throws Exception {
		ByteArrayOutputStream bytes = new ByteArrayOutputStream();
		DicomOutputStream stream = new DicomOutputStream(bytes);
		element.write(stream);
		assertEquals(expectedLength, bytes.toByteArray().length);
		logger.debug("bytes: " + HexaDecimalUtils.dump( bytes.toByteArray() ) );
	}
	
	public void testDataElementFactory() throws Exception {
		DataElementFactory factory = new DataElementFactory();
		
		DataElement us = factory.newElement( DicomTags.CommandField, ValueRepresentation.UnsignedShort, false, 0);
		assertEquals( ValueRepresentation.UnsignedShort, us.getValueRepresentation());
		
	}

}
