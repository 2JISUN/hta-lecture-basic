import java.util.HashMap;

class Student {
	//필드
	private int id;
	private String tel;

	//생성자
	public Student(int id, String tel) {
		this.id = id;
		this.tel = tel;
	}

	public int getId() {
		return id;
	}

	public String getTel() {
		return tel;
	}
	
}

public class StudentHashMap {
	public static void main(String[] args) {
		HashMap<String,Student> studentMap = new HashMap<>();
		studentMap.put("이지선", new Student(1, "010-1111-2222"));
		studentMap.put("이지", new Student(2, "010-1111-2222"));
		studentMap.put("이", new Student(3, "010-1111-2222"));
		Student student = studentMap.get("마크뷘");
		System.out.println(student.getTel());
	}
	
}
