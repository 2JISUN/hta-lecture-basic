import java.util.Scanner;

public class WhileTest {
	public static void main(String[] args) {

		// int i = 0;
		// while (i<10) {
		// 	System.out.print(i);
		// 	i++;
		// }
		// 정수를 입력받는다. 이때 -1을 입력하면 종료한다
		// 메모리에 미리 올라가 있는 것들 static
		// 입력받은 정수의 평균 구하기...

		Scanner input = new Scanner(System.in);

		
		int sum = 0;
		int count = 0;
		while (true) {
			int num = input.nextInt();
			if (num==-1) break;

			sum += num;
			count++;
		}

		System.out.println("입력한 값의 합 : "+sum);
		System.out.println("입력한 값의 평균 : "+((double) sum/count));

		System.out.print("입력한 값의 합 : "+sum);
		System.out.print("입력한 값의 평균 : "+sum/count);
		



		input.close(); 



	}
}
