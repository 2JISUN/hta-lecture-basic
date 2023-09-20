import java.util.Scanner;


public class StrRandom {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("문자열을 입력하세요.");

		String str = input.nextLine();


		// 입력받는 문자의 개수를 정하기 : ASCII 문자 범위
		int[] strCount = new int[256];


		// 문자열 내 각 문자의 등장 횟수를 세기 위한 루프
		for(char c : str.toCharArray()){ // c는 ASCII 문자의 index
			strCount[c]++; //문자열을 한글자씩 쪼개서 배열에 넣어준다
		}
		System.out.println(strCount[59]); // 세미콜론 몇개인가요?
		System.out.println(strCount[42]); // * 몇개인가요?


	
		// 결과값을 출력
		System.out.println("각 문자의 등장 횟수: ");
		for (int i =0; i<strCount.length; i++) {
			if (strCount[i]>0) {
				System.out.println((char)i + " : " + strCount[i] + "개");
			}
		}


		

		input.close();

	}
}

