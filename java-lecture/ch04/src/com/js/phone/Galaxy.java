package com.js.phone;

public class Galaxy implements PhoneInterface,Mp3Interface {

	@Override
	public void receiveCall() {
		System.out.println("전화받기");

	}

	@Override
	public void sendCall() {
		System.out.println("전화걸기");

	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}


