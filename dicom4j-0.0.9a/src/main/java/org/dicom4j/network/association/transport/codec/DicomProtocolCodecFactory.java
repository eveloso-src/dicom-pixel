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

package org.dicom4j.network.association.transport.codec;

import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;

/**
 * Factory to create Dicom {@link DicomProtocolDecoder Encoder}/
 * {@link DicomProtocolDecoder Decoder}
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomProtocolCodecFactory implements ProtocolCodecFactory {

	private DicomProtocolDecoder decoder;

	private DicomProtocolEncoder encoder;

	public DicomProtocolCodecFactory() {
		super();
		this.decoder = new DicomProtocolDecoder();
		this.encoder = new DicomProtocolEncoder();
	}

	public ProtocolDecoder getDecoder() {
		assert this.decoder != null;
		return this.decoder;
	}

	public ProtocolEncoder getEncoder() {
		assert this.encoder != null;
		return this.encoder;
	}

	public void setSopClassRegistry(SOPClassRegistry sopClassRegistry) {
		this.decoder.setSopClassRegistry(sopClassRegistry);
	}

	public void setTransferSyntaxRegistry(
			TransferSyntaxRegistry transferSyntaxRegistry) {
		this.decoder.setTransferSyntaxRegistry(transferSyntaxRegistry);
	}

}
