package com.mart.model;

public class ThirdCategory {
	private int tId;
	private String tName;
	private int sId;
	
	public ThirdCategory(){}

	public ThirdCategory(int tId, String tName, int sId) {
		super();
		this.tId = tId;
		this.tName = tName;
		this.sId = sId;
	}

	public int gettId() {return tId;}
	public void settId(int tId) {this.tId = tId;}

	public String gettName() {return tName;}
	public void settName(String tName) {this.tName = tName;}

	public int getsId() {return sId;}
	public void setsId(int sId) {this.sId = sId;}

	@Override
	public String toString() {
		return "ThirdCategory [tId=" + tId + ", tName=" + tName + ", sId=" + sId + "]\n";
	}
	
	
}
