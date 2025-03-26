import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 그래프탐색06_BFS_배열_같은레벨처리 {
	static int N; // N x N , N x M
	static int[][] map; // 2차원 배열
	static boolean[][] visited; // 방문쳌

	// 4방향
	static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dc = { 0, 0, -1, 1 };

	// 좌표를 담기 위한 클래스
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		// 현재는 (0,0) -> (N-1, N-1) 갈 수 있는지...
		// 입력을 시작정점과 도착정점을 주기도 함
		// map에 값을 이용하여 표현을 해주기도 함
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		} // 미로 입력

		int ans = bfs(0, 0);

		System.out.println(ans);

	}

	static int bfs(int r, int c) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c)); // 시작정점을 넣었다!

		visited[r][c] = true;

		int dist = 1; // 시작점의 레벨 혹인 깊이 혹은 길이

		while (!q.isEmpty()) {
			int size = q.size(); // 같은 레벨(인접한)만 처리하기위해서..

			for (int i = 0; i < size; i++) {
				Pos curr = q.poll(); // 값을 하나 꺼내
				// 도착 지점에 도달했다!
				if (curr.r == N - 1 && curr.c == N - 1) {
					return dist;
				}

				// 4방향 탐색
				for (int d = 0; d < 4; d++) {
					int nr = curr.r + dr[d];
					int nc = curr.c + dc[d]; // 다음좌표

					// 3개의 쳐내 관문
					// 1. 범위 쳐내
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					// 2. 벽이면 쳐내 / 이미 거리가 결정되어 있으면 쳐내
					if (map[nr][nc] == 1 || visited[nr][nc])
						continue;

					visited[nr][nc] = true;
					q.add(new Pos(nr, nc));
				}
			} // size별로 묶은 for문
			dist++;
		}

		return -1; // 탈출 못해~
	}

	static String input = "8\r\n" + "0 0 1 1 1 1 1 1\r\n" + "1 0 0 0 0 0 0 1\r\n" + "1 1 1 0 1 1 1 1\r\n"
			+ "1 1 1 0 1 1 1 1\r\n" + "1 0 0 0 0 0 0 1\r\n" + "1 0 1 1 1 1 1 1\r\n" + "1 0 0 0 0 0 0 0\r\n"
			+ "1 1 1 1 1 1 1 0\r\n" + "";

}
