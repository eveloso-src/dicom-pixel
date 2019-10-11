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

package org.dicom4j.wado;

import org.dicom4j.core.utils.StringValue;

/**
 * Wado mime's type
 * 
 * @since 0.0.9
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class MimeType extends StringValue {

	public static final MimeType MIME_TYPE_DICOM = new MimeType(
	"application/dicom");

	public static final MimeType MIME_TYPE_GIF = new MimeType("image/gif");

	public static final MimeType MIME_TYPE_HTML = new MimeType("text/html");

	public static final MimeType MIME_TYPE_JP2 = new MimeType("image/jp2");

	public static final MimeType MIME_TYPE_JPEG = new MimeType("image/jpeg");

	public static final MimeType MIME_TYPE_MPEG = new MimeType("video/mpeg");

	public static final MimeType MIME_TYPE_PDF = new MimeType("application/pdf");

	public static final MimeType MIME_TYPE_PLAIN = new MimeType("text/plain");

	public static final MimeType MIME_TYPE_PNG = new MimeType("image/png");

	public static final MimeType MIME_TYPE_RTF = new MimeType("text/rtf");

	public static final MimeType MIME_TYPE_XML = new MimeType("text/xml");

	private static final long serialVersionUID = 1L;

	public MimeType(String value) {
		super(value);
	}

}
