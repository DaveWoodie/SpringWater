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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import com.netbuilder.app.GraphData;

/**
 *Sales Graph Panel showing the specified products sales
 */
@SuppressWarnings("serial")
public class SalesGraphGUI extends JPanel implements ActionListener
{
	private DefaultCategoryDataset dataset;
	private GraphData graphData;
	private ArrayList<Object[]> dataList;
	private String[] dayArray, monthArray, yearArray, durationArray;
	private JButton buttonUpdate;
	private JComboBox<String> comboDuration;
	private ChartPanel chartPanelDays, chartPanelYears;
	private JPanel graphPanel;

	public SalesGraphGUI() 
	{
		makeDataset();
		setSalesArrays();
		createUI();
		//drawChartDays();
		repaint();
		revalidate();
	}
	
	public void createUI()
	{
		//Set panel layout
		setLayout(new BorderLayout());
				
		//Options
		JPanel panelOptions = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelOptions.setBorder(BorderFactory.createLineBorder(Color.gray));
		JLabel labelDate = new JLabel("Start Date : ");
		JLabel labelDuration = new JLabel("Duration : ");
		//combo boxes
		JComboBox<String> comboDay = new JComboBox<String>(dayArray);
		JComboBox<String> comboMonth = new JComboBox<String>(monthArray);
		JComboBox<String> comboYear = new JComboBox<String>(yearArray);
		comboDuration = new JComboBox<String>(durationArray);
		buttonUpdate = new JButton("Update");
		buttonUpdate.addActionListener(this);
				
			//add components to options panel
			/*panelOptions.add(labelDate);
			panelOptions.add(comboDay);
			panelOptions.add(comboMonth);
			panelOptions.add(comboYear);
			panelOptions.add(Box.createRigidArea(new Dimension(20, 0)));
			panelOptions.add(labelDuration);*/
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
		graphData = new GraphData();
		dataList = graphData.getDataArray();
		
		dataset = new DefaultCategoryDataset();
		
		for(int i = 0; i < dataList.size(); i++)
		{	
			dataset.addValue((double) dataList.get(i)[0], (Comparable<?>) dataList.get(i)[1], (Comparable<?>) dataList.get(i)[2]);
		}
	}
	
	public void setSalesArrays()
	{
		dayArray = new String[31];
		monthArray = new String[12];
		yearArray = new String[10];
				
		for(int i = 0; i < dayArray.length; i++)
		{
			dayArray[i] = Integer.toString(i + 1);
		}
		
		for(int i = 0; i < monthArray.length; i++)
		{
			monthArray[i] = Integer.toString(i + 1);
		}
		
		for(int i = 0; i < yearArray.length; i++)
		{
			yearArray[i] = Integer.toString(2015 - i);
		}
		
		durationArray = new String[]{"Days", "Weeks", "Months", "Years"};
	}
	
	private void drawChartDays() 
	{
		JFreeChart lineChart = ChartFactory.createLineChart(
	         "Sales",						 //Chart title
	         "Day",					         //X Label
	         "Number of Items sold",		 //Y Label
	         dataset,						 //Data
	         PlotOrientation.VERTICAL,
	         true,							 //Include Legend
	         true,false);
	      
	      
	    CategoryAxis axis = lineChart.getCategoryPlot().getDomainAxis();
	    axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

	    chartPanelDays = new ChartPanel(lineChart);
	    chartPanelDays.setPreferredSize(new Dimension(600, 400));
	    graphPanel.add(chartPanelDays);
	}
	
	private void drawChartYears()
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		ArrayList<Integer[]> yearArray = graphData.getYearArray();
		
		for(int i = 0; i < yearArray.size(); i++)
		{
			dataset.addValue(yearArray.get(i)[1], "Year", yearArray.get(i)[0]);
		}
		
		JFreeChart lineChart = ChartFactory.createLineChart(
				 "Sales",						 //Chart title
		         "Year",					     //X Label
		         "Number of Items sold",		 //Y Label
		         dataset,						 //Data
		         PlotOrientation.VERTICAL,
		         true,							 //Include Legend
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
	
	public static void main(String[] args)
	{
		JFrame j = new JFrame();
		SalesGraphGUI sg = new SalesGraphGUI();
		
		j.setVisible(true);
		j.add(sg);
		j.setSize(650, 450);
		j.setLocationRelativeTo(null);
	}

}


