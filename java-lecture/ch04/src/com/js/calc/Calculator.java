package com.js.calc;

abstract public class Calculator {
	public abstract int add (int a, int b);
	public abstract int subtract (int a, int b);
	public abstract double average (int[] array);	
}


class SamsungCalculator extends Calculator {

	@Override
	public int add(int a, int b) {
		return 0;
	}

	@Override
	public int subtract(int a, int b) {
		return a>b? a-b : b-a;
	}

	@Override
	public double average(int[] array) {
		double sum = 0;
		for(int i =0; i<array.length; i++){
			sum += array[i];
		}
		return sum / array.length;
	}

	public static void main(String[] args) {
		SamsungCalculator sc = new SamsungCalculator();
		System.out.println(sc.subtract(5,10));

	}
	
}

class LgCalculator extends Calculator {

	@Override
	public int add(int a, int b) {
		return 0;

	}

	@Override
	public int subtract(int a, int b) {
		return 0;
	}

	@Override
	public double average(int[] array) {
		return 0;
	}
	
}