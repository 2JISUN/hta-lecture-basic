public class Student {
	// 변수
	private int id;
	private String name;
	private double score;


	// 디폴트값이 외부 접근 불가능하지만
	// 함수를 통해서는 접근이 가능함
	private String gender;
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}


	// 생성자
	public Student () {

	}
	
	

	//생성자(ctrl + . > generate constructure)
	public Student(int id, String name, double score, String gender) {
		this.id = id;
		this.name = name;
		this.score = score;
		this.gender = gender;
	}


}
