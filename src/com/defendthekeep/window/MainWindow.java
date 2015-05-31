package com.defendthekeep.window;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

import com.defendthekeep.keychecker.KeyCheckPlayer;
import com.defendthekeep.music.Sounds;

public class MainWindow {

	private final int FRAME_WIDTH = 1040;
	private final int FRAME_HEIGHT = 804;
	
	private String music = "src/Music.wav";
	
	public JFrame jFrame = new JFrame();
	public ControlPanel cp;
	public MenuPanel mp;
	public GamePanel gp;
	public int score = 0;
	
	public MainWindow(){
		new Sounds(music);
	}
	
	public void createFrame(){
		
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		
		jFrame.setTitle("Defend the Keep");
		jFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		jFrame.setLocation(screenSize.width / 2 - screenSize.width / 4, (screenSize.height/2) - (FRAME_HEIGHT/2));
		//jFrame.setResizable(false);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.addKeyListener(new KeyCheckPlayer());
		mp = new MenuPanel();
		cp = new ControlPanel();
		gp = new GamePanel();
		Container cont = new Container();
		cont.add(cp.createControlPanel());
		cont.add(mp.createMenuPanel());
		cont.add(gp.createGamePanel());
		jFrame.getContentPane().add(cont);
		cp.pane.setVisible(false);
		gp.setVisible(false);		
		jFrame.setVisible(true);
		
		while(true){
			gp.gpUpdate();
			mainWindowupdate();
			
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

	}
	
	public void mainWindowupdate(){
		if(KeyCheckPlayer.keysCheck(KeyEvent.VK_UP)){
			if (gp.archerImageY > 25 && gp.archerImageY + 25 > 25) {
				gp.archerImageY -= 15;
				gp.repaint();;
				System.out.println("archer up");
			}
		}
		if(KeyCheckPlayer.keysCheck(KeyEvent.VK_DOWN)){
			if (gp.archerImageY < 730 && gp.archerImageY + 25 < 730) {
				gp.archerImageY += 15;
				gp.gpUpdate();;
				System.out.println("archer down");
			}
		}
		else if(KeyCheckPlayer.keysCheck(KeyEvent.VK_RIGHT)){
			gp.counter.setText("Score : " + Integer.toString(score++));
			gp.gpUpdate();
		}
		
	}
}

//	@Override
//	public void keyPressed(KeyEvent e) {
//		int key = e.getKeyCode();
//
//		if (key == KeyEvent.VK_A) {
//			if (gp.archerImageY > 25 && gp.archerImageY + 25 > 25) {
//				gp.archerImageY -= 25;
//				gp.gpUpdate();;
//				System.out.println("archer up");
//			}
//		}
//		if (key == KeyEvent.VK_B) {
//			if (gp.archerImageY < 730 && gp.archerImageY + 25 < 730) {
//				gp.archerImageY += 25;
//				gp.gpUpdate();;
//				System.out.println("archer down");
//			}
//		}
//		else if(key == KeyEvent.VK_C){
//			gp.counter.setText("Score : " + Integer.toString(score++));
//			gp.gpUpdate();
//		}
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		int key = e.getKeyCode();
//
//		if (key == KeyEvent.VK_UP) {
//		}
//		if (key == KeyEvent.VK_DOWN) {
//		}		
//	}
//
//	@Override
//	public void keyTyped(KeyEvent e) {	
//	}
//}
