
// 클래스 > [원]
public class Circle {
	// 변수 > 원이라면 가지고 있는 특징들을 변수로 선언
	int radius; //반지름
	String name;

	
	// 생성자란? = 함수 + 클래스명과 함수명이 동일
	// 함수(생성자형 = 클래스명과 동일할 때 타입을 써주지 않는다.)
	// 생성자형 함수를 여러개 만들 수 있다 = 오버로드
	// 생성자형 함수를 여러개 만들 때는 무조건 각각 서로 달라야한다.
	// 오버로드 할 때는 반드시 빈 생성자를 반드시 "직접" 만들어두어야 한다.

	// 생성자01
	Circle() {
		radius = 1;
		name = "";
	}
	 
	// 생성자02 (오버로드)
	Circle(int radius, String name) {
		this.radius = radius;
		this.name = name;
	}

	// 생성자03 (오버로드)
	Circle(int radius){
		this.radius = radius;
		name = "";
	}



	// 메서드(함수)
	double getArea(){
		return radius*radius*3.14;
	}

	// 메인 메서드(함수) > 이제 메모리에 올려볼까나
	public static void main(String[] args) {
		// 객체화된 클래스 =new 클래스명()
		// circle 객체화 > 도미노 피자
		Circle domino = new Circle(); // 접근하기 위해 변수로 선언함
		domino.radius = 10;
		domino.name = "도미노";
		double dominoArea = domino.getArea();
		System.out.println(domino.name + "의 면적은 " + dominoArea);


		// circle 객체화 > 피자헛 피자
		Circle pizzaHut = new Circle(20, "피자헛");
		// pizzaHut.radius = 20;
		// pizzaHut.name = "피자헛";
		double pizzaHutArea = pizzaHut.getArea();
		System.out.println(pizzaHut.name + "의 면적은 " + pizzaHutArea);


		// circle 객체화 
		Circle obj01 = new Circle(1);
		Circle obj02 = new Circle(2);
		Circle obj03;
		obj03 = obj02; //복사가 아닌 참조
		obj01 = obj02; //복사가 아닌 참조
		System.out.printf("obj01의 반지름===%d%n", obj01.radius);
		System.out.printf("obj02의 반지름===%d%n", obj02.radius);

		// circle 객체화
		// Circle c01 = new Circle(1);
		// Circle c02 = new Circle(2);
		// Circle c03 = new Circle(3);
		// Circle c04 = new Circle(4);
		// Circle c05 = new Circle(5);
		
		Circle circle[] = new Circle[5];
		for(int i =0; i<5; i++){
			circle[i] = new Circle((i+1)*10);
		}


		System.out.println(circle[0].radius);
	}




}
