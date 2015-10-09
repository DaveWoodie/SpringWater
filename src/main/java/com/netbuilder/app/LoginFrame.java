package com.netbuilder.app;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
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
		getContentPane().setSize(350, 300);
	}
	
	public void createUI() 
	{
		panelLogo();
		
		//background panel
		panelBackground = new JPanel();
		panelBackground.setLayout(null);
		panelBackground.setBackground(Color.white);
		
		//UserName panel
		JPanel panelUsername = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelUsername.setBorder(BorderFactory.createLineBorder(Color.black));
		panelUsername.setBounds(panelLogo.getBounds().x, panelLogo.getBounds().y + panelLogo.getHeight(), 200, 50);
		panelUsername.setBackground(Color.white);
		labelUsername = new JLabel("Username : ");
		textUsername = new JTextField(15);
		panelUsername.add(labelUsername);
		panelUsername.add(textUsername);
		
		//Password panel
		JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelPassword.setBorder(BorderFactory.createLineBorder(Color.black));
		panelPassword.setBounds(panelUsername.getBounds().x, panelUsername.getBounds().y + panelUsername.getHeight(), 200, 50);
		panelPassword.setBackground(Color.white);
		labelPassword = new JLabel("Password : ");
		textPassword = new JPasswordField(15);
		panelPassword.add(labelPassword);
		panelPassword.add(textPassword);
		
		//Login button panel
		JPanel panelLogin = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelLogin.setBorder(BorderFactory.createLineBorder(Color.black));
		panelLogin.setBounds(panelPassword.getBounds().x, panelPassword.getBounds().y + panelPassword.getHeight(), 200, 50);
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
		panelLogo = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelLogo.setBorder(BorderFactory.createLineBorder(Color.black));
		panelLogo.setBounds(10, 10, 110, 50);
		panelLogo.setSize(205, 110);
		panelLogo.setBackground(Color.white);
		
		try{
			BufferedImage Logo = ImageIO.read(new File("src/main/Resources/logoPlaceholder.png"));
			JLabel labelLogo = new JLabel(new ImageIcon(Logo));
			panelLogo.add(labelLogo);
		}
		catch(IOException ex){
			System.out.println(ex);
		}
	}
}
