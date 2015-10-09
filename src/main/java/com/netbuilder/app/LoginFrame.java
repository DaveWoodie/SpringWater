package com.netbuilder.app;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	private JLabel labelUsername, labelPassword;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JButton buttonLogin;
	
	private static JFrame j;
	
	public LoginFrame()
	{
		initUI();
		createUI();
	}
	
	public void initUI()
	{
		setLocationRelativeTo(null);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 100);
	}
	
	public void createUI()
	{
		labelUsername = new JLabel("Username : ");
		labelPassword = new JLabel("Password : ");
		
		textUsername = new JTextField(10);
		
		//add components to Login panel
		add(labelUsername);
		add(textUsername);
	}
	
}
