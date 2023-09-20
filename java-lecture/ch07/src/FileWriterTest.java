import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest {
	public static void main(String[] args) {
        String filePath = "C:\\temp\\testwrite.txt";

        try (FileWriter fileWriter = new FileWriter(filePath);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter the text you want to write to the file (Enter two empty lines to finish):");

            int emptyLineCount = 0;
            while (emptyLineCount < 2) {
                String line = scanner.nextLine();
                if (line.isEmpty()) {
                    emptyLineCount++;
                } else {
                    emptyLineCount = 0;
                    fileWriter.write(line + "\n");
                }
            }

            System.out.println("File written successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}