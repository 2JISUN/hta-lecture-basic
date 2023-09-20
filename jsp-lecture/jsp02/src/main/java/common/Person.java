package common;

//클래스
public class Person {
	//필드
	private String name;
	private int age;
	
	//필드의 게터세터
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	//클래스 생성자
	public Person() {
		
	}
	public Person(String name, int age) {
		super();
		this.name=name;
		this.age=age;
	}
	

}
