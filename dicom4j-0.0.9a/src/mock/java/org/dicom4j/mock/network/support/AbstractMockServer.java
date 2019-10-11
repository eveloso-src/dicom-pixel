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

package org.dicom4j.mock.network.support;

import org.dicom4j.network.association.AssociationAcceptor;
import org.dicom4j.network.association.AssociationAcceptorConfiguration;
import org.dicom4j.network.association.support.AssociationAcceptorImpl;
import org.dolmen.core.lang.ExceptionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract Mock server
 * 
 * @since 0.1
 * @since 4 mars 2009
 * @author <a href="mailto:straahd@users.sourceforge.net">Laurent Lecomte
 * 
 */
public abstract class AbstractMockServer {

	private class SCPWorker extends Thread {

		@Override
		public void run() {
			try {
				logger.info("SCPWorker.run");
				AbstractMockServer.this.associationAcceptor
				.bind(AbstractMockServer.this.getPort()); // we start listening on
				// the port
				logger.info("waiting associations on port : "
						+ AbstractMockServer.this.getPort());
			} catch (Exception e) {
				logger.error(e.getMessage());
				AbstractMockServer.this.exceptionListener.exceptionOccurs(e);
			}
		}
	}

	private static final Logger logger = LoggerFactory
	.getLogger(AbstractMockServer.class);

	private static final long serialVersionUID = 1L;

	protected AssociationAcceptor associationAcceptor = new AssociationAcceptorImpl();

	private ExceptionListener exceptionListener;

	// private DimseMessageFactory dimseMessageFactory;

	private int port;

	public AbstractMockServer() {
		super();
		this.port = 0;
		// AssociationAcceptor associationAcceptor = new AssociationAcceptorImpl();
		// associationAcceptor.setConfiguration( new
		// AssociationAcceptorConfigurationImpl() );
		// associationAcceptor.getConfiguration().setTransportAcceptor( new
		// TransportAcceptor() );
	}

	/**
	 * @return
	 * @see org.dicom4j.network.association.AssociationAcceptor#getConfiguration()
	 */
	public AssociationAcceptorConfiguration getConfiguration() {
		return this.associationAcceptor.getConfiguration();
	}

	public ExceptionListener getExceptionListener() {
		return this.exceptionListener;
	}

	public int getPort() {
		return this.port;
	}

	public void setExceptionListener(ExceptionListener exceptionListener) {
		this.exceptionListener = exceptionListener;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void start(ExceptionListener exceptionListener) {
		this.setExceptionListener(exceptionListener);
		try {
			this.associationAcceptor.bind(AbstractMockServer.this.getPort()); // we start
			// listening
			// on the
			// port
			logger.info("waiting associations on port : "
					+ AbstractMockServer.this.getPort());
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			this.getExceptionListener().exceptionOccurs(ex);
		}

		// ThreadUtils.startRunnable( new SCPWorker() );
	}

}
