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

package org.dicom4j.classcreator.support;

import org.dicom4j.classcreator.BaseGenerator;
import org.dicom4j.classcreator.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseClassGenerator extends BaseGenerator {

	private static final Logger logger = LoggerFactory
	.getLogger(BaseClassGenerator.class);

	private static final long serialVersionUID = 1L;

	public BaseClassGenerator() throws Exception {
		super();
	}

	public void generate() throws Exception {
		Utils.writeLicence(this.fWriter);
		this.appendBlankLine();
		this.append("package " + this.getPackage() + ";");
		this.appendBlankLine();

	}

	public abstract String getClassName();

	public abstract String getPackage();

}
