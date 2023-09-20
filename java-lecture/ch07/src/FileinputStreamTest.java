import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileinputStreamTest {
	public static void main(String[] args) {
		String filePath = "C:\\temp\\test.txt";

		// try-catch 파일이 존재하지 않는 경우 예외 처리를 시켜주어야 함
		try {
			FileInputStream fileInputStream = new FileInputStream(filePath);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
			int charCode;
			while ((charCode = inputStreamReader.read()) != -1) {
				System.out.print((char) charCode);

			}


		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
}
