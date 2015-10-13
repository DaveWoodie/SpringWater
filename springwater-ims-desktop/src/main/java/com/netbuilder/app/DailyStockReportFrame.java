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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

		// Create Table Models + Tables
		DefaultTableModel lowStockModel = new DefaultTableModel(numRows,colHeadings.length);
		lowStockModel.setColumnIdentifiers(colHeadings);
		DefaultTableModel fastSellingkModel = new DefaultTableModel(numRows,colHeadings.length);
		fastSellingkModel.setColumnIdentifiers(colHeadings);
		final JTable lowStockTable = new JTable(lowStockModel);
		final JTable fastSellingTable = new JTable(fastSellingkModel);

		// actionListener for tables
		ListSelectionModel lowStockcellSelectionModel = lowStockTable.getSelectionModel();
		lowStockcellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lowStockcellSelectionModel.addListSelectionListener(new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						int lowSelectedRow = lowStockTable.getSelectedRow();
						try {
							lowSelectedRow = Integer.parseInt(lowStockTable.getValueAt(lowSelectedRow, 0).toString());
							System.out.println("Item ID: " + lowSelectedRow+ " selected!");
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
							fastSelectedRow = Integer.parseInt(fastSellingTable.getValueAt(fastSelectedRow, 0).toString());
							System.out.println("Item ID: " + fastSelectedRow+ " selected!");
						} catch (NullPointerException npe) {
							System.out.println("Not a valid Item!");
						}
					}
				});

		JButton lowStockSelect = new JButton("Select");
		lowStockSelect.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Take selected item from list and load into item frame
				@SuppressWarnings("unused")
				ItemGUI IG = new ItemGUI();
			}		
		});
		
		JButton fastSellingSelect = new JButton("Select");
		fastSellingSelect.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Take selected item from list and load into item frame
				@SuppressWarnings("unused")
				ItemGUI IG = new ItemGUI();
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
		fastSellingPanel.setBackground(Color.WHITE);
		lowStockPanel.setBackground(Color.WHITE);
		fastSellingTable.getTableHeader().setBackground(Color.WHITE);
		lowStockTable.getTableHeader().setBackground(Color.WHITE);
		fastSellingPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		lowStockPanel.setBorder(BorderFactory.createLineBorder(Color.black));

		// Add components to low stock panel
		lowStockTable.setPreferredScrollableViewportSize(lowStockTable.getPreferredSize());
		lowStockTable.setFillsViewportHeight(true);
		LowStockLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lowStockPanel.add(LowStockLabel);
		lowStockPanel.add(new JScrollPane(lowStockTable));
		lowStockPanel.add(lowStockSelect);

		// Add components to fast selling panel
		fastSellingTable.setPreferredScrollableViewportSize(fastSellingTable.getPreferredSize());
		fastSellingTable.setFillsViewportHeight(true);
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

}
