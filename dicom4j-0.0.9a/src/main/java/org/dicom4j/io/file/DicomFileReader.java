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

package org.dicom4j.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.FileMetaInformation;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.TransferSyntaxFactory;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.DicomReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * A specialized {@link DicomReader} to read DICOM Files.
 * <p>
 * <p>
 * This class add specialized methods to manage the{@link FileMetaInformation}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomFileReader extends DicomReader {

	private static Logger logger = LoggerFactory.getLogger(DicomFileReader.class);

	private TransferSyntaxFactory tsFactory = new TransferSyntaxFactory();

	/**
	 * Creates a new DicomReader
	 * 
	 * @param aBytes
	 *          the bytes to read from
	 */
	public DicomFileReader(byte[] aBytes) {
		super(aBytes);
	}

	/**
	 * Creates a new DicomFileReader
	 * 
	 * @param File
	 *          the file to read
	 * @exception FileNotFoundException
	 */

	public DicomFileReader(File aFile) throws FileNotFoundException {
		this(new FileInputStream(aFile));
	}

	/**
	 * Creates a new DicomReader
	 * 
	 * @param aInputStream
	 *          the stream to read from
	 */
	public DicomFileReader(InputStream aInputStream) {
		super(aInputStream);
	}

	/**
	 * Creates a new DicomFileReader
	 * 
	 * @param aPathName
	 *          the pathname of the file to read
	 * @exception FileNotFoundException
	 */
	public DicomFileReader(String aPathName) throws FileNotFoundException {
		this(new File(aPathName));
	}

	public TransferSyntaxFactory getTsFactory() {
		return this.tsFactory;
	}

	/**
	 * return true if the stream contains {@link FileMetaInformation
	 * FileMetaInformation}
	 * 
	 * @return true if have FileMetaInformation
	 * @throws IOException
	 * @throws DicomException
	 */
	public boolean hasFileMetaInformation() throws IOException, DicomException {
		boolean lResult = false;
		this.fInputStream.mark(0);
		try {
			if (this.fInputStream.available() > FileMetaInformation.PREAMBLE_LENGTH
					+ FileMetaInformation.DicomPrefix.length()) {
				this.fInputStream.skip(FileMetaInformation.PREAMBLE_LENGTH);
				String lPrefix = this.fInputStream
				.readASCII(FileMetaInformation.DicomPrefix.length());
				if (lPrefix.equals(FileMetaInformation.DicomPrefix)) {
					lResult = true; // if true it's a DICOM PS 3.10 file
				}
			}
		} finally {
			this.fInputStream.reset();
		}
		logger.info("hasFileMetaInformation: " + lResult);
		return lResult;
	}

	/**
	 * Read the FileMetaInformation and the DataSet of a DICOM File. </br> The
	 * TransferSyntax to use for the DataSet will depend of the
	 * FileMetaInformation. before reading FileMetaInformation and DataSet are
	 * cleared
	 * 
	 * @param aFileMetaInformation
	 *          the FileMetaInformation where to add read data (can be null)
	 * @param aDataSet
	 *          the DataSet where to add read data
	 * @throws IOException
	 * @throws DicomException
	 */
	public void readFile(FileMetaInformation aFileMetaInformation,
			DataSet aDataSet) throws IOException, DicomException, Exception {
		FileMetaInformation lFileMetaInformation;
		if (aFileMetaInformation != null) {
			lFileMetaInformation = aFileMetaInformation;
			lFileMetaInformation.removeAll();
		} else {
			lFileMetaInformation = new FileMetaInformation();
		}
		assert aDataSet != null;
		aDataSet.removeAll();

		TransferSyntax lTransferSyntax = this.tsFactory
		.getDefaultDicomTransferSyntax();

		// if have a FileMetaInformation, we read it
		if (this.hasFileMetaInformation()) {
			this.readFileMetaInformation(lFileMetaInformation, false);
			if (lFileMetaInformation.hasElement(DicomTags.TransferSyntaxUID)) {
				UniqueIdentifier lElement = lFileMetaInformation
				.getUniqueIdentifier(DicomTags.TransferSyntaxUID);
				String tsUID = lElement.getSingleStringValue().trim();
				logger.debug("FileMetaInformation has TransferSyntaxUID: " + tsUID);
				lTransferSyntax = this.getTsFactory().newTransferSyntax(tsUID);
				if (lTransferSyntax == null) {
					throw new DicomException("TransferSyntax " + tsUID
							+ " is not supported");
				} else {
					logger.info("TransferSyntax: " + lTransferSyntax.getName());
				}
			} else {
				logger.warn("No TransferSyntaxUID in FileMetaInformation");
			}
		}
		super.read(aDataSet, lTransferSyntax);
	}

	/**
	 * Read the FileMetaInformation of a DICOM File. <br>
	 * the Stream is always rewinded after the reading
	 * 
	 * @param aFileMetaInformation
	 *          the FileMetaInformation where to add read data
	 * @throws IOException
	 * @throws DicomException
	 */
	public void readFileMetaInformation(FileMetaInformation aFileMetaInformation)
	throws IOException, DicomException, Exception {
		this.readFileMetaInformation(aFileMetaInformation, true);
	}

	protected void readFileMetaInformation(
			FileMetaInformation aFileMetaInformation, boolean aRewindAfter)
	throws IOException, DicomException, Exception {
		logger.info("readFileMetaInformation (aRewindAfter: " + aRewindAfter
				+ ",TransferSyntax: " + TransferSyntax.ExplicitVRLittleEndian.getName()
				+ ")");
		this.fInputStream.mark(0);
		try {
			this.fInputStream
			.setTransferSyntax(TransferSyntax.ExplicitVRLittleEndian);
			byte[] lpreambule = new byte[FileMetaInformation.PREAMBLE_LENGTH];
			this.fInputStream.read(lpreambule);
			String lPrefix = this.fInputStream
			.readASCII(FileMetaInformation.DicomPrefix.length());
			logger.debug("prefix readed");
			// if true it's a DICOM PS 3.10 file
			if (lPrefix.equals(FileMetaInformation.DicomPrefix)) {
				aFileMetaInformation.setPreambule(lpreambule);
				this.fByteOffset = 128 + 4; // we must count preamble and DicomPrefix
				this.read(aFileMetaInformation, 0xffffffffl, true, null, null);
			}
			if (logger.isDebugEnabled()) {
				logger.debug("FileMetaInformation: " + aFileMetaInformation.toString());
			}
			logger.info("readFileMetaInformation (number of Elements: "
					+ aFileMetaInformation.count() + ")");
		} finally {
			if (aRewindAfter) {
				this.fInputStream.reset();
			}
		}
	}

	public void setTsFactory(TransferSyntaxFactory tsFactory) {
		assert (tsFactory != null);
		this.tsFactory = tsFactory;
	}

}
