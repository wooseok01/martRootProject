package com.mart.model;

import java.util.ArrayList;

public class Node {
	private int id;
	private String name;
	private Node parent;
	private boolean visit;
	private int x;
	private int y;
	private ArrayList<Edge> edges;
	
	public Node(){}

	public Node(int id, String name, int x, int y){
		this.id = id;
		this.name = name;
		this.visit = false;
		this.x = x;
		this.y = y;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public Node getParent() {return parent;}
	public void setParent(Node parent) {this.parent = parent;}

	public boolean isVisit() {return visit;}
	public void setVisit(boolean visit) {this.visit = visit;}

	public int getX() {return x;}
	public void setX(int x) {this.x = x;}

	public int getY() {return y;}
	public void setY(int y) {this.y = y;}

	public ArrayList<Edge> getEdges() {return edges;}
	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public String toString() {
		String str = "Node [id=" + id + ", name=" + name + ", parent=";
		if(parent != null){
			str += parent.getName();
		}else{
			str += "null";
		}
		str += ", visit=" + visit + ", x=" + x + ", y=" + y
				+ ", edges=" + edges + "]\n";
		return  str;
	}
	
	
	
	
}
