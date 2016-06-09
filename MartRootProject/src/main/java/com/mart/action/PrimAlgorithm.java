package com.mart.action;

import java.util.ArrayList;

import com.mart.model.Edge;
import com.mart.model.FloorData;
import com.mart.model.Node;

public class PrimAlgorithm {
	
	private ArrayList<Node> list;
	
	public PrimAlgorithm(){
		list = new ArrayList<Node>();
	}

	public ArrayList<Node> getList() {return list;}
	public void setList(ArrayList<Node> list) {this.list = list;}

	public void setNode(ArrayList<FloorData> fList){
		for(int i=0; i<fList.size(); i++){
			
			int id = fList.get(i).getfId();
			String name = fList.get(i).getfProduct();
			int x = fList.get(i).getfX();
			int y = fList.get(i).getfY();
			
			Node node = new Node(id, name, x, y);
			list.add(node);
		}
		setEdges();
	}
	
	private void setEdges(){
		
		for(int i=0; i<list.size(); i++){
			ArrayList<Edge> eList = new ArrayList<Edge>();
			for(int j=0; j<list.size(); j++){
				if(list.get(i).getId() != list.get(j).getId()){
					int from = list.get(i).getId();
					int to = list.get(j).getId();
					
					int x1 = list.get(i).getX();
					int y1 = list.get(i).getY();
					int x2 = list.get(j).getX();
					int y2 = list.get(j).getY();
					
					Edge edge = new Edge(from, to);
					edge.setLength(x1, y1, x2, y2);
					eList.add(edge);
				}
			}
			list.get(i).setEdges(eList);
		}
	}
	
	public ArrayList<Integer> findRootUsingPrimAlgorithm(){
		ArrayList<Integer> path = new ArrayList<Integer>();
		int index = 0;
		ArrayList<Integer> visitList = new ArrayList<Integer>();

		list.get(index).setParent(null);
//		System.out.println(list.size());
		for(int i=0; i<list.size(); i++){
			path.add(list.get(index).getId());
			int to = findShortestEdge(list.get(index).getEdges(), visitList);
			list.get(index).setVisit(true);
			visitList.add(list.get(index).getId());
			index = findNextNode(to);
		}
		System.out.println(visitList.toString());
		System.out.println(path.toString());
		return path;
	}
	
	private int findNextNode(int to){
		for(int i=0; i<list.size(); i++){
			if(list.get(i).getId() == to){
				return i;
			}
		}
		return -1;
	}
	
	private int findShortestEdge(ArrayList<Edge> eList, ArrayList<Integer> visitList){
		double min = 100000;
		int result = 0;
		
		for(int i=0; i<eList.size(); i++){
			if(min > eList.get(i).getLength() && visitCheck(eList.get(i).getTo(), visitList)){
				min = eList.get(i).getLength();
				result = eList.get(i).getTo();
			}
		}
		
		return result;
	}
	
	private boolean visitCheck(int id, ArrayList<Integer> visitList){
		for(int i=0; i<visitList.size(); i++){
			if(id == visitList.get(i)){
				return false;
			}
		}
		return true;
	}
	@Override
	public String toString() {
		return "PrimAlgorithm [list=" + list + "]\n";
	}
	
	
}
