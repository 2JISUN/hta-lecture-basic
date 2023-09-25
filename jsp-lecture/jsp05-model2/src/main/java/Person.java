
public class Person {
	
	private String name;
	private String nickName;
	private int age;
	private String gender;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", nickName=" + nickName + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Person(String name, String nickName, int age, String gender) {
		super();
		this.name = name;
		this.nickName = nickName;
		this.age = age;
		this.gender = gender;
	}
	
	
	
	
	

}
