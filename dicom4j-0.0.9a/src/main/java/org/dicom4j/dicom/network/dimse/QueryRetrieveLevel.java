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

package org.dicom4j.dicom.network.dimse;

import org.dicom4j.core.utils.StringValue;
import org.dicom4j.data.DataSet;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.network.dimse.DimseConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Query Retrieve Level
 * 
 * @since 0.0.6
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class QueryRetrieveLevel extends StringValue {

	private static final Logger fLogger = LoggerFactory
	.getLogger(QueryRetrieveLevel.class);

	public static final QueryRetrieveLevel IMAGES_LEVEL = new QueryRetrieveLevel(
	"IMAGE");

	public static final QueryRetrieveLevel PATIENT_LEVEL = new QueryRetrieveLevel(
	"PATIENT");

	public static final QueryRetrieveLevel SERIES_LEVEL = new QueryRetrieveLevel(
	"SERIES");

	public static final QueryRetrieveLevel STUDY_LEVEL = new QueryRetrieveLevel(
	"STUDY");

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

	public static boolean isImageLevel(String aLevel) {
		return aLevel.trim().equals(IMAGES_LEVEL.value());
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

	public static boolean isPatientLevel(String aLevel) {
		return aLevel.trim().equals(PATIENT_LEVEL.value());
	}

	public static boolean isSerieLevel(DataSet aDataSet) throws Exception {
		return DimseConst.QueryRetrieveLevel
		.isSerieLevel(getQueryRetreiveLevel(aDataSet));
	}

	public static boolean isSerieLevel(String aLevel) {
		return aLevel.trim().equals(SERIES_LEVEL.value());
	}

	public static boolean isStudyLevel(DataSet aDataSet) throws Exception {
		return DimseConst.QueryRetrieveLevel
		.isStudyLevel(getQueryRetreiveLevel(aDataSet));
	}

	public static boolean isStudyLevel(String aLevel) {
		return aLevel.trim().equals(STUDY_LEVEL.value());
	}

	public QueryRetrieveLevel(String aValue) {
		super(aValue);
	}

	public boolean isImageLevel() {
		return isImageLevel(this.value());
	}

	public boolean isPatientLevel() {
		return isPatientLevel(this.value());
	}

	public boolean isSerieLevel() {
		return isSerieLevel(this.value());
	}

	public boolean isStudyLevel() {
		return isStudyLevel(this.value());
	}

}
