package com.kh.mini.model;

import java.awt.Image;

public class Beer {
	private String beerName;
	private String nation;
	private String dosu;
	private String kinds;
	private String flavorOther;
	private String flavorForSearch;
	private Image beerImage;
	
	
	public Beer() {}
	
	
	
	public Beer(String beerName, String nation, String dosu, String kinds, String flavorOther, String flavorForSearch) {
		super();
		this.beerName = beerName;
		this.nation = nation;
		this.dosu = dosu;
		this.kinds = kinds;
		this.flavorOther = flavorOther;
		this.flavorForSearch = flavorForSearch;
	}



	public String getBeerName() {
		return beerName;
	}



	public void setBeerName(String beerName) {
		this.beerName = beerName;
	}



	public String getDosu() {
		return dosu;
	}



	public void setDosu(String dosu) {
		this.dosu = dosu;
	}



	public String getKinds() {
		return kinds;
	}



	public void setKinds(String kinds) {
		this.kinds = kinds;
	}



	public String getFlavorOther() {
		return flavorOther;
	}



	public void setFlavorOther(String flavorOther) {
		this.flavorOther = flavorOther;
	}


	public String getNation() {
		return this.nation;
	}



	public String getFlavorForSearch() {
		return flavorForSearch;
	}



	public void setFlavorForSearch(String flavorForSearch) {
		this.flavorForSearch = flavorForSearch;
	}
	
	


	public Image getBeerImage() {
		return beerImage;
	}



	public void setBeerImage(Image beerImage) {
		this.beerImage = beerImage;
	}



	@Override
	public String toString() {
		return "Beer [beerName=" + beerName + ", nation=" + nation + ", dosu=" + dosu + ", kinds=" + kinds
				+ ", flavorOther=" + flavorOther + ", flavorForSearch=" + flavorForSearch + "]";
	}






	

	
	
	
	
}
