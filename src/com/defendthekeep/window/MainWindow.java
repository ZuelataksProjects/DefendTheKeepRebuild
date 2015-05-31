package com.defendthekeep.window;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.defendthekeep.music.Sounds;

public class MainWindow implements KeyListener{

	private final int FRAME_WIDTH = 1040;
	private final int FRAME_HEIGHT = 804;
	public JFrame jFrame = new JFrame();
	public ControlPanel cp;
	public MenuPanel mp;
	public GamePanel gp;
	public String music = "src/Music.wav";
	
	public int contentWidth = jFrame.getContentPane().getWidth();
	public int contentHeight = jFrame.getContentPane().getHeight();
	
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
		jFrame.addKeyListener(this);
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
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		System.out.println("ddfdfdf");

		if (key == KeyEvent.VK_UP) {
			// UpMove = true;

			if (gp.imageY > 25 && gp.imageY + 25 > 25) {
				gp.imageY -= 25;
				gp.repaint();
				System.out.println("ddfdfdf");
			}
		}
		else if (key == KeyEvent.VK_DOWN) {
			// DownMove = true;

			if (gp.imageY < 730 && gp.imageY + 25 < 730) {
				gp.imageY += 25;
				gp.repaint();
			}

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
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
