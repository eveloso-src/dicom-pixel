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

package org.dicom4j.management.model.beans;

import java.util.ArrayList;
import java.util.List;

import org.dicom4j.management.TransferCapability;

/**
 * {@link TransferCapability TransferCapability} bean
 * 
 * @since 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class TransferCapabilityBean implements TransferCapability {

	/**
	 * the CommonName
	 */
	protected String fCommonName = "";

	protected boolean fisScp = false;

	// private SOPClass fSopClass;

	private String fSopClass = "";

	protected List<String> transferSyntaxes;

	public TransferCapabilityBean() {
		super();
		this.transferSyntaxes = new ArrayList<String>();
	}

	public void addTransferSyntax(String aTransferSyntax) {
		// TODO Auto-generated method stub

	}

	public String getCommonName() {
		return this.fCommonName;
	}

	public String getRole() {
		return this.fisScp ? TransferCapability.SCP : TransferCapability.SCU;
	}

	public String getSOPClass() {
		return this.fSopClass;
	}

	public List<String> getTransferSyntax() {
		return this.transferSyntaxes;
	}

	public void setCommonName(String aCommonName) {
		this.fCommonName = aCommonName;
	}

	public void setRole(String aRole) {
		if (aRole == null) {
			throw new NullPointerException("Role");
		}

		if (aRole.equals(SCP)) {
			this.fisScp = true;
		} else if (aRole.equals(SCU)) {
			this.fisScp = false;
		} else {
			throw new IllegalArgumentException("Role:" + aRole);
		}
	}

	public void setSOPClass(String aSopClass) {
		this.fSopClass = aSopClass;
	}

	/*
	 * public void setTransferSyntax(String[] aTransferSyntaxes) { if
	 * (fTransferSyntax.length == 0) { throw new
	 * IllegalArgumentException("transferSyntax.length = 0"); } for (int i = 0; i
	 * < fTransferSyntax.length; i++) { if (fTransferSyntax[i] == null) { throw
	 * new NullPointerException("transferSyntax[" + i + "]"); } }
	 * this.fTransferSyntax = fTransferSyntax.clone(); }
	 */

	public void setTransferSyntax(List<String> transferSyntaxes) {
		this.transferSyntaxes = transferSyntaxes;
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return this.getSOPClass();
	}

}
