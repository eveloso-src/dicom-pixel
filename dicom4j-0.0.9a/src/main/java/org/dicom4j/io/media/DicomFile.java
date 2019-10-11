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

package org.dicom4j.io.media;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dicom4j.core.registry.NotFoundRegistryException;
import org.dicom4j.data.DataSet;
import org.dicom4j.data.FileMetaInformation;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.TransferSyntaxFactory;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.io.file.DicomFileReader;
import org.dicom4j.io.file.DicomFileWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Read/Write DICOM files stored on a FileSystem (extends the java's File by
 * adding specifics methods for Dicom files)
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomFile {

	/**
	 * the Logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(DicomFile.class);

	private static final long serialVersionUID = 1L;

	/**
	 * the DataSet which contains data
	 */
	private DataSet dataset;

	private File file;

	/**
	 * the File Meta Information
	 */
	private FileMetaInformation fileMetaInformation;

	/**
	 * the specific Files reader
	 */
	private DicomFileReader reader;

	private TransferSyntaxFactory transferSyntaxFactory;

	private TransferSyntaxRegistry transferSyntaxRegistry;

	/**
	 * creates a new file
	 * 
	 * @param aFile
	 *          the File
	 */
	public DicomFile(File aFile) {
		this(aFile.getAbsolutePath());
	}

	/**
	 * creates a new file
	 * 
	 * @param pathname
	 *          the AbsolutePath
	 */
	public DicomFile(String pathname) {
		super();
		this.file = new File(pathname);
		this.dataset = new DataSet();
		this.fileMetaInformation = new FileMetaInformation(false);
		this.transferSyntaxFactory = new TransferSyntaxFactory();
		this.setTransferSyntaxRegistry(new TransferSyntaxRegistry());
	}

	/**
	 * @return
	 * @see java.io.File#canRead()
	 */
	public boolean canRead() {
		return this.file.canRead();
	}

	/**
	 * @return
	 * @see java.io.File#canWrite()
	 */
	public boolean canWrite() {
		return this.file.canWrite();
	}

	public void close() throws IOException, DicomException {
		logger.debug("close (path" + this.getAbsolutePath() + ")");
		this.fileMetaInformation.removeAll();
		this.dataset.removeAll();
		if (this.reader != null) {
			this.reader.close();
			this.reader = null;
		} else {
			logger.warn("Close without open");
		}
		logger.info("File closed");
	}

	public boolean containFileMetaInformation() {
		return this.fileMetaInformation.count() != 0;
	}

	/**
	 * @return
	 * @see java.io.File#delete()
	 */
	public boolean delete() {
		return this.file.delete();
	}

	/**
	 * @return
	 * @see java.io.File#exists()
	 */
	public boolean exists() {
		return this.file.exists();
	}

	/**
	 * @return
	 * @see java.io.File#getAbsoluteFile()
	 */
	public File getAbsoluteFile() {
		return this.file.getAbsoluteFile();
	}

	/**
	 * @return
	 * @see java.io.File#getAbsolutePath()
	 */
	public String getAbsolutePath() {
		return this.file.getAbsolutePath();
	}

	/**
	 * @return
	 * @throws IOException
	 * @see java.io.File#getCanonicalFile()
	 */
	public File getCanonicalFile() throws IOException {
		return this.file.getCanonicalFile();
	}

	/**
	 * @return
	 * @throws IOException
	 * @see java.io.File#getCanonicalPath()
	 */
	public String getCanonicalPath() throws IOException {
		return this.file.getCanonicalPath();
	}

	/**
	 * Return the {@link DataSet}
	 * 
	 * @return the DataSet
	 */
	public DataSet getDataset() {
		return this.dataset;
	}

	/**
	 * Return the {@link FileMetaInformation}
	 * 
	 * @return the FileMetaInformation
	 */
	public FileMetaInformation getFileMetaInformation() {
		return this.fileMetaInformation;
	}

	/**
	 * @return
	 * @see java.io.File#getName()
	 */
	public String getName() {
		return this.file.getName();
	}

	/**
	 * @return
	 * @see java.io.File#getPath()
	 */
	public String getPath() {
		return this.file.getPath();
	}

	protected TransferSyntax getTransferSyntax() throws NotFoundRegistryException {
		if (this.getFileMetaInformation().hasTransferSyntaxUIDElement()) {
			logger.info("FileMetaInformation has Transfer Syntax UID Element");
			return this.getTransferSyntaxRegistry().getByUID(
					this.getFileMetaInformation().getTransferSyntaxUID());
		} else {
			return null;
		}
	}

	/**
	 * return the current factory
	 * 
	 * @return
	 */
	public TransferSyntaxFactory getTransferSyntaxFactory() {
		return this.transferSyntaxFactory;
	}

	/**
	 * @return Returns the transferSyntaxRegistry.
	 */
	public TransferSyntaxRegistry getTransferSyntaxRegistry() {
		return this.transferSyntaxRegistry;
	}

	/**
	 * @return
	 * @see java.io.File#isAbsolute()
	 */
	public boolean isAbsolute() {
		return this.file.isAbsolute();
	}

	/**
	 * Check is the file is open. If the file was not open, getDataSet will return
	 * an empty DataSet
	 * 
	 * @return true if open
	 */
	public boolean isOpen() {
		return this.reader != null;
	}

	/**
	 * @return
	 * @see java.io.File#lastModified()
	 */
	public long lastModified() {
		return this.file.lastModified();
	}

	/**
	 * @return the file's length
	 * 
	 * @see java.io.File#length()
	 */
	public long length() {
		return this.file.length();
	}

	/**
	 * Open the File
	 * 
	 * @throws IOException
	 * @throws DicomException
	 */
	public void open() throws IOException, DicomException, Exception {
		logger.debug("open (path" + this.getAbsolutePath() + ")");
		if (this.isOpen()) {
			this.close();
		}
		this.reader = new DicomFileReader(this.file);
		this.reader.readFile(this.fileMetaInformation, this.dataset);
		logger.info("File opened");
	}

	/**
	 * @param dest
	 * @return
	 * @see java.io.File#renameTo(java.io.File)
	 */
	public boolean renameTo(File dest) {
		return this.file.renameTo(dest);
	}

	/**
	 * save the DataSet
	 * 
	 * @throws IOException
	 * @throws DicomException
	 * @throws NotFoundRegistryException
	 *           if no TransferSyntax can't be found
	 * @throws Exception
	 */
	public void save() throws IOException, DicomException, Exception,
	NotFoundRegistryException {
		TransferSyntax transferSyntax = this.getTransferSyntax();
		if (transferSyntax == null) {
			transferSyntax = this.getTransferSyntaxRegistry()
			.getDefaultDicomTransferSyntax();
		}
		this.save(transferSyntax);
	}

	public void save(String newFilePath) throws IOException, DicomException {

	}

	public void save(String newFilePath, TransferSyntax transferSyntax,
			boolean deleteOldFile) throws IOException, DicomException, Exception {
		logger.info("save (path" + newFilePath + ", TransferSyntax: "
				+ transferSyntax + ", deleteOldFile: " + deleteOldFile + ")");
		if (this.getDataset() == null) {
			throw new DicomException("No DataSet was set");
		}
		String oldFilePath = "";
		if (deleteOldFile) {
			oldFilePath = this.getAbsolutePath();
		}

		if (!this.getFileMetaInformation().hasTransferSyntaxUIDElement()) {
			this.getFileMetaInformation().addElementsAndPreambule();
			this.getFileMetaInformation().setTransferSyntaxUID(transferSyntax.getUID());
		}

		if (!this.isOpen()) {
			this.open();
		}

		if (this.reader != null) {
			this.reader.close();
		}

		this.write(newFilePath, transferSyntax);
		if (oldFilePath.length() != 0) {
			new File(oldFilePath).delete();
		}

	}

	public void save(TransferSyntax transferSyntax) throws IOException,
	DicomException, Exception {
		logger.debug("save (path" + this.getAbsolutePath() + ", TransferSyntax: "
				+ transferSyntax + ")");
		if (this.getDataset() == null) {
			throw new DicomException("No DataSet was set");
		}
		if (this.reader != null) {
			this.reader.close();
		}

		this.write(this.file, transferSyntax);
	}

	/**
	 * @param time
	 * @return
	 * @see java.io.File#setLastModified(long)
	 */
	public boolean setLastModified(long time) {
		return this.file.setLastModified(time);
	}

	/**
	 * set the {@link TransferSyntaxFactory} to use.
	 * <p>
	 * the factory is used to get a {@link TransferSyntax} depending of the
	 * Transfer Syntax UID Element of the FileMetaInformation
	 * 
	 * @param transferSyntaxFactory
	 *          the factory
	 */
	public void setTransferSyntaxFactory(
			TransferSyntaxFactory transferSyntaxFactory) {
		this.transferSyntaxFactory = transferSyntaxFactory;
	}

	/**
	 * @param transferSyntaxRegistry
	 *          The transferSyntaxRegistry to set.
	 */
	public void setTransferSyntaxRegistry(
			TransferSyntaxRegistry transferSyntaxRegistry) {
		this.transferSyntaxRegistry = transferSyntaxRegistry;
	}

	protected void write(File file, TransferSyntax transferSyntax)
	throws Exception {
		try {
			DicomFileWriter lwriter = new DicomFileWriter(new FileOutputStream(file));
			try {
				lwriter.write(this.getFileMetaInformation(), this.getDataset(),
						transferSyntax);
				logger
				.info("file saved (absolutePath: " + file.getAbsolutePath() + ")");
			} finally {
				lwriter.close();
			}
		} finally {
			this.reader = new DicomFileReader(file);
		}
	}

	protected void write(String pathname, TransferSyntax transferSyntax)
	throws Exception {
		this.file = new File(pathname);
		this.write(this.file, transferSyntax);
	}

}
