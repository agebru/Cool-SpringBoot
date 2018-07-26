package com.samples;

public class Triangle extends TotalArea {
	private int height;
	private int width;
	
	public Triangle() {
		
	}
	
public Triangle(int height,int width) {
		this.height=height;
		this.width=width;
	}

	@Override
	public double totalAreaCounter() {
		return 0.5*height*width;
	}

}
