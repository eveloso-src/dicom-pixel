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

import java.util.List;

import org.dicom4j.network.association.associate.AssociatePrimitiveFactory;

/**
 * Commons behavior for connectors and acceptors
 * 
 * @since 0.1
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface AssociationService {

	/**
	 * Send a A-Abort request to all connected {@link Association}
	 * 
	 */
	public void abortAssociations();

	/**
	 * return the number of connected Associations
	 * 
	 * @return
	 * @since 0.0.5
	 */
	public int count();

	/**
	 * return the {@link AssociatePrimitiveFactory}
	 * 
	 * @return the AssociatePrimitiveFactory
	 */
	public AssociatePrimitiveFactory getAssociatePrimitiveFactory();

	/**
	 * return the list of connected associations
	 * 
	 * @return
	 * @since 0.0.5
	 */
	public List<Association> getAssociations();

}
