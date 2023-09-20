import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextCopy {
	public static void main(String[] args) {
		File sourceFile = new File("C:\\windows\\system.ini");
		File copyFile = new File("C:\\temp\\system.txt");

		try {
			if (!copyFile.exists()){

				copyFile.createNewFile();
			}
			int c;
			FileReader fileReader = new FileReader(sourceFile);
			FileWriter fileWriter = new FileWriter(copyFile);
			while((c = fileReader.read()) != -1){
				fileWriter.write((char) c);
			}
			fileWriter.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
