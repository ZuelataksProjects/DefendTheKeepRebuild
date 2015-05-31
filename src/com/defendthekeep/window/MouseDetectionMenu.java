package com.defendthekeep.window;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.defendthekeep.main.Main;


public class MouseDetectionMenu extends MouseAdapter {
	final private int START_LOW_X = 52;
	final private int START_HIGH_X = 246;
	final private int START_LOW_Y = 359;
	final private int START_HIGH_Y = 426;
	
	final private int CONTROLS_LOW_X = 720;
	final private int CONTROLS_HIGH_X = 1016;
	final private int CONTROLS_LOW_Y = 359;
	final private int CONTROLS_HIGH_Y = 415;
	
	public MouseDetectionMenu(){		
	}
	public void mousePressed(MouseEvent e) {
		    
			if(e.getX() > (CONTROLS_LOW_X) && e.getX() < (CONTROLS_HIGH_X) && e.getY() > (CONTROLS_LOW_Y) && e.getY() < (CONTROLS_HIGH_Y)) {

				Main.mw.mp.pane.setVisible(false);
				Main.mw.cp.pane.setVisible(true);
			}
			else if(e.getX() > (START_LOW_X) && e.getX() < (START_HIGH_X) && e.getY() > (START_LOW_Y) && e.getY() < (START_HIGH_Y)) {

				Main.mw.mp.pane.setVisible(false);
				Main.mw.gp.setVisible(true);
			}
		}
	}


