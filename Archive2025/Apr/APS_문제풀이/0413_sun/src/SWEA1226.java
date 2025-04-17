/* 출발지 ~ 도착지 갈 수 있는 길이 있나? 판단  */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA1226 {
	
	static int[][] board = new int[16][16];
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static boolean[][] visited;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		for (int tc = 1; tc <= 10; tc++) {
			
			int t = sc.nextInt();
			// buffer flush
			sc.nextLine();
			visited = new boolean[16][16];
			
			for (int i = 0; i < 16; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < 16; j++) {
					board[i][j] = line.charAt(j) - '0';
				}
			} // 채우기
			
			int res = 0; 
			for (int x = 0; x < 16; x++) {
				for (int y = 0; y < 16; y++) {
					if (board[x][y] == 2) {
						res = bfs(new int[] {x, y});
					}
				}
			}
			
			System.out.println("#" + t + " " + res);
			// 1 벽 0 길 2 출발지 3 도착지
			// 벽 통과 없으면서 2출발지 ~ 3도착지 가능한지 확인 
			// bfs로 돌려보기
		}
		sc.close();
	}
	
	static int bfs(int[] pair) {
		Queue<int[]> q = new LinkedList<>();
		int x = pair[0];
		int y = pair[1];
		
		// 시작점부터 고고 
		q.offer(pair);
		visited[x][y] = true; 
		
		// 그 다음이 벽이면 갈 수 있고, 벽이 아니면 갈 수 없고
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int curX = curr[0];
			int curY = curr[1];
			
			// 현재 위치에서 4방탐색 (1 아닐때만 ㄱㄴ)
			for (int dir = 0; dir < 4; dir++) {
				int nextX = curX + dx[dir];
				int nextY = curY + dy[dir]; 
				
				// 위치 이동할 수 있다면 고고
				if (isValid(nextX, nextY) && !visited[nextX][nextY] && board[nextX][nextY] != 1) {
					visited[nextX][nextY] = true;
					q.offer(new int[] {nextX, nextY});
					
					// 언젠가 3 마주치면 끝나는데... 끝까지 없으면 0
					if (board[nextX][nextY] == 3) return 1;
				}
			}
		}
		
		// 끝까지 없으면 return 0
		return 0;
	}
	
	static boolean isValid(int x, int y) {
		return (x >= 0 && x < 16 && y >= 0 && y < 16);
	}
}
