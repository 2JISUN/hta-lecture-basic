package lib;

class Point {
	// 필드
	private int x, y;

	// 생성자 (private 권한인 필드를 접근가능하게 해주는 생성자(초기화)를 만들어 준다)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "나의 좌표는 (" + x + "," + y + ") 입니다.";


	// equals 재정의  (덮어쓰기 = 오버라이딩)
	public boolean equals(Object object){
		Point point = (Point)object;
		if(x==point.x && y==point.y) {
			return true;
		} else {
			return false;
		}

	}

	}
	
}

public class ObjectPropertyTest {
	public static void main(String[] args) {
		Point point = new Point(10, 10);
		Point point02 = new Point(10, 10);
		System.out.println(point.getClass().getName());
		System.out.println(point.hashCode());
		System.out.println(point02.hashCode());
		System.out.println(point.toString());
		System.out.println(point02.toString());
		System.out.println(point.equals(point02));
		
		
	}
}
