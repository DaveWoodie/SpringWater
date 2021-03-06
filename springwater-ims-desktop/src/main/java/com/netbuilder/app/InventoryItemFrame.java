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
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entities.Item;

public class InventoryItemFrame extends JPanel implements MouseListener {

	private String imageFolderLocation = "src/main/resources/images/";
	private static final long serialVersionUID = 1L;
	private static int HEIGHT = 70;
	private int WIDTH;
	private Item item;
	
	private int IMAGE_SIZE = 50;
	
	private int productID;
	private String productName;
	private int quantity;
	private String imageLocation;
	private boolean porousware;
	
	private IconLoader iconLoader;
	
	private JPanel infoPanel;
	private JPanel imagePanel;
	private ImageIcon itemIcon;
	
	private JPanel buttonPanel;
	private JButton viewItemButton;
	
	private Color backgroundColor = new Color(197,208,199);
	private Color hoverBackgroundColor = new Color(157,166,159);
	
	private Color discontinuedBackgroundColor = new Color(234,139,139);
	private Color discontinuedHoverBackgroundColor = new Color(187,111,111);
	
	
	public InventoryItemFrame(InventoryGUI src, int width, Item item) {
		this.productID = item.getIdItem();
		this.productName = item.getItemName();
		this.quantity = item.getStock();
		this.porousware = item.isPorousware();
		this.imageLocation = item.getImageLocation();
		this.item = item;
		this.WIDTH = width;
		initialSetup();
	}
	
	private void initialSetup() {
		this.iconLoader = new IconLoader();
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.setFinalSize(this, this.WIDTH, HEIGHT);
		this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0,0,0)));
		setNormalBackground();
		
		this.addMouseListener(this);
		
		
		infoPanel = new JPanel();
		infoPanel.setLayout(new GridLayout(4, 1));
		makeOpaque(infoPanel);
		setFinalSize(infoPanel, this.WIDTH*4/6, HEIGHT);
		
		infoPanel.add(new JLabel("Name: "+this.productName));
		infoPanel.add(new JLabel("Item ID: "+this.productID));
		infoPanel.add(new JLabel("Quantity: "+this.quantity));
		infoPanel.add(new JLabel("Porousware: "+porouswareReadout(this.porousware)));
		

		this.add(infoPanel);
		
		imagePanel = new JPanel();
		setFinalSize(imagePanel, this.WIDTH*2/6, HEIGHT);
		imagePanel.setLayout(new GridBagLayout());
		makeOpaque(imagePanel);
		if(this.imageLocation != null) {
			itemIcon = iconLoader.createImageIcon(this.imageFolderLocation+this.imageLocation, IMAGE_SIZE, IMAGE_SIZE);
		} else {
			itemIcon = loadDefaultImage();
		}
		
		JLabel lbl = new JLabel(itemIcon);
		lbl.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(0,0,0)));
		imagePanel.add(lbl);
		this.add(imagePanel);
		
		buttonPanel = new JPanel();
		setFinalSize(buttonPanel, WIDTH/6, HEIGHT);
		buttonPanel.setLayout(new GridBagLayout());
		makeOpaque(buttonPanel);
		
		viewItemButton = new JButton("View Details");
		buttonPanel.add(viewItemButton);
		
		this.add(buttonPanel);
	}
	
	private String porouswareReadout(boolean porouwareStatus) {
		if(porouwareStatus) {
			return "Yes";
		} else {
			return "No";
		}
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
		ImageIcon icon = iconLoader.createImageIcon("src/main/resources/images/default.png", IMAGE_SIZE, IMAGE_SIZE);
		return icon;
	}
	
	public void resizeEverything(int newWidth) {
		this.WIDTH = newWidth;
		setFinalSize(this, WIDTH, HEIGHT);
		setFinalSize(infoPanel, this.WIDTH*3/6, HEIGHT);
		setFinalSize(imagePanel, this.WIDTH*2/6, HEIGHT);
		setFinalSize(buttonPanel, WIDTH/6, HEIGHT);
		
		this.repaint();
		this.revalidate();
	}
	
	public int getID() {
		return productID;
	}
	public String getName() {
		return productName;
	}
	
	private void setHoverBackground() {
		if(item.isDiscontinued()) {
			setBackground(discontinuedHoverBackgroundColor);
		} else {
			setBackground(hoverBackgroundColor);
		}
		repaint();
		revalidate();
	}
	

	private void setNormalBackground() {
		if(item.isDiscontinued()) {
			setBackground(discontinuedBackgroundColor);
		} else {
			setBackground(backgroundColor);
		}
		repaint();
		revalidate();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		ItemGUI itemGUI = new ItemGUI(this.productID);
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setHoverBackground();
	}
	@Override
	public void mouseExited(MouseEvent e) {

		setNormalBackground();
	}
}
