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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.netbuilder.apploader.ItemLoader;
import com.netbuilder.entities.Item;

/**
 *Creates a JFrame containing a selected item's details
 */
@SuppressWarnings("serial")
public class ItemGUI extends JFrame
{	
	private int itemID = 1;
	private BufferedImage productImage;
	private Image img;
	private JTabbedPane tabbedPane;
	private DefaultTableModel tableModel =  new DefaultTableModel(){
		@Override
	    public boolean isCellEditable(int i, int i1) {
	        return false; //To change body of generated methods, choose Tools | Templates.
	    }
	};
	private String[] dayArray, monthArray, yearArray, durationArray;
	private LoadData Data = new LoadData();
	private Object[][] Inventory;
	private Object[][] PO;
	private ArrayList<Object[]> listPO;
	private Object[][] Suppliers;
	private JLabel textName, textPrice, textStock, labelImage, textSupplier;
	private JTextField textAdd;
	private ItemLoader itemLoader;

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
		listPO = Data.fetchPurchaseOrderList();
		Suppliers = Data.fetchSuppliers();
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
			
			//Add to purchase order
			JPanel addToPO = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel labelQuantity = new JLabel("Quantity : ");
			textAdd = new JTextField(5);
			JButton buttonAddToPO = new JButton("Add to Purchase Order");
			addToPO.add(labelQuantity);
			addToPO.add(textAdd);
			addToPO.add(buttonAddToPO);
			
			buttonAddToPO.addActionListener(new ActionListener()
			{
				@Override
				public void actionPerformed(ActionEvent e) 
				{
					//null check
					if(textAdd.getText().equals(""))
					{
						textAdd.setText("0");
					}
					
					if(Integer.parseInt(textAdd.getText()) > 0)
					{
						listPO.add(new Object[]{(listPO.size() - 1), "21/10/2015", textAdd.getText(),  "Order not sent", textSupplier.getText(), textPrice.getText()});
						
					}
					else
					{
						textAdd.setText("0");
						JOptionPane.showMessageDialog(null, "The quantity must be higher than 0");
					}
					
					for(int i = 0; i < listPO.size(); i++)
					{
						if(listPO.get(i)[3].equals("Order not sent"))
						{
							String oldValue = (String) listPO.get(i)[3];
							
							String newValue = Integer.toString(Integer.parseInt(oldValue) + Integer.parseInt(textAdd.getText())); 
							listPO.get(i)[3] = newValue;
							
							tableModel.setValueAt(newValue, listPO.size() - i, 3);
							
							System.out.println(listPO.get(i)[3]);
						}
						else
						{
							tableModel.insertRow(0, listPO.get(listPO.size() - 1));
							break;
						}
					}
				}
			});
			
				//add components to item name panel
				panelSplit.add(panelID);
				panelSplit.add(panelMainName);
				panelSplit.add(panelPrice);
				panelSplit.add(panelSupplier);
				panelSplit.add(new JPanel());
				panelSplit.add(panelStock);
				panelSplit.add(new JPanel());
				panelSplit.add(addToPO);
		
		
		//Item labelImage
		JPanel panellabelImage = new JPanel(new BorderLayout());
		panellabelImage.setBackground(Color.white);
		getProductlabelImage((String)Inventory[itemID - 1][4]);
		Image scaledImg = img.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
		labelImage = new JLabel(new ImageIcon(scaledImg));
		panellabelImage.add(labelImage);
		
			//add components to top panel
			panelItem.add(panelSplit);
			panelItem.add(panellabelImage);
		
		
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
				IndividualPurchaseOrderViewFrame ipo = new IndividualPurchaseOrderViewFrame(1, "Supplier", "12/07/2015", "Order Placed", "£100");
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
		
		//table testing
		tableModel.addRow(new Object[]{PO[2][0], "02/06/2015", 20, "Order Placed"});
		tableModel.addRow(new Object[]{PO[1][0], PO[1][1], 35, "Order Completed"});
		
		//mongo testing
		ArrayList<Item> itemList = new ArrayList<Item>();
		itemLoader = new ItemLoader();
		itemList = itemLoader.loadItemByID(1);
		System.out.println(itemList.get(0).getItemName());
		System.out.println(itemList.get(0).getIdItem());
		System.out.println(itemList.get(0).getIdSupplier());
		System.out.println(itemList.get(0).getCost());
		System.out.println(itemList.get(0).getImageLocation());
		System.out.println(itemList.get(0).getStock());
		
	}
	
	/**
	 * Creates the sales panel  
	 */
	public void itemSalesPanel()
	{
		JPanel panelSales = new SalesGraphGUI();
		tabbedPane.add("Sales" ,panelSales);
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
		textSupplier.setText((String) Suppliers[1][1]);
	}
	
	/**
	 * Method to set up the table model for display
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
	 * @param labelImageFileName
	 */
	public void getProductlabelImage(String labelImageFileName)
	{
		//Get Product labelImage
		try 
		{
			productImage = ImageIO.read(new File("src/main/resources/Images/" + labelImageFileName));
			img = ImageIO.read(new File("src/main/resources/Images/" + labelImageFileName));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		ItemGUI i = new ItemGUI();
	}
}
