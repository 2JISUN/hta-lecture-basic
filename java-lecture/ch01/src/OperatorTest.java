import java.util.Scanner;

public class OperatorTest {
	public static void main(String[] args) {
		// 초를 정수로 입력받기
		// 5000s = 몇 시간 / 몇 분 / 몇 초
		Scanner input = new Scanner(System.in);
		System.out.println("초를 입력하면 시/분/초로 알려드립니다");
// 입력받을 시간(초)
		int temp = input.nextInt();
		
		int sec = temp%60;
		int min = (temp/60)%60;
		int hour = (temp/60)/60;
		

		System.out.println(temp + "초는 " + hour + "시 "+ min + "분 "+ sec+ "초");

		input.close();


	}
}
