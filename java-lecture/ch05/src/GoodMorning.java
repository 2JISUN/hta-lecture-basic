import java.util.Calendar;

public class GoodMorning {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		int hour = calendar.get(Calendar.HOUR_OF_DAY);
		System.out.println(hour);

		String greeting;

		if (hour >= 5 && hour <= 11) {
            greeting = "좋은 아침";
        } else if (hour >= 12 && hour <= 17) {
            greeting = "좋은 오후";
        } else if (hour >= 18 && hour <= 21) {
            greeting = "좋은 저녁";
        } else{
            greeting = "잘자라";
        }

		System.out.println(greeting);




	}
}
