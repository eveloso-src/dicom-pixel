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

package org.dicom4j.images;

import org.dicom4j.dicom.DicomException;

/**
 * 
 * @since Alpha 0.0.2
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomImageReaderException extends DicomException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DicomImageReaderException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DicomImageReaderException(String msg) {
		super(msg);
		// TODO Auto-generated constructor stub
	}

	public DicomImageReaderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DicomImageReaderException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

}
