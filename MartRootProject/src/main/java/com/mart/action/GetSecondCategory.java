package com.mart.action;

import java.util.ArrayList;

import com.mart.dao.AllDao;
import com.mart.model.SecondCategory;

public class GetSecondCategory {
	private AllDao dao;
	
	public GetSecondCategory(){}

	public GetSecondCategory(AllDao dao) {
		super();
		this.dao = dao;
	}
	
	public ArrayList<SecondCategory> getSecondCategory(int bId){
		return dao.getSecondCategory(bId);
	}
	
	public ArrayList<SecondCategory> getAllSecondCategory(){
		return dao.getAllSecondCategory();
	}
}
