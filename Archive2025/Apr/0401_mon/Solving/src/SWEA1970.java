/* 돈 개수 최소한으로 거슬러주기: 가장 큰 수부터 쳐내기 
 * */
import java.util.Scanner;

public class SWEA1970 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); 
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 거스름돈
			
			// 거스름돈의 정확한 갯수 필요하니까
			// 각 5만원 - 10원 
			int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] rest = new int[8]; // 최소 되는 거스름돈 개수?  
			
			// 이번에는 직접적인 갯수 파악 필요 > dp 배열에 최소 되는 수 저장하기?
			for (int i = 0; i < 8; i++) {
				// 가장 큰 수부터 쳐내기 - 계산 가능한지 먼저 확인 
				if (N >= coins[i]) {
					// coin 쳐낼 수 있다면 쳐내고, 값 다시 계산 
					rest[i] = N / coins[i]; 
					N -= rest[i] * coins[i];
				}
			}
			
			
			System.out.println("#" + tc);
			for (int i : rest) {
				System.out.print(i + " ");
			}
			System.out.println();
			
		}
		sc.close();
	}
}
