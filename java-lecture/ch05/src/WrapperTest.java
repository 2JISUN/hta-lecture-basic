public class WrapperTest {


	public static void main(String[] args) {
		char ch = 'A';
		char ch02 = '9';
		System.out.println(Character.toLowerCase(ch));
		System.out.println(Character.isDigit(ch));
		System.out.println(Character.isDigit(ch02));
		System.out.println(Character.isAlphabetic(ch));
		System.out.println(Character.isAlphabetic(ch02));

		String str = "16";
		int num = 16;
		System.out.println(str+1); //161
		System.out.println(Integer.parseInt(str)+1); //17
		System.out.println(Integer.toHexString(num)); //10
		System.out.println(Integer.toBinaryString(num)); //10000
		System.out.println(Integer.toString(num)); //16
		System.out.println( str.equals(Integer.toString(num))); //true


		double d = 3.14;
		String d2 = "3.14";
		System.out.println(Double.toString(d));
		System.out.println(Double.parseDouble(d2));


		Integer ten = 10; // boxing
		int ten02 = 10;  // unboxing(객체에 담으면)
		System.out.println(ten == ten02); // true


		Integer num01 = 12345;
		Integer num02 = 12345;
		// System.out.println(num01);
		System.out.println(num01==num02); // false > 값은 같지만 참조객체라서 다름
		System.out.println(num01.equals(num02));



		
	}
}
