import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BOJ_1316 {
	public static void main(String[] args) {
		// 각 문자 연속해서 나타남 /
		Scanner sc = new Scanner(System.in);
			
		int N = sc.nextInt(); 
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next(); 
			char[] cArr = new char[str.length()];
			
			for (int c = 0; c < str.length(); c++) {
				cArr[c] = str.charAt(c);
			}
			
			// 등장했던 단어 집합
			Set<Character> words = new HashSet<>();
			boolean isGroupWord = true; // 단어 판별
			
			for (int k = 0; k < cArr.length - 1; k++) {
				// 한번에 와다다 등장은 오케이 
				// 이전/다음 문자 비교 > 다른 문자인지 확인
				
				// 단어가 최초등장하는 경우 집합에 넣기
				if (cArr[k] == cArr[k+1]) {
					// 같으면 ok
				} else {
					//달라도 처음 등장하면 ok
				}
				
//				System.out.println(cArr[k] + "일 때: " + isGroupWord);
				// 연속된 문자인가 
			}
			
			// arr[i], arr[i-1] 비교
			
			// 단어들이 연속해서 나오지 않으면 그룹단어 X
			
			// 기존에 등장했던 문자가 또 등장하면 X
			
			
			
			// 기존에 나온 단어 집합 비교 
			
			
			if (isGroupWord) cnt++;
		} // 그룹 단어 체크
		System.out.println(cnt);
		// 기존에 나왔던 단어 집합 
		// 연속해서 나오지 않으면 그룹단어 아님 
		
		// 연속되지 않은 문자 > 이전 문자와 비교
		// 현재 문자가 다른 문자인지 확인
		// 문자가 다르면 그 문자 앞에 다른 문자가 등장했는지 체크하기
	
		
		sc.close();
	}
}
