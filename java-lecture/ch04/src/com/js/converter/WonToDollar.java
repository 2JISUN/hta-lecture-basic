package com.js.converter;

import java.util.Scanner;

abstract class Coverter {

	abstract public double convert(double src);
	abstract public String srcString();
	abstract public String destString();

	public double ratio;


	public void run() {
		Scanner input = new Scanner(System.in);
		System.out.printf("%s를 %s로 환전해 드리겠습니다", this.srcString(), this.destString());
		System.out.printf("%s를 입력하세요.",this.srcString());
		double inputWon = input.nextDouble();
		double changedMoney = convert(inputWon);
		System.out.printf("환전된 금액은%f%s입니다.",changedMoney, this.destString());

	}

}

public class WonToDollar extends Coverter {

	public WonToDollar(double ratio){
		this.ratio = ratio;
	}


	@Override
	public double convert(double src) {
		return src / ratio;
	}

	@Override
	public String destString() {
		return "달러";
	}

	@Override
	public String srcString() {
		return "원";
	}

	public static void main(String[] args) {
		WonToDollar wonToDollar  = new WonToDollar(1380);
		wonToDollar.run();
	}


}
