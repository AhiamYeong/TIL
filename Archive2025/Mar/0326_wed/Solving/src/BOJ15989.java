
import java.util.Arrays;
import java.util.Scanner;

/* 이번에는 순서가 아니라 조합으로 확인하기
 * dp[i]는 i번째까지 만들 수 있는 경우의 수로 정의 (각 독립사건 모두 고려하여 '합'으로 표현 )
 * 1,1,2 == 1,2,1 같은 걸로 취급하기 > 
 * 가장 마지막에 더하는 값을 1, 2, 3으로 구분하면?? 
 */

public class BOJ15989 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // TC 
    int T = sc.nextInt();
    for (int tc = 1; tc <= T; tc++){
      // N은 10000 미만 양수 
      int N = sc.nextInt();
      int[] dp = new int[N+1]; // 1-based idx dp table

      // 일반항 채우기: 0 - 3 만드는 경우의 수까지는 정의 가능 
      dp[1] = 1; // 1: 1
      if (N >= 2) {
        dp[2] = 2; // 2: 1+1, 2
        if (N >= 3) dp[3] = 3; // 3: 1+1+1, 1+2, 3
      }

      if (N >= 4){
        // 분해분해해서 3 -> 2 -> 1 순으로 계속 분해해서 저장하기 
        for (int i = 4; i <= N; i++){
          // 1은 항상 1개네?
          
        }
      }

      System.out.println(Arrays.toString(dp));
      System.out.println(dp[N]);
    } // tc
    sc.close();
  }
}