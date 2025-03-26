import java.util.Scanner;

public class BOJ9657 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();

    // 1, 3, 4개 > 마지막 돌 가져가면 이김 
    // sk 먼저 가져감 / 

    // 남은 돌 개수를 dp에 저장하기?
    int[] dp = new int[N+1];
    String res = "";

    // 누가 돌 가져감 > 계속 reverse 하기 좋게 
    boolean SK = true;
    
    // 초기값
    dp[1] = 1;

    for (int i = 2; i <= N; i++){
      // 항상 가능한 연산 
      dp[i] = dp[i-1] + 1;

      // 가능하다면?
      if (N % 3 == 0) {
        dp[i] = Math.min(dp[i], dp[i/3]+1);
        // 위에서 한 번 뒤집었으니까 
      }
      if (N % 4 == 0) {
        dp[i] = Math.min(dp[i], dp[i/4]+1);
      }

    }
    
    // 최솟값 게임: 몇 번 가져갔느냐에 따라 결과 바뀜
    res = dp[N] / 2 == 0 ? "SK" : "CY";

    System.out.println(res);
    sc.close();
  }
  
}