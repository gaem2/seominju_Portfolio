package com.kh.mini.controller;



import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.kh.mini.model.Beer;

public class BeerController {

	private Beer[] beer = new Beer[100];



	public BeerController(){//기본생성자로 맥주파일을 읽고 맥주객체배열을 만들어 낸다.
		//이트라이는 파일을 읽습니다.
		try(BufferedReader br = new BufferedReader(new FileReader("DB/BEER/맥주2.txt"))){

			StringBuilder sb = new StringBuilder();

			String str = br.readLine(); // 
			String[] tmpArrStr = new String[6];
			int i=0,j=0;
			int count =0;
			while(str != null){
				StringTokenizer st = new StringTokenizer(str,";");
				j=0;
				while(st.hasMoreTokens()) {//토큰으로 자료를 나눕니다
					tmpArrStr[j]=st.nextToken();
					//					System.out.println(tmpArrStr[j]);
					//					System.out.println(j);
					j++;
				}

				for(j=0;j<6;j++) {//중간에 탭이 들어간거는 빼줍니다.
					tmpArrStr[j]=tmpArrStr[j].replaceAll("\\t", "");
				}

				//beer 객체를 만들어 넣습니다.
				beer[i++] = new Beer(tmpArrStr[0],tmpArrStr[1],tmpArrStr[2],tmpArrStr[3],tmpArrStr[4],tmpArrStr[5]); 

				str = br.readLine();
			}
			br.close();
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		// 이미지를 저장한다.

		int i=0;
		while(beer[i] != null) {

			try {
				beer[i].setBeerImage(ImageIO.read(new File("DB/맥주사진/"+beer[i].getBeerName()+".png")).getScaledInstance(400, 500, 0));

			} catch (IOException e) {
				try {
					beer[i].setBeerImage(ImageIO.read(new File("DB/맥주사진/"+beer[i].getBeerName()+".jpg")).getScaledInstance(400, 500, 0));
				} catch (IOException e1) {
					System.out.println(beer[i].getBeerName()+"파일없음");
				}
			}

			i++;
		}	

	}


	public Beer[] FindBeer(String str) {//도수를 뺀 객체 찾기
		ArrayList<Beer> list = new ArrayList<Beer>();

		int i=0;
		while(beer[i] != null) {
			if(beer[i].getBeerName().contains(str)
					|| beer[i].getFlavorForSearch().contains(str)
					|| beer[i].getKinds().contains(str)
					|| beer[i].getFlavorOther().contains(str)
					|| beer[i].getFlavorForSearch().contains(str)) {//contain으로 값찾기

				list.add(beer[i]);

			}
			i++;
		}

		if(list.size() != 0) {//있으면 찾아서 배열객체화 시켜서 리턴
			Beer[] br = new Beer[list.size()];
			for(i=0;i<list.size();i++) {
				br[i] = list.get(i);
			}

			return br;

		}else {//없으면 널리턴
			return null;
		}
	}


	public Beer[] FinduseName(String str) {//이름으로 나머지 객체를 찾아서 돌려준다.5
		ArrayList<Beer> list = new ArrayList<Beer>();

		int i=0;
		while(beer[i] != null) {
			if(beer[i].getBeerName().contains(str)) {//contain으로 값찾기
				//list.add( new Beer(beer[i].getBeerName(),beer[i].getNation(),beer[i].getDosu(),beer[i].getKinds(),beer[i].getFlavorOther(),beer[i].getFlavorForSearch()));
				list.add(beer[i]);
				//list.get(i).setBeerImage(beer[i].getBeerImage());
			}
			i++;
		}

		if(list.size() != 0) {//있으면 찾아서 배열객체화 시켜서 리턴
			Beer[] br = new Beer[list.size()];
			for(i=0;i<list.size();i++) {
				br[i] = list.get(i);
			}

			return br;

		}else {//없으면 널리턴
			return null;
		}



	}
	public Beer[] FinduseNation(String str) {//나라로 객체를 찾아서 돌려준다.
		ArrayList<Beer> list = new ArrayList<Beer>();
		int i=0;

		if(str == "EU") {
			str ="영국 독일 오스트리아 리투아니아 벨기에 아일랜드 네덜란드 덴마크 스페인 폴란드 싱가포르 체코";
			while(beer[i] != null) {

				if(str.contains(beer[i].getNation())) {//contain으로 값찾기
					list.add(beer[i]);			
				}
				i++;
			}
		}else if(str == "SouthAmerica") {
			str ="멕시코 ";
			while(beer[i] != null) {

				if(str.contains(beer[i].getNation())) {//contain으로 값찾기
					list.add(beer[i]);			
				}
				i++;
			}
		}else{
			while(beer[i] != null) {


				if(beer[i].getNation().contains(str)) {//contain으로 값찾기
					list.add(beer[i]);	
				}

				i++;
			}
		}

		if(list.size() != 0) {//있으면 찾아서 배열객체화 시켜서 리턴
			Beer[] br = new Beer[list.size()];
			for(i=0;i<list.size();i++) {
				br[i] = list.get(i);
			}

			return br;

		}else {//없으면 널 리턴
			return null;
		}
	}



	public Beer[] FinduseKinds(String str) {//종류로 찾아낸다.
		ArrayList<Beer> list = new ArrayList<Beer>();
		int i=0;
		while(beer[i] != null) {
			if(beer[i].getKinds().contains(str)) {//contain으로 값찾기
				list.add(beer[i]);		
				//list.get(i).setBeerImage(beer[i].getBeerImage());
			}
			i++;
		}
		if(list.size() != 0) {//있으면 찾아서 배열객체화 시켜서 리턴
			Beer[] br = new Beer[list.size()];
			for( i=0;i<list.size();i++) {
				br[i] = list.get(i);
			}

			return br;

		}else {//없으면 널 리턴
			return null;
		}
	}

	public Beer[] FinduseKinds(String str1,String str2) {//종류로 찾아낸다.
		ArrayList<Beer> list = new ArrayList<Beer>();
		int i=0;
		while(beer[i] != null) {
			if(beer[i].getKinds().contains(str1)) {//contain으로 값찾기
				list.add(beer[i]);		
				//list.get(i).setBeerImage(beer[i].getBeerImage());
			}
			i++;
		}
		i=0;
		while(beer[i] != null) {
			if(beer[i].getKinds().contains(str2)) {//contain으로 값찾기
				list.add(beer[i]);		
				//list.get(i).setBeerImage(beer[i].getBeerImage());
			}
			i++;
		}

		if(list.size() != 0) {//있으면 찾아서 배열객체화 시켜서 리턴
			Beer[] br = new Beer[list.size()];
			for( i=0;i<list.size();i++) {
				br[i] = list.get(i);
			}

			return br;

		}else {//없으면 널 리턴
			return null;
		}
	}

	public Beer[] FinduseFlavor(String str) {//맛으로 찾아낸다.
		ArrayList<Beer> list = new ArrayList<Beer>();
		int i=0;
		while(beer[i] != null) {
			if(beer[i].getFlavorOther().contains(str)) {//contain으로 값찾기
				list.add(beer[i]);
				//list.get(i).setBeerImage(beer[i].getBeerImage());
			}
			i++;
		}
		if(list.size() != 0) {//있으면 찾아서 배열객체화 시켜서 리턴
			Beer[] br = new Beer[list.size()];
			for(i=0;i<list.size();i++) {
				br[i] = list.get(i);
			}

			return br;

		}else {//없으면 널 리턴
			return null;
		}
	}

	public Beer[] FinduseFlavorSearch(String str) {//특정맛으로 찾아낸다.
		ArrayList<Beer> list = new ArrayList<Beer>();
		int i=0;
		while(beer[i] != null) {
			if(beer[i].getFlavorForSearch().contains(str)) {//contain으로 값찾기
				list.add(beer[i]);
				//list.get(i).setBeerImage(beer[i].getBeerImage());
			}
			i++;
		}
		if(list.size() != 0) {//있으면 찾아서 배열객체화 시켜서 리턴
			Beer[] br = new Beer[list.size()];
			for(i=0;i<list.size();i++) {
				br[i] = list.get(i);
			}

			return br;

		}else {//없으면 널 리턴
			return null;
		}
	}

	public Beer[] FinduseDosu(double startDosu,double endDosu) {//도수로 찾아낸다.

		if(startDosu > endDosu) {//작은것부터 큰것은 찾아주기위해 크기 비교를 해주고 바꾸어 줍니다
			double tmp = startDosu;
			startDosu = endDosu;
			endDosu = tmp;
		}

		ArrayList<Beer> list = new ArrayList<Beer>();



		double dosu=0;
		int i=0;
		while(beer[i] != null) {
			dosu = Double.parseDouble(beer[i].getDosu().replace("%", ""));	//뒤에 %를빼고 숫자를 double화 시킵니다.~
			//System.out.println(beer[i].getDosu().replace("%", ""));
			if(startDosu <= dosu && dosu <= endDosu) {
				list.add(beer[i]);
				//list.get(i).setBeerImage(beer[i].getBeerImage());
			}
			i++;
		}

		if(list.size() != 0) {//있으면 찾아서 배열객체화 시켜서 리턴
			Beer[] br = new Beer[list.size()];
			for(i=0;i<list.size();i++) {
				br[i] = list.get(i);
			}

			return br;

		}else {//없으면 널 리턴
			return null;
		}
	}

	public void PrintFind(Beer[] arrFinded) {//배열객체를 받아 프린트 해준다
		if(arrFinded == null) {
			System.out.println("값없음");
			return;
		}

		for(int i=0;i<arrFinded.length;i++) {
			System.out.println(arrFinded[i]);
		}
	}

	public void PrintAll() {//가지고 있는 배열객체 전부를 프린트 해준다.
		int i=0;
		while(beer[i] != null) {
			System.out.println(beer[i++]);
		}

	}




	public Beer[] getBeerALL() {
		return beer;
	}


	public void setBeer(Beer[] beer) {
		this.beer = beer;
	}



	//	public  void ReadBeerDB_xlsx() {
	//		File file = new File("DB/BEER/맥주_자료정리.xlsx");
	//		try {
	//			FileInputStream
	//			fis = new FileInputStream(file);
	//
	//			XSSFWorkbook workBook = new XSSFWorkbook(fis);
	//			
	//			//엑셀 index는 0부터 시작
	//			int rowIndex=0;
	//			int colIndex=0;
	//			
	//			//시트 수
	//			XSSFSheet sheet = workBook.getSheetAt(0);
	//			//행의 수
	//			int rows = sheet.getPhysicalNumberOfRows();
	//			for(rowIndex=0; rowIndex < rows;rowIndex++) {
	//				
	//				//행 읽기
	//				XSSFRow row = sheet.getRow(rowIndex);
	//				
	//			
	//			}
	//
	//		} catch (FileNotFoundException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//	}

}
