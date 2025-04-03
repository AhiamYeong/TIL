package day12_DP;

import java.util.Scanner;

public class dp2_동전거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 사용할 수 있는 동전이 1, 4, 6일 때 
		int money = sc.nextInt(); // 거스름돈 
		int[] dp = new int[money + 1]; // 거스름돈 몇 개?
		
		for (int i = 1; i <= money; i++) {
			int minCnt = 987654321; // 아주 큰 수 하나 넣고
			
			// 1원을 고려했을 때 
			minCnt = Math.min(minCnt, dp[i-1] + 1);
			// 4원을 고려했을 때 - 적어도 4원보다는 커야댐
			// minCnt에 이미 1원 고민했을 때 결과 들어와있음 
			if(i >= 4) minCnt = Math.min(minCnt, dp[i-4] + 1);
			// minCnt에 1, 4원 고민했을 때 결과 들어와있음 
			if (i >= 6) minCnt = Math.min(minCnt, dp[i-6] + 1);
			dp[i] = minCnt;
		}
		System.out.println(dp[money]);
		
		sc.close();
	}
}
