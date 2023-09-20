package com.js.instance;


// 상위 클래스
class Person {
	
}


class Student extends Person {

}


class Reseacher extends Person {

}


class Professor extends Reseacher {

}




public class InstanceTest {
	static void print(Person p){ 
		if(p instanceof Person) {
			System.out.println("Person");
		}
		if(p instanceof Student) {
			System.out.println("Student");
		}
		if(p instanceof Reseacher) {
			System.out.println("Reseacher");
		}
		if(p instanceof Professor) {
			System.out.println("Professor");
		}
		

	}
	public static void main(String[] args) {
		// print(new Student()); //person > student
		print(new Reseacher());  //person > reseacher 
		// print(new Professor()); //person > reseacher > professor

	}
	
}
