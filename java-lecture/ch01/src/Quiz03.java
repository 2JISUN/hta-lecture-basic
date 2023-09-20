import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		

		int ten = num/10;
		int one = num%10;

		if (ten == 3 || ten == 6 || ten == 9) {
			String tenResult = "짝";
			System.out.println(tenResult);
		} else {
			String tenResult = "";
			System.out.println(tenResult);
		}
		
		
		if (one == 3 || one == 6 || one == 9) {
			String oneResult = "짝";
			System.out.println(oneResult);
		} else {
			String oneResult = "";
			System.out.println(oneResult);
		}
		System.out.println();

		input.close();
	}
	
}
