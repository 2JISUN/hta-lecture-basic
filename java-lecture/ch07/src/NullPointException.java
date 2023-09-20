public class NullPointException {
	public static void main(String[] args) {
		String msg = null;
		try {
			System.out.println(msg.length());
			
		} catch (NullPointerException e) {
			System.out.println("null의 길이는 없습니다.");
			
		}
	}
}
