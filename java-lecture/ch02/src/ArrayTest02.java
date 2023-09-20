import java.util.Scanner;

public class ArrayTest02 {
	public static void main(String[] args) {
		// int intArray[] = {10,20,30,40,50,60,70,80,90,100};

		// // 동물 이름 배열 길이 5개를 만들고 출력해보자~~
		// String animals[] = {"kitty","panda","puppy","rabbit","hamster"};

		// for(int i = 0;i<animals.length;i++){
		// 	// System.out.println(animals[i]);
		// 	System.out.printf("animals[%d]: %s %n", i, animals[i]);
		// }


		// 양의 정수 5개를 입력받아서 제일 큰 숫자 출력하기...
		int intArray[] = new int[5]; //개수가 정해진 배열

		Scanner input = new Scanner(System.in);
		for (int i =0; i<5;i++){
			intArray[i] = input.nextInt();	
		}
		int max = intArray[0];
		int min = intArray[0];


		for (int i =0; i<5;i++){

			if(intArray[i]>max) {
				max = intArray[i];
			} else if (intArray[i]<min){
				min = intArray[i];
			}
		}
		for(int i =0; i<5;i++){
			System.out.print(intArray[i]+","); 
		}
		System.out.printf("제일 큰 숫자는 : %d", max);
		System.out.println("");
		System.out.printf("제일 작은 숫자는 : %d", min);

		
	}
}
