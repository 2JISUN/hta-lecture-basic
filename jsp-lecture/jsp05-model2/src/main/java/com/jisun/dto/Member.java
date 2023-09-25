package com.jisun.dto;

public class Member {
	
	



	private int no;
	private String id;
	private String password;
	private String name;
	private int postcode;
	private String address;
	private String addressdetail;
	private String regdate;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressdetail() {
		return addressdetail;
	}
	public void setAddressdetail(String addressdetail) {
		this.addressdetail = addressdetail;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", password=" + password + ", name=" + name + ", postcode="
				+ postcode + ", address=" + address + ", addressdetail=" + addressdetail + ", regdate=" + regdate + "]";
	}
	
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Member(int no, String id, String password, String name, int postcode, String address, String addressdetail,
			String regdate) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.postcode = postcode;
		this.address = address;
		this.addressdetail = addressdetail;
		this.regdate = regdate;
	}
	
}
