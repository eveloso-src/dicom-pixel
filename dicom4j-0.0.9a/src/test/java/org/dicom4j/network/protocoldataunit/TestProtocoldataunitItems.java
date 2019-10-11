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
package org.dicom4j.network.protocoldataunit;

import org.dicom4j.AbstractTestCase;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.io.media.TestDicomFile;
import org.dicom4j.network.protocoldataunit.items.PresentationDataValueItem;
import org.dicom4j.network.protocoldataunit.items.ProtocolDataUnitItemType;
import org.dicom4j.network.protocoldataunit.items.TransferSyntaxItem;
import org.dicom4j.network.protocoldataunit.items.support.AbstractProtocolDataUnitItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TestProtocoldataunitItems extends AbstractTestCase {

	private static byte[] PDV_1 = { 0x1, 0x1, 0x1, 0x1, 0x1 };

	private static final Logger logger = LoggerFactory.getLogger(TestProtocoldataunitItems.class);	
	
	public TestProtocoldataunitItems() {
		super("TestItems");
	}

	/*
	 * public void testItems() throws Exception {
	 * 
	 * TransferSyntaxItem ltsItem = new TransferSyntaxItem();
	 * 
	 * ltsItem.setTransferSyntax( TransferSyntax.Default );
	 * assertEquals(TransferSyntax.Default.getName() , TransferSyntax.toString(
	 * ltsItem.getValue() ) );
	 * 
	 * }
	 */

	protected void checkTypeAndName(ProtocolDataUnitItemType type, AbstractProtocolDataUnitItem item) {
		assertEquals(type.value(), item.getType().value());
		assertEquals(type.getAsString(), item.getName());
	}

	public void testPresentationDataValueItem() throws Exception {
		PresentationDataValueItem pdv = new PresentationDataValueItem();
		assertNotNull(pdv);
		assertEquals(-1, pdv.getPresentationContextID());
		assertTrue(pdv.isCommand());
		assertTrue(pdv.isLastFragment());
	}

	public void testTransferSyntaxItem() throws Exception {
		logger.info("testTransferSyntaxItem");
		TransferSyntaxItem tsItem = new TransferSyntaxItem();

		tsItem.setTransferSyntax(TransferSyntax.Default);
		assertEquals(TransferSyntax.Default.getUID(), tsItem.getValue());
		this.checkTypeAndName(ProtocolDataUnitItemType.TRANSFERT_SYNTAX, tsItem);
		assertEquals(TransferSyntax.Default.getName(), tsItem.getTransferSyntaxName());
		TransferSyntaxRegistry reg = new TransferSyntaxRegistry();
		tsItem.setTransferSyntaxRegistry(reg);
		assertEquals(TransferSyntax.Default.getName(), tsItem	.getTransferSyntaxName());
		logger.info("testTransferSyntaxItem: success");
	}

}
