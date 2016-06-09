package com.mart.model;

public class BigCategory {
	private int bId;
	private String bName;
	
	public BigCategory(){}

	public BigCategory(int bId, String bName) {
		super();
		this.bId = bId;
		this.bName = bName;
	}

	public int getbId() {return bId;}
	public void setbId(int bId) {this.bId = bId;}

	public String getbName() {return bName;}
	public void setbName(String bName) {this.bName = bName;}
	
	
}
