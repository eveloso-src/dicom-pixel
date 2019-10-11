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

package org.dicom4j.network.protocoldataunit;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.nio.ByteOrder;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.dicom4j.AbstractTestCase;
import org.dicom4j.Data;
import org.dicom4j.TestDicom4J;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.mock.io.MockBinaryInputStream;
import org.dicom4j.network.protocoldataunit.codec.ProtocolDataUnitCodecFactory;
import org.dicom4j.network.protocoldataunit.items.ApplicationContextItem;
import org.dicom4j.network.protocoldataunit.pdu.AssociateRQPDU;
import org.dolmen.core.lang.HexaDecimalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Test ProtocolDataUnit
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestProtocolDataUnit extends AbstractTestCase {

	private static Logger logger = LoggerFactory
	.getLogger(TestProtocolDataUnit.class);

	private ProtocolDataUnitCodecFactory codecFactory;

	private ProtocolDataUnitFactory pduFactory;

	public TestProtocolDataUnit(String name) {
		super(name);
	}

	/*
	 * public void testAAbortPDU() { //ProtocolDataUnit lPDU = new
	 * AAbortPDU(AAbortPDU.Source.RESERVED, AAbortPDU.Reasons.UNRECOGNIZED_PDU);
	 * // byte[] lData = {07, 00, 00, 00, 00, 04, 00, 00, 01, 01}; //
	 * assertTrue(HexDump
	 * .dump(lData).equals(HexDump.dump(lAAbortPDU.getBytes()))); }
	 */

	public ProtocolDataUnit newProtocolDataUnit(byte aType) throws Exception {
		ProtocolDataUnit lPDU = this.pduFactory.newProtocolDataUnit(aType);
		assertEquals(aType, lPDU.getType().value());
		return lPDU;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.pduFactory = new ProtocolDataUnitFactory();
		this.codecFactory = new ProtocolDataUnitCodecFactory();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAReleaseRPPDU() throws Exception {
		ProtocolDataUnit lPDU = this
		.newProtocolDataUnit(ProtocolDataUnitType.A_RELEASE_RP.value());
		byte[] lbytes = this.codecFactory.getEncoder().encode(lPDU);
		byte[] lData = { 06, 00, 00, 00, 00, 04, 00, 00, 00, 00 };
		assertTrue(HexaDecimalUtils.dump(lData).equals(
				HexaDecimalUtils.dump(lbytes)));

		// test read
		MockBinaryInputStream stream = new MockBinaryInputStream(null);
		stream.setSkipReturnValue(4);
		try {
			lPDU.read(stream, 1);
			fail("Should have gotten Exception");
		} catch (Exception expected) {
			System.out.println(expected.getMessage());
		}
		stream.setSkipReturnValue(1);
		lPDU.read(stream, 1);
	}

	public void testAReleaseRQPDU() throws Exception {
		ProtocolDataUnit lPDU = this
		.newProtocolDataUnit(ProtocolDataUnitType.A_RELEASE_RQ.value());
		byte[] lbytes = this.codecFactory.getEncoder().encode(lPDU);
		byte[] lData = { 05, 00, 00, 00, 00, 04, 00, 00, 00, 00 };
		assertTrue(HexaDecimalUtils.dump(lData).equals(
				HexaDecimalUtils.dump(lbytes)));

		// test read
		MockBinaryInputStream stream = new MockBinaryInputStream(null);
		stream.setSkipReturnValue(4);
		try {
			lPDU.read(stream, 1);
			fail("Should have gotten Exception");
		} catch (Exception expected) {
			System.out.println(expected.getMessage());
		}
		stream.setSkipReturnValue(1);
		lPDU.read(stream, 1);
	}

	public void testEncodeAssociateRQPDU() throws Exception {
		AssociateRQPDU rqPDU = new AssociateRQPDU();

		ApplicationContextItem acItem = new ApplicationContextItem();

		rqPDU.setApplicationContextItem(acItem);
		rqPDU.addPresentationContextItem(Data
				.newPresentationContextItemRQ((byte) 1));
		rqPDU.setUserInformationItem(Data.newUserInformationItem());

		BinaryOutputStream stream = new BinaryOutputStream(new FileOutputStream(
				TestDicom4J.outputLocation + "/AssociateRQPDU.dump"));
		stream.setByteOrder(ByteOrder.BIG_ENDIAN);
		rqPDU.write(stream);
	}

	public void testEndOfStream() throws Exception {
		logger.info("testEndOfStream");
		AssociateRQPDU rqPDU = new AssociateRQPDU();
		ByteArrayOutputStream out = new ByteArrayOutputStream(90);
		for (int i = 0; i < 68; i++) {
			out.write(0x00);
		}
		// out.write( 0x48 );
		out.write(0xffffffff);
		ByteArrayInputStream stream = new ByteArrayInputStream(out.toByteArray());
		rqPDU.read(new BinaryInputStream(stream), 1000);
		logger.info("testEndOfStream: success");
	}

	public void testnewProtocolDataUnit() throws Exception {
		ProtocolDataUnit lPDU = this.pduFactory
		.newProtocolDataUnit(ProtocolDataUnitType.A_ASSOCIATE_RQ_BYTE);
		assertEquals(lPDU.getType().value(),
				ProtocolDataUnitType.A_ASSOCIATE_RQ_BYTE);
		lPDU = this.pduFactory
		.newProtocolDataUnit(ProtocolDataUnitType.A_ASSOCIATE_AC_BYTE);
		assertEquals(lPDU.getType().value(),
				ProtocolDataUnitType.A_ASSOCIATE_AC_BYTE);
	}

	public void textAssociateRQPDU() throws Exception {
		AssociateRQPDU pdu = new AssociateRQPDU();

		// test read
		MockBinaryInputStream stream = new MockBinaryInputStream(null);
		try {
			pdu.read(stream, 1);
			fail("Should have gotten Exception");
		} catch (Exception expected) {
			System.out.println(expected.getMessage());
		}

		// ProtocolDataUnit pdu = newProtocolDataUnit( ProtocolDataUnitType.a )

	}

}
