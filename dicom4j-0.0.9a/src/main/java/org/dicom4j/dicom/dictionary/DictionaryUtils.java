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

package org.dicom4j.dicom.dictionary;

import java.util.Iterator;

import org.dicom4j.dicom.DicomTagList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 0.1
 * @since 9 January 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public final class DictionaryUtils {

	private static final Logger logger = LoggerFactory.getLogger(DictionaryUtils.class);

	private static final long serialVersionUID = 1L;

	public static DicomTagList getDicomTagListFromDictionaryIterator(
			Iterator<DictionaryTag> it) {
		logger.debug("DictionaryIteratortoDicomTagList");
		DicomTagList tagList = new DicomTagList();
		while (it.hasNext()) {
			tagList.add(it.next());
		}
		return tagList;
	}

}
