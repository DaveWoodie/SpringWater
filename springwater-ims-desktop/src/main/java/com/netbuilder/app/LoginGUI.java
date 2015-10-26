/**
 * @author Freshwater
 * @date 12/10/2015
 */
package com.netbuilder.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.netbuilder.logic.LoginAuthentication;

/**
 * Create a login JFrame
 */
public class LoginGUI extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel panelLogo, panelBackground;
	private JLabel labelUsername, labelPassword;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JButton buttonLogin;
	private JButton examplebutton;
	private Color colour;
	
	private LoginAuthentication loginAuth = new LoginAuthentication();
	private IconLoader iconLoader = new IconLoader();
	
	private GUIStart src;
	
	public LoginGUI()
	{
		createUI();
	}

	public LoginGUI(GUIStart src)
	{
		this.src = src;
		createUI();
	}
	
	public void createUI() 
	{
		//background panel
		panelBackground = new JPanel(new BoxLayout(panelBackground, BoxLayout.Y_AXIS));
		panelBackground.setLayout(null);
		panelBackground.setPreferredSize(new Dimension(350, 300));
		panelBackground.setBorder(BorderFactory.createLineBorder(Color.gray));
		panelBackground.setBackground(Color.white);
		this.add(panelBackground);
		
		//Logo Panel
		panelLogo = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelLogo.setPreferredSize(new Dimension(210, 115));
		panelLogo.setBounds(getPreferredSize().width / 2 - panelLogo.getPreferredSize().width / 2, 10, panelLogo.getPreferredSize().width, panelLogo.getPreferredSize().height);
		panelLogo.setBackground(Color.white);
		
		try
		{
			BufferedImage Logo = ImageIO.read(new File("src/main/Resources/logo.png"));
			JLabel labelLogo = new JLabel(new ImageIcon(Logo));
			panelLogo.add(labelLogo);
		}
		catch(IOException ex)
		{
			System.out.println(ex);
		}
		
		//UserName panel
		JPanel panelUsername = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelUsername.setPreferredSize(new Dimension(250, 50));
		panelUsername.setBounds(getPreferredSize().width / 2 - panelUsername.getPreferredSize().width / 2, panelLogo.getBounds().y + panelLogo.getHeight(), panelUsername.getPreferredSize().width, panelUsername.getPreferredSize().height);
		panelUsername.setBackground(Color.white);
		labelUsername = new JLabel("Username : ");
		textUsername = new JTextField(21);
		panelUsername.add(labelUsername);
		panelUsername.add(textUsername);
		
		//Password panel
		JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelPassword.setPreferredSize(new Dimension(250, 50));
		panelPassword.setBounds(getPreferredSize().width / 2 - panelPassword.getPreferredSize().width / 2, panelUsername.getBounds().y + panelUsername.getHeight(), panelPassword.getPreferredSize().width, panelPassword.getPreferredSize().height);
		panelPassword.setBackground(Color.white);
		labelPassword = new JLabel("Password : ");
		textPassword = new JPasswordField(21);
		panelPassword.add(labelPassword);
		panelPassword.add(textPassword);
		
		//Login button panel
		JPanel panelLogin = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelLogin.setBounds(panelPassword.getBounds().x, panelPassword.getBounds().y + panelPassword.getHeight() + 10, 250, 50);
		panelLogin.setBackground(Color.white);
		buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(this);
		panelLogin.add(buttonLogin);
		
		//add components to container panel
		panelBackground.add(panelLogo);
		panelBackground.add(panelUsername);
		panelBackground.add(panelPassword);
		panelBackground.add(panelLogin);
		
		//add background panel to login frame
		add(panelBackground);	
	}
	
	/** 
	 * Method to get the Users ID
	 * 
	 * @return Returns the users ID
	 */
	public String getUserID()
	{
		return textUsername.getText();
	}

	/**
	 * Manages the event when the Login button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(buttonLogin)) 
		{
			if(loginAuth.checkLogin(textUsername.getText(), textPassword.getPassword()) == true)
			{
				src.revertToMain(textUsername.getText());
			}
			else
			{
				textUsername.setText("");
				textPassword.setText("");
			}
		}
	}
}
