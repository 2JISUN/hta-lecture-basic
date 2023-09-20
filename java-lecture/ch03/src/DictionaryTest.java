import java.util.Scanner;

class Dictionary {
	static String kor[]={"사과", "자두", "포도"};
	static String eng[]={"apple", "plum", "grape"};

	public static String korToEng(String word) {
		for(int i = 0;i<kor.length;i++) {
			if (kor[i].equals(word)){
				return eng[i];
			}
		}
		return null;
	}

}


public class DictionaryTest {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("한글 단어를 입력하세요");
			System.out.println("'그만'을 입력하면 중지합니다");
			String kor = input.next();
			if (kor.equals("그만"))
			break;
			
			String eng = Dictionary.korToEng(kor);
			if (eng == null) {
				System.out.println("없는 단어입니다. 다시 입력해 주세요.");
			} else {
				System.out.println(kor + "의 영어는" + eng + "입니다.");
			}
			// 그만 입력하면 빠져나가기..
			// 맞는 단어 있으면 영어로 돌려주기..
			// 없으면 없는 단어입니다. 출력하기..
		}
		// Dictionary.korToEng(null);
	}
	
}
