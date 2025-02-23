import java.util.Scanner;

public class P1_array_BOJ_10808 {
	public static void main(String[] args) {
		// 단어 S 입력받기 
		Scanner sc = new Scanner(System.in);
		
		String st = sc.next();
		char[] c = new char[st.length()];
		
		for (int i = 0; i < st.length(); i++) {
			c[i] = st.charAt(i);
		} // input
		
		// 알파벳 소문자 a - z: 총 26게
		// 1 - 26 집합 만들 (0 사용X)
		int[] cnt = new int[26];
		
		for (int i = 0; i < c.length; i++) {
			for (int j = 0 ; j < cnt.length; j++) {
				if (c[i] == (j + 'a')) {
					cnt[j]++;
				}
			}
		}
		for (int i = 0; i < cnt.length; i++) {
			System.out.print(cnt[i] + " ");
		}
		
		sc.close();
	}
}
