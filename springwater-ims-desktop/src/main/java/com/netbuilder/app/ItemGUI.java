/**
 * @author Freshwater
 * @date 13/10/2015
 */
package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import loaders.PurchaseOrderLineLoader;
import loaders.PurchaseOrderLoader;
import loaders.SupplierLoader;
import entities.Item;
import entities.PurchaseOrder;
import entities.PurchaseOrderLine;
import entities.Supplier;
import loaders.ItemLoader;

/**
 *Creates a JFrame containing a selected item's details
 */
@SuppressWarnings("serial")
public class ItemGUI extends JFrame
{	
	private Item item;
	private ItemLoader itemLoader = new ItemLoader();
	private SupplierLoader supplierLoader = new SupplierLoader();
	private PurchaseOrderLoader purchaseOrderLoader = new PurchaseOrderLoader();
	private PurchaseOrderLineLoader purchaseOrderLineLoader = new PurchaseOrderLineLoader();
	
	private int itemID = 1;
	private Image img;
	private JTabbedPane tabbedPane;
	private JTable tableItem;
	private JButton buttonDiscontinue, buttonAddToPO;
	
	//------test data----------------------
	private LoadData Data = new LoadData();
	private Object[][] Inventory;
	//-------------------------------------
	
	
	private JLabel textName, textPrice, textStock, labelImage, textSupplier;
	private JTextField textAdd;
	
	private DefaultTableModel tableModel =  new DefaultTableModel(){
		@Override
	    public boolean isCellEditable(int i, int i1) {
	        return false; //To change body of generated methods, choose Tools | Templates.
	    }
	};
	
	/**
	 * Constructor that creates an instance of an item GUI for the item ID that is passed
	 * @param itemID : 
	 */
	public ItemGUI(int itemID)
	{
		this.itemID = itemID;
		
		initGUI();
		createUI();
		setLabels();
		loadTable();
	}
	
	/**
	 * Constructor to create an instance of an item GUI that doesn't include ItemID
	 * Mainly for testing
	 */
	public ItemGUI()
	{
		initGUI();
		createUI();
		setLabels();
		loadTable();
	}
	
	/**
	 * Initializes GUI configuration and methods before creation of UI
	 */
	public void initGUI()
	{
		//configure JFrame
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//get Item info from entity
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		//pulls item info from MongDB
		itemList = itemLoader.loadItemByID(itemID);
		System.out.println(itemList.size());
		item = itemList.get(0);
	
		//-------------Testing--------------
		//TODO fetch dummy data - needed for item images for now
		Inventory = Data.fetchInventoryList();
		//----------------------------------
		
		setUpTableModel();
	}
	
	/**
	 * Method that creates the front end to view an individual item
	 */
	public void createUI()
	{
		//Tab pane
		tabbedPane = new JTabbedPane();
		add(tabbedPane);
		
		//Sets up main panels
		viewItemPanel();
		itemSalesPanel();
		predictedSalesPanel();
		
		//configure size
		setTitle("Full Item Details");
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
		JPanel panelSplit = new JPanel(new GridLayout(8, 0));
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
			
			//Supplier 
			JPanel panelSupplier = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelSupplier = new JLabel("Supplier : ");
			textSupplier = new JLabel();
			panelSupplier.add(labelSupplier);
			panelSupplier.add(textSupplier);
			
			//Stock
			JPanel panelStock = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelStock = new JLabel("Stock Level : ");
			textStock = new JLabel("");
			panelStock.add(labelStock);
			panelStock.add(textStock);
			
			//Discontinue Item
			JPanel panelDiscontinue = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelDiscontinue = new JLabel("Item Status : ");
			buttonDiscontinue = new JButton("");
			panelDiscontinue.add(labelDiscontinue);
			panelDiscontinue.add(buttonDiscontinue);
			
			buttonDiscontinue.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					if(buttonDiscontinue.getText().equals("Active"))
					{
						int choice = JOptionPane.showOptionDialog(null, "Do you want to discontinue this item?",
														   "Choose an option", 
														   JOptionPane.YES_NO_OPTION, 
														   JOptionPane.QUESTION_MESSAGE, 
														   null, 
														   null, 
														   null);
						if(choice == JOptionPane.YES_OPTION)
						{
							buttonDiscontinue.setText("Discontinued");
							textAdd.setEditable(false);
							buttonAddToPO.setEnabled(false);
							itemLoader.setDiscontinueStatus(itemID, false);
						}
					}
					else if(buttonDiscontinue.getText().equals("Discontinued"))
					{
						int choice = JOptionPane.showOptionDialog(null, "Do you want to set this product to active?",
								   "Choose an option", 
								   JOptionPane.YES_NO_OPTION, 
								   JOptionPane.QUESTION_MESSAGE, 
								   null, 
								   null, 
								   null);
						if(choice == JOptionPane.YES_OPTION)
						{
							buttonDiscontinue.setText("Active");
							textAdd.setEditable(true);
							buttonAddToPO.setEnabled(true);
							itemLoader.setDiscontinueStatus(itemID, true);
						}
					}
				}
			});
			
			//Add to purchase order
			JPanel addToPO = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelQuantity = new JLabel("Quantity : ");
			textAdd = new JTextField(5);
			buttonAddToPO = new JButton("Add to Purchase Order");
			addToPO.add(labelQuantity);
			addToPO.add(textAdd);
			addToPO.add(buttonAddToPO);
			
			//testing button functionality with dummy data
			buttonAddToPO.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					
				}
			});
			
				//add components to item name panel
				panelSplit.add(panelID);
				panelSplit.add(panelMainName);
				panelSplit.add(panelPrice);
				panelSplit.add(panelSupplier);
				panelSplit.add(new JPanel());
				panelSplit.add(panelStock);
				panelSplit.add(panelDiscontinue);
				panelSplit.add(addToPO);
		
		
		//Item labelImage
		JPanel panellabelImage = new JPanel(new BorderLayout());
		panellabelImage.setBackground(Color.white);
		getProductlabelImage(item.getImageLocation());
		Image scaledImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		labelImage = new JLabel(new ImageIcon(scaledImg));
		panellabelImage.add(labelImage);
		
			//add components to top panel
			panelItem.add(panelSplit);
			panelItem.add(panellabelImage);
		
		
		//Item Table
		JPanel panelTable = new JPanel(new BorderLayout());
		
		tableItem = new JTable(tableModel);
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
				if(tableItem.getSelectedRow() > -1)
				{
					int purchaseOrderID = (int) tableModel.getValueAt(tableItem.getSelectedRow(), 0);
					ArrayList<PurchaseOrder> purchaseOrderList = purchaseOrderLoader.getPurchaseOrderByID(purchaseOrderID);
					PurchaseOrder purchaseOrder = purchaseOrderList.get(0);
						
					//TODO change individual PO frame constructor to only take the PO id and get the rest of the info from that
					IndividualPurchaseOrderViewFrame ipo = new IndividualPurchaseOrderViewFrame(purchaseOrderID, 
																								textSupplier.getText(), 
																								"12/07/2015", 
																								purchaseOrder.getPurchaseOrderStatus().getPurchOrderStatus(), 
																								"£100");
					ipo.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please choose a purchase order to view");
				}
			}
		});
		
			//add components to scroll pane
			panelTable.add(scrollTable, BorderLayout.CENTER);
			panelTable.add(buttonPO, BorderLayout.SOUTH);
		
		//adding components to item panel
		panelMain.add(panelItem);
		panelMain.add(panelTable);
	}
	
	/**
	 * Creates the sales panel  
	 */
	public void itemSalesPanel()
	{
		JPanel panelSales = new SalesGraphGUI(itemID);
		tabbedPane.add("Sales" ,panelSales);
	}
	
	/**
	 * Creates the predicted sales panel
	 */
	public void predictedSalesPanel()
	{
		JPanel panelPredictedSales = new JPanel();
		tabbedPane.add("Predicted Sales", panelPredictedSales);
	}
	
	/**
	 * Method that loads the table model with the items purchase order information
	 */
	public void loadTable()
	{
		ArrayList<PurchaseOrder> purchaseOrderList = purchaseOrderLoader.getPurchaseOrderListByItem(itemID);
		ArrayList<PurchaseOrderLine> purchaseOrderLineList;
		
		if(purchaseOrderList.size() > 0)
		{
			for(int i = 0; i < purchaseOrderList.size(); i++)
			{
				purchaseOrderLineList = purchaseOrderLineLoader.getPurchaseOrderLineByOrderAndProduct(purchaseOrderList.get(i).getIDPurchaseOrder(), itemID);
				
				if(!purchaseOrderLineList.isEmpty())
				{
					tableModel.addRow(new Object[]{purchaseOrderList.get(i).getIDPurchaseOrder(), 
												   purchaseOrderList.get(i).getDatePlaced(),
												   purchaseOrderLineList.get(0).getQuantity(),
												   purchaseOrderList.get(i).getPurchaseOrderStatus().getPurchOrderStatus()});
				}
			}
		}
	}
	
	/**
	 * Method to set the JLabels on the Item Info panel
	 * @param itemID : The specified items ID
	 */
	private void setLabels()
	{	
		textName.setText(item.getItemName());
		textPrice.setText("£" + Float.toString(item.getPrice()));
		textStock.setText(Integer.toString(item.getStock()));
		
		ArrayList<Supplier> supplierList = supplierLoader.getSupplierListByID(item.getIdSupplier());
		
		if(!supplierList.isEmpty())
		{
			textSupplier.setText(supplierList.get(0).getSupplierName());
		}
		
		if(item.isDiscontinued() == true)
		{
			buttonDiscontinue.setText("Discontinued");
			textAdd.setEditable(false);
			buttonAddToPO.setEnabled(false);
		}
		else
		{
			buttonDiscontinue.setText("Active");
			textAdd.setEditable(true);
			buttonAddToPO.setEnabled(true);
		}
		
	}
	
	/**
	 * Method to set up the table model for display
	 * Sets up table columns
	 */
	public void setUpTableModel()
	{
		tableModel.addColumn("Purchase Order ID");
		tableModel.addColumn("Date");
		tableModel.addColumn("Stock In");
		tableModel.addColumn("Status");
	}
	
	/**
	 * Method that loads an labelImage from the resources folder by passing the labelImage files name
	 * @param labelImageFileName : The file location name in src/main/resources/Images/ e.g red_gnome.png
	 */
	public void getProductlabelImage(String labelImageFileName)
	{
		try 
		{
			img = ImageIO.read(new File("src/main/resources/Images/" + labelImageFileName));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args)
//	{
//		ItemGUI i = new ItemGUI();
//	}
}
