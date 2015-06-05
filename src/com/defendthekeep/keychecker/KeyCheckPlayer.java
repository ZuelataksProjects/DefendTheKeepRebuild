package com.defendthekeep.keychecker;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyCheckPlayer implements KeyListener {
	
	private static boolean keys[] = new boolean[100];
	
	public static boolean keysCheck(int keycode){
		if((keycode >= 0) && (keycode < keys.length)) return keys[keycode];
		else return false;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if((keyCode >= 0) && (keyCode < keys.length))keys[keyCode] = true;

		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if((keyCode >= 0) && (keyCode < keys.length))keys[keyCode] = false;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {

		
	}

}
