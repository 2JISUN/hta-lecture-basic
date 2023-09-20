import java.util.Scanner;

public class Quiz05 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int month = input.nextInt();
		String season ="";

		switch(month){
			case 12 :
			case 1 :
			case 2 :
			season = "겨울⛄";

				break;
			case 3 :
			case 4 :
			case 5 :
			season = "봄🌻";

				break;
			case 6 :
			case 7 :
			case 8 :
			season = "여름🏊‍♂️";

				break;
			case 9 :
			case 10 :
			case 11 :
			season = "가을🍂";
				
				break;
			default:
				season = "없음";

		}
		System.out.println(month +"월의 계절은 " + season + " 입니다.");


		input.close();




	}
}
