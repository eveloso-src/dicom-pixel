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

package org.dicom4j.network.dimse.codec;

import org.dicom4j.network.association.Association;

/**
 * Factory to create {@link DimseMessageEncoder} and {@link DimseMessageDecoder}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DimseMessageCodecFactory {

	private DimseMessageDecoder decoder;

	private DimseMessageEncoder encoder;

	/*
	 * public DimseMessageDecoder getDecoder(Association aAssociation) { return
	 * new DimseMessageDecoder(aAssociation); }
	 */

	/*
	 * public DimseMessageDecoder getEncoder(Association aAssociation) { return
	 * new DimseMessageEncoder(aAssociation); }
	 */

	public DimseMessageCodecFactory() {
		this.encoder = new DimseMessageEncoder();
	}

	public DimseMessageCodecFactory(Association association) {
		super();
		this.decoder = new DimseMessageDecoder(association, association
				.getMessageFactory());
		this.encoder = new DimseMessageEncoder();
	}

	public DimseMessageDecoder getDecoder() {
		return this.decoder;
	}

	public DimseMessageEncoder getEncoder() {
		return this.encoder;
	}
}
