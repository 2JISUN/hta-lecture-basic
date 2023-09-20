package com.js.converter;

import java.util.Scanner;

abstract public class Converter {
	abstract public double convert(double src);
	abstract public String srcString();
	abstract public String destString();

	public double ratio;


	public void run() {
		Scanner input = new Scanner(System.in);
		System.out.printf("%s를 %s로 환전해 드리겠습니다", this.srcString(), this.destString());
		System.out.printf("%s를 입력하세요.%n ",this.srcString());
		double inputWon = input.nextDouble();
		double changedMoney = convert(inputWon);
		System.out.printf("환전된 금액은%f%s입니다.",changedMoney, this.destString());

	}
	
}
