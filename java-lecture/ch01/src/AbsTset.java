public class AbsTset {
	public static void main(String[] args) {
		// 양수 두개의 차이를 양수로 표현하기
		// |a-b| > 0
		int a = 9;
		int b = 15;
		// 2 나오게 하기...

		// 메소드사용
		System.out.println(
			Math.abs(a-b)
		);


		// 조건문 생각해보기
		// 만약 앞의 수가 뒤의 수보다 작을 경우 앞에 -를 곱해주면 절대값으로 나옴
		if (a<b) {
			System.out.println(-1 * (a-b));
		} else if (a>=b) {
			System.out.println((a-b));
		}

		// 삼항연산자


	}
}
