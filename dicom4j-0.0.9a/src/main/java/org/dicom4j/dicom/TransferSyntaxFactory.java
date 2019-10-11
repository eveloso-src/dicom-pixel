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

package org.dicom4j.dicom;

import org.dicom4j.core.FactoryException;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Factory to creates {@link TransferSyntax}
 * 
 * @deprecated
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
@Deprecated
public class TransferSyntaxFactory {

	private static Logger logger = LoggerFactory
	.getLogger(TransferSyntaxFactory.class);

	public TransferSyntax getDefaultDicomTransferSyntax() throws FactoryException {
		return TransferSyntax.Default;
	}

	public TransferSyntax newTransferSyntax(String aUID) throws FactoryException {
		if (aUID.equals("")) {
			throw new FactoryException(
			"Factory can provide a TransferSyntax: no UID was supplied");
		}
		logger.debug("newTransferSyntax, UID: " + aUID);
		TransferSyntax res = null;
		if (aUID.equals(TransferSyntax.ExplicitVRBigEndian.getUID())) {
			res = TransferSyntax.ExplicitVRBigEndian;
		}
		if (aUID.equals(TransferSyntax.ExplicitVRLittleEndian.getUID())) {
			res = TransferSyntax.ExplicitVRLittleEndian;
		}
		if (aUID.equals(TransferSyntax.ImplicitVRLittleEndian.getUID())) {
			res = TransferSyntax.ImplicitVRLittleEndian;
		}
		if (aUID.equals(TransferSyntax.JPEG2000.getUID())) {
			res = TransferSyntax.JPEG2000;
		}
		if (aUID.equals(TransferSyntax.JPEG2000Lossless.getUID())) {
			res = TransferSyntax.JPEG2000Lossless;
		}
		if (aUID.equals(TransferSyntax.JPEGBaseline.getUID())) {
			res = TransferSyntax.JPEGBaseline;
		}
		if (aUID.equals(TransferSyntax.JPEGExtended.getUID())) {
			res = TransferSyntax.JPEGExtended;
		}
		if (aUID.equals(TransferSyntax.JPEGLossless.getUID())) {
			res = TransferSyntax.JPEGLossless;
		}
		if (aUID.equals(TransferSyntax.JPEGLosslessSV1.getUID())) {
			res = TransferSyntax.JPEGLosslessSV1;
		}
		if (aUID.equals(TransferSyntax.JPEGLS.getUID())) {
			res = TransferSyntax.JPEGLS;
		}
		if (aUID.equals(TransferSyntax.JPEGNLS.getUID())) {
			res = TransferSyntax.JPEGNLS;
		}
		if (aUID.equals(TransferSyntax.MPEG2MPML.getUID())) {
			res = TransferSyntax.MPEG2MPML;
		}
		if (res == null) {
			logger.warn("Unable to creates a TransferSyntax for " + aUID + " UID");
			throw new FactoryException("Unable to provide a TransferSyntax for "
					+ aUID + " UID");
		} else {
			logger.debug("Transfer Syntax \"" + res.getName() + "\" created");
			return res;
		}
	}

}
