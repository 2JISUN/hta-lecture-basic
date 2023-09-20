public class QuizGrade {
	// 변수
	private int math ;
	private int kor ;
	private int eng ;
	


	// 생성자
	public QuizGrade(int math, int kor, int eng) {
		this.math = math;
		this.kor = kor;
		this.eng = eng;
	}


	// 메서드 (일반)
	int average(){
		return (int)((math + kor + eng) / 3);
	}



	// 메서드 (메인)
	public static void main(String[] args) {
		QuizGrade grade = new QuizGrade(90, 85, 50);
		int average = grade.average();
		System.out.printf("나의 국영수 평균 : %d", average);

		
	}
}
