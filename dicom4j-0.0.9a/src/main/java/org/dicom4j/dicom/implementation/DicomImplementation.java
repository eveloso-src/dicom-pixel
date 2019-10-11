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
package org.dicom4j.dicom.implementation;

import org.dicom4j.data.elements.ShortString;
import org.dicom4j.data.elements.UniqueIdentifier;

/**
 * <p>
 * DicomImplementation
 * </p>
 * 
 * a dicom implementation is used to manage implementation specific setting
 * needed we creating Dicom instances and sending data over a network
 * 
 * @since 0.0.8
 * @since 17 January 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface DicomImplementation {

	public UniqueIdentifier getImplementationClassUID();

	public ShortString getImplementationVersionName();

}
