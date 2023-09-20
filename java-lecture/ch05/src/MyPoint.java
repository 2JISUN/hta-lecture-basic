public class MyPoint {
	// 필드
	private int x, y;

	// 생성자
	public MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// 오버라이드 - toString
	@Override
	public String toString() {
		return "Point(" + x + "," + y + ")";
	}

	// 오버라이드 - equals
	public boolean equals(Object object){
		MyPoint point = (MyPoint)object;
		if(x==point.x && y == point.y) {
			return true;
		} else {
			return false;
		}
	}


	// 메소드 메인
	public static void main(String[] args) {
		MyPoint myPoint = new MyPoint(3, 4);
		MyPoint myPoint02 = new MyPoint(3, 4);
		System.out.println(myPoint.toString());
		System.out.println(myPoint.equals(myPoint02));
	}

}
