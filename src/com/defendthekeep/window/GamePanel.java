package com.defendthekeep.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.defendthekeep.enemy.Enemy;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = -8590849790367994162L;
	
	//Images
	private BufferedImage gameBgrImage;
	private BufferedImage archerImage;
	public BufferedImage knightImage;
	
	//Start positions
	public int archerImageX = 886;
	public int archerImageY = 360;
	public int knightImageX = 100;
	//public int knightImageY = 400;
	public int knightImageY = (int)(Math.random() * 700 + 1);
	
	public JLabel counter;
	private String counterText;
	public int Score = 0;
	public double lastTime;
	
	Enemy[] enemy;
	List<Enemy> enemyList = new ArrayList<Enemy>(); 

	public GamePanel() {
	}

	public JPanel createGamePanel() {
		
		lastTime = System.currentTimeMillis();
		setSize(1040, 804);
		counter = new JLabel();
		counterText = "Score : " + Integer.toString(Score);
		counter.setText(counterText);
		counter.setBounds(400, 11, 360, 60);
		counter.setFont(counter.getFont().deriveFont(55f));
		add(counter);
		

		//add(en);
		

		try {
			gameBgrImage = ImageIO.read(new File("src/GameBackground.png"));
			archerImage = ImageIO.read(new File("src/Archer.png"));
			knightImage = ImageIO.read(new File("src/Knight.png"));
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//enemy = new Enemy[2];
		//enemy[0] = new Enemy(knightImage,knightImageX);
		//enemy[1] = new Enemy(knightImage,knightImageX);
		return this;
	}
	
	
	public void gpUpdate(){
		repaint();
		
	}
	
	
	
	@Override
	public void paintComponent(Graphics g) {

			super.paintComponent(g); // This places an on the screen at the desired position. so that you can now put what you want.

			g.drawImage(gameBgrImage, 0, 0, null); // This places the background at position 0,0.
			g.drawImage(archerImage, archerImageX, archerImageY, null); // This places the archers position.
			//g.drawImage(knightImage, knightImageX, knightImageY, null); // This places the knights position.
			//g.drawImage(enemy[0].knightImage, enemy[0].knightImageX, enemy[0].knightImageY, null);
			//g.drawImage(enemy[1].knightImage, enemy[1].knightImageX, enemy[1].knightImageY, null);
			//knightImageX += 10;
			if (System.currentTimeMillis() - lastTime > 2000) {
				enemyList.add(new Enemy(knightImage,knightImageX));
				//enemy[0] = new Enemy(knightImage,knightImageX);
				lastTime = System.currentTimeMillis();
				}
			
				for (Enemy e : enemyList) {
					e.knightImageX += 1;
					g.drawImage(e.knightImage, e.knightImageX, e.knightImageY, null);
				}

			
//			if( System.currentTimeMillis() - lastTime > 2000){					
//				System.out.println("test");
//			
//				g.drawImage(enemy[0].knightImage, enemy[0].knightImageX, enemy[0].knightImageY, null); // This places the knights position.
//				lastTime = System.currentTimeMillis();
//			
//			}
	   
	}
}

