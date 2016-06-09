package com.mart.action;

import java.util.ArrayList;

import com.mart.dao.AllDao;
import com.mart.model.SecondCategory;
import com.mart.model.ThirdCategory;

public class GetThirdCategory {
	private AllDao dao;
	
	public GetThirdCategory(){}

	public GetThirdCategory(AllDao dao) {
		super();
		this.dao = dao;
	}
	
	public ArrayList<SecondCategory> getThirdCategory(int bId){
		return dao.getThirdCategory(bId);
	}
	
	public ArrayList<ThirdCategory> getAllThirdCategory(){
		return dao.getAllThirdCategory();
	}
}
