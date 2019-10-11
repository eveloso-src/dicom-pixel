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

package org.dicom4j.network.protocoldataunit.codec;

/**
 * Factory to creates Encoder/Decoder
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ProtocolDataUnitCodecFactory {

	/**
	 * the {@link ProtocolDataUnitDecoder}
	 */
	private ProtocolDataUnitDecoder fDecoder;

	/**
	 * the encoder
	 */
	private ProtocolDataUnitEncoder fEncoder;

	public ProtocolDataUnitCodecFactory() {
		this.fEncoder = new ProtocolDataUnitEncoder();
		this.fDecoder = new ProtocolDataUnitDecoder();
	}

	public ProtocolDataUnitDecoder getDecoder() {
		return this.fDecoder;
	}

	public ProtocolDataUnitEncoder getEncoder() {
		return this.fEncoder;
	}

}
