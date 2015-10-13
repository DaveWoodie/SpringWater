package com.netbuilder.app;

import java.awt.BorderLayout;
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

/**
 *Creates a JFrame containing a selected item's details
 */
@SuppressWarnings("serial")
public class ItemGUI extends JFrame
{	
	private BufferedImage productImage;
	private JTabbedPane tabbedPane;
	private DefaultTableModel tableModel =  new DefaultTableModel();
	
	public ItemGUI()
	{
		initGUI();
		createUI();
	}
	
	/**
	 * Initializes GUI configuration and methods before creation of UI
	 */
	public void initGUI()
	{
		//configure JFrame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		setUpTableModel();
		getProductImage("logoPlaceholder.png");
	}
	
	/**
	 * Method that creates the front end to view an individual item
	 */
	public void createUI()
	{
		//Tab pane
		tabbedPane = new JTabbedPane();
		add(tabbedPane);
		
		viewItemPanel();
		predictedSalesPanel();
		
		//configure size
		setSize(new Dimension(600, 600));
		setMinimumSize(new Dimension(600, 600));
		setPreferredSize(new Dimension(600, 800));
		setLocationRelativeTo(null);
	}
	
	/**
	 * Creates the view item panel
	 */
	public void viewItemPanel()
	{
		//Item panel
		JPanel panelItem = new JPanel(new GridLayout(2, 0));
		tabbedPane.add("View Item", panelItem);
		
		//Item info
		JPanel panelInfo = new JPanel(new GridLayout(0, 3));
		panelInfo.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Item name
		JPanel panelName = new JPanel();
		panelName.setLayout(new GridLayout(7, 0));
		panelName.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//ID
		JPanel panelID = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//panelID.setBorder(BorderFactory.createLineBorder(Color.gray));
		JLabel labelID = new JLabel("ID : ");
		JTextField textID = new JTextField(4);
		panelID.add(labelID);
		panelID.add(textID);
		
		//Name
		JPanel panelItemName = new JPanel(new FlowLayout(FlowLayout.LEFT));
		//panelItemName.setBorder(BorderFactory.createLineBorder(Color.gray));
		JLabel labelName = new JLabel("Item : ");
		JTextField textName = new JTextField(10);
		panelItemName.add(labelName);
		panelItemName.add(textName);
		
		//Price
		JPanel panelPrice = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel labelPrice = new JLabel("Price : ");
		JTextField textPrice = new JTextField(10);
		panelPrice.add(labelPrice);
		panelPrice.add(textPrice);
		
			//add components to item name panel
			panelName.add(panelID);
			panelName.add(panelItemName);
			panelName.add(panelPrice);
		
		//Item Stock
		JPanel panelOptions = new JPanel();
		panelOptions.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Item Image
		JPanel panelImage = new JPanel(new BorderLayout());
		panelImage.setBorder(BorderFactory.createLineBorder(Color.gray));
		JLabel Image = new JLabel(new ImageIcon(productImage));
		panelImage.add(Image);
		
			//add components to top panel
			panelInfo.add(panelName);
			panelInfo.add(panelOptions);
			panelInfo.add(panelImage);
		
		
		//Item Table
		JPanel panelTable = new JPanel(new BorderLayout());
		panelTable.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		JTable tableItem = new JTable(tableModel);
		tableItem.setFillsViewportHeight(true);
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setMinimumSize(new Dimension(getWidth(), getHeight()));
		scrollTable.setViewportView(tableItem);
		
			//add components to scroll pane
			panelTable.add(scrollTable);
		
		//adding components to item panel
		panelItem.add(panelInfo);
		panelItem.add(panelTable);
	}
	
	/**
	 * Creates the predicted sales panel
	 */
	public void predictedSalesPanel()
	{
		//Predicted Sales Panel
		JPanel panelPredictedSales = new JPanel();
		tabbedPane.add("Predicted Sales", panelPredictedSales);
	}
	
	public void setUpTableModel()
	{
		tableModel.addColumn("Delivery ID");
		tableModel.addColumn("Date");
		tableModel.addColumn("Stock In");
		tableModel.addColumn("Amount Damaged");
	}
	
	/**
	 * Method that loads an image from the resources folder by passing the image files name
	 * @param imageFileName
	 */
	public void getProductImage(String imageFileName)
	{
		//Get Product Image
		try 
		{
			productImage = ImageIO.read(new File("src/test/resources/" + imageFileName));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
