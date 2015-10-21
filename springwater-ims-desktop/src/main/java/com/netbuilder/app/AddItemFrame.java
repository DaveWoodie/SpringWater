/**
 * @author abutcher
 * @date 20/10/2015
 */

package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AddItemFrame extends JFrame {
	private JPanel base, main, buttonBar;
	private JLabel itemNameL, itemDescriptionL, itemPriceL, itemUnitPriceL,porousewareL, supplierL;
	private JTextField itemNameR, itemPriceR, itemUnitPriceR;
	private JTextArea itemDescriptionR;
	private JComboBox supplierR;
	private JRadioButton porouswareYesB, porouswareNoB;
	private JButton addIB, addAttributesB, cancelB;
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
		setTitle("Add New Item");
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
		porouswareYesB = new JRadioButton("Yes");
		porouswareYesB.setSelected(true);
		c.gridx = 1;
		c.gridy = 4;
		main.add(porouswareYesB, c);
		
		porouswareNoB = new JRadioButton("No");
		c.gridx = 2;
		c.gridy = 4;
		main.add(porouswareNoB, c);
		
		 ButtonGroup group = new ButtonGroup();
		 group.add(porouswareYesB);
		 group.add(porouswareNoB);
		
		itemNameR = new JTextField();
		itemNameR.setColumns(30);
		itemNameR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		main.add(itemNameR, c);
		
		itemDescriptionR = new JTextArea();
		itemDescriptionR.setColumns(30);
		itemDescriptionR.setRows(5);
		itemDescriptionR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy = 1;
		JScrollPane scroll = new JScrollPane (itemDescriptionR);
		main.add(scroll, c);
		
		itemPriceR = new JTextField();
		itemPriceR.setColumns(30);
		itemPriceR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.weightx = 0.5;
		c.gridy = 2;
		main.add(itemPriceR, c);
		
		itemUnitPriceR = new JTextField();
		itemUnitPriceR.setColumns(30);
		itemUnitPriceR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy = 3;
		main.add(itemUnitPriceR, c);
				
		supplierR = new JComboBox();
		supplierR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy = 5;		
		main.add(supplierR, c);
		
		addAttributesB = new JButton("Add Attributes");
		c.gridy = 6;		
		main.add(addAttributesB, c);
		
		// Button Bar Panel
		buttonBar = new JPanel();
		buttonBar.setLayout(new GridLayout(1, 3));
		addIB = new JButton("Add");
		cancelB = new JButton("Cancel");

		buttonBar.add(addIB);
		buttonBar.add(cancelB);

		//ActionListeners
		addIB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO get inputs and add item
				
			}
		});
		
		addAttributesB.addActionListener(new ActionListener() {
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
}
