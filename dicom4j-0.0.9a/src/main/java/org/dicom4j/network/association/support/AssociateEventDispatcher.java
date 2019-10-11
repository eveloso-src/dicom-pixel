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

import java.util.ArrayList;
import java.util.List;

import org.dicom4j.network.association.Association;
import org.dicom4j.network.association.associate.AssociateAbort;
import org.dicom4j.network.association.associate.AssociateSession;
import org.dicom4j.network.association.listeners.AssociationListener;
import org.dicom4j.network.dimse.messages.support.AbstractDimseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.emory.mathcs.backport.java.util.concurrent.Executor;
import edu.emory.mathcs.backport.java.util.concurrent.LinkedBlockingQueue;
import edu.emory.mathcs.backport.java.util.concurrent.ThreadPoolExecutor;
import edu.emory.mathcs.backport.java.util.concurrent.TimeUnit;

public class AssociateEventDispatcher {

	protected static class Event {

		private final Object fData;

		private final AssociationListener fListener;

		private final byte fPresentationContextID;

		private final EventType fType;

		Event(EventType type, AssociationListener aListener, Object data,
				byte aPresentationContextID) {
			this.fType = type;
			this.fData = data;
			this.fListener = aListener;
			this.fPresentationContextID = aPresentationContextID;
		}

		public Object getData() {
			return this.fData;
		}

		public AssociationListener getListener() {
			return this.fListener;
		}

		public byte getPresentationContextID() {
			return this.fPresentationContextID;
		}

		public EventType getType() {
			return this.fType;
		}
	}

	private static class EventsBuffer {
		private static final String KEY = EventsBuffer.class.getName() + ".KEY";

		private static EventsBuffer getEventsBuffer(Association aAssociation) {
			synchronized (aAssociation) {
				EventsBuffer buf = (EventsBuffer) aAssociation.getAttribute(KEY);
				if (buf == null) {
					buf = new EventsBuffer(aAssociation);
					aAssociation.setAttribute(KEY, buf);
				}
				return buf;
			}
		}

		private final List<Event> eventQueue = new ArrayList<Event>();

		private final Association fAssociation;

		private boolean processingCompleted = true;

		private EventsBuffer(Association aAssociation) {
			this.fAssociation = aAssociation;
		}

	}

	protected static class EventType {

		public static final EventType ABORTED = new EventType("ABORTED");

		public static final EventType CLOSED = new EventType("CLOSED");

		public static final EventType EXCEPTION = new EventType("EXCEPTION");

		public static final EventType IDLE = new EventType("IDLE");

		public static final EventType MESSAGE_RECEIVED = new EventType(
		"MESSAGE_RECEIVED");

		public static final EventType MESSAGE_SENT = new EventType("MESSAGE_SENT");

		public static final EventType OPENED = new EventType("OPENED");

		public static final EventType RELEASED = new EventType("RELEASED");

		private final String value;

		private EventType(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}
	}

	private class ProcessEventsRunnable implements Runnable {
		private final EventsBuffer buffer;

		ProcessEventsRunnable(EventsBuffer buffer) {
			this.buffer = buffer;
		}

		public void run() {
			// LOGGER.error("run");
			while (true) {
				// LOGGER.error("true");
				Event event;

				synchronized (this.buffer.eventQueue) {
					if (this.buffer.eventQueue.isEmpty()) {
						// LOGGER.error("EMPTY");
						this.buffer.processingCompleted = true;
						break;
					}

					event = this.buffer.eventQueue.remove(0);
				}
				// logger.error(event.getNextFilter().getClass().getName());
				// LOGGER.error("before processEvent");
				assert this.buffer != null;
				assert event != null;
				AssociateEventDispatcher.this.processEvent(this.buffer.fAssociation,
						event.getType(), event.getListener(), event.getData(), event
						.getPresentationContextID());
			}
			// LOGGER.error("FALSE");

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Exiting since queue is empty for "); // +
				// buffer.session.getRemoteAddress()
				// );
			}
		}
	}

	// private final EventsBuffer fEventsBuffer;
	private static final Logger LOGGER = LoggerFactory
	.getLogger(AssociateEventDispatcher.class);

	/*
	 * public void run() { super.run(); try {
	 * fListener.associationOpened(fAssociation, null); } catch (Throwable e) {
	 * fListener.exceptionCaught(fAssociation, e); } }
	 */

	private final Executor fExecutor;

	public AssociateEventDispatcher() {
		this.fExecutor = new ThreadPoolExecutor(16, 16, 60, TimeUnit.SECONDS,
				new LinkedBlockingQueue());
	}

	public void associationAborted(Association aAssociation,
			AssociationListener aListener, AssociateAbort aAbort) throws Exception {
		this.fireEvent(aAssociation, EventType.ABORTED, aListener, aAbort,
				(byte) -1);
	}

	public void associationOpened(Association aAssociation,
			AssociationListener aListener, AssociateSession aAssociateSession)
	throws Exception {
		this.fireEvent(aAssociation, EventType.OPENED, aListener,
				aAssociateSession, (byte) -1);
	}

	/*
	 * public void messageSent(Association aAssociation, AssociationListener
	 * aListener, byte aPresentationContextID, DimseMessage aMessage) throws
	 * Exception { fireEvent ( aAssociation, EventType.MESSAGE_SENT , aListener,
	 * aMessage, aPresentationContextID); }
	 */

	public void associationReleased(Association aAssociation,
			AssociationListener aListener) {
		this
		.fireEvent(aAssociation, EventType.RELEASED, aListener, null, (byte) -1);
	}

	private void fireEvent(Association aAssociation, EventType type,
			AssociationListener aListener, Object data, byte aPresentationContextID) {
		// LOGGER.error("fireEvent:" + type.toString() );
		Event event = new Event(type, aListener, data, aPresentationContextID);
		// LOGGER.error("fireEvent-1");
		EventsBuffer buf = EventsBuffer.getEventsBuffer(aAssociation);
		// LOGGER.error("fireEvent-2");
		synchronized (buf.eventQueue) {
			// LOGGER.error("fireEvent-3");
			buf.eventQueue.add(event);
			// LOGGER.error("fireEvent buf size:" + buf.eventQueue.size());
			// LOGGER.error("fireEvent-4");
			if (buf.processingCompleted) {
				// LOGGER.error("fireEvent-5");
				buf.processingCompleted = false;
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Launching thread"); // for " +
					// session.getRemoteAddress() );
				}
				// LOGGER.error("fireEvent-6");
				this.fExecutor.execute(new ProcessEventsRunnable(buf));
				// LOGGER.error("fireEvent-7");
			}
			// LOGGER.error("fireEvent-8");
		}
	}

	public void messageReceived(Association aAssociation,
			AssociationListener aListener, byte aPresentationContextID,
			AbstractDimseMessage aMessage) throws Exception {
		this.fireEvent(aAssociation, EventType.MESSAGE_RECEIVED, aListener,
				aMessage, aPresentationContextID);
	}

	protected void processEvent(Association aAssociation, EventType type,
			AssociationListener aListener, Object data, byte aPresentationContextID) {
		assert aAssociation != null;
		assert type != null;
		assert aListener != null;
		// LOGGER.error("processEvent:" + type.toString());
		try {

			if (type == EventType.OPENED) {
				aListener.associationOpened(aAssociation, (AssociateSession) data);
			}

			if (type == EventType.RELEASED) {
				aListener.associationReleased(aAssociation);
			}

			if (type == EventType.ABORTED) {
				aListener.associationAborted(aAssociation, (AssociateAbort) data);
			}

			if (type == EventType.MESSAGE_RECEIVED) {
				assert data != null;
				aListener.messageReceived(aAssociation, aPresentationContextID,
						(AbstractDimseMessage) data);
			}

		} catch (Exception e) {
			aListener.exceptionCaught(aAssociation, e);
		}
	}

}
