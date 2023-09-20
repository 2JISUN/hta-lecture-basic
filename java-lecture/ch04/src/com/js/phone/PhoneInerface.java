package com.js.phone;

interface PhoneInterface {
	final int TIMEOUT = 10000;
	void sendCall();
	void receiveCall();
	default void printLogo() {
		System.out.println("==== Phone ====");
	}

}

interface MobilePhoneInterface extends PhoneInterface {
	void sendSms();
	void receiveSms();

}

interface Mp3Interface  {
	void play();
	void stop();

}

