import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		// 카렌다는 추상 클래스이기 때문에 new로 객체를 생성하지 않는다

		String[] monthArray = { "일월","이월","삼월","사월","오월","유월","칠월","팔월","구월","시월","십일월","십이월"};

		String[] dayArray = { "일","월","화","수","목","금","토","일"};

		Calendar calendar = Calendar.getInstance();

		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DAY_OF_MONTH);
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		int hour = calendar.get(Calendar.HOUR); //12
		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY); //24
		int ampm = calendar.get(Calendar.AM_PM); //오전0 / 오후1
		int min = calendar.get(Calendar.MINUTE); //오전0 / 오후1
		int sec = calendar.get(Calendar.SECOND); //오전0 / 오후1


		System.out.println(year + "/" + (month+1));
		System.out.println(year + "/" + monthArray[month]);
		System.out.println(year + "/" + monthArray[month] + "/" + date + "/" + dayArray[day-1] + "/" + hourOfDay + "시/" + min + "분/" + sec + "초");
		System.out.println(hour);
		System.out.println(hourOfDay);
		System.out.println(ampm);



		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String myDate =	simpleDateFormat.format(calendar.getTime());
		System.out.println(myDate);



		// 시간에 따라 인사말 구분
		
        Date currentTime = calendar.getTime();


		SimpleDateFormat dateFormat = new SimpleDateFormat("HH");

        int hour = Integer.parseInt(dateFormat.format(currentTime));

        String greeting;

        if (hour >= 5 && hour <= 11) {
            greeting = "좋은 아침";
        } else if (hour >= 12 && hour <= 17) {
            greeting = "좋은 오후ㅋ";
        } else {
            greeting = "안녕하세요";
        }

        System.out.println(greeting);



		
	
	}
}


	
