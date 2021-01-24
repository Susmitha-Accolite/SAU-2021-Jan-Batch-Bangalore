package com.au.spring;

import java.util.HashSet;
import java.util.Map;

public class Triangle {
	
//	private HashSet<Point> points;
//	
//	public HashSet<Point> getPoints() {
//		return points;
//	}
//	
//	public void setPoints(HashSet<Point> points){
//		this.points = points;
//	}
	
	private Map<String,Point> points;
	public Map<String, Point> getPoints() {
		return points;
	}
	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}
	
	public void draw() {
		
//		for(Point point : points) {
//			System.out.println(point.getX()+" "+point.getY());
//		}
//		
		for(Map.Entry<String, Point> entry: points.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue().getX() +"\t" +entry.getValue().getY());
		} 

		
	}

}
