public class ForEach {
	public static void main(String[] args) {
		// int intArray[] = {1,2,3,4,5};
		// for(int num : intArray){
		// 	System.out.println(num);
		// }

		enum Week {
			월, 화, 수, 목, 금, 토, 일
		}
		for(Week day : Week.values()){
			System.out.println(day+"요일");
		}
	}
}
