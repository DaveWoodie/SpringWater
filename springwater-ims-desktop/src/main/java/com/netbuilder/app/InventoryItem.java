package com.netbuilder.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InventoryItem extends JPanel implements MouseListener {

	private static final long serialVersionUID = 1L;
	private static int HEIGHT = 70;
	private int WIDTH;
	
	private int IMAGE_SIZE = 50;
	
	private int productID;
	private String productName;
	private int quantity;
	private String location;
	private String imageLocation;
	
	private IconLoader iconLoader;
	
	private JPanel infoPanel;
	private JPanel imagePanel;
	private ImageIcon itemIcon;
	
	private Color backgroundColor = new Color(197,208,199);
	private Color hoverBackgroundColor = new Color(157,166,159);
	
	public InventoryItem(InventoryGUI src, int width, int productID, String productName, int quantity, String location, String imageLocation) {
		this.productID = productID;
		this.productName = productName;
		this.quantity = quantity;
		this.location = location;
		this.imageLocation = imageLocation;
		this.WIDTH = width;
		initialSetup();
		
	}
	
	private void initialSetup() {
		this.iconLoader = new IconLoader();
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setFinalSize(this, this.WIDTH, HEIGHT);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0,0,0)));
		this.setBackground(backgroundColor);
		
		this.addMouseListener(this);
		
		
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(2, 2));
		makeOpaque(infoPanel);
		setFinalSize(infoPanel, this.WIDTH*4/6, HEIGHT);
		
		infoPanel.add(new JLabel("Name: "+this.productName));
		infoPanel.add(new JLabel("ID: "+this.productID));
		infoPanel.add(new JLabel("Quantity: "+this.quantity));
		infoPanel.add(new JLabel("Location: "+this.location));
		

		this.add(infoPanel);
		
		imagePanel = new JPanel();
		setFinalSize(imagePanel, this.WIDTH*2/6, HEIGHT);
		imagePanel.setLayout(new GridBagLayout());
		makeOpaque(imagePanel);
		if(this.imageLocation != null) {
			itemIcon = iconLoader.createImageIcon("./Images/"+this.imageLocation, IMAGE_SIZE, IMAGE_SIZE);
		} else {
			itemIcon = loadDefaultImage();
		}
		
		JLabel lbl = new JLabel(itemIcon);
		lbl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0,0,0)));
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
		ImageIcon icon = iconLoader.createImageIcon("src/main/resources/images/gnome.jpg", IMAGE_SIZE, IMAGE_SIZE);
		return icon;
	}
	
	public void resizeEverything(int newWidth) {
		this.WIDTH = newWidth;
		setFinalSize(this, WIDTH, HEIGHT);
		setFinalSize(infoPanel, this.WIDTH*4/6, HEIGHT);
		setFinalSize(imagePanel, this.WIDTH*2/6, HEIGHT);
		
		this.repaint();
		this.revalidate();
	}

	public int getID() {
		return productID;
	}
	
	public String getName() {
		return productName;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ItemGUI itemGUI = new ItemGUI(this.productID);
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		setBackground(hoverBackgroundColor);
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		setBackground(backgroundColor);
		
	}


}
