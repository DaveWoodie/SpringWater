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
	private JPanel base, main, buttonBar, addressP;
	private JLabel nameL, tPhoneL, eMailL, addressTL, addressCL, addressPCL;
	private JTextField nameT, tPhoneT, eMialT, addressTT, addressCT, addressPCT;
	private JButton addSB, cancelB, addAddressLine;
	private ArrayList<JTextField> addressLines = new ArrayList<JTextField>();
	private ArrayList<JLabel> addressLineLabels = new ArrayList<JLabel>();
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagConstraints addressC;
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
		setSize(500, 210);
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
		c.gridx = 0;
		c.gridy = 0;
		main.add(nameL, c);
			
		tPhoneL = new JLabel("Contact Phone Number:");
		c.gridy = 1;
		main.add(tPhoneL, c);
		
		eMailL = new JLabel("Contact e-mail:");
		c.gridy = 2;
		main.add(eMailL, c);
		
		addressP = new JPanel(new GridBagLayout());
		c.gridy = 3;
		c.gridwidth =2;
		main.add(addressP, c);		
		
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
			
		addAddressPanel();
		
		// Button Bar Panel
		buttonBar = new JPanel();
		buttonBar.setLayout(new GridLayout(1, 3));
		addSB = new JButton("Add");
//		addSWPB = new JButton("Add (With Products)");
		cancelB = new JButton("Cancel");

		buttonBar.add(addSB);
//		buttonBar.add(addSWPB);
		buttonBar.add(cancelB);

		//ActionListeners	
		addSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				//TODO send to database
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
	
	private void addAddressPanel()
	{	
		addressC = new GridBagConstraints();
		addressC.fill = GridBagConstraints.HORIZONTAL;
		noOfAL++;
		
		setSize(getSize().width, getSize().height+20);
		
		if(noOfAL !=1)
		{
			addressP.removeAll();
			addressP.revalidate();
		}
		
		addressLineLabels.add(new JLabel("Address Line " + noOfAL + ":"));
		addressLines.add(new JTextField());
		addressLines.get(noOfAL-1).setColumns(30);
		
		addressPCL = new JLabel("Address Post Code:       ");
		addressC.gridy = noOfAL+6;
		addressP.add(addressPCL, addressC);
		
		for (int i = 0; i < noOfAL; i++){		
			addressC.gridx = 0;
			addressC.gridy = i +2;
			addressP.add(addressLineLabels.get(i), addressC);
							
			addressC.gridx = 1;
			addressC.gridy = i +2;
			addressP.add(addressLines.get(i), addressC);
		}
		
		addAddressLine = new JButton("+");  
		addAddressLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAddressPanel();
				
			}
		});
		
		addressC.gridwidth = 2;
		addressC.gridx = 0;
		addressC.gridy = noOfAL+3;
		addressP.add(addAddressLine, addressC);

		addressTL = new JLabel("Address Town:");
		addressC.gridy = noOfAL+4;
		addressP.add(addressTL, addressC);
		
		addressCL = new JLabel("Address County:");
		addressC.gridy = noOfAL+5;
		addressP.add(addressCL, addressC);
			
		addressTT = new JTextField();
		addressTT.setColumns(30);
		addressC.gridx = 1;
		addressC.gridy = noOfAL+4;
		addressP.add(addressTT, addressC);
		
		addressCT = new JTextField();
		addressCT.setColumns(30);
		addressC.weightx = 0.5;
		addressC.gridy = noOfAL+5;
		addressP.add(addressCT, addressC);
		
		addressPCT = new JTextField();
		addressPCT.setColumns(30);
		addressC.weightx = 0.5;
		addressC.gridy = noOfAL+6;
		addressP.add(addressPCT, addressC);
		
		addressP.repaint();
		addressP.revalidate();		
//		System.out.println("here add");
	}
	
	/**
	 * Method to collate the inputs from the GUI
	 * @return an array of strings from inputs
	 * @date 21/10/2015
	 */
	private String[] getResults()
	{
		//TODO Validate inputs
		ArrayList<String> input = new ArrayList<String>();
		input.add(nameT.getText());
		input.add(tPhoneT.getText());
		input.add(eMialT.getText());
		input.add(addressTT.getText());
		input.add(addressCT.getText());
		input.add(addressPCT.getText());
		for (JTextField al :addressLines)
		{
			input.add(al.getText());
//			System.out.println(al.getText());
		}
		String[] array = new String[input.size()];
		array =  input.toArray(array);
		return array;
	}
}
