package com.js.shape;


abstract class Shape {
	public void draw() {
		System.out.println("Shape");
	}
}

class Line extends Shape {

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Line");
	}
}


class Reac extends Shape {
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Reac");
	}

}


class Weapon {
	int fire(){
		return 1;

	}

}

class Canon extends Weapon {
	int fire(){
		return 10;
	}

}

public class MethodOverrideTest {

	public static void main(String[] args) {
		// new Shape().draw();
		// new Line().draw();
		// Shape line = new Line();
		// line.draw();

		Weapon weapon ;
		weapon = new Weapon();
		System.out.printf("기본 무기의 파워는 %d", weapon.fire());
		
		weapon = new Canon();
		System.out.printf("캐논 무기의 파워는 %d", weapon.fire());
		


	
	}
	
}
