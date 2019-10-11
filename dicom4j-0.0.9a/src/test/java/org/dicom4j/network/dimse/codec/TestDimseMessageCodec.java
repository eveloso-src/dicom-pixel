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

package org.dicom4j.network.dimse.codec;

import org.dicom4j.AbstractTestCase;
import org.dicom4j.dicom.network.dimse.DimseStatus;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.network.Properties;
import org.dicom4j.network.dimse.messages.CStoreResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestDimseMessageCodec extends AbstractTestCase {

	private static Logger logger = LoggerFactory
	.getLogger(TestDimseMessageCodec.class);

	private DimseMessageCodecFactory factory = null;

	public TestDimseMessageCodec() {
		super(TestDimseMessageCodec.class.getName());
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.factory = new DimseMessageCodecFactory(Properties.newAssoc());
		// testFactory();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testDimseMessageEncoder() throws Exception {
		logger.info("testDimseMessageEncoder: start");
		DimseMessageEncoder lEncoder = new DimseMessageEncoder();
		CStoreResponseMessage lResp = this.getDimseMessageFactory()
		.newCStoreResponseMessage(0, "2", DimseStatus.Success);
		lEncoder.encode((byte) 0, TransferSyntax.Default, lResp, 100000);
		logger.info("testDimseMessageEncoder: sucess");
	}

	public void testFactory() {
		assertNotNull(this.factory);
		assertNotNull(this.factory.getDecoder());
		assertNotNull(this.factory.getEncoder());
	}
}
