public class Hello {
	public static void main(String[] args) {
		String str = "hellojava";
		// System.out.println(str.charAt(0));
		// System.out.println(str.substring(2));


		for (int i = 1; i<str.length()+1; i++){
			String rotated = str.substring(i) + str.substring(0, i);
			System.out.println(rotated);

		}

	}
}
