package com.defendthekeep.enemy;

import java.awt.Graphics;

import com.defendthekeep.window.GamePanel;

public class Enemy extends GamePanel implements Runnable {
	
	public int knightImageY;

	private static final long serialVersionUID = -5644079102702569233L;

	public Enemy(int knightImageY){
		this.knightImageY = knightImageY;
		Thread t = new Thread();
		t.start();
	}
	
	
	@Override
	public void run() {
		while(true){
			knightImageY = (int)(Math.random() * 700 + 1);
			repaint();
		}
		
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {

			super.paintComponent(g); // This places an on the screen at the desired position. so that you can now put what you want.

			g.drawImage(knightImage, knightImageX, knightImageY, null); // This places the knights position.
	}

}
