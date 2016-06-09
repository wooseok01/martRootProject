package com.mart.action;

import java.util.ArrayList;

import com.mart.dao.AllDao;
import com.mart.model.FloorData;

public class GetThirdFloorData {
	private AllDao dao;

	public GetThirdFloorData(AllDao dao) {
		super();
		this.dao = dao;
	}
	
	public ArrayList<FloorData> getThirdFloorData(){
		return dao.getThirdFloorData();
	}
}
