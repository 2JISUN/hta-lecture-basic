public class StringTest {
	public static void main(String[] args) {
		String a = new String("  Java    ");
		String b = new String(",Spring ");
		System.out.println(a.length());
		System.out.println(a.contains("va"));
		System.out.println(a.concat(b));
		System.out.println(a.trim().concat(b));


		String c = " ";
		String d = "  \t\n";
		System.out.println(c.isEmpty()); // 공백 제거하지 않고 문자열의 길이가 0인지 아닌지 따지기
		System.out.println(d.isEmpty()); // 공백 제거하지 않고 문자열의 길이가 0인지 아닌지 따지기
		System.out.println(c.isBlank()); // 공백 제거하고 문자열의 길이가 0인지 아닌지 따지기
		System.out.println(d.isBlank()); // 공백 제거하고 문자열의 길이가 0인지 아닌지 따지기
		System.out.println(c.trim().length());


		String e = "피곤한 월요일 화요일";

		System.out.println(e.charAt(4));
		// System.out.println(e.charAt(-));
		System.out.println(e.indexOf("월"));
		System.out.println(e.lastIndexOf("월"));


		String f = "hello java";
		String g = "HELLO JAVA";
		System.out.println(f.equals(g));
		System.out.println(f.equalsIgnoreCase(g));
		
		String str01 = "Hi~~~ how are you fine thank you and you";
		String str02 = "HOW"; // 대소문자 무시하고 포함되어 있는지 따져보기

		System.out.println(str01.contains(str02.toLowerCase())); // 메서드 체이닝
		System.out.println(str01.contains(str02.toUpperCase()));

		String str03 = "점";
		str03.concat("심"); // concat은 문자열만 이어붙일 수 있음

		String str05 = new StringBuilder("a")
								 .append("b")
							 	 .append("c")
								 .append("A")
								 .toString();
		System.out.println(str05);
		

		String str06 = "쿵짝";
		String str06Repeat = str06.concat("쿵짝").concat("쿵짝").concat("쿵짝");
		String str06Repeat02 = str06.repeat(4);
		String str06Repeat03 = str06.concat(" ").repeat(4).trim();
		
		System.out.println(str06Repeat);
		System.out.println(str06Repeat02);
		System.out.println(str06Repeat03);

		String story = "인어공주 라푼젤 백설공주";
		System.out.println(story.startsWith("인"));
		System.out.println(story.endsWith("주"));


		String str07 = "쥐 개 양 돼지 잡아서 먹어보자 찍찍찍";
		System.out.println(str07.replace("쥐","개")); //replace는 하나만 바꿀 수 있음
		System.out.println(str07.replaceAll("[쥐,개,양,돼지]", "소")); 
		

		String str08 = "java,c#,spring,python,javascript";
		String[] array = str08.split(","); //split : 문자열 쪼개서 배열로 만들기
		System.out.println(array[0]);
		for(int i=0; i<array.length; i++){
			System.out.println(array[i]);
		}

		String arrayTxt = String.join("///", array); // join : 배열의 각 요소를 구분자를 포함하여 스트링으로 만들기
		System.out.println(arrayTxt);


		String str09 = "안녕하세요. 이지선입니다.";
		System.out.println(str09.substring(0, 7)); //글자 자르기






		






	}
}
