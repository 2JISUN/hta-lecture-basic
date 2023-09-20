import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class HangMan {
	public static void main(String[] args) {
		// 파일 경로 설정
		String filePath = "C:\\temp\\words.txt";

		try {
			// 1. 파일 읽어와서 list로 저장
			// 객체생성 : 파일 읽기
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			Scanner scReader = new Scanner(fileReader);


			// 파일 안의 영단어 저장할 리스트 생성
			ArrayList<String> wordList =new ArrayList<>();
			while (scReader.hasNext()) {
				wordList.add(scReader.nextLine());
			}

			// 2. list에 저장된 단어에서 한 글자를 마스킹처리
			// 객체생성 : 랜덤, 글자변환(문자 → '_'), 입력
			Scanner input = new Scanner(System.in);
			Random random = new Random();
			StringBuilder maskedWord = new StringBuilder();


			// 영단어 랜덤으로 선택하고 문자 변경
			while (true) {
				// 영단어 랜덤 선택
				String randomWord = wordList.get(random.nextInt(wordList.size()));

				// 영단어 랜덤 선택 > 랜덤 문자를 인덱스로 선택
				int randomIndex = random.nextInt(randomWord.length());

				// 영단어 랜덤 선택 > 랜덤 문자를 인덱스로 선택 > '_'로 변환(마스킹처리)
				maskedWord.setLength(0); // 기존의 maskedWord 초기화
				for(int i = 0; i<randomWord.length(); i++){
					if(i==randomIndex){
						maskedWord.append('_'); // 랜덤 인덱스의 문자를 '_'로 대체하여 추가

					} else {
						maskedWord.append(randomWord.charAt(i)); // 나머지 문자 그대로 추가
					}
				}
				
				// 3. 프로그램 실행하면 입력받기 
				while (true) {
					System.out.println("빈칸에 들어갈 문자를 입력하세요.");
					System.out.println("랜덤으로 선택된 단어: " + maskedWord);

					// 문자 입력하기
					String inputString = input.next();

					// 한 문자를 입력받고 랜덤으로 마스킹처리된 문자가 동일한지 확인
					char guess = inputString.charAt(0);
					if (randomWord.charAt(randomIndex) == guess) {
						maskedWord.setCharAt(randomIndex, guess);
						System.out.println("정답\n");

						// 추가 기능 : 게임 지속할지 물어보기
						System.out.print("더하시려면 y, 그만하시려면 n을 입력해주세요: ");
						String continueGame = input.next();
						if(continueGame.equals("n")){
							System.out.println("게임을 종료합니다.");
							input.close();
							return;
						} else{
							break; // 새로운 단어로 게임을 이어감
						}
					} else {
						System.out.println("오답\n");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
