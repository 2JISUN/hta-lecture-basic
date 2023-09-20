import java.util.Scanner;

public class DivideZero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("분모를 입력하시오");
		int denominatorInput = sc.nextInt();
		System.out.println("분자를 입력하시오");
		int numeratorInput = sc.nextInt();

		try {
			System.out.println(denominatorInput + " / " + numeratorInput + " = " +denominatorInput/numeratorInput);		
		} catch (Exception e) {
			System.out.println("오류를 확인하세요");
			e.printStackTrace();
		}
	}
}
