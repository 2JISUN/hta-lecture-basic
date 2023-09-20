public class DoWhileTest {
	public static void main(String[] args) {

		// do ~ 구문을 무조건 한 번 실행한다.
		char letter  = 'ㄱ';
		do{
			System.out.print(" " +letter);
			letter = (char) (letter + 1);
		}while(letter<='ㅎ');
	}
}
