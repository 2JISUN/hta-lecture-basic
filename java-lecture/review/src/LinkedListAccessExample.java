import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListAccessExample {
    public static void main(String[] args) {
        // LinkedList 생성 + 값 할당 동시동작 생성
        LinkedList<String> colors = new LinkedList<>(Arrays.asList("Black","White","Red","Green"));

        // "White"에 접근
		int index = colors.indexOf("White"); // 값으로 검색해서 값의 "인덱스에 접근"
		System.out.println(index); // 인덱스 출력
		String color = colors.get(index); // 값으로 검색해서 값의 인덱스로 "값에 접근"
		System.out.println(color);  // 값 출력

}
}