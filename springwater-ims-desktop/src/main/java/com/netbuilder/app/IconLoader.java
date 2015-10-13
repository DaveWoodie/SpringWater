package com.netbuilder.app;


import javax.swing.*;
import javax.imageio.*;

import java.awt.*;
import java.io.File;

/**
 * class with only one public method. Used to load images from file as icons, in order to insert them into JPanels
 * @author tstacey
 * @date 12/10/2015
 */

public class IconLoader {

	/**
	 * returns an image icon from the passed file path, scaled to the passed width and height
	 * @param path
	 * @param imageWidth
	 * @param imageHeight
	 * @return resized ImageIcon
	 */
	public ImageIcon createImageIcon(String path, int imageWidth, int imageHeight) {
		Image img = loadImage(path, imageWidth, imageHeight);
		img = resizeImage(img, imageWidth, imageHeight);
		ImageIcon icon = new ImageIcon(img);
		return icon;
	}
	
	private Image loadImage(String path, int imageWidth, int imageHeight) {
    	Image img;
    	try {
    		img = ImageIO.read(new File(path));
    	} catch (Exception e) {
    		System.out.println("***ERROR: Couldn't load image at: '"+path+"' in IconLoader class");
    		throw new Error(e);
    	}
    	return img;
	}

	// resizes an image so that it corresponds to the passed size
	private Image resizeImage(Image imgToResize, int imageWidth, int imageHeight) {
		imgToResize = imgToResize.getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
		return imgToResize;
	}

}

