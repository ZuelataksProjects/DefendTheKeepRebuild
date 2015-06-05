package com.defendthekeep.enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;


public class Enemy extends JPanel implements Runnable {
	
	public BufferedImage knightImage;
	public int knightImageX;
	public int knightImageY = (int)(Math.random() * 700 + 1);

	private static final long serialVersionUID = -5644079102702569233L;

	public Enemy(BufferedImage knightImage,int knightImageX){
		setSize(1040, 804);
		this.knightImage = knightImage;
		this.knightImageX = knightImageX;
	
		Thread t = new Thread();
		t.start();
	}
	
	public BufferedImage getKnightImage(){
		return knightImage;
	}
	public int getKnightImageX(){
		return knightImageX;
	}
	public int getKnightImageY(){
		return knightImageY;
	}
	
	@Override
	public void run() {
		while(true){
			knightImageX += 100;
			
		}	
	}
		
	@Override
	public void paintComponent(Graphics g) {

			super.paintComponent(g); // This places an on the screen at the desired position. so that you can now put what you want.

			g.drawImage(knightImage, knightImageX, knightImageY, null); // This places the knights position.
	}

}
