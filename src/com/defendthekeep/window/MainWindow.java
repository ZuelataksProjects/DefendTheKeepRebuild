package com.defendthekeep.window;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.defendthekeep.music.Sounds;

public class MainWindow{

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
}
