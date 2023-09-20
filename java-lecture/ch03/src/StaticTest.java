class Calc {
	// 변수
	// int abs(int a){
	// 	return a>0? a:-a; // a가 0보다 크다면? a 아니면 -a
	// }


	// int max(int a, int b){
	// 	return a>b? a:b;
	// }
	// int min(int a, int b){
	// 	return a>b? b:a;
	// }

	static int abs(int a){
		return a>0? a:-a; // a가 0보다 크다면? a 아니면 -a
	}

	static int max(int a, int b){
		return a>b? a:b;
	}
	static int min(int a, int b){
		return a>b? b:a;
	}



}

public class StaticTest {
	public static void main(String[] args) {
		// 다이렉트 접근 불가능
		// static이 없을 때는 반드시 변수로써 할당받고 속성값 사용가능
		// Calc calc = new Calc(); // static 없을 때
		// calc.abs(-10); // static없을 때

		// 다이렉트 접근 가능
		// static이 있을 때는 반드시 변수로써 할당받지 않고도 속성값 사용가능
		Calc.abs(0); 
	}
}
