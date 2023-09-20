public class ForFor {
	public static void main(String[] args) {
		// 구구단 찍기
		for(int i = 1;i<10;i++){
			if (i==2) 
			continue;
			// break;
			System.out.println(i + "단 출력합니다.");
			for(int j = 1;j<10;j++){
				System.out.print(i + "*" + j + "=" + i * j);
				System.out.print('\t');
			}
			System.out.println("");
		}
	}
}
