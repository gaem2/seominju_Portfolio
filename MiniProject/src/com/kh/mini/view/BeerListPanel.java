package com.kh.mini.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.kh.mini.controller.BeerController;
import com.kh.mini.model.Beer;

public class BeerListPanel extends JDialog{ // 국가이름을 가져와 리스트를 보여준다.
	private BeerController bc = MainFrame.bc; // 메인프레임에 컨트롤러를 가져온다
	private JButton[] bt; //버튼은 생성하기 위한 저장소
	private Beer[] br; // 전체 자료를 가져온다.
	private JPanel jp; // 전체를 담을 판
	boolean clickedShow = false; // 클릭되었는지 확인
	JDialog jf;// 클릭시 맥주설명 다이아 로그 담는 변수
	int num;
	public BeerListPanel(String nation,int x,int y){ // 생성자
		PanelSetting(x ,y);
		nation =EngtoKr(nation);// 국가이름 필터링및 검색에 맞는 이름으로 변환한다.
		
		if(nation == null) { // 이름 값이 널이면 종료
			this.setSize(0,0);
			return;
		}
		
		jp = new JPanel();
		jp.setSize(150, 200);
		br = bc.FinduseNation(nation);
		
		jp.setLayout(new GridLayout(br.length,1));
		jp.setBackground(Color.WHITE);
		bt= new JButton[br.length];
		
		for(int i =0; i<br.length;i++) {// 버튼 생성.
			
			bt[i]= new JButton(new ImageIcon(br[i].getBeerImage().getScaledInstance(150, 200, 0)));
			bt[i].setSize(150, 200);
			String str = br[i].getBeerName();
			bt[i].setOpaque(false);
			bt[i].setContentAreaFilled(false);
			bt[i].setBorderPainted(false);
			bt[i].setCursor(new Cursor(Cursor.HAND_CURSOR));	
			bt[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String str1 =str;
					if(clickedShow == false) {
					
							
							jf = new ShowBeerExplan(x,y,str1);
						
						clickedShow = true;
					}else{
						jf.dispose();
						clickedShow =false;
					}
										
				}
				
			});
			
			bt[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					 Play("DB/BeerImage/btn.wav"); 
				}
			});
			jp.add(bt[i]);
		}
		
	
			
		// 판넬을 스크롤바에 넣는다.
		JScrollPane jsp= new JScrollPane(jp,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
	               JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		jsp.setBounds(0, 0, 300, 600);		
		jsp.getVerticalScrollBar().setUnitIncrement(20);

	
		this.add(jsp);
		
		
		
	}
	
	void PanelSetting(int x , int y) { // 이 패널의 주 세팅/=.

		this.setSize(300, 600);
		this.setLocation(x,y);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	
	String EngtoKr(String nation) { // 검색에 적합한 이름으로 변경한다.
		
		if(nation.contains("Korea")) {
			nation = "국산";
		}else if(nation.contains("South")){
			nation = "SouthAmerica";
		}else if(nation.contains("America")){
			nation = "미국";
		}else if(nation.contains("Japan")) {
			nation = "일본";
		}else if(nation.contains("China")) {
			nation = "중국";
		}else if(nation.contains("EU")){
			
		}else if(nation.contains("Africa")){
			nation = "남아공";
		}else{
			nation = null;
		}
		
		return nation;
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
