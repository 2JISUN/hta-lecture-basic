import java.util.Scanner;

public class StrCountList {

		public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine().trim();

		if(str.isEmpty()){
			System.out.println('0');
		}else{
			String delimiter = " ";
			String[] strArray = str.split(delimiter); 
			System.out.println(strArray.length);
		}

		input.close();

	}
	
}
