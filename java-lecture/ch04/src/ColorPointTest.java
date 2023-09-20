import JISUN2.ColorPoint;
import JISUN2.Point;

public class ColorPointTest {

	public static void main(String[] args) {
		
		Point point = new Point();
		point.set(10, 10);
		point.showPoint();

		ColorPoint colorPoint = new ColorPoint();
		colorPoint.set(100,100);
		colorPoint.setColor("red");
		colorPoint.showPoint();
		colorPoint.showColorPoint();


	}

	
}
