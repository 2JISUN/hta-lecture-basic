import java.util.StringTokenizer;

public class StringBufferTest {
	public static void main(String[] args) {
		String str = new String("this"); //불변 객체
		StringBuffer sb = new StringBuffer("this"); //가변 객체 > 원본 변경
		str.concat(" is not pipe");
		sb.append(" is not pipe");
		System.out.println(str);
		System.out.println(sb);
		sb.insert(12,"a");
		System.out.println(sb);
		System.out.println(sb.replace(11, 16, " apple"));

		String title = "홍길/심청/콩쥐/개구리/왕눈이";
		StringTokenizer st = new StringTokenizer(title, "/");
		System.out.println(title);
		System.out.println(st.hasMoreTokens());
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}





	}
}
