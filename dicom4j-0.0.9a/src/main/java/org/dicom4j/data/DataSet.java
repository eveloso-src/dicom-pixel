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

package org.dicom4j.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.TreeMap;

import org.dicom4j.data.elements.ApplicationEntity;
import org.dicom4j.data.elements.CodeString;
import org.dicom4j.data.elements.DateElement;
import org.dicom4j.data.elements.IntegerString;
import org.dicom4j.data.elements.LongString;
import org.dicom4j.data.elements.LongText;
import org.dicom4j.data.elements.OtherByteString;
import org.dicom4j.data.elements.PersonName;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.data.elements.ShortString;
import org.dicom4j.data.elements.Time;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.UnsignedLong;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.ValueRepresentation;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.DicomReader;
import org.dicom4j.io.DicomWriter;
import org.dicom4j.io.file.DicomFileReader;
import org.dicom4j.io.file.DicomFileWriter;
import org.dicom4j.io.media.DicomFile;
import org.dicom4j.modules.AbstractModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * DICOM DataSet (list of{@link DataElements} )
 * </p>
 * 
 * <p>
 * a dataset is used to manage a list of elements.
 * <p>
 * this class offer specific getter of setter to get/set elements depending of
 * their type. A cast error will be raised if you try to get an element of a
 * wrong type.
 * </p>
 * 
 * @see DicomFileReader
 * @see DicomFileWriter
 * @see DicomFile
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DataSet {

	private final static Logger logger = LoggerFactory.getLogger(DataSet.class);

	private static final long serialVersionUID = 1L;

	/**
	 * <p>
	 * Get the values of a named attribute in an attribute list, as an array of
	 * double.
	 * </p>
	 * 
	 * <p>
	 * If there is no such attribute, <code>null</code> is returned.
	 * </p>
	 * 
	 * <p>
	 * If there is an exception trying to fetch the values, <code>null</code> is
	 * returned.
	 * </p>
	 * 
	 * @param aDataSet
	 *          the list of attributes in which to look for the attribute
	 * @param tag
	 *          the tag of the attribute to find
	 * @return the values as an array of double
	 */
	public static double[] getDoubleValues(DataSet aDataSet, DicomTag tag) {
		assert aDataSet != null;
		double[] values = null;
		if (aDataSet != null) {
			DataElement a = aDataSet.getElement(tag);
			if (a != null) {
				try {
					values = a.getDoubleValues();
				} catch (DicomException e) {
				}
			}
		}
		return values;
	}

	/**
	 * The stored Elements
	 */
	private TreeMap<DicomTag, DataElement> dataElements;

	public DataSet() {
		super();
		this.dataElements = new TreeMap<DicomTag, DataElement>();
	}

	public DataSet(DataSet aDataSet) {
		super();
		// fDataElements = aDataSet. new TreeMap();
	}

	/**
	 * add a new {@link ApplicationEntity} element, and set the single sting value
	 * 
	 * @param element
	 *          the element to add
	 * @param aSingleValue
	 *          the single string value to set
	 * @return the added element
	 * @since 0.0.8
	 */
	public ApplicationEntity addApplicationEntity(ApplicationEntity element,
			String singleValue) {
		element.setValue(singleValue);
		this.addElement(element);
		return element;
	}

	public CodeString addCodeString(CodeString element, String singleValue) {
		element.setValue(singleValue);
		this.addElement(element);
		return element;
	}

	/**
	 * add all data contains in the DataSet into this (NOT A COPY)
	 * 
	 * @param aDataSet
	 * @return the added DataSet
	 */
	public DataSet addDataSet(DataSet aDataSet) {
		Iterator<DataElement> i = aDataSet.getIterator();
		while (i.hasNext()) {
			this.addElement(i.next());
		}

		return aDataSet;
	}

	/**
	 * Add a new DataElement
	 * 
	 * @param aDataElement
	 *          the element to add
	 * @return the added element
	 * @see DataElement
	 */
	public DataElement addElement(DataElement aDataElement) {
		if (aDataElement == null) {
			logger.warn("trying to add a null DataElement");
			throw new NullPointerException();
		} else {
			// logger.debug("addDataElement: " + aDataElement.toString());
			this.dataElements.put(aDataElement.getTag(), aDataElement);
			return aDataElement;
		}
	}

	/**
	 * add an {@link IntegerString}, and set the supplied value
	 * 
	 * @param element
	 *          the element to add
	 * @param singleValue
	 *          the value to set
	 * @return the added element
	 * @since 0.0.8
	 */
	public IntegerString addIntegerString(IntegerString element,
			String singleValue) {
		element.setValue(singleValue);
		this.addElement(element);
		return element;
	}

	/**
	 * add an {@link LongString}, and set the supplied value
	 * 
	 * @param element
	 *          the element to add
	 * @param singleValue
	 *          the value to set
	 * @return the added element
	 * @since 0.0.9
	 */
	public LongString addLongString(LongString element, String singleValue) {
		element.setValue(singleValue);
		this.addElement(element);
		return element;
	}

	/**
	 * add a new {@link PersonName} element, and set the single sting value
	 * 
	 * @param element
	 *          the element to add
	 * @param aSingleValue
	 *          the single string value to set
	 * @return the added element
	 * @since 0.0.8
	 */

	/**
	 * Add a new module to the DataSet
	 * 
	 * @param aModule
	 *          the module to add
	 * @return the added module
	 */
	public AbstractModule addModule(AbstractModule aModule) {
		logger.debug("we added " + aModule.getName() + " module");
		return (AbstractModule) this.addDataSet(aModule);
	}

	/**
	 * add a new {@link PersonName} element
	 * 
	 * @param personNameElement
	 *          the element
	 * @return the added element
	 */
	public PersonName addPersonName(PersonName personNameElement) {
		return (PersonName) this.addElement(personNameElement);
	}

	/**
	 * add an {@link PersonName}, and set the supplied value
	 * 
	 * @param element
	 *          the element to add
	 * @param singleValue
	 *          the value to set
	 * @return the added element
	 * @since 0.0.8
	 */
	public PersonName addPersonName(PersonName element, String aSingleValue) {
		element.setValue(aSingleValue);
		this.addElement(element);
		return element;
	}

	public ShortString addShortString(ShortString element, String singleValue) {
		element.setValue(singleValue);
		this.addElement(element);
		return element;
	}

	/**
	 * add an {@link UniqueIdentifier}, and set the supplied value
	 * 
	 * @param element
	 *          the element to add
	 * @param singleValue
	 *          the value to set
	 * @return the added element
	 */
	public UniqueIdentifier addUniqueIdentifier(UniqueIdentifier element,
			String singleValue) {
		element.setValue(singleValue);
		this.addElement(element);
		return element;
	}

	/**
	 * add a new UniqueIdentifier to the dataset
	 * @param tag the element's tag 
	 * @return the added element
	 */
	public UniqueIdentifier addUniqueIdentifier(DicomTag tag) {
		return (UniqueIdentifier) this.addElement(new UniqueIdentifier(tag));
	}
	
	/**
	 * add a new {@link UnsignedShort} element to the dataSet
	 * 
	 * @param tag
	 *          the element's tag
	 * @return the add element
	 * @since 0.0.9
	 */
	public UnsignedShort addUnsignedShort(DicomTag tag) {
		return (UnsignedShort) this.addElement(new UnsignedShort(tag));
	}

	/**
	 * call clear method for all element.
	 */
	public void clear() {
		Iterator<DataElement> i = this.getIterator();
		while (i.hasNext()) {
			i.next().clear();
		}
	}

	/**
	 * Return the number of {@link org.dicom4j.data.elements.support.DataElement
	 * Elements} in the DataSet
	 * 
	 * @return number of {@link org.dicom4j.data.elements.support.DataElement
	 *         Elements}
	 */
	public int count() {
		return this.dataElements.size();
	}

	/**
	 * 
	 * @param aDataElementTag
	 * @return
	 * @throws NoSuchElementException
	 * @throws WrongDataElementTypeException
	 */
	public ApplicationEntity getApplicationEntity(DicomTag aDataElementTag)
	throws NoSuchElementException, WrongDataElementTypeException {
		DataElement lAttribute = this.getElement(aDataElementTag);
		if (!(lAttribute instanceof ApplicationEntity)) {
			throw new WrongDataElementTypeException(
					ValueRepresentation.ApplicationEntity, aDataElementTag);
		}
		return (ApplicationEntity) lAttribute;
	}

	/**
	 * get an ApplicationEntity element
	 * 
	 * @param aDataElementTag
	 *          the dicom tag
	 * @return
	 */
	public ApplicationEntity getApplicationEntityOrNull(DicomTag aDataElementTag) {
		DataElement lAttribute = this.getElementOrNull(aDataElementTag);
		if (lAttribute == null) {
			return null;
		}
		if (!(lAttribute instanceof ApplicationEntity)) {
			return null;
		} else {
			return (ApplicationEntity) lAttribute;
		}
	}

	/**
	 * @deprecated use iterator
	 * @param aIndex
	 * @return
	 */
	@Deprecated
	public DataElement getAttribute(int aIndex) {
		return (DataElement) this.dataElements.values().toArray()[aIndex];
	}

	public CodeString getCodeString(DicomTag tag) {
		DataElement lAttribute = this.getElement(tag);
		assert lAttribute != null;
		assert lAttribute instanceof CodeString;
		return (CodeString) this.getElement(tag);
	}

	/**
	 * Return all {@link org.dicom4j.data.elements.support.DataElement Attribute}
	 * of the same group
	 * 
	 * @param aGroup
	 *          the group
	 * @return
	 */
	public DataSet getDataElementsOfSameGroup(int aGroup) {
		DataSet lRes = new DataSet();
		for (int i = 0; i < this.count(); i++) {
			DataElement lElement = this.getAttribute(i);
			if (lElement.getTag().getGroup() == aGroup) {
				lRes.addElement(lElement);
			}
		}
		return lRes;
	}

	public DateElement getDate(DicomTag tag) {
		return (DateElement) this.getElement(tag);
	}

	// TODO check caller, this methods should always return element
	/**
	 * 
	 * Return the DataElement associated whith aAttributeTag
	 * 
	 * @param aAttributeTag
	 *          the Tag
	 * @return
	 */
	// TODO add throws NoSuchElementException
	public DataElement getElement(DicomTag aAttributeTag) {
		assert aAttributeTag != null;
		DataElement lElement = this.dataElements.get(aAttributeTag);
		// assert lElement != null;
		/*
		 * DataElement lElement = getElementOrNull(aAttributeTag); if ( lElement ==
		 * null) { throw new NoSuchElementException(aAttributeTag); } else { return
		 * lElement; }
		 */

		return lElement;
	}

	/**
	 * Retrun the DataElement associated whith aAttributeTa
	 * 
	 * @param aAttributeTag
	 *          the tag
	 * @return the element (can be null)
	 */
	public DataElement getElementOrNull(DicomTag aAttributeTag) {
		assert aAttributeTag != null;
		return this.dataElements.get(aAttributeTag);
	}

	/**
	 * Return a {@link IntegerString} element depending of the supplied
	 * {@link DicomTag}
	 * 
	 * @param tag
	 *          the element's tag
	 * @return the element
	 * @throws NoSuchElementException
	 *           if the element isn't not present in the dataset
	 * @throws WrongDataElementTypeException
	 *           if the element's type is not IntegerString
	 */
	public IntegerString getIntegerString(DicomTag tag)
	throws NoSuchElementException, WrongDataElementTypeException {
		DataElement lAttribute = this.getElement(tag);
		if (!(lAttribute instanceof IntegerString)) {
			throw new WrongDataElementTypeException(
					ValueRepresentation.IntegerString, tag);
		}
		return (IntegerString) lAttribute;
	}

	/**
	 * Return an {@link Iterator Iterator} for this DataSet
	 * 
	 * @return the Iterator
	 */
	public Iterator<DataElement> getIterator() {
		return this.dataElements.values().iterator();
	}

	public LongString getLongString(DicomTag tag) {
		return (LongString) this.getElement(tag);
	}

	public LongString getLongStringOrNull(DicomTag aDataElementTag) {
		DataElement lAttribute = this.getElementOrNull(aDataElementTag);
		if (lAttribute == null) {
			return null;
		}
		if (!(lAttribute instanceof LongString)) {
			return null;
		} else {
			return (LongString) lAttribute;
		}
	}

	public LongText getLongText(DicomTag aDataElementTag)
	throws NoSuchElementException, WrongDataElementTypeException {
		DataElement lAttribute = this.getElement(aDataElementTag);
		if (!(lAttribute instanceof LongText)) {
			throw new WrongDataElementTypeException(ValueRepresentation.LongText,
					aDataElementTag);
		}
		return (LongText) lAttribute;
	}

	public LongText getLongTextOrNull(DicomTag aDataElementTag) {
		DataElement lAttribute = this.getElementOrNull(aDataElementTag);
		if (lAttribute == null) {
			return null;
		}
		if (!(lAttribute instanceof LongText)) {
			return null;
		} else {
			return (LongText) lAttribute;
		}
	}

	public OtherByteString getOtherByteString(DicomTag aDataElementTag) {
		DataElement lAttribute = this.getElement(aDataElementTag);
		assert lAttribute != null;
		assert lAttribute instanceof OtherByteString;
		return (OtherByteString) lAttribute;
	}

	public OtherByteString getOtherByteStringOrNull(DicomTag aDataElementTag) {
		DataElement lAttribute = this.getElementOrNull(aDataElementTag);
		if (lAttribute == null) {
			return null;
		}
		if (!(lAttribute instanceof OtherByteString)) {
			return null;
		} else {
			return (OtherByteString) lAttribute;
		}
	}

	public PersonName getPersonName(DicomTag tag) {
		DataElement lAttribute = this.getElement(tag);
		assert lAttribute != null;
		assert lAttribute instanceof PersonName;
		return (PersonName) this.getElement(tag);
	}

	public PersonName getPersonNameOrNull(DicomTag aDataElementTag) {
		DataElement lAttribute = this.getElementOrNull(aDataElementTag);
		if (lAttribute == null) {
			return null;
		}
		if (!(lAttribute instanceof PersonName)) {
			return null;
		} else {
			return (PersonName) lAttribute;
		}
	}

	/**
	 * get a {@link SequenceOfItems SequenceOfItems} element
	 * 
	 * @param tag
	 * @return
	 */
	public SequenceOfItems getSequenceOfItems(DicomTag tag) {
		return (SequenceOfItems) this.getElement(tag);
	}

	/**
	 * get a {@link SequenceOfItems SequenceOfItems} element or Null
	 * 
	 * @param aDataElementTag
	 * @return
	 */
	public SequenceOfItems getSequenceOfItemsOrNull(DicomTag aDataElementTag) {
		DataElement lAttribute = this.getElementOrNull(aDataElementTag);
		if (lAttribute == null) {
			return null;
		}
		if (!(lAttribute instanceof SequenceOfItems)) {
			return null;
		} else {
			return (SequenceOfItems) lAttribute;
		}
	}

	public ShortString getShortString(DicomTag aTag) {
		DataElement lAttribute = this.getElement(aTag);
		assert lAttribute != null;
		assert lAttribute instanceof ShortString;
		return (ShortString) lAttribute;
	}

	public Time getTime(DicomTag tag) {
		return (Time) this.getElement(tag);
	}

	public UniqueIdentifier getUniqueIdentifier(DicomTag aDataElementTag) throws NoSuchElementException, WrongDataElementTypeException {
		DataElement lAttribute = this.getElement(aDataElementTag);
		assert lAttribute != null;
		if (!(lAttribute instanceof UniqueIdentifier)) {
			throw new WrongDataElementTypeException( ValueRepresentation.UniqueIdentifier, aDataElementTag);
		}
		return (UniqueIdentifier) lAttribute;
	}

	public UniqueIdentifier getUniqueIdentifierOrNull(DicomTag aDataElementTag) {
		DataElement lAttribute = this.getElementOrNull(aDataElementTag);
		if (lAttribute == null) {
			return null;
		}
		if (!(lAttribute instanceof UniqueIdentifier)) {
			return null;
		} else {
			return (UniqueIdentifier) lAttribute;
		}
	}

	public UnsignedLong getUnsignedLong(DicomTag tag) {
		DataElement lAttribute = this.getElement(tag);
		assert lAttribute != null;
		assert lAttribute instanceof UnsignedLong;
		return (UnsignedLong) lAttribute;
	}

	public UnsignedLong getUnsignedLongOrNull(DicomTag aDataElementTag) {
		DataElement lAttribute = this.getElementOrNull(aDataElementTag);
		if (lAttribute == null) {
			return null;
		}
		if (!(lAttribute instanceof UnsignedLong)) {
			return null;
		} else {
			return (UnsignedLong) lAttribute;
		}
	}

	public UnsignedShort getUnsignedShort(DicomTag aDataElementTag) {
		logger.debug("getUnsignedShort: " + aDataElementTag.getName() );
		DataElement lAttribute = this.getElement(aDataElementTag);
		assert lAttribute != null;
		/*if (!(lAttribute instanceof UniqueIdentifier)) {
			throw new WrongDataElementTypeException( ValueRepresentation.UnsignedShort, aDataElementTag);
		}*/
		assert lAttribute instanceof UnsignedShort;
		return (UnsignedShort) lAttribute;
	}

	public boolean hasElement(DicomTag aAttributeTag) {
		return exist(aAttributeTag);
	}
	
	public boolean exist(DicomTag aAttributeTag) {
		return this.dataElements.get(aAttributeTag) != null;		
	}

	/**
	 * populate the DataSet from data readed from bytes
	 * 
	 * @deprecated use reader instead
	 * @param aBytes
	 *          the bytes to read
	 * @param aTransferSyntax
	 *          the TransferSyntax to use
	 * @throws IOException
	 * @throws DicomException
	 */
	@Deprecated
	public void read(byte[] aBytes, TransferSyntax aTransferSyntax)
	throws IOException, DicomException, Exception {
		DicomReader lReader = new DicomReader(aBytes);
		lReader.read(this, aTransferSyntax);
	}

	/**
	 * populate the DataSet from data readed from a Stream
	 * 
	 * @deprecated use reader instead
	 * @param aStream
	 *          the Stream to read
	 * @param aTransferSyntax
	 *          the TransferSyntax to use
	 * @throws IOException
	 * @throws DicomException
	 */
	@Deprecated
	public void read(InputStream aStream, TransferSyntax aTransferSyntax)
	throws IOException, DicomException, Exception {
		DicomReader lReader = new DicomReader(aStream);
		lReader.read(this, aTransferSyntax);
	}

	/**
	 * Remove all elements
	 * 
	 */
	public void removeAll() {
		this.dataElements.clear();
	}

	/**
	 * remove the supplied element from the Dataset
	 * 
	 * @param element
	 *          the element to remote
	 * @return the removed element (null is element is null too)
	 */
	public DataElement removeElement(DataElement element) {
		if (element == null) {
			logger.warn("removeElement: null was supplied");
			return null;
		} else {
			return this.removeElement(element.getTag());
		}
	}

	/**
	 * remove an element depending of his tag
	 * 
	 * @param tag
	 *          the tag
	 * @return the remove element (or null if not present in the Dataset)
	 */
	public DataElement removeElement(DicomTag tag) {
		DataElement lElement = this.dataElements.remove(tag);
		logger.debug(tag.getName() + " removed from DataSet");
		return lElement;
	}

	/**
	 * get all elements as an array of objects
	 * 
	 * @return
	 */
	public Object[] toArray() {
		return this.dataElements.values().toArray();
	}

	/**
	 * @deprecated
	 */
	@Deprecated
	public byte[] toBytes(TransferSyntax aTransferSyntax) throws IOException,
	DicomException {
		return DicomWriter.getDataSetToBytes(this, aTransferSyntax);
	}

	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();

		Iterator<DataElement> i = this.dataElements.values().iterator();
		while (i.hasNext()) {
			str.append(i.next().toString());
			str.append("\n");
		}
		return str.toString();
	}

	/**
	 * Write the DataSet into a stream
	 * 
	 * @deprecated use reader instead
	 * @param aStream
	 *          the Stream to write
	 * @param aTransferSyntax
	 *          the TransferSyntax to use
	 * @throws IOException
	 * @throws DicomException
	 */
	@Deprecated
	public void write(OutputStream aStream, TransferSyntax aTransferSyntax)
	throws IOException, DicomException {
		DicomWriter lWriter = new DicomWriter(aStream);
		lWriter.write(this, aTransferSyntax);
	}
}
