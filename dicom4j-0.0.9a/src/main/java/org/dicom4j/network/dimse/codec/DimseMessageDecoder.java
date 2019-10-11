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

import java.util.LinkedList;
import java.util.ListIterator;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.dicom4j.data.CommandSet;
import org.dicom4j.data.CommandSetType;
import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.CommandSetReader;
import org.dicom4j.io.DicomReader;
import org.dicom4j.network.association.Association;
import org.dicom4j.network.dimse.DimseMessageFactory;
import org.dicom4j.network.dimse.messages.DimseMessage;
import org.dicom4j.network.dimse.messages.support.AbstractDimseMessage;
import org.dicom4j.network.protocoldataunit.PDataTFPDU;
import org.dicom4j.network.protocoldataunit.items.PresentationDataValueItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Decode {@link PDataTFPDU PDataTFPDU(s)} into {@link DimseMessage}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DimseMessageDecoder {

	private static final Logger logger = LoggerFactory.getLogger(DimseMessageDecoder.class);

	private Association association;

	private ByteArrayOutputStream commandReceivedBuffer;

	private ByteArrayOutputStream dataSetReceivedBuffer;

	private DimseMessage message;

	private DimseMessageFactory messageFactory;

	private byte presentationContextID;

	/**
	 * Creates new Decoder
	 * 
	 * @param association
	 */
	public DimseMessageDecoder(Association association,	DimseMessageFactory messageFactory) {
		super();
		this.association = association;
		this.messageFactory = messageFactory;
		this.commandReceivedBuffer = new ByteArrayOutputStream(65000);
		this.dataSetReceivedBuffer = new ByteArrayOutputStream(65000);
		this.clear();
	}

	public void clear() {
		this.presentationContextID = 0;
		this.message = null;
	}

	/**
	 * Decode the PDataPDU
	 * 
	 * @param aPdata
	 *          the PDU to decode
	 * @throws Exception
	 */
	public void decode(PDataTFPDU aPdata) throws Exception {
		try {
			LinkedList<PresentationDataValueItem> pdvList = aPdata.getPresentationDataValues();
			logger.debug("decode: " + pdvList.size() + " element(s) to decode");
			ListIterator<PresentationDataValueItem> i = pdvList.listIterator();
			// We read all PDV(s)
			while (i.hasNext()) {
				PresentationDataValueItem pdv = i.next();
				this.presentationContextID = pdv.getPresentationContextID();
				if (pdv.isCommand()) {
					this.commandReceivedBuffer.write(pdv.getValue());
					if (pdv.isLastFragment()) {
						logger.debug("Last fragment of command seen");
						CommandSet lCommand = new CommandSet();
						CommandSetReader lReader = new CommandSetReader( this.commandReceivedBuffer.toByteArray());
						try {
							lReader.read(lCommand);
						} finally {
							lReader.close();
						}
						this.decodeCommand(lCommand); // handle the command
						this.commandReceivedBuffer.close();
						this.commandReceivedBuffer = new ByteArrayOutputStream(1024); // clear
						// buffer
					}
				} else {
					this.dataSetReceivedBuffer.write(pdv.getValue());
					// fLogger.debug("OK");
					logger.debug("size: " + this.dataSetReceivedBuffer.size());
					if (pdv.isLastFragment()) {
						logger.debug("Last fragment of Dataset seen");
						TransferSyntax lTransfertSyntax = new TransferSyntax(this
								.getAssociation().getTransferSyntaxFromPresentationID(
										pdv.getPresentationContextID()));
						DataSet lDataset = new DataSet();
						DicomReader lReader = new DicomReader(this.dataSetReceivedBuffer
								.toByteArray());
						try {
							lReader.read(lDataset, lTransfertSyntax);
						} finally {
							lReader.close();
						}
						this.decodeDataSet(lDataset);
						this.dataSetReceivedBuffer.close();
						this.dataSetReceivedBuffer = new ByteArrayOutputStream(1024); // clear
						// buffer
					}
				}
			}

			// we read a complete Dimse message
			if (this.isDone()) {
				if (logger.isDebugEnabled()) {
					logger.debug("decoded message: \n"
							+ this.getDecodedMessage().toString());
				}
				logger.info("Message decoded: " + this.getDecodedMessage().getName());
			}
		} catch (Throwable e) {
			throw new DimseMessageDecoderException(e.getMessage(), e);
		}
	}

	protected void decodeCommand(CommandSet aCommandDataSet) throws Exception {
		assert aCommandDataSet != null;
		String lType = CommandSetType.toString(aCommandDataSet.getCommandField());
		logger.debug("decodeCommand, message: " + lType);
		this.message = this.getMessageFactory().newMessage(aCommandDataSet);
		if (this.message == null) {
			throw new DimseMessageDecoderException("unable to get a message for "
					+ lType);
		}
	}

	protected void decodeDataSet(DataSet aDataSet) throws Exception {
		assert aDataSet != null;
		logger.debug("DataSet decoded"); // : \n" + aDataSet.toString());
		if (this.message == null) {
			throw new Exception("DataSet without Command");
		}
		if (!this.message.getCommandSet().hasDataSet()) {
			throw new DimseMessageDecoderException(
			"the CommandSet doesn't have a DataSet");
		}

		this.message.setDataSet(aDataSet);

	}

	public Association getAssociation() {
		assert this.association != null;
		return this.association;
	}

	public AbstractDimseMessage getDecodedMessage() throws Exception {
		if (!this.isDone()) {
			throw new Exception(
			"Unabled to return the decoded message, all PDU(s) haven't been readed ");
		}
		return (AbstractDimseMessage) this.message;
	}

	protected DimseMessageFactory getMessageFactory() {
		return this.messageFactory;
	}

	public byte getPresentationContextID() {
		return this.presentationContextID;
	}

	/**
	 * Return true if all PDataPDU of a Dimse Message has been read
	 * 
	 * @return
	 */
	public boolean isDone() {
		boolean lResult = false;
		if (this.message != null) {
			if (this.message.getCommandSet().hasDataSet()) {
				lResult = this.message.getDataSet() != null;
			} else {
				lResult = true;
			}
		}
		// fLogger.debug("isDone : " + Boolean.toString(lResult));
		return lResult;
	}

}
