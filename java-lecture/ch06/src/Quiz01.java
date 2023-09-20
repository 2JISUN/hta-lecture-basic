import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
// import java.util.Vector;

public class Quiz01 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		ArrayList<Integer> intArray = new ArrayList<>();
		// Vector<Integer> intArray = new Vector<>();

		while (true) {
			System.out.println("정수를 입력하세요. -1를 입력하면 종료합니다.");
			int n = input.nextInt();
			if(n==-1){
				break;
			}
			intArray.add(n);
		}
		



		// int max = intArray.get(0);
		// for (int i = 1; i< intArray.size(); i++){
		// 	if (intArray.get(i)>max){
		// 		max = intArray.get(i);
		// 	}
		// }


		Collections.sort(intArray); // 내림차순
		Collections.sort(intArray, Collections.reverseOrder());
		System.out.println(intArray.get(0));
		

	}

}
