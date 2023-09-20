import java.util.ArrayList;
import java.util.Iterator;


public class IteratorTest {
	public static void main(String[] args) {
		ArrayList<Integer> intArray = new ArrayList<>();
		intArray.add(11);
		intArray.add(22);
		intArray.add(33);
		intArray.add(44);
		intArray.add(55);


		Iterator<Integer> it = intArray.iterator();
;
		System.out.println(it.next());

		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
	}
}
