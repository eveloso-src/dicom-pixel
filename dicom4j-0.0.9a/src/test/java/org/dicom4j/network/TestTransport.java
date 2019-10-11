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

package org.dicom4j.network;

import junit.framework.TestCase;

public class TestTransport extends TestCase {

	public TestTransport(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// TODO
		// fTransportLayer = new TransportLayerImpl("localhost",104);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testOpenConnection() {
		try {
			fail("NO TEST");
			// fTransportLayer.openConnection();
			// AAbortPDU lPDU = new AAbortPDU(AAbortPDU.Source.SERVICE_PROVIDER,
			// AAbortPDU.Reasons.INVALID_PDU_PARAMETER_VALUE);
			// fTransportLayer.sendPDU(lPDU);
			// fTransportLayer.closeConnection();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	// private Transport48 fTransportLayer;

}
