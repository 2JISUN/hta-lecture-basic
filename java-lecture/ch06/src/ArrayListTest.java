import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("루피");
		arrayList.add("조로");
		arrayList.add("상디");
		arrayList.add("우솝");
		arrayList.add("나미");

		// 리스트에서 오브젝트 하나씩 접근하기
		for(int i = 0; i<arrayList.size(); i++){
			System.out.println(arrayList.get(i));
		}
		for (String str : arrayList) {
			System.out.println(str);
		}
		// arrayList.clear();
		// arrayList.remove(0);
		// System.out.println(arrayList.isEmpty());
		arrayList.set(0, "쵸파");
		System.out.println(arrayList);
		System.out.println(arrayList.contains("루피"));
		System.out.println(arrayList.contains("쵸파"));

		int intArray[] = {11,22,33,44,55};
		ArrayList<Integer> intArrayList = new ArrayList<>(
				Arrays.asList(11,22,33,44,55));
				System.out.println(intArrayList.get(0));

		ArrayList<String> nctDream = new ArrayList<>(
				Arrays.asList("이마크민형","황런쥔","이제노","이해찬","나재민","쫑천러","박지성"));
				System.out.println(nctDream.get(0));
				for(String str : nctDream){
					System.out.println(str);
				}
				
				int longIdx = 0;
				for(int i =0; i<nctDream.size(); i++){
					if (nctDream.get(i).length()>nctDream.get(longIdx).length()){
						longIdx = i;
					}
				}
				
				System.out.println(nctDream.get(longIdx));
		
		

		


	}
}
