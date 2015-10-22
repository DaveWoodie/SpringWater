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
import java.util.ArrayList;

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
	private JPanel base, main, buttonBar, attributesP;
	private JLabel itemNameL, itemDescriptionL, itemPriceL, itemUnitPriceL,porousewareL, supplierL, typeL, column1L,column2L;
	private JTextField itemNameR, itemPriceR, itemUnitPriceR;
	private JTextArea itemDescriptionR;
	private JComboBox supplierR, typeR;
	private JRadioButton porouswareYesB, porouswareNoB;
	private JButton addIB, addAttributesB, cancelB;
	private ArrayList<JTextField> attributesNames = new ArrayList<JTextField>();
	private ArrayList<JTextField> attributesDes = new ArrayList<JTextField>();
	private ArrayList<JLabel> attributesLabels = new ArrayList<JLabel>();
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagConstraints attriC;
	private int noOfA =0;

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
		setSize(500, 320);
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
		c.gridy = 1;
		main.add(itemDescriptionL, c);
		
		itemPriceL = new JLabel("Sale Price:");
		c.gridy = 2;
		main.add(itemPriceL, c);
		
		itemUnitPriceL = new JLabel("Unit Cost:");
		c.gridy = 3;
		main.add(itemUnitPriceL, c);
		
		porousewareL = new JLabel("PorouseWare:");
		c.gridy = 4;
		main.add(porousewareL, c);
		
		typeL = new JLabel("Catergory;");
		c.gridy = 5;
		main.add(typeL, c);
		
		supplierL = new JLabel("Supplier:");
		c.gridy = 6;
		main.add(supplierL, c);
		
		attributesP = new JPanel(new GridBagLayout());
		c.gridy =7;
		c.gridwidth=3;
		main.add(attributesP, c);
		
		column1L = new JLabel("Name");
		column1L.setBorder(BorderFactory.createLineBorder(Color.black));
		column2L = new JLabel("Description");
		column2L.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//Inputs
		porouswareYesB = new JRadioButton("Yes");
		porouswareYesB.setSelected(true);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth= 1;
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
		
		typeR = new JComboBox();
		//TODO get category list and add to combo box
		typeR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy =5;
		main.add(typeR, c);
		
		supplierR = new JComboBox();
		//TODO get supplier list and add to combo box
		supplierR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy = 6;		
		main.add(supplierR, c); 
		
		// Button Bar Panel
		buttonBar = new JPanel();
		buttonBar.setLayout(new GridLayout(1, 3));
		addIB = new JButton("Add");
		cancelB = new JButton("Cancel");

		addAttributePnael();
		
		buttonBar.add(addIB);
		buttonBar.add(cancelB);

		//ActionListeners
		addIB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO add item
				getResults();
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
	
	private void addAttributePnael() {
		attriC = new GridBagConstraints();
		attriC.fill = GridBagConstraints.HORIZONTAL;
		noOfA++;
		
		setSize(getSize().width, getSize().height+20);
		
		if(noOfA !=1) {
			attributesP.removeAll();
			attributesP.revalidate();
		}
		
		attriC.gridx = 1;
		attriC.gridy = 0;
		attributesP.add(column1L, attriC);
		
		attriC.gridx = 2;
		attributesP.add(column2L, attriC);
		
		attributesLabels.add(new JLabel("Attribute " + noOfA + ":"));
		attributesNames.add(new JTextField());
		attributesNames.get(noOfA-1).setColumns(15);
		attributesNames.get(noOfA-1).setBorder(BorderFactory.createLineBorder(Color.black));
		attributesDes.add(new JTextField());
		attributesDes.get(noOfA-1).setColumns(15);
		attributesDes.get(noOfA-1).setBorder(BorderFactory.createLineBorder(Color.black));	
		
		for (int i = 0; i < noOfA; i++){		
			attriC.gridx = 0;
			attriC.gridy = i +2;
			attributesP.add(attributesLabels.get(i), attriC);
							
			attriC.gridx = 1;
			attriC.gridy = i +2;
			attributesP.add(attributesNames.get(i), attriC);
			
			attriC.gridx = 2;
			attriC.gridy = i +2;
			attributesP.add(attributesDes.get(i), attriC);
		}
		
		addAttributesB = new JButton("+");
		addAttributesB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAttributePnael();				
			}
		});
		
		attriC.gridx = 0;
		attriC.gridy = noOfA+4;
		attriC.gridwidth = 3;
		attributesP.add(addAttributesB, attriC);		
	}
	
	private Object[] getResults(){
		//TODO Validate inputs
		ArrayList<Object> input = new ArrayList<Object>();
		input.add(itemNameR.getText());
		input.add(itemDescriptionR.getText());
		input.add(itemPriceR.getText());
		input.add(itemUnitPriceR.getText());
		input.add(supplierR.getSelectedItem());
		input.add(typeR.getSelectedItem());	
		
		for (int i = 0; i<noOfA;i++)
		{
			input.add(attributesNames.get(i).getText());
			input.add(attributesDes.get(i).getText());
		}
		Object[] array = new Object[input.size()];
		array =  input.toArray(array);
		return array;
	}
}
