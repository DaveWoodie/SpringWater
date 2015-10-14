package com.netbuilder.app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import org.jfree.data.category.DefaultCategoryDataset;


@SuppressWarnings("serial")
public class SalesGraphGUI extends JPanel
{
	
	private DefaultCategoryDataset dataset;

	public SalesGraphGUI() {
		makeDataset();
	}
	/*
	private void doDrawing(Graphics g)
	{
		g.setColor(Color.black);
		int[] x = {75, 75};
		int[] y = {75, 450};
		g.drawLine(75, 75, 75, 450);
		g.drawLine(500, 450, 75, 450);
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// doDrawing(g);
	}
	
	*/
	private void makeDataset() {
		dataset = new DefaultCategoryDataset();
		dataset.addValue(20.0, "sales","05/07/2015");
		dataset.addValue(23.0, "sales","12/07/2015");
		dataset.addValue(24.0, "sales","19/07/2015");
		dataset.addValue(19.0, "sales","26/07/2015");
		dataset.addValue(25.0, "sales","02/08/2015");
		dataset.addValue(24.0, "sales","09/08/2015");
		dataset.addValue(25.0, "sales","16/08/2015");
		dataset.addValue(27.0, "sales","23/08/2015");
		dataset.addValue(28.0, "sales","30/08/2015");
		dataset.addValue(35.0, "sales","06/09/2015");
		dataset.addValue(34.0, "sales","13/09/2015");
		dataset.addValue(36.0, "sales","20/09/2015");
		dataset.addValue(37.0, "sales","27/09/2015");
		dataset.addValue(39.0, "sales","04/10/2015");
		dataset.addValue(38.0, "sales","11/11/2015");
	}
	
}
