import java.util.Scanner;

public class StrCount {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = input.nextLine().trim();

		if(str.isEmpty()){
			System.out.println('0');
		}else{
			System.out.println(str.split(" ").length);
		}

		input.close();

	}


}
