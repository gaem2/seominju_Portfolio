package com.kh.mini.view;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.model.*;
import com.kh.mini.view.MainFrame;
import com.kh.mini.controller.*;


public class Rank extends JPanel{

	private Image image;
	private JLabel lba;
	private JLabel pock;
	protected AbstractButton panal;


	public Rank() {
		PanelSetting();

	}

	void PanelSetting() {


		//Panel p = new Panel();

		Image image1 = new ImageIcon("DB/image/2차3.png").getImage().getScaledInstance(1200, 880, 0);  //이미지 경로		  
		
		
		lba = new JLabel(new ImageIcon(image1));
		lba.setBounds(0,0,1200,880);
		this.setBounds(0, 0, 1200, 900);
		this.setLayout(null);
		this.add(lba);      
	
		// ----------- 홈 아이콘 사이즈 바꾸기 위한 코드  -----------
		String imgPath2 = "DB/Searching/Home.png";

		ImageIcon originIcon2 = new ImageIcon(imgPath2);

		Image originImg2 = originIcon2.getImage();

		Image chagedImg2 = originImg2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		ImageIcon Icon2 = new ImageIcon(chagedImg2);





		JButton btn1 = new JButton(Icon2);      // 메인으로 돌아가는 버튼 
		btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn1.setBorderPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 1;

			}
		});
		btn1.setBounds(890, 10, 105, 50);
		lba.add(btn1);


		// 맥주 이름을 클릭하면 맥주 설명으로 넘어감


		JButton btn2 = new JButton("  ");   // 랭킹1위
		btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn2.setBorderPainted(false);
		btn2.setContentAreaFilled(false);
		btn2.setFocusPainted(false);
		btn2.addMouseListener(new MouseListener() {




			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				image = new ImageIcon("DB/image/폭죽.gif").getImage().getScaledInstance(1200,900, 0);
				pock =new  JLabel(new ImageIcon(image));
				pock.setBounds(0,0,1200,900);
				
				lba.add(pock);
				//thisadd(pock);
				//lba.setLayout(null);
				Play("DB/BeerImage/btn.wav");
				Re();



			}


			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				image = new ImageIcon(" ").getImage().getScaledInstance(220,130, 0);
				btn2.setIcon(new ImageIcon(image));
				pock.setVisible(false);
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}


			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}});
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 51;
			}

		}
				);
		btn2.setBounds(502, 385, 200, 131);
		lba.add(btn2);


		JButton btn3 = new JButton("  ");   // 랭킹2위
		btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn3.setBorderPainted(false);
		btn3.setContentAreaFilled(false);
		btn3.setFocusPainted(false);
		btn3.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon("DB/image/길2.jpg").getImage().getScaledInstance(220,130, 0);
				//btn3.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon(" ").getImage().getScaledInstance(220,130, 0);
				//btn3.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 52;

			}
		});
		btn3.setBounds(350, 538, 200, 131);
		lba.add(btn3);


		JButton btn4 = new JButton("  ");   // 랭킹3위
		btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn4.setBorderPainted(false);
		btn4.setContentAreaFilled(false);
		btn4.setFocusPainted(false);
		btn4.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon("DB/image/길2.jpg").getImage().getScaledInstance(220,130, 0);
				//btn4.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon(" ").getImage().getScaledInstance(220,130, 0);
				//btn4.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}});
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 53;

			}
		});
		btn4.setBounds(665, 538, 200, 131);
		lba.add(btn4);


		JButton btn5 = new JButton("  ");   // 랭킹 4위
		btn5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn5.setBorderPainted(false);
		btn5.setContentAreaFilled(false);
		btn5.setFocusPainted(false);
		btn5.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon("DB/image/길2.jpg").getImage().getScaledInstance(220,130, 0);
				//btn5.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon(" ").getImage().getScaledInstance(220,130, 0);
				//btn5.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}});
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 54;

			}
		});
		btn5.setBounds(155, 685, 200, 131);
		lba.add(btn5);


		JButton btn6 = new JButton("  ");   // 랭킹 5위
		btn6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn6.setBorderPainted(false);
		btn6.setContentAreaFilled(false);
		btn6.setFocusPainted(false);
		btn6.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon("DB/image/길2.jpg").getImage().getScaledInstance(220,130, 0);
				//btn6.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon(" ").getImage().getScaledInstance(220,130, 0);
				//btn6.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}});
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 55;

			}
		});
		btn6.setBounds(848, 684, 200, 131);
		lba.add(btn6);


		JButton btn7 = new JButton("  ");   // 랭킹 6위   
		btn7.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn7.setBorderPainted(false);
		btn7.setContentAreaFilled(false);
		btn7.setFocusPainted(false);
		btn7.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon("DB/image/길2.jpg").getImage().getScaledInstance(220,130, 0);
				//btn7.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				//image = new ImageIcon(" ").getImage().getScaledInstance(220,130, 0);
				//btn7.setIcon(new ImageIcon(image));
				Play("DB/BeerImage/btn.wav");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}});
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 56;
			}
		});
		btn7.setBounds(501, 745, 200, 100);   
		lba.add(btn7);

		lba.setLayout(null);


		this.add(lba);	




	}
	
	void Re() {
		this.revalidate();//?? 새로운호출
		this.repaint();// 비슷한데;;;
	}
	
	void thisadd(Component cp) {
		this.add(cp);
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