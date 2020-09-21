package com.kh.mini.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RecPage15 extends JPanel {
	private Image image;
	private JLabel lb;

	public RecPage15(){
		PanelSetting();
	}

	void PanelSetting() {

		image = new ImageIcon("DB/image/bg.jpg").getImage().getScaledInstance(1200, 900, 0);
		lb = new JLabel(new ImageIcon(image));
		JLabel title = new JLabel("단 맛");
		title.setBounds(300,200,600,100);
		title.setForeground(new Color(255,255,255));
		title.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 100));
		title.setHorizontalAlignment(JLabel.CENTER);
		lb.add(title);

		JButton b1 = new JButton(new ImageIcon("DB/image/gbtn.png"));
		b1.setBounds(200, 500, 250, 250);
		b1.setBorderPainted(false);
		b1.setContentAreaFilled(false);
		b1.setFocusPainted(false);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lb.add(b1);

		// 버튼 기능 넣기
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = ("골든에일");
				RecPage18.str_rec = str;
				Play("DB/BeerImage/btn.wav"); 
				MainFrame.state = 18;

			}
		});   

		JButton b2 = new JButton(new ImageIcon("DB/image/nbtn.png"));
		b2.setBounds(700, 500, 250, 250);
		b2.setBorderPainted(false);
		b2.setContentAreaFilled(false);
		b2.setFocusPainted(false);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lb.add(b2);

		// 버튼 기능 넣기
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = ("스타우트");
				RecPage18.str_rec = str;
				Play("DB/BeerImage/btn.wav"); 
				MainFrame.state = 18;
			}
		}); 

		JButton b3 = new JButton("뒤로가기");
		ImageIcon back = new ImageIcon(new ImageIcon("DB/Searching/reply.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		b3 = new JButton(back);
		b3.setBounds(1080, 60, 50, 50);
		b3.setBorderPainted(false);
		b3.setContentAreaFilled(false);
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lb.add(b3);

		// 버튼 기능 넣기
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 4;
			}
		});  
		JButton b4 = new JButton("메인 메뉴");
		ImageIcon Home = new ImageIcon(new ImageIcon("DB/Searching/Home.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		b4 = new JButton(Home);
		b4.setBounds(980, 60, 50, 50);	
		b4.setBorderPainted(false);
		b4.setContentAreaFilled(false);
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lb.add(b4);

		// 버튼 기능 넣기
		b4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 1;
			}
		}); 

		this.setSize(1200,900);		
		this.setLocation(0,0);
		this.add(lb);	

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