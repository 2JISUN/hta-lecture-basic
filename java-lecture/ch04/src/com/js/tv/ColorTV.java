package com.js.tv;


public class ColorTV extends TV { // TV로부터 상속받음

	// 필드(Field) 
	private int nColor;

	public int getnColor() {
		return nColor;
	}
	
	public ColorTV(int size, int nColor) {
		super(size);
		this.nColor = nColor;
	}
	
	void showInfo() {
		System.out.printf("%d인치 %d 컬러 TV 입니다.", this.getSize(), this.getnColor());
	}

	public static void main(String[] args) {
		new ColorTV(64, 256);
	}


		
	
}
