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

import org.dicom4j.AbstractTestCase;
import org.dicom4j.data.elements.UnsignedLong;
import org.dicom4j.data.elements.UnsignedShort;
import org.dicom4j.dicom.DicomTags;

public class CommandSetTest extends AbstractTestCase {

	public CommandSetTest(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testToString() {
		CommandSet lObject1 = new CommandSet();
		lObject1.addElement(new UnsignedLong(DicomTags.CommandGroupLength));
		lObject1.addElement(new UnsignedShort(DicomTags.CommandField));
		lObject1.addElement(new UnsignedShort(DicomTags.DataSetType));
		// Logger.info("lObject1: \n" + lObject1.toString());

		/*
		 * CommandSet lObject2 = new CommandSet(CommandSetTypes.C_FIND_REQUEST);
		 * Logger.info("lObject2: \n" + lObject2.toString());
		 */
	}

	// private CommandSet fObject;
	// private static Logger Logger =
	// LoggerFactory.getLogger(CommandSetTest.class);

}
