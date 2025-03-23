import java.util.Scanner;

public class BOJ1463 {

  // DP table: 문제 조건 보고 썼음 
  static int[] dp = new int[1000001];
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // dp 적용
        dp[1] = 0; 
        // 초기값 

        // dp 배열 채우기: 1 제외 2-n까지 
        for (int i = 2; i <= N; i++){
          // 항상 가능한 연산: 바로 전 연산에서 온 수 정의 
          dp[i] = dp[i-1] + 1;
          
          // 조건 맞으면 더 쉬운 연산들 정의
          // 해당 조건에 들어올 경우, 기본 연산(+1 연산)에서 온 경로의 최솟값과  i/2에서 오는 경로의 최솟값과 비교해서 더 작은 값을 i번째 배열에 저장하기 
          // 기본 연산 (+1)을 이미 하기 때문에 dp[i]는 굳이 +1 할 필요 업슴 
          if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i/2]+1);
          if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i/3]+1);
        }

        System.out.println(dp[N]);
        sc.close();
    }
}
