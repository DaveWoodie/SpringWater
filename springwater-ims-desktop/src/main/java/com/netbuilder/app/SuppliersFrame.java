/**
 * @author jforster
 * @date 12/10/1015
 */
package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

@SuppressWarnings("serial")
public class SuppliersFrame extends JPanel{
	
	private String [] columns = {"Supplier ID", "Supplier Name"};
	private String [] supplierCategories = {"Supplier ID", "Supplier Name", "Product ID"};
	TableModel supplierListModel;
	JPanel table, south, search, controller;
	JTable suppliers;
	JScrollPane pane, pane2;
	JTextArea searchTerm;
	JComboBox<String> categories;
	JButton filter, select, reset, add;
	JLabel searchLabel, filterLabel;
	private int selectedOrder;
	
	/**
	 * Method to create GUI panel for the list of suppliers
	 * @return JPanel to be loaded into main Frame
	 */
	public JPanel initUI() {
		
		//set layout of main panel
		setLayout(new BorderLayout());
		
		//set layouts of other panels
		table = new JPanel();
		table.setLayout(new BorderLayout());
		south = new JPanel();
		south.setLayout(new BoxLayout(south, BoxLayout.Y_AXIS));
		search = new JPanel();
		search.setLayout(new BoxLayout(search, BoxLayout.X_AXIS));
		controller = new JPanel();
		controller.setLayout(new GridLayout(1, 4));
		
		//create components
		categories = new JComboBox<String>(supplierCategories);
		
		supplierListModel = new DefaultTableModel(columns, 20);
		suppliers = new JTable(supplierListModel);
		suppliers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    ListSelectionModel cellSelectionModel = suppliers.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
	    //add selection listener to the list
		cellSelectionModel.addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent e) {
				// TODO select ID of selected row
				int selectedRow = suppliers.getSelectedRow();
				try {
					selectedOrder = Integer.parseInt(suppliers.getValueAt(selectedRow, 0).toString());
					System.out.println("Supplier ID: " + selectedOrder + " selected!");
				}
				catch (NullPointerException npe) {
					System.out.println("Not a valid supplier!");
				}
			}
			
		});
		
		searchLabel = new JLabel("Filter Term:");
		filterLabel = new JLabel("Filter By:");
		searchTerm = new JTextArea();
		pane = new JScrollPane(suppliers);
		pane2 = new JScrollPane(searchTerm);
		
		filter = new JButton("Filter Results");
		filter.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO set filter of table results
				
			}
			
		});
		
		select = new JButton("Select Supplier");
		select.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Take selected supplier from list and load into supplier frame
				SupplierFrame sF = new SupplierFrame();
			}
			
		});
		
		reset = new JButton("Reset Filters");
		reset.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Reset search filters and reload full list of results
				
			}
			
		});
		
		add = new JButton("New Supplier");
		add.addActionListener(new ActionListener(){
			
			public void actionPerformed(ActionEvent e) {
				//TODO add new supplier details
			}
			
		});
		
		//construct panels
		table.add(pane);
		
		search.add(filterLabel);
		search.add(Box.createRigidArea(new Dimension(10,0)));
		search.add(categories);
		search.add(Box.createRigidArea(new Dimension(10,0)));
		search.add(searchLabel);
		search.add(Box.createRigidArea(new Dimension(10,0)));
		search.add(pane2);
		
		controller.add(select);
		controller.add(filter);
		controller.add(reset);
		controller.add(add);
		
		south.add(search);
		south.add(controller);
		
		add(table, BorderLayout.CENTER);
		add(south, BorderLayout.SOUTH);
		
		return this;
	}


}
