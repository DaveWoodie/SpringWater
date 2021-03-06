/**
 * @author abutcher
 * @date 13/10/2015
 */

package com.netbuilder.app;

import java.awt.Dimension;

import javax.jms.JMSException;
import javax.swing.JFrame;



@SuppressWarnings("serial")
public class GUIStart extends JFrame {
	private LoginGUI lFrame;
	private static MainGUI mFrame;

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		GUIStart gStar1t = new GUIStart();
	}
 
	/**
	 * Sets up the GUI frame
	 */
	public GUIStart() {
		initSetup();
	}

	/**
	 * sets initial settings for frame
	 */
	private void initSetup() {
		setTitle("Inventory Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginSetup();
		
	}

	/**
	 * sets up the frame for login
	 */
	private void loginSetup() {
		setVisible(false);
		this.getContentPane().removeAll();
		lFrame = new LoginGUI(this);
		setResizable(false);
		this.getContentPane().add(lFrame);
		setMinimumSize(null);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * sets up the frame for the main content
	 */
	private void mainGUISetup(String userID) {
		setVisible(false);
		this.getContentPane().removeAll();
		mFrame = new MainGUI(this, userID);
		setResizable(true);
		this.getContentPane().add(mFrame);
		pack();
		setMinimumSize(new Dimension(600, 800));
		setLocationRelativeTo(null);
		setVisible(true);

	}

	/**
	 * calls the settings for main
	 */
	public void revertToMain(String userID) {
		mainGUISetup(userID);
		createListener();
	}
	
	/**
	 * calls the settings for login
	 */
	public void revertToLogin() {
		try {
			mFrame.connection.close();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loginSetup();
	}
	
	public void createListener() {
		mFrame.createBackendConnection();
		try {
			mFrame.consumer.setMessageListener(mFrame);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
		} catch (NullPointerException npe) {
			
		}
	}

}

