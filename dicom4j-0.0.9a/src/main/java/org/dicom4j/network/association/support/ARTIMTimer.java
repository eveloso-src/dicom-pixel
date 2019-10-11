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

package org.dicom4j.network.association.support;

import org.dicom4j.network.association.Association;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Mnage ARTIM time out
 * 
 * @since 0.0.4
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public class ARTIMTimer {

	private class Timer extends Thread {

		public Timer() {
		}

		@Override
		public void run() {
			try {
				Thread.sleep(ARTIMTimer.this.getTimeOut());
				// we check fisStarted because calling stop can't really stop the thread
				if (ARTIMTimer.this.isStarted) {
					logger.debug("Timeout (time: " + ARTIMTimer.this.fTimeOut
							+ "), we must close the connection");
					ARTIMTimer.this.association.closeTransportConnection(false); // TODO
					// must
					// be
					// true
					// or
					// false ??
				}
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}
	}

	/**
	 * The logger
	 */
	protected static final Logger logger = LoggerFactory
	.getLogger(Association.class);

	/**
	 * the association
	 */
	private Association association;

	/**
	 * the timeout
	 */
	private int fTimeOut;

	/**
	 * to know if the timer is started or not
	 */
	private boolean isStarted = false;

	/**
	 * the inner timer
	 */
	private Timer timer;

	public ARTIMTimer(Association association, int aTimeOut) {
		this.setAssociation(association);
		this.setTimeOut(aTimeOut);
	}

	/**
	 * @return Returns the aTimeOut.
	 */
	public int getTimeOut() {
		return this.fTimeOut;
	}

	/**
	 * check is the timer is started
	 * 
	 * @return true is started
	 */
	public boolean isStarted() {
		return this.isStarted;
	}

	protected void setAssociation(Association association) {
		this.association = association;
		assert this.association != null;
	}

	/**
	 * @param timeOut
	 *          The aTimeOut to set.
	 */
	public void setTimeOut(int atimeOut) {
		this.fTimeOut = atimeOut;
	}

	/**
	 * start the timer
	 * 
	 */
	public void start() {
		logger.debug("Start timer");
		this.timer = new Timer();
		this.timer.start();
		this.isStarted = true;
	}

	/**
	 * stop the timer
	 * 
	 */
	public void stop() {
		logger.debug("Stop timer");
		this.isStarted = false;
		this.timer = null;
	}

}
