import java.util.Scanner;

class Phone {
	// 필드 > 이름, 전화번호
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	private String tel;
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	// 생성자(디폴트)
	public Phone(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}
}


public class PhoneBook {
	// 필드 > 전화번호 목록(배열) , 입력(스캐너)
	// has-a 관계 (클래스 사이의 포함관계일 뿐 상속관계는 아님)
	private Phone phoneList[];
	private Scanner input;



	// 생성자(디폴트+매개변수)
	public PhoneBook() {
		input = new Scanner(System.in);
	}

	// 메소드 : 전화번호부 입력(리턴X)
	public void write() {
		System.out.println("몇명을 입력하시겠습니까?");
		int total = input.nextInt();
		phoneList = new Phone[total];
		for(int i =0; i<total;i++){
			System.out.println("이름과 전화번호를 입력하시오.");
			String name = input.next();
			String tel = input.next();
			phoneList[i] = new Phone(name, tel);
		}
		System.out.println(total+"명의 전화번호부가 입력되었습니다.");
	}


	// 메소드 : 전화번호 찾기(리턴O)
	public String search(String name) {
		System.out.println("찾으실 분의 이름을 입력해주세요.");
		// String search = input.next();
		// searchList = new Name[search];
		for(int i =0; i<phoneList.length ;i++) {
			if(phoneList[i].getName().equals(name)) {
				return phoneList[i].getTel();
			}
		}
		return "해당하는 사람 없음";
	}

	// 메소드 : 운영(리턴X)
	public void run() {
		while (true) {
			System.out.println("이름을 쓰세요");
			System.out.println("'그만'을 입력하면 중지합니다");
			String name = input.next();
			if (name.equals("그만"))
			break;
			String tel = search(name);
			if (tel == null) {
				System.out.println("없는 사람입니다. 다시 입력해 주세요.");
			} else {
				System.out.println(name + "님의 전화번호는" + tel + "입니다.");
			}
		}
	}



	// 메소드(메인) > PhoneBookTest.java

}
