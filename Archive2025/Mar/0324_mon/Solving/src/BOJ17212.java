/* 동전 개수 최소되도록 지불하기...
 * 최소 개수 출력하는 프로그램 
 * 1 2 5 7만 선택 가능 
 * eg 12 > 5 + 7 ... 마지막에 하나씩 남겨보기 (바킹독 문풀이랑 비슷하게 고고)
 * 12-1. 12-2. 12-5. 12-7까지 경우의 수 + 1 하게 될 테니까 
 */

import java.util.Scanner;

public class BOJ17212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 지불해야 하는 금액 
        int[] dp = new int[N+2]; // 1 based idx 이용 위해 

        // 단 하나 최소인 경우의 수
        dp[1] = 1; 
        dp[2] = 1;
        dp[5] = 1;
        dp[7] = 1;
        
        // dp[N]: N이라는 수를 만드는 조합의 수 중 최솟값

        // dp 배열 채우기
        for (int i = 3; i <= N; i++){
            // 이미 초기값으로 있으면 pass
            if (dp[i] != 0) continue;
            // 점화식 ///////// 부터 다시 보기 /////////////////
            dp[i] = Math.min(dp[i], dp[i-1], dp[i-2], dp[i-5], dp[i-7]);


            System.out.print(dp[i] + " ");
        }
        System.out.println("val: " + dp[N]);

        sc.close();
    }
}