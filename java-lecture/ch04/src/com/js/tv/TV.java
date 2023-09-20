// TV 클래스 만들기
// private size (사이즈 변경 불가)
// 생성자 만들기 new TV(30)

// ColorTV만들기 private nColor;
// 생성자 만들기 new ColorTV(30,256)
// showInfo() 만들어서 몇인치에 몇컬러인지 출력

package com.js.tv;

public class TV {

	// 필드(Field) 
	private int size;
	// 필드가 private라면 get, set 필요
	public int getSize() {
		return size;
	}

	// 빈 생성자(Constructor) > 자식 클래스의 오류를 없애고자
	public TV(){

	}


	// 메인 생성자(Constructor) > 초기화
	public TV(int size) {
		this.size = size;
	}



}
