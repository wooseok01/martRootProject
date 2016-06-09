package com.mart.action;

import java.util.ArrayList;

import com.mart.dao.AllDao;
import com.mart.model.FloorData;

public class GetSecondFloorData {
	private AllDao dao;
	
	public GetSecondFloorData(){}

	public GetSecondFloorData(AllDao dao) {
		super();
		this.dao = dao;
	}
	
	public ArrayList<FloorData> getSecondFloorData(){
		return dao.getSecondFloorData();
	}
}
