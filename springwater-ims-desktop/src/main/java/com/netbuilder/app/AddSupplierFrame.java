/**
 * @author abutcher
 * @date 16/10/2015
 */

package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class AddSupplierFrame extends JFrame {
	private JPanel base, main, buttonBar;
	private JLabel nameL, tPhoneL, eMailL, addressTL, addressCL, addressPCL;
	private JTextField nameT, tPhoneT, eMialT, addressTT, addressCT, addressPCT;
	private JButton addSB, addSWPB, cancelB, addAddressLine;
	private ArrayList<JTextField> addressLines = new ArrayList<JTextField>();
	private ArrayList<JLabel> addressLineLabels = new ArrayList<JLabel>();
	private GridBagConstraints c = new GridBagConstraints();
	private int noOfAL = 0;

	public static void main(String[] args) {
		AddSupplierFrame a = new AddSupplierFrame();
		a.setVisible(true);
	}
	
	public AddSupplierFrame() {
		// System.out.print("Here");
		initUI();
	}

	private void initUI() {
		configFrame();
		addContent();
	}

	private void configFrame() {
		setTitle("Add New Supplier");
//		setSize(600,800);
		setSize(500, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	private void addContent() {
		base = new JPanel(new BorderLayout());
		add(base);
		main = new JPanel(new GridBagLayout());
		
		boolean shouldFill = true;
		
		if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.HORIZONTAL;
}
		
		//Labels
		nameL = new JLabel("Name:");
//		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		main.add(nameL, c);
			
		tPhoneL = new JLabel("Contact Phone Number:");
//		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		main.add(tPhoneL, c);
		
		eMailL = new JLabel("Contact e-mail:");
//		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 2;
		main.add(eMailL, c);
		
		//Inputs
		nameT = new JTextField();
		nameT.setColumns(30);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		main.add(nameT, c);
		
		tPhoneT = new JTextField();
		tPhoneT.setColumns(30);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		main.add(tPhoneT, c);
		
		eMialT = new JTextField();
		eMialT.setColumns(30);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		main.add(eMialT, c);
			
	addAddress();
		
		// Button Bar Panel
		buttonBar = new JPanel();
		buttonBar.setLayout(new GridLayout(1, 3));
		addSB = new JButton("Add");
		addSWPB = new JButton("Add (With Products)");
		cancelB = new JButton("Cancel");

		buttonBar.add(addSB);
		buttonBar.add(addSWPB);
		buttonBar.add(cancelB);

		//ActionListeners
		addAddressLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				addAddress();
			}
		});
		
		addSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
			}
		});
		
		addSWPB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				
			}
		});
		
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		base.add(main, BorderLayout.CENTER);
		base.add(buttonBar, BorderLayout.SOUTH);
	}
	
	private void addAddress()
	{	
		noOfAL++;
		
		if(noOfAL !=1)
		{
			base.removeAll();
//			base.remove(addAddressLine);
//			base.remove(addressTL);
//			base.remove(addressTT);
//			base.remove(addressCL);
//			base.remove(addressCT);
//			base.remove(addressPCL);
//			base.remove(addressPCT);
		}
		
		main.invalidate();
		main.repaint();
		main.revalidate();
		base.updateUI();
		
		
		
		
//		addressLineLabels.add(new JLabel("Address Line " +noOfAL + ":"));
//		c.gridx = 0;
//		c.gridy = noOfAL +2;
//		main.add(addressLineLabels.get(noOfAL -1), c);
//		
//		addressLines.add(new JTextField());
//		addressLines.get(noOfAL -1).setColumns(30);
//		c.gridx = 1;
//		c.gridy = noOfAL +2;
//		main.add(addressLines.get(noOfAL -1), c);
		
		addAddressLine = new JButton("+");    
		c.weightx = 0.0;
		c.gridwidth = 2;
		c.gridx = 1;
		c.gridy = noOfAL+3;
		main.add(addAddressLine, c);
		
//		addressTL = new JLabel("Address Town:");
////		c.weightx = 0.5;
//		c.gridx = 0;
//		c.gridy = noOfAL+4;
//		main.add(addressTL, c);
//		
//		addressCL = new JLabel("Address County:");
////		c.weightx = 0.5;
//		c.gridx = 0;
//		c.gridy = noOfAL+5;
//		main.add(addressCL, c);
//		
//		addressPCL = new JLabel("Address Post Code:");
////		c.weightx = 0.5;
//		c.gridx = 0;
//		c.gridy = noOfAL+6;
//		main.add(addressPCL, c); 
//		
//		addressTT = new JTextField();
//		addressTT.setColumns(30);
//		c.weightx = 0.5;
//		c.gridx = 1;
//		c.gridy = noOfAL+4;
//		main.add(addressTT, c);
//		
//		addressCT = new JTextField();
//		addressCT.setColumns(30);
//		c.weightx = 0.5;
//		c.gridx = 1;
//		c.gridy = noOfAL+5;
//		main.add(addressCT, c);
//		
//		addressPCT = new JTextField();
//		addressPCT.setColumns(30);
//		c.weightx = 0.5;
//		c.gridx = 1;
//		c.gridy = noOfAL+6;
//		main.add(addressPCT, c);
//		
		repaint();
		revalidate();
		
		System.out.println("here add");
	}
	
}
