package com.netbuilder.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InventoryItem extends JPanel {

	private static final long serialVersionUID = 1L;
	private static int HEIGHT = 70;
	private int width;
	
	private int productID;
	private String productName;
	private int quantity;
	private String location;
	private String imageLocation;
	
	private IconLoader iconLoader;
	
	private JPanel infoPanel;
	private JPanel imagePanel;
	private ImageIcon itemIcon;
	
	public InventoryItem(InventoryGUI src, int width, int productID, String productName, int quantity, String location, String imageLocation) {
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.location = location;
		this.imageLocation = imageLocation;
		this.width = width;
		
		this.iconLoader = new IconLoader();
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setFinalSize(this, this.width, HEIGHT);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0,0,0)));
		this.setBackground(new Color (197,208,199));
		

		
		infoPanel = new JPanel();
		infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
		makeOpaque(infoPanel);
		setFinalSize(infoPanel, this.width*4/6, HEIGHT);
		
		infoPanel.add(new JLabel("Name: "+this.productName));
		infoPanel.add(new JLabel("ID: "+this.productID));
		infoPanel.add(new JLabel("Quantity: "+this.quantity));
		infoPanel.add(new JLabel("Location: "+this.location));
		

		this.add(infoPanel);
		
		imagePanel = new JPanel();
		setFinalSize(imagePanel, this.width*2/6, HEIGHT);
		imagePanel.setLayout(new GridBagLayout());
		makeOpaque(imagePanel);
		if(this.imageLocation != null) {
			itemIcon = iconLoader.createImageIcon("./Images/"+this.imageLocation, this.width*1/6, this.width*1/6);
		} else {
			itemIcon = loadDefaultImage();
		}
		
		JLabel lbl = new JLabel(itemIcon);
		imagePanel.add(lbl);
		this.add(imagePanel);
		
	}

	
	private void setFinalSize(JPanel panel, int width, int height) {
		Dimension d = new Dimension(width, height);
		panel.setPreferredSize(d);
		panel.setMaximumSize(d);
		panel.setMinimumSize(d);
	}
	
	
	private void makeOpaque(JPanel panel) {
		panel.setOpaque(true);
		panel.setBackground(new Color(0,0,0,0));
	}

	private ImageIcon loadDefaultImage() {
		ImageIcon icon = iconLoader.createImageIcon("src/test/Resources/trial_gnome.png", this.width*1/6, this.width*1/6);
		return icon;
	}


}
