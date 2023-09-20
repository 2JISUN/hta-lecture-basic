import java.util.Scanner;

public class Above80 {
	public static void main(String[] args) {
		// 키보드로부터 정수를 입력받아 80 이상이면 합격 아니면 불합격 출력해보기

		Scanner input = new Scanner(System.in);
			System.out.println("정수를 입력하면 [합격/불합격] 여부를 알려드리겠습니다.");

			int score = input.nextInt();
			
			if (score >= 80){
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
			input.close();

	}
	
}
