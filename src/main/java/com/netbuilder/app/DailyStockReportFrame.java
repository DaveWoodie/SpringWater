/**
 * @author abutcher
 * @date 09/10/2015
 */

package com.netbuilder.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DailyStockReportFrame extends JFrame {

	public DailyStockReportFrame() {

	}

	public JPanel getStockReportPanel() {
		int numRows = 30 ;
		String[] colHeadings = {"Item ID","Item Name", "Current Stock", "Sales Rate"};
		final JLabel fastSellingLabel = new JLabel("Fast Selling Items");
		final JLabel LowStockLabel = new JLabel("Low stock Items");
		JPanel pane = new JPanel();
		JPanel lowStockPanel = new JPanel();
		JPanel fastSellingPanel = new JPanel();
		GridLayout stockReportLayout = new GridLayout(1, 2);
		
		//Create Table Models + Tables
		DefaultTableModel lowStockModel = new DefaultTableModel(numRows, colHeadings.length) ;
		lowStockModel.setColumnIdentifiers(colHeadings);	
		DefaultTableModel fastSellingkModel = new DefaultTableModel(numRows, colHeadings.length) ;
		fastSellingkModel.setColumnIdentifiers(colHeadings);	
		JTable lowStockTable = new JTable(lowStockModel);
		JTable fastSellingTable = new JTable(fastSellingkModel);
		
		//Set up box layouts
		BoxLayout lowStockBoxLayout = new BoxLayout(lowStockPanel, BoxLayout.Y_AXIS);
		lowStockPanel.setLayout(lowStockBoxLayout);	
		BoxLayout fastSellingBoxLayout = new BoxLayout(fastSellingPanel, BoxLayout.Y_AXIS);
		fastSellingPanel.setLayout(fastSellingBoxLayout);
		
		
		//Formatting
		fastSellingLabel.setForeground(Color.GREEN);
		LowStockLabel.setForeground(Color.RED);
		fastSellingPanel.setBackground(Color.WHITE);
		lowStockPanel.setBackground(Color.WHITE);
		fastSellingTable.getTableHeader().setBackground(Color.WHITE);
		lowStockTable.getTableHeader().setBackground(Color.WHITE);
		
		
		//Add components to low stock panel
		lowStockTable.setPreferredScrollableViewportSize(lowStockTable.getPreferredSize());
		lowStockTable.setFillsViewportHeight(true);
		LowStockLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lowStockPanel.add(LowStockLabel);
		lowStockPanel.add(new JScrollPane(lowStockTable));
		
		//Add components to fast selling panel
		fastSellingTable.setPreferredScrollableViewportSize(fastSellingTable.getPreferredSize());
		fastSellingTable.setFillsViewportHeight(true);
		fastSellingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		fastSellingPanel.add(fastSellingLabel);
		fastSellingPanel.add(new JScrollPane(fastSellingTable));
		
		//set up and add pane
		pane.setLayout(stockReportLayout);	
		pane.add(lowStockPanel);
		pane.add(fastSellingPanel);
		return pane;
	}
}
