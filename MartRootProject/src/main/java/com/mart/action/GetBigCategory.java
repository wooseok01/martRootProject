package com.mart.action;

import java.util.ArrayList;

import com.mart.dao.AllDao;
import com.mart.model.BigCategory;

public class GetBigCategory {
	private AllDao dao;
	
	public GetBigCategory(){}

	public GetBigCategory(AllDao dao) {
		super();
		this.dao = dao;
	}
	
	public ArrayList<BigCategory> getBigCategory(){
		return dao.getBigCategory();
	}
	
	
}
