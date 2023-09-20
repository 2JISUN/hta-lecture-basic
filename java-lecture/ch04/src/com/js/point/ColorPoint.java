package com.js.point;

public class ColorPoint extends Point {
	private String color;
	ColorPoint(int x, int y, String color) {
		super(x, y);
		this.color = color;
	}

	void showColorPoint() {
		System.out.println(color);
		showPoint();
	}



}
