package com.netbuilder.app;

import javax.swing.JFrame;

public class RunGUI extends JFrame
{	
	public RunGUI()
	{
		//setLocationRelativeTo(null);
		setLocation(350, 250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ItemGUI i = new ItemGUI();
		add(i.getPanel());
		
		setSize(600, 800);
	}
}
