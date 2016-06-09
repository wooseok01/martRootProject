package com.mart.action;

import java.util.ArrayList;

import com.mart.dao.AllDao;
import com.mart.model.FloorData;

public class GetFloorProductList {
	private AllDao dao;
	
	public GetFloorProductList(){}

	public GetFloorProductList(AllDao dao) {
		this.dao = dao;
	}
	

	
	public ArrayList<FloorData> 
		getThirdFloorProductList(String selected[]){
		
		ArrayList<FloorData> list = new ArrayList<FloorData>();
		
		for(int i=0; i<selected.length; i++){
			if(i == 0){
				FloorData entrance = dao.getEntrance(3);
				list.add(entrance);
			}
			ArrayList<FloorData> third = dao.getThirdFloorProductList(selected[i]);

			if(third != null){
				for(int j=0; j<third.size(); j++){
					if(third.get(j) != null && sameCheck(list, third.get(j))){
						list.add(third.get(j));
					}
						
				}
			}
		}
		return list;
	}
	

	
	public ArrayList<FloorData> 
		getSecondFloorProductList(String selected[]){

		ArrayList<FloorData> list = new ArrayList<FloorData>();
		for(int i=0; i<selected.length; i++){
			if(i == 0){
				FloorData entrance = dao.getEntrance(2);
				list.add(entrance);
			}
			ArrayList<FloorData> second = dao.getSecondFloorProductList(selected[i]);
			if(second != null){
				for(int j=0; j<second.size(); j++){
//					if(i == 0){
//						FloorData entrance = dao.getEntrance(3);
//						list.add(entrance);
//					}
					
					if(second.get(j) != null && sameCheck(list, second.get(j))){
						list.add(second.get(j));
					}
				}
			}
		}
		return list;
	}
	
	private boolean sameCheck(ArrayList<FloorData> list, FloorData third){
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getfId() == third.getfId()){
				return false;
			}
		}
		return true;
	}
}
