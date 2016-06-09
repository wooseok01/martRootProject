package com.mart.model;

public class SecondCategory {
	private int sId;
	private String sName;
	private int bId;
	
	public SecondCategory(){}

	public SecondCategory(int sId, String sName, int bId) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.bId = bId;
	}

	public int getsId() {return sId;}
	public void setsId(int sId) {this.sId = sId;}

	public String getsName() {return sName;}
	public void setsName(String sName) {this.sName = sName;}

	public int getbId() {return bId;}
	public void setbId(int bId) {this.bId = bId;}
	
	
}
