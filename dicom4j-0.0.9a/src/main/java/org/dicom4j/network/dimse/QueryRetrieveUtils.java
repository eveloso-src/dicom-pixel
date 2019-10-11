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

package org.dicom4j.network.dimse;

import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.DicomTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @deprecated see QueryRetreieveLevel Utility class to provide fonctionnality
 *             related to Query/Retrieve
 * 
 * @since Alpha 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
@Deprecated
public final class QueryRetrieveUtils {

	private static final Logger fLogger = LoggerFactory
	.getLogger(QueryRetrieveUtils.class);

	public static String getQueryRetreiveLevel(DataSet aDataSet) {
		try {
			if (aDataSet.hasElement(DicomTags.QueryRetrieveLevel)) {
				return aDataSet.getCodeString(DicomTags.QueryRetrieveLevel)
				.getSingleStringValue().trim();
			} else {
				fLogger.warn("No QueryRetrieveLevel DataElement in DataSet");
				return "";
			}
		} catch (Exception e) {
			fLogger.error(e.getMessage());
		}
		return "";
	}

	/**
	 * return true is the DataSet indicate a Image Q/R Level
	 * 
	 * @param aDataSet
	 * @return
	 * @throws Exception
	 */
	public static boolean isImageLevel(DataSet aDataSet) throws Exception {
		return DimseConst.QueryRetrieveLevel
		.isImageLevel(getQueryRetreiveLevel(aDataSet));
	}

	/**
	 * Return true is the DataSet indicate a Patient Q/R Level
	 * 
	 * @param aDataSet
	 * @return
	 * @throws Exception
	 */
	public static boolean isPatientLevel(DataSet aDataSet) throws Exception {
		return DimseConst.QueryRetrieveLevel
		.isPatientLevel(getQueryRetreiveLevel(aDataSet));
	}

	public static boolean isSerieLevel(DataSet aDataSet) throws Exception {
		return DimseConst.QueryRetrieveLevel
		.isSerieLevel(getQueryRetreiveLevel(aDataSet));
	}

	public static boolean isStudyLevel(DataSet aDataSet) throws Exception {
		return DimseConst.QueryRetrieveLevel
		.isStudyLevel(getQueryRetreiveLevel(aDataSet));
	}
}
