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

package org.dicom4j.network.dimse.codec;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.DicomWriter;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.protocoldataunit.PDataTFPDU;
import org.dicom4j.network.protocoldataunit.ProtocolDataUnits;
import org.dicom4j.network.protocoldataunit.items.PresentationDataValueItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Encode {@link DimseMessage} into {@link PDataTFPDU}(s)
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DimseMessageEncoder {

	/**
	 * Encode a part of the message into a {@link PDataTFPDU PDataTFPDU}. This
	 * methods must be called until isDone return true.
	 * 
	 * @return a part of the message encoded into a PDataTFPDU
	 * @throws Exception
	 */
	/*
	 * public PDataTFPDU encode() throws Exception { try {
	 * fLogger.debug("encode");
	 * 
	 * if (fAssociation.getAssociateSession() == null) { throw new
	 * Exception("DimseMessageEncoder.encode: no Associate Session was opened"); }
	 * 
	 * PDataTFPDU lPDU = new PDataTFPDU();
	 * 
	 * int MAX = (int)fAssociation.getAssociateSession().getMaximumLength();
	 * 
	 * int lCommandLength = fCommandLength-lCommandOffset;
	 * 
	 * if (lCommandOffset < fCommandLength) {
	 * 
	 * if (lCommandLength < MAX) { byte[] lData = new byte[lCommandLength];
	 * lCommandStream.read(lData); PresentationDataValueItem lVal = new
	 * PresentationDataValueItem(fPresentationContextID, true, true, lData);
	 * lPDU.addPresentationDataValueItem(lVal); lCommandOffset+=lCommandLength;
	 * 
	 * if (fDataSetStream == null) fisDone= true; // no more data to put in PData
	 * return lPDU; } else { byte[] lData = new byte[MAX-6];
	 * lCommandStream.read(lData); PresentationDataValueItem lVal = new
	 * PresentationDataValueItem(fPresentationContextID, true, false, lData);
	 * lPDU.addPresentationDataValueItem(lVal); lCommandOffset+=MAX-6; return
	 * lPDU; } }
	 * 
	 * if (fDataSetStream != null) {
	 * 
	 * int lDataSetLength = fDataSetLength-fDataSetOffset;
	 * 
	 * if (lDataSetLength < MAX) { byte[] lData = new byte[lDataSetLength];
	 * fDataSetStream.read(lData); PresentationDataValueItem lVal = new
	 * PresentationDataValueItem(fPresentationContextID, false, true, lData);
	 * lPDU.addPresentationDataValueItem(lVal); fDataSetOffset+=lDataSetLength;
	 * fisDone=true; // no more data to encode return lPDU; } else { byte[] lData
	 * = new byte[MAX-6]; fDataSetStream.read(lData); PresentationDataValueItem
	 * lVal = new PresentationDataValueItem(fPresentationContextID, false, false,
	 * lData); lPDU.addPresentationDataValueItem(lVal); fDataSetOffset+=MAX-6;
	 * return lPDU; } }
	 * 
	 * throw new Exception("shouldn't not arrive"); } catch (Exception e) {
	 * fLogger.error("error while encoding message: " + e.getMessage() ); throw e;
	 * } }
	 */
	// private DimseMessage fMessage;
	// private byte fPresentationContextID;
	// private boolean fisDone;
	// private Association fAssociation;
	/*
	 * private InputStream lCommandStream; private int lCommandOffset; private int
	 * fCommandLength; private InputStream fDataSetStream; private int
	 * fDataSetOffset; private int fDataSetLength;
	 */

	private static Logger logger = LoggerFactory
	.getLogger(DimseMessageEncoder.class);

	/**
	 * Creates new Encoder
	 * 
	 * @param aAssociation
	 *          the Assocation
	 * @param aPresentationContextID
	 *          the presentation Context Id
	 * @param aMessage
	 *          the message to encode
	 * 
	 */
	/*
	 * public DimseMessageEncoder(Association aAssociation, byte
	 * aPresentationContextID, DimseMessage aMessage) throws Exception { super();
	 * fAssociation = aAssociation; fPresentationContextID =
	 * aPresentationContextID; fMessage = aMessage; if (aMessage == null) { throw
	 * new NullArgumentException("DimseMessageEncoder: no message was set"); }
	 * fisDone = false; fLogger.info("Message to encode: " + fMessage.getName() );
	 * if ( fLogger.isDebugEnabled() ) { fLogger.debug("CommandSet: \n" +
	 * fMessage.getCommandSet().toString() ); if (fMessage.getDataSet() != null) {
	 * fLogger.debug("DataSet: \n" + fMessage.getDataSet().toString() ); } }
	 * 
	 * lCommandStream = new
	 * ByteArrayInputStream(DicomWriter.getDataSetToBytes(aMessage
	 * .getCommandSet(), TransferSyntax.ImplicitVRLittleEndian));
	 * lCommandOffset=0; fCommandLength = lCommandStream.available();
	 * 
	 * fDataSetStream=null; fDataSetOffset=0; fDataSetLength=0; if
	 * (aMessage.getDataSet() != null) { TransferSyntax lTransferSyntaxforDataSet
	 * =
	 * fAssociation.getAssociateSession().getTransferSyntax(fPresentationContextID
	 * ); fLogger.info("TransferSyntax for DataSet : " +
	 * lTransferSyntaxforDataSet.getName() ); fDataSetStream = new
	 * ByteArrayInputStream(DicomWriter.getDataSetToBytes(fMessage.getDataSet(),
	 * lTransferSyntaxforDataSet)); fDataSetLength=fDataSetStream.available(); } }
	 */

	/*
	 * 
	 */

	/**
	 * creates new message Encoder
	 */
	public DimseMessageEncoder() {
	}

	/**
	 * return true when the message was encoded into the {@link PDataTFPDU
	 * PDataTFPDU(s)}
	 * 
	 * @return
	 */
	/*
	 * public boolean isDone() { return fisDone; }
	 */

	public synchronized ProtocolDataUnits encode(byte aPresID,
			TransferSyntax aTransferSyntax, DimseMessage aMessage, int aMaximumLength)
	throws Exception {
		if (aMessage == null) {
			throw new DimseMessageEncoderException(
			"DimseMessageEncoder: no message was set");
		}
		if (aTransferSyntax == null) {
			throw new DimseMessageEncoderException(
			"No TransferSyntax set for encoding");
		}
		logger.info("Message to encode: " + aMessage.getName());
		logger.info("TransferSyntax for DataSet : " + aTransferSyntax.getName());
		if (logger.isDebugEnabled()) {
			logger.debug("CommandSet: \n" + aMessage.getCommandSet().toString());
			if (aMessage.getDataSet() != null) {
				logger.debug("DataSet: \n" + aMessage.getDataSet().toString());
			}
		}

		InputStream lCommandStream = new ByteArrayInputStream(DicomWriter
				.getDataSetToBytes(aMessage.getCommandSet(),
						TransferSyntax.ImplicitVRLittleEndian));
		InputStream fDataSetStream = null;
		try {

			int lCommandOffset = 0;
			int fCommandLength = lCommandStream.available();

			int fDataSetOffset = 0;
			int fDataSetLength = 0;
			if (aMessage.getDataSet() != null) {
				fDataSetStream = new ByteArrayInputStream(DicomWriter
						.getDataSetToBytes(aMessage.getDataSet(), aTransferSyntax));
				fDataSetLength = fDataSetStream.available();
			}

			ProtocolDataUnits lPDUs = new ProtocolDataUnits();
			boolean lIsDone = false;

			while (!lIsDone) {
				PDataTFPDU lPDU = new PDataTFPDU();
				int lCommandLength = fCommandLength - lCommandOffset;
				if (lCommandOffset < fCommandLength) {
					if (lCommandLength < aMaximumLength) {
						byte[] lData = new byte[lCommandLength];
						lCommandStream.read(lData);
						PresentationDataValueItem lVal = new PresentationDataValueItem(
								aPresID, true, true, lData);
						lPDU.addPresentationDataValueItem(lVal);
						lCommandOffset += lCommandLength;

						if (fDataSetStream == null) {
							lIsDone = true; // no more data to put in PData
						}
					} else {
						byte[] lData = new byte[aMaximumLength - 6];
						lCommandStream.read(lData);
						PresentationDataValueItem lVal = new PresentationDataValueItem(
								aPresID, true, false, lData);
						lPDU.addPresentationDataValueItem(lVal);
						lCommandOffset += aMaximumLength - 6;
					}

				}

				if (fDataSetStream != null) {

					int lDataSetLength = fDataSetLength - fDataSetOffset;

					if (lDataSetLength < aMaximumLength) {
						byte[] lData = new byte[lDataSetLength];
						fDataSetStream.read(lData);
						PresentationDataValueItem lVal = new PresentationDataValueItem(
								aPresID, false, true, lData);
						lPDU.addPresentationDataValueItem(lVal);
						fDataSetOffset += lDataSetLength;
						lIsDone = true; // no more data to encode
					} else {
						byte[] lData = new byte[aMaximumLength - 6];
						fDataSetStream.read(lData);
						PresentationDataValueItem lVal = new PresentationDataValueItem(
								aPresID, false, false, lData);
						lPDU.addPresentationDataValueItem(lVal);
						fDataSetOffset += aMaximumLength - 6;
					}
				}
				lPDUs.add(lPDU);
			}

			logger.info("Message completely encoded");
			return lPDUs;

		} finally {
			/*
			 * if (lCommandStream != null) IOUtils.closeQuietly(lCommandStream); if
			 * (fDataSetStream != null) IOUtils.closeQuietly(lCommandStream);
			 */
		}
	}
}
