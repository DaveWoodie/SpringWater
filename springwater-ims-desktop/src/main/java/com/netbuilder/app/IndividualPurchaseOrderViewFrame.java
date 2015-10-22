package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.netbuilder.logic.PurchaseOrderLineLogic;

@SuppressWarnings("serial")
public class IndividualPurchaseOrderViewFrame extends JFrame {

	private String [] columns = {"Item ID", "Item Name", "Quantity", "Number Damaged", "Subtotal"};
	private JPanel contentPane, bottom, top;
	private JTable itemTable;
	private JButton select;
	private JButton quit;
	private JLabel loginDetails, orderID, supplier, datePlaced, orderStatus, orderTotal;
	private DefaultTableModel defaultItemTable;
	private int selectedID;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					IndividualPurchaseOrderView frame = new IndividualPurchaseOrderView(0);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public IndividualPurchaseOrderViewFrame( int id, String supplierName, String date, String status, String total) {
		
		setTitle("Full Purchase Order Details");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 800));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(50, 50, 1050, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		PurchaseOrderLineLogic lD =  new PurchaseOrderLineLogic();
		defaultItemTable = new DefaultTableModel(lD.fetchPurchaseOrderLinesByPurchaseOrderID(id), columns){
			@Override
		    public boolean isCellEditable(int i, int i1) {
		        return false; //To change body of generated methods, choose Tools | Templates.
		    }
		};
		itemTable = new JTable(defaultItemTable);
		ListSelectionModel prListSelectionModel =itemTable.getSelectionModel();
		prListSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		prListSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = itemTable.getSelectedRow();
				try {
					selectedID = Integer.parseInt(itemTable.getValueAt(selectedRow, 0).toString());
				} catch (NullPointerException npe) {
					System.out.println("Not a valid Item!");
				}
			}
		});
		
//		itemTable = new JTable();
		scrollPane.setViewportView(itemTable);
		
		top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
		
		//These are place holders for the Supplied things
		orderID = new JLabel("Order ID: " + id);
		supplier = new JLabel("Supplier: " + supplierName);
		datePlaced = new JLabel("Date Placed: " + date);
		orderStatus = new JLabel("Order Status: " + status);
		
		top.add(Box.createRigidArea(new Dimension(10,0)));
		top.add(orderID);
		top.add(Box.createRigidArea(new Dimension(10,0)));
		top.add(supplier);
		top.add(Box.createRigidArea(new Dimension(10,0)));
		top.add(datePlaced);
		top.add(Box.createRigidArea(new Dimension(10,0)));
		top.add(orderStatus);
		top.add(Box.createRigidArea(new Dimension(10,0)));
		
		bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		
		loginDetails = new JLabel("<html>Employee ID: 1<br>Employee Name: Al Stock");
		orderTotal = new JLabel("Order Total: " + total);
		
		//create logout button
//		logout = new JButton("Logout");
//		logout.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				// TODO Logout method to return to login screen
//			}
//		});
		
		//create select Item button
		select = new JButton("Select Item");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedID ==0) {
					System.out.println("No item selected!");
				}
				else {
				@SuppressWarnings("unused")
				ItemGUI IG = new ItemGUI(selectedID);
				}			
			}
		});
		
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
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(orderTotal);
//		bottom.add(Box.createRigidArea(new Dimension(10,0)));
//		bottom.add(logout);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(select);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(quit);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
				
		//construct base panel
		contentPane.add(scrollPane, BorderLayout.CENTER);
		contentPane.add(bottom, BorderLayout.SOUTH);
		contentPane.add(top, BorderLayout.NORTH);
		add(contentPane);
//		pack();
		setLocationRelativeTo(null);
	}

}
