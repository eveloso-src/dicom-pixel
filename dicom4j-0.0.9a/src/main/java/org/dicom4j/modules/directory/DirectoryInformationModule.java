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

package org.dicom4j.modules.directory;

import org.dicom4j.data.DataElements;
import org.dicom4j.modules.AbstractModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Directory Information Module
 * 
 * @since 0.0.8
 * @since 5 march 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DirectoryInformationModule extends AbstractModule {

	private static final Logger logger = LoggerFactory
	.getLogger(DirectoryInformationModule.class);

	private static final long serialVersionUID = 1L;

	public DirectoryInformationModule() {
		super();
	}

	@Override
	public void addModuleElements() {
		this.addElement(DataElements.newOffsetOfFirstRootDirectoryRecord());
		this.addElement(DataElements.newOffsetOfLastRootDirectoryRecord());

		this.addElement(DataElements.newDirectoryRecordType());
	}

	@Override
	public String getName() {
		return "Directory Information Module";
	}

}
