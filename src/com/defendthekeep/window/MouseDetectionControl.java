package com.defendthekeep.window;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.defendthekeep.main.Main;

public class MouseDetectionControl extends MouseAdapter {

	final private int MENU_LOW_X = 105;
	final private int MENU_HIGH_X = 297;
	final private int MENU_LOW_Y = 638;
	final private int MENU_HIGH_Y = 728;

	
	public MouseDetectionControl(){
		
	}
	public void mousePressed(MouseEvent e) {
		    		
			if(e.getX() > (MENU_LOW_X) && e.getX() < (MENU_HIGH_X) && e.getY() > (MENU_LOW_Y) && e.getY() < (MENU_HIGH_Y)) {
				//System.out.println("Control pressed");
				Main.mw.cp.pane.setVisible(false);
				Main.mw.mp.pane.setVisible(true);
			}
		}	
	}


