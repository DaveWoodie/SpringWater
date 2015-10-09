package com.netbuilder.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * Searchable inventory list
 * @author tstacey
 * @date 09/10/2015
 */
public class InventoryGUI extends JPanel {
	
	private int WIDTH = 600;
	private int HEIGHT = 800;

	private static final long serialVersionUID = 1L;

	private JScrollPane scrollPane;
	
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
	}
	
	private void addSearchPanel() {
		searchPanel = new JPanel();
		setAbsoluteSize(searchPanel, WIDTH, HEIGHT/12);
		setBorder(searchPanel, new Color(0,0,0));
		searchPanel.setLayout(new BoxLayout(searchPanel, BoxLayout.X_AXIS));
		
		searchFieldPanel = new JPanel();
		setAbsoluteSize(searchFieldPanel, WIDTH*3/4, HEIGHT/12);
		setBorder(searchFieldPanel, new Color(100,50,240));
		searchFieldPanel.setLayout(new GridBagLayout());
		
		searchField = new JTextField(10);
		TextPrompt tp = new TextPrompt("Search for Item...", searchField); 
		searchFieldPanel.add(searchField);
		
		
		searchPanel.add(searchFieldPanel);
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

}
