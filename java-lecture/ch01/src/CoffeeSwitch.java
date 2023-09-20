import java.util.Scanner;

public class CoffeeSwitch {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);

		String coffeeMenu = input.next();
		int price = 0;

		switch(coffeeMenu){
			case "아메리카노" :
				price = 3000;
				System.out.println("주문하신 " + coffeeMenu +" 의 가격은" + price + "입니다.");
				break;
			case "카푸치노" :
				price = 4000;
				System.out.println("주문하신 " + coffeeMenu +" 의 가격은" + price + "입니다.");
				break;
			default:
			System.out.println("없습니다.");
		}
		input.close();


	}
}
