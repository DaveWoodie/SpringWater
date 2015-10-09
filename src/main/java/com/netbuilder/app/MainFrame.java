package com.netbuilder.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	JPanel base = new JPanel();
	
	public MainFrame() {
		initUI();
	}
	
	public void initUI() {
		
		base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
		
		//test labels for panel generation
		final JLabel test = new JLabel("TEST");
		final JLabel test2 = new JLabel("TEST2");
		final JLabel test3 = new JLabel("TEST3");
		final JLabel test4 = new JLabel("TEST4");
		
		//create tabbed pane and tabs
		final JTabbedPane pane = new JTabbedPane();
		final JPanel panel1 = new JPanel();
		//test generating initial tab panel
		panel1.add(test2);
		pane.addTab("Daily Report", null, panel1, "Daily Report");
		final JPanel panel2 = new JPanel();
		pane.addTab("Inventory", null, panel2, "Inventory");
		final JPanel panel3 = new JPanel();
		pane.addTab("Purchase Orders", null, panel3, "Purchase Orders");
		final JPanel panel4 = new JPanel();
		pane.addTab("Suppliers", null, panel4, "Suppliers");
		
		//runs update when tab is changed
		pane.addChangeListener(new ChangeListener(){

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				int i = pane.getSelectedIndex();
				if (i == 0) {
					panel1.removeAll();
					panel1.add(test);
				}
				else if (i == 1) {
					panel2.removeAll();
					panel2.add(test2);
				}
				else if (i == 2) {
					panel3.removeAll();
					panel3.add(test3);
				}
				else if (i == 3) {
					panel4.removeAll();
					panel4.add(test4);
				}
			}
			
		});
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		
		JLabel loginDetails = new JLabel("<html>Employee ID: 1<br>Employee Name: Al Stock");
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Logout method to return to login screen
			}
			
		});
		
		JButton quit = new JButton("Quit");
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Quit out from java application
				
			}
			
		});
		
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(loginDetails);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(logout);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		bottom.add(quit);
		bottom.add(Box.createRigidArea(new Dimension(10,0)));
		
		base.add(pane);
		base.add(bottom);
		add(base);
		
		setTitle("Inventory Management System");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 800));
	}
}
