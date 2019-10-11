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
package org.dicom4j.dicom.uniqueidentifiers;

import org.dicom4j.core.registry.NotFoundRegistryException;
import org.dicom4j.dicom.uniqueidentifiers.support.AbstractUniqueIdentifierRegistry;
import org.dicom4j.dicom.uniqueidentifiers.support.UniqueIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Registry of {@link TransferSyntax}
 * 
 * @user
 * @since 0.0.7
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TransferSyntaxRegistry extends AbstractUniqueIdentifierRegistry {

	private static final Logger logger = LoggerFactory
	.getLogger(TransferSyntaxRegistry.class);

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TransferSyntaxRegistry() {
		super();
		this.add(TransferSyntax.ImplicitVRLittleEndian);
		this.add(TransferSyntax.ExplicitVRLittleEndian);
		this.add(TransferSyntax.ExplicitVRBigEndian);
		this.add(TransferSyntax.JPEGBaseline);
		this.add(TransferSyntax.JPEGExtended);
		this.add(TransferSyntax.JPEGLossless);
		this.add(TransferSyntax.JPEGLosslessSV1);
		this.add(TransferSyntax.JPEGLS);
		this.add(TransferSyntax.JPEGNLS);
		this.add(TransferSyntax.JPEG2000Lossless);
		this.add(TransferSyntax.JPEG2000);
		this.add(TransferSyntax.MPEG2MPML);
		logger.debug(this.count() + " TransferSyntax added");
	}

	/**
	 * Add a TransferSyntax to the registry
	 * 
	 * @param item
	 *          the TransferSyntax to add
	 * @return the added TransferSyntax
	 */
	public TransferSyntax add(TransferSyntax item) {
		super.add(item);
		return item;
	}

	@Override
	public TransferSyntax getByUID(String uid) throws NotFoundRegistryException {
		UniqueIdentifier object = super.getByUID(uid);
		if (object == null) {
			return null;
		} else {
			return (TransferSyntax) object;
		}
	}

	public TransferSyntax getDefaultDicomTransferSyntax() {
		return TransferSyntax.Default;
	}

	@Override
	public UniqueIdentifierType getType() {
		return UniqueIdentifierType.TRANSFER_SYNTAX;
	}

}
