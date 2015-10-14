package com.netbuilder.app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SalesGraph extends JPanel
{
	private void doDrawing(Graphics g)
	{
		g.setColor(Color.black);
		int[] x = {75, 75, 120};
		int[] y = {75, 450, 50};
		g.drawLine(x[0], y[0], x[1], y[1]);
		g.drawLine(500, 450, x[1], y[1]);
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		doDrawing(g);
	}
}
