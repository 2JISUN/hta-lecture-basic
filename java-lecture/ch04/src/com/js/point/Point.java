package com.js.point;
/**
 * Point
 * 메인 메소드 생성 x
 */

//  
public class Point {
	// 필드,속성,변수
	private int x,y;

	public Point(){

	}


	// 메서드(일반, 리턴X)
	public void set(int x, int y){
		this.x = x;
		this.y = y;
	}

	// 메서드 : 출력 (일반, 리턴X)
	void showPoint() {
		System.out.printf("(%d,%d)",x,y);
	}

}