import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Quiz01 {
	public static void main(String[] args) {
		String filePath = "C:\\temp\\test04.txt";
		String content = "hello java";

		File file = new File(filePath);

		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(content);
			System.out.println("파일이 성공적으로 저장되었습니다.");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
