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

import java.io.OutputStream;

import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;

/**
 * <p>
 * Extends {@link org.dicom4j.io.BinaryOutputStream BinaryOutputStream} by
 * adding the concept of transfer syntaxes
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 */
public class DicomOutputStream extends BinaryOutputStream {

	private TransferSyntax transferSyntax;

	public DicomOutputStream(OutputStream aOutputStream) {
		this(aOutputStream, TransferSyntax.ImplicitVRLittleEndian); // the default
		// TransferSyntax
	}

	public DicomOutputStream(OutputStream aOutputStream,
			TransferSyntax aTransferSyntax) {
		super(aOutputStream);
		this.setTransferSyntax(aTransferSyntax);
	}

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

	public void setTransferSyntax(TransferSyntax aTransferSyntax) {
		assert aTransferSyntax != null;
		this.transferSyntax = aTransferSyntax;
		this.setByteOrder(this.transferSyntax.getByteOrder());
	}
}
