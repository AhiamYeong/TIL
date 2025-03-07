import java.util.*;
public class test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] c = sc.next().toCharArray();
			// 팰린드롬이면 1 아니면 0 (결과)
			int[] res = isPalindrome(c, 0, 0);
			System.out.println(res[0] + " " + res[1]);
		}
		sc.close();
	}
	
	// 팰린드롬이면 1 아니면 0 출력 
	static int[] isPalindrome(char[] s, int idx, int cnt) {
		int len = s.length; // 절반만 떼놓고 검사하면 됨 

		// 어렵게 가지 말고 종료조건부터
		// 끝까지 봤을때 틀리는거 없으면 ok
		// 절반만 검사하면 되니까 
		if (idx == len/2) return new int[] {1, cnt+1}; 
		// 다르면 종료 
		if (s[idx] != s[len-1-idx]) {
			// 다르면 바로 종료
			return new int[] {0, cnt+1};
		}
		// 재귀 부분: 같으면 다음 로직 검사
		return isPalindrome(s, idx+1, cnt+1);
	}
}
