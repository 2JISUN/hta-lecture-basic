package com.js.practice;

public class Student {

	// 필드
	public String name; //학생이름
	public int ban; //반
	public int no; //번호
	public int kor, eng, math; //국어, 영어, 수학 점수

	// 생성자(초기화)
	public Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	// 메소드 : 정보전달
	 String info() {
		return String.format("제 이름은 %s 이고 %d반 %d번 입니다.", this.name, this.ban, this.no);
    }

	// 메소드 : 메인
	public static void main(String[] args) {
		Student s =  new Student("홍길동", 1, 1, 100, 60, 76);
		String str = s.info();
		System.out.println(str);
	}
}
