public class Book {
	// title, author

	// 변수
	String title;
	String author;

	// 생성자(함수)
	// 생성자01  
	Book() {
		this("",""); // this는 무조건 처음에 호출!!
								  // 많이 쓰이지는 않음
	}

	// 생성자02 (오버로드) > 저자가 없는 책
	Book(String title) {
		this(title, author:"작자미상");
	}

	// 생성자03 (오버로드) > 타이틀도 있고 저자도 명시되어있다.
	Book(String title, String author){
		this.title = title;
		this.author = author;
	}


	// 메인 메서드 생성 > 메모리에 올리기
	public static void main(String[] args) {
		Book javaJungsuk = new Book("자바의 정석", "남궁 성");
		System.out.println(javaJungsuk.title + " / " + javaJungsuk.author);

		Book simchung = new Book("심청전");
		System.out.printf("%s / %s", simchung.title, simchung.author);
	}
}
