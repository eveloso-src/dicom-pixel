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
package org.dicom4j.io.media;

import java.io.File;
import java.io.IOException;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.io.directory.DicomDirectory;
import org.dicom4j.io.directory.DicomDirectoryReader;

/**
 * DICOM DIR
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomDir extends DicomFile {

	private static final long serialVersionUID = 1L;

	private DicomDirectory dicomDirectory = new DicomDirectory();

	/**
	 * @param aFile
	 */
	public DicomDir(File aFile) {
		this(aFile.getAbsolutePath());
	}

	/**
	 * @param aAbsolutePath
	 */
	public DicomDir(String aAbsolutePath) {
		super(aAbsolutePath);
	}

	public DicomDirectory getDicomDirectory() {
		return this.dicomDirectory;
	}

	@Override
	public void open() throws IOException, DicomException, Exception {
		super.open(); // we read the DicomDir's data from the files
		DicomDirectoryReader lReader = new DicomDirectoryReader(this.getDataset());
		lReader.read(this.dicomDirectory);
	}

}
