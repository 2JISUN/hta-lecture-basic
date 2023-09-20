import java.util.Scanner;

public class IntegerError {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 전역변수로 설정해주기!!
		int num1 =0;
		int num2 =0;
		char operator = '\0'; //초기화(null)
		
		try {
			num1 = sc.nextInt();
			num2 = sc.nextInt();
			operator = sc.next().charAt(0);
		} catch (Exception e) {
			System.out.println("정수를 입력해주세요.");
			sc.nextLine(); // 버퍼 비우기
            return; // 예외 발생 시 프로그램 종료
		}

		switch (operator) {
			case '+':
				System.out.println(num1+num2);
				break;
			case '-':
				System.out.println(num1-num2);
				break;
			case '*':
				System.out.println(num1*num2);
				break;
			case '/':
				if(num2==0){
					System.out.println("0으로 나눌 수 없습니다");
				} else {
					System.out.println((double) num1/num2);
				}
				


				break;
			default:
			System.out.println("올바른 사칙연산 기호를 입력해주세요.");
			
		}






	}
}
