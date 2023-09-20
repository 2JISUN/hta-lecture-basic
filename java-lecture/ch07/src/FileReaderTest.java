import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
	public static void main(String[] args) {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("C:\\Windows\\system.ini");
			int c;
			while ((c = fileReader.read()) != -1) {
				System.out.println(c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
