import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap<String,String> dictionary = new HashMap<>();
		dictionary.put("apple", "사과");
		dictionary.put("grape", "포도");
		dictionary.put("peach", "복숭아");
		dictionary.put("plum", "자두");


		System.out.println(dictionary.get("apple"));

		Set<String> keys = dictionary.keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()){

			System.out.println(it.next());
		}


		LinkedHashMap<String,String> dictionary02 = new LinkedHashMap<>();
		dictionary02.put("apple", "사과");
		dictionary02.put("grape", "포도");
		dictionary02.put("peach", "복숭아");
		dictionary02.put("plum", "자두");


		System.out.println(dictionary.keySet());
		System.out.println(dictionary02.keySet());



		HashMap<String,Integer> studentScore = new HashMap<>();
		 studentScore.put("차은우", 100);
		 studentScore.put("서강준", 98);
		 studentScore.put("정재현", 90);
		
		//  System.out.println(studentScore.keySet()); //키를 list 형태로 출력해줌

		for(String name : studentScore.keySet()) {
			int score = studentScore.get(name);
			System.out.print(name + " " + score + ",");
		}

		Set<String> kset = studentScore.keySet();
		Iterator<String> it02 = kset.iterator();
		while (it02.hasNext()) {
			System.out.println(it02.next());
			
		}











	}
}
