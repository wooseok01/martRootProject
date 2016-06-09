package com.mart.mapper;

import java.util.ArrayList;

import com.mart.model.BigCategory;
import com.mart.model.FloorData;
import com.mart.model.SecondCategory;
import com.mart.model.ThirdCategory;

public interface AllDaoInterface {

	public ArrayList<BigCategory> getBigCategory();
	public ArrayList<SecondCategory> getSecondCategory(int bId);
	public ArrayList<SecondCategory> getThirdCategory(int bId);
	public ArrayList<SecondCategory> getAllSecondCategory();
	public ArrayList<ThirdCategory> getAllThirdCategory();
	public ArrayList<FloorData> getThirdFloorData();
	public ArrayList<FloorData> getThirdFloorProductList(String selected);
	public ArrayList<FloorData> getSecondFloorProductList(String selected);
	public FloorData getEntrance(int floor);
	public ArrayList<FloorData> getSecondFloorData();
	
	

}
