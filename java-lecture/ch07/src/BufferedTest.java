import java.io.BufferedOutputStream;
import java.io.FileReader;

public class BufferedTest {
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("C:\\temp\\test.txt");
			// 이미지의 경우 버퍼를 많이 사용한다.(용량이 크기 때문에..)
			BufferedOutputStream bOutputStream = new BufferedOutputStream(System.out, 5);
			int c;
			while ((c = fileReader.read()) != -1) {
				bOutputStream.write(c);				
			}
			bOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
