package com.defendthekeep.window;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import com.defendthekeep.icontoimage.ImageConverter;
import com.defendthekeep.main.Main;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements KeyListener, Runnable {

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
		// Main.mw.gp.pane.addKeyListener(this);

		addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				System.out.println("ddfdfdf");

				if (key == KeyEvent.VK_UP) {
					// UpMove = true;

					if (imageY > 25 && imageY + 25 > 25) {
						imageY -= 25;
						pane.repaint();
						System.out.println("ddfdfdf");
					}
				}
				else if (key == KeyEvent.VK_DOWN) {
					// DownMove = true;

					if (imageY < 730 && imageY + 25 < 730) {
						imageY += 25;
						pane.repaint();
					}

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

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
	

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		// Check if the left or right arrows were released so that we
		// will stop moving the rockets
		if (key == KeyEvent.VK_UP) {
			//UpMove = false;
		}
		if (key == KeyEvent.VK_DOWN) {
			//DownMove = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("ddfdfdf");

		if (key == KeyEvent.VK_UP) {
			// UpMove = true;

			if (imageY > 25 && imageY + 25 > 25) {
				imageY -= 25;
				repaint();
				System.out.println("ddfdfdf");
			}
		}
		else if (key == KeyEvent.VK_DOWN) {
			// DownMove = true;

			if (imageY < 730 && imageY + 25 < 730) {
				imageY += 25;
				repaint();
			}

		}

	}


}
