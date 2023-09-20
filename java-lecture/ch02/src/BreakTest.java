import java.util.Scanner;

public class BreakTest {
	public static void main(String[] args) {
		// exit가 입렫뇌면 종료합니다. 출력하기

		Scanner input = new Scanner(System.in);
		
		while (true) {
			String letter = input.next() ;

			if (letter.equals("exit")) {
				System.out.println("입력을 종료합니다.");
				break;
			} else {
				System.out.println(letter);
				System.out.println("exit을 입력하면 종료합니다");
			}
		}
		input.close(); 
	}
}
