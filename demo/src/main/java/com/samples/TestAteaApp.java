package com.samples;

public class TestAteaApp {

	public static void main(String[] args) {
		TotalArea TrianglAarea=new Triangle(6,5);
		TotalArea RectangleAarea=new Rectangle(6,5);
		
		
		double total_area=TrianglAarea.totalAreaCounter()+RectangleAarea.totalAreaCounter();
		
		System.out.println("Total Area==> "+total_area);
		
		
		System.out.println("Total Area:"+(int)(TrianglAarea.totalAreaCounter()+RectangleAarea.totalAreaCounter()));
		

	}

}
