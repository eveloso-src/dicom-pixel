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

package org.dicom4j.data;

import java.io.IOException;
import java.io.InputStream;

import org.dicom4j.data.elements.ElementNotFoundException;
import org.dicom4j.data.elements.UnsignedLong;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomException;
import org.dicom4j.dicom.DicomTags;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntax;
import org.dicom4j.io.DicomReader;

/**
 * DICOM Command Set
 * 
 * @since 0.0.0
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class CommandSet extends DataSet {

	/**
	 * Has DataSet byte value
	 */
	public static final int HAS_DATASET = 0x0102;

	/**
	 * No DataSet byte value
	 */
	public static final int NO_DATASET = 0x0101;

	/**
	 * Return a type of CommandSet as string
	 * 
	 * @param aType
	 *          CommandSet type
	 * @return type as String
	 * @deprecated
	 */
	@Deprecated
	/*
	 * public final static String commandTypeToString(int aType) {
	 * 
	 * if (aType == CommandSet.Types.C_STORE_REQUEST) { return "C-STORE-REQUEST";
	 * } else if (aType == CommandSet.Types.C_STORE_RESPONSE) { return
	 * "C-STORE-RESPONSE";
	 * 
	 * } else if (aType == CommandSet.Types.C_GET_RQ) { return "C-GET-RQ"; } else
	 * if (aType == CommandSet.Types.C_GET_RSP) { return "C-GET-RSP";
	 * 
	 * } else if (aType == CommandSet.Types.C_FIND_REQUEST) { return "C-FIND-RQ";
	 * } else if (aType == CommandSet.Types.C_FIND_RESPONSE) { return
	 * "C-FIND-RSP";
	 * 
	 * } else if (aType == CommandSet.Types.C_MOVE_REQUEST) { return
	 * "C-MOVE-REQUEST"; } else if (aType == CommandSet.Types.C_MOVE_RESPONSE) {
	 * return "C-MOVE-RESPONSE";
	 * 
	 * } else if (aType == CommandSet.Types.C_ECHO_REQUEST) { return "C-ECHO-RQ";
	 * } else if (aType == CommandSet.Types.C_ECHO_RESPONSE) { return
	 * "C-ECHO-RSP";
	 * 
	 * } else if (aType == CommandSet.Types.N_EVENT_REPORT_RQ) { return
	 * "N-EVENT-REPORT-RQ"; } else if (aType ==
	 * CommandSet.Types.N_EVENT_REPORT_RQ) { return "N-EVENT-REPORT-RSP";
	 * 
	 * } else if (aType == CommandSet.Types.N_GET_RQ) { return "N-GET-RQ"; } else
	 * if (aType == CommandSet.Types.N_GET_RSP) { return "N-GET-RSP";
	 * 
	 * } else if (aType == CommandSet.Types.N_SET_RQ) { return "N-SET-RQ"; } else
	 * if (aType == CommandSet.Types.N_SET_RSP) { return "N-SET-RSP";
	 * 
	 * } else if (aType == CommandSet.Types.N_ACTION_RQ) { return "N-ACTION-RQ"; }
	 * else if (aType == CommandSet.Types.N_ACTION_RSP) { return "N-ACTION-RSP";
	 * 
	 * } else if (aType == CommandSet.Types.N_CREATE_RQ) { return "N-CREATE-RQ"; }
	 * else if (aType == CommandSet.Types.N_CREATE_RSP) { return "N-CREATE-RSP";
	 * 
	 * } else if (aType == CommandSet.Types.N_DELETE_RQ) { return "N-DELETE-RQ"; }
	 * else if (aType == CommandSet.Types.N_DELETE_RSP) { return "N-DELETE-RSP";
	 * 
	 * } else if (aType == CommandSet.Types.C_CANCEL_RQ) { return "C-CANCEL-RQ"; }
	 * else { return "Unknown Command"; } }
	 */
	public static final String datasetTypeToString(int aDataSetType) {
		if (aDataSetType == NO_DATASET) {
			return "No DataSet";
		} else {
			return "Has DataSet";
		}
	}

	/**
	 * @deprecated Check if the Command is a CEcho (Request/Resonse)
	 * 
	 * @param aDimseCommand
	 *          the command
	 * @return
	 */
	/*
	 * public static boolean isCEcho(CommandSet aDimseCommand) { return
	 * aDimseCommand.getCommandField() == CommandSet.Types.C_ECHO_REQUEST ||
	 * aDimseCommand.getCommandField() == CommandSet.Types.C_ECHO_RESPONSE; }
	 */

	/**
	 * Create a new Command Set
	 */
	public CommandSet() {
		super();
	}

	public CommandSet(int commandType) throws DicomException {
		super();
		this.setCommandField(commandType);
	}

	public int getCommandField() throws ElementNotFoundException {
		return this.getCommandFieldAttribute().getIntegerValue(0);
	}

	protected UnsignedShort getCommandFieldAttribute() throws ElementNotFoundException {
		if (  hasElement( DicomTags.CommandField )) {
		return this.getUnsignedShort(DicomTags.CommandField);
		} else {
			throw new ElementNotFoundException(DicomTags.CommandField);
		}
	}

	/*
	 * public String getCommandFieldToString() { return
	 * commandTypeToString(getCommandField()); }
	 */

	public int getDataSetType() {
		return this.getDataSetTypeAttribute().getIntegerValue(0);
	}

	protected UnsignedShort getDataSetTypeAttribute() {
		assert this.getUnsignedShort(DicomTags.DataSetType) != null;
		return this.getUnsignedShort(DicomTags.DataSetType);
	}

	public String getDataSetTypeToString() {
		return datasetTypeToString(this.getDataSetType());
	}

	protected UnsignedLong getGroupLengthDataElement() {
		assert this.getUnsignedLong(DicomTags.CommandGroupLength) != null;
		return this.getUnsignedLong(DicomTags.CommandGroupLength);
	}

	public boolean hasDataSet() {
		return this.getDataSetType() != NO_DATASET;
	}

	public boolean isCEchoRequest() throws ElementNotFoundException{
		return this.getCommandField() == CommandSetType.C_ECHO_REQUEST.value();
	}

	public boolean isCEchoResponse() throws ElementNotFoundException {
		return this.getCommandField() == CommandSetType.C_ECHO_RESPONSE.value();
	}

	public boolean isCFindRequest() throws ElementNotFoundException {
		return this.getCommandField() == CommandSetType.C_FIND_REQUEST.value();
	}

	public boolean isCStoreResponse() throws ElementNotFoundException {
		return this.getCommandField() == CommandSetType.C_STORE_RESPONSE.value();
	}

	public void read(byte[] aBytes) throws IOException, DicomException, Exception {
		DicomReader lReader = new DicomReader(aBytes);
		try {
			lReader.read(this, TransferSyntax.ImplicitVRLittleEndian);
		} finally {
			lReader.close();
		}
	}

	/**
	 * @deprecated
	 * @param aStream
	 * @throws IOException
	 * @throws DicomException
	 */
	@Deprecated
	public void read(InputStream aStream) throws IOException, DicomException,
	Exception {
		super.read(aStream, TransferSyntax.ImplicitVRLittleEndian);
	}

	public void setCommandField(int aCommandField) throws DicomException {
		this.getCommandFieldAttribute().setValue(aCommandField);
	}

	public void setDataSetType(int aDataSetType) throws DicomException {
		this.getDataSetTypeAttribute().setValue(aDataSetType);
	}

}
