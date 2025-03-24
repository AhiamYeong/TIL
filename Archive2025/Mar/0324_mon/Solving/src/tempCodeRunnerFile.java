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
        int[] coins = {1, 2, 5, 7};

        // 지피티 조언: 처음에 dp[i] = Integer.MAX_VALUE로 전부 초기화해 판단하기 
        for (int i = 0; i <= dp.length; i++) dp[i] = Integer.MAX_VALUE;
        
        // 단 하나 최소인 경우의 수
        dp[1] = 1; 
        dp[2] = 1;
        dp[5] = 1;
        dp[7] = 1;
        
        // dp[N]: N이라는 수를 만드는 조합의 수 중 최솟값


        // dp 배열 채우기
        for (int i = 3; i <= N; i++){
            // 이미 초기값으로 있으면 pass
            // if (dp[i] != 0) continue;
            // 점화식 ///////// 부터 다시 보기 ////////////////
            dp[i] = dp[i-1]+1; // 언제나 가능 
            
            // 채점 93에서 자꾸 에러... 본인 원래 코드에서는 i=6일 때 line1에서 dp[-1] 접근될 수도 있음. 그래서 인덱스 터지는거 
            // // 1보다 큰 수로도 나눠지면?? 당빠 대체하기
            // if (i >= 7) dp[i] = Math.min(dp[i], dp[i-7]+1);
            // if (i >= 5) dp[i] = Math.min(dp[i], dp[i-5]+1);
            // if (i >= 2) dp[i] = Math.min(dp[i], dp[i-2]+1);

            // 지피티 추천 코드 > 모든 coin에 대해 '이미 접근한 값' 맞는지 확인 & 가장 작은 값 확인 
            for (int c : coins){
              if (i >= c && dp[i - c] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
              }
            }

            // System.out.print(dp[i] + " ");
        }
        System.out.println(dp[N]);

        sc.close();
    }
}