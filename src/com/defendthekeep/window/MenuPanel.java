package com.defendthekeep.window;

//import MouseDetection;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuPanel {

	private BufferedImage image;
	public JPanel pane;

	public MenuPanel() {

	}

	public JPanel createMenuPanel() {

		try {
			image = ImageIO.read(new File("src/menuImage.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pane = new JPanel() {

			private static final long serialVersionUID = -4574520763655452619L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(image, 0, 0, null);
			}
		};
		pane.setSize(1040, 804);

		pane.addMouseListener(new MouseDetectionMenu());
		return pane;
	}
}
