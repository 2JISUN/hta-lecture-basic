import java.util.Scanner;

public class Quiz06 {
	public static void main(String[] args) {
		System.out.println("숫자 3개를 입력하면 가운데 숫자를 알려드립니다.");


		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		int center = a;
		if((a>=b&&a<=c)||(a>=c&&a<=b)){
			center = a;
		} else if((b>=a&&b<=c)||(b>=c&&b<=a)){
			center = b;
		}else {
			center = c;
		}


		System.out.println("가운데 숫자는? " + center );


		input.close();
		
	}
}
