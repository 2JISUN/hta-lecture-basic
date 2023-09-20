public class Rectangle {
	// int width, height
	// int getArea


	// 변수
	int width; //넓이
	int height; //높이
	String name; //이름


	// 함수(생성자 함수 = 클래스명과 동일할 때 타입을 써주지 않는다.)
	// 언제 실행될까? 메모리에 올라올 때 > new 클래스명() 일때!!
	Rectangle() {
		System.out.println("나는 생성될 때 한 번만 실행합니다. 다시 호출 되지 않는 리턴없는 타입입니다.");

	}


	// 함수
	double getArea(){
		return width*height;
	}


	// 함수 > 해당 클래스 메모리에 올리기
	public static void main(String[] args) {
		// new Rectangle(); // 메모리에 올리기만 가능
		Rectangle spongebob = new Rectangle(); // 메모리에 올리고 접근하기
		spongebob.height = 50;
		spongebob.width = 35;
		spongebob.name = "스폰지밥";
		double area = spongebob.getArea(); // 리턴값이 있다면 변수에 담을 수 있다는 의미와 같다.
		System.out.println("스폰지밥의 면적은 " + area + "입니다.");


		



	}





}
