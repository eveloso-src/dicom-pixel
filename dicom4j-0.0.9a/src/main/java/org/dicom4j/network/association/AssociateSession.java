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

/**
 * 
 */
package org.dicom4j.network.association;

/**
 * Associate Session (ie: parameters of an Association opened between 2 dicom
 * nodes)
 * 
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface AssociateSession {

	public long getMaximumLength();

	public int getMaximumNumberOperationsInvoked();

	/**
	 * return the response's called Application Entity Title
	 * 
	 * @since 0.0.9
	 * @return The called AET
	 */
	public String getResponseCalledAET();

	/**
	 * return the response's calling Application Entity Title
	 * 
	 * @since 0.0.9
	 * @return The calling AET
	 */
	public String getResponseCallingAET();

}
