/**
 * @author Tom Stacey, Freshwater
 * @date 16/10/2015
 */

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.event.ChartChangeEvent;
import org.jfree.chart.event.ChartChangeListener;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.netbuilder.app.GraphData;
import loaders.PurchaseOrderLineLoader;
import loaders.PurchaseOrderLoader;
import entities.PurchaseOrder;
import entities.PurchaseOrderLine;

/**
 *Sales Graph Panel showing the specified products sales
 */
@SuppressWarnings("serial")
public class SalesGraphGUI extends JPanel implements ActionListener
{
	private int itemID;
	private PurchaseOrderLoader purchaseOrderLoader = new PurchaseOrderLoader();
	private PurchaseOrderLineLoader purchaseOrderLineLoader = new PurchaseOrderLineLoader();
	
	private DefaultCategoryDataset dataset;
	private String[] durationArray;
	private JButton buttonUpdate;
	private JComboBox<String> comboDuration;
	private ChartPanel chartPanelDays, chartPanelYears;
	private JPanel graphPanel;
	private LineAndShapeRenderer LASR;

	public SalesGraphGUI(int itemID) 
	{
		this.itemID = itemID;
		
		makeDataset();
		createUI();
	}
	
	public void createUI()
	{
		//Set panel layout
		setLayout(new BorderLayout());
				
		//Options
		JPanel panelOptions = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelOptions.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//combo boxes
		durationArray = new String[]{"Days", "Months", "Years"};
		comboDuration = new JComboBox<String>(durationArray);
		buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(this);
				
			panelOptions.add(comboDuration);
			panelOptions.add(Box.createRigidArea(new Dimension(20, 0)));
			panelOptions.add(buttonUpdate);
			
		//graph panel
		graphPanel = new JPanel(new BorderLayout());
				
		//add components to panel
		add(panelOptions, BorderLayout.NORTH);
		add(graphPanel, BorderLayout.CENTER);
	}
	
	public void makeDataset() 
	{
		//get purchase orders including specified item
		ArrayList<PurchaseOrder> purchaseOrderList = purchaseOrderLoader.getPurchaseOrderListByItem(itemID);
		
		dataset = new DefaultCategoryDataset();
		
		if(purchaseOrderList.isEmpty() == false)
		{
			for(int i = 0; i < purchaseOrderList.size(); i++)
			{
				//go through each purchase order containing the specified item and get the purchase order line
				ArrayList<PurchaseOrderLine> pOLine = purchaseOrderLineLoader.getPurchaseOrderLineByOrderAndProduct(purchaseOrderList.get(i).getIDPurchaseOrder(), itemID);
				PurchaseOrderLine purchaseOrderLine = pOLine.get(0);
				
				Integer j = purchaseOrderLine.getQuantity();
				
				dataset.addValue(j.doubleValue(), (Comparable<?>) "sales", (Comparable<?>) purchaseOrderList.get(i).getDatePlaced());
			}
		}
	}
	
	private void drawChartDays() 
	{
		JFreeChart lineChart = ChartFactory.createLineChart(
	         "Sales",						 //Chart title
	         "Day",					         //X Label
	         "Number of Items sold",		 //Y Label
	         dataset,						 //Data
	         PlotOrientation.VERTICAL,
	         false,							 //Include Legend
	         true,false);

		LASR = new LineAndShapeRenderer();
		
		lineChart.addChangeListener(new ChartChangeListener()
		{
			@Override
			public void chartChanged(ChartChangeEvent arg0) 
			{
				repaint();
				revalidate();
			}
		});
	    LASR.setBaseShapesVisible(true);
	      
	    CategoryAxis axis = lineChart.getCategoryPlot().getDomainAxis();
	    axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

	    chartPanelDays = new ChartPanel(lineChart);
	    chartPanelDays.setPreferredSize(new Dimension(600, 400));
	    graphPanel.add(chartPanelDays);
	}
	
	private void drawChartYears()
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		new SimpleDateFormat("yyyy-MM-dd");
		Calendar calendar = Calendar.getInstance();
		int Total = 0;
		int oldYear = 0;
		ArrayList<PurchaseOrderLine> purchaseOrderLineList;
		ArrayList<Integer[]> yearArray = new ArrayList<Integer[]>();
		
		//get purchase orders including specified item
		ArrayList<PurchaseOrder> purchaseOrderList = purchaseOrderLoader.getPurchaseOrderListByItem(itemID);
		
		//purchase orders are in ascending order so will always start with earliest date first
		for(int i = 0; i < purchaseOrderList.size(); i++)
		{
			//get purchase order date by Year
			calendar.setTime(purchaseOrderList.get(i).getDatePlaced());
			int newYear = calendar.get(calendar.YEAR);
			
			purchaseOrderLineList = purchaseOrderLineLoader.getPurchaseOrderLineByOrderAndProduct(purchaseOrderList.get(i).getIDPurchaseOrder(), itemID);
			
			//if same year
			if(oldYear == newYear)
			{
				Total = Total + purchaseOrderLineList.get(0).getQuantity();
			}
			else
			{
				Total = purchaseOrderLineList.get(0).getQuantity();
				oldYear = newYear;
			}
			
			//add to array
			yearArray.add(new Integer[]{newYear, Total});
			
			//dataset.addValue(total, "Year", year);
			
			//if new year is not the same as old year then it means its moved over into a new year
			
		}
		
		//add array to dataset
		for(int i = 0; i < yearArray.size(); i++)
		{
			dataset.addValue(yearArray.get(i)[1], "Year", yearArray.get(i)[0]);
		}
		
		/*ArrayList<Integer[]> yearArray = graphData.getYearArray();
		
		for(int i = 0; i < yearArray.size(); i++)
		{
			dataset.addValue(yearArray.get(i)[1], "Year", yearArray.get(i)[0]);
		}*/
		
		JFreeChart lineChart = ChartFactory.createLineChart(
				 "Sales",						 //Chart title
		         "Year",					     //X Label
		         "Number of Items sold",		 //Y Label
		         dataset,						 //Data
		         PlotOrientation.VERTICAL,
		         false,							 //Include Legend
		         true,false);
		
		CategoryAxis axis = lineChart.getCategoryPlot().getDomainAxis();
	    axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

	    chartPanelYears = new ChartPanel(lineChart);
	    chartPanelYears.setPreferredSize(new Dimension(600, 400));
	    graphPanel.add(chartPanelYears);
	}
	
	/**
	 * Method to update the graph with filters when the Update button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(buttonUpdate))
		{
			if(comboDuration.getSelectedItem().equals("Days"))
			{
				if(graphPanel.getComponentCount() > 0)
				{
					graphPanel.removeAll();
				}
				
				drawChartDays();
				
				repaint();
				revalidate();
			}
			
			if(comboDuration.getSelectedItem().equals("Years"))
			{
				if(graphPanel.getComponentCount() > 0)
				{
					graphPanel.removeAll();
				}
				
				drawChartYears();
				
				repaint();
				revalidate();
			}
		}
	}
	
//	public static void main(String[] args)
//	{
//		JFrame j = new JFrame();
//		int i = 1;
//		SalesGraphGUI sg = new SalesGraphGUI(i);
//		
//		j.setVisible(true);
//		j.add(sg);
//		j.setSize(650, 450);
//		j.setLocationRelativeTo(null);
//	}

}


