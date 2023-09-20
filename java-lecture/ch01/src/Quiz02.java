import java.util.Scanner;

public class Quiz02 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int won = input.nextInt();

		int 오만원몇장 = won/50000;
		  int 만원몇장 = (won%50000)/10000;
		int 오천원몇장 = ((won%50000)%10000)/5000;
		  int 천원몇장 = (((won%50000)%10000)%5000)/1000;
		int 오백원몇개 = ((((won%50000)%10000)%5000)%1000)/500;
		  int 백원몇개 = (((((won%50000)%10000)%5000)%1000)%500)/100;
		int 오십원몇개 = ((((((won%50000)%10000)%5000)%1000)%500)%100)/50;
		  int 십원몇개 = (((((((won%50000)%10000)%5000)%1000)%500)%100)%50)/10;

		System.out.println("오만원:" + 오만원몇장);
		System.out.println("일만원:" + 만원몇장);
		System.out.println("오천원:" + 오천원몇장);
		System.out.println("천원:" + 천원몇장);
		System.out.println("오백원:" + 오백원몇개);
		System.out.println("백원:" + 백원몇개 );
		System.out.println("오십원:" + 오십원몇개);
		System.out.println("십원:" + 십원몇개);

		input.close();


	}
}
