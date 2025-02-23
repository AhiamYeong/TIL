import java.util.Scanner;

public class SWEA2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
//		//  M*M 박스 만들기 위한 dx, dy
//		// 나, 오른쪽, 아래, 오른쪽 아래
//		int[] dx = {0, 1, 0, 1};
//		int[] dy = {0, 0, 1, 1};
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); 
			int M = sc.nextInt();
			int[][] board = new int[N][N]; // 파리
			
			// board 채우기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			int max = 0; // 최대값 (결과)
			
			// 보드 돌며 확인 - 초기값 이동
			for (int x = 0; x < N - M + 1; x++) {
				for (int y = 0; y < N - M + 1; y++) {
					// M*M 크기만큼 순회해야 함 
					// x, y를 이동해가며 확인 
					int sum = 0;
					// x, y는 꼭짓점 모서리 (왼쪽 위) 기준
					// i, j는 우측/하단으로 영역 확장하며 탐
					for (int i = 0; i < M; i++) {
						for (int j = 0; j < M; j++) {
							sum += board[i+x][j+y];
						}
					}
					if (sum > max) max = sum;
				}
			}
			
			System.out.println("#" + tc + " " + max);
			
		} // tc
		sc.close();
	}
}
