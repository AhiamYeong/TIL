/* 수열이 순증가 + 원소 제일 많아야 함: LIS
 * 입력이 1억개까지 가능하니까 뭔가 좀 잘라야 할 것 같지 
 * 가장 긴 수열의 개수 출력
 * dp 테이블에 i번째까지 봤을 때 LIS에서 가장 큰 수 저장
 * 나한테 오는 최장 경로는 과연 어디서 오는가 ......???  
 * */

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11568 {
	static String input = "5\r\n"
			+ "8 9 1 2 10";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 카드 N장
		int[] cards = new int[N];
		
		for (int i = 0; i < N; i++) {
			cards[i] = sc.nextInt(); 
		}
		
		// [0] i번째까지 봤을 때 가장 마지막 수열 
		// [1] i번째까지 봤을 때 가장 긴 개수 
		int[][] dp = new int[N][2]; 
		// 단순하게 가장 작은 수 저장해놓고 카운트 세면 안됨? 
		dp[0][0] = cards[0];
		dp[0][1] = 1; // cnt 대체  
		
		for (int i = 1; i < N; i++) {
			// 현재 값 > LIS의 마지막 값이라면
			if (cards[i] > dp[i-1][0]) {
				dp[i][0] = cards[i]; // 더 큰 값 저장 
				dp[i][1] = dp[i-1][1] + 1; // 수++ 
			}
			// 이전값이 더 크면 전 값 유지  
			
			if (cards[i] <= dp[i-1][0]) {
				dp[i][0] = dp[i-1][0];
				dp[i][1] = dp[i-1][1];
			}
		}
//		 
//		for (int[] i : dp) {
//			for (int j : i) {
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
		// 바로 다음 원소가 작다면, 덮어쓰고 다시 작성
		// dp에 담을 값은, i번째까지 확인했을 때 연속된 수열의 개수
		
		System.out.println(dp[N-1][1]);
		
		sc.close();
	}
}
