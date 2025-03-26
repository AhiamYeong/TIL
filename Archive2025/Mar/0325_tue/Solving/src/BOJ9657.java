/* 돌 1개 or 3개 or 4개 가져갈 수 있음. 항상 SK 먼저 게임 시작 
 * 필승전략이 있나?? >> '완벽하게', '게임 이론': 항상 이기는 수만 생각해서 플레이
 * 돌 1개가 남으면 반드시 SK 승리 
 */

import java.util.Scanner;

public class BOJ9657 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 6개 -> 4 1 1, 3 3, 1 1 1 1 1 1: 
    // 초기 상태의 돌이 이긴자리/진자리에 따라 유불리 결정됨? 

    int N = sc.nextInt();

    // 1이 남는 순간 승자/패자 결정됨
    // 4, 3, 1로만 결정할 수 있음 
    int[] dp = new int[N+1];

    // dp[i]: i번째 턴에서 돌 가져가고 남은 수. 
    dp[1] = N;
    for (int i = N; i > 0; i--){
      // 돌 남는 경우의 수는 4, 3, 1개 중 선택 가능
      // 가장 기본 케이스: 1 가져가기 
      dp[i-1] = dp[i] - 1;

      // 3을 가져갈 수도, 4를 가져갈 수도 있음
      
    }

    
    sc.close();
  }
}
