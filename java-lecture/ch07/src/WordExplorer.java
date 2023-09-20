import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordExplorer {
	public static void main(String[] args) {
		// 파일 경로 설정
		String filePath = "C:\\temp\\words.txt";
		
		try {
			// 파일 읽기
			File file = new File(filePath);
			FileReader fileReader = new FileReader(file);
			Scanner scannerReader = new Scanner(fileReader); // 파일을 줄 단위로 읽음 (원하는 형식으로 데이터를 추출)

			// 검색할 문자 입력 받기
			Scanner input = new Scanner(System.in);
			System.out.print("검색할 문자를 입력하세요: ");
			String targetWord = input.nextLine();



			//검색된 단어 출력
			System.out.println("검색된 문자 < " + targetWord + " > 를 포함하는 단어들 : ");

			while (scannerReader.hasNext()) {
				String word = scannerReader.next();
				if(word.toLowerCase().contains(targetWord.toLowerCase())){
					System.out.println(word);
				}
			}

			// 자원 해제
			scannerReader.close();
			fileReader.close();
			input.close();	
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
