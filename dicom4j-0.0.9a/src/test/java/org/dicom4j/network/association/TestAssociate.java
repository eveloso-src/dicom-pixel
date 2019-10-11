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

package org.dicom4j.network.association;

import org.dicom4j.AbstractTestCase;
import org.dicom4j.core.Const;
import org.dicom4j.dicom.implementation.Dicom4jImplementation;
import org.dicom4j.dicom.implementation.DicomImplementation;
import org.dicom4j.network.association.associate.AssociatePrimitiveFactory;
import org.dicom4j.network.association.associate.AssociateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAssociate extends AbstractTestCase {

	private static final Logger logger = LoggerFactory
	.getLogger(TestAssociate.class);

	private static final long serialVersionUID = 1L;

	/**
	 * @since 0.0.9
	 * @throws Exception
	 */
	public void testAssociateRequest() throws Exception {
		logger.info("AssociateRequest");
		AssociateRequest pdu = new AssociateRequest();
		assertEquals(Const.CLASS_UID, pdu.getImplementationClassUID());
		assertEquals(Const.VERSION_NAME + " - " + Const.VERSION, pdu
				.getImplementationVersionName());
		logger.info("AssociateRequest: succes");
	}

	/**
	 * @since 0.0.9
	 * @throws Exception
	 */
	public void testFactory() throws Exception {
		DicomImplementation implementation = new Dicom4jImplementation();
		String classUID = implementation.getImplementationClassUID()
		.getSingleStringValue();
		String versionName = implementation.getImplementationVersionName()
		.getSingleStringValue();
		AssociatePrimitiveFactory factory = new AssociatePrimitiveFactory();
		factory.setClassUID(classUID);
		factory.setVersionName(versionName);

		AssociateRequest request = factory.newAssociateRequest();
		assertNotNull(request);

		assertEquals(factory.getClassUID(), request.getImplementationClassUID());
		assertEquals(factory.getVersionName(), request
				.getImplementationVersionName());
	}
}
