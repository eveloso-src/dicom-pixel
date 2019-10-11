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

package org.dicom4j.io;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.UnsignedLong;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Writer used to insert a {@link DataSet} into a stream.
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomWriter {

	/**
	 * the logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DicomWriter.class);

	/**
	 * Convert a DataSet into an array of bytes
	 * 
	 * @param aDataSet
	 *          the Dataset
	 * @param aTransferSyntax
	 *          the TransferSyntax to use
	 * @return the Dataset as array of bytes
	 * @throws IOException
	 * @throws DicomException
	 */
	public static byte[] getDataSetToBytes(DataSet aDataSet,
			TransferSyntax aTransferSyntax) throws IOException, DicomException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try {
			DicomWriter lWriter = new DicomWriter(bout);
			try {
				lWriter.write(aDataSet, aTransferSyntax);
				return bout.toByteArray();
			} finally {
				lWriter.close();
			}
		} finally {
			bout.close();
		}
	}

	/**
	 * The Stream to write to
	 */
	private DicomOutputStream stream;

	/**
	 * Creates a new writer
	 * 
	 * @param stream the stream to write
	 */
	public DicomWriter(OutputStream stream) {
		super();
		assert stream != null;
		this.stream = new DicomOutputStream(new BufferedOutputStream(stream));
	}

	public void close() {
		try {
			this.stream.close();
		} catch (Exception e) {
			logger.warn(e.getMessage());
		}
	}

	/**
	 * Read all DataElement to compute the value of the GroupLength
	 * 
	 * @param groupLength
	 * @param isExplicitVR
	 * @throws DicomException
	 */
	protected void computeGroupLength(DataSet aDataSet, UnsignedLong groupLength, boolean isExplicitVR) throws DicomException {
		try {
			// Group Length depend of how many elements there are for DataElement of
			// the same Group.
			// we can count length by adding Tag group + tag element + VR(if explicit)
			// + VL(depending of the VR) + padded value. for each DataElement
			// We shouldn't count the GroupLength Data Element
			groupLength.setValue(0); // must init otherwise getPaddedVL return 0
			long Result = 0;
			long VRLength;
			if (isExplicitVR) {
				VRLength = 2;
			} else {
				VRLength = 0; // no VR
			}
			for (int i = 0; i < aDataSet.count(); i++) {
				DataElement element = aDataSet.getAttribute(i);

				// if it's the same Group of the Grouplength
				if (element.getTag().getGroup() == groupLength.getTag().getGroup()) {

					// if not the GroupLength Data Element
					if (element.getTag().getElement() != 0) {

						// we compute the length of VL is bytes (depending or TS and VR)
						long lVLLength = 0;
						if (isExplicitVR) {
							if (ValueRepresentation.isShortValueLengthVR(element
									.getValueRepresentation().toBytes())) {
								lVLLength = 2;
							} else {
								lVLLength = 6;
							}
						} else {
							lVLLength = 4;
						}
						// Tag group (2) + tag element (2) + VR (2) + VL (2 or 4 or 6) + the
						// length of Data
						Result = Result + 2 + 2 + VRLength + lVLLength
						+ aDataSet.getAttribute(i).getPaddedVL();
					}
				}
			}
			groupLength.setValue(Result);
		} catch (Exception e) {
			throw new DicomException(e.getMessage());
		}

	}

	/**
	 * write a DataSet into the stream
	 * 
	 * @param aDataSet
	 *          the DataSet to write
	 * @param aTransferSyntax
	 *          the TransferSyntax to use
	 * @throws IOException
	 * @throws DicomException
	 */
	protected void doWrite(DataSet aDataSet, TransferSyntax aTransferSyntax)
	throws IOException, DicomException {
		assert aDataSet != null;
		if (aTransferSyntax != null) {
			this.stream.setTransferSyntax(aTransferSyntax);
		}
		logger.info("Start writing a DataSet, " + aDataSet.count()
				+ " element(s) to write (TransferSyntax: "
				+ this.stream.getTransferSyntax().getName() + ")");
		for (int i = 0; i < aDataSet.count(); i++) {
			DataElement lDataElement = aDataSet.getAttribute(i);
			if (DataElement.isGroupLength(lDataElement)) {
				if (lDataElement instanceof UnsignedLong) {
					this.computeGroupLength(aDataSet, (UnsignedLong) lDataElement,
							aTransferSyntax.isExplicitVR());
				} else {
					logger
					.warn("can't compute Group Length the element is not a UnsignedLong");
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug("we must write: " + lDataElement.toString());
			}
			lDataElement.write(this.stream);
			logger.debug("write ok");
			this.stream.flush();
			logger.debug("flush ok");
		}
		logger.info("Stop writing");
	}

	/**
	 * return the stream
	 * 
	 * @return the stream
	 */
	public OutputStream getStream() {
		return this.stream;
	}

	/**
	 * insert data of the {@link DataSet}using the default DICOM TransferSyntax
	 * (Implicit VR Little Endian)
	 * 
	 * @param aDataSet
	 *          the DataSet to write
	 * @throws IOException
	 * @throws DicomException
	 */
	public void write(DataSet aDataSet) throws IOException, DicomException {
		this.doWrite(aDataSet, TransferSyntax.Default);
	}

	/**
	 * insert data of the Dataset using the supplied DICOM TransferSyntax
	 * 
	 * @param aDataSet
	 *          the DataSet to insert
	 * @param aTransferSyntax
	 *          the TransferSyntax to use
	 * @throws IOException
	 * @throws DicomException
	 */
	public void write(DataSet aDataSet, TransferSyntax aTransferSyntax)
	throws IOException, DicomException {
		this.doWrite(aDataSet, aTransferSyntax);
	}

}
