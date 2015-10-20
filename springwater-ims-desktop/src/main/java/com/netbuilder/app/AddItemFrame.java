package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddItemFrame extends JFrame {
	private JPanel base, main, buttonBar;
	private JLabel itemNameL, itemDescriptionL, itemPriceL, itemUnitPriceL,
			porousewareL, supplierL;
	private JTextField itemNameR, itemPriceR, itemUnitPriceR;
	private JTextArea itemDescriptionR;
	private JComboBox supplierR;
	private JButton addIB, cancelB;
	private GridBagConstraints c = new GridBagConstraints();

	public static void main(String[] args) {
		AddItemFrame iF = new AddItemFrame();
		iF.setVisible(true);

	}

	public AddItemFrame() {
		// System.out.print("Here");
		initUI();
	}

	private void initUI() {
		configFrame();
		addContent();
	}

	private void configFrame() {
		setTitle("Add New Supplier");
		// setSize(600,800);
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
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		itemNameL = new JLabel("Name:");
		c.gridx = 0;
		c.gridy = 0;
		main.add(itemNameL, c);
			
		itemDescriptionL = new JLabel("Description:");
		c.gridx = 0;
		c.gridy = 1;
		main.add(itemDescriptionL, c);
		
		itemPriceL = new JLabel("Sale Price:");
		c.gridx = 0;
		c.gridy = 2;
		main.add(itemPriceL, c);
		
		itemUnitPriceL = new JLabel("Unit Cost:");
		c.gridx = 0;
		c.gridy = 3;
		main.add(itemUnitPriceL, c);
		
		porousewareL = new JLabel("PorouseWare:");
		c.gridx = 0;
		c.gridy = 4;
		main.add(porousewareL, c);
		
		supplierL = new JLabel("Supplier:");
		c.gridx = 0;
		c.gridy = 5;
		main.add(supplierL, c);
		
		
		
		//Inputs
		itemNameR = new JTextField();
		itemNameR.setColumns(30);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		main.add(itemNameR, c);
		
		itemPriceR = new JTextField();
		itemPriceR.setColumns(30);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 2;
		main.add(itemPriceR, c);
		
		itemUnitPriceR = new JTextField();
		itemUnitPriceR.setColumns(30);
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 3;
		main.add(itemUnitPriceR, c);
		
		
		
		supplierR = new JComboBox();
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 5;
		main.add(supplierR, c);
		
		// Button Bar Panel
				buttonBar = new JPanel();
				buttonBar.setLayout(new GridLayout(1, 3));
				addIB = new JButton("Add");
				cancelB = new JButton("Cancel");

				buttonBar.add(addIB);
				buttonBar.add(cancelB);

				//ActionListeners

				
				cancelB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				base.add(main, BorderLayout.CENTER);
				base.add(buttonBar, BorderLayout.SOUTH);
	}
}
