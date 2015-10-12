/**
 * @author dwoodward
 * @date 12/10/2015
 */

package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class PurchaseOrders extends JPanel {
	
	private String [] columns = {"Purchase Order ID", "Date Placed", "Status", "Supplier"};
	private String [] purchaseOrderCategories = {"Status", "Supplier", "Date", "Order ID"};
	TableModel purchaseListTable;
	JPanel table, south, search, controller;
	JTable purchaseOrderTable;
	JScrollPane paneAlph, paneBeta;
	JTextField searchField;
	JComboBox<String> filterPurchaseOrder;
	JButton filter, select, reset, add;
	JLabel searchFieldLabel, filterFieldLabel;
	
	public JPanel initUI() {
		
		//set layout of main panel
		setLayout(new BorderLayout());
		addPanels();
		setupComponents();
		addComponents();
		
		return this;
	}
	
	/**
	 * Method to add the panels that will hold the tables, buttons and search fields in the main tabbed pane.
	 */
	public void addPanels() {
		table = new JPanel();
		table.setLayout(new BorderLayout());
		south = new JPanel();
		south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
		search = new JPanel();
		search.setLayout(new BoxLayout(search, BoxLayout.X_AXIS));
		controller = new JPanel();
		controller.setLayout(new GridLayout(1, 3));
	}
	
	/**
	 * Method to add all components to the panels and the main pane.
	 */
	public void addComponents() {
		
		table.add(paneAlph);
		
		search.add(filterFieldLabel);
		search.add(Box.createRigidArea(new Dimension(10,0)));
		search.add(filterPurchaseOrder);
		search.add(Box.createRigidArea(new Dimension(10,0)));
		search.add(searchFieldLabel);
		search.add(Box.createRigidArea(new Dimension(10,0)));
		search.add(paneBeta);
		
		controller.add(select);
		controller.add(filter);
		controller.add(reset);
		
		south.add(search);
		south.add(controller);
		
		add(table, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
	}
	
	/**
	 * Method to build all components that are added to the panels.
	 */
	public void setupComponents() {
		
		filterPurchaseOrder = new JComboBox<String>(purchaseOrderCategories);
		
		purchaseListTable = new DefaultTableModel(columns, 0);
		purchaseOrderTable = new JTable(purchaseListTable);
		searchFieldLabel = new JLabel("Filter:");
		filterFieldLabel = new JLabel("Filter By:");
		paneAlph = new JScrollPane(purchaseOrderTable);
		searchField = new JTextField();
		paneBeta = new JScrollPane(searchField);
		
		filter = new JButton("Filter Results");
		filter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO set filter of table results
				//Should apply the filters selected to the table.
			}
		});
		
		select = new JButton("Select Order");
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Take selected supplier from list and load into supplier frame
				//This button should open a new Frame (IndividualPurchaseOrderFrame).
			}
		});
		
		reset = new JButton("Reset Filters");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO Reset search filters and reload full list of results
				//This method should re-populate the entire table with call to either the dummy data or the database
			}
		});
		//Currently Commented out due to not really being sure if we need/want the functionality
//		add = new JButton("New Order");
//		add.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				//TODO add new supplier details
//			}
//		});
	}
}
