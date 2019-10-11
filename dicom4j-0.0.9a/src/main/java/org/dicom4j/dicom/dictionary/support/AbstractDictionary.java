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

package org.dicom4j.dicom.dictionary.support;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.dictionary.DicomDictionary;
import org.dicom4j.dicom.dictionary.DictionaryElements;
import org.dicom4j.dicom.dictionary.DictionarySopClass;
import org.dicom4j.dicom.dictionary.DictionaryTag;
import org.dicom4j.dicom.dictionary.item.SopClassDictionaryItem;
import org.dicom4j.dicom.dictionary.item.TransferSyntaxDictionaryItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base class to implement real {@link DicomDictionary DicomDictionary}
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractDictionary implements DicomDictionary {

	private static final Logger logger = LoggerFactory
	.getLogger(AbstractDictionary.class);

	// public abstract void read(String aFileName) throws Exception;

	private DictionaryElements fSOPClasses;

	// private TagElements fTags32;
	private LinkedList<?> modules;

	private TreeMap<String, SopClassDictionaryItem> sopClasses = new TreeMap<String, SopClassDictionaryItem>();

	private TreeMap<DicomTag, DicomTag> tags;

	private TreeMap<String, TransferSyntaxDictionaryItem> transferSyntaxItems = new TreeMap<String, TransferSyntaxDictionaryItem>();

	/**
	 * Creates new instance
	 * 
	 */
	public AbstractDictionary() {
		super();
		this.tags = new TreeMap<DicomTag, DicomTag>();
		this.fSOPClasses = new DictionaryElements();
		this.modules = new LinkedList<Object>();
	}

	public SopClassDictionaryItem addSOPClassItem(
			SopClassDictionaryItem sopClassItem) {
		this.sopClasses.put(sopClassItem.getKey(), sopClassItem);
		return sopClassItem;
	}

	public DicomTag addTag(DicomTag aTag) {
		this.tags.put(aTag, aTag);
		return aTag;
	}

	public TransferSyntaxDictionaryItem addTransferSyntaxtem(
			TransferSyntaxDictionaryItem item) {
		this.transferSyntaxItems.put(item.getKey(), item);
		return item;
	}

	protected LinkedList getModules() {
		return this.modules;
	}

	public Iterator getModulesIterator() {
		return this.getModules().iterator();
	}

	public String getNameFromTag(DicomTag aDicomTag) {
		DicomTag lElement = this.getTag(aDicomTag);
		if (lElement != null) {
			logger.info("null");
			return lElement.getName();
		} else {
			logger.info("unkown: " + aDicomTag.getElement());
			if (aDicomTag.isPrivate()) {
				return "Private Tag";
			} else if (aDicomTag.getElement() == 0x0000) {
				return "Group length";
			} else {
				logger.info("unkow");
				return "Unknown Tag";
			}
		}
	}

	public DictionarySopClass getSopClass(String aUID) {
		return (DictionarySopClass) this.fSOPClasses.get(aUID);
	}

	public Iterator<SopClassDictionaryItem> getSOPClassesIterator() {
		return this.sopClasses.values().iterator();
	}

	public SopClassDictionaryItem getSopClassItem(String sopClassUID) {
		logger.debug("getSopClassItem: " + sopClassUID);
		return this.sopClasses.get(sopClassUID); // (DictionarySopClass)
		// fSOPClasses.get(aUID);
	}

	public DicomTag getTag(DicomTag dicomTag) {
		assert this.tags != null;
		logger.debug("getTag: " + dicomTag);
		return this.tags.get(dicomTag);
	}

	public DicomTag getTag(int aGroup, int aElement) {
		return this.tags.get(new DicomTag(aGroup, aElement));
	}

	public Iterator<DictionaryTag> getTagIterator() {
		return this.getTags().values().iterator();
	}

	protected TreeMap getTags() {
		return this.tags;
	}

	public TransferSyntaxDictionaryItem getTransferSyntaxDictionaryItem(String key) {
		return this.transferSyntaxItems.get(key); // (DictionarySopClass)
		// fSOPClasses.get(aUID);
	}

	public Iterator<TransferSyntaxDictionaryItem> getTransferSyntaxesIterator() {
		return this.transferSyntaxItems.values().iterator();
	}

	public boolean hasTag(DicomTag aDicomTag) {
		return this.getTag(aDicomTag) != null;
	}

}
