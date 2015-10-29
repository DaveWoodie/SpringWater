/**
 * @author abutcher
 * @date 16/10/2015
 */

package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.netbuilder.logic.SupplierLogic;

import entities.Address;

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
	private boolean edit =false;
	private SupplierLogic sL = new SupplierLogic();
	private int selectedID, addressID ;

//	public static void main(String[] args) {
//		AddSupplierFrame a = new AddSupplierFrame(12);
//		a.setVisible(true);
//	}
	
	/**
	 * constructor for adding a new supplier
	 */
	public AddSupplierFrame() {
		configFrame();
		addContent();
	}

	/**
	 * constructor for editing a supplier
	 * @param id - id of of supplier to edit
	 */
	public AddSupplierFrame(int id) {
		edit = !edit; 
		configFrame();
		addContent();
		setValues(id);
		selectedID = id;
	}
	
	/**
	 * configures the frame
	 */	
	private void configFrame() {
		@SuppressWarnings("unused")
		String titleS = "Add New Supplier";
		if (edit) {
			titleS = "Edit Supplier";
		}
		setTitle(titleS);
		setSize(500, 210);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	/**
	 * creates the main panel of the frame
	 */
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
		
		if (!edit) {
			addAddressPanel();
		}
		
		
		// Button Bar Panel
		buttonBar = new JPanel();
		buttonBar.setLayout(new GridLayout(1, 3));
		String buttonS = "Add";
		if (edit) {
			buttonS = "Save changes";
		}
		addSB = new JButton(buttonS);
//		addSWPB = new JButton("Add (With Products)");
		cancelB = new JButton("Cancel");

		buttonBar.add(addSB);
//		buttonBar.add(addSWPB);
		buttonBar.add(cancelB);

		//ActionListeners	
		addSB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				if(isFilledOut()) {
					if (edit) {
						sL.updateSupplier(getResults(), selectedID, addressID);
						JFrame frame = new JFrame("Add new supplier");
						JOptionPane.showMessageDialog(frame, "Supplier has been added", "Warning",
								JOptionPane.WARNING_MESSAGE);
						dispose();
					}else {
						sL.addNewSupplier(getResults());
						JFrame frame = new JFrame("Add new supplier");
						JOptionPane.showMessageDialog(frame, "Supplier has been added", "Warning",
								JOptionPane.WARNING_MESSAGE);
						dispose();
					}			
				}			
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
	
	/**
	 * creates the address panel
	 */
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

		addressTL = new JLabel("Address Town / City:");
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
	 * Method that is called when editing a supplier
	 * @param cont the content of the next address line
	 */
	private void addAddressPanel(String cont)
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
		addressLines.get(noOfAL-1).setText(cont);
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

		addressTL = new JLabel("Address Town / City:");
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
	 * Method to set the values of the form to relate to the given id
	 * @param id - the id of the supplier to edit
	 */
	private void setValues(int id) {
		Object[][] supplier = sL.fetchSupplierByID(id);
		nameT.setText((String)supplier[0][1]);
		tPhoneT.setText((String)supplier[0][2]);
		eMialT.setText((String)supplier[0][3]);
		Address a = sL.getAddressAsAddress((int)supplier[0][4]);
		addressID = a.getAddressID();
		for (String s : a.getAddressLines()) {
			addAddressPanel(s);
		}
		addressCT.setText(a.getCounty());
		addressPCT.setText(a.getPostCode());
		addressTT.setText(a.getCity());
		noOfAL = a.getAddressLines().size();
		
	}
	
	/**
	 * Validates and checks the form is filled out correctly
	 * @return true if the form is correct
	 */
	private boolean isFilledOut() {
		boolean ready = true;
		
		if (nameT.getText().isEmpty()) {
			ready = false;
			JFrame frame = new JFrame("Add new supplier");
			JOptionPane.showMessageDialog(frame, "A supplier name must be entered!!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
		//Check if at least one contact detail has been entered
		if(eMialT.getText().isEmpty() && tPhoneT.getText().isEmpty() ) {
			ready = false;
			JFrame frame = new JFrame("Add new supplier");
			JOptionPane.showMessageDialog(frame, "A supplier contact e-mail or phone number must be entered!!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
			
		if(!tPhoneT.getText().isEmpty()) {
			String pn = tPhoneT.getText();
			String regex = "^(0[12357])[0-9]{9}$";
			Pattern pattern = Pattern.compile(regex);
			 Matcher matcher = pattern.matcher(pn);
			    if (!matcher.matches()) {
					ready = false;
					JFrame frame = new JFrame("Add new supplier");
					JOptionPane.showMessageDialog(frame, "The phone number entered is not valid!!", "Error",
							JOptionPane.ERROR_MESSAGE);
			    }
	}
		
		if(!eMialT.getText().isEmpty()) {
			   try {
				      InternetAddress emailAddr = new InternetAddress(eMialT.getText());
				      emailAddr.validate();
				   } catch (AddressException ex) {
				      ready = false;
						JFrame frame = new JFrame("Add new supplier");
						JOptionPane.showMessageDialog(frame, "The e-mail address entered is not valid!!", "Error",
								JOptionPane.ERROR_MESSAGE);
				   }
		}
		
		if (addressTT.getText().isEmpty()) {
			ready = false;
			JFrame frame = new JFrame("Add new supplier");
			JOptionPane.showMessageDialog(frame, "A supplier town / city must be entered!!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		
		if (addressPCT.getText().isEmpty()) {
			ready = false;
			JFrame frame = new JFrame("Add new supplier");
			JOptionPane.showMessageDialog(frame, "A supplier post code must be entered!!", "Error",
					JOptionPane.ERROR_MESSAGE);
		}else {
			String pc = addressPCT.getText();
			String regex = "^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$";
			Pattern pattern = Pattern.compile(regex);
			
			 Matcher matcher = pattern.matcher(pc);
			    if (!matcher.matches()) {
					ready = false;
					JFrame frame = new JFrame("Add new supplier");
					JOptionPane.showMessageDialog(frame, "The post code entered is not valid!!", "Error",
							JOptionPane.ERROR_MESSAGE);
			    }
		}
		
		return ready;
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
		input.add(nameT.getText());			//0
		input.add(tPhoneT.getText());		//1
		input.add(eMialT.getText());		//2
		input.add(addressTT.getText());		//3
		input.add(addressCT.getText());		//4
		input.add(addressPCT.getText());	//5
		
		for (JTextField al :addressLines) {
			input.add(al.getText());
//			System.out.println(al.getText());
		}
		
		String[] array = new String[input.size()];
		array =  input.toArray(array);
		return array;
	}
}
