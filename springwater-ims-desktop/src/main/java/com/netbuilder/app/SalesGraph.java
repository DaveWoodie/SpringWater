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
		int[] x = {75, 75};
		int[] y = {75, 450};
		g.drawLine(75, 75, 75, 450);
		g.drawLine(500, 450, 75, 450);
		
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		doDrawing(g);
	}
}
