package com.kh.mini.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.border.Border;



public class SearchPan extends JPanel{
   private Image image;
   private JLabel lb;
   private Border EmptyBorder;               // 검색창 JTextField 외곽선 없애기 위함.
   JTextField searchbox = new JTextField(30);   // 검색창

   JButton btn = new JButton();            // 검색 버튼
   JButton home= new JButton();              // 홈 버튼

   public SearchPan() {
      searchboard();                     // searchboard 메소드 호출
   }

   void searchboard() {

      // 배경 이미지
      image = new ImageIcon("DB/Searching/searchbg1.jpg").getImage().getScaledInstance(1200,900,0);   
      lb = new JLabel(new ImageIcon(image));

      // 메인 패널 크기 지정
      this.setSize(1200,900);
      this.setLocation(0, 0);
      this.add(lb);

      // ----------- 돋보기 아이콘 사이즈 바꾸기 위한 코드  -----------
      ImageIcon Icon = new ImageIcon(new ImageIcon("DB/Searching/dotbogi.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

      // ----------- 홈 아이콘 사이즈 바꾸기 위한 코드  -----------
      ImageIcon Icon2 = new ImageIcon(new ImageIcon("DB/Searching/Home.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

      // ----------- 콤보박스 만들기 -----------
      String[] beer= {"맥주명", "종류", "제조국"};
      this.setLayout(new FlowLayout());   
      JComboBox jb = new JComboBox(beer);         

      // ----------- 검색 화면 디자인 -----------
      searchbox.setBackground(Color.BLACK);   // 검색창 배경색
      searchbox.setForeground(Color.white);   // 검색창 글자색
      searchbox.setBorder(EmptyBorder);      // 검색창 JTextField 외곽선 없애기 위함.

      btn = new JButton(Icon);
      home = new JButton(Icon2);

      // 1. 위치 조정
      lb.setBounds(-318,-47,1800,900);       // 배경이미지 위치
      searchbox.setBounds(390,500,420,50);   // 검색창 위치
      btn.setBounds(815,500,50,50);            // 검색 버튼 위치
      home.setBounds(1020,200,100,50);      // 홈 버튼 위치
      jb.setBounds(290,500,100,50);         // 콤보박스 위치

      // 2. 폰트 지정
      jb.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.BOLD, 20));
      searchbox.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 40));

      //      searchbox.requestFocus();
      btn.setBorderPainted(false);         //JButton의 Border(외곽선)을 없애준다.
      btn.setContentAreaFilled(false);
      home.setBorderPainted(false);
      home.setContentAreaFilled(false);


      // ----------- 검색 창에서 Enter키로 콤보박스 값과 검색 값을 가져오는 이벤트 -----------
      // 1. 검색 값
      searchbox.addKeyListener(new KeyListener() {

         @Override
         public void keyTyped(KeyEvent e) {}

         @Override
         public void keyReleased(KeyEvent e) {}

         @Override
         public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_ENTER) {
               String str = searchbox.getText();
               RecPage50.str_search = str;
            }

         }
      });

      // 2. 콤보박스 값
      searchbox.addKeyListener(new KeyListener() {

         @Override
         public void keyTyped(KeyEvent e) {}

         @Override
         public void keyReleased(KeyEvent e) {}

         @Override
         public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if(key == KeyEvent.VK_ENTER) {
               String msg = jb.getSelectedItem().toString();
               RecPage50.str_combo = msg;
               RecPage50.br=MainFrame.bc.FinduseKinds(msg);
               MainFrame.state =50;
            }

         }
      });

      // ----------- 검색 버튼 클릭 시에 발동되는 메소드 -----------
      // 1. 검색 값
      btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String str = searchbox.getText();
            RecPage50.str_search = str;
         }

      });

      // 2. 콤보 값
      btn.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String msg = jb.getSelectedItem().toString();
            //            System.out.println("무지개에는 "+msg+"이 있어요");
            //              resultboard();
            System.out.println("서치"+msg);
            RecPage50.str_combo = msg;
            RecPage50.br=MainFrame.bc.FinduseKinds(msg);
            MainFrame.state =50; 
         }


      });

      // ----------- 홈 버튼 클릭 시에 발동되는 메소드 -----------
      home.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            MainFrame.state=1;
         }
      });

      lb.setBounds(0,0,1200,900);
      lb.add(btn);       // 이전 화면 버튼
      lb.add(home);      // 매인화면으로가는 버튼

      lb.add(searchbox);   // 검색창 
      lb.add(jb);         // 콤보박스
      this.add(lb);      // 메인 패널에 라벨 담아줌


   }

}