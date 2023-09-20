import java.util.Scanner;

public class TryCatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum =0;

		for(int i =0; i<3; i++){
			try {
			int num = sc.nextInt();
			sum += num;
			} catch (Exception e) {
			System.out.println("정수를 입력해주세요.");
			sc.next(); // 잘못 입력된 값 버리기
			i--; // 현재 반복 회차를 다시 실행하기 위해 loop의 횟수를 감소시킨다
			}
		}
		System.out.println(sum);
	}
}
