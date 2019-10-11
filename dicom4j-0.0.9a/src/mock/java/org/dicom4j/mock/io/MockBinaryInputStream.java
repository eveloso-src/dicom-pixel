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

package org.dicom4j.mock.io;

import java.io.IOException;
import java.io.InputStream;

import org.dicom4j.io.BinaryInputStream;

public class MockBinaryInputStream extends BinaryInputStream {

	private long skipReturnValue;

	public MockBinaryInputStream(InputStream aInput) {
		super(aInput);
	}

	public long getSkipReturnValue() {
		return this.skipReturnValue;
	}

	public void setSkipReturnValue(long skipReturnValue) {
		this.skipReturnValue = skipReturnValue;
	}

	@Override
	public long skip(long n) throws IOException {
		return this.skipReturnValue;
	}
}
