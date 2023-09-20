public class QuizTv {
	
	// 필드생성
	private String brand; 
	private int year;
	private int size;


	// 생성자 (ctrl + .)
	public QuizTv(String brand, int year, int size) {
		this.brand = brand;
		this.year = year;
		this.size = size;
	}

	// 메소드 (일반)
	public void show(){
		System.out.printf("%s 브랜드에서 만든 %d 년형 %d 인치 tv입니다.", this.brand, this.year, this.size);
	}


	// 메소드 (메인)
	public static void main(String[] args) {
		QuizTv tv = new QuizTv("LG",	 2023, 64);
		tv.show();
	}

}
