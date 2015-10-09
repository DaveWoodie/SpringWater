package com.netbuilder.app;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		JComponent panel1 = makeTextPanel("Panel #1");
		pane.addTab("Daily Report", null, panel1, "Daily Report");
		JComponent panel2 = makeTextPanel("Panel #2");
		pane.addTab("Inventory", null, panel2, "Inventory");
		JComponent panel3 = makeTextPanel("Panel #3");
		pane.addTab("Purchase Orders", null, panel3, "Purchase Orders");
		JComponent panel4 = makeTextPanel("Panel #4");
		pane.addTab("Suppliers", null, panel4, "Suppliers");
		
		JPanel bottom = new JPanel();
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.X_AXIS));
		
		JLabel loginDetails = new JLabel();
		
		JButton logout = new JButton();
		logout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Logout method to return to login screen
			}
			
		});
		
		JButton quit = new JButton();
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Quit out from java application
				
			}
			
		});
		
		bottom.add(loginDetails);
		bottom.add(logout);
		bottom.add(quit);
		
		base.add(pane);
		base.add(bottom);
		add(base);
		
		setTitle("Inventory Management System");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
	}
	
	//temporary test code
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

}
