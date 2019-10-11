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

package org.dicom4j.network.dimse;

import org.dicom4j.AbstractTestCase;
import org.dicom4j.dicom.network.dimse.DimseStatus;

public class TestDimseStatus extends AbstractTestCase {

	private static final long serialVersionUID = 1L;

	// private static final Logger logger =
	// LoggerFactory.getLogger(TestDimseStatus.class);

	public TestDimseStatus() {
		super("TestDimseStatus");
	}

	public void testDimseStatus() throws Exception {
		assertEquals(true, DimseStatus.isFailure(DimseStatus.RefusedOutOfResources
				.value()));
		assertEquals(true, DimseStatus.RefusedOutOfResources.isFailure());
	}

}
