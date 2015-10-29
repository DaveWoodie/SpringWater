/**
 * @author jforster
 * @date 09/10/2015
 */
package com.netbuilder.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.netbuilder.logic.SupplierLogic;

/**
 * 
 * GUI generation to display selected supplier and details
 *
 */
@SuppressWarnings("serial")
public class SupplierFrame extends JFrame{
	
	private String [] columns = {"Product ID", "Product Name"};
	TableModel productListModel;
	JPanel base, main, left, right, bottom, bottomOptions;
	JLabel rightTest, leftLogo;
	JTable productList;
	JScrollPane bottomPane;
	JButton exit, edit, select;
	int selectedID;
	private SupplierLogic lD = new SupplierLogic();
	private String imageLocation;
	private String imageFolderLocation = "src/main/resources/images/";
	private ImageIcon itemIcon;
	private IconLoader iconLoader = new IconLoader();
	private int IMAGE_SIZE = 50;
	
	public SupplierFrame(int supplierID, String supplierName) {
		initUI(supplierID, supplierName);
		setVisible(true);
	}
	public SupplierFrame(int supplierID) {
		Object [][] gN = lD.fetchSupplierByID(supplierID);
		initUI(supplierID, (String)gN[0][1]);
		setVisible(true);
	}
	/**
	 * Method to construct the GUI JFrame for display
	 */
	public void initUI(int supplierID, String supplierName) {
		selectedID = supplierID;
		
		//configure base panel
		base = new JPanel();
		base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
		add(base);
		
		//configure main panel
		main = new JPanel();
		main.setLayout(new GridLayout(1, 2));
		
		//create left panel
		Object [][] products = lD.fetchProducts(selectedID);
		Object [][] supplierDetails = lD.fetchSupplierByID(selectedID);
		left = new JPanel();
//		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
//		try{
//			String s = "src/main/resources/images/" + supplierDetails[0][6];
////			System.out.println(s);
//			BufferedImage Logo = ImageIO.read(new File(s));
//			leftLogo = new JLabel(new ImageIcon(Logo));
//		}
//		catch(IOException ex){
//			System.out.println(ex);
//		}
		
		imageLocation = ((String)supplierDetails[0][6]);
		
		left = new JPanel();
//		 setFinalSize(left, this.WIDTH*2/6, HEIGHT);
		left.setLayout(new GridBagLayout());
//		makeOpaque(left);
		if(this.imageLocation != null) {
			itemIcon = iconLoader.createImageIcon(this.imageFolderLocation+this.imageLocation, IMAGE_SIZE, IMAGE_SIZE);
		} else {
			itemIcon = loadDefaultImage();
		}
		JLabel lbl = new JLabel(itemIcon);
		lbl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0,0,0)));
		left.add(lbl);
		
		//create right panel
		right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		right.setMinimumSize(new Dimension(350,50));
		String str = "<html>  ID: " + supplierID + "<br>  Name: " + supplierName  +"<br> "+ supplierDetails[0][2] + "<br>  " + supplierDetails[0][3] + "<br>  Average Delivery Time: " +  supplierDetails[0][5]+ " Days"+ "<br><br>  Address "   +   supplierDetails[0][4]+ ":<br>";
		ArrayList<String> address =  lD.getAddress((int)supplierDetails[0][4]);
		for (String s :address) {
			str = str + s + "<br>";
		}
		rightTest = new JLabel(str);
		rightTest.setFont(new Font("Serif", Font.BOLD, 16));
		right.add(rightTest);
		
		//create bottom panel
		bottom = new JPanel();
		productListModel = new DefaultTableModel(products, columns){
			@Override
		    public boolean isCellEditable(int i, int i1) {
		        return false; //To change body of generated methods, choose Tools | Templates.
		    }
		};
		productList = new JTable(productListModel);
		ListSelectionModel prListSelectionModel =productList.getSelectionModel();
		prListSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		prListSelectionModel.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int selectedRow = productList.getSelectedRow();
				try {
					selectedID = Integer.parseInt(productList.getValueAt(selectedRow, 0).toString());
				} catch (NullPointerException npe) {
					System.out.println("Not a valid Item!");
				}
			}
		});

		bottom.add(productList);
		bottomPane = new JScrollPane();
		bottomPane.setViewportView(productList);
		
		//create bottomOptions panel
		bottomOptions = new JPanel();
		select = new JButton("Select Item");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selectedID ==0) {
					System.out.println("No item selected!");
				}
				else {
				@SuppressWarnings("unused")
				ItemGUI IG = new ItemGUI(selectedID);
				}
				
			}
		});
		
		edit = new JButton("Edit Supplier Details");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddSupplierFrame aSF = new AddSupplierFrame(selectedID);
				aSF.setVisible(true);
			}
		});
		
		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		bottomOptions.add(select);
		bottomOptions.add(edit);
		bottomOptions.add(exit);
		
		
		//construct main and base panels
		main.add(left);
		main.add(right);
		base.add(main);
		base.add(bottomPane);
		base.add(bottomOptions);
		
		//configure frame
		setTitle("Full Supplier Details");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 800));
	}
	
	private ImageIcon loadDefaultImage() {
		ImageIcon icon = iconLoader.createImageIcon("src/main/resources/images/gnome.jpg", IMAGE_SIZE, IMAGE_SIZE);
		return icon;
	}
}