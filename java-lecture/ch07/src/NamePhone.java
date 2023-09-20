import java.util.Scanner;
import java.io.*;


public class NamePhone {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String filePath = "C:\\temp\\phone.txt";

		// 입력받아서 파일 저장하기
		
		long before = System.currentTimeMillis();
		try {
			FileWriter fileWriter = new FileWriter(filePath);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

			while (true) {
				System.out.println("이름을 입력하세요. ('그만'을 입력 시 종료) : ");
				String name = input.nextLine();
				if (name.equals("그만")){
					System.out.println("입력을 종료합니다.");
					break;
				}

				System.out.println("전화번호를 입력하세요. : ");
				String phoneNumber = input.nextLine();

				bufferedWriter.write(name + "," + phoneNumber);
				bufferedWriter.newLine();
			}
			System.out.println("전화번호 정보를 파일에 저장했습니다.");
			bufferedWriter.close(); // 파일 작성 완료

		} catch (IOException e) {
			e.printStackTrace();
		}
		long after = System.currentTimeMillis();
		System.out.println(after-before);


		// 저장한 파일의 내용을 출력하기
		long before02 = System.currentTimeMillis();
		System.out.println("전화번호부 내용 : ");
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

			String line;
			while ((line = bufferedReader.readLine()) != null) {	
				String[] parts =line.split(",");
				if (parts.length == 2) {
					System.out.printf("%s의 전화번호는 %s 입니다. %n", parts[0],parts[1]);
				}
			}
			bufferedReader.close(); // 파일 읽기 완료
		} catch (IOException e) {
			e.printStackTrace();	
		}
		long after02 = System.currentTimeMillis();
		System.out.println(before02-after02);

		input.close();
	}
}
