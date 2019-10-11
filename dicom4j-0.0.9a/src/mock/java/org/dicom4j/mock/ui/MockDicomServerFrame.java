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

package org.dicom4j.mock.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import org.apache.log4j.PropertyConfigurator;
import org.dicom4j.mock.network.MockDicomServer;
import org.dolmen.core.lang.ExceptionListener;
import org.dolmen.swing.frames.BaseFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MockDicomServerFrame extends BaseFrame {

	private class MockDicomServerFrameExceptionListener implements
	ExceptionListener {

		public void exceptionOccurs(Throwable exception) {
			MockDicomServerFrame.this.events.append("Throwable: " + exception.getMessage() + "\n");
		}

	}

	private static final Logger logger = LoggerFactory
	.getLogger(MockDicomServerFrame.class);

	private static final long serialVersionUID = 1L;

	/**
	 * @param args
	 * @exception Exception
	 */
	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure("./log4j.properties");
		MockDicomServerFrame frame = new MockDicomServerFrame();
		frame.showCentered();
	}

	private JCheckBox acceptVerificationCheckbox = new JCheckBox(
	"accept Verification");

	private JTextArea events = new JTextArea();

	private JTextArea portTextArea = new JTextArea("10044");

	private MockDicomServer server;

	public MockDicomServerFrame() {
		super();

		this.server = new MockDicomServer(new MockDicomServerFrameExceptionListener());

		this.setLayout(new BorderLayout());

		JPanel top = new JPanel(new BorderLayout());

		JPanel serverPanel = new JPanel();
		serverPanel.setBorder(new TitledBorder("Server settings"));

		this.portTextArea.setPreferredSize(new Dimension(60, 21));

		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					MockDicomServerFrame.this.server.setPort(Integer.parseInt(MockDicomServerFrame.this.portTextArea.getText()));
					MockDicomServerFrame.this.server.startWithException();
					MockDicomServerFrame.this.events.append("server started on port: " + MockDicomServerFrame.this.server.getPort() + "\n ");
				} catch (Exception lE) {
					MockDicomServerFrame.this.events.append(lE.getMessage() + "\n");
				}

			}
		});

		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					MockDicomServerFrame.this.server.stopWithException();
					MockDicomServerFrame.this.events.append("server stopped \n");
				} catch (Exception lE) {
					MockDicomServerFrame.this.events.append(lE.getMessage() + "\n");
				}
				;
			}
		});

		serverPanel.add(new JLabel("Port: "));
		serverPanel.add(this.portTextArea);
		serverPanel.add(startButton);
		serverPanel.add(stopButton);

		JPanel assocationNegociationPanel = new JPanel();
		assocationNegociationPanel.setBorder(new TitledBorder(
		"Assocation Negociation"));

		this.acceptVerificationCheckbox.setSelected(this.server.acceptVerification);
		this.acceptVerificationCheckbox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				MockDicomServerFrame.this.server.acceptVerification = MockDicomServerFrame.this.acceptVerificationCheckbox.isSelected();
			}
		});

		assocationNegociationPanel.add(this.acceptVerificationCheckbox);

		top.add(serverPanel, BorderLayout.NORTH);
		top.add(assocationNegociationPanel, BorderLayout.CENTER);

		this.add(top, BorderLayout.NORTH);
		this.add(new JScrollPane(this.events), BorderLayout.CENTER);

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.exit(0); // we force stop the application
	}

}
