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

package org.dicom4j.network.dimse;

/**
 * Constants contained in DIMSE-MESSAGES
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DimseConst {

	/**
	 * Priorities
	 * 
	 * @deprecated since 0.0.4 use DimsePriority instead
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 * 
	 */
	@Deprecated
	public class Priorities {

		/**
		 * HIGH priority
		 */
		public final static int HIGH = 0x0001;

		/**
		 * LOW priority
		 */
		public final static int LOW = 0x0002;

		/**
		 * MEDIUM priority
		 */
		public final static int MEDIUM = 0x0000;
	}

	public static class QueryRetrieveLevel {

		public static String IMAGES_LEVEL = "IMAGE";

		public static String PATIENT_LEVEL = "PATIENT";

		public static String SERIES_LEVEL = "SERIES";

		public static String STUDY_LEVEL = "STUDY";

		public static boolean isImageLevel(String aLevel) {
			return aLevel.trim().equals(IMAGES_LEVEL);
		}

		public static boolean isPatientLevel(String aLevel) {
			return aLevel.trim().equals(PATIENT_LEVEL);
		}

		public static boolean isSerieLevel(String aLevel) {
			return aLevel.trim().equals(SERIES_LEVEL);
		}

		public static boolean isStudyLevel(String aLevel) {
			return aLevel.trim().equals(STUDY_LEVEL);
		}
	}

	/**
	 * Status
	 * 
	 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
	 * 
	 */
	public class Status {

		// Failures

		/**
		 * Cancel
		 */
		public static final int Cancel = 0xFE00;

		/**
		 * Error: Cannot understand
		 */
		public static final int ErrorCannotUnderstand = 0xC000;

		/**
		 * Pending
		 */
		public static final int Pending = 0xFF00;

		/**
		 * Pending With Warning
		 */
		public static final int PendingWithWarning = 0xFF01;

		// Success

		/**
		 * Refused: Move Destination unknown
		 */
		public static final int RefusedMoveDestinationUnknown = 0xA801;

		// Cancel

		/**
		 * RefusedOutOfResources
		 */
		public static final int RefusedOutOfResources = 0xA700;

		// Pending

		/**
		 * Success
		 */
		public static final int Success = 0x0000;

		public static final int UnableToPerformSubOperations = 0xa702;
	}

	/**
	 * Return true if the status indicates a failure status
	 * 
	 * @param aStatus
	 * @return true if failure
	 */
	public static final boolean isFailure(int aStatus) {
		return (aStatus == DimseConst.Status.RefusedOutOfResources)
		|| (aStatus == DimseConst.Status.RefusedMoveDestinationUnknown)
		|| (aStatus == DimseConst.Status.ErrorCannotUnderstand);
	}

	/**
	 * Return true if the status indicates a pending status
	 * 
	 * @param aStatus
	 * @return true if pending
	 */
	public static final boolean isPendingStatus(int aStatus) {
		return (aStatus == DimseConst.Status.Pending)
		|| (aStatus == DimseConst.Status.PendingWithWarning);
	}

	/**
	 * Return a Priority as String
	 * 
	 * @param aPriority
	 *          the priority
	 * @return priority as string
	 */
	public static String priorityToString(int aPriority) {
		if (aPriority == Priorities.LOW) {
			return "Low";
		} else if (aPriority == Priorities.MEDIUM) {
			return "Medium";
		} else if (aPriority == Priorities.HIGH) {
			return "High";
		} else {
			return "Unknown priority";
		}
	}

	/**
	 * Get a status as String
	 * 
	 * @param aStatus
	 *          the status
	 * @return status as string
	 */
	public static final String statusToString(int aStatus) {
		if (aStatus == Status.Success) {
			return "success";
		} else if (aStatus == Status.Pending) {
			return "pending";
		} else if (aStatus == Status.PendingWithWarning) {
			return "pending with warning";
		} else if (aStatus == Status.RefusedOutOfResources) {
			return "Refused: Out Of Resources";
		} else if (aStatus == Status.ErrorCannotUnderstand) {
			return "Error: Cannot understand";
		} else if (aStatus == Status.RefusedMoveDestinationUnknown) {
			return "Refused: Move Destination unknown";
		} else {
			return "Unknown status";
		}
	}

}
