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

import java.io.IOException;
import java.io.InputStream;

import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;

/**
 * <p>Extends {@link BinaryInputStream} to add dicom specific read primitives
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class DicomInputStream extends BinaryInputStream {

	/**
	 * the TransferSyntax
	 */
	private TransferSyntax transferSyntax;

	/**
	 * Construct a stream to read DICOM data sets.
	 * <p>ImplicitVRLittleEndian (dicom default) will be set)
	 * 
	 * @param stream the input stream to read from
	 */
	public DicomInputStream(InputStream stream) {
		this(stream, TransferSyntax.ImplicitVRLittleEndian); // the default
	}

	/**
	 * Construct a stream to read DICOM data sets
	 * @param stream the input stream to read from
	 * @param transferSyntax the TransferSyntax
	 */
	public DicomInputStream(InputStream stream, TransferSyntax transferSyntax) {
		super(stream);
		assert stream != null;
		assert transferSyntax != null;
		this.transferSyntax = transferSyntax;
	}

	/**
	 * return the TransferSyntax
	 * @return the TransferSyntax
	 */
	public TransferSyntax getTransferSyntax() {
		return this.transferSyntax;
	}

	/**
	 * <p>
	 * Is the transfer syntax use explicit VR ?
	 * </p>
	 * 
	 * @return true if explicit VR
	 */
	public boolean isExplicitVR() {
		return this.getTransferSyntax().isExplicitVR();
	}

	/**
	 * read a {@link ValueRepresentation} from a stream.
	 * 
	 * @return the readed ValueRepresentation
	 * @throws DicomIOException if TransferSyntax is not explict or unable to read 2 bytes
	 * @throws IOException if I/O errors occurs
	 */
	public byte[] readValueRepresentationAsBytes() throws DicomIOException, IOException {
		if ( ! this.isExplicitVR() ) {
			throw new DicomIOException("the TransferSyntax is impplict, readValueRepresentationasBytes should not be call");
		}
		byte[] vr = new byte[2];
		if ( this.read(vr, 0, 2) != 2 ) {
			throw new DicomIOException("VR read failed, unable to read two bytes");
		}
		return vr;
	}

	public void setTransferSyntax(TransferSyntax aTransferSyntax) {
		assert aTransferSyntax != null;
		this.transferSyntax = aTransferSyntax;
		this.setByteOrder(this.transferSyntax.getByteOrder());
	}

}
