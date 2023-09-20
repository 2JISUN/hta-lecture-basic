public class MethodOverload {

	// 함수(메서드) 
	// 함수 또한 생성자와 같이 이름 중복이 가능하다
	// 하지만 반드시 매ro변수 내용(개수, 매개변수 타입)이 달라야함
	int getSum(int i, int j) {
		return i + j;
	}
	int getSum(int i, int j, int k){
		return i + j;
	}


	public static void main(String[] args) {
		MethodOverload m01 = new MethodOverload();
		int m01Sum = m01.getSum(10, 10);
		System.out.printf("m01Sum의 값은 = %d",m01Sum);
	}
}
