import java.io.*;

public class PhoneRead {
	public static void main(String[] args) {
        BufferedReader br = null;

        File f = new File("C:\\temp\\phone.txt");

        try {
            br = new BufferedReader(new FileReader(f));
            long before = System.currentTimeMillis();

            while (true) {
                String line = br.readLine();
                if (line == null) {
                    break;
                } 
                System.out.println(line);
            }
            long after = System.currentTimeMillis();
            System.out.println(after-before);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

	
}
