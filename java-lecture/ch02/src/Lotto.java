import java.util.Arrays;

public class Lotto {
	public static void main(String[] args) {
		int nums[] = new int[45]; //배열안의 요소의 개수를 정해줄 때

		for(int i =0; i<nums.length;i++){
			int temp = 
			nums[i] = i + 1;
		}
		// System.out.println(nums);
		// System.out.println(Arrays.toString(nums));
		System.out.println((int) (Math.random()*45));

		int nums[] = new int[45]; //배열안의 요소의 개수를 정해줄 때
		for (int i =0;i<100;i++){
			int selected = (int) (Math.random()*nums.length);
			int temp =nums[0];
			nums[0]=nums[selected];


		}
	}
}
