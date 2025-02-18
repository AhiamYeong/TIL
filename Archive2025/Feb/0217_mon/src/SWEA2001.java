import java.util.Scanner;

public class SWEA2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		//  M*M 박스 만들기 위한 dx, dy
		// 나, 오른쪽, 아래, 오른쪽 아래
		int[] dx = {0, 1, 0, 1};
		int[] dy = {0, 0, 1, 1};
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); 
			int M = sc.nextInt();
			int[][] board = new int[N][N]; // 파리
			int[][] box = new int[M][M]; // 파리채
			
			int max = 0;
			// 보드 돌며 찾기
			int direction = 0;
			// 탐색 시작값
			int x = 0, y = 0;
			for (int i = 1; i <= M; i++) {
				int sum = 0; //매번 갱신
				int nextX = x + dx[direction] * i;
				int nextY = y + dy[direction] * i;
				// 유효범위 내에서
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					sum += board[nextX][nextY];
					direction++;
				}
				// 다 돌았다면 최대값 비교
				if (max < sum) max = sum;
			} // M*M 배열 
			System.out.println("#" + tc + " " + max);
			
		} // tc
		sc.close();
	}
}
