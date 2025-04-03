/* dp테이블 - 1~i번까지 고려했을 때, 배낭 무게 w일 때 넣을 수 있는 최고 가치.
 * w - weigth[i] 물건 넣고 남는 무게 + cost[i] 지금 물건 가치 
 * w - weigth[i]로 '돌아가서' 무게 저 때 최적의 참조 확인하기. 
 * */
package day12_DP;

import java.util.Scanner;

public class dp3_배낭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 물건의 개수
		int W = sc.nextInt(); // 배낭의 무게
		
		// 가치, 무게 입력받기 > 2차원 배열 OR 1차원 2개
		int[] weigths = new int[N+1];
		int[] cost = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			weigths[i] = sc.nextInt();
			cost[i] = sc.nextInt(); 
		} // 입력받기
		
		int[][] dp = new int[N+1][W+1]; // i번째 물건, W만큼 고려
		// 무게의 최댓값, 물건은 1개씩만 존재
		for (int i = 1; i <= N; i++) {
			// 임시 무게 
			for (int w = 0; w <= W; w++) {
				// 1. 내가 고려할 물건 무게 <= 임시 무게
				if (weigths[i] <= w) {
					// 전자는 '이번 것 패스' 
					// 후자는 '물건 넣고 공간 잃기'
					dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w - weigths[i]] + cost[i]);
				}
				// 2. 내가 고려할 물건 무게 > 임시 무게 (배낭에 안 들어갈정도로 크면) 
				else {
					// 바로 직전 행열 값 그대로 가져오기 (이번 거 pass)
					dp[i][w] = dp[i-1][w];
				}
			} 
		} // 물건 for문
		
		System.out.println(dp[N][W] );
	}
}
