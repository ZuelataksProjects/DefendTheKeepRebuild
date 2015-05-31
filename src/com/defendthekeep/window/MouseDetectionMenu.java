package com.defendthekeep.window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.defendthekeep.main.Main;


public class MouseDetectionMenu extends MouseAdapter {
	final private int START_LOW_X = 52;
	final private int START_HIGH_X = 246;
	final private int START_LOW_Y = 359;
	final private int START_HIGH_Y = 426;
	
	final private int MENU_LOW_X = 105;
	final private int MENU_HIGH_X = 297;
	final private int MENU_LOW_Y = 638;
	final private int MENU_HIGH_Y = 728;

	final private int CONTROLS_LOW_X = 720;
	final private int CONTROLS_HIGH_X = 1016;
	final private int CONTROLS_LOW_Y = 359;
	final private int CONTROLS_HIGH_Y = 415;
	
	public MouseDetectionMenu(){		
	}
	public void mousePressed(MouseEvent e) {
		    
			if(e.getX() > (CONTROLS_LOW_X) && e.getX() < (CONTROLS_HIGH_X) && e.getY() > (CONTROLS_LOW_Y) && e.getY() < (CONTROLS_HIGH_Y))
			{
				//System.out.println("Control pressed");
				Main.mw.mp.pane.setVisible(false);
				Main.mw.cp.pane.setVisible(true);
			}
			else if(e.getX() > (START_LOW_X) && e.getX() < (START_HIGH_X) && e.getY() > (START_LOW_Y) && e.getY() < (START_HIGH_Y))
			{
				//System.out.println("Start pressed");
				Main.mw.mp.pane.setVisible(false);
				Main.mw.gp.setVisible(true);
			}
			//check start button
//			else if(e.getX() > (START_LOW_X) && e.getX() < (START_HIGH_X) && e.getY() > (START_LOW_Y) && e.getY() < (START_HIGH_Y))
//			{
//				//System.out.println("Start pressed");
//				game.gameFlag = true;
//			}
		}
	
	}

