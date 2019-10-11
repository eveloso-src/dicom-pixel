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

package org.dicom4j.network.protocoldataunit.items;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedList;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnitType;
import org.dicom4j.network.protocoldataunit.support.AbstractProtocolDataUnit;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.UserInformationSubItemFactory;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.UserInformationSubItemType;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.AsynchronousOperationsWindow;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.ImplementationClassUID;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.ImplementationVersionName;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.MaximumLength;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.ScpScuRoleSelection;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.support.AbstractUserInformationSubItem;
import org.dolmen.core.lang.HexaDecimalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User Information Item (see DICOM PS 3.8)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class UserInformationItem extends AbstractProtocolDataUnit {

	private static final UserInformationSubItemFactory ITEM_FACTORY = new UserInformationSubItemFactory();

	private static final Logger logger = LoggerFactory
	.getLogger(UserInformationItem.class);

	/**
	 * Asynchronous Operations Window
	 */
	private AsynchronousOperationsWindow asynchronousOperationsWindow;

	private ImplementationClassUID implementationClassUID;

	private ImplementationVersionName implementationVersionName;

	private MaximumLength maximumLength;

	private LinkedList<ScpScuRoleSelection> scpScuRoleSelections;

	/**
	 * Creates a new User Information Item
	 * 
	 */
	public UserInformationItem() {
		super();
		this.scpScuRoleSelections = new LinkedList<ScpScuRoleSelection>();
		this.asynchronousOperationsWindow = null;
	}

	public void addScpScuRoleSelection(String aSOPClassUID, boolean aIsSCU,
			boolean aIsSCP) {
		this.addScpScuRoleSelectionItem(new ScpScuRoleSelection(aSOPClassUID,
				aIsSCU, aIsSCP));
	}

	private void addScpScuRoleSelectionItem(ScpScuRoleSelection aItem) {
		this.scpScuRoleSelections.add(aItem);
	}

	public AsynchronousOperationsWindow getAsynchronousOperationsWindow() {
		return this.asynchronousOperationsWindow;
	}

	public String getImplementationClassUID() {
		if (this.getImplementationClassUIDSubItem() != null) {
			return this.getImplementationClassUIDSubItem().getValue();
		} else {
			return "";
		}
	}

	public ImplementationClassUID getImplementationClassUIDSubItem() {
		return this.implementationClassUID;
	}

	public String getImplementationVersionName() {
		if (this.getImplementationVersionNameSubItem() != null) {
			return this.getImplementationVersionNameSubItem().getValue();
		} else {
			return "";
		}
	}

	public ImplementationVersionName getImplementationVersionNameSubItem() {
		return this.implementationVersionName;
	}

	/**
	 * Return the length of the PDU
	 * 
	 * @return The length
	 */
	@Override
	public int getLength() {
		int Result = 4;
		if (this.maximumLength != null) {
			Result += this.maximumLength.getLength();
		}
		if (this.implementationClassUID != null) {
			Result += this.implementationClassUID.getLength();
		}
		if (this.implementationVersionName != null) {
			Result += this.implementationVersionName.getLength();
		}
		if (this.asynchronousOperationsWindow != null) {
			Result += this.asynchronousOperationsWindow.getLength();
		}
		Iterator<ScpScuRoleSelection> lIterator = this.scpScuRoleSelections
		.iterator();
		while (lIterator.hasNext()) {
			Result += (lIterator.next()).getLength();
		}
		return Result;
	}

	/**
	 * Return the Maximum length (those stored in the MaximumLengthSubItem)
	 * 
	 * @return the maximum PDU length
	 */
	public long getMaximumLength() {
		if (this.getMaximumLengthSubItem() != null) {
			return this.maximumLength.getValue();
		} else {
			return 0;
		}
	}

	public MaximumLength getMaximumLengthSubItem() {
		return this.maximumLength;
	}

	public int getMaximumNumberOperationsInvoked() {
		if (this.asynchronousOperationsWindow == null) {
			return 1;
		} else {
			return this.asynchronousOperationsWindow
			.getMaximumNumberOperationsInvoked();
		}
	}

	public int getMaximumNumberOperationsPerformed() {
		if (this.asynchronousOperationsWindow == null) {
			return 1;
		} else {
			return this.asynchronousOperationsWindow
			.getMaximumNumberOperationsPerformed();
		}
	}

	public Iterator<ScpScuRoleSelection> getScpScuRoleSelectionIterator() {
		return this.scpScuRoleSelections.iterator();
	}

	@Override
	public ProtocolDataUnitType getType() {
		return ProtocolDataUnitItemType.USER_INFORMATION;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("start reading (length to read: " + length + ")");
		int lPos = 0;
		while (lPos < length) {
			byte lItemType = stream.readByte();
			stream.skip(1);
			int llength = stream.readUnsigned16();
			logger.debug("we must read a "
					+ UserInformationSubItemType.toString(lItemType)
					+ " sub item (length: " + llength + ")");
			AbstractUserInformationSubItem lItem = ITEM_FACTORY
			.newUserInformationSubItem(lItemType);
			if (lItem != null) {
				lItem.read(stream, llength);
				logger.info(lItem.getName() + " readed");
				logger.debug(lItem.getName() + "\n"
						+ HexaDecimalUtils.dump(lItem.toBytes()));
				if (lItemType == UserInformationSubItemType.MAXIMUM_LENGTH.value()) {
					this.setMaximumLengthSubItem((MaximumLength) lItem);
				} else if (lItemType == UserInformationSubItemType.IMPLENTATIONCLASS_UID
						.value()) {
					this.setImplementationClassUIDSubItem((ImplementationClassUID) lItem);
				} else if (lItemType == UserInformationSubItemType.IMPLEMENTATION_VERSION_NAME
						.value()) {
					this
					.setImplementationVersionNameSubItem((ImplementationVersionName) lItem);
				} else if (lItemType == UserInformationSubItemType.ASYNCHRONOUS_OPERATIONS_WINDOW
						.value()) {
					this.asynchronousOperationsWindow = (AsynchronousOperationsWindow) lItem;
				}
				/*
				 * else if (lItemType ==
				 * UserInformationSubItem.Types.SCP_SCU_ROLE_SELECTION) {
				 * ScpScuRoleSelection lItem = new ScpScuRoleSelection(aStream,
				 * llength); addScpScuRoleSelectionItem(lItem); fLogger.info("readed: "
				 * + lItem.getName() + "\n" + HexDump.dump(lItem.toBytes()));
				 */
			} else {
				logger.warn("Unknow Item in USER_INFORMATION, we skip " + llength
						+ " byte(s)");
				stream.skip(llength);
			}
			lPos += 4 + llength; // PDU type (1), reserved (1), length of data in
			// PDU(2), PDU Data (llength)
		}
	}

	public void setAsynchronousOperationsWindowSubItem(
			AsynchronousOperationsWindow asynchronousOperationsWindow) {
		this.asynchronousOperationsWindow = asynchronousOperationsWindow;
	}

	public String setImplementationClassUID(String implementationClassUID) {
		this.setImplementationClassUIDSubItem(new ImplementationClassUID(
				implementationClassUID));
		return implementationClassUID;
	}

	public void setImplementationClassUIDSubItem(ImplementationClassUID aItem) {
		assert aItem != null;
		this.implementationClassUID = aItem;
	}

	public String setImplementationVersionName(String aImplementationVersionName) {
		this.setImplementationVersionNameSubItem(new ImplementationVersionName(
				aImplementationVersionName));
		return aImplementationVersionName;
	}

	public void setImplementationVersionNameSubItem(ImplementationVersionName item) {
		assert item != null;
		this.implementationVersionName = item;
	}

	public void setMaximumLength(long aMaximumLength) {
		this.setMaximumLengthSubItem(new MaximumLength(aMaximumLength));
	}

	public void setMaximumLengthSubItem(MaximumLength aItem) {
		assert aItem != null;
		this.maximumLength = aItem;
	}

	public void setMaximumNumberOperationsInvoked(
			int aMaximumNumberOperationsInvoked) {
		if (this.asynchronousOperationsWindow == null) {
			this.asynchronousOperationsWindow = new AsynchronousOperationsWindow();
		}
		this.asynchronousOperationsWindow
		.setMaximumNumberOperationsInvoked(aMaximumNumberOperationsInvoked);
	}

	public void setMaximumNumberOperationsPerformed(
			int aMaximumNumberOperationsPerformed) {
		if (this.asynchronousOperationsWindow == null) {
			this.asynchronousOperationsWindow = new AsynchronousOperationsWindow();
		}
		this.asynchronousOperationsWindow
		.setMaximumNumberOperationsPerformed(aMaximumNumberOperationsPerformed);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("User Information: \n");
		if (this.maximumLength != null) {
			sb.append("  " + this.maximumLength + "\n");
		}
		if (this.implementationClassUID != null) {
			sb.append("  " + this.implementationClassUID + "\n");
		}
		if (this.implementationVersionName != null) {
			sb.append("  " + this.implementationVersionName + "\n");
		}
		if (this.asynchronousOperationsWindow != null) {
			sb.append("  " + this.asynchronousOperationsWindow + "\n");
		}
		Iterator<ScpScuRoleSelection> lIterator = this.scpScuRoleSelections
		.iterator();
		while (lIterator.hasNext()) {
			sb.append("  " + lIterator.next().toString());
		}
		return sb.toString();
	};

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		// fLogger.debug("Start writing");
		if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
		stream.write(this.getType().value());
		stream.write(0); // reserved
		stream.writeUnsigned16(this.getLength() - 4);

		if (this.maximumLength != null) {
			this.maximumLength.write(stream);
			// fLogger.info("write: " + fMaximumLength.getName() + "\n" +
			// HexDump.dump(fMaximumLength.toBytes()));
		}
		if (this.implementationClassUID != null) {
			this.implementationClassUID.write(stream);
			// fLogger.info("write: " + fImplementationClassUID.getName() + "\n" +
			// HexDump.dump(fImplementationClassUID.toBytes()));
		}

		if (this.implementationVersionName != null) {
			this.implementationVersionName.write(stream);
			// fLogger.info("write: " + fImplementationVersionName.getName() + "\n" +
			// HexDump.dump(fImplementationVersionName.toBytes()));
		}
		if (this.asynchronousOperationsWindow != null) {
			this.asynchronousOperationsWindow.write(stream);
			// fLogger.info("write: " + fImplementationVersionName.getName() + "\n" +
			// HexDump.dump(fImplementationVersionName.toBytes()));
		}

		Iterator<ScpScuRoleSelection> lIterator = this.scpScuRoleSelections
		.iterator();
		while (lIterator.hasNext()) {
			lIterator.next().write(stream);
		}

		// fLogger.debug("Stop writing");
	}

}
