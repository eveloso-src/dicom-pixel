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

package org.dicom4j.management;

import java.util.List;

/**
 * Transfer Capability (see DICOM PS 3.15, table H.1-7)
 * 
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface TransferCapability {

	/**
	 * String representation of the DICOM SCP role.
	 */
	public static final String SCP = "SCP";

	/**
	 * String representation of the DICOM SCU role.
	 */
	public static final String SCU = "SCU";

	/**
	 * add one TransferSyntax
	 * 
	 * @param transferSyntax
	 *          the TransferSyntaxe to add
	 */
	public void addTransferSyntax(String transferSyntax);

	/**
	 * get the CommonName
	 * 
	 * @return the CommonName
	 */
	public String getCommonName();

	/**
	 * get the Role
	 * 
	 * @return
	 */
	public String getRole();

	/**
	 * get the SOPClass
	 * 
	 * @return
	 */
	public String getSOPClass();

	/**
	 * get the TransferSyntaxes
	 * 
	 * @return the TransferSyntaxes
	 */
	public List<String> getTransferSyntax();

	/**
	 * set the CommonName
	 * 
	 * @param aCommonName
	 *          the CommonName
	 */
	public void setCommonName(String aCommonName);

	/**
	 * Set the Role
	 * 
	 * @param aRole
	 */
	public void setRole(String aRole);

	/**
	 * set the SOPClass
	 * 
	 * @param aSopClass
	 */
	public void setSOPClass(String aSopClass);

	/**
	 * set the TransferSyntaxes
	 * 
	 * @param aTransferSyntaxes
	 *          the TransferSyntaxes
	 */
	public void setTransferSyntax(List<String> transferSyntaxes);

}
