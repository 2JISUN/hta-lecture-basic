import java.util.Scanner;

public class WonToDollor {
	public static void main(String[] args) {
		// 변하지 않는 더블 타입의 상수 rate 1380
		// 정수 won을 입력받아서 
		// 1,870,000 won이 몇 dollor인지 알려주기

		// input
		Scanner input = new Scanner(System.in);
		int won = input.nextInt();

		// 1달러 = 1380원
		// 1원 = 1/1380달러
		final double rate = 1380.0;
		double dollar = won / rate;

		
		


		System.out.println(dollar );
		input.close();



		
	}
}
