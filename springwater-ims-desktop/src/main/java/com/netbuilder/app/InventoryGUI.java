package com.netbuilder.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Searchable inventory list
 * @author tstacey
 * @date 09/10/2015
 */
public class InventoryGUI extends JPanel implements ActionListener {
	
	private int WIDTH = 600;
	private int HEIGHT = 800;

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	private JPanel scrollPanel;
	
	private JPanel searchPanel;
	private JPanel searchFieldPanel;
	private JPanel searchButtonPanel;
	
	private JTextField searchField;
	private JButton searchButton;
	
	public static void main(String[] args) {
		
		JFrame w = new JFrame();
		
		InventoryGUI inv = new InventoryGUI();
		w.add(inv);
		w.pack();
        w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		w.setVisible(true);

	}
	
	public InventoryGUI() {
		
		initialSetup();
		
	}
	
	private void initialSetup() {
		setAbsoluteSize(this, WIDTH, HEIGHT);
		
		addSearchPanel();
		
		addInventoryList();
	}
	
	private void addSearchPanel() {
		searchPanel = new JPanel();
		setAbsoluteSize(searchPanel, WIDTH, HEIGHT/12);
		setBorder(searchPanel, new Color(0,0,0));
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		
		searchFieldPanel = new JPanel();
		addSearchFieldPanel();
		
		searchButtonPanel = new JPanel();
		addSearchButtonPanel();
		
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
	
	private void addSearchFieldPanel() {
		setAbsoluteSize(searchFieldPanel, WIDTH*11/16, HEIGHT/12);
		setBorder(searchFieldPanel, new Color(100,50,240));
		searchFieldPanel.setLayout(new GridBagLayout());
		addSearchField();
		searchPanel.add(searchFieldPanel);
	}
	
	private void addSearchField() {
		searchField = new JTextField(15);
        Font searchFont = searchField.getFont().deriveFont(Font.PLAIN, 30f);
        searchField.setFont(searchFont);
        TextPrompt tP = new TextPrompt("Search for item...", searchField);
		searchFieldPanel.add(searchField);
		
	}
	
	private void addSearchButtonPanel() {
		setAbsoluteSize(searchButtonPanel, WIDTH*1/4, HEIGHT/12);
		setBorder(searchButtonPanel, new Color(100,240,100));
		searchButtonPanel.setLayout(new GridBagLayout());
		
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		searchButtonPanel.add(searchButton);
		
		searchPanel.add(searchButtonPanel);
	}
	
	private void addInventoryList() {
		scrollPanel = new JPanel();
		this.scrollPane = new JScrollPane(scrollPanel);
		
		scrollPane.setPreferredSize(new Dimension(WIDTH, HEIGHT*10/12));
		scrollPane.setMaximumSize(new Dimension(WIDTH, HEIGHT*10/12));
		scrollPane.setMinimumSize(new Dimension(WIDTH, HEIGHT*10/12));
		
		scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.Y_AXIS));
		
		for(int i = 0; i < 10; i++) {
			scrollPanel.add(new InventoryItem(this, WIDTH*10/12, i, "Test", 50, "2B", null));
		}
		
		this.add(scrollPane);
		scrollPanel.setVisible(true);
		scrollPanel.repaint();
		scrollPanel.revalidate();
	}
	
	// InventoryGUI src, int width, int productID, String productName, int quantity, String location, String imageLocation
	
	
	
	private void filterResults(String searchText) {
		// TODO: fill out filter method to refine inventory display based on search field
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(searchButton)) {
			filterResults(searchField.getText());
		}	
	}
}
