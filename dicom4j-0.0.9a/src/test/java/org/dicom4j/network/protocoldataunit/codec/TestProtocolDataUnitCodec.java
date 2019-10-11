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

package org.dicom4j.network.protocoldataunit.codec;

import junit.framework.TestCase;

import org.dicom4j.TestDicom4J;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnitFactory;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnitType;
import org.dolmen.core.lang.HexaDecimalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TestProtocolDataUnitCodec
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestProtocolDataUnitCodec extends TestCase {

	private static Logger logger = LoggerFactory
	.getLogger(TestProtocolDataUnitCodec.class);

	private ProtocolDataUnitCodecFactory codecFactory;

	private ProtocolDataUnitFactory factory;

	public TestProtocolDataUnitCodec(String name) {
		super(name);
		TestDicom4J.start();
		this.factory = new ProtocolDataUnitFactory();
		this.codecFactory = new ProtocolDataUnitCodecFactory();
	}

	public ProtocolDataUnit newProtocolDataUnit(byte aType) throws Exception {
		ProtocolDataUnit lPDU = this.factory.newProtocolDataUnit(aType);
		assertEquals(aType, lPDU.getType().value());
		return lPDU;
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testAAbortPDU() {
		// ProtocolDataUnit lPDU = new AAbortPDU(AAbortPDU.Source.RESERVED,
		// AAbortPDU.Reasons.UNRECOGNIZED_PDU);
		// byte[] lData = {07, 00, 00, 00, 00, 04, 00, 00, 01, 01};
		// assertTrue(HexDump.dump(lData).equals(HexDump.dump(lAAbortPDU.getBytes())));
	}

	public void testAReleaseRPPDU() throws Exception {
		logger.info("testAReleaseRPPDU");
		ProtocolDataUnit lPDU = this
		.newProtocolDataUnit(ProtocolDataUnitType.A_RELEASE_RP_BYTE);
		byte[] lbytes = this.codecFactory.getEncoder().encode(lPDU);
		byte[] lData = { 06, 00, 00, 00, 00, 04, 00, 00, 00, 00 };
		assertTrue(HexaDecimalUtils.dump(lData).equals(
				HexaDecimalUtils.dump(lbytes)));
		logger.info("testAReleaseRPPDU: success");
	}

	public void testAReleaseRQPDU() throws Exception {
		ProtocolDataUnit lPDU = this
		.newProtocolDataUnit(ProtocolDataUnitType.A_RELEASE_RQ_BYTE);
		byte[] lbytes = this.codecFactory.getEncoder().encode(lPDU);
		byte[] lData = { 05, 00, 00, 00, 00, 04, 00, 00, 00, 00 };
		assertTrue(HexaDecimalUtils.dump(lData).equals(
				HexaDecimalUtils.dump(lbytes)));
	}

	/*
	 * public void testGEdump() throws Exception { logger.info("testGEdump");
	 * ProtocolDataUnitDecoder decoder = codecFactory.getDecoder(); InputStream
	 * stream = new FileInputStream( new File("./GE dump") ); byte type = (byte)
	 * stream.read(); logger.info("pdu's type: " +
	 * ProtocolDataUnitType.typetoString(type) );
	 * logger.info("testGEdump: success"); }
	 */

}
