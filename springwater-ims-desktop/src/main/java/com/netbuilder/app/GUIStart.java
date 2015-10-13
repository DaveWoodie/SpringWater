package com.netbuilder.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;


public class GUIStart extends JFrame implements ActionListener {
	private LoginFrame lFrame;
	private MainFrame mFrame;
	
	public static void main(String[] args) {
		GUIStart gStart = new GUIStart();
	}

	public GUIStart()
	{
		initSetup();
	}
	
	private void initSetup()
	{	
		setTitle("Inventory Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginSetup();
		setVisible(true);
	}
	
	private void loginSetup()
	{
		this.getContentPane().removeAll();
		lFrame = new LoginFrame(this);
		setResizable(false);
		this.getContentPane().add(lFrame);
		setMinimumSize(null);
		pack();
		setLocationRelativeTo(null);	
	}
	
	private void mainFrameSetup() 
	{	
		this.getContentPane().remove(lFrame);  
		mFrame = new MainFrame(this);
		setResizable(true);
		this.getContentPane().add(mFrame);
        pack();
        setMinimumSize(new Dimension(620, 860));
		setLocationRelativeTo(null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		mainFrameSetup();
	}

	public void revertToLogin() {
		loginSetup();
	}

}
