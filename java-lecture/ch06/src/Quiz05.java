import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;



public class Quiz05 {
	public static void main(String[] args) {
		HashMap<String, Double> studentList = new HashMap<>();

		double cutline = 3.8;
		studentList.put("이지선",4.5);
		studentList.put("이마크",4.5);
		studentList.put("황런쥔",4.5);
		studentList.put("문태일",2.5);

		Set<String> set = studentList.keySet(); //key값 출력
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String name = it.next();
			Double score = studentList.get(name);
			if(score>=cutline) {
				System.out.println(name + "장학금 지급");
			} else {
				System.out.println(name + "엄빠 장학금 지급");
			}
		}
	}
}
