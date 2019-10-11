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

package org.dicom4j.network.protocoldataunit.userinformationsubitems;

import org.dicom4j.dicom.DicomException;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.AsynchronousOperationsWindow;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.ImplementationClassUID;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.ImplementationVersionName;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.MaximumLength;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.SOPClassExtendedNegotiation;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.items.ScpScuRoleSelection;
import org.dicom4j.network.protocoldataunit.userinformationsubitems.support.AbstractUserInformationSubItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Factory to create
 * {@link org.dicom4j.network.protocoldataunit.userinformationsubitems.support.AbstractUserInformationSubItem
 * UserInformationSubItem}
 * </p>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class UserInformationSubItemFactory {

	private static Logger logger = LoggerFactory
	.getLogger(UserInformationSubItemFactory.class);

	public UserInformationSubItemFactory() {
		super();
	}

	/**
	 * creates a new UserInformationSubItem
	 * 
	 * @param type
	 *          the type of the UserInformationSubItem
	 * @return the created UserInformationSubItem (null if type doesn't match to a
	 *         known UserInformationSubItem)
	 * @throws DicomException
	 */
	public AbstractUserInformationSubItem newUserInformationSubItem(byte type)
	throws DicomException {
		AbstractUserInformationSubItem result = null;
		if (type == UserInformationSubItemType.MAXIMUM_LENGTH.value()) {
			result = new MaximumLength();
		} else if (type == UserInformationSubItemType.IMPLENTATIONCLASS_UID.value()) {
			result = new ImplementationClassUID();
		} else if (type == UserInformationSubItemType.ASYNCHRONOUS_OPERATIONS_WINDOW
				.value()) {
			result = new AsynchronousOperationsWindow();
		} else if (type == UserInformationSubItemType.SCP_SCU_ROLE_SELECTION
				.value()) {
			result = new ScpScuRoleSelection();
		} else if (type == UserInformationSubItemType.IMPLEMENTATION_VERSION_NAME
				.value()) {
			result = new ImplementationVersionName();
		} else if (type == UserInformationSubItemType.SOP_CLASS_EXTENDED_NEGOCIATION
				.value()) {
			result = new SOPClassExtendedNegotiation();
		} else if (type == UserInformationSubItemType.SOP_CLASS_COMMON_EXTENDED_NEGOTIATION
				.value()) {
			// lResult = new ();
		} else if (type == UserInformationSubItemType.USER_IDENTITY.value()) {
			// lResult = new ();
		} else {
			logger.warn(type + " is not a valid User Information Sub Item type");
		}
		if (result != null) {
			logger.debug("newUserInformationSubItem: " + result.getName());
		}
		return result;
	}

	@Override
	public String toString() {
		return "default UserInformationSubItemFactory";
	}

}
