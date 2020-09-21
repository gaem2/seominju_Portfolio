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

public class RecommendPan extends JPanel {
	
	// 패널 하나 만들기
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();

	JButton b1 = new JButton("라이트 바디");
	JButton b2 = new JButton("미디움 바디");
	JButton b3 = new JButton("풀 바디");

	public RecommendPan() {

		Play("DB/BeerImage/btn.wav"); 

		Image myImg = new ImageIcon("DB/image/3beer.png").getImage().getScaledInstance(1200, 900, 0);
		JLabel lb = new JLabel(new ImageIcon(myImg));

		// 버튼 위치와 크기
		JButton b1 = new JButton("라이트 바디");
		b1.setBounds(140, 600, 200, 50);
		JButton b2 = new JButton("미디움 바디");
		b2.setBounds(500, 600, 200, 50);
		JButton b3 = new JButton("풀 바디");
		b3.setBounds(850, 600, 200, 50);
		b1.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 25));
		b2.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 25));
		b3.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 25));
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		// 버튼 기능 넣기
		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 11;
				Play("DB/BeerImage/btn.wav"); 
			}
		});   
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 12;
				Play("DB/BeerImage/btn.wav"); 
			}
		});   
		b3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 13;
				Play("DB/BeerImage/btn.wav"); 
			}
		});   

		JButton b4 = new JButton("뒤로가기");
		ImageIcon Home = new ImageIcon(new ImageIcon("DB/Searching/reply.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
		b4 = new JButton(Home);
		b4.setBounds(1090, 60, 50, 50);	
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

		JLabel l1 = new JLabel("원하시는 맥주 맛를 선택해주세요");
		l1.setBounds(250, 50, 1000, 50);
		JLabel l2 = new JLabel("가볍고 청량한 맛");
		l2.setBounds(130, 250, 500, 70);
		JLabel l3 = new JLabel( "쌉싸름하고 적당한 맛");
		l3.setBounds(455, 250, 500, 70);
		JLabel l4 = new JLabel("묵직하고 걸쭉한 맛");
		l4.setBounds(840, 250, 500, 70);
		l1.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 50));
		l2.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 30));
		l3.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 30));
		l4.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 30));
		l2.setForeground(new Color(255,255,255));
		l3.setForeground(new Color(255,255,255));
		l4.setForeground(new Color(255,255,255));
		lb.setLayout(null);
		// 패널에 버튼 넣기
		lb.add(b1);
		lb.add(b2);
		lb.add(b3);
		lb.add(b4);

		lb.add(l1);
		lb.add(l2);
		lb.add(l3);
		lb.add(l4);

		lb.setLayout(null);
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