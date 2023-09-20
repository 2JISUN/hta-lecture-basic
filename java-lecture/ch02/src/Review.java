import java.util.Scanner;

public class Review {
	public static void main(String[] args) {
		

		// 3. 별 찍기
		Scanner input = new Scanner(System.in);
		int star = input.nextInt();

		for (int i=star; i>1;i--){
			for (int j=1; j<=star;j++) {
				System.out.print("*");

			}
			System.out.println("");
		}

	}
}
