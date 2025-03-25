/* 포도주 N개 & 선택 개수 상관X but 연속 3잔까지는 불가능 & 최대로 많이 마시기
 * DP테이블 설정: 이전까지 가장 많이 마신 포도주 양
 */

import java.util.Scanner;

public class BOJ2156 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(); // 포도주 개수 
    int[] wines = new int[N+1];
    for (int i = 1 ; i <= N; i++){
      wines[i] = sc.nextInt();
    }
    int[][] dp = new int[N+1][1]; // dp 테이블 

    // 포도주 제일 많이 마실 수 있는 결과 
    int alcohol = 0;
  
    // 가장 기본, 항상 만족하는 초기 조건은 뭘까?
    // 1개만 마셨을 때 ? 

    // dp table에 저장할 값은 '가장 많이 마신 양' > 어쩄든 wine 안에서 경우 돌아야 하자나 

    // 일단 일반항은 이거?
    for (int i = 1; i <= N; i++){
      int cnt = 0; // depth처럼 마실 때 순서 함께 저장
      for (int wine : wines){
        
        dp[i][cnt] = Math.max(dp[i][cnt], dp[i-1][cnt + 1] + wine);
        if (cnt >= 3) continue;
      }
    }
    sc.close();
  }
}
