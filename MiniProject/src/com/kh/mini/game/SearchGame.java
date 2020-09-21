package com.kh.mini.game;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.controller.BeerController;
import com.kh.mini.model.Beer;

public class SearchGame extends JDialog{
   BeerController bc = new BeerController();
   Beer[] br = bc.getBeerALL();
   JPanel jp ;
   JLabel character;
   JLabel[] enemy = new JLabel[100];
   String[] enemyStr = new String[100];
   String userStr = null;
   int Count = 0;
   int life = 5;
   JLabel[] lb= new JLabel[2];
   JLabel winlb;
   JLabel loselb;
   JLabel backlb;
   public SearchGame() {
      setting();

      new MakeEnemy().start();
      new EnemyMove().start();
      
      this.setVisible(true);
   }

   class EnemyMove extends Thread{

      @Override
      public void run() {
         int i=0;
         while(true) {
            try {
               Thread.sleep(5);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            for(i=0;i<100;i++) {
               if(enemy[i] != null) {
                  try{
                  enemy[i].setLocation(enemy[i].getX(), enemy[i].getY()+1);
                  if(enemy[i].getY() > 700) {
                     enemy[i] = null;
                     life--;
                     lb[1].setText("라이프 : " + life);
                     
                     if(life == 0) {
                        loselb.setVisible(true);
                        try {
                           Thread.sleep(3000);
                        } catch (InterruptedException e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                        }
                        exit();
                        
                     }
                  }
                  }catch(NullPointerException e) {
                     
                  }
               }
               if(Count == 5) {
                  winlb.setVisible(true);
                  try {
                     Thread.sleep(3000);
                  } catch (InterruptedException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                  }
                  exit();
               }
            }
         }
      }


   }

   class MakeEnemy extends Thread{

      @Override
      public void run() {
         int i =0;
         while(true) {
            
            for(i=0;i<100;i++) {
               try {
                  Thread.sleep(2500);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               
               int rand = (int)(Math.random()*79+1);
               enemyStr[i] = br[rand].getBeerName();
               Image img = br[rand].getBeerImage().getScaledInstance(100, 100, 0);
               
               rand = (int)(Math.random()*1100+1);
               enemy[i] = new JLabel(new ImageIcon(img));
               enemy[i].setBounds(rand,30, 100, 100);
               
               backlb.add(enemy[i]);
               
               
            }
         }
      }
   }


   void setting() {
      winlb = new JLabel("Win!!");
      winlb.setBounds(310,250,800,300);
      winlb.setBackground(Color.WHITE);
      winlb.setFont(new Font("고딕",Font.BOLD,200));
      winlb.setForeground(Color.BLUE);
      winlb.setVisible(false);
      loselb = new JLabel("Lose!!");
      loselb.setBounds(310,250,800,300);
      loselb.setBackground(Color.WHITE);
      loselb.setForeground(Color.red);
      loselb.setFont(new Font("고딕",Font.BOLD,200));
      loselb.setVisible(false);
      lb[0] = new JLabel("점수  : " +Count);
      lb[0].setBounds(0, 0, 150, 30);
      lb[0].setBackground(Color.WHITE);
      lb[0].setFont(new Font("고딕",Font.BOLD,30));
      lb[1] = new JLabel("라이프 : " + life);
      lb[1].setBounds(150, 0, 160, 30);
      lb[1].setBackground(Color.WHITE);
      lb[1].setFont(new Font("고딕",Font.BOLD,30));
      JTextField jText = new JTextField(20); 
      Image img = new ImageIcon("DB/image/gamebg0"+(int)(Math.random()*2+1)+".jpg").getImage().getScaledInstance(1200, 790, 0);
      backlb = new JLabel(new ImageIcon(img));
      backlb.setBounds(0, 0, 1200, 790);
      
      
      jText.setBounds(0,790, 1200, 70);
      jText.setFont(new Font("고딕",Font.BOLD,60));
      jText.setForeground(Color.WHITE);
      jText.setBackground(Color.BLACK);
      jText.requestFocus();
      jText.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
            //37 왼쪽 38 위 39 오른쪽 40 아래 10 엔터

            if(e.getKeyCode() == 10) {
   
               userStr = jText.getText();
               jText.setText("");
               
               
            
                  
               
               for(int i=0;i < 100;i++) {
                  if(enemy[i] !=null &&userStr.length()!=0&&enemyStr[i].contains(userStr)) {
                     enemyStr[i] =null;
                     enemy[i].setVisible(false);
                     enemy[i] =null;
                     Count++;
                     lb[0].setText("점수  : " +Count);
                     
                  }
               }

            }

         }
      });
      backlb.setLayout(null);
      backlb.add(loselb);
      backlb.add(winlb);
      backlb.add(lb[0]);
      backlb.add(lb[1]);
      this.add(jText);
      jp=new JPanel();
      jp.setLayout(null);
      jp.setBounds(0, 0, 1200, 790);
      jp.setVisible(true);
      jp.setBackground(Color.WHITE);
      jp.add(backlb);
      this.add(jp);
      this.setLayout(null);
      this.setBounds(300,100,1200,900);
      this.setVisible(true);
      //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


   }
   void exit() {
      this.setVisible(false);
   }
   

}
