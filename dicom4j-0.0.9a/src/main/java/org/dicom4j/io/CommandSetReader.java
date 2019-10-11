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
package org.dicom4j.io;

import java.io.IOException;
import java.io.InputStream;

import org.dicom4j.data.CommandSet;
import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;

/**
 * a specialized {@link DicomReader} to read a {@link CommandSet} stored in a
 * stream
 * 
 * @since Alpha 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CommandSetReader extends DicomReader {

	/**
	 * @param aBytes
	 */
	public CommandSetReader(byte[] aBytes) {
		super(aBytes);
	}

	/**
	 * @param aInputStream
	 */
	public CommandSetReader(InputStream aInputStream) {
		super(aInputStream);
	}

	public void read(DataSet aDataSet) throws IOException, DicomException, Exception {
		super.read(aDataSet, TransferSyntax.ImplicitVRLittleEndian);
	}

}
