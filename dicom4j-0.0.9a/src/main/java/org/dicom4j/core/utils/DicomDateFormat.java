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

package org.dicom4j.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * DICOM {@link DateFormat}
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class DicomDateFormat {

	/**
	 * the DICOM date format
	 */
	public static final String DICOM_DATE_FORMAT = "yyyyMMdd";

	/**
	 * the default local
	 */
	private static Locale LOCAL = Locale.getDefault();

	public static String formatDate(Date aDate) {
		return DateFormatUtils.format(aDate, DICOM_DATE_FORMAT);
	}

	public static Date parseDate(String aDate) throws ParseException {
		return parseDate(aDate, LOCAL);
	}

	public static final Date parseDate(String aDate, Locale aLocal)
	throws ParseException {
		return new SimpleDateFormat(DICOM_DATE_FORMAT, aLocal).parse(aDate);
	}

	/**
	 * set the {@link Locale} to use
	 * <p>
	 * (if not set local equal to Locale.getDefault() )
	 * </p>
	 * 
	 * @param aLocal
	 *          the local
	 */
	public static final synchronized void setLocal(Locale aLocal) {
		LOCAL = aLocal;
	}

}
