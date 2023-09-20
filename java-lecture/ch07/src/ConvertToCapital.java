import java.io.*;

public class ConvertToCapital {
	public static void main(String[] args) {
		String filePath = "C:\\Windows\\system.ini";

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
			StringBuilder stringConvertor = new StringBuilder();


			String line;
			while((line = bufferedReader.readLine()) != null){
				stringConvertor.append(line).append("\n");
			}

			bufferedReader.close();

			String capitalizedString = stringConvertor.toString().toUpperCase();
			System.out.println(capitalizedString);

			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
