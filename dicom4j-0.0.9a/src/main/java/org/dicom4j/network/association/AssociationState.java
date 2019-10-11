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

package org.dicom4j.network.association;

/**
 * Internal states of an Association
 * 
 * @since 0.0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AssociationState {

	public static final int ASSOCIATION_ESTABLISHED_READY_FOR_DATA_TRANSFERT = 6;

	public static final int AWAITING_A_ASSOCIATE = 3;

	public static final int AWAITING_A_RELEASE_RP = 7;

	public static final int AWAITING_ASSOCIATE_AC_RJ = 5;

	public static final int AWAITING_LOCAL_A_RELEASE = 8;

	public static final int AWAITING_TRANSPORT_CONNECTION_CLOSE = 13;

	public static final int AWAITING_TRANSPORT_CONNECTION_OPENING = 4;

	public static final int IDLE = 1;

	public static final int RELEASE_COLLISION_ACCEPTOR_SIDE_AWAITING_A_RELEASE = 12;

	public static final int RELEASE_COLLISION_ACCEPTOR_SIDE_AWAITING_A_RELEASE_RP = 10;

	public static final int RELEASE_COLLISION_REQUESTOR_SIDE_AWAITING_A_RELEASE = 9;

	public static final int RELEASE_COLLISION_REQUESTOR_SIDE_AWAITING_A_RELEASE_RP = 11;

	public static final int TRANSPORT_CONNECTION_OPEN = 2;

	/**
	 * Return a State as a string
	 * 
	 * @param aState
	 *          the State
	 * @return state as a string
	 */
	public static String toString(int aState) {
		if (aState == IDLE) {
			return "idle";
		}
		if (aState == TRANSPORT_CONNECTION_OPEN) {
			return "TRANSPORT_CONNECTION_OPEN";
		}
		if (aState == AWAITING_A_ASSOCIATE) {
			return "AWAITING_A_ASSOCIATE";
		}
		if (aState == AWAITING_TRANSPORT_CONNECTION_OPENING) {
			return "AWAITING_TRANSPORT_CONNECTION_OPENING";
		}
		if (aState == AWAITING_ASSOCIATE_AC_RJ) {
			return "AWAITING_ASSOCIATE_AC_RJ";
		}
		if (aState == ASSOCIATION_ESTABLISHED_READY_FOR_DATA_TRANSFERT) {
			return "ASSOCIATION_ESTABLISHED_READY_FOR_DATA_TRANSFERT";
		}
		if (aState == AWAITING_A_RELEASE_RP) {
			return "AWAITING_A_RELEASE_RP";
		}
		if (aState == AWAITING_LOCAL_A_RELEASE) {
			return "AWAITING_LOCAL_A_RELEASE";
		}
		if (aState == RELEASE_COLLISION_REQUESTOR_SIDE_AWAITING_A_RELEASE) {
			return "RELEASE_COLLISION_REQUESTOR_SIDE_AWAITING_A_RELEASE";
		}
		if (aState == RELEASE_COLLISION_ACCEPTOR_SIDE_AWAITING_A_RELEASE_RP) {
			return "RELEASE_COLLISION_ACCEPTOR_SIDE_AWAITING_A_RELEASE_RP";
		}
		if (aState == RELEASE_COLLISION_REQUESTOR_SIDE_AWAITING_A_RELEASE_RP) {
			return "RELEASE_COLLISION_REQUESTOR_SIDE_AWAITING_A_RELEASE_RP";
		}
		if (aState == RELEASE_COLLISION_ACCEPTOR_SIDE_AWAITING_A_RELEASE) {
			return "RELEASE_COLLISION_ACCEPTOR_SIDE_AWAITING_A_RELEASE";
		}
		if (aState == AWAITING_TRANSPORT_CONNECTION_CLOSE) {
			return "AWAITING_TRANSPORT_CONNECTION_CLOSE";
		}
		return "UNKNOWN STATE";
	}
}
