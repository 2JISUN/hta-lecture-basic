import java.util.*;

public class Main {
    public static void main(String[] args) {
		// 입력
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toLowerCase(); // 입력받은 문자를 소문자로 치환

		// 입력 > 저장소 > {알파벳 : 알파벳 개수}
        Map<Character, Integer> charCount = new HashMap<>(); // 알파벳 개수를 저장할 Map
        char maxCountChar = '?'; // 가장 많이 나온 알파벳
        int maxCount = 0; // 가장 많이 나온 알파벳의 개수

        for (char cha : word.toCharArray()) {
			// 현재 문자 cha가 알파벳인지 확인. 알파벳이 아닌 문자는 무시.
            if (Character.isLetter(cha)) {
                charCount.put(cha, charCount.getOrDefault(cha, 0) + 1); // 알파벳 개수 증가
				//맵에 현재 문자 cha를 키로 사용하여 해당 문자의 개수를 증가시킵니다. 이미 해당 문자가 맵에 있을 경우에는 해당 문자의 개수를 1 증가시키고, 없을 경우에는 1로 초기화합니다. 이로써 각 알파벳의 개수가 저장되게 됩니다.


                // 최댓값 계산 및 가장 많이 나온 알파벳 갱신
                if (charCount.get(cha) > maxCount) {
                    maxCountChar = cha; // 알파벳 갱신
                    maxCount = charCount.get(cha); // 알파벳 개수 갱신
                } else if (charCount.get(cha) == maxCount) {
                    maxCountChar = '?'; // 최댓값이 같은 경우 '?'로 설정
                }
            }
        }

        System.out.println(Character.toUpperCase(maxCountChar)); // 대문자로 출력

        sc.close();
    }
}
