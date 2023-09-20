class Rect {
	private int width, height;

	public Rect(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public boolean equals(Object obj) {
		Rect rect = (Rect)obj;
		if(width*height == rect.width* rect.height){
			return true;
		}else{
			return false;
		}

	}

}



public class RectTest {
	public static void main(String[] args) {
		Rect rect01 = new Rect(10, 10);
		Rect rect02 = new Rect(20, 5);
		System.out.println(rect01.equals(rect02));
	}
}