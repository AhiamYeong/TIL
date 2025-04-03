/* dp[i]: i개 숫자까지 고려했을 때 금액의 '최댓값'
 * 1 2 3 더하기랑 비슷한거같은디
 * 2: 1+1 / 2 
 * 3: 1+1+1 / 2+1 / 1+2 / 3
 * */ 
import java.util.Arrays;
import java.util.Scanner;

public class BOJ11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1개, 2개, ..., N개 
		int N = sc.nextInt(); // 카드 N개
		int[] cards = new int[N+1]; 
		int[] dp = new int[N+1];

		// 카드 N개
		for (int i = 1; i <= N; i++) cards[i] = sc.nextInt();
		
		dp[0] = 0; 
		dp[1] = cards[1]; // 1 하나
		// 4개일 경우 해보면
		//z dp(3) + card(1) or dp(2) + card(2) or
		// dp(1) + card(3) or card(4)
		
		for (int i = 2; i <= N; i++	) {
			int max = cards[i];
			
			for (int j = 1; j < i; j++) {
				int tmp = dp[i-j] + cards[j];
				if (max < tmp) max = tmp;
			}
			dp[i] = max;
		}
		
		System.out.println(dp[N]);
		sc.close();
	}
}
