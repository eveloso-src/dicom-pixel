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

import org.dicom4j.network.association.associate.AssociateAbort;
import org.dolmen.core.util.AbstractList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO make interface to manage
 * {@link org.dicom4j.network.association.Association Associations} created by
 * {@link org.dicom4j.network.association.AssociationAcceptor
 * AssociationAcceptor} or
 * {@link org.dicom4j.network.association.AssociationConnector
 * AssociationConnector}.
 * 
 * @deprecated
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
@Deprecated
public class AssociationManager extends AbstractList {

	private class AssociationReaper extends Thread {

		public AssociationReaper() {
			super("AssociationReaper");
		}

		@Override
		public void run() {
			try {
				while (true) {
					Thread.sleep(5000);
					for (int i = 0; i < AssociationManager.this.count(); i++) {
						Association lAssoc = AssociationManager.this.getAssociation(i);
						if (lAssoc.isReleased()) {
							fLogger.info("[AssociationReaper] " + lAssoc.toString()
									+ " removed");
							AssociationManager.this.remove(lAssoc);
						}
					}
				}
			} catch (Exception e) {
				fLogger.error("[AssociationReaper] " + e.getMessage());
			}

		}
	}

	private static Logger fLogger = LoggerFactory
	.getLogger(AssociationManager.class);

	private AssociationReaper fAssociationReaper;

	public AssociationManager() {
		super();
		this.fAssociationReaper = new AssociationReaper();
		this.fAssociationReaper.setDaemon(true);
		this.fAssociationReaper.start();
	}

	public synchronized void abortAssocation(Association aAssociation) {
		try {
			aAssociation.sendAbort(AssociateAbort.ServiceUserAbort);
		} catch (Exception e) {
			fLogger.error(e.getMessage());
		}
	}

	public synchronized void abortAssociations() {
		for (int i = 0; i < this.count(); i++) {
			Association lAssoc = this.getAssociation(i);
			// if not Released, when send a Abort to close the association
			if (!lAssoc.isReleased()) {
				this.abortAssocation(lAssoc);
			}
		}
	}

	public synchronized void addAssocation(Association aAssociation) {
		super.addItem(aAssociation);
	}

	public synchronized Association getAssociation(int aItem) {
		return (Association) this.fItems.get(aItem);
	}

	public synchronized void realeaseAssocation(Association aAssociation) {
	}

}
