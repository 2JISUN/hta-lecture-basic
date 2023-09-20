import java.util.*;

public class Quiz06 {
	public static void main(String[] args) {

		// 데이터 map에 저장해두기
		HashMap<String, String> coCaList = new HashMap<>();
		coCaList.put("대한민국", "서울");
		coCaList.put("중국", "베이징");
		coCaList.put("일본", "도쿄");
		coCaList.put("프랑스", "파리");
		coCaList.put("독일", "베를린");
		coCaList.put("미국", "워싱턴");

		
		Scanner input = new Scanner(System.in);
		Random random = new Random();

		System.out.println("수도를 맞춰보세요! (*그만* 입력시 종료)");

		while (true) {
			// 랜덤한 키 선택
			int randomIndex = random.nextInt(coCaList.size());
			String randomCon = (String) coCaList.keySet().toArray()[randomIndex];

			System.out.printf("%s의 수도는? ",randomCon);
	
			String userAnswer = input.nextLine(); //입력받기		
			if (userAnswer.equals("그만")){
				System.out.println("종료합니다.");
				break;
			} 
			
			String correctAnswer = coCaList.get(randomCon); //랜덤
			if(userAnswer.equals(correctAnswer)){
				System.out.println("딩동댕");
			} else {
				System.out.println("땡! 정답 : " + correctAnswer );
			}
			
		}
		input.close();
	}
}
