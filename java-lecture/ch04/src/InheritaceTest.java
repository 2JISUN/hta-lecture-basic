public class InheritaceTest {
	public static void main(String[] args) {
		Student student = new Student();
		student.set();
		System.out.println(student.age);
		System.out.println(student.height);
		System.out.println(student.name);
		System.out.println(student.getWeight());
	}
}
