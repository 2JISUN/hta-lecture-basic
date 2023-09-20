import java.util.Vector;


class Point {
	// 필드
	private int x,y;
	// 생성자
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	// 오버라이드(덮어씌우기) - toString
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	
	
}



public class VectorTest {
	public static void main(String[] args) {
		//List : 순서O 중복O
		//Set  : 순서X 중복X
		//Map  : key : 중복X
		//Map  : value : 중복X
		Vector<Integer> vec = new Vector<>();
		vec.add(100);
		vec.add(200);
		vec.add(300);
		System.out.println(vec); //벡터(배열) 전체 출력
		System.out.println(vec.get(2)); // 벡터(배열) 값 하나씩 출력

		for(int i =0; i<vec.size(); i++){
			System.out.println(vec.get(i));
		}

		for(int i : vec){
			System.out.println(i);
		}

		String animals = "호랑이,사자,토끼,거북이";



		Vector<String> stringVector = new Vector<>();
		// 벡터(배열) 에 넣기
		for(String animal : animals.split(",")) {
			stringVector.add(animal);
		}
		System.out.println(stringVector);

		// 하나씩 꺼내는 법
		for (int i =0; i<stringVector.size(); i++){
			System.out.println(stringVector.get(i));
		}

		stringVector.add("캥거루1");
		stringVector.add("캥거루2");
		System.out.println(stringVector);

		stringVector.remove(stringVector.size()-1);
		System.out.println(stringVector);


		Vector<Point> pointVec = new Vector<>();
		pointVec.add(new Point(10, 10));
		pointVec.add(new Point(20, 20));
		pointVec.add(new Point(30, 30));
		System.out.println(pointVec.get(0));










	}
}