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

/**
 * 
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DirectoryRecordType {

	/**
	 * CONCATENATION Directory Record Type
	 */
	public static final DirectoryRecordType CONCATENATION = new DirectoryRecordType(
	"CONCATENATION");

	/**
	 * IMAGE Directory Record Type
	 */
	public static final DirectoryRecordType IMAGE = new DirectoryRecordType(
	"IMAGE");

	/**
	 * PATIENT Directory Record Type
	 */
	public static final DirectoryRecordType PATIENT = new DirectoryRecordType(
	"PATIENT");

	/**
	 * RAW DATA Directory Record Type
	 */
	public static final DirectoryRecordType RAW_DATA = new DirectoryRecordType(
	"RAW DATA");

	/**
	 * SERIES Directory Record Type
	 */
	public static DirectoryRecordType SERIES = new DirectoryRecordType("SERIES");

	/**
	 * SPECTROSCOPY Directory Record Type
	 */
	public static DirectoryRecordType SPECTROSCOPY = new DirectoryRecordType(
	"SPECTROSCOPY");

	/**
	 * SR DOCUMENT Directory Record Type
	 */
	public static DirectoryRecordType SR_DOCUMENT = new DirectoryRecordType(
	"SR DOCUMENT");

	/**
	 * STUDY Directory Record Type
	 */
	public static DirectoryRecordType STUDY = new DirectoryRecordType("STUDY");

	/**
	 * WAVEFORM Directory Record Type
	 */
	public static DirectoryRecordType WAVEFORM = new DirectoryRecordType(
	"WAVEFORM");

	private String fType;

	public DirectoryRecordType(String aType) {
		this.fType = aType;
	}

	public boolean equals(DirectoryRecordType aObject) {
		return aObject.toString().equals(this.toString());
	}

	@Override
	public String toString() {
		return this.fType;
	}

}
