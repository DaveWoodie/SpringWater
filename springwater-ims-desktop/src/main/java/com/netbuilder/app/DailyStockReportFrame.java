/**
 * @author abutcher
 * @date 09/10/2015
 */

package com.netbuilder.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class DailyStockReportFrame {
	int lowSelectedID;
	int fastSelectedID;
	
	public DailyStockReportFrame() {
	}

	public JPanel getStockReportPanel() {
		int numRows = 30;
		String[] colHeadings = { "Item ID", "Item Name", "Stock Level","Sales Rate" };
		final JLabel fastSellingLabel = new JLabel("Fast Selling Items");
		final JLabel LowStockLabel = new JLabel("Low stock Items");
		JPanel pane = new JPanel();
		JPanel lowStockPanel = new JPanel();
		JPanel fastSellingPanel = new JPanel();
		GridLayout stockReportLayout = new GridLayout(1, 2);

		// Create Table Models
		LoadData lD = new LoadData();
		DefaultTableModel lowStockModel = new DefaultTableModel(lD.fetchLowStockList(), colHeadings);
		//lowStockModel.setColumnIdentifiers(colHeadings);
		DefaultTableModel fastSellingkModel = new DefaultTableModel(lD.fetchHighSaleList(), colHeadings);
		//fastSellingkModel.setColumnIdentifiers(colHeadings);

//		// Fill tables with test data
//		lowStockModel = fillTable(numRows, lowStockModel);
//		fastSellingkModel = fillTable(numRows, fastSellingkModel);
		
		//Create Tables
		final JTable lowStockTable = new JTable(lowStockModel);
		final JTable fastSellingTable = new JTable(fastSellingkModel);
		
		// ActionListener for tables
		ListSelectionModel lowStockcellSelectionModel = lowStockTable.getSelectionModel();
		lowStockcellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lowStockcellSelectionModel.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						int lowSelectedRow = lowStockTable.getSelectedRow();
						try {
							lowSelectedID = Integer.parseInt(lowStockTable.getValueAt(lowSelectedRow, 0).toString());
						} catch (NullPointerException npe) {
							System.out.println("Not a valid Item!");
						}
					}
				});

		ListSelectionModel fastStockcellSelectionModel = fastSellingTable.getSelectionModel();
		fastStockcellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		fastStockcellSelectionModel.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						int fastSelectedRow = fastSellingTable.getSelectedRow();
						try {
							fastSelectedID = Integer.parseInt(fastSellingTable.getValueAt(fastSelectedRow, 0).toString());
						} catch (NullPointerException npe) {
							System.out.println("Not a valid Item!");
						}
					}
				});
		
		// Select buttons
		JButton lowStockSelect = new JButton("Open Selected Item");
		lowStockSelect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(lowSelectedID ==0) {
					System.out.println("No item selected!");
				}
				else {
				@SuppressWarnings("unused")
				ItemGUI IG = new ItemGUI(lowSelectedID);
				}
			}		
		});
		
		JButton fastSellingSelect = new JButton("Open Selected Item");
		fastSellingSelect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if(fastSelectedID ==0) {
					System.out.println("No item selected!");
				}
				else {
					@SuppressWarnings("unused")
					ItemGUI IG = new ItemGUI(fastSelectedID);
				}
			}		
		});
		
		// Set up box layouts
		BoxLayout lowStockBoxLayout = new BoxLayout(lowStockPanel,BoxLayout.Y_AXIS);
		lowStockPanel.setLayout(lowStockBoxLayout);
		BoxLayout fastSellingBoxLayout = new BoxLayout(fastSellingPanel,BoxLayout.Y_AXIS);
		fastSellingPanel.setLayout(fastSellingBoxLayout);

		// Formatting
		fastSellingLabel.setForeground(Color.GREEN);
		LowStockLabel.setForeground(Color.RED);
//		fastSellingPanel.setBackground(Color.WHITE);
//		lowStockPanel.setBackground(Color.WHITE);
//		fastSellingTable.getTableHeader().setBackground(Color.WHITE);
//		lowStockTable.getTableHeader().setBackground(Color.WHITE);
//		fastSellingPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
//		lowStockPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		// Add components to low stock panel
//		lowStockTable.setPreferredScrollableViewportSize(lowStockTable.getPreferredSize());
//		lowStockTable.setFillsViewportHeight(true);
		LowStockLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lowStockPanel.add(LowStockLabel);
		lowStockPanel.add(new JScrollPane(lowStockTable));
		lowStockPanel.add(lowStockSelect);

		// Add components to fast selling panel
//		fastSellingTable.setPreferredScrollableViewportSize(fastSellingTable.getPreferredSize());
//		fastSellingTable.setFillsViewportHeight(true);
		fastSellingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		fastSellingPanel.add(fastSellingLabel);
		fastSellingPanel.add(new JScrollPane(fastSellingTable));
		fastSellingPanel.add(fastSellingSelect);

		// set up and add pane
		pane.setLayout(stockReportLayout);
		pane.add(lowStockPanel);
		pane.add(fastSellingPanel);
		return pane;
	}
	
	//fills the table with test data
	private DefaultTableModel fillTable(int numRows, DefaultTableModel dtm) {
		for (int i = 0;i<numRows; i++) {
			dtm.setValueAt(i+1, i, 0);
			dtm.setValueAt("Test", i, 1);
			dtm.setValueAt("5", i, 2);
			dtm.setValueAt("10", i, 3);
		}
		return dtm;
	}
	
}
