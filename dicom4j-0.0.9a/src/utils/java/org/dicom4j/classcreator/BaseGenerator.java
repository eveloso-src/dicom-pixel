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

package org.dicom4j.classcreator;

import java.io.Writer;

import org.dicom4j.dicom.dictionary.DicomDictionary;

public abstract class BaseGenerator {

	protected DicomDictionary dicomDictionary;

	protected Writer fWriter;

	public BaseGenerator() throws Exception {
		this.fWriter = this.createWriter();
	}

	protected void append(String aString) throws Exception {
		this.fWriter.write(aString + "\n");
	}

	protected void appendBlankLine() throws Exception {
		this.append("");
	}

	protected abstract Writer createWriter() throws Exception;

	public DicomDictionary getDicomDictionary() {
		return this.dicomDictionary;
	}

	public void setDicomDictionary(DicomDictionary dicomDictionary) {
		this.dicomDictionary = dicomDictionary;
	}
}
