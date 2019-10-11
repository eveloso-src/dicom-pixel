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

package org.dicom4j.samples;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 0.0.9
 * @since 28 oct. 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractSample {

	private static final Logger logger = LoggerFactory
	.getLogger(AbstractSample.class);

	private static final long serialVersionUID = 1L;

	private final Properties properties = new Properties();

	public AbstractSample() throws Exception {
		super();
		PropertyConfigurator.configure(".//log4j.properties");
		this.getProperties().load(new FileInputStream(this.getProperiesFilePath()));
		logger.info("Properties " + this.getProperiesFilePath() + "loaded");
	}

	public String getProperiesFilePath() {
		return "";
	}

	public Properties getProperties() {
		return this.properties;
	}

	public String getServerHostName() {
		return this.getProperties().getProperty("server.hostname");
	}

	public int getServerPort() {
		return Integer.parseInt(this.getProperties().getProperty("server.port"));
	}

}
