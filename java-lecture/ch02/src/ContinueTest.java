import java.util.Scanner;

public class ContinueTest {
	public static void main(String[] args) {
		//다섯개의 정수를 입력받겠다.
		// 이때 양의 정수의 합만 구하시오.

		Scanner input = new Scanner(System.in);
		
		int sum = 0 ;
	
			for (int i =1; i<=5; i++){

				int num = input.nextInt();
				if (num<0) {
					continue;
				} else {
				sum +=num;
			}
		}
		System.out.println("양의 정수의 합 : " + sum);
		input.close(); 

	}
}
