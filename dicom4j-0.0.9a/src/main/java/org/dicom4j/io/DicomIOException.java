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

package org.dicom4j.io;

import org.dicom4j.dicom.DicomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DICOM IO Exception
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomIOException extends DicomException {

	protected static Logger fLogger = LoggerFactory
	.getLogger(DicomIOException.class);

	private static final long serialVersionUID = 72878573212128043L;

	public DicomIOException() {
		super();
	}

	public DicomIOException(String message) {
		super(message);
	}

	public DicomIOException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/*
	 * public DicomIOException(String msg) { super(msg); }
	 */
	public DicomIOException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * 
	 */

}
