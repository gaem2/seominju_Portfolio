package com.kh.mini.view;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.game.SearchGame;

public class MainPan extends JPanel{
  
   private Image image;
   private JLabel lb;
  
   
   public MainPan() {


      PanelSetting();   
      RankButton();
      SearchButton();
      RecommendButton();
      MapButton();
      gameButton();
   }

   void PanelSetting() {
      image = new ImageIcon("DB/BeerImage/main.gif").getImage().getScaledInstance(1200, 900, 0);
      lb = new JLabel(new ImageIcon(image));
      this.setSize(1200,900);      
      this.setLocation(0,0);
      this.add(lb);      
   }

   void RankButton() {
      image = new ImageIcon("DB/BeerImage/Rank.png").getImage().getScaledInstance(316, 93, 0);
      JButton rb = new JButton(new ImageIcon(image));
      rb.setBounds(50,300,316,93);
      rb.setCursor(new Cursor(Cursor.HAND_CURSOR));
      lb.add(rb);

      rb.addMouseListener(new MouseListener() {

         @Override
         public void mouseReleased(MouseEvent e) {

         }

         @Override
         public void mousePressed(MouseEvent e) {

         }

         @Override
         public void mouseExited(MouseEvent e) {
            image = new ImageIcon("DB/BeerImage/Rank.png").getImage().getScaledInstance(316, 93, 0);
            rb.setIcon(new ImageIcon(image));


         }

         @Override
         public void mouseEntered(MouseEvent e) {
            image = new ImageIcon("DB/BeerImage/Rank_after.png").getImage().getScaledInstance(316, 93, 0);
            rb.setIcon(new ImageIcon(image));
            Play("DB/BeerImage/btn.wav");

         }

         @Override
         public void mouseClicked(MouseEvent e) {
            MainFrame.state =2;
         }
      });

   }

   void SearchButton() {
      image = new ImageIcon("DB/BeerImage/Search.png").getImage().getScaledInstance(316, 93, 0);
      JButton sb = new JButton(new ImageIcon(image));
      sb.setBounds(50,420,316,93);
      sb.setCursor(new Cursor(Cursor.HAND_CURSOR));
      lb.add(sb);

      sb.addMouseListener(new MouseListener() {

         @Override
         public void mouseReleased(MouseEvent e) {

         }

         @Override
         public void mousePressed(MouseEvent e) {

         }

         @Override
         public void mouseExited(MouseEvent e) {
            image = new ImageIcon("DB/BeerImage/Search.png").getImage().getScaledInstance(316, 93, 0);
            sb.setIcon(new ImageIcon(image));
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            image = new ImageIcon("DB/BeerImage/Search_after.png").getImage().getScaledInstance(316, 93, 0);
            sb.setIcon(new ImageIcon(image));
            Play("DB/BeerImage/btn.wav");

         }

         @Override
         public void mouseClicked(MouseEvent e) {
            MainFrame.state =3;
         }
      });

   }
   
   void RecommendButton() {
      image = new ImageIcon("DB/BeerImage/Recommend.jpg").getImage().getScaledInstance(316, 93, 0);
      JButton rb = new JButton(new ImageIcon(image));
      rb.setBounds(50,540,316,93);
      rb.setCursor(new Cursor(Cursor.HAND_CURSOR));
      lb.add(rb);

      rb.addMouseListener(new MouseListener() {

         @Override
         public void mouseReleased(MouseEvent e) {}

         @Override
         public void mousePressed(MouseEvent e) {}

         @Override
         public void mouseExited(MouseEvent e) {
            image = new ImageIcon("DB/BeerImage/Recommend.jpg").getImage().getScaledInstance(316, 93, 0);
            rb.setIcon(new ImageIcon(image));
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            image = new ImageIcon("DB/BeerImage/Recommend_after.jpg").getImage().getScaledInstance(316, 93, 0);
            rb.setIcon(new ImageIcon(image));
            Play("DB/BeerImage/btn.wav");

         }

         @Override
         public void mouseClicked(MouseEvent e) {
            MainFrame.state =4;
         }
      });
   }
   
   void MapButton() {
      image = new ImageIcon("DB/BeerImage/Mapbt.png").getImage().getScaledInstance(316, 93, 0);
      JButton rb = new JButton(new ImageIcon(image));
      rb.setBounds(50,650,316,93);  
      rb.setCursor(new Cursor(Cursor.HAND_CURSOR));
      lb.add(rb);

      rb.addMouseListener(new MouseListener() {

         @Override
         public void mouseReleased(MouseEvent e) {}

         @Override
         public void mousePressed(MouseEvent e) {}

         @Override
         public void mouseExited(MouseEvent e) {
            image = new ImageIcon("DB/BeerImage/Mapbt.png").getImage().getScaledInstance(316, 93, 0);
            rb.setIcon(new ImageIcon(image));
         }

         @Override
         public void mouseEntered(MouseEvent e) {
            image = new ImageIcon("DB/BeerImage/Mapbt_after.png").getImage().getScaledInstance(316, 93, 0);
            rb.setIcon(new ImageIcon(image));
            Play("DB/BeerImage/btn.wav");

         }

         @Override
         public void mouseClicked(MouseEvent e) {
            MainFrame.state =5;
         }
      });
   }
   
   void gameButton() {
	      JButton rb = new JButton();
	      rb.setBounds(560,220,200,200);  
	      rb.setOpaque(false);
	      rb.setContentAreaFilled(false);
	      rb.setBorderPainted(false);
	      rb.setCursor(new Cursor(Cursor.HAND_CURSOR));
	      lb.add(rb);

	      rb.addMouseListener(new MouseListener() {

	         @Override
	         public void mouseReleased(MouseEvent e) {}

	         @Override
	         public void mousePressed(MouseEvent e) {}

	         @Override
	         public void mouseExited(MouseEvent e) {
	         }

	         @Override
	         public void mouseEntered(MouseEvent e) {
	            Play("DB/BeerImage/btn.wav");

	         }

	         @Override
	         public void mouseClicked(MouseEvent e) {
	            
	            	new SearchGame();
	            	
	          
	         }
	      });
   }
   
 
   
   
   
   void Play(String fileName){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(fileName));
            Clip clip = AudioSystem.getClip();
            clip.stop();
            clip.open(ais);
            clip.start();
        }catch (Exception ex){
           ex.printStackTrace();
        }
    }



}   