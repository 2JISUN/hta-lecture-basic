import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Quiz03 {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		Map<String,Integer> conPop = new HashMap<>();
	
		while(true){
			System.out.println("나라이름을 입력하세요. (종료 : 'exit')");
			String con = input.nextLine();
			if(con.equals("exit")){
				break;
			}

			// 두 번째 루프에서 에러가 발생하는 이유는 input.nextInt() 호출로 인해 개행 문자('\n')가 버퍼에 남아있어서 다음에 호출되는 input.nextLine()에서 이 개행 문자가 읽혀지기 때문입니다. 이런 상황을 해결하기 위해서는 input.nextLine()을 호출하여 버퍼에 남아있는 개행 문자를 비우는 것이 필요합니다.
			System.out.println("인구수를 입력하세요.");
			int pop = Integer.parseInt(input.nextLine());
	
			conPop.put(con, pop);
	
		}
	
		System.out.println("나라이름을 입력하시면 인구수를 알려드립니다. ");
		String searchCon = input.nextLine();

		if(conPop.containsKey(searchCon)){
			int foundPop = conPop.get(searchCon);
			System.out.printf("%s의 인구수 : %d명",searchCon, foundPop);
		} else {
			System.out.println("해당 나라의 인구수를 찾을 수 없습니다.");
		}
	}

}
