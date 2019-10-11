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

/**
 * 
 */
package org.dicom4j.dicom.uniqueidentifiers;

import org.dicom4j.AbstractTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestUniqueIdentifierRegistry extends AbstractTestCase {

	private static final Logger logger = LoggerFactory
	.getLogger(TestUniqueIdentifierRegistry.class);

	private static final long serialVersionUID = 1L;

	public TestUniqueIdentifierRegistry() {
		super();
	}

	public void testgetSopClass() throws Exception {
		logger.info("testgetSopClass: start");
		SOPClassRegistry registry = new SOPClassRegistry();
		SOPClass sopClass = registry.getByUID("1.2.840.10008.5.1.4.1.1.9.1.3");
		assertEquals("1.2.840.10008.5.1.4.1.1.9.1.3", sopClass.getUID());
		logger.info("testgetSopClass: success");
	}

	public void testgetTransferSyntax() throws Exception {
		logger.info("testgetTransferSyntax: start");
		TransferSyntaxRegistry registry = new TransferSyntaxRegistry();
		String tsUID = TransferSyntax.ImplicitVRLittleEndian.getUID();
		TransferSyntax ts = registry.getByUID(tsUID);
		assertEquals(tsUID, ts.getUID());
		logger.info("testgetTransferSyntax: success");
	}
}
