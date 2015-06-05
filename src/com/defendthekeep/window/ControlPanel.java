package com.defendthekeep.window;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ControlPanel{
	
	private BufferedImage image;
	public JPanel pane;

	public ControlPanel(){
				
	}
	
	public JPanel createControlPanel(){
		
		try {
			image = ImageIO.read(new File("src/Controls.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pane = new JPanel() {

			private static final long serialVersionUID = -6379705495600305969L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        };
        pane.setSize(1040, 804);
        pane.addMouseListener(new MouseDetectionControl());
        
       // pane.addMouseListener(new MouseDetection(this));
		return pane;
	}
		
}
