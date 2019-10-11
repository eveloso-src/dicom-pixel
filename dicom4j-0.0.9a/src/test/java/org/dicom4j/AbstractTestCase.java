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

package org.dicom4j;

import junit.framework.TestCase;

import org.dicom4j.dicom.network.dimse.DimseStatusRegistry;
import org.dicom4j.dicom.uniqueidentifiers.SOPClassRegistry;
import org.dicom4j.dicom.uniqueidentifiers.TransferSyntaxRegistry;
import org.dicom4j.network.dimse.DimseMessageFactory;

/**
 * Base class for all TestCase
 * 
 * @since 0.0.3
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractTestCase extends TestCase {

	public static final DimseMessageFactory Message_Factroy = new DimseMessageFactory();

	public AbstractTestCase() {
		this("");
	}

	public AbstractTestCase(String name) {
		super(name);
		Thread
		.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			public void uncaughtException(Thread t, Throwable ex) {
				System.out.println("You crashed thread " + t.getName());
				System.out.println("Exception was: " + ex.toString());
				assertFalse(true);
				fail("[" + t.getName() + "] - " + ex.getMessage());
			}
		});
		TestDicom4J.start();
	}

	protected DimseMessageFactory getDimseMessageFactory() {
		DimseMessageFactory factory = new DimseMessageFactory();
		factory.setSopClassRegistry(new SOPClassRegistry());
		factory.setTransferSyntaxRegistry(new TransferSyntaxRegistry());
		factory.setStatusRegistry(new DimseStatusRegistry());
		return factory;
	}

}
