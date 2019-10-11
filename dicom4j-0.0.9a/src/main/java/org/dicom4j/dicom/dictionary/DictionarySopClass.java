/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
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

/**
 * 
 */
package org.dicom4j.dicom.dictionary;

import org.dicom4j.dicom.dictionary.item.support.AbstractDictionaryItem;
import org.dicom4j.dicom.uniqueidentifiers.SOPClass;

/**
 * <p>
 * A {@link SOPClass} description readed from a Dicom Dictionary.
 * </p>
 * 
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 * @since 0.0.1
 */
public class DictionarySopClass extends AbstractDictionaryItem {

	// TODO implement
	private String fUID;

	/**
	 * 
	 */
	public DictionarySopClass() {
		super();
	}

	public DictionarySopClass(String aUID) {
		super(aUID);
	}

	/**
	 * @return Returns the uID.
	 */
	public String getUID() {
		return this.fUID;
	}

	/**
	 * @param uid
	 *          The uID to set.
	 */
	public void setUID(String uid) {
		this.fUID = uid;
	}

}
