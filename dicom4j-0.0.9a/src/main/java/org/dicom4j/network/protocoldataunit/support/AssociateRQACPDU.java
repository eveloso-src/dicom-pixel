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

package org.dicom4j.network.protocoldataunit.support;

import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import org.dicom4j.core.Dicom4j;
import org.dicom4j.dicom.DicomConst;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.AssociateRJPDU;
import org.dicom4j.network.protocoldataunit.items.ApplicationContextItem;
import org.dicom4j.network.protocoldataunit.items.PresentationContexRequestItem;
import org.dicom4j.network.protocoldataunit.items.PresentationContextItemAC;
import org.dicom4j.network.protocoldataunit.items.ProtocolDataUnitItemType;
import org.dicom4j.network.protocoldataunit.items.UserInformationItem;
import org.dicom4j.network.protocoldataunit.pdu.AssociateRQPDU;
import org.dolmen.core.lang.HexaDecimalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class for {@link AssociateRQPDU} and {@link AssociateRJPDU}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AssociateRQACPDU extends AbstractProtocolDataUnit {

	private static Logger logger = LoggerFactory.getLogger(AssociateRQACPDU.class);

	/**
	 * write the supplied aet into the stream
	 * 
	 * @param stream
	 *          the stream to write
	 * @param aet
	 *          the aet to write
	 * @param name
	 * @exception DicomException
	 */
	private static void writeAETToPDU(BinaryOutputStream stream, String aet) throws DicomException, IOException {
		// ApplicationEntity.checkIfValid(aet);
		byte[] baet = aet.getBytes("ASCII");
		int baetl = baet.length;
		stream.write(baet, 0, baetl);
		while (baetl++ < 16) {
			stream.write(0x20);
		}
	}

	private ApplicationContextItem applicationContextItem;

	private String calledAET;

	private String callingAET;

	protected int internalLength;

	protected LinkedList<AbstractPresentationContextItem> items;

	private int protocolVersion;

	private UserInformationItem userInformationItem;

	protected AssociateRQACPDU() {
		this("", "");
	}

	protected AssociateRQACPDU(String aCalledAETitle, String aCallingAETitle) {
		super();
		this.items = new LinkedList<AbstractPresentationContextItem>();
		this.userInformationItem = new UserInformationItem();
		this.setCalledAET(aCalledAETitle);
		this.setCallingAET(aCallingAETitle);
		this.protocolVersion = 1;
	}

	/**
	 * return the ApplicationContextItem
	 * 
	 * @return the ApplicationContextItem
	 */
	public ApplicationContextItem getApplicationContextItem() {
		return this.applicationContextItem;
	}

	public String getCalledAETitle() {
		return this.calledAET;
	}

	public String getCallingAETitle() {
		return this.callingAET;
	}

	protected int getInternalLength() {
		return this.internalLength;
	}

	public LinkedList<AbstractPresentationContextItem> getItems() {
		return this.items;
	}

	@Override
	public int getLength() {
		// 74:
		// Type(1)+reserved(1)+length(4)+Protocol
		// Version(2)+reserved(2)+called(16)+calling(16)+reserved(32)
		int Result = 74;
		if (this.applicationContextItem != null) {
			Result += this.applicationContextItem.getLength();
		}
		Iterator<AbstractPresentationContextItem> i = this.getPresentationIterator(); 
		while (i.hasNext()) {
			Result += i.next().getLength();
		}
		if (this.userInformationItem != null) {
			Result += this.userInformationItem.getLength();
		}
		return Result;
	}

	public Iterator<AbstractPresentationContextItem> getPresentationIterator() {
		return this.items.iterator();
	}

	public int getProtocolVersion() {
		return this.protocolVersion;
	}

	public UserInformationItem getUserInformationItem() {
		return this.userInformationItem;
	}

	@Override
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException {
		logger.debug("we must read " + length + " bytes ");
		this.internalLength = length;
		this.protocolVersion = stream.readUnsigned16();
		logger.debug("ProtocolVersion: " + this.protocolVersion);
		this.skip(stream, 2); // we skip reserved
		this.setCalledAET(stream.readASCII(16));
		logger.debug("CalledAETitle: " + this.getCalledAETitle().trim());
		this.setCallingAET(stream.readASCII(16));
		logger.debug("CallingAETitle: " + this.getCallingAETitle().trim());
		this.skip(stream, 32); // we must skip reserved
		this.items = new LinkedList<AbstractPresentationContextItem>();
		int offset = 74; // we already read 74 bytes
		// we read the rest of PDU until we arrive at the end
		while (offset < this.getInternalLength()) {
			byte itemType = stream.readByte();
			if (itemType == -1) {
				logger.debug("end of stream reached, no more items to read");
				break;
			}
			logger.debug("Item type: " + ProtocolDataUnitItemType.toString(itemType));
			if (itemType == ProtocolDataUnitItemType.APPLICATION_CONTEXT.value()) {
				this.applicationContextItem = new ApplicationContextItem(stream);
				logger.info("read: " + this.applicationContextItem.getName() + "\n"
						+ HexaDecimalUtils.dump(this.applicationContextItem.toBytes()));
				offset += this.applicationContextItem.getLength();
				logger.debug("ApplicationContextItem correctly readed");
			} else if (itemType == ProtocolDataUnitItemType.PRESENTATION_CONTEXT_AC
					.value()) {
				PresentationContextItemAC item = new PresentationContextItemAC();// stream);
				item.setTransferSyntaxRegistry(this.getTransferSyntaxRegistry());
				item.read(stream, 0);
				this.items.add(item);
				// fLogger.info("read: " + fPresentationContextItems.getName() +"\n" +
				// HexDump.dump(fPresentationContextItems.toBytes()) );
				offset += item.getLength();
				logger.debug("PresentationContextItemAC correctly readed");
			} else if (itemType == ProtocolDataUnitItemType.PRESENTATION_CONTEXT_RQ
					.value()) {
				PresentationContexRequestItem lItem = new PresentationContexRequestItem(
						stream);
				this.items.add(lItem);
				offset += lItem.getLength();
				logger.debug("PresentationContextItemRQ correctly readed");
			} else if (itemType == ProtocolDataUnitItemType.USER_INFORMATION.value()) {
				this.skip(stream, 1); // We must skip the first reserved byte
				int llength = stream.readUnsigned16();
				this.userInformationItem = new UserInformationItem();
				this.userInformationItem.read(stream, llength); //
				offset += this.userInformationItem.getLength();
				logger.debug("UserInformationItem correctly readed");
			} else {
				logger.error("Unrecognized Item Type : "
						+ Integer.toHexString(itemType));
				throw new DicomException("Unrecognized Item Type: "
						+ Integer.toHexString(itemType));
			}
		}
	}

	public void setApplicationContext(String aApplicationContext) {
		this.applicationContextItem = new ApplicationContextItem(
				aApplicationContext);
	}

	public void setApplicationContextItem(ApplicationContextItem aItem) {
		assert aItem != null;
		this.applicationContextItem = aItem;
	}

	public void setCalledAET(String aCalledAET) {
		this.calledAET = aCalledAET;
	}

	public void setCallingAET(String aCallingAET) {
		this.callingAET = aCallingAET;
	}

	public void setDefautValues() {
		this.setApplicationContext(DicomConst.applicationContextName); // Default
		// ApplicationContext
		this.setUserInformations(65000, Dicom4j.CLASS_UID, Dicom4j.VERSION_NAME
				+ " - " + Dicom4j.VERSION);
	}

	public void setUserInformationItem(UserInformationItem userInformationItem) {
		this.userInformationItem = userInformationItem;
	}

	public void setUserInformations(long aMaximumLength,
			String ImplementationUID, String ImplementationVersion) {
		assert this.userInformationItem != null;
		this.userInformationItem.setMaximumLength(aMaximumLength);
		this.userInformationItem.setImplementationClassUID(ImplementationUID);
		this.userInformationItem
		.setImplementationVersionName(ImplementationVersion);
	}

	/***/
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getName() + ": \n");
		sb.append("Protocol Version: " + this.getProtocolVersion() + "\n");
		sb.append("Called AET: " + this.getCalledAETitle().trim() + "\n");
		sb.append("Calling AET: " + this.getCallingAETitle().trim() + "\n");
		sb.append(this.applicationContextItem + "\n");

		sb.append(this.userInformationItem + "\n");

		if (this.items != null) {
			for (AbstractPresentationContextItem lcurrentItem : this.items) {
				sb.append(lcurrentItem.toString());
			}
		}
		return sb.toString();
	}

	@Override
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException {
		if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
			throw new DicomException("the stream must be in BIG_ENDIAN");
		}
		stream.write(this.getType().value());
		stream.write(0x00); // reserved
		stream.writeUnsigned32(this.getLength() - 6);

		stream.writeUnsigned16(this.protocolVersion);
		stream.write(0x00); // reserved
		stream.write(0x00); // reserved

		writeAETToPDU(stream, this.getCalledAETitle());
		writeAETToPDU(stream, this.getCallingAETitle());

		for (int i = 0; i < 32; ++i) {
			stream.write(0x00); // reserved
		}

		if (this.applicationContextItem != null) {
			this.applicationContextItem.write(stream);
		}

		ListIterator<AbstractPresentationContextItem> i = this.items.listIterator();
		while (i.hasNext()) {
			i.next().write(stream);
		}

		if (this.userInformationItem != null) {
			this.userInformationItem.write(stream);
		}
	}
}
