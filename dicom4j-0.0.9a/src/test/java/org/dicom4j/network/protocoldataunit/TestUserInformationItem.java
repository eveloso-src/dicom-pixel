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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteOrder;

import org.dicom4j.AbstractTestCase;
import org.dicom4j.TestDicom4J;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.items.UserInformationItem;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.UserInformationSubItemFactory;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.UserInformationSubItemType;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.codec.UserInformationSubItemDecoder;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.codec.UserInformationSubItemEncoder;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.support.AbstractUserInformationSubItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUserInformationItem extends AbstractTestCase {

	private static final String ClassUID = "ClassUID";

	private static final Logger logger = LoggerFactory
	.getLogger(TestUserInformationItem.class);

	private static final long serialVersionUID = 1L;

	private static final String VersionName = "VersionName";

	public TestUserInformationItem() {
		super("TestUserInformationItem");
	}

	/**
	 * 0.0.9
	 * 
	 * @throws Exception
	 */
	public void testDecode() throws Exception {
		logger.info("testDecode");
		UserInformationSubItemDecoder decoder = new UserInformationSubItemDecoder();
		BinaryInputStream stream = new BinaryInputStream(new FileInputStream(
				TestDicom4J.outputLocation + "/UserInformationItem.dump"));
		stream.setByteOrder(ByteOrder.BIG_ENDIAN);
		stream.skip(1);
		UserInformationItem item = decoder.decode(stream);
		assertNotNull(item);
		assertEquals(ClassUID, item.getImplementationClassUID());
		assertEquals(VersionName, item.getImplementationVersionName());
		logger.info("testDecode: success");
	}

	/**
	 * 0.0.9
	 * 
	 * @throws Exception
	 */
	public void testEncode() throws Exception {
		logger.info("testDecode");
		UserInformationSubItemEncoder encoder = new UserInformationSubItemEncoder();
		UserInformationItem item = new UserInformationItem();
		item.setImplementationClassUID(ClassUID);
		item.setImplementationVersionName(VersionName);
		item.setMaximumLength(123456);
		item.setMaximumNumberOperationsInvoked(4);
		item.setMaximumNumberOperationsPerformed(4);
		item.addScpScuRoleSelection(SOPClass.Verification.getUID(), true, true);
		logger.info("UserInformationItem: \n" + item.toString());
		BinaryOutputStream stream = new BinaryOutputStream(new FileOutputStream(
				TestDicom4J.outputLocation + "/UserInformationItem.dump"));
		stream.setByteOrder(ByteOrder.BIG_ENDIAN);
		logger.info("UserInformationItem: \n" + item.toString());
		encoder.encode(item, stream);
		logger.info("testEncode: success");
	}

	public void testGetterAndSetter() throws Exception {
		UserInformationItem lItems = new UserInformationItem();
		assertNotNull(lItems);
		assertEquals("", lItems.getImplementationClassUID());
		lItems.setImplementationClassUID(ClassUID);
		assertEquals(ClassUID, lItems.getImplementationClassUID());
		lItems.setImplementationVersionName(VersionName);
		assertEquals(VersionName, lItems.getImplementationVersionName());
	}

	/**
	 * 0.0.6
	 * 
	 * @throws Exception
	 */
	public void testnewUserInformationSubItem() throws Exception {
		UserInformationSubItemFactory factory = new UserInformationSubItemFactory();
		AbstractUserInformationSubItem item = null;
		assertNotNull(factory);
		item = factory
		.newUserInformationSubItem(UserInformationSubItemType.MAXIMUM_LENGTH
				.value());
		assertNotNull(item);
		assertEquals(UserInformationSubItemType.MAXIMUM_LENGTH.value(), item
				.getType().value());

		item = factory
		.newUserInformationSubItem(UserInformationSubItemType.ASYNCHRONOUS_OPERATIONS_WINDOW
				.value());
		assertNotNull(item);
		assertEquals(UserInformationSubItemType.ASYNCHRONOUS_OPERATIONS_WINDOW
				.value(), item.getType().value());

		item = factory
		.newUserInformationSubItem(UserInformationSubItemType.SCP_SCU_ROLE_SELECTION
				.value());
		assertNotNull(item);
		assertEquals(UserInformationSubItemType.SCP_SCU_ROLE_SELECTION.value(),
				item.getType().value());

	}
}
