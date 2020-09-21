package com.kh.mini.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.kh.mini.model.Beer;

public class RecPage18 extends JPanel {
	private JLabel[] arrJP;      			// arrJP배열 선언
	static String str_rec; 					
	static Beer[] br;
	JScrollPane scrollBar ;
	JPanel listPan;
	ImageIcon icon;

	public RecPage18() {

		switch (str_rec) {			// 스위치문 사용
		case "라거":
			br = MainFrame.bc.FinduseKinds(str_rec); break;
		case "과실주":
			br = MainFrame.bc.FinduseKinds("과실주","바이스"); break;
		case "골든에일":
			br = MainFrame.bc.FinduseKinds(str_rec);  break;
		case "스타우트":
			br = MainFrame.bc.FinduseKinds("스타우트"); break;
		case "페일":
			br = MainFrame.bc.FinduseKinds("페일"+"에일"); break;
		case "IPA":
			br = MainFrame.bc.FinduseKinds(str_rec); break;
		case "포터":
			br = MainFrame.bc.FinduseKinds(str_rec); break;
		default:
			break;
		}
		setLayout(null);							// 레이아웃 초기화

		MainFrame.bc.PrintFind(br);                  // 일단 찾은 정보 모두 콘솔창에 프린트하기
		System.out.println("br.length : " + br.length);


		arrJP = new JLabel[br.length];         		      // 찾은 맥주의 객수만큼 arrJP배열 갯수 설정하기
		listPan = new JPanel();        	    		// listPan 패널만들기
		listPan.setBounds(0,0, 1200, 900);					// listPan 위치, 크기 설정
		listPan.setLayout(new GridLayout(0,1));
		JLabel[] lb = new JLabel[5];             		  // lb 배열 5개로 설정
		JButton [] btn = new JButton[br.length];
		Image home = new ImageIcon("DB/Searching/Home.png").getImage().getScaledInstance(50, 50, 0);
		Image img = new ImageIcon("DB/image/beerbg.jpg").getImage().getScaledInstance(1200, 900, 0);

		// 반복문을 통해 결과 표현
		for (int i = 0; i < br.length; i++) {
			arrJP[i] = new JLabel();
			arrJP[i].setLayout(null);
			arrJP[i] = new JLabel(new ImageIcon(img));                     // 배경이미지

			// 1. lb[] 배열에 각각에 값 넣기
			lb[0] = new JLabel(new ImageIcon(br[i].getBeerImage()));       // 맥주 이미지
			lb[1] = new JLabel(br[i].getBeerName());                       // 맥주 이름
			lb[2] = new JLabel(br[i].getKinds());                          // 맥주 종류
			lb[3] = new JLabel(br[i].getFlavorForSearch());                // 맥주 맛
			lb[4] = new JLabel(br[i].getDosu());                           // 맥주 도수
			btn[i] = new JButton(new ImageIcon(home));                     // 홈 버튼

			// ----------- 홈 버튼 클릭 시에 발동되는 메소드 -----------

			JTextArea text = new JTextArea(br[i].getFlavorOther());        // 맥주 설명

			// 위치, 크기 지정
			lb[0].setBounds(60, 80, 400, 500);
			lb[1].setBounds(550, 100, 400, 200);
			lb[2].setBounds(900, 250, 300, 100);
			lb[3].setBounds(550, 300, 300, 100);
			lb[4].setBounds(900, 400, 300, 100);
			btn[i].setBounds(1050, 30, 50, 50);
			text.setBounds(0, 700, 1200, 200);

			// 폰트 지정
			lb[0].setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 20));
			lb[1].setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 40));
			lb[2].setFont(new Font("아리따-돋움4.0(OTF)-Medium", Font.PLAIN, 40));
			lb[3].setFont(new Font("아리따-돋움4.0(OTF)-Medium", Font.PLAIN, 40));
			lb[4].setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 50));

			btn[i].setContentAreaFilled(false);               // 버튼 투명화
			btn[i].setBorderPainted(false);                  // 버튼 외곽선 투명화
			btn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));   // 마우스 손 모양


			//  홈버튼 기능 설정
			btn[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					MainFrame.state=1;
				}
			});

			btn[i].addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {}

				@Override
				public void mousePressed(MouseEvent e) {}

				@Override
				public void mouseExited(MouseEvent e) {}

				@Override
				public void mouseEntered(MouseEvent e) {
					Play("DB/BeerImage/btn.wav"); 
				}
				@Override
				public void mouseClicked(MouseEvent e) {
					Play("DB/BeerImage/btn.wav"); 
				}
			});

			arrJP[i].add(lb[0]);
			arrJP[i].add(lb[1]);
			arrJP[i].add(lb[2]);
			arrJP[i].add(lb[3]);
			arrJP[i].add(lb[4]);
			arrJP[i].add(btn[i]);
			arrJP[i].add(text);
			
			// contents 디자인
			text.setForeground(Color.black);                          	  		  // 텍스트 에리어 글자색 바꿈
			text.setLineWrap(true);                                  	   		  // 텍스트 에리어 자동 줄바꿈
			text.setEditable(false);                                  			  // 텍스트 에리어 비활성화
			text.setFont(new Font("아리따-돋움4.0(OTF)-Medium", Font.BOLD, 30)); 	  // 텍스트 글꼴, 진하게, 크기
			text.setBackground(new Color(255,139,0,1));                     	  // 텍스트 에리어 배경색 설정

			// TextArea의 테두리선의 색을 검정 두깨를 0px로 설정합니다.
			Border lineBorder = BorderFactory.createLineBorder(Color.black, 0);

			// 텍스트와 TextArea 경계 사이에 여백을 두기 위해서 emptyBorder를 생성합니다. 
			Border emptyBorder = BorderFactory.createEmptyBorder(7, 40, 7, 40);   // (상, 좌, 하, 우)

			//TextArea에 lineBorder(검정테두리), emptyBorder(여백)로 구성된 복합 경계선을 설정합니다.
			text.setBorder(BorderFactory.createCompoundBorder(lineBorder, emptyBorder));


			arrJP[i].setBounds(0,0,1200,900);
			listPan.setBounds(0,0,1200,900);
			listPan.add(arrJP[i]);

		}
		// 스크롤바 생성, 세로는 필요할 때만 가로는 안생기게.
		scrollBar = new JScrollPane(listPan, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		scrollBar.setBounds(0, 0, 1220, 920);						//스크롤바 위치 조절
		scrollBar.getVerticalScrollBar().setUnitIncrement(20);		//스크롤바 속도 조절

		this.add(scrollBar);
		this.setBounds(0,0,1200,900);
		this.setVisible(true);
		this.revalidate();
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


