import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneExplorer {
	public static void main(String[] args) {
		Map <String, String> phoneMap = new HashMap<>();
		File file = new File("C:\\temp\\phone.txt");



		try {
			FileReader fileReader = new FileReader(file);
			Scanner scanner = new Scanner(fileReader);
			System.out.println(file.getPath()+"를 출력합니다.");
			while(scanner.hasNext()){
				String str = scanner.nextLine();
				System.out.println(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
