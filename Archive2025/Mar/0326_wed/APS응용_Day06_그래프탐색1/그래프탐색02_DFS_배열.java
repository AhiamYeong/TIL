import java.util.Scanner;

public class 그래프탐색02_DFS_배열 {
	static int N; //N x N , N x M 
	static int[][] map; //2차원 배열
	static boolean[][] visited; //방문쳌
	static boolean ans = false; //탈출할 수 있는지....
	
	//4방향
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		
		//현재는 (0,0) -> (N-1, N-1) 갈 수 있는지...
		//입력을 시작정점과 도착정점을 주기도 함
		//map에 값을 이용하여 표현을 해주기도 함
		for(int i = 0 ; i<N; i++) {
			for(int j = 0 ; j<N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					//출발지/도착지를 저장할 수 도 있음
				}
			}
		}//미로 입력
		
		
		dfs(0, 0);
		
		System.out.println(ans);
		
	}
	
	//r : 행, c : 열
	private static void dfs(int r, int c) {
		//탈출조건
		if(r == N-1 && c == N-1) {
			ans = true; //꿈꿨더니 탈출할 수 있더라...
			return;
		}
		
		visited[r][c] = true;
		
		//재귀부분
		for(int d = 0 ; d<4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d]; //다음좌표
			
			//1. 쳐내 (범위를 벗어나면)
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
			//2. 쳐내 (벽이면)
			if(map[nr][nc] == 1) continue;
			//3. 쳐내 (방문했으면)
			if(visited[nr][nc]) continue;
			
			//3개의 관문을 뚫어낸 당신 내려갈 자격이 있다.
			dfs(nr,nc);
		}//4방향 탐색
		
		
		
		
		
		
	}


	static String input = "8\r\n"
			+ "0 0 1 1 1 1 1 1\r\n"
			+ "1 0 0 0 0 0 0 1\r\n"
			+ "1 1 1 0 1 1 1 1\r\n"
			+ "1 1 1 0 1 1 1 1\r\n"
			+ "1 0 0 0 0 0 0 1\r\n"
			+ "1 0 1 1 1 1 1 1\r\n"
			+ "1 0 0 0 0 0 0 0\r\n"
			+ "1 1 1 1 1 1 1 0\r\n"
			+ "";
	
}
