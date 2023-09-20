package com.js.calc;

import java.util.Scanner;

// Add, Mul, Sub ,Div > 4개의 클래스를 만들기

class Add extends Calc {
	@Override
	int calculate() {
		return a+b;
	}}

class Mul extends Calc {
	@Override
	int calculate() {
		return a*b;
	}}

class Sub extends Calc {
	@Override
	int calculate() {
		return a-b;
	}}

class Div extends Calc {
	@Override
	int calculate() {
		return a/b;
	}



}




public class MyCalculator {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.ins);
		System.out.println("정수 두개를 입력하고 연산자를 입력하시오.");

		int a = input.nextInt();
		int b = input.nextInt();
		String operator = input.next();
		
		Calc exp = null;
		int result = 0;
		switch(operator){
			case "+":
				exp = new Add();
				break;
			case "*":
				exp = new Mul();
				break;
			case "-":
				exp = new Sub();
				break;
			case "/":
				exp = new Div();
				break;

		}
		exp.setValue(a,b);
		result = exp.calculate();
		System.out.println(result);
	}
}
