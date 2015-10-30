/**
 * @author jforster
 * @date 09/10/2015
 */
package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.MessageConsumer;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.apache.activemq.ActiveMQConnectionFactory;

import entities.MessageContent;
import loaders.LoginLoader;

/**
 * GUI to load and select all other GUIs
 */

@SuppressWarnings("serial")
public class MainGUI extends JPanel implements ComponentListener , ActionListener, MessageListener{
	
	JPanel base, panel1, panel2, panel3, panel4, bottom;
	JTabbedPane pane;
	JLabel loginDetails;
	JButton logout, quit, refresh;
	InventoryGUI iGUI;
	DailyStockReportGUI dSRF;
	SuppliersGUI sF;
	PurchaseOrdersGUI pO;
	
	private GUIStart src;
	private String userID;
	private LoginLoader loginLoader = new LoginLoader();
	private String[] User = new String[1];
	private String boardName = "IMS.IN";
	public MessageConsumer consumer;
	
	/**
	 * Method to call GUI initialisation
	 */
	public MainGUI() {
		initUI();
	}
	
	public MainGUI(GUIStart src, String userID) {
		this.src = src;
		this.src.addComponentListener(this);
		this.userID = userID;
		User = loginLoader.getNameByID(userID);
		initUI();
		try {
			 
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:8081");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createTopic(boardName);

            // Create a MessageConsumer from the Session to the Topic or Queue
            consumer = session.createConsumer(destination);
		}
		catch (Exception e) {
			JFrame popupFrame = new JFrame();
			JOptionPane.showMessageDialog(popupFrame, "Cannot connect to system backend, some features will not be available.");
		}
	}
	
	/**
	 * Method to create GUI menu frame for the java app.
	 */
	public void initUI() {
		
		base = new JPanel();
		base.setBorder(new EmptyBorder(5, 5, 5, 5));
		base.setLayout(new BorderLayout());

		//create tabbed pane and tabs
		pane = new JTabbedPane();
		
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		iGUI = new InventoryGUI();
		panel2.add(iGUI);
		pane.addTab("Inventory", null, panel2, "Inventory");
		
		panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		pO = new PurchaseOrdersGUI();
		panel3.add(pO.initUI());
		pane.addTab("Purchase Orders", null, panel3, "Purchase Orders");
		
		panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		sF = new SuppliersGUI();
		panel4.add(sF.initUI());
		pane.addTab("Suppliers", null, panel4, "Suppliers");
		
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		dSRF = new DailyStockReportGUI();
		panel1.add(dSRF.getStockReportPanel());
		pane.addTab("Daily Report", null, panel1, "Daily Report");
		
		//create bottom panel
		bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		
		//PlaceHolder for actual Login details.
		loginDetails = new JLabel("<html>Employee ID: " + userID + "<br>Employee Name: " + User[0] + " " + User[1]);
		
		//Refresh Button
		refresh = new JButton("Refresh");
		refresh.addActionListener(this);
		
		//create logout button
		logout = new JButton("Logout");
		logout.addActionListener(this);
		
		//create quit button
		quit = new JButton("Quit");
		quit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		//construct bottom panel
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(loginDetails);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(refresh);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(logout);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(quit);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		
		//construct base panel
		base.add(pane, BorderLayout.CENTER);
		base.add(bottom, BorderLayout.SOUTH);
		add(base);
	
		//configure JFrame
//		setTitle("Inventory Management System");
//		base.setSize(650, 850);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//		base.setMinimumSize(new Dimension(650, 850));
        //delete before push
        setVisible(true);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		// TODO Auto-generated method stub
		resizeEverything();
	}

	private void resizeEverything() {
		Dimension d = new Dimension(src.getWidth()-16, src.getHeight()-38);
		base.setPreferredSize(d);
		base.setMaximumSize(d);
		base.setMinimumSize(d);
		this.repaint();
		this.revalidate();
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(logout)) {
			src.revertToLogin();
		}
		if (e.getSource().equals(refresh)) {
			iGUI.refresh();
			//DailyStockReportGUI 
			dSRF.refresh();
			//SuppliersGUI
			sF.refresh();
			// PurchaseOrdersGUI
			pO.refresh();
		}
		
	}
	
	/**
	 * Listener to receive messages from the IMS inbox
	 */
	@Override
	public void onMessage(Message message) {
		// TODO Handle inbound message types
		ObjectMessage objectMessage = (ObjectMessage) message;
		try {
			if (objectMessage.getObject() instanceof MessageContent) {
				MessageContent messageContent = (MessageContent) objectMessage.getObject();
				if (messageContent.getMessage().equals("damagedStockReport")) {
					JFrame popupFrame = new JFrame();
					JOptionPane.showMessageDialog(popupFrame, (String) messageContent.getContents());
				}
				else if (messageContent.getMessage().equals("newStockReport")) {
					JFrame popupFrame = new JFrame();
					JOptionPane.showMessageDialog(popupFrame, (String) messageContent.getContents());
				}
			}
		}
		catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
