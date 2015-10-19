/**
 * @author abutcher
 * @date 16/10/2015
 */

package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

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
	private JPanel base, main, left, right, buttonBar;
	private JLabel nameL, tPhoneL, eMailL, addressL;
	private JTextField nameT, tPhoneT, eMialT;
	private JButton addSB, addSWPB, cancelB; 
	
	public AddSupplierFrame(){
	//	System.out.print("Here");
		initUI();
	}
	
	private void initUI(){
		configFrame();
		addContent();
	}
	
	private void configFrame(){
		setTitle("Add New Supplier");
		setSize(500, 140);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }
	
	private void addContent() {
		base = new JPanel(new BorderLayout());
		add(base);
//		main = new JPanel(new GridLayout(1,2));
		main = new JPanel();
		main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));

		
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
		nameT = new JTextField();
		nameT.setColumns(30);
		tPhoneT = new JTextField();
		tPhoneT.setColumns(30);
		eMialT = new JTextField();
		eMialT.setColumns(30);
		right.add(nameT);
		right.add(tPhoneT);
		right.add(eMialT);
		
		main.add(left);
		main.add(right);
		
		//Button Bar Panel
		buttonBar = new JPanel();
		buttonBar.setLayout(new GridLayout(1, 3));
		addSB = new JButton("Add");
		addSWPB = new JButton("Add (With Products)");
		cancelB = new JButton("Cancel");
		
		buttonBar.add(addSB);
		buttonBar.add(addSWPB);
		buttonBar.add(cancelB);
		
		base.add(main, BorderLayout.CENTER);
		base.add(buttonBar, BorderLayout.SOUTH);
	}
}
