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

package org.dicom4j.io.directory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * a Dicom Directory
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomDirectory {

	/**
	 * The Logger
	 */
	private static Logger flogger = LoggerFactory.getLogger(DicomDirectory.class);

	/**
	 * the root node
	 */
	private DicomDirectoryItem fRoot = new TopDirectoryItem();

	public DicomDirectoryItem getChild(Object node, int index) {
		return (DicomDirectoryItem) ((DicomDirectoryItem) node).getChildAt(index);
	}

	public DicomDirectoryItem getRoot() {
		return this.fRoot;
	}

	public boolean isLeaf(Object node) {
		return ((DicomDirectoryItem) node).getChildCount() == 0;
	}

}
