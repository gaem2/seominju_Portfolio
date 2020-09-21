package com.kh.mini.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WorldMap extends JPanel{ // 지도에서 나라별 맥주 보기
	private JFrame jf;
	private JDialog jd;
	private Image image; // 이미지 저장
	private JLabel lb; // 이미지 저장
	JButton homeBt;
	class nationR{ // 국가 이름 과 위치및 사이즈 저장하기 위한 클래스
		String Name; // 국가 이름 저장
		Rectangle r; // 위치및 사이즈 저장
		public nationR(String name, Rectangle r) {
			Name = name;
			this.r = r;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public Rectangle getR() {
			return r;
		}
		public void setR(Rectangle r) {
			this.r = r;
		}		




	}
	Map<String,JButton> mapBt; // 국가별 버튼 저장 map 형태로 키워드는 국가 이름
	Map<String,nationR> mapN; // 위에 클라스를 map 형식으로 저장 키워드는 국가이름
	JPanel jp; // 주 판넬
	boolean checkClick = false;
	public WorldMap() {//생성자

		PanelSetting();// 패널세팅


		mapN = MakeNationLIst(); // 국가리스트및 위치작성
		mapBt = MakeButton(mapN); // 버튼생성

		SetButtonMouse(mapBt, mapN); //버튼 이벤트


	}

	void PanelSetting() {// 전체적인 판넬 세팅
		image = new ImageIcon("DB/MAP/하얀지도작은거.png").getImage().getScaledInstance(1200, 900, 0);
		lb = new JLabel(new ImageIcon(image));
		HomeBt();
		lb.add(homeBt);
		this.setLayout(null);
		lb.setBounds(0,0,1200,900);
		this.setBounds(0, 0,1200, 900);
		this.add(lb);	
	

	}

	Map<String,nationR> MakeNationLIst() { // 국가 이름및 버튼 정보 

		Map<String,nationR> ret = new HashMap<>();

		ret.put("Korea",new nationR("Korea1",new Rectangle(470, 385, 23, 28)));
		ret.put("China",new nationR("China",new Rectangle(355, 385,110, 70)));
		ret.put("Japan",new nationR("Japan",new Rectangle(500, 378, 50, 80)));
		ret.put("EU",new nationR("EU",new Rectangle( 85, 335,80, 80)));
		ret.put("Rusia",new nationR("Rusia",new Rectangle(260, 200, 180,120)));
		ret.put("Australia",new nationR("Australia",new Rectangle(440,560,130,120)));
		ret.put("America",new nationR("America",new Rectangle(830,350,130,100)));
		ret.put("SouthAmerica",new nationR("SouthAmerica",new Rectangle(920,500,150,150)));
		ret.put("Africa",new nationR("Africa",new Rectangle(80,420,100,100)));
		ret.put("Korea",new nationR("Korea",new Rectangle(430, 345, 100, 50)));

		return ret; 
	}


	Map<String,JButton> MakeButton(Map<String,nationR> mapData) {// 국가맵을 이용하여 버튼 생성

		Map<String,JButton> ret = new HashMap<String, JButton>();
		Set key = mapData.keySet();
		Iterator<Set> iter= key.iterator();
		JButton tmpBt;
		Object obj;
		while(iter.hasNext()) {
			obj = iter.next();

			tmpBt = new JButton(obj.toString());
			tmpBt.setBounds(mapData.get(obj.toString()).getR());
			tmpBt.setOpaque(false);
			tmpBt.setContentAreaFilled(false);
			tmpBt.setBorderPainted(false);
			tmpBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lb.add(tmpBt);
			ret.put(obj.toString(), tmpBt);	


		}		
		return ret;

	}

	void SetButtonMouse(Map<String,JButton> mapBt,Map<String,nationR> mapData) { 
		// 생성된 버튼에 이벤트를 처리한다
		Set key = mapData.keySet();
		Iterator<nationR> iter= key.iterator();

		while(iter.hasNext()) {
			Object obj = iter.next();

			mapBt.get(obj.toString()).addMouseListener(new MouseListener() {
				String str = obj.toString();

				//Map<String,nationR> mapNation = mapData;
				nationR nation = mapData.get(obj.toString());

				@Override
				public void mouseReleased(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {
					if(checkClick == false) {
						jd.dispose();
						mapBt.get(obj.toString()).setForeground(Color.BLACK);
					}
				}

				@Override
				public void mouseEntered(MouseEvent e) {

					 Play("DB/BeerImage/btn.wav"); 
					if(checkClick ==false) {
						mapBt.get(obj.toString()).setForeground(Color.RED);
						int x=nation.getR().x;

						if(x >700) {

							jd=new BeerListPanel(obj.toString(),x-10,200);

						}else {

							jd=new BeerListPanel(obj.toString(),x+400,200);
						}

						jd.setVisible(true);
					}			

				}

				@Override
				public void mouseClicked(MouseEvent e) {

					if(checkClick == false) {		
						mapBt.get(obj.toString()).setForeground(Color.BLUE);
						checkClick = true;
						jd.setVisible(true);
					}else {			
						mapBt.get(obj.toString()).setForeground(Color.BLACK);
						checkClick = false;
						jd.dispose();			
					}
				}
			});

		}		
	}

	void ThisaddJP(JPanel jp) {// 주판넬에 새로운 판넬을 넣고 업데이트
		this.add(jp);
		this.revalidate();	
	}

	void Revalidate() { // 판넬 업데이트 
		this.revalidate();
		this.repaint();
	}

	void HomeBt() {
		Image img = new ImageIcon("DB/Searching/Home.png").getImage().getScaledInstance(50, 50, 0);
		homeBt = new JButton(new ImageIcon(img));

		homeBt.setBounds(1020,50,50,50);                  // 홈 버튼 위치
		homeBt.setContentAreaFilled(false);               // 버튼외곽선
		homeBt.setBorderPainted(false);
		homeBt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		homeBt.addActionListener(new ActionListener() {
			 
			@Override
			public void actionPerformed(ActionEvent e) {
				Play("DB/BeerImage/btn.wav");
				MainFrame.state=1;
				
			}
		});
		
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

