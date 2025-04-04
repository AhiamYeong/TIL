/* N번 쐈을 때 최대한 많은 벽돌 부수기, 명중 시 N*N만큼 제거
 * "영향 받으면 한 번에 제거됨" 1이면 자기자신만 
 * 남은 벽돌 개수 구하기, 항상 맨 위만 깰 수 있음 & 상하좌우 k만큼 제거
 * 밑으로 떨어져야 함: 바로 아래 좌표가 0이면 내리기
 * 삽입 삭제가 빈번할 것 같으니 arraylist 사용 
 * 시뮬레이션: 계속 복사 수행해야 함*/
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class SWEA5656 {
	
	static String input = "1\r\n"
			+ "3 10 10\r\n"
			+ "0 0 0 0 0 0 0 0 0 0\r\n"
			+ "1 0 1 0 1 0 0 0 0 0\r\n"
			+ "1 0 3 0 1 1 0 0 0 1\r\n"
			+ "1 1 1 0 1 2 0 0 0 9\r\n"
			+ "1 1 4 0 1 1 0 0 1 1\r\n"
			+ "1 1 4 1 1 1 2 1 1 1\r\n"
			+ "1 1 5 1 1 1 1 2 1 1\r\n"
			+ "1 1 6 1 1 1 1 1 2 1\r\n"
			+ "1 1 1 1 1 1 1 1 1 5\r\n"
			+ "1 1 7 1 1 1 1 1 1 1";
	
	static int[][] board;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int H;
	static int W;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 구슬 N번 쏘기
			W = sc.nextInt(); // 너비 
			H = sc.nextInt(); // 높이
			
			board = new int[H][W];
			// N번만큼 구슬 부수기 - 가장 위만 부술 수 있으므로, 후보는 0이 아닌 행의 가장 위 값
			// 제거: 어디가 제일 효율적인지 모름-완탐 base, 모든 경우 확인하기 
			
			// 경우 1개마다 제거 & 이동의 작업 모두 이뤄져야 함
			// tops도 계속 갱신돼야 해 
			
			// '반응한다': 연쇄적으로 제거 한 번에 이루어짐 > BFS로 퍼뜨리기
			
			// 덱의 first에서 넣고 빼는 연산해서 스택처럼 사용하기 
			
			// 어떤 걸 제거할지 선택하는건 완전탐색으로 모든 경우 다 찾아보기 (뭘 어케 제거해야되는지 멀라)
			// 이거바께 모르겠다
			// 제거할 순서: 중복순열로 원소 N개인 모든 경우 찾고 제거 로직 돌리기
			// 중간에 break 거는 지점은 값을 검사했는데 0일 때 
			
			
			// 없앨 수 있는 범위? 
			int[] tops = new int[W];

			
			// tops 내에서 제거할 것 하나 선택 -> 제거 -> 없앨 수 있는 값 갱신 (N번 반복)
			for (int count = 0; count < N; count++) {
				// 제거할 게 없으면 N번 다 안 채워도 루프 끝 
				
				// 중복순열 
				for (int x = 0; x < H; x++	) {
					for (int y = 0; y < W; y++) {
						
						// remove는 꼭 '가장 위 값'만 사용 가능 
						
						remove(x, y);
						// 값 아래로 밀기
						move();
					}
				} // 보드 내에서 지울 좌표 선택 
				// 선택했으면 제거
				
			} // N번 반복 
			
			
			// 계산 
			int cnt = 0;
			for (int x = 0; x < H; x++	) {
				for (int y = 0; y < W; y++) {
					if (board[x][y] != 0) cnt++;
				}
			} 
			
			System.out.println("#" + tc + " " + cnt);
		} // tc
		sc.close();
	} // main 

	// 값 지웠으면 보드 돌면서 아래로 쭉 밀기 
	private static void move() {
		
		// 세로로 계산: 매번 dq 이용하고 새로 만들기 
		for (int y = 0; y < W; y++) {
			Deque<Integer> dq = new ArrayDeque<>();
			
			// 0이 아닌 값 큐에 넣고 
			for (int x = 0; x < H; x++) {
				if (board[x][y] != 0) dq.offerLast(board[x][y]);
			}
			
			// 아래부터 채우기 (큐에서 뺀담에 아래부터 넣기)
			for (int x = H - 1; x <= 0; x--	) {
				// 가로에 있는 값들은 아래부터 쭉 채우기 
				if (!dq.isEmpty()) board[x][y] = dq.getLast();
				// 큐 끝났으면 전부 0으로 채우기
				else board[x][y] = 0;
			}
		}
		
		
	}

	// 1회차 : 하나 선택해서 지우기 - 하나는 선택됨  
	private static void remove(int x, int y) {
		// 1. 선택한 블록의 범위 확인
		int val = board[x][y];
		// 본인 제거 
		board[x][y] = 0; 
		
		for (int range = 1; range < val; range++) {
			for (int dir = 0; dir < 4; dir++) {
				int nextX = x + dx[dir] * range;
				int nextY = y + dy[dir] * range;
			
				if (isValid(nextX, nextY)) {
					// 범위 내 1보다 큰 값 있으면 다시 제거 (dfs?)
					if (board[nextX][nextY] > 1) remove(nextX, nextY);
					board[nextX][nextY] = 0; // 제거
				}
			}
		} // 범위만큼 블록 제거 
	}
	
	static boolean isValid(int x, int y) {
		return (x >= 0 && x < H && y >= 0 && y < W);
	}
}
