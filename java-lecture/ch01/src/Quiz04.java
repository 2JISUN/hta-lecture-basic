import java.util.Scanner;

public class Quiz04 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int y = input.nextInt();

		if ((y%4==0 && y%100!=0 )|| y%400==0) {
			System.out.println("윤년");

		} else {
			System.out.println("평년");
		}
		input.close();
	}
}
