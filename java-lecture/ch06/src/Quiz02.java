import java.util.ArrayList;
import java.util.Scanner;

public class Quiz02 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		// char ch = input.next().charAt(0);

		// System.out.println(ch);
		// System.out.println((int)ch);

		int sum = 0;
		for(int i = 1; i<6+1; i++){
			System.out.printf("%d번째 알파벳입니다. 6개를 입력하면 종료되면 아스키코드의 평균값으로 리턴됩니다.", i);
			char ch = input.next().charAt(0);
			int asc = (int)ch;
			sum += asc;

		}
		System.out.println(sum/6);


		
	}


}
