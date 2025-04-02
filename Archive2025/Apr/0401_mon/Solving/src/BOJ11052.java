import java.util.Scanner;

public class BOJ11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 1개, 2개, ..., N개 
		int N = sc.nextInt(); // 카드 N개
		int[] cards = new int[N+1]; 
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) cards[i] = sc.nextInt();
		
		// 카드 1개 - N개까지 들어있음
		// i개 조합해서 N개 만들기 > i개 숫자까지 고려했을 때 금액의 최댓값  
		// i=4일 때 -> 4 OR 1+3 OR 2+2
		dp[1] = 
	}
}
