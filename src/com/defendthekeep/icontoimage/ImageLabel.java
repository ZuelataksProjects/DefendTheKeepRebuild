package com.defendthekeep.icontoimage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {

	private static final long serialVersionUID = -3001426493464513168L;

	public ImageLabel(String img) {
	    this(new ImageIcon(img));
	  }

	  public ImageLabel(ImageIcon icon) {
	    setIcon(icon);
	    // setMargin(new Insets(0,0,0,0));
	    setIconTextGap(0);
	    // setBorderPainted(false);
	    setBorder(null);
	    setText(null);
	    setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
	  }
}