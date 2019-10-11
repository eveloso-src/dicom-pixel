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

import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.dictionary.item.SopClassDictionaryItem;
import org.dicom4j.dicom.dictionary.item.TransferSyntaxDictionaryItem;
import org.dicom4j.modules.AbstractModule;

/**
 * <p>
 * DICOM Dictionary.
 * 
 * <p>
 * a Dictionary Contains:
 * <ul>
 * <li>Tags</li>
 * <li>SopClasses</li>
 * <li>TransferSyntaxes</li>
 * <li>Modules</li>
 * <li>Macros</li>
 * </ul>
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public interface DicomDictionary {

	/**
	 * add a {@link DictionarySopClass DictionarySopClass}
	 * 
	 * @since Alpha 0.0.3
	 * @param sopClassItem
	 * @return
	 */
	public SopClassDictionaryItem addSOPClassItem(
			SopClassDictionaryItem sopClassItem);

	/**
	 * Add a {@link DicomTag DicomTag}
	 * 
	 * @param aTag
	 * @return
	 */
	public DicomTag addTag(DicomTag aTag);

	/**
	 * Return an {@link Iterator Iterator} for
	 * {@link org.dicom4j.modules.AbstractModule Module}
	 * 
	 * @return the Iterator
	 */
	public Iterator<AbstractModule> getModulesIterator();

	/**
	 * Return the name of a Tag
	 * 
	 * @param aDicomTag
	 *          the tag
	 * @return the name of the tag
	 */
	public String getNameFromTag(DicomTag aDicomTag);

	/**
	 * Return an {@link Iterator Iterator} for {@link DictionarySopClass
	 * SOPClasses}
	 * 
	 * @since Alpha 0.0.3
	 * @return the Iterator
	 */
	public Iterator<SopClassDictionaryItem> getSOPClassesIterator();

	public SopClassDictionaryItem getSopClassItem(String aUID);

	/**
	 * Return a {@link DicomTag DicomTag} contains in the Dictionnary
	 * 
	 * @param aTag
	 *          the tag whith the same Group and Element from those who want from
	 *          the Dictionnary
	 * @return the tag
	 */
	public DicomTag getTag(DicomTag aDicomTag);

	/**
	 * Return a {@link DicomTag DicomTag} contains in the Dictionnary
	 * 
	 * @param aGroup
	 *          the tag's group
	 * @param aElement
	 *          the tag's element
	 * @return the tag
	 */
	public DicomTag getTag(int aGroup, int aElement);

	/**
	 * Return an {@link Iterator Iterator} for {@link DicomTag DicomTag}
	 * 
	 * @return the Iterator
	 */
	public Iterator<DictionaryTag> getTagIterator();

	public Iterator<TransferSyntaxDictionaryItem> getTransferSyntaxesIterator();

	/**
	 * Check if a tag is in the Dictionnary
	 * 
	 * @param aDicomTag
	 *          the tag to search
	 * @return true if is in
	 */
	public boolean hasTag(DicomTag aDicomTag);

}
