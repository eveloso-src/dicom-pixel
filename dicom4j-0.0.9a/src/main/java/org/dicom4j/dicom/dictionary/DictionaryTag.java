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

import org.dicom4j.dicom.DicomTag;
import org.dicom4j.dicom.dictionary.item.DictionaryItem;

/**
 * <p>
 * A {@link org.dicom4j.dicom.DicomTag DicomTag} description readed from a Dicom
 * Dictionary.
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DictionaryTag extends DicomTag implements DictionaryItem {

	private boolean fisRetired;

	/**
	 * Return the group of a tag value in string (must be in like: (0000,0000) )
	 * 
	 * @param aValue
	 *          the tag (0000,0000)
	 * @return the group value
	 */
	/*
	 * public static String getGroup(String aValue) { if (aValue.length() != 11)
	 * throw new IllegalArgumentException("the length of the argument of getGroup
	 * must be 11"); return (aValue.split(",")[0]).substring(1,5); }
	 * 
	 * /** Return the group of a tag value in string (must be in like: (0000,0000)
	 * )
	 * 
	 * @param aValue the tag (0000,0000) @return the group value
	 */
	/*
	 * public static String getElement(String aValue) { if (aValue.length() != 11)
	 * throw new IllegalArgumentException("the length of the argument of getGroup
	 * must be 11"); return (aValue.split(",")[1]).substring(0,4); }
	 */

	/*
	 * private int fIntGroup; private int fIntElement; private String fGroup;
	 * private String fElement;
	 */

	private String fKey;

	private String fType;

	private String fVM;

	private String fVR;

	public DictionaryTag(String aKey, int aGroup, int aElement, String aName,
			String aVR) {
		super(aGroup, aElement, aName);
		this.fKey = aKey;
		this.fVR = aVR;
		this.fVM = "";
		this.fisRetired = false;
	}

	public String getKey() {
		return this.fKey;
	}

	public String getType() {
		return this.fType;
	}

	/**
	 * @return Returns the fVM.
	 */
	public String getVM() {
		return this.fVM;
	}

	/**
	 * @return Returns the fVR.
	 */
	public String getVR() {
		return this.fVR;
	}

	/**
	 * @return Returns the fisRetired.
	 */
	public boolean isisRetired() {
		return this.fisRetired;
	}

	/**
	 * Used to compare this tag to a {@link DicomTag DicomTag} instance
	 */
	/*
	 * public int hashCode() { return (fIntGroup<<16)+(fIntElement&0xffff); }
	 */

	/*
	 * public int hashCode() { return (fGroup<<16)+(fElement&0xffff); }
	 */

	/**
	 * @param aisRetired
	 *          The fisRetired to set.
	 */
	public void setisRetired(boolean aisRetired) {
		this.fisRetired = aisRetired;
	}

	public void setType(String aType) {
		this.fType = aType;
	}

	/**
	 * @return Returns the fGroup.
	 */
	/*
	 * public String getGroup() { return fGroup; } /** @param group The fGroup to
	 * set.
	 */
	/*
	 * public void setGroup(String aGroup) { fGroup = aGroup; // fIntGroup =
	 * Integer.parseInt(aGroup); }
	 * 
	 * /** @return Returns the fElement.
	 */
	/*
	 * public String getElement() { return fElement; }
	 */
	/**
	 * @param aElement
	 *          The fElement to set.
	 */
	/*
	 * public void setElement(String aElement) { fElement = aElement; //
	 * fIntElement = Integer.parseInt(aElement); }
	 */
	/**
	 * @param fvm
	 *          The fVM to set.
	 */
	public void setVM(String aVM) {
		if (aVM != null) {
			this.fVM = aVM.toUpperCase();
		}
	}

	/**
	 * @param fvr
	 *          The fVR to set.
	 */
	public void setVR(String aVR) {
		if (aVR != null) {
			this.fVR = aVR;
		}
	}

	@Override
	public String toString() {
		return "(" + this.getGroupAsString() + "," + this.getElementAsString()
		+ ") " + this.getName() + " " + this.getVR() + " " + this.getVM();
	}

}
