package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AddSupplierFrame extends JFrame {
	private JPanel base, main, left, right, buttonBar;
	private JLabel nameL, tPhoneL, eMailL, addressL;
	private JTextArea nameT, tPhoneT, eMialT;
	
	public AddSupplierFrame(){
		System.out.print("Here");
		initUI();
	}
	
	private void initUI(){
		configFrame();
		addContent();
	}
	
	private void configFrame(){
		setTitle("Add New Supplier");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 800));
    }
	
	private void addContent() {
		base = new JPanel(new BorderLayout());
		add(base);
		main = new JPanel(new GridLayout(1,2));
		
		//Left Panel
		left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));	
		nameL = new JLabel("Name");
		tPhoneL = new JLabel("Contact Phone Number");
		eMailL = new JLabel("Contact e-mail");		
		left.add(nameL);
		left.add(tPhoneL);
		left.add(eMailL);
		
		//Right Panel
		right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		nameT = new JTextArea();
		tPhoneT = new JTextArea();
		eMialT = new JTextArea();
		right.add(nameT);
		right.add(tPhoneT);
		right.add(eMialT);
		
		main.add(left);
		main.add(right);
		
		base.add(main, BorderLayout.CENTER);
	}
}
