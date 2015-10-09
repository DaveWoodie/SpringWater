package com.netbuilder.app;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JPanel panelLogo, panelBackground;
	private JLabel labelUsername, labelPassword;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JButton buttonLogin;
	
	private Color blue = new Color(37, 172, 227);
	
	private static JFrame j;
	
	public LoginFrame()
	{
		initUI();
		createUI();
		
	}
	
	public void initUI()
	{
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		
	}
	
	/**
	 * 
	 */
	public void createUI() 
	{
		panelLogo();
		
		//background panel
		panelBackground = new JPanel();
		panelBackground.setBackground(Color.white);
		
		//UserName panel
		JPanel panelUsername = new JPanel();
		panelUsername.setBackground(Color.white);
		labelUsername = new JLabel("Username : ");
		labelUsername.setForeground(blue);
		textUsername = new JTextField(15);
		panelUsername.add(labelUsername);
		panelUsername.add(textUsername);
		
		//Password panel
		JPanel panelPassword = new JPanel();
		panelPassword.setBackground(Color.white);
		labelPassword = new JLabel("Password : ");
		labelPassword.setForeground(blue);
		textPassword = new JPasswordField(15);
		panelPassword.add(labelPassword);
		panelPassword.add(textPassword);
		
		//Login button panel
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(Color.white);
		buttonLogin = new JButton("Login");
		panelLogin.add(buttonLogin);
		
		//add components to background panel
		panelBackground.add(panelLogo);
		panelBackground.add(panelUsername);
		panelBackground.add(panelPassword);
		panelBackground.add(panelLogin);
		
		//add background panel to login frame
		add(panelBackground);	
		
		//resize screen
		pack();
		setSize(300, 300);
	}
	
	public void panelLogo()
	{
		panelLogo = new JPanel();
		panelLogo.setSize(300, 300);
		panelLogo.setBackground(Color.white);
		
		try{
			BufferedImage Logo = ImageIO.read(new File("src/main/Resources/logoExample.png"));
			JLabel labelLogo = new JLabel(new ImageIcon(Logo));
			panelLogo.add(labelLogo);
		}
		catch(IOException ex){
			System.out.println(ex);
		}
	}
}
