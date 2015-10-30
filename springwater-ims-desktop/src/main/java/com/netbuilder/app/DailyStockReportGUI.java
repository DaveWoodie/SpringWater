/**
 * @author abutcher
 * @date 09/10/2015
 */

package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.netbuilder.logic.StockReportLogic;

public class DailyStockReportGUI {
	private int lowSelectedID;
	private int fastSelectedID;
	private UneditableTableModel lowStockModel;
	private UneditableTableModel fastSellingkModel;
	private String[] colHeadings;
	
	private StockReportLogic logic = new StockReportLogic();
	
	public DailyStockReportGUI() {
		colHeadings = new String[]{ "Item ID", "Item Name", "Stock Level","Sales Rate" };
	}

	/**
	 * method to get the daily stock report pane
	 * @return a JPanel containing the stock report
	 */
	public JPanel getStockReportPanel() {
		
		final JLabel fastSellingLabel = new JLabel("Fluctuating Items", SwingConstants.CENTER);
		final JLabel LowStockLabel = new JLabel("Current Stock", SwingConstants.CENTER);
		JPanel pane = new JPanel();
		JPanel lowStockPanel = new JPanel();
		JPanel fastSellingPanel = new JPanel();
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel mainPane = new JPanel();
		GridLayout stockReportLayout = new GridLayout(1, 2);

		// Create Table Models
		lowStockModel = new UneditableTableModel(logic.fetchStockList(), colHeadings);
		fastSellingkModel = new UneditableTableModel(logic.fetchFastMovingList(), colHeadings);

		
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

		LowStockLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		lowStockPanel.add(new JScrollPane(lowStockTable));

		// Add components to fast selling panel
		fastSellingLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		fastSellingPanel.add(new JScrollPane(fastSellingTable));

		// set up and add pane
		pane.setLayout(stockReportLayout);
		pane.add(lowStockPanel);
		pane.add(fastSellingPanel);
		topPanel.setLayout(stockReportLayout);
		topPanel.add(LowStockLabel);
		topPanel.add(fastSellingLabel);
		bottomPanel.setLayout(stockReportLayout);
		bottomPanel.add(lowStockSelect);
		bottomPanel.add(fastSellingSelect);
		mainPane.setLayout(new BorderLayout());
		mainPane.add(topPanel, BorderLayout.NORTH);
		mainPane.add(pane, BorderLayout.CENTER);
		mainPane.add(bottomPanel, BorderLayout.SOUTH);
		return mainPane;
	}
	
	public void refresh() {
		lowStockModel = new UneditableTableModel(logic.fetchStockList(), colHeadings);
		fastSellingkModel = new UneditableTableModel(logic.fetchFastMovingList(), colHeadings);
	}
	
	//fills the table with test data
	@Deprecated
	@SuppressWarnings("unused")
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
