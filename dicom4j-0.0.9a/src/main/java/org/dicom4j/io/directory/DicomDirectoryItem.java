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

import java.util.Collection;
import java.util.Enumeration;
import java.util.TreeSet;
import java.util.Vector;

import javax.swing.tree.TreeNode;

import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.DicomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * base class for DICOMDIR's items
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class DicomDirectoryItem implements Comparable, TreeNode {

	/**
	 * The Logger
	 */
	private static Logger flogger = LoggerFactory.getLogger(DicomDirectory.class);

	TreeNode[] array;

	Collection fChildrens;

	DataSet fDataSet;

	private DirectoryRecordType fDirectoryRecordType;

	DicomDirectoryItem fParent;

	protected String fUID;

	protected int integerValue;

	protected String stringValue;

	/**
	 * @param p
	 * @param l
	 */
	public DicomDirectoryItem(DicomDirectoryItem p, DataSet l) {
		this.fParent = p;
		this.fDataSet = l;
		this.makeIntegerValue();
		this.makeStringValue();
	}

	/**
	 * @param p
	 * @param l
	 */
	public DicomDirectoryItem(DirectoryRecordType aDirectoryRecordType,
			DicomDirectoryItem p, DataSet l) {
		super();
		this.fDirectoryRecordType = aDirectoryRecordType;
		this.fParent = p;
		this.fDataSet = l;
		assert this.fDirectoryRecordType != null;
		assert this.fDataSet != null;
		this.makeIntegerValue();
		this.makeStringValue();
	}

	/**
	 * @param child
	 */
	public void addChild(DicomDirectoryItem child) {
		if (this.fChildrens == null) {
			this.fChildrens = new TreeSet(); // is sorted
		}
		this.fChildrens.add(child);
		this.array = null; // cache is dirty
	}

	/**
	 * @param sibling
	 * @exception DicomException
	 */
	public void addSibling(DicomDirectoryItem sibling) throws DicomException {
		if (this.fParent == null) {
			throw new DicomException("Internal error - root node with sibling");
		} else {
			this.fParent.addChild(sibling);
		}
	}

	/**
	 * <p>
	 * Returns the children of this node as an {@link java.util.Enumeration
	 * Enumeration}.
	 * </p>
	 * 
	 * @return the children of this node
	 */
	public Enumeration children() {
		return this.fChildrens == null ? null : new Vector(this.fChildrens)
		.elements();
	}

	// Methods to implement Comparable (allows parent to sort)

	/**
	 * @param o
	 */
	public int compareTo(Object o) {
		return 0; // no particular order unless class is specialized
	}

	/**
	 * @param record
	 */
	protected final int compareToByIntegerValue(DicomDirectoryItem record) {
		if (this.getClass().equals(record.getClass())) {
			int uidComparison = this.getUIDForComparison().compareTo(
					record.getUIDForComparison());
			if (uidComparison == 0) {
				return 0; // always equal if same UID
			} else {
				int intComparison = this.getIntegerValue() - record.getIntegerValue();
				if (intComparison == 0) {
					int strComparison = this.toString().compareTo(record.toString());
					if (strComparison == 0) {
						return uidComparison; // same integer & string values but different
						// UID; distinguish and order consistently
					} else {
						return strComparison; // same integer values but different string;
						// distinguish and order consistently
					}
				} else {
					return intComparison;
				}
			}
		} else {
			return this.toString().compareTo(record.toString()); // includes name of
			// record
			// type
		}
	}

	// Methods to help with Comparable support

	/**
	 * @param record
	 */
	protected final int compareToByStringValue(DicomDirectoryItem record) {
		if (this.getClass().equals(record.getClass())) {
			int uidComparison = this.getUIDForComparison().compareTo(
					record.getUIDForComparison());
			// if (uidComparison == 0) {
			// return 0; // always equal if same UID
			// /}
			// else {
			{
				int strComparison = this.toString().compareTo(record.toString());
				if (strComparison == 0) {
					return uidComparison; // same string but different UID; distinguish
					// and order consistently
				} else {
					return strComparison;
				}
			}
		} else {
			return this.toString().compareTo(record.toString()); // includes name of
			// record
			// type
		}
	}

	/**
	 * @param o
	 */
	@Override
	public boolean equals(Object o) {
		return this.compareTo(o) == 0;
	}

	/**
	 * <p>
	 * Always returns true, since children may always be added.
	 * </p>
	 * 
	 * @return always true
	 */
	public boolean getAllowsChildren() {
		return true;
	}

	/**
	 * <p>
	 * Returns the child at the specified index.
	 * </p>
	 * 
	 * @param index
	 *          the index of the child to be returned, numbered from 0
	 * @return the child <code>TreeNode</code> at the specified index
	 */
	public TreeNode getChildAt(int index) {
		int n = this.fChildrens.size();
		if (this.array == null) {
			this.array = (TreeNode[]) this.fChildrens.toArray(new TreeNode[n]); // explicitly
			// allocated to
			// set returned
			// array type
			// correctly
		}
		return index < n ? this.array[index] : null;
	}

	/**
	 * <p>
	 * Return the number of children that this node contains.
	 * </p>
	 * 
	 * @return the number of children, 0 if none
	 */
	public int getChildCount() {
		return this.fChildrens == null ? 0 : this.fChildrens.size();
	}

	public DataSet getDataSet() {
		assert this.fDataSet != null;
		return this.fDataSet;
	}

	/**
	 * <p>
	 * Returns the index of the specified child from amongst this node's children,
	 * if present.
	 * </p>
	 * 
	 * @param child
	 *          the child to search for amongst this node's children
	 * @return the index of the child, or -1 if not present
	 */
	public int getIndex(TreeNode child) {
		// System.err.println("getIndexOfChild: looking for "+child);
		int n = this.fChildrens.size();
		if (this.array == null) {
			this.array = (TreeNode[]) this.fChildrens.toArray(new TreeNode[n]); // explicitly
			// allocated to
			// set returned
			// array type
			// correctly
		}
		for (int i = 0; i < n; ++i) {
			if (this.getChildAt(i).equals(child)) { // expensive comparison ? :(
				// System.err.println("getIndexOfChild: found "+child);
				return i;
			}
		}
		return -1;
	}

	/***/
	protected int getIntegerValue() {
		return this.integerValue;
	}

	// Methods to implement TreeNode ...

	/**
	 * 
	 * return the parent node
	 * 
	 * @return the parent node, or null if root
	 */
	public TreeNode getParent() {
		return this.fParent;
	}

	/***/
	protected String getStringValue() {
		return this.stringValue;
	}

	public DirectoryRecordType getType() {
		assert this.fDirectoryRecordType != null;
		return this.fDirectoryRecordType;
	}

	/***/
	protected final String getUIDForComparison() {
		return this.fUID;
	}

	/**
	 * <p>
	 * Returns true if the receiver is a leaf (has no children).
	 * </p>
	 * 
	 * @return true if the receiver is a leaf
	 */
	public boolean isLeaf() {
		return this.getChildCount() == 0;
	}

	/***/
	abstract protected void makeIntegerValue();

	/***/
	abstract protected void makeStringValue();

	// Methods specific to this kind of node ...

	/**
	 * @param child
	 */
	public void removeChild(DicomDirectoryItem child) {
		this.fChildrens.remove(child);
		this.array = null; // cache is dirty
	}

	public void setUID(String uid) {
		this.fUID = uid;
	}

	/***/
	@Override
	public String toString() {
		return this.getType().toString() + ": " + this.fUID;
	}

	/***/

}
