/**
 * @author Freshwater
 * @date 13/10/2015
 */
package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
	private int itemID = 1;
	private BufferedImage productImage;
	private JTabbedPane tabbedPane;
	private DefaultTableModel tableModel =  new DefaultTableModel();
	private String[] dayArray, monthArray, yearArray, durationArray;
	private LoadData Data = new LoadData();
	private Object[][] Inventory;
	private Object[][] PO;
	private JLabel textName, textPrice, textStock, Image;

	/**
	 * Constructor that creates an instance of an item GUI for the item ID that is passed
	 * @param itemID : 
	 */
	public ItemGUI(int itemID)
	{
		this.itemID = itemID;
		
		initGUI();
		createUI();
	}
	
	/**
	 * Constructor to create an instance of an item GUI that doesn't include ItemID
	 */
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		Inventory = Data.fetchInventoryList();
		PO = Data.fetchPurchaseOrders();
		setUpTableModel();
		setSalesArrays();
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
		itemSalesPanel();
		predictedSalesPanel();
		
		//configure size
		setSize(new Dimension(650, 600));
		setMinimumSize(new Dimension(650, 600));
		setPreferredSize(new Dimension(650, 600));
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Creates the view item panel
	 */
	public void viewItemPanel()
	{
		//Item panel
		JPanel panelMain = new JPanel(new GridLayout(2, 0));
		tabbedPane.add("View Item", panelMain);
		
		//Item info
		JPanel panelItem = new JPanel(new GridLayout(0, 2));
		panelItem.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Item split
		JPanel panelSplit = new JPanel(new GridLayout(10, 0));
		panelSplit.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.gray));
		
			//ID
			JPanel panelID = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelID = new JLabel("ID : ");
			JLabel textID = new JLabel(String.valueOf(itemID));
			panelID.add(labelID);
			panelID.add(textID);
			
			//Name
			JPanel panelMainName = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelName = new JLabel("Item : ");
			textName = new JLabel("");
			panelMainName.add(labelName);
			panelMainName.add(textName);
			
			//Price
			JPanel panelPrice = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelPrice = new JLabel("Price : ");
			textPrice = new JLabel("");
			panelPrice.add(labelPrice);
			panelPrice.add(textPrice);
			
			//Stock
			JPanel panelStock = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelStock = new JLabel("Stock Level : ");
			textStock = new JLabel("");
			panelStock.add(labelStock);
			panelStock.add(textStock);
			
				//add components to item name panel
				panelSplit.add(panelID);
				panelSplit.add(panelMainName);
				panelSplit.add(panelPrice);
				panelSplit.add(new JPanel());
				panelSplit.add(panelStock);
		
		
		//Item Image
		JPanel panelImage = new JPanel(new BorderLayout());
		getProductImage((String)Inventory[itemID - 1][4]);
		Image = new JLabel(new ImageIcon(productImage));
		panelImage.add(Image);
		
			//add components to top panel
			panelItem.add(panelSplit);
			panelItem.add(panelImage);
		
		
		//Item Table
		JPanel panelTable = new JPanel(new BorderLayout());
		
		JTable tableItem = new JTable(tableModel);
		tableItem.setFillsViewportHeight(true);
		JScrollPane scrollTable = new JScrollPane();
		scrollTable.setMinimumSize(new Dimension(getWidth(), getHeight()));
		scrollTable.setViewportView(tableItem);
		
		JButton buttonPO = new JButton("View Purchase Order");
		buttonPO.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				IndividualPurchaseOrderView ipo = new IndividualPurchaseOrderView(1, "Supplier", "12/07/2015", "Order Placed", "£100");
				ipo.setVisible(true);
			}
		});
		
			//add components to scroll pane
			panelTable.add(scrollTable, BorderLayout.CENTER);
			panelTable.add(buttonPO, BorderLayout.SOUTH);
		
		//adding components to item panel
		panelMain.add(panelItem);
		panelMain.add(panelTable);
		
		searchItemArray(itemID);
		
		tableModel.addRow(new Object[]{PO[1][0], PO[1][1], 35, 0});
		
	}
	
	/**
	 * Creates the previous sales panel  
	 */
	public void itemSalesPanel()
	{
		//previous sales panel
		JPanel panelSales = new JPanel(new BorderLayout());
		tabbedPane.add("Sales", panelSales);
		
		//graph panel
		JPanel panelGraph = new SalesGraph();
		panelGraph.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		//Options
		JPanel panelOptions = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelOptions.setBorder(BorderFactory.createLineBorder(Color.gray));
		JLabel labelDate = new JLabel("Start Date : ");
		JLabel labelDuration = new JLabel("Duration : ");
		JComboBox<String> comboDay = new JComboBox<String>(dayArray);
		JComboBox<String> comboMonth = new JComboBox<String>(monthArray);
		JComboBox<String> comboYear = new JComboBox<String>(yearArray);
		JComboBox<String> comboDuration = new JComboBox<String>(durationArray);
		JButton buttonUpdate = new JButton("Update");
		
			//add components to options panel
			panelOptions.add(labelDate);
			panelOptions.add(comboDay);
			panelOptions.add(comboMonth);
			panelOptions.add(comboYear);
			panelOptions.add(Box.createRigidArea(new Dimension(20, 0)));
			panelOptions.add(labelDuration);
			panelOptions.add(comboDuration);
			panelOptions.add(Box.createRigidArea(new Dimension(20, 0)));
			panelOptions.add(buttonUpdate);
		
		//add components to sales panel
		panelSales.add(panelGraph, BorderLayout.CENTER);
		panelSales.add(panelOptions, BorderLayout.NORTH);
		
		//http://mathbits.com/MathBits/Java/Graphics/linegraphonly.htm
		
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
	
	public void searchItemArray(int itemID)
	{
		textName.setText((String) Inventory[itemID - 1][1]);
		textPrice.setText((String) Inventory[itemID - 1][5]);
		textStock.setText(String.valueOf((int) Inventory[itemID - 1][2]));
	}
	
	/**
	 * Method to set up the table model for display
	 */
	public void setUpTableModel()
	{
		tableModel.addColumn("Purchase Order ID");
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
			productImage = ImageIO.read(new File("src/main/resources/images/" + imageFileName));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void setSalesArrays()
	{
		dayArray = new String[31];
		monthArray = new String[12];
		yearArray = new String[10];
				
		for(int i = 0; i < dayArray.length; i++)
		{
			dayArray[i] = Integer.toString(i + 1);
		}
		
		for(int i = 0; i < monthArray.length; i++)
		{
			monthArray[i] = Integer.toString(i + 1);
		}
		
		for(int i = 0; i < yearArray.length; i++)
		{
			yearArray[i] = Integer.toString(2015 - i);
		}
		
		durationArray = new String[]{"Days", "Weeks", "Months"};
	}
	
	public static void main(String[] args)
	{
		ItemGUI i = new ItemGUI();
	}
}
