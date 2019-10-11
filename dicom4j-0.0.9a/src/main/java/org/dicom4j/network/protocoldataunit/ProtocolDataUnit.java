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

package org.dicom4j.network.protocoldataunit;

import java.io.IOException;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.io.BinaryInputStream;
import org.dicom4j.io.BinaryOutputStream;

/**
 * <p>
 * Protocol Data Unit
 * 
 * @since 0.0.8
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface ProtocolDataUnit {

	/**
	 * Return the length of the Protocol Data Unit
	 * 
	 * @return the length
	 */
	public int getLength();

	/**
	 * return the name of the Protocol Data Unit
	 * 
	 * @return the name
	 */
	public String getName();

	/**
	 * return the {@link SOPClassRegistry}
	 * 
	 * @return the SOPClassRegistry
	 */
	public SOPClassRegistry getSopClassRegistry();

	/**
	 * return the TransferSyntaxRegistry
	 * 
	 * @return
	 * @since 0.0.9
	 */
	public TransferSyntaxRegistry getTransferSyntaxRegistry();

	/**
	 * return the pdu's type
	 * @return
	 */
	public ProtocolDataUnitType getType();

	/**
	 * future release will implements Reader/writer
	 */
	@Deprecated
	public void read(BinaryInputStream stream, int length) throws DicomException,
	IOException;

	/**
	 * set the {@link SOPClassRegistry}
	 * 
	 * @param sopClassRegistry the SOPClassRegistry
	 */
	public void setSopClassRegistry(SOPClassRegistry sopClassRegistry);

	/**
	 * 
	 * @param transferSyntaxRegistry
	 * @since 0.0.9
	 */
	public void setTransferSyntaxRegistry(TransferSyntaxRegistry transferSyntaxRegistry);

	/**
	 * return the ProtocolDataUnit as a string
	 * 
	 * @return ProtocolDataUnit as string
	 */
	public String toString();

	/**
	 * future release will implements Reader/writer
	 * 
	 * @param stream
	 * @throws DicomException
	 * @throws IOException
	 */
	@Deprecated
	public void write(BinaryOutputStream stream) throws DicomException,
	IOException;

}
