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

package org.dicom4j.dicom.network.dimse;

import org.dicom4j.core.utils.IntValue;
import org.dicom4j.network.dimse.DimseConst;
import org.dicom4j.network.dimse.DimseConst.Status;

/**
 * Dimse Status
 * 
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DimseStatus extends IntValue {

	/**
	 * Cancel Status
	 */
	public static final DimseStatus Cancel = new DimseStatus(0xFE00, "Cancel");

	/**
	 * Coercion Of Data Elements
	 */
	public static final DimseStatus CoercionOfDataElements = new DimseStatus(
			0xB000, "Coercion of Data Elements");

	/**
	 * RefusedOutOfResources
	 */
	public static final DimseStatus DataSetDoesNotMatchSOPClass = new DimseStatus(
			0xA900, "Data Set does not match SOP Class");

	/**
	 * Error: Cannot understand
	 */
	public static final DimseStatus ErrorCannotUnderstand = new DimseStatus(
			0xC000, "Error Cannot Understand");

	/**
	 * Pending
	 */
	public static final DimseStatus Pending = new DimseStatus(0xFF00, "Pending");

	/**
	 * Pending With Warning
	 */
	public static final DimseStatus PendingWithWarning = new DimseStatus(0xFF01,
	"Pending With Warning");

	/**
	 * Refused: Move Destination unknown
	 */
	public static final DimseStatus RefusedMoveDestinationUnknown = new DimseStatus(
			0xA801, "Refused Move Destination Unknown");

	/**
	 * RefusedOutOfResources
	 */
	public static final DimseStatus RefusedOutOfResources = new DimseStatus(
			0xA700, "Refused Out Of Resources");

	/**
	 * Success
	 */
	public static final DimseStatus Success = new DimseStatus(0x0000, "Success");

	/**
	 * Unable To Perform Sub Operations
	 */
	public static final DimseStatus UnableToPerformSubOperations = new DimseStatus(
			0xa702, "Unable To Perform Sub Operations");

	/**
	 * check if the status indicates a failure status
	 * 
	 * @param status
	 *          the status
	 * @return true if failure
	 */
	public static final boolean isFailure(int status) {
		boolean res = false;
		res = (status == RefusedOutOfResources.value())
		|| (status == RefusedMoveDestinationUnknown.value())
		|| (status == ErrorCannotUnderstand.value());
		if ((status >= 0xa900) || (status <= 0xa9ff)) {
			res = true;
		}
		return res;
	}

	/**
	 * Return true if the status indicates a pending status
	 * 
	 * @param status
	 * @return true if pending
	 */
	public static final boolean isPending(int status) {
		return (status == DimseConst.Status.Pending)
		|| (status == DimseConst.Status.PendingWithWarning);
	}

	/**
	 * check if the status indicates a succes status
	 * 
	 * @param status
	 *          the status
	 * @return true if failure
	 */
	public static final boolean isSuccess(int status) {
		return status == Success.value();
	}

	public static final String toString(int status) {
		if (status == Success.value()) {
			return Success.toString();
		} else if (status == Status.Pending) {
			return "pending";
		} else if (status == Status.PendingWithWarning) {
			return "pending with warning";
		} else if (status == Status.RefusedOutOfResources) {
			return "Refused: Out Of Resources";
		} else if (status == Status.ErrorCannotUnderstand) {
			return "Error: Cannot understand";
		} else if (status == Status.RefusedMoveDestinationUnknown) {
			return "Refused: Move Destination unknown";
		} else if (status == CoercionOfDataElements.value()) {
			return CoercionOfDataElements.toString();
		} else if ((status >= 0xa900) || (status <= 0xa9ff)) {
			return DataSetDoesNotMatchSOPClass.toString();
		} else {
			return "Unknown status (status: " + status + ")";
		}
	}

	public DimseStatus(int aValue, String aValueAsString) {
		super(aValue, aValueAsString);
	}

	public boolean isFailure() {
		return isFailure(this.value());
	}

	public boolean isPending() {
		return isPending(this.value());
	}

	public boolean isSuccess() {
		return isSuccess(this.value());
	}

}
