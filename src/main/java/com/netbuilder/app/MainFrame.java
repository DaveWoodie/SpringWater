package com.netbuilder.app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	JPanel base = new JPanel();
	
	public MainFrame() {
		initUI();
	}
	
	public void initUI() {
		
		base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
		
		JTabbedPane pane = new JTabbedPane();
		
		pane.add(base);
		add(pane);
		
		setTitle("Inventory Management System");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	}
	
	
}
