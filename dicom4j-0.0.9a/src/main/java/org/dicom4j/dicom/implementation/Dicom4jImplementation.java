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

package org.dicom4j.dicom.implementation;

import org.dicom4j.core.Dicom4j;
import org.dicom4j.data.DataElements;
import org.dicom4j.data.elements.ShortString;
import org.dicom4j.data.elements.UniqueIdentifier;

/**
 * Dicom4j {@link DicomImplementation}
 * 
 * @since 0.1
 * @since 4 February 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class Dicom4jImplementation implements DicomImplementation {

	private static final long serialVersionUID = 1L;

	// private static final Logger logger =
	// LoggerFactory.getLogger(Dicom4jmplementation.class);

	private UniqueIdentifier implementationClassUID;

	private ShortString implementationVersionName;

	public Dicom4jImplementation() {
		super();
		this.implementationClassUID = DataElements.newImplementationClassUID();
		this.implementationClassUID.setValue(Dicom4j.VERSION_NAME);
		this.implementationVersionName = DataElements
		.newImplementationVersionName();
		this.implementationVersionName.setValue(Dicom4j.VERSION_NAME + "."
				+ Dicom4j.VERSION);
	}

	public UniqueIdentifier getImplementationClassUID() {
		return this.implementationClassUID;
	}

	public ShortString getImplementationVersionName() {
		return this.implementationVersionName;

	}

}
