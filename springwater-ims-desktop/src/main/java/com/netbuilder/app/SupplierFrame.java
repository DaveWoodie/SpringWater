/**
 * @author jforster
 * @date 09/10/2015
 */
package com.netbuilder.app;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * 
 * GUI generation to display selected supplier and details
 *
 */
@SuppressWarnings("serial")
public class SupplierFrame extends JFrame{
	
	private String [] columns = {"Product ID", "Product Name"};
	TableModel productListModel = new DefaultTableModel(columns, 20);
	JPanel base, main, left, right, bottom, bottomOptions;
	JLabel rightTest, leftTest;
	JTable productList;
	JScrollPane bottomPane;
	JButton exit;

	/**
	 * Method to construct the GUI JFrame for display
	 */
	public void initUI() {
		
		//configure base panel
		base = new JPanel();
		base.setLayout(new BoxLayout(base, BoxLayout.Y_AXIS));
		add(base);
		
		//configure main panel
		main = new JPanel();
		main.setLayout(new GridLayout(1, 2));
		
		//create left panel
		left = new JPanel();
		left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));
		try{
			BufferedImage Logo = ImageIO.read(new File("src/main/Resources/logoExample.png"));
			leftTest = new JLabel(new ImageIcon(Logo));
		}
		catch(IOException ex){
			System.out.println(ex);
		}
		left.add(leftTest);
		
		//create right panel
		right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		right.setMinimumSize(new Dimension(350,50));
		rightTest = new JLabel("<html>Supplier ID: 001<br>Supplier Name: NB Supplies<br>Supplier Address: 59<br>NB Road<br><br>Gnomes<br>GN0 M3S");
		right.add(rightTest);
		
		//create bottom panel
		bottom = new JPanel();
		productList = new JTable(productListModel);
		bottom.add(productList);
		bottomPane = new JScrollPane();
		bottomPane.setViewportView(productList);
		
		//create bottomOptions panel
		bottomOptions = new JPanel();
		exit = new JButton("Exit");
		exit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		bottomOptions.add(exit);
		
		//construct main and base panels
		main.add(left);
		main.add(right);
		base.add(main);
		base.add(bottomPane);
		base.add(bottomOptions);
		
		//configure frame
		setTitle("Inventory Management System");
		setSize(600, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 800));
	}
}
