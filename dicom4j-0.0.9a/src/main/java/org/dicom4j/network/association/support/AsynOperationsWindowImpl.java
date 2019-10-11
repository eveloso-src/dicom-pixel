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

package org.dicom4j.network.association.support;

import java.util.Iterator;
import java.util.TreeMap;

import org.dicom4j.network.association.AsynOperationsWindow;
import org.dicom4j.network.association.listeners.AssociationListener;
import org.dicom4j.network.association.listeners.DefaultAssociationListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class AsynOperationsWindowImpl implements AsynOperationsWindow {

	protected static final Logger LOGGER = LoggerFactory
	.getLogger(AsynOperationsWindowImpl.class);

	private AssociationListener fAssociationHandler;

	private TreeMap<Integer, AsynOperation> fOperations;

	public AsynOperationsWindowImpl() {
		super();
		this.fOperations = new TreeMap<Integer, AsynOperation>();
	}

	public AsynOperation addAsynOperation(int aMessageID) {
		LOGGER.debug("addAsynOperation: " + aMessageID);
		AsynOperation lOP = new AsynOperation(aMessageID);
		this.fOperations.put(lOP.getMessageID(), lOP);
		return lOP;
	}

	public int count() {
		return this.fOperations.size();
	}

	public AssociationListener getAssociationListener() {
		if (this.fAssociationHandler == null) {
			return this.fAssociationHandler;
		} else {
			return new DefaultAssociationListener();
		}
	}

	public AsynOperation getAsynOperation(int aMessageID) {
		return this.fOperations.get(new Integer(aMessageID));
	}

	public Iterator<AsynOperation> getIterator() {
		return this.fOperations.values().iterator();
	}

	public void removeAsynOperation(int aMessageID) {
		LOGGER.debug("removeAsynOperation: " + aMessageID);
		this.fOperations.remove(new Integer(aMessageID));
	}

	public void setAssociationListener(AssociationListener aListener) {
		this.fAssociationHandler = aListener;
	}
}
