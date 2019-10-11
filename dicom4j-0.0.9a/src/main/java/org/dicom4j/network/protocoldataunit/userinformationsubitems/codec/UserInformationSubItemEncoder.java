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
package org.dicom4j.network.protocoldataunit.userinformationsubitems.codec;

import java.nio.ByteOrder;
import java.util.Iterator;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.BinaryOutputStream;
import org.dicom4j.network.protocoldataunit.codec.ProtocolDataUnitEncoderException;
import org.dicom4j.network.protocoldataunit.items.UserInformationItem;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.ScpScuRoleSelection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @since 0.1
 * @since 12 oct. 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class UserInformationSubItemEncoder {

	private static final Logger logger = LoggerFactory
	.getLogger(UserInformationSubItemEncoder.class);

	private static final long serialVersionUID = 1L;

	public void encode(UserInformationItem item, BinaryOutputStream stream)
	throws ProtocolDataUnitEncoderException {
		try {
			if (item == null) {
				throw new ProtocolDataUnitEncoderException("can't encode a null PDU");
			}
			logger.info("encode of " + item.getName() + " requested");
			logger.debug("UserInformationItem to encode :" + item.toString());
			if (stream.getByteOrder() != ByteOrder.BIG_ENDIAN) {
				throw new DicomException("the stream must be in BIG_ENDIAN");
			}
			stream.write(item.getType().value());
			stream.write(0); // reserved
			stream.writeUnsigned16(item.getLength() - 4);

			if (item.getMaximumLengthSubItem() != null) {
				item.getMaximumLengthSubItem().write(stream);
				logger.debug("MaximumLengthSubItem encoded");
			}
			if (item.getImplementationClassUIDSubItem() != null) {
				item.getImplementationClassUIDSubItem().write(stream);
				logger.debug("ImplementationClassUID encoded");
			}
			if (item.getImplementationVersionNameSubItem() != null) {
				item.getImplementationVersionNameSubItem().write(stream);
				logger.debug("ImplementationVersionName encoded");
			}
			if (item.getAsynchronousOperationsWindow() != null) {
				item.getAsynchronousOperationsWindow().write(stream);
				logger.debug(item.getAsynchronousOperationsWindow() + " encoded");
			}
			Iterator<ScpScuRoleSelection> lIterator = item
			.getScpScuRoleSelectionIterator();
			while (lIterator.hasNext()) {
				ScpScuRoleSelection role = lIterator.next();
				role.write(stream);
				logger.debug(role.toString() + " encoded");
			}
			/*
			 * if (implementationClassUID != null) {
			 * //implementationClassUID.write(aStream); // fLogger.info("write: " +
			 * fImplementationClassUID.getName() + "\n" + //
			 * HexDump.dump(fImplementationClassUID.toBytes())); }
			 * 
			 * if (implementationVersionName != null) {
			 * //implementationVersionName.write(aStream); // fLogger.info("write: " +
			 * fImplementationVersionName.getName() + "\n" + //
			 * HexDump.dump(fImplementationVersionName.toBytes())); } if
			 * (asynchronousOperationsWindow != null) {
			 * //asynchronousOperationsWindow.write(aStream); //
			 * fLogger.info("write: " + fImplementationVersionName.getName() + "\n" +
			 * // HexDump.dump(fImplementationVersionName.toBytes())); }
			 */

			/*
			 * Iterator<ScpScuRoleSelection> lIterator =
			 * scpScuRoleSelections.iterator(); while (lIterator.hasNext()) {
			 * lIterator.next().write(aStream); }
			 */

			// ArrayList<byte>
			// ByteArray = ne
			// item.write(stream);
			/*
			 * logger.debug("trying to encode " + aPDU.getName() + " PDU");
			 * aPDU.write(new BinaryOutputStream(aStream, ByteOrder.BIG_ENDIAN));
			 * logger.debug("encoded " + aPDU.getName() + "\n" +
			 * HexaDecimalUtils.dump(aStream.toByteArray()));
			 * logger.info(aPDU.getName() + "PDU(s) correctly encoded");
			 */
		} catch (Exception e) {
			throw new ProtocolDataUnitEncoderException(
					"errors occurs while encoding a ProtocolDataUnit", e);
		}
	}

}
