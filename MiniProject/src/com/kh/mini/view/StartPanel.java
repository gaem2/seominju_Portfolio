package com.kh.mini.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class StartPanel extends JPanel {
	JLabel lb;
	public StartPanel() {
		Image myImg = new ImageIcon("DB/image/bg0.jpg").getImage().getScaledInstance(1200, 900, 0);
		lb = new JLabel(new ImageIcon(myImg));

		JLabel text = new JLabel("성인이십니까?");
		text.setBounds(300, 150, 1000, 200);
		lb.add(text);
		text.setForeground(new Color(255,255,255));
		text.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 100));

		JButton btn1 = new JButton("YES");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckZumin();
			}
		});
		btn1.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 50));
		btn1.setBounds(254, 600, 250, 100);
		lb.add(btn1);

		JButton btn2 = new JButton("NO");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btn2.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 50));
		btn2.setBounds(773, 600, 250, 100);
		lb.add(btn2);
	
		this.add(lb);
		this.setBounds(0,0,1200,900);
		this.setVisible(true);
	}

	class CheckZumin extends JDialog{
		JTextField[] tf = new JTextField[2];
		JButton okBtn;
		JLabel[] lb = new JLabel[2];


		public CheckZumin() {
			tf[0] = new JTextField(6);
			tf[0].setSize(50,30);
			tf[1] = new JPasswordField(7);
			tf[1].setSize(50,30);
			tf[1].addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == 10) {
						calc();					
					}
				}
			});

			okBtn = new JButton("OK");
			okBtn.setSize(20,20);
			okBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 calc();
				}
			});


			lb[0] = new JLabel("주민번호");
			lb[0].setSize(10,10);
			lb[1] = new JLabel("-");
			lb[1].setSize(10,10);
			
			this.setLayout(new FlowLayout());
			this.add(lb[0]);
			this.add(tf[0]);
			this.add(lb[1]);
			this.add(tf[1]);
			this.add(okBtn);
			this.setBounds(700, 400, 400, 100);
			//this.setUndecorated(true);
			this.setVisible(true);
		}

	
		void exit() {
			this.setVisible(false);
		}
		
		void calc() {
			String str;
			char[] ch;
			str = tf[0].getText();
			str += "-";
			ch = ((JPasswordField)tf[1]).getPassword();
			str += new String(ch);	
			System.out.println(checkzuminRG(str));
			if(checkzuminRG(str)) {
				
				exit();
				MainFrame.state =1;
				
			}else {
				System.exit(0);
			}
		}
		
		
	}
	


	boolean checkzuminRG(String str) {//주민번호 확인 할고리즘

		int[] chk = {2,3,4,5,6,7,0,8,9,2,3,4,5};
		int sum = 0; 

		char[] ch = new char[3];
		ch[0] = str.charAt(0);
		ch[1] = str.charAt(1);
		ch[2] = str.charAt(7);
		int num= Character.getNumericValue(ch[0])*10+Character.getNumericValue(ch[1]);
		
		if((ch[2] == 3 && ch[0] !=0 && ch[1] != 0) 
		|| (ch[2] == 4 && ch[0] !=0 && ch[1] != 0)) {
			return false;
		}	
		if(str.length()!=14) {  
			return false; 
		} 
		for (int i=0; i<str.length()-1;i++){ 
			if(i==6) 
				continue; 
			sum += chk[i] *(str.charAt(i)-48);
		}
		int su = 11*(sum/11)+11-sum; 
		int bn = su-10*(su/10);
		if(bn==str.charAt(13)-48) { 
			return true;
			
		} else { 
			return false;
		}

	}

}