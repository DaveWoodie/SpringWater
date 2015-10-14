package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class IndividualPurchaseOrderView extends JFrame {

	private String [] columns = {"Item ID", "Quantity", "Number Damaged", "Total Price"};
	private JPanel contentPane, bottom, top;
	private JTable itemTable;
	private JButton quit;
	private JLabel loginDetails, orderID, supplier, datePlaced;
	private DefaultTableModel defaultItemTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IndividualPurchaseOrderView frame = new IndividualPurchaseOrderView(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IndividualPurchaseOrderView( int id) {
		
		setTitle("Purchase Order");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1000, 700));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		defaultItemTable = new DefaultTableModel(columns, 0);
		itemTable = new JTable(defaultItemTable);
//		itemTable = new JTable();
		scrollPane.setViewportView(itemTable);
		
		top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
		
		//These are place holders for the Supplied things
		orderID = new JLabel("Order ID placeholder");
		supplier = new JLabel("Supplier placeholder");
		datePlaced = new JLabel("Date Placed placeholder");
		
		top.add(Box.createRigidArea(new Dimension(10,0)));
		top.add(orderID);
		top.add(Box.createRigidArea(new Dimension(10,0)));
		top.add(supplier);
		top.add(Box.createRigidArea(new Dimension(10,0)));
		top.add(datePlaced);
		top.add(Box.createRigidArea(new Dimension(10,0)));
		
		bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		
		loginDetails = new JLabel("<html>Employee ID: 1<br>Employee Name: Al Stock");
		
		//create logout button
//		logout = new JButton("Logout");
//		logout.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				// TODO Logout method to return to login screen
//			}
//		});
				
		//create quit button
		quit = new JButton("Quit");
		quit.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				dispose();
			}	
		});
				
		//construct bottom panel
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(loginDetails);
//		bottom.add(Box.createRigidArea(new Dimension(10,0)));
//		bottom.add(logout);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(quit);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
				
		//construct base panel
		contentPane.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(bottom, BorderLayout.SOUTH);
		contentPane.add(top, BorderLayout.NORTH);
		add(contentPane);
		
	}

}
