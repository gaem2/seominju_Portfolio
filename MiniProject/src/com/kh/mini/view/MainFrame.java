package com.kh.mini.view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.controller.BeerController;

public class MainFrame extends JFrame{

	JButton bt;
	static  BeerController bc=new BeerController(); // 비어 컨트롤 안에 100개의 비어객체 생성
	private JPanel curPan; // 현재판
	static int state =0;// 1. 메인 메뉴 , 2
	Clip clip;
	boolean musicOn=false;
	boolean once=false;
	private JPanel[] arJP = new JPanel[100];


	public MainFrame() {

		SetMainFrame();



		System.out.println("테스트통합 돌리고 있음");
		while(true) {
			System.out.print("");
			switch (state) {
			case 0:

				break;
			case 1:
				if(once == false) {
					once  = true;
					replaceLoading();
					try {
						Thread.sleep(2800);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				Bgm();
				replaceMainPan();
				break;
			case 2:
				replaceRankPan();
				break;
			case 3:
				replaceSearchPan();
				break;
			case 4:
				replaceRecommendPan();
				break;
			case 5:
				replaceMapPan();
				break;
			case 11:
				RecPage11();
				break;
			case 12:
				RecPage12();
				break;
			case 13:
				RecPage13();
				break;
			case 14:
				RecPage14();
				break;
			case 15:
				RecPage15();
				break;
			case 16:
				RecPage16();
				break;
			case 17:
				RecPage17();
				break;
			case 18:
				RecPage18();
				break;	

			case 50:


				replaceLoading();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				RecPage50();
				break;
			case 51:
				RecPage51();
				break;
			case 52:
				RecPage52();
				break;
			case 53:
				RecPage53();
				break;
			case 54:
				RecPage54();
				break;
			case 55:
				RecPage55();
				break;
			case 56:
				RecPage56();
				break;



			default:
				break;
			}
		}





	}


	public void SetMainFrame() { //메인 프레임 설정
		curPan = new StartPanel();
		this.add(curPan);
		this.setTitle("내 취향 맥주는?");
		this.setBounds(300,10,1200,900);
		try {
			this.setIconImage(ImageIO.read(new File("DB/image/icon.png")));
		} catch (IOException e) {
			System.out.println("icon파일 없엉");
		}   
		//this.pack();
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



	}
	public void replaceMainPan() {//메인프레임으로 교체
		this.remove(curPan);
		curPan = new MainPan();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void replaceLoading() {
		this.remove(curPan);
		curPan = new Loading();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();	
		state =0;

	}
	public void replaceRankPan() {
		this.remove(curPan);
		curPan = new Rank();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}

	public void replaceSearchPan() {
		this.remove(curPan);
		curPan = new SearchPan();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}

	public void replaceRecommendPan() {//메인프레임으로 교체
		this.remove(curPan);
		curPan = new RecommendPan();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}

	public void replaceMapPan() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new WorldMap();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void RecPage11() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage11();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void RecPage12() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage12();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void RecPage13() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage13();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void RecPage14() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage14();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void RecPage15() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage15();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void RecPage16() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage16();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void RecPage17() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage17();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void RecPage18() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage18();
		this.add(curPan);
		//this.pack();
		this.setVisible(true);
		this.repaint();
		state =0;
	}

	public void RecPage50() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage50();
		this.add(curPan);
		this.setVisible(true);
		this.repaint();
		state =0;
	}
	public void RecPage51() {//메인프레임으로 교체
		this.remove(curPan);
		curPan = new RecPage51();
		this.add(curPan);

		this.repaint();
		state =0;
	}
	public void RecPage52() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage52();
		this.add(curPan);
		this.repaint();
		state =0;
	}
	public void RecPage53() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage53();
		this.add(curPan);
		this.repaint();
		state =0;
	}
	public void RecPage54() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage54();
		this.add(curPan);
		this.repaint();
		state =0;
	}
	public void RecPage55() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage55();
		this.add(curPan);
		this.repaint();
		state =0;
	}
	public void RecPage56() {//메인프레임으로 교체

		this.remove(curPan);
		curPan = new RecPage56();
		this.add(curPan);
		this.repaint();
		state =0;
	}


	public  void Bgm()  {
		File file = new File("DB/BeerImage/bgm.wav");
		System.out.println(file.exists()); //true

		if(musicOn == true) {
			clip.stop();
			musicOn = false;
		}

		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(stream);
			clip.start();
			musicOn=true;


		} catch(Exception e) {

			e.printStackTrace();

		}
	}


	class RandMove extends Thread{

		Image image;
		JLabel lb;
		int rand;
		@Override
		public void run() {
			while(true) {
			rand =(int)(Math.random()*4)+1;
			image = new ImageIcon("DB/이모티콘/"+rand+"gif").getImage().getScaledInstance(200, 300, 0);
			lb = new JLabel(new ImageIcon(image));
			thisAdd(lb);		
			try {
				this.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			
		}
	}
	void thisAdd(Component cp) {
		this.add(cp);
	}
	
}
