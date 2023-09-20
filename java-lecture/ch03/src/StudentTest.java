public class StudentTest {
	public static void main(String[] args) {
		Student st01 = new Student(01,"하리수",4.0,"남자");
		st01.setScore(3.2);
		System.out.prinf("하리수의 학점 : %f", st01.getScore());
	}
}
