package com.netbuilder.app;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GUIStart extends JFrame {
	private LoginFrame lFrame;
	private MainFrame mFrame;

	public static void main(String[] args) {
		GUIStart gStart = new GUIStart();
	}

	public GUIStart() {
		initSetup();
	}

	private void initSetup() {
		setTitle("Inventory Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginSetup();
		setVisible(true);
	}

	private void loginSetup() {
		this.getContentPane().removeAll();
		lFrame = new LoginFrame(this);
		setResizable(false);
		this.getContentPane().add(lFrame);
		setMinimumSize(null);
		pack();
		setLocationRelativeTo(null);
	}

	private void mainFrameSetup() {
		this.getContentPane().removeAll();
		mFrame = new MainFrame(this);
		setResizable(true);
		this.getContentPane().add(mFrame);
		pack();
		setMinimumSize(new Dimension(620, 860));
		setLocationRelativeTo(null);
	}

	public void revertToMain() {
		mainFrameSetup();
	}

	public void revertToLogin() {
		loginSetup();
	}

}
