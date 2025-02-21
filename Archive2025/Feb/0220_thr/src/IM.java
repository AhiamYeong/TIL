import java.util.Scanner;

public class IM {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int T = sc.nextInt(); // tc
		// 4방탐색용
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, 1, -1};
		
		for(int tc = 1; tc <= T; tc++) {
			int maxCnt = 0;
			int N = sc.nextInt();
			int[][] board = new int[N][N];
			
			// input
			for (int i =0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
			
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					// x, y 꼭짓점 이동은 별개로 두고
					// 현재 좌표를 굴려야 하므로 curX, curY에 저장
					int curX = x;
					int curY = y;
					int count = 1; // 본인은 이동 횟수에 포함
					// 더 이동 못 할때까지 반복ㄱ
					while(true) {
						int min = Integer.MAX_VALUE; // 이동할 가장 낮은 높이 저장
						// 이동할 가장 낮은 좌표 
						int minX = -1, minY = -1;
						// 4방향을 탐색했는데 모든 위치가 현재 높이보다 크거나 같은 경우 잘못된 좌표(0,0)으로 이동할 위험 방지
						
						
						for (int d = 0; d < 4; d++) {
							int nx = curX + dx[d];
							int ny = curY + dy[d];
							
							if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
								continue; 
							} // 범위 벗어나면 이 쪽으론 못감
							
							// 4방탐색 중 가장 작은 기둥 좌표 찾기
							// 현재 높이보다 낮은 곳으로만 이동 가능하게 
							if (board[nx][ny] < board[curX][curY] && board[nx][ny] < min) {
								min = board[nx][ny];
								minX = nx;
								minY = ny;
							}
						} // 4방탐색
						// 종료 조건 -> 나보다 더 작은 좌표가 4방 내에 없을 떄
						if (minX == -1 && minY == -1) break;
						
						// 가장 작은 좌표값을 저장
						curX = minX;
						curY = minY;
						count++;
						
					} // while 
					maxCnt = Math.max(maxCnt, count);
				} // 꼭짓점 Y좌표 이동
			} // 꼭짓점 x좌표 이동
			System.out.println("#" + tc + " " + maxCnt);
			
		} // tc
		sc.close();
	} // main
}
