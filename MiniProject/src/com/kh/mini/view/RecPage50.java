package com.kh.mini.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.kh.mini.model.Beer;
import com.kh.mini.view.MainFrame;

public class RecPage50 extends JPanel {
   private JScrollPane scrollBar ;
   private JPanel listPan;
   private JLabel[] arrJP;
   static String str_search;
   static String str_combo;
   static Beer[] br;
   static JButton BACK= new JButton(); 

   public RecPage50() { // 결과 화면
      System.out.println("RecPage50 불림");
      // 검색하기 위한 값 가져오기
      if(str_combo.equals("맥주명")) {
         br = MainFrame.bc.FinduseName(str_search);
         MainFrame.bc.PrintFind(br);
      }else if(str_combo.equals("종류")) {
         br = MainFrame.bc.FinduseKinds(str_search);
         MainFrame.bc.PrintFind(br);
      }else if(str_combo.equals("제조국")) {
         br = MainFrame.bc.FinduseNation(str_search);
         MainFrame.bc.PrintFind(br);
      }

      // ----- 검색 성공! -----
      if(br != null) {
         setLayout(null);
         int y = 500;
         for(int index = 0; index < br.length; index++) {
            addBeer(br[index],y*index);
            if(index == br.length-1) {

            }
         }


         arrJP = new JLabel[br.length];
         listPan = new JPanel();
         listPan.setBounds(0,0,1200, 900);
         listPan.setLayout(new GridLayout(0,1));
         JLabel[] lb = new JLabel[5];
         JButton [] btn = new JButton[br.length];
         Image back = new ImageIcon("DB/Searching/reply.png").getImage().getScaledInstance(50, 50, 0);
         Image img = new ImageIcon("DB/image/beerbg.jpg").getImage().getScaledInstance(1200, 900, 0);

         // 반복문을 통해 결과 표현
         for (int i = 0; i < br.length; i++) {
            arrJP[i] = new JLabel();
            arrJP[i].setLayout(null);
            arrJP[i] = new JLabel(new ImageIcon(img));                     // 배경이미지

            // 1. lb[] 배열에 각각에 값 넣기
            lb[0] = new JLabel(new ImageIcon(br[i].getBeerImage()));         // 맥주 이미지
            lb[1] = new JLabel(br[i].getBeerName());                        // 맥주 이름
            lb[2] = new JLabel(br[i].getKinds());                           // 맥주 종류
            lb[3] = new JLabel(br[i].getFlavorForSearch());                     // 맥주 맛
            lb[4] = new JLabel(br[i].getDosu());                        // 맥주 도수
            btn[i] = new JButton(new ImageIcon(back));                     // BACK 버튼

            // ----------- 홈 버튼 클릭 시에 발동되는 메소드 -----------

            JTextArea text = new JTextArea(br[i].getFlavorOther());               // 맥주 설명

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
            lb[4].setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 40));

            btn[i].setContentAreaFilled(false);               // 버튼 투명화
            btn[i].setBorderPainted(false);                  // 버튼 외곽선 투명화
            btn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));   // 마우스 손 모양
            // 패널에 마우스가 들어왔을때 포커스 잡아주는용도
            listPan.addMouseListener(new MouseAdapter() {

               @Override
               public void mouseEntered(MouseEvent e) {
                  System.out.println("테스트");
                  listPan.requestFocus();
               }

            });
            listPan.addKeyListener(new KeyListener() {

               @Override
               public void keyTyped(KeyEvent e) {
               }

               @Override
               public void keyReleased(KeyEvent e) {
               }

               @Override
               public void keyPressed(KeyEvent e) {
                  MainFrame.state = 3;
               }
            });

            // BACK 버튼 기능 설정
            btn[i].addActionListener(new ActionListener() {

               @Override
               public void actionPerformed(ActionEvent e) {
                  MainFrame.state=3;
               }
            });

            // 버튼 사운드
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

            // arrJP[i] 라벨에 각 값들 넣어줌
            arrJP[i].add(lb[0]);
            arrJP[i].add(lb[1]);
            arrJP[i].add(lb[2]);
            arrJP[i].add(lb[3]);
            arrJP[i].add(lb[4]);
            arrJP[i].add(btn[i]);
            arrJP[i].add(text);


            // contents 디자인
            text.setForeground(Color.black);                              // 텍스트 에리어 글자색 바꿈
            text.setLineWrap(true);                                       // 텍스트 에리어 자동 줄바꿈
            text.setEditable(false);                                    // 텍스트 에리어 비활성화
            text.setFont(new Font("아리따-돋움4.0(OTF)-Medium", Font.BOLD, 30));   // 텍스트 글꼴, 진하게, 크기
            text.setBackground(new Color(255,139,0,1));                        // 텍스트 에리어 배경색 설정

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

         scrollBar = new JScrollPane(listPan, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
         //                                                세로 스크롤_필요하면 자동               가로 스크롤_안보이게 설정
         scrollBar.setBounds(0, 0, 1224, 920);
         scrollBar.getVerticalScrollBar().setUnitIncrement(20);   // 스크롤 속도 설정
         this.add(scrollBar);

      }
      // ----- 검색 실패! -----
      else {JLabel jb= new JLabel();
      Image img2 = new ImageIcon("DB/image/bg_rank.jpg").getImage().getScaledInstance(1200, 900, 0);
      jb= new JLabel(new ImageIcon(img2));
      jb.setBounds(0,0,1200,900);
      jb.setVisible(true);
      listPan = new JPanel();
      listPan.setLayout(null);
      listPan.setBounds(0,0,1250,950);
      //      listPan.setBackground(Color.orange);

      JLabel retext = new JLabel("검색 결과가 없습니다");

      // 되돌아가 가기 버튼 생성
      Image img1 = new ImageIcon("DB/Searching/bagbeer.gif").getImage().getScaledInstance(350, 450, 0);
      BACK = new JButton(new ImageIcon(img1));
      BACK.setContentAreaFilled(false);               // BACK 버튼 배경 투명화
      BACK.setBorderPainted(false);                  // BACK 버튼 테두리 투명화
      BACK.addActionListener(new ActionListener() {   // BACK 버튼 기능

         @Override
         public void actionPerformed(ActionEvent e) {
            MainFrame.state = 3 ;   // 이전 화면
         }
      });

      listPan.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseEntered(MouseEvent e) {
            System.out.println("테스트");
            BACK.requestFocus();
         }

      });

      BACK.addKeyListener(new KeyListener() {

         @Override
         public void keyTyped(KeyEvent e) {}

         @Override
         public void keyReleased(KeyEvent e) {}

         @Override
         public void keyPressed(KeyEvent e) {
            MainFrame.state = 3;
         }


      });
      BACK.setBounds(400,330,500,450);
      retext.setBounds(400,200,500,100);
      retext.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.BOLD, 50));

      listPan.add(BACK);
      listPan.add(retext);
      this.setLayout(null);
      this.add(listPan);
      listPan.add(jb);
      }

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


   private void addBeer(Beer beer, int i) {}
}