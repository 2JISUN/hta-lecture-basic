package com.js.calc;

public abstract class Calc {
	// 필드
	public int a,b;
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	abstract int calculate();


	
}
