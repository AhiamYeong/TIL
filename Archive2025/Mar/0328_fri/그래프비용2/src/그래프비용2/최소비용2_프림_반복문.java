package 그래프비용2;

import java.util.Arrays;
import java.util.Scanner;

public class 최소비용2_프림_반복문 {
	
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(input);
		
		// 정점, 간선의 개수 
		int V = sc.nextInt(); // 0번부터 시작
		int E = sc.nextInt();
		
		// 정점 위주로 생각 > 인접리스트 / 인접행렬로 받기
		int[][] adj = new int[V][V];
		
		// 간선만큼 
		for (int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int cost = sc.nextInt(); 
			
			// 무향 그래프: 인접 행렬에 양방향 저장
			adj[s][e] = adj[e][s] = cost; 
		} // 간선 입력 끝
		
		int[] p = new int[V]; // 부모 정보 저장할 배열 
		int[] dist = new int[V]; // key값 (가장 작은 값) 저장 
		// 트리 정점인지, 비트리 정점인지 확인할 배열
		boolean[] visited = new boolean[V]; // 트리 소속인지 아닌지 기록 위함
		
		
		// 1. 가장 큰 값으로 dist 배열 초기화
		for (int i = 0; i < V; i++) {
			dist[i] = INF;
			p[i] = -1; // 0번 정점도 있으니까 -1로 초기화해줌
		}
		
		// 2. 시작할 정점 고르기
		dist[0] = 0; 
		int ans = 0; // 최소비용 (정답)
		
		// 3. 전체 반복하며 정점 뽑기
		for (int i = 0; i < V; i++) {
			// 3.1. 가장 작은 값 고르기
			int min = INF;
			int idx = -1; // 비어있으니까 
			
			// 정점들 중 최솟값 고르기
			for (int j = 0; j < V; j++) {
				// 방문하지 않은 정점들 중 최솟값 고르고 갱신
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					idx = j;
				} 
			} // idx는 가장 작은 정점으로 갱신됨 
			
			// 뽑은 값 처리 & 누적처리 
			visited[idx] = true;
			ans += dist[idx]; 
		
			// 3.2. 가장 작은 정점 뽑았으니, 연결된 간선으로 갱신
			// 인접리스트 & 인접행렬 방식이 좀 달라짐 
			for (int j = 0; j < V; j++) {
				// 방문하지 않았고 & idx와 연결된 & 갱신 여지 있으면
				// 내가 가진 간선이 더 작다면
				if (!visited[j] && adj[idx][j] != 0 && dist[j] > adj[idx][j]) {
					dist[j] = adj[idx][j];
					p[j] = idx; 
				}
			}
		} // 끝
		System.out.println(Arrays.toString(dist));
		System.out.println(Arrays.toString(p));
		System.out.println(ans);
		
		
		
	} // main
	
	
	static String input = "7 11\r\n" + //
	        "0 1 32\r\n" + //
	        "0 2 31\r\n" + //
	        "0 5 60\r\n" + //
	        "0 6 51\r\n" + //
	        "1 2 21\r\n" + //
	        "2 4 46\r\n" + //
	        "2 6 25\r\n" + //
	        "3 4 34\r\n" + //
	        "3 5 18\r\n" + //
	        "4 5 40\r\n" + //
	        "4 6 51\r\n" + //
	        "";
	
	
}
