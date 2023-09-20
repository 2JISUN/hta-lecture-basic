import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {
	public static void main(String[] args) {
		
		File sourceImg = new File("C:\\temp\\cha.png");
		File copyImg = new File("C:\\temp\\copy-cha.png");
	
		try {
			if(!copyImg.exists()){
				copyImg.createNewFile();
				FileInputStream fileInputStream = new FileInputStream(sourceImg);
				FileOutputStream fileOutputStream = new FileOutputStream(copyImg);
				int c;
				while ((c = fileInputStream.read()) != -1) {
					fileOutputStream.write((byte) c);
				}
				fileInputStream.close();
				fileOutputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
