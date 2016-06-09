package com.mart.model;

public class Edge {
	private int from;
	private int to;
	private double length;
	
	public Edge(){}

	public Edge(int from, int to) {
		this.from = from;
		this.to = to;
	}

	public int getFrom() {return from;}
	public void setFrom(int from) {this.from = from;}

	public int getTo() {return to;}
	public void setTo(int to) {this.to = to;}

	public double getLength() {return length;}
	public void setLength(int x1, int y1, int x2, int y2) {
		int xDif = x1-x2;
		int yDif = y1-y2;
		this.length = Math.sqrt(xDif*xDif + yDif*yDif);
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", length=" + length + "]\n";
	}
	
	
	
	
}
