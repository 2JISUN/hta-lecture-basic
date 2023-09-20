import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;
import java.util.List;


class Student {
	//필드
	private double grade; //학점
	private String id, name, department, ;
	
	
	//생성자
	public Student(String id, String name, String department, double grade) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.grade = grade;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	//메소드
	  @Override
    public String toString() {
        return "Student02 [name=" + name + ", department=" + department + ", id=" + id + ", grade=" + grade + "]";
    }


	

	

}



public class Quiz04 {
	
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("snm03097", "이지선", "자바", 10.0));
		










		
	}
}
