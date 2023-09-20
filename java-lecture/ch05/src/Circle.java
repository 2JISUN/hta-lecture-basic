public class Circle {
	// 필드
	private int x, y, r;

	// 생성자(초기화)
	public Circle(int x, int y, int r) {
		this.x = x;
		this.y = y;
		this.r = r;
	}

	// 오버라이드(재정의) - toString
	@Override
	public String toString() {
		return "Circle(" + x + "," + y + ") 반지름" + r;
	}

	// 오버라이드 - equals
	public boolean equals(Object object){
		Circle circle = (Circle)object;
		if(x==circle.x && y == circle.y) {
			return true;
		} else {
			return false;
		}
	}


	// 메인 메소드
	public static void main(String[] args) {
		Circle circle = new Circle(3, 4, 10);
		Circle circle02 = new Circle(3, 4, 10);
		System.out.println(circle.toString());
		System.out.println(circle.equals(circle02));
		
	}




	




}
