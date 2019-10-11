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

package org.dicom4j.network.protocoldataunit.userinformationsubitems.codec;

import java.io.InputStream;

import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.network.protocoldataunit.items.UserInformationItem;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.UserInformationSubItem;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.UserInformationSubItemFactory;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.UserInformationSubItemType;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.AsynchronousOperationsWindow;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.ImplementationClassUID;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.ImplementationVersionName;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.MaximumLength;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.support.AbstractUserInformationSubItem;
import org.dolmen.core.lang.HexaDecimalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Decode {@link UserInformationSubItem} from {@link InputStream}
 * 
 * @since 0.0.9
 * @since 11 oct. 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class UserInformationSubItemDecoder {

	private static final Logger logger = LoggerFactory
	.getLogger(UserInformationSubItemDecoder.class);

	private static final long serialVersionUID = 1L;

	private UserInformationSubItemFactory itemFactory;

	public UserInformationSubItemDecoder() {
		this.setItemFactory(new UserInformationSubItemFactory());
	}

	public UserInformationItem decode(BinaryInputStream stream)
	throws UserInformationSubItemDecoderException {
		logger.debug("must decode a UserInformationItem");
		try {
			UserInformationItem item = new UserInformationItem();
			stream.skip(1); // We must skip the first reserved byte
			long length = stream.readUnsigned16();
			logger.debug("length to read: " + length + ")");
			int lPos = 0;
			while (lPos < length) {
				byte itemType = stream.readByte();
				stream.skip(1);
				int llength = stream.readUnsigned16();
				logger.debug("we must read a "
						+ UserInformationSubItemType.toString(itemType)
						+ " sub item (length: " + llength + ")");
				AbstractUserInformationSubItem lItem = this.itemFactory
				.newUserInformationSubItem(itemType);
				if (lItem != null) {
					lItem.read(stream, llength);
					logger.info(lItem.getName() + " readed");
					logger.debug(lItem.getName() + "\n"
							+ HexaDecimalUtils.dump(lItem.toBytes()));
					if (itemType == UserInformationSubItemType.MAXIMUM_LENGTH.value()) {
						item.setMaximumLengthSubItem((MaximumLength) lItem);
					} else if (itemType == UserInformationSubItemType.IMPLENTATIONCLASS_UID
							.value()) {
						item
						.setImplementationClassUIDSubItem((ImplementationClassUID) lItem);
					} else if (itemType == UserInformationSubItemType.IMPLEMENTATION_VERSION_NAME
							.value()) {
						item
						.setImplementationVersionNameSubItem((ImplementationVersionName) lItem);
					} else if (itemType == UserInformationSubItemType.ASYNCHRONOUS_OPERATIONS_WINDOW
							.value()) {
						item
						.setAsynchronousOperationsWindowSubItem((AsynchronousOperationsWindow) lItem);
					}
					/*
					 * else if (lItemType ==
					 * UserInformationSubItem.Types.SCP_SCU_ROLE_SELECTION) {
					 * ScpScuRoleSelection lItem = new ScpScuRoleSelection(aStream,
					 * llength); addScpScuRoleSelectionItem(lItem);
					 * fLogger.info("readed: " + lItem.getName() + "\n" +
					 * HexDump.dump(lItem.toBytes()));
					 */
				} else {
					logger.warn("Unknown Item in USER_INFORMATION, we skip " + llength
							+ " byte(s)");
					stream.skip(llength);
				}
				lPos += 4 + llength; // PDU type (1), reserved (1), length of data in
			}
			return item;
		} catch (Exception ex) {
			throw new UserInformationSubItemDecoderException(ex.getMessage(), ex);
		}

	}

	protected UserInformationSubItemFactory getItemFactory() {
		return this.itemFactory;
	}

	protected void setItemFactory(UserInformationSubItemFactory itemFactory) {
		this.itemFactory = itemFactory;
		logger.info("setItemFactory: " + itemFactory);
	}

}
