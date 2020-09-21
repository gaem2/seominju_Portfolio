package com.kh.mini.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.game.SearchGame;

public class Loading extends JPanel{
	Image image;
	JLabel lb;
	public Loading () {

		image = new ImageIcon("DB/image/로딩.gif").getImage().getScaledInstance(1200, 900, 0);
	      lb = new JLabel(new ImageIcon(image));
	      this.setSize(1200,900);      
	      this.setLocation(0,0);
	      this.add(lb);    
	}

}
