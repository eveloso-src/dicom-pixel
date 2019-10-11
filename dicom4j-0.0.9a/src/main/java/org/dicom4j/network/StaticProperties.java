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

package org.dicom4j.network;

/**
 * @deprecated Static properties
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
@Deprecated
public class StaticProperties {

	/**
	 * Reason of AAbort
	 */
	public static class AssociateAbortReasons {
		public static final byte INVALID_PDU_PARAMETER_VALUE = 6;

		public static final byte REASON_NOT_SPECIFIED = 0;

		public static final byte RESERVED = 3;

		public static final byte UNEXPECTED_PDU = 2;

		public static final byte UNEXPECTED_PDU_PARAMETER = 5;

		public static final byte UNRECOGNIZED_PDU = 1;

		public static final byte UNRECOGNIZED_PDU_PARAMETER = 4;
	}

	/**
	 * Sources of AAbort
	 */
	public static class AssociateAbortSource {
		public static final byte RESERVED = 1;

		public static final byte SERVICE_PROVIDER = 2;

		public static final byte SERVICE_USER = 0;
	}

	public static class AssociateRejectReason {
	}

	public static class AssociateRejectResult {
		public static final byte REJECTED_PERMANENT = 1;

		public static final byte REJECTED_TRANSIENT = 2;
	}

	public static class AssociateRejectSource {
		public static final byte DICOM_UL_SERVICE_PRESENTATION = 3;

		public static final byte DICOM_UL_SERVICE_PROVIDER_ACSE = 2;

		public static final byte DICOM_UL_SERVICE_USER = 1;
	}

	public static class PresentationContextReasons {
		public final static byte ABSTRACT_SYNTAX_NOT_SUPPORTED = 3;

		public final static byte ACCEPTANCE = 0;

		public final static byte NO_REASON = 2;

		public final static byte TRANSFER_SYNTAXES_NOT_SUPPORTED = 4;

		public final static byte USER_REJECTION = 1;
	}

	public static String ApplicationContextUID = "1.2.840.10008.3.1.1.1";

}
