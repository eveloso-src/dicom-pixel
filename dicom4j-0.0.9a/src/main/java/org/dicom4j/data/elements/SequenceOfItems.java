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

package org.dicom4j.data.elements;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.SpecificCharacterSet;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.io.DicomInputStream;
import org.dicom4j.io.DicomOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Sequence (SQ) {@link DataElement Attribute}
 * </p>
 * 
 * @since Alpha 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class SequenceOfItems extends DataElement {

	private static final Logger fLogger = LoggerFactory
	.getLogger(SequenceOfItems.class);

	// no constructor for input stream ... done manually elsewhere
	// TODO the read MUST BE HERE

	/**
	 * @param list
	 * @param tag
	 * @param dflt
	 */
	public static String getMeaningOfCodedSequenceAttributeOrDefault(
			DataSet list, DicomTag tag, String dflt) {
		String meaning = dflt;
		DataElement a = getNamedAttributeFromWithinSequenceWithSingleItem(list,
				tag, DicomTags.CodeMeaning);
		if (a != null) {
			meaning = a.getSingleStringValue(dflt);
		}
		return meaning;
	}

	/**
	 * <p>
	 * From within a list of attributes, get the specified sequence which has one
	 * item, and from within that extract the specified attribute.
	 * </p>
	 * 
	 * @param list
	 *          the list that contains the sequence (may not be null)
	 * @param sequenceTag
	 *          the tag of the sequence attribute that has one item
	 * @param namedTag
	 *          the tag of the attribute within the item of the sequence
	 * @return the attribute if found else null
	 */
	public static DataElement getNamedAttributeFromWithinSequenceWithSingleItem(
			DataSet list, DicomTag sequenceTag, DicomTag namedTag) {
		SequenceOfItems sequenceAttribute = (SequenceOfItems) list
		.getElement(sequenceTag);
		return getNamedAttributeFromWithinSequenceWithSingleItem(sequenceAttribute,
				namedTag);
	}

	/**
	 * <p>
	 * From the specified sequence which has one item, and from within that
	 * extract the specified attribute.
	 * </p>
	 * 
	 * @param sequenceAttribute
	 *          the sequence attribute that has one item (may be null in which
	 *          case returns null)
	 * @param namedTag
	 *          the tag of the attribute within the item of the sequence
	 * @return the attribute if found else null
	 */
	public static DataElement getNamedAttributeFromWithinSequenceWithSingleItem(
			SequenceOfItems sequenceAttribute, DicomTag namedTag) {
		DataElement a = null;
		if (sequenceAttribute != null) {
			// assert sequenceAttribute.getNumberOfItems() == 1
			Iterator sitems = sequenceAttribute.iterator();
			if (sitems.hasNext()) {
				SequenceItems sitem = (SequenceItems) sitems.next();
				DataSet slist = sitem.getDataSet();
				if (slist != null) {
					a = slist.getElement(namedTag);
				}
			}
		}
		return a;
	}

	private LinkedList<SequenceItems> fItems; // each member is a SequenceItem

	/**
	 * <p>
	 * Creates a new DataElement
	 * </p>
	 * 
	 * @param aDataElementTag
	 *          the tag of the element
	 */
	public SequenceOfItems(DicomTag aDataElementTag) {
		super(aDataElementTag);
		this.fItems = new LinkedList<SequenceItems>();
		this.fValueLength = 0xffffffffl; // for the benefit of writebase();
	}

	/**
	 * Add an item to the sequence (after any existing items).
	 * 
	 * @param item
	 *          the list of attributes that comprise the item
	 */
	/*
	 * public void addItem(AttributeList item) { itemList.addLast(new
	 * SequenceItem(item)); }
	 */

	public void addItem(DataSet aItem) {
		this.fItems.addLast(new SequenceItems(aItem));
	}

	/**
	 * Add an item to the sequence (after any existing items), keeping tracking of
	 * input byte offsets.
	 * 
	 * @param item
	 *          the list of attribuites that comprise the item
	 * @param byteOffset
	 *          the byte offset in the input stream of the start of the item
	 */
	/*
	 * public void addItem(AttributeList item,long byteOffset) {
	 * itemList.addLast(new SequenceItem(item,byteOffset)); }
	 */

	/**
	 * 
	 * @param aItem
	 * @param byteOffset
	 */
	public void addItem(DataSet aItem, long byteOffset) {
		this.fItems.addLast(new SequenceItems(aItem, byteOffset));
	}

	@Override
	public void clear() {
		fLogger.debug("clear()");
		for (int i = 0; i < this.count(); i++) {
			SequenceItems lItems = this.getItem(i);
			if (lItems != null) {
				lItems.clear();
			}
		}
	}

	/**
	 * get the number of items in the sequence.
	 * 
	 * @return the number of items
	 */
	public int count() {
		return this.fItems.size();
	}

	/**
	 * Get an {@link SequenceItem} by his index in the sequence.
	 * 
	 * @param index
	 *          which item to return, numbered from zero
	 * @return the item or null if no items or no such item
	 */
	public SequenceItems getItem(int index) {
		return (this.fItems == null) || (index >= this.fItems.size()) ? null
				: (SequenceItems) this.fItems.get(index);
	}

	/**
	 * Return the value representation of this data element
	 * 
	 * @return the value representation (SQ)
	 */
	@Override
	public ValueRepresentation getValueRepresentation() {
		return ValueRepresentation.SequenceOfItems;
	}

	/**
	 * <p>
	 * Get the value representation of this attribute (SQ).
	 * </p>
	 * 
	 * @deprecated
	 * @return 'S','Q' in ASCII as a two byte array; see
	 */
	@Deprecated
	public byte[] getVR() {
		return ValueRepresentation.SQ;
	}

	/**
	 * @deprecated
	 * @return
	 */
	@Deprecated
	public int itemsCount() {
		return this.fItems.size();
	}

	/**
	 * Get an {@link java.util.Iterator Iterator} of the items in the sequence.
	 * 
	 * @return a {@link java.util.Iterator Iterator} of items, each encoded as an
	 *         {@link org.dicom4j.data.elements.SequenceItem SequenceItem}
	 */
	public Iterator<SequenceItems> iterator() {
		return this.fItems.iterator(); // listIterator(0);
	}

	@Override
	public void read(DicomInputStream aStream, long aLength,
			SpecificCharacterSet aCharacterSet) throws IOException, DicomException {
		// TODO
	}

	/***/
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append(super.toString());
		str.append("\n%seq\n");
		Iterator i = this.iterator();
		while (i.hasNext()) {
			str.append(((SequenceItems) i.next()).toString());
			str.append("\n");
		}
		str.append("%endseq");
		return str.toString();
	}

	/**
	 * @param o
	 * @exception IOException
	 * @exception DicomException
	 */
	@Override
	public void write(DicomOutputStream o) throws DicomException, IOException {
		fLogger.debug("Start write");
		this.writeBase(o); // valueLength should be 0xffffffff from constructor

		Iterator i = this.iterator();
		while (i.hasNext()) {
			SequenceItems item = (SequenceItems) i.next();
			item.write(o);
		}

		o.writeUnsigned16(0xfffe); // Sequence Delimiter
		o.writeUnsigned16(0xe0dd);
		o.writeUnsigned32(0); // dummy length
		fLogger.debug("end write");
	}

}
