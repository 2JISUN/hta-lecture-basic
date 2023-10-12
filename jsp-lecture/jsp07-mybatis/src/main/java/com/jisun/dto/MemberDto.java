/*
DTO (Data Transfer Object) 폴더 = db의 필드를 객체화시킨다

DTO는 데이터베이스 테이블의 레코드를 자바 객체로 표현한 것입니다. 
각각의 DTO 클래스는 데이터베이스 테이블의 열(column)과 일치하는 필드(variable)를 가지고 있어야 합니다.
DTO 클래스는 주로 데이터의 전송 및 저장에 사용됩니다.
보통 DTO 클래스의 이름은 해당 테이블의 이름과 관련이 있으며, 필드 이름은 테이블의 열 이름과 일치하거나 유사하게 지정됩니다.
예를 들어, 만약 "User" 테이블이 있다면, UserDTO.java와 같은 이름의 DTO 클래스를 생성할 수 있습니다.

DTO 클래스는 데이터의 전달과 저장을 단순하게 하고, 데이터의 일관성을 유지하는 데 도움이 됩니다.
*/


package com.jisun.dto;


public class MemberDto {
	
	/*
	1. 인스턴스 변수 (멤버 변수)
	   생성방법 : 직접 작성
	*/
	
	private int no;
	private String id;
	private String password;
	private String name;
	private int postcode;
	private String address;
	private String addressdetail;
	private String regdate;
	private String email;
	private String tel;
	private String profile; //경로로 삽입 (Part는 사진삽입일때만)
	
	
	
	
	/*
	 2. 게터(Getter)와 세터(Setter) 메서드
	 	생성방법 : 소스 > 게터세터
	 
	 각 인스턴스 변수에 대한 게터와 세터 메서드가 제공됩니다. 
	 (1)외부에서 클래스의 인스턴스 변수에 접근하고 값을 설정 또는 가져올 수 있도록 합니다.
	 (2)객체 지향 프로그래밍에서 
	 	객체의 데이터를 보호하고 캡슐화를 유지하며, 
	 	객체 지향 프로그래밍의 원칙을 준수하고 유지보수성을 향상
	*/

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



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public String getProfile() {
		return profile;
	}



	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	
	/*
	 3. toString() 메서드
	 	생성방법 : 소스 > 투스트링()
	 
	 객체를 문자열로 표현하기 위한 toString() 메서드가 구현되어 있습니다. 
	 이 메서드는 객체를 문자열로 표현할 때 각 변수의 값을 포함한 형식을 정의합니다.
	 */
	



	@Override
	public String toString() {
		return "Member [id=" + id + ", password=" + password + ", name=" + name + ", postcode=" + postcode
				+ ", address=" + address + ", addressdetail=" + addressdetail + ", regdate=" + regdate + ", email="
				+ email + ", tel=" + tel + ", profile=" + profile + ", no=" + no + "]";
	}

	
	
	/*
	4. 기본 생성자 (Default Constructor)
	   생성방법 : 소스 > 슈퍼클래스

	매개변수 없는 기본 생성자가 제공됩니다.
	객체를 생성할 때 생성자가 호출됩니다. 
	기본 생성자가 없으면 다른 생성자만 사용 가능한데, 이 경우 다른 생성자를 통해서만 객체를 생성할 수 있습니다. 
	기본 생성자가 존재하면 디폴트로 객체를 생성하는 데 사용할 수 있습니다.
	*/
	public MemberDto() {
		super();

	}
	
	
	
	/*
	5. 매개변수가 있는 생성자 (Parameterized Constructor)
	   생성방법 : 소스 > 유징필드
	   
	모든 인스턴스 변수를 초기화하는 매개변수가 있는 생성자도 제공됩니다. 
	이 생성자를 통해 객체를 생성하면서 초기 데이터를 설정할 수 있습니다.
	*/
	public MemberDto(int no, 
				String id, 
				String password, 
				String name, 
				
				int postcode, 
				String address, 
				String addressdetail,
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
