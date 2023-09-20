import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTest {
	public static void main(String[] args) {
		LocalDate nowDate = LocalDate.now();
		LocalTime nowTime = LocalTime.now();
		LocalDateTime nowDateTime = LocalDateTime.now();
		System.out.println(nowDate); //2023-08-22
		System.out.println(nowDate.getYear()); //2023
		System.out.println(nowTime); //10:32:58.527919400
		System.out.println(nowDateTime); //2023-08-22T10:32:58.527919400
		System.out.printf("%d년%d월%d일",nowDate.getYear(),nowDate.getMonthValue(),nowDate.getDayOfMonth()); 
		System.out.println(nowDateTime.format(DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss"))); //2023년8월22일2023/08/22 10:41:30

		ZonedDateTime seoulDateTime = ZonedDateTime.now(ZoneId.of("America/Chicago"));
		System.out.println(seoulDateTime);
		
	











	}
}
