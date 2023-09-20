import java.util.Scanner;

public class Coffee {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// 입력받는 커피메뉴
		String coffeeMenu = input.next();

		// 가격 타입을 우선 정해줌
		int price = 0;

		// 문자열 비교는 메서드를 이용해야함
		if(coffeeMenu.equals("아메리카노")) {
			price = 2000;
		} else if(coffeeMenu.equals("카푸치노")) {
			price = 3000;
		}


		System.out.println("주문하신 " + coffeeMenu + " 가격은" + price + " 입니다.");
		input.close();

	}
}
