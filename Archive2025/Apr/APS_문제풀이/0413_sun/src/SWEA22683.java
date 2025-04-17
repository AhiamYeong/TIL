/* rc카의 '상태 정의'하기
 * 조작 (전진/좌회전/우회전) 3개를 모두 비용 1인 간선으로 보고 bfs 
 * 처음 도착한 r, c가 목표 y인 순간의 '거리'가 최소 조작 횟수 
 * */

import java.util.Scanner;

public class SWEA22683 {
	
	static char[][] field;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	
	// BFS에서 한 번 처리한 '상태'는 재방문X: 상태에 node 4가지 들어가므로
	// 4가지 축 모두 같아야 '같은 상태' 
	static boolean[][][][] visited;
	
	// rc카 현재 상태 정의하기 
	static class Node {
		int r, c; // 위치 (r, c)
		int dir; // 바라보는 방향 {0 위 1 오른쪽 2 아래 3 왼쪽}
		int leftCut; // 남은 벌목 횟수
		int dist; // 지금까지 명령 횟수
		
		public Node(int r, int c, int dir, int leftCut, int dist) {
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.leftCut = leftCut;
			this.dist = dist;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // tc 
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 필드 크기
			int K = sc.nextInt(); // 나무 벨 수 있는 횟수
			
			sc.nextLine(); // butter flush
			
			field = new char[N][N];
			visited = new boolean[N][N][4][K+1];
			
			for (int i = 0; i < N; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < N; j++) {
					field[i][j] = line.charAt(j);
				}
			}
			
			// 이동 위한 최소 조작 횟수
			// g 이동 가능, t 나무, x 현위치, y목적지
			
		} // tc
		sc.close();
	} // main
	
	static boolean inRange(int r, int c, int N) {
		return (r >= 0 && r < N && c >= 0 && c < N);
	}
	
}
