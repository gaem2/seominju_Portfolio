package com.kh.mini.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kh.mini.model.Beer;

public class RecPage51 extends JPanel { // 랭킹 1위 결과 창 
	

	public RecPage51() {
		
		this.setLayout(null);
		 Image image = new ImageIcon("DB/image/움직이는맥주2.gif").getImage().getScaledInstance(1200,900,0);// 배경이미지용
		JLabel lb = new JLabel(new ImageIcon(image));
		
		this.setSize(1200,900);
		this.setLocation(0, 0);
		this.add(lb);
		

		 
		Beer[] br = MainFrame.bc.FinduseName("칭따오");   // 종류로 찾기 기능을 이용해서 라거에 해당하는 맥주 모두 찾기

		MainFrame.bc.PrintFind(br);                  // 찾은 정보 모두 프린트하기


		JLabel imageLabel = new JLabel(new ImageIcon(br[0].getBeerImage().getScaledInstance(250, 455, 0)));
		imageLabel.setBounds(120, 200, 430, 405);      

		JLabel nameLabel = new JLabel(br[0].getBeerName()); //맥주이름
		nameLabel.setBounds(676, 180, 376, 101);
		nameLabel.setFont(new Font("아리따-돋움4.0(OTF)-Bold",Font.BOLD,70));

		JLabel kindLabel = new JLabel(br[0].getKinds());	//맥주종류
		kindLabel.setBounds(676, 280, 376, 101);
		kindLabel.setFont(new Font("아리따-돋움4.0(OTF)-Bold",Font.BOLD,50));

		JLabel  FlavorForSearch = new JLabel(br[0].getFlavorForSearch()); // 맛
		FlavorForSearch .setBounds(676, 330, 376, 201);
		FlavorForSearch.setFont(new Font("아리따-돋움4.0(OTF)-Bold",FRAMEBITS,30));

		JLabel dosuLabel = new JLabel(br[0].getDosu()); //도수
		dosuLabel.setBounds(676, 480, 376, 101);
		dosuLabel.setFont(new Font("아리따-돋움4.0(OTF)-Bold",Font.BOLD,70));

		JTextArea flavorTextArea = new JTextArea(br[0].getFlavorOther()); //정보
		flavorTextArea.setBounds(100, 600, 1000, 200);
		flavorTextArea.setForeground(Color.black);   									// 텍스트 에리어 글자색 바꿈
		flavorTextArea.setLineWrap(true);     										// 텍스트 에리어 자동 줄바꿈
		flavorTextArea.setEditable(false);    										// 텍스트 에리어 비활성화
		flavorTextArea.setFont(new Font("아리따-돋움4.0(OTF)-Bold",Font.PLAIN, 30));		// 텍스트 글꼴, 진하게, 크기
		flavorTextArea.setBackground(new Color(255, 255, 255,1)); // 정보창 백그라운드 색         



		// ----------- 랭킹 아이콘 사이즈 바꾸기 위한 코드  -----------
		String imgPath2 = "DB/image/뒤로가기.png";

		ImageIcon originIcon2 = new ImageIcon(imgPath2);

		Image originImg2 = originIcon2.getImage();

		Image chagedImg2 = originImg2.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		ImageIcon Icon2 = new ImageIcon(chagedImg2);


		JButton btn1 = new JButton(Icon2);      // 랭킹화면으로 돌아가는 버튼 
		btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn1.setBorderPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.setFocusPainted(false);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFrame.state = 2;

			}
		});
		
		btn1.setBounds(1000, 0, 150, 100);
		lb.add(btn1);



	
		lb.add(imageLabel);   
		lb.add(nameLabel);
		lb.add(kindLabel);
		lb.add(FlavorForSearch);
		lb.add(dosuLabel );
		lb.add(flavorTextArea);
		lb.setBounds(0,0,1200,900);
		lb.setVisible(true);
		lb.revalidate();
		
	}

	
}
