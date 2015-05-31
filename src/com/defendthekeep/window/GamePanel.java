package com.defendthekeep.window;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import com.defendthekeep.icontoimage.ImageConverter;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

	private static final long serialVersionUID = -8590849790367994162L;
	
	private BufferedImage image;
	private BufferedImage image2;
	private BufferedImage image3;
	public JPanel pane;

	Image archerImage = ImageConverter.getConvertedImage("Archer.png");
	public int imageX = 886;
	public int imageY = 360;

	Image knightImage = ImageConverter.getConvertedImage("Knight.png");
	public int imageX2 = 400;
	public int imageY2 = 400;

	public GamePanel() {
		Thread t = new Thread();
		t.start();
	}

	public JPanel createGamePanel() {

		try {
			image = ImageIO.read(new File("src/GameBackground.png"));
			image2 = ImageIO.read(new File("src/Archer.png"));
			image3 = ImageIO.read(new File("src/Knight.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setSize(1040, 804);
		setFocusable(true);
		requestFocus();
		setFocusTraversalKeysEnabled(false);		
		
		return this;
	}
	
	public void paintComponent(Graphics g) {

			super.paintComponent(g); // This places an on the screen at the desired position. so that you can now put what you want.

			g.drawImage(image, 0, 0, null); // This places an on the screen at the desired position.
			g.drawImage(image2, imageX, imageY, null); // This places an on the screen at the desired position.
			g.drawImage(image3, imageX2, imageY2, null); // This places an on the screen at the desired position.
	}
	
	@Override
	public void run() {		
		while(true){
			repaint();
		}				
	}	
}
