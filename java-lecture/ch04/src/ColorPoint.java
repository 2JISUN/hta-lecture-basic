// Point(부모) 클래스로 부터 상속받기

import JISUN2.ColorPoint;
import JISUN2.Point;

public class ColorPoint extends Point {
	// 변수, 속성
	private String color;
	
	
	public void setColor(String color) {
		this.color = color;
	}

	public void showColorPoint() {
		showPoint();
		System.out.printf("색상은 %s", color);
	}



	// 메서드(메인)
	public static void main(String[] args) {
		ColorPoint colorPoint = new ColorPoint();
		colorPoint.set(30, 40);
		colorPoint.setColor("red");

	}

}
