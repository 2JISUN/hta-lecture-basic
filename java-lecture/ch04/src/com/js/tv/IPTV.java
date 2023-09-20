package com.js.tv;

public class IPTV extends ColorTV {

	private String ipAddress;
	public String getIpAddress() {
		return ipAddress;
	}

	public IPTV(int size, int nColor, String ipAdress) {
		super(size, nColor);
		this.ipAddress = ipAdress;
	}

	void showInfo(){
		System.out.printf("ip주소 %s이고 %d 인치 %d 컬러 TV 입니다.",this.getIpAddress(),this.getSize(), this.getnColor());
	}


	public static void main(String[] args) {
		new IPTV(64, 256, "127.0.0.1").showInfo();
	}

}
