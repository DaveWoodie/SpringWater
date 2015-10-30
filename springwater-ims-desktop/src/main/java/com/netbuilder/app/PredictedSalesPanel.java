package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import loaders.ItemLoader;
import loaders.PurchaseOrderLineLoader;
import loaders.PurchaseOrderLoader;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import entities.Item;
import entities.PurchaseOrder;
import entities.PurchaseOrderLine;

public class PredictedSalesPanel extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	
	private int itemID;
	private JButton buttonUpdate;
	private JPanel graphPanel;
	private ChartPanel chartPanel;
	private Calendar calendar;
	private DateFormat df;
	private DefaultCategoryDataset dataset;
	
	private PurchaseOrderLoader purchaseOrderLoader = new PurchaseOrderLoader();
	private PurchaseOrderLineLoader purchaseOrderLineLoader = new PurchaseOrderLineLoader();
	private ItemLoader itemLoader = new ItemLoader();
	
	public PredictedSalesPanel(int itemID)
	{
		this.itemID = itemID;
		
		makeDataset();
		createUI();
		drawForecastChart();
	}
	
	public void makeDataset()
	{
		//get purchase orders including specified item
		ArrayList<PurchaseOrder> purchaseOrderList = purchaseOrderLoader.getPurchaseOrderListByItem(itemID);
		
		ArrayList<Item> itemList = itemLoader.loadItemByID(itemID);
				
		dataset = new DefaultCategoryDataset();
		
		int Total = 0;
		int counter = 0;
		double salesRate = 0;
		double thirdRate = 0;
		double totalRate = 0;
		
		calendar = Calendar.getInstance();
		df = new SimpleDateFormat("dd-MM-yyyy");
		
		if(purchaseOrderList.size() > 0)
		{
			for(int i = 0; i < purchaseOrderList.size(); i++)
			{
				//go through each purchase order containing the specified item and get the purchase order line
				ArrayList<PurchaseOrderLine> pOLine = purchaseOrderLineLoader.getPurchaseOrderLineByOrderAndProduct(purchaseOrderList.get(i).getIDPurchaseOrder(), itemID);
				
				if(pOLine.size() > 0 && purchaseOrderList.get(i).getDatePlaced() != null) 
				{
					if(counter == 0)
					{
						PurchaseOrderLine purchaseOrderLine = pOLine.get(0);
						Integer j = purchaseOrderLine.getQuantity();
						dataset.addValue(j.doubleValue(), (Comparable<?>) "Week", (Comparable<?>) df.format(calendar.getTime()));
						salesRate = itemList.get(0).getSalesRate();
						System.out.println(salesRate);
						thirdRate = salesRate / 3;
						counter++;
						totalRate = totalRate + thirdRate; 
						dataset.addValue(totalRate, (Comparable<?>) "Week", "1");
						totalRate = totalRate + thirdRate; 
						dataset.addValue(totalRate, (Comparable<?>) "Week", "2");
						totalRate = totalRate + thirdRate; 
						dataset.addValue(totalRate, (Comparable<?>) "Week", "3");
					}
					
				}
			}
		}
	}
	
	public void createUI()
	{
		//Set panel layout
		setLayout(new BorderLayout());
						
		//Options
		JPanel panelOptions = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelOptions.setBorder(BorderFactory.createLineBorder(Color.gray));
				
		//combo boxes
		buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(this);
						
			panelOptions.add(Box.createRigidArea(new Dimension(20, 0)));
			panelOptions.add(buttonUpdate);
					
				//graph panel
				graphPanel = new JPanel(new BorderLayout());
						
				//add components to panel
				add(panelOptions, BorderLayout.NORTH);
				add(graphPanel, BorderLayout.CENTER);
	}
	
	public void drawForecastChart()
	{
		JFreeChart lineChart = ChartFactory.createLineChart(
		         "Predicted Sales",				 //Chart title
		         "Week",					     //X Label
		         "Predicted Sales",		         //Y Label
		         dataset,						 //Data
		         PlotOrientation.VERTICAL,
		         false,							 //Include Legend
		         true,false);
		
		CategoryAxis axis = lineChart.getCategoryPlot().getDomainAxis();
	    axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
	    
	    chartPanel = new ChartPanel(lineChart);
	    chartPanel.setPreferredSize(new Dimension(600, 400));
	    graphPanel.add(chartPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
	}
	
	public static void main(String[] args)
	{
		JFrame j = new JFrame();
		PredictedSalesPanel sg = new PredictedSalesPanel(7);
		
		j.setVisible(true);
		j.add(sg);
		j.setSize(650, 450);
		j.setLocationRelativeTo(null);
	}
}
