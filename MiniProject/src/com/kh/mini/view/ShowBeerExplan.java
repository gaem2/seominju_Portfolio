package com.kh.mini.view;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.kh.mini.model.Beer;

public class ShowBeerExplan extends JDialog{ // 맵에서 비어목록을 보여주고 목록을 클릭하면 내용을 띄어준다.
	Beer br;
	Beer[] arbr;
	public ShowBeerExplan(int x, int y,String str) {
		arbr = MainFrame.bc.getBeerALL();
	
		for(int i=0;i<arbr.length;i++) {
			if(str == arbr[i].getBeerName()) {
				br=arbr[i];
				break;
			}
		}
		
		if(br == null) {
			return;
		}
		
		
		JTextArea tArea = new JTextArea(br.getBeerName()+"\n"+br.getNation()+"\n"+br.getKinds()+"\n"+br.getFlavorOther());
		tArea.setFont(new Font("아리따-돋움4.0(OTF)-Bold", Font.PLAIN, 25));
		tArea.setLineWrap(true);
		tArea.setEditable(false);
		tArea.setSize(300,300);
		if(x>500) {
			this.setLocation(x-300, y);
		}else {
			this.setLocation(x+300,y);
		}
		JLabel[] lb = new JLabel[4];

		JScrollPane jsp= new JScrollPane(tArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
	               JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);		
		jsp.setBounds(0, 0, 300, 300);	
		this.setSize(300, 300);
		this.add(jsp);
		this.setUndecorated(true);
		this.setVisible(true);
	}
	
	
}
