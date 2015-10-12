package com.netbuilder.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class ItemGUI extends JPanel
{	
	private BufferedImage productImage;
	
	public ItemGUI()
	{
		initGUI();
		createUI();
	}
	
	public void initGUI()
	{
		setSize(new Dimension(600, 800));
		setPreferredSize(new Dimension(600, 800));
		setLayout(new GridLayout(2, 0));
		
		try 
		{
			productImage = ImageIO.read(new File("src/test/resources/logoPlaceholder.png"));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void createUI()
	{
		//main Panel
		JPanel panelItem = new JPanel(new GridLayout(0, 2));
		panelItem.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Product name panel - top left
		JPanel panelName = new JPanel();
		panelName.setMaximumSize(new Dimension(999, 200));
		panelName.setBorder(BorderFactory.createLineBorder(Color.gray));
		JLabel labelName = new JLabel("Product Name : ");
		JTextField textName = new JTextField(15);
		textName.setBackground(Color.white);
		textName.setEditable(false);
		panelName.add(labelName);
		panelName.add(textName);
		panelItem.add(panelName);
		
		//Product image panel- top right
		JPanel panelImage = new JPanel();
		panelImage.setBorder(BorderFactory.createLineBorder(Color.gray));
		JLabel Image = new JLabel(new ImageIcon(productImage));
		panelImage.add(Image);
		panelItem.add(panelImage);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		
		//add panels to main panel
		add(panelItem);
		add(panel2);
		
	}
	
	public JPanel getPanel()
	{
		return this;
	}
}
