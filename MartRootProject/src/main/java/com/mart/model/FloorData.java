package com.mart.model;

public class FloorData {
	private int fId;
	private String fProduct;
	private int fX;
	private int fY;
	private int fWidth;
	private int fHeight;
	private int fFloor;
	
	public FloorData(){}

	public FloorData(int fId, String fProduct, int fX, int fY, int fWidth, int fHeight, int fFloor) {
		super();
		this.fId = fId;
		this.fProduct = fProduct;
		this.fX = fX;
		this.fY = fY;
		this.fWidth = fWidth;
		this.fHeight = fHeight;
		this.fFloor = fFloor;
	}

	public int getfId() {return fId;}
	public void setfId(int fId) {this.fId = fId;}

	public String getfProduct() {return fProduct;}
	public void setfProduct(String fProduct) {this.fProduct = fProduct;}

	public int getfX() {return fX;}
	public void setfX(int fX) {this.fX = fX;}

	public int getfY() {return fY;}
	public void setfY(int fY) {this.fY = fY;}

	public int getfWidth() {return fWidth;}
	public void setfWidth(int fWidth) {this.fWidth = fWidth;}

	public int getfHeight() {return fHeight;}
	public void setfHeight(int fHeight) {this.fHeight = fHeight;}

	public int getfFloor() {return fFloor;}
	public void setfFloor(int fFloor) {this.fFloor = fFloor;}

	@Override
	public String toString() {
		return "FloorData [fId=" + fId + ", fProduct=" + fProduct + ", fX=" + fX + ", fY=" + fY + ", fWidth=" + fWidth
				+ ", fHeight=" + fHeight + ", fFloor=" + fFloor + "]\n";
	}
	
	
}
