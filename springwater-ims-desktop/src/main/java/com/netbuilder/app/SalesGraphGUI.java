/**
 * @author Tom Stacey, Freshwater
 * @date 16/10/2015
 */

package com.netbuilder.app;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
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
public class SalesGraphGUI extends JPanel
{
	private DefaultCategoryDataset dataset;
	private GraphData graphData;
	private ArrayList<Object[]> dataList;

	public SalesGraphGUI() 
	{
		makeDataset();
		drawChart();
		repaint();
		revalidate();
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
	
	private void drawChart() 
	{
	      JFreeChart lineChart = ChartFactory.createLineChart(
	         "Sales",						 //Chart title
	         "Week",					     //X Label
	         "Number of Items sold",		 //Y Label
	         dataset,						 //Data
	         PlotOrientation.VERTICAL,
	         true,							 //Include Legend
	         true,false);
	      
	      
	      CategoryAxis axis = lineChart.getCategoryPlot().getDomainAxis();
	      axis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);

	      ChartPanel chartPanel = new ChartPanel(lineChart);
	      chartPanel.setPreferredSize(new Dimension(600, 400));
	      this.add(chartPanel);
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


