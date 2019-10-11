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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.FileMetaInformation;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.DicomWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Specialized {@link DicomWriter} to write Dicom Files.
 * <p>
 * </br> This class add specialized methods and behavior to manage the
 * {@link FileMetaInformation} of DICOM files
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomFileWriter extends DicomWriter {

	/**
	 * the Logger
	 */
	private static final Logger logger = LoggerFactory
	.getLogger(DicomFileWriter.class);

	/**
	 * Creates a new DicomFileWriter
	 * 
	 * @param File
	 *          the file to read
	 * @exception FileNotFoundException
	 */

	public DicomFileWriter(File aFile) throws FileNotFoundException {
		this(new FileOutputStream(aFile, true)); // true: write append at the end
		// of the stream
	}

	/**
	 * Creates a new DicomFileWriter
	 * 
	 * @param aStream
	 *          the stream to write to
	 */
	public DicomFileWriter(OutputStream aStream) {
		super(aStream);
	}

	/**
	 * Creates a new DicomFileWriter
	 * 
	 * @param aPathName
	 *          the pathname of the file to read
	 * @exception FileNotFoundException
	 */
	public DicomFileWriter(String aPathName) throws FileNotFoundException {
		this(new File(aPathName));
	}

	/**
	 * Write a {@link org.dicom4j.data.FileMetaInformation FileMetaInformation}
	 * and a
	 * 
	 * @param fileMetaInformation
	 *          the FileMetaInformation to write
	 * @throws IOException
	 * @throws DicomException
	 */
	public void write(FileMetaInformation fileMetaInformation, DataSet aDataSet)
	throws IOException, DicomException {
		this.writeFileMetaInformation(fileMetaInformation);
		this.write(aDataSet);
	}

	public void write(FileMetaInformation aFileMetaInformation, DataSet aDataSet,
			TransferSyntax aTransferSyntax) throws IOException, DicomException {
		this.writeFileMetaInformation(aFileMetaInformation);
		this.write(aDataSet, aTransferSyntax);
	}

	/**
	 * Write a {@link org.dicom4j.data.FileMetaInformation FileMetaInformation}
	 * 
	 * @param aFileMetaInformation
	 *          the FileMetaInformation to write
	 * @throws IOException
	 * @throws DicomException
	 */
	public void writeFileMetaInformation(FileMetaInformation aFileMetaInformation)
	throws IOException, DicomException {
		assert (aFileMetaInformation != null);
		logger.debug("writeFileMetaInformation:" + aFileMetaInformation.count()
				+ " item(s)");
		if (aFileMetaInformation.count() != 0) {
			this.getStream().write(aFileMetaInformation.getPreambule());
			this.getStream().write(FileMetaInformation.DicomPrefix.getBytes());
			this.write(aFileMetaInformation, TransferSyntax.ExplicitVRLittleEndian);
			this.getStream().flush();
		}
	}
}
