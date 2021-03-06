package com.netbuilder.app;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import connections.MongoPull;
import entities.Item;
import loaders.ItemLoader;

/**
 * Searchable inventory list
 * @author tstacey
 * @date 09/10/2015
 */
@SuppressWarnings("serial")
public class InventoryGUI extends JPanel implements ActionListener, ComponentListener {
	
	private int WIDTH = 580;
	private int HEIGHT = 800;
	private int ITEM_WIDTH = WIDTH/2;
	private int SEARCH_PANEL_HEIGHT = 66;
	private int SIDE_PADDING = 20;

	private JScrollPane scrollPane;
	private JPanel scrollPanel;
	
	
	private JPanel searchPanel;
	private JPanel searchFieldPanel;
	private JPanel searchButtonPanel;
	private JPanel addNewItemButtonPanel;
	private JPanel refreshButtonPanel;
	
	private JTextField searchField;
	private JButton searchButton;
	private JButton addNewItemButton;
	private JButton refreshButton;
	
	private ArrayList<InventoryItemFrame> items = new ArrayList<InventoryItemFrame>();
	
	private ArrayList<InventoryItemFrame> filteredItems = new ArrayList<InventoryItemFrame>();
	
	private ArrayList<InventoryItemFrame> currentlyDisplayedItems = items;
	
	private int currentColumns = 1;
	
	private ItemLoader loader = new ItemLoader();
	
	// Placeholder Data
	private LoadData placeHolders = new LoadData();
	
//	public static void main(String[] args) {
//		
//		JFrame w = new JFrame();
//		
//		InventoryGUI inv = new InventoryGUI();
//		w.add(inv);
//		w.pack();
//        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		w.setVisible(true);
//
//	}
//	
	public InventoryGUI() {
		
		initialSetup();
		
		this.addComponentListener(this);
		
	}
	
	private void initialSetup() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		addSearchPanel();
		
		addInventoryList();
		
	}
	
	
	private void resizeEverything() {
		
		this.HEIGHT = this.getHeight();
		this.WIDTH = this.getWidth()-SIDE_PADDING;
		
		setAbsoluteSize(this, WIDTH, HEIGHT);
		setAbsoluteSize(searchPanel, WIDTH, SEARCH_PANEL_HEIGHT);
		searchPanel.repaint();
		searchPanel.revalidate();
		setAbsoluteSize(searchFieldPanel, WIDTH*2/5, SEARCH_PANEL_HEIGHT);
		setAbsoluteSize(searchButtonPanel, WIDTH*2/15, SEARCH_PANEL_HEIGHT);
		setAbsoluteSize(refreshButtonPanel, WIDTH*2/15, SEARCH_PANEL_HEIGHT);
		setAbsoluteSize(addNewItemButtonPanel, WIDTH*3/15, SEARCH_PANEL_HEIGHT);

		setAbsoluteSize(scrollPane, WIDTH, HEIGHT-SEARCH_PANEL_HEIGHT);
		
		fillContentPanelsBasedOnSize();
		
		
	}
	
	/**
	 * Splits the InventoryItems scrollpane based on the width of the container and adds the inventory item objects in columns to match
	 */
	private void fillContentPanelsBasedOnSize() {
		int totalWidth = this.WIDTH;
		if(totalWidth/ITEM_WIDTH != currentColumns) {
			int newColumns = totalWidth/ITEM_WIDTH;
			int remainder = 0;
			if(newColumns != 0) {
				remainder = currentlyDisplayedItems.size()%newColumns;
			}
			scrollPanel.removeAll();
			int total = 0;
			for(int i = 0; i < newColumns; i++) {
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS) );
				panel.setAlignmentY(Component.TOP_ALIGNMENT);
				scrollPanel.add(panel);
				int limit = currentlyDisplayedItems.size()/newColumns;
				if(i < remainder) {
					limit++;
				}
				for(int j = 0; j < limit && total < currentlyDisplayedItems.size(); j++) {
					panel.add(currentlyDisplayedItems.get(total) );
					total++;
				}
			}
		}
		scrollPanel.repaint();
		scrollPanel.revalidate();
	}
	
	
	private void addSearchPanel() {
		searchPanel = new JPanel();
		setAbsoluteSize(searchPanel, WIDTH, SEARCH_PANEL_HEIGHT);
		setBorder(searchPanel, new Color(0,0,0));
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		
		
		searchFieldPanel = new JPanel();
		addSearchFieldPanel();
		
		searchButtonPanel = new JPanel();
		addSearchButtonPanel();
		
		refreshButtonPanel = new JPanel();
//		addRefreshButtonPanel();
		
		addNewItemButtonPanel = new JPanel();
		addAddNewItemButtonPanel();
		
		this.add(searchPanel);
		
		
		
	}
	
	
	private void setBorder(JPanel panel ,Color c) {
		panel.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, c));
	}
	
	private void setAbsoluteSize(JPanel panel, int width, int height) {
		panel.setPreferredSize(new Dimension(width, height));
		panel.setMaximumSize(new Dimension(width, height));
		panel.setMinimumSize(new Dimension(width, height));
	}


	private void setAbsoluteSize(JScrollPane pane, int width, int height) {
		pane.setPreferredSize(new Dimension(width, height));
		pane.setMaximumSize(new Dimension(width, height));
		pane.setMinimumSize(new Dimension(width, height));
	}
	
	private void addSearchFieldPanel() {
		setAbsoluteSize(searchFieldPanel, WIDTH*2/5, SEARCH_PANEL_HEIGHT);
		searchFieldPanel.setLayout(new GridBagLayout());
		addSearchField();
		searchPanel.add(searchFieldPanel);
	}
	
	private void addSearchField() {
		searchField = new JTextField(13);
        Font searchFont = searchField.getFont().deriveFont(Font.PLAIN, 20f);
        searchField.setFont(searchFont);
        searchField.addActionListener(this);
        TextPrompt tP = new TextPrompt("Search for item...", searchField);
		searchFieldPanel.add(searchField);
		
	}
	
	private void addSearchButtonPanel() {
		setAbsoluteSize(searchButtonPanel, WIDTH*2/15, SEARCH_PANEL_HEIGHT);
		searchButtonPanel.setLayout(new GridBagLayout());
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		searchButtonPanel.add(searchButton);
		
		searchPanel.add(searchButtonPanel);
	}
	
	private void addRefreshButtonPanel() {
		setAbsoluteSize(refreshButtonPanel, WIDTH*2/15, SEARCH_PANEL_HEIGHT);
		refreshButtonPanel.setLayout(new GridBagLayout());
		
		refreshButton = new JButton("Refresh");
		refreshButton.addActionListener(this);
		refreshButtonPanel.add(refreshButton);
		
		searchPanel.add(refreshButtonPanel);
	}

	private void addAddNewItemButtonPanel() {
		setAbsoluteSize(addNewItemButtonPanel, WIDTH*3/15, SEARCH_PANEL_HEIGHT);
		addNewItemButtonPanel.setLayout(new GridBagLayout());
		
		addNewItemButton = new JButton("Add New Item");
		addNewItemButton.addActionListener(this);
		addNewItemButtonPanel.add(addNewItemButton);
		
		searchPanel.add(addNewItemButtonPanel);
	}
	
	private void addInventoryList() {
		
		scrollPanel = new JPanel();
		
		scrollPane = new JScrollPane(scrollPanel);
		
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.X_AXIS));
		
		addAllItems();

		setAbsoluteSize(scrollPane, WIDTH, HEIGHT-SEARCH_PANEL_HEIGHT);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		this.add(scrollPane);
		scrollPanel.setVisible(true);
		scrollPanel.repaint();
		scrollPanel.revalidate();
	}
	
	
	public void refresh() {
		currentlyDisplayedItems = items;
		addAllItems();
	}
	
	private void addAllItems() {
		items.clear();
		ArrayList<Item> loadedItems = loader.loadAllItems();
		for(Item i : loadedItems) {
			items.add(new InventoryItemFrame(this, ITEM_WIDTH, i));
			
		}
				
		fillContentPanelsBasedOnSize();
		
		
	}
	
	//InventoryItem(InventoryGUI src, int width, int productID, String productName, int quantity, String location, String imageLocation)
	
	private void filterResults(String searchText) {
		// TODO: fill out filter method to refine inventory display based on search field
		filteredItems = new ArrayList<InventoryItemFrame>();
		for(InventoryItemFrame i : items) {
			if(i.getName().toUpperCase().contains(searchText.toUpperCase())) {
				filteredItems.add(i);
			}
		}
		
		if(filteredItems.isEmpty()) {
			currentlyDisplayedItems = items;
		} else {
			currentlyDisplayedItems = filteredItems;
		}
		fillContentPanelsBasedOnSize();
		
		
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(searchButton) || e.getSource().equals(searchField)) {
			if(!searchField.getText().equals("")) {
				filterResults(searchField.getText());
			} else {
				refresh();
				fillContentPanelsBasedOnSize();
			}
		}
		else if(e.getSource().equals(addNewItemButton)) {
			AddItemFrame aif = new AddItemFrame();
			aif.setVisible(true);
		}
		else if(e.getSource().equals(refreshButton)) {
			refresh();
		}
	}

	public void componentResized(ComponentEvent e) {
		this.resizeEverything();
		
	}

	public void componentMoved(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentShown(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void componentHidden(ComponentEvent e) {
		// TODO Auto-generated method stub
		
	}
}
