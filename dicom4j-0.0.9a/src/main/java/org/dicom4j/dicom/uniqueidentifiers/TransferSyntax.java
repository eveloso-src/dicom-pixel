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

package org.dicom4j.dicom.uniqueidentifiers;

import java.nio.ByteOrder;

import org.dicom4j.dicom.uniqueidentifiers.support.UniqueIdentifier;

/**
 * Transfer Syntax
 * 
 * @user
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TransferSyntax extends UniqueIdentifier {

	/*private static class InnerTransferSyntaxes extends UniqueIdentifiers {

		protected void addUIDs() {
			this.add(ImplicitVRLittleEndian);
			this.add(ExplicitVRLittleEndian);
			this.add(ExplicitVRBigEndian);
			this.add(JPEGBaseline);
			this.add(JPEGExtended);
			this.add(JPEGLossless);
			this.add(JPEGLosslessSV1);
			this.add(JPEGLS);
			this.add(JPEGNLS);
			this.add(JPEG2000Lossless);
			this.add(JPEG2000);
			this.add(MPEG2MPML);
		}
	}*/





	/**
	 * Explicit VR BigEndian
	 */
	public static final TransferSyntax ExplicitVRBigEndian = new TransferSyntax(
			"1.2.840.10008.1.2.2", "Explicit VR Big Endian", true,
			ByteOrder.BIG_ENDIAN, false);

	/**
	 * Explicit VR Little Endian
	 */
	public static final TransferSyntax ExplicitVRLittleEndian = new TransferSyntax(
			"1.2.840.10008.1.2.1", "Explicit VR Little Endian", true,
			ByteOrder.LITTLE_ENDIAN, false);

	/**
	 * Implicit VR Little Endian
	 */
	public static final TransferSyntax ImplicitVRLittleEndian = new TransferSyntax(
			"1.2.840.10008.1.2", "Implicit VR Little Endian", false,
			ByteOrder.LITTLE_ENDIAN, false);

	/***/
	public static final TransferSyntax JPEG2000 = new TransferSyntax(
			"1.2.840.10008.1.2.4.91", "JPEG 2000", true, ByteOrder.LITTLE_ENDIAN,
			true);

	/**
	 * JPEG2000Lossless Transfer Syntax
	 */
	public static final TransferSyntax JPEG2000Lossless = new TransferSyntax(
			"1.2.840.10008.1.2.4.90", "JPEG 2000 Lossless Only", true,
			ByteOrder.LITTLE_ENDIAN, true);

	/***/
	public static final TransferSyntax JPEGBaseline = new TransferSyntax(
			"1.2.840.10008.1.2.4.50", "JPEG Baseline", true, ByteOrder.LITTLE_ENDIAN,
			true);

	/***/
	public static final TransferSyntax JPEGExtended = new TransferSyntax(
			"1.2.840.10008.1.2.4.51", "JPEG Extended", true, ByteOrder.LITTLE_ENDIAN,
			true);

	/***/
	public static final TransferSyntax JPEGLossless = new TransferSyntax(
			"1.2.840.10008.1.2.4.57", "JPEG Lossless", true, ByteOrder.LITTLE_ENDIAN,
			true);

	/***/
	public static final TransferSyntax JPEGLosslessSV1 = new TransferSyntax(
			"1.2.840.10008.1.2.4.70", "JPEG LosslessS V1", true,
			ByteOrder.LITTLE_ENDIAN, true);

	/***/
	public static final TransferSyntax JPEGLS = new TransferSyntax(
			"1.2.840.10008.1.2.4.80", "JPEG-LS", true, ByteOrder.LITTLE_ENDIAN, true);

	/***/
	public static final TransferSyntax JPEGNLS = new TransferSyntax(
			"1.2.840.10008.1.2.4.81", "JPEG-LS Near-lossless", true,
			ByteOrder.LITTLE_ENDIAN, true);

	/**
	 * MPEG2 MPML
	 */
	public static final TransferSyntax MPEG2MPML = new TransferSyntax(
			"1.2.840.10008.1.2.4.100", "MPEG2 MPML", true, ByteOrder.LITTLE_ENDIAN,
			true);

	/**
	 * Default DICOM transfer syntax (ie: ImplicitVRLittleEndian)
	 */
	public static final TransferSyntax Default = ImplicitVRLittleEndian;
	
	//private static InnerTransferSyntaxes transferSyntaxes = new InnerTransferSyntaxes();

	/**
	 * add a new TransferSyntax to the list of known TransferSyntax
	 * 
	 * @param transferSyntax
	 *          the TransferSyntax to add
	 * @return the added TransferSyntax
	 */
	/*public static synchronized TransferSyntax addTransferSyntax(
			TransferSyntax transferSyntax) {
		return (TransferSyntax) transferSyntaxes.add(transferSyntax);
	}*/

	/**
	 * @deprecated get a TransferSyntax as a human readable value (ie: the name)
	 * @param value
	 *          the TransferSyntax UID
	 * @return the TransferSyntax a as string
	 */
	//@Deprecated
	/*public static String toString(String value) {
		TransferSyntax ts = (TransferSyntax) transferSyntaxes.getByUID(value);
		if (ts != null) {
			return ts.getName();
		} else {
			return "Unknown Transfer Syntax";
		}
	}*/

	/**
	 * the Byte Order
	 */
	private ByteOrder byteOrder;

	private boolean encapsulatedPixelData;

	/**
	 * true if ExplicitVR
	 */
	private boolean explicitVR;

	/**
	 * <p>
	 * Construct a Transfer Syntax using the specified UID, automatically
	 * determining its characteristics.
	 * </p>
	 * 
	 * @param uid
	 *          the UID to use to refer to this transfer syntax
	 */
	public TransferSyntax(String uid) {
		super(UniqueIdentifierType.TRANSFER_SYNTAX.value(), uid, "Unrecognized");
		this.name = "Unrecognized";
		this.byteOrder = ByteOrder.LITTLE_ENDIAN;
		this.explicitVR = true;
		this.encapsulatedPixelData = false;

		if (this.getUID().equals(TransferSyntax.ImplicitVRLittleEndian.getUID())) {
			this.name = "Implicit VR Little Endian";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = false;
			this.encapsulatedPixelData = false;
		} else if (this.getUID().equals(
				TransferSyntax.ExplicitVRLittleEndian.getUID())) {
			this.name = "Explicit VR Little Endian";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = false;
		} else if (this.getUID().equals(ExplicitVRBigEndian.getUID())) {
			this.name = "Explicit VR Big Endian";
			this.byteOrder = ByteOrder.BIG_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = false;
		} else if (this.getUID().equals(JPEGBaseline.getUID())) {
			this.name = "JPEG Baseline";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = true;
		} else if (this.getUID().equals(JPEGExtended.getUID())) {
			this.name = "JPEG Extended";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = true;
		} else if (this.getUID().equals(JPEG2000Lossless.getUID())) {
			this.name = "JPEG 2000 Lossless Only";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = true;
		} else if (this.getUID().equals(JPEG2000.getUID())) {
			this.name = "JPEG 2000";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = true;
		} else if (this.getUID().equals(JPEGLossless.getUID())) {
			this.name = "JPEG Lossless";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = true;
		} else if (this.getUID().equals(JPEGLosslessSV1.getUID())) {
			this.name = "JPEG Lossless SV1";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = true;
		} else if (this.getUID().equals(JPEGLS.getUID())) {
			this.name = "JPEG-LS";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = true;
		} else if (this.getUID().equals(JPEGNLS.getUID())) {
			this.name = "JPEG-LS Near-lossless";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = true;
		} else if (this.getUID().equals(MPEG2MPML.getUID())) {
			this.name = "MPEG2 MPML";
			this.byteOrder = ByteOrder.LITTLE_ENDIAN;
			this.explicitVR = true;
			this.encapsulatedPixelData = true;
		}
	}

	/**
	 * <p>
	 * Construct a Transfer Syntax using the specified UID and characteristics.
	 * </p>
	 * 
	 * @param uid
	 *          the UID to use to refer to this transfer syntax
	 * @param desc
	 *          the fName of this transfer syntax
	 * @param explicit
	 *          true if an explicit VR transfer syntax
	 * @param big
	 *          true if big-endian transfer syntax
	 * @param encapsulated
	 *          true if a pixel data encapsulated transfer syntax
	 */
	public TransferSyntax(String uid, String desc, boolean explicit,
			ByteOrder aByteOrder, boolean encapsulated) {
		super(UniqueIdentifierType.TRANSFER_SYNTAX, uid, desc);
		this.name = desc;
		// bigEndian=big;
		this.byteOrder = aByteOrder;
		this.explicitVR = explicit;
		this.encapsulatedPixelData = encapsulated;
	}

	/**
	 * get the {@link ByteOrder}
	 * 
	 * @return the ByteOrder
	 */
	public ByteOrder getByteOrder() {
		return this.byteOrder;
	}

	/**
	 * <p>
	 * Does the Transfer Syntax use deflate compression ?
	 * </p>
	 * 
	 * @return true if deflated
	 */
	public boolean isDeflated() {
		return false; /* getValue().equals(DeflatedExplicitVRLittleEndian); */
	}

	/**
	 * <p>
	 * Does the Transfer Syntax encapsulate the pixel data ?
	 * </p>
	 * 
	 * @return true if encapsulate
	 */
	public boolean isEncapsulated() {
		return this.encapsulatedPixelData;
	}

	/**
	 * <p>
	 * Is the Transfer Syntax explicit VR ?
	 * </p>
	 * 
	 * @return true if explicit VR
	 */
	public boolean isExplicitVR() {
		return this.explicitVR;
	}

	/**
	 * <p>
	 * Does the Transfer Syntax encode the pixel data without encapsulation?
	 * </p>
	 * 
	 * @return true if not encapsulated
	 */
	public boolean isNotEncapsulated() {
		return !this.encapsulatedPixelData;
	}

	/**
	 * <p>
	 * get the Transfer Syntax as a string.
	 * </p>
	 * 
	 * @return the TransferSyntax as a string
	 */
	@Override
	public String toString() {
		return this.getUID();
	}

}
