/**
 * @author jforster
 * @date 09/10/2015
 */
package com.netbuilder.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

/**
 * 
 * GUI to load and select all other GUIs
 *
 */
@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	JPanel base, panel1, panel2, panel3, panel4, bottom;
	JTabbedPane pane;
	JLabel loginDetails;
	JButton logout, quit;
	
	/**
	 * 
	 * Constructor to call GUI initialisation
	 *
	 */
	public MainFrame() {
		initUI();
	}
	
	/**
	 * Method to create GUI menu frame for the java app.
	 */
	public void initUI() {
		
		base = new JPanel();
		base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
		
		//test labels for panel generation
		JLabel test = new JLabel("TEST");
		JLabel test2 = new JLabel("TEST2");
		JLabel test3 = new JLabel("TEST3");
		JLabel test4 = new JLabel("TEST4");
		
		//create tabbed pane and tabs
		pane = new JTabbedPane();
		
		panel1 = new JPanel();
		panel1.add(test);
		pane.addTab("Daily Report", null, panel1, "Daily Report");
		
		panel2 = new JPanel();
		panel2.add(test2);
		pane.addTab("Inventory", null, panel2, "Inventory");
		
		panel3 = new JPanel();
		panel3.add(test3);
		pane.addTab("Purchase Orders", null, panel3, "Purchase Orders");
		
		panel4 = new JPanel();
		panel4.add(test4);
		pane.addTab("Suppliers", null, panel4, "Suppliers");
		
		//create bottom panel
		bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		
		loginDetails = new JLabel("<html>Employee ID: 1<br>Employee Name: Al Stock");
		
		//create logout button
		logout = new JButton("Logout");
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Logout method to return to login screen
			}
			
		});
		
		//create quit button
		quit = new JButton("Quit");
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Quit out from java application
				
			}
			
		});
		
		//construct bottom panel
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(loginDetails);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(logout);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(quit);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		
		//construct base panel
		base.add(pane);
		base.add(bottom);
		add(base);
		
		//configure JFrame
		setTitle("Inventory Management System");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 800));
	}
}
