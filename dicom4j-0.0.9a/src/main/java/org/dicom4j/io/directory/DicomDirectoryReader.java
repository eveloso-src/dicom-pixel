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

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import org.dicom4j.data.DataSet;
import org.dicom4j.data.elements.CodeString;
import org.dicom4j.data.elements.SequenceItems;
import org.dicom4j.data.elements.SequenceOfItems;
import org.dicom4j.data.elements.UniqueIdentifier;
import org.dicom4j.data.elements.support.DataElement;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * DicomDir reader
 * <p>
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomDirectoryReader {

	/**
	 * The Logger
	 */
	private static Logger logger = LoggerFactory
	.getLogger(DicomDirectoryReader.class);

	/**
	 * @param sopInstanceUID
	 */
	/*
	 * public String getReferencedFileNameForSOPInstanceUID(String sopInstanceUID)
	 * throws DicomException { if (mapOfSOPInstanceUIDToReferencedFileName ==
	 * null) { throw new DicomException("Map of SOPInstanceUID to
	 * ReferencedFileName has not been initialized"); } else { return
	 * (String)(mapOfSOPInstanceUIDToReferencedFileName.get(sopInstanceUID)); } }
	 * 
	 * /** @param parent @param components
	 */
	private static String buildPathFromParentAndStringArray(String parent,
			String[] components) {
		File path = parent == null ? null : new File(parent);
		for (int i = 0; i < components.length; ++i) {
			path = path == null ? new File(components[i]) : new File(path,
					components[i]);
		}
		return path.getPath();
	}

	/**
	 * <p>
	 * Get all the referenced file names at or below the specified directory
	 * record.
	 * </p>
	 * 
	 * @param record
	 * @param parentFilePath
	 *          the folder in which the DICOMDIR lives (i.e., the base for
	 *          contained references)
	 * @return a java.util.Vector of string file names fully qualified by the
	 *         specified parent
	 */
	public static Vector findAllContainedReferencedFileNames(
			DicomDirectoryItem record, String parentFilePath) {
		// long startTime = System.currentTimeMillis();
		Vector names = new Vector();
		// String name = getReferencedFileName(record,parentFilePath);
		// if (name != null) names.add(name);
		// int nChildren = record.getChildCount();
		// for (int i=0; i<nChildren; ++i) {
		// DicomDirectoryRecord child=(DicomDirectoryRecord)(record.getChildAt(i));
		// names.addAll(findAllContainedReferencedFileNames(child,parentFilePath));
		// }
		// return names;
		HashMap map = findAllContainedReferencedFileNamesAndTheirRecords(record,
				parentFilePath);
		names.addAll(map.keySet());
		// long currentTime = System.currentTimeMillis();
		// System.err.println("DicomDirectory.findAllContainedReferencedFileNames():
		// took = "+(currentTime-startTime)+" ms");
		return names;
	}

	/**
	 * <p>
	 * Get all the referenced file names at or below the specified directory
	 * record, and a map to the directory records that reference them.
	 * </p>
	 * 
	 * @param record
	 * @param parentFilePath
	 *          the folder in which the DICOMDIR lives (i.e., the base for
	 *          contained references)
	 * @return a java.util.HashMap whose keys are string file names fully
	 *         qualified by the specified parent, mapped to DicomDirectoryRecords
	 */
	public static HashMap findAllContainedReferencedFileNamesAndTheirRecords(
			DicomDirectoryItem record, String parentFilePath) {
		HashMap map = new HashMap();
		String name = getReferencedFileName(record, parentFilePath);
		if (name != null) {
			map.put(name, record);
		}
		int nChildren = record.getChildCount();
		for (int i = 0; i < nChildren; ++i) {
			DicomDirectoryItem child = (DicomDirectoryItem) record.getChildAt(i);
			map.putAll(findAllContainedReferencedFileNamesAndTheirRecords(child,
					parentFilePath));
		}
		return map;
	}

	/**
	 * @param record
	 * @param parentFilePath
	 */
	private static String getReferencedFileName(DicomDirectoryItem record,
			String parentFilePath) {
		String name = null;
		DataSet list = record.getDataSet();
		if (list != null) {
			// System.err.println(list);
			try {
				DataElement a = list.getElement(DicomTags.RefFileID);
				if (a != null) {
					String[] filePath = a.getStringValues();
					name = buildPathFromParentAndStringArray(parentFilePath, filePath);
				}
			} catch (DicomException e) {
			}
		}
		return name;
	}

	private DataSet dataSet;

	/**
	 * the Factory to create items
	 */
	private DicomDirectoryRecordFactory itemFactory = new DicomDirectoryRecordFactory();

	private TreeMap mapOffsetToSequenceItemAttributeList;

	/***/
	private Map mapOfSOPInstanceUIDToReferencedFileName;

	/**
	 * @param aDataSet
	 * @exception DicomException
	 */
	public DicomDirectoryReader(DataSet aDataSet) throws DicomException {
		super();
		this.dataSet = aDataSet;
		assert this.dataSet != null;
	}

	/**
	 * @param node
	 */
	/*
	 * private String walkTree(DicomDirectoryItem node) { StringBuffer buffer =
	 * new StringBuffer(); buffer.append(node.toString()); buffer.append("\n");
	 * 
	 * int n = node.getChildCount();//getChildCount(node); for (int i=0; i<n; ++i)
	 * buffer.append(walkTree((DicomDirectoryItem)node.getChildAt(i)));
	 * 
	 * return buffer.toString(); }
	 */
	/***/
	/*
	 * public String toString() { return walkTree(root); }
	 */

	/**
	 * @param node
	 * @param wantConcatenationUID
	 * @param useInstanceNumber
	 * @exception DicomException
	 */
	private DicomDirectoryItem findOrInsertNewConcatenationDirectoryRecord(
			DicomDirectoryItem node, String wantConcatenationUID,
			String useInstanceNumber) throws DicomException {
		// System.err.println("findOrInsertNewConcatenationDirectoryRecord:
		// "+wantConcatenationUID);
		// System.err.println("findOrInsertNewConcatenationDirectoryRecord:
		// searching parent "+node);
		DicomDirectoryItem found = null;
		int n = node.getChildCount(); // getChildCount(node);
		// System.err.println("findOrInsertNewConcatenationDirectoryRecord: child
		// count="+n);
		for (int i = 0; i < n; ++i) {
			DicomDirectoryItem lChildItem = (DicomDirectoryItem) node.getChildAt(i);
			// System.err.println("findOrInsertNewConcatenationDirectoryRecord:
			// examining child "+child);
			if (lChildItem.getType().equals(DirectoryRecordType.CONCATENATION)) {
				// System.err.println("findOrInsertNewConcatenationDirectoryRecord: have
				// ConcatenationDirectoryRecord");
				DataSet list = lChildItem.getDataSet();
				String haveConcatenationUID = DataElement.getSingleStringValueOrNull(
						list, DicomTags.ConcatenationUID);
				// System.err.println("findOrInsertNewConcatenationDirectoryRecord:
				// comparing with existing ConcatenationDirectoryRecord
				// "+haveConcatenationUID);
				if ((haveConcatenationUID != null) && (wantConcatenationUID != null)
						&& haveConcatenationUID.equals(wantConcatenationUID)) {
					// System.err.println("findOrInsertNewConcatenationDirectoryRecord:
					// match");
					found = lChildItem;
					break;
				}
			}
		}
		if (found == null) {
			// TODO
			// System.err.println("findOrInsertNewConcatenationDirectoryRecord: making
			// new one");
			DataSet list = new DataSet();
			DataElement directoryRecordType = new CodeString(
					DicomTags.DirectoryRecordType);
			directoryRecordType.addValue("CONCATENATION");
			list.addElement(directoryRecordType);
			DataElement concatenationUID = new UniqueIdentifier(
					DicomTags.ConcatenationUID);
			concatenationUID.addValue(wantConcatenationUID);
			list.addElement(concatenationUID);
			if (useInstanceNumber != null) {
				DataElement instanceNumber = new CodeString(DicomTags.InstanceNumber);
				instanceNumber.addValue(useInstanceNumber);
				list.addElement(instanceNumber);
			}
			found = this.itemFactory.newDicomDirectoryItem(node, list);
			node.addChild(found);
		}
		return found;
	}

	/**
	 * @param node
	 * @exception DicomException
	 */
	private void insertConcatenationNodes(DicomDirectoryItem node)
	throws DicomException {
		// System.err.println("insertConcatenationNodes:");
		int n = node.getChildCount(); // getChildCount(node);
		int i = 0;
		while (i < n) {
			DicomDirectoryItem lChild = (DicomDirectoryItem) node.getChildAt(i);
			if (node.getType().equals(DirectoryRecordType.SERIES)
					&& lChild.getType().equals(DirectoryRecordType.IMAGE)) {
				// System.err.println("insertConcatenationNodes: testing child
				// ["+i+"]");
				DataSet list = lChild.getDataSet();
				String concatenationUID = DataElement.getSingleStringValueOrNull(list,
						DicomTags.ConcatenationUID);
				if (concatenationUID != null) {
					String instanceNumber = DataElement.getSingleStringValueOrNull(list,
							DicomTags.InstanceNumber);
					DicomDirectoryItem concatenation = this
					.findOrInsertNewConcatenationDirectoryRecord(node,
							concatenationUID, instanceNumber);
					// System.err.println("insertConcatenationNodes:concatenation in
					// series is: "+concatenation);
					// System.err.println("insertConcatenationNodes:removing child from
					// series: "+child);
					node.removeChild(lChild);
					// System.err.println("insertConcatenationNodes:adding child to
					// concatenation:");
					concatenation.addChild(lChild);
					// restart the scan since the list has changed ... (and take care not
					// to inadvertantly immediately increment i !)
					i = 0;
					n = node.getChildCount(); // getChildCount(node);
				} else {
					++i;
				}
			} else {
				this.insertConcatenationNodes(lChild);
				++i;
			}
		}
	}

	/**
	 * @param parent
	 * @param offset
	 * @exception DicomException
	 */
	private DicomDirectoryItem processSubTree(DicomDirectoryItem parent,
			long offset) throws DicomException {
		// flogger.debug("processSubTree");
		DataSet lDataSet = (DataSet) this.mapOffsetToSequenceItemAttributeList
		.get(new Long(offset));
		assert lDataSet != null;
		logger.debug("DataSet.count: " + lDataSet.count());
		DicomDirectoryItem node = this.itemFactory.newDicomDirectoryItem(parent,
				lDataSet);

		long offsetOfFirstChild = lDataSet.getUnsignedLong(
				DicomTags.OffsetOfLowerLevelDirectoryEntity).getValue(0);
		if (offsetOfFirstChild != 0) {
			// System.err.println("processSubTree: addChild
			// offset=0x"+Long.toHexString(offsetOfFirstChild)+" to node "+node);
			node.addChild(this.processSubTree(node, offsetOfFirstChild));
		}

		long offsetOfNextSibling = lDataSet.getUnsignedLong(
				DicomTags.OffsetOfNextDirectoryRecord).getValue(0);
		if (offsetOfNextSibling != 0) {
			// System.err.println("processSubTree: addSibling
			// offset=0x"+Long.toHexString(offsetOfNextSibling)+" to parent "+parent);
			node.addSibling(this.processSubTree(parent, offsetOfNextSibling));
		}

		return node;
	}

	/**
	 * <p>
	 * Get all the referenced file names in the entire directory, and a map to the
	 * directory records that reference them.
	 * </p>
	 * 
	 * @param parentFilePath
	 *          the folder in which the DICOMDIR lives (i.e., the base for
	 *          contained references)
	 * @return a java.util.HashMap whose keys are string file names fully
	 *         qualified by the specified parent, mapped to DicomDirectoryRecords
	 */
	/*
	 * public HashMap findAllContainedReferencedFileNamesAndTheirRecords(String
	 * parentFilePath) { return
	 * findAllContainedReferencedFileNamesAndTheirRecords(
	 * (DicomDirectoryItem)(getRoot()),parentFilePath); }
	 */

	/**
	 * TODO
	 * 
	 * @param aDirectory
	 * @throws DicomException
	 */
	public void read(DicomDirectory aDirectory) throws DicomException {
		logger.debug("read");
		// Step 1 ... traverse entire (linear) directory record sequence
		// and build index of offsets of each sequence item

		this.mapOffsetToSequenceItemAttributeList = new TreeMap<Long, DataSet>();

		if (!this.dataSet.hasElement(DicomTags.DirectoryRecordSeq)) {
			throw new DicomException("No DirectoryRecordSeq in DataSet");
		}

		SequenceOfItems lDirSequence = this.dataSet
		.getSequenceOfItems(DicomTags.DirectoryRecordSeq);
		assert lDirSequence != null;

		Iterator i = lDirSequence.iterator();// ((SequenceOfItems)list.getElement(TagFromName.DirectoryRecordSequence)).iterator();
		while (i.hasNext()) {
			SequenceItems item = (SequenceItems) i.next();
			this.mapOffsetToSequenceItemAttributeList.put(new Long(item
					.getByteOffset()), item.getDataSet());
		}
		// long currentTime = System.currentTimeMillis();
		// System.err.println("Make offset mapping = "+(currentTime-startTime)+"
		// ms");
		// startTime=currentTime;
		// Step 2 ... walk tree starting from root, building our tree

		// System.err.println("Walk tree");

		// fDicomDirectoryItemFactory=new DicomDirectoryRecordFactory();
		DicomDirectoryItem lRoot = aDirectory.getRoot();
		long offsetOfRoot = this.dataSet.getUnsignedLong(
				DicomTags.OffsetOfFirstRootDirectoryRecord).getValue(0);
		if (offsetOfRoot != 0) {
			// root = fDicomDirectoryItemFactory.newTopDirectoryRecord(); // we create
			// our own (empty) root on top
			lRoot.addChild(this.processSubTree(lRoot, offsetOfRoot)); // the DICOMDIR
			// "root" is really
			// the first of many
			// siblings
		}
		// currentTime = System.currentTimeMillis();
		// System.err.println("Walk tree took = "+(currentTime-startTime)+" ms");
		// startTime=currentTime;
		// System.err.println(toString());

		// Step 3 ... walk tree to insert pseudo-records for concatenations ...

		// if (doConcatenations)
		this.insertConcatenationNodes(lRoot);
		// currentTime = System.currentTimeMillis();
		// System.err.println("Inserting concatenations took =
		// "+(currentTime-startTime)+" ms");
		// startTime=currentTime;
		// Step 4 ... clean up intermediate data structures ...

		this.mapOffsetToSequenceItemAttributeList = null;
		// fDicomDirectoryItemFactory=null;
	}

}
