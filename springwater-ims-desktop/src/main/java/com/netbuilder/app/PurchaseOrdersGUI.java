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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.netbuilder.logic.PurchaseOrderLogic;

@SuppressWarnings("serial")
public class PurchaseOrdersGUI extends JPanel {
	
	private String [] columns = {"Purchase Order ID", "Date Placed", "Status", "Supplier", "Total"};
	private String [] purchaseOrderCategories = {"Status", "Supplier", "Date", "Order ID"};
	TableModel purchaseListTable;
	JPanel table, south, search, controller;
	JTable purchaseOrderTable;
	JScrollPane paneAlph, paneBeta;
	JTextField searchField;
	JComboBox<String> filterPurchaseOrder;
	JButton filter, select, reset, add;
	JLabel searchFieldLabel, filterFieldLabel;
	
	int currentlySelectedOrder = 0;
	
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
		//
		//search.add(paneBeta);
		//
		search.add(searchField);
		
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
		
		final PurchaseOrderLogic lD = new PurchaseOrderLogic();
		purchaseListTable = new DefaultTableModel(lD.fetchPurchaseOrders(), columns){
			@Override
		    public boolean isCellEditable(int i, int i1) {
		        return false; //To change body of generated methods, choose Tools | Templates.
		    }
		};
		
		purchaseOrderTable = new JTable(purchaseListTable);
		purchaseOrderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    ListSelectionModel cellSelectionModel = purchaseOrderTable.getSelectionModel();
	    cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    
	    //add selection listener to the list
		cellSelectionModel.addListSelectionListener(new ListSelectionListener(){
			
			public void valueChanged(ListSelectionEvent e) {
				// TODO select ID of selected row
				if (purchaseOrderTable.getSelectedRow() != -1) {
					try {
						int selectedRow = purchaseOrderTable.getSelectedRow();
						currentlySelectedOrder = Integer.parseInt(purchaseOrderTable.getValueAt(selectedRow, 0).toString());
						//System.out.println("Supplier ID: " + currentlySelectedOrder + " selected!");
					}
					catch (NullPointerException npe) {
						System.out.println("Null Purchase Order!");
					} 
				}
				else {
					currentlySelectedOrder = 0;
				}
			}
			
		});
		
		searchFieldLabel = new JLabel("Filter:");
		filterFieldLabel = new JLabel("Filter By:");
		paneAlph = new JScrollPane(purchaseOrderTable);
		searchField = new JTextField();
//		paneBeta = new JScrollPane(searchField);
		
		filter = new JButton("Filter Results");
		filter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				// TODO set filter of table results
				//Should apply the filters selected to the table.
				Object[][] update;
				String input = searchField.getText();
				switch (filterPurchaseOrder.getSelectedItem().toString()) {
					case "Order ID":
						System.out.println(input);
						int i = Integer.parseInt(input);
						update = lD.fetchPurchaseOrdersByID(i);
						break;
					
					case "Status":
						update = lD.fetchPurchaseOrdersByStatus(input);
						break;
						
					case "Supplier":
						update = lD.fetchPurchaseOrdersBySupplier(input);
						break;
						
					case "Date":
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
						try {
							Date date = formatter.parse(input);
							System.out.println("Date populated: " + formatter.format(date));
							update = lD.fetchPurchaseOrdersByDate(date);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							try {
								formatter = new SimpleDateFormat("dd/MM/yyyy");
								Date date = formatter.parse(input);
								System.out.println("Date populated: " + formatter.format(date));
								update = lD.fetchPurchaseOrdersByDate(date);
							} catch (ParseException e2) {
								// TODO Auto-generated catch block
								update = null;
							}
						}
						break;
					
					
					default:
						update = null;
						
				}
				purchaseListTable =  new DefaultTableModel(update, columns){
					@Override
				    public boolean isCellEditable(int i, int i1) {
				        return false; //To change body of generated methods, choose Tools | Templates.
				    }
				};
				purchaseOrderTable.setModel(purchaseListTable);
			}
		});
		
		select = new JButton("Select Order");
		select.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(currentlySelectedOrder == 0) {
					System.out.println("No Purchase Order selected!");
				}
				else {
					String suppliername = purchaseOrderTable.getValueAt(purchaseOrderTable.getSelectedRow(), 3).toString();
					String date = purchaseOrderTable.getValueAt(purchaseOrderTable.getSelectedRow(), 1).toString();
					String status = purchaseOrderTable.getValueAt(purchaseOrderTable.getSelectedRow(), 2).toString();
					String total = purchaseOrderTable.getValueAt(purchaseOrderTable.getSelectedRow(), 4).toString();
					IndividualPurchaseOrderViewFrame iPO = new IndividualPurchaseOrderViewFrame(currentlySelectedOrder, suppliername, date, status, total);
					iPO.setVisible(true);
				}
			}
		});
		
		reset = new JButton("Reset Filters");
		reset.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				final PurchaseOrderLogic lD = new PurchaseOrderLogic();
				purchaseListTable = new DefaultTableModel(lD.fetchPurchaseOrders(), columns){
					@Override
				    public boolean isCellEditable(int i, int i1) {
				        return false; //To change body of generated methods, choose Tools | Templates.
				    }
				};
				purchaseOrderTable.setModel(purchaseListTable);
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

