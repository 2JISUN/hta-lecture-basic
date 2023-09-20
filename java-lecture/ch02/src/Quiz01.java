import java.util.Scanner;

public class Quiz01 {
	public static void main(String[] args) {

		// 1. 짝수합 by js
		// int sum = 0;
		// for (int i = 1; i<=100 ; i++) {
		// 	if (i%2==0) {
		// 		sum += i;
		// 	}
		// }
		// System.out.println(sum);

		// 1. 짝수합 by 강사님
		// int i =0,sum=0;
		// while(i<=100){
		// 	sum += i;
		// 	i +=2;
		// }
		// System.out.println(sum);

		// int sum = 0;
		// for (int i =0; i<=100; i+=2){
		// 	sum +=i;
		// }
		// System.out.println(sum);





		// 2. 홀수합
		// 		int sum = 0;
		// for (int i = 1; i<=100 ; i++) {
		// 	if (i%2==1) {
		// 		sum += i;
		// 	}
		// }
		// System.out.println(sum);

		// // 3.별 찍기
		// Scanner input = new Scanner(System.in);
		// int star = input.nextInt();

		
		// for (int i = star ; i > 0 ; i--){
		// 	for (int j =0; j<i ; j++){
		// 		System.out.print("*");
		// 	}
		// 	System.out.println(""); //!!!
		// }


		// 4. 양의 정수 10개를 입력받아 3의 배수 개수 구하기
		// Scanner input = new Scanner(System.in);
		// int intArray[] = new int[10];



		// for(int i =0;i<10;i++){
		// 	int num = input.nextInt();
		// 	intArray[i] = num;
		// }
		// System.out.println(Array.toSting(intArray)); //배열 전체 보고싶을 때

		// int count = 0;
		// for(int i = 0;i<intArray.length;i++){
		// 	if (intArray[i]%3==0){
		// 		count +=1;
		// 	}
		// }
		// System.out.println(count);



		// 5. 지폐 세기를 배열과 반복문을 이용해서 출력

		// int unit[] = {50000,10000,5000,1000,500,100,50,10};
		// int remain = 0;

		// Scanner input = new Scanner(System.in);
		// System.out.println("금액을 입력하면 각 단위당 개수를 알려드리겠습니다.");
		// int money = input.nextInt();
		// for (int i = 0; i <unit.length;i++){
		// 	remain = money/unit[i];
		// 	if(money/unit[i]==0){ //continue도 가능ㅎㅎ
		// 	} else {
		// 		System.out.print(unit[i]+"원 "+remain + "장 ");
		// 	}
		// 	money = money % unit[i];
		
		// }

		// 6. 2차원 배열 만들기
		// words={}

		String word[][]={{"apple","사과"},{"plum","자두"},{"grape","포도"}};

		Scanner input = new Scanner(System.in);
		
		for (int i =0;i<word.length;i++){
			System.out.printf("%d 번 문제 주어진 영어단어 %s의 뜻은 === ",i+1,word[i][0]);
			String answer = input.nextLine();
			if (answer.equals(word[i][1])) {
				System.out.println("딩동댕");
			} else {
				System.out.printf("땡!! 정답은 %s 입니다.", word[i][1]);
			}
			
		}

		


















	}
}
