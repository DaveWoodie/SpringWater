package com.netbuilder.app;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CreatePurchaseOrder extends JPanel
{	
	public JPanel createUI()
	{
		
		
		
		return this;
	}
	

	public static void main(String[] args)
	{
		JFrame j = new JFrame();
		
		CreatePurchaseOrder cpo = new CreatePurchaseOrder();
		
		j.add(cpo.createUI());
		
		j.setSize(600, 800);
		j.setLocationRelativeTo(null);
		j.setVisible(true);
		
		System.out.println("Frame set up");
	}
}
