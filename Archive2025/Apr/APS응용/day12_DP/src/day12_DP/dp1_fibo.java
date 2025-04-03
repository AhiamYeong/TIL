package day12_DP;

import java.util.Arrays;
import java.util.Scanner;

public class dp1_fibo {
	
	static int[] memo2;
	// static block: 미리 초기화코드 작성해둘 수 있음  
	static {
		memo2 = new int[10000]; 
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		System.out.println(fibo1(N));
		
		memo = new int[1000];
		Arrays.fill(memo, -1);
		memo[0] = 0;
		memo[1] = 1; 
		
		sc.close();
	}
	
	// 단점: 무수히 많은 중복 호출 > 이미 계산된 값은 저장하기로 하자  
	static int fibo1(int n) {
		if (n <= 1) return n;
		return fibo1(n-1) + fibo1(n-2);
	}
	
	// 2 memoization 활용 > 새 메모리 공간 필요
	
	static int[] memo; 
	
	static int fibo2(int n) {
		// 0, 1 초기화한 배열 아니면 값 계산해서 저장하기
		if (memo[n] == -1) { 
			memo[n] = fibo2(n-1) + fibo2(n-2);
		}
		return memo[n];
	}
	
	static int fibo3(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i-1] + dp[i-2]; 
		}
		return dp[n];
	}
}
