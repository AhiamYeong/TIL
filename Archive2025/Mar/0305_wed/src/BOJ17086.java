import java.util.*;
public class BOJ17086 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 공간 크기 N*M
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = sc.nextInt();
			}
		} // input
		
		// 이제 여기 dfs를 어떻게 적용할 것인가
		 
		sc.close();
		
	}
}
