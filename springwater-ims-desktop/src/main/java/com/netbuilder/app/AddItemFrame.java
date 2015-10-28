/**
 * @author abutcher
 * @date 20/10/2015
 */

package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import entities.Item;
import loaders.ItemLoader;

@SuppressWarnings("serial")
public class AddItemFrame extends JFrame 
{
	private JPanel base, main, buttonBar, attributesP, browseP;
	private JLabel itemNameL, itemDescriptionL, itemPriceL, itemUnitPriceL,porousewareL, supplierL, typeL, column1L,column2L, browseL;
	private JTextField itemNameR, textBrowse;
	private JTextArea itemDescriptionR;
	private JComboBox supplierR, typeR;
	private JRadioButton porouswareYesB, porouswareNoB;
	private JButton addIB, addAttributesB, removeAttributesB, cancelB;
	private JFormattedTextField itemPriceR, itemUnitPriceR;
	private ArrayList<JTextField> attributesNames = new ArrayList<JTextField>();
	private ArrayList<JTextField> attributesDes = new ArrayList<JTextField>();
	private ArrayList<JLabel> attributesLabels = new ArrayList<JLabel>();
	private GridBagConstraints c = new GridBagConstraints();
	private GridBagConstraints attriC;
	private int noOfA = 0;
	private TextPrompt inp, idp, ispp, iucp ;
	private boolean edit = false;
	
	private JFileChooser fileChooser = new JFileChooser();
	private ItemLoader itemLoader = new ItemLoader();
	private String imageLocation;

//	public static void main(String[] args) {
//		AddItemFrame iF = new AddItemFrame();
//		iF.setVisible(true);
//	}

	/**
	 * constructor for adding a new item
	 */
	public AddItemFrame() {
		configFrame();
		addContent();
	}

	/**
	 * constructor for editing a item
	 * @param id - id of of item to edit
	 */
	public AddItemFrame(int id) {
		edit = !edit; 
		configFrame();
		addContent();
		setValues(id);
	}
	
	/**
	 * configures the frame
	 */	
	private void configFrame() {
		@SuppressWarnings("unused")
		String titleS = "Add New Item";
		if (edit) {
			titleS = "Edit Item";
		}
		setTitle("Add an Item");
		setSize(500, 360);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
	}

	/**
	 * creates the main panel of the frame
	 */
	private void addContent() {
		base = new JPanel(new BorderLayout());
		add(base);
		main = new JPanel(new GridBagLayout());
		DecimalFormat df = new DecimalFormat("#.00"); 
		
		boolean shouldFill = true;

		if (shouldFill) {
			c.fill = GridBagConstraints.HORIZONTAL;
		}
		
		itemNameL = new JLabel(" Name :");
		c.gridx = 0;
		c.gridy = 0;
		main.add(itemNameL, c);
			
		itemDescriptionL = new JLabel(" Description :");
		c.gridy = 1;
		main.add(itemDescriptionL, c);
		
		itemPriceL = new JLabel(" Sale Price : £");	
		c.gridy = 2;
		main.add(itemPriceL, c);
		
		itemUnitPriceL = new JLabel(" Unit Cost : £");
		c.gridy = 3;
		main.add(itemUnitPriceL, c);
		
		porousewareL = new JLabel(" PorouseWare :");
		c.gridy = 4;
		main.add(porousewareL, c);
		
		typeL = new JLabel(" Catergory :");
		c.gridy = 5;
		main.add(typeL, c);
		
		supplierL = new JLabel(" Supplier :");
		c.gridy = 6;
		main.add(supplierL, c);
		
		browseL = new JLabel("  Image :");
		c.gridy = 7;
		main.add(browseL, c);
		
		browseP = browseFiles();
		c.gridy = 7;
		c.gridx = 1;
		c.gridwidth = 2;
		main.add(browseP, c);
		
		attributesP = new JPanel(new GridBagLayout());
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth=3;
		main.add(attributesP, c);
		
		column1L = new JLabel("Name");
		column1L.setBorder(BorderFactory.createLineBorder(Color.black));
		column2L = new JLabel("Description");
		column2L.setBorder(BorderFactory.createLineBorder(Color.black));
		
		//Inputs
		porouswareYesB = new JRadioButton("Yes");
		porouswareYesB.setSelected(true);
		c.gridx = 1;
		c.gridy = 4;
		c.gridwidth= 1;
		main.add(porouswareYesB, c);
		
		porouswareNoB = new JRadioButton("No");
		c.gridx = 2;
		c.gridy = 4;
		main.add(porouswareNoB, c);
		
		 ButtonGroup group = new ButtonGroup();
		 group.add(porouswareYesB);
		 group.add(porouswareNoB);
		
		itemNameR = new JTextField();
		inp = new TextPrompt("Gnome with hat", itemNameR);
		inp.changeAlpha(0.75f);
		itemNameR.setColumns(30);
		itemNameR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;	
		main.add(itemNameR, c);
		
		itemDescriptionR = new JTextArea();
		idp = new TextPrompt("Gnome with blue jacket and red hat.........", itemDescriptionR);
		idp.changeAlpha(0.75f);
		itemDescriptionR.setColumns(30);
		itemDescriptionR.setRows(5);
		itemDescriptionR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy = 1;
		JScrollPane scroll = new JScrollPane (itemDescriptionR);
		main.add(scroll, c);
		
		itemPriceR = new JFormattedTextField(df);
		ispp = new TextPrompt("10.00", itemPriceR);
		ispp.changeAlpha(0.75f);
		itemPriceR.setColumns(30);
		itemPriceR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.weightx = 0.5;
		c.gridy = 2;
		main.add(itemPriceR, c);
		
		itemUnitPriceR = new JFormattedTextField(df);
		iucp = new TextPrompt("10.00", itemUnitPriceR);
		iucp.changeAlpha(0.75f);
		itemUnitPriceR.setColumns(30);
		itemUnitPriceR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy = 3;
		main.add(itemUnitPriceR, c);
		
		typeR = new JComboBox();
		//TODO get category list and add to combo box
//		supplierR.setSelectedIndex(0);
		typeR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy =5;
		main.add(typeR, c);
		
		supplierR = new JComboBox();
		//TODO get supplier list and add to combo box
//		supplierR.setSelectedIndex(0);
		supplierR.setBorder(BorderFactory.createLineBorder(Color.black));
		c.gridy = 6;		
		main.add(supplierR, c); 
		
		// Button Bar Panel
		buttonBar = new JPanel();
		buttonBar.setLayout(new GridLayout(1, 3));
		String buttonS = "Add";
		if (edit) {
			buttonS = "Save changes";
		}
		addIB = new JButton(buttonS);
		cancelB = new JButton("Cancel");

		addAttributePanel();
		
		buttonBar.add(addIB);
		buttonBar.add(cancelB);

		//ActionListeners
		addIB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO add item
				if(isFilledOut()){
					getResult();
				}				
			}
		});
		
		cancelB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				
				base.add(main, BorderLayout.CENTER);
				base.add(buttonBar, BorderLayout.SOUTH);
	}
	
	/**
	 * creates the attributes panel
	 */
	private void addAttributePanel() {
		attriC = new GridBagConstraints();
		attriC.fill = GridBagConstraints.HORIZONTAL;
		noOfA++;
		
		//add a 20 pixel drop to the frame when an attribute panel is added
		setSize(getSize().width, getSize().height+20);
		
		if(noOfA !=1) {
			attributesP.removeAll();
			attributesP.revalidate();
		}
		
		attriC.gridx = 1;
		attriC.gridy = 0;
		attributesP.add(column1L, attriC);
		
		attriC.gridx = 2;
		attributesP.add(column2L, attriC);
		
		attributesLabels.add(new JLabel("Attribute " + noOfA + ":"));
		attributesNames.add(new JTextField());
		attributesNames.get(noOfA-1).setColumns(15);
		attributesNames.get(noOfA-1).setBorder(BorderFactory.createLineBorder(Color.black));
		attributesDes.add(new JTextField());
		attributesDes.get(noOfA-1).setColumns(15);
		attributesDes.get(noOfA-1).setBorder(BorderFactory.createLineBorder(Color.black));	
		
		for (int i = 0; i < noOfA; i++){		
			attriC.gridx = 0;
			attriC.gridy = i +2;
			attributesP.add(attributesLabels.get(i), attriC);
							
			attriC.gridx = 1;
			attriC.gridy = i +2;
			attributesP.add(attributesNames.get(i), attriC);
			
			attriC.gridx = 2;
			attriC.gridy = i +2;
			attributesP.add(attributesDes.get(i), attriC);
		}
		
		addAttributesB = new JButton("+");
		addAttributesB.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				addAttributePanel();				
			}
		});
		
		removeAttributesB= new JButton("-");
		removeAttributesB.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		
		attriC.gridx = 1;
		attriC.gridy = noOfA+4;
		attriC.gridwidth = 1;
		attributesP.add(addAttributesB, attriC);
		
		//remove attributes button
		attriC.gridx = 2;
		attributesP.add(removeAttributesB, attriC);
		
		/*//TODO add erase last attribute field - in case of adding too many
		attriC.gridy = noOfA+4;
		JButton buttonRemoveAttribute = new JButton("-");
		attributesP.add(buttonRemoveAttribute, attriC);
		*/
	}
	
	/**
	 * Method to set the values of the form to relate to the given id
	 * @param id - the id of the item to edit
	 */
	private void setValues(int id) {
		//TODO get item details
		itemNameR.setText("");
		itemDescriptionR.setText("");
		itemPriceR.setText("");
		itemUnitPriceR.setText("");
		//TODO select correct radio button
		typeR.setSelectedItem(null);
		supplierR.setSelectedItem(null);
		//TODO fill attributes
	}
	
	/**
	 * check to see if all required fields are filled out
	 * @return false if not filled out
	 */
	private boolean isFilledOut()
	{
		boolean ready = true;
		String errorMessage = "";
		
		if (itemNameR.getText().isEmpty()) 
		{
			ready = false;
			errorMessage = errorMessage + "An item name must be entered";
		}
		
		if (itemDescriptionR.getText().isEmpty()) 
		{
			ready = false;
			errorMessage = errorMessage + '\n' + "An item description must be entered";
		}
		
		if (itemPriceR.getText().isEmpty()) 
		{
			ready = false;
			errorMessage = errorMessage + '\n' + "An item sale price must be entered";
		}
		
		if (itemUnitPriceR.getText().isEmpty()) 
		{
			ready = false;
			errorMessage = errorMessage + '\n' + "An item unit cost must be entered";
		}
		
		if (textBrowse.getText().isEmpty()) 
		{
			ready = false;
			errorMessage = errorMessage + '\n' + "An item image file must be added";
		}
		
		if(ready == false)
		{
			JFrame frame = new JFrame("Add new item");
			JOptionPane.showMessageDialog(frame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		return ready;
	}
	
	/**
	 * Method to collate the inputs from the GUI
	 * @return array of objects representing the attributes of the item
	 */
	private Object[] getResults(){
		ArrayList<Object> input = new ArrayList<Object>();
		input.add(itemNameR.getText());
		input.add(itemDescriptionR.getText());
		input.add(itemPriceR.getText());
		input.add(itemUnitPriceR.getText());
		input.add(porouswareYesB.isSelected());
		input.add(typeR.getSelectedItem());	
		input.add(supplierR.getSelectedItem());
		
		for (int i = 0; i<noOfA;i++)
		{
			input.add(attributesNames.get(i).getText());
			input.add(attributesDes.get(i).getText());
		}
		Object[] array = new Object[input.size()];
		array =  input.toArray(array);
		return array;
	}
	
	/**
	 * Method that creates a file browsing frame to select the image for the item
	 * @return Returns the JPanel
	 */
	private JPanel browseFiles()
	{
		JPanel browsePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		//File chooser filter
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files .jpg, .png", "jpg", "png");
		fileChooser.setFileFilter(filter);
		
		//JTextField
		textBrowse = new JTextField(30);
		textBrowse.setEditable(false);
		
		//browse button
		JButton buttonBrowse = new JButton();
		buttonBrowse.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				//TODO set image location to location in java project not local machine
				imageLocation = null;
				
				//open file chooser
				fileChooser.showOpenDialog(getContentPane());
				
				//file chooser null check
				if(fileChooser.getSelectedFile() != null)
				{
					//get image file path
					imageLocation = fileChooser.getSelectedFile().getAbsolutePath();
				}
				
				textBrowse.setText(imageLocation);
			}
		});
		
			//Add icon image to button
			try
			{
				BufferedImage img = ImageIO.read(new File("src/main/resources/folder_icon.png"));
				buttonBrowse.setIcon(new ImageIcon(img));
			}
			catch(IOException ex)
			{
				ex.printStackTrace();
			}
		
		//add components to panel
		browsePanel.add(textBrowse);
		browsePanel.add(buttonBrowse);
		
		return browsePanel;
	}
	
	/**
	 * Method that creates an Item object from the GUI results and adds it to MongoDB
	 */
	private void getResult()
	{
		copyFile(new File(textBrowse.getText()));
		
		Item item = new Item(itemNameR.getText(),                        //name
					  		 itemDescriptionR.getText(),                 //description
					         Float.parseFloat(itemPriceR.getText()),     //price
					         Float.parseFloat(itemUnitPriceR.getText()), //cost
					         0, 						     		     //initial stock
					         imageLocation, 				          	 //image location
					         false,						  	             //is Discontinued
					         porouswareYesB.isSelected(),    		     //is Porouswareable
					         (int) supplierR.getSelectedItem(), 0, 0);         //supplier
			
		
		//itemLoader.addItem(item);
	}

	/**
	 * Method to copy the source image file into the java project
	 */
	private void copyFile(File sourceFile)
	{
		File Source = sourceFile;
		String Path = "src/main/resources/";
		File Destination = new File(Path + Source.getName());
		
		//Copy from source to destination
		try 
		{
			Files.copy(Source.toPath(), Destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		//set image location
		imageLocation = Path + Source.getName();
	}
}
