/**
 * @author jforster
 * @date 09/10/2015
 */
package com.netbuilder.app;

import java.awt.BorderLayout;
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
import javax.swing.border.EmptyBorder;

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
	DailyStockReportFrame dSRF;
	SuppliersFrame sF;
	PurchaseOrders pO;
	
	/**
	 * Method to call GUI initialisation
	 */
	public MainFrame() {
		initUI();
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
		
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		dSRF = new DailyStockReportFrame();
		panel1.add(dSRF.getStockReportPanel());
		pane.addTab("Daily Report", null, panel1, "Daily Report");
		
		panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		InventoryGUI iGUI = new InventoryGUI();
		panel2.add(iGUI);
		pane.addTab("Inventory", null, panel2, "Inventory");
		
		panel3 = new JPanel();
		panel3.setLayout(new BorderLayout());
		pO = new PurchaseOrders();
		panel3.add(pO.initUI());
		pane.addTab("Purchase Orders", null, panel3, "Purchase Orders");
		
		panel4 = new JPanel();
		panel4.setLayout(new BorderLayout());
		sF = new SuppliersFrame();
		panel4.add(sF.initUI());
		pane.addTab("Suppliers", null, panel4, "Suppliers");
		
		//create bottom panel
		bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		
		//PlaceHolder for actual Login details.
		loginDetails = new JLabel("<html>Employee ID: 1<br>Employee Name: Al Stock");
		
		//create logout button
		logout = new JButton("Logout");
		logout.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Logout method to return to login screen
			}
			
		});
		
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
		bottom.add(logout);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(quit);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		
		//construct base panel
		base.add(pane, BorderLayout.CENTER);
		base.add(bottom, BorderLayout.SOUTH);
		add(base);
		
		//configure JFrame
		setTitle("Inventory Management System");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 800));

        //delete before push
        setVisible(true);
	}


}
