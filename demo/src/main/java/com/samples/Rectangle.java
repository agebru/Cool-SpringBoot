package com.samples;

public class Rectangle extends TotalArea {
	private int height;
	private int width;
	
	public Rectangle() {
		
	}
	
public Rectangle(int height,int width) {
		this.height=height;
		this.width=width;
	}

	@Override
	public double totalAreaCounter() {
		return height*width;
	}

}
